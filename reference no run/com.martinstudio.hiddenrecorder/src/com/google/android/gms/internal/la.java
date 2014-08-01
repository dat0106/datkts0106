package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class la
  implements Parcelable.Creator<kt.d>
{
  static void a(kt.d paramd, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = paramd.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramd.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramd.getFamilyName(), true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramd.getFormatted(), true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramd.getGivenName(), true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramd.getHonorificPrefix(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.a(paramParcel, 6, paramd.getHonorificSuffix(), true);
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, paramd.getMiddleName(), true);
    }
    b.G(paramParcel, i);
  }
  
  public kt.d bM(Parcel paramParcel)
  {
    String str1 = null;
    int k = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str6 = null;
    String str5 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new kt.d(localHashSet, j, str5, str6, str4, str3, str2, str1);
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
        str5 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        str6 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(3));
        break;
      case 4: 
        str4 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str3 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        str2 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        str1 = a.o(paramParcel, i);
        localHashSet.add(Integer.valueOf(7));
      }
    }
  }
  
  public kt.d[] dj(int paramInt)
  {
    return new kt.d[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.la
 * JD-Core Version:    0.7.0.1
 */