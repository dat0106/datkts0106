package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class StreetViewPanoramaOrientationCreator
  implements Parcelable.Creator<StreetViewPanoramaOrientation>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramStreetViewPanoramaOrientation.getVersionCode());
    b.a(paramParcel, 2, paramStreetViewPanoramaOrientation.tilt);
    b.a(paramParcel, 3, paramStreetViewPanoramaOrientation.bearing);
    b.G(paramParcel, i);
  }
  
  public StreetViewPanoramaOrientation createFromParcel(Parcel paramParcel)
  {
    float f2 = 0.0F;
    int j = a.B(paramParcel);
    int i = 0;
    float f1 = 0.0F;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new StreetViewPanoramaOrientation(i, f1, f2);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        f1 = a.l(paramParcel, k);
        break;
      case 3: 
        f2 = a.l(paramParcel, k);
      }
    }
  }
  
  public StreetViewPanoramaOrientation[] newArray(int paramInt)
  {
    return new StreetViewPanoramaOrientation[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaOrientationCreator
 * JD-Core Version:    0.7.0.1
 */