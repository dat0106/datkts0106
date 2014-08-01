package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class MarkerOptionsCreator
  implements Parcelable.Creator<MarkerOptions>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(MarkerOptions paramMarkerOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramMarkerOptions.getVersionCode());
    b.a(paramParcel, 2, paramMarkerOptions.getPosition(), paramInt, false);
    b.a(paramParcel, 3, paramMarkerOptions.getTitle(), false);
    b.a(paramParcel, 4, paramMarkerOptions.getSnippet(), false);
    b.a(paramParcel, 5, paramMarkerOptions.jJ(), false);
    b.a(paramParcel, 6, paramMarkerOptions.getAnchorU());
    b.a(paramParcel, 7, paramMarkerOptions.getAnchorV());
    b.a(paramParcel, 8, paramMarkerOptions.isDraggable());
    b.a(paramParcel, 9, paramMarkerOptions.isVisible());
    b.a(paramParcel, 10, paramMarkerOptions.isFlat());
    b.a(paramParcel, 11, paramMarkerOptions.getRotation());
    b.a(paramParcel, 12, paramMarkerOptions.getInfoWindowAnchorU());
    b.a(paramParcel, 13, paramMarkerOptions.getInfoWindowAnchorV());
    b.a(paramParcel, 14, paramMarkerOptions.getAlpha());
    b.G(paramParcel, i);
  }
  
  public MarkerOptions createFromParcel(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int j = 0;
    LatLng localLatLng = null;
    String str2 = null;
    String str1 = null;
    IBinder localIBinder = null;
    float f1 = 0.0F;
    float f6 = 0.0F;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    float f3 = 0.0F;
    float f5 = 0.5F;
    float f4 = 0.0F;
    float f2 = 1.0F;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new MarkerOptions(j, localLatLng, str2, str1, localIBinder, f1, f6, bool3, bool1, bool2, f3, f5, f4, f2);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        j = a.g(paramParcel, i);
        break;
      case 2: 
        localLatLng = (LatLng)a.a(paramParcel, i, LatLng.CREATOR);
        break;
      case 3: 
        str2 = a.o(paramParcel, i);
        break;
      case 4: 
        str1 = a.o(paramParcel, i);
        break;
      case 5: 
        localIBinder = a.p(paramParcel, i);
        break;
      case 6: 
        f1 = a.l(paramParcel, i);
        break;
      case 7: 
        f6 = a.l(paramParcel, i);
        break;
      case 8: 
        bool3 = a.c(paramParcel, i);
        break;
      case 9: 
        bool1 = a.c(paramParcel, i);
        break;
      case 10: 
        bool2 = a.c(paramParcel, i);
        break;
      case 11: 
        f3 = a.l(paramParcel, i);
        break;
      case 12: 
        f5 = a.l(paramParcel, i);
        break;
      case 13: 
        f4 = a.l(paramParcel, i);
        break;
      case 14: 
        f2 = a.l(paramParcel, i);
      }
    }
  }
  
  public MarkerOptions[] newArray(int paramInt)
  {
    return new MarkerOptions[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.MarkerOptionsCreator
 * JD-Core Version:    0.7.0.1
 */