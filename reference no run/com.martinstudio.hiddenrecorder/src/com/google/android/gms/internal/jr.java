package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

public final class jr
  implements SafeParcelable
{
  public static final js CREATOR = new js();
  static final long Wj = TimeUnit.HOURS.toMillis(1L);
  private final long Vi;
  private final jn Wk;
  private final int mPriority;
  final int xJ;
  
  public jr(int paramInt1, jn paramjn, long paramLong, int paramInt2)
  {
    this.xJ = paramInt1;
    this.Wk = paramjn;
    this.Vi = paramLong;
    this.mPriority = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof jr))
      {
        jr localjr = (jr)paramObject;
        if ((!hl.equal(this.Wk, localjr.Wk)) || (this.Vi != localjr.Vi) || (this.mPriority != localjr.mPriority)) {
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
  
  public long getInterval()
  {
    return this.Vi;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.Wk;
    arrayOfObject[1] = Long.valueOf(this.Vi);
    arrayOfObject[2] = Integer.valueOf(this.mPriority);
    return hl.hashCode(arrayOfObject);
  }
  
  public jn ja()
  {
    return this.Wk;
  }
  
  public String toString()
  {
    return hl.e(this).a("filter", this.Wk).a("interval", Long.valueOf(this.Vi)).a("priority", Integer.valueOf(this.mPriority)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    js.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jr
 * JD-Core Version:    0.7.0.1
 */