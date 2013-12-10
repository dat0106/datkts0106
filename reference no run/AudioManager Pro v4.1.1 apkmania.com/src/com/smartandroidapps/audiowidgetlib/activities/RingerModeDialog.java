package com.smartandroidapps.audiowidgetlib.activities;

import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.drawable;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.R.xml;
import com.smartandroidapps.audiowidgetlib.data.Profile;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager.Editor;
import com.smartandroidapps.audiowidgetlib.receivers.TurnRingerOn;
import com.smartandroidapps.audiowidgetlib.ui.NumberPickerDialog;
import com.smartandroidapps.audiowidgetlib.ui.NumberPickerDialog.OnNumberSetListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class RingerModeDialog
  extends PreferenceActivity
  implements NumberPickerDialog.OnNumberSetListener, Constants
{
  private final IntentFilter RINGER_MODE_CHANGED = new IntentFilter("android.media.RINGER_MODE_CHANGED");
  private Button cancelButton;
  private final BroadcastReceiver dismissFromVolumeUp = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (2 == paramAnonymousIntent.getIntExtra("android.media.EXTRA_RINGER_MODE", -1)) {
        RingerModeDialog.this.finish();
      }
    }
  };
  private CheckBox hideDialog;
  private Calendar mEnd;
  private int mHour = 0;
  private int mMinute = 0;
  private List<Profile> mProfiles;
  private SettingsManager mSettings;
  int profileId = -1;
  private Preference profiles;
  private Button saveButton;
  private Preference time;
  private CheckBoxPreference vibrate;
  
  private void commit()
  {
    SettingsManager.Editor localEditor = this.mSettings.editnew();
    localEditor.putRingerRestoreHour(this.mHour);
    localEditor.putRingerRestoreMinute(this.mMinute);
    localEditor.putRingerRestoreProfileID(this.profileId);
    localEditor.putRingerRestoreVibrate(this.vibrate.isChecked());
    localEditor.commit();
    TurnRingerOn.schedule(this, TurnRingerOn.createPendingIntent(this, this.profileId, this.vibrate.isChecked()), this.mEnd.getTime().getTime() - System.currentTimeMillis() + SystemClock.elapsedRealtime());
  }
  
  private void showProfilesDialog()
  {
    this.mProfiles = Profile.getProfiles(this);
    if ((this.mProfiles != null) && (!this.mProfiles.isEmpty()))
    {
      IconicAdapter localIconicAdapter = new IconicAdapter(this, this.mProfiles);
      new AlertDialog.Builder(this).setTitle(R.string.restore_profiles).setAdapter(localIconicAdapter, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
          RingerModeDialog.this.profiles.setSummary(((Profile)RingerModeDialog.this.mProfiles.get(paramAnonymousInt)).getName());
          RingerModeDialog.this.profileId = ((Profile)RingerModeDialog.this.mProfiles.get(paramAnonymousInt)).getId();
        }
      }).show();
    }
    else
    {
      Toast.makeText(this, R.string.profile_notfound, 0).show();
    }
  }
  
  private void showTimePickerDialog()
  {
    NumberPickerDialog localNumberPickerDialog = new NumberPickerDialog(this, -1, this.mHour, this.mMinute);
    localNumberPickerDialog.setTitle(R.string.when);
    localNumberPickerDialog.setIcon(R.drawable.ic_dialog_time);
    localNumberPickerDialog.setOnNumberSetListener(this);
    localNumberPickerDialog.show();
  }
  
  public void onBackPressed()
  {
    Log.d("AudioManager", "back pressed");
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(3);
    super.onCreate(paramBundle);
    setContentView(R.layout.ringer_changed);
    setFeatureDrawableResource(3, R.drawable.vibrate);
    addPreferencesFromResource(R.xml.ringer_prefs);
    ((Button)findViewById(R.id.saveButton)).setText(R.string.ok);
    this.time = findPreference("timeToRestore");
    this.hideDialog = ((CheckBox)findViewById(R.id.hideDialog));
    this.profiles = findPreference("profileToRestore");
    this.vibrate = ((CheckBoxPreference)findPreference("vibrateApplyRinger"));
    this.saveButton = ((Button)findViewById(R.id.saveButton));
    this.cancelButton = ((Button)findViewById(R.id.cancelButton));
    this.mSettings = new SettingsManager(this);
    onNumberSet(this.mSettings.getRingerRestoreHour(), this.mSettings.getRingerRestoreMinute());
    this.profileId = this.mSettings.getRingerRestoreProfileID();
    if (this.profileId != -1)
    {
      Profile localProfile = Profile.getProfile(this.profileId, this);
      if (localProfile != null) {
        this.profiles.setSummary(localProfile.getName());
      }
    }
    this.vibrate.setChecked(this.mSettings.getRingerRestoreVibrate());
    this.time.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
    {
      public boolean onPreferenceClick(Preference paramAnonymousPreference)
      {
        RingerModeDialog.this.showTimePickerDialog();
        return false;
      }
    });
    this.profiles.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
    {
      public boolean onPreferenceClick(Preference paramAnonymousPreference)
      {
        RingerModeDialog.this.showProfilesDialog();
        return false;
      }
    });
    this.saveButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((RingerModeDialog.this.profileId != -1) && ((RingerModeDialog.this.mHour >= 1) || (RingerModeDialog.this.mMinute >= 1)) && (RingerModeDialog.this.mEnd != null))
        {
          Toast.makeText(RingerModeDialog.this, R.string.restore_ringer_set, 0).show();
          RingerModeDialog.this.commit();
          RingerModeDialog.this.finish();
        }
        else
        {
          Toast.makeText(RingerModeDialog.this, R.string.when_and_profile_fields_are_required, 0).show();
        }
      }
    });
    this.cancelButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RingerModeDialog.this.finish();
      }
    });
  }
  
  protected void onDestroy()
  {
    if (this.hideDialog.isChecked()) {
      this.mSettings.editnew().putShowRingerRestoreDialog(false).commit();
    }
    super.onDestroy();
  }
  
  public void onNumberSet(int paramInt1, int paramInt2)
  {
    this.mHour = paramInt1;
    this.mMinute = paramInt2;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      int i = paramInt1 * 3600000;
      int j = paramInt2 * 60000;
      long l = System.currentTimeMillis() + (i + j);
      this.mEnd = new GregorianCalendar();
      this.mEnd.setTimeInMillis(l);
      this.time.setSummary(this.mEnd.getTime().toLocaleString());
    }
    else
    {
      this.mEnd = null;
      this.time.setSummary(R.string.select_when_to_restore);
    }
  }
  
  protected void onStart()
  {
    TurnRingerOn.cancelScheduled(this);
    registerReceiver(this.dismissFromVolumeUp, this.RINGER_MODE_CHANGED);
    super.onStart();
  }
  
  protected void onStop()
  {
    unregisterReceiver(this.dismissFromVolumeUp);
    super.onStop();
  }
  
  private class IconicAdapter
    extends ArrayAdapter<Profile>
  {
    ListActivity context;
    List<Profile> profiles;
    
    IconicAdapter(List<Profile> paramList)
    {
      super(R.layout.simple_list_item_1, 16908308, localList);
      this.context = paramList;
      this.profiles = localList;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = this.context.getLayoutInflater().inflate(R.layout.simple_list_item_1, null);
      ((TextView)localView.findViewById(16908308)).setText(((Profile)this.profiles.get(paramInt)).getName());
      return localView;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.activities.RingerModeDialog
 * JD-Core Version:    0.7.0.1
 */