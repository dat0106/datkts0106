package com.smartschedule;

import java.util.ArrayList;
import java.util.Calendar;

import com.smartschedule.database.Event;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.util.Constant;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.Toast;

public class ScheduleServiceReceiver extends WakefulBroadcastReceiver {
    private AlarmManager alarmMgrStart;
    private AlarmManager alarmMgrEnd;
    private PendingIntent alarmIntent;
    private ArrayList<PendingIntent> intentArray;
    private AlarmManager[] alarmManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();

        intent.setClass(context, SchedulingService.class);
        Intent service = new Intent(context, SchedulingService.class);

        int i = extras.getInt(SmartSchedulerDatabase.COLUMN_EVENT_ID);
        String i2 = extras.getString(Constant.START_OR_END);
        Log.v(this.toString(), "COLUMN_EVENT_ID" + i + " check_start_end" + i2);
//        service.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, 10);
//        service.putExtra(Constant.START_OR_END, 1);
        startWakefulService(context, intent);


    }
//
//    public void setAlarm(Context context) {
//        alarmManager = new AlarmManager[24];
//        intentArray = new ArrayList<PendingIntent>();
//        for (int i = 0; i < 2; i++) {
//            alarmManager[i] = (AlarmManager) context
//                    .getSystemService(Context.ALARM_SERVICE);
//            Intent intent = new Intent(context, ScheduleServiceReceiver.class);
//            // use Pending Intent for sent signal - send broadcast
//            PendingIntent pi = PendingIntent.getBroadcast(context, i, intent,
//                    PendingIntent.FLAG_ONE_SHOT);
//
//            // alarmManager[i].set(AlarmManager.RTC_WAKEUP,
//            // System.currentTimeMillis() + 5000* i ,pi);
//
//            alarmManager[i].setRepeating(AlarmManager.RTC_WAKEUP,
//                    System.currentTimeMillis() + 5000 * i, 60000, pi);
//
//            intentArray.add(pi);
//            // // for each 15 min
//            // alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
//            // AlarmManager.INTERVAL_FIFTEEN_MINUTES,
//            // AlarmManager.INTERVAL_FIFTEEN_MINUTES, alarmIntent);
//        }
//        // chua dung den
//        // ComponentName receiver = new ComponentName(context,
//        // SampleBootReceiver.class);
//        // PackageManager pm = context.getPackageManager();
//        //
//        // pm.setComponentEnabledSetting(receiver,
//        // PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
//        // PackageManager.DONT_KILL_APP);
//    }
//
//    public void cancelAlarm(Context context) {
//
//        alarmManager = new AlarmManager[24];
//        for (int i = 0; i < 10; i++) {
//            alarmManager[i] = (AlarmManager) context
//                    .getSystemService(Context.ALARM_SERVICE);
//            Intent intent = new Intent(context, ScheduleServiceReceiver.class);
//
//            // use;l Pending Intent for sent signal - send broadcast
//            PendingIntent pi = PendingIntent
//                    .getBroadcast(context, i, intent, 0);
//            try {
//                alarmManager[i].cancel(pi);
//                Log.v("ScheduleServiceReceiver", "cancel alarmManager " + i);
//            } catch (Exception e) {
//                Log.e("ScheduleServiceReceiver", "error alarmManager " + i
//                        + " " + e.getMessage());
//            }
//
//        }
//        // Disable {@code SampleBootReceiver} so that it doesn't automatically
//        // restart the
//        // alarm when the device is rebooted.
//        ComponentName receiver = new ComponentName(context,
//                SampleBootReceiver.class);
//        PackageManager pm = context.getPackageManager();
//
//        pm.setComponentEnabledSetting(receiver,
//                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
//                PackageManager.DONT_KILL_APP);
//
//    }

    public void setSchedule(Context context, Event event) {
        int id = event.getId();
        alarmMgrStart = (AlarmManager) context
                .getSystemService(context.ALARM_SERVICE);

        alarmMgrEnd = (AlarmManager) context
                .getSystemService(context.ALARM_SERVICE);
        Intent intentStart = new Intent(context, ScheduleServiceReceiver.class);
        intentStart.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, id);
        intentStart.putExtra(Constant.START_OR_END, Constant.START);

        PendingIntent piStart = PendingIntent.getBroadcast(context, id * 2,
                intentStart, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar startTime = Calendar.getInstance();

        startTime
                .set(Calendar.HOUR_OF_DAY,
                        event.getTimeStartHour());
        startTime
                .set(Calendar.MINUTE,
                        event.getTimeStartMinute());
        startTime.set(Calendar.SECOND, 0);

        // DateUtils.DAY_IN_MILLIS
        alarmMgrStart.setRepeating(AlarmManager.RTC_WAKEUP,
                startTime.getTimeInMillis(), 300000, piStart);

        Intent intentEnd = new Intent(context, ScheduleServiceReceiver.class);
        intentEnd.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, id);
        intentEnd.putExtra(Constant.START_OR_END, Constant.END);
        PendingIntent piEnd = PendingIntent.getBroadcast(context, id * 2 + 1,
                intentEnd, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar endTime = Calendar.getInstance();

        endTime.set(
                Calendar.HOUR_OF_DAY,
                event.getTimeEndHour());
        endTime.set(
                Calendar.MINUTE,
                event.getTimeEndMinute());
        endTime.set(Calendar.SECOND, 0);
        Log.v(this.toString(), "Time Start : " + startTime.getTime().toString()
                + "  \nTime End : " + endTime.getTime().toString());
        // TODO remove Toast
        Toast.makeText(
                context,
                "Time Start : " + startTime.getTime().toString()
                        + "  \nTime End : " + endTime.getTime().toString(),
                Toast.LENGTH_LONG).show();
        // DateUtils.DAY_IN_MILLIS
        alarmMgrEnd.setRepeating(AlarmManager.RTC_WAKEUP,
                endTime.getTimeInMillis(), 300000, piEnd);
    }

    public void cancelSchedule(Context context, Event event) {
        int id = event.getId();
        alarmMgrStart = (AlarmManager) context
                .getSystemService(context.ALARM_SERVICE);

        alarmMgrEnd = (AlarmManager) context
                .getSystemService(context.ALARM_SERVICE);
        Intent intentStart = new Intent(context, ScheduleServiceReceiver.class);
        intentStart.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, id);
        intentStart.putExtra(Constant.START_OR_END, Constant.START);

        PendingIntent piStart = PendingIntent.getBroadcast(context, id * 2,
                intentStart, PendingIntent.FLAG_UPDATE_CURRENT);
        try {
            alarmMgrStart.cancel(piStart);
            Log.v(this.toString(),
                    "cancel alarmManager "
                            + event.getName());
        } catch (Exception e) {
            Log.e(this.toString(),
                    "error alarmManager "
                            + event.getName()
                            + " " + e.getMessage());
        }

        Intent intentEnd = new Intent(context, ScheduleServiceReceiver.class);
        intentEnd.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, id);
        intentEnd.putExtra(Constant.START_OR_END, Constant.END);
        PendingIntent piEnd = PendingIntent.getBroadcast(context, id * 2 + 1,
                intentEnd, PendingIntent.FLAG_UPDATE_CURRENT);
        try {
            alarmMgrEnd.cancel(piEnd);
            // TODO remove Toast
            Toast.makeText(
                    context,
                    "cancel alarmManager "
                            + event.getName(),
                    Toast.LENGTH_LONG).show();
            Log.v(this.toString(),
                    "cancel End alarmManager "
                            + event.getName());
        } catch (Exception e) {
            Log.e(this.toString(),
                    "error alarmManager "
                            + event.getName()
                            + " " + e.getMessage());
        }
    }
}
