package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

public final class cb<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  implements MediationBannerListener, MediationInterstitialListener
{
  private final bw nR;
  
  public cb(bw parambw)
  {
    this.nR = parambw;
  }
  
  public void onClick(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ev.z("Adapter called onClick.");
    if (!eu.bR())
    {
      ev.D("onClick must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdClicked();
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
      });
    }
    for (;;)
    {
      return;
      try
      {
        this.nR.onAdClicked();
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not call onAdClicked.", localRemoteException);
      }
    }
  }
  
  public void onDismissScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ev.z("Adapter called onDismissScreen.");
    if (!eu.bR())
    {
      ev.D("onDismissScreen must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdClosed();
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
      });
    }
    for (;;)
    {
      return;
      try
      {
        this.nR.onAdClosed();
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not call onAdClosed.", localRemoteException);
      }
    }
  }
  
  public void onDismissScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    ev.z("Adapter called onDismissScreen.");
    if (!eu.bR())
    {
      ev.D("onDismissScreen must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdClosed();
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
      });
    }
    for (;;)
    {
      return;
      try
      {
        this.nR.onAdClosed();
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not call onAdClosed.", localRemoteException);
      }
    }
  }
  
  public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    ev.z("Adapter called onFailedToReceiveAd with error. " + paramErrorCode);
    if (!eu.bR())
    {
      ev.D("onFailedToReceiveAd must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdFailedToLoad(cc.a(paramErrorCode));
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
      });
    }
    for (;;)
    {
      return;
      try
      {
        this.nR.onAdFailedToLoad(cc.a(paramErrorCode));
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not call onAdFailedToLoad.", localRemoteException);
      }
    }
  }
  
  public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, final AdRequest.ErrorCode paramErrorCode)
  {
    ev.z("Adapter called onFailedToReceiveAd with error " + paramErrorCode + ".");
    if (!eu.bR())
    {
      ev.D("onFailedToReceiveAd must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdFailedToLoad(cc.a(paramErrorCode));
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
      });
    }
    for (;;)
    {
      return;
      try
      {
        this.nR.onAdFailedToLoad(cc.a(paramErrorCode));
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not call onAdFailedToLoad.", localRemoteException);
      }
    }
  }
  
  public void onLeaveApplication(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ev.z("Adapter called onLeaveApplication.");
    if (!eu.bR())
    {
      ev.D("onLeaveApplication must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdLeftApplication();
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
      });
    }
    for (;;)
    {
      return;
      try
      {
        this.nR.onAdLeftApplication();
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not call onAdLeftApplication.", localRemoteException);
      }
    }
  }
  
  public void onLeaveApplication(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    ev.z("Adapter called onLeaveApplication.");
    if (!eu.bR())
    {
      ev.D("onLeaveApplication must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdLeftApplication();
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
      });
    }
    for (;;)
    {
      return;
      try
      {
        this.nR.onAdLeftApplication();
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not call onAdLeftApplication.", localRemoteException);
      }
    }
  }
  
  public void onPresentScreen(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ev.z("Adapter called onPresentScreen.");
    if (!eu.bR())
    {
      ev.D("onPresentScreen must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdOpened();
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
      });
    }
    for (;;)
    {
      return;
      try
      {
        this.nR.onAdOpened();
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not call onAdOpened.", localRemoteException);
      }
    }
  }
  
  public void onPresentScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    ev.z("Adapter called onPresentScreen.");
    if (!eu.bR())
    {
      ev.D("onPresentScreen must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdOpened();
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
      });
    }
    for (;;)
    {
      return;
      try
      {
        this.nR.onAdOpened();
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not call onAdOpened.", localRemoteException);
      }
    }
  }
  
  public void onReceivedAd(MediationBannerAdapter<?, ?> paramMediationBannerAdapter)
  {
    ev.z("Adapter called onReceivedAd.");
    if (!eu.bR())
    {
      ev.D("onReceivedAd must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdLoaded();
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
      });
    }
    for (;;)
    {
      return;
      try
      {
        this.nR.onAdLoaded();
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not call onAdLoaded.", localRemoteException);
      }
    }
  }
  
  public void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter)
  {
    ev.z("Adapter called onReceivedAd.");
    if (!eu.bR())
    {
      ev.D("onReceivedAd must be called on the main UI thread.");
      eu.ss.post(new Runnable()
      {
        public void run()
        {
          try
          {
            cb.a(cb.this).onAdLoaded();
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
      });
    }
    for (;;)
    {
      return;
      try
      {
        this.nR.onAdLoaded();
      }
      catch (RemoteException localRemoteException)
      {
        ev.c("Could not call onAdLoaded.", localRemoteException);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cb
 * JD-Core Version:    0.7.0.1
 */