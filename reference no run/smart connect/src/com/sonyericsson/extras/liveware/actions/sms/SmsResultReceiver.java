package com.sonyericsson.extras.liveware.actions.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SmsResultReceiver
  extends BroadcastReceiver
{
  public static final String EXTRA_RESULT_CODE = "result";
  public static final String RESULT_ACTION = "com.sonyericsson.extras.liveware.SMS_RESULT_INTENT";
  public static final String SMS_DELIVERY_INTENT = "com.sonyericsson.extras.liveware.SMS_DELIVERY_INTENT";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.setClass(paramContext, SmsResultService.class);
    paramIntent.putExtra("result", getResultCode());
    paramContext.startService(paramIntent);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.sms.SmsResultReceiver
 * JD-Core Version:    0.7.0.1
 */