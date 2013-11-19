package com.sonyericsson.extras.liveware.ui;

import android.app.ActionBar;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.sonyericsson.bidi.BidiUtils;
import com.sonyericsson.extras.liveware.experience.Time;
import com.sonyericsson.extras.liveware.utils.AsfTimeUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.SyncedProperty;
import java.util.TimeZone;

public class TimeTriggerActivity
  extends BaseActivity
{
  private static final long DEFAULT_TIME_DIFF = 3600000L;
  private static final String DIALOG_SET_START_TIME = "dialog_start_time";
  private static final String DIALOG_SET_STOP_TIME = "dialog_stop_time";
  private static final String DIALOG_SET_WEEK_DAYS = "dialog_week_days";
  public static final String EXTRA_START_TIME = "start_time";
  public static final String EXTRA_STOP_TIME = "stop_time";
  public static final String EXTRA_WEEKDAYS = "weekdays";
  private static final String NO_TIME_STRING = "--:--";
  private MenuItem mDoneActionItem;
  private View mDoneButton;
  private Button mFromButton;
  private TextView mRepeatValueView;
  private View mRepeatView;
  SyncedProperty<Boolean> mSaved = new SyncedProperty(Boolean.valueOf(false));
  private Long mStartTime;
  private Long mStopTime;
  private Button mToButton;
  private int mWeekDays = 254;
  
  private long addTime(long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L) {
      paramLong2 += 86400000L;
    }
    return (paramLong1 + paramLong2) % 86400000L;
  }
  
  public static Intent createIntent(Context paramContext, Time paramTime)
  {
    Intent localIntent = new Intent(paramContext, TimeTriggerActivity.class);
    if (paramTime != null)
    {
      localIntent.putExtra("start_time", paramTime.getStartTime());
      localIntent.putExtra("stop_time", paramTime.getStopTime());
      localIntent.putExtra("weekdays", paramTime.getDaysRaw());
    }
    return localIntent;
  }
  
  private long getCurrentTime()
  {
    long l = System.currentTimeMillis();
    return l + TimeZone.getDefault().getOffset(l) - AsfTimeUtils.getMidnight(false);
  }
  
  private Button getFromButton(View paramView)
  {
    Button localButton;
    if (BidiUtils.shouldMirror(paramView.findViewById(2131558538))) {
      localButton = (Button)paramView.findViewById(2131558542);
    } else {
      localButton = (Button)paramView.findViewById(2131558541);
    }
    return localButton;
  }
  
  private Button getToButton(View paramView)
  {
    Button localButton;
    if (BidiUtils.shouldMirror(paramView.findViewById(2131558538))) {
      localButton = (Button)paramView.findViewById(2131558541);
    } else {
      localButton = (Button)paramView.findViewById(2131558542);
    }
    return localButton;
  }
  
  private void onCancel()
  {
    finish();
  }
  
  private void onDone()
  {
    if ((this.mStartTime == null) || (this.mStopTime == null))
    {
      setResult(-1, new Intent());
    }
    else
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("start_time", this.mStartTime);
      localIntent.putExtra("stop_time", this.mStopTime);
      localIntent.putExtra("weekdays", this.mWeekDays);
      setResult(-1, localIntent);
    }
    finish();
  }
  
  private void renderView()
  {
    if (this.mStartTime == null) {
      this.mFromButton.setText("--:--");
    } else {
      this.mFromButton.setText(AsfTimeUtils.getFormattedTime(this.mStartTime.longValue(), this));
    }
    if (this.mStopTime == null) {
      this.mToButton.setText("--:--");
    } else {
      this.mToButton.setText(AsfTimeUtils.getFormattedTime(this.mStopTime.longValue(), this));
    }
    renderWeekDays();
    updateDoneEnable();
  }
  
  private void renderWeekDays()
  {
    if (this.mWeekDays != 254) {
      this.mRepeatValueView.setText(AsfTimeUtils.getFormattedWeekDays(this.mWeekDays, 20));
    } else {
      this.mRepeatValueView.setText(2131099935);
    }
  }
  
  private void showFragmentDialog(String paramString, DialogFragment paramDialogFragment)
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    if (getFragmentManager().findFragmentByTag(paramString) == null)
    {
      localFragmentTransaction.addToBackStack(null);
      paramDialogFragment.show(localFragmentTransaction, paramString);
    }
  }
  
  private void updateDoneEnable()
  {
    boolean bool;
    if (this.mStartTime == null) {
      bool = false;
    } else {
      bool = true;
    }
    if (this.mDoneButton != null) {
      this.mDoneButton.setEnabled(bool);
    }
    if (this.mDoneActionItem != null) {
      this.mDoneActionItem.setEnabled(bool);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    View localView = LayoutInflater.from(this).inflate(2130903088, null);
    setContentView(localView);
    this.mFromButton = getFromButton(localView);
    this.mToButton = getToButton(localView);
    this.mDoneButton = ((Button)localView.findViewById(2131558457));
    this.mRepeatView = localView.findViewById(2131558543);
    this.mRepeatValueView = ((TextView)localView.findViewById(2131558545));
    if (paramBundle == null)
    {
      localObject = getIntent().getExtras();
      if (localObject != null)
      {
        this.mStartTime = Long.valueOf(((Bundle)localObject).getLong("start_time", 0L));
        this.mStopTime = Long.valueOf(((Bundle)localObject).getLong("stop_time", 0L));
        this.mWeekDays = ((Bundle)localObject).getInt("weekdays", 254);
      }
    }
    else
    {
      if (paramBundle.containsKey("start_time")) {
        this.mStartTime = Long.valueOf(paramBundle.getLong("start_time"));
      }
      if (paramBundle.containsKey("stop_time")) {
        this.mStopTime = Long.valueOf(paramBundle.getLong("stop_time"));
      }
      if (paramBundle.containsKey("weekdays")) {
        this.mWeekDays = paramBundle.getInt("weekdays", 254);
      }
    }
    renderView();
    this.mFromButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!((Boolean)TimeTriggerActivity.this.mSaved.get()).booleanValue())
        {
          long l;
          if (TimeTriggerActivity.this.mStartTime == null) {
            l = TimeTriggerActivity.this.getCurrentTime();
          } else {
            l = TimeTriggerActivity.this.mStartTime.longValue();
          }
          SetTimeDialog localSetTimeDialog = SetTimeDialog.newInstance(l, true);
          TimeTriggerActivity.this.showFragmentDialog("dialog_start_time", localSetTimeDialog);
        }
        else
        {
          Dbg.w("TimeTriggerActivity mFromButton.onClick ignored");
        }
      }
    });
    this.mToButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!((Boolean)TimeTriggerActivity.this.mSaved.get()).booleanValue())
        {
          long l;
          if (TimeTriggerActivity.this.mStopTime == null) {
            l = TimeTriggerActivity.this.addTime(TimeTriggerActivity.access$1(TimeTriggerActivity.this), 3600000L);
          } else {
            l = TimeTriggerActivity.this.mStopTime.longValue();
          }
          SetTimeDialog localSetTimeDialog = SetTimeDialog.newInstance(l, false);
          TimeTriggerActivity.this.showFragmentDialog("dialog_stop_time", localSetTimeDialog);
        }
        else
        {
          Dbg.w("TimeTriggerActivity mToButton.onClick ignored");
        }
      }
    });
    this.mRepeatView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!((Boolean)TimeTriggerActivity.this.mSaved.get()).booleanValue())
        {
          ChooseWeekDaysDialog localChooseWeekDaysDialog = ChooseWeekDaysDialog.newInstance(TimeTriggerActivity.this.mWeekDays);
          TimeTriggerActivity.this.showFragmentDialog("dialog_week_days", localChooseWeekDaysDialog);
        }
        else
        {
          Dbg.w("TimeTriggerActivity mRepeatView.onClick ignored");
        }
      }
    });
    if (this.mDoneButton != null) {
      this.mDoneButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          TimeTriggerActivity.this.onDone();
        }
      });
    }
    Object localObject = (Button)localView.findViewById(2131558456);
    if (localObject != null) {
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          TimeTriggerActivity.this.onCancel();
        }
      });
    }
    getActionBar().setDisplayHomeAsUpEnabled(true);
    setTitle(2131099828);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131689472, paramMenu);
    this.mDoneActionItem = paramMenu.findItem(2131558549);
    updateDoneEnable();
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = false;
      break;
    case 16908332: 
      finish();
      break;
    case 2131558548: 
      onCancel();
      break;
    case 2131558549: 
      onDone();
    }
    return bool;
  }
  
  public void onResume()
  {
    super.onResume();
    this.mSaved.set(Boolean.valueOf(false));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mSaved.set(Boolean.valueOf(true));
    if (this.mStartTime != null) {
      paramBundle.putLong("start_time", this.mStartTime.longValue());
    }
    if (this.mStopTime != null) {
      paramBundle.putLong("stop_time", this.mStopTime.longValue());
    }
    paramBundle.putInt("weekdays", this.mWeekDays);
  }
  
  public void onStartTimeSet(long paramLong)
  {
    long l;
    if ((this.mStopTime == null) || (this.mStartTime == null)) {
      l = 3600000L;
    } else {
      l = this.mStopTime.longValue() - this.mStartTime.longValue();
    }
    this.mStartTime = Long.valueOf(paramLong);
    this.mStopTime = Long.valueOf(addTime(this.mStartTime.longValue(), l));
    renderView();
  }
  
  public void onStopTimeSet(long paramLong)
  {
    if (this.mStartTime != null)
    {
      if (paramLong == this.mStartTime.longValue())
      {
        Toast.makeText(this, 2131099830, 0).show();
        paramLong = addTime(paramLong, 3600000L);
      }
    }
    else {
      this.mStartTime = Long.valueOf(addTime(paramLong, -3600000L));
    }
    this.mStopTime = Long.valueOf(paramLong);
    renderView();
  }
  
  public void onWeekDaysSet(int paramInt)
  {
    this.mWeekDays = paramInt;
    renderView();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.TimeTriggerActivity
 * JD-Core Version:    0.7.0.1
 */