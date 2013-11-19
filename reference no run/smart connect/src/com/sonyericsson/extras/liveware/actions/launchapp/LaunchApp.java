package com.sonyericsson.extras.liveware.actions.launchapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import com.sonyericsson.extras.liveware.R.string;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.ReflectionUtils;

public class LaunchApp
  extends AbstractAction
{
  public static final String LAUNCH_APP = "LaunchApp";
  public static final String LAUNCH_APP_SETTING = "launch_app_setting";
  
  public LaunchApp()
  {
    super(LaunchApp.class.getSimpleName());
  }
  
  public static String getLabelByRawSetting(Context paramContext, String paramString)
  {
    String str = paramString;
    if (str.contains(";")) {
      str = str.split(";")[0];
    }
    Object localObject1 = null;
    Object localObject2 = paramContext.getPackageManager();
    if (str.contains("/")) {
      localObject1 = getLabelFromActivityInfo(str, (PackageManager)localObject2);
    }
    if ((localObject1 == null) && (LaunchAppAction.isSenseMeSlideshow(str))) {
      localObject1 = getLabelFromActivityInfo("com.sonymobile.musicslideshow/com.sonymobile.musicslideshow.MusicSlideShowActivity", (PackageManager)localObject2);
    }
    if ((localObject1 == null) && (LaunchAppAction.isOldSenseMeSlideshow(str))) {
      localObject1 = getLabelFromActivityInfo("com.sonymobile.photoanalyzer/com.sonymobile.musicslideshow.MusicSlideShowActivity", (PackageManager)localObject2);
    }
    Object localObject3;
    if ((str.contains("/")) && (localObject1 == null))
    {
      localObject3 = str.substring(0, str.indexOf("/"));
      try
      {
        localObject1 = ((PackageManager)localObject2).getApplicationLabel(((PackageManager)localObject2).getApplicationInfo((String)localObject3, 0));
        localObject1 = localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        label124:
        break label124;
      }
      localObject2 = null;
      if (localObject1 == null) {
        break label177;
      }
      localObject2 = ((CharSequence)localObject1).toString();
    }
    label177:
    label305:
    label340:
    label373:
    for (;;)
    {
      for (;;)
      {
        return localObject2;
        if (str.contains("/")) {
          break;
        }
        try
        {
          localObject1 = ((PackageManager)localObject2).getApplicationLabel(((PackageManager)localObject2).getApplicationInfo(str, 0));
          localObject1 = localObject1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2) {}
      }
      break;
      if (paramString.contains(";"))
      {
        if (!paramString.contains(";@")) {
          break label340;
        }
        localObject1 = ReflectionUtils.getStaticField(R.string.class.getName(), paramString.split("@")[1]);
        if (localObject1 == null) {
          break label305;
        }
        localObject3 = paramContext.getResources();
        localObject2 = new Object[1];
        localObject2[0] = paramContext.getString(((Integer)localObject1).intValue());
        localObject2 = ((Resources)localObject3).getString(2131099996, (Object[])localObject2);
      }
      for (;;)
      {
        if (localObject2 != null) {
          break label373;
        }
        localObject2 = paramContext.getResources();
        localObject1 = new Object[1];
        if (str.contains("/")) {
          str = str.split("/")[0];
        }
        localObject1[0] = str;
        localObject2 = ((Resources)localObject2).getString(2131099996, (Object[])localObject1);
        break;
        Dbg.d("R.string." + paramString.split("@")[1] + " does not exist");
        continue;
        localObject2 = paramContext.getResources();
        localObject1 = new Object[1];
        localObject1[0] = paramString.split(";")[1];
        localObject2 = ((Resources)localObject2).getString(2131099996, (Object[])localObject1);
      }
    }
  }
  
  private static CharSequence getLabelFromActivityInfo(String paramString, PackageManager paramPackageManager)
  {
    try
    {
      localCharSequence = paramPackageManager.getActivityInfo(ComponentName.unflattenFromString(paramString), 0).loadLabel(paramPackageManager);
      localCharSequence = localCharSequence;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        CharSequence localCharSequence = null;
      }
    }
    return localCharSequence;
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, LaunchAppAction.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, LaunchAppSettingsHandler.class);
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    return getLabelByRawSetting(paramContext, paramIntent.getStringExtra("setting_raw"));
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, LaunchAppSelectionActivity.class);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.launchapp.LaunchApp
 * JD-Core Version:    0.7.0.1
 */