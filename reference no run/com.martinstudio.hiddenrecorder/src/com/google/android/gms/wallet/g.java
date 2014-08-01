package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g
  implements Parcelable.Creator<FullWalletRequest>
{
  static void a(FullWalletRequest paramFullWalletRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramFullWalletRequest.getVersionCode());
    b.a(paramParcel, 2, paramFullWalletRequest.aiN, false);
    b.a(paramParcel, 3, paramFullWalletRequest.aiO, false);
    b.a(paramParcel, 4, paramFullWalletRequest.aiX, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public FullWalletRequest bV(Parcel paramParcel)
  {
    Cart localCart = null;
    int i = a.B(paramParcel);
    int k = 0;
    String str1 = null;
    String str2 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new FullWalletRequest(k, str2, str1, localCart);
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
        localCart = (Cart)a.a(paramParcel, j, Cart.CREATOR);
      }
    }
  }
  
  public FullWalletRequest[] dB(int paramInt)
  {
    return new FullWalletRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.g
 * JD-Core Version:    0.7.0.1
 */