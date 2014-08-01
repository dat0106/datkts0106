package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.ev;

public final class CustomEventAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter
{
  private View n;
  private CustomEventBanner sT;
  private CustomEventInterstitial sU;
  
  private static <T> T a(String paramString)
  {
    try
    {
      localObject1 = Class.forName(paramString).newInstance();
      localObject1 = localObject1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        ev.D("Could not instantiate custom event adapter: " + paramString + ". " + localThrowable.getMessage());
        Object localObject2 = null;
      }
    }
    return localObject1;
  }
  
  private void a(View paramView)
  {
    this.n = paramView;
  }
  
  public View getBannerView()
  {
    return this.n;
  }
  
  public void onDestroy()
  {
    if (this.sT != null) {
      this.sT.onDestroy();
    }
    if (this.sU != null) {
      this.sU.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.sT != null) {
      this.sT.onPause();
    }
    if (this.sU != null) {
      this.sU.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.sT != null) {
      this.sT.onResume();
    }
    if (this.sU != null) {
      this.sU.onResume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.sT = ((CustomEventBanner)a(paramBundle1.getString("class_name")));
    if (this.sT != null)
    {
      Bundle localBundle;
      if (paramBundle2 != null) {
        localBundle = paramBundle2.getBundle(paramBundle1.getString("class_name"));
      } else {
        localBundle = null;
      }
      this.sT.requestBannerAd(paramContext, new a(this, paramMediationBannerListener), paramBundle1.getString("parameter"), paramAdSize, paramMediationAdRequest, localBundle);
    }
    else
    {
      paramMediationBannerListener.onAdFailedToLoad(this, 0);
    }
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    this.sU = ((CustomEventInterstitial)a(paramBundle1.getString("class_name")));
    if (this.sU != null)
    {
      Bundle localBundle;
      if (paramBundle2 != null) {
        localBundle = paramBundle2.getBundle(paramBundle1.getString("class_name"));
      } else {
        localBundle = null;
      }
      this.sU.requestInterstitialAd(paramContext, new b(this, paramMediationInterstitialListener), paramBundle1.getString("parameter"), paramMediationAdRequest, localBundle);
    }
    else
    {
      paramMediationInterstitialListener.onAdFailedToLoad(this, 0);
    }
  }
  
  public void showInterstitial()
  {
    this.sU.showInterstitial();
  }
  
  private class b
    implements CustomEventInterstitialListener
  {
    private final MediationInterstitialListener m;
    private final CustomEventAdapter sV;
    
    public b(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      this.sV = paramCustomEventAdapter;
      this.m = paramMediationInterstitialListener;
    }
    
    public void onAdClicked()
    {
      ev.z("Custom event adapter called onAdClicked.");
      this.m.onAdClicked(this.sV);
    }
    
    public void onAdClosed()
    {
      ev.z("Custom event adapter called onAdClosed.");
      this.m.onAdClosed(this.sV);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      ev.z("Custom event adapter called onFailedToReceiveAd.");
      this.m.onAdFailedToLoad(this.sV, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      ev.z("Custom event adapter called onAdLeftApplication.");
      this.m.onAdLeftApplication(this.sV);
    }
    
    public void onAdLoaded()
    {
      ev.z("Custom event adapter called onReceivedAd.");
      this.m.onAdLoaded(CustomEventAdapter.this);
    }
    
    public void onAdOpened()
    {
      ev.z("Custom event adapter called onAdOpened.");
      this.m.onAdOpened(this.sV);
    }
  }
  
  private static final class a
    implements CustomEventBannerListener
  {
    private final MediationBannerListener l;
    private final CustomEventAdapter sV;
    
    public a(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
    {
      this.sV = paramCustomEventAdapter;
      this.l = paramMediationBannerListener;
    }
    
    public void onAdClicked()
    {
      ev.z("Custom event adapter called onAdClicked.");
      this.l.onAdClicked(this.sV);
    }
    
    public void onAdClosed()
    {
      ev.z("Custom event adapter called onAdClosed.");
      this.l.onAdClosed(this.sV);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      ev.z("Custom event adapter called onAdFailedToLoad.");
      this.l.onAdFailedToLoad(this.sV, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      ev.z("Custom event adapter called onAdLeftApplication.");
      this.l.onAdLeftApplication(this.sV);
    }
    
    public void onAdLoaded(View paramView)
    {
      ev.z("Custom event adapter called onAdLoaded.");
      CustomEventAdapter.a(this.sV, paramView);
      this.l.onAdLoaded(this.sV);
    }
    
    public void onAdOpened()
    {
      ev.z("Custom event adapter called onAdOpened.");
      this.l.onAdOpened(this.sV);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
 * JD-Core Version:    0.7.0.1
 */