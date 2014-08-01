package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class j
  implements Parcelable.Creator<ValuesSetDetails>
{
  static void a(ValuesSetDetails paramValuesSetDetails, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramValuesSetDetails.xJ);
    b.c(paramParcel, 2, paramValuesSetDetails.mIndex);
    b.c(paramParcel, 3, paramValuesSetDetails.LC);
    b.c(paramParcel, 4, paramValuesSetDetails.LD);
    b.G(paramParcel, i);
  }
  
  public ValuesSetDetails[] bZ(int paramInt)
  {
    return new ValuesSetDetails[paramInt];
  }
  
  public ValuesSetDetails bc(Parcel paramParcel)
  {
    int k = 0;
    int m = a.B(paramParcel);
    int n = 0;
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new ValuesSetDetails(j, i, n, k);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int i1 = a.A(paramParcel);
      switch (a.ar(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        j = a.g(paramParcel, i1);
        break;
      case 2: 
        i = a.g(paramParcel, i1);
        break;
      case 3: 
        n = a.g(paramParcel, i1);
        break;
      case 4: 
        k = a.g(paramParcel, i1);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.j
 * JD-Core Version:    0.7.0.1
 */