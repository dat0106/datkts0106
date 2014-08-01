package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<BeginCompoundOperationRequest>
{
  static void a(BeginCompoundOperationRequest paramBeginCompoundOperationRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramBeginCompoundOperationRequest.xJ);
    b.a(paramParcel, 2, paramBeginCompoundOperationRequest.Lg);
    b.a(paramParcel, 3, paramBeginCompoundOperationRequest.mName, false);
    b.G(paramParcel, i);
  }
  
  public BeginCompoundOperationRequest aP(Parcel paramParcel)
  {
    boolean bool = false;
    int j = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    String str = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new BeginCompoundOperationRequest(k, bool, str);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int i = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(i))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i);
        break;
      case 1: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i);
        break;
      case 2: 
        bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, i);
        break;
      case 3: 
        str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i);
      }
    }
  }
  
  public BeginCompoundOperationRequest[] bL(int paramInt)
  {
    return new BeginCompoundOperationRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.a
 * JD-Core Version:    0.7.0.1
 */