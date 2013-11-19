package com.sonyericsson.extras.liveware;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import com.sonyericsson.extras.liveware.analytics.AnalyticsService;
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.Locale;

public class LivewareManagerApplication
  extends Application
{
  private int mCurrentCountryCode;
  private Locale mCurrentLocale;
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.mCurrentCountryCode != paramConfiguration.mcc) || (!this.mCurrentLocale.equals(paramConfiguration.locale)))
    {
      if (Dbg.v()) {
        Dbg.v("Locale or mcc updated");
      }
      AsfUtils.updateConfiguration(this);
    }
    this.mCurrentLocale = paramConfiguration.locale;
    this.mCurrentCountryCode = paramConfiguration.mcc;
  }
  
  public void onCreate()
  {
    super.onCreate();
    try
    {
      Dbg.initDebugFlag(this);
      this.mCurrentLocale = getResources().getConfiguration().locale;
      this.mCurrentCountryCode = getResources().getConfiguration().mcc;
      AsfUtils.initializeServices(this);
      PreferenceManager.setDefaultValues(this, 2130968576, false);
      SmartConnectAnalytics.init(this);
      SmartConnectAnalytics.enableExceptionTracking(this);
      AnalyticsService.dispatchIfAllowed(this);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        if (Dbg.w()) {
          Dbg.w("Failed to start services", localSecurityException);
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.LivewareManagerApplication
 * JD-Core Version:    0.7.0.1
 */