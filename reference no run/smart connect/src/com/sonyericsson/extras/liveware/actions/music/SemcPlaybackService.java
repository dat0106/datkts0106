package com.sonyericsson.extras.liveware.actions.music;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.music.IPlayback;
import com.sonyericsson.music.IPlayback.Stub;
import java.util.ArrayList;
import java.util.List;

public class SemcPlaybackService
  implements PlaybackServiceInterface
{
  private static final int CONDITIONAL_PLAY = 4;
  private static final int MUSIC_SERVICE_TIME_OUT = 1000;
  private static final int MUSIC_SERVICE_WAIT_TIME = 500;
  private static final int NEXT = 3;
  private static final int PAUSE = 2;
  private static final int PLAY = 1;
  private boolean isServiceConnected = false;
  private List<Integer> mActionList = new ArrayList();
  private Context mContext;
  private Handler mHandler = new Handler();
  private IPlayback mManager = null;
  private Runnable mRunner = new Runnable()
  {
    public void run()
    {
      if (SemcPlaybackService.this.mManager != null) {
        SemcPlaybackService.this.runQueuedUpActions();
      }
    }
  };
  private MusicService mService;
  private ServiceConnection mServiceConnection = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      Dbg.d("SemcPlaybackService: onServiceConnection");
      SemcPlaybackService.this.mHandler.removeCallbacks(SemcPlaybackService.this.mTimeoutRunner);
      SemcPlaybackService.this.mManager = IPlayback.Stub.asInterface(paramAnonymousIBinder);
      SemcPlaybackService.this.isServiceConnected = true;
      for (;;)
      {
        try
        {
          if (Dbg.d())
          {
            Dbg.d("SemcPlaybackService: player info, artist: " + SemcPlaybackService.this.mManager.getArtistName());
            Dbg.d("SemcPlaybackService: player info, track: " + SemcPlaybackService.this.mManager.getTrackName());
            StringBuilder localStringBuilder = new StringBuilder("SemcPlaybackService: player info, is ");
            if (!SemcPlaybackService.this.mManager.isPlaying()) {
              break label264;
            }
            str = "playing";
            Dbg.d(str);
            Dbg.d("SemcPlaybackService: player info, track ID is: " + SemcPlaybackService.this.mManager.getTrackId());
          }
          if (SemcPlaybackService.this.mManager.getTrackId() != -1)
          {
            SemcPlaybackService.this.runQueuedUpActions();
          }
          else
          {
            SemcPlaybackService.this.mManager.play();
            SemcPlaybackService.this.mManager.pause();
            SemcPlaybackService.this.mHandler.postDelayed(SemcPlaybackService.this.mRunner, 500L);
          }
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        return;
        label264:
        String str = "not playing";
      }
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      Dbg.d("SemcPlaybackService: onServiceDisconnected");
      SemcPlaybackService.this.mManager = null;
      SemcPlaybackService.this.isServiceConnected = false;
    }
  };
  private Runnable mTimeoutRunner = new Runnable()
  {
    public void run()
    {
      if (SemcPlaybackService.this.mManager == null)
      {
        Dbg.d("SemcPlaybackService: never got a callback, stop service");
        SemcPlaybackService.this.mService.replyAndStop(1);
      }
    }
  };
  
  SemcPlaybackService(Context paramContext, MusicService paramMusicService)
  {
    this.mContext = paramContext;
    this.mService = paramMusicService;
    Dbg.d("SemcPlaybackService: Instantiating");
  }
  
  private void runQueuedUpActions()
  {
    i = 1;
    try
    {
      j = ((Integer)this.mActionList.remove(0)).intValue();
      if (!Dbg.d()) {
        break label334;
      }
      Dbg.d("SemcPlaybackService: runQueuedUpActions, action: " + j);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        int j;
        if (Dbg.e()) {
          Dbg.e("SemcPlaybackService: RemoteException", localRemoteException);
        }
        if ((this.mActionList.isEmpty()) || (i == 1))
        {
          unbindService();
          this.mService.replyAndStop(i);
        }
        else
        {
          this.mHandler.postDelayed(this.mRunner, 500L);
        }
      }
    }
    finally
    {
      for (;;)
      {
        if ((this.mActionList.isEmpty()) || (i == 1))
        {
          unbindService();
          this.mService.replyAndStop(i);
        }
        for (;;)
        {
          throw localObject;
          this.mHandler.postDelayed(this.mRunner, 500L);
        }
        this.mHandler.postDelayed(this.mRunner, 500L);
      }
      switch (localObject)
      {
      }
    }
    if (Dbg.e()) {
      Dbg.e("SemcPlaybackService: unsuported action: " + j);
    }
    while ((this.mActionList.isEmpty()) || (i == 1))
    {
      unbindService();
      this.mService.replyAndStop(i);
      return;
      Dbg.d("SemcPlaybackService: play");
      this.mManager.play();
      i = 0;
      continue;
      Dbg.d("SemcPlaybackService: pause");
      this.mManager.pause();
      i = 0;
      continue;
      Dbg.d("SemcPlaybackService: next");
      this.mManager.next();
      i = 0;
      continue;
      Dbg.d("SemcPlaybackService: conditional play");
      if (!this.mManager.isPlaying())
      {
        Dbg.d("SemcPlaybackService: conditional play, not playing, running play");
        this.mManager.play();
      }
      i = 0;
    }
  }
  
  public boolean bindService()
  {
    Dbg.d("SemcPlaybackService: bindService");
    boolean bool = false;
    Object localObject = new Intent("com.sonyericsson.music.SERVICE");
    try
    {
      if (this.mContext != null)
      {
        Dbg.d("SemcPlaybackService: bindService, context is not null");
        ((Intent)localObject).setAction("com.sonyericsson.music.SERVICE");
        Dbg.d("SemcPlaybackService: bindService, startng service");
        this.mContext.startService((Intent)localObject);
        Dbg.d("SemcPlaybackService: calling bindService");
        bool = this.mContext.bindService((Intent)localObject, this.mServiceConnection, 1);
        this.mHandler.postDelayed(this.mTimeoutRunner, 1000L);
      }
      for (;;)
      {
        if (Dbg.d())
        {
          StringBuilder localStringBuilder = new StringBuilder("SemcPlaybackService: bindService, manager is ");
          if (this.mManager != null) {
            break;
          }
          localObject = "null";
          Dbg.d((String)localObject);
        }
        return bool;
        Dbg.d("SemcPlaybackService: bindService, context is null");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (Dbg.d())
        {
          Dbg.d("SemcPlaybackService: Failed to bind to music player.");
          continue;
          localObject = "not null";
        }
      }
    }
  }
  
  public boolean isPlaying()
  {
    boolean bool2 = false;
    try
    {
      if (this.mManager != null)
      {
        boolean bool1 = this.mManager.isPlaying();
        bool2 = bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Dbg.e("SemcPlaybackService: Failed to check isPlaying", localRemoteException);
      }
    }
    return bool2;
  }
  
  public boolean isServiceConnected()
  {
    return this.isServiceConnected;
  }
  
  public void next()
  {
    this.mActionList.add(Integer.valueOf(3));
    this.mActionList.add(Integer.valueOf(4));
    if (this.mManager != null) {
      runQueuedUpActions();
    }
  }
  
  public void pause()
  {
    this.mActionList.add(Integer.valueOf(2));
    if (this.mManager != null) {
      runQueuedUpActions();
    }
  }
  
  public void play()
  {
    this.mActionList.add(Integer.valueOf(1));
    if (this.mManager != null) {
      runQueuedUpActions();
    }
  }
  
  public void unbindService()
  {
    Dbg.d("SemcPlaybackService: unbindService");
    if ((this.mContext != null) && (this.isServiceConnected))
    {
      Dbg.d("SemcPlaybackService: unbind");
      this.mContext.unbindService(this.mServiceConnection);
    }
    this.isServiceConnected = false;
    this.mManager = null;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.music.SemcPlaybackService
 * JD-Core Version:    0.7.0.1
 */