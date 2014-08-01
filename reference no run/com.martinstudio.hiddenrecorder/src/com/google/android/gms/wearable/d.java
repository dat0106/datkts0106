package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
  implements Parcelable.Creator<c>
{
  static void a(c paramc, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramc.xJ);
    b.a(paramParcel, 2, paramc.getName(), false);
    b.a(paramParcel, 3, paramc.getAddress(), false);
    b.c(paramParcel, 4, paramc.getType());
    b.c(paramParcel, 5, paramc.getRole());
    b.a(paramParcel, 6, paramc.isEnabled());
    b.G(paramParcel, i);
  }
  
  public c ct(Parcel paramParcel)
  {
    String str2 = null;
    boolean bool = false;
    int n = a.B(paramParcel);
    int i = 0;
    int j = 0;
    String str1 = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= n)
      {
        if (paramParcel.dataPosition() == n) {
          return new c(m, str1, str2, j, i, bool);
        }
        throw new a.a("Overread allowed size end=" + n, paramParcel);
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
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
        break;
      case 4: 
        j = a.g(paramParcel, k);
        break;
      case 5: 
        i = a.g(paramParcel, k);
        break;
      case 6: 
        bool = a.c(paramParcel, k);
      }
    }
  }
  
  public c[] eb(int paramInt)
  {
    return new c[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.d
 * JD-Core Version:    0.7.0.1
 */