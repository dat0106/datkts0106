package com.hitek.settingsscheduler;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.provider.Settings.System;
import android.util.Log;
import android.widget.Toast;
import java.util.Calendar;

public class SchedulerIntentService
  extends WakeSchedulerIntentService
{
  private static Context context;
  private SharedPreferences prefs;
  
  public SchedulerIntentService()
  {
    super("Settings Scheduler Service");
  }
  
  private void runAlarmVolumeTask(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      AudioManager localAudioManager = (AudioManager)context.getSystemService("audio");
      localAudioManager.setStreamVolume(4, i * localAudioManager.getStreamMaxVolume(4) / 100, 1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("SettingsScheduler", "SchedulerIntentService.runAlarmVolumeTask error");
      }
    }
  }
  
  private void runBluetoothTask(String paramString)
  {
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    if (!paramString.equalsIgnoreCase(getString(2131034118)))
    {
      if (paramString.equalsIgnoreCase(getString(2131034117))) {
        ((BluetoothAdapter)localObject).enable();
      }
    }
    else {
      ((BluetoothAdapter)localObject).disable();
    }
    String str = getResources().getString(2131034112) + " : " + getResources().getString(2131034120) + " = " + paramString;
    localObject = new ToastMessageTask(null);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = str;
    ((ToastMessageTask)localObject).execute(arrayOfString);
  }
  
  private void runBrightnessModeTask(String paramString)
  {
    try
    {
      if (paramString.equalsIgnoreCase(getString(2131034118))) {
        Settings.System.putInt(getContentResolver(), "screen_brightness_mode", 0);
      }
      for (;;)
      {
        Object localObject = new Intent(context, ZombieBrightnessActivity.class);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("taskType", "mode");
        ((Intent)localObject).putExtra("value", "0");
        startActivity((Intent)localObject);
        String str = getResources().getString(2131034112) + " : " + getResources().getString(2131034131) + "-" + getResources().getString(2131034132) + " = " + paramString;
        ToastMessageTask localToastMessageTask = new ToastMessageTask(null);
        localObject = new String[1];
        localObject[0] = str;
        localToastMessageTask.execute((Object[])localObject);
        break;
        if (paramString.equalsIgnoreCase(getString(2131034117))) {
          Settings.System.putInt(getContentResolver(), "screen_brightness_mode", 1);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.d("SettingsScheduler", "SchedulerIntentService.runBrightnessModeTask error");
    }
  }
  
  private void runBrightnessTask(String paramString)
  {
    try
    {
      int i = 255 * Integer.parseInt(paramString) / 100;
      if (Settings.System.getInt(getContentResolver(), "screen_brightness_mode") == 1) {
        Settings.System.putInt(getContentResolver(), "screen_brightness_mode", 0);
      }
      Settings.System.putInt(getContentResolver(), "screen_brightness", i);
      Object localObject = new Intent(context, ZombieBrightnessActivity.class);
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("taskType", "level");
      ((Intent)localObject).putExtra("value", Integer.toString(i));
      startActivity((Intent)localObject);
      String str = getResources().getString(2131034112) + " : " + getResources().getString(2131034131) + " = " + paramString;
      ToastMessageTask localToastMessageTask = new ToastMessageTask(null);
      localObject = new String[1];
      localObject[0] = str;
      localToastMessageTask.execute((Object[])localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("SettingsScheduler", "SchedulerIntentService.runBrightnessTask error");
      }
    }
  }
  
  private void runMediaVolumeTask(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      AudioManager localAudioManager = (AudioManager)context.getSystemService("audio");
      localAudioManager.setStreamVolume(3, i * localAudioManager.getStreamMaxVolume(3) / 100, 1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("SettingsScheduler", "SchedulerIntentService.runMediaVolumeTask error");
      }
    }
  }
  
  private void runMobileDataTask(String paramString) {}
  
  private void runNotificationVolumeTask(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      AudioManager localAudioManager = (AudioManager)context.getSystemService("audio");
      localAudioManager.setStreamVolume(5, i * localAudioManager.getStreamMaxVolume(5) / 100, 1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("SettingsScheduler", "SchedulerIntentService.runNotificationVolumeTask error");
      }
    }
  }
  
  private void runRingerVolumeTask(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      AudioManager localAudioManager = (AudioManager)context.getSystemService("audio");
      localAudioManager.setStreamVolume(2, i * localAudioManager.getStreamMaxVolume(2) / 100, 1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("SettingsScheduler", "SchedulerIntentService.runRingerVolumeTask error");
      }
    }
  }
  
  private void runScreenTimeoutTask(String paramString)
  {
    try
    {
      f1 = Float.parseFloat(paramString);
      f1 = f1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        float f1;
        int i;
        String str;
        ToastMessageTask localToastMessageTask;
        String[] arrayOfString;
        Log.d("SettingsScheduler", "SchedulerIntentService.runScreenTimeoutTask error");
        float f2 = 15.0F;
      }
    }
    i = (int)(1000.0F * (60.0F * f1));
    Settings.System.putInt(getContentResolver(), "screen_off_timeout", i);
    str = getResources().getString(2131034112) + " : " + getResources().getString(2131034129) + " = " + paramString;
    localToastMessageTask = new ToastMessageTask(null);
    arrayOfString = new String[1];
    arrayOfString[0] = str;
    localToastMessageTask.execute(arrayOfString);
  }
  
  private void runSoundTask(String paramString)
  {
    Object localObject = (AudioManager)context.getSystemService("audio");
    if (!paramString.equalsIgnoreCase(getString(2131034118)))
    {
      if (paramString.equalsIgnoreCase(getString(2131034117))) {
        ((AudioManager)localObject).setRingerMode(2);
      }
    }
    else {
      ((AudioManager)localObject).setRingerMode(0);
    }
    String str = getResources().getString(2131034112) + " : " + getResources().getString(2131034121) + " = " + paramString;
    localObject = new ToastMessageTask(null);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = str;
    ((ToastMessageTask)localObject).execute(arrayOfString);
  }
  
  private void runSystemVolumeTask(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      AudioManager localAudioManager = (AudioManager)context.getSystemService("audio");
      localAudioManager.setStreamVolume(1, i * localAudioManager.getStreamMaxVolume(1) / 100, 1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("SettingsScheduler", "SchedulerIntentService.runSystemVolumeTask error");
      }
    }
  }
  
  private void runVibarateTask(String paramString)
  {
    Object localObject = (AudioManager)context.getSystemService("audio");
    if (!paramString.equalsIgnoreCase(getString(2131034118)))
    {
      if (paramString.equalsIgnoreCase(getString(2131034117))) {
        ((AudioManager)localObject).setRingerMode(1);
      }
    }
    else {
      ((AudioManager)localObject).setRingerMode(0);
    }
    localObject = getResources().getString(2131034112) + " : " + getResources().getString(2131034122) + " = " + paramString;
    ToastMessageTask localToastMessageTask = new ToastMessageTask(null);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = localObject;
    localToastMessageTask.execute(arrayOfString);
  }
  
  private void runWifiTask(String paramString)
  {
    Object localObject = (WifiManager)getSystemService("wifi");
    if (!paramString.equalsIgnoreCase(getString(2131034118)))
    {
      if (paramString.equalsIgnoreCase(getString(2131034117))) {
        ((WifiManager)localObject).setWifiEnabled(true);
      }
    }
    else {
      ((WifiManager)localObject).setWifiEnabled(false);
    }
    localObject = getResources().getString(2131034112) + " : " + getResources().getString(2131034119) + " = " + paramString;
    ToastMessageTask localToastMessageTask = new ToastMessageTask(null);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = localObject;
    localToastMessageTask.execute(arrayOfString);
  }
  
  private boolean satisfiesDayCriteria(String paramString)
  {
    int i = 1;
    int j = Calendar.getInstance().get(7);
    if (j != i)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 5)
            {
              if (j != 6)
              {
                if ((j == 7) && (Boolean.valueOf(this.prefs.getString("saturday_" + paramString, "false")).booleanValue())) {
                  return i;
                }
              }
              else if (Boolean.valueOf(this.prefs.getString("friday_" + paramString, "false")).booleanValue()) {
                return i;
              }
            }
            else if (Boolean.valueOf(this.prefs.getString("thursday_" + paramString, "false")).booleanValue()) {
              return i;
            }
          }
          else if (Boolean.valueOf(this.prefs.getString("wednesday_" + paramString, "false")).booleanValue()) {
            return i;
          }
        }
        else if (Boolean.valueOf(this.prefs.getString("tuesday_" + paramString, "false")).booleanValue()) {
          return i;
        }
      }
      else if (Boolean.valueOf(this.prefs.getString("monday_" + paramString, "false")).booleanValue()) {
        return i;
      }
    }
    else if (Boolean.valueOf(this.prefs.getString("sunday_" + paramString, "false")).booleanValue()) {
      return i;
    }
    i = 0;
    return i;
  }
  
  private boolean satisfiesWeekCriteria(String paramString)
  {
    int i = 1;
    Calendar localCalendar = Calendar.getInstance();
    int j = localCalendar.get(4);
    int k = localCalendar.get(3);
    if (j != i)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 5)
            {
              if (j != 6)
              {
                if (k % 2 != 0)
                {
                  if ((k % 2 != 0) && (Boolean.valueOf(this.prefs.getString("weekOdd_" + paramString, "false")).booleanValue())) {
                    return i;
                  }
                }
                else if (Boolean.valueOf(this.prefs.getString("weekEven_" + paramString, "false")).booleanValue()) {
                  return i;
                }
              }
              else if (Boolean.valueOf(this.prefs.getString("week6_" + paramString, "false")).booleanValue()) {
                return i;
              }
            }
            else if (Boolean.valueOf(this.prefs.getString("week5_" + paramString, "false")).booleanValue()) {
              return i;
            }
          }
          else if (Boolean.valueOf(this.prefs.getString("week4_" + paramString, "false")).booleanValue()) {
            return i;
          }
        }
        else if (Boolean.valueOf(this.prefs.getString("week3_" + paramString, "false")).booleanValue()) {
          return i;
        }
      }
      else if (Boolean.valueOf(this.prefs.getString("week2_" + paramString, "false")).booleanValue()) {
        return i;
      }
    }
    else if (Boolean.valueOf(this.prefs.getString("week1_" + paramString, "false")).booleanValue()) {
      return i;
    }
    i = 0;
    return i;
  }
  
  void doSchedulerWork(Intent paramIntent, Context paramContext)
  {
    context = paramContext;
    this.prefs = getSharedPreferences("Tasks", 4);
    String str3 = paramIntent.getStringExtra("taskID");
    Log.d("SettingsScheduler", "ScheduleIntentService.doSchedulerWork: taskID = " + str3);
    if ((this.prefs.getString("enabled_" + str3, "false").equals("true")) && (satisfiesDayCriteria(str3)) && (satisfiesWeekCriteria(str3)))
    {
      String str1 = this.prefs.getString("taskType_" + str3, "0");
      String str2 = this.prefs.getString("value_" + str3, "");
      Log.d("SettingsScheduler", "ScheduleIntentService.doSchedulerWork: taskID = " + str3 + ", taskType = " + str1 + ", taskValue = " + str2);
      if (!str1.equals("0"))
      {
        if (!str1.equals("1"))
        {
          if (!str1.equals("2"))
          {
            if (!str1.equals("3"))
            {
              if (!str1.equals("4"))
              {
                if (!str1.equals("5"))
                {
                  if (!str1.equals("6"))
                  {
                    if (!str1.equals("7"))
                    {
                      if (!str1.equals("8"))
                      {
                        if (!str1.equals("9"))
                        {
                          if (!str1.equals("10"))
                          {
                            if (!str1.equals("11"))
                            {
                              if (str1.equals("12")) {
                                runMobileDataTask(str2);
                              }
                            }
                            else {
                              runBrightnessModeTask(str2);
                            }
                          }
                          else {
                            runBrightnessTask(str2);
                          }
                        }
                        else {
                          runAlarmVolumeTask(str2);
                        }
                      }
                      else {
                        runSystemVolumeTask(str2);
                      }
                    }
                    else {
                      runNotificationVolumeTask(str2);
                    }
                  }
                  else {
                    runRingerVolumeTask(str2);
                  }
                }
                else {
                  runMediaVolumeTask(str2);
                }
              }
              else {
                runVibarateTask(str2);
              }
            }
            else {
              runSoundTask(str2);
            }
          }
          else {
            runBluetoothTask(str2);
          }
        }
        else {
          runWifiTask(str2);
        }
      }
      else {
        runScreenTimeoutTask(str2);
      }
    }
  }
  
  private class ToastMessageTask
    extends AsyncTask<String, String, String>
  {
    String toastMessage;
    
    private ToastMessageTask() {}
    
    protected String doInBackground(String... paramVarArgs)
    {
      this.toastMessage = paramVarArgs[0];
      return this.toastMessage;
    }
    
    protected void onPostExecute(String paramString)
    {
      Toast.makeText(SchedulerIntentService.this.getApplicationContext(), paramString, 1).show();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.hitek.settingsscheduler.SchedulerIntentService
 * JD-Core Version:    0.7.0.1
 */