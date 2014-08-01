package com.google.android.gms.ads.purchase;

public abstract interface PlayStorePurchaseListener
{
  public abstract boolean isValidPurchase(String paramString);
  
  public abstract void onInAppPurchaseFinished(InAppPurchaseResult paramInAppPurchaseResult);
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.purchase.PlayStorePurchaseListener
 * JD-Core Version:    0.7.0.1
 */