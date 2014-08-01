package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class aa
  implements Parcelable.Creator<z>
{
  static void a(z paramz, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramz.versionCode);
    b.c(paramParcel, 2, paramz.statusCode);
    b.a(paramParcel, 3, paramz.alN, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public z cD(Parcel paramParcel)
  {
    int k = 0;
    int j = a.B(paramParcel);
    ai localai = null;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new z(i, k, localai);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        i = a.g(paramParcel, m);
        break;
      case 2: 
        k = a.g(paramParcel, m);
        break;
      case 3: 
        localai = (ai)a.a(paramParcel, m, ai.CREATOR);
      }
    }
  }
  
  public z[] em(int paramInt)
  {
    return new z[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.aa
 * JD-Core Version:    0.7.0.1
 */