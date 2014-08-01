package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class i
  implements Parcelable.Creator<CreateFileIntentSenderRequest>
{
  static void a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCreateFileIntentSenderRequest.xJ);
    b.a(paramParcel, 2, paramCreateFileIntentSenderRequest.IA, paramInt, false);
    b.c(paramParcel, 3, paramCreateFileIntentSenderRequest.qX);
    b.a(paramParcel, 4, paramCreateFileIntentSenderRequest.HV, false);
    b.a(paramParcel, 5, paramCreateFileIntentSenderRequest.HX, paramInt, false);
    b.a(paramParcel, 6, paramCreateFileIntentSenderRequest.IB, false);
    b.G(paramParcel, i);
  }
  
  public CreateFileIntentSenderRequest X(Parcel paramParcel)
  {
    int k = 0;
    Integer localInteger = null;
    int j = a.B(paramParcel);
    DriveId localDriveId = null;
    String str = null;
    MetadataBundle localMetadataBundle = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new CreateFileIntentSenderRequest(m, localMetadataBundle, k, str, localDriveId, localInteger);
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
        m = a.g(paramParcel, i);
        break;
      case 2: 
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, i, MetadataBundle.CREATOR);
        break;
      case 3: 
        k = a.g(paramParcel, i);
        break;
      case 4: 
        str = a.o(paramParcel, i);
        break;
      case 5: 
        localDriveId = (DriveId)a.a(paramParcel, i, DriveId.CREATOR);
        break;
      case 6: 
        localInteger = a.h(paramParcel, i);
      }
    }
  }
  
  public CreateFileIntentSenderRequest[] aT(int paramInt)
  {
    return new CreateFileIntentSenderRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.i
 * JD-Core Version:    0.7.0.1
 */