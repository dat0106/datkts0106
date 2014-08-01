package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public class StreetViewPanoramaLink
  implements SafeParcelable
{
  public static final StreetViewPanoramaLinkCreator CREATOR = new StreetViewPanoramaLinkCreator();
  public final float bearing;
  public final String panoId;
  private final int xJ;
  
  StreetViewPanoramaLink(int paramInt, String paramString, float paramFloat)
  {
    this.xJ = paramInt;
    this.panoId = paramString;
    if (paramFloat <= 0.0D) {
      paramFloat = 360.0F + paramFloat % 360.0F;
    }
    this.bearing = (paramFloat % 360.0F);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof StreetViewPanoramaLink))
      {
        StreetViewPanoramaLink localStreetViewPanoramaLink = (StreetViewPanoramaLink)paramObject;
        if ((!this.panoId.equals(localStreetViewPanoramaLink.panoId)) || (Float.floatToIntBits(this.bearing) != Float.floatToIntBits(localStreetViewPanoramaLink.bearing))) {
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
    arrayOfObject[0] = this.panoId;
    arrayOfObject[1] = Float.valueOf(this.bearing);
    return hl.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return hl.e(this).a("panoId", this.panoId).a("bearing", Float.valueOf(this.bearing)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StreetViewPanoramaLinkCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaLink
 * JD-Core Version:    0.7.0.1
 */