package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class a
  implements Parcelable.Creator<ChangeEvent>
{
  static void a(ChangeEvent paramChangeEvent, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramChangeEvent.xJ);
    b.a(paramParcel, 2, paramChangeEvent.Hw, paramInt, false);
    b.c(paramParcel, 3, paramChangeEvent.Id);
    b.G(paramParcel, i);
  }
  
  public ChangeEvent P(Parcel paramParcel)
  {
    int j = 0;
    int i = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    Object localObject1 = null;
    Object localObject2 = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new ChangeEvent(localObject2, (DriveId)localObject1, j);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      int m;
      int n;
      Object localObject4;
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        k = j;
        localObject3 = localObject1;
        localObject1 = localObject2;
        break;
      case 1: 
        localObject2 = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        m = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject2;
        m = m;
        break;
      case 2: 
        DriveId localDriveId = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, DriveId.CREATOR);
        localObject1 = localObject2;
        n = localObject3;
        localObject3 = localDriveId;
        break;
      case 3: 
        localObject4 = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        localObject3 = localObject1;
        localObject1 = localObject2;
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
      Object localObject3 = localObject4;
    }
  }
  
  public ChangeEvent[] aJ(int paramInt)
  {
    return new ChangeEvent[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.a
 * JD-Core Version:    0.7.0.1
 */