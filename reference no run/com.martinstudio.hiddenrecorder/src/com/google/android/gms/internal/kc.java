package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class kc
  implements Parcelable.Creator<kb>
{
  static void a(kb paramkb, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramkb.YS, false);
    b.c(paramParcel, 1000, paramkb.versionCode);
    b.a(paramParcel, 2, paramkb.YT, false);
    b.G(paramParcel, i);
  }
  
  public kb bB(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.B(paramParcel);
    int k = 0;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new kb(k, str1, str2);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        str1 = a.o(paramParcel, i);
        break;
      case 2: 
        str2 = a.o(paramParcel, i);
        break;
      case 1000: 
        k = a.g(paramParcel, i);
      }
    }
  }
  
  public kb[] cW(int paramInt)
  {
    return new kb[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kc
 * JD-Core Version:    0.7.0.1
 */