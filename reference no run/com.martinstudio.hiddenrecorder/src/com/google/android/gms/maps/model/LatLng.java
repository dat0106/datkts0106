package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.v;

public final class LatLng
  implements SafeParcelable
{
  public static final LatLngCreator CREATOR = new LatLngCreator();
  public final double latitude;
  public final double longitude;
  private final int xJ;
  
  public LatLng(double paramDouble1, double paramDouble2)
  {
    this(1, paramDouble1, paramDouble2);
  }
  
  LatLng(int paramInt, double paramDouble1, double paramDouble2)
  {
    this.xJ = paramInt;
    if ((-180.0D > paramDouble2) || (paramDouble2 >= 180.0D)) {
      this.longitude = ((360.0D + (paramDouble2 - 180.0D) % 360.0D) % 360.0D - 180.0D);
    } else {
      this.longitude = paramDouble2;
    }
    this.latitude = Math.max(-90.0D, Math.min(90.0D, paramDouble1));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof LatLng))
      {
        LatLng localLatLng = (LatLng)paramObject;
        if ((Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(localLatLng.latitude)) || (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(localLatLng.longitude))) {
          bool = false;
        }
      }
      else
      {
        bool = false;
      }
    }
    return bool;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.latitude);
    int i = 31 + (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.longitude);
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!v.jG()) {
      LatLngCreator.a(this, paramParcel, paramInt);
    } else {
      e.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.LatLng
 * JD-Core Version:    0.7.0.1
 */