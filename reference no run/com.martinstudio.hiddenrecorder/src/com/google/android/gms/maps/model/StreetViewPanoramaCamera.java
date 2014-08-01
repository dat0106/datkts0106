package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;

public class StreetViewPanoramaCamera
  implements SafeParcelable
{
  public static final StreetViewPanoramaCameraCreator CREATOR = new StreetViewPanoramaCameraCreator();
  private StreetViewPanoramaOrientation aaY;
  public final float bearing;
  public final float tilt;
  private final int xJ;
  public final float zoom;
  
  public StreetViewPanoramaCamera(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(1, paramFloat1, paramFloat2, paramFloat3);
  }
  
  StreetViewPanoramaCamera(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool;
    if ((-90.0F > paramFloat2) || (paramFloat2 > 90.0F)) {
      bool = false;
    } else {
      bool = true;
    }
    hn.b(bool, "Tilt needs to be between -90 and 90 inclusive");
    this.xJ = paramInt;
    this.zoom = paramFloat1;
    this.tilt = (0.0F + paramFloat2);
    float f;
    if (paramFloat3 > 0.0D) {
      f = paramFloat3;
    } else {
      f = 360.0F + paramFloat3 % 360.0F;
    }
    this.bearing = (f % 360.0F);
    this.aaY = new StreetViewPanoramaOrientation.Builder().tilt(paramFloat2).bearing(paramFloat3).build();
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder builder(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
  {
    return new Builder(paramStreetViewPanoramaCamera);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof StreetViewPanoramaCamera))
      {
        StreetViewPanoramaCamera localStreetViewPanoramaCamera = (StreetViewPanoramaCamera)paramObject;
        if ((Float.floatToIntBits(this.zoom) != Float.floatToIntBits(localStreetViewPanoramaCamera.zoom)) || (Float.floatToIntBits(this.tilt) != Float.floatToIntBits(localStreetViewPanoramaCamera.tilt)) || (Float.floatToIntBits(this.bearing) != Float.floatToIntBits(localStreetViewPanoramaCamera.bearing))) {
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
  
  public StreetViewPanoramaOrientation getOrientation()
  {
    return this.aaY;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Float.valueOf(this.zoom);
    arrayOfObject[1] = Float.valueOf(this.tilt);
    arrayOfObject[2] = Float.valueOf(this.bearing);
    return hl.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return hl.e(this).a("zoom", Float.valueOf(this.zoom)).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StreetViewPanoramaCameraCreator.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    public float bearing;
    public float tilt;
    public float zoom;
    
    public Builder() {}
    
    public Builder(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
    {
      this.zoom = paramStreetViewPanoramaCamera.zoom;
      this.bearing = paramStreetViewPanoramaCamera.bearing;
      this.tilt = paramStreetViewPanoramaCamera.tilt;
    }
    
    public Builder bearing(float paramFloat)
    {
      this.bearing = paramFloat;
      return this;
    }
    
    public StreetViewPanoramaCamera build()
    {
      return new StreetViewPanoramaCamera(this.zoom, this.tilt, this.bearing);
    }
    
    public Builder orientation(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
    {
      this.tilt = paramStreetViewPanoramaOrientation.tilt;
      this.bearing = paramStreetViewPanoramaOrientation.bearing;
      return this;
    }
    
    public Builder tilt(float paramFloat)
    {
      this.tilt = paramFloat;
      return this;
    }
    
    public Builder zoom(float paramFloat)
    {
      this.zoom = paramFloat;
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaCamera
 * JD-Core Version:    0.7.0.1
 */