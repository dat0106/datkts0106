package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class ie
  implements Parcelable.Creator<ic.a>
{
  static void a(ic.a parama, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, parama.versionCode);
    b.a(paramParcel, 2, parama.className, false);
    b.b(paramParcel, 3, parama.Hl, false);
    b.G(paramParcel, i);
  }
  
  public ic.a K(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int i = a.B(paramParcel);
    int j = 0;
    String str = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new ic.a(j, str, localArrayList);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        str = a.o(paramParcel, k);
        break;
      case 3: 
        localArrayList = a.c(paramParcel, k, ic.b.CREATOR);
      }
    }
  }
  
  public ic.a[] az(int paramInt)
  {
    return new ic.a[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ie
 * JD-Core Version:    0.7.0.1
 */