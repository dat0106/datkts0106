package com.sonyericsson.extras.liveware.actions.music;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class GenericPlaybackService
  implements PlaybackServiceInterface
{
  private static final String TAG = "GenericPlaybackService";
  private Context mContext;
  private MusicService mService;
  
  GenericPlaybackService(Context paramContext, MusicService paramMusicService)
  {
    this.mContext = paramContext;
    this.mService = paramMusicService;
    Dbg.d("Instantiating GenericPlaybackService");
  }
  
  private void sendMediaButtonIntent(int paramInt)
  {
    try
    {
      long l = SystemClock.uptimeMillis();
      Intent localIntent = new Intent("android.intent.action.MEDIA_BUTTON", null);
      localIntent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(l, l, 0, paramInt, 0));
      this.mContext.sendOrderedBroadcast(localIntent, null);
      localIntent = new Intent("android.intent.action.MEDIA_BUTTON", null);
      localIntent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(l, l, 1, paramInt, 0));
      this.mContext.sendOrderedBroadcast(localIntent, null);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("GenericPlaybackService", "Failed to send media button intent.", localException);
      }
    }
  }
  
  private void shutDown()
  {
    this.mService.replyAndStop(0);
  }
  
  public boolean bindService()
  {
    return true;
  }
  
  public boolean isPlaying()
  {
    AudioManager localAudioManager = (AudioManager)this.mContext.getSystemService("audio");
    StringBuilder localStringBuilder = new StringBuilder("isMusicActive: ");
    String str;
    if (!localAudioManager.isMusicActive()) {
      str = "no";
    } else {
      str = "yes";
    }
    Dbg.d(str);
    return localAudioManager.isMusicActive();
  }
  
  public boolean isServiceConnected()
  {
    return true;
  }
  
  public void next()
  {
    sendMediaButtonIntent(87);
    shutDown();
  }
  
  public void pause()
  {
    if ((isPlaying()) && (this.mContext != null)) {
      sendMediaButtonIntent(85);
    }
    shutDown();
  }
  
  public void play()
  {
    if ((!isPlaying()) && (this.mContext != null)) {
      sendMediaButtonIntent(85);
    }
    shutDown();
  }
  
  public void unbindService() {}
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.music.GenericPlaybackService
 * JD-Core Version:    0.7.0.1
 */