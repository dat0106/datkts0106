package com.samples.camera.ui;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.*;
import android.view.SurfaceHolder.Callback;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.samples.camera.utils.Common;

import java.util.Date;

public class RecorderService
  extends Service
  implements Callback
{
  private Camera camera = null;
  LayoutParams layoutParams1;
  private MediaRecorder mediaRecorder = null;
  int quality_video = 0;
  private SurfaceView surfaceView;
  boolean use_front_camera = false;
  boolean use_notificationbar = true;
  boolean use_preview = true;
  private WindowManager windowManager;

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    this.windowManager = ((WindowManager)getSystemService(Context.WINDOW_SERVICE));
    this.surfaceView = new SurfaceView(this);
    this.use_preview = UserSettingActivity.getInfoShowPreviewOrNot(getApplicationContext());
    Log.i("Giang", "Use preivew = " + this.use_preview);
    if (!this.use_preview)
    {
      this.layoutParams1 =
//        this.layoutParams1 = new LayoutParams(1, 1, 2006, 262144, -3);
        new WindowManager.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        this.layoutParams1.gravity = Gravity.CENTER;
        Log.i("Dat", "su dung layour moi  = " + this.use_preview);
    }
    else
    {
      this.layoutParams1 = new LayoutParams(Common.getScreenSize(this).x / 5, Common.getScreenSize(this).y / 5, 2002, 8, -3);
    }
    this.windowManager.addView(this.surfaceView, this.layoutParams1);
    this.surfaceView.setOnTouchListener(new OnTouchListener()
    {
      private float initialTouchX;
      private float initialTouchY;
      private int initialX;
      private int initialY;
      
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        boolean bool = true;
        Log.i("Giang", "touch surface view");
        switch (paramAnonymousMotionEvent.getAction())
        {
        default: 
          bool = false;
          break;
        case 0: 
          this.initialX = RecorderService.this.layoutParams1.x;
          this.initialY = RecorderService.this.layoutParams1.y;
          this.initialTouchX = paramAnonymousMotionEvent.getRawX();
          this.initialTouchY = paramAnonymousMotionEvent.getRawY();
          break;
        case 2: 
          RecorderService.this.layoutParams1.x = (this.initialX + (int)(paramAnonymousMotionEvent.getRawX() - this.initialTouchX));
          RecorderService.this.layoutParams1.y = (this.initialY + (int)(paramAnonymousMotionEvent.getRawY() - this.initialTouchY));
          RecorderService.this.windowManager.updateViewLayout(RecorderService.this.surfaceView, RecorderService.this.layoutParams1);
        }
        return bool;
      }
    });
    this.surfaceView.getHolder().addCallback(this);
  }
  
  public void onDestroy()
  {
    this.mediaRecorder.stop();
    this.mediaRecorder.reset();
    this.mediaRecorder.release();
    this.camera.lock();
    this.camera.release();
    this.windowManager.removeView(this.surfaceView);
    this.surfaceView = null;
  }
  
  @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
      Log.v("dat", "vaoday");


      Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
    this.use_front_camera = paramIntent.getBooleanExtra("use_camera_front", false);
    this.quality_video = Integer.valueOf(paramIntent.getStringExtra("video_quality")).intValue();
    this.use_notificationbar = paramIntent.getBooleanExtra("use_notification", true);


//    if ((this.use_notificationbar) && (Build.VERSION.SDK_INT >= 16)) {
//        Notification note =   new Notification.Builder(this).setContentTitle("Background Video Recorder").setContentText("").build();
//    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mediaRecorder = new MediaRecorder();
//    if ((Camera.getNumberOfCameras() >= 2) && (this.use_front_camera))
//    {
//      this.camera = Camera.open(1);
//      this.mediaRecorder.setOrientationHint(270);
//    }
//    for (;;)
//    {
        this.camera = Camera.open(1);
        this.mediaRecorder.setOrientationHint(270);
      this.camera.setDisplayOrientation(90);
      this.camera.unlock();
      this.mediaRecorder.setPreviewDisplay(paramSurfaceHolder.getSurface());
      this.mediaRecorder.setMaxDuration(10800000);
      this.mediaRecorder.setCamera(this.camera);
      this.mediaRecorder.setAudioSource(5);
      this.mediaRecorder.setVideoSource(1);
      if (this.quality_video == 0)
      {
        this.mediaRecorder.setProfile(CamcorderProfile.get(1));
        this.mediaRecorder.setOutputFile(Environment.getExternalStorageDirectory() + "/SpyVideo/" + DateFormat.format("yyyy-MM-dd_kk-mm-ss", new Date().getTime()) + ".mp4");
      }
      try
      {
        this.mediaRecorder.prepare();
        this.mediaRecorder.start();
        this.camera = Camera.open(0);
        this.mediaRecorder.setOrientationHint(90);
        this.mediaRecorder.setProfile(CamcorderProfile.get(0));
      }
      catch (Exception localException)
      {
        Log.d(this.toString(), localException.getMessage());
      }
    }
//  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {}
}



/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar

 * Qualified Name:     com.martinstudio.secretvideorecorder.RecorderService

 * JD-Core Version:    0.7.0.1

 */