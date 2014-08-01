package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.ih;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.d;
import com.google.android.gms.wallet.wobs.f;
import com.google.android.gms.wallet.wobs.l;
import com.google.android.gms.wallet.wobs.n;
import com.google.android.gms.wallet.wobs.p;
import java.util.ArrayList;

public class j
  implements Parcelable.Creator<LoyaltyWalletObject>
{
  static void a(LoyaltyWalletObject paramLoyaltyWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramLoyaltyWalletObject.getVersionCode());
    b.a(paramParcel, 2, paramLoyaltyWalletObject.eC, false);
    b.a(paramParcel, 3, paramLoyaltyWalletObject.ajf, false);
    b.a(paramParcel, 4, paramLoyaltyWalletObject.ajg, false);
    b.a(paramParcel, 5, paramLoyaltyWalletObject.ajh, false);
    b.a(paramParcel, 6, paramLoyaltyWalletObject.aji, false);
    b.a(paramParcel, 7, paramLoyaltyWalletObject.ajj, false);
    b.a(paramParcel, 8, paramLoyaltyWalletObject.ajk, false);
    b.a(paramParcel, 9, paramLoyaltyWalletObject.ajl, false);
    b.a(paramParcel, 10, paramLoyaltyWalletObject.ajm, false);
    b.a(paramParcel, 11, paramLoyaltyWalletObject.ajn, false);
    b.c(paramParcel, 12, paramLoyaltyWalletObject.state);
    b.b(paramParcel, 13, paramLoyaltyWalletObject.ajo, false);
    b.a(paramParcel, 14, paramLoyaltyWalletObject.ajp, paramInt, false);
    b.b(paramParcel, 15, paramLoyaltyWalletObject.ajq, false);
    b.a(paramParcel, 17, paramLoyaltyWalletObject.ajs, false);
    b.a(paramParcel, 16, paramLoyaltyWalletObject.ajr, false);
    b.a(paramParcel, 19, paramLoyaltyWalletObject.aju);
    b.b(paramParcel, 18, paramLoyaltyWalletObject.ajt, false);
    b.b(paramParcel, 21, paramLoyaltyWalletObject.ajw, false);
    b.b(paramParcel, 20, paramLoyaltyWalletObject.ajv, false);
    b.a(paramParcel, 23, paramLoyaltyWalletObject.ajy, paramInt, false);
    b.b(paramParcel, 22, paramLoyaltyWalletObject.ajx, false);
    b.G(paramParcel, i);
  }
  
  public LoyaltyWalletObject bY(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    String str12 = null;
    String str11 = null;
    String str8 = null;
    String str7 = null;
    String str10 = null;
    String str5 = null;
    String str1 = null;
    String str9 = null;
    String str4 = null;
    String str6 = null;
    int m = 0;
    ArrayList localArrayList6 = ih.fV();
    l locall = null;
    ArrayList localArrayList3 = ih.fV();
    String str2 = null;
    String str3 = null;
    ArrayList localArrayList5 = ih.fV();
    boolean bool = false;
    ArrayList localArrayList4 = ih.fV();
    ArrayList localArrayList2 = ih.fV();
    ArrayList localArrayList1 = ih.fV();
    f localf = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new LoyaltyWalletObject(i, str12, str11, str8, str7, str10, str5, str1, str9, str4, str6, m, localArrayList6, locall, localArrayList3, str2, str3, localArrayList5, bool, localArrayList4, localArrayList2, localArrayList1, localf);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str12 = a.o(paramParcel, k);
        break;
      case 3: 
        str11 = a.o(paramParcel, k);
        break;
      case 4: 
        str8 = a.o(paramParcel, k);
        break;
      case 5: 
        str7 = a.o(paramParcel, k);
        break;
      case 6: 
        str10 = a.o(paramParcel, k);
        break;
      case 7: 
        str5 = a.o(paramParcel, k);
        break;
      case 8: 
        str1 = a.o(paramParcel, k);
        break;
      case 9: 
        str9 = a.o(paramParcel, k);
        break;
      case 10: 
        str4 = a.o(paramParcel, k);
        break;
      case 11: 
        str6 = a.o(paramParcel, k);
        break;
      case 12: 
        m = a.g(paramParcel, k);
        break;
      case 13: 
        localArrayList6 = a.c(paramParcel, k, p.CREATOR);
        break;
      case 14: 
        locall = (l)a.a(paramParcel, k, l.CREATOR);
        break;
      case 15: 
        localArrayList3 = a.c(paramParcel, k, LatLng.CREATOR);
        break;
      case 16: 
        str2 = a.o(paramParcel, k);
        break;
      case 17: 
        str3 = a.o(paramParcel, k);
        break;
      case 18: 
        localArrayList5 = a.c(paramParcel, k, d.CREATOR);
        break;
      case 19: 
        bool = a.c(paramParcel, k);
        break;
      case 20: 
        localArrayList4 = a.c(paramParcel, k, n.CREATOR);
        break;
      case 21: 
        localArrayList2 = a.c(paramParcel, k, com.google.android.gms.wallet.wobs.j.CREATOR);
        break;
      case 22: 
        localArrayList1 = a.c(paramParcel, k, n.CREATOR);
        break;
      case 23: 
        localf = (f)a.a(paramParcel, k, f.CREATOR);
      }
    }
  }
  
  public LoyaltyWalletObject[] dE(int paramInt)
  {
    return new LoyaltyWalletObject[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.j
 * JD-Core Version:    0.7.0.1
 */