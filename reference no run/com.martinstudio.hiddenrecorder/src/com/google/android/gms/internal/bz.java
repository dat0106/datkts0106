package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

public final class bz
  implements MediationBannerListener, MediationInterstitialListener
{
  private final bw nR;
  
  public bz(bw parambw)
  {
    this.nR = parambw;
  }
  
  public void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hn.ay("onAdClicked must be called on the main UI thread.");
    ev.z("Adapter called onAdClicked.");
    try
    {
      this.nR.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call onAdClicked.", localRemoteException);
      }
    }
  }
  
  public void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hn.ay("onAdClicked must be called on the main UI thread.");
    ev.z("Adapter called onAdClicked.");
    try
    {
      this.nR.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call onAdClicked.", localRemoteException);
      }
    }
  }
  
  public void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hn.ay("onAdClosed must be called on the main UI thread.");
    ev.z("Adapter called onAdClosed.");
    try
    {
      this.nR.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call onAdClosed.", localRemoteException);
      }
    }
  }
  
  public void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hn.ay("onAdClosed must be called on the main UI thread.");
    ev.z("Adapter called onAdClosed.");
    try
    {
      this.nR.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call onAdClosed.", localRemoteException);
      }
    }
  }
  
  public void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    hn.ay("onAdFailedToLoad must be called on the main UI thread.");
    ev.z("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.nR.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call onAdFailedToLoad.", localRemoteException);
      }
    }
  }
  
  public void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    hn.ay("onAdFailedToLoad must be called on the main UI thread.");
    ev.z("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.nR.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call onAdFailedToLoad.", localRemoteException);
      }
    }
  }
  
  public void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hn.ay("onAdLeftApplication must be called on the main UI thread.");
    ev.z("Adapter called onAdLeftApplication.");
    try
    {
      this.nR.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call onAdLeftApplication.", localRemoteException);
      }
    }
  }
  
  public void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hn.ay("onAdLeftApplication must be called on the main UI thread.");
    ev.z("Adapter called onAdLeftApplication.");
    try
    {
      this.nR.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call onAdLeftApplication.", localRemoteException);
      }
    }
  }
  
  public void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hn.ay("onAdLoaded must be called on the main UI thread.");
    ev.z("Adapter called onAdLoaded.");
    try
    {
      this.nR.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call onAdLoaded.", localRemoteException);
      }
    }
  }
  
  public void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hn.ay("onAdLoaded must be called on the main UI thread.");
    ev.z("Adapter called onAdLoaded.");
    try
    {
      this.nR.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call onAdLoaded.", localRemoteException);
      }
    }
  }
  
  public void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
  {
    hn.ay("onAdOpened must be called on the main UI thread.");
    ev.z("Adapter called onAdOpened.");
    try
    {
      this.nR.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call onAdOpened.", localRemoteException);
      }
    }
  }
  
  public void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    hn.ay("onAdOpened must be called on the main UI thread.");
    ev.z("Adapter called onAdOpened.");
    try
    {
      this.nR.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not call onAdOpened.", localRemoteException);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bz
 * JD-Core Version:    0.7.0.1
 */