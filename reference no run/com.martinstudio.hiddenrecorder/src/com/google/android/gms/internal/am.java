package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class am
  implements SafeParcelable
{
  public static final an CREATOR = new an();
  public final int height;
  public final int heightPixels;
  public final String mc;
  public final boolean md;
  public final am[] me;
  public final int versionCode;
  public final int width;
  public final int widthPixels;
  
  public am()
  {
    this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
  }
  
  am(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, am[] paramArrayOfam)
  {
    this.versionCode = paramInt1;
    this.mc = paramString;
    this.height = paramInt2;
    this.heightPixels = paramInt3;
    this.md = paramBoolean;
    this.width = paramInt4;
    this.widthPixels = paramInt5;
    this.me = paramArrayOfam;
  }
  
  public am(Context paramContext, AdSize paramAdSize)
  {
    this(paramContext, arrayOfAdSize);
  }
  
  public am(Context paramContext, AdSize[] paramArrayOfAdSize)
  {
    AdSize localAdSize = paramArrayOfAdSize[0];
    this.versionCode = 2;
    this.md = false;
    this.width = localAdSize.getWidth();
    this.height = localAdSize.getHeight();
    int j;
    if (this.width != -1) {
      j = 0;
    } else {
      j = 1;
    }
    int i;
    if (this.height != -2) {
      i = 0;
    } else {
      i = 1;
    }
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    int m;
    int n;
    if (j == 0)
    {
      m = this.width;
      this.widthPixels = eu.a(localDisplayMetrics, this.width);
      n = m;
    }
    else
    {
      this.widthPixels = a(localDisplayMetrics);
      n = (int)(this.widthPixels / localDisplayMetrics.density);
    }
    if (i == 0) {
      m = this.height;
    } else {
      m = c(localDisplayMetrics);
    }
    this.heightPixels = eu.a(localDisplayMetrics, m);
    if ((j == 0) && (i == 0)) {
      this.mc = localAdSize.toString();
    } else {
      this.mc = (n + "x" + m + "_as");
    }
    if (paramArrayOfAdSize.length <= 1) {
      this.me = null;
    } else {
      this.me = new am[paramArrayOfAdSize.length];
    }
    for (;;)
    {
      if (k >= paramArrayOfAdSize.length) {
        return;
      }
      this.me[k] = new am(paramContext, paramArrayOfAdSize[k]);
      k++;
    }
  }
  
  public am(am paramam, am[] paramArrayOfam)
  {
    this(2, paramam.mc, paramam.height, paramam.heightPixels, paramam.md, paramam.width, paramam.widthPixels, paramArrayOfam);
  }
  
  public static int a(DisplayMetrics paramDisplayMetrics)
  {
    return paramDisplayMetrics.widthPixels;
  }
  
  public static int b(DisplayMetrics paramDisplayMetrics)
  {
    return (int)(c(paramDisplayMetrics) * paramDisplayMetrics.density);
  }
  
  private static int c(DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(paramDisplayMetrics.heightPixels / paramDisplayMetrics.density);
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
  
  public AdSize aB()
  {
    return a.a(this.width, this.height, this.mc);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    an.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.am
 * JD-Core Version:    0.7.0.1
 */