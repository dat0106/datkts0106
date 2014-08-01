package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ju
  implements Parcelable.Creator<jt>
{
  static void a(jt paramjt, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramjt.qU, false);
    b.c(paramParcel, 1000, paramjt.xJ);
    b.G(paramParcel, i);
  }
  
  public jt by(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int j = 0;
    String str = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new jt(j, str);
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
        str = a.o(paramParcel, i);
        break;
      case 1000: 
        j = a.g(paramParcel, i);
      }
    }
  }
  
  public jt[] cT(int paramInt)
  {
    return new jt[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ju
 * JD-Core Version:    0.7.0.1
 */