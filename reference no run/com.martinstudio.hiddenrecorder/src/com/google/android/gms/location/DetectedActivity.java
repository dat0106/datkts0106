package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DetectedActivity
  implements SafeParcelable
{
  public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
  public static final int IN_VEHICLE = 0;
  public static final int ON_BICYCLE = 1;
  public static final int ON_FOOT = 2;
  public static final int RUNNING = 8;
  public static final int STILL = 3;
  public static final int TILTING = 5;
  public static final int UNKNOWN = 4;
  public static final int WALKING = 7;
  int UV;
  int UW;
  private final int xJ;
  
  public DetectedActivity(int paramInt1, int paramInt2)
  {
    this.xJ = 1;
    this.UV = paramInt1;
    this.UW = paramInt2;
  }
  
  public DetectedActivity(int paramInt1, int paramInt2, int paramInt3)
  {
    this.xJ = paramInt1;
    this.UV = paramInt2;
    this.UW = paramInt3;
  }
  
  private int cF(int paramInt)
  {
    if (paramInt > 8) {
      paramInt = 4;
    }
    return paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getConfidence()
  {
    return this.UW;
  }
  
  public int getType()
  {
    return cF(this.UV);
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public String toString()
  {
    return "DetectedActivity [type=" + getType() + ", confidence=" + this.UW + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    DetectedActivityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.DetectedActivity
 * JD-Core Version:    0.7.0.1
 */