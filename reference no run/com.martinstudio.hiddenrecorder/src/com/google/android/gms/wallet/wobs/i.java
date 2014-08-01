package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i
  implements Parcelable.Creator<f>
{
  static void a(f paramf, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramf.getVersionCode());
    b.a(paramParcel, 2, paramf.label, false);
    b.a(paramParcel, 3, paramf.akP, paramInt, false);
    b.a(paramParcel, 4, paramf.type, false);
    b.a(paramParcel, 5, paramf.ajp, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public f cn(Parcel paramParcel)
  {
    l locall = null;
    int i = a.B(paramParcel);
    int k = 0;
    String str2 = null;
    g localg = null;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new f(k, str1, localg, str2, locall);
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
        str1 = a.o(paramParcel, j);
        break;
      case 3: 
        localg = (g)a.a(paramParcel, j, g.CREATOR);
        break;
      case 4: 
        str2 = a.o(paramParcel, j);
        break;
      case 5: 
        locall = (l)a.a(paramParcel, j, l.CREATOR);
      }
    }
  }
  
  public f[] dV(int paramInt)
  {
    return new f[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.i
 * JD-Core Version:    0.7.0.1
 */