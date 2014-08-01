package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.v;

public final class CameraPosition
  implements SafeParcelable
{
  public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
  public final float bearing;
  public final LatLng target;
  public final float tilt;
  private final int xJ;
  public final float zoom;
  
  CameraPosition(int paramInt, LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    hn.b(paramLatLng, "null camera target");
    boolean bool;
    if ((0.0F > paramFloat2) || (paramFloat2 > 90.0F)) {
      bool = false;
    } else {
      bool = true;
    }
    hn.b(bool, "Tilt needs to be between 0 and 90 inclusive");
    this.xJ = paramInt;
    this.target = paramLatLng;
    this.zoom = paramFloat1;
    this.tilt = (paramFloat2 + 0.0F);
    if (paramFloat3 <= 0.0D) {
      paramFloat3 = 360.0F + paramFloat3 % 360.0F;
    }
    this.bearing = (paramFloat3 % 360.0F);
  }
  
  public CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(1, paramLatLng, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder builder(CameraPosition paramCameraPosition)
  {
    return new Builder(paramCameraPosition);
  }
  
  public static CameraPosition createFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    Object localObject;
    if (paramAttributeSet != null)
    {
      localObject = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
      float f1;
      if (!((TypedArray)localObject).hasValue(2)) {
        f1 = 0.0F;
      } else {
        f1 = ((TypedArray)localObject).getFloat(2, 0.0F);
      }
      float f2;
      if (!((TypedArray)localObject).hasValue(3)) {
        f2 = 0.0F;
      } else {
        f2 = ((TypedArray)localObject).getFloat(3, 0.0F);
      }
      LatLng localLatLng = new LatLng(f1, f2);
      Builder localBuilder = builder();
      localBuilder.target(localLatLng);
      if (((TypedArray)localObject).hasValue(5)) {
        localBuilder.zoom(((TypedArray)localObject).getFloat(5, 0.0F));
      }
      if (((TypedArray)localObject).hasValue(1)) {
        localBuilder.bearing(((TypedArray)localObject).getFloat(1, 0.0F));
      }
      if (((TypedArray)localObject).hasValue(4)) {
        localBuilder.tilt(((TypedArray)localObject).getFloat(4, 0.0F));
      }
      localObject = localBuilder.build();
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    return new CameraPosition(paramLatLng, paramFloat, 0.0F, 0.0F);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof CameraPosition))
      {
        CameraPosition localCameraPosition = (CameraPosition)paramObject;
        if ((!this.target.equals(localCameraPosition.target)) || (Float.floatToIntBits(this.zoom) != Float.floatToIntBits(localCameraPosition.zoom)) || (Float.floatToIntBits(this.tilt) != Float.floatToIntBits(localCameraPosition.tilt)) || (Float.floatToIntBits(this.bearing) != Float.floatToIntBits(localCameraPosition.bearing))) {
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
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.target;
    arrayOfObject[1] = Float.valueOf(this.zoom);
    arrayOfObject[2] = Float.valueOf(this.tilt);
    arrayOfObject[3] = Float.valueOf(this.bearing);
    return hl.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return hl.e(this).a("target", this.target).a("zoom", Float.valueOf(this.zoom)).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!v.jG()) {
      CameraPositionCreator.a(this, paramParcel, paramInt);
    } else {
      a.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class Builder
  {
    private LatLng aak;
    private float aal;
    private float aam;
    private float aan;
    
    public Builder() {}
    
    public Builder(CameraPosition paramCameraPosition)
    {
      this.aak = paramCameraPosition.target;
      this.aal = paramCameraPosition.zoom;
      this.aam = paramCameraPosition.tilt;
      this.aan = paramCameraPosition.bearing;
    }
    
    public Builder bearing(float paramFloat)
    {
      this.aan = paramFloat;
      return this;
    }
    
    public CameraPosition build()
    {
      return new CameraPosition(this.aak, this.aal, this.aam, this.aan);
    }
    
    public Builder target(LatLng paramLatLng)
    {
      this.aak = paramLatLng;
      return this;
    }
    
    public Builder tilt(float paramFloat)
    {
      this.aam = paramFloat;
      return this;
    }
    
    public Builder zoom(float paramFloat)
    {
      this.aal = paramFloat;
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.CameraPosition
 * JD-Core Version:    0.7.0.1
 */