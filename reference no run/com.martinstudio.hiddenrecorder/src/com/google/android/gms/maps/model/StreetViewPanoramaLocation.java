package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public class StreetViewPanoramaLocation
  implements SafeParcelable
{
  public static final StreetViewPanoramaLocationCreator CREATOR = new StreetViewPanoramaLocationCreator();
  public final StreetViewPanoramaLink[] links;
  public final String panoId;
  public final LatLng position;
  private final int xJ;
  
  StreetViewPanoramaLocation(int paramInt, StreetViewPanoramaLink[] paramArrayOfStreetViewPanoramaLink, LatLng paramLatLng, String paramString)
  {
    this.xJ = paramInt;
    this.links = paramArrayOfStreetViewPanoramaLink;
    this.position = paramLatLng;
    this.panoId = paramString;
  }
  
  public StreetViewPanoramaLocation(StreetViewPanoramaLink[] paramArrayOfStreetViewPanoramaLink, LatLng paramLatLng, String paramString)
  {
    this(1, paramArrayOfStreetViewPanoramaLink, paramLatLng, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof StreetViewPanoramaLocation))
      {
        StreetViewPanoramaLocation localStreetViewPanoramaLocation = (StreetViewPanoramaLocation)paramObject;
        if ((!this.panoId.equals(localStreetViewPanoramaLocation.panoId)) || (!this.position.equals(localStreetViewPanoramaLocation.position))) {
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
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.position;
    arrayOfObject[1] = this.panoId;
    return hl.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return hl.e(this).a("panoId", this.panoId).a("position", this.position.toString()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StreetViewPanoramaLocationCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaLocation
 * JD-Core Version:    0.7.0.1
 */