package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class jx
  implements SafeParcelable
{
  public static final jy CREATOR = new jy();
  public static final jx YM = w("test_type", 1);
  public static final jx YN = w("saved_offers", 4);
  public static final Set<jx> YO;
  final int YP;
  final String qU;
  final int xJ;
  
  static
  {
    jx[] arrayOfjx = new jx[2];
    arrayOfjx[0] = YM;
    arrayOfjx[1] = YN;
    YO = Collections.unmodifiableSet(new HashSet(Arrays.asList(arrayOfjx)));
  }
  
  jx(int paramInt1, String paramString, int paramInt2)
  {
    hn.aE(paramString);
    this.xJ = paramInt1;
    this.qU = paramString;
    this.YP = paramInt2;
  }
  
  private static jx w(String paramString, int paramInt)
  {
    return new jx(0, paramString, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof jx))
      {
        jx localjx = (jx)paramObject;
        if ((!this.qU.equals(localjx.qU)) || (this.YP != localjx.YP)) {
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
  
  public int hashCode()
  {
    return this.qU.hashCode();
  }
  
  public String toString()
  {
    return this.qU;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jy.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jx
 * JD-Core Version:    0.7.0.1
 */