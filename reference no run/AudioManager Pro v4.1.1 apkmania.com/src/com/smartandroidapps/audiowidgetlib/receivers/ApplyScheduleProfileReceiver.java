package com.smartandroidapps.audiowidgetlib.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;
import com.smartandroidapps.audiowidgetlib.AlarmAlertWakeLock;
import com.smartandroidapps.audiowidgetlib.data.Schedule;
import com.smartandroidapps.audiowidgetlib.fragments.ProfilesFragment;
import com.smartandroidapps.audiowidgetlib.services.UpdateService;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;

public class ApplyScheduleProfileReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("scheduleId", 0);
    Log.d("AudioManager", "ApplyScheduleProfileReceiver ScheduleId: " + String.valueOf(i));
    Schedule localSchedule2 = Schedule.getSchedule(i, paramContext);
    Schedule localSchedule1 = Schedule.SetUpAlarmManagerForNextSchedule(paramContext);
    Log.d("AudioManager", "ApplyScheduleProfileReceiver Next Schedule, ScheduleId: " + localSchedule1.getId());
    if (localSchedule2 == null)
    {
      Log.w("AudioManager", "ApplyScheduleProfileReceiver Schedule not found:" + i);
    }
    else if (localSchedule2.applyProfileForSchedule(ProfilesFragment.checkProfileStreams(paramContext, false, (AudioManager)paramContext.getSystemService("audio"))))
    {
      Log.d("AudioManager", "ApplyScheduleProfileReceiver Schedule Profile Applied, ProfileId: " + localSchedule2.getProfileId());
      AlarmAlertWakeLock.acquireCpuWakeLock(paramContext);
      paramContext.startService(new Intent(paramContext, UpdateService.class));
      if (MiscUtils.isDebug()) {
        Log.d("AudioManager", "ApplyScheduleProfileReceiver Schedule Profile Applied, widget Ui updated: " + localSchedule2.getProfileId());
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.receivers.ApplyScheduleProfileReceiver
 * JD-Core Version:    0.7.0.1
 */