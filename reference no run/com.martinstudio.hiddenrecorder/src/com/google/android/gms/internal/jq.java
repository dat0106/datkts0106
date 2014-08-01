package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jq
  implements Parcelable.Creator<jp>
{
  static void a(jp paramjp, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramjp.xJ);
    b.a(paramParcel, 2, paramjp.je(), false);
    b.a(paramParcel, 3, paramjp.getTag(), false);
    b.G(paramParcel, i);
  }
  
  public jp bw(Parcel paramParcel)
  {
    String str2 = null;
    int k = a.B(paramParcel);
    int i = 0;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new jp(i, str1, str2);
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
        str1 = a.o(paramParcel, j);
        break;
      case 3: 
        str2 = a.o(paramParcel, j);
      }
    }
  }
  
  public jp[] cR(int paramInt)
  {
    return new jp[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jq
 * JD-Core Version:    0.7.0.1
 */