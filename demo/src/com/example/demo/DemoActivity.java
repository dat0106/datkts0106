package com.example.demo;

import java.util.List;

import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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

       call.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Uri number = Uri.parse("tel:5551234");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities =  packageManager.queryIntentActivities(callIntent, 0);
            boolean isIntentSafe = activities.size() > 0;
            if (isIntentSafe) {
                startActivity(callIntent);
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
