package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ku
  implements Parcelable.Creator<kt>
{
  static void a(kt paramkt, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    Set localSet = paramkt.kf();
    if (localSet.contains(Integer.valueOf(1))) {
      b.c(paramParcel, 1, paramkt.getVersionCode());
    }
    if (localSet.contains(Integer.valueOf(2))) {
      b.a(paramParcel, 2, paramkt.getAboutMe(), true);
    }
    if (localSet.contains(Integer.valueOf(3))) {
      b.a(paramParcel, 3, paramkt.kA(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(4))) {
      b.a(paramParcel, 4, paramkt.getBirthday(), true);
    }
    if (localSet.contains(Integer.valueOf(5))) {
      b.a(paramParcel, 5, paramkt.getBraggingRights(), true);
    }
    if (localSet.contains(Integer.valueOf(6))) {
      b.c(paramParcel, 6, paramkt.getCircledByCount());
    }
    if (localSet.contains(Integer.valueOf(7))) {
      b.a(paramParcel, 7, paramkt.kB(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(8))) {
      b.a(paramParcel, 8, paramkt.getCurrentLocation(), true);
    }
    if (localSet.contains(Integer.valueOf(9))) {
      b.a(paramParcel, 9, paramkt.getDisplayName(), true);
    }
    if (localSet.contains(Integer.valueOf(12))) {
      b.c(paramParcel, 12, paramkt.getGender());
    }
    if (localSet.contains(Integer.valueOf(14))) {
      b.a(paramParcel, 14, paramkt.getId(), true);
    }
    if (localSet.contains(Integer.valueOf(15))) {
      b.a(paramParcel, 15, paramkt.kC(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(16))) {
      b.a(paramParcel, 16, paramkt.isPlusUser());
    }
    if (localSet.contains(Integer.valueOf(19))) {
      b.a(paramParcel, 19, paramkt.kD(), paramInt, true);
    }
    if (localSet.contains(Integer.valueOf(18))) {
      b.a(paramParcel, 18, paramkt.getLanguage(), true);
    }
    if (localSet.contains(Integer.valueOf(21))) {
      b.c(paramParcel, 21, paramkt.getObjectType());
    }
    if (localSet.contains(Integer.valueOf(20))) {
      b.a(paramParcel, 20, paramkt.getNickname(), true);
    }
    if (localSet.contains(Integer.valueOf(23))) {
      b.b(paramParcel, 23, paramkt.kF(), true);
    }
    if (localSet.contains(Integer.valueOf(22))) {
      b.b(paramParcel, 22, paramkt.kE(), true);
    }
    if (localSet.contains(Integer.valueOf(25))) {
      b.c(paramParcel, 25, paramkt.getRelationshipStatus());
    }
    if (localSet.contains(Integer.valueOf(24))) {
      b.c(paramParcel, 24, paramkt.getPlusOneCount());
    }
    if (localSet.contains(Integer.valueOf(27))) {
      b.a(paramParcel, 27, paramkt.getUrl(), true);
    }
    if (localSet.contains(Integer.valueOf(26))) {
      b.a(paramParcel, 26, paramkt.getTagline(), true);
    }
    if (localSet.contains(Integer.valueOf(29))) {
      b.a(paramParcel, 29, paramkt.isVerified());
    }
    if (localSet.contains(Integer.valueOf(28))) {
      b.b(paramParcel, 28, paramkt.kG(), true);
    }
    b.G(paramParcel, i);
  }
  
  public kt bG(Parcel paramParcel)
  {
    int i2 = a.B(paramParcel);
    HashSet localHashSet = new HashSet();
    int k = 0;
    String str9 = null;
    kt.a locala = null;
    String str5 = null;
    String str3 = null;
    int i1 = 0;
    kt.b localb = null;
    String str10 = null;
    String str7 = null;
    int m = 0;
    String str6 = null;
    kt.c localc = null;
    boolean bool2 = false;
    String str2 = null;
    kt.d locald = null;
    String str4 = null;
    int i = 0;
    Object localObject1 = null;
    Object localObject3 = null;
    int n = 0;
    int j = 0;
    String str8 = null;
    String str1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i2)
      {
        if (paramParcel.dataPosition() == i2) {
          return new kt(localHashSet, k, str9, locala, str5, str3, i1, localb, str10, str7, m, str6, localc, bool2, str2, locald, str4, i, (List)localObject1, (List)localObject3, n, j, str8, str1, (List)localObject2, bool1);
        }
        throw new a.a("Overread allowed size end=" + i2, paramParcel);
      }
      int i3 = a.A(paramParcel);
      switch (a.ar(i3))
      {
      case 10: 
      case 11: 
      case 13: 
      case 17: 
      default: 
        a.b(paramParcel, i3);
        break;
      case 1: 
        k = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2: 
        str9 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3: 
        locala = (kt.a)a.a(paramParcel, i3, kt.a.CREATOR);
        localHashSet.add(Integer.valueOf(3));
        locala = locala;
        break;
      case 4: 
        str5 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(4));
        break;
      case 5: 
        str3 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6: 
        i1 = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(6));
        break;
      case 7: 
        localb = (kt.b)a.a(paramParcel, i3, kt.b.CREATOR);
        localHashSet.add(Integer.valueOf(7));
        localb = localb;
        break;
      case 8: 
        str10 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(8));
        break;
      case 9: 
        str7 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(9));
        break;
      case 12: 
        m = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(12));
        break;
      case 14: 
        str6 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(14));
        break;
      case 15: 
        localc = (kt.c)a.a(paramParcel, i3, kt.c.CREATOR);
        localHashSet.add(Integer.valueOf(15));
        localc = localc;
        break;
      case 16: 
        bool2 = a.c(paramParcel, i3);
        localHashSet.add(Integer.valueOf(16));
        break;
      case 18: 
        str2 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(18));
        break;
      case 19: 
        locald = (kt.d)a.a(paramParcel, i3, kt.d.CREATOR);
        localHashSet.add(Integer.valueOf(19));
        locald = locald;
        break;
      case 20: 
        str4 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(20));
        break;
      case 21: 
        i = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(21));
        break;
      case 22: 
        localObject1 = a.c(paramParcel, i3, kt.f.CREATOR);
        localHashSet.add(Integer.valueOf(22));
        break;
      case 23: 
        localObject3 = a.c(paramParcel, i3, kt.g.CREATOR);
        localHashSet.add(Integer.valueOf(23));
        break;
      case 24: 
        n = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(24));
        break;
      case 25: 
        j = a.g(paramParcel, i3);
        localHashSet.add(Integer.valueOf(25));
        break;
      case 26: 
        str8 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(26));
        break;
      case 27: 
        str1 = a.o(paramParcel, i3);
        localHashSet.add(Integer.valueOf(27));
        break;
      case 28: 
        localObject2 = a.c(paramParcel, i3, kt.h.CREATOR);
        localHashSet.add(Integer.valueOf(28));
        break;
      case 29: 
        bool1 = a.c(paramParcel, i3);
        localHashSet.add(Integer.valueOf(29));
      }
    }
  }
  
  public kt[] dd(int paramInt)
  {
    return new kt[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ku
 * JD-Core Version:    0.7.0.1
 */