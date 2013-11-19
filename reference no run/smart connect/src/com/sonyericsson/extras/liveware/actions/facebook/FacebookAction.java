package com.sonyericsson.extras.liveware.actions.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.sonyericsson.extras.liveware.actions.AbstractAction;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.MarketUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAction
  extends AbstractAction
{
  public FacebookAction()
  {
    super(FacebookAction.class.getSimpleName());
  }
  
  public static String getLabelByRawSetting(Context paramContext, String paramString)
  {
    try
    {
      str1 = new JSONObject(paramString).optString("facebook_message", "");
      str1 = str1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        String str1;
        Dbg.e(localJSONException);
        String str2 = "";
      }
    }
    return str1;
  }
  
  public static String getRawSetting(int paramInt, String paramString)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("facebook_audience", paramInt);
      localJSONObject.put("facebook_message", paramString);
      str = localJSONObject.toString();
      str = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Dbg.e(localJSONException);
      }
    }
    return str;
  }
  
  protected Intent getExecuteIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, FacebookService.class);
  }
  
  protected Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, FacebookSettingsHandler.class);
  }
  
  protected String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent)
  {
    return getLabelByRawSetting(paramContext, paramIntent.getStringExtra("setting_raw"));
  }
  
  protected Intent getSettingsIntent(Context paramContext, Intent paramIntent)
  {
    return new Intent(paramContext, FacebookSettings.class);
  }
  
  protected boolean isCompatible(Context paramContext)
  {
    boolean bool = false;
    if (!paramContext.getResources().getBoolean(2131427329))
    {
      Dbg.d("FacebookAction checkCompatibility() Disable: Configuration ");
    }
    else if (!MarketUtils.isGooglePlayInstalled(paramContext))
    {
      Dbg.d("FacebookAction checkCompatibility() Disable: Google Play not found ");
    }
    else
    {
      Dbg.d("FacebookAction checkCompatibility() Enable: Google Play found ");
      bool = true;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.facebook.FacebookAction
 * JD-Core Version:    0.7.0.1
 */