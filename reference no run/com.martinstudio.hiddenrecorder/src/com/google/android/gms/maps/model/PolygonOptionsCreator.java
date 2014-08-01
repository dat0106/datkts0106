package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptionsCreator
  implements Parcelable.Creator<PolygonOptions>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(PolygonOptions paramPolygonOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramPolygonOptions.getVersionCode());
    b.b(paramParcel, 2, paramPolygonOptions.getPoints(), false);
    b.c(paramParcel, 3, paramPolygonOptions.jK(), false);
    b.a(paramParcel, 4, paramPolygonOptions.getStrokeWidth());
    b.c(paramParcel, 5, paramPolygonOptions.getStrokeColor());
    b.c(paramParcel, 6, paramPolygonOptions.getFillColor());
    b.a(paramParcel, 7, paramPolygonOptions.getZIndex());
    b.a(paramParcel, 8, paramPolygonOptions.isVisible());
    b.a(paramParcel, 9, paramPolygonOptions.isGeodesic());
    b.G(paramParcel, i);
  }
  
  public PolygonOptions createFromParcel(Parcel paramParcel)
  {
    float f2 = 0.0F;
    boolean bool1 = false;
    int n = a.B(paramParcel);
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    boolean bool2 = false;
    int k = 0;
    int m = 0;
    float f1 = 0.0F;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= n)
      {
        if (paramParcel.dataPosition() == n) {
          return new PolygonOptions(j, (List)localObject, localArrayList, f1, m, k, f2, bool2, bool1);
        }
        throw new a.a("Overread allowed size end=" + n, paramParcel);
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
        localObject = a.c(paramParcel, i, LatLng.CREATOR);
        break;
      case 3: 
        a.a(paramParcel, i, localArrayList, getClass().getClassLoader());
        break;
      case 4: 
        f1 = a.l(paramParcel, i);
        break;
      case 5: 
        m = a.g(paramParcel, i);
        break;
      case 6: 
        k = a.g(paramParcel, i);
        break;
      case 7: 
        f2 = a.l(paramParcel, i);
        break;
      case 8: 
        bool2 = a.c(paramParcel, i);
        break;
      case 9: 
        bool1 = a.c(paramParcel, i);
      }
    }
  }
  
  public PolygonOptions[] newArray(int paramInt)
  {
    return new PolygonOptions[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PolygonOptionsCreator
 * JD-Core Version:    0.7.0.1
 */