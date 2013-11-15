package com.example.smartsystem;

import com.smartsystem.database.SmartSystemDatabase;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class SampleSchedulingService extends IntentService{
    private NotificationManager mNotificationManager;
    private int count = 0 ;
    private SmartSystemDatabase database = new SmartSystemDatabase(this);
    public SampleSchedulingService() {
        super("SchedulingService");
    }

    public static final String TAG = "SampleSchedulingService";

    public static final int NOTIFICATION_ID = 1;

    @Override
    protected void onHandleIntent(Intent intent) {
        count++;
        database.open();
        database.createData(count);
        database.close();
        sendNotification("lập lịch làm việc ");
        
    }

    private void sendNotification(String msg) {
        database.open();
        String[] ds = database.getCountData();
        database.close();

        msg  =  msg +  ds[0];

        mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);

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