package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class j
  implements Parcelable.Creator<CreateFileRequest>
{
  static void a(CreateFileRequest paramCreateFileRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCreateFileRequest.xJ);
    b.a(paramParcel, 2, paramCreateFileRequest.IC, paramInt, false);
    b.a(paramParcel, 3, paramCreateFileRequest.IA, paramInt, false);
    b.a(paramParcel, 4, paramCreateFileRequest.It, paramInt, false);
    b.a(paramParcel, 5, paramCreateFileRequest.IB, false);
    b.a(paramParcel, 6, paramCreateFileRequest.IE);
    b.a(paramParcel, 7, paramCreateFileRequest.Iv, false);
    b.G(paramParcel, i);
  }
  
  public CreateFileRequest Y(Parcel paramParcel)
  {
    boolean bool = false;
    String str = null;
    int k = a.B(paramParcel);
    Integer localInteger = null;
    Contents localContents = null;
    MetadataBundle localMetadataBundle = null;
    DriveId localDriveId = null;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new CreateFileRequest(j, localDriveId, localMetadataBundle, localContents, localInteger, bool, str);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        j = a.g(paramParcel, i);
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
        localInteger = a.h(paramParcel, i);
        break;
      case 6: 
        bool = a.c(paramParcel, i);
        break;
      case 7: 
        str = a.o(paramParcel, i);
      }
    }
  }
  
  public CreateFileRequest[] aU(int paramInt)
  {
    return new CreateFileRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.j
 * JD-Core Version:    0.7.0.1
 */