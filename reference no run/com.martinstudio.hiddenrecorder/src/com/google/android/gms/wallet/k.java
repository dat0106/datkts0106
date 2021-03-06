package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.UserAddress;

public class k
  implements Parcelable.Creator<MaskedWallet>
{
  static void a(MaskedWallet paramMaskedWallet, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramMaskedWallet.getVersionCode());
    b.a(paramParcel, 2, paramMaskedWallet.aiN, false);
    b.a(paramParcel, 3, paramMaskedWallet.aiO, false);
    b.a(paramParcel, 4, paramMaskedWallet.aiT, false);
    b.a(paramParcel, 5, paramMaskedWallet.aiQ, false);
    b.a(paramParcel, 6, paramMaskedWallet.aiR, paramInt, false);
    b.a(paramParcel, 7, paramMaskedWallet.aiS, paramInt, false);
    b.a(paramParcel, 8, paramMaskedWallet.ajz, paramInt, false);
    b.a(paramParcel, 9, paramMaskedWallet.ajA, paramInt, false);
    b.a(paramParcel, 10, paramMaskedWallet.aiU, paramInt, false);
    b.a(paramParcel, 11, paramMaskedWallet.aiV, paramInt, false);
    b.a(paramParcel, 12, paramMaskedWallet.aiW, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public MaskedWallet bZ(Parcel paramParcel)
  {
    int i = a.B(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    String[] arrayOfString = null;
    String str3 = null;
    Address localAddress2 = null;
    Address localAddress1 = null;
    LoyaltyWalletObject[] arrayOfLoyaltyWalletObject = null;
    OfferWalletObject[] arrayOfOfferWalletObject = null;
    UserAddress localUserAddress2 = null;
    UserAddress localUserAddress1 = null;
    InstrumentInfo[] arrayOfInstrumentInfo = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new MaskedWallet(j, str1, str2, arrayOfString, str3, localAddress2, localAddress1, arrayOfLoyaltyWalletObject, arrayOfOfferWalletObject, localUserAddress2, localUserAddress1, arrayOfInstrumentInfo);
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
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
        break;
      case 4: 
        arrayOfString = a.A(paramParcel, k);
        break;
      case 5: 
        str3 = a.o(paramParcel, k);
        break;
      case 6: 
        localAddress2 = (Address)a.a(paramParcel, k, Address.CREATOR);
        break;
      case 7: 
        localAddress1 = (Address)a.a(paramParcel, k, Address.CREATOR);
        break;
      case 8: 
        arrayOfLoyaltyWalletObject = (LoyaltyWalletObject[])a.b(paramParcel, k, LoyaltyWalletObject.CREATOR);
        break;
      case 9: 
        arrayOfOfferWalletObject = (OfferWalletObject[])a.b(paramParcel, k, OfferWalletObject.CREATOR);
        break;
      case 10: 
        localUserAddress2 = (UserAddress)a.a(paramParcel, k, UserAddress.CREATOR);
        break;
      case 11: 
        localUserAddress1 = (UserAddress)a.a(paramParcel, k, UserAddress.CREATOR);
        break;
      case 12: 
        arrayOfInstrumentInfo = (InstrumentInfo[])a.b(paramParcel, k, InstrumentInfo.CREATOR);
      }
    }
  }
  
  public MaskedWallet[] dF(int paramInt)
  {
    return new MaskedWallet[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.k
 * JD-Core Version:    0.7.0.1
 */