package com.smartschedule;

import java.util.Calendar;

import com.smartschedule.action.ActivitySoundManager;
import com.smartschedule.action.DialogSoundManager;
import com.smartschedule.database.Event;
import com.smartschedule.database.SmartSchedulerDatabase;
import com.smartschedule.util.Constant;
import com.smartschedule.util.Util;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TimePicker;
import android.widget.Toast;

public class EventTimeActivity extends Activity {
    private SmartSchedulerDatabase smartScheduleDb = new SmartSchedulerDatabase(
            this);
    ScheduleServiceReceiver schedule = new ScheduleServiceReceiver();
    Button btn1;
    Button btn2;
    Button btn3;
    Button btnTest;
    Button start_time;
    Button end_time;
    EditText editText1;
    // protected int start_time_hour;
    // protected int start_time_minute;
    // protected int end_time_hour;
    // protected int end_time_minute;
    // private int event_id;
    private Event contentValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        getData(intent.getExtras().getInt(
                SmartSchedulerDatabase.COLUMN_EVENT_ID));

        btn1 = (Button) findViewById(R.id.button1);

        start_time = (Button) findViewById(R.id.start_time);
        start_time
                .setText(Util.convertTime(contentValues
                        .getTimeStartHour())
                        + ":"
                        + Util.convertTime(contentValues.getTimeStartMinute()));
        end_time = (Button) findViewById(R.id.end_time);
        end_time.setText(Util.convertTime(contentValues.getTimeEndHour())
                + ":"
                + Util.convertTime(contentValues.getTimeEndMinute()));
        editText1 = (EditText) findViewById(R.id.editText1);
        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(EventTimeActivity.this,
                        EventDetailActivity.class);
                i.putExtra(
                        SmartSchedulerDatabase.COLUMN_EVENT_ID,
                        contentValues.getId());
                i.putExtra(
                        Constant.START_OR_END, SmartSchedulerDatabase.COLUMN_ACTION_START_ID);
                startActivity(i);

            }
        });

        btn2 = (Button) findViewById(R.id.button2);

        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                smartScheduleDb.open();
                String data1 = smartScheduleDb.getAllData();
                smartScheduleDb.close();
            }
        });

        btn3 = (Button) findViewById(R.id.button3);

        btn3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "delete all table",
                        Toast.LENGTH_LONG).show();
            }
        });

        start_time.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Calendar mcurrentTime = Calendar.getInstance();

                int hour;
                if (contentValues.getTimeStartHour() == null) {
                    hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                } else {
                    hour = contentValues.getTimeStartHour();
                }
                int minute;
                if (contentValues.getTimeStartMinute() == null) {
                    minute = mcurrentTime.get(Calendar.MINUTE);
                } else {
                    minute = contentValues.getTimeStartMinute();
                }
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(EventTimeActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker,
                                    int selectedHour, int selectedMinute) {

                                contentValues.setTimeStartHour(selectedHour);
                                contentValues.setTimeStartMinute(selectedMinute);

                                start_time.setText(Util
                                        .convertTime(selectedHour)
                                        + ":"
                                        + Util.convertTime(selectedMinute));
                            }
                        }, hour, minute, true);// Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
        end_time.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour;
                if (contentValues.getTimeEndHour() == null) {
                    hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                } else {
                    hour = contentValues.getTimeEndHour();
                }
                int minute;
                if (contentValues.getTimeEndMinute()== null) {
                    minute = mcurrentTime.get(Calendar.MINUTE);
                } else {
                    minute = contentValues.getTimeEndMinute();
                }
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(EventTimeActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker,
                                    int selectedHour, int selectedMinute) {
                                contentValues.setTimeEndHour(selectedHour);
                                contentValues.setTimeEndMinute(selectedMinute);

                                end_time.setText(Util.convertTime(selectedHour)
                                        + ":"
                                        + Util.convertTime(selectedMinute));
                            }
                        }, hour, minute, true);// Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        test();
    }

    private void test() {
        btnTest = (Button) findViewById(R.id.button_test);

        btnTest.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // AlertDialog.Builder builder = new
                // DialogSoundManager(EventActivity.this);
                //
                // final AlertDialog dialog = builder.create();
                // dialog.show();

                Intent i = new Intent(EventTimeActivity.this,
                        ActivitySoundManager.class);
                i.putExtra(
                        SmartSchedulerDatabase.COLUMN_EVENT_ID,
                        contentValues.getId());
                i.putExtra(
                        Constant.START_OR_END, SmartSchedulerDatabase.COLUMN_ACTION_START_ID);
                startActivityForResult(i, Constant.SOUND_MANAGER_REQUEST_CODE);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // @Override
    // public boolean onOptionsItemSelected(MenuItem item) {
    // switch (item.getItemId()) {
    // // when the user click start schedule
    // case android.R.id.home:
    // // Navigate "up" the demo structure to the launchpad activity.
    // // for more.
    // NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
    // return true;
    // case R.id.done_scheduler:
    // schedule.setAlarm(this);
    // return true;
    // case R.id.cancel_scheduler:
    // schedule.cancelAlarm(this);
    // return true;
    // }
    // return false;
    // }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        // when the user click start schedule
        case android.R.id.home:
            // Navigate "up" the demo structure to the launchpad activity.
            // for more.
            NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
            return true;
        case R.id.done:
            // update state
            contentValues.setState(1);
            ContentValues cv = new ContentValues();
            cv.put(SmartSchedulerDatabase.COLUMN_EVENT_TIME_START_HOUR,
                    contentValues.getTimeStartHour());
            cv.put(SmartSchedulerDatabase.COLUMN_EVENT_TIME_START_MINUTE,
                    contentValues.getTimeStartMinute());
            cv.put(SmartSchedulerDatabase.COLUMN_EVENT_TIME_END_HOUR,
                    contentValues.getTimeEndHour());
            cv.put(SmartSchedulerDatabase.COLUMN_EVENT_TIME_END_MINUTE,
                    contentValues.getTimeEndMinute());
            cv.put(SmartSchedulerDatabase.COLUMN_EVENT_STATE, contentValues.getState());

            smartScheduleDb.open();
            smartScheduleDb.update_event(cv, contentValues.getId());
            smartScheduleDb.close();
            // TODO kiem tra thoi gian set co ton tai ko
            schedule.setSchedule(getApplicationContext(), contentValues);

            // schedule.setAlarm(this);
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


            if (resultCode == RESULT_OK) {
                switch (resultCode) {
                case Constant.SOUND_MANAGER_REQUEST_CODE:
                    // TODO get id to reload event
                    String result = data.getStringExtra("result");
                    break;

                default:
                    break;
                }

            }

    }

    /**
     * @doc get content values in database
     */
    private void getData(int id) {
        smartScheduleDb.openRead();
        contentValues = smartScheduleDb.getData(id);
        smartScheduleDb.close();
    }
}
