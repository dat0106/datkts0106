package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class TileOverlayOptionsCreator
  implements Parcelable.Creator<TileOverlayOptions>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(TileOverlayOptions paramTileOverlayOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramTileOverlayOptions.getVersionCode());
    b.a(paramParcel, 2, paramTileOverlayOptions.jL(), false);
    b.a(paramParcel, 3, paramTileOverlayOptions.isVisible());
    b.a(paramParcel, 4, paramTileOverlayOptions.getZIndex());
    b.a(paramParcel, 5, paramTileOverlayOptions.getFadeIn());
    b.G(paramParcel, i);
  }
  
  public TileOverlayOptions createFromParcel(Parcel paramParcel)
  {
    boolean bool2 = false;
    int k = a.B(paramParcel);
    IBinder localIBinder = null;
    float f = 0.0F;
    boolean bool1 = true;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new TileOverlayOptions(i, localIBinder, bool2, f, bool1);
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
        localIBinder = a.p(paramParcel, j);
        break;
      case 3: 
        bool2 = a.c(paramParcel, j);
        break;
      case 4: 
        f = a.l(paramParcel, j);
        break;
      case 5: 
        bool1 = a.c(paramParcel, j);
      }
    }
  }
  
  public TileOverlayOptions[] newArray(int paramInt)
  {
    return new TileOverlayOptions[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.TileOverlayOptionsCreator
 * JD-Core Version:    0.7.0.1
 */