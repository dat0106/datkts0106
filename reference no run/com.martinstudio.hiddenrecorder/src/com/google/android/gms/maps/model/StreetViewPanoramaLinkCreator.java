package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class StreetViewPanoramaLinkCreator
  implements Parcelable.Creator<StreetViewPanoramaLink>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(StreetViewPanoramaLink paramStreetViewPanoramaLink, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramStreetViewPanoramaLink.getVersionCode());
    b.a(paramParcel, 2, paramStreetViewPanoramaLink.panoId, false);
    b.a(paramParcel, 3, paramStreetViewPanoramaLink.bearing);
    b.G(paramParcel, i);
  }
  
  public StreetViewPanoramaLink createFromParcel(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int i = 0;
    String str = null;
    float f = 0.0F;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new StreetViewPanoramaLink(i, str, f);
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
        i = a.g(paramParcel, j);
        break;
      case 2: 
        str = a.o(paramParcel, j);
        break;
      case 3: 
        f = a.l(paramParcel, j);
      }
    }
  }
  
  public StreetViewPanoramaLink[] newArray(int paramInt)
  {
    return new StreetViewPanoramaLink[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaLinkCreator
 * JD-Core Version:    0.7.0.1
 */