package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public final class cz
{
  public static int a(Bundle paramBundle)
  {
    Object localObject = paramBundle.get("RESPONSE_CODE");
    int i;
    if (localObject != null)
    {
      if (!(localObject instanceof Integer))
      {
        if (!(localObject instanceof Long))
        {
          ev.D("Unexpected type for intent response code. " + localObject.getClass().getName());
          i = 5;
        }
        else
        {
          i = (int)((Long)i).longValue();
        }
      }
      else {
        i = ((Integer)i).intValue();
      }
    }
    else
    {
      ev.D("Bundle with null response code, assuming OK (known issue)");
      i = 0;
    }
    return i;
  }
  
  public static int c(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras().get("RESPONSE_CODE");
    int i;
    if (localObject != null)
    {
      if (!(localObject instanceof Integer))
      {
        if (!(localObject instanceof Long))
        {
          ev.D("Unexpected type for intent response code. " + localObject.getClass().getName());
          i = 5;
        }
        else
        {
          i = (int)((Long)i).longValue();
        }
      }
      else {
        i = ((Integer)i).intValue();
      }
    }
    else
    {
      ev.D("Intent with no response code, assuming OK (known issue)");
      i = 0;
    }
    return i;
  }
  
  public static String d(Intent paramIntent)
  {
    String str;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
    } else {
      str = null;
    }
    return str;
  }
  
  public static String e(Intent paramIntent)
  {
    String str;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
    } else {
      str = null;
    }
    return str;
  }
  
  public static String p(String paramString)
  {
    String str = null;
    if (paramString == null) {}
    for (;;)
    {
      return str;
      try
      {
        str = new JSONObject(paramString).getString("developerPayload");
        str = str;
      }
      catch (JSONException localJSONException)
      {
        ev.D("Fail to parse purchase data");
      }
    }
  }
  
  public static String q(String paramString)
  {
    String str = null;
    if (paramString == null) {}
    for (;;)
    {
      return str;
      try
      {
        str = new JSONObject(paramString).getString("purchaseToken");
        str = str;
      }
      catch (JSONException localJSONException)
      {
        ev.D("Fail to parse purchase data");
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cz
 * JD-Core Version:    0.7.0.1
 */