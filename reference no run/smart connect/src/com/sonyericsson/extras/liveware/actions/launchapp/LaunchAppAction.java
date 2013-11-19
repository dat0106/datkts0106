package com.sonyericsson.extras.liveware.actions.launchapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.actions.ActionService;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.MarketUtils;
import com.sonyericsson.extras.liveware.utils.PackageUtils;

public class LaunchAppAction
  extends ActionService
{
  static final String oldSlideShowAppName = "com.sonymobile.musicslideshow/com.sonymobile.musicslideshow.MusicSlideShowActivity";
  static final String slideShowAppName = "com.sonymobile.photoanalyzer/com.sonymobile.musicslideshow.MusicSlideShowActivity";
  
  private boolean appIsSenseMeSlideShow(String paramString)
  {
    boolean bool;
    if ((isOldSenseMeSlideshow(paramString)) || (isSenseMeSlideshow(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean isOldSenseMeSlideshow(String paramString)
  {
    boolean bool;
    if (("com.sonymobile.musicslideshow/com.sonymobile.musicslideshow.MusicSlideShowActivity".equals(paramString)) || ("com.sonymobile.musicslideshow/.MusicSlideShowActivity".equals(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean isSenseMeSlideshow(String paramString)
  {
    return "com.sonymobile.photoanalyzer/com.sonymobile.musicslideshow.MusicSlideShowActivity".equals(paramString);
  }
  
  private int launchApp(String paramString, Context paramContext, Device paramDevice)
  {
    if (Dbg.d()) {
      Dbg.d("Trying to launch app: " + paramString);
    }
    if ((!paramString.contains("/")) || (!PackageUtils.sendConnectLaunch(paramContext, paramDevice, paramString))) {
      if (!paramString.contains("/"))
      {
        startActivity(getPackageManager().getLaunchIntentForPackage(paramString));
      }
      else
      {
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.setComponent(ComponentName.unflattenFromString(paramString));
        localIntent.addCategory("android.intent.category.LAUNCHER");
        localIntent.addFlags(268435456);
        startActivity(localIntent);
      }
    }
    return 0;
  }
  
  private int launchSlideShow(String paramString, Context paramContext, Device paramDevice)
  {
    try
    {
      i = launchApp(paramString, paramContext, paramDevice);
      i = i;
      if (i != 0) {
        break label22;
      }
    }
    catch (RuntimeException localRuntimeException2)
    {
      for (;;)
      {
        try
        {
          int i;
          label22:
          if (isOldSenseMeSlideshow(paramString))
          {
            i = launchApp("com.sonymobile.photoanalyzer/com.sonymobile.musicslideshow.MusicSlideShowActivity", paramContext, paramDevice);
          }
          else
          {
            i = launchApp("com.sonymobile.musicslideshow/com.sonymobile.musicslideshow.MusicSlideShowActivity", paramContext, paramDevice);
            i = i;
          }
        }
        catch (RuntimeException localRuntimeException1)
        {
          Dbg.e("Not able to start any of the versions of the SenseMe Slideshow app.", localRuntimeException1);
          int j = 1;
        }
      }
    }
    return i;
  }
  
  public int executeAction(Context paramContext, String paramString1, String paramString2)
  {
    String str1 = paramString2;
    Object localObject2;
    Device localDevice;
    int i;
    if (!TextUtils.isEmpty(str1))
    {
      if (str1.contains(";")) {
        str1 = str1.split(";")[0];
      }
      localObject2 = ExperienceManager.getInstance(paramContext);
      ActionSet localActionSet = ((ExperienceManager)localObject2).getActionSetByUuid(paramString1);
      localDevice = null;
      if (localActionSet != null) {
        localDevice = ((ExperienceManager)localObject2).getExperience(localActionSet.getExperience()).getDevice();
      }
      if (!str1.contains("/")) {
        break label134;
      }
      localObject2 = str1.split("/")[0];
      if (!PackageUtils.existsPackage(paramContext, (String)localObject2)) {
        break label175;
      }
      if (!appIsSenseMeSlideShow(str1)) {
        break label141;
      }
      i = launchSlideShow(str1, paramContext, localDevice);
    }
    label134:
    label141:
    int j;
    for (;;)
    {
      return i;
      Dbg.d("No setting.");
      i = 1;
      continue;
      localObject2 = i;
      break;
      try
      {
        i = launchApp(i, paramContext, localDevice);
        i = i;
      }
      catch (RuntimeException localRuntimeException)
      {
        Dbg.e("Not able to start application.", localRuntimeException);
        j = 1;
      }
    }
    label175:
    if (MarketUtils.isGooglePlayInstalled(paramContext)) {
      if (j.contains("/"))
      {
        String str2 = j.split("/")[0];
        label203:
        MarketUtils.launchInfo(paramContext, str2);
      }
    }
    for (;;)
    {
      int k = 1;
      break;
      Object localObject1 = k;
      break label203;
      Dbg.d("App not installed and market is not installed");
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.launchapp.LaunchAppAction
 * JD-Core Version:    0.7.0.1
 */