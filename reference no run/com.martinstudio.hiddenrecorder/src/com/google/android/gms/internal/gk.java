package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class gk
  implements SafeParcelable
{
  public static final Parcelable.Creator<gk> CREATOR = new gl();
  private double AM;
  private boolean AN;
  private int BO;
  private final int xJ;
  
  public gk()
  {
    this(1, (0.0D / 0.0D), false, -1);
  }
  
  gk(int paramInt1, double paramDouble, boolean paramBoolean, int paramInt2)
  {
    this.xJ = paramInt1;
    this.AM = paramDouble;
    this.AN = paramBoolean;
    this.BO = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public double ec()
  {
    return this.AM;
  }
  
  public boolean ei()
  {
    return this.AN;
  }
  
  public int ej()
  {
    return this.BO;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject != this) {
      if ((paramObject instanceof gk))
      {
        gk localgk = (gk)paramObject;
        if ((this.AM != localgk.AM) || (this.AN != localgk.AN) || (this.BO != localgk.BO)) {
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
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Double.valueOf(this.AM);
    arrayOfObject[1] = Boolean.valueOf(this.AN);
    arrayOfObject[2] = Integer.valueOf(this.BO);
    return hl.hashCode(arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gl.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gk
 * JD-Core Version:    0.7.0.1
 */