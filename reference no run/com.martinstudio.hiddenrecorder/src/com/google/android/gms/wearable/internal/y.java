package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class y
  implements Parcelable.Creator<x>
{
  static void a(x paramx, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramx.versionCode);
    b.c(paramParcel, 2, paramx.statusCode);
    b.a(paramParcel, 3, paramx.alM, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public x cC(Parcel paramParcel)
  {
    int k = 0;
    int j = a.B(paramParcel);
    ParcelFileDescriptor localParcelFileDescriptor = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new x(m, k, localParcelFileDescriptor);
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
        m = a.g(paramParcel, i);
        break;
      case 2: 
        k = a.g(paramParcel, i);
        break;
      case 3: 
        localParcelFileDescriptor = (ParcelFileDescriptor)a.a(paramParcel, i, ParcelFileDescriptor.CREATOR);
      }
    }
  }
  
  public x[] el(int paramInt)
  {
    return new x[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.y
 * JD-Core Version:    0.7.0.1
 */