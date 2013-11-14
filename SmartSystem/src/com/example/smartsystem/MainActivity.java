package com.example.smartsystem;

import com.smartsystem.database.SmartSystemDatabase;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private SmartSystemDatabase database = new SmartSystemDatabase(this);
    SampleAlarmReceiver alarm = new SampleAlarmReceiver();
    Button btn1 ;
    Button btn2 ;
    Button btn3 ;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 =  (Button)findViewById(R.id.button1);
        editText1 = (EditText)findViewById(R.id.editText1);
        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
              database.open();
              database.createData(100);
              database.close();

            }
        });

        btn2 =  (Button)findViewById(R.id.button2);

        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
              database.open();
              String[] data = database.getCountData();
              database.close();
              editText1.setText(data[0] + "\n" +  data[1]);
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
