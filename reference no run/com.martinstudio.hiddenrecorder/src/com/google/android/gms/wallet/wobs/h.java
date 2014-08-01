package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<g>
{
  static void a(g paramg, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramg.getVersionCode());
    b.c(paramParcel, 2, paramg.akQ);
    b.a(paramParcel, 3, paramg.akR, false);
    b.a(paramParcel, 4, paramg.akS);
    b.a(paramParcel, 5, paramg.akT, false);
    b.a(paramParcel, 6, paramg.akU);
    b.c(paramParcel, 7, paramg.akV);
    b.G(paramParcel, i);
  }
  
  public g cm(Parcel paramParcel)
  {
    String str1 = null;
    int k = 0;
    int n = a.B(paramParcel);
    double d = 0.0D;
    long l = 0L;
    int i = -1;
    String str2 = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= n)
      {
        if (paramParcel.dataPosition() == n) {
          return new g(m, k, str2, d, str1, l, i);
        }
        throw new a.a("Overread allowed size end=" + n, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        m = a.g(paramParcel, j);
        break;
      case 2: 
        k = a.g(paramParcel, j);
        break;
      case 3: 
        str2 = a.o(paramParcel, j);
        break;
      case 4: 
        d = a.m(paramParcel, j);
        break;
      case 5: 
        str1 = a.o(paramParcel, j);
        break;
      case 6: 
        l = a.i(paramParcel, j);
        break;
      case 7: 
        i = a.g(paramParcel, j);
      }
    }
  }
  
  public g[] dU(int paramInt)
  {
    return new g[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.h
 * JD-Core Version:    0.7.0.1
 */