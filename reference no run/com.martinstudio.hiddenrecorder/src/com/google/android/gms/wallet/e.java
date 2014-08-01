package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e
  implements Parcelable.Creator<d>
{
  static void a(d paramd, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramd.getVersionCode());
    b.a(paramParcel, 2, paramd.aiL, paramInt, false);
    b.a(paramParcel, 3, paramd.aiM, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public d bT(Parcel paramParcel)
  {
    OfferWalletObject localOfferWalletObject = null;
    int i = a.B(paramParcel);
    int j = 0;
    LoyaltyWalletObject localLoyaltyWalletObject = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new d(j, localLoyaltyWalletObject, localOfferWalletObject);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        localOfferWalletObject = localOfferWalletObject;
        localLoyaltyWalletObject = localLoyaltyWalletObject;
        j = j;
        break;
      case 1: 
        j = a.g(paramParcel, k);
        localOfferWalletObject = localOfferWalletObject;
        localLoyaltyWalletObject = localLoyaltyWalletObject;
        j = j;
        localOfferWalletObject = localOfferWalletObject;
        break;
      case 2: 
        localLoyaltyWalletObject = (LoyaltyWalletObject)a.a(paramParcel, k, LoyaltyWalletObject.CREATOR);
        j = j;
        localOfferWalletObject = localOfferWalletObject;
        localLoyaltyWalletObject = localLoyaltyWalletObject;
        break;
      case 3: 
        localOfferWalletObject = (OfferWalletObject)a.a(paramParcel, k, OfferWalletObject.CREATOR);
        localLoyaltyWalletObject = localLoyaltyWalletObject;
        j = j;
      }
      j = j;
      localLoyaltyWalletObject = localLoyaltyWalletObject;
      localOfferWalletObject = localOfferWalletObject;
    }
  }
  
  public d[] dz(int paramInt)
  {
    return new d[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.e
 * JD-Core Version:    0.7.0.1
 */