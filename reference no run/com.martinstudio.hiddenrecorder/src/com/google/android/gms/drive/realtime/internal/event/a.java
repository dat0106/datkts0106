package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<ParcelableEvent>
{
  static void a(ParcelableEvent paramParcelableEvent, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramParcelableEvent.xJ);
    b.a(paramParcel, 2, paramParcelableEvent.rO, false);
    b.a(paramParcel, 3, paramParcelableEvent.Lj, false);
    b.a(paramParcel, 4, paramParcelableEvent.Lp);
    b.a(paramParcel, 5, paramParcelableEvent.Ln, false);
    b.a(paramParcel, 6, paramParcelableEvent.Lq, false);
    b.a(paramParcel, 7, paramParcelableEvent.Lr, paramInt, false);
    b.a(paramParcel, 8, paramParcelableEvent.Ls, paramInt, false);
    b.a(paramParcel, 9, paramParcelableEvent.Lt, paramInt, false);
    b.a(paramParcel, 10, paramParcelableEvent.Lu, paramInt, false);
    b.a(paramParcel, 11, paramParcelableEvent.Lv, paramInt, false);
    b.a(paramParcel, 12, paramParcelableEvent.Lw, paramInt, false);
    b.a(paramParcel, 13, paramParcelableEvent.Lx, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public ParcelableEvent aT(Parcel paramParcel)
  {
    int k = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    int j = 0;
    String str1 = null;
    String str3 = null;
    boolean bool = false;
    String str2 = null;
    String str4 = null;
    TextInsertedDetails localTextInsertedDetails = null;
    TextDeletedDetails localTextDeletedDetails = null;
    ValuesAddedDetails localValuesAddedDetails = null;
    ValuesRemovedDetails localValuesRemovedDetails = null;
    ValuesSetDetails localValuesSetDetails = null;
    ValueChangedDetails localValueChangedDetails = null;
    ReferenceShiftedDetails localReferenceShiftedDetails = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new ParcelableEvent(j, str1, str3, bool, str2, str4, localTextInsertedDetails, localTextDeletedDetails, localValuesAddedDetails, localValuesRemovedDetails, localValuesSetDetails, localValueChangedDetails, localReferenceShiftedDetails);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int i = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(i))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i);
        break;
      case 2: 
        str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i);
        break;
      case 3: 
        str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i);
        break;
      case 4: 
        bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, i);
        break;
      case 5: 
        str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i);
        break;
      case 6: 
        str4 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i);
        break;
      case 7: 
        localTextInsertedDetails = (TextInsertedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i, TextInsertedDetails.CREATOR);
        break;
      case 8: 
        localTextDeletedDetails = (TextDeletedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i, TextDeletedDetails.CREATOR);
        break;
      case 9: 
        localValuesAddedDetails = (ValuesAddedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i, ValuesAddedDetails.CREATOR);
        break;
      case 10: 
        localValuesRemovedDetails = (ValuesRemovedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i, ValuesRemovedDetails.CREATOR);
        break;
      case 11: 
        localValuesSetDetails = (ValuesSetDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i, ValuesSetDetails.CREATOR);
        break;
      case 12: 
        localValueChangedDetails = (ValueChangedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i, ValueChangedDetails.CREATOR);
        break;
      case 13: 
        localReferenceShiftedDetails = (ReferenceShiftedDetails)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i, ReferenceShiftedDetails.CREATOR);
      }
    }
  }
  
  public ParcelableEvent[] bQ(int paramInt)
  {
    return new ParcelableEvent[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.a
 * JD-Core Version:    0.7.0.1
 */