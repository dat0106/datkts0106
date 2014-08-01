package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class ky
  implements Parcelable.Creator<kt.b.b>
{
  static void a(kt.b.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = paramb.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramb.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.c(paramParcel, 2, paramb.getHeight());
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramb.getUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.c(paramParcel, 4, paramb.getWidth());
    }
    b.G(paramParcel, i);
  }
  
  public kt.b.b bK(Parcel paramParcel)
  {
    int j = 0;
    int i = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
    int k = 0;
    int n = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new kt.b.b(localHashSet, n, k, str, j);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        n = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        k = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        str = a.o(paramParcel, m);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        j = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(4));
      }
    }
  }
  
  public kt.b.b[] dh(int paramInt)
  {
    return new kt.b.b[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ky
 * JD-Core Version:    0.7.0.1
 */