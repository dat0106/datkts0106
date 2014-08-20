package com.samples.camera.ui;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.view.*;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.samples.camera.preview.CameraPreview;
import com.samples.camera.utils.CameraHelpers;
import com.varma.samples.camera.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ledat on 8/4/14.
 */
public class CameraService extends Service {

    private WindowManager windowManager;
    private ImageView chatHead;
    WindowManager.LayoutParams params;
    private Camera mServiceCamera;
    private MediaRecorder mMediaRecorder;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private boolean mRecordingStatus = false;
    private CameraPreview mPreview;

    RelativeLayout mainView;
    private boolean checkStopService = false;

    @Override
    public IBinder onBind(Intent intent) {
        // Not used
        return null;
    }

    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.v(this.toString(), "vao BroadcastReceiver");
            if(intent.getAction().equals("com.sample.camera")) {
                StartRecording();
            }
        }
    };
    @Override
    public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        LayoutInflater layoutInflater = (LayoutInflater) this
                .getSystemService(this.LAYOUT_INFLATER_SERVICE);
        mainView = (RelativeLayout) layoutInflater.inflate(
                R.layout.camera_service, null);;
    }

    /**
     * Called by the system every time a client explicitly starts the service by calling
     * {@link android.content.Context#startService}, providing the arguments it supplied and a
     * unique integer token representing the start request.  Do not call this method directly.
     * <p/>
     * <p>For backwards compatibility, the default implementation calls
     * {@link #onStart} and returns either {@link #START_STICKY}
     * or {@link #START_STICKY_COMPATIBILITY}.
     * <p/>
     * <p>If you need your application to run on platform versions prior to API
     * level 5, you can use the following model to handle the older {@link #onStart}
     * callback in that case.  The <code>handleCommand</code> method is implemented by
     * you as appropriate:
     * <p/>
     * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/ForegroundService.java
     * start_compatibility}
     * <p/>
     * <p class="caution">Note that the system calls this on your
     * service's main thread.  A service's main thread is the same
     * thread where UI operations take place for Activities running in the
     * same process.  You should always avoid stalling the main
     * thread's event loop.  When doing long-running operations,
     * network calls, or heavy disk I/O, you should kick off a new
     * thread, or use {@link android.os.AsyncTask}.</p>
     *
     * @param intent  The Intent supplied to {@link android.content.Context#startService},
     *                as given.  This may be null if the service is being restarted after
     *                its process has gone away, and it had previously returned anything
     *                except {@link #START_STICKY_COMPATIBILITY}.
     * @param flags   Additional data about this start request.  Currently either
     *                0, {@link #START_FLAG_REDELIVERY}, or {@link #START_FLAG_RETRY}.
     * @param startId A unique integer representing this specific request to
     *                start.  Use with {@link #stopSelfResult(int)}.
     * @return The return value indicates what semantics the system should
     * use for the service's current started state.  It may be one of the
     * constants associated with the {@link #START_CONTINUATION_MASK} bits.
     * @see #stopSelfResult(int)
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        FrameLayout preview = (FrameLayout) mainView.findViewById(R.id.camera_preview);

        // api conrespond with Preference
        int cameraID = intent.getIntExtra("camera", Camera.CameraInfo.CAMERA_FACING_BACK);
        // max size camera
        int videoQuality = intent.getIntExtra("video_quality", 0);

        boolean showPreivew = intent.getBooleanExtra("show_preview", false);
        mServiceCamera = getCameraInstance(cameraID);

        if(mServiceCamera == null){
            Log.d(this.toString(), "can not open camera");
            // TODO LEDAT xem co phai show notify ko
            checkStopService =  true;
            stopSelf();
        }else {

            if(!showPreivew) {
                // no preview
                params = new WindowManager.LayoutParams(
                        2,
                        2,
                        WindowManager.LayoutParams.TYPE_PHONE,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                        PixelFormat.TRANSLUCENT);
                params.gravity = Gravity.TOP | Gravity.LEFT;
                params.x = 0;
                params.y = 100;
            }else{
                // preview
                params = new WindowManager.LayoutParams(
                        600,
                        600,
                        WindowManager.LayoutParams.TYPE_PHONE,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                        PixelFormat.TRANSLUCENT);
                params.gravity = Gravity.CENTER;
//                params.x = 0;
//                params.y = 100;
            }

            //        mainView.setOnTouchListener(new View.OnTouchListener() {
            //            private int initialX;
            //            private int initialY;
            //            private float initialTouchX;
            //            private float initialTouchY;
            //
            //            @Override public boolean onTouch(View v, MotionEvent event) {
            //                switch (event.getAction()) {
            //                    case MotionEvent.ACTION_DOWN:
            //                        initialX = params.x;
            //                        initialY = params.y;
            //                        initialTouchX = event.getRawX();
            //                        initialTouchY = event.getRawY();
            //                        return true;
            //                    case MotionEvent.ACTION_UP:
            //                        return true;
            //                    case MotionEvent.ACTION_MOVE:
            //                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
            //                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
            //                        windowManager.updateViewLayout(mainView, params);
            //                        return true;
            //                }
            //                return false;
            //            }
            //        });


            // setCameraDisplayOrientation
            CameraHelpers.setCameraDisplayOrientation(cameraID, mServiceCamera, Surface.ROTATION_0);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                if(mServiceCamera.getParameters().getMaxNumDetectedFaces() >0) {
                    mServiceCamera.setFaceDetectionListener(new Camera.FaceDetectionListener() {
                        @Override public void onFaceDetection(Camera.Face[] faces, Camera camera) {

                            if(faces.length > 0) {
                                Log.v("Camera", "FaceDetection");
                            }

                        }
                    });
                    mServiceCamera.startFaceDetection();
                }
            }

            // get Camera parameters
            Camera.Parameters paramsCamera = mServiceCamera.getParameters();

            Log.v(this.toString(), "params1" + paramsCamera.flatten());
            List<String> focusModes = paramsCamera.getSupportedFocusModes();
            if (focusModes.contains(Camera.Parameters.FOCUS_MODE_AUTO)) {
                // Autofocus mode is supported

                paramsCamera.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
               // set Camera parameters
                mServiceCamera.setParameters(paramsCamera);
            }

            List<Camera.Size> sizes = (List<Camera.Size>) paramsCamera.getSupportedPictureSizes();
            for (int i=0;i<sizes.size();i++){
                Log.i("PictureSize", "Supported Size: " + sizes.get(i).width + " : " +  sizes.get(i).height );
            }

            mPreview = new CameraPreview(this, mServiceCamera);

            preview.addView(mPreview);
            windowManager.addView(mainView, params);

            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.sample.camera");
            registerReceiver(receiver, intentFilter);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    public void StartRecording() {
        if(prepareVideoRecorder()) {
            mMediaRecorder.start();
            Log.v(this.toString(), "vao StartRecording");
        }else {
            Log.d(CameraService.this.toString(), "start service fail on prepareVideoRecorder");
            releaseMediaRecorder();
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(!checkStopService) {
            if (mainView != null) windowManager.removeView(mainView);
            unregisterReceiver(receiver);
            if (mMediaRecorder != null) {
                mMediaRecorder.stop();
            }
            releaseMediaRecorder();
            releaseCamera();
            Log.v(this.toString(), "stop or destroy recording service");
        }else {
            Log.v(this.toString(), "Error stop or destroy recording service");
        }

    }
    
    private boolean prepareVideoRecorder(){

        mMediaRecorder = new MediaRecorder();

        // Step 1: Unlock and set camera to MediaRecorder
        mServiceCamera.unlock();
        mMediaRecorder.setCamera(mServiceCamera);

        // Step 2: Set sources
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
        mMediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);

        // Step 3: Set a CamcorderProfile (requires API Level 8 or higher)
        mMediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH));

        // Step 4: Set output file
        mMediaRecorder.setOutputFile(getOutputMediaFile(MEDIA_TYPE_VIDEO).toString());

        // Step 5: Set the preview output
        mMediaRecorder.setPreviewDisplay(mPreview.getHolder().getSurface());

        // Step 6: Prepare configured MediaRecorder
        try {
            mMediaRecorder.prepare();
        } catch (IllegalStateException e) {
            Log.d(CameraService.this.toString(), "IllegalStateException preparing MediaRecorder: " + e.getMessage());
            releaseMediaRecorder();
            return false;
        } catch (IOException e) {
            Log.d(CameraService.this.toString(), "IOException preparing MediaRecorder: " + e.getMessage());
            releaseMediaRecorder();
            return false;
        }
        return true;
    }


    private void releaseMediaRecorder(){
        if (mMediaRecorder != null) {
            mMediaRecorder.reset();   // clear recorder configuration
            mMediaRecorder.release(); // release the recorder object
            mMediaRecorder = null;
            if(mServiceCamera != null) {
                mServiceCamera.lock();           // lock camera for later use
            }
        }
    }

    private void releaseCamera(){
        if (mServiceCamera != null){
            mServiceCamera.release();        // release the camera for other applications
            mServiceCamera = null;
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

    private Camera.PictureCallback mPicture = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {

            File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
            if (pictureFile == null){
                Log.d(((Object)this).toString(), "Error creating media file, check storage permissions: ");
                return;
            }

            try {
                FileOutputStream fos = new FileOutputStream(pictureFile);
                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e) {
                Log.d(((Object)this).toString(), "File not found: " + e.getMessage());
            } catch (IOException e) {
                Log.d(((Object)this).toString(), "Error accessing file: " + e.getMessage());
            }
        }
    };

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
