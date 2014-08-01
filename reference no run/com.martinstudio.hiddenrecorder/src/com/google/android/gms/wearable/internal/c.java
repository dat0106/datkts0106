package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class c
  implements Parcelable.Creator<b>
{
  static void a(b paramb, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramb.xJ);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramb.nj(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramb.alx, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public b cv(Parcel paramParcel)
  {
    IntentFilter[] arrayOfIntentFilter = null;
    int i = a.B(paramParcel);
    int k = 0;
    IBinder localIBinder = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new b(k, localIBinder, arrayOfIntentFilter);
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
        localIBinder = a.p(paramParcel, j);
        break;
      case 3: 
        arrayOfIntentFilter = (IntentFilter[])a.b(paramParcel, j, IntentFilter.CREATOR);
      }
    }
  }
  
  public b[] ee(int paramInt)
  {
    return new b[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.c
 * JD-Core Version:    0.7.0.1
 */