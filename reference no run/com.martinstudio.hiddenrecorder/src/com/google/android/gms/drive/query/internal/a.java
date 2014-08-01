package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class a
  implements Parcelable.Creator<ComparisonFilter>
{
  static void a(ComparisonFilter paramComparisonFilter, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramComparisonFilter.xJ);
    b.a(paramParcel, 1, paramComparisonFilter.KI, paramInt, false);
    b.a(paramParcel, 2, paramComparisonFilter.KJ, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public ComparisonFilter aF(Parcel paramParcel)
  {
    MetadataBundle localMetadataBundle = null;
    int i = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    int j = 0;
    Operator localOperator = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new ComparisonFilter(j, localOperator, localMetadataBundle);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        localMetadataBundle = localMetadataBundle;
        localOperator = localOperator;
        j = j;
        break;
      case 1: 
        localOperator = (Operator)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Operator.CREATOR);
        j = j;
        localMetadataBundle = localMetadataBundle;
        localOperator = localOperator;
        break;
      case 2: 
        localMetadataBundle = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, MetadataBundle.CREATOR);
        localOperator = localOperator;
        j = j;
        break;
      case 1000: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        localMetadataBundle = localMetadataBundle;
        localOperator = localOperator;
        j = j;
        localMetadataBundle = localMetadataBundle;
      }
      j = j;
      localOperator = localOperator;
      localMetadataBundle = localMetadataBundle;
    }
  }
  
  public ComparisonFilter[] bB(int paramInt)
  {
    return new ComparisonFilter[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.a
 * JD-Core Version:    0.7.0.1
 */