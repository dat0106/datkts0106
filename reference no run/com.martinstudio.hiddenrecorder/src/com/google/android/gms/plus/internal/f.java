package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f
  implements Parcelable.Creator<PlusCommonExtras>
{
  static void a(PlusCommonExtras paramPlusCommonExtras, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramPlusCommonExtras.jS(), false);
    b.c(paramParcel, 1000, paramPlusCommonExtras.getVersionCode());
    b.a(paramParcel, 2, paramPlusCommonExtras.jT(), false);
    b.G(paramParcel, i);
  }
  
  public PlusCommonExtras bC(Parcel paramParcel)
  {
    String str2 = null;
    int k = a.B(paramParcel);
    int i = 0;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new PlusCommonExtras(i, str1, str2);
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
        str1 = a.o(paramParcel, j);
        break;
      case 2: 
        str2 = a.o(paramParcel, j);
        break;
      case 1000: 
        i = a.g(paramParcel, j);
      }
    }
  }
  
  public PlusCommonExtras[] cZ(int paramInt)
  {
    return new PlusCommonExtras[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.f
 * JD-Core Version:    0.7.0.1
 */