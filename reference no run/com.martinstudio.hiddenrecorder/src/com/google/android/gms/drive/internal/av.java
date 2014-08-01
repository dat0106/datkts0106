package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class av
  implements Parcelable.Creator<SetResourceParentsRequest>
{
  static void a(SetResourceParentsRequest paramSetResourceParentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramSetResourceParentsRequest.xJ);
    b.a(paramParcel, 2, paramSetResourceParentsRequest.JC, paramInt, false);
    b.b(paramParcel, 3, paramSetResourceParentsRequest.JD, false);
    b.G(paramParcel, i);
  }
  
  public SetResourceParentsRequest aw(Parcel paramParcel)
  {
    Object localObject3 = null;
    int i = a.B(paramParcel);
    Object localObject2 = 0;
    Object localObject1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new SetResourceParentsRequest(localObject2, (DriveId)localObject1, (List)localObject3);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int j = a.A(paramParcel);
      Object localObject4;
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        localObject4 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject2;
        break;
      case 1: 
        localObject2 = a.g(paramParcel, localObject4);
        localObject4 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject4 = localObject4;
        break;
      case 2: 
        DriveId localDriveId = (DriveId)a.a(paramParcel, localObject4, DriveId.CREATOR);
        localObject1 = localObject2;
        localObject4 = localObject3;
        localObject3 = localDriveId;
        break;
      case 3: 
        localObject4 = a.c(paramParcel, localObject4, DriveId.CREATOR);
        localObject3 = localObject1;
        localObject1 = localObject2;
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
    }
  }
  
  public SetResourceParentsRequest[] bs(int paramInt)
  {
    return new SetResourceParentsRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.av
 * JD-Core Version:    0.7.0.1
 */