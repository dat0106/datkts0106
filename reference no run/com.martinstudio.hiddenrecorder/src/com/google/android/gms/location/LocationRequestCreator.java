package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class LocationRequestCreator
  implements Parcelable.Creator<LocationRequest>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(LocationRequest paramLocationRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramLocationRequest.mPriority);
    b.c(paramParcel, 1000, paramLocationRequest.getVersionCode());
    b.a(paramParcel, 2, paramLocationRequest.Vi);
    b.a(paramParcel, 3, paramLocationRequest.Vj);
    b.a(paramParcel, 4, paramLocationRequest.Vk);
    b.a(paramParcel, 5, paramLocationRequest.UY);
    b.c(paramParcel, 6, paramLocationRequest.Vl);
    b.a(paramParcel, 7, paramLocationRequest.Vm);
    b.G(paramParcel, i);
  }
  
  public LocationRequest createFromParcel(Parcel paramParcel)
  {
    boolean bool = false;
    int j = a.B(paramParcel);
    int n = 102;
    long l2 = 3600000L;
    long l3 = 600000L;
    long l1 = 9223372036854775807L;
    int i = 2147483647;
    float f = 0.0F;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new LocationRequest(k, n, l2, l3, bool, l1, i, f);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
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
        l2 = a.i(paramParcel, m);
        break;
      case 3: 
        l3 = a.i(paramParcel, m);
        break;
      case 4: 
        bool = a.c(paramParcel, m);
        break;
      case 5: 
        l1 = a.i(paramParcel, m);
        break;
      case 6: 
        i = a.g(paramParcel, m);
        break;
      case 7: 
        f = a.l(paramParcel, m);
        break;
      case 1000: 
        k = a.g(paramParcel, m);
      }
    }
  }
  
  public LocationRequest[] newArray(int paramInt)
  {
    return new LocationRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationRequestCreator
 * JD-Core Version:    0.7.0.1
 */