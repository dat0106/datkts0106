package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class EasyTracker
{
  static final int NUM_MILLISECONDS_TO_WAIT_FOR_OPEN_ACTIVITY = 1000;
  private static EasyTracker sInstance;
  private int mActivitiesActive = 0;
  private final Map<String, String> mActivityNameMap = new HashMap();
  private GoogleAnalytics mAnalyticsInstance;
  private String mAppName;
  private String mAppVersion;
  private Clock mClock = new Clock()
  {
    public long currentTimeMillis()
    {
      return System.currentTimeMillis();
    }
  };
  private Context mContext;
  private boolean mDebug;
  private int mDispatchPeriod = 1800;
  private Thread.UncaughtExceptionHandler mExceptionHandler;
  private boolean mIsAnonymizeIpEnabled;
  private boolean mIsAutoActivityTracking = false;
  private boolean mIsEnabled = false;
  private boolean mIsInForeground = false;
  private boolean mIsReportUncaughtExceptionsEnabled;
  private long mLastOnStopTime;
  private ParameterLoader mParameterFetcher;
  private Double mSampleRate;
  private ServiceManager mServiceManager;
  private long mSessionTimeout;
  private Timer mTimer;
  private TimerTask mTimerTask;
  private Tracker mTracker = null;
  private String mTrackingId;
  
  /**
   * @deprecated
   */
  private void clearExistingTimer()
  {
    try
    {
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @VisibleForTesting
  static void clearTracker()
  {
    sInstance = null;
  }
  
  private String getActivityName(Activity paramActivity)
  {
    Object localObject1 = paramActivity.getClass().getCanonicalName();
    if (!this.mActivityNameMap.containsKey(localObject1))
    {
      Object localObject2 = this.mParameterFetcher.getString((String)localObject1);
      if (localObject2 == null) {
        localObject2 = localObject1;
      }
      this.mActivityNameMap.put(localObject1, localObject2);
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = (String)this.mActivityNameMap.get(localObject1);
    }
    return localObject1;
  }
  
  public static EasyTracker getInstance()
  {
    if (sInstance == null) {
      sInstance = new EasyTracker();
    }
    return sInstance;
  }
  
  public static Tracker getTracker()
  {
    if (getInstance().mContext != null) {
      return getInstance().mTracker;
    }
    throw new IllegalStateException("You must call EasyTracker.getInstance().setContext(context) or startActivity(activity) before calling getTracker()");
  }
  
  private void loadParameters()
  {
    boolean bool = true;
    this.mTrackingId = this.mParameterFetcher.getString("ga_trackingId");
    if (TextUtils.isEmpty(this.mTrackingId))
    {
      this.mTrackingId = this.mParameterFetcher.getString("ga_api_key");
      if (TextUtils.isEmpty(this.mTrackingId)) {}
    }
    else
    {
      this.mIsEnabled = bool;
      this.mAppName = this.mParameterFetcher.getString("ga_appName");
      this.mAppVersion = this.mParameterFetcher.getString("ga_appVersion");
      this.mDebug = this.mParameterFetcher.getBoolean("ga_debug");
      this.mSampleRate = this.mParameterFetcher.getDoubleFromString("ga_sampleFrequency");
      if (this.mSampleRate == null) {
        this.mSampleRate = new Double(this.mParameterFetcher.getInt("ga_sampleRate", 100));
      }
      this.mDispatchPeriod = this.mParameterFetcher.getInt("ga_dispatchPeriod", 1800);
      this.mSessionTimeout = (1000 * this.mParameterFetcher.getInt("ga_sessionTimeout", 30));
      if ((!this.mParameterFetcher.getBoolean("ga_autoActivityTracking")) && (!this.mParameterFetcher.getBoolean("ga_auto_activity_tracking"))) {
        bool = false;
      }
      this.mIsAutoActivityTracking = bool;
      this.mIsAnonymizeIpEnabled = this.mParameterFetcher.getBoolean("ga_anonymizeIp");
      this.mIsReportUncaughtExceptionsEnabled = this.mParameterFetcher.getBoolean("ga_reportUncaughtExceptions");
      this.mTracker = this.mAnalyticsInstance.getTracker(this.mTrackingId);
      if (!TextUtils.isEmpty(this.mAppName))
      {
        Log.i("setting appName to " + this.mAppName);
        this.mTracker.setAppName(this.mAppName);
      }
      if (this.mAppVersion != null) {
        this.mTracker.setAppVersion(this.mAppVersion);
      }
      this.mTracker.setAnonymizeIp(this.mIsAnonymizeIpEnabled);
      this.mTracker.setSampleRate(this.mSampleRate.doubleValue());
      this.mAnalyticsInstance.setDebug(this.mDebug);
      this.mServiceManager.setDispatchPeriod(this.mDispatchPeriod);
      if (!this.mIsReportUncaughtExceptionsEnabled) {
        return;
      }
      Object localObject = this.mExceptionHandler;
      if (localObject == null) {
        localObject = new ExceptionReporter(this.mTracker, this.mServiceManager, Thread.getDefaultUncaughtExceptionHandler());
      }
      Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)localObject);
      return;
    }
    Log.e("EasyTracker requested, but missing required ga_trackingId");
    this.mTracker = new NoopTracker();
  }
  
  public void activityStart(Activity paramActivity)
  {
    setContext(paramActivity);
    if (this.mIsEnabled)
    {
      clearExistingTimer();
      if ((!this.mIsInForeground) && (this.mActivitiesActive == 0) && (checkForNewSession()))
      {
        this.mTracker.setStartSession(true);
        if (this.mIsAutoActivityTracking) {}
      }
      this.mIsInForeground = true;
      this.mActivitiesActive = (1 + this.mActivitiesActive);
      if (this.mIsAutoActivityTracking) {
        this.mTracker.sendView(getActivityName(paramActivity));
      }
    }
  }
  
  public void activityStop(Activity paramActivity)
  {
    setContext(paramActivity);
    if (this.mIsEnabled)
    {
      this.mActivitiesActive = (-1 + this.mActivitiesActive);
      this.mActivitiesActive = Math.max(0, this.mActivitiesActive);
      this.mLastOnStopTime = this.mClock.currentTimeMillis();
      if (this.mActivitiesActive == 0)
      {
        clearExistingTimer();
        this.mTimerTask = new NotInForegroundTimerTask(null);
        this.mTimer = new Timer("waitForActivityStart");
        this.mTimer.schedule(this.mTimerTask, 1000L);
      }
    }
  }
  
  boolean checkForNewSession()
  {
    boolean bool;
    if ((this.mSessionTimeout != 0L) && ((this.mSessionTimeout <= 0L) || (this.mClock.currentTimeMillis() <= this.mLastOnStopTime + this.mSessionTimeout))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void dispatch()
  {
    if (this.mIsEnabled) {
      this.mServiceManager.dispatch();
    }
  }
  
  @VisibleForTesting
  int getActivitiesActive()
  {
    return this.mActivitiesActive;
  }
  
  @VisibleForTesting
  void setClock(Clock paramClock)
  {
    this.mClock = paramClock;
  }
  
  public void setContext(Context paramContext)
  {
    if (paramContext != null)
    {
      GAServiceManager localGAServiceManager = GAServiceManager.getInstance();
      setContext(paramContext, new ParameterLoaderImpl(paramContext.getApplicationContext()), GoogleAnalytics.getInstance(paramContext.getApplicationContext()), localGAServiceManager);
    }
    else
    {
      Log.e("Context cannot be null");
    }
  }
  
  @VisibleForTesting
  void setContext(Context paramContext, ParameterLoader paramParameterLoader, GoogleAnalytics paramGoogleAnalytics, ServiceManager paramServiceManager)
  {
    if (paramContext == null) {
      Log.e("Context cannot be null");
    }
    if (this.mContext == null)
    {
      this.mContext = paramContext.getApplicationContext();
      this.mAnalyticsInstance = paramGoogleAnalytics;
      this.mServiceManager = paramServiceManager;
      this.mParameterFetcher = paramParameterLoader;
      loadParameters();
    }
  }
  
  @VisibleForTesting
  void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.mExceptionHandler = paramUncaughtExceptionHandler;
  }
  
  private class NotInForegroundTimerTask
    extends TimerTask
  {
    private NotInForegroundTimerTask() {}
    
    public void run()
    {
      EasyTracker.access$102(EasyTracker.this, false);
    }
  }
  
  class NoopTracker
    extends Tracker
  {
    private String mAppId;
    private String mAppInstallerId;
    private ExceptionParser mExceptionParser;
    private boolean mIsAnonymizeIp;
    private boolean mIsUseSecure;
    private double mSampleRate = 100.0D;
    
    NoopTracker() {}
    
    public void close() {}
    
    public Map<String, String> constructEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
    {
      return new HashMap();
    }
    
    public Map<String, String> constructException(String paramString, boolean paramBoolean)
    {
      return new HashMap();
    }
    
    public Map<String, String> constructRawException(String paramString, Throwable paramThrowable, boolean paramBoolean)
    {
      return new HashMap();
    }
    
    public Map<String, String> constructSocial(String paramString1, String paramString2, String paramString3)
    {
      return new HashMap();
    }
    
    public Map<String, String> constructTiming(String paramString1, long paramLong, String paramString2, String paramString3)
    {
      return new HashMap();
    }
    
    public Map<String, String> constructTransaction(Transaction paramTransaction)
    {
      return new HashMap();
    }
    
    public String get(String paramString)
    {
      return "";
    }
    
    public String getAppId()
    {
      return this.mAppId;
    }
    
    public String getAppInstallerId()
    {
      return this.mAppInstallerId;
    }
    
    public ExceptionParser getExceptionParser()
    {
      return this.mExceptionParser;
    }
    
    public double getSampleRate()
    {
      return this.mSampleRate;
    }
    
    public String getTrackingId()
    {
      return "";
    }
    
    public boolean isAnonymizeIpEnabled()
    {
      return this.mIsAnonymizeIp;
    }
    
    public boolean isUseSecure()
    {
      return this.mIsUseSecure;
    }
    
    public void send(String paramString, Map<String, String> paramMap) {}
    
    public void sendEvent(String paramString1, String paramString2, String paramString3, Long paramLong) {}
    
    public void sendException(String paramString, Throwable paramThrowable, boolean paramBoolean) {}
    
    public void sendException(String paramString, boolean paramBoolean) {}
    
    public void sendSocial(String paramString1, String paramString2, String paramString3) {}
    
    public void sendTiming(String paramString1, long paramLong, String paramString2, String paramString3) {}
    
    public void sendTransaction(Transaction paramTransaction) {}
    
    public void sendView() {}
    
    public void sendView(String paramString) {}
    
    public void set(String paramString1, String paramString2) {}
    
    public void setAnonymizeIp(boolean paramBoolean)
    {
      this.mIsAnonymizeIp = paramBoolean;
    }
    
    public void setAppId(String paramString)
    {
      this.mAppId = paramString;
    }
    
    public void setAppInstallerId(String paramString)
    {
      this.mAppInstallerId = paramString;
    }
    
    public void setAppName(String paramString) {}
    
    public void setAppScreen(String paramString) {}
    
    public void setAppVersion(String paramString) {}
    
    public void setCampaign(String paramString) {}
    
    public void setCustomDimension(int paramInt, String paramString) {}
    
    public void setCustomDimensionsAndMetrics(Map<Integer, String> paramMap, Map<Integer, Long> paramMap1) {}
    
    public void setCustomMetric(int paramInt, Long paramLong) {}
    
    public void setExceptionParser(ExceptionParser paramExceptionParser)
    {
      this.mExceptionParser = paramExceptionParser;
    }
    
    public void setReferrer(String paramString) {}
    
    public void setSampleRate(double paramDouble)
    {
      this.mSampleRate = paramDouble;
    }
    
    public void setStartSession(boolean paramBoolean) {}
    
    public void setUseSecure(boolean paramBoolean)
    {
      this.mIsUseSecure = paramBoolean;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.EasyTracker
 * JD-Core Version:    0.7.0.1
 */