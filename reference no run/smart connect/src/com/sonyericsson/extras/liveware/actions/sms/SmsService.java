package com.sonyericsson.extras.liveware.actions.sms;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Telephony.Sms;
import android.provider.Telephony.Sms.Outbox;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import com.sonyericsson.extras.liveware.actions.ActionService;
import com.sonyericsson.extras.liveware.utils.Dbg;
import org.json.JSONObject;

public class SmsService
  extends ActionService
{
  private PendingIntent createDeliveryIntent(Uri paramUri)
  {
    return PendingIntent.getBroadcast(this, 0, new Intent("com.sonyericsson.extras.liveware.SMS_DELIVERY_INTENT", paramUri, this, SmsResultReceiver.class), 134217728);
  }
  
  private PendingIntent getSentIntent(String paramString, Uri paramUri)
  {
    Intent localIntent = new Intent("com.sonyericsson.extras.liveware.SMS_RESULT_INTENT", paramUri, this, SmsResultReceiver.class);
    localIntent.putExtra("id", paramString);
    return PendingIntent.getBroadcast(this, 0, localIntent, 134217728);
  }
  
  public int executeAction(Context paramContext, String paramString1, String paramString2)
  {
    Dbg.d("executeAction");
    String str1 = null;
    try
    {
      Object localObject1 = new JSONObject(paramString2);
      str1 = ((JSONObject)localObject1).getString("sms_number");
      String str2 = ((JSONObject)localObject1).getString("sms_message");
      int i;
      if (PhoneNumberUtils.isWellFormedSmsAddress(str1))
      {
        Dbg.d("well formed SMS address");
        Object localObject2 = Telephony.Sms.addMessageToUri(getContentResolver(), Telephony.Sms.Outbox.CONTENT_URI, str1, str2, null, Long.valueOf(System.currentTimeMillis()), true, true);
        SmsManager localSmsManager = SmsManager.getDefault();
        localObject1 = getSentIntent(paramString1, (Uri)localObject2);
        localObject2 = createDeliveryIntent((Uri)localObject2);
        localSmsManager.sendTextMessage(str1, null, str2, (PendingIntent)localObject1, (PendingIntent)localObject2);
        i = 2;
      }
      else
      {
        Dbg.d("No setting.");
        i = 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Dbg.e("Unable to send SMS to number: " + str1, localException);
      }
    }
    return localException;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.sms.SmsService
 * JD-Core Version:    0.7.0.1
 */