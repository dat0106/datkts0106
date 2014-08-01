package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class at
  implements Parcelable.Creator<as>
{
  static void a(as paramas, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramas.versionCode);
    b.c(paramParcel, 2, paramas.statusCode);
    b.a(paramParcel, 3, paramas.alY);
    b.b(paramParcel, 4, paramas.ama, false);
    b.G(paramParcel, i);
  }
  
  public as cK(Parcel paramParcel)
  {
    int j = 0;
    int i = a.B(paramParcel);
    long l = 0L;
    Object localObject = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new as(m, j, l, (List)localObject);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        m = a.g(paramParcel, k);
        break;
      case 2: 
        j = a.g(paramParcel, k);
        break;
      case 3: 
        l = a.i(paramParcel, k);
        break;
      case 4: 
        localObject = a.c(paramParcel, k, ak.CREATOR);
      }
    }
  }
  
  public as[] et(int paramInt)
  {
    return new as[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.at
 * JD-Core Version:    0.7.0.1
 */