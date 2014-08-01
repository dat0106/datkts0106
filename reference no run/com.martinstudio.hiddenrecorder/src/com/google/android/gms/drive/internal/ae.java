package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ae
  implements Parcelable.Creator<LoadRealtimeRequest>
{
  static void a(LoadRealtimeRequest paramLoadRealtimeRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramLoadRealtimeRequest.xJ);
    b.a(paramParcel, 2, paramLoadRealtimeRequest.Hw, paramInt, false);
    b.a(paramParcel, 3, paramLoadRealtimeRequest.Jp);
    b.G(paramParcel, i);
  }
  
  public LoadRealtimeRequest ag(Parcel paramParcel)
  {
    int k = 0;
    int i = a.B(paramParcel);
    Object localObject2 = null;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new LoadRealtimeRequest(j, (DriveId)localObject2, k);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int m = a.A(paramParcel);
      int n;
      int i1;
      Object localObject3;
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        m = k;
        localObject1 = localObject2;
        j = j;
        break;
      case 1: 
        j = a.g(paramParcel, m);
        n = localObject1;
        localObject1 = localObject2;
        j = j;
        n = n;
        break;
      case 2: 
        localObject2 = (DriveId)a.a(paramParcel, n, DriveId.CREATOR);
        j = j;
        i1 = localObject1;
        localObject1 = localObject2;
        break;
      case 3: 
        localObject3 = a.c(paramParcel, i1);
        localObject1 = localObject2;
        j = j;
      }
      j = j;
      localObject2 = localObject1;
      Object localObject1 = localObject3;
    }
  }
  
  public LoadRealtimeRequest[] bc(int paramInt)
  {
    return new LoadRealtimeRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ae
 * JD-Core Version:    0.7.0.1
 */