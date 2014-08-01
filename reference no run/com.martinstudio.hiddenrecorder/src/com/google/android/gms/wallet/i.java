package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i
  implements Parcelable.Creator<LineItem>
{
  static void a(LineItem paramLineItem, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramLineItem.getVersionCode());
    b.a(paramParcel, 2, paramLineItem.description, false);
    b.a(paramParcel, 3, paramLineItem.ajb, false);
    b.a(paramParcel, 4, paramLineItem.ajc, false);
    b.a(paramParcel, 5, paramLineItem.aiH, false);
    b.c(paramParcel, 6, paramLineItem.ajd);
    b.a(paramParcel, 7, paramLineItem.aiI, false);
    b.G(paramParcel, i);
  }
  
  public LineItem bX(Parcel paramParcel)
  {
    int m = 0;
    String str1 = null;
    int k = a.B(paramParcel);
    String str2 = null;
    String str4 = null;
    String str5 = null;
    String str3 = null;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new LineItem(i, str3, str5, str4, str2, m, str1);
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
        str3 = a.o(paramParcel, j);
        break;
      case 3: 
        str5 = a.o(paramParcel, j);
        break;
      case 4: 
        str4 = a.o(paramParcel, j);
        break;
      case 5: 
        str2 = a.o(paramParcel, j);
        break;
      case 6: 
        m = a.g(paramParcel, j);
        break;
      case 7: 
        str1 = a.o(paramParcel, j);
      }
    }
  }
  
  public LineItem[] dD(int paramInt)
  {
    return new LineItem[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.i
 * JD-Core Version:    0.7.0.1
 */