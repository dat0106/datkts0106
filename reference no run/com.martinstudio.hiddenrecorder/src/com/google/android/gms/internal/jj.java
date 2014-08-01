package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class jj
  implements Parcelable.Creator<ji>
{
  static void a(ji paramji, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramji.getRequestId(), false);
    b.c(paramParcel, 1000, paramji.getVersionCode());
    b.a(paramParcel, 2, paramji.getExpirationTime());
    b.a(paramParcel, 3, paramji.iV());
    b.a(paramParcel, 4, paramji.getLatitude());
    b.a(paramParcel, 5, paramji.getLongitude());
    b.a(paramParcel, 6, paramji.iW());
    b.c(paramParcel, 7, paramji.iX());
    b.c(paramParcel, 8, paramji.getNotificationResponsiveness());
    b.c(paramParcel, 9, paramji.iY());
    b.G(paramParcel, i);
  }
  
  public ji bt(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int n = 0;
    String str = null;
    int k = 0;
    short s = 0;
    double d1 = 0.0D;
    double d2 = 0.0D;
    float f = 0.0F;
    long l = 0L;
    int i1 = 0;
    int m = -1;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new ji(n, str, k, s, d1, d2, f, l, i1, m);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
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
      case 2: 
        l = a.i(paramParcel, i);
        break;
      case 3: 
        s = a.f(paramParcel, i);
        break;
      case 4: 
        d1 = a.m(paramParcel, i);
        break;
      case 5: 
        d2 = a.m(paramParcel, i);
        break;
      case 6: 
        f = a.l(paramParcel, i);
        break;
      case 7: 
        k = a.g(paramParcel, i);
        break;
      case 8: 
        i1 = a.g(paramParcel, i);
        break;
      case 9: 
        m = a.g(paramParcel, i);
        break;
      case 1000: 
        n = a.g(paramParcel, i);
      }
    }
  }
  
  public ji[] cO(int paramInt)
  {
    return new ji[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jj
 * JD-Core Version:    0.7.0.1
 */