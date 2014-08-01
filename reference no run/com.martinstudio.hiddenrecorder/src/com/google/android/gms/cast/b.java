package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import java.util.List;

public class b
  implements Parcelable.Creator<CastDevice>
{
  static void a(CastDevice paramCastDevice, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramCastDevice.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramCastDevice.getDeviceId(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramCastDevice.Af, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 4, paramCastDevice.getFriendlyName(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 5, paramCastDevice.getModelName(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 6, paramCastDevice.getDeviceVersion(), false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 7, paramCastDevice.getServicePort());
    com.google.android.gms.common.internal.safeparcel.b.b(paramParcel, 8, paramCastDevice.getIcons(), false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 9, paramCastDevice.getCapabilities());
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public CastDevice[] P(int paramInt)
  {
    return new CastDevice[paramInt];
  }
  
  public CastDevice s(Parcel paramParcel)
  {
    int j = 0;
    Object localObject = null;
    int i = a.B(paramParcel);
    int k = 0;
    String str4 = null;
    String str2 = null;
    String str1 = null;
    String str5 = null;
    String str3 = null;
    int n = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new CastDevice(n, str3, str5, str1, str2, str4, k, (List)localObject, j);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        n = a.g(paramParcel, m);
        break;
      case 2: 
        str3 = a.o(paramParcel, m);
        break;
      case 3: 
        str5 = a.o(paramParcel, m);
        break;
      case 4: 
        str1 = a.o(paramParcel, m);
        break;
      case 5: 
        str2 = a.o(paramParcel, m);
        break;
      case 6: 
        str4 = a.o(paramParcel, m);
        break;
      case 7: 
        k = a.g(paramParcel, m);
        break;
      case 8: 
        localObject = a.c(paramParcel, m, WebImage.CREATOR);
        break;
      case 9: 
        j = a.g(paramParcel, m);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.b
 * JD-Core Version:    0.7.0.1
 */