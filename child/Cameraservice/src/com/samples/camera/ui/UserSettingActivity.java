package com.samples.camera.ui;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.preference.ListPreference;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.util.Log;
import com.varma.samples.camera.R;

import java.util.List;

public class UserSettingActivity extends PreferenceActivity implements
        OnSharedPreferenceChangeListener  {
    private  Camera cameraDevice;
    private  ListPreference cameraPreference;
    private ListPreference videoQualityPreference;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.activity_setting);


        Preference pref = (Preference)this.findPreference("my_video");
        pref.setSummary("12");


        cameraPreference = (ListPreference) this.findPreference("camera");

        setCameraPreferences(cameraPreference);

        videoQualityPreference = (ListPreference) this.findPreference("video_quality");
        setSizePreferences(videoQualityPreference, cameraPreference);


        Log.v("Environment", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent intent =  new Intent(getApplicationContext(), MyVideo.class);
                startActivity(intent);
                return true;
            }
        });

        updateSummary();
	}

    @Override
    protected void onResume() {
        super.onResume();
        // Set up a listener whenever a key changes
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(UserSettingActivity.this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the listener whenever a key changes
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener( UserSettingActivity.this);
    }

    private void setCameraPreferences(final ListPreference cameraPreference)
    {
        final int numberOfCameras = Camera.getNumberOfCameras();
        final CharSequence[] entries = new CharSequence[numberOfCameras];
        final CharSequence[] entryValues = new CharSequence[numberOfCameras];
        final Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int cameraIndex = 0; cameraIndex < numberOfCameras; cameraIndex++)
        {
            Camera.getCameraInfo(cameraIndex, cameraInfo);
            String cameraFacing;
            switch (cameraInfo.facing)
            {
                case Camera.CameraInfo.CAMERA_FACING_BACK:
                    cameraFacing = getResources().getString(R.string.camera_back);
                    break;
                case Camera.CameraInfo.CAMERA_FACING_FRONT:
                    cameraFacing = getResources().getString(R.string.camera_front);
                    break;
                default:
                    cameraFacing = "unknown";
            } // switch

            entries[cameraIndex] = cameraFacing;
            entryValues[cameraIndex] = String.valueOf(cameraIndex);
        } //for

        cameraPreference.setEntries(entries);
        cameraPreference.setEntryValues(entryValues);
        cameraPreference.setDefaultValue(0);

    } // setCameraPreferences(ListPreference)

    private void setSizePreferences(final ListPreference sizePreference,
                                    final ListPreference cameraPreference)
    {

        final String cameraPreferenceValue = cameraPreference.getValue();
        final int cameraIndex;
        if (cameraPreferenceValue != null)
        {
            cameraIndex = Integer.parseInt(cameraPreferenceValue);
        } // if
        else
        {
            cameraIndex = 0;
        } // else
        cameraDevice = getCameraInstance(cameraIndex);
        final Camera.Parameters params = cameraDevice.getParameters();
        releaseCamera();

        final List<Camera.Size> supportedPreviewSizes = params.getSupportedPreviewSizes();
        CharSequence[] entries = new CharSequence[supportedPreviewSizes.size()];
        CharSequence[] entryValues = new CharSequence[supportedPreviewSizes.size()];
        for (int previewSizeIndex = 0; previewSizeIndex < supportedPreviewSizes.size();
             previewSizeIndex++)
        {
            Camera.Size supportedPreviewSize = supportedPreviewSizes.get(previewSizeIndex);
            entries[previewSizeIndex] = supportedPreviewSize.width + "x"
                    + supportedPreviewSize.height;
            entryValues[previewSizeIndex] = String.valueOf(previewSizeIndex);
        } // for

        sizePreference.setEntries(entries);
        sizePreference.setEntryValues(entryValues);
        sizePreference.setDefaultValue(0);

    } // setSizePreferenceData(ListPreference)


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

    /**
     * Called when a shared preference is changed, added, or removed. This
     * may be called even if a preference is set to its existing value.
     * <p/>
     * <p>This callback will be run on your main thread.
     *
     * @param sharedPreferences The {@link android.content.SharedPreferences} that received
     *                          the change.
     * @param key               The key of the preference that was changed, added, or
     */
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        setSizePreferences(videoQualityPreference, cameraPreference);
        updateSummary();

    }

    private void updateSummary() {
        cameraPreference.setSummary(cameraPreference.getEntry());
        videoQualityPreference.setSummary(
                String.format(getResources().getString(R.string.video_quality_summary),
                        videoQualityPreference.getEntry())
        );
        ListPreference videoOrientation = (ListPreference) this.findPreference("video_orientation");
        videoOrientation.setSummary(
                videoOrientation.getEntry()
        );
    }
}
