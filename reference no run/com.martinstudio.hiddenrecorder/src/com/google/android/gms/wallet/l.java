package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class l
  implements Parcelable.Creator<MaskedWalletRequest>
{
  static void a(MaskedWalletRequest paramMaskedWalletRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramMaskedWalletRequest.getVersionCode());
    b.a(paramParcel, 2, paramMaskedWalletRequest.aiO, false);
    b.a(paramParcel, 3, paramMaskedWalletRequest.ajC);
    b.a(paramParcel, 4, paramMaskedWalletRequest.ajD);
    b.a(paramParcel, 5, paramMaskedWalletRequest.ajE);
    b.a(paramParcel, 6, paramMaskedWalletRequest.ajF, false);
    b.a(paramParcel, 7, paramMaskedWalletRequest.aiI, false);
    b.a(paramParcel, 8, paramMaskedWalletRequest.ajG, false);
    b.a(paramParcel, 9, paramMaskedWalletRequest.aiX, paramInt, false);
    b.a(paramParcel, 10, paramMaskedWalletRequest.ajH);
    b.a(paramParcel, 11, paramMaskedWalletRequest.ajI);
    b.a(paramParcel, 12, paramMaskedWalletRequest.ajJ, paramInt, false);
    b.a(paramParcel, 13, paramMaskedWalletRequest.ajK);
    b.a(paramParcel, 14, paramMaskedWalletRequest.ajL);
    b.b(paramParcel, 15, paramMaskedWalletRequest.ajM, false);
    b.G(paramParcel, i);
  }
  
  public MaskedWalletRequest ca(Parcel paramParcel)
  {
    int i = a.B(paramParcel);
    int j = 0;
    String str3 = null;
    boolean bool7 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    String str2 = null;
    String str4 = null;
    String str1 = null;
    Cart localCart = null;
    boolean bool1 = false;
    boolean bool3 = false;
    CountrySpecification[] arrayOfCountrySpecification = null;
    boolean bool6 = true;
    boolean bool2 = true;
    ArrayList localArrayList = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new MaskedWalletRequest(j, str3, bool7, bool5, bool4, str2, str4, str1, localCart, bool1, bool3, arrayOfCountrySpecification, bool6, bool2, localArrayList);
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
        str3 = a.o(paramParcel, k);
        break;
      case 3: 
        bool7 = a.c(paramParcel, k);
        break;
      case 4: 
        bool5 = a.c(paramParcel, k);
        break;
      case 5: 
        bool4 = a.c(paramParcel, k);
        break;
      case 6: 
        str2 = a.o(paramParcel, k);
        break;
      case 7: 
        str4 = a.o(paramParcel, k);
        break;
      case 8: 
        str1 = a.o(paramParcel, k);
        break;
      case 9: 
        localCart = (Cart)a.a(paramParcel, k, Cart.CREATOR);
        break;
      case 10: 
        bool1 = a.c(paramParcel, k);
        break;
      case 11: 
        bool3 = a.c(paramParcel, k);
        break;
      case 12: 
        arrayOfCountrySpecification = (CountrySpecification[])a.b(paramParcel, k, CountrySpecification.CREATOR);
        break;
      case 13: 
        bool6 = a.c(paramParcel, k);
        break;
      case 14: 
        bool2 = a.c(paramParcel, k);
        break;
      case 15: 
        localArrayList = a.c(paramParcel, k, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
      }
    }
  }
  
  public MaskedWalletRequest[] dG(int paramInt)
  {
    return new MaskedWalletRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.l
 * JD-Core Version:    0.7.0.1
 */