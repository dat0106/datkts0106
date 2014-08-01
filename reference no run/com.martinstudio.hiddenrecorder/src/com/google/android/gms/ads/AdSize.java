package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.eu;

public final class AdSize
{
  public static final int AUTO_HEIGHT = -2;
  public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
  public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
  public static final int FULL_WIDTH = -1;
  public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
  public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
  public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
  public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
  public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
  private final int ks;
  private final int kt;
  private final String ku;
  
  public AdSize(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, (String)localObject1 + "_as");
  }
  
  AdSize(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 >= 0) || (paramInt1 == -1))
    {
      if ((paramInt2 >= 0) || (paramInt2 == -2))
      {
        this.ks = paramInt1;
        this.kt = paramInt2;
        this.ku = paramString;
        return;
      }
      throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
    }
    throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject != this) {
      if ((paramObject instanceof AdSize))
      {
        AdSize localAdSize = (AdSize)paramObject;
        if ((this.ks != localAdSize.ks) || (this.kt != localAdSize.kt) || (!this.ku.equals(localAdSize.ku))) {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
    return bool;
  }
  
  public int getHeight()
  {
    return this.kt;
  }
  
  public int getHeightInPixels(Context paramContext)
  {
    int i;
    if (this.kt != -2) {
      i = eu.a(paramContext, this.kt);
    } else {
      i = am.b(paramContext.getResources().getDisplayMetrics());
    }
    return i;
  }
  
  public int getWidth()
  {
    return this.ks;
  }
  
  public int getWidthInPixels(Context paramContext)
  {
    int i;
    if (this.ks != -1) {
      i = eu.a(paramContext, this.ks);
    } else {
      i = am.a(paramContext.getResources().getDisplayMetrics());
    }
    return i;
  }
  
  public int hashCode()
  {
    return this.ku.hashCode();
  }
  
  public boolean isAutoHeight()
  {
    boolean bool;
    if (this.kt != -2) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isFullWidth()
  {
    boolean bool;
    if (this.ks != -1) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    return this.ku;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.AdSize
 * JD-Core Version:    0.7.0.1
 */