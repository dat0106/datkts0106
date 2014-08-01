package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ag
  implements Parcelable.Creator<af>
{
  static void a(af paramaf, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramaf.xJ);
    b.c(paramParcel, 2, paramaf.getRequestId());
    b.a(paramParcel, 3, paramaf.getPath(), false);
    b.a(paramParcel, 4, paramaf.getData(), false);
    b.a(paramParcel, 5, paramaf.getSourceNodeId(), false);
    b.G(paramParcel, i);
  }
  
  public af cE(Parcel paramParcel)
  {
    int m = 0;
    String str1 = null;
    int i = a.B(paramParcel);
    byte[] arrayOfByte = null;
    String str2 = null;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new af(j, m, str2, arrayOfByte, str1);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        m = a.g(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
        break;
      case 4: 
        arrayOfByte = a.r(paramParcel, k);
        break;
      case 5: 
        str1 = a.o(paramParcel, k);
      }
    }
  }
  
  public af[] en(int paramInt)
  {
    return new af[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ag
 * JD-Core Version:    0.7.0.1
 */