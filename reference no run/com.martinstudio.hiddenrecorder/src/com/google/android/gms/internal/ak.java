package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class ak
  implements Parcelable.Creator<aj>
{
  static void a(aj paramaj, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramaj.versionCode);
    b.a(paramParcel, 2, paramaj.lQ);
    b.a(paramParcel, 3, paramaj.extras, false);
    b.c(paramParcel, 4, paramaj.lR);
    b.a(paramParcel, 5, paramaj.lS, false);
    b.a(paramParcel, 6, paramaj.lT);
    b.c(paramParcel, 7, paramaj.lU);
    b.a(paramParcel, 8, paramaj.lV);
    b.a(paramParcel, 9, paramaj.lW, false);
    b.a(paramParcel, 10, paramaj.lX, paramInt, false);
    b.a(paramParcel, 11, paramaj.lY, paramInt, false);
    b.a(paramParcel, 12, paramaj.lZ, false);
    b.a(paramParcel, 13, paramaj.ma, false);
    b.G(paramParcel, i);
  }
  
  public aj b(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    long l = 0L;
    Bundle localBundle2 = null;
    int m = 0;
    Object localObject = null;
    boolean bool1 = false;
    int n = 0;
    boolean bool2 = false;
    String str2 = null;
    ax localax = null;
    Location localLocation = null;
    String str1 = null;
    Bundle localBundle1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new aj(i, l, localBundle2, m, (List)localObject, bool1, n, bool2, str2, localax, localLocation, str1, localBundle1);
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
        l = a.i(paramParcel, k);
        break;
      case 3: 
        localBundle2 = a.q(paramParcel, k);
        break;
      case 4: 
        m = a.g(paramParcel, k);
        break;
      case 5: 
        localObject = a.B(paramParcel, k);
        break;
      case 6: 
        bool1 = a.c(paramParcel, k);
        break;
      case 7: 
        n = a.g(paramParcel, k);
        break;
      case 8: 
        bool2 = a.c(paramParcel, k);
        break;
      case 9: 
        str2 = a.o(paramParcel, k);
        break;
      case 10: 
        localax = (ax)a.a(paramParcel, k, ax.CREATOR);
        break;
      case 11: 
        localLocation = (Location)a.a(paramParcel, k, Location.CREATOR);
        break;
      case 12: 
        str1 = a.o(paramParcel, k);
        break;
      case 13: 
        localBundle1 = a.q(paramParcel, k);
      }
    }
  }
  
  public aj[] c(int paramInt)
  {
    return new aj[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ak
 * JD-Core Version:    0.7.0.1
 */