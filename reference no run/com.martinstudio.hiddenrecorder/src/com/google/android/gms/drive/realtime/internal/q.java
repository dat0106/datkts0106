package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class q
  implements Parcelable.Creator<ParcelableIndexReference>
{
  static void a(ParcelableIndexReference paramParcelableIndexReference, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramParcelableIndexReference.xJ);
    b.a(paramParcel, 2, paramParcelableIndexReference.Ln, false);
    b.c(paramParcel, 3, paramParcelableIndexReference.mIndex);
    b.a(paramParcel, 4, paramParcelableIndexReference.Lo);
    b.G(paramParcel, i);
  }
  
  public ParcelableIndexReference aS(Parcel paramParcel)
  {
    boolean bool = false;
    int j = a.B(paramParcel);
    String str = null;
    int k = 0;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new ParcelableIndexReference(i, str, k, bool);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        i = a.g(paramParcel, m);
        break;
      case 2: 
        str = a.o(paramParcel, m);
        break;
      case 3: 
        k = a.g(paramParcel, m);
        break;
      case 4: 
        bool = a.c(paramParcel, m);
      }
    }
  }
  
  public ParcelableIndexReference[] bP(int paramInt)
  {
    return new ParcelableIndexReference[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.q
 * JD-Core Version:    0.7.0.1
 */