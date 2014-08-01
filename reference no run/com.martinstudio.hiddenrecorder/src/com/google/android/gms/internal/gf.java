package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class gf
  implements SafeParcelable
{
  public static final Parcelable.Creator<gf> CREATOR = new gg();
  private String Bz;
  private final int xJ;
  
  public gf()
  {
    this(1, null);
  }
  
  gf(int paramInt, String paramString)
  {
    this.xJ = paramInt;
    this.Bz = paramString;
  }
  
  public String dX()
  {
    return this.Bz;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject != this)
    {
      if ((paramObject instanceof gf))
      {
        gf localgf = (gf)paramObject;
        bool = gj.a(this.Bz, localgf.Bz);
      }
      else
      {
        bool = false;
      }
    }
    else {
      bool = true;
    }
    return bool;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.Bz;
    return hl.hashCode(arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gg.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gf
 * JD-Core Version:    0.7.0.1
 */