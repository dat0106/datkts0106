package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class js
  implements Parcelable.Creator<jr>
{
  static void a(jr paramjr, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramjr.xJ);
    b.a(paramParcel, 2, paramjr.ja(), paramInt, false);
    b.a(paramParcel, 3, paramjr.getInterval());
    b.c(paramParcel, 4, paramjr.getPriority());
    b.G(paramParcel, i);
  }
  
  public jr bx(Parcel paramParcel)
  {
    int m = a.B(paramParcel);
    int j = 0;
    jn localjn = null;
    long l = jr.Wj;
    int i = 102;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new jr(j, localjn, l, i);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 2: 
        localjn = (jn)a.a(paramParcel, k, jn.CREATOR);
        break;
      case 3: 
        l = a.i(paramParcel, k);
        break;
      case 4: 
        i = a.g(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
      }
    }
  }
  
  public jr[] cS(int paramInt)
  {
    return new jr[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.js
 * JD-Core Version:    0.7.0.1
 */