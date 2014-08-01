package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class o
  implements Parcelable.Creator<ProxyCard>
{
  static void a(ProxyCard paramProxyCard, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramProxyCard.getVersionCode());
    b.a(paramParcel, 2, paramProxyCard.ajS, false);
    b.a(paramParcel, 3, paramProxyCard.ajT, false);
    b.c(paramParcel, 4, paramProxyCard.ajU);
    b.c(paramParcel, 5, paramProxyCard.ajV);
    b.G(paramParcel, i);
  }
  
  public ProxyCard cd(Parcel paramParcel)
  {
    String str1 = null;
    int m = 0;
    int n = a.B(paramParcel);
    int k = 0;
    String str2 = null;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= n)
      {
        if (paramParcel.dataPosition() == n) {
          return new ProxyCard(i, str2, str1, k, m);
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
        i = a.g(paramParcel, j);
        break;
      case 2: 
        str2 = a.o(paramParcel, j);
        break;
      case 3: 
        str1 = a.o(paramParcel, j);
        break;
      case 4: 
        k = a.g(paramParcel, j);
        break;
      case 5: 
        m = a.g(paramParcel, j);
      }
    }
  }
  
  public ProxyCard[] dJ(int paramInt)
  {
    return new ProxyCard[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.o
 * JD-Core Version:    0.7.0.1
 */