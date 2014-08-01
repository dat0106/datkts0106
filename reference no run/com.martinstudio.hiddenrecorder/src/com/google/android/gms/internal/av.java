package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;

public final class av
{
  private AdListener lO;
  private PlayStorePurchaseListener mA;
  private AppEventListener mf;
  private AdSize[] mg;
  private String mh;
  private final bt mu = new bt();
  private final al mv;
  private ar mw;
  private String mx;
  private ViewGroup my;
  private InAppPurchaseListener mz;
  
  public av(ViewGroup paramViewGroup)
  {
    this(paramViewGroup, null, false, al.aA());
  }
  
  public av(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramViewGroup, paramAttributeSet, paramBoolean, al.aA());
  }
  
  av(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean, al paramal)
  {
    this.my = paramViewGroup;
    this.mv = paramal;
    Context localContext;
    if (paramAttributeSet != null) {
      localContext = paramViewGroup.getContext();
    }
    try
    {
      ap localap = new ap(localContext, paramAttributeSet);
      this.mg = localap.f(paramBoolean);
      this.mh = localap.getAdUnitId();
      if (paramViewGroup.isInEditMode()) {
        eu.a(paramViewGroup, new am(localContext, this.mg[0]), "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        eu.a(paramViewGroup, new am(localContext, AdSize.BANNER), localIllegalArgumentException.getMessage(), localIllegalArgumentException.getMessage());
      }
    }
  }
  
  private void aG()
  {
    try
    {
      d locald = this.mw.P();
      if (locald != null) {
        this.my.addView((View)e.e(locald));
      }
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Failed to get an ad frame.", localRemoteException);
    }
  }
  
  private void aH()
    throws RemoteException
  {
    if (((this.mg != null) && (this.mh != null)) || (this.mw != null))
    {
      Context localContext = this.my.getContext();
      this.mw = ai.a(localContext, new am(localContext, this.mg), this.mh, this.mu);
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
      aG();
      return;
    }
    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
  }
  
  public void a(au paramau)
  {
    try
    {
      if (this.mw == null) {
        aH();
      }
      if (this.mw.a(this.mv.a(this.my.getContext(), paramau))) {
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
  
  public void a(AdSize... paramVarArgs)
  {
    this.mg = paramVarArgs;
    try
    {
      if (this.mw != null) {
        this.mw.a(new am(this.my.getContext(), this.mg));
      }
      this.my.requestLayout();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Failed to set the ad size.", localRemoteException);
      }
    }
  }
  
  public void destroy()
  {
    try
    {
      if (this.mw != null) {
        this.mw.destroy();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Failed to destroy AdView.", localRemoteException);
      }
    }
  }
  
  public AdListener getAdListener()
  {
    return this.lO;
  }
  
  public AdSize getAdSize()
  {
    try
    {
      if (this.mw == null) {
        break label31;
      }
      localAdSize1 = this.mw.Q().aB();
      localAdSize1 = localAdSize1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        AdSize localAdSize1;
        ev.c("Failed to get the current AdSize.", localRemoteException);
        label31:
        AdSize localAdSize2;
        if (this.mg != null) {
          localAdSize2 = this.mg[0];
        } else {
          localAdSize2 = null;
        }
      }
    }
    return localAdSize1;
  }
  
  public AdSize[] getAdSizes()
  {
    return this.mg;
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
  
  public void pause()
  {
    try
    {
      if (this.mw != null) {
        this.mw.pause();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Failed to call pause.", localRemoteException);
      }
    }
  }
  
  public void recordManualImpression()
  {
    try
    {
      this.mw.ab();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Failed to record impression.", localRemoteException);
      }
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.mw != null) {
        this.mw.resume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Failed to call resume.", localRemoteException);
      }
    }
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
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if (this.mg == null)
    {
      a(paramVarArgs);
      return;
    }
    throw new IllegalStateException("The ad size can only be set once on AdView.");
  }
  
  public void setAdUnitId(String paramString)
  {
    if (this.mh == null)
    {
      this.mh = paramString;
      return;
    }
    throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
          break label56;
        }
      }
      label56:
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
    if (this.mz != null) {
      throw new IllegalStateException("InAppPurchaseListener has already been set.");
    }
    try
    {
      this.mA = paramPlayStorePurchaseListener;
      this.mx = paramString;
      ar localar;
      if (this.mw != null)
      {
        localar = this.mw;
        if (paramPlayStorePurchaseListener == null) {
          break label64;
        }
      }
      label64:
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
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.av
 * JD-Core Version:    0.7.0.1
 */