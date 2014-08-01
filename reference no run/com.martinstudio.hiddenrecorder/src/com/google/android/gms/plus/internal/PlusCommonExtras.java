package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public class PlusCommonExtras
  implements SafeParcelable
{
  public static final f CREATOR = new f();
  public static String TAG = "PlusCommonExtras";
  private String abN;
  private String abO;
  private final int xJ;
  
  public PlusCommonExtras()
  {
    this.xJ = 1;
    this.abN = "";
    this.abO = "";
  }
  
  PlusCommonExtras(int paramInt, String paramString1, String paramString2)
  {
    this.xJ = paramInt;
    this.abN = paramString1;
    this.abO = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof PlusCommonExtras))
    {
      PlusCommonExtras localPlusCommonExtras = (PlusCommonExtras)paramObject;
      if ((this.xJ == localPlusCommonExtras.xJ) && (hl.equal(this.abN, localPlusCommonExtras.abN)) && (hl.equal(this.abO, localPlusCommonExtras.abO))) {
        bool = true;
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
    arrayOfObject[0] = Integer.valueOf(this.xJ);
    arrayOfObject[1] = this.abN;
    arrayOfObject[2] = this.abO;
    return hl.hashCode(arrayOfObject);
  }
  
  public String jS()
  {
    return this.abN;
  }
  
  public String jT()
  {
    return this.abO;
  }
  
  public void n(Bundle paramBundle)
  {
    paramBundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", c.a(this));
  }
  
  public String toString()
  {
    return hl.e(this).a("versionCode", Integer.valueOf(this.xJ)).a("Gpsrc", this.abN).a("ClientCallingPackage", this.abO).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.PlusCommonExtras
 * JD-Core Version:    0.7.0.1
 */