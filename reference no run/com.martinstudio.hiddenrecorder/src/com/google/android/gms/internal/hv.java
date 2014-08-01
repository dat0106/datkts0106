package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hv
  implements Parcelable.Creator<hu>
{
  static void a(hu paramhu, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramhu.getVersionCode());
    b.a(paramParcel, 2, paramhu.fw(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public hu E(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int i = 0;
    hw localhw = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new hu(i, localhw);
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
        i = a.g(paramParcel, j);
        break;
      case 2: 
        localhw = (hw)a.a(paramParcel, j, hw.CREATOR);
      }
    }
  }
  
  public hu[] at(int paramInt)
  {
    return new hu[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hv
 * JD-Core Version:    0.7.0.1
 */