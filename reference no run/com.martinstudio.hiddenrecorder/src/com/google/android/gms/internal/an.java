package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class an
  implements Parcelable.Creator<am>
{
  static void a(am paramam, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramam.versionCode);
    b.a(paramParcel, 2, paramam.mc, false);
    b.c(paramParcel, 3, paramam.height);
    b.c(paramParcel, 4, paramam.heightPixels);
    b.a(paramParcel, 5, paramam.md);
    b.c(paramParcel, 6, paramam.width);
    b.c(paramParcel, 7, paramam.widthPixels);
    b.a(paramParcel, 8, paramam.me, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public am c(Parcel paramParcel)
  {
    am[] arrayOfam = null;
    int k = 0;
    int i = a.B(paramParcel);
    int n = 0;
    boolean bool = false;
    int i2 = 0;
    int j = 0;
    String str = null;
    int i1 = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new am(i1, str, j, i2, bool, n, k, arrayOfam);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        i1 = a.g(paramParcel, m);
        break;
      case 2: 
        str = a.o(paramParcel, m);
        break;
      case 3: 
        j = a.g(paramParcel, m);
        break;
      case 4: 
        i2 = a.g(paramParcel, m);
        break;
      case 5: 
        bool = a.c(paramParcel, m);
        break;
      case 6: 
        n = a.g(paramParcel, m);
        break;
      case 7: 
        k = a.g(paramParcel, m);
        break;
      case 8: 
        arrayOfam = (am[])a.b(paramParcel, m, am.CREATOR);
      }
    }
  }
  
  public am[] d(int paramInt)
  {
    return new am[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.an
 * JD-Core Version:    0.7.0.1
 */