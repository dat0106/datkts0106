package com.sonyericsson.extras.liveware.actions.music;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONException;
import org.json.JSONObject;

public class MusicService
  extends Service
{
  private SmartTagsMediaPlayer mPlayer = null;
  private String mUuid;
  
  private void startMediaPlayer(Context paramContext)
  {
    this.mPlayer = new SmartTagsMediaPlayer(paramContext, this);
    this.mPlayer.startAndBindToMediaService();
    StringBuilder localStringBuilder = new StringBuilder("executeAction, Player is ");
    String str;
    if (!this.mPlayer.isConnected()) {
      str = "not connected";
    } else {
      str = "connected";
    }
    Dbg.d(str);
  }
  
  public void executeAction(Context paramContext, String paramString)
  {
    Dbg.d("executeAction");
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      str = localJSONObject.getString("music_settings");
      if (str.equalsIgnoreCase("play"))
      {
        Dbg.d("play");
        startMediaPlayer(paramContext);
        this.mPlayer.play();
      }
      else if (str.equalsIgnoreCase("play_next"))
      {
        Dbg.d("play next");
        startMediaPlayer(paramContext);
        this.mPlayer.next();
      }
    }
    catch (JSONException localJSONException)
    {
      Dbg.e(localJSONException);
      replyAndStop(1);
    }
    if (str.equalsIgnoreCase("pause"))
    {
      Dbg.d("pause");
      startMediaPlayer(paramContext);
      this.mPlayer.pause();
    }
    else if (str.equalsIgnoreCase("play_track_setting"))
    {
      Dbg.d("play track");
      MusicUtils.playTrack(paramContext, localJSONException.getString("music_path"), this);
    }
    else
    {
      replyAndStop(1);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Dbg.d("onBind");
    return null;
  }
  
  public void onDestroy()
  {
    Dbg.d("onDestroy");
    if ((this.mPlayer != null) && (this.mPlayer.isConnected())) {
      this.mPlayer.unbindService();
    }
    stopSelf();
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
    {
      Dbg.d("startCommand, null intent");
      stopSelf();
    }
    else
    {
      String str = paramIntent.getStringExtra("setting_raw");
      this.mUuid = paramIntent.getStringExtra("id");
      if (!TextUtils.isEmpty(str)) {
        executeAction(getApplicationContext(), str);
      } else {
        replyAndStop(1);
      }
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public void replyAndStop(int paramInt)
  {
    ActionUtils.sendExecuteReplyIntent(this, this.mUuid, paramInt);
    stopSelf();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.music.MusicService
 * JD-Core Version:    0.7.0.1
 */