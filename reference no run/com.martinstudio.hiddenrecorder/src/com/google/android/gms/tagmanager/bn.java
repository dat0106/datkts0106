package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

class bn
  extends BroadcastReceiver
{
  static final String tO = bn.class.getName();
  private final cw agj;
  
  bn(cw paramcw)
  {
    this.agj = paramcw;
  }
  
  public static void t(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(paramContext.getPackageName());
    localIntent.putExtra(tO, true);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(localObject))
    {
      if (("com.google.analytics.RADIO_POWERED".equals(localObject)) && (!paramIntent.hasExtra(tO))) {
        this.agj.cD();
      }
    }
    else
    {
      localObject = paramIntent.getExtras();
      Boolean localBoolean = Boolean.FALSE;
      if (localObject != null) {
        localBoolean = Boolean.valueOf(paramIntent.getExtras().getBoolean("noConnectivity"));
      }
      localObject = this.agj;
      boolean bool;
      if (localBoolean.booleanValue()) {
        bool = false;
      } else {
        bool = true;
      }
      ((cw)localObject).t(bool);
    }
  }
  
  public void s(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(this, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.google.analytics.RADIO_POWERED");
    localIntentFilter.addCategory(paramContext.getPackageName());
    paramContext.registerReceiver(this, localIntentFilter);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.bn
 * JD-Core Version:    0.7.0.1
 */