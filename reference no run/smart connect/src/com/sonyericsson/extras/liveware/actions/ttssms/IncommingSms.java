package com.sonyericsson.extras.liveware.actions.ttssms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class IncommingSms
  extends BroadcastReceiver
{
  private void startService(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Intent localIntent = new Intent(paramContext, IncommingSmsService.class);
      localIntent.putExtras(paramIntent);
      localIntent.setAction(paramIntent.getAction());
      paramContext.startService(localIntent);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Dbg.d("IncommingSms onReceive " + paramIntent.getAction());
    startService(paramContext, paramIntent);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.ttssms.IncommingSms
 * JD-Core Version:    0.7.0.1
 */