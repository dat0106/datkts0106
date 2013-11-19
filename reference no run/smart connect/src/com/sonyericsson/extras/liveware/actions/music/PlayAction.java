package com.sonyericsson.extras.liveware.actions.music;

import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayAction
  extends AbstractAction
{
  public PlayAction()
  {
    super(PlayAction.class.getSimpleName());
  }
  
  public static String getLabelByRawSetting(Context paramContext, String paramString)
  {
    String str1 = "";
    try
    {
      Object localObject = new JSONObject(paramString);
      String str2 = ((JSONObject)localObject).optString("music_settings");
      if (str2.equalsIgnoreCase("play"))
      {
        str1 = paramContext.getString(2131099861);
      }
      else if (str2.equalsIgnoreCase("play_next"))
      {
        str1 = paramContext.getString(2131099862);
      }
      else if (str2.equalsIgnoreCase("pause"))
      {
        str1 = paramContext.getString(2131099860);
      }
      else if (str2.equalsIgnoreCase("play_track_setting"))
      {
        localObject = ((JSONObject)localObject).optString("music_track", "");
        str1 = paramContext.getString(2131099863) + " - " + (String)localObject;
        str1 = str1;
      }
    }
    catch (JSONException localJSONException)
    {
      Dbg.e(localJSONException);
    }
    return str1;
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, MusicService.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, MusicSettingsHandler.class);
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    return getLabelByRawSetting(paramContext, paramIntent.getStringExtra("setting_raw"));
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, MusicSettings.class);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.music.PlayAction
 * JD-Core Version:    0.7.0.1
 */