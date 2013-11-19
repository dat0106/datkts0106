package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class CampaignTrackingReceiver
  extends BroadcastReceiver
{
  static final String CAMPAIGN_KEY = "referrer";
  static final String INSTALL_ACTION = "com.android.vending.INSTALL_REFERRER";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("referrer");
    if (("com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction())) && (str != null))
    {
      Intent localIntent = new Intent(paramContext, CampaignTrackingService.class);
      localIntent.putExtra("referrer", str);
      paramContext.startService(localIntent);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.CampaignTrackingReceiver
 * JD-Core Version:    0.7.0.1
 */