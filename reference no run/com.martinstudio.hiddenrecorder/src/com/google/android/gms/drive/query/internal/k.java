package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class k
  implements Parcelable.Creator<Operator>
{
  static void a(Operator paramOperator, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramOperator.xJ);
    b.a(paramParcel, 1, paramOperator.mTag, false);
    b.G(paramParcel, i);
  }
  
  public Operator aO(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    String str = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new Operator(i, str);
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
        str = a.o(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
  }
  
  public Operator[] bK(int paramInt)
  {
    return new Operator[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.k
 * JD-Core Version:    0.7.0.1
 */