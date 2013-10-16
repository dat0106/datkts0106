package com.example.demo;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class WifiActivity extends Activity {

    CheckBox wifiStatus;
    WifiManager mainWifi;
    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiStatus = (CheckBox)findViewById(R.id.wifiStatus);
//        status = (CheckBox)findViewById(R.id.log);

        wifiStatus.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if(isChecked == true){
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
                    Toast.makeText(getApplicationContext(), "wifi is  enabled", Toast.LENGTH_LONG).show();
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
