package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class ao
  implements Parcelable.Creator<OnResourceIdSetResponse>
{
  static void a(OnResourceIdSetResponse paramOnResourceIdSetResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnResourceIdSetResponse.getVersionCode());
    b.a(paramParcel, 2, paramOnResourceIdSetResponse.gj(), false);
    b.G(paramParcel, i);
  }
  
  public OnResourceIdSetResponse ap(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    Object localObject = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new OnResourceIdSetResponse(i, (List)localObject);
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
        localObject = a.B(paramParcel, k);
      }
    }
  }
  
  public OnResourceIdSetResponse[] bl(int paramInt)
  {
    return new OnResourceIdSetResponse[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ao
 * JD-Core Version:    0.7.0.1
 */