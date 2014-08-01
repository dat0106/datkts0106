package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import java.util.Arrays;

public class h
  implements SafeParcelable
{
  public static final j CREATOR = new j();
  private final String[] abQ;
  private final String[] abR;
  private final String[] abS;
  private final String abT;
  private final String abU;
  private final String abV;
  private final String abW;
  private final PlusCommonExtras abX;
  private final int xJ;
  private final String yN;
  
  h(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5, PlusCommonExtras paramPlusCommonExtras)
  {
    this.xJ = paramInt;
    this.yN = paramString1;
    this.abQ = paramArrayOfString1;
    this.abR = paramArrayOfString2;
    this.abS = paramArrayOfString3;
    this.abT = paramString2;
    this.abU = paramString3;
    this.abV = paramString4;
    this.abW = paramString5;
    this.abX = paramPlusCommonExtras;
  }
  
  public h(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, PlusCommonExtras paramPlusCommonExtras)
  {
    this.xJ = 1;
    this.yN = paramString1;
    this.abQ = paramArrayOfString1;
    this.abR = paramArrayOfString2;
    this.abS = paramArrayOfString3;
    this.abT = paramString2;
    this.abU = paramString3;
    this.abV = paramString4;
    this.abW = null;
    this.abX = paramPlusCommonExtras;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof h))
    {
      h localh = (h)paramObject;
      if ((this.xJ == localh.xJ) && (hl.equal(this.yN, localh.yN)) && (Arrays.equals(this.abQ, localh.abQ)) && (Arrays.equals(this.abR, localh.abR)) && (Arrays.equals(this.abS, localh.abS)) && (hl.equal(this.abT, localh.abT)) && (hl.equal(this.abU, localh.abU)) && (hl.equal(this.abV, localh.abV)) && (hl.equal(this.abW, localh.abW)) && (hl.equal(this.abX, localh.abX))) {
        bool = true;
      }
    }
    return bool;
  }
  
  public String getAccountName()
  {
    return this.yN;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = Integer.valueOf(this.xJ);
    arrayOfObject[1] = this.yN;
    arrayOfObject[2] = this.abQ;
    arrayOfObject[3] = this.abR;
    arrayOfObject[4] = this.abS;
    arrayOfObject[5] = this.abT;
    arrayOfObject[6] = this.abU;
    arrayOfObject[7] = this.abV;
    arrayOfObject[8] = this.abW;
    arrayOfObject[9] = this.abX;
    return hl.hashCode(arrayOfObject);
  }
  
  public String[] jU()
  {
    return this.abQ;
  }
  
  public String[] jV()
  {
    return this.abR;
  }
  
  public String[] jW()
  {
    return this.abS;
  }
  
  public String jX()
  {
    return this.abT;
  }
  
  public String jY()
  {
    return this.abU;
  }
  
  public String jZ()
  {
    return this.abV;
  }
  
  public String ka()
  {
    return this.abW;
  }
  
  public PlusCommonExtras kb()
  {
    return this.abX;
  }
  
  public Bundle kc()
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
    this.abX.n(localBundle);
    return localBundle;
  }
  
  public String toString()
  {
    return hl.e(this).a("versionCode", Integer.valueOf(this.xJ)).a("accountName", this.yN).a("requestedScopes", this.abQ).a("visibleActivities", this.abR).a("requiredFeatures", this.abS).a("packageNameForAuth", this.abT).a("callingPackageName", this.abU).a("applicationName", this.abV).a("extra", this.abX.toString()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.h
 * JD-Core Version:    0.7.0.1
 */