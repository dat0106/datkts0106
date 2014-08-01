package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<CustomPropertyKey>
{
  static void a(CustomPropertyKey paramCustomPropertyKey, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCustomPropertyKey.xJ);
    b.a(paramParcel, 2, paramCustomPropertyKey.JI, false);
    b.c(paramParcel, 3, paramCustomPropertyKey.JJ);
    b.G(paramParcel, i);
  }
  
  public CustomPropertyKey az(Parcel paramParcel)
  {
    int k = 0;
    int i = a.B(paramParcel);
    String str = null;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new CustomPropertyKey(j, str, k);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        str = a.o(paramParcel, m);
        break;
      case 3: 
        k = a.g(paramParcel, m);
      }
    }
  }
  
  public CustomPropertyKey[] bv(int paramInt)
  {
    return new CustomPropertyKey[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.c
 * JD-Core Version:    0.7.0.1
 */