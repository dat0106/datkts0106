package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<CountrySpecification>
{
  static void a(CountrySpecification paramCountrySpecification, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCountrySpecification.getVersionCode());
    b.a(paramParcel, 2, paramCountrySpecification.rc, false);
    b.G(paramParcel, i);
  }
  
  public CountrySpecification bS(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int i = 0;
    String str = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new CountrySpecification(i, str);
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
        str = a.o(paramParcel, j);
      }
    }
  }
  
  public CountrySpecification[] dy(int paramInt)
  {
    return new CountrySpecification[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.c
 * JD-Core Version:    0.7.0.1
 */