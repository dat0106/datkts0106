package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenFileIntentSenderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<OpenFileIntentSenderRequest> CREATOR = new as();
  final String HV;
  final String[] HW;
  final DriveId HX;
  final int xJ;
  
  OpenFileIntentSenderRequest(int paramInt, String paramString, String[] paramArrayOfString, DriveId paramDriveId)
  {
    this.xJ = paramInt;
    this.HV = paramString;
    this.HW = paramArrayOfString;
    this.HX = paramDriveId;
  }
  
  public OpenFileIntentSenderRequest(String paramString, String[] paramArrayOfString, DriveId paramDriveId)
  {
    this(1, paramString, paramArrayOfString, paramDriveId);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    as.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OpenFileIntentSenderRequest
 * JD-Core Version:    0.7.0.1
 */