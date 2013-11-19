package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class GANetworkReceiver
  extends BroadcastReceiver
{
  private final ServiceManager mManager;
  
  GANetworkReceiver(ServiceManager paramServiceManager)
  {
    this.mManager = paramServiceManager;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
    {
      Object localObject = paramIntent.getExtras();
      Boolean localBoolean = Boolean.FALSE;
      if (localObject != null) {
        localBoolean = Boolean.valueOf(paramIntent.getExtras().getBoolean("noConnectivity"));
      }
      localObject = this.mManager;
      boolean bool;
      if (localBoolean.booleanValue()) {
        bool = false;
      } else {
        bool = true;
      }
      ((ServiceManager)localObject).updateConnectivityStatus(bool);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.GANetworkReceiver
 * JD-Core Version:    0.7.0.1
 */