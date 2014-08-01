package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q
  implements Parcelable.Creator<p>
{
  static void a(p paramp, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramp.versionCode);
    b.c(paramParcel, 2, paramp.statusCode);
    b.c(paramParcel, 3, paramp.alI);
    b.G(paramParcel, i);
  }
  
  public p cy(Parcel paramParcel)
  {
    int n = 0;
    int m = a.B(paramParcel);
    int j = 0;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new p(k, j, n);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        k = a.g(paramParcel, i);
        break;
      case 2: 
        j = a.g(paramParcel, i);
        break;
      case 3: 
        n = a.g(paramParcel, i);
      }
    }
  }
  
  public p[] eh(int paramInt)
  {
    return new p[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.q
 * JD-Core Version:    0.7.0.1
 */