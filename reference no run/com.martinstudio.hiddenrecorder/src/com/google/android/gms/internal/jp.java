package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jp
  implements SafeParcelable
{
  public static final jq CREATOR = new jq();
  private final String Wi;
  private final String mTag;
  final int xJ;
  
  jp(int paramInt, String paramString1, String paramString2)
  {
    this.xJ = paramInt;
    this.Wi = paramString1;
    this.mTag = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof jp))
    {
      jp localjp = (jp)paramObject;
      if ((hl.equal(this.Wi, localjp.Wi)) && (hl.equal(this.mTag, localjp.mTag))) {
        bool = true;
      }
    }
    return bool;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.Wi;
    arrayOfObject[1] = this.mTag;
    return hl.hashCode(arrayOfObject);
  }
  
  public String je()
  {
    return this.Wi;
  }
  
  public String toString()
  {
    return hl.e(this).a("mPlaceId", this.Wi).a("mTag", this.mTag).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jq.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jp
 * JD-Core Version:    0.7.0.1
 */