package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class li
  implements Parcelable.Creator<lh>
{
  static void a(lh paramlh, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramlh.getVersionCode());
    b.a(paramParcel, 2, paramlh.aka, false);
    b.G(paramParcel, i);
  }
  
  public lh ce(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int i = 0;
    int[] arrayOfInt = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new lh(i, arrayOfInt);
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
        arrayOfInt = a.u(paramParcel, j);
      }
    }
  }
  
  public lh[] dK(int paramInt)
  {
    return new lh[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.li
 * JD-Core Version:    0.7.0.1
 */