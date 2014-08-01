package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class aj
  implements Parcelable.Creator<ai>
{
  static void a(ai paramai, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramai.xJ);
    b.a(paramParcel, 2, paramai.getId(), false);
    b.a(paramParcel, 3, paramai.getDisplayName(), false);
    b.G(paramParcel, i);
  }
  
  public ai cF(Parcel paramParcel)
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
          return new ai(k, str1, str2);
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
  
  public ai[] eo(int paramInt)
  {
    return new ai[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.aj
 * JD-Core Version:    0.7.0.1
 */