package com.smartschedule;

import java.util.jar.Attributes.Name;

import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.database.SmartSystemDatabase;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class SchedulingService extends IntentService{
    private NotificationManager mNotificationManager;
    private int count = 0 ;
    private SmartSystemDatabase database = new SmartSystemDatabase(this);
    public SchedulingService() {
        super("SchedulingService");
    }

    public static final String TAG = "SampleSchedulingService";

    public static final int NOTIFICATION_ID = 1;

    @Override
    protected void onHandleIntent(Intent intent) {
        count++;

        int event_id = intent.getExtras().getInt(SmartSchedulerDatabase.COLUMN_EVENT_ID);
        String name = intent.getExtras().getString(SmartSchedulerDatabase.COLUMN_EVENT_NAME);
        int check_start_end = intent.getExtras().getInt("check_start_end");

        database.open();
        database.createData(count);
        database.close();
        sendNotification("lập lịch làm việc " + name + ": " + check_start_end  +  "id", event_id);

    }

    private void sendNotification(String msg, int event_id) {
        database.open();
        String[] ds = database.getCountData();
        database.close();

        msg  =  msg +  ds[0];

        mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, EventActivity.class);
        intent.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, event_id);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.ic_launcher)
        .setContentTitle(getString(R.string.app_name))
        .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
        .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());

    }
}