package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;

public final class LocationRequest
  implements SafeParcelable
{
  public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
  public static final int PRIORITY_HIGH_ACCURACY = 100;
  public static final int PRIORITY_LOW_POWER = 104;
  public static final int PRIORITY_NO_POWER = 105;
  long UY;
  long Vi;
  long Vj;
  boolean Vk;
  int Vl;
  float Vm;
  int mPriority;
  private final int xJ;
  
  public LocationRequest()
  {
    this.xJ = 1;
    this.mPriority = 102;
    this.Vi = 3600000L;
    this.Vj = 600000L;
    this.Vk = false;
    this.UY = 9223372036854775807L;
    this.Vl = 2147483647;
    this.Vm = 0.0F;
  }
  
  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat)
  {
    this.xJ = paramInt1;
    this.mPriority = paramInt2;
    this.Vi = paramLong1;
    this.Vj = paramLong2;
    this.Vk = paramBoolean;
    this.UY = paramLong3;
    this.Vl = paramInt3;
    this.Vm = paramFloat;
  }
  
  private static void a(float paramFloat)
  {
    if (paramFloat >= 0.0F) {
      return;
    }
    throw new IllegalArgumentException("invalid displacement: " + paramFloat);
  }
  
  private static void cG(int paramInt)
  {
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      throw new IllegalArgumentException("invalid quality: " + paramInt);
    }
  }
  
  public static String cH(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 101: 
    case 103: 
    default: 
      str = "???";
      break;
    case 100: 
      str = "PRIORITY_HIGH_ACCURACY";
      break;
    case 102: 
      str = "PRIORITY_BALANCED_POWER_ACCURACY";
      break;
    case 104: 
      str = "PRIORITY_LOW_POWER";
      break;
    case 105: 
      str = "PRIORITY_NO_POWER";
    }
    return str;
  }
  
  public static LocationRequest create()
  {
    return new LocationRequest();
  }
  
  private static void v(long paramLong)
  {
    if (paramLong >= 0L) {
      return;
    }
    throw new IllegalArgumentException("invalid interval: " + paramLong);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if ((paramObject instanceof LocationRequest))
      {
        LocationRequest localLocationRequest = (LocationRequest)paramObject;
        if ((this.mPriority != localLocationRequest.mPriority) || (this.Vi != localLocationRequest.Vi) || (this.Vj != localLocationRequest.Vj) || (this.Vk != localLocationRequest.Vk) || (this.UY != localLocationRequest.UY) || (this.Vl != localLocationRequest.Vl) || (this.Vm != localLocationRequest.Vm)) {
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
  
  public long getExpirationTime()
  {
    return this.UY;
  }
  
  public long getFastestInterval()
  {
    return this.Vj;
  }
  
  public long getInterval()
  {
    return this.Vi;
  }
  
  public int getNumUpdates()
  {
    return this.Vl;
  }
  
  public int getPriority()
  {
    return this.mPriority;
  }
  
  public float getSmallestDisplacement()
  {
    return this.Vm;
  }
  
  int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.mPriority);
    arrayOfObject[1] = Long.valueOf(this.Vi);
    arrayOfObject[2] = Long.valueOf(this.Vj);
    arrayOfObject[3] = Boolean.valueOf(this.Vk);
    arrayOfObject[4] = Long.valueOf(this.UY);
    arrayOfObject[5] = Integer.valueOf(this.Vl);
    arrayOfObject[6] = Float.valueOf(this.Vm);
    return hl.hashCode(arrayOfObject);
  }
  
  public LocationRequest setExpirationDuration(long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    if (paramLong <= 9223372036854775807L - l) {
      this.UY = (l + paramLong);
    } else {
      this.UY = 9223372036854775807L;
    }
    if (this.UY < 0L) {
      this.UY = 0L;
    }
    return this;
  }
  
  public LocationRequest setExpirationTime(long paramLong)
  {
    this.UY = paramLong;
    if (this.UY < 0L) {
      this.UY = 0L;
    }
    return this;
  }
  
  public LocationRequest setFastestInterval(long paramLong)
  {
    v(paramLong);
    this.Vk = true;
    this.Vj = paramLong;
    return this;
  }
  
  public LocationRequest setInterval(long paramLong)
  {
    v(paramLong);
    this.Vi = paramLong;
    if (!this.Vk) {
      this.Vj = ((this.Vi / 6.0D));
    }
    return this;
  }
  
  public LocationRequest setNumUpdates(int paramInt)
  {
    if (paramInt > 0)
    {
      this.Vl = paramInt;
      return this;
    }
    throw new IllegalArgumentException("invalid numUpdates: " + paramInt);
  }
  
  public LocationRequest setPriority(int paramInt)
  {
    cG(paramInt);
    this.mPriority = paramInt;
    return this;
  }
  
  public LocationRequest setSmallestDisplacement(float paramFloat)
  {
    a(paramFloat);
    this.Vm = paramFloat;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(cH(this.mPriority));
    if (this.mPriority != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.Vi + "ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.Vj + "ms");
    if (this.UY != 9223372036854775807L)
    {
      long l = this.UY - SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l + "ms");
    }
    if (this.Vl != 2147483647) {
      localStringBuilder.append(" num=").append(this.Vl);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    LocationRequestCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationRequest
 * JD-Core Version:    0.7.0.1
 */