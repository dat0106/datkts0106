package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class LoadRealtimeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoadRealtimeRequest> CREATOR = new ae();
  final DriveId Hw;
  final boolean Jp;
  final int xJ;
  
  LoadRealtimeRequest(int paramInt, DriveId paramDriveId, boolean paramBoolean)
  {
    this.xJ = paramInt;
    this.Hw = paramDriveId;
    this.Jp = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ae.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.LoadRealtimeRequest
 * JD-Core Version:    0.7.0.1
 */