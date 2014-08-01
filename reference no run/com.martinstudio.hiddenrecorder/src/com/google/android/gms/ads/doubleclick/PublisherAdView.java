package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.av;

public final class PublisherAdView
  extends ViewGroup
{
  private final av kv;
  
  public PublisherAdView(Context paramContext)
  {
    super(paramContext);
    this.kv = new av(this);
  }
  
  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.kv = new av(this, paramAttributeSet, true);
  }
  
  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.kv = new av(this, paramAttributeSet, true);
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
  
  public AdSize[] getAdSizes()
  {
    return this.kv.getAdSizes();
  }
  
  public String getAdUnitId()
  {
    return this.kv.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.kv.getAppEventListener();
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.kv.a(paramPublisherAdRequest.O());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int m = localView.getMeasuredWidth();
      int i = localView.getMeasuredHeight();
      int k = (paramInt3 - paramInt1 - m) / 2;
      int j = (paramInt4 - paramInt2 - i) / 2;
      localView.layout(k, j, m + k, i + j);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    View localView = getChildAt(0);
    AdSize localAdSize = getAdSize();
    if ((localView == null) || (localView.getVisibility() == 8))
    {
      if (localAdSize == null)
      {
        k = 0;
      }
      else
      {
        Context localContext = getContext();
        k = localAdSize.getWidthInPixels(localContext);
        j = localAdSize.getHeightInPixels(localContext);
      }
    }
    else
    {
      measureChild(localView, paramInt1, paramInt2);
      k = localView.getMeasuredWidth();
      j = localView.getMeasuredHeight();
    }
    int k = Math.max(k, getSuggestedMinimumWidth());
    int j = Math.max(j, getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSize(k, paramInt1), View.resolveSize(j, paramInt2));
  }
  
  public void pause()
  {
    this.kv.pause();
  }
  
  public void recordManualImpression()
  {
    this.kv.recordManualImpression();
  }
  
  public void resume()
  {
    this.kv.resume();
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.kv.setAdListener(paramAdListener);
  }
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      this.kv.a(paramVarArgs);
      return;
    }
    throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
  }
  
  public void setAdUnitId(String paramString)
  {
    this.kv.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.kv.setAppEventListener(paramAppEventListener);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.doubleclick.PublisherAdView
 * JD-Core Version:    0.7.0.1
 */