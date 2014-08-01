package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class aq
  implements Parcelable.Creator<OnSyncMoreResponse>
{
  static void a(OnSyncMoreResponse paramOnSyncMoreResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnSyncMoreResponse.xJ);
    b.a(paramParcel, 2, paramOnSyncMoreResponse.IM);
    b.G(paramParcel, i);
  }
  
  public OnSyncMoreResponse ar(Parcel paramParcel)
  {
    boolean bool = false;
    int j = a.B(paramParcel);
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new OnSyncMoreResponse(i, bool);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        bool = a.c(paramParcel, k);
      }
    }
  }
  
  public OnSyncMoreResponse[] bn(int paramInt)
  {
    return new OnSyncMoreResponse[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.aq
 * JD-Core Version:    0.7.0.1
 */