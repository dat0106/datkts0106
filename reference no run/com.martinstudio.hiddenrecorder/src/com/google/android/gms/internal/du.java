package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class du
  implements Parcelable.Creator<dt>
{
  static void a(dt paramdt, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramdt.versionCode);
    b.a(paramParcel, 2, paramdt.pU, false);
    b.a(paramParcel, 3, paramdt.pV, paramInt, false);
    b.a(paramParcel, 4, paramdt.kR, paramInt, false);
    b.a(paramParcel, 5, paramdt.kL, false);
    b.a(paramParcel, 6, paramdt.applicationInfo, paramInt, false);
    b.a(paramParcel, 7, paramdt.pW, paramInt, false);
    b.a(paramParcel, 8, paramdt.pX, false);
    b.a(paramParcel, 9, paramdt.pY, false);
    b.a(paramParcel, 10, paramdt.pZ, false);
    b.a(paramParcel, 11, paramdt.kO, paramInt, false);
    b.a(paramParcel, 12, paramdt.qa, false);
    b.G(paramParcel, i);
  }
  
  public dt h(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    Bundle localBundle1 = null;
    aj localaj = null;
    am localam = null;
    String str1 = null;
    ApplicationInfo localApplicationInfo = null;
    PackageInfo localPackageInfo = null;
    String str2 = null;
    String str4 = null;
    String str3 = null;
    ew localew = null;
    Bundle localBundle2 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new dt(i, localBundle1, localaj, localam, str1, localApplicationInfo, localPackageInfo, str2, str4, str3, localew, localBundle2);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localBundle1 = a.q(paramParcel, k);
        break;
      case 3: 
        localaj = (aj)a.a(paramParcel, k, aj.CREATOR);
        break;
      case 4: 
        localam = (am)a.a(paramParcel, k, am.CREATOR);
        break;
      case 5: 
        str1 = a.o(paramParcel, k);
        break;
      case 6: 
        localApplicationInfo = (ApplicationInfo)a.a(paramParcel, k, ApplicationInfo.CREATOR);
        break;
      case 7: 
        localPackageInfo = (PackageInfo)a.a(paramParcel, k, PackageInfo.CREATOR);
        break;
      case 8: 
        str2 = a.o(paramParcel, k);
        break;
      case 9: 
        str4 = a.o(paramParcel, k);
        break;
      case 10: 
        str3 = a.o(paramParcel, k);
        break;
      case 11: 
        localew = (ew)a.a(paramParcel, k, ew.CREATOR);
        break;
      case 12: 
        localBundle2 = a.q(paramParcel, k);
      }
    }
  }
  
  public dt[] m(int paramInt)
  {
    return new dt[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.du
 * JD-Core Version:    0.7.0.1
 */