package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<WalletFragmentOptions>
{
  static void a(WalletFragmentOptions paramWalletFragmentOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramWalletFragmentOptions.xJ);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 2, paramWalletFragmentOptions.getEnvironment());
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 3, paramWalletFragmentOptions.getTheme());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 4, paramWalletFragmentOptions.getFragmentStyle(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 5, paramWalletFragmentOptions.getMode());
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public WalletFragmentOptions ch(Parcel paramParcel)
  {
    int m = 1;
    int n = 0;
    int i1 = a.B(paramParcel);
    WalletFragmentStyle localWalletFragmentStyle = null;
    int i = m;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i1)
      {
        if (paramParcel.dataPosition() == i1) {
          return new WalletFragmentOptions(j, i, n, localWalletFragmentStyle, m);
        }
        throw new a.a("Overread allowed size end=" + i1, paramParcel);
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
        i = a.g(paramParcel, k);
        break;
      case 3: 
        n = a.g(paramParcel, k);
        break;
      case 4: 
        localWalletFragmentStyle = (WalletFragmentStyle)a.a(paramParcel, k, WalletFragmentStyle.CREATOR);
        break;
      case 5: 
        m = a.g(paramParcel, k);
      }
    }
  }
  
  public WalletFragmentOptions[] dO(int paramInt)
  {
    return new WalletFragmentOptions[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.b
 * JD-Core Version:    0.7.0.1
 */