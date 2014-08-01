package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i
  implements Parcelable.Creator<ValuesRemovedDetails>
{
  static void a(ValuesRemovedDetails paramValuesRemovedDetails, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramValuesRemovedDetails.xJ);
    b.c(paramParcel, 2, paramValuesRemovedDetails.mIndex);
    b.c(paramParcel, 3, paramValuesRemovedDetails.LC);
    b.c(paramParcel, 4, paramValuesRemovedDetails.LD);
    b.a(paramParcel, 5, paramValuesRemovedDetails.LM, false);
    b.c(paramParcel, 6, paramValuesRemovedDetails.LN);
    b.G(paramParcel, i);
  }
  
  public ValuesRemovedDetails[] bY(int paramInt)
  {
    return new ValuesRemovedDetails[paramInt];
  }
  
  public ValuesRemovedDetails bb(Parcel paramParcel)
  {
    int j = 0;
    int n = a.B(paramParcel);
    String str = null;
    int i2 = 0;
    int m = 0;
    int i1 = 0;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= n)
      {
        if (paramParcel.dataPosition() == n) {
          return new ValuesRemovedDetails(i, i1, m, i2, str, j);
        }
        throw new a.a("Overread allowed size end=" + n, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        i1 = a.g(paramParcel, k);
        break;
      case 3: 
        m = a.g(paramParcel, k);
        break;
      case 4: 
        i2 = a.g(paramParcel, k);
        break;
      case 5: 
        str = a.o(paramParcel, k);
        break;
      case 6: 
        j = a.g(paramParcel, k);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.i
 * JD-Core Version:    0.7.0.1
 */