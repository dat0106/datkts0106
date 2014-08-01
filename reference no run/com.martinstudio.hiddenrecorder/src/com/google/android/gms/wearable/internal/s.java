package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.wearable.c;

public class s
  implements Parcelable.Creator<r>
{
  static void a(r paramr, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramr.versionCode);
    b.c(paramParcel, 2, paramr.statusCode);
    b.a(paramParcel, 3, paramr.alJ, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public r cz(Parcel paramParcel)
  {
    int i = 0;
    int k = a.B(paramParcel);
    c localc = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new r(m, i, localc);
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
        m = a.g(paramParcel, j);
        break;
      case 2: 
        i = a.g(paramParcel, j);
        break;
      case 3: 
        localc = (c)a.a(paramParcel, j, c.CREATOR);
      }
    }
  }
  
  public r[] ei(int paramInt)
  {
    return new r[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.s
 * JD-Core Version:    0.7.0.1
 */