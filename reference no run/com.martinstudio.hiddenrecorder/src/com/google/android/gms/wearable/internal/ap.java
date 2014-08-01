package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ap
  implements Parcelable.Creator<ao>
{
  static void a(ao paramao, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramao.xJ);
    b.a(paramParcel, 2, paramao.nj(), false);
    b.G(paramParcel, i);
  }
  
  public ao cI(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int k = 0;
    IBinder localIBinder = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new ao(k, localIBinder);
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
        k = a.g(paramParcel, i);
        break;
      case 2: 
        localIBinder = a.p(paramParcel, i);
      }
    }
  }
  
  public ao[] er(int paramInt)
  {
    return new ao[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ap
 * JD-Core Version:    0.7.0.1
 */