package com.smartschedule;

import java.util.Calendar;

import util.Util;

import com.smartschedule.database.SmartSchedulerDatabase;

import android.os.Bundle;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class EventActivity extends Activity {
	private SmartSchedulerDatabase smartScheduleDb = new SmartSchedulerDatabase(
			this);
	SampleAlarmReceiver schedule = new SampleAlarmReceiver();
	Button btn1;
	Button btn2;
	Button btn3;
	Button start_time;
	Button end_time;
	EditText editText1;
	protected int start_time_hour;
	protected int start_time_minute;
	protected int end_time_hour;
	protected int end_time_minute;
	private int event_id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent =  getIntent();
		event_id = intent.getExtras().getInt(SmartSchedulerDatabase.COLUMN_EVENT_ID);

		btn1 = (Button) findViewById(R.id.button1);

		start_time = (Button) findViewById(R.id.start_time);
		end_time = (Button) findViewById(R.id.end_time);
		editText1 = (EditText) findViewById(R.id.editText1);
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				smartScheduleDb.open();
				smartScheduleDb.createData("sample", "image", 1, 1);
				smartScheduleDb.close();

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
				int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
				int minute = mcurrentTime.get(Calendar.MINUTE);
				TimePickerDialog mTimePicker;
				mTimePicker = new TimePickerDialog(EventActivity.this,
						new TimePickerDialog.OnTimeSetListener() {
							@Override
							public void onTimeSet(TimePicker timePicker,
									int selectedHour, int selectedMinute) {

								start_time_hour = selectedHour;
								start_time_minute = selectedMinute;
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
				int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
				int minute = mcurrentTime.get(Calendar.MINUTE);
				TimePickerDialog mTimePicker;
				mTimePicker = new TimePickerDialog(EventActivity.this,
						new TimePickerDialog.OnTimeSetListener() {
							@Override
							public void onTimeSet(TimePicker timePicker,
									int selectedHour, int selectedMinute) {
								end_time_hour = selectedHour;
								end_time_minute = selectedMinute;

								end_time.setText(Util.convertTime(selectedHour)
										+ ":"
										+ Util.convertTime(selectedMinute));
							}
						}, hour, minute, true);// Yes 24 hour time
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
		case R.id.done_scheduler:
			schedule.setSchedule(this, 1);
			return true;
		case R.id.cancel_scheduler:
			schedule.cancelSchedule(this, 1);
			return true;
		}
		return false;
	}

}
