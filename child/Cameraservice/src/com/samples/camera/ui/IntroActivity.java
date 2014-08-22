package com.samples.camera.ui;

import android.content.SharedPreferences;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.util.Log;
import com.varma.samples.camera.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends Activity {


    private static final int RESULT_SETTINGS = 1;
    private boolean startAndStopCameraService = false;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		
		((Button)findViewById(R.id.start_camera)).setOnClickListener(onButtonClick);
        ((Button)findViewById(R.id.start_camera_video)).setOnClickListener(onButtonClick);
        ((Button)findViewById(R.id.start_camera_recording)).setOnClickListener(onButtonClick);
        ((Button)findViewById(R.id.camera_service)).setOnClickListener(onButtonClick);
	}




    private void startAndStopCameraService() {
        if(!startAndStopCameraService){
            Intent i = new Intent(IntroActivity.this, CameraService.class);
            i.putExtra("camera_id", 0);
            i.putExtra("camera_preview", true);

            // cac ban co the truyen 1 so data can thiet va tu bat =
            // receiver
            SharedPreferences sharedPrefs = PreferenceManager
                    .getDefaultSharedPreferences(this);
            // api conrespond with Preference
            i.putExtra("camera", Integer.parseInt(sharedPrefs.getString("camera", null)));
            i.putExtra("video_quality", Integer.parseInt(sharedPrefs.getString("video_quality", null)));
            i.putExtra("video_orientation", Integer.parseInt(sharedPrefs.getString("video_orientation", null)));
            i.putExtra("video_folder", sharedPrefs.getString("video_folder", null));
            i.putExtra("flashlight", sharedPrefs.getBoolean("flashlight", false));
            i.putExtra("show_preview", sharedPrefs.getBoolean("show_preview", false));
            i.putExtra("show_notification", sharedPrefs.getBoolean("show_notification", false));
            i.putExtra("hide_video", sharedPrefs.getBoolean("hide_video", false));

            startService(i);
            Intent mIntent = new Intent("com.sample.camera");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sendBroadcast(mIntent);
            ((Button)findViewById(R.id.camera_service)).setText("camera service stop");
            startAndStopCameraService = true;
        }else {
            Intent i = new Intent(IntroActivity.this, CameraService.class);
            stopService(i);
            ((Button)findViewById(R.id.camera_service)).setText("camera service start");
            startAndStopCameraService = false;
        }
    }
    private View.OnClickListener onButtonClick = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch(v.getId())
			{
                case R.id.camera_service:
                {
                    startAndStopCameraService();

                    break;
                }
                case R.id.start_camera:
                {
                    references();

                    break;
                }
                case R.id.start_camera_recording:
                {
                    showUserSettings();
                    break;
                }

			}
		}


    };

    private void references() {
        Intent i = new Intent(this, UserSettingActivity.class);
        startActivityForResult(i, RESULT_SETTINGS);

    }

    private void showUserSettings() {
        SharedPreferences sharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this);



//        StringBuilder builder = new StringBuilder();
//
//        builder.append("\n Username: "
//                + sharedPrefs.getString("prefUsername", "NULL"));
//
//        builder.append("\n Send report:"
//                + sharedPrefs.getBoolean("prefSendReport", false));
//
//        builder.append("\n Sync Frequency: "
//                + sharedPrefs.getString("prefSyncFrequency", "NULL"));
//
//        TextView settingsTextView = (TextView) findViewById(R.id.textUserSettings);
//
//        settingsTextView.setText(builder.toString());
    }


}
