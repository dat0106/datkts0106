package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class k
  implements Parcelable.Creator<j>
{
  static void a(j paramj, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramj.getVersionCode());
    b.a(paramParcel, 2, paramj.akW, false);
    b.a(paramParcel, 3, paramj.qb, false);
    b.G(paramParcel, i);
  }
  
  public j co(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.B(paramParcel);
    int k = 0;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new j(k, str1, str2);
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
        k = a.g(paramParcel, i);
        break;
      case 2: 
        str1 = a.o(paramParcel, i);
        break;
      case 3: 
        str2 = a.o(paramParcel, i);
      }
    }
  }
  
  public j[] dW(int paramInt)
  {
    return new j[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.k
 * JD-Core Version:    0.7.0.1
 */