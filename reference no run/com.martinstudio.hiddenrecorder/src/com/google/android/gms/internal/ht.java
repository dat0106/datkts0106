package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ht
  implements Parcelable.Creator<hs>
{
  static void a(hs paramhs, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramhs.xJ);
    b.a(paramParcel, 2, paramhs.GQ, false);
    b.c(paramParcel, 3, paramhs.GR);
    b.G(paramParcel, i);
  }
  
  public hs D(Parcel paramParcel)
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
          return new hs(k, str, m);
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
  
  public hs[] as(int paramInt)
  {
    return new hs[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ht
 * JD-Core Version:    0.7.0.1
 */