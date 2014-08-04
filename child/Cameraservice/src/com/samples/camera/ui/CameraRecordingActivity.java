package com.samples.camera.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.samples.camera.utils.NotificationUtils;
import com.samples.camera.utils.StorageUtils;
import com.varma.samples.camera.R;

/**
 * Created by ledat on 8/4/14.
 */
public class CameraRecordingActivity extends Activity {
    private Button recordBtn;
    private String fileName;
    private boolean mRecordingStatus;

    /**
     * Called when the activity is starting.  This is where most initialization
     * should go: calling {@link #setContentView(int)} to inflate the
     * activity's UI, using {@link #findViewById} to programmatically interact
     * with widgets in the UI, calling
     * {@link #managedQuery(android.net.Uri, String[], String, String[], String)} to retrieve
     * cursors for data being displayed, etc.
     * <p/>
     * <p>You can call {@link #finish} from within this function, in
     * which case onDestroy() will be immediately called without any of the rest
     * of the activity lifecycle ({@link #onStart}, {@link #onResume},
     * {@link #onPause}, etc) executing.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     * @see #onStart
     * @see #onSaveInstanceState
     * @see #onRestoreInstanceState
     * @see #onPostCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_rec);

        if (!StorageUtils.checkExternalStorageAvailable()) {
            NotificationUtils.showInfoDialog(this, getString(R.string.noExtStorageAvailable));
            return;
        }
        fileName = StorageUtils.getFileName(false);

        recordBtn = (Button) findViewById(R.id.recordBtn);
        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                record();
            }

        });
    }

    private void record() {
        if (mRecordingStatus) {

            stopServiceRecorder();
            //           stopMediaRecorder();
            recordBtn.setText(R.string.recordBtn);
		/*	switchBtn.setEnabled(true);
			playBtn.setEnabled(true);
			videoSizeSpinner.setEnabled(true);*/
        }
        else {

            starrServiceRecorder();
            recordBtn.setText(R.string.stopRecordBtn);
            //            switchBtn.setEnabled(false);
            //            playBtn.setEnabled(false);
            //            videoSizeSpinner.setEnabled(false);
        }
    }

    private void starrServiceRecorder()
    {
        Intent localIntent = new Intent(this, RecorderService.class);
        Log.i("Dat", "use_camera_front" + UserSettingActivity.getInfoWhichCameraForRecorder(this));

        localIntent.putExtra("use_camera_front", true);
        //        localIntent.putExtra("use_camera_front", UserSettingActivity.getInfoWhichCameraForRecorder(this));
        localIntent.putExtra("preview", UserSettingActivity.getInfoShowPreviewOrNot(this));
        Log.i("Giang", "check start config" + UserSettingActivity.getInfoShowPreviewOrNot(this));
        localIntent.putExtra("video_quality", UserSettingActivity.getInfoQualityVideo(this));
        localIntent.putExtra("use_notification", UserSettingActivity.getInfoEnableNotification(this));
        startService(localIntent);
        mRecordingStatus = true;
    }

    private void stopServiceRecorder()
    {
        Intent localIntent = new Intent(this, RecorderService.class);

        stopService(localIntent);
        mRecordingStatus = false;
    }

    /**
     * Perform any final cleanup before an activity is destroyed.  This can
     * happen either because the activity is finishing (someone called
     * {@link #finish} on it, or because the system is temporarily destroying
     * this instance of the activity to save space.  You can distinguish
     * between these two scenarios with the {@link #isFinishing} method.
     * <p/>
     * <p><em>Note: do not count on this method being called as a place for
     * saving data! For example, if an activity is editing data in a content
     * provider, those edits should be committed in either {@link #onPause} or
     * {@link #onSaveInstanceState}, not here.</em> This method is usually implemented to
     * free resources like threads that are associated with an activity, so
     * that a destroyed activity does not leave such things around while the
     * rest of its application is still running.  There are situations where
     * the system will simply kill the activity's hosting process without
     * calling this method (or any others) in it, so it should not be used to
     * do things that are intended to remain around after the process goes
     * away.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onPause
     * @see #onStop
     * @see #finish
     * @see #isFinishing
     */
    @Override
    protected void onDestroy() {
        Intent localIntent = new Intent(this, RecorderService.class);

        stopService(localIntent);
        mRecordingStatus = false;
        super.onDestroy();
    }
}
