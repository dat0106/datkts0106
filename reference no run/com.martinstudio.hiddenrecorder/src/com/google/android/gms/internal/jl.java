package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jl
  implements SafeParcelable
{
  public static final jm CREATOR = new jm();
  private final int UX;
  private final int VX;
  private final jn VY;
  private final int xJ;
  
  jl(int paramInt1, int paramInt2, int paramInt3, jn paramjn)
  {
    this.xJ = paramInt1;
    this.UX = paramInt2;
    this.VX = paramInt3;
    this.VY = paramjn;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof jl))
      {
        jl localjl = (jl)paramObject;
        if ((this.UX != localjl.UX) || (this.VX != localjl.VX) || (!this.VY.equals(localjl.VY))) {
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
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.UX);
    arrayOfObject[1] = Integer.valueOf(this.VX);
    return hl.hashCode(arrayOfObject);
  }
  
  public int iX()
  {
    return this.UX;
  }
  
  public int iZ()
  {
    return this.VX;
  }
  
  public jn ja()
  {
    return this.VY;
  }
  
  public String toString()
  {
    return hl.e(this).a("transitionTypes", Integer.valueOf(this.UX)).a("loiteringTimeMillis", Integer.valueOf(this.VX)).a("placeFilter", this.VY).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jm.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jl
 * JD-Core Version:    0.7.0.1
 */