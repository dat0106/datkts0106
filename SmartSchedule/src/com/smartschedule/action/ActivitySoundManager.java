package com.smartschedule.action;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartschedule.DrawAction;
import com.smartschedule.EventTimeActivity;
import com.smartschedule.R;
import com.smartschedule.database.Action;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.utils.Constant;
import com.smartschedule.utils.MiscUtils;

public class ActivitySoundManager extends Activity {

    private SmartSchedulerDatabase smartScheduleDb = new SmartSchedulerDatabase(
            this);

    private int event_id;
    Action action;
    private ContentValues contentValues;
    private int mRingerMode = -1;
    private RadioButton radioNormal;
    private RadioButton radioVibrate;
    private RadioButton radioSilent;

    private Button alarmRingtone;
    private Button phoneRingtone;
    private Button notificationRingtone;

    private ToggleButton advancedSound;

    private SeekBar music;
    private TextView musicProgress;
    private Uri notificationRingtoneUri;
    private Uri phoneRingtoneUri;
    private Uri alarmRingtoneUri;
    private SeekBar ringer;
    private TextView ringerProgress;
    private SeekBar system;
    private TextView systemProgress;

    private SeekBar voice;
    private TextView voiceProgress;

    private SeekBar alarm;
    private TextView alarmProgress;

    private SeekBar alert;
    private TextView alertProgress;
    private AudioManager am;

    int musicNum;
    int notificationNum;
    int alarmNum;
    int systemNum;
    int voiceCallNum;
    int ringNum;
    protected boolean checkAdvancedSound;
    Gson gson;
    DrawAction pst;
    private String start_or_end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_manager);

        this.radioNormal = (RadioButton) findViewById(R.id.radio_normal);

        this.radioVibrate = (RadioButton) findViewById(R.id.radio_vibrate);
        this.radioSilent = (RadioButton) findViewById(R.id.radio_silent);
        this.alarmRingtone = ((Button) findViewById(R.id.alarmRingtone));
        this.phoneRingtone = ((Button) findViewById(R.id.phoneRingtone));
        this.notificationRingtone = ((Button) findViewById(R.id.notificationRingtone));
        this.advancedSound = (ToggleButton) findViewById(R.id.advanced_sound);
        this.alarm = ((SeekBar) findViewById(R.id.alarm));
        this.music = ((SeekBar) findViewById(R.id.music));
        this.alert = ((SeekBar) findViewById(R.id.alerts));
        this.ringer = ((SeekBar) findViewById(R.id.ringer));
        this.system = ((SeekBar) findViewById(R.id.system));
        this.voice = ((SeekBar) findViewById(R.id.voice));
        // this.am = ((AudioManager)getSystemService("audio"));
        // this.vibe = ((Vibrator)getSystemService("vibrator"));
        this.alarmProgress = ((TextView) findViewById(R.id.alarmLvl));
        this.musicProgress = ((TextView) findViewById(R.id.musicLvl));
        this.alertProgress = ((TextView) findViewById(R.id.alertLvl));
        this.ringerProgress = ((TextView) findViewById(R.id.ringerLvl));
        this.systemProgress = ((TextView) findViewById(R.id.systemLvl));
        this.voiceProgress = ((TextView) findViewById(R.id.voiceLvl));

        this.alarmRingtone = ((Button) findViewById(R.id.alarmRingtone));
        this.phoneRingtone = ((Button) findViewById(R.id.phoneRingtone));
        this.notificationRingtone = ((Button) findViewById(R.id.notificationRingtone));
        am = (AudioManager) getSystemService(ActivitySoundManager.this.AUDIO_SERVICE);

        Intent intent = getIntent();
        this.event_id = intent.getExtras().getInt(
                SmartSchedulerDatabase.COLUMN_EVENT_ID);
        action = intent.getExtras().getParcelable(Constant.ACTION_PARAMS);
        start_or_end = intent.getExtras().getString(Constant.START_OR_END);

        // final SeekBar textView = (SeekBar) View
        // .findViewById(R.id.dialog_add_event);

        Typeface localTypeface = null;
        if (Build.VERSION.SDK_INT >= 4) {
            localTypeface = MiscUtils.CreateTypefaceFromRawResource(
                    ActivitySoundManager.this, R.raw.digital);
        }

        // this.toggleSilent =
        // ((ToggleButton)findViewById(R.id.toggleSilent));
        // this.mToggleVibe =
        // ((ToggleButton)findViewById(R.id.ToggleButtonVibe));
        // this.mButtonVibe = ((Button)findViewById(R.id.ButtonVibe));
        // this.saveButton = ((Button)findViewById(R.id.saveButton));
        // this.cancelButton = ((Button)findViewById(R.id.cancelButton));

        if (localTypeface != null) {
            this.alarmProgress.setTypeface(localTypeface);
            this.musicProgress.setTypeface(localTypeface);
            this.alertProgress.setTypeface(localTypeface);
            this.ringerProgress.setTypeface(localTypeface);
            this.systemProgress.setTypeface(localTypeface);
            this.voiceProgress.setTypeface(localTypeface);
        }

        this.advancedSound.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (advancedSound.isChecked()) {
                    checkAdvancedSound = true;
                    disable_or_enable_advanced_sound(checkAdvancedSound);

                } else {
                    checkAdvancedSound = false;
                    disable_or_enable_advanced_sound(checkAdvancedSound);
                }
            }

        });

        this.alarmRingtone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {

                Intent localIntent = new Intent(
                        RingtoneManager.ACTION_RINGTONE_PICKER);
                // localIntent.putExtra("android.intent.extra.ringtone.TITLE",
                // ActivitySoundManager.this.getText(R.string.alarm_ringtone));
                // localIntent.putExtra(
                // RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT,
                // true);
                localIntent.putExtra(
                        RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true);
                localIntent.putExtra(
                        RingtoneManager.EXTRA_RINGTONE_DEFAULT_URI,
                        Settings.System.DEFAULT_ALARM_ALERT_URI);
                localIntent.putExtra(
                        RingtoneManager.EXTRA_RINGTONE_EXISTING_URI,
                        ActivitySoundManager.this.alarmRingtoneUri);
                localIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE,
                        RingtoneManager.TYPE_ALARM);
                ActivitySoundManager.this.startActivityForResult(localIntent,
                        1002);
            }
        });
        this.phoneRingtone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                Intent localIntent = new Intent(
                        RingtoneManager.ACTION_RINGTONE_PICKER);
                // localIntent.putExtra("android.intent.extra.ringtone.TITLE",
                // ActivitySoundManager.this.getText(R.string.phone_ringtone));
                // localIntent.putExtra(
                // RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT,
                // true);
                localIntent.putExtra(
                        RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true);
                localIntent.putExtra(
                        RingtoneManager.EXTRA_RINGTONE_DEFAULT_URI,
                        Settings.System.DEFAULT_RINGTONE_URI);
                localIntent.putExtra(
                        RingtoneManager.EXTRA_RINGTONE_EXISTING_URI,
                        ActivitySoundManager.this.phoneRingtoneUri);
                localIntent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE,
                        RingtoneManager.TYPE_RINGTONE);
                ActivitySoundManager.this.startActivityForResult(localIntent,
                        1000);
            }
        });
        this.notificationRingtone
                .setOnClickListener(new View.OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        Intent localIntent = new Intent(
                                RingtoneManager.ACTION_RINGTONE_PICKER);
                        // localIntent.putExtra("android.intent.extra.ringtone.TITLE",
                        // ActivitySoundManager.this.getText(R.string.notification_ringtone));
                        // localIntent.putExtra(
                        // RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT,
                        // true);
                        localIntent.putExtra(
                                RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT,
                                true);
                        localIntent.putExtra(
                                RingtoneManager.EXTRA_RINGTONE_DEFAULT_URI,
                                Settings.System.DEFAULT_NOTIFICATION_URI);
                        localIntent
                                .putExtra(
                                        RingtoneManager.EXTRA_RINGTONE_EXISTING_URI,
                                        ActivitySoundManager.this.notificationRingtoneUri);
                        localIntent.putExtra(
                                "android.intent.extra.ringtone.TYPE",
                                RingtoneManager.TYPE_NOTIFICATION);
                        ActivitySoundManager.this.startActivityForResult(
                                localIntent, 1001);
                    }
                });

        this.music
                .setMax(this.am.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        this.alarm
                .setMax(this.am.getStreamMaxVolume(AudioManager.STREAM_ALARM));
        this.alert.setMax(this.am
                .getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION));
        this.system.setMax(this.am
                .getStreamMaxVolume(AudioManager.STREAM_SYSTEM));
        this.voice.setMax(this.am
                .getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL));
        // TODO Co loi version
        this.ringer
                .setMax(this.am.getStreamMaxVolume(AudioManager.STREAM_RING));
        setSeekBarListeners();

        GsonBuilder gsonb = new GsonBuilder();
        gson = gsonb.create();
        if(action == null) {
            pst = gson.fromJson("{}", DrawAction.class);
        } else {
            pst = gson.fromJson(action.getDrawAction(), DrawAction.class);
        }

        // Intent cv = new Intent();
        //
        // cv.putExtra("fuck", pst);
        //
        // DrawAction pst1 = cv.getExtras().getParcelable("fuck");
        //
        // Log.d("TAggeD", pst1.ringtone_alarm + pst1.rimgtome_ringer);
        //
        // Log.d("TAGGED", gson.toJson(pst1));

        updateUI();

    }

    private void setRingtone() {
        if (pst.ringtone_notification == null) {
            notificationRingtoneUri = RingtoneManager
                    .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        } else {
            notificationRingtoneUri = Uri.parse(pst.ringtone_notification);
        }

        getTitleForRingtone(RingtoneManager.TYPE_NOTIFICATION,
                notificationRingtoneUri, notificationRingtone);

        if (pst.ringtone_alarm == null) {
            alarmRingtoneUri = RingtoneManager
                    .getDefaultUri(RingtoneManager.TYPE_ALARM);
        } else {
            alarmRingtoneUri = Uri.parse(pst.ringtone_alarm);
        }

        getTitleForRingtone(RingtoneManager.TYPE_ALARM, alarmRingtoneUri,
                alarmRingtone);

        if (pst.rimgtone_ringer == null) {
            phoneRingtoneUri = RingtoneManager
                    .getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        } else {
            phoneRingtoneUri = Uri.parse(pst.rimgtone_ringer);
        }

        getTitleForRingtone(RingtoneManager.TYPE_RINGTONE, phoneRingtoneUri,
                phoneRingtone);

    }

    protected void onActivityResult(int paramInt1, int paramInt2,
            Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if (paramInt2 == -1) {
            Uri localUri = (Uri) paramIntent
                    .getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);

            // chay ok
            // Uri ringer = Uri.parse(part);
            // Ringtone r2 =
            // RingtoneManager.getRingtone(getApplicationContext(), ringer);
            //
            // RingtoneManager.setActualDefaultRingtoneUri(getApplicationContext(),
            // RingtoneManager.TYPE_NOTIFICATION, ringer);
            // r2.play();
            switch (paramInt1) {
            case 1000:
                this.phoneRingtoneUri = localUri;
                getTitleForRingtone(RingtoneManager.TYPE_RINGTONE, localUri,
                        this.phoneRingtone);
                break;
            case 1001:
                this.notificationRingtoneUri = localUri;
                getTitleForRingtone(RingtoneManager.TYPE_NOTIFICATION,
                        localUri, this.notificationRingtone);
                break;
            case 1002:
                this.alarmRingtoneUri = localUri;
                getTitleForRingtone(RingtoneManager.TYPE_ALARM, localUri,
                        this.alarmRingtone);
            }
        }
    }

    private void getTitleForRingtone(int paramInt, Uri paramUri,
            TextView paramTextView) {
        String localObject2;
        Ringtone localObject1 = null;
        localObject1 = RingtoneManager.getRingtone(this, paramUri);

        localObject2 = localObject1.getTitle(this);

        Log.v(ActivitySoundManager.this.toString(), (String) localObject2);
        paramTextView.setText(localObject2);
        return;

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
        case R.id.radio_normal:
            if (checked) {
                mRingerMode = AudioManager.RINGER_MODE_NORMAL;
                updateNormal(notificationNum, ringNum, systemNum);
            }
            break;
        case R.id.radio_vibrate:
            if (checked) {
                mRingerMode = AudioManager.RINGER_MODE_VIBRATE;

                updateVibrateOrSilent();
            }
            break;
        case R.id.radio_silent:
            if (checked) {
                mRingerMode = AudioManager.RINGER_MODE_SILENT;

                updateVibrateOrSilent();
            }
            break;
        }
    }

    private void updateUI() {

        if (pst.sound_mode == null) {
            mRingerMode = am.getRingerMode();
        } else {
            mRingerMode = Integer.parseInt(pst.sound_mode);
        }
        switch (mRingerMode) {
        case 0:
            radioSilent.setChecked(true);
            break;
        case 1:
            radioVibrate.setChecked(true);
            break;
        case 2:
            radioNormal.setChecked(true);
            break;
        default:
            break;
        }

        if (pst.sound_music == null) {
            musicNum = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        } else {
            musicNum = Integer.parseInt(pst.sound_music);
        }

        if (pst.sound_notification == null) {
            notificationNum = am
                    .getStreamVolume(AudioManager.STREAM_NOTIFICATION);
        } else {
            notificationNum = Integer.parseInt(pst.sound_notification);
        }

        if (pst.sound_alarm == null) {
            alarmNum = am.getStreamVolume(AudioManager.STREAM_ALARM);
        } else {
            alarmNum = Integer.parseInt(pst.sound_alarm);
        }

        if (pst.sound_system == null) {
            systemNum = am.getStreamVolume(AudioManager.STREAM_SYSTEM);
        } else {
            systemNum = Integer.parseInt(pst.sound_system);
        }
        if (pst.sound_voice_call == null) {
            voiceCallNum = am.getStreamVolume(AudioManager.STREAM_VOICE_CALL);
        } else {
            voiceCallNum = Integer.parseInt(pst.sound_voice_call);
        }
        if (pst.sound_ring == null) {
            ringNum = am.getStreamVolume(AudioManager.STREAM_RING);
        } else {
            ringNum = Integer.parseInt(pst.sound_ring);
        }

        setRingtone();
        if (pst.sound_ring == null || pst.sound_alarm == null
                || pst.sound_music == null || pst.sound_notification == null
                || pst.sound_system == null || pst.sound_voice_call == null) {
            checkAdvancedSound = false;

        } else {
            checkAdvancedSound = true;
        }
        advancedSound.setChecked(checkAdvancedSound);;
        disable_or_enable_advanced_sound(checkAdvancedSound);
        this.music.setProgress(musicNum);
        this.alert.setProgress(notificationNum);
        this.alarm.setProgress(alarmNum);
        this.system.setProgress(systemNum);
        this.voice.setProgress(voiceCallNum);
        this.musicProgress.setText("" + musicNum + "/" + ""
                + this.am.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        this.alertProgress.setText("" + notificationNum + "/" + ""
                + this.am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION));
        this.systemProgress.setText("" + alarmNum + "/" + ""
                + this.am.getStreamMaxVolume(AudioManager.STREAM_ALARM));
        this.alarmProgress.setText("" + systemNum + "/" + ""
                + this.am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM));
        this.voiceProgress.setText("" + voiceCallNum + "/" + ""
                + this.am.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL));

        if (this.mRingerMode != 2) {
            updateVibrateOrSilent();
        } else {
            updateNormal(notificationNum, ringNum, systemNum);
        }
        // setPressedStates();
    }

    private void setSeekBarListeners() {
        this.voice.setOnSeekBarChangeListener(new OnAudioSeekBarListener(
                AudioManager.STREAM_VOICE_CALL, this.voiceProgress));
        this.system.setOnSeekBarChangeListener(new OnAudioSeekBarListener(
                AudioManager.STREAM_SYSTEM, this.systemProgress));

        this.ringer.setOnSeekBarChangeListener(new OnAudioSeekBarListener(
                AudioManager.STREAM_RING, this.ringerProgress));

        this.music.setOnSeekBarChangeListener(new OnAudioSeekBarListener(
                AudioManager.STREAM_MUSIC, this.musicProgress));
        this.alarm.setOnSeekBarChangeListener(new OnAudioSeekBarListener(
                AudioManager.STREAM_ALARM, this.alarmProgress));
        this.alert.setOnSeekBarChangeListener(new OnAudioSeekBarListener(
                AudioManager.STREAM_NOTIFICATION, this.alertProgress));
    }

    private class OnAudioSeekBarListener implements
            SeekBar.OnSeekBarChangeListener {
        private TextView progressTextView;
        private int stream;
        boolean checkMode = false;

        public OnAudioSeekBarListener(int paramInt, TextView paramTextView) {
            this.stream = paramInt;
            this.progressTextView = paramTextView;
        }

        public void onProgressChanged(SeekBar paramSeekBar, int paramInt,
                boolean paramBoolean) {
            switch (stream) {
            case AudioManager.STREAM_RING:
                if (checkMode) {
                    ringNum = paramInt;
                    if (paramInt == 0) {
                        ActivitySoundManager.this.radioVibrate.setChecked(true);
                        mRingerMode = AudioManager.RINGER_MODE_VIBRATE;
                        updateVibrateOrSilent();
                    } else {
                        ActivitySoundManager.this.radioNormal.setChecked(true);
                        mRingerMode = AudioManager.RINGER_MODE_NORMAL;
                        updateNormal(notificationNum, ringNum, systemNum);
                    }
                }

                break;
            case AudioManager.STREAM_NOTIFICATION:
                if (checkMode) {
                    notificationNum = paramInt;
                }

                break;
            case AudioManager.STREAM_SYSTEM:
                if (checkMode) {
                    systemNum = paramInt;
                }

                break;
            case AudioManager.STREAM_ALARM:
                alarmNum = paramInt;

                break;
            case AudioManager.STREAM_MUSIC:
                musicNum = paramInt;

                break;
            case AudioManager.STREAM_VOICE_CALL:
                voiceCallNum = paramInt;

                break;
            default:
                break;
            }

            this.progressTextView.setText(paramInt
                    + "/"
                    + ActivitySoundManager.this.am
                            .getStreamMaxVolume(this.stream));

        }

        public void onStartTrackingTouch(SeekBar paramSeekBar) {
            checkMode = true;
        }

        public void onStopTrackingTouch(SeekBar paramSeekBar) {
            checkMode = false;
        }
    }

    private void updateVibrateOrSilent() {
        this.alert.setEnabled(false);
        this.system.setEnabled(false);
        this.alert.setProgress(0);
        this.system.setProgress(0);
        this.alertProgress.setText("0/"
                + this.am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION));
        this.systemProgress.setText("0/"
                + this.am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM));
        this.ringer.setProgress(0);
        this.ringerProgress.setText("0/"
                + this.am.getStreamMaxVolume(AudioManager.STREAM_RING));

    }

    private void updateNormal(int notification, int paramInt2, int paramInt3) {
        // check if togglebutton disable wil dont set enable alert and system;
        if (checkAdvancedSound == true) {
            this.alert.setEnabled(true);
            this.system.setEnabled(true);
        }
        this.alert.setProgress(notification);
        this.system.setProgress(paramInt3);
        this.alertProgress.setText("" + notification + "/" + ""
                + this.am.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION));
        this.systemProgress.setText("" + paramInt3 + "/" + ""
                + this.am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM));

        this.ringerProgress.setText("" + paramInt2 + "/" + ""
                + this.am.getStreamMaxVolume(2));
        this.ringer.setProgress(paramInt2);

    }

    private void disable_or_enable_advanced_sound(boolean check) {
        alarm.setEnabled(check);

        music.setEnabled(check);
        ringer.setEnabled(check);

        // check ring mode if normal -> enable
        if (check == true && mRingerMode == AudioManager.RINGER_MODE_NORMAL) {
            alert.setEnabled(check);
            system.setEnabled(check);
        } else {
            alert.setEnabled(false);
            system.setEnabled(false);
        }
        voice.setEnabled(check);
        notificationRingtone.setEnabled(check);
        phoneRingtone.setEnabled(check);
        alarmRingtone.setEnabled(check);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        // when the user click start schedule
        case android.R.id.home:
            // Navigate "up" the demo structure to the launchpad activity.
            // for more.

            finish();
            return true;
        case R.id.done:
            // get data to update database
            ContentValues contentValue = new ContentValues();
            pst.sound_mode = String.valueOf(mRingerMode);

            if (checkAdvancedSound == true) {
                if (alarmRingtoneUri != null) {
                    pst.ringtone_alarm = alarmRingtoneUri.toString();
                }
                if (notificationRingtoneUri != null) {
                    pst.ringtone_notification = notificationRingtoneUri
                            .toString();
                }
                if (phoneRingtoneUri != null) {
                    pst.rimgtone_ringer = phoneRingtoneUri.toString();
                }

                pst.sound_alarm = String.valueOf(alarm.getProgress());
                pst.sound_music = String.valueOf(music.getProgress());
                pst.sound_ring = String.valueOf(ringer.getProgress());
                pst.sound_notification = String.valueOf(alert.getProgress());
                pst.sound_system = String.valueOf(system.getProgress());
                pst.sound_voice_call = String.valueOf(voice.getProgress());
            }else{
                pst.ringtone_alarm = null;
                pst.ringtone_notification = null;
                pst.rimgtone_ringer = null;

                pst.sound_alarm = null;
                pst.sound_music = null;
                pst.sound_ring = null;
                pst.sound_notification = null;
                pst.sound_system = null;
                pst.sound_voice_call = null;
            }

            contentValue.put(SmartSchedulerDatabase.COLUMN_ACTION_DRAW,
                    gson.toJson(pst));
            
            String status = null;
			switch (mRingerMode) {
			case AudioManager.RINGER_MODE_SILENT:
				status = getString(R.string.silent);
				break;
			case AudioManager.RINGER_MODE_VIBRATE:
				status = getString(R.string.vibrate);
				break;	
			case AudioManager.RINGER_MODE_NORMAL:
				status = getString(R.string.normal);
				break;		
			default:
				break;
			}
            contentValue.put(SmartSchedulerDatabase.COLUMN_ACTION_DRAW,
                    gson.toJson(pst));
            contentValue.put(SmartSchedulerDatabase.COLUMN_ACTION_STATUS,
            		status);
            smartScheduleDb.open();
            if (action == null) {
                if (Constant.START.equals(start_or_end)) {
                    contentValue.put(
                            SmartSchedulerDatabase.COLUMN_ACTION_START_ID,
                            event_id);
                } else if (Constant.END.equals(start_or_end)) {
                    contentValue.put(
                            SmartSchedulerDatabase.COLUMN_ACTION_END_ID,
                            event_id);
                } else {
                    Log.d(((Object) this).toString(),
                            "we can not check start or end ");
                    throw new Error(
                            "we can not check start or end");
                }
                contentValue.put(SmartSchedulerDatabase.COLUMN_ACTION_STATE,
                        Constant.ROUTER_SOUND_MANAGER);
                contentValue.put(SmartSchedulerDatabase.COLUMN_ACTION_NAME,
                        R.string.name_sound_manager);
                smartScheduleDb.insert_action(contentValue);
            } else {
                smartScheduleDb.update_action(contentValue, action.getId());
            }
            smartScheduleDb.close();
            Intent intent = new Intent(this, EventTimeActivity.class);
            intent.putExtra(SmartSchedulerDatabase.COLUMN_EVENT_ID, event_id);

            setResult(RESULT_OK, intent);
            finish();
            return true;
        case R.id.cancel:
            // schedule.cancelSchedule(this, 1);
            // do nothing
            finish();
            return true;
        }
        return false;
    }
}
