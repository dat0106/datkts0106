package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class au
  implements Parcelable.Creator<RemoveEventListenerRequest>
{
  static void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramRemoveEventListenerRequest.xJ);
    b.a(paramParcel, 2, paramRemoveEventListenerRequest.Hw, paramInt, false);
    b.c(paramParcel, 3, paramRemoveEventListenerRequest.In);
    b.G(paramParcel, i);
  }
  
  public RemoveEventListenerRequest av(Parcel paramParcel)
  {
    int j = 0;
    int i = a.B(paramParcel);
    Object localObject1 = null;
    Object localObject2 = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new RemoveEventListenerRequest(localObject2, (DriveId)localObject1, j);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      Object localObject3;
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        j = j;
        localObject3 = localObject1;
        localObject1 = localObject2;
        break;
      case 1: 
        localObject2 = a.g(paramParcel, localObject3);
        j = j;
        localObject3 = localObject1;
        localObject1 = localObject2;
        j = j;
        break;
      case 2: 
        localObject3 = (DriveId)a.a(paramParcel, localObject3, DriveId.CREATOR);
        localObject1 = localObject2;
        j = j;
        localObject3 = localObject3;
        break;
      case 3: 
        j = a.g(paramParcel, localObject3);
        localObject3 = localObject1;
        localObject1 = localObject2;
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
      j = j;
    }
  }
  
  public RemoveEventListenerRequest[] br(int paramInt)
  {
    return new RemoveEventListenerRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.au
 * JD-Core Version:    0.7.0.1
 */