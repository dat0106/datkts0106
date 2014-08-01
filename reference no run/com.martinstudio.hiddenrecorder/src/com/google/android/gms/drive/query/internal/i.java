package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i
  implements Parcelable.Creator<MatchAllFilter>
{
  static void a(MatchAllFilter paramMatchAllFilter, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramMatchAllFilter.xJ);
    b.G(paramParcel, i);
  }
  
  public MatchAllFilter aM(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new MatchAllFilter(i);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
  }
  
  public MatchAllFilter[] bI(int paramInt)
  {
    return new MatchAllFilter[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.i
 * JD-Core Version:    0.7.0.1
 */