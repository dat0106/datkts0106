/*
 * Copyright (C) 2013 Steelkiwi Development, Julia Zudikova, Viacheslav Tiagotenkov
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidrecording.video;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.nfc.Tag;
import android.os.Environment;
import android.util.Log;

/*
 * Manages media recorder recording 
 */

public class MediaRecorderManager {
	private static final int VIDEO_W_DEFAULT = 800;
	private static final int VIDEO_H_DEFAULT = 480;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    private MediaRecorder recorder;
	private boolean isRecording;

	public MediaRecorderManager() {
		recorder = new MediaRecorder();
        isRecording = false;
	}

    public boolean startRecording(Camera camera, String fileName, Size sz, int cameraRotationDegree, AdaptiveSurfaceView videoView ) {
        recorder = new MediaRecorder();
        if (sz == null) {
            sz = camera.new Size(VIDEO_W_DEFAULT, VIDEO_H_DEFAULT);
        }

        try {
            // Step 1: Unlock and set camera to MediaRecorder
            camera.unlock();
            recorder.setCamera(camera);

            // Step 2: Set sources
            recorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
            recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);

            // Step 3: Set a CamcorderProfile (requires API Level 8 or higher)
            recorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH));


            // Step 4: Set output file
            recorder.setOutputFile(getOutputMediaFile(MEDIA_TYPE_VIDEO).toString());


            // Step 5: Set the preview output
            recorder.setPreviewDisplay(videoView.getHolder().getSurface());

            //            recorder.setOrientationHint(cameraRotationDegree);
            //			recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            //			recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
            //			recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            //			recorder.setVideoSize(sz.width, sz.height);
            //			recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
            //			recorder.setVideoEncoder(MediaRecorder.VideoEncoder.MPEG_4_SP);
            //			recorder.setOutputFile(fileName);
            recorder.prepare();
            recorder.start();
            isRecording = true;
        } catch (IllegalStateException e) {
            Log.d(this.toString(), "IllegalStateException preparing MediaRecorder: " + e.getMessage());
            releaseMediaRecorder();
            camera.lock();
            return false;
        } catch (IOException e) {
            Log.d(this.toString(), "IOException preparing MediaRecorder: : " + e.getMessage());
            releaseMediaRecorder();
            camera.lock();
            return false;
        }

        return isRecording;
    }

	public boolean stopRecording() {
		if (isRecording) {
			isRecording = false;
            try {
                recorder.stop();
            } catch (RuntimeException e){
                Log.d(this.toString(), "CAN NOT STOP recorder: " + e.getMessage());
            }
			return true;
		}
		return false;
	}

    public void releaseMediaRecorder(){
        if (recorder != null) {
            recorder.reset();   // clear recorder configuration
            recorder.release(); // release the recorder object
            recorder = null;
        }
    }
	public boolean isRecording() {
		return isRecording;
	}


    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }


        Log.v("MediaRecorderManager", "mediaStorageDir.getPath()" +mediaStorageDir.getPath());
        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else if(type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }


}
