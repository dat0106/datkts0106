package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<WalletFragmentStyle>
{
  static void a(WalletFragmentStyle paramWalletFragmentStyle, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramWalletFragmentStyle.xJ);
    b.a(paramParcel, 2, paramWalletFragmentStyle.akB, false);
    b.c(paramParcel, 3, paramWalletFragmentStyle.akC);
    b.G(paramParcel, i);
  }
  
  public WalletFragmentStyle ci(Parcel paramParcel)
  {
    int k = 0;
    int i = a.B(paramParcel);
    Bundle localBundle = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new WalletFragmentStyle(m, localBundle, k);
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
        m = a.g(paramParcel, j);
        break;
      case 2: 
        localBundle = a.q(paramParcel, j);
        break;
      case 3: 
        k = a.g(paramParcel, j);
      }
    }
  }
  
  public WalletFragmentStyle[] dP(int paramInt)
  {
    return new WalletFragmentStyle[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.c
 * JD-Core Version:    0.7.0.1
 */