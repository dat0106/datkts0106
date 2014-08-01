package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class hm
  implements Parcelable.Creator<gz.a>
{
  static void a(gz.a parama, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, parama.getAccountName(), false);
    b.c(paramParcel, 1000, parama.getVersionCode());
    b.a(paramParcel, 2, parama.fg(), false);
    b.c(paramParcel, 3, parama.ff());
    b.a(paramParcel, 4, parama.fi(), false);
    b.G(paramParcel, i);
  }
  
  public gz.a[] aq(int paramInt)
  {
    return new gz.a[paramInt];
  }
  
  public gz.a z(Parcel paramParcel)
  {
    int j = 0;
    String str2 = null;
    int k = a.B(paramParcel);
    Object localObject = null;
    String str1 = null;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new gz.a(i, str1, (List)localObject, j, str2);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str1 = a.o(paramParcel, m);
        break;
      case 2: 
        localObject = a.B(paramParcel, m);
        break;
      case 3: 
        j = a.g(paramParcel, m);
        break;
      case 4: 
        str2 = a.o(paramParcel, m);
        break;
      case 1000: 
        i = a.g(paramParcel, m);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hm
 * JD-Core Version:    0.7.0.1
 */