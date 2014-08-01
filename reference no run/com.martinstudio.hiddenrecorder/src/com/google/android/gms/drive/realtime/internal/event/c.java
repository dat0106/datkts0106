package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<ParcelableObjectChangedEvent>
{
  static void a(ParcelableObjectChangedEvent paramParcelableObjectChangedEvent, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramParcelableObjectChangedEvent.xJ);
    b.a(paramParcel, 2, paramParcelableObjectChangedEvent.rO, false);
    b.a(paramParcel, 3, paramParcelableObjectChangedEvent.Lj, false);
    b.a(paramParcel, 4, paramParcelableObjectChangedEvent.Lp);
    b.a(paramParcel, 5, paramParcelableObjectChangedEvent.Ln, false);
    b.a(paramParcel, 6, paramParcelableObjectChangedEvent.Lq, false);
    b.c(paramParcel, 7, paramParcelableObjectChangedEvent.LC);
    b.c(paramParcel, 8, paramParcelableObjectChangedEvent.LD);
    b.G(paramParcel, i);
  }
  
  public ParcelableObjectChangedEvent aV(Parcel paramParcel)
  {
    String str4 = null;
    int m = 0;
    int i = a.B(paramParcel);
    int j = 0;
    String str2 = null;
    boolean bool = false;
    String str1 = null;
    String str3 = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new ParcelableObjectChangedEvent(k, str3, str1, bool, str2, str4, j, m);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        str3 = a.o(paramParcel, n);
        break;
      case 3: 
        str1 = a.o(paramParcel, n);
        break;
      case 4: 
        bool = a.c(paramParcel, n);
        break;
      case 5: 
        str2 = a.o(paramParcel, n);
        break;
      case 6: 
        str4 = a.o(paramParcel, n);
        break;
      case 7: 
        j = a.g(paramParcel, n);
        break;
      case 8: 
        m = a.g(paramParcel, n);
      }
    }
  }
  
  public ParcelableObjectChangedEvent[] bS(int paramInt)
  {
    return new ParcelableObjectChangedEvent[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.c
 * JD-Core Version:    0.7.0.1
 */