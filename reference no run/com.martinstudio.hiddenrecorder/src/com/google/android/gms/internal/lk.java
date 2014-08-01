package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class lk
  implements Parcelable.Creator<lj>
{
  static void a(lj paramlj, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramlj.getVersionCode());
    b.a(paramParcel, 2, paramlj.akb, false);
    b.a(paramParcel, 3, paramlj.akc, false);
    b.G(paramParcel, i);
  }
  
  public lj cf(Parcel paramParcel)
  {
    String[] arrayOfString = null;
    int j = a.B(paramParcel);
    int k = 0;
    byte[][] arrayOfByte = (byte[][])null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new lj(k, arrayOfString, arrayOfByte);
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
        arrayOfString = a.A(paramParcel, i);
        break;
      case 3: 
        arrayOfByte = a.s(paramParcel, i);
      }
    }
  }
  
  public lj[] dL(int paramInt)
  {
    return new lj[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lk
 * JD-Core Version:    0.7.0.1
 */