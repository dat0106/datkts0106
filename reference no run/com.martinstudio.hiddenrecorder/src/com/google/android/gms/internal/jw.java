package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class jw
  implements Parcelable.Creator<jv>
{
  static void a(jv paramjv, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramjv.getName(), false);
    b.c(paramParcel, 1000, paramjv.xJ);
    b.a(paramParcel, 2, paramjv.jf(), paramInt, false);
    b.a(paramParcel, 3, paramjv.getAddress(), false);
    b.b(paramParcel, 4, paramjv.jg(), false);
    b.a(paramParcel, 5, paramjv.getPhoneNumber(), false);
    b.a(paramParcel, 6, paramjv.jh(), false);
    b.G(paramParcel, i);
  }
  
  public jv bz(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.B(paramParcel);
    int k = 0;
    String str4 = null;
    Object localObject = null;
    String str1 = null;
    LatLng localLatLng = null;
    String str3 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new jv(k, str3, localLatLng, str1, (List)localObject, str4, str2);
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
        str3 = a.o(paramParcel, i);
        break;
      case 2: 
        localLatLng = (LatLng)a.a(paramParcel, i, LatLng.CREATOR);
        break;
      case 3: 
        str1 = a.o(paramParcel, i);
        break;
      case 4: 
        localObject = a.c(paramParcel, i, jt.CREATOR);
        break;
      case 5: 
        str4 = a.o(paramParcel, i);
        break;
      case 6: 
        str2 = a.o(paramParcel, i);
        break;
      case 1000: 
        k = a.g(paramParcel, i);
      }
    }
  }
  
  public jv[] cU(int paramInt)
  {
    return new jv[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jw
 * JD-Core Version:    0.7.0.1
 */