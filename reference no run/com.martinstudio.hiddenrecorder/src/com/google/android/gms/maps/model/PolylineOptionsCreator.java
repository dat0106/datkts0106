package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class PolylineOptionsCreator
  implements Parcelable.Creator<PolylineOptions>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(PolylineOptions paramPolylineOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramPolylineOptions.getVersionCode());
    b.b(paramParcel, 2, paramPolylineOptions.getPoints(), false);
    b.a(paramParcel, 3, paramPolylineOptions.getWidth());
    b.c(paramParcel, 4, paramPolylineOptions.getColor());
    b.a(paramParcel, 5, paramPolylineOptions.getZIndex());
    b.a(paramParcel, 6, paramPolylineOptions.isVisible());
    b.a(paramParcel, 7, paramPolylineOptions.isGeodesic());
    b.G(paramParcel, i);
  }
  
  public PolylineOptions createFromParcel(Parcel paramParcel)
  {
    float f1 = 0.0F;
    boolean bool1 = false;
    int k = a.B(paramParcel);
    Object localObject = null;
    boolean bool2 = false;
    int i = 0;
    float f2 = 0.0F;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new PolylineOptions(m, (List)localObject, f2, i, f1, bool2, bool1);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        m = a.g(paramParcel, j);
        break;
      case 2: 
        localObject = a.c(paramParcel, j, LatLng.CREATOR);
        break;
      case 3: 
        f2 = a.l(paramParcel, j);
        break;
      case 4: 
        i = a.g(paramParcel, j);
        break;
      case 5: 
        f1 = a.l(paramParcel, j);
        break;
      case 6: 
        bool2 = a.c(paramParcel, j);
        break;
      case 7: 
        bool1 = a.c(paramParcel, j);
      }
    }
  }
  
  public PolylineOptions[] newArray(int paramInt)
  {
    return new PolylineOptions[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PolylineOptionsCreator
 * JD-Core Version:    0.7.0.1
 */