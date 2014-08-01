package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class dw
  implements Parcelable.Creator<dv>
{
  static void a(dv paramdv, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramdv.versionCode);
    b.a(paramParcel, 2, paramdv.oy, false);
    b.a(paramParcel, 3, paramdv.qb, false);
    b.a(paramParcel, 4, paramdv.nr, false);
    b.c(paramParcel, 5, paramdv.errorCode);
    b.a(paramParcel, 6, paramdv.ns, false);
    b.a(paramParcel, 7, paramdv.qc);
    b.a(paramParcel, 8, paramdv.qd);
    b.a(paramParcel, 9, paramdv.qe);
    b.a(paramParcel, 10, paramdv.qf, false);
    b.a(paramParcel, 11, paramdv.nv);
    b.c(paramParcel, 12, paramdv.orientation);
    b.a(paramParcel, 13, paramdv.qg, false);
    b.a(paramParcel, 14, paramdv.qh);
    b.a(paramParcel, 15, paramdv.qi, false);
    b.a(paramParcel, 19, paramdv.qk, false);
    b.a(paramParcel, 18, paramdv.qj);
    b.a(paramParcel, 21, paramdv.ql, false);
    b.G(paramParcel, i);
  }
  
  public dv i(Parcel paramParcel)
  {
    int n = a.B(paramParcel);
    int k = 0;
    String str3 = null;
    String str6 = null;
    Object localObject1 = null;
    int i = 0;
    Object localObject3 = null;
    long l2 = 0L;
    boolean bool1 = false;
    long l3 = 0L;
    Object localObject2 = null;
    long l1 = 0L;
    int j = 0;
    String str2 = null;
    long l4 = 0L;
    String str1 = null;
    boolean bool2 = false;
    String str5 = null;
    String str4 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= n)
      {
        if (paramParcel.dataPosition() == n) {
          return new dv(k, str3, str6, (List)localObject1, i, (List)localObject3, l2, bool1, l3, (List)localObject2, l1, j, str2, l4, str1, bool2, str5, str4);
        }
        throw new a.a("Overread allowed size end=" + n, paramParcel);
      }
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      case 16: 
      case 17: 
      case 20: 
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        k = a.g(paramParcel, m);
        break;
      case 2: 
        str3 = a.o(paramParcel, m);
        break;
      case 3: 
        str6 = a.o(paramParcel, m);
        break;
      case 4: 
        localObject1 = a.B(paramParcel, m);
        break;
      case 5: 
        i = a.g(paramParcel, m);
        break;
      case 6: 
        localObject3 = a.B(paramParcel, m);
        break;
      case 7: 
        l2 = a.i(paramParcel, m);
        break;
      case 8: 
        bool1 = a.c(paramParcel, m);
        break;
      case 9: 
        l3 = a.i(paramParcel, m);
        break;
      case 10: 
        localObject2 = a.B(paramParcel, m);
        break;
      case 11: 
        l1 = a.i(paramParcel, m);
        break;
      case 12: 
        j = a.g(paramParcel, m);
        break;
      case 13: 
        str2 = a.o(paramParcel, m);
        break;
      case 14: 
        l4 = a.i(paramParcel, m);
        break;
      case 15: 
        str1 = a.o(paramParcel, m);
        break;
      case 18: 
        bool2 = a.c(paramParcel, m);
        break;
      case 19: 
        str5 = a.o(paramParcel, m);
        break;
      case 21: 
        str4 = a.o(paramParcel, m);
      }
    }
  }
  
  public dv[] n(int paramInt)
  {
    return new dv[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dw
 * JD-Core Version:    0.7.0.1
 */