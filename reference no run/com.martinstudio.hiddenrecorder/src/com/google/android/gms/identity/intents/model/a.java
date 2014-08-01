package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<CountrySpecification>
{
  static void a(CountrySpecification paramCountrySpecification, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCountrySpecification.getVersionCode());
    b.a(paramParcel, 2, paramCountrySpecification.rc, false);
    b.G(paramParcel, i);
  }
  
  public CountrySpecification bq(Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    int k = 0;
    String str = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new CountrySpecification(k, str);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int j = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(j))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, j);
        break;
      case 1: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, j);
        break;
      case 2: 
        str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, j);
      }
    }
  }
  
  public CountrySpecification[] cD(int paramInt)
  {
    return new CountrySpecification[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.model.a
 * JD-Core Version:    0.7.0.1
 */