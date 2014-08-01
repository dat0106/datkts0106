package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class d
  implements Parcelable.Creator<CheckResourceIdsExistRequest>
{
  static void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCheckResourceIdsExistRequest.getVersionCode());
    b.a(paramParcel, 2, paramCheckResourceIdsExistRequest.gj(), false);
    b.G(paramParcel, i);
  }
  
  public CheckResourceIdsExistRequest T(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int i = 0;
    Object localObject = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new CheckResourceIdsExistRequest(i, (List)localObject);
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
        localObject = a.B(paramParcel, j);
      }
    }
  }
  
  public CheckResourceIdsExistRequest[] aO(int paramInt)
  {
    return new CheckResourceIdsExistRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.d
 * JD-Core Version:    0.7.0.1
 */