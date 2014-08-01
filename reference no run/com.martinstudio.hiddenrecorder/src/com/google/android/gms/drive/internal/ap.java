package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.StorageStats;

public class ap
  implements Parcelable.Creator<OnStorageStatsResponse>
{
  static void a(OnStorageStatsResponse paramOnStorageStatsResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnStorageStatsResponse.xJ);
    b.a(paramParcel, 2, paramOnStorageStatsResponse.JA, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OnStorageStatsResponse aq(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int k = 0;
    StorageStats localStorageStats = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new OnStorageStatsResponse(k, localStorageStats);
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
        localStorageStats = (StorageStats)a.a(paramParcel, i, StorageStats.CREATOR);
      }
    }
  }
  
  public OnStorageStatsResponse[] bm(int paramInt)
  {
    return new OnStorageStatsResponse[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ap
 * JD-Core Version:    0.7.0.1
 */