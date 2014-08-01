package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ai
  implements Parcelable.Creator<OnDriveIdResponse>
{
  static void a(OnDriveIdResponse paramOnDriveIdResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnDriveIdResponse.xJ);
    b.a(paramParcel, 2, paramOnDriveIdResponse.Ir, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OnDriveIdResponse aj(Parcel paramParcel)
  {
    int i = a.B(paramParcel);
    int j = 0;
    DriveId localDriveId = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new OnDriveIdResponse(j, localDriveId);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
  }
  
  public OnDriveIdResponse[] bf(int paramInt)
  {
    return new OnDriveIdResponse[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ai
 * JD-Core Version:    0.7.0.1
 */