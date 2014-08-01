package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<InstrumentInfo>
{
  static void a(InstrumentInfo paramInstrumentInfo, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramInstrumentInfo.getVersionCode());
    b.a(paramParcel, 2, paramInstrumentInfo.getInstrumentType(), false);
    b.a(paramParcel, 3, paramInstrumentInfo.getInstrumentDetails(), false);
    b.G(paramParcel, i);
  }
  
  public InstrumentInfo bW(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.B(paramParcel);
    int k = 0;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new InstrumentInfo(k, str1, str2);
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
        str1 = a.o(paramParcel, i);
        break;
      case 3: 
        str2 = a.o(paramParcel, i);
      }
    }
  }
  
  public InstrumentInfo[] dC(int paramInt)
  {
    return new InstrumentInfo[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.h
 * JD-Core Version:    0.7.0.1
 */