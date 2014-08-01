package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ad
  implements Parcelable.Creator<ListParentsRequest>
{
  static void a(ListParentsRequest paramListParentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramListParentsRequest.xJ);
    b.a(paramParcel, 2, paramListParentsRequest.Jo, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public ListParentsRequest af(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new ListParentsRequest(i, localDriveId);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        i = a.g(paramParcel, j);
        break;
      case 2: 
        localDriveId = (DriveId)a.a(paramParcel, j, DriveId.CREATOR);
      }
    }
  }
  
  public ListParentsRequest[] bb(int paramInt)
  {
    return new ListParentsRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ad
 * JD-Core Version:    0.7.0.1
 */