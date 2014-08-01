package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class lb
  implements Parcelable.Creator<kt.f>
{
  static void a(kt.f paramf, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = paramf.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramf.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramf.getDepartment(), true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramf.getDescription(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramf.getEndDate(), true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramf.getLocation(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.a(paramParcel, 6, paramf.getName(), true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, paramf.isPrimary());
    }
    if (localSet.contains(Integer.valueOf(8))) {
      b.a(paramParcel, 8, paramf.getStartDate(), true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      b.a(paramParcel, 9, paramf.getTitle(), true);
    }
    if (localSet.contains(Integer.valueOf(10))) {
      b.c(paramParcel, 10, paramf.getType());
    }
    b.G(paramParcel, i);
  }
  
  public kt.f bN(Parcel paramParcel)
  {
    int m = 0;
    String str1 = null;
    int j = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    String str4 = null;
    boolean bool = false;
    String str3 = null;
    String str2 = null;
    String str7 = null;
    String str5 = null;
    String str6 = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new kt.f(localHashSet, k, str6, str5, str7, str2, str3, bool, str4, str1, m);
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str6 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        str5 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        str7 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str2 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        str3 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        bool = a.c(paramParcel, i);
        localHashSet.add(Integer.valueOf(7));
        break;
      case 8: 
        str4 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9: 
        str1 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 10: 
        m = a.g(paramParcel, i);
        localHashSet.add(Integer.valueOf(10));
      }
    }
  }
  
  public kt.f[] dk(int paramInt)
  {
    return new kt.f[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lb
 * JD-Core Version:    0.7.0.1
 */