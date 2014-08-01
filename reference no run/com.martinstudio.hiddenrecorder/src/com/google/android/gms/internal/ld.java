package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class ld
  implements Parcelable.Creator<kt.h>
{
  static void a(kt.h paramh, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = paramh.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramh.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.c(paramParcel, 3, paramh.kS());
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramh.getValue(), true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramh.getLabel(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.c(paramParcel, 6, paramh.getType());
    }
    b.G(paramParcel, i);
  }
  
  public kt.h bP(Parcel paramParcel)
  {
    String str2 = null;
    int j = 0;
    int n = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    int i = 0;
    String str1 = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= n)
      {
        if (paramParcel.dataPosition() == n) {
          return new kt.h(localHashSet, m, str1, i, str2, j);
        }
        throw new a.a("Overread allowed size end=" + n, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      case 2: 
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        m = a.g(paramParcel, k);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 3: 
        j = a.g(paramParcel, k);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        str2 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str1 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        i = a.g(paramParcel, k);
        localHashSet.add(Integer.valueOf(6));
      }
    }
  }
  
  public kt.h[] dm(int paramInt)
  {
    return new kt.h[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ld
 * JD-Core Version:    0.7.0.1
 */