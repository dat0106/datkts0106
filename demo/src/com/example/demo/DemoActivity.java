package com.example.demo;

import java.util.List;

import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.util.Log;
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
    Button getContact;
    static final int PICK_CONTACT_REQUEST = 1; // the request code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       wifiStatus = (CheckBox)findViewById(R.id.wifiStatus);
       status = (TextView)findViewById(R.id.log);
       submit = (Button)findViewById(R.id.submit);
       call = (Button) findViewById(R.id.Call);
       getContact = (Button)findViewById(R.id.contact);

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

       getContact.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                pickContact();
            }
        });

    };


    private void pickContact(){
        Intent pickContactIntent =  new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(Phone.CONTENT_TYPE); // show user only contacts  phone numbers
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.
                Uri contactUri = data.getData();
                // Do something with the contact here (bigger example below)
                String[] projection = {Phone.NUMBER};
                Log.v("DemoActivity projection", projection.toString());

                Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
                cursor.moveToFirst();
                int column =  cursor.getColumnIndex(Phone.NUMBER);
                String number =  cursor.getString(column);
                Toast.makeText(getApplicationContext(), "Number phone: "+ number, Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Cancel: resultCode = "+ resultCode, Toast.LENGTH_LONG).show();
            }
        }
    }
}
