package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.internal.ih;
import java.util.ArrayList;

public class e
  implements Parcelable.Creator<d>
{
  static void a(d paramd, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramd.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramd.akM, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramd.akN, false);
    com.google.android.gms.common.internal.safeparcel.b.b(paramParcel, 4, paramd.akO, false);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public d cl(Parcel paramParcel)
  {
    String str2 = null;
    int k = a.B(paramParcel);
    int j = 0;
    ArrayList localArrayList = ih.fV();
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new d(j, str1, str2, localArrayList);
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
        j = a.g(paramParcel, i);
        break;
      case 2: 
        str1 = a.o(paramParcel, i);
        break;
      case 3: 
        str2 = a.o(paramParcel, i);
        break;
      case 4: 
        localArrayList = a.c(paramParcel, i, b.CREATOR);
      }
    }
  }
  
  public d[] dT(int paramInt)
  {
    return new d[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.e
 * JD-Core Version:    0.7.0.1
 */