package com.google.analytics.tracking.android;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GoogleAnalytics
  implements TrackerHandler
{
  private static GoogleAnalytics sInstance;
  private AdHitIdGenerator mAdHitIdGenerator;
  private volatile Boolean mAppOptOut;
  private volatile String mClientId;
  private Context mContext;
  private boolean mDebug;
  private Tracker mDefaultTracker;
  private String mLastTrackingId;
  private AnalyticsThread mThread;
  private final Map<String, Tracker> mTrackers = new HashMap();
  
  @VisibleForTesting
  GoogleAnalytics() {}
  
  private GoogleAnalytics(Context paramContext)
  {
    this(paramContext, GAThread.getInstance(paramContext));
  }
  
  private GoogleAnalytics(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    if (paramContext != null)
    {
      this.mContext = paramContext.getApplicationContext();
      this.mThread = paramAnalyticsThread;
      this.mAdHitIdGenerator = new AdHitIdGenerator();
      this.mThread.requestAppOptOut(new AppOptOutCallback()
      {
        public void reportAppOptOut(boolean paramAnonymousBoolean)
        {
          GoogleAnalytics.access$002(GoogleAnalytics.this, Boolean.valueOf(paramAnonymousBoolean));
        }
      });
      this.mThread.requestClientId(new AnalyticsThread.ClientIdCallback()
      {
        public void reportClientId(String paramAnonymousString)
        {
          GoogleAnalytics.access$102(GoogleAnalytics.this, paramAnonymousString);
        }
      });
      return;
    }
    throw new IllegalArgumentException("context cannot be null");
  }
  
  @VisibleForTesting
  static void clearInstance()
  {
    try
    {
      sInstance = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static GoogleAnalytics getInstance()
  {
    try
    {
      GoogleAnalytics localGoogleAnalytics = sInstance;
      return localGoogleAnalytics;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static GoogleAnalytics getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null) {
        sInstance = new GoogleAnalytics(paramContext);
      }
      GoogleAnalytics localGoogleAnalytics = sInstance;
      return localGoogleAnalytics;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @VisibleForTesting
  static GoogleAnalytics getNewInstance(Context paramContext, AnalyticsThread paramAnalyticsThread)
  {
    try
    {
      if (sInstance != null) {
        sInstance.close();
      }
      sInstance = new GoogleAnalytics(paramContext, paramAnalyticsThread);
      GoogleAnalytics localGoogleAnalytics = sInstance;
      return localGoogleAnalytics;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @VisibleForTesting
  void close() {}
  
  public void closeTracker(Tracker paramTracker)
  {
    try
    {
      this.mTrackers.values().remove(paramTracker);
      if (paramTracker == this.mDefaultTracker) {
        this.mDefaultTracker = null;
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
  Boolean getAppOptOut()
  {
    return this.mAppOptOut;
  }
  
  String getClientIdForAds()
  {
    String str;
    if (this.mClientId != null) {
      str = this.mClientId.toString();
    } else {
      str = null;
    }
    return str;
  }
  
  public Tracker getDefaultTracker()
  {
    try
    {
      GAUsage.getInstance().setUsage(GAUsage.Field.GET_DEFAULT_TRACKER);
      Tracker localTracker = this.mDefaultTracker;
      return localTracker;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public Tracker getTracker(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +18 -> 21
    //   6: new 84	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc 155
    //   12: invokespecial 89	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   15: athrow
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    //   21: aload_0
    //   22: getfield 43	com/google/analytics/tracking/android/GoogleAnalytics:mTrackers	Ljava/util/Map;
    //   25: aload_1
    //   26: invokeinterface 159 2 0
    //   31: checkcast 161	com/google/analytics/tracking/android/Tracker
    //   34: astore_2
    //   35: aload_2
    //   36: ifnonnull +37 -> 73
    //   39: new 161	com/google/analytics/tracking/android/Tracker
    //   42: dup
    //   43: aload_1
    //   44: aload_0
    //   45: invokespecial 164	com/google/analytics/tracking/android/Tracker:<init>	(Ljava/lang/String;Lcom/google/analytics/tracking/android/TrackerHandler;)V
    //   48: astore_2
    //   49: aload_0
    //   50: getfield 43	com/google/analytics/tracking/android/GoogleAnalytics:mTrackers	Ljava/util/Map;
    //   53: aload_1
    //   54: aload_2
    //   55: invokeinterface 168 3 0
    //   60: pop
    //   61: aload_0
    //   62: getfield 125	com/google/analytics/tracking/android/GoogleAnalytics:mDefaultTracker	Lcom/google/analytics/tracking/android/Tracker;
    //   65: ifnonnull +8 -> 73
    //   68: aload_0
    //   69: aload_2
    //   70: putfield 125	com/google/analytics/tracking/android/GoogleAnalytics:mDefaultTracker	Lcom/google/analytics/tracking/android/Tracker;
    //   73: invokestatic 141	com/google/analytics/tracking/android/GAUsage:getInstance	()Lcom/google/analytics/tracking/android/GAUsage;
    //   76: getstatic 171	com/google/analytics/tracking/android/GAUsage$Field:GET_TRACKER	Lcom/google/analytics/tracking/android/GAUsage$Field;
    //   79: invokevirtual 151	com/google/analytics/tracking/android/GAUsage:setUsage	(Lcom/google/analytics/tracking/android/GAUsage$Field;)V
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_2
    //   85: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	GoogleAnalytics
    //   0	86	1	paramString	String
    //   16	4	2	localObject	Object
    //   34	51	2	localTracker	Tracker
    // Exception table:
    //   from	to	target	type
    //   6	19	16	finally
    //   21	84	16	finally
  }
  
  String getTrackingIdForAds()
  {
    return this.mLastTrackingId;
  }
  
  public boolean isDebugEnabled()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_DEBUG);
    return this.mDebug;
  }
  
  public void requestAppOptOut(AppOptOutCallback paramAppOptOutCallback)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.REQUEST_APP_OPT_OUT);
    if (this.mAppOptOut == null) {
      this.mThread.requestAppOptOut(paramAppOptOutCallback);
    } else {
      paramAppOptOutCallback.reportAppOptOut(this.mAppOptOut.booleanValue());
    }
  }
  
  /* Error */
  public void sendHit(Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +18 -> 21
    //   6: new 84	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc 197
    //   12: invokespecial 89	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   15: athrow
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    //   21: aload_1
    //   22: ldc 199
    //   24: invokestatic 205	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   27: invokestatic 211	com/google/analytics/tracking/android/Utils:getLanguage	(Ljava/util/Locale;)Ljava/lang/String;
    //   30: invokeinterface 168 3 0
    //   35: pop
    //   36: aload_1
    //   37: ldc 213
    //   39: aload_0
    //   40: getfield 68	com/google/analytics/tracking/android/GoogleAnalytics:mAdHitIdGenerator	Lcom/google/analytics/tracking/android/AdHitIdGenerator;
    //   43: invokevirtual 217	com/google/analytics/tracking/android/AdHitIdGenerator:getAdHitId	()I
    //   46: invokestatic 222	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   49: invokeinterface 168 3 0
    //   54: pop
    //   55: aload_1
    //   56: ldc 224
    //   58: new 226	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   65: aload_0
    //   66: getfield 61	com/google/analytics/tracking/android/GoogleAnalytics:mContext	Landroid/content/Context;
    //   69: invokevirtual 231	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   72: invokevirtual 237	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   75: getfield 243	android/util/DisplayMetrics:widthPixels	I
    //   78: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: ldc 249
    //   83: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: getfield 61	com/google/analytics/tracking/android/GoogleAnalytics:mContext	Landroid/content/Context;
    //   90: invokevirtual 231	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   93: invokevirtual 237	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   96: getfield 255	android/util/DisplayMetrics:heightPixels	I
    //   99: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokeinterface 168 3 0
    //   110: pop
    //   111: aload_1
    //   112: ldc_w 258
    //   115: invokestatic 141	com/google/analytics/tracking/android/GAUsage:getInstance	()Lcom/google/analytics/tracking/android/GAUsage;
    //   118: invokevirtual 261	com/google/analytics/tracking/android/GAUsage:getAndClearSequence	()Ljava/lang/String;
    //   121: invokeinterface 168 3 0
    //   126: pop
    //   127: invokestatic 141	com/google/analytics/tracking/android/GAUsage:getInstance	()Lcom/google/analytics/tracking/android/GAUsage;
    //   130: invokevirtual 264	com/google/analytics/tracking/android/GAUsage:getAndClearUsage	()Ljava/lang/String;
    //   133: pop
    //   134: aload_0
    //   135: getfield 63	com/google/analytics/tracking/android/GoogleAnalytics:mThread	Lcom/google/analytics/tracking/android/AnalyticsThread;
    //   138: aload_1
    //   139: invokeinterface 266 2 0
    //   144: aload_0
    //   145: aload_1
    //   146: ldc_w 268
    //   149: invokeinterface 159 2 0
    //   154: checkcast 131	java/lang/String
    //   157: putfield 174	com/google/analytics/tracking/android/GoogleAnalytics:mLastTrackingId	Ljava/lang/String;
    //   160: aload_0
    //   161: monitorexit
    //   162: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	GoogleAnalytics
    //   0	163	1	paramMap	Map<String, String>
    //   16	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	19	16	finally
    //   21	162	16	finally
  }
  
  public void setAppOptOut(boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_OPT_OUT);
    this.mAppOptOut = Boolean.valueOf(paramBoolean);
    this.mThread.setAppOptOut(paramBoolean);
  }
  
  public void setDebug(boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_DEBUG);
    this.mDebug = paramBoolean;
    Log.setDebug(paramBoolean);
  }
  
  public void setDefaultTracker(Tracker paramTracker)
  {
    try
    {
      GAUsage.getInstance().setUsage(GAUsage.Field.SET_DEFAULT_TRACKER);
      this.mDefaultTracker = paramTracker;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static abstract interface AppOptOutCallback
  {
    public abstract void reportAppOptOut(boolean paramBoolean);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.GoogleAnalytics
 * JD-Core Version:    0.7.0.1
 */