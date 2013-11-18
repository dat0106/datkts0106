package com.hitek.settingsscheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class OnBootReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.d("SettingsScheduler", "OnBootReceiver");
    new ScheduleManager(paramContext).scheduleAllTasks();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.hitek.settingsscheduler.OnBootReceiver
 * JD-Core Version:    0.7.0.1
 */