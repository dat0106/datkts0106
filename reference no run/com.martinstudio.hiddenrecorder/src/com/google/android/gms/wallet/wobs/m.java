package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m
  implements Parcelable.Creator<l>
{
  static void a(l paraml, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paraml.getVersionCode());
    b.a(paramParcel, 2, paraml.akX);
    b.a(paramParcel, 3, paraml.akY);
    b.G(paramParcel, i);
  }
  
  public l cp(Parcel paramParcel)
  {
    long l1 = 0L;
    int k = a.B(paramParcel);
    int i = 0;
    long l2 = l1;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new l(i, l2, l1);
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
        l2 = a.i(paramParcel, j);
        break;
      case 3: 
        l1 = a.i(paramParcel, j);
      }
    }
  }
  
  public l[] dX(int paramInt)
  {
    return new l[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.m
 * JD-Core Version:    0.7.0.1
 */