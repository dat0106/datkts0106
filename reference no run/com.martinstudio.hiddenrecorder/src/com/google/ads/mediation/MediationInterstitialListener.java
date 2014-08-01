package com.google.ads.mediation;

import com.google.ads.AdRequest.ErrorCode;

@Deprecated
public abstract interface MediationInterstitialListener
{
  public abstract void onDismissScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter);
  
  public abstract void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, AdRequest.ErrorCode paramErrorCode);
  
  public abstract void onLeaveApplication(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter);
  
  public abstract void onPresentScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter);
  
  public abstract void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter);
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.MediationInterstitialListener
 * JD-Core Version:    0.7.0.1
 */