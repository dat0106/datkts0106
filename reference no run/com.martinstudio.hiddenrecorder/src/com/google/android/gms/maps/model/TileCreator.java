package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class TileCreator
  implements Parcelable.Creator<Tile>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(Tile paramTile, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramTile.getVersionCode());
    b.c(paramParcel, 2, paramTile.width);
    b.c(paramParcel, 3, paramTile.height);
    b.a(paramParcel, 4, paramTile.data, false);
    b.G(paramParcel, i);
  }
  
  public Tile createFromParcel(Parcel paramParcel)
  {
    int j = 0;
    int i = a.B(paramParcel);
    byte[] arrayOfByte = null;
    int k = 0;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new Tile(m, k, j, arrayOfByte);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        m = a.g(paramParcel, n);
        break;
      case 2: 
        k = a.g(paramParcel, n);
        break;
      case 3: 
        j = a.g(paramParcel, n);
        break;
      case 4: 
        arrayOfByte = a.r(paramParcel, n);
      }
    }
  }
  
  public Tile[] newArray(int paramInt)
  {
    return new Tile[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.TileCreator
 * JD-Core Version:    0.7.0.1
 */