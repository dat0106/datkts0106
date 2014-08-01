package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.model.CameraPosition;

public class GoogleMapOptionsCreator
  implements Parcelable.Creator<GoogleMapOptions>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(GoogleMapOptions paramGoogleMapOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramGoogleMapOptions.getVersionCode());
    b.a(paramParcel, 2, paramGoogleMapOptions.jl());
    b.a(paramParcel, 3, paramGoogleMapOptions.jm());
    b.c(paramParcel, 4, paramGoogleMapOptions.getMapType());
    b.a(paramParcel, 5, paramGoogleMapOptions.getCamera(), paramInt, false);
    b.a(paramParcel, 6, paramGoogleMapOptions.jn());
    b.a(paramParcel, 7, paramGoogleMapOptions.jo());
    b.a(paramParcel, 8, paramGoogleMapOptions.jp());
    b.a(paramParcel, 9, paramGoogleMapOptions.jq());
    b.a(paramParcel, 10, paramGoogleMapOptions.jr());
    b.a(paramParcel, 11, paramGoogleMapOptions.js());
    b.G(paramParcel, i);
  }
  
  public GoogleMapOptions createFromParcel(Parcel paramParcel)
  {
    byte b2 = 0;
    int j = a.B(paramParcel);
    CameraPosition localCameraPosition = null;
    byte b1 = 0;
    byte b5 = 0;
    byte b6 = 0;
    byte b3 = 0;
    byte b7 = 0;
    int k = 0;
    byte b8 = 0;
    byte b4 = 0;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new GoogleMapOptions(m, b4, b8, k, localCameraPosition, b7, b3, b6, b5, b1, b2);
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
        m = a.g(paramParcel, i);
        break;
      case 2: 
        b4 = a.e(paramParcel, i);
        break;
      case 3: 
        b8 = a.e(paramParcel, i);
        break;
      case 4: 
        k = a.g(paramParcel, i);
        break;
      case 5: 
        localCameraPosition = (CameraPosition)a.a(paramParcel, i, CameraPosition.CREATOR);
        break;
      case 6: 
        b7 = a.e(paramParcel, i);
        break;
      case 7: 
        b3 = a.e(paramParcel, i);
        break;
      case 8: 
        b6 = a.e(paramParcel, i);
        break;
      case 9: 
        b5 = a.e(paramParcel, i);
        break;
      case 10: 
        b1 = a.e(paramParcel, i);
        break;
      case 11: 
        b2 = a.e(paramParcel, i);
      }
    }
  }
  
  public GoogleMapOptions[] newArray(int paramInt)
  {
    return new GoogleMapOptions[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.GoogleMapOptionsCreator
 * JD-Core Version:    0.7.0.1
 */