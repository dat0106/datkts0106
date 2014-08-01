package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerService
  extends IntentService
{
  CampaignTrackingService afN;
  Context afO;
  
  public InstallReferrerService()
  {
    super("InstallReferrerService");
  }
  
  public InstallReferrerService(String paramString)
  {
    super(paramString);
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    if (this.afN == null) {
      this.afN = new CampaignTrackingService();
    }
    this.afN.processIntent(paramContext, paramIntent);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("referrer");
    Context localContext;
    if (this.afO == null) {
      localContext = getApplicationContext();
    } else {
      localContext = this.afO;
    }
    ay.d(localContext, str);
    a(localContext, paramIntent);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.InstallReferrerService
 * JD-Core Version:    0.7.0.1
 */