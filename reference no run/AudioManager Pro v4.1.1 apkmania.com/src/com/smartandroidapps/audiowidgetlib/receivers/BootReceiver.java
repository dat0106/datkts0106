package com.smartandroidapps.audiowidgetlib.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;
import com.smartandroidapps.audiowidgetlib.AApplication;
import com.smartandroidapps.audiowidgetlib.data.Schedule;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.fragments.ProfilesFragment;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;

public class BootReceiver
  extends BroadcastReceiver
{
  static final String ACTION_BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (MiscUtils.isDebug()) {
      Log.d("AudioManager", "BootReceiver onReceive(): " + paramIntent.getAction().toString());
    }
    if (paramIntent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
    {
      SettingsManager localSettingsManager = new SettingsManager(paramContext);
      boolean bool1 = localSettingsManager.getBoolean("statBar", false);
      boolean bool2 = localSettingsManager.getProfileWidgetEnabled();
      if (MiscUtils.isDebug())
      {
        Log.d("AudioManager", "BootReceiver statBarMonitor: " + bool1);
        Log.d("AudioManager", "BootReceiver profileWidgetEnabled: " + bool2);
      }
      AApplication.isBooting = true;
      if ((bool1) || (bool2)) {
        ProfilesFragment.checkProfileStreams(paramContext, true, (AudioManager)paramContext.getSystemService("audio"));
      }
      AApplication.BootingDone();
    }
    Schedule.SetUpAlarmManagerForNextSchedule(paramContext);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.receivers.BootReceiver
 * JD-Core Version:    0.7.0.1
 */