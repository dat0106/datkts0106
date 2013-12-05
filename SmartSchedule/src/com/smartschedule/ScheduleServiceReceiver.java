package com.smartschedule;

import java.util.ArrayList;
import java.util.Calendar;

import com.smartschedule.database.SmartSchedulerDatabase;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.Toast;

public class ScheduleServiceReceiver extends WakefulBroadcastReceiver {
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    private ArrayList<PendingIntent> intentArray;
    private AlarmManager[] alarmManager;

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent service = new Intent(context, SchedulingService.class);

        startWakefulService(context, service);

    }

    public void setAlarm(Context context) {
        alarmManager = new AlarmManager[24];
        intentArray = new ArrayList<PendingIntent>();
        for (int i = 0; i < 2; i++) {
            alarmManager[i] = (AlarmManager) context
                    .getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(context, ScheduleServiceReceiver.class);
            // use Pending Intent for sent signal - send broadcast
            PendingIntent pi = PendingIntent.getBroadcast(context, i, intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            // alarmManager[i].set(AlarmManager.RTC_WAKEUP,
            // System.currentTimeMillis() + 5000* i ,pi);

            alarmManager[i].setRepeating(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis() + 5000 * i, 60000, pi);

            intentArray.add(pi);
            // // for each 15 min
            // alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
            // AlarmManager.INTERVAL_FIFTEEN_MINUTES,
            // AlarmManager.INTERVAL_FIFTEEN_MINUTES, alarmIntent);
        }
        // chua dung den
        // ComponentName receiver = new ComponentName(context,
        // SampleBootReceiver.class);
        // PackageManager pm = context.getPackageManager();
        //
        // pm.setComponentEnabledSetting(receiver,
        // PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        // PackageManager.DONT_KILL_APP);
    }

    public void cancelAlarm(Context context) {

        alarmManager = new AlarmManager[24];
        for (int i = 0; i < 10; i++) {
            alarmManager[i] = (AlarmManager) context
                    .getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(context, ScheduleServiceReceiver.class);

            // use;l Pending Intent for sent signal - send broadcast
            PendingIntent pi = PendingIntent
                    .getBroadcast(context, i, intent, 0);
            try {
                alarmManager[i].cancel(pi);
                Log.v("ScheduleServiceReceiver", "cancel alarmManager " + i);
            } catch (Exception e) {
                Log.e("ScheduleServiceReceiver", "error alarmManager " + i
                        + " " + e.getMessage());
            }

        }
        // Disable {@code SampleBootReceiver} so that it doesn't automatically
        // restart the
        // alarm when the device is rebooted.
        ComponentName receiver = new ComponentName(context,
                SampleBootReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);

    }

    public void setSchedule(Context context, ContentValues contentValues) {
        int id = contentValues
                .getAsInteger(SmartSchedulerDatabase.COLUMN_EVENT_ID);
        alarmMgr = (AlarmManager) context
                .getSystemService(context.ALARM_SERVICE);
        Intent intentStart = new Intent(context, ScheduleServiceReceiver.class);
        intentStart.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, id);
        intentStart.putExtra("check_start_end", 0);

        PendingIntent piStart = PendingIntent.getBroadcast(context, id * 2,
                intentStart, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar startTime = Calendar.getInstance();

        startTime
                .set(Calendar.HOUR_OF_DAY,
                        contentValues
                                .getAsInteger(SmartSchedulerDatabase.COLUMN_EVENT_TIME_START_HOUR));
        startTime
                .set(Calendar.MINUTE,
                        contentValues
                                .getAsInteger(SmartSchedulerDatabase.COLUMN_EVENT_TIME_START_MINUTE));
        startTime.set(Calendar.SECOND, 0);

        // DateUtils.DAY_IN_MILLIS
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP,
                startTime.getTimeInMillis(), 300000, piStart);

        Intent intentEnd = new Intent(context, ScheduleServiceReceiver.class);
        intentEnd.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, id);
        intentEnd.putExtra("check_start_end", 1);
        PendingIntent piEnd = PendingIntent.getBroadcast(context, id * 2 + 1,
                intentEnd, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar endTime = Calendar.getInstance();

        endTime.set(
                Calendar.HOUR_OF_DAY,
                contentValues
                        .getAsInteger(SmartSchedulerDatabase.COLUMN_EVENT_TIME_END_HOUR));
        endTime.set(
                Calendar.MINUTE,
                contentValues
                        .getAsInteger(SmartSchedulerDatabase.COLUMN_EVENT_TIME_END_MINUTE));
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
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP,
                endTime.getTimeInMillis(), 300000, piEnd);
    }

    public void cancelSchedule(Context context, ContentValues contentValues) {
        int id = contentValues
                .getAsInteger(SmartSchedulerDatabase.COLUMN_EVENT_ID);
        alarmMgr = (AlarmManager) context
                .getSystemService(context.ALARM_SERVICE);
        Intent intentStart = new Intent(context, ScheduleServiceReceiver.class);
        intentStart.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, id);
        intentStart.putExtra("check_start_end", 0);

        PendingIntent piStart = PendingIntent.getBroadcast(context, id * 2,
                intentStart, PendingIntent.FLAG_UPDATE_CURRENT);
        try {
            alarmMgr.cancel(piStart);
            Log.v(this.toString(),
                    "cancel alarmManager "
                            + contentValues
                                    .getAsString(SmartSchedulerDatabase.COLUMN_EVENT_NAME));
        } catch (Exception e) {
            Log.e(this.toString(),
                    "error alarmManager "
                            + contentValues
                                    .getAsString(SmartSchedulerDatabase.COLUMN_EVENT_NAME)
                            + " " + e.getMessage());
        }

        Intent intentEnd = new Intent(context, ScheduleServiceReceiver.class);
        intentEnd.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, id);
        intentEnd.putExtra("check_start_end", 1);
        PendingIntent piEnd = PendingIntent.getBroadcast(context, id * 2 + 1,
                intentEnd, PendingIntent.FLAG_UPDATE_CURRENT);
        try {
            alarmMgr.cancel(piEnd);
            // TODO remove Toast
            Toast.makeText(
                    context,
                    "cancel alarmManager "
                            + contentValues
                                    .getAsString(SmartSchedulerDatabase.COLUMN_EVENT_NAME),
                    Toast.LENGTH_LONG).show();
            Log.v(this.toString(),
                    "cancel End alarmManager "
                            + contentValues
                                    .getAsString(SmartSchedulerDatabase.COLUMN_EVENT_NAME));
        } catch (Exception e) {
            Log.e(this.toString(),
                    "error alarmManager "
                            + contentValues
                                    .getAsString(SmartSchedulerDatabase.COLUMN_EVENT_NAME)
                            + " " + e.getMessage());
        }
    }
}
