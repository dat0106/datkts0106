package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class CircleOptionsCreator
  implements Parcelable.Creator<CircleOptions>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(CircleOptions paramCircleOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCircleOptions.getVersionCode());
    b.a(paramParcel, 2, paramCircleOptions.getCenter(), paramInt, false);
    b.a(paramParcel, 3, paramCircleOptions.getRadius());
    b.a(paramParcel, 4, paramCircleOptions.getStrokeWidth());
    b.c(paramParcel, 5, paramCircleOptions.getStrokeColor());
    b.c(paramParcel, 6, paramCircleOptions.getFillColor());
    b.a(paramParcel, 7, paramCircleOptions.getZIndex());
    b.a(paramParcel, 8, paramCircleOptions.isVisible());
    b.G(paramParcel, i);
  }
  
  public CircleOptions createFromParcel(Parcel paramParcel)
  {
    float f1 = 0.0F;
    boolean bool = false;
    int m = a.B(paramParcel);
    LatLng localLatLng = null;
    double d = 0.0D;
    int j = 0;
    int i = 0;
    float f2 = 0.0F;
    int n = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new CircleOptions(n, localLatLng, d, f2, i, j, f1, bool);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        n = a.g(paramParcel, k);
        break;
      case 2: 
        localLatLng = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 3: 
        d = a.m(paramParcel, k);
        break;
      case 4: 
        f2 = a.l(paramParcel, k);
        break;
      case 5: 
        i = a.g(paramParcel, k);
        break;
      case 6: 
        j = a.g(paramParcel, k);
        break;
      case 7: 
        f1 = a.l(paramParcel, k);
        break;
      case 8: 
        bool = a.c(paramParcel, k);
      }
    }
  }
  
  public CircleOptions[] newArray(int paramInt)
  {
    return new CircleOptions[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.CircleOptionsCreator
 * JD-Core Version:    0.7.0.1
 */