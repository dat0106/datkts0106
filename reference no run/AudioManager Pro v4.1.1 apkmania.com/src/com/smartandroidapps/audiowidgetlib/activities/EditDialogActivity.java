package com.smartandroidapps.audiowidgetlib.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings.System;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.drawable;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.R.raw;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.R.style;
import com.smartandroidapps.audiowidgetlib.data.Profile;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.ui.ActionItem;
import com.smartandroidapps.audiowidgetlib.ui.QuickAction;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;
import com.smartandroidapps.audiowidgetlib.util.OldAPIHelper;
import java.util.Hashtable;
import java.util.Map;

public class EditDialogActivity
  extends Activity
  implements Constants
{
  public static final String PROFILE_ID = "editProfileId";
  private SeekBar alarm;
  private TextView alarmProgress;
  private Button alarmRingtone;
  private Uri alarmRingtoneUri;
  private SeekBar alert;
  private TextView alertProgress;
  private AudioManager am;
  private Button cancelButton;
  private Button mButtonVibe;
  private View.OnClickListener mOnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (paramAnonymousView.getId() != R.id.toggleSilent)
      {
        if (paramAnonymousView.getId() != R.id.ToggleButtonVibe)
        {
          if (paramAnonymousView.getId() != R.id.saveButton)
          {
            if (paramAnonymousView.getId() == R.id.cancelButton) {
              EditDialogActivity.this.finish();
            }
          }
          else
          {
            EditDialogActivity.this.updateProfile();
            Toast.makeText(EditDialogActivity.this, R.string.profile_saved, 1).show();
            EditDialogActivity.this.finish();
          }
        }
        else {
          EditDialogActivity.this.toggleVibeForJellyBean();
        }
      }
      else {
        EditDialogActivity.this.togglePhoneMode();
      }
    }
  };
  private Profile mProfile;
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
  private Button saveButton;
  private SettingsManager settings;
  private SeekBar system;
  private TextView systemProgress;
  private ToggleButton toggleSilent;
  private Vibrator vibe;
  private SeekBar voice;
  private TextView voiceProgress;
  private boolean volumizer;

  private boolean areRingtonesAvailable()
  {
    boolean bool;
    if (new RingtoneManager(this).getCursor().getCount() <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }

  private int getCallsVibrateSetting()
  {
    int i = 1;
    int j = getPhoneVibrateSettingValue();
    if (Build.VERSION.SDK_INT < 16)
    {
      if (j != 3) {
        if (j != i)
        {
          if (j == 2) {
            i = 2;
          }
        }
        else {
          i = 0;
        }
      }
    }
    else if (j == i) {
      i = 0;
    }
    return i;
  }

  private void getTitleForRingtone(int paramInt, Uri paramUri, TextView paramTextView)
  {
    Object localObject2 = getString(R.string.profile_none_applied);
    Object localObject1 = null;
    if (paramUri != null) {}
    for (;;)
    {
      try
      {
        localObject1 = RingtoneManager.getRingtone(this, paramUri);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((Ringtone)localObject1).getTitle(this);
        localObject2 = localObject1;
      }
      catch (NullPointerException localNullPointerException)
      {
        continue;
      }
      paramTextView.setText((CharSequence)localObject2);
      return;
      localObject2 = getString(R.string.silent_button);
      continue;
      localObject1 = getString(R.string.default_ringtone_silent);
      localObject2 = localObject1;
    }
  }

  private boolean getVibeInSilent()
  {
    boolean bool = false;
    int i = getPhoneVibrateSettingValue();
    if ((i != 3) && (i != 1)) {
      if (i != 2) {
        bool = true;
      } else {
        bool = true;
      }
    }
    return bool;
  }

  private void setLayoutTheme()
  {
    String str = new SettingsManager(this).getTheme();
    if (!MiscUtils.isAtLeastLargeHC(this))
    {
      if (!str.equals("darkBlue"))
      {
        if (!str.equals("normal"))
        {
          if (!str.equals("darkRed"))
          {
            if (!str.equals("darkGreen"))
            {
              if (!str.equals("darkYellow"))
              {
                if (str.equals("darkPink")) {
                  setTheme(R.style.Theme_AudioManager_Dark_Pink);
                }
              }
              else {
                setTheme(R.style.Theme_AudioManager_Dark_Yellow);
              }
            }
            else {
              setTheme(R.style.Theme_AudioManager_Dark_Green);
            }
          }
          else {
            setTheme(R.style.Theme_AudioManager_Dark_Red);
          }
        }
        else {
          setTheme(R.style.Theme_AudioManager);
        }
      }
      else {
        setTheme(R.style.Theme_AudioManager_Dark_Blue);
      }
    }
    else if (!str.equals("darkBlue"))
    {
      if (!str.equals("normal"))
      {
        if (!str.equals("darkRed"))
        {
          if (!str.equals("darkGreen"))
          {
            if (!str.equals("darkYellow"))
            {
              if (str.equals("darkPink")) {
                setTheme(R.style.Theme_AudioManager_Dark_Pink_DialogWhenLarge);
              }
            }
            else {
              setTheme(R.style.Theme_AudioManager_Dark_Yellow_DialogWhenLarge);
            }
          }
          else {
            setTheme(R.style.Theme_AudioManager_Dark_Green_DialogWhenLarge);
          }
        }
        else {
          setTheme(R.style.Theme_AudioManager_Dark_Red_DialogWhenLarge);
        }
      }
      else {
        setTheme(R.style.Theme_AudioManager_DialogWhenLarge);
      }
    }
    else {
      setTheme(R.style.Theme_AudioManager_Dark_Blue_DialogWhenLarge);
    }
  }

  private void setPhoneVibrateSettingValue(int paramInt)
  {
    this.mVibeMode = paramInt;
  }

  private void setSeekBarListeners()
  {
    this.voice.setOnSeekBarChangeListener(new OnAudioSeekBarListener(0, this.voiceProgress));
    this.system.setOnSeekBarChangeListener(new OnAudioSeekBarListener(1, this.systemProgress));
    if (this.ringer.getVisibility() == 0) {
      this.ringer.setOnSeekBarChangeListener(new OnAudioSeekBarListener(2, this.ringerProgress));
    }
    this.music.setOnSeekBarChangeListener(new OnAudioSeekBarListener(3, this.musicProgress));
    this.alarm.setOnSeekBarChangeListener(new OnAudioSeekBarListener(4, this.alarmProgress));
    this.alert.setOnSeekBarChangeListener(new OnAudioSeekBarListener(5, this.alertProgress));
  }

  private void setupUI()
  {
    this.settings = new SettingsManager(this);
    this.volumizer = this.settings.getBoolean("volumizer", false);
    Typeface localTypeface = null;
    if (Build.VERSION.SDK_INT >= 4) {
      localTypeface = MiscUtils.CreateTypefaceFromRawResource(this, R.raw.digital);
    }
    this.alarmRingtone = ((Button)findViewById(R.id.alarmRingtone));
    this.phoneRingtone = ((Button)findViewById(R.id.phoneRingtone));
    this.notificationRingtone = ((Button)findViewById(R.id.notificationRingtone));
    this.alarmRingtone.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent("android.intent.action.RINGTONE_PICKER");
        localIntent.putExtra("android.intent.extra.ringtone.TITLE", EditDialogActivity.this.getText(R.string.alarm_ringtone));
        localIntent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
        localIntent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
        localIntent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", Settings.System.DEFAULT_ALARM_ALERT_URI);
        localIntent.putExtra("android.intent.extra.ringtone.EXISTING_URI", EditDialogActivity.this.alarmRingtoneUri);
        localIntent.putExtra("android.intent.extra.ringtone.TYPE", 4);
        EditDialogActivity.this.startActivityForResult(localIntent, 1002);
      }
    });
    this.phoneRingtone.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent("android.intent.action.RINGTONE_PICKER");
        localIntent.putExtra("android.intent.extra.ringtone.TITLE", EditDialogActivity.this.getText(R.string.phone_ringtone));
        localIntent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
        localIntent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
        localIntent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", Settings.System.DEFAULT_RINGTONE_URI);
        localIntent.putExtra("android.intent.extra.ringtone.EXISTING_URI", EditDialogActivity.this.phoneRingtoneUri);
        localIntent.putExtra("android.intent.extra.ringtone.TYPE", 1);
        EditDialogActivity.this.startActivityForResult(localIntent, 1000);
      }
    });
    this.notificationRingtone.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent("android.intent.action.RINGTONE_PICKER");
        localIntent.putExtra("android.intent.extra.ringtone.TITLE", EditDialogActivity.this.getText(R.string.notification_ringtone));
        localIntent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
        localIntent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
        localIntent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", Settings.System.DEFAULT_NOTIFICATION_URI);
        localIntent.putExtra("android.intent.extra.ringtone.EXISTING_URI", EditDialogActivity.this.notificationRingtoneUri);
        localIntent.putExtra("android.intent.extra.ringtone.TYPE", 2);
        EditDialogActivity.this.startActivityForResult(localIntent, 1001);
      }
    });
    if (!areRingtonesAvailable())
    {
      this.phoneRingtone.setEnabled(false);
      this.notificationRingtone.setEnabled(false);
      this.alarmRingtone.setEnabled(false);
    }
    this.alarm = ((SeekBar)findViewById(R.id.alarm));
    this.music = ((SeekBar)findViewById(R.id.music));
    this.alert = ((SeekBar)findViewById(R.id.alerts));
    this.ringer = ((SeekBar)findViewById(R.id.ringer));
    this.system = ((SeekBar)findViewById(R.id.system));
    this.voice = ((SeekBar)findViewById(R.id.voice));
    this.am = ((AudioManager)getSystemService("audio"));
    this.vibe = ((Vibrator)getSystemService("vibrator"));
    this.alarmProgress = ((TextView)findViewById(R.id.alarmLvl));
    this.musicProgress = ((TextView)findViewById(R.id.musicLvl));
    this.alertProgress = ((TextView)findViewById(R.id.alertLvl));
    this.ringerProgress = ((TextView)findViewById(R.id.ringerLvl));
    this.systemProgress = ((TextView)findViewById(R.id.systemLvl));
    this.voiceProgress = ((TextView)findViewById(R.id.voiceLvl));
    this.toggleSilent = ((ToggleButton)findViewById(R.id.toggleSilent));
    this.mToggleVibe = ((ToggleButton)findViewById(R.id.ToggleButtonVibe));
    this.mButtonVibe = ((Button)findViewById(R.id.ButtonVibe));
    this.saveButton = ((Button)findViewById(R.id.saveButton));
    this.cancelButton = ((Button)findViewById(R.id.cancelButton));
    if (localTypeface != null)
    {
      this.alarmProgress.setTypeface(localTypeface);
      this.musicProgress.setTypeface(localTypeface);
      this.alertProgress.setTypeface(localTypeface);
      this.ringerProgress.setTypeface(localTypeface);
      this.systemProgress.setTypeface(localTypeface);
      this.voiceProgress.setTypeface(localTypeface);
    }
    setSeekBarListeners();
    if (OldAPIHelper.hasSystemTelephony(getPackageManager()))
    {
      this.ringer.setMax(this.am.getStreamMaxVolume(2));
    }
    else
    {
      this.ringer.setVisibility(8);
      this.ringer.setEnabled(false);
      this.ringerProgress.setVisibility(8);
      this.phoneRingtone.setVisibility(8);
      findViewById(R.id.ringerLabel).setVisibility(8);
    }
    this.toggleSilent.setOnClickListener(this.mOnClickListener);
    this.saveButton.setOnClickListener(this.mOnClickListener);
    this.cancelButton.setOnClickListener(this.mOnClickListener);
    if (Build.VERSION.SDK_INT < 16)
    {
      this.mToggleVibe.setVisibility(8);
      this.mButtonVibe.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          final QuickAction localQuickAction = new QuickAction(paramAnonymousView);
          EditDialogActivity localEditDialogActivity = EditDialogActivity.this;
          ActionItem localActionItem3 = new ActionItem();
          localActionItem3.setTitle(localEditDialogActivity.getResources().getStringArray(com.smartandroidapps.audiowidgetlib.R.array.vibrate_entries)[0]);
          localActionItem3.setIcon(localEditDialogActivity.getResources().getDrawable(R.drawable.btn_radio_off_holo_dark));
          localActionItem3.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              EditDialogActivity.this.setPhoneVibrateSettingValue(0);
              localQuickAction.dismiss();
            }
          });
          ActionItem localActionItem1 = new ActionItem();
          localActionItem1.setTitle(localEditDialogActivity.getResources().getStringArray(com.smartandroidapps.audiowidgetlib.R.array.vibrate_entries)[1]);
          localActionItem1.setIcon(localEditDialogActivity.getResources().getDrawable(R.drawable.btn_radio_off_holo_dark));
          localActionItem1.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              EditDialogActivity.this.setPhoneVibrateSettingValue(1);
              localQuickAction.dismiss();
            }
          });
          ActionItem localActionItem4 = new ActionItem();
          localActionItem4.setTitle(localEditDialogActivity.getResources().getStringArray(com.smartandroidapps.audiowidgetlib.R.array.vibrate_entries)[2]);
          localActionItem4.setIcon(localEditDialogActivity.getResources().getDrawable(R.drawable.btn_radio_off_holo_dark));
          localActionItem4.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              EditDialogActivity.this.setPhoneVibrateSettingValue(2);
              localQuickAction.dismiss();
            }
          });
          ActionItem localActionItem2 = new ActionItem();
          localActionItem2.setTitle(localEditDialogActivity.getResources().getStringArray(com.smartandroidapps.audiowidgetlib.R.array.vibrate_entries)[3]);
          localActionItem2.setIcon(localEditDialogActivity.getResources().getDrawable(R.drawable.btn_radio_off_holo_dark));
          localActionItem2.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              EditDialogActivity.this.setPhoneVibrateSettingValue(3);
              localQuickAction.dismiss();
            }
          });
          switch (EditDialogActivity.this.getPhoneVibrateSettingValue())
          {
          case 0:
            localActionItem3.setIcon(localEditDialogActivity.getResources().getDrawable(R.drawable.btn_radio_on_holo_dark));
            break;
          case 1:
            localActionItem1.setIcon(localEditDialogActivity.getResources().getDrawable(R.drawable.btn_radio_on_holo_dark));
            break;
          case 2:
            localActionItem4.setIcon(localEditDialogActivity.getResources().getDrawable(R.drawable.btn_radio_on_holo_dark));
            break;
          case 3:
            localActionItem2.setIcon(localEditDialogActivity.getResources().getDrawable(R.drawable.btn_radio_on_holo_dark));
          }
          localQuickAction.addActionItem(localActionItem3);
          localQuickAction.addActionItem(localActionItem1);
          localQuickAction.addActionItem(localActionItem4);
          if (Build.VERSION.SDK_INT >= 8) {
            localQuickAction.addActionItem(localActionItem2);
          }
          EditDialogActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              localQuickAction.show();
            }
          });
        }
      });
    }
    else
    {
      this.mButtonVibe.setVisibility(8);
      this.mToggleVibe.setOnClickListener(this.mOnClickListener);
    }
    this.music.setMax(this.am.getStreamMaxVolume(3));
    this.alarm.setMax(this.am.getStreamMaxVolume(4));
    this.alert.setMax(this.am.getStreamMaxVolume(5));
    this.system.setMax(this.am.getStreamMaxVolume(1));
    this.voice.setMax(this.am.getStreamMaxVolume(0));
  }

  private void togglePhoneMode()
  {
    if (this.mRingerMode != 2)
    {
      this.mRingerMode = 2;
    }
    else if (!getVibeInSilent())
    {
      this.mRingerMode = 0;
    }
    else
    {
      this.mRingerMode = 1;
      this.vibe.vibrate(50L);
    }
    updateUI(false);
  }

  private void toggleVibeForJellyBean()
  {
    if (getPhoneVibrateSettingValue() == 1) {
      setPhoneVibrateSettingValue(0);
    } else {
      setPhoneVibrateSettingValue(1);
    }
    updateUI(false);
  }

  private void updateNormal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.alert.setProgress(paramInt1);
    this.system.setProgress(paramInt3);
    this.alertProgress.setText("" + paramInt1 + "/" + "" + this.am.getStreamMaxVolume(5));
    this.systemProgress.setText("" + paramInt3 + "/" + "" + this.am.getStreamMaxVolume(1));
    if (this.ringer.getVisibility() != 0)
    {
      this.music.setProgress(paramInt4);
      this.musicProgress.setText("" + paramInt4 + "/" + "" + this.am.getStreamMaxVolume(3));
    }
    else
    {
      this.ringerProgress.setText("" + paramInt2 + "/" + "" + this.am.getStreamMaxVolume(2));
      this.ringer.setProgress(paramInt2);
    }
  }

  private void updateProfile()
  {
    Hashtable localHashtable = new Hashtable();
    localHashtable.put(Integer.valueOf(0), Integer.valueOf(this.voice.getProgress()));
    localHashtable.put(Integer.valueOf(1), Integer.valueOf(this.system.getProgress()));
    localHashtable.put(Integer.valueOf(2), Integer.valueOf(this.ringer.getProgress()));
    localHashtable.put(Integer.valueOf(3), Integer.valueOf(this.music.getProgress()));
    localHashtable.put(Integer.valueOf(4), Integer.valueOf(this.alarm.getProgress()));
    localHashtable.put(Integer.valueOf(5), Integer.valueOf(this.alert.getProgress()));
    int i = getCallsVibrateSetting();
    this.mProfile.setAllValues(this.mRingerMode, i, i, getVibeInSilent(), localHashtable);
    this.mProfile.setRingtones(this.phoneRingtoneUri, this.notificationRingtoneUri, this.alarmRingtoneUri);
  }

  private void updateUI(boolean paramBoolean)
  {
    int k = this.mProfile.getStreamValue(3);
    int j = this.mProfile.getStreamValue(5);
    int i1 = this.mProfile.getStreamValue(4);
    int i = this.mProfile.getStreamValue(1);
    int n = this.mProfile.getStreamValue(0);
    int m = 0;
    boolean bool = true;
    if (this.ringer.getVisibility() == 0)
    {
      bool = MiscUtils.isNotificationAndRingerLinked(getContentResolver(), this, false);
      m = this.mProfile.getStreamValue(2);
      if (bool) {
        this.alert.setEnabled(false);
      }
      if (paramBoolean)
      {
        this.ringer.setProgress(m);
        this.ringerProgress.setText("" + m + "/" + "" + this.am.getStreamMaxVolume(2));
      }
    }
    if (paramBoolean)
    {
      this.music.setProgress(k);
      this.alert.setProgress(j);
      this.alarm.setProgress(i1);
      this.system.setProgress(i);
      this.voice.setProgress(n);
      this.musicProgress.setText("" + k + "/" + "" + this.am.getStreamMaxVolume(3));
      this.alertProgress.setText("" + j + "/" + "" + this.am.getStreamMaxVolume(5));
      this.systemProgress.setText("" + i + "/" + "" + this.am.getStreamMaxVolume(1));
      this.alarmProgress.setText("" + i1 + "/" + "" + this.am.getStreamMaxVolume(4));
      this.voiceProgress.setText("" + n + "/" + "" + this.am.getStreamMaxVolume(0));
      this.phoneRingtoneUri = this.mProfile.getPhoneRingtoneUri();
      this.notificationRingtoneUri = this.mProfile.getNotificationRingtoneUri();
      this.alarmRingtoneUri = this.mProfile.getAlarmRingtoneUri();
      getTitleForRingtone(1, this.mProfile.getPhoneRingtoneUri(), this.phoneRingtone);
      getTitleForRingtone(2, this.mProfile.getNotificationRingtoneUri(), this.notificationRingtone);
      getTitleForRingtone(4, this.mProfile.getAlarmRingtoneUri(), this.alarmRingtone);
    }
    if (this.mRingerMode != 2)
    {
      this.alarm.setEnabled(true);
      if (this.ringer.getVisibility() != 0)
      {
        this.music.setEnabled(false);
      }
      else
      {
        this.ringer.setEnabled(false);
        this.music.setEnabled(true);
      }
      this.alert.setEnabled(false);
      this.system.setEnabled(false);
      this.voice.setEnabled(true);
      updateVibrateOrSilent();
    }
    else
    {
      this.alarm.setEnabled(true);
      this.music.setEnabled(true);
      if (this.ringer.getVisibility() != 0)
      {
        this.alert.setEnabled(true);
      }
      else
      {
        this.ringer.setEnabled(true);
        SeekBar localSeekBar = this.alert;
        if (bool) {
          bool = false;
        } else {
          bool = true;
        }
        localSeekBar.setEnabled(bool);
      }
      this.system.setEnabled(true);
      this.voice.setEnabled(true);
      updateNormal(j, m, i, k);
    }
    setPressedStates();
  }

  private void updateVibrateOrSilent()
  {
    this.alert.setProgress(0);
    this.system.setProgress(0);
    this.alertProgress.setText("0/" + this.am.getStreamMaxVolume(5));
    this.systemProgress.setText("0/" + this.am.getStreamMaxVolume(1));
    if (this.ringer.getVisibility() != 0)
    {
      this.music.setProgress(0);
      this.musicProgress.setText("0/" + this.am.getStreamMaxVolume(3));
    }
    else
    {
      this.ringer.setProgress(0);
      this.ringerProgress.setText("0/" + this.am.getStreamMaxVolume(2));
    }
  }

  int getPhoneVibrateSettingValue()
  {
    int i;
    if (this.mVibeMode == -1)
    {
      int j = this.mProfile.getVibrateRinger();
      if (Build.VERSION.SDK_INT < 16)
      {
        boolean bool = this.mProfile.getVibrateInSilentBoolean();
        if (Build.VERSION.SDK_INT >= 8)
        {
          if (!bool)
          {
            if (j == 2) {
              Log.d("AudioManager", "profile vibe settings incorrect. vibeInSilent=false and callsVibrateSetting=onlySilent");
            }
            if (j != 1) {
              this.mVibeMode = 1;
            } else {
              this.mVibeMode = 3;
            }
          }
          else
          {
            if (j == 0) {
              Log.d("AudioManager", "profile vibe settings incorrect. vibeInSilent=true and callsVibrateSetting=off");
            }
            if (j != 1) {
              this.mVibeMode = 2;
            } else {
              this.mVibeMode = 0;
            }
          }
        }
        else if (j != 1)
        {
          if (j != 2) {
            this.mVibeMode = 1;
          } else {
            this.mVibeMode = 2;
          }
        }
        else {
          this.mVibeMode = 0;
        }
      }
      else if (j == 0)
      {
        this.mVibeMode = 1;
      }
      else
      {
        this.mVibeMode = 0;
      }
      i = this.mVibeMode;
    }
    else
    {
      i = this.mVibeMode;
    }
    return i;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      Uri localUri = (Uri)paramIntent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
      if (MiscUtils.isDebug()) {
        Log.d("AudioManager", "onActivityResult(): " + localUri);
      }
      switch (paramInt1)
      {
      case 1000:
        this.phoneRingtoneUri = localUri;
        getTitleForRingtone(1, localUri, this.phoneRingtone);
        break;
      case 1001:
        this.notificationRingtoneUri = localUri;
        getTitleForRingtone(2, localUri, this.notificationRingtone);
        break;
      case 1002:
        this.alarmRingtoneUri = localUri;
        getTitleForRingtone(4, localUri, this.alarmRingtone);
      }
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setLayoutTheme();
    requestWindowFeature(3);
    if (!MiscUtils.isAtLeastLargeHC(this)) {
      setContentView(R.layout.edit_phone);
    } else {
      setContentView(R.layout.edit);
    }
    setFeatureDrawableResource(3, R.drawable.edit);
    setupUI();
  }

  public void onStart()
  {
    int i = getIntent().getIntExtra("editProfileId", -1);
    if (i == -1) {
      finish();
    }
    this.mProfile = Profile.getProfile(i, this);
    this.mRingerMode = this.mProfile.getRingerMode();
    updateUI(true);
    super.onStart();
  }

  protected void onStop()
  {
    super.onStop();
    finish();
  }

  public void playBeepingTone(int paramInt)
  {
    if ((this.alarm.isPressed()) || (this.music.isPressed()) || (this.alert.isPressed()) || (this.ringer.isPressed()) || (this.system.isPressed()) || (this.voice.isPressed())) {}
    try
    {
      this.mToneGenerator = new ToneGenerator(paramInt, 100);
      this.mToneGenerator.startTone(24);
      this.mToneGenerator.release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.w("AudioManager", localRuntimeException.getMessage());
      }
    }
  }

  public void setPressedStates()
  {
    if (this.mRingerMode != 2) {
      this.toggleSilent.setChecked(true);
    } else {
      this.toggleSilent.setChecked(false);
    }
    if (getPhoneVibrateSettingValue() == 1) {
      this.mToggleVibe.setChecked(false);
    } else {
      this.mToggleVibe.setChecked(true);
    }
  }

  private class OnAudioSeekBarListener
    implements SeekBar.OnSeekBarChangeListener
  {
    private TextView progressTextView;
    private int stream;

    public OnAudioSeekBarListener(int paramInt, TextView paramTextView)
    {
      this.stream = paramInt;
      this.progressTextView = paramTextView;
    }

    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      this.progressTextView.setText(paramInt + "/" + EditDialogActivity.this.am.getStreamMaxVolume(this.stream));
      if (paramBoolean)
      {
        if (EditDialogActivity.this.ringer.getVisibility() == 0)
        {
          boolean bool = MiscUtils.isNotificationAndRingerLinked(EditDialogActivity.this.getContentResolver(), EditDialogActivity.this, false);
          if ((this.stream == 2) && (bool)) {
            EditDialogActivity.this.alert.setProgress(paramInt);
          }
        }
        if (EditDialogActivity.this.volumizer) {
          EditDialogActivity.this.playBeepingTone(this.stream);
        }
      }
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar) {}

    public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.activities.EditDialogActivity
 * JD-Core Version:    0.7.0.1
 */