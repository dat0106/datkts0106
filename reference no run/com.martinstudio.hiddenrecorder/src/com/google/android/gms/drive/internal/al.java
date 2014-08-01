package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class al
  implements Parcelable.Creator<OnListParentsResponse>
{
  static void a(OnListParentsResponse paramOnListParentsResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnListParentsResponse.xJ);
    b.a(paramParcel, 2, paramOnListParentsResponse.Jy, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OnListParentsResponse am(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int i = 0;
    DataHolder localDataHolder = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new OnListParentsResponse(i, localDataHolder);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        i = a.g(paramParcel, j);
        break;
      case 2: 
        localDataHolder = (DataHolder)a.a(paramParcel, j, DataHolder.CREATOR);
      }
    }
  }
  
  public OnListParentsResponse[] bi(int paramInt)
  {
    return new OnListParentsResponse[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.al
 * JD-Core Version:    0.7.0.1
 */