package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class a
  implements Parcelable.Creator<AddEventListenerRequest>
{
  static void a(AddEventListenerRequest paramAddEventListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramAddEventListenerRequest.xJ);
    b.a(paramParcel, 2, paramAddEventListenerRequest.Hw, paramInt, false);
    b.c(paramParcel, 3, paramAddEventListenerRequest.In);
    b.a(paramParcel, 4, paramAddEventListenerRequest.Io, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public AddEventListenerRequest R(Parcel paramParcel)
  {
    Object localObject1 = null;
    Object localObject2 = 0;
    int i = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new AddEventListenerRequest(j, localDriveId, localObject2, (PendingIntent)localObject1);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      Object localObject3;
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localDriveId = localDriveId;
        j = j;
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, localObject3);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localDriveId = localDriveId;
        j = j;
        localObject3 = localObject3;
        break;
      case 2: 
        localDriveId = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, localObject3, DriveId.CREATOR);
        j = j;
        localObject2 = localObject2;
        localDriveId = localDriveId;
        localObject3 = localObject1;
        localObject1 = localObject2;
        break;
      case 3: 
        localObject2 = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, localObject3);
        localDriveId = localDriveId;
        j = j;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject3 = localObject3;
        break;
      case 4: 
        localObject3 = (PendingIntent)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, localObject3, PendingIntent.CREATOR);
        localObject1 = localObject2;
        localDriveId = localDriveId;
        j = j;
      }
      j = j;
      localDriveId = localDriveId;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public AddEventListenerRequest[] aM(int paramInt)
  {
    return new AddEventListenerRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.a
 * JD-Core Version:    0.7.0.1
 */