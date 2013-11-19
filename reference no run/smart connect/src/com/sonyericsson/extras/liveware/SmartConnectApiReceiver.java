package com.sonyericsson.extras.liveware;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.sonymobile.smartconnect.internal.SmartConnectDeviceService;

public class SmartConnectApiReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.setComponent(new ComponentName(paramContext, SmartConnectDeviceService.class));
    paramContext.startService(paramIntent);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.SmartConnectApiReceiver
 * JD-Core Version:    0.7.0.1
 */