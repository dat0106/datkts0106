package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class g
  implements Parcelable.Creator<ValueChangedDetails>
{
  static void a(ValueChangedDetails paramValueChangedDetails, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramValueChangedDetails.xJ);
    b.c(paramParcel, 2, paramValueChangedDetails.LJ);
    b.G(paramParcel, i);
  }
  
  public ValueChangedDetails aZ(Parcel paramParcel)
  {
    int k = 0;
    int m = a.B(paramParcel);
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new ValueChangedDetails(i, k);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
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
        k = a.g(paramParcel, j);
      }
    }
  }
  
  public ValueChangedDetails[] bW(int paramInt)
  {
    return new ValueChangedDetails[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.g
 * JD-Core Version:    0.7.0.1
 */