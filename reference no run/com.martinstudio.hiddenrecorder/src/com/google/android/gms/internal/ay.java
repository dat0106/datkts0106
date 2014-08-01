package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ay
  implements Parcelable.Creator<ax>
{
  static void a(ax paramax, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramax.versionCode);
    b.c(paramParcel, 2, paramax.mB);
    b.c(paramParcel, 3, paramax.backgroundColor);
    b.c(paramParcel, 4, paramax.mC);
    b.c(paramParcel, 5, paramax.mD);
    b.c(paramParcel, 6, paramax.mE);
    b.c(paramParcel, 7, paramax.mF);
    b.c(paramParcel, 8, paramax.mG);
    b.c(paramParcel, 9, paramax.mH);
    b.a(paramParcel, 10, paramax.mI, false);
    b.c(paramParcel, 11, paramax.mJ);
    b.a(paramParcel, 12, paramax.mK, false);
    b.c(paramParcel, 13, paramax.mL);
    b.c(paramParcel, 14, paramax.mM);
    b.a(paramParcel, 15, paramax.mN, false);
    b.G(paramParcel, i);
  }
  
  public ax d(Parcel paramParcel)
  {
    int i4 = a.B(paramParcel);
    int k = 0;
    int m = 0;
    int i9 = 0;
    int i2 = 0;
    int i6 = 0;
    int i3 = 0;
    int i5 = 0;
    int i1 = 0;
    int i8 = 0;
    String str3 = null;
    int n = 0;
    String str2 = null;
    int i7 = 0;
    int j = 0;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i4)
      {
        if (paramParcel.dataPosition() == i4) {
          return new ax(k, m, i9, i2, i6, i3, i5, i1, i8, str3, n, str2, i7, j, str1);
        }
        throw new a.a("Overread allowed size end=" + i4, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        k = a.g(paramParcel, i);
        break;
      case 2: 
        m = a.g(paramParcel, i);
        break;
      case 3: 
        i9 = a.g(paramParcel, i);
        break;
      case 4: 
        i2 = a.g(paramParcel, i);
        break;
      case 5: 
        i6 = a.g(paramParcel, i);
        break;
      case 6: 
        i3 = a.g(paramParcel, i);
        break;
      case 7: 
        i5 = a.g(paramParcel, i);
        break;
      case 8: 
        i1 = a.g(paramParcel, i);
        break;
      case 9: 
        i8 = a.g(paramParcel, i);
        break;
      case 10: 
        str3 = a.o(paramParcel, i);
        break;
      case 11: 
        n = a.g(paramParcel, i);
        break;
      case 12: 
        str2 = a.o(paramParcel, i);
        break;
      case 13: 
        i7 = a.g(paramParcel, i);
        break;
      case 14: 
        j = a.g(paramParcel, i);
        break;
      case 15: 
        str1 = a.o(paramParcel, i);
      }
    }
  }
  
  public ax[] f(int paramInt)
  {
    return new ax[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ay
 * JD-Core Version:    0.7.0.1
 */