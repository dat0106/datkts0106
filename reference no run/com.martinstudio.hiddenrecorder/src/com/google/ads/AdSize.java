package com.google.ads;

import android.content.Context;

@Deprecated
public final class AdSize
{
  public static final int AUTO_HEIGHT = -2;
  public static final AdSize BANNER;
  public static final int FULL_WIDTH = -1;
  public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
  public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
  public static final AdSize IAB_MRECT;
  public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
  public static final int LANDSCAPE_AD_HEIGHT = 32;
  public static final int LARGE_AD_HEIGHT = 90;
  public static final int PORTRAIT_AD_HEIGHT = 50;
  public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
  private final com.google.android.gms.ads.AdSize c;
  
  static
  {
    BANNER = new AdSize(320, 50, "mb");
    IAB_MRECT = new AdSize(300, 250, "as");
  }
  
  public AdSize(int paramInt1, int paramInt2)
  {
    this(new com.google.android.gms.ads.AdSize(paramInt1, paramInt2));
  }
  
  private AdSize(int paramInt1, int paramInt2, String paramString)
  {
    this(new com.google.android.gms.ads.AdSize(paramInt1, paramInt2));
  }
  
  public AdSize(com.google.android.gms.ads.AdSize paramAdSize)
  {
    this.c = paramAdSize;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject instanceof AdSize))
    {
      AdSize localAdSize = (AdSize)paramObject;
      bool = this.c.equals(localAdSize.c);
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public AdSize findBestSize(AdSize... paramVarArgs)
  {
    Object localObject2 = null;
    float f1;
    int k;
    int j;
    int i;
    int m;
    if (paramVarArgs != null)
    {
      f1 = 0.0F;
      k = getWidth();
      j = getHeight();
      i = paramVarArgs.length;
      m = 0;
    }
    for (;;)
    {
      if (m >= i) {
        return localObject2;
      }
      AdSize localAdSize = paramVarArgs[m];
      int i1 = localAdSize.getWidth();
      int n = localAdSize.getHeight();
      float f3;
      if (isSizeAppropriate(i1, n))
      {
        f3 = i1 * n / (k * j);
        if (f3 > 1.0F) {
          f3 = 1.0F / f3;
        }
        if (f3 > f1) {}
      }
      else
      {
        f3 = f1;
        localObject1 = localObject2;
        break label120;
      }
      Object localObject1 = localAdSize;
      label120:
      m++;
      localObject2 = localObject1;
      float f2 = f3;
    }
  }
  
  public int getHeight()
  {
    return this.c.getHeight();
  }
  
  public int getHeightInPixels(Context paramContext)
  {
    return this.c.getHeightInPixels(paramContext);
  }
  
  public int getWidth()
  {
    return this.c.getWidth();
  }
  
  public int getWidthInPixels(Context paramContext)
  {
    return this.c.getWidthInPixels(paramContext);
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public boolean isAutoHeight()
  {
    return this.c.isAutoHeight();
  }
  
  public boolean isCustomAdSize()
  {
    return false;
  }
  
  public boolean isFullWidth()
  {
    return this.c.isFullWidth();
  }
  
  public boolean isSizeAppropriate(int paramInt1, int paramInt2)
  {
    int j = getWidth();
    int i = getHeight();
    if ((paramInt1 > 1.25F * j) || (paramInt1 < 0.8F * j) || (paramInt2 > 1.25F * i) || (paramInt2 < 0.8F * i)) {
      i = 0;
    } else {
      i = 1;
    }
    return i;
  }
  
  public String toString()
  {
    return this.c.toString();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.AdSize
 * JD-Core Version:    0.7.0.1
 */