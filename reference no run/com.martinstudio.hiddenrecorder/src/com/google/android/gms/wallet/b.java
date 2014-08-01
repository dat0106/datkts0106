package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import java.util.ArrayList;

public class b
  implements Parcelable.Creator<Cart>
{
  static void a(Cart paramCart, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramCart.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramCart.aiH, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramCart.aiI, false);
    com.google.android.gms.common.internal.safeparcel.b.b(paramParcel, 4, paramCart.aiJ, false);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public Cart bR(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.B(paramParcel);
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new Cart(i, str1, str2, localArrayList);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
        break;
      case 4: 
        localArrayList = a.c(paramParcel, k, LineItem.CREATOR);
      }
    }
  }
  
  public Cart[] dx(int paramInt)
  {
    return new Cart[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.b
 * JD-Core Version:    0.7.0.1
 */