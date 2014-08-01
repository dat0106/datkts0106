package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class x
  implements Parcelable.Creator<w>
{
  static void a(w paramw, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramw.versionCode);
    b.a(paramParcel, 2, paramw.kZ);
    b.a(paramParcel, 3, paramw.lb);
    b.G(paramParcel, i);
  }
  
  public w a(Parcel paramParcel)
  {
    boolean bool1 = false;
    int i = a.B(paramParcel);
    boolean bool2 = false;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new w(k, bool2, bool1);
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
        bool2 = a.c(paramParcel, j);
        break;
      case 3: 
        bool1 = a.c(paramParcel, j);
      }
    }
  }
  
  public w[] b(int paramInt)
  {
    return new w[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.x
 * JD-Core Version:    0.7.0.1
 */