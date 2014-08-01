package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class lc
  implements Parcelable.Creator<kt.g>
{
  static void a(kt.g paramg, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = paramg.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramg.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramg.isPrimary());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramg.getValue(), true);
    }
    b.G(paramParcel, i);
  }
  
  public kt.g bO(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new kt.g(localHashSet, k, bool, str);
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
        k = a.g(paramParcel, j);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        bool = a.c(paramParcel, j);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        str = a.o(paramParcel, j);
        localHashSet.add(Integer.valueOf(3));
      }
    }
  }
  
  public kt.g[] dl(int paramInt)
  {
    return new kt.g[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lc
 * JD-Core Version:    0.7.0.1
 */