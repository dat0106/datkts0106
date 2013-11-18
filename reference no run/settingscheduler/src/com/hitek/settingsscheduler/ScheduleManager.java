package com.hitek.settingsscheduler;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ScheduleManager
{
  private AlarmManager alarmManager;
  private Context context;
  
  public ScheduleManager(Context paramContext)
  {
    this.context = paramContext;
    this.alarmManager = ((AlarmManager)paramContext.getSystemService("alarm"));
  }
  
  private Calendar getNextTriggerCheckTime(int paramInt1, int paramInt2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(11, paramInt1);
    localCalendar2.set(12, paramInt2);
    if ((localCalendar2.before(localCalendar1)) || (localCalendar2.equals(localCalendar1))) {
      localCalendar2.add(5, 1);
    }
    return localCalendar2;
  }
  
  public void scheduleAllTasks()
  {
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences("Tasks", 4);
    Iterator localIterator = localSharedPreferences.getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.contains("taskID_"))
      {
        str = localSharedPreferences.getString(str, "");
        if (localSharedPreferences.getString("enabled_" + str, "false").equals("true")) {
          scheduleTask(str);
        }
      }
    }
  }
  
  public void scheduleTask(String paramString)
  {
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences("Tasks", 4);
    int j = Integer.parseInt(localSharedPreferences.getString("hour_" + paramString, "12"));
    int k = Integer.parseInt(localSharedPreferences.getString("minute_" + paramString, "00"));
    Intent localIntent = new Intent(this.context, OnScheduleReceiver.class);
    localIntent.putExtra("taskID", paramString);
    int i = Integer.parseInt(paramString.substring(-5 + paramString.length()));
    Calendar localCalendar = getNextTriggerCheckTime(j, k);
    Long localLong = Long.valueOf(86400000L);
    Log.d("SettingsScheduler", "ScheduleManager.scheduleTask: taskID = " + paramString + ", next trigger time = " + localCalendar.getTime().toString());
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.context, i, localIntent, 268435456);
    this.alarmManager.setRepeating(0, localCalendar.getTimeInMillis(), localLong.longValue(), localPendingIntent);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.hitek.settingsscheduler.ScheduleManager
 * JD-Core Version:    0.7.0.1
 */