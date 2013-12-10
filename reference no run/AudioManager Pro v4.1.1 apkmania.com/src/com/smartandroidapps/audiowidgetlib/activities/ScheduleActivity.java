package com.smartandroidapps.audiowidgetlib.activities;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.R.drawable;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.R.xml;
import com.smartandroidapps.audiowidgetlib.data.Schedule;
import java.text.DateFormatSymbols;
import java.util.Calendar;

public class ScheduleActivity
  extends PreferenceActivity
  implements Constants
{
  static final int REPEAT_DIALOG_ID = 1;
  static final int TIME_DIALOG_ID;
  private Button cancelButton;
  private int dayCount;
  boolean[] days;
  private CheckBoxPreference enable;
  boolean is24Hour;
  private int mHour;
  private int mMinute;
  private TimePickerDialog.OnTimeSetListener mTimeSetListener;
  int profileId;
  private Preference repeat;
  private Button saveButton;
  private Schedule sched;
  private int setHour;
  private int setMinute;
  private Preference time;
  private String[] values;
  private CheckBoxPreference vibrate;
  private String[] weekdays;
  
  public ScheduleActivity()
  {
    Object localObject = new boolean[7];
    localObject[0] = 0;
    localObject[1] = 0;
    localObject[2] = 0;
    localObject[3] = 0;
    localObject[4] = 0;
    localObject[5] = 0;
    localObject[6] = 0;
    this.days = ((boolean[])localObject);
    this.profileId = -1;
    this.is24Hour = true;
    this.weekdays = new DateFormatSymbols().getWeekdays();
    localObject = new String[7];
    localObject[0] = this.weekdays[1];
    localObject[1] = this.weekdays[2];
    localObject[2] = this.weekdays[3];
    localObject[3] = this.weekdays[4];
    localObject[4] = this.weekdays[5];
    localObject[5] = this.weekdays[6];
    localObject[6] = this.weekdays[7];
    this.values = ((String[])localObject);
    this.mTimeSetListener = new TimePickerDialog.OnTimeSetListener()
    {
      public void onTimeSet(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        ScheduleActivity.this.setTimeDisplay(paramAnonymousInt1, paramAnonymousInt2);
        ScheduleActivity.access$202(ScheduleActivity.this, paramAnonymousInt1);
        ScheduleActivity.access$302(ScheduleActivity.this, paramAnonymousInt2);
      }
    };
  }
  
  private void displayDaysPicked()
  {
    this.dayCount = 0;
    StringBuilder localStringBuilder;
    for (int i = 0;; localStringBuilder++)
    {
      if (this.days.length <= i)
      {
        localStringBuilder = new StringBuilder();
        Object localObject = new DateFormatSymbols();
        String[] arrayOfString;
        if (this.dayCount <= 1) {
          arrayOfString = ((DateFormatSymbols)localObject).getWeekdays();
        } else {
          arrayOfString = ((DateFormatSymbols)localObject).getShortWeekdays();
        }
        localObject = new String[7];
        localObject[0] = arrayOfString[1];
        localObject[1] = arrayOfString[2];
        localObject[2] = arrayOfString[3];
        localObject[3] = arrayOfString[4];
        localObject[4] = arrayOfString[5];
        localObject[5] = arrayOfString[6];
        localObject[6] = arrayOfString[7];
        int j = 0;
        int k = 0;
        for (;;)
        {
          if (this.days.length <= j)
          {
            if (this.dayCount == 0) {
              localStringBuilder.append(getResources().getString(R.string.scheduler_popup_repeat_selectdays));
            }
            this.repeat.setSummary(localStringBuilder);
            return;
          }
          if ((this.days[j] != 0) && (this.dayCount != 0))
          {
            localStringBuilder.append(localObject[j]);
            if ((this.dayCount > 1) && (k + 1 != this.dayCount))
            {
              localStringBuilder.append(", ");
              k++;
            }
          }
          j++;
        }
      }
      if (this.days[localStringBuilder] != 0) {
        this.dayCount = (1 + this.dayCount);
      }
    }
  }
  
  private static String hPad(int paramInt)
  {
    String str;
    if (paramInt <= 12)
    {
      if (paramInt != 0) {
        str = String.valueOf(paramInt);
      } else {
        str = String.valueOf(12);
      }
    }
    else {
      str = String.valueOf(paramInt - 12);
    }
    return str;
  }
  
  private static String pad(int paramInt)
  {
    String str;
    if (paramInt < 10) {
      str = "0" + String.valueOf(paramInt);
    } else {
      str = String.valueOf(paramInt);
    }
    return str;
  }
  
  private void setTimeDisplay(int paramInt1, int paramInt2)
  {
    this.mHour = paramInt1;
    this.mMinute = paramInt2;
    String str;
    if (!this.is24Hour)
    {
      if (this.mHour < 12) {
        str = hPad(this.mHour) + ":" + pad(this.mMinute) + " " + getString(R.string.AM);
      } else {
        str = hPad(this.mHour) + ":" + pad(this.mMinute) + " " + getString(R.string.PM);
      }
    }
    else {
      str = pad(this.mHour) + ":" + pad(this.mMinute);
    }
    this.time.setSummary(str);
  }
  
  private void updateActiveDisplay()
  {
    this.enable.setChecked(this.sched.isActive());
  }
  
  private void updateDaysDisplay()
  {
    this.days = this.sched.getRepeatDaysBooleanArray();
    displayDaysPicked();
  }
  
  private void updateDaysPicked(int paramInt, boolean paramBoolean)
  {
    this.days[paramInt] = paramBoolean;
  }
  
  private void updateTimeDisplay()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.sched.getTriggerTime());
    this.mHour = ((Calendar)localObject).get(11);
    this.mMinute = ((Calendar)localObject).get(12);
    if (!this.is24Hour)
    {
      if (this.mHour < 12) {
        localObject = hPad(this.mHour) + ":" + pad(this.mMinute) + " " + getString(R.string.AM);
      } else {
        localObject = hPad(this.mHour) + ":" + pad(this.mMinute) + " " + getString(R.string.PM);
      }
    }
    else {
      localObject = pad(this.mHour) + ":" + pad(this.mMinute);
    }
    this.time.setSummary((CharSequence)localObject);
  }
  
  private void updateVibrateDisplay()
  {
    this.vibrate.setChecked(this.sched.isVibrate());
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
    setContentView(R.layout.schedule);
    setFeatureDrawableResource(3, R.drawable.alarm_icon_title);
    addPreferencesFromResource(R.xml.alarm_prefs);
    this.profileId = getIntent().getIntExtra("profileId", -1);
    this.sched = Schedule.getOrCreateScheduleForProfile(this.profileId, this);
    this.is24Hour = DateFormat.is24HourFormat(this);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.sched.getTriggerTime());
    this.setHour = localCalendar.get(11);
    this.setMinute = localCalendar.get(12);
    this.time = findPreference("time");
    this.repeat = findPreference("repeat");
    this.enable = ((CheckBoxPreference)findPreference("enabled"));
    this.vibrate = ((CheckBoxPreference)findPreference("vibrateApply"));
    this.saveButton = ((Button)findViewById(R.id.saveButton));
    this.cancelButton = ((Button)findViewById(R.id.cancelButton));
    this.time.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
    {
      public boolean onPreferenceClick(Preference paramAnonymousPreference)
      {
        ScheduleActivity.this.showDialog(0);
        return false;
      }
    });
    this.repeat.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
    {
      public boolean onPreferenceClick(Preference paramAnonymousPreference)
      {
        ScheduleActivity.this.showDialog(1);
        return false;
      }
    });
    this.saveButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!ScheduleActivity.this.enable.isChecked())
        {
          ScheduleActivity.this.sched.deactivate();
          Toast.makeText(ScheduleActivity.this, R.string.scheduler_popup_status_disabled, 1).show();
        }
        else
        {
          if (ScheduleActivity.this.dayCount <= 0)
          {
            Toast.makeText(ScheduleActivity.this, R.string.select_days_toast, 0).show();
            return;
          }
          ScheduleActivity.this.sched.changeSettings(ScheduleActivity.this.days, ScheduleActivity.this.setHour, ScheduleActivity.this.setMinute, true, ScheduleActivity.this.vibrate.isChecked());
          Toast.makeText(ScheduleActivity.this, R.string.scheduler_popup_status_enabled, 1).show();
        }
        ScheduleActivity.this.finish();
      }
    });
    this.cancelButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ScheduleActivity.this.finish();
      }
    });
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
      break;
    case 0: 
      localObject = new TimePickerDialog(this, this.mTimeSetListener, this.mHour, this.mMinute, this.is24Hour);
      break;
    case 1: 
      localObject = new AlertDialog.Builder(this).setIcon(17301598).setTitle(getResources().getString(R.string.scheduler_popup_repeat)).setMultiChoiceItems(this.values, this.days, new DialogInterface.OnMultiChoiceClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          ScheduleActivity.this.updateDaysPicked(paramAnonymousInt, paramAnonymousBoolean);
        }
      }).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          ScheduleActivity.this.displayDaysPicked();
        }
      }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          ScheduleActivity.this.days = ScheduleActivity.this.sched.getRepeatDaysBooleanArray();
        }
      }).create();
    }
    return localObject;
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    case 0: 
      ((TimePickerDialog)paramDialog).updateTime(this.mHour, this.mMinute);
    }
  }
  
  protected void onStart()
  {
    updateActiveDisplay();
    updateTimeDisplay();
    updateDaysDisplay();
    updateVibrateDisplay();
    super.onStart();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.activities.ScheduleActivity
 * JD-Core Version:    0.7.0.1
 */