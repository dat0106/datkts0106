package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class LatLngCreator
  implements Parcelable.Creator<LatLng>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(LatLng paramLatLng, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramLatLng.getVersionCode());
    b.a(paramParcel, 2, paramLatLng.latitude);
    b.a(paramParcel, 3, paramLatLng.longitude);
    b.G(paramParcel, i);
  }
  
  public LatLng createFromParcel(Parcel paramParcel)
  {
    double d1 = 0.0D;
    int j = a.B(paramParcel);
    int k = 0;
    double d2 = d1;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new LatLng(k, d2, d1);
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
        d2 = a.m(paramParcel, i);
        break;
      case 3: 
        d1 = a.m(paramParcel, i);
      }
    }
  }
  
  public LatLng[] newArray(int paramInt)
  {
    return new LatLng[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.LatLngCreator
 * JD-Core Version:    0.7.0.1
 */