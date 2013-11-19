package com.sonyericsson.extras.liveware.actions.facebook;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.Resources;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookSettingsHandler
  extends IntentService
{
  private static final String TAG = "FacebookSettingsHandler";
  
  public FacebookSettingsHandler()
  {
    super("FacebookSettingsHandler");
  }
  
  private void updateSetting(String paramString1, int paramInt, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    int i = 1;
    String str = null;
    try
    {
      localJSONObject.put("facebook_audience", paramInt);
      localJSONObject.put("facebook_message", paramString2);
      str = localJSONObject.toString();
      str = str;
      i = 0;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Dbg.e(localJSONException);
      }
    }
    ActionUtils.sendInjectSettingsResponseIntent(this, paramString1, i, str);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("id");
    String str3 = paramIntent.getStringExtra("setting_inject");
    int j = str3.indexOf(";");
    String str2;
    if (j != -1)
    {
      str2 = str3.substring(0, j);
      str3 = str3.substring(j + 1);
      if (str3.charAt(0) == '@')
      {
        String str4 = str3.substring(1);
        int k = getResources().getIdentifier(str4, "string", getPackageName());
        if (k != 0) {
          str3 = getString(k);
        }
      }
      if (Dbg.v()) {
        Dbg.v("Facebooksetting -> audienceString:" + str2 + " messageString:" + str3);
      }
    }
    try
    {
      int i = Integer.parseInt(str2);
      if ((FacebookUtils.isAudienceValid(i)) && (str1 != null)) {
        updateSetting(str1, i, str3);
      }
      label160:
      return;
    }
    catch (Exception localException)
    {
      break label160;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.facebook.FacebookSettingsHandler
 * JD-Core Version:    0.7.0.1
 */