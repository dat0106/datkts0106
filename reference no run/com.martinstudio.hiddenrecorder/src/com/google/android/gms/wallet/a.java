package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<Address>
{
  static void a(Address paramAddress, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramAddress.getVersionCode());
    b.a(paramParcel, 2, paramAddress.name, false);
    b.a(paramParcel, 3, paramAddress.UE, false);
    b.a(paramParcel, 4, paramAddress.UF, false);
    b.a(paramParcel, 5, paramAddress.UG, false);
    b.a(paramParcel, 6, paramAddress.rc, false);
    b.a(paramParcel, 7, paramAddress.aiF, false);
    b.a(paramParcel, 8, paramAddress.aiG, false);
    b.a(paramParcel, 9, paramAddress.UL, false);
    b.a(paramParcel, 10, paramAddress.UN, false);
    b.a(paramParcel, 11, paramAddress.UO);
    b.a(paramParcel, 12, paramAddress.UP, false);
    b.G(paramParcel, i);
  }
  
  public Address bQ(Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    int j = 0;
    String str1 = null;
    String str5 = null;
    String str9 = null;
    String str2 = null;
    String str4 = null;
    String str6 = null;
    String str3 = null;
    String str10 = null;
    String str8 = null;
    boolean bool = false;
    String str7 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new Address(j, str1, str5, str9, str2, str4, str6, str3, str10, str8, bool, str7);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2: 
        str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 3: 
        str5 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 4: 
        str9 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 5: 
        str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 6: 
        str4 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 7: 
        str6 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 8: 
        str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 9: 
        str10 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 10: 
        str8 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 11: 
        bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k);
        break;
      case 12: 
        str7 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
      }
    }
  }
  
  public Address[] dw(int paramInt)
  {
    return new Address[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.a
 * JD-Core Version:    0.7.0.1
 */