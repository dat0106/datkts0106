package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class n
  implements Parcelable.Creator<DeleteResourceRequest>
{
  static void a(DeleteResourceRequest paramDeleteResourceRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramDeleteResourceRequest.xJ);
    b.a(paramParcel, 2, paramDeleteResourceRequest.Ir, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public DeleteResourceRequest[] aX(int paramInt)
  {
    return new DeleteResourceRequest[paramInt];
  }
  
  public DeleteResourceRequest ab(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int k = 0;
    DriveId localDriveId = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new DeleteResourceRequest(k, localDriveId);
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
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.n
 * JD-Core Version:    0.7.0.1
 */