package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class g
  implements Parcelable.Creator<InFilter>
{
  static void a(InFilter paramInFilter, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramInFilter.xJ);
    b.a(paramParcel, 1, paramInFilter.KJ, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public InFilter aK(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    MetadataBundle localMetadataBundle = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new InFilter(i, localMetadataBundle);
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
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, k, MetadataBundle.CREATOR);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
  }
  
  public InFilter[] bG(int paramInt)
  {
    return new InFilter[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.g
 * JD-Core Version:    0.7.0.1
 */