package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ar
  implements Parcelable.Creator<aq>
{
  static void a(aq paramaq, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramaq.versionCode);
    b.c(paramParcel, 2, paramaq.statusCode);
    b.c(paramParcel, 3, paramaq.alZ);
    b.G(paramParcel, i);
  }
  
  public aq cJ(Parcel paramParcel)
  {
    int i = 0;
    int n = a.B(paramParcel);
    int k = 0;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= n)
      {
        if (paramParcel.dataPosition() == n) {
          return new aq(m, k, i);
        }
        throw new a.a("Overread allowed size end=" + n, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        m = a.g(paramParcel, j);
        break;
      case 2: 
        k = a.g(paramParcel, j);
        break;
      case 3: 
        i = a.g(paramParcel, j);
      }
    }
  }
  
  public aq[] es(int paramInt)
  {
    return new aq[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ar
 * JD-Core Version:    0.7.0.1
 */