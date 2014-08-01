package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.de;
import com.google.android.gms.internal.dj;
import com.google.android.gms.internal.ev;

public final class InAppPurchaseActivity
  extends Activity
{
  public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
  public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
  private de sY;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      if (this.sY != null) {
        this.sY.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not forward onActivityResult to in-app purchase manager:", localRemoteException);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.sY = dj.d(this);
    if (this.sY == null)
    {
      ev.D("Could not create in-app purchase manager.");
      finish();
    }
    for (;;)
    {
      return;
      try
      {
        this.sY.onCreate();
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not forward onCreate to in-app purchase manager:", localRemoteException);
        finish();
      }
    }
  }
  
  protected void onDestroy()
  {
    try
    {
      if (this.sY != null) {
        this.sY.onDestroy();
      }
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not forward onDestroy to in-app purchase manager:", localRemoteException);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.purchase.InAppPurchaseActivity
 * JD-Core Version:    0.7.0.1
 */