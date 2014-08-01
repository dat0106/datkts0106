package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class am
  implements Parcelable.Creator<OnMetadataResponse>
{
  static void a(OnMetadataResponse paramOnMetadataResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnMetadataResponse.xJ);
    b.a(paramParcel, 2, paramOnMetadataResponse.IA, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OnMetadataResponse an(Parcel paramParcel)
  {
    int i = a.B(paramParcel);
    int k = 0;
    MetadataBundle localMetadataBundle = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new OnMetadataResponse(k, localMetadataBundle);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        k = a.g(paramParcel, j);
        break;
      case 2: 
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, j, MetadataBundle.CREATOR);
      }
    }
  }
  
  public OnMetadataResponse[] bj(int paramInt)
  {
    return new OnMetadataResponse[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.am
 * JD-Core Version:    0.7.0.1
 */