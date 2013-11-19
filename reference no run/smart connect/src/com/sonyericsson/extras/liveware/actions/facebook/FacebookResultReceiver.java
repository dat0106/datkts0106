package com.sonyericsson.extras.liveware.actions.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class FacebookResultReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (Dbg.d()) {
      Dbg.d("FacebookResultReceiver onReceive() getResultCode()=" + getResultCode() + "FACEBOOK_STATUS_OK=" + true);
    }
    if (!paramIntent.getBooleanExtra("facebook_status", false))
    {
      String str = paramIntent.getStringExtra("facebook_error");
      Dbg.e("FacebookResultReceiver onReceive() Notification error:" + str);
      FacebookUtils.getInstance(paramContext).notifyUserOfError(str);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.facebook.FacebookResultReceiver
 * JD-Core Version:    0.7.0.1
 */