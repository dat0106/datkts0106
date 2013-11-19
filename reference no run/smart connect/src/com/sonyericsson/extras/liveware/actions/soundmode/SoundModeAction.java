package com.sonyericsson.extras.liveware.actions.soundmode;

import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.actions.ActionService;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class SoundModeAction
  extends ActionService
{
  public int executeAction(Context paramContext, String paramString1, String paramString2)
  {
    int i = 0;
    AudioManager localAudioManager = (AudioManager)getSystemService("audio");
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      if (TextUtils.isEmpty(paramString2)) {
        Dbg.d("No setting.");
      }
    }
    else
    {
      i = 1;
      break label119;
    }
    if (!paramString2.equalsIgnoreCase("silent"))
    {
      if (!paramString2.equalsIgnoreCase("vibrate"))
      {
        localAudioManager.setRingerMode(2);
      }
      else
      {
        Vibrator localVibrator = (Vibrator)getSystemService("vibrator");
        if ((localVibrator == null) || (!localVibrator.hasVibrator())) {
          localAudioManager.setRingerMode(0);
        } else {
          localAudioManager.setRingerMode(1);
        }
      }
    }
    else {
      localAudioManager.setRingerMode(0);
    }
    label119:
    return i;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.soundmode.SoundModeAction
 * JD-Core Version:    0.7.0.1
 */