package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
  implements Parcelable.Creator<FilterHolder>
{
  static void a(FilterHolder paramFilterHolder, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramFilterHolder.KM, paramInt, false);
    b.c(paramParcel, 1000, paramFilterHolder.xJ);
    b.a(paramParcel, 2, paramFilterHolder.KN, paramInt, false);
    b.a(paramParcel, 3, paramFilterHolder.KO, paramInt, false);
    b.a(paramParcel, 4, paramFilterHolder.KP, paramInt, false);
    b.a(paramParcel, 5, paramFilterHolder.KQ, paramInt, false);
    b.a(paramParcel, 6, paramFilterHolder.KR, paramInt, false);
    b.a(paramParcel, 7, paramFilterHolder.KS, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public FilterHolder aI(Parcel paramParcel)
  {
    HasFilter localHasFilter = null;
    int i = a.B(paramParcel);
    int j = 0;
    MatchAllFilter localMatchAllFilter = null;
    InFilter localInFilter = null;
    NotFilter localNotFilter = null;
    LogicalFilter localLogicalFilter = null;
    FieldOnlyFilter localFieldOnlyFilter = null;
    ComparisonFilter localComparisonFilter = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new FilterHolder(j, localComparisonFilter, localFieldOnlyFilter, localLogicalFilter, localNotFilter, localInFilter, localMatchAllFilter, localHasFilter);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localComparisonFilter = (ComparisonFilter)a.a(paramParcel, k, ComparisonFilter.CREATOR);
        break;
      case 2: 
        localFieldOnlyFilter = (FieldOnlyFilter)a.a(paramParcel, k, FieldOnlyFilter.CREATOR);
        break;
      case 3: 
        localLogicalFilter = (LogicalFilter)a.a(paramParcel, k, LogicalFilter.CREATOR);
        break;
      case 4: 
        localNotFilter = (NotFilter)a.a(paramParcel, k, NotFilter.CREATOR);
        break;
      case 5: 
        localInFilter = (InFilter)a.a(paramParcel, k, InFilter.CREATOR);
        break;
      case 6: 
        localMatchAllFilter = (MatchAllFilter)a.a(paramParcel, k, MatchAllFilter.CREATOR);
        break;
      case 7: 
        localHasFilter = (HasFilter)a.a(paramParcel, k, HasFilter.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
      }
    }
  }
  
  public FilterHolder[] bE(int paramInt)
  {
    return new FilterHolder[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.d
 * JD-Core Version:    0.7.0.1
 */