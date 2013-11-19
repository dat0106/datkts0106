package com.sonyericsson.extras.liveware.actions.volume;

import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONException;
import org.json.JSONObject;

public class VolumeAction
  extends AbstractAction
{
  public static final String ALARM_VOL_TAG = "alarm";
  public static final String MEDIA_VOL_TAG = "media";
  public static final String NOTIFICATION_VOL_TAG = "notif";
  public static final String RING_VOL_TAG = "ring";
  
  public VolumeAction()
  {
    super(VolumeAction.class.getSimpleName());
  }
  
  public static JSONObject buildRawSetting(int paramInt1, int paramInt2, int paramInt3)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("ring", paramInt1);
    localJSONObject.put("media", paramInt2);
    localJSONObject.put("notif", paramInt1);
    localJSONObject.put("alarm", paramInt3);
    return localJSONObject;
  }
  
  public static String getLabelByRawSetting(Context paramContext, String paramString)
  {
    return "";
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    Dbg.d("getExecuteIntent");
    return new Intent(paramContext, VolumeService.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    Dbg.d("getInjectSettingsIntent");
    return new Intent(paramContext, VolumeSettingsHandler.class);
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    return getLabelByRawSetting(paramContext, paramIntent.getStringExtra("setting_raw"));
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    Dbg.d("getSettingsIntent");
    return new Intent(paramContext, VolumeActivity.class);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.volume.VolumeAction
 * JD-Core Version:    0.7.0.1
 */