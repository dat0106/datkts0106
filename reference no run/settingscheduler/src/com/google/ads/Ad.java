package com.google.ads;

public abstract interface Ad
{
  public abstract boolean isReady();
  
  public abstract void loadAd(AdRequest paramAdRequest);
  
  public abstract void setAdListener(AdListener paramAdListener);
  
  public abstract void stopLoading();
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.Ad
 * JD-Core Version:    0.7.0.1
 */