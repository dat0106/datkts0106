package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<MetadataBundle>
{
  static void a(MetadataBundle paramMetadataBundle, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramMetadataBundle.xJ);
    b.a(paramParcel, 2, paramMetadataBundle.JP, false);
    b.G(paramParcel, i);
  }
  
  public MetadataBundle aC(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    Bundle localBundle = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new MetadataBundle(i, localBundle);
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
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localBundle = a.q(paramParcel, k);
      }
    }
  }
  
  public MetadataBundle[] by(int paramInt)
  {
    return new MetadataBundle[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.h
 * JD-Core Version:    0.7.0.1
 */