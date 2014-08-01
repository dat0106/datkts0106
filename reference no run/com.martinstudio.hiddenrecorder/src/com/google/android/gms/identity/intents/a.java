package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.List;

public class a
  implements Parcelable.Creator<UserAddressRequest>
{
  static void a(UserAddressRequest paramUserAddressRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramUserAddressRequest.getVersionCode());
    b.b(paramParcel, 2, paramUserAddressRequest.UB, false);
    b.G(paramParcel, i);
  }
  
  public UserAddressRequest bp(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    int i = 0;
    Object localObject = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new UserAddressRequest(i, (List)localObject);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int k = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2: 
        localObject = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, CountrySpecification.CREATOR);
      }
    }
  }
  
  public UserAddressRequest[] cC(int paramInt)
  {
    return new UserAddressRequest[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.a
 * JD-Core Version:    0.7.0.1
 */