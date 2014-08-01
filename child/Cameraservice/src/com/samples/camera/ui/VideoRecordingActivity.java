package com.samples.camera.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import androidrecording.video.AdaptiveSurfaceView;
import androidrecording.video.CameraHelper;
import androidrecording.video.VideoRecordingHandler;
import androidrecording.video.VideoRecordingManager;
import com.samples.camera.utils.NotificationUtils;
import com.samples.camera.utils.StorageUtils;
import com.varma.samples.camera.R;


import java.io.IOException;
import java.util.List;

public class VideoRecordingActivity extends Activity {
	private static String fileName = null;
    
	private Button recordBtn, playBtn;
	private ImageButton switchBtn;
	private Spinner videoSizeSpinner;
	
	private Size videoSize = null;
	private VideoRecordingManager recordingManager;
	
	private VideoRecordingHandler recordingHandler = new VideoRecordingHandler() {
		@Override
		public boolean onPrepareRecording() {
			if (videoSizeSpinner == null) {
	    		initVideoSizeSpinner();
	    		return true;
			}
			return false;
		}
		
		@Override
		public Size getVideoSize() {
			return videoSize;
		}
		
		@Override
		public int getDisplayRotation() {
			return VideoRecordingActivity.this.getWindowManager().getDefaultDisplay().getRotation();
		}
	};
    private Camera mServiceCamera;
    private SurfaceHolder mSurfaceHolder;
    MediaRecorder mMediaRecorder;
    private boolean mRecordingStatus;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_rec);
		
		if (!StorageUtils.checkExternalStorageAvailable()) {
			NotificationUtils.showInfoDialog(this, getString(R.string.noExtStorageAvailable));
			return;
		}
		fileName = StorageUtils.getFileName(false);
		
//		AdaptiveSurfaceView videoView = (AdaptiveSurfaceView) findViewById(R.id.videoView);

//        AdaptiveSurfaceView videoView = new AdaptiveSurfaceView(this);
//
//        mRecordingStatus = false;
//        recordingManager = new VideoRecordingManager(videoView, recordingHandler);
//
		recordBtn = (Button) findViewById(R.id.recordBtn);
		recordBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				record();
			}
		});
//
//		switchBtn = (ImageButton) findViewById(R.id.switchBtn);
//		if (recordingManager.getCameraManager().hasMultipleCameras()) {
//			switchBtn.setOnClickListener(new OnClickListener() {
//				@Override
//				public void onClick(View v) {
//					switchCamera();
//				}
//			});
//		}
//		else {
//			switchBtn.setVisibility(View.GONE);
//		}
//
//		playBtn = (Button) findViewById(R.id.playBtn);
//		playBtn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				play();
//			}
//		});
//        videoView.setVisibility(View.INVISIBLE);
	}

    private void addView(AdaptiveSurfaceView videoView, int i) {
    }

    @Override
	protected void onDestroy() {
		recordingManager.dispose();
		recordingHandler = null;
		
		super.onDestroy();
	}
	
	@SuppressLint("NewApi")
	private void initVideoSizeSpinner() {
		videoSizeSpinner = (Spinner) findViewById(R.id.videoSizeSpinner);
		if (Build.VERSION.SDK_INT >= 11) {
			List<Size> sizes = CameraHelper.getCameraSupportedVideoSizes(recordingManager.getCameraManager().getCamera());
			videoSizeSpinner.setAdapter(new SizeAdapter(sizes));
			videoSizeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					videoSize = (Size) arg0.getItemAtPosition(arg2);
					recordingManager.setPreviewSize(videoSize);
				}
	
				@Override
				public void onNothingSelected(AdapterView<?> arg0) {}
			});
			videoSize = (Size) videoSizeSpinner.getItemAtPosition(0);
		}
		else {
			videoSizeSpinner.setVisibility(View.GONE);
		}
	}
	
	@SuppressLint("NewApi")
	private void updateVideoSizes() {
		if (Build.VERSION.SDK_INT >= 11) {
			((SizeAdapter) videoSizeSpinner.getAdapter()).set(CameraHelper.getCameraSupportedVideoSizes(recordingManager.getCameraManager().getCamera()));
			videoSizeSpinner.setSelection(0);
			videoSize = (Size) videoSizeSpinner.getItemAtPosition(0);
			recordingManager.setPreviewSize(videoSize);
		}
	}
	
	private void switchCamera() {
		recordingManager.getCameraManager().switchCamera();
		updateVideoSizes();
	}
	
	private void record() {
		if (mRecordingStatus) {
           stopMediaRecorder();
			recordBtn.setText(R.string.recordBtn);
			switchBtn.setEnabled(true);
			playBtn.setEnabled(true);
			videoSizeSpinner.setEnabled(true);
		}
		else {
            starMediaRecording();
		}
	}
	
	private void startRecording() {
		if (recordingManager.startRecording(fileName, videoSize)) {
			recordBtn.setText(R.string.stopRecordBtn);
			switchBtn.setEnabled(false);
			playBtn.setEnabled(false);
			videoSizeSpinner.setEnabled(false);
			return;
		}
		Toast.makeText(this, getString(R.string.videoRecordingError), Toast.LENGTH_LONG).show();
	}
	
	private void play() {
//		Intent i = new Intent(VideoRecordingActivity.this, VideoPlaybackActivity.class);
//		i.putExtra(VideoPlaybackActivity.FileNameArg, fileName);
//		startActivityForResult(i, 0);
	}

    public boolean starMediaRecording(){
        Camera.Parameters params = mServiceCamera.getParameters();
        mServiceCamera.setParameters(params);
        Camera.Parameters p = mServiceCamera.getParameters();

        final List<Size> listSize = p.getSupportedPreviewSizes();
        Size mPreviewSize = listSize.get(2);
        p.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
        p.setPreviewFormat(PixelFormat.YCbCr_420_SP);
        mServiceCamera.setParameters(p);

        try {
            mServiceCamera.setPreviewDisplay(mSurfaceHolder);
            mServiceCamera.startPreview();
        }
        catch (IOException e) {
            Log.e(this.toString(), e.getMessage());
            e.printStackTrace();
        }

        mServiceCamera.unlock();

        mMediaRecorder  = new MediaRecorder();
        mMediaRecorder.setCamera(mServiceCamera);
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mMediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        mMediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);
        mMediaRecorder.setOutputFile("/sdcard/filenamevideo.mp4");
        mMediaRecorder.setVideoFrameRate(30);
        mMediaRecorder.setVideoSize(mPreviewSize.width, mPreviewSize.height);
        mMediaRecorder.setPreviewDisplay(mSurfaceHolder.getSurface());

        try {
            mMediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mMediaRecorder.start();

        mRecordingStatus = true;

        return true;

    }

    public void stopMediaRecorder() {
        try {
            mServiceCamera.reconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mMediaRecorder.stop();
        mMediaRecorder.reset();

        mServiceCamera.stopPreview();
        mMediaRecorder.release();

        mRecordingStatus = false;
        mServiceCamera.release();
        mServiceCamera = null;
    }

}
