package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jm
  implements Parcelable.Creator<jl>
{
  static void a(jl paramjl, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramjl.iX());
    b.c(paramParcel, 1000, paramjl.getVersionCode());
    b.c(paramParcel, 2, paramjl.iZ());
    b.a(paramParcel, 3, paramjl.ja(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public jl bu(Parcel paramParcel)
  {
    int j = 0;
    int m = a.B(paramParcel);
    int i = -1;
    jn localjn = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new jl(k, j, i, localjn);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        j = a.g(paramParcel, n);
        break;
      case 2: 
        i = a.g(paramParcel, n);
        break;
      case 3: 
        localjn = (jn)a.a(paramParcel, n, jn.CREATOR);
        break;
      case 1000: 
        k = a.g(paramParcel, n);
      }
    }
  }
  
  public jl[] cP(int paramInt)
  {
    return new jl[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jm
 * JD-Core Version:    0.7.0.1
 */