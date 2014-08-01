package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;

public final class Tile
  implements SafeParcelable
{
  public static final TileCreator CREATOR = new TileCreator();
  public final byte[] data;
  public final int height;
  public final int width;
  private final int xJ;
  
  Tile(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    this.xJ = paramInt1;
    this.width = paramInt2;
    this.height = paramInt3;
    this.data = paramArrayOfByte;
  }
  
  public Tile(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this(1, paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!v.jG()) {
      TileCreator.a(this, paramParcel, paramInt);
    } else {
      i.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.Tile
 * JD-Core Version:    0.7.0.1
 */