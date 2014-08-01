package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gg
  implements Parcelable.Creator<gf>
{
  static void a(gf paramgf, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramgf.getVersionCode());
    b.a(paramParcel, 2, paramgf.dX(), false);
    b.G(paramParcel, i);
  }
  
  public gf[] S(int paramInt)
  {
    return new gf[paramInt];
  }
  
  public gf u(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    String str = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new gf(i, str);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str = a.o(paramParcel, k);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gg
 * JD-Core Version:    0.7.0.1
 */