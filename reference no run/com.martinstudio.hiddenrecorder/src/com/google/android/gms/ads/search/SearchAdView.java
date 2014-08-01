package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.av;

public final class SearchAdView
  extends ViewGroup
{
  private final av kv;
  
  public SearchAdView(Context paramContext)
  {
    super(paramContext);
    this.kv = new av(this);
  }
  
  public SearchAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.kv = new av(this, paramAttributeSet, false);
  }
  
  public SearchAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  public void loadAd(SearchAdRequest paramSearchAdRequest)
  {
    this.kv.a(paramSearchAdRequest.O());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int m = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      int k = (paramInt3 - paramInt1 - m) / 2;
      int i = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(k, i, m + k, j + i);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    View localView = getChildAt(0);
    AdSize localAdSize = getAdSize();
    int m;
    if ((localView == null) || (localView.getVisibility() == 8))
    {
      if (localAdSize == null)
      {
        m = 0;
      }
      else
      {
        Context localContext = getContext();
        m = localAdSize.getWidthInPixels(localContext);
        k = localAdSize.getHeightInPixels(localContext);
      }
    }
    else
    {
      measureChild(localView, paramInt1, paramInt2);
      m = localView.getMeasuredWidth();
      k = localView.getMeasuredHeight();
    }
    int i = Math.max(m, getSuggestedMinimumWidth());
    int k = Math.max(k, getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSize(i, paramInt1), View.resolveSize(k, paramInt2));
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
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.search.SearchAdView
 * JD-Core Version:    0.7.0.1
 */