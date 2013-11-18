package com.google.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class AdSize
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
  private final int a;
  private final int b;
  private boolean c;
  private boolean d;
  private boolean e;
  private String f;
  
  static
  {
    BANNER = new AdSize(320, 50, "mb");
    IAB_MRECT = new AdSize(300, 250, "as");
  }
  
  public AdSize(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, null);
    if (!a())
    {
      this.e = true;
    }
    else
    {
      this.e = false;
      this.f = "mb";
    }
  }
  
  private AdSize(int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.f = paramString;
    boolean bool2;
    if (paramInt1 != -1) {
      bool2 = false;
    } else {
      bool2 = bool1;
    }
    this.c = bool2;
    if (paramInt2 != -2) {
      bool1 = false;
    }
    this.d = bool1;
    this.e = false;
  }
  
  private static int a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels / localDisplayMetrics.density);
  }
  
  private boolean a()
  {
    boolean bool;
    if ((this.a >= 0) && (this.b >= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static int b(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    int i = (int)(localDisplayMetrics.heightPixels / localDisplayMetrics.density);
    if (i > 400)
    {
      if (i > 720) {
        i = 90;
      } else {
        i = 50;
      }
    }
    else {
      i = 32;
    }
    return i;
  }
  
  public static AdSize createAdSize(AdSize paramAdSize, Context paramContext)
  {
    if ((paramContext != null) && (paramAdSize.a()))
    {
      int i;
      if (!paramAdSize.c) {
        i = paramAdSize.getWidth();
      } else {
        i = a(paramContext);
      }
      int j;
      if (!paramAdSize.d) {
        j = paramAdSize.getHeight();
      } else {
        j = b(paramContext);
      }
      AdSize localAdSize = new AdSize(i, j, paramAdSize.f);
      localAdSize.d = paramAdSize.d;
      localAdSize.c = paramAdSize.c;
      localAdSize.e = paramAdSize.e;
      paramAdSize = localAdSize;
    }
    else if (paramAdSize.a())
    {
      paramAdSize = BANNER;
    }
    return paramAdSize;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof AdSize))
    {
      AdSize localAdSize = (AdSize)paramObject;
      if ((this.a == localAdSize.a) && (this.b == localAdSize.b)) {
        bool = true;
      }
    }
    return bool;
  }
  
  public AdSize findBestSize(AdSize... paramVarArgs)
  {
    Object localObject2 = null;
    double d2 = 0.0D;
    int j;
    int i;
    if (paramVarArgs != null)
    {
      j = paramVarArgs.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        return localObject2;
      }
      AdSize localAdSize = paramVarArgs[i];
      double d1;
      if (isSizeAppropriate(localAdSize.a, localAdSize.b))
      {
        d1 = localAdSize.a * localAdSize.b / (this.a * this.b);
        if (d1 > 1.0D) {
          d1 = 1.0D / d1;
        }
        if (d1 > d2) {}
      }
      else
      {
        d1 = d2;
        localObject1 = localObject2;
        break label113;
      }
      Object localObject1 = localAdSize;
      label113:
      i++;
      localObject2 = localObject1;
      double d3 = d1;
    }
  }
  
  public int getHeight()
  {
    if (this.b >= 0) {
      return this.b;
    }
    throw new UnsupportedOperationException("Ad size was not set before getHeight() was called.");
  }
  
  public int getHeightInPixels(Context paramContext)
  {
    return (int)TypedValue.applyDimension(1, this.b, paramContext.getResources().getDisplayMetrics());
  }
  
  public int getWidth()
  {
    if (this.a >= 0) {
      return this.a;
    }
    throw new UnsupportedOperationException("Ad size was not set before getWidth() was called.");
  }
  
  public int getWidthInPixels(Context paramContext)
  {
    return (int)TypedValue.applyDimension(1, this.a, paramContext.getResources().getDisplayMetrics());
  }
  
  public int hashCode()
  {
    return Integer.valueOf(this.a).hashCode() << 16 | 0xFFFF & Integer.valueOf(this.b).hashCode();
  }
  
  public boolean isAutoHeight()
  {
    return this.d;
  }
  
  public boolean isCustomAdSize()
  {
    return this.e;
  }
  
  public boolean isFullWidth()
  {
    return this.c;
  }
  
  public boolean isSizeAppropriate(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 > 1.25D * this.a) || (paramInt1 < 0.8D * this.a) || (paramInt2 > 1.25D * this.b) || (paramInt2 < 0.8D * this.b)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(getWidth()).append("x").append(getHeight());
    String str;
    if (this.f != null) {
      str = "_" + this.f;
    } else {
      str = "";
    }
    return str;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.AdSize
 * JD-Core Version:    0.7.0.1
 */