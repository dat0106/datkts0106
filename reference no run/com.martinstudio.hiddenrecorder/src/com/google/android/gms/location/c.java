package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class c
  implements Parcelable.Creator<b>
{
  static void a(b paramb, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramb.Vn);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1000, paramb.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 2, paramb.Vo);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramb.Vp);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public b bs(Parcel paramParcel)
  {
    int n = 1;
    int m = a.B(paramParcel);
    int j = 0;
    long l = 0L;
    int k = n;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new b(j, k, n, l);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
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
        n = a.g(paramParcel, i);
        break;
      case 3: 
        l = a.i(paramParcel, i);
        break;
      case 1000: 
        j = a.g(paramParcel, i);
      }
    }
  }
  
  public b[] cL(int paramInt)
  {
    return new b[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.c
 * JD-Core Version:    0.7.0.1
 */