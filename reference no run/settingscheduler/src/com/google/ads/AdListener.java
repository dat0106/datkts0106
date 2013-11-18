package com.google.ads;

public abstract interface AdListener
{
  public abstract void onDismissScreen(Ad paramAd);
  
  public abstract void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode);
  
  public abstract void onLeaveApplication(Ad paramAd);
  
  public abstract void onPresentScreen(Ad paramAd);
  
  public abstract void onReceiveAd(Ad paramAd);
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.AdListener
 * JD-Core Version:    0.7.0.1
 */