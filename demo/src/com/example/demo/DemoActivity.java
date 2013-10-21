package com.example.demo;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class DemoActivity extends Activity {

    CheckBox wifiStatus;
    WifiManager mainWifi;
    TextView status;
    Button submit;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       wifiStatus = (CheckBox)findViewById(R.id.wifiStatus);
       status = (TextView)findViewById(R.id.log);
       submit = (Button)findViewById(R.id.submit);
       call = (Button) findViewById(R.id.Call);

       submit.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            mainWifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
            // TODO Auto-generated method stub
            //
            if(wifiStatus.isChecked() == true){
                  mainWifi.setWifiEnabled(true);
             }
              else{
                  mainWifi.setWifiEnabled(false);
              }
              if (mainWifi.isWifiEnabled() == false)
              {
                  // If wifi disabled then enable it
                  Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled", Toast.LENGTH_LONG).show();
              }
              else
              {
                   // If wifi disabled then enable it
                  Toast.makeText(getApplicationContext(), "wifi is enabled", Toast.LENGTH_LONG).show();
              }

       }
    });


        };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
