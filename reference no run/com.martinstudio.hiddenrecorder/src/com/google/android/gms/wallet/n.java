package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class n
  implements Parcelable.Creator<OfferWalletObject>
{
  static void a(OfferWalletObject paramOfferWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOfferWalletObject.getVersionCode());
    b.a(paramParcel, 2, paramOfferWalletObject.eC, false);
    b.a(paramParcel, 3, paramOfferWalletObject.ajQ, false);
    b.a(paramParcel, 4, paramOfferWalletObject.ajR, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OfferWalletObject cc(Parcel paramParcel)
  {
    CommonWalletObject localCommonWalletObject = null;
    int i = a.B(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new OfferWalletObject(j, str2, str1, localCommonWalletObject);
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
        str2 = a.o(paramParcel, k);
        break;
      case 3: 
        str1 = a.o(paramParcel, k);
        break;
      case 4: 
        localCommonWalletObject = (CommonWalletObject)a.a(paramParcel, k, CommonWalletObject.CREATOR);
      }
    }
  }
  
  public OfferWalletObject[] dI(int paramInt)
  {
    return new OfferWalletObject[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.n
 * JD-Core Version:    0.7.0.1
 */