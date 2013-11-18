package com.hitek.settingsscheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class OnScheduleReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("taskID");
    Log.d("SettingsScheduler", "OnScheduleReceiver: taskID = " + str);
    WakeSchedulerIntentService.acquireStaticLock(paramContext);
    Intent localIntent = new Intent(paramContext, SchedulerIntentService.class);
    localIntent.putExtra("taskID", str);
    paramContext.startService(localIntent);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.hitek.settingsscheduler.OnScheduleReceiver
 * JD-Core Version:    0.7.0.1
 */