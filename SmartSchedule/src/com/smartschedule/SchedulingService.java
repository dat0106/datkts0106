package com.smartschedule;

import java.util.jar.Attributes.Name;

import com.smartschedule.database.Event;
import com.smartschedule.database.SmartSchedulerDatabase;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class SchedulingService extends IntentService {
    private NotificationManager mNotificationManager;
    private SmartSchedulerDatabase database = new SmartSchedulerDatabase(this);
    private Event contentValue;

    public SchedulingService() {
        super("SchedulingService");
    }

    public static final String TAG = "SampleSchedulingService";

    public static final int NOTIFICATION_ID = 1;

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i(this.toString(),
                "Start service @ " + SystemClock.elapsedRealtime());
        // count++;

        int event_id = intent.getExtras().getInt(
                SmartSchedulerDatabase.COLUMN_EVENT_ID);

        int check_start_end = intent.getExtras().getInt("check_start_end");

        database.open();
        contentValue = database.getData(event_id);
        database.close();

        String name = contentValue.getName();
        sendNotification("lập lịch làm việc " + name + ": " + check_start_end
                + "id", event_id);

        doingWifi(check_start_end);
        doingVolume();

        Log.i(this.toString(),
                "Completed service @ " + SystemClock.elapsedRealtime());
        ScheduleServiceReceiver.completeWakefulIntent(intent);

    }

    private void doingWifi(int check_start_end) {

        WifiManager mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        if (check_start_end == 1) {
            mainWifi.setWifiEnabled(true);
        } else {
            mainWifi.setWifiEnabled(false);
        }
    }

    private void doingVolume() {
        AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int currentVolumeRing = audio.getStreamVolume(AudioManager.STREAM_RING);
        int currentVolumeMusic = audio
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        int currentVolumeAlarm = audio
                .getStreamVolume(AudioManager.STREAM_ALARM);
        int currentVolumeNotification = audio
                .getStreamVolume(AudioManager.STREAM_NOTIFICATION);
        int currentVolumeSystem = audio
                .getStreamVolume(AudioManager.STREAM_SYSTEM);
        int currentVolumeVoiceCall = audio
                .getStreamVolume(AudioManager.STREAM_VOICE_CALL);
        int currentVolumeDTMF = audio.getStreamVolume(AudioManager.STREAM_DTMF);

        Log.i(this.toString(), "Volume default:  \n" + "STREAM_RING : "
                + currentVolumeRing + "\n" + "STREAM_MUSIC : "
                + currentVolumeMusic + "\n" + "STREAM_ALARM : "
                + currentVolumeAlarm + "\n" + "STREAM_NOTIFICATION : "
                + currentVolumeNotification + "\n" + "STREAM_SYSTEM : "
                + currentVolumeSystem + "\n" + "STREAM_VOICE_CALL : "
                + currentVolumeVoiceCall + "\n" + "STREAM_DTMF : "
                + currentVolumeDTMF + "\n"

        );

        // TODO Chu y neu kiem tra co can thiet phai show toast ko. anh huong
        // TODO kiem tra Android setStreamVolume for STREAM_RING doesn't always work while RINGING
        // den app khac ko
//        audio.setStreamVolume(AudioManager.STREAM_RING, 1,
//                AudioManager.FLAG_SHOW_UI);
        audio.setStreamVolume(AudioManager.STREAM_MUSIC, 3,
                AudioManager.FLAG_SHOW_UI);
        audio.setStreamVolume(AudioManager.STREAM_ALARM, 3,
                AudioManager.FLAG_SHOW_UI);
        audio.setStreamVolume(AudioManager.STREAM_NOTIFICATION, 3,
                AudioManager.FLAG_SHOW_UI);
        audio.setStreamVolume(AudioManager.STREAM_SYSTEM, 3,
                AudioManager.FLAG_SHOW_UI);
        audio.setStreamVolume(AudioManager.STREAM_VOICE_CALL, 3,
                AudioManager.FLAG_SHOW_UI);
        audio.setStreamVolume(AudioManager.STREAM_DTMF, 3,
                AudioManager.FLAG_SHOW_UI);

        currentVolumeRing = audio.getStreamVolume(AudioManager.STREAM_RING);
        currentVolumeMusic = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        currentVolumeAlarm = audio.getStreamVolume(AudioManager.STREAM_ALARM);
        currentVolumeNotification = audio
                .getStreamVolume(AudioManager.STREAM_NOTIFICATION);
        currentVolumeSystem = audio.getStreamVolume(AudioManager.STREAM_SYSTEM);
        currentVolumeVoiceCall = audio
                .getStreamVolume(AudioManager.STREAM_VOICE_CALL);
        currentVolumeDTMF = audio.getStreamVolume(AudioManager.STREAM_DTMF);

        Log.i(this.toString(), "Volume set:  \n" + "STREAM_RING : "
                + currentVolumeRing + "\n" + "STREAM_MUSIC : "
                + currentVolumeMusic + "\n" + "STREAM_ALARM : "
                + currentVolumeAlarm + "\n" + "STREAM_NOTIFICATION : "
                + currentVolumeNotification + "\n" + "STREAM_SYSTEM : "
                + currentVolumeSystem + "\n" + "STREAM_VOICE_CALL : "
                + currentVolumeVoiceCall + "\n" + "STREAM_DTMF : "
                + currentVolumeDTMF + "\n"

        );

        currentVolumeRing = audio.getStreamMaxVolume(AudioManager.STREAM_RING);
        currentVolumeMusic = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        currentVolumeAlarm = audio.getStreamMaxVolume(AudioManager.STREAM_ALARM);
        currentVolumeNotification = audio
                .getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION);
        currentVolumeSystem = audio.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
        currentVolumeVoiceCall = audio
                .getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL);
        currentVolumeDTMF = audio.getStreamMaxVolume(AudioManager.STREAM_DTMF);

        Log.i(this.toString(), "Volume Max:  \n" + "STREAM_RING : "
                + currentVolumeRing + "\n" + "STREAM_MUSIC : "
                + currentVolumeMusic + "\n" + "STREAM_ALARM : "
                + currentVolumeAlarm + "\n" + "STREAM_NOTIFICATION : "
                + currentVolumeNotification + "\n" + "STREAM_SYSTEM : "
                + currentVolumeSystem + "\n" + "STREAM_VOICE_CALL : "
                + currentVolumeVoiceCall + "\n" + "STREAM_DTMF : "
                + currentVolumeDTMF + "\n"

        );

    }

    private void sendNotification(String msg, int event_id) {
        // database.open();
        // String[] ds = database.getCountData();
        // database.close();
        //
        // msg = msg + ds[0];

        mNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        // TODO make again event activity
        Intent intent = new Intent(this, EventActivity.class);
        intent.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, event_id);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                this).setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(getString(R.string.app_name))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());

    }
}