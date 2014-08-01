package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AddEventListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddEventListenerRequest> CREATOR = new a();
  final DriveId Hw;
  final int In;
  final PendingIntent Io;
  final int xJ;
  
  AddEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2, PendingIntent paramPendingIntent)
  {
    this.xJ = paramInt1;
    this.Hw = paramDriveId;
    this.In = paramInt2;
    this.Io = paramPendingIntent;
  }
  
  public AddEventListenerRequest(DriveId paramDriveId, int paramInt, PendingIntent paramPendingIntent)
  {
    this(1, paramDriveId, paramInt, paramPendingIntent);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.AddEventListenerRequest
 * JD-Core Version:    0.7.0.1
 */