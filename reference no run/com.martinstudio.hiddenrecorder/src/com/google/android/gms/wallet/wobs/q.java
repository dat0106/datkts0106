package com.google.android.gms.wallet.wobs;

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
    b.c(paramParcel, 1, paramp.getVersionCode());
    b.a(paramParcel, 2, paramp.akW, false);
    b.a(paramParcel, 3, paramp.qb, false);
    b.a(paramParcel, 4, paramp.ala, paramInt, false);
    b.a(paramParcel, 5, paramp.alb, paramInt, false);
    b.a(paramParcel, 6, paramp.alc, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public p cr(Parcel paramParcel)
  {
    n localn2 = null;
    int i = a.B(paramParcel);
    int k = 0;
    n localn1 = null;
    l locall = null;
    String str1 = null;
    String str2 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new p(k, str2, str1, locall, localn1, localn2);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        k = a.g(paramParcel, j);
        break;
      case 2: 
        str2 = a.o(paramParcel, j);
        break;
      case 3: 
        str1 = a.o(paramParcel, j);
        break;
      case 4: 
        locall = (l)a.a(paramParcel, j, l.CREATOR);
        break;
      case 5: 
        localn1 = (n)a.a(paramParcel, j, n.CREATOR);
        break;
      case 6: 
        localn2 = (n)a.a(paramParcel, j, n.CREATOR);
      }
    }
  }
  
  public p[] dZ(int paramInt)
  {
    return new p[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.q
 * JD-Core Version:    0.7.0.1
 */