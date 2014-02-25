package com.smartschedule.action;

import com.smartschedule.EventTimeActivity;
import com.smartschedule.R;
import com.smartschedule.utils.MiscUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class DialogSoundManager extends AlertDialog.Builder {

	private int mRingerMode = -1;
	private ToggleButton mToggleVibe;
	private ToneGenerator mToneGenerator;
	private int mVibeMode = -1;
	private SeekBar music;
	private TextView musicProgress;
	private Button notificationRingtone;
	private Uri notificationRingtoneUri;
	private Button phoneRingtone;
	private Uri phoneRingtoneUri;
	private SeekBar ringer;
	private TextView ringerProgress;
	private SeekBar system;
	private TextView systemProgress;
	private ToggleButton toggleSilent;
	private Vibrator vibe;
	private SeekBar voice;
	private TextView voiceProgress;
	private boolean volumizer;
	private SeekBar alarm;
	private TextView alarmProgress;
	private Button alarmRingtone;
	private Uri alarmRingtoneUri;
	private SeekBar alert;
	private TextView alertProgress;
	private AudioManager am;
	private Button saveButton;
	private Button cancelButton;
	private Button mButtonVibe;
	private Context context;

	public DialogSoundManager(Context context) {
		super(context);
		this.context =  context;

		am  = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		final View View = android.view.View.inflate(context,
				R.layout.dialog_sound_manager, null);

		final SeekBar textView = (SeekBar) View
				.findViewById(R.id.dialog_add_event);

		Typeface localTypeface = null;
		if (Build.VERSION.SDK_INT >= 4) {
			localTypeface = MiscUtils.CreateTypefaceFromRawResource(context,
					R.raw.digital);
		}

		this.alarmRingtone = ((Button) View.findViewById(R.id.alarmRingtone));
		this.phoneRingtone = ((Button) View.findViewById(R.id.phoneRingtone));
		this.notificationRingtone = ((Button) View
				.findViewById(R.id.notificationRingtone));
		this.alarm = ((SeekBar) View.findViewById(R.id.alarm));
		this.music = ((SeekBar) View.findViewById(R.id.music));
		this.alert = ((SeekBar) View.findViewById(R.id.alerts));
		this.ringer = ((SeekBar) View.findViewById(R.id.ringer));
		this.system = ((SeekBar) View.findViewById(R.id.system));
		this.voice = ((SeekBar) View.findViewById(R.id.voice));
		// this.am = ((AudioManager)context.getSystemService("audio"));
		// this.vibe = ((Vibrator)getSystemService("vibrator"));
		this.alarmProgress = ((TextView) View.findViewById(R.id.alarmLvl));
		this.musicProgress = ((TextView) View.findViewById(R.id.musicLvl));
		this.alertProgress = ((TextView) View.findViewById(R.id.alertLvl));
		this.ringerProgress = ((TextView) View.findViewById(R.id.ringerLvl));
		this.systemProgress = ((TextView) View.findViewById(R.id.systemLvl));
		this.voiceProgress = ((TextView) View.findViewById(R.id.voiceLvl));
		// this.toggleSilent =
		// ((ToggleButton)View.findViewById(R.id.toggleSilent));
		// this.mToggleVibe =
		// ((ToggleButton)View.findViewById(R.id.ToggleButtonVibe));
		// this.mButtonVibe = ((Button)View.findViewById(R.id.ButtonVibe));
		// this.saveButton = ((Button)View.findViewById(R.id.saveButton));
		// this.cancelButton = ((Button)View.findViewById(R.id.cancelButton));

		if (localTypeface != null) {
			this.alarmProgress.setTypeface(localTypeface);
			this.musicProgress.setTypeface(localTypeface);
			this.alertProgress.setTypeface(localTypeface);
			this.ringerProgress.setTypeface(localTypeface);
			this.systemProgress.setTypeface(localTypeface);
			this.voiceProgress.setTypeface(localTypeface);
		}
		int ixc = this.am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		Log.v(DialogSoundManager.this.toString(), ixc  + "");
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
		this.ringer.setMax(this.am.getStreamMaxVolume(AudioManager.STREAM_RING));
		setSeekBarListeners();

		// update bt
		mRingerMode = 2;
		updateUI(true);
		this.setTitle(R.string.title_dialog_add_event);

		this.setView(View)
				.setCancelable(false)
				.setPositiveButton(R.string.done,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// get name to sent
								// String checkDisableCreate = (String) textView
								// .getText().toString();

								dialog.dismiss();
							}
						})
				.setNegativeButton(R.string.cancel,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

	}

	private void updateUI(boolean paramBoolean) {
		int k = am.getStreamVolume(AudioManager.STREAM_MUSIC);
		int j = am.getStreamVolume(AudioManager.STREAM_NOTIFICATION);
		int i1 = am.getStreamVolume(AudioManager.STREAM_ALARM);
		int i = am.getStreamVolume(AudioManager.STREAM_SYSTEM);
		int n = am.getStreamVolume(AudioManager.STREAM_VOICE_CALL);
		int m = 0;
		boolean bool = true;
		// if (this.ringer.getVisibility() == 0) {
		// bool = MiscUtils.isNotificationAndRingerLinked(
		// getContentResolver(), this, false);
		// m = this.mProfile.getStreamValue(2);
		// if (bool) {
		// this.alert.setEnabled(false);
		// }
		// if (paramBoolean) {
		// this.ringer.setProgress(m);
		// this.ringerProgress.setText("" + m + "/" + ""
		// + this.am.getStreamMaxVolume(2));
		// }
		// }
		if (paramBoolean) {
			this.music.setProgress(k);
			this.alert.setProgress(j);
			this.alarm.setProgress(i1);
			this.system.setProgress(i);
			this.voice.setProgress(n);
			this.musicProgress.setText("" + k + "/" + ""
					+ this.am.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
			this.alertProgress
					.setText(""
							+ j
							+ "/"
							+ ""
							+ this.am
									.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION));
			this.systemProgress.setText("" + i + "/" + ""
					+ this.am.getStreamMaxVolume(AudioManager.STREAM_ALARM));
			this.alarmProgress.setText("" + i1 + "/" + ""
					+ this.am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM));
			this.voiceProgress
					.setText(""
							+ n
							+ "/"
							+ ""
							+ this.am
									.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL));
			// this.phoneRingtoneUri = this.mProfile.getPhoneRingtoneUri();
			// this.notificationRingtoneUri = this.mProfile
			// .getNotificationRingtoneUri();
			// this.alarmRingtoneUri = this.mProfile.getAlarmRingtoneUri();
			// getTitleForRingtone(1, this.mProfile.getPhoneRingtoneUri(),
			// this.phoneRingtone);
			// getTitleForRingtone(2,
			// this.mProfile.getNotificationRingtoneUri(),
			// this.notificationRingtone);
			// getTitleForRingtone(4, this.mProfile.getAlarmRingtoneUri(),
			// this.alarmRingtone);
		}
		if (this.mRingerMode != 2) {
			this.alarm.setEnabled(true);
			if (this.ringer.getVisibility() != 0) {
				this.music.setEnabled(false);
			} else {
				this.ringer.setEnabled(false);
				this.music.setEnabled(true);
			}
			this.alert.setEnabled(false);
			this.system.setEnabled(false);
			this.voice.setEnabled(true);
			updateVibrateOrSilent();
		} else {
			this.alarm.setEnabled(true);
			this.music.setEnabled(true);

			this.alert.setEnabled(true);
			// ko hieu lam j
//			if (this.ringer.getVisibility() != 0) {
//				this.alert.setEnabled(true);
//			} else {
//				this.ringer.setEnabled(true);
//				SeekBar localSeekBar = this.alert;
//				if (bool) {
//					bool = false;
//				} else {
//					bool = true;
//				}
//				localSeekBar.setEnabled(bool);
//			}
			this.system.setEnabled(true);
			this.voice.setEnabled(true);
			updateNormal(j, m, i, k);
		}
		// setPressedStates();
	}

	private void setSeekBarListeners() {
		this.voice.setOnSeekBarChangeListener(new OnAudioSeekBarListener(AudioManager.STREAM_VOICE_CALL,
				this.voiceProgress));
		this.system.setOnSeekBarChangeListener(new OnAudioSeekBarListener(AudioManager.STREAM_SYSTEM,
				this.systemProgress));
		if (this.ringer.getVisibility() == 0) {
			this.ringer.setOnSeekBarChangeListener(new OnAudioSeekBarListener(
					AudioManager.STREAM_RING, this.ringerProgress));
		}
		this.music.setOnSeekBarChangeListener(new OnAudioSeekBarListener(AudioManager.STREAM_MUSIC,
				this.musicProgress));
		this.alarm.setOnSeekBarChangeListener(new OnAudioSeekBarListener(AudioManager.STREAM_ALARM,
				this.alarmProgress));
		this.alert.setOnSeekBarChangeListener(new OnAudioSeekBarListener(AudioManager.STREAM_NOTIFICATION,
				this.alertProgress));
	}

	private class OnAudioSeekBarListener implements
			SeekBar.OnSeekBarChangeListener {
		private TextView progressTextView;
		private int stream;

		public OnAudioSeekBarListener(int paramInt, TextView paramTextView) {
			this.stream = paramInt;
			this.progressTextView = paramTextView;
		}

		public void onProgressChanged(SeekBar paramSeekBar, int paramInt,
				boolean paramBoolean) {
			this.progressTextView.setText(paramInt
					+ "/"
					+ DialogSoundManager.this.am
							.getStreamMaxVolume(this.stream));
//			if (paramBoolean) {
//				if (EditDialogActivity.this.ringer.getVisibility() == 0) {
//					boolean bool = MiscUtils.isNotificationAndRingerLinked(
//							DialogSoundManager.this.getContentResolver(),
//							EditDialogActivity.this, false);
//					if ((this.stream == 2) && (bool)) {
//						EditDialogActivity.this.alert.setProgress(paramInt);
//					}
//				}
//				if (EditDialogActivity.this.volumizer) {
//					EditDialogActivity.this.playBeepingTone(this.stream);
//				}
//			}
		}

		public void onStartTrackingTouch(SeekBar paramSeekBar) {
		}

		public void onStopTrackingTouch(SeekBar paramSeekBar) {
		}
	}

	private void updateVibrateOrSilent() {
		this.alert.setProgress(0);
		this.system.setProgress(0);
		this.alertProgress.setText("0/" + this.am.getStreamMaxVolume(5));
		this.systemProgress.setText("0/" + this.am.getStreamMaxVolume(1));
		if (this.ringer.getVisibility() != 0) {
			this.music.setProgress(0);
			this.musicProgress.setText("0/" + this.am.getStreamMaxVolume(3));
		} else {
			this.ringer.setProgress(0);
			this.ringerProgress.setText("0/" + this.am.getStreamMaxVolume(2));
		}
	}

	private void updateNormal(int paramInt1, int paramInt2, int paramInt3,
			int paramInt4) {
		this.alert.setProgress(paramInt1);
		this.system.setProgress(paramInt3);
		this.alertProgress.setText("" + paramInt1 + "/" + ""
				+ this.am.getStreamMaxVolume(5));
		this.systemProgress.setText("" + paramInt3 + "/" + ""
				+ this.am.getStreamMaxVolume(1));
		if (this.ringer.getVisibility() != 0) {
			this.music.setProgress(paramInt4);
			this.musicProgress.setText("" + paramInt4 + "/" + ""
					+ this.am.getStreamMaxVolume(3));
		} else {
			this.ringerProgress.setText("" + paramInt2 + "/" + ""
					+ this.am.getStreamMaxVolume(2));
			this.ringer.setProgress(paramInt2);
		}
	}
}
