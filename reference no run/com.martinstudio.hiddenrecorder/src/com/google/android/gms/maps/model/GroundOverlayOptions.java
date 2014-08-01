package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.v;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
  public static final float NO_DIMENSION = -1.0F;
  private float aaA;
  private LatLngBounds aaB;
  private float aaC = 0.0F;
  private float aaD = 0.5F;
  private float aaE = 0.5F;
  private float aan;
  private float aau;
  private boolean aav = true;
  private BitmapDescriptor aax;
  private LatLng aay;
  private float aaz;
  private final int xJ;
  
  public GroundOverlayOptions()
  {
    this.xJ = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.xJ = paramInt;
    this.aax = new BitmapDescriptor(d.a.ag(paramIBinder));
    this.aay = paramLatLng;
    this.aaz = paramFloat1;
    this.aaA = paramFloat2;
    this.aaB = paramLatLngBounds;
    this.aan = paramFloat3;
    this.aau = paramFloat4;
    this.aav = paramBoolean;
    this.aaC = paramFloat5;
    this.aaD = paramFloat6;
    this.aaE = paramFloat7;
  }
  
  private GroundOverlayOptions a(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.aay = paramLatLng;
    this.aaz = paramFloat1;
    this.aaA = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.aaD = paramFloat1;
    this.aaE = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions bearing(float paramFloat)
  {
    this.aan = ((360.0F + paramFloat % 360.0F) % 360.0F);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAnchorU()
  {
    return this.aaD;
  }
  
  public float getAnchorV()
  {
    return this.aaE;
  }
  
  public float getBearing()
  {
    return this.aan;
  }
  
  public LatLngBounds getBounds()
  {
    return this.aaB;
  }
  
  public float getHeight()
  {
    return this.aaA;
  }
  
  public BitmapDescriptor getImage()
  {
    return this.aax;
  }
  
  public LatLng getLocation()
  {
    return this.aay;
  }
  
  public float getTransparency()
  {
    return this.aaC;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public float getWidth()
  {
    return this.aaz;
  }
  
  public float getZIndex()
  {
    return this.aau;
  }
  
  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    this.aax = paramBitmapDescriptor;
    return this;
  }
  
  public boolean isVisible()
  {
    return this.aav;
  }
  
  IBinder jI()
  {
    return this.aax.ji().asBinder();
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.aaB != null) {
      bool2 = false;
    } else {
      bool2 = bool1;
    }
    hn.a(bool2, "Position has already been set using positionFromBounds");
    if (paramLatLng == null) {
      bool2 = false;
    } else {
      bool2 = bool1;
    }
    hn.b(bool2, "Location must be specified");
    if (paramFloat < 0.0F) {
      bool1 = false;
    }
    hn.b(bool1, "Width must be non-negative");
    return a(paramLatLng, paramFloat, -1.0F);
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.aaB != null) {
      bool2 = false;
    } else {
      bool2 = bool1;
    }
    hn.a(bool2, "Position has already been set using positionFromBounds");
    if (paramLatLng == null) {
      bool2 = false;
    } else {
      bool2 = bool1;
    }
    hn.b(bool2, "Location must be specified");
    if (paramFloat1 < 0.0F) {
      bool2 = false;
    } else {
      bool2 = bool1;
    }
    hn.b(bool2, "Width must be non-negative");
    if (paramFloat2 < 0.0F) {
      bool1 = false;
    }
    hn.b(bool1, "Height must be non-negative");
    return a(paramLatLng, paramFloat1, paramFloat2);
  }
  
  public GroundOverlayOptions positionFromBounds(LatLngBounds paramLatLngBounds)
  {
    boolean bool;
    if (this.aay != null) {
      bool = false;
    } else {
      bool = true;
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.aay;
    hn.a(bool, "Position has already been set using position: %s", arrayOfObject);
    this.aaB = paramLatLngBounds;
    return this;
  }
  
  public GroundOverlayOptions transparency(float paramFloat)
  {
    boolean bool;
    if ((paramFloat < 0.0F) || (paramFloat > 1.0F)) {
      bool = false;
    } else {
      bool = true;
    }
    hn.b(bool, "Transparency must be in the range [0..1]");
    this.aaC = paramFloat;
    return this;
  }
  
  public GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.aav = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!v.jG()) {
      GroundOverlayOptionsCreator.a(this, paramParcel, paramInt);
    } else {
      c.a(this, paramParcel, paramInt);
    }
  }
  
  public GroundOverlayOptions zIndex(float paramFloat)
  {
    this.aau = paramFloat;
    return this;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.GroundOverlayOptions
 * JD-Core Version:    0.7.0.1
 */