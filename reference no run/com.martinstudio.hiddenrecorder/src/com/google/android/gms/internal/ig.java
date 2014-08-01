package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ig
  implements Parcelable.Creator<if>
{
  static void a(if paramif, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramif.getVersionCode());
    b.a(paramParcel, 2, paramif.fT(), false);
    b.a(paramParcel, 3, paramif.fU(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public if L(Parcel paramParcel)
  {
    ic localic = null;
    int k = a.B(paramParcel);
    int j = 0;
    Parcel localParcel = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new if(j, localParcel, localic);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        j = a.g(paramParcel, i);
        break;
      case 2: 
        localParcel = a.C(paramParcel, i);
        break;
      case 3: 
        localic = (ic)a.a(paramParcel, i, ic.CREATOR);
      }
    }
  }
  
  public if[] aA(int paramInt)
  {
    return new if[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ig
 * JD-Core Version:    0.7.0.1
 */