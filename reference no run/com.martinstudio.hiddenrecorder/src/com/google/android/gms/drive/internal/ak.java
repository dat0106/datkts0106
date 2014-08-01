package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ak
  implements Parcelable.Creator<OnListEntriesResponse>
{
  static void a(OnListEntriesResponse paramOnListEntriesResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnListEntriesResponse.xJ);
    b.a(paramParcel, 2, paramOnListEntriesResponse.Jx, paramInt, false);
    b.a(paramParcel, 3, paramOnListEntriesResponse.IM);
    b.G(paramParcel, i);
  }
  
  public OnListEntriesResponse al(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.B(paramParcel);
    DataHolder localDataHolder = null;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new OnListEntriesResponse(j, localDataHolder, bool);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        bool = bool;
        localDataHolder = localDataHolder;
        j = j;
        break;
      case 1: 
        j = a.g(paramParcel, k);
        bool = bool;
        localDataHolder = localDataHolder;
        j = j;
        bool = bool;
        break;
      case 2: 
        localDataHolder = (DataHolder)a.a(paramParcel, k, DataHolder.CREATOR);
        j = j;
        bool = bool;
        localDataHolder = localDataHolder;
        break;
      case 3: 
        bool = a.c(paramParcel, k);
        localDataHolder = localDataHolder;
        j = j;
      }
      j = j;
      localDataHolder = localDataHolder;
      bool = bool;
    }
  }
  
  public OnListEntriesResponse[] bh(int paramInt)
  {
    return new OnListEntriesResponse[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ak
 * JD-Core Version:    0.7.0.1
 */