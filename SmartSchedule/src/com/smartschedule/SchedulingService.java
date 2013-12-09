package com.smartschedule;

import java.util.jar.Attributes.Name;

import com.smartschedule.database.SmartSchedulerDatabase;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class SchedulingService extends IntentService{
    private NotificationManager mNotificationManager;
    private int count = 0 ;
    private SmartSchedulerDatabase database = new SmartSchedulerDatabase(this);
	private ContentValues contentValue;
    public SchedulingService() {
        super("SchedulingService");
    }

    public static final String TAG = "SampleSchedulingService";

    public static final int NOTIFICATION_ID = 1;

    @Override
    protected void onHandleIntent(Intent intent) {
        count++;

        int event_id = intent.getExtras().getInt(SmartSchedulerDatabase.COLUMN_EVENT_ID);

        int check_start_end = intent.getExtras().getInt("check_start_end");

        database.open();
        contentValue = database.getData(event_id);
        database.close();

        String name = contentValue.getAsString(SmartSchedulerDatabase.COLUMN_EVENT_NAME);
        sendNotification("lập lịch làm việc " + name + ": " + check_start_end  +  "id", event_id);

        doing(check_start_end);

    }

    private void doing(int check_start_end) {

    	WifiManager mainWifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
		if (check_start_end == 1) {
			mainWifi.setWifiEnabled(true);
		} else {
			mainWifi.setWifiEnabled(false);
		}
	}

	private void sendNotification(String msg, int event_id) {
//        database.open();
//        String[] ds = database.getCountData();
//        database.close();
//
//        msg  =  msg +  ds[0];

        mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

        // TODO make again event activity
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