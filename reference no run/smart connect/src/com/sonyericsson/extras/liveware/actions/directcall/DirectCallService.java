package com.sonyericsson.extras.liveware.actions.directcall;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings.System;
import android.telephony.PhoneNumberUtils;
import com.sonyericsson.extras.liveware.actions.ActionService;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONObject;

public class DirectCallService
  extends ActionService
{
  private static String TELEFHONE_PREFIX = "tel:";
  
  public int executeAction(Context paramContext, String paramString1, String paramString2)
  {
    int i = 1;
    Dbg.d("executeAction");
    String str = null;
    try
    {
      str = new JSONObject(paramString2).getString(paramContext.getString(2131099655));
      if (Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0) > 0)
      {
        Dbg.d("In flight mode!");
      }
      else if (PhoneNumberUtils.isWellFormedSmsAddress(str))
      {
        Dbg.d("well formed phone number");
        Object localObject = TELEFHONE_PREFIX + str;
        Dbg.d("executeAction, " + (String)localObject);
        localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
        ((Intent)localObject).addFlags(268435456);
        paramContext.startActivity((Intent)localObject);
        i = 0;
      }
      else
      {
        Dbg.d("No setting.");
      }
    }
    catch (Exception localException)
    {
      Dbg.e("Unabel to make phone call to number: " + str, localException);
    }
    return i;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.directcall.DirectCallService
 * JD-Core Version:    0.7.0.1
 */