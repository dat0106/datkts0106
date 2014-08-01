package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class j
  implements Parcelable.Creator<NotFilter>
{
  static void a(NotFilter paramNotFilter, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramNotFilter.xJ);
    b.a(paramParcel, 1, paramNotFilter.KW, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public NotFilter aN(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int i = 0;
    FilterHolder localFilterHolder = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new NotFilter(i, localFilterHolder);
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
        localFilterHolder = (FilterHolder)a.a(paramParcel, j, FilterHolder.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, j);
      }
    }
  }
  
  public NotFilter[] bJ(int paramInt)
  {
    return new NotFilter[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.j
 * JD-Core Version:    0.7.0.1
 */