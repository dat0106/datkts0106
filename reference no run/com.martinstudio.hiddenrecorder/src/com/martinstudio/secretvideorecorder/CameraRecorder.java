package com.martinstudio.secretvideorecorder;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Camera;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.martinstudio.adapter.MyThumbAdapter;
import com.martinstudio.utils.VideoInfo;
import com.martinstudio.widget.WidgetStartStopRecorder;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CameraRecorder
  extends Activity
{
  private static final String TAG = "Recorder";
  public static Camera mCamera;
  public static boolean mPreviewRunning;
  public static SurfaceHolder mSurfaceHolder;
  public static SurfaceView mSurfaceView;
  final int MESSAGE_STOP_RECORDER = 100;
  ImageView btnRecorder;
  protected Handler handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      case 100: 
        Intent localIntent = new Intent(CameraRecorder.this, RecorderService.class);
        CameraRecorder.this.stopServiceRecorderAsyntask(localIntent);
      }
    }
  };
  ListView lst_thumbnail;
  private ActionMode mActionMode;
  Activity mActivity;
  AdView mAdView;
  AnimationSet mAnimation;
  AdapterView.OnItemClickListener mOnItemsClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      CameraRecorder.this.onClick(paramAnonymousInt);
    }
  };
  AdapterView.OnItemLongClickListener mOnItemsLongClickListener = new AdapterView.OnItemLongClickListener()
  {
    public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      boolean bool;
      if (CameraRecorder.this.mActionMode == null)
      {
        CameraRecorder.this.onListItemSelect(paramAnonymousInt);
        bool = true;
      }
      else
      {
        bool = false;
      }
      return bool;
    }
  };
  MyThumbAdapter mThumbAdapter;
  ArrayList<VideoInfo> myData;
  TextView txt_rec;
  
  private boolean isMyServiceRunning()
  {
    Iterator localIterator = ((ActivityManager)getSystemService("activity")).getRunningServices(2147483647).iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)localIterator.next();
      if (RecorderService.class.getName().equals(localRunningServiceInfo.service.getClassName())) {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  private void onListItemSelect(int paramInt)
  {
    this.mThumbAdapter.toggleSelection(paramInt);
    int i;
    if (this.mThumbAdapter.getSelectedCount() <= 0) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) || (this.mActionMode != null))
    {
      if ((i == 0) && (this.mActionMode != null)) {
        this.mActionMode.finish();
      }
    }
    else {
      this.mActionMode = startActionMode(new ActionModeCallback(null));
    }
    if (this.mActionMode != null) {
      this.mActionMode.setTitle(String.valueOf(this.mThumbAdapter.getSelectedCount()) + " selected");
    }
  }
  
  public ArrayList<VideoInfo> GetFilesVideosInfo()
  {
    Object localObject = new File(Environment.getExternalStorageDirectory() + "/SpyVideo");
    ArrayList localArrayList = new ArrayList();
    localObject = new File(((File)localObject).getAbsolutePath());
    ((File)localObject).mkdirs();
    File[] arrayOfFile = ((File)localObject).listFiles();
    if (arrayOfFile.length != 0) {
      for (int i = -1 + arrayOfFile.length; i >= 0; i--)
      {
        localObject = new VideoInfo();
        ((VideoInfo)localObject).setName(arrayOfFile[i].getName());
        ((VideoInfo)localObject).setPath(arrayOfFile[i].getAbsolutePath());
        ((VideoInfo)localObject).setDate(arrayOfFile[i].lastModified());
        ((VideoInfo)localObject).setLength(arrayOfFile[i].length());
        ((VideoInfo)localObject).setThumbnail(ThumbnailUtils.createVideoThumbnail(arrayOfFile[i].getAbsolutePath(), 1));
        localArrayList.add(localObject);
      }
    }
    localArrayList = null;
    return localArrayList;
  }
  
  void animationRecTextView()
  {
    this.txt_rec.startAnimation(this.mAnimation);
    this.mAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        CameraRecorder.this.txt_rec.startAnimation(CameraRecorder.this.mAnimation);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
  }
  
  public boolean deleteFile(String paramString)
  {
    return new File(paramString).delete();
  }
  
  void loadDataIntoAdapter()
  {
    new AsyncTask()
    {
      ProgressDialog progressDialog;
      
      protected Void doInBackground(Void... paramAnonymousVarArgs)
      {
        CameraRecorder.this.myData = CameraRecorder.this.GetFilesVideosInfo();
        if (CameraRecorder.this.myData != null) {
          CameraRecorder.this.mThumbAdapter = new MyThumbAdapter(CameraRecorder.this.mActivity, 2130903041, CameraRecorder.this.myData);
        }
        return null;
      }
      
      protected void onPostExecute(Void paramAnonymousVoid)
      {
        CameraRecorder.this.lst_thumbnail.setAdapter(CameraRecorder.this.mThumbAdapter);
        try
        {
          this.progressDialog.dismiss();
          label24:
          CameraRecorder.this.updateButtonRecordIcon();
          super.onPostExecute(paramAnonymousVoid);
          return;
        }
        catch (Exception localException)
        {
          break label24;
        }
      }
      
      protected void onPreExecute()
      {
        this.progressDialog = new ProgressDialog(CameraRecorder.this);
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.setMessage("Initializing...");
        this.progressDialog.show();
      }
    }.execute(new Void[0]);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public boolean onClick(int paramInt)
  {
    int i = 0;
    int j;
    if (this.mThumbAdapter.getSelectedCount() <= 0) {
      j = 0;
    } else {
      j = 1;
    }
    boolean bool;
    if ((j == 0) && (this.mActionMode == null))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.parse(((VideoInfo)this.myData.get(paramInt)).getPath()), "video/mp4");
      startActivity(localIntent);
      bool = true;
    }
    else
    {
      onListItemSelect(paramInt);
    }
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    setRequestedOrientation(1);
    getActionBar().setBackgroundDrawable(new ColorDrawable(-864059521));
    this.mActivity = this;
    this.myData = new ArrayList();
    this.lst_thumbnail = ((ListView)findViewById(2131296283));
    loadDataIntoAdapter();
    this.lst_thumbnail.setOnItemClickListener(this.mOnItemsClickListener);
    this.lst_thumbnail.setOnItemLongClickListener(this.mOnItemsLongClickListener);
    this.mAdView = ((AdView)findViewById(2131296277));
    this.mAdView.loadAd(new AdRequest.Builder().build());
    this.txt_rec = ((TextView)findViewById(2131296282));
    this.mAnimation = ((AnimationSet)AnimationUtils.loadAnimation(this.mActivity, 2130968576));
    this.btnRecorder = ((ImageView)findViewById(2131296281));
    this.btnRecorder.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CameraRecorder.this.startAndStopServiceRecorder();
        CameraRecorder.this.updateButtonRecordIcon();
        Intent localIntent = new Intent(CameraRecorder.this.mActivity, WidgetStartStopRecorder.class);
        localIntent.setAction(WidgetStartStopRecorder.UPDATE_WIDGET);
        CameraRecorder.this.mActivity.sendBroadcast(localIntent);
      }
    });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131558402, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = super.onOptionsItemSelected(paramMenuItem);
      break;
    case 2131296290: 
      loadDataIntoAdapter();
      break;
    case 2131296291: 
      startActivity(new Intent(this, UserSettingActivity.class));
    }
    return bool;
  }
  
  protected void onResume()
  {
    if (this.myData != null)
    {
      this.mThumbAdapter = new MyThumbAdapter(this.mActivity, 2130903041, this.myData);
      this.lst_thumbnail.setAdapter(this.mThumbAdapter);
    }
    updateButtonRecordIcon();
    super.onResume();
  }
  
  void sendMessageStopRecorder()
  {
    if (this.handler.hasMessages(100)) {
      this.handler.removeMessages(100);
    }
    Message localMessage = this.handler.obtainMessage();
    localMessage.what = 100;
    this.handler.sendMessageDelayed(localMessage, 1500L);
  }
  
  void starrServiceRecorder()
  {
    Intent localIntent = new Intent(this, RecorderService.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("use_camera_front", UserSettingActivity.getInfoWhichCameraForRecorder(this));
    localIntent.putExtra("preview", UserSettingActivity.getInfoShowPreviewOrNot(this));
    Log.i("Giang", "check start config" + UserSettingActivity.getInfoShowPreviewOrNot(this));
    localIntent.putExtra("video_quality", UserSettingActivity.getInfoQualityVideo(this));
    localIntent.putExtra("use_notification", UserSettingActivity.getInfoEnableNotification(this));
    startService(localIntent);
  }
  
  void startAndStopServiceRecorder()
  {
    if (!isMyServiceRunning()) {
      starrServiceRecorder();
    } else {
      sendMessageStopRecorder();
    }
  }
  
  void stopServiceRecorderAsyntask(final Intent paramIntent)
  {
    new AsyncTask()
    {
      ProgressDialog progressDialog;
      
      protected Void doInBackground(Void... paramAnonymousVarArgs)
      {
        CameraRecorder.this.stopService(paramIntent);
        CameraRecorder.this.myData = CameraRecorder.this.GetFilesVideosInfo();
        if (CameraRecorder.this.myData != null) {
          CameraRecorder.this.mThumbAdapter = new MyThumbAdapter(CameraRecorder.this.mActivity, 2130903041, CameraRecorder.this.myData);
        }
        return null;
      }
      
      protected void onPostExecute(Void paramAnonymousVoid)
      {
        CameraRecorder.this.lst_thumbnail.setAdapter(CameraRecorder.this.mThumbAdapter);
        try
        {
          this.progressDialog.dismiss();
          label24:
          CameraRecorder.this.updateButtonRecordIcon();
          Toast.makeText(CameraRecorder.this, "Saved in your My Files /SpyVideo/...", 1).show();
          super.onPostExecute(paramAnonymousVoid);
          return;
        }
        catch (Exception localException)
        {
          break label24;
        }
      }
      
      protected void onPreExecute()
      {
        this.progressDialog = new ProgressDialog(CameraRecorder.this);
        this.progressDialog.setCanceledOnTouchOutside(false);
        this.progressDialog.setMessage("Saving...");
        this.progressDialog.show();
      }
    }.execute(new Void[0]);
  }
  
  void updateButtonRecordIcon()
  {
    if (!isMyServiceRunning())
    {
      this.btnRecorder.setBackgroundResource(2130837539);
      this.mAnimation.reset();
      this.txt_rec.clearAnimation();
      this.txt_rec.setVisibility(4);
    }
    else
    {
      animationRecTextView();
      this.btnRecorder.setBackgroundResource(2130837540);
    }
  }
  
  private class ActionModeCallback
    implements ActionMode.Callback
  {
    private ActionModeCallback() {}
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      int i;
      switch (paramMenuItem.getItemId())
      {
      default: 
        i = 0;
        break;
      case 2131296289: 
        SparseBooleanArray localSparseBooleanArray = CameraRecorder.this.mThumbAdapter.getSelectedIds();
        for (i = -1 + localSparseBooleanArray.size(); i >= 0; i--) {
          if (localSparseBooleanArray.valueAt(i))
          {
            VideoInfo localVideoInfo = (VideoInfo)CameraRecorder.this.mThumbAdapter.getItem(localSparseBooleanArray.keyAt(i));
            CameraRecorder.this.mThumbAdapter.remove(localVideoInfo);
            CameraRecorder.this.deleteFile(localVideoInfo.getPath());
          }
        }
        paramActionMode.finish();
        i = 1;
      }
      return i;
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      paramActionMode.getMenuInflater().inflate(2131558401, paramMenu);
      return true;
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      CameraRecorder.this.mThumbAdapter.removeSelection();
      CameraRecorder.this.mActionMode = null;
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return false;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.martinstudio.secretvideorecorder.CameraRecorder
 * JD-Core Version:    0.7.0.1
 */