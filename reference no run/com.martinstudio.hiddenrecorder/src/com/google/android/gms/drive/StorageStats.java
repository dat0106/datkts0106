package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StorageStats
  implements SafeParcelable
{
  public static final Parcelable.Creator<StorageStats> CREATOR = new e();
  final long HY;
  final long HZ;
  final long Ia;
  final long Ib;
  final int Ic;
  final int xJ;
  
  StorageStats(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    this.xJ = paramInt1;
    this.HY = paramLong1;
    this.HZ = paramLong2;
    this.Ia = paramLong3;
    this.Ib = paramLong4;
    this.Ic = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.StorageStats
 * JD-Core Version:    0.7.0.1
 */