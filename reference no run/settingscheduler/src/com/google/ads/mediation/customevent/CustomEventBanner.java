package com.google.ads.mediation.customevent;

import android.app.Activity;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;

public abstract interface CustomEventBanner
  extends CustomEvent
{
  public abstract void requestBannerAd(CustomEventBannerListener paramCustomEventBannerListener, Activity paramActivity, String paramString1, String paramString2, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Object paramObject);
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.customevent.CustomEventBanner
 * JD-Core Version:    0.7.0.1
 */