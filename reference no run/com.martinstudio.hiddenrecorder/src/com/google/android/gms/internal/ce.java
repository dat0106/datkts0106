package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ce
  implements Parcelable.Creator<cf>
{
  static void a(cf paramcf, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramcf.versionCode);
    b.a(paramParcel, 2, paramcf.nY, false);
    b.a(paramParcel, 3, paramcf.nZ, false);
    b.a(paramParcel, 4, paramcf.mimeType, false);
    b.a(paramParcel, 5, paramcf.packageName, false);
    b.a(paramParcel, 6, paramcf.oa, false);
    b.a(paramParcel, 7, paramcf.ob, false);
    b.a(paramParcel, 8, paramcf.oc, false);
    b.G(paramParcel, i);
  }
  
  public cf e(Parcel paramParcel)
  {
    String str1 = null;
    int j = a.B(paramParcel);
    int k = 0;
    String str2 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str7 = null;
    String str6 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new cf(k, str6, str7, str3, str4, str5, str2, str1);
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
        str6 = a.o(paramParcel, i);
        break;
      case 3: 
        str7 = a.o(paramParcel, i);
        break;
      case 4: 
        str3 = a.o(paramParcel, i);
        break;
      case 5: 
        str4 = a.o(paramParcel, i);
        break;
      case 6: 
        str5 = a.o(paramParcel, i);
        break;
      case 7: 
        str2 = a.o(paramParcel, i);
        break;
      case 8: 
        str1 = a.o(paramParcel, i);
      }
    }
  }
  
  public cf[] i(int paramInt)
  {
    return new cf[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ce
 * JD-Core Version:    0.7.0.1
 */