package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import com.sonyericsson.extras.liveware.utils.AsfTimeUtils;

public class SetTimeDialog
  extends DialogFragment
{
  static final String IS_START_TIME = "is_start_time";
  static final String TIME = "time";
  private Activity mActivity;
  private boolean mStartTime;
  private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener()
  {
    public void onTimeSet(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (!SetTimeDialog.this.mStartTime) {
        ((TimeTriggerActivity)SetTimeDialog.this.mActivity).onStopTimeSet(3600000L * paramAnonymousInt1 + 60000L * paramAnonymousInt2);
      } else {
        ((TimeTriggerActivity)SetTimeDialog.this.mActivity).onStartTimeSet(3600000L * paramAnonymousInt1 + 60000L * paramAnonymousInt2);
      }
    }
  };
  
  public static SetTimeDialog newInstance(long paramLong, boolean paramBoolean)
  {
    SetTimeDialog localSetTimeDialog = new SetTimeDialog();
    Bundle localBundle = new Bundle();
    localBundle.putLong("time", paramLong);
    localBundle.putBoolean("is_start_time", paramBoolean);
    localSetTimeDialog.setArguments(localBundle);
    return localSetTimeDialog;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    long l = getArguments().getLong("time");
    this.mStartTime = getArguments().getBoolean("is_start_time");
    return new TimePickerDialog(this.mActivity, this.mTimeSetListener, AsfTimeUtils.getHours(l), AsfTimeUtils.getMinutes(l), DateFormat.is24HourFormat(this.mActivity));
  }
  
  public void onStart()
  {
    super.onStart();
    setRetainInstance(true);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.mActivity.isChangingConfigurations()) {
      setRetainInstance(false);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.SetTimeDialog
 * JD-Core Version:    0.7.0.1
 */