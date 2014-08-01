package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class b
  implements Parcelable.Creator<FieldOnlyFilter>
{
  static void a(FieldOnlyFilter paramFieldOnlyFilter, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1000, paramFieldOnlyFilter.xJ);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 1, paramFieldOnlyFilter.KJ, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public FieldOnlyFilter aG(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int k = 0;
    MetadataBundle localMetadataBundle = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new FieldOnlyFilter(k, localMetadataBundle);
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
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, i, MetadataBundle.CREATOR);
        break;
      case 1000: 
        k = a.g(paramParcel, i);
      }
    }
  }
  
  public FieldOnlyFilter[] bC(int paramInt)
  {
    return new FieldOnlyFilter[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.b
 * JD-Core Version:    0.7.0.1
 */