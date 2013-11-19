package com.sonyericsson.extras.liveware.actions.sms;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONException;
import org.json.JSONObject;

public class SmsAction
  extends AbstractAction
{
  public SmsAction()
  {
    super(SmsAction.class.getSimpleName());
  }
  
  public static JSONObject buildRawSetting(String paramString1, String paramString2, String paramString3)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(paramString1)) {
      localJSONObject.put("sms_contact", paramString1);
    }
    localJSONObject.put("sms_number", paramString2);
    localJSONObject.put("sms_message", paramString3);
    return localJSONObject;
  }
  
  public static String getLabelByRawSetting(Context paramContext, String paramString)
  {
    for (Object localObject = "";; localObject = str1)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        String str2 = localJSONObject.optString("sms_contact", null);
        str1 = localJSONObject.getString("sms_number");
        if (TextUtils.isEmpty(str2)) {
          continue;
        }
        localObject = str2;
        localObject = localObject + ": " + localJSONObject.getString("sms_message");
        localObject = localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          String str1;
          Dbg.e(localJSONException);
        }
      }
      return localObject;
    }
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, SmsService.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return null;
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    return getLabelByRawSetting(paramContext, paramIntent.getStringExtra("setting_raw"));
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, SmsSettings.class);
  }
  
  protected boolean isCompatible(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.telephony");
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.sms.SmsAction
 * JD-Core Version:    0.7.0.1
 */