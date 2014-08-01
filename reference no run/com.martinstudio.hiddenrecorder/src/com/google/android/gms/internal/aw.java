package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class aw
{
  private AdListener lO;
  private PlayStorePurchaseListener mA;
  private final Context mContext;
  private AppEventListener mf;
  private String mh;
  private final bt mu = new bt();
  private final al mv;
  private ar mw;
  private String mx;
  private InAppPurchaseListener mz;
  
  public aw(Context paramContext)
  {
    this(paramContext, al.aA());
  }
  
  public aw(Context paramContext, al paramal)
  {
    this.mContext = paramContext;
    this.mv = paramal;
  }
  
  private void k(String paramString)
    throws RemoteException
  {
    if (this.mh == null) {
      l(paramString);
    }
    this.mw = ai.a(this.mContext, new am(), this.mh, this.mu);
    if (this.lO != null) {
      this.mw.a(new ah(this.lO));
    }
    if (this.mf != null) {
      this.mw.a(new ao(this.mf));
    }
    if (this.mz != null) {
      this.mw.a(new di(this.mz));
    }
    if (this.mA != null) {
      this.mw.a(new dm(this.mA), this.mx);
    }
  }
  
  private void l(String paramString)
  {
    if (this.mw != null) {
      return;
    }
    throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
  }
  
  public void a(au paramau)
  {
    try
    {
      if (this.mw == null) {
        k("loadAd");
      }
      if (this.mw.a(this.mv.a(this.mContext, paramau))) {
        this.mu.c(paramau.aD());
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Failed to load ad.", localRemoteException);
      }
    }
  }
  
  public AdListener getAdListener()
  {
    return this.lO;
  }
  
  public String getAdUnitId()
  {
    return this.mh;
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.mf;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.mz;
  }
  
  public boolean isLoaded()
  {
    boolean bool = false;
    try
    {
      if (this.mw != null)
      {
        bool = this.mw.isReady();
        bool = bool;
      }
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Failed to check if ad is ready.", localRemoteException);
    }
    return bool;
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      this.lO = paramAdListener;
      ar localar;
      if (this.mw != null)
      {
        localar = this.mw;
        if (paramAdListener == null) {
          break label38;
        }
      }
      label38:
      for (ah localah = new ah(paramAdListener);; localah = null)
      {
        localar.a(localah);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Failed to set the AdListener.", localRemoteException);
      }
    }
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.mh == null)
    {
      this.mh = paramString;
      return;
    }
    throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      this.mf = paramAppEventListener;
      ar localar;
      if (this.mw != null)
      {
        localar = this.mw;
        if (paramAppEventListener == null) {
          break label38;
        }
      }
      label38:
      for (ao localao = new ao(paramAppEventListener);; localao = null)
      {
        localar.a(localao);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Failed to set the AppEventListener.", localRemoteException);
      }
    }
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    if (this.mA != null) {
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    }
    try
    {
      this.mz = paramInAppPurchaseListener;
      ar localar;
      if (this.mw != null)
      {
        localar = this.mw;
        if (paramInAppPurchaseListener == null) {
          break label55;
        }
      }
      label55:
      for (di localdi = new di(paramInAppPurchaseListener);; localdi = null)
      {
        localar.a(localdi);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Failed to set the InAppPurchaseListener.", localRemoteException);
      }
    }
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    try
    {
      this.mA = paramPlayStorePurchaseListener;
      ar localar;
      if (this.mw != null)
      {
        localar = this.mw;
        if (paramPlayStorePurchaseListener == null) {
          break label41;
        }
      }
      label41:
      for (dm localdm = new dm(paramPlayStorePurchaseListener);; localdm = null)
      {
        localar.a(localdm, paramString);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Failed to set the play store purchase parameter.", localRemoteException);
      }
    }
  }
  
  public void show()
  {
    try
    {
      l("show");
      this.mw.showInterstitial();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Failed to show interstitial.", localRemoteException);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.aw
 * JD-Core Version:    0.7.0.1
 */