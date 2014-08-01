package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class q
  extends BroadcastReceiver
{
  static final String tO = q.class.getName();
  private final af tP;
  
  q(af paramaf)
  {
    this.tP = paramaf;
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
    boolean bool1 = false;
    String str = paramIntent.getAction();
    if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(str))
    {
      if (("com.google.analytics.RADIO_POWERED".equals(str)) && (!paramIntent.hasExtra(tO))) {
        this.tP.cD();
      }
    }
    else
    {
      boolean bool2 = paramIntent.getBooleanExtra("noConnectivity", false);
      af localaf = this.tP;
      if (!bool2) {
        bool1 = true;
      }
      localaf.t(bool1);
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
 * Qualified Name:     com.google.android.gms.analytics.q
 * JD-Core Version:    0.7.0.1
 */