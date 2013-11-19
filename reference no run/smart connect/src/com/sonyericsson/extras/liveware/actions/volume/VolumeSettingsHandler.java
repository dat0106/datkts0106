package com.sonyericsson.extras.liveware.actions.volume;

import android.app.IntentService;
import android.content.Intent;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONException;
import org.json.JSONObject;

public class VolumeSettingsHandler
  extends IntentService
{
  private static final String TAG = "VolumeSettingsHandler";
  
  public VolumeSettingsHandler()
  {
    super("VolumeSettingsHandler");
  }
  
  private int clampVolume(int paramInt)
  {
    int i;
    if (paramInt >= 0) {
      i = Math.min(100, paramInt);
    } else {
      i = -1;
    }
    return i;
  }
  
  private void updateSetting(String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws JSONException
  {
    ActionUtils.sendInjectSettingsResponseIntent(this, paramString, 0, VolumeAction.buildRawSetting(paramInt1, paramInt2, paramInt3).toString());
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("id");
    String[] arrayOfString = paramIntent.getStringExtra("setting_inject").split(";");
    try
    {
      int j = clampVolume(Integer.parseInt(arrayOfString[0]));
      int i = clampVolume(Integer.parseInt(arrayOfString[1]));
      int k = clampVolume(Integer.parseInt(arrayOfString[2]));
      if (str != null) {
        updateSetting(str, j, i, k);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Dbg.e(localNumberFormatException);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Dbg.e(localJSONException);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.volume.VolumeSettingsHandler
 * JD-Core Version:    0.7.0.1
 */