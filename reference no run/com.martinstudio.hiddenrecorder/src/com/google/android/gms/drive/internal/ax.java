package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ax
  implements Parcelable.Creator<TrashResourceRequest>
{
  static void a(TrashResourceRequest paramTrashResourceRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramTrashResourceRequest.xJ);
    b.a(paramParcel, 2, paramTrashResourceRequest.Ir, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public TrashResourceRequest ax(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int j = 0;
    DriveId localDriveId = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new TrashResourceRequest(j, localDriveId);
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
      }
    }
  }
  
  public TrashResourceRequest[] bt(int paramInt)
  {
    return new TrashResourceRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ax
 * JD-Core Version:    0.7.0.1
 */