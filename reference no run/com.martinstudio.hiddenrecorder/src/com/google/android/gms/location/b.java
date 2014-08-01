package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;

public class b
  implements SafeParcelable
{
  public static final c CREATOR = new c();
  int Vn;
  int Vo;
  long Vp;
  private final int xJ;
  
  b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.xJ = paramInt1;
    this.Vn = paramInt2;
    this.Vo = paramInt3;
    this.Vp = paramLong;
  }
  
  private String cI(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 1: 
    default: 
      str = "STATUS_UNKNOWN";
      break;
    case 0: 
      str = "STATUS_SUCCESSFUL";
      break;
    case 2: 
      str = "STATUS_TIMED_OUT_ON_SCAN";
      break;
    case 3: 
      str = "STATUS_NO_INFO_IN_DATABASE";
      break;
    case 4: 
      str = "STATUS_INVALID_SCAN";
      break;
    case 5: 
      str = "STATUS_UNABLE_TO_QUERY_DATABASE";
      break;
    case 6: 
      str = "STATUS_SCANS_DISABLED_IN_SETTINGS";
      break;
    case 7: 
      str = "STATUS_LOCATION_DISABLED_IN_SETTINGS";
      break;
    case 8: 
      str = "STATUS_IN_PROGRESS";
    }
    return str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof b))
    {
      b localb = (b)paramObject;
      if ((this.Vn == localb.Vn) && (this.Vo == localb.Vo) && (this.Vp == localb.Vp)) {
        bool = true;
      }
    }
    return bool;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.Vn);
    arrayOfObject[1] = Integer.valueOf(this.Vo);
    arrayOfObject[2] = Long.valueOf(this.Vp);
    return hl.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationStatus[cell status: ").append(cI(this.Vn));
    localStringBuilder.append(", wifi status: ").append(cI(this.Vo));
    localStringBuilder.append(", elapsed realtime ns: ").append(this.Vp);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.b
 * JD-Core Version:    0.7.0.1
 */