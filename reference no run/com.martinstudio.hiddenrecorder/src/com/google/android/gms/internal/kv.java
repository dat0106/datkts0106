package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class kv
  implements Parcelable.Creator<kt.a>
{
  static void a(kt.a parama, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = parama.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, parama.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.c(paramParcel, 2, parama.getMax());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.c(paramParcel, 3, parama.getMin());
    }
    b.G(paramParcel, i);
  }
  
  public kt.a bH(Parcel paramParcel)
  {
    int k = 0;
    int j = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    int n = 0;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new kt.a(localHashSet, i, n, k);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        i = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        n = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        k = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(3));
      }
    }
  }
  
  public kt.a[] de(int paramInt)
  {
    return new kt.a[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kv
 * JD-Core Version:    0.7.0.1
 */