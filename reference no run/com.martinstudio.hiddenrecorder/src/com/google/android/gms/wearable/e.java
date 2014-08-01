package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e
  implements Parcelable.Creator<PutDataRequest>
{
  static void a(PutDataRequest paramPutDataRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramPutDataRequest.xJ);
    b.a(paramParcel, 2, paramPutDataRequest.getUri(), paramInt, false);
    b.a(paramParcel, 4, paramPutDataRequest.nh(), false);
    b.a(paramParcel, 5, paramPutDataRequest.getData(), false);
    b.G(paramParcel, i);
  }
  
  public PutDataRequest cu(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = a.B(paramParcel);
    Uri localUri2 = 0;
    Object localObject4 = null;
    Uri localUri1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new PutDataRequest(localUri2, localUri1, (Bundle)localObject4, (byte[])localObject1);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      Object localObject6;
      int j;
      Object localObject2;
      switch (a.ar(k))
      {
      case 3: 
      default: 
        a.b(paramParcel, k);
        localObject6 = localObject1;
        localObject1 = localObject4;
        localObject4 = localUri1;
        localUri1 = localUri2;
        break;
      case 1: 
        localUri2 = a.g(paramParcel, localObject6);
        localObject6 = localObject1;
        localObject1 = localObject4;
        localObject4 = localUri1;
        localUri1 = localUri2;
        localObject6 = localObject6;
        break;
      case 2: 
        localObject6 = (Uri)a.a(paramParcel, localObject6, Uri.CREATOR);
        localUri1 = localUri2;
        localObject5 = localObject4;
        localObject4 = localObject6;
        localObject6 = localObject1;
        localObject1 = localObject5;
        break;
      case 4: 
        localObject6 = a.q(paramParcel, localObject6);
        localObject4 = localUri1;
        j = localObject5;
        localObject5 = localObject1;
        localObject1 = localObject6;
        localObject6 = localObject5;
        break;
      case 5: 
        localObject6 = a.r(paramParcel, localObject6);
        localObject1 = localObject4;
        localObject4 = j;
        localObject2 = localObject5;
      }
      Object localObject5 = localObject2;
      Object localObject3 = localObject4;
      localObject4 = localObject1;
      localObject1 = localObject6;
    }
  }
  
  public PutDataRequest[] ec(int paramInt)
  {
    return new PutDataRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.e
 * JD-Core Version:    0.7.0.1
 */