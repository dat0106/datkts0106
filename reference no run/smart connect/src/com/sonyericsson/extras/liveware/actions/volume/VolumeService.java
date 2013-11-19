package com.sonyericsson.extras.liveware.actions.volume;

import android.content.Context;
import android.media.AudioManager;
import com.sonyericsson.extras.liveware.actions.ActionService;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONException;
import org.json.JSONObject;

public class VolumeService
  extends ActionService
{
  private void setVolume(Context paramContext, String paramString1, int paramInt, String paramString2, AudioManager paramAudioManager)
  {
    try
    {
      int i = new JSONObject(paramString1).getInt(paramString2);
      if (i < 0)
      {
        if (Dbg.d()) {
          Dbg.d("setVolume, streamType: " + paramInt + ", volumeInPercent: " + i + ". Leave unchanged.");
        }
      }
      else
      {
        int k = paramAudioManager.getStreamMaxVolume(paramInt);
        int j = k * i / 100;
        if (Dbg.d()) {
          Dbg.d("setVolume, streamType: " + paramInt + ", volumeInPercent: " + i + " max: " + k + " vol: " + j);
        }
        if (j >= 0) {
          paramAudioManager.setStreamVolume(paramInt, j, 0);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      Dbg.e(localJSONException);
    }
  }
  
  public int executeAction(Context paramContext, String paramString1, String paramString2)
  {
    Dbg.d("executeAction");
    AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
    Dbg.d("executeAction, set ring");
    setVolume(paramContext, paramString2, 2, "ring", localAudioManager);
    Dbg.d("executeAction, set media");
    setVolume(paramContext, paramString2, 3, "media", localAudioManager);
    Dbg.d("executeAction, set notif");
    setVolume(paramContext, paramString2, 5, "notif", localAudioManager);
    Dbg.d("executeAction, set alarm");
    setVolume(paramContext, paramString2, 4, "alarm", localAudioManager);
    return 0;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.volume.VolumeService
 * JD-Core Version:    0.7.0.1
 */