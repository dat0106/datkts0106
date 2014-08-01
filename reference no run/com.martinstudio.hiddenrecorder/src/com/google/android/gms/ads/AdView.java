package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.av;

public final class AdView
  extends ViewGroup
{
  private final av kv;
  
  public AdView(Context paramContext)
  {
    super(paramContext);
    this.kv = new av(this);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.kv = new av(this, paramAttributeSet, false);
  }
  
  public AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.kv = new av(this, paramAttributeSet, false);
  }
  
  public void destroy()
  {
    this.kv.destroy();
  }
  
  public AdListener getAdListener()
  {
    return this.kv.getAdListener();
  }
  
  public AdSize getAdSize()
  {
    return this.kv.getAdSize();
  }
  
  public String getAdUnitId()
  {
    return this.kv.getAdUnitId();
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.kv.getInAppPurchaseListener();
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    this.kv.a(paramAdRequest.O());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int k = localView.getMeasuredWidth();
      int m = localView.getMeasuredHeight();
      int i = (paramInt3 - paramInt1 - k) / 2;
      int j = (paramInt4 - paramInt2 - m) / 2;
      localView.layout(i, j, k + i, m + j);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 0;
    View localView = getChildAt(0);
    AdSize localAdSize = getAdSize();
    int m;
    if ((localView == null) || (localView.getVisibility() == 8))
    {
      if (localAdSize == null)
      {
        j = 0;
      }
      else
      {
        Context localContext = getContext();
        j = localAdSize.getWidthInPixels(localContext);
        m = localAdSize.getHeightInPixels(localContext);
      }
    }
    else
    {
      measureChild(localView, paramInt1, paramInt2);
      j = localView.getMeasuredWidth();
      m = localView.getMeasuredHeight();
    }
    int i = Math.max(j, getSuggestedMinimumWidth());
    int j = Math.max(m, getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSize(i, paramInt1), View.resolveSize(j, paramInt2));
  }
  
  public void pause()
  {
    this.kv.pause();
  }
  
  public void resume()
  {
    this.kv.resume();
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.kv.setAdListener(paramAdListener);
  }
  
  public void setAdSize(AdSize paramAdSize)
  {
    av localav = this.kv;
    AdSize[] arrayOfAdSize = new AdSize[1];
    arrayOfAdSize[0] = paramAdSize;
    localav.setAdSizes(arrayOfAdSize);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.kv.setAdUnitId(paramString);
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    this.kv.setInAppPurchaseListener(paramInAppPurchaseListener);
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    this.kv.setPlayStorePurchaseParams(paramPlayStorePurchaseListener, paramString);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.AdView
 * JD-Core Version:    0.7.0.1
 */