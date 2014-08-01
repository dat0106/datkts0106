package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ch
  implements Parcelable.Creator<ci>
{
  static void a(ci paramci, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramci.versionCode);
    b.a(paramParcel, 2, paramci.ot, paramInt, false);
    b.a(paramParcel, 3, paramci.aP(), false);
    b.a(paramParcel, 4, paramci.aQ(), false);
    b.a(paramParcel, 5, paramci.aR(), false);
    b.a(paramParcel, 6, paramci.aS(), false);
    b.a(paramParcel, 7, paramci.oy, false);
    b.a(paramParcel, 8, paramci.oz);
    b.a(paramParcel, 9, paramci.oA, false);
    b.a(paramParcel, 10, paramci.aU(), false);
    b.c(paramParcel, 11, paramci.orientation);
    b.c(paramParcel, 12, paramci.oC);
    b.a(paramParcel, 13, paramci.nZ, false);
    b.a(paramParcel, 14, paramci.kO, paramInt, false);
    b.a(paramParcel, 15, paramci.aT(), false);
    b.a(paramParcel, 17, paramci.oF, paramInt, false);
    b.a(paramParcel, 16, paramci.oE, false);
    b.G(paramParcel, i);
  }
  
  public ci f(Parcel paramParcel)
  {
    int n = a.B(paramParcel);
    int k = 0;
    cf localcf = null;
    IBinder localIBinder6 = null;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
    IBinder localIBinder5 = null;
    String str2 = null;
    boolean bool = false;
    String str3 = null;
    IBinder localIBinder4 = null;
    int m = 0;
    int i = 0;
    String str4 = null;
    ew localew = null;
    IBinder localIBinder1 = null;
    String str1 = null;
    w localw = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= n)
      {
        if (paramParcel.dataPosition() == n) {
          return new ci(k, localcf, localIBinder6, localIBinder2, localIBinder3, localIBinder5, str2, bool, str3, localIBinder4, m, i, str4, localew, localIBinder1, str1, localw);
        }
        throw new a.a("Overread allowed size end=" + n, paramParcel);
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
        localcf = (cf)a.a(paramParcel, j, cf.CREATOR);
        break;
      case 3: 
        localIBinder6 = a.p(paramParcel, j);
        break;
      case 4: 
        localIBinder2 = a.p(paramParcel, j);
        break;
      case 5: 
        localIBinder3 = a.p(paramParcel, j);
        break;
      case 6: 
        localIBinder5 = a.p(paramParcel, j);
        break;
      case 7: 
        str2 = a.o(paramParcel, j);
        break;
      case 8: 
        bool = a.c(paramParcel, j);
        break;
      case 9: 
        str3 = a.o(paramParcel, j);
        break;
      case 10: 
        localIBinder4 = a.p(paramParcel, j);
        break;
      case 11: 
        m = a.g(paramParcel, j);
        break;
      case 12: 
        i = a.g(paramParcel, j);
        break;
      case 13: 
        str4 = a.o(paramParcel, j);
        break;
      case 14: 
        localew = (ew)a.a(paramParcel, j, ew.CREATOR);
        break;
      case 15: 
        localIBinder1 = a.p(paramParcel, j);
        break;
      case 16: 
        str1 = a.o(paramParcel, j);
        break;
      case 17: 
        localw = (w)a.a(paramParcel, j, w.CREATOR);
      }
    }
  }
  
  public ci[] j(int paramInt)
  {
    return new ci[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ch
 * JD-Core Version:    0.7.0.1
 */