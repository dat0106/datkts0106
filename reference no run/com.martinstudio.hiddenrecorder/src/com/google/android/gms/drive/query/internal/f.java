package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class f
  implements Parcelable.Creator<HasFilter>
{
  static void a(HasFilter paramHasFilter, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramHasFilter.xJ);
    b.a(paramParcel, 1, paramHasFilter.KJ, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public HasFilter aJ(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int i = 0;
    MetadataBundle localMetadataBundle = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new HasFilter(i, localMetadataBundle);
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
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, j, MetadataBundle.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, j);
      }
    }
  }
  
  public HasFilter[] bF(int paramInt)
  {
    return new HasFilter[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.f
 * JD-Core Version:    0.7.0.1
 */