package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class c
  implements Parcelable.Creator<CustomProperty>
{
  static void a(CustomProperty paramCustomProperty, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCustomProperty.xJ);
    b.a(paramParcel, 2, paramCustomProperty.JN, paramInt, false);
    b.a(paramParcel, 3, paramCustomProperty.mValue, false);
    b.G(paramParcel, i);
  }
  
  public CustomProperty aB(Parcel paramParcel)
  {
    String str = null;
    int i = a.B(paramParcel);
    int j = 0;
    CustomPropertyKey localCustomPropertyKey = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new CustomProperty(j, localCustomPropertyKey, str);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        str = str;
        localCustomPropertyKey = localCustomPropertyKey;
        j = j;
        break;
      case 1: 
        j = a.g(paramParcel, k);
        str = str;
        localCustomPropertyKey = localCustomPropertyKey;
        j = j;
        str = str;
        break;
      case 2: 
        localCustomPropertyKey = (CustomPropertyKey)a.a(paramParcel, k, CustomPropertyKey.CREATOR);
        j = j;
        str = str;
        localCustomPropertyKey = localCustomPropertyKey;
        break;
      case 3: 
        str = a.o(paramParcel, k);
        localCustomPropertyKey = localCustomPropertyKey;
        j = j;
      }
      j = j;
      localCustomPropertyKey = localCustomPropertyKey;
      str = str;
    }
  }
  
  public CustomProperty[] bx(int paramInt)
  {
    return new CustomProperty[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.c
 * JD-Core Version:    0.7.0.1
 */