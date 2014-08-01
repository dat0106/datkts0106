package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class CameraPositionCreator
  implements Parcelable.Creator<CameraPosition>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(CameraPosition paramCameraPosition, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCameraPosition.getVersionCode());
    b.a(paramParcel, 2, paramCameraPosition.target, paramInt, false);
    b.a(paramParcel, 3, paramCameraPosition.zoom);
    b.a(paramParcel, 4, paramCameraPosition.tilt);
    b.a(paramParcel, 5, paramCameraPosition.bearing);
    b.G(paramParcel, i);
  }
  
  public CameraPosition createFromParcel(Parcel paramParcel)
  {
    float f3 = 0.0F;
    int j = a.B(paramParcel);
    int i = 0;
    LatLng localLatLng = null;
    float f2 = 0.0F;
    float f1 = 0.0F;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new CameraPosition(i, localLatLng, f1, f2, f3);
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
        localLatLng = (LatLng)a.a(paramParcel, k, LatLng.CREATOR);
        break;
      case 3: 
        f1 = a.l(paramParcel, k);
        break;
      case 4: 
        f2 = a.l(paramParcel, k);
        break;
      case 5: 
        f3 = a.l(paramParcel, k);
      }
    }
  }
  
  public CameraPosition[] newArray(int paramInt)
  {
    return new CameraPosition[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.CameraPositionCreator
 * JD-Core Version:    0.7.0.1
 */