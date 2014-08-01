package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.maps.internal.v;

public final class VisibleRegion
  implements SafeParcelable
{
  public static final VisibleRegionCreator CREATOR = new VisibleRegionCreator();
  public final LatLng farLeft;
  public final LatLng farRight;
  public final LatLngBounds latLngBounds;
  public final LatLng nearLeft;
  public final LatLng nearRight;
  private final int xJ;
  
  VisibleRegion(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    this.xJ = paramInt;
    this.nearLeft = paramLatLng1;
    this.nearRight = paramLatLng2;
    this.farLeft = paramLatLng3;
    this.farRight = paramLatLng4;
    this.latLngBounds = paramLatLngBounds;
  }
  
  public VisibleRegion(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    this(1, paramLatLng1, paramLatLng2, paramLatLng3, paramLatLng4, paramLatLngBounds);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof VisibleRegion))
      {
        VisibleRegion localVisibleRegion = (VisibleRegion)paramObject;
        if ((!this.nearLeft.equals(localVisibleRegion.nearLeft)) || (!this.nearRight.equals(localVisibleRegion.nearRight)) || (!this.farLeft.equals(localVisibleRegion.farLeft)) || (!this.farRight.equals(localVisibleRegion.farRight)) || (!this.latLngBounds.equals(localVisibleRegion.latLngBounds))) {
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
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.nearLeft;
    arrayOfObject[1] = this.nearRight;
    arrayOfObject[2] = this.farLeft;
    arrayOfObject[3] = this.farRight;
    arrayOfObject[4] = this.latLngBounds;
    return hl.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return hl.e(this).a("nearLeft", this.nearLeft).a("nearRight", this.nearRight).a("farLeft", this.farLeft).a("farRight", this.farRight).a("latLngBounds", this.latLngBounds).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!v.jG()) {
      VisibleRegionCreator.a(this, paramParcel, paramInt);
    } else {
      k.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.VisibleRegion
 * JD-Core Version:    0.7.0.1
 */