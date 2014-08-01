package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class u
  implements Parcelable.Creator<t>
{
  static void a(t paramt, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramt.versionCode);
    b.c(paramParcel, 2, paramt.statusCode);
    b.b(paramParcel, 3, paramt.alK, false);
    b.G(paramParcel, i);
  }
  
  public t cA(Parcel paramParcel)
  {
    int j = 0;
    int m = a.B(paramParcel);
    Object localObject = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new t(k, j, (List)localObject);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        k = a.g(paramParcel, i);
        break;
      case 2: 
        j = a.g(paramParcel, i);
        break;
      case 3: 
        localObject = a.c(paramParcel, i, ai.CREATOR);
      }
    }
  }
  
  public t[] ej(int paramInt)
  {
    return new t[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.u
 * JD-Core Version:    0.7.0.1
 */