package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class i
{
  static void a(Tile paramTile, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramTile.getVersionCode());
    b.c(paramParcel, 2, paramTile.width);
    b.c(paramParcel, 3, paramTile.height);
    b.a(paramParcel, 4, paramTile.data, false);
    b.G(paramParcel, i);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.i
 * JD-Core Version:    0.7.0.1
 */