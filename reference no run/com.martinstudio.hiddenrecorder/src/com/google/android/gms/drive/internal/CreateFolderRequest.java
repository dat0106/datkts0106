package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.hn;

public class CreateFolderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateFolderRequest> CREATOR = new k();
  final MetadataBundle IA;
  final DriveId IC;
  final int xJ;
  
  CreateFolderRequest(int paramInt, DriveId paramDriveId, MetadataBundle paramMetadataBundle)
  {
    this.xJ = paramInt;
    this.IC = ((DriveId)hn.f(paramDriveId));
    this.IA = ((MetadataBundle)hn.f(paramMetadataBundle));
  }
  
  public CreateFolderRequest(DriveId paramDriveId, MetadataBundle paramMetadataBundle)
  {
    this(1, paramDriveId, paramMetadataBundle);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.CreateFolderRequest
 * JD-Core Version:    0.7.0.1
 */