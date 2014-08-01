package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<ValuesAddedDetails>
{
  static void a(ValuesAddedDetails paramValuesAddedDetails, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramValuesAddedDetails.xJ);
    b.c(paramParcel, 2, paramValuesAddedDetails.mIndex);
    b.c(paramParcel, 3, paramValuesAddedDetails.LC);
    b.c(paramParcel, 4, paramValuesAddedDetails.LD);
    b.a(paramParcel, 5, paramValuesAddedDetails.LK, false);
    b.c(paramParcel, 6, paramValuesAddedDetails.LL);
    b.G(paramParcel, i);
  }
  
  public ValuesAddedDetails[] bX(int paramInt)
  {
    return new ValuesAddedDetails[paramInt];
  }
  
  public ValuesAddedDetails ba(Parcel paramParcel)
  {
    int k = 0;
    int i1 = a.B(paramParcel);
    String str = null;
    int m = 0;
    int n = 0;
    int i2 = 0;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i1)
      {
        if (paramParcel.dataPosition() == i1) {
          return new ValuesAddedDetails(j, i2, n, m, str, k);
        }
        throw new a.a("Overread allowed size end=" + i1, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        j = a.g(paramParcel, i);
        break;
      case 2: 
        i2 = a.g(paramParcel, i);
        break;
      case 3: 
        n = a.g(paramParcel, i);
        break;
      case 4: 
        m = a.g(paramParcel, i);
        break;
      case 5: 
        str = a.o(paramParcel, i);
        break;
      case 6: 
        k = a.g(paramParcel, i);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.h
 * JD-Core Version:    0.7.0.1
 */