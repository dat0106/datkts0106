package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class hx
  implements Parcelable.Creator<hw>
{
  static void a(hw paramhw, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramhw.getVersionCode());
    b.b(paramParcel, 2, paramhw.fy(), false);
    b.G(paramParcel, i);
  }
  
  public hw F(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int k = 0;
    ArrayList localArrayList = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new hw(k, localArrayList);
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
        localArrayList = a.c(paramParcel, i, hw.a.CREATOR);
      }
    }
  }
  
  public hw[] au(int paramInt)
  {
    return new hw[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hx
 * JD-Core Version:    0.7.0.1
 */