package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<a>
{
  static void a(a parama, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, parama.xJ);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, parama.Et, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 3, parama.AQ);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public a[] ab(int paramInt)
  {
    return new a[paramInt];
  }
  
  public a w(Parcel paramParcel)
  {
    int k = 0;
    int i = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    ParcelFileDescriptor localParcelFileDescriptor = null;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new a(j, localParcelFileDescriptor, k);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int m = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
        k = k;
        localParcelFileDescriptor = localParcelFileDescriptor;
        j = j;
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        k = k;
        localParcelFileDescriptor = localParcelFileDescriptor;
        j = j;
        k = k;
        break;
      case 2: 
        localParcelFileDescriptor = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, m, ParcelFileDescriptor.CREATOR);
        j = j;
        k = k;
        localParcelFileDescriptor = localParcelFileDescriptor;
        break;
      case 3: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
        localParcelFileDescriptor = localParcelFileDescriptor;
        j = j;
      }
      j = j;
      localParcelFileDescriptor = localParcelFileDescriptor;
      k = k;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.b
 * JD-Core Version:    0.7.0.1
 */