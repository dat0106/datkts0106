package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class e
  implements Parcelable.Creator<CloseContentsAndUpdateMetadataRequest>
{
  static void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCloseContentsAndUpdateMetadataRequest.xJ);
    b.a(paramParcel, 2, paramCloseContentsAndUpdateMetadataRequest.Ir, paramInt, false);
    b.a(paramParcel, 3, paramCloseContentsAndUpdateMetadataRequest.Is, paramInt, false);
    b.a(paramParcel, 4, paramCloseContentsAndUpdateMetadataRequest.It, paramInt, false);
    b.a(paramParcel, 5, paramCloseContentsAndUpdateMetadataRequest.Iu);
    b.a(paramParcel, 6, paramCloseContentsAndUpdateMetadataRequest.Iv, false);
    b.G(paramParcel, i);
  }
  
  public CloseContentsAndUpdateMetadataRequest U(Parcel paramParcel)
  {
    boolean bool = false;
    String str = null;
    int j = a.B(paramParcel);
    Contents localContents = null;
    MetadataBundle localMetadataBundle = null;
    DriveId localDriveId = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new CloseContentsAndUpdateMetadataRequest(k, localDriveId, localMetadataBundle, localContents, bool, str);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        k = a.g(paramParcel, i);
        break;
      case 2: 
        localDriveId = (DriveId)a.a(paramParcel, i, DriveId.CREATOR);
        break;
      case 3: 
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, i, MetadataBundle.CREATOR);
        break;
      case 4: 
        localContents = (Contents)a.a(paramParcel, i, Contents.CREATOR);
        break;
      case 5: 
        bool = a.c(paramParcel, i);
        break;
      case 6: 
        str = a.o(paramParcel, i);
      }
    }
  }
  
  public CloseContentsAndUpdateMetadataRequest[] aP(int paramInt)
  {
    return new CloseContentsAndUpdateMetadataRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.e
 * JD-Core Version:    0.7.0.1
 */