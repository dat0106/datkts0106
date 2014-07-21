package com.smartschedule;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.content.ActivityNotFoundException;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartschedule.action.wifihotspotutils.WifiApManager;
import com.smartschedule.database.Action;
import com.smartschedule.database.Event;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.utils.Constant;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.media.AudioManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class SchedulingService extends IntentService {
    private NotificationManager mNotificationManager;
    private SmartSchedulerDatabase database = new SmartSchedulerDatabase(this);
    private Event event;
    private ArrayList<Action> actions;
    private PackageManager packageManager;

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

        String check_start_end = intent.getExtras().getString(
                Constant.START_OR_END);

        database.open();
        event = database.getData(event_id);
        actions = database.getDataAction(event_id, check_start_end);

        for (int i = 0; i < actions.size(); i++) {
            switch (actions.get(i).getState()) {
            case Constant.ROUTER_SOUND_MANAGER:
                doingVolume(actions.get(i));
                break;
            case Constant.ROUTER_WIFI:
                doingWifi(actions.get(i));
                break;
            case Constant.ROUTER_WIFI_HOTSPOT:
                doingWifiHotspot(actions.get(i));
                break;

            case Constant.ROUTER_BLUETOOTH:
                doingBlueTooth(actions.get(i));
                doingManagerPlayer(actions.get(i));
                break;
            default:
                break;
            }
        }

        database.close();

        String name = event.getName();
        sendNotification("lập lịch làm việc " + name + ": " + check_start_end
                + "id", event_id);
        Log.i(this.toString(),
                "Completed service @ " + SystemClock.elapsedRealtime());
        ScheduleServiceReceiver.completeWakefulIntent(intent);

    }

    private void doingBlueTooth(Action action) {

        String draw = action.getDrawAction();

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        DrawAction drawAction = gson.fromJson(draw, DrawAction.class);

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        if(Boolean.valueOf(drawAction.bluetooth_mode)) {
            adapter.enable();
        } else{
            adapter.disable();
        }
    }

    private void doingWifiHotspot(Action action) {

        String draw = action.getDrawAction();

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        DrawAction drawAction = gson.fromJson(draw, DrawAction.class);

        WifiApManager wifiApManager = new WifiApManager(this);
        wifiApManager.setWifiApEnabled(null, Boolean.valueOf(drawAction.wifi_hotspot_mode));

    }

    private void doingWifi(Action action) {

        String draw = action.getDrawAction();

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        DrawAction drawAction = gson.fromJson(draw, DrawAction.class);

        WifiManager mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        mainWifi.setWifiEnabled(Boolean.valueOf(drawAction.wifi_mode));

    }

    private void doingVolume(Action action) {

        String draw = action.getDrawAction();

        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();
        DrawAction drawAction = gson.fromJson(draw, DrawAction.class);
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
        // TODO kiem tra Android setStreamVolume for STREAM_RING doesn't always
        // work while RINGING
        // den app khac ko

        audio.setRingerMode(Integer.parseInt(drawAction.sound_mode));

        if (drawAction.sound_ring != null) {
            audio.setStreamVolume(AudioManager.STREAM_RING,
                    Integer.parseInt(drawAction.sound_ring),
                    AudioManager.FLAG_SHOW_UI);
            audio.setStreamVolume(AudioManager.STREAM_MUSIC,
                    Integer.parseInt(drawAction.sound_music),
                    AudioManager.FLAG_SHOW_UI);
            audio.setStreamVolume(AudioManager.STREAM_ALARM,
                    Integer.parseInt(drawAction.sound_alarm),
                    AudioManager.FLAG_SHOW_UI);
            audio.setStreamVolume(AudioManager.STREAM_NOTIFICATION,
                    Integer.parseInt(drawAction.sound_notification),
                    AudioManager.FLAG_SHOW_UI);
            audio.setStreamVolume(AudioManager.STREAM_SYSTEM,
                    Integer.parseInt(drawAction.sound_system),
                    AudioManager.FLAG_SHOW_UI);
            audio.setStreamVolume(AudioManager.STREAM_VOICE_CALL,
                    Integer.parseInt(drawAction.sound_voice_call),
                    AudioManager.FLAG_SHOW_UI);
        }
        // audio.setStreamVolume(AudioManager.STREAM_DTMF, 3,
        // AudioManager.FLAG_SHOW_UI);

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
        currentVolumeMusic = audio
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        currentVolumeAlarm = audio
                .getStreamMaxVolume(AudioManager.STREAM_ALARM);
        currentVolumeNotification = audio
                .getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION);
        currentVolumeSystem = audio
                .getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
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

    Context my_service = this;

    private TimerTask my_TimerTask = new TimerTask() {
        public void run() {
            Log.w("hello", "my name is Nicolas" + String.valueOf( SystemClock.uptimeMillis() ) );
            packageManager = my_service.getPackageManager();
            Log.w("hello", "my name is Nicolas" + String.valueOf(packageManager));
        }
    };


    int i = 0;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Timer my_timer = new Timer("automated launchemy loop",true);
        if(i==0){
            i=1;
            my_timer.schedule(my_TimerTask, 0, 5000);
        }
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private void doingManagerPlayer(Action action) {


        Log.v(this.toString(), "vaoday");
        List<ApplicationInfo> applist = checkForLaunchIntent(
                packageManager.getInstalledApplications(PackageManager.GET_META_DATA));
        ApplicationInfo app = applist.get(1);

        Log.v(this.toString(), app.loadLabel(packageManager) + " (" + app.packageName + ")");
//        iconview.setImageDrawable(data.loadIcon(packageManager));
        try
        {
            Intent intent = packageManager.getLaunchIntentForPackage(app.packageName);

            if(null != intent)
            {
                startActivity(intent);
            }
        }
        catch (ActivityNotFoundException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private List<ApplicationInfo> checkForLaunchIntent(List<ApplicationInfo> list)
    {
        ArrayList<ApplicationInfo> applist = new ArrayList<ApplicationInfo>();

        for(ApplicationInfo info: list)
        {
            try {
                if(null != packageManager.getLaunchIntentForPackage(info.packageName))
                {
                    applist.add(info);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return applist;
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
        Intent intent = new Intent(this, EventTimeActivity.class);
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