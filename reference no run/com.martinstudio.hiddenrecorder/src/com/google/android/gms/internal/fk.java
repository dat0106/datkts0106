package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fk
  implements Parcelable.Creator<fj>
{
  static void a(fj paramfj, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramfj.xN, false);
    b.c(paramParcel, 1000, paramfj.xJ);
    b.a(paramParcel, 2, paramfj.xO, false);
    b.a(paramParcel, 3, paramfj.xP, false);
    b.G(paramParcel, i);
  }
  
  public fj[] E(int paramInt)
  {
    return new fj[paramInt];
  }
  
  public fj m(Parcel paramParcel)
  {
    String str2 = null;
    int k = a.B(paramParcel);
    int j = 0;
    String str3 = null;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new fj(j, str1, str3, str2);
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
        str1 = a.o(paramParcel, i);
        break;
      case 2: 
        str3 = a.o(paramParcel, i);
        break;
      case 3: 
        str2 = a.o(paramParcel, i);
        break;
      case 1000: 
        j = a.g(paramParcel, i);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fk
 * JD-Core Version:    0.7.0.1
 */