package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class GroundOverlayOptionsCreator
  implements Parcelable.Creator<GroundOverlayOptions>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(GroundOverlayOptions paramGroundOverlayOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramGroundOverlayOptions.getVersionCode());
    b.a(paramParcel, 2, paramGroundOverlayOptions.jI(), false);
    b.a(paramParcel, 3, paramGroundOverlayOptions.getLocation(), paramInt, false);
    b.a(paramParcel, 4, paramGroundOverlayOptions.getWidth());
    b.a(paramParcel, 5, paramGroundOverlayOptions.getHeight());
    b.a(paramParcel, 6, paramGroundOverlayOptions.getBounds(), paramInt, false);
    b.a(paramParcel, 7, paramGroundOverlayOptions.getBearing());
    b.a(paramParcel, 8, paramGroundOverlayOptions.getZIndex());
    b.a(paramParcel, 9, paramGroundOverlayOptions.isVisible());
    b.a(paramParcel, 10, paramGroundOverlayOptions.getTransparency());
    b.a(paramParcel, 11, paramGroundOverlayOptions.getAnchorU());
    b.a(paramParcel, 12, paramGroundOverlayOptions.getAnchorV());
    b.G(paramParcel, i);
  }
  
  public GroundOverlayOptions createFromParcel(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int j = 0;
    IBinder localIBinder = null;
    LatLng localLatLng = null;
    float f5 = 0.0F;
    float f7 = 0.0F;
    LatLngBounds localLatLngBounds = null;
    float f4 = 0.0F;
    float f3 = 0.0F;
    boolean bool = false;
    float f2 = 0.0F;
    float f6 = 0.0F;
    float f1 = 0.0F;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new GroundOverlayOptions(j, localIBinder, localLatLng, f5, f7, localLatLngBounds, f4, f3, bool, f2, f6, f1);
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
        localIBinder = a.p(paramParcel, i);
        break;
      case 3: 
        localLatLng = (LatLng)a.a(paramParcel, i, LatLng.CREATOR);
        break;
      case 4: 
        f5 = a.l(paramParcel, i);
        break;
      case 5: 
        f7 = a.l(paramParcel, i);
        break;
      case 6: 
        localLatLngBounds = (LatLngBounds)a.a(paramParcel, i, LatLngBounds.CREATOR);
        break;
      case 7: 
        f4 = a.l(paramParcel, i);
        break;
      case 8: 
        f3 = a.l(paramParcel, i);
        break;
      case 9: 
        bool = a.c(paramParcel, i);
        break;
      case 10: 
        f2 = a.l(paramParcel, i);
        break;
      case 11: 
        f6 = a.l(paramParcel, i);
        break;
      case 12: 
        f1 = a.l(paramParcel, i);
      }
    }
  }
  
  public GroundOverlayOptions[] newArray(int paramInt)
  {
    return new GroundOverlayOptions[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.GroundOverlayOptionsCreator
 * JD-Core Version:    0.7.0.1
 */