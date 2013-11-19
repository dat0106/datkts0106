package com.sonyericsson.extras.liveware.actions.music;

import android.app.IntentService;
import android.content.Intent;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class MusicSettingsHandler
  extends IntentService
{
  private static final String TAG = "MusicSettingsHandler";
  
  public MusicSettingsHandler()
  {
    super("MusicSettingsHandler");
  }
  
  private String getTrackNameFromPath(String paramString)
  {
    String str = "";
    String[] arrayOfString = paramString.split("/");
    if (arrayOfString != null) {
      str = arrayOfString[(-1 + arrayOfString.length)];
    }
    return str;
  }
  
  private void updateSetting(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      Dbg.d("Got setting, will store. Setting: " + paramString2);
      String str;
      if ((!paramString2.equalsIgnoreCase("play")) && (!paramString2.equalsIgnoreCase("pause")) && (!paramString2.equalsIgnoreCase("play_next"))) {
        str = MusicSettings.buildRawSetting("music_settings", paramString2, getTrackNameFromPath(paramString2));
      } else {
        str = MusicSettings.buildRawSetting(paramString2, null, null);
      }
      ActionUtils.sendInjectSettingsResponseIntent(this, paramString1, 0, str);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("id");
    String str2 = paramIntent.getStringExtra("setting_inject");
    if ((str1 != null) && (str2 != null)) {
      updateSetting(str1, str2);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.music.MusicSettingsHandler
 * JD-Core Version:    0.7.0.1
 */