package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.v;

public final class LatLngBounds
  implements SafeParcelable
{
  public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
  public final LatLng northeast;
  public final LatLng southwest;
  private final int xJ;
  
  LatLngBounds(int paramInt, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    hn.b(paramLatLng1, "null southwest");
    hn.b(paramLatLng2, "null northeast");
    boolean bool;
    if (paramLatLng2.latitude < paramLatLng1.latitude) {
      bool = false;
    } else {
      bool = true;
    }
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Double.valueOf(paramLatLng1.latitude);
    arrayOfObject[1] = Double.valueOf(paramLatLng2.latitude);
    hn.b(bool, "southern latitude exceeds northern latitude (%s > %s)", arrayOfObject);
    this.xJ = paramInt;
    this.southwest = paramLatLng1;
    this.northeast = paramLatLng2;
  }
  
  public LatLngBounds(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    this(1, paramLatLng1, paramLatLng2);
  }
  
  private static double b(double paramDouble1, double paramDouble2)
  {
    return (360.0D + (paramDouble1 - paramDouble2)) % 360.0D;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  private static double c(double paramDouble1, double paramDouble2)
  {
    return (360.0D + (paramDouble2 - paramDouble1)) % 360.0D;
  }
  
  private boolean c(double paramDouble)
  {
    boolean bool;
    if ((this.southwest.latitude > paramDouble) || (paramDouble > this.northeast.latitude)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean d(double paramDouble)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (this.southwest.longitude > this.northeast.longitude)
    {
      if ((this.southwest.longitude <= paramDouble) || (paramDouble <= this.northeast.longitude)) {
        bool2 = bool1;
      }
      bool1 = bool2;
    }
    else if ((this.southwest.longitude > paramDouble) || (paramDouble > this.northeast.longitude))
    {
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    boolean bool;
    if ((!c(paramLatLng.latitude)) || (!d(paramLatLng.longitude))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof LatLngBounds))
      {
        LatLngBounds localLatLngBounds = (LatLngBounds)paramObject;
        if ((!this.southwest.equals(localLatLngBounds.southwest)) || (!this.northeast.equals(localLatLngBounds.northeast))) {
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
  
  public LatLng getCenter()
  {
    double d1 = (this.southwest.latitude + this.northeast.latitude) / 2.0D;
    double d3 = this.northeast.longitude;
    double d2 = this.southwest.longitude;
    if (d2 > d3) {
      d2 = (d2 + (d3 + 360.0D)) / 2.0D;
    } else {
      d2 = (d3 + d2) / 2.0D;
    }
    return new LatLng(d1, d2);
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.southwest;
    arrayOfObject[1] = this.northeast;
    return hl.hashCode(arrayOfObject);
  }
  
  public LatLngBounds including(LatLng paramLatLng)
  {
    double d3 = Math.min(this.southwest.latitude, paramLatLng.latitude);
    double d1 = Math.max(this.northeast.latitude, paramLatLng.latitude);
    double d5 = this.northeast.longitude;
    double d2 = this.southwest.longitude;
    double d4 = paramLatLng.longitude;
    if (d(d4))
    {
      d4 = d2;
      d5 = d5;
    }
    else if (b(d2, d4) >= c(d5, d4))
    {
      d5 = d4;
      d4 = d2;
    }
    else
    {
      d5 = d5;
    }
    return new LatLngBounds(new LatLng(d3, d4), new LatLng(d1, d5));
  }
  
  public String toString()
  {
    return hl.e(this).a("southwest", this.southwest).a("northeast", this.northeast).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!v.jG()) {
      LatLngBoundsCreator.a(this, paramParcel, paramInt);
    } else {
      d.a(this, paramParcel, paramInt);
    }
  }
  
  public static final class Builder
  {
    private double aaH = (1.0D / 0.0D);
    private double aaI = (-1.0D / 0.0D);
    private double aaJ = (0.0D / 0.0D);
    private double aaK = (0.0D / 0.0D);
    
    private boolean d(double paramDouble)
    {
      boolean bool2 = true;
      boolean bool1 = false;
      if (this.aaJ > this.aaK)
      {
        if ((this.aaJ <= paramDouble) || (paramDouble <= this.aaK)) {
          bool1 = bool2;
        }
        bool2 = bool1;
      }
      else if ((this.aaJ > paramDouble) || (paramDouble > this.aaK))
      {
        bool2 = false;
      }
      return bool2;
    }
    
    public LatLngBounds build()
    {
      boolean bool;
      if (Double.isNaN(this.aaJ)) {
        bool = false;
      } else {
        bool = true;
      }
      hn.a(bool, "no included points");
      return new LatLngBounds(new LatLng(this.aaH, this.aaJ), new LatLng(this.aaI, this.aaK));
    }
    
    public Builder include(LatLng paramLatLng)
    {
      this.aaH = Math.min(this.aaH, paramLatLng.latitude);
      this.aaI = Math.max(this.aaI, paramLatLng.latitude);
      double d = paramLatLng.longitude;
      if (!Double.isNaN(this.aaJ))
      {
        if (!d(d)) {
          if (LatLngBounds.d(this.aaJ, d) >= LatLngBounds.e(this.aaK, d)) {
            this.aaK = d;
          } else {
            this.aaJ = d;
          }
        }
      }
      else
      {
        this.aaJ = d;
        this.aaK = d;
      }
      return this;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.LatLngBounds
 * JD-Core Version:    0.7.0.1
 */