package com.smartschedule;

import java.util.Calendar;

import util.Util;

import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.database.SmartSystemDatabase;

import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager.OnCancelListener;
import android.app.TimePickerDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TimePicker;
import android.widget.Toast;

public class EventActivity extends Activity {
    private SmartSystemDatabase database = new SmartSystemDatabase(this);
    private SmartSchedulerDatabase smartScheduteDb = new SmartSchedulerDatabase(this);
    SampleAlarmReceiver alarm = new SampleAlarmReceiver();
    Button btn1 ;
    Button btn2 ;
    Button btn3 ;
    Button start_time ;
    Button end_time ;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 =  (Button)findViewById(R.id.button1);

        start_time =  (Button)findViewById(R.id.start_time);
        end_time =  (Button)findViewById(R.id.end_time);
        editText1 = (EditText)findViewById(R.id.editText1);
        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
              database.open();
              database.createData(100);
              database.close();

              smartScheduteDb.open();
              smartScheduteDb.createData("sample", "image", 123456, 1234567, 1, 1);
              smartScheduteDb.close();

            }
        });

        btn2 =  (Button)findViewById(R.id.button2);

        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
              database.open();
              String[] data = database.getCountData();
              database.close();

              smartScheduteDb.open();
              String data1  = smartScheduteDb.getAllData();
              smartScheduteDb.close();

              editText1.setText(data1 + "\n"+ data[0] + "\n" +  data[1] );
//              Toast.makeText(getApplicationContext(), data[0] + data[1], Toast.LENGTH_LONG).show();
            }
        });

        btn3 =  (Button)findViewById(R.id.button3);

        btn3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
              database.open();
              database.deleteAll();
              database.close();
              Toast.makeText(getApplicationContext(), "delete all table", Toast.LENGTH_LONG).show();
            }
        });


        start_time.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(EventActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        start_time.setText( Util.convertTime(selectedHour) + ":" + Util.convertTime(selectedMinute));
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
        end_time.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(EventActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        end_time.setText( Util.convertTime(selectedHour) + ":" + Util.convertTime(selectedMinute));
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
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
        case R.id.start_scheduler:

            alarm.setAlarm(this);
            return true;
        case R.id.cancel_scheduler:
            alarm.cancelAlarm(this);
            return true;
        }
        return false;
    }


}
