package com.sonymobile.gahelper;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.Log;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.ExceptionReporter;
import com.google.analytics.tracking.android.GAServiceManager;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.ServiceManager;
import com.google.analytics.tracking.android.Tracker;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class GaHelper
  extends ContentObserver
{
  private static final Uri GA_URI = Settings.System.getUriFor("somc.google_analytics_enabled");
  private static final String LOG_TAG = GaHelper.class.toString();
  private static final String SOMC_GA_ENABLED_SETTING = "somc.google_analytics_enabled";
  private final Context mContext;
  private boolean mSubscribing = false;
  
  public GaHelper(Context paramContext)
    throws IllegalArgumentException
  {
    super(null);
    if (paramContext != null)
    {
      this.mContext = paramContext;
      return;
    }
    throw new IllegalArgumentException("context is not allowed to be null");
  }
  
  public GaHelper(Context paramContext, Handler paramHandler)
    throws IllegalArgumentException
  {
    super(paramHandler);
    if (paramContext != null)
    {
      this.mContext = paramContext;
      return;
    }
    throw new IllegalArgumentException("context is not allowed to be null");
  }
  
  public static void enableDetailedExceptionTracking(final Tracker paramTracker)
  {
    if (paramTracker != null)
    {
      Thread.setDefaultUncaughtExceptionHandler(new ExceptionReporter(paramTracker, GAServiceManager.getInstance(), Thread.getDefaultUncaughtExceptionHandler())
      {
        public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
        {
          String str1 = paramAnonymousThrowable.getClass().getSimpleName();
          Object localObject = paramAnonymousThrowable.getLocalizedMessage();
          String str2 = ((String)localObject).substring(0, Math.min(((String)localObject).length(), 30));
          localObject = paramAnonymousThrowable.getStackTrace()[0];
          if (localObject == null) {
            str1 = "?";
          } else {
            str1 = str1 + "(" + str2 + ")" + " F:" + ((StackTraceElement)localObject).getFileName() + " M:" + ((StackTraceElement)localObject).getMethodName() + " L:" + ((StackTraceElement)localObject).getLineNumber();
          }
          if (Dbg.d()) {
            Log.e(GaHelper.LOG_TAG, "uncaughtException: " + str1);
          }
          paramTracker.sendException(str1, true);
          super.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
        }
      });
      return;
    }
    throw new IllegalArgumentException("tracker is not allowed to be null");
  }
  
  public void enableDetailedExceptionTrackingEasyTracker()
  {
    EasyTracker.getInstance().setContext(this.mContext);
    enableDetailedExceptionTracking(EasyTracker.getTracker());
  }
  
  public void onChange(boolean paramBoolean)
  {
    if (Dbg.d()) {
      Dbg.d("onChange");
    }
    readAndSetGaEnabled();
  }
  
  public void readAndSetGaEnabled()
  {
    boolean bool2 = false;
    boolean bool1;
    if (Settings.System.getInt(this.mContext.getContentResolver(), "somc.google_analytics_enabled", 1) != 1) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (Dbg.d()) {
      Dbg.d("somc.google_analytics_enabled=" + bool1);
    }
    GoogleAnalytics localGoogleAnalytics = GoogleAnalytics.getInstance(this.mContext);
    if (!bool1) {
      bool2 = true;
    }
    localGoogleAnalytics.setAppOptOut(bool2);
  }
  
  public void subscribeGaSettingChanges()
  {
    if (Dbg.d()) {
      Dbg.d("subscribeGaSettingChanges");
    }
    readAndSetGaEnabled();
    if (!this.mSubscribing)
    {
      this.mContext.getContentResolver().registerContentObserver(GA_URI, false, this);
      this.mSubscribing = true;
    }
  }
  
  public void unsubscribeGaSettingChanges()
  {
    if (Dbg.d()) {
      Dbg.d("unsubscribeGaSettingChanges");
    }
    if (this.mSubscribing)
    {
      this.mContext.getContentResolver().unregisterContentObserver(this);
      this.mSubscribing = false;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonymobile.gahelper.GaHelper
 * JD-Core Version:    0.7.0.1
 */