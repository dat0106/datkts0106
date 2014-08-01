package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class cx
  extends dg.a
  implements ServiceConnection
{
  private Context mContext;
  private cs oW;
  private String pd;
  private cw ph;
  private boolean pm = false;
  private int pn;
  private Intent po;
  
  public cx(Context paramContext, String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, cw paramcw)
  {
    this.pd = paramString;
    this.pn = paramInt;
    this.po = paramIntent;
    this.pm = paramBoolean;
    this.mContext = paramContext;
    this.ph = paramcw;
  }
  
  public void finishPurchase()
  {
    int i = cz.c(this.po);
    if ((this.pn == -1) && (i == 0))
    {
      this.oW = new cs(this.mContext);
      Context localContext = this.mContext;
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localContext.bindService(localIntent, this, 1);
    }
  }
  
  public String getProductId()
  {
    return this.pd;
  }
  
  public Intent getPurchaseData()
  {
    return this.po;
  }
  
  public int getResultCode()
  {
    return this.pn;
  }
  
  public boolean isVerified()
  {
    return this.pm;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    ev.B("In-app billing service connected.");
    this.oW.o(paramIBinder);
    String str = cz.q(cz.d(this.po));
    if (str != null)
    {
      if (this.oW.a(this.mContext.getPackageName(), str) == 0) {
        cy.h(this.mContext).a(this.ph);
      }
      this.mContext.unbindService(this);
      this.oW.destroy();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    ev.B("In-app billing service disconnected.");
    this.oW.destroy();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cx
 * JD-Core Version:    0.7.0.1
 */