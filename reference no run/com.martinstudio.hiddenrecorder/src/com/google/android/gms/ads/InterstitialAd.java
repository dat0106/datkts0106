package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.aw;

public final class InterstitialAd
{
  private final aw kw;
  
  public InterstitialAd(Context paramContext)
  {
    this.kw = new aw(paramContext);
  }
  
  public AdListener getAdListener()
  {
    return this.kw.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return this.kw.getAdUnitId();
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.kw.getInAppPurchaseListener();
  }
  
  public boolean isLoaded()
  {
    return this.kw.isLoaded();
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    this.kw.a(paramAdRequest.O());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.kw.setAdListener(paramAdListener);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.kw.setAdUnitId(paramString);
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    this.kw.setInAppPurchaseListener(paramInAppPurchaseListener);
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    this.kw.setPlayStorePurchaseParams(paramPlayStorePurchaseListener, paramString);
  }
  
  public void show()
  {
    this.kw.show();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.InterstitialAd
 * JD-Core Version:    0.7.0.1
 */