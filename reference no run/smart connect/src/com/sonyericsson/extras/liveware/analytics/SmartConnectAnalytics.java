package com.sonyericsson.extras.liveware.analytics;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import com.sonyericsson.extras.liveware.experience.Action;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonymobile.gahelper.GaHelper;

public class SmartConnectAnalytics
{
  public static final String ACTION_LAUNCH_HOME = "Home";
  public static final String ACTION_LAUNCH_NOTIFICATION = "Notification";
  public static final String ACTION_LAUNCH_SETTINGS = "Settings";
  public static final String ACTION_NONE = "None";
  public static final String CATEGORY_ACTION_ADD = "ActionAdd";
  public static final String CATEGORY_ACTION_EDIT = "ActionEdit";
  public static final String CATEGORY_ACTION_REMOVE = "ActionRemove";
  public static final String CATEGORY_DEVICE_CONFIGURE = "DeviceConfigure";
  public static final String CATEGORY_DEVICE_PAGE_LAUNCH = "DevicePageLaunch";
  public static final String CATEGORY_EVENT_CREATE = "EventCreate";
  public static final String CATEGORY_EVENT_START = "EventStart";
  public static final String CATEGORY_EVENT_STOP = "EventStop";
  public static final String CATEGORY_EXTENSION_INSTALL = "ExtensionInstall";
  public static final String CATEGORY_LAUNCH = "Launch";
  public static final String CATEGORY_TRIGGER_ADD = "TriggerAdd";
  public static final String CATEGORY_TRIGGER_EDIT = "TriggerEdit";
  public static final String CATEGORY_TRIGGER_REMOVE = "TriggerRemove";
  public static final String LABEL_NONE = "None";
  public static final String LABEL_TRIGGER_TIME = "Time";
  private static final String SOMC_GA_ENABLED_SETTING = "somc.google_analytics_enabled";
  
  public static void enableExceptionTracking(Context paramContext)
  {
    new GaHelper(paramContext).enableDetailedExceptionTrackingEasyTracker();
  }
  
  public static void init(Context paramContext)
  {
    Object localObject = new GaHelper(paramContext);
    if (!ActivityManager.isUserAMonkey())
    {
      if (!isSomcSettingAvailable(paramContext))
      {
        boolean bool = PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramContext.getString(2131099730), true);
        if (Dbg.d()) {
          Dbg.d("Analytics enabled: " + bool);
        }
        localObject = GoogleAnalytics.getInstance(paramContext);
        if (!bool) {
          bool = true;
        } else {
          bool = false;
        }
        ((GoogleAnalytics)localObject).setAppOptOut(bool);
      }
      else
      {
        ((GaHelper)localObject).readAndSetGaEnabled();
      }
    }
    else
    {
      Dbg.d("Analytics opt out due to Monkey");
      GoogleAnalytics.getInstance(paramContext).setAppOptOut(true);
    }
    EasyTracker.getInstance().setContext(paramContext);
    localObject = EasyTracker.getTracker();
    ((Tracker)localObject).setCustomDimension(1, Build.MODEL);
    ((Tracker)localObject).setCustomDimension(2, Build.ID);
    ((Tracker)localObject).setCustomDimension(3, String.valueOf(((Tracker)localObject).getSampleRate()));
  }
  
  public static boolean isSomcSettingAvailable(Context paramContext)
  {
    boolean bool;
    if (Settings.System.getInt(paramContext.getContentResolver(), "somc.google_analytics_enabled", 244) == 244) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void trackDeviceFirstConnect(Context paramContext, Device paramDevice)
  {
    AnalyticsService.addHit(paramContext, "DeviceConfigure", paramDevice.getProductId(), "None");
  }
  
  public static void trackDevicePageLaunch(Context paramContext, Device paramDevice)
  {
    AnalyticsService.addHit(paramContext, "DevicePageLaunch", paramDevice.getProductId(), "None");
  }
  
  public static void trackEvent(Context paramContext, String paramString)
  {
    AnalyticsService.addHit(paramContext, paramString, "None", "None");
  }
  
  public static void trackEvent(Context paramContext, String paramString1, String paramString2)
  {
    AnalyticsService.addHit(paramContext, paramString1, paramString2, "None");
  }
  
  public static void trackEvent(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AnalyticsService.addHit(paramContext, paramString1, paramString2, paramString3);
  }
  
  public static void trackEventAction(Context paramContext, String paramString, Action paramAction)
  {
    AnalyticsService.addHit(paramContext, paramString, paramAction.getClassName(), "None");
  }
  
  public static void trackEventDevice(Context paramContext, String paramString, Device paramDevice)
  {
    AnalyticsService.addHit(paramContext, paramString, paramDevice.getProductId(), "None");
  }
  
  public static void trackExperienceRun(Context paramContext, Experience paramExperience, String paramString)
  {
    Object localObject = paramExperience.getDevice();
    if (localObject == null) {
      localObject = "None";
    } else {
      localObject = ((Device)localObject).getProductId();
    }
    String str;
    if (paramExperience.getTime() == null) {
      str = "None";
    } else {
      str = "Time";
    }
    AnalyticsService.addHit(paramContext, paramString, (String)localObject, str);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics
 * JD-Core Version:    0.7.0.1
 */