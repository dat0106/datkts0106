package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class VisibleRegionCreator
  implements Parcelable.Creator<VisibleRegion>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramVisibleRegion.getVersionCode());
    b.a(paramParcel, 2, paramVisibleRegion.nearLeft, paramInt, false);
    b.a(paramParcel, 3, paramVisibleRegion.nearRight, paramInt, false);
    b.a(paramParcel, 4, paramVisibleRegion.farLeft, paramInt, false);
    b.a(paramParcel, 5, paramVisibleRegion.farRight, paramInt, false);
    b.a(paramParcel, 6, paramVisibleRegion.latLngBounds, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public VisibleRegion createFromParcel(Parcel paramParcel)
  {
    LatLngBounds localLatLngBounds = null;
    int k = a.B(paramParcel);
    int j = 0;
    LatLng localLatLng2 = null;
    LatLng localLatLng1 = null;
    LatLng localLatLng3 = null;
    LatLng localLatLng4 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new VisibleRegion(j, localLatLng4, localLatLng3, localLatLng1, localLatLng2, localLatLngBounds);
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
        localLatLng4 = (LatLng)a.a(paramParcel, i, LatLng.CREATOR);
        break;
      case 3: 
        localLatLng3 = (LatLng)a.a(paramParcel, i, LatLng.CREATOR);
        break;
      case 4: 
        localLatLng1 = (LatLng)a.a(paramParcel, i, LatLng.CREATOR);
        break;
      case 5: 
        localLatLng2 = (LatLng)a.a(paramParcel, i, LatLng.CREATOR);
        break;
      case 6: 
        localLatLngBounds = (LatLngBounds)a.a(paramParcel, i, LatLngBounds.CREATOR);
      }
    }
  }
  
  public VisibleRegion[] newArray(int paramInt)
  {
    return new VisibleRegion[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.VisibleRegionCreator
 * JD-Core Version:    0.7.0.1
 */