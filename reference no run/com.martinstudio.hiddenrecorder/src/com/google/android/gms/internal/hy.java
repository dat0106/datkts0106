package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hy
  implements Parcelable.Creator<hw.a>
{
  static void a(hw.a parama, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, parama.versionCode);
    b.a(paramParcel, 2, parama.GW, false);
    b.c(paramParcel, 3, parama.GX);
    b.G(paramParcel, i);
  }
  
  public hw.a G(Parcel paramParcel)
  {
    int m = 0;
    int i = a.B(paramParcel);
    String str = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new hw.a(k, str, m);
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
        k = a.g(paramParcel, j);
        break;
      case 2: 
        str = a.o(paramParcel, j);
        break;
      case 3: 
        m = a.g(paramParcel, j);
      }
    }
  }
  
  public hw.a[] av(int paramInt)
  {
    return new hw.a[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hy
 * JD-Core Version:    0.7.0.1
 */