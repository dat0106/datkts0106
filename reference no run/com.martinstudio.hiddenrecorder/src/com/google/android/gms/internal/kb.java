package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class kb
  implements SafeParcelable
{
  public static final kc CREATOR = new kc();
  public final String YS;
  public final String YT;
  public final int versionCode;
  
  public kb(int paramInt, String paramString1, String paramString2)
  {
    this.versionCode = paramInt;
    this.YS = paramString1;
    this.YT = paramString2;
  }
  
  public kb(String paramString, Locale paramLocale)
  {
    this.versionCode = 0;
    this.YS = paramString;
    this.YT = paramLocale.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject != null) && ((paramObject instanceof kb)))
      {
        kb localkb = (kb)paramObject;
        if ((!this.YT.equals(localkb.YT)) || (!this.YS.equals(localkb.YS))) {
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
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.YS;
    arrayOfObject[1] = this.YT;
    return hl.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return hl.e(this).a("clientPackageName", this.YS).a("locale", this.YT).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kc.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kb
 * JD-Core Version:    0.7.0.1
 */