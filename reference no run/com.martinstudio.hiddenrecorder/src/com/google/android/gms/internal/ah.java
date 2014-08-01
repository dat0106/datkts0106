package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;

public final class ah
  extends aq.a
{
  private final AdListener lO;
  
  public ah(AdListener paramAdListener)
  {
    this.lO = paramAdListener;
  }
  
  public void onAdClosed()
  {
    this.lO.onAdClosed();
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    this.lO.onAdFailedToLoad(paramInt);
  }
  
  public void onAdLeftApplication()
  {
    this.lO.onAdLeftApplication();
  }
  
  public void onAdLoaded()
  {
    this.lO.onAdLoaded();
  }
  
  public void onAdOpened()
  {
    this.lO.onAdOpened();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ah
 * JD-Core Version:    0.7.0.1
 */