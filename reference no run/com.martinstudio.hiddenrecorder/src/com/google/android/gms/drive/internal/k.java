package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class k
  implements Parcelable.Creator<CreateFolderRequest>
{
  static void a(CreateFolderRequest paramCreateFolderRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCreateFolderRequest.xJ);
    b.a(paramParcel, 2, paramCreateFolderRequest.IC, paramInt, false);
    b.a(paramParcel, 3, paramCreateFolderRequest.IA, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public CreateFolderRequest Z(Parcel paramParcel)
  {
    MetadataBundle localMetadataBundle = null;
    int i = a.B(paramParcel);
    int j = 0;
    DriveId localDriveId = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new CreateFolderRequest(j, localDriveId, localMetadataBundle);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        localMetadataBundle = localMetadataBundle;
        localDriveId = localDriveId;
        j = j;
        break;
      case 1: 
        j = a.g(paramParcel, k);
        localMetadataBundle = localMetadataBundle;
        localDriveId = localDriveId;
        j = j;
        localMetadataBundle = localMetadataBundle;
        break;
      case 2: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
        j = j;
        localMetadataBundle = localMetadataBundle;
        localDriveId = localDriveId;
        break;
      case 3: 
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, k, MetadataBundle.CREATOR);
        localDriveId = localDriveId;
        j = j;
      }
      j = j;
      localDriveId = localDriveId;
      localMetadataBundle = localMetadataBundle;
    }
  }
  
  public CreateFolderRequest[] aV(int paramInt)
  {
    return new CreateFolderRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.k
 * JD-Core Version:    0.7.0.1
 */