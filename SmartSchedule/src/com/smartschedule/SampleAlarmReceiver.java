package com.smartschedule;

import java.util.ArrayList;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class SampleAlarmReceiver extends WakefulBroadcastReceiver {
    private AlarmManager alarmMgr;
    private PendingIntent  alarmIntent;
    private ArrayList<PendingIntent> intentArray;
    private AlarmManager[] alarmManager;

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent service =  new Intent(context, SampleSchedulingService.class);

        startWakefulService(context, service);

    }

    public void setAlarm(Context context){
        alarmManager = new AlarmManager[24];
        intentArray =  new ArrayList<PendingIntent>();
        for(int i = 0; i <10; i ++){
            alarmManager[i] = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(context, SampleAlarmReceiver.class);
            // use Pending Intent for sent signal - send broadcast
            PendingIntent pi =  PendingIntent.getBroadcast(context, i, intent, 0);

//	        alarmManager[i].set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +  5000* i ,pi);

            alarmManager[i].setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +  5000* i, 60000, pi);

            intentArray.add(pi);
//	        // for each 15 min
//	        alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
//	                AlarmManager.INTERVAL_FIFTEEN_MINUTES,
//	                AlarmManager.INTERVAL_FIFTEEN_MINUTES, alarmIntent);
        }
        // chua dung den
        ComponentName receiver = new ComponentName(context, SampleBootReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    public void cancelAlarm(Context context) {

        alarmManager = new AlarmManager[24];
        for(int i = 0; i <10; i ++){
            alarmManager[i] = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(context, SampleAlarmReceiver.class);
            // use Pending Intent for sent signal - send broadcast
            PendingIntent pi =  PendingIntent.getBroadcast(context, i, intent, 0);
            try{
                alarmManager[i].cancel(pi);
                Log.v("SampleAlarmReceiver", "cancel alarmManager " + i );
            }
            catch(Exception e){
                Log.e("SampleAlarmReceiver", "error alarmManager " + i + " "+ e.getMessage());

            }

        }
        // Disable {@code SampleBootReceiver} so that it doesn't automatically restart the
        // alarm when the device is rebooted.
        ComponentName receiver = new ComponentName(context, SampleBootReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);

    }
}
