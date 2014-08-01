package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ar
  implements Parcelable.Creator<OpenContentsRequest>
{
  static void a(OpenContentsRequest paramOpenContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOpenContentsRequest.xJ);
    b.a(paramParcel, 2, paramOpenContentsRequest.Ir, paramInt, false);
    b.c(paramParcel, 3, paramOpenContentsRequest.Hv);
    b.G(paramParcel, i);
  }
  
  public OpenContentsRequest as(Parcel paramParcel)
  {
    int k = 0;
    int i = a.B(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new OpenContentsRequest(j, localDriveId, k);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        k = k;
        localDriveId = localDriveId;
        j = j;
        break;
      case 1: 
        j = a.g(paramParcel, m);
        k = k;
        localDriveId = localDriveId;
        j = j;
        k = k;
        break;
      case 2: 
        localDriveId = (DriveId)a.a(paramParcel, m, DriveId.CREATOR);
        j = j;
        k = k;
        localDriveId = localDriveId;
        break;
      case 3: 
        k = a.g(paramParcel, m);
        localDriveId = localDriveId;
        j = j;
      }
      j = j;
      localDriveId = localDriveId;
      k = k;
    }
  }
  
  public OpenContentsRequest[] bo(int paramInt)
  {
    return new OpenContentsRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ar
 * JD-Core Version:    0.7.0.1
 */