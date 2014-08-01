package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class StreetViewPanoramaLocationCreator
  implements Parcelable.Creator<StreetViewPanoramaLocation>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(StreetViewPanoramaLocation paramStreetViewPanoramaLocation, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramStreetViewPanoramaLocation.getVersionCode());
    b.a(paramParcel, 2, paramStreetViewPanoramaLocation.links, paramInt, false);
    b.a(paramParcel, 3, paramStreetViewPanoramaLocation.position, paramInt, false);
    b.a(paramParcel, 4, paramStreetViewPanoramaLocation.panoId, false);
    b.G(paramParcel, i);
  }
  
  public StreetViewPanoramaLocation createFromParcel(Parcel paramParcel)
  {
    Object localObject4 = null;
    int i = a.B(paramParcel);
    StreetViewPanoramaLink[] arrayOfStreetViewPanoramaLink2 = 0;
    Object localObject1 = null;
    StreetViewPanoramaLink[] arrayOfStreetViewPanoramaLink1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new StreetViewPanoramaLocation(arrayOfStreetViewPanoramaLink2, arrayOfStreetViewPanoramaLink1, (LatLng)localObject1, (String)localObject4);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      Object localObject6;
      int j;
      Object localObject2;
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        localObject6 = localObject4;
        localObject4 = localObject1;
        localObject1 = arrayOfStreetViewPanoramaLink1;
        arrayOfStreetViewPanoramaLink1 = arrayOfStreetViewPanoramaLink2;
        break;
      case 1: 
        arrayOfStreetViewPanoramaLink2 = a.g(paramParcel, localObject6);
        localObject6 = localObject4;
        localObject4 = localObject1;
        localObject1 = arrayOfStreetViewPanoramaLink1;
        arrayOfStreetViewPanoramaLink1 = arrayOfStreetViewPanoramaLink2;
        localObject6 = localObject6;
        break;
      case 2: 
        localObject6 = (StreetViewPanoramaLink[])a.b(paramParcel, localObject6, StreetViewPanoramaLink.CREATOR);
        arrayOfStreetViewPanoramaLink1 = arrayOfStreetViewPanoramaLink2;
        localObject5 = localObject1;
        localObject1 = localObject6;
        localObject6 = localObject4;
        localObject4 = localObject5;
        break;
      case 3: 
        localObject6 = (LatLng)a.a(paramParcel, localObject6, LatLng.CREATOR);
        localObject1 = arrayOfStreetViewPanoramaLink1;
        j = localObject5;
        localObject5 = localObject4;
        localObject4 = localObject6;
        localObject6 = localObject5;
        break;
      case 4: 
        localObject6 = a.o(paramParcel, localObject6);
        localObject4 = localObject1;
        localObject1 = j;
        localObject2 = localObject5;
      }
      Object localObject5 = localObject2;
      Object localObject3 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject6;
    }
  }
  
  public StreetViewPanoramaLocation[] newArray(int paramInt)
  {
    return new StreetViewPanoramaLocation[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaLocationCreator
 * JD-Core Version:    0.7.0.1
 */