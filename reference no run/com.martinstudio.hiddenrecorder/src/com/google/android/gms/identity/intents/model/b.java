package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<UserAddress>
{
  static void a(UserAddress paramUserAddress, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramUserAddress.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramUserAddress.name, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramUserAddress.UE, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 4, paramUserAddress.UF, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 5, paramUserAddress.UG, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 6, paramUserAddress.UH, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 7, paramUserAddress.UI, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 8, paramUserAddress.UJ, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 9, paramUserAddress.UK, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 10, paramUserAddress.rc, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 11, paramUserAddress.UL, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 12, paramUserAddress.UM, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 13, paramUserAddress.UN, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 14, paramUserAddress.UO);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 15, paramUserAddress.UP, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 16, paramUserAddress.UQ, false);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public UserAddress br(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    String str6 = null;
    String str4 = null;
    String str2 = null;
    String str12 = null;
    String str1 = null;
    String str9 = null;
    String str8 = null;
    String str5 = null;
    String str13 = null;
    String str14 = null;
    String str7 = null;
    String str11 = null;
    boolean bool = false;
    String str3 = null;
    String str10 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new UserAddress(i, str6, str4, str2, str12, str1, str9, str8, str5, str13, str14, str7, str11, bool, str3, str10);
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
        str6 = a.o(paramParcel, k);
        break;
      case 3: 
        str4 = a.o(paramParcel, k);
        break;
      case 4: 
        str2 = a.o(paramParcel, k);
        break;
      case 5: 
        str12 = a.o(paramParcel, k);
        break;
      case 6: 
        str1 = a.o(paramParcel, k);
        break;
      case 7: 
        str9 = a.o(paramParcel, k);
        break;
      case 8: 
        str8 = a.o(paramParcel, k);
        break;
      case 9: 
        str5 = a.o(paramParcel, k);
        break;
      case 10: 
        str13 = a.o(paramParcel, k);
        break;
      case 11: 
        str14 = a.o(paramParcel, k);
        break;
      case 12: 
        str7 = a.o(paramParcel, k);
        break;
      case 13: 
        str11 = a.o(paramParcel, k);
        break;
      case 14: 
        bool = a.c(paramParcel, k);
        break;
      case 15: 
        str3 = a.o(paramParcel, k);
        break;
      case 16: 
        str10 = a.o(paramParcel, k);
      }
    }
  }
  
  public UserAddress[] cE(int paramInt)
  {
    return new UserAddress[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.model.b
 * JD-Core Version:    0.7.0.1
 */