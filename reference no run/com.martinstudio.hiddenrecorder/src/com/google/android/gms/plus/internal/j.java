package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class j
  implements Parcelable.Creator<h>
{
  static void a(h paramh, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramh.getAccountName(), false);
    b.c(paramParcel, 1000, paramh.getVersionCode());
    b.a(paramParcel, 2, paramh.jU(), false);
    b.a(paramParcel, 3, paramh.jV(), false);
    b.a(paramParcel, 4, paramh.jW(), false);
    b.a(paramParcel, 5, paramh.jX(), false);
    b.a(paramParcel, 6, paramh.jY(), false);
    b.a(paramParcel, 7, paramh.jZ(), false);
    b.a(paramParcel, 8, paramh.ka(), false);
    b.a(paramParcel, 9, paramh.kb(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public h bD(Parcel paramParcel)
  {
    PlusCommonExtras localPlusCommonExtras = null;
    int k = a.B(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    String str5 = null;
    String str4 = null;
    String[] arrayOfString2 = null;
    String[] arrayOfString1 = null;
    String[] arrayOfString3 = null;
    String str3 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new h(i, str3, arrayOfString3, arrayOfString1, arrayOfString2, str4, str5, str2, str1, localPlusCommonExtras);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        str3 = a.o(paramParcel, j);
        break;
      case 2: 
        arrayOfString3 = a.A(paramParcel, j);
        break;
      case 3: 
        arrayOfString1 = a.A(paramParcel, j);
        break;
      case 4: 
        arrayOfString2 = a.A(paramParcel, j);
        break;
      case 5: 
        str4 = a.o(paramParcel, j);
        break;
      case 6: 
        str5 = a.o(paramParcel, j);
        break;
      case 7: 
        str2 = a.o(paramParcel, j);
        break;
      case 8: 
        str1 = a.o(paramParcel, j);
        break;
      case 9: 
        localPlusCommonExtras = (PlusCommonExtras)a.a(paramParcel, j, PlusCommonExtras.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, j);
      }
    }
  }
  
  public h[] da(int paramInt)
  {
    return new h[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.j
 * JD-Core Version:    0.7.0.1
 */