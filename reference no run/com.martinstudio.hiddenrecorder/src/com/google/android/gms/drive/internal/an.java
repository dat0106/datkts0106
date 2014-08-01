package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class an
  implements Parcelable.Creator<OnLoadRealtimeResponse>
{
  static void a(OnLoadRealtimeResponse paramOnLoadRealtimeResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnLoadRealtimeResponse.xJ);
    b.a(paramParcel, 2, paramOnLoadRealtimeResponse.Jz);
    b.G(paramParcel, i);
  }
  
  public OnLoadRealtimeResponse ao(Parcel paramParcel)
  {
    boolean bool = false;
    int j = a.B(paramParcel);
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new OnLoadRealtimeResponse(k, bool);
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
        break;
      case 2: 
        bool = a.c(paramParcel, i);
      }
    }
  }
  
  public OnLoadRealtimeResponse[] bk(int paramInt)
  {
    return new OnLoadRealtimeResponse[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.an
 * JD-Core Version:    0.7.0.1
 */