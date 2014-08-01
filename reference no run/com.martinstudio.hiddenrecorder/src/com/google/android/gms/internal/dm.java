package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class dm
  extends dh.a
{
  private final PlayStorePurchaseListener mA;
  
  public dm(PlayStorePurchaseListener paramPlayStorePurchaseListener)
  {
    this.mA = paramPlayStorePurchaseListener;
  }
  
  public void a(dg paramdg)
  {
    this.mA.onInAppPurchaseFinished(new dk(paramdg));
  }
  
  public boolean isValidPurchase(String paramString)
  {
    return this.mA.isValidPurchase(paramString);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dm
 * JD-Core Version:    0.7.0.1
 */