package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fo
  implements Parcelable.Creator<fn>
{
  static void a(fn paramfn, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramfn.id);
    b.c(paramParcel, 1000, paramfn.xJ);
    b.a(paramParcel, 2, paramfn.xV, false);
    b.G(paramParcel, i);
  }
  
  public fn[] G(int paramInt)
  {
    return new fn[paramInt];
  }
  
  public fn o(Parcel paramParcel)
  {
    int i = 0;
    int m = a.B(paramParcel);
    Bundle localBundle = null;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new fn(j, i, localBundle);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localBundle = a.q(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fo
 * JD-Core Version:    0.7.0.1
 */