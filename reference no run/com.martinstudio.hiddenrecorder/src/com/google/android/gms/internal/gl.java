package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class gl
  implements Parcelable.Creator<gk>
{
  static void a(gk paramgk, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramgk.getVersionCode());
    b.a(paramParcel, 2, paramgk.ec());
    b.a(paramParcel, 3, paramgk.ei());
    b.c(paramParcel, 4, paramgk.ej());
    b.G(paramParcel, i);
  }
  
  public gk[] Y(int paramInt)
  {
    return new gk[paramInt];
  }
  
  public gk v(Parcel paramParcel)
  {
    int m = 0;
    int i = a.B(paramParcel);
    double d = 0.0D;
    boolean bool = false;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new gk(j, d, bool, m);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        d = a.m(paramParcel, k);
        break;
      case 3: 
        bool = a.c(paramParcel, k);
        break;
      case 4: 
        m = a.g(paramParcel, k);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gl
 * JD-Core Version:    0.7.0.1
 */