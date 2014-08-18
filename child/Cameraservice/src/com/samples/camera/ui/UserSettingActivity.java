package com.samples.camera.ui;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.util.Log;
import com.varma.samples.camera.R;

import java.util.Arrays;
import java.util.List;

public class UserSettingActivity extends PreferenceActivity {
    private  Camera cameraDevice;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.activity_setting);


        Preference pref = (Preference)this.findPreference("my_video");
        pref.setSummary("12");


        ListPreference camera = (ListPreference) this.findPreference("camera");
        Log.v(this.toString(), "camera.getEntry()" + (String)camera.getEntry());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        CharSequence[] cameraArray =  camera.getEntries();
        CharSequence[] cameraArrayValues =  camera.getEntryValues();
        if(Camera.getNumberOfCameras() == 2){
            CharSequence[] entriesCamera = new CharSequence[]{cameraArray[0], cameraArray[1]};
            CharSequence[] entryValuesCamera = new CharSequence[]{cameraArrayValues[0], cameraArrayValues[1]};
            camera.setEntries(entriesCamera);
            camera.setEntryValues(entryValuesCamera);
        }else if(Camera.getNumberOfCameras() == 1){
            CharSequence[] entriesCamera = new CharSequence[]{cameraArray[0]};
            CharSequence[] entryValuesCamera = new CharSequence[]{cameraArrayValues[0]};
            camera.setEntries(entriesCamera);
            camera.setEntryValues(entryValuesCamera);
        }else{
            new Throwable("No camera");
        }

        Log.v(this.toString(), "camera.getEntry()" + (String)camera.getEntry());
//
//        Camera.Parameters paramsCamera = cameraDevice.getParameters();

        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent intent =  new Intent(getApplicationContext(), MyVideo.class);
                startActivity(intent);
                return false;
            }
        });
	}

    private void releaseCamera(){
        if (cameraDevice != null){
            cameraDevice.release();        // release the camera for other applications
            cameraDevice = null;
        }
    }
    /** A safe way to get an instance of the Camera object. */
    public Camera getCameraInstance(int cameraId){
        Camera c = null;
        try {
            if(cameraId == Camera.CameraInfo.CAMERA_FACING_BACK) {
                c = Camera.open(android.hardware.Camera.CameraInfo.CAMERA_FACING_BACK); // attempt to get a Camera instance
            }else if(cameraId ==  Camera.CameraInfo.CAMERA_FACING_FRONT){
                c = Camera.open(android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT); // attempt to get a Camera instance
            }else {
                c = Camera.open();
            }
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
            Log.d("prepareVideoRecorder", "can not open camera");
        }
        return c; // returns null if camera is unavailable
    }

}
