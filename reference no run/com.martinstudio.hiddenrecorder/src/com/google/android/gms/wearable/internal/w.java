package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class w
  implements Parcelable.Creator<v>
{
  static void a(v paramv, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramv.versionCode);
    b.c(paramParcel, 2, paramv.statusCode);
    b.a(paramParcel, 3, paramv.alL, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public v cB(Parcel paramParcel)
  {
    int k = 0;
    int i = a.B(paramParcel);
    m localm = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new v(m, k, localm);
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
        m = a.g(paramParcel, j);
        break;
      case 2: 
        k = a.g(paramParcel, j);
        break;
      case 3: 
        localm = (m)a.a(paramParcel, j, m.CREATOR);
      }
    }
  }
  
  public v[] ek(int paramInt)
  {
    return new v[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.w
 * JD-Core Version:    0.7.0.1
 */