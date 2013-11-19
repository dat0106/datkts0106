package com.sonyericsson.extras.liveware.actions.launchapp;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class LaunchAppSettingsHandler
  extends IntentService
{
  private static final String APP_SEPARATOR = "||";
  private static final String ESCAPED_APP_SEPARATOR = "\\|\\|";
  private static final String TAG = "LaunchAppSettingsHandler";
  
  public LaunchAppSettingsHandler()
  {
    super("LaunchAppSettingsHandler");
  }
  
  private void handleIncomingSetting(String paramString1, String paramString2)
  {
    int m = 0;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString2.contains("||"))
      {
        int i = 0;
        String[] arrayOfString = paramString2.split("\\|\\|");
        int j = arrayOfString.length;
        int k = 0;
        while (k < j)
        {
          String str = arrayOfString[k];
          if (!isCorrectSetting(str))
          {
            k++;
          }
          else
          {
            paramString2 = str;
            i = 1;
          }
        }
        if ((i != 0) || (paramString2.endsWith("||")))
        {
          if (paramString2.endsWith("||"))
          {
            Dbg.d("No valid launchapp app available");
            m = 1;
          }
        }
        else
        {
          Dbg.d("None of the predefined apps are installed on the device, using last option");
          paramString2 = arrayOfString[(-1 + arrayOfString.length)];
        }
      }
    }
    else
    {
      Dbg.d("Setting is empty");
      m = 1;
    }
    ActionUtils.sendInjectSettingsResponseIntent(this, paramString1, m, paramString2);
  }
  
  private boolean isCorrectSetting(String paramString)
  {
    boolean bool = true;
    if (paramString.contains(";")) {
      paramString = paramString.split(";")[0];
    }
    PackageManager localPackageManager = getPackageManager();
    int i = 0;
    try
    {
      if (paramString.contains("/")) {
        localPackageManager.getActivityInfo(ComponentName.unflattenFromString(paramString), 0);
      }
      if (i != 0) {}
      try
      {
        if (paramString.contains("/")) {
          localPackageManager.getApplicationInfo(paramString.substring(0, paramString.indexOf("/")), 0);
        } else if (!paramString.contains("/")) {
          localPackageManager.getApplicationInfo(paramString, 0);
        }
      }
      catch (Exception localException1)
      {
        bool = false;
      }
      return bool;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        i = 1;
      }
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    handleIncomingSetting(paramIntent.getStringExtra("id"), paramIntent.getStringExtra("setting_inject"));
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.launchapp.LaunchAppSettingsHandler
 * JD-Core Version:    0.7.0.1
 */