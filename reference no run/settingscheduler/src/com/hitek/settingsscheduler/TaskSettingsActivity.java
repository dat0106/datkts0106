package com.hitek.settingsscheduler;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TimePicker;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import java.text.DateFormatSymbols;
import java.util.Date;

public class TaskSettingsActivity
  extends Activity
  implements View.OnClickListener
{
  CheckBox friCheck;
  CheckBox monCheck;
  CheckBox satCheck;
  boolean startup = true;
  CheckBox sunCheck;
  String taskID;
  String taskType;
  Button taskTypeButton;
  Button taskValueButton;
  CheckBox thrCheck;
  TimePicker timePicker;
  CheckBox tueCheck;
  String value;
  CheckBox wedCheck;
  CheckBox week1Check;
  CheckBox week2Check;
  CheckBox week3Check;
  CheckBox week4Check;
  CheckBox week5Check;
  CheckBox week6Check;
  CheckBox weekEvenCheck;
  CheckBox weekOddCheck;
  
  private boolean allDaysUnchecked()
  {
    boolean bool;
    if ((this.sunCheck.isChecked()) || (this.monCheck.isChecked()) || (this.tueCheck.isChecked()) || (this.wedCheck.isChecked()) || (this.thrCheck.isChecked()) || (this.friCheck.isChecked()) || (this.satCheck.isChecked())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean allWeeksUnchecked()
  {
    boolean bool;
    if ((this.weekOddCheck.isChecked()) || (this.weekEvenCheck.isChecked()) || (this.week1Check.isChecked()) || (this.week2Check.isChecked()) || (this.week3Check.isChecked()) || (this.week4Check.isChecked()) || (this.week5Check.isChecked()) || (this.week6Check.isChecked())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void checkAllDays()
  {
    this.sunCheck.setChecked(true);
    this.monCheck.setChecked(true);
    this.tueCheck.setChecked(true);
    this.wedCheck.setChecked(true);
    this.thrCheck.setChecked(true);
    this.friCheck.setChecked(true);
    this.satCheck.setChecked(true);
  }
  
  public void onCancelClick(View paramView)
  {
    finish();
  }
  
  public void onClick(View paramView)
  {
    if (!((CheckBox)paramView).isChecked())
    {
      if (allWeeksUnchecked())
      {
        this.weekOddCheck.setChecked(true);
        this.weekEvenCheck.setChecked(true);
      }
    }
    else
    {
      this.weekOddCheck.setChecked(false);
      this.weekEvenCheck.setChecked(false);
    }
  }
  
  public void onClickTaskTypeButton(View paramView)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    final String[] arrayOfString = new TaskTypes(this).getTaskTypesArray();
    localBuilder.setItems(arrayOfString, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        String str1 = arrayOfString[paramAnonymousInt];
        TaskSettingsActivity.this.taskTypeButton.setText(str1);
        if ((!str1.equals(TaskSettingsActivity.this.getResources().getString(2131034119))) && (!str1.equals(TaskSettingsActivity.this.getResources().getString(2131034120))) && (!str1.equals(TaskSettingsActivity.this.getResources().getString(2131034121))) && (!str1.equals(TaskSettingsActivity.this.getResources().getString(2131034122))) && (!str1.equals(TaskSettingsActivity.this.getResources().getString(2131034131) + "-" + TaskSettingsActivity.this.getResources().getString(2131034132))) && (!str1.equals(TaskSettingsActivity.this.getResources().getString(2131034130))))
        {
          String[] arrayOfString;
          String str3;
          int j;
          int i;
          if (!str1.equals(TaskSettingsActivity.this.getResources().getString(2131034129)))
          {
            if ((str1.equals(TaskSettingsActivity.this.getResources().getString(2131034131))) || (str1.equals(TaskSettingsActivity.this.getResources().getString(2131034123) + "-" + TaskSettingsActivity.this.getResources().getString(2131034125))) || (str1.equals(TaskSettingsActivity.this.getResources().getString(2131034123) + "-" + TaskSettingsActivity.this.getResources().getString(2131034124))) || (str1.equals(TaskSettingsActivity.this.getResources().getString(2131034123) + "-" + TaskSettingsActivity.this.getResources().getString(2131034127))) || (str1.equals(TaskSettingsActivity.this.getResources().getString(2131034123) + "-" + TaskSettingsActivity.this.getResources().getString(2131034128))) || (str1.equals(TaskSettingsActivity.this.getResources().getString(2131034123) + "-" + TaskSettingsActivity.this.getResources().getString(2131034126))))
            {
              arrayOfString = new String[11];
              arrayOfString[0] = "0";
              arrayOfString[1] = "10";
              arrayOfString[2] = "20";
              arrayOfString[3] = "30";
              arrayOfString[4] = "40";
              arrayOfString[5] = "50";
              arrayOfString[6] = "60";
              arrayOfString[7] = "70";
              arrayOfString[8] = "80";
              arrayOfString[9] = "90";
              arrayOfString[10] = "100";
              str3 = TaskSettingsActivity.this.taskValueButton.getText().toString();
              j = 0;
              for (i = 0; i < arrayOfString.length; i++) {
                if (arrayOfString[i].equals(str3))
                {
                  j = 1;
                  TaskSettingsActivity.this.value = arrayOfString[i];
                }
              }
              if (j == 0)
              {
                TaskSettingsActivity.this.taskValueButton.setText(arrayOfString[6]);
                TaskSettingsActivity.this.value = arrayOfString[6];
              }
            }
          }
          else
          {
            arrayOfString = new String[12];
            arrayOfString[0] = "0.5";
            arrayOfString[1] = "1";
            arrayOfString[2] = "2";
            arrayOfString[3] = "3";
            arrayOfString[4] = "5";
            arrayOfString[5] = "7";
            arrayOfString[6] = "10";
            arrayOfString[7] = "15";
            arrayOfString[8] = "20";
            arrayOfString[9] = "30";
            arrayOfString[10] = "45";
            arrayOfString[11] = "60";
            str3 = TaskSettingsActivity.this.taskValueButton.getText().toString();
            i = 0;
            for (j = 0; j < arrayOfString.length; j++) {
              if (arrayOfString[j].equals(str3))
              {
                i = 1;
                TaskSettingsActivity.this.value = arrayOfString[j];
              }
            }
            if (i == 0)
            {
              TaskSettingsActivity.this.taskValueButton.setText(arrayOfString[1]);
              TaskSettingsActivity.this.value = arrayOfString[1];
            }
          }
        }
        else
        {
          String str2 = TaskSettingsActivity.this.taskValueButton.getText().toString();
          if ((!str2.equals(TaskSettingsActivity.this.getResources().getString(2131034118))) && (!str2.equals(TaskSettingsActivity.this.getResources().getString(2131034117))))
          {
            TaskSettingsActivity.this.taskValueButton.setText(TaskSettingsActivity.this.getResources().getString(2131034117));
            TaskSettingsActivity.this.value = "on";
          }
        }
      }
    });
    localBuilder.create().show();
  }
  
  public void onClickTaskValueButton(View paramView)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    Object localObject = this.taskTypeButton.getText().toString();
    localBuilder.setTitle((CharSequence)localObject);
    localBuilder.setIcon(2130837513);
    if ((!((String)localObject).equals(getResources().getString(2131034119))) && (!((String)localObject).equals(getResources().getString(2131034120))) && (!((String)localObject).equals(getResources().getString(2131034121))) && (!((String)localObject).equals(getResources().getString(2131034122))) && (!((String)localObject).equals(getResources().getString(2131034131) + "-" + getResources().getString(2131034132))) && (!((String)localObject).equals(getResources().getString(2131034130))))
    {
      if (!((String)localObject).equals(getResources().getString(2131034129)))
      {
        if ((((String)localObject).equals(getResources().getString(2131034131))) || (((String)localObject).equals(getResources().getString(2131034123) + "-" + getResources().getString(2131034125))) || (((String)localObject).equals(getResources().getString(2131034123) + "-" + getResources().getString(2131034124))) || (((String)localObject).equals(getResources().getString(2131034123) + "-" + getResources().getString(2131034127))) || (((String)localObject).equals(getResources().getString(2131034123) + "-" + getResources().getString(2131034128))) || (((String)localObject).equals(getResources().getString(2131034123) + "-" + getResources().getString(2131034126))))
        {
          localObject = new String[11];
          localObject[0] = "0";
          localObject[1] = "10";
          localObject[2] = "20";
          localObject[3] = "30";
          localObject[4] = "40";
          localObject[5] = "50";
          localObject[6] = "60";
          localObject[7] = "70";
          localObject[8] = "80";
          localObject[9] = "90";
          localObject[10] = "100";
          localBuilder.setItems((CharSequence[])localObject, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              TaskSettingsActivity.this.taskValueButton.setText(this.val$items[paramAnonymousInt]);
              TaskSettingsActivity.this.value = this.val$items[paramAnonymousInt];
            }
          });
          localBuilder.create().show();
        }
      }
      else
      {
        localObject = new String[15];
        localObject[0] = "0.5";
        localObject[1] = "1";
        localObject[2] = "2";
        localObject[3] = "3";
        localObject[4] = "5";
        localObject[5] = "7";
        localObject[6] = "10";
        localObject[7] = "15";
        localObject[8] = "20";
        localObject[9] = "30";
        localObject[10] = "45";
        localObject[11] = "60";
        localObject[12] = "120";
        localObject[13] = "300";
        localObject[14] = "900";
        localBuilder.setItems((CharSequence[])localObject, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            TaskSettingsActivity.this.taskValueButton.setText(this.val$items[paramAnonymousInt]);
            TaskSettingsActivity.this.value = this.val$items[paramAnonymousInt];
          }
        });
        localBuilder.create().show();
      }
    }
    else
    {
      final CheckBox localCheckBox = new CheckBox(this);
      localObject = new RelativeLayout(this);
      ((RelativeLayout)localObject).setGravity(1);
      ((RelativeLayout)localObject).setPadding(0, 25, 0, 25);
      ((RelativeLayout)localObject).addView(localCheckBox);
      localBuilder.setView((View)localObject);
      localBuilder.setPositiveButton(getResources().getString(17039370), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          TaskSettingsActivity.this.value = "off";
          TaskSettingsActivity.this.taskValueButton.setText(TaskSettingsActivity.this.getResources().getString(2131034118));
          if (localCheckBox.isChecked())
          {
            TaskSettingsActivity.this.value = "on";
            TaskSettingsActivity.this.taskValueButton.setText(TaskSettingsActivity.this.getResources().getString(2131034117));
          }
        }
      });
      localBuilder.setNegativeButton(getResources().getString(17039360), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      localBuilder.show();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    this.timePicker = ((TimePicker)findViewById(2131296266));
    this.taskTypeButton = ((Button)findViewById(2131296264));
    this.taskTypeButton.setText(getResources().getString(2131034119));
    this.taskValueButton = ((Button)findViewById(2131296265));
    this.taskValueButton.setText(getResources().getString(2131034117));
    this.value = getResources().getString(2131034117);
    ((TextView)findViewById(2131296275)).setText(getResources().getString(2131034133) + " - " + getResources().getString(2131034134));
    ((TextView)findViewById(2131296282)).setText(getResources().getString(2131034133) + " - " + getResources().getString(2131034135));
    Object localObject1 = new DateFormatSymbols().getWeekdays();
    this.sunCheck = ((CheckBox)findViewById(2131296268));
    this.sunCheck.setText(localObject1[1]);
    this.sunCheck.setChecked(true);
    this.monCheck = ((CheckBox)findViewById(2131296269));
    this.monCheck.setText(localObject1[2]);
    this.monCheck.setChecked(true);
    this.tueCheck = ((CheckBox)findViewById(2131296270));
    this.tueCheck.setText(localObject1[3]);
    this.tueCheck.setChecked(true);
    this.wedCheck = ((CheckBox)findViewById(2131296271));
    this.wedCheck.setText(localObject1[4]);
    this.wedCheck.setChecked(true);
    this.thrCheck = ((CheckBox)findViewById(2131296272));
    this.thrCheck.setText(localObject1[5]);
    this.thrCheck.setChecked(true);
    this.friCheck = ((CheckBox)findViewById(2131296273));
    this.friCheck.setText(localObject1[6]);
    this.friCheck.setChecked(true);
    this.satCheck = ((CheckBox)findViewById(2131296274));
    this.satCheck.setText(localObject1[7]);
    this.satCheck.setChecked(true);
    this.week1Check = ((CheckBox)findViewById(2131296276));
    this.week1Check.setText("1");
    this.week1Check.setChecked(true);
    this.week2Check = ((CheckBox)findViewById(2131296277));
    this.week2Check.setText("2");
    this.week2Check.setChecked(true);
    this.week3Check = ((CheckBox)findViewById(2131296278));
    this.week3Check.setText("3");
    this.week3Check.setChecked(true);
    this.week4Check = ((CheckBox)findViewById(2131296279));
    this.week4Check.setText("4");
    this.week4Check.setChecked(true);
    this.week5Check = ((CheckBox)findViewById(2131296280));
    this.week5Check.setText("5");
    this.week5Check.setChecked(true);
    this.week6Check = ((CheckBox)findViewById(2131296281));
    this.week6Check.setText("6");
    this.week6Check.setChecked(true);
    this.weekOddCheck = ((CheckBox)findViewById(2131296283));
    this.weekOddCheck.setText("1, 3....51, 53");
    this.weekEvenCheck = ((CheckBox)findViewById(2131296284));
    this.weekEvenCheck.setText("2, 4....50, 52");
    this.week1Check.setOnClickListener(this);
    this.week2Check.setOnClickListener(this);
    this.week3Check.setOnClickListener(this);
    this.week4Check.setOnClickListener(this);
    this.week5Check.setOnClickListener(this);
    this.week6Check.setOnClickListener(this);
    this.weekOddCheck.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!((CheckBox)paramAnonymousView).isChecked())
        {
          if (TaskSettingsActivity.this.allWeeksUnchecked())
          {
            TaskSettingsActivity.this.week1Check.setChecked(true);
            TaskSettingsActivity.this.week2Check.setChecked(true);
            TaskSettingsActivity.this.week3Check.setChecked(true);
            TaskSettingsActivity.this.week4Check.setChecked(true);
            TaskSettingsActivity.this.week5Check.setChecked(true);
            TaskSettingsActivity.this.week6Check.setChecked(true);
          }
        }
        else
        {
          TaskSettingsActivity.this.week1Check.setChecked(false);
          TaskSettingsActivity.this.week2Check.setChecked(false);
          TaskSettingsActivity.this.week3Check.setChecked(false);
          TaskSettingsActivity.this.week4Check.setChecked(false);
          TaskSettingsActivity.this.week5Check.setChecked(false);
          TaskSettingsActivity.this.week6Check.setChecked(false);
        }
      }
    });
    this.weekEvenCheck.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!((CheckBox)paramAnonymousView).isChecked())
        {
          if (TaskSettingsActivity.this.allWeeksUnchecked())
          {
            TaskSettingsActivity.this.week1Check.setChecked(true);
            TaskSettingsActivity.this.week2Check.setChecked(true);
            TaskSettingsActivity.this.week3Check.setChecked(true);
            TaskSettingsActivity.this.week4Check.setChecked(true);
            TaskSettingsActivity.this.week5Check.setChecked(true);
            TaskSettingsActivity.this.week6Check.setChecked(true);
          }
        }
        else
        {
          TaskSettingsActivity.this.week1Check.setChecked(false);
          TaskSettingsActivity.this.week2Check.setChecked(false);
          TaskSettingsActivity.this.week3Check.setChecked(false);
          TaskSettingsActivity.this.week4Check.setChecked(false);
          TaskSettingsActivity.this.week5Check.setChecked(false);
          TaskSettingsActivity.this.week6Check.setChecked(false);
        }
      }
    });
    this.sunCheck.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (TaskSettingsActivity.this.allDaysUnchecked()) {
          TaskSettingsActivity.this.checkAllDays();
        }
      }
    });
    this.monCheck.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (TaskSettingsActivity.this.allDaysUnchecked()) {
          TaskSettingsActivity.this.checkAllDays();
        }
      }
    });
    this.tueCheck.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (TaskSettingsActivity.this.allDaysUnchecked()) {
          TaskSettingsActivity.this.checkAllDays();
        }
      }
    });
    this.wedCheck.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (TaskSettingsActivity.this.allDaysUnchecked()) {
          TaskSettingsActivity.this.checkAllDays();
        }
      }
    });
    this.thrCheck.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (TaskSettingsActivity.this.allDaysUnchecked()) {
          TaskSettingsActivity.this.checkAllDays();
        }
      }
    });
    this.friCheck.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (TaskSettingsActivity.this.allDaysUnchecked()) {
          TaskSettingsActivity.this.checkAllDays();
        }
      }
    });
    this.satCheck.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (TaskSettingsActivity.this.allDaysUnchecked()) {
          TaskSettingsActivity.this.checkAllDays();
        }
      }
    });
    localObject1 = new AdView(this, AdSize.BANNER, "a150d239823e1fa");
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131296260);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new AdRequest();
    ((AdRequest)localObject2).addTestDevice(AdRequest.TEST_EMULATOR);
    ((AdRequest)localObject2).addTestDevice("079375A20A34061F38A0100D6952E95B");
    ((AdView)localObject1).loadAd((AdRequest)localObject2);
    this.taskID = getIntent().getStringExtra("taskID");
    if (this.taskID.length() == 0) {
      return;
    }
    localObject1 = getSharedPreferences("Tasks", 4);
    int i = 0;
    try
    {
      i = Integer.parseInt(((SharedPreferences)localObject1).getString("taskType_" + this.taskID, "0"));
      i = i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label1022:
      break label1022;
    }
    this.taskType = new TaskTypes(this).getTaskTypeString(i);
    this.taskTypeButton.setText(this.taskType);
    this.value = ((SharedPreferences)localObject1).getString("value_" + this.taskID, "");
    if (this.value.equals("on")) {
      this.taskValueButton.setText(getResources().getString(2131034117));
    }
    for (;;)
    {
      this.timePicker.setCurrentHour(Integer.valueOf(Integer.parseInt(((SharedPreferences)localObject1).getString("hour_" + this.taskID, "12"))));
      this.timePicker.setCurrentMinute(Integer.valueOf(Integer.parseInt(((SharedPreferences)localObject1).getString("minute_" + this.taskID, "00"))));
      this.sunCheck.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("sunday_" + this.taskID, "true")).booleanValue());
      this.monCheck.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("monday_" + this.taskID, "true")).booleanValue());
      this.tueCheck.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("tuesday_" + this.taskID, "true")).booleanValue());
      this.wedCheck.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("wednesday_" + this.taskID, "true")).booleanValue());
      this.thrCheck.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("thursday_" + this.taskID, "true")).booleanValue());
      this.friCheck.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("friday_" + this.taskID, "true")).booleanValue());
      this.satCheck.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("saturday_" + this.taskID, "true")).booleanValue());
      this.week1Check.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("week1_" + this.taskID, "true")).booleanValue());
      this.week2Check.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("week2_" + this.taskID, "true")).booleanValue());
      this.week3Check.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("week3_" + this.taskID, "true")).booleanValue());
      this.week4Check.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("week4_" + this.taskID, "true")).booleanValue());
      this.week5Check.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("week5_" + this.taskID, "true")).booleanValue());
      this.week6Check.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("week6_" + this.taskID, "true")).booleanValue());
      this.weekOddCheck.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("weekOdd_" + this.taskID, "true")).booleanValue());
      this.weekEvenCheck.setChecked(Boolean.valueOf(((SharedPreferences)localObject1).getString("weekEven_" + this.taskID, "true")).booleanValue());
      break;
      if (this.value.equals("off")) {
        this.taskValueButton.setText(getResources().getString(2131034118));
      } else {
        this.taskValueButton.setText(this.value);
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return false;
  }
  
  public void onSaveClick(View paramView)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences("Tasks", 4).edit();
    if (this.taskID.length() == 0) {
      this.taskID = Long.toString(new Date().getTime());
    }
    localEditor.putString("taskID_" + this.taskID, this.taskID);
    localEditor.putString("enabled_" + this.taskID, "true");
    this.taskType = this.taskTypeButton.getText().toString();
    int i = new TaskTypes(this).getTaskTypeIndex(this.taskType);
    localEditor.putString("taskType_" + this.taskID, Integer.toString(i));
    localEditor.putString("value_" + this.taskID, this.value);
    this.timePicker.clearFocus();
    localEditor.putString("hour_" + this.taskID, Integer.toString(this.timePicker.getCurrentHour().intValue()));
    localEditor.putString("minute_" + this.taskID, Integer.toString(this.timePicker.getCurrentMinute().intValue()));
    localEditor.putString("sunday_" + this.taskID, Boolean.toString(this.sunCheck.isChecked()));
    localEditor.putString("monday_" + this.taskID, Boolean.toString(this.monCheck.isChecked()));
    localEditor.putString("tuesday_" + this.taskID, Boolean.toString(this.tueCheck.isChecked()));
    localEditor.putString("wednesday_" + this.taskID, Boolean.toString(this.wedCheck.isChecked()));
    localEditor.putString("thursday_" + this.taskID, Boolean.toString(this.thrCheck.isChecked()));
    localEditor.putString("friday_" + this.taskID, Boolean.toString(this.friCheck.isChecked()));
    localEditor.putString("saturday_" + this.taskID, Boolean.toString(this.satCheck.isChecked()));
    localEditor.putString("week1_" + this.taskID, Boolean.toString(this.week1Check.isChecked()));
    localEditor.putString("week2_" + this.taskID, Boolean.toString(this.week2Check.isChecked()));
    localEditor.putString("week3_" + this.taskID, Boolean.toString(this.week3Check.isChecked()));
    localEditor.putString("week4_" + this.taskID, Boolean.toString(this.week4Check.isChecked()));
    localEditor.putString("week5_" + this.taskID, Boolean.toString(this.week5Check.isChecked()));
    localEditor.putString("week6_" + this.taskID, Boolean.toString(this.week6Check.isChecked()));
    localEditor.putString("weekOdd_" + this.taskID, Boolean.toString(this.weekOddCheck.isChecked()));
    localEditor.putString("weekEven_" + this.taskID, Boolean.toString(this.weekEvenCheck.isChecked()));
    localEditor.commit();
    new ScheduleManager(this).scheduleTask(this.taskID);
    finish();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.hitek.settingsscheduler.TaskSettingsActivity
 * JD-Core Version:    0.7.0.1
 */