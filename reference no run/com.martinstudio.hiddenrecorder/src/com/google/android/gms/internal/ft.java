package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ft
  implements Parcelable.Creator<fs>
{
  static void a(fs paramfs, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramfs.yn, paramInt, false);
    b.c(paramParcel, 1000, paramfs.xJ);
    b.a(paramParcel, 2, paramfs.yo);
    b.c(paramParcel, 3, paramfs.yp);
    b.a(paramParcel, 4, paramfs.mN, false);
    b.a(paramParcel, 5, paramfs.yq, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public fs[] K(int paramInt)
  {
    return new fs[paramInt];
  }
  
  public fs q(Parcel paramParcel)
  {
    int k = 0;
    fh localfh = null;
    int m = a.B(paramParcel);
    long l = 0L;
    String str = null;
    fj localfj = null;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new fs(i, localfj, l, k, str, localfh);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        localfj = (fj)a.a(paramParcel, j, fj.CREATOR);
        break;
      case 2: 
        l = a.i(paramParcel, j);
        break;
      case 3: 
        k = a.g(paramParcel, j);
        break;
      case 4: 
        str = a.o(paramParcel, j);
        break;
      case 5: 
        localfh = (fh)a.a(paramParcel, j, fh.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, j);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ft
 * JD-Core Version:    0.7.0.1
 */