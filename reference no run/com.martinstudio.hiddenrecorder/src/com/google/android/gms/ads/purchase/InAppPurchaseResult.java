package com.google.android.gms.ads.purchase;

import android.content.Intent;

public abstract interface InAppPurchaseResult
{
  public abstract void finishPurchase();
  
  public abstract String getProductId();
  
  public abstract Intent getPurchaseData();
  
  public abstract int getResultCode();
  
  public abstract boolean isVerified();
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.purchase.InAppPurchaseResult
 * JD-Core Version:    0.7.0.1
 */