package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<ParcelableEventList>
{
  static void a(ParcelableEventList paramParcelableEventList, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.C(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramParcelableEventList.xJ);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramParcelableEventList.Ly, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramParcelableEventList.Lz, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 4, paramParcelableEventList.LA);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 5, paramParcelableEventList.LB, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.G(paramParcel, i);
  }
  
  public ParcelableEventList aU(Parcel paramParcel)
  {
    boolean bool = false;
    ParcelableObjectChangedEvent[] arrayOfParcelableObjectChangedEvent = null;
    int k = a.B(paramParcel);
    DataHolder localDataHolder = null;
    ParcelableEvent[] arrayOfParcelableEvent = null;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new ParcelableEventList(i, arrayOfParcelableEvent, localDataHolder, bool, arrayOfParcelableObjectChangedEvent);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        i = a.g(paramParcel, j);
        break;
      case 2: 
        arrayOfParcelableEvent = (ParcelableEvent[])a.b(paramParcel, j, ParcelableEvent.CREATOR);
        break;
      case 3: 
        localDataHolder = (DataHolder)a.a(paramParcel, j, DataHolder.CREATOR);
        break;
      case 4: 
        bool = a.c(paramParcel, j);
        break;
      case 5: 
        arrayOfParcelableObjectChangedEvent = (ParcelableObjectChangedEvent[])a.b(paramParcel, j, ParcelableObjectChangedEvent.CREATOR);
      }
    }
  }
  
  public ParcelableEventList[] bR(int paramInt)
  {
    return new ParcelableEventList[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.b
 * JD-Core Version:    0.7.0.1
 */