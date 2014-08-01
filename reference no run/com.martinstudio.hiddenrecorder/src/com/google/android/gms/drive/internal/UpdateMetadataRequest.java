package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UpdateMetadataRequest> CREATOR = new ay();
  final DriveId Ir;
  final MetadataBundle Is;
  final int xJ;
  
  UpdateMetadataRequest(int paramInt, DriveId paramDriveId, MetadataBundle paramMetadataBundle)
  {
    this.xJ = paramInt;
    this.Ir = paramDriveId;
    this.Is = paramMetadataBundle;
  }
  
  public UpdateMetadataRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle)
  {
    this(1, paramDriveId, paramMetadataBundle);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ay.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.UpdateMetadataRequest
 * JD-Core Version:    0.7.0.1
 */