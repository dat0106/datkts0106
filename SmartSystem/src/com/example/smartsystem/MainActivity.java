package com.example.smartsystem;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    SampleAlarmReceiver alarm = new SampleAlarmReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
