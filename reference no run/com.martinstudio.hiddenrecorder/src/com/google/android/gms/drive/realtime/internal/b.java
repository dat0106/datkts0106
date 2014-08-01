package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<EndCompoundOperationRequest>
{
  static void a(EndCompoundOperationRequest paramEndCompoundOperationRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramEndCompoundOperationRequest.xJ);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public EndCompoundOperationRequest aQ(Parcel paramParcel)
  {
    int i = a.B(paramParcel);
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new EndCompoundOperationRequest(j);
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
      }
    }
  }
  
  public EndCompoundOperationRequest[] bM(int paramInt)
  {
    return new EndCompoundOperationRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.b
 * JD-Core Version:    0.7.0.1
 */