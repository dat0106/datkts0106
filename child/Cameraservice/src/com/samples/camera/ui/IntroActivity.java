package com.samples.camera.ui;

import com.varma.samples.camera.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends Activity {

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
	
	private void startCameraActivity() {
		Intent intent = new Intent(IntroActivity.this,CameraActivity.class);
		
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
		startActivity(intent);
		
		finish();
	}

    private void startCameraVideoActivity() {

        Intent i = new Intent(IntroActivity.this, VideoRecordingActivity.class);
        startActivity(i);


        finish();
    }


    private void startCameraRecordingActivity() {

        Intent i = new Intent(IntroActivity.this, CameraRecordingActivity.class);
        startActivity(i);

        finish();
    }

    private void startAndStopCameraService() {
        if(!startAndStopCameraService){
            Intent i = new Intent(IntroActivity.this, CameraService.class);
            startService(i);

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
				case R.id.start_camera:
				{
					startCameraActivity();
					
					break;
				}
                case R.id.start_camera_video:
                {
                    startCameraVideoActivity();

                    break;
                }
                case R.id.start_camera_recording:
                {
                    startCameraRecordingActivity();

                    break;
                }
                case R.id.camera_service:
                {
                    startAndStopCameraService();

                    break;
                }
			}
		}


    };


}
