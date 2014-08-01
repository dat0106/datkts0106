package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class kx
  implements Parcelable.Creator<kt.b.a>
{
  static void a(kt.b.a parama, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = parama.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, parama.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.c(paramParcel, 2, parama.getLeftImageOffset());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.c(paramParcel, 3, parama.getTopImageOffset());
    }
    b.G(paramParcel, i);
  }
  
  public kt.b.a bJ(Parcel paramParcel)
  {
    int m = 0;
    int i = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    int k = 0;
    int n = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new kt.b.a(localHashSet, n, k, m);
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
        n = a.g(paramParcel, j);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        k = a.g(paramParcel, j);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        m = a.g(paramParcel, j);
        localHashSet.add(Integer.valueOf(3));
      }
    }
  }
  
  public kt.b.a[] dg(int paramInt)
  {
    return new kt.b.a[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kx
 * JD-Core Version:    0.7.0.1
 */