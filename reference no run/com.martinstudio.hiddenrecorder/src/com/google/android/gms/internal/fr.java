package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fr
  implements Parcelable.Creator<fq>
{
  static void a(fq paramfq, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramfq.name, false);
    b.c(paramParcel, 1000, paramfq.xJ);
    b.a(paramParcel, 2, paramfq.xY, false);
    b.a(paramParcel, 3, paramfq.xZ);
    b.c(paramParcel, 4, paramfq.weight);
    b.a(paramParcel, 5, paramfq.ya);
    b.a(paramParcel, 6, paramfq.yb, false);
    b.a(paramParcel, 7, paramfq.yc, paramInt, false);
    b.a(paramParcel, 8, paramfq.yd, false);
    b.a(paramParcel, 11, paramfq.ye, false);
    b.G(paramParcel, i);
  }
  
  public fq[] J(int paramInt)
  {
    return new fq[paramInt];
  }
  
  public fq p(Parcel paramParcel)
  {
    boolean bool2 = false;
    String str4 = null;
    int j = a.B(paramParcel);
    int k = 1;
    int[] arrayOfInt = null;
    fn[] arrayOffn = null;
    String str1 = null;
    boolean bool1 = false;
    String str3 = null;
    String str2 = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new fq(m, str2, str3, bool1, k, bool2, str1, arrayOffn, arrayOfInt, str4);
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
        str2 = a.o(paramParcel, i);
        break;
      case 2: 
        str3 = a.o(paramParcel, i);
        break;
      case 3: 
        bool1 = a.c(paramParcel, i);
        break;
      case 4: 
        k = a.g(paramParcel, i);
        break;
      case 5: 
        bool2 = a.c(paramParcel, i);
        break;
      case 6: 
        str1 = a.o(paramParcel, i);
        break;
      case 7: 
        arrayOffn = (fn[])a.b(paramParcel, i, fn.CREATOR);
        break;
      case 8: 
        arrayOfInt = a.u(paramParcel, i);
        break;
      case 11: 
        str4 = a.o(paramParcel, i);
        break;
      case 1000: 
        m = a.g(paramParcel, i);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fr
 * JD-Core Version:    0.7.0.1
 */