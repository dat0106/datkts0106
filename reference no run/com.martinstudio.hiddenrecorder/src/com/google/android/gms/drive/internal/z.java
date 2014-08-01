package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class z
  implements Parcelable.Creator<GetMetadataRequest>
{
  static void a(GetMetadataRequest paramGetMetadataRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramGetMetadataRequest.xJ);
    b.a(paramParcel, 2, paramGetMetadataRequest.Ir, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public GetMetadataRequest ae(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new GetMetadataRequest(i, localDriveId);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
  }
  
  public GetMetadataRequest[] ba(int paramInt)
  {
    return new GetMetadataRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.z
 * JD-Core Version:    0.7.0.1
 */