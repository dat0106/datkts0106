package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class kz
  implements Parcelable.Creator<kt.c>
{
  static void a(kt.c paramc, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = paramc.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramc.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramc.getUrl(), true);
    }
    b.G(paramParcel, i);
  }
  
  public kt.c bL(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    String str = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new kt.c(localHashSet, j, str);
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(2));
      }
    }
  }
  
  public kt.c[] di(int paramInt)
  {
    return new kt.c[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kz
 * JD-Core Version:    0.7.0.1
 */