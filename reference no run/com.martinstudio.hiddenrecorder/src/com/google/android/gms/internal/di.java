package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

public final class di
  extends dd.a
{
  private final InAppPurchaseListener mz;
  
  public di(InAppPurchaseListener paramInAppPurchaseListener)
  {
    this.mz = paramInAppPurchaseListener;
  }
  
  public void a(dc paramdc)
  {
    this.mz.onInAppPurchaseRequested(new dl(paramdc));
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.di
 * JD-Core Version:    0.7.0.1
 */