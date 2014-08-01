package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jy
  implements Parcelable.Creator<jx>
{
  static void a(jx paramjx, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramjx.qU, false);
    b.c(paramParcel, 1000, paramjx.xJ);
    b.c(paramParcel, 2, paramjx.YP);
    b.G(paramParcel, i);
  }
  
  public jx bA(Parcel paramParcel)
  {
    int k = 0;
    int i = a.B(paramParcel);
    String str = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new jx(m, str, k);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        str = a.o(paramParcel, j);
        break;
      case 2: 
        k = a.g(paramParcel, j);
        break;
      case 1000: 
        m = a.g(paramParcel, j);
      }
    }
  }
  
  public jx[] cV(int paramInt)
  {
    return new jx[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jy
 * JD-Core Version:    0.7.0.1
 */