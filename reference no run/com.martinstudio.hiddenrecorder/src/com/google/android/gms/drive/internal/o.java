package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class o
  implements Parcelable.Creator<DisconnectRequest>
{
  static void a(DisconnectRequest paramDisconnectRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramDisconnectRequest.xJ);
    b.G(paramParcel, i);
  }
  
  public DisconnectRequest[] aY(int paramInt)
  {
    return new DisconnectRequest[paramInt];
  }
  
  public DisconnectRequest ac(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new DisconnectRequest(k);
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
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.o
 * JD-Core Version:    0.7.0.1
 */