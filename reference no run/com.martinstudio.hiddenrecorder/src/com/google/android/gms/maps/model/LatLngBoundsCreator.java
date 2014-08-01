package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class LatLngBoundsCreator
  implements Parcelable.Creator<LatLngBounds>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(LatLngBounds paramLatLngBounds, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramLatLngBounds.getVersionCode());
    b.a(paramParcel, 2, paramLatLngBounds.southwest, paramInt, false);
    b.a(paramParcel, 3, paramLatLngBounds.northeast, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public LatLngBounds createFromParcel(Parcel paramParcel)
  {
    Object localObject3 = null;
    int i = a.B(paramParcel);
    Object localObject2 = 0;
    Object localObject1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new LatLngBounds(localObject2, (LatLng)localObject1, (LatLng)localObject3);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int j = a.A(paramParcel);
      Object localObject4;
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        localObject4 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject2;
        break;
      case 1: 
        localObject2 = a.g(paramParcel, localObject4);
        localObject4 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject4 = localObject4;
        break;
      case 2: 
        LatLng localLatLng = (LatLng)a.a(paramParcel, localObject4, LatLng.CREATOR);
        localObject1 = localObject2;
        localObject4 = localObject3;
        localObject3 = localLatLng;
        break;
      case 3: 
        localObject4 = (LatLng)a.a(paramParcel, localObject4, LatLng.CREATOR);
        localObject3 = localObject1;
        localObject1 = localObject2;
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
    }
  }
  
  public LatLngBounds[] newArray(int paramInt)
  {
    return new LatLngBounds[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.LatLngBoundsCreator
 * JD-Core Version:    0.7.0.1
 */