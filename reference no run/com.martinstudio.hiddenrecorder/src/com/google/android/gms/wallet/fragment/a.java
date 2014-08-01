package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public class a
  implements Parcelable.Creator<WalletFragmentInitParams>
{
  static void a(WalletFragmentInitParams paramWalletFragmentInitParams, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramWalletFragmentInitParams.xJ);
    b.a(paramParcel, 2, paramWalletFragmentInitParams.getAccountName(), false);
    b.a(paramParcel, 3, paramWalletFragmentInitParams.getMaskedWalletRequest(), paramInt, false);
    b.c(paramParcel, 4, paramWalletFragmentInitParams.getMaskedWalletRequestCode());
    b.a(paramParcel, 5, paramWalletFragmentInitParams.getMaskedWallet(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public WalletFragmentInitParams cg(Parcel paramParcel)
  {
    MaskedWallet localMaskedWallet = null;
    int m = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    int k = 0;
    int i = -1;
    MaskedWalletRequest localMaskedWalletRequest = null;
    String str = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new WalletFragmentInitParams(k, str, localMaskedWalletRequest, i, localMaskedWallet);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int j = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(j))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, j);
        break;
      case 1: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, j);
        break;
      case 2: 
        str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, j);
        break;
      case 3: 
        localMaskedWalletRequest = (MaskedWalletRequest)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, j, MaskedWalletRequest.CREATOR);
        break;
      case 4: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, j);
        break;
      case 5: 
        localMaskedWallet = (MaskedWallet)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, j, MaskedWallet.CREATOR);
      }
    }
  }
  
  public WalletFragmentInitParams[] dN(int paramInt)
  {
    return new WalletFragmentInitParams[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.a
 * JD-Core Version:    0.7.0.1
 */