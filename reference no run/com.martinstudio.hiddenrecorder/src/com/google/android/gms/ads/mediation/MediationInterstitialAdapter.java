package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;

public abstract interface MediationInterstitialAdapter
  extends MediationAdapter
{
  public abstract void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2);
  
  public abstract void showInterstitial();
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationInterstitialAdapter
 * JD-Core Version:    0.7.0.1
 */