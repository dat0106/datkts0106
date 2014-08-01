package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ex
  implements Parcelable.Creator<ew>
{
  static void a(ew paramew, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramew.versionCode);
    b.a(paramParcel, 2, paramew.st, false);
    b.c(paramParcel, 3, paramew.su);
    b.c(paramParcel, 4, paramew.sv);
    b.a(paramParcel, 5, paramew.sw);
    b.G(paramParcel, i);
  }
  
  public ew j(Parcel paramParcel)
  {
    boolean bool = false;
    int m = a.B(paramParcel);
    String str = null;
    int n = 0;
    int k = 0;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new ew(i, str, k, n, bool);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
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
        str = a.o(paramParcel, j);
        break;
      case 3: 
        k = a.g(paramParcel, j);
        break;
      case 4: 
        n = a.g(paramParcel, j);
        break;
      case 5: 
        bool = a.c(paramParcel, j);
      }
    }
  }
  
  public ew[] q(int paramInt)
  {
    return new ew[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ex
 * JD-Core Version:    0.7.0.1
 */