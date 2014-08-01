package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class al
  implements Parcelable.Creator<ak>
{
  static void a(ak paramak, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramak.versionCode);
    b.a(paramParcel, 2, paramak.packageName, false);
    b.a(paramParcel, 3, paramak.label, false);
    b.a(paramParcel, 4, paramak.alY);
    b.G(paramParcel, i);
  }
  
  public ak cG(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.B(paramParcel);
    int k = 0;
    long l = 0L;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new ak(k, str1, str2, l);
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
        break;
      case 2: 
        str1 = a.o(paramParcel, i);
        break;
      case 3: 
        str2 = a.o(paramParcel, i);
        break;
      case 4: 
        l = a.i(paramParcel, i);
      }
    }
  }
  
  public ak[] ep(int paramInt)
  {
    return new ak[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.al
 * JD-Core Version:    0.7.0.1
 */