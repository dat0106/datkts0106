package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f
  implements Parcelable.Creator<TextInsertedDetails>
{
  static void a(TextInsertedDetails paramTextInsertedDetails, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramTextInsertedDetails.xJ);
    b.c(paramParcel, 2, paramTextInsertedDetails.mIndex);
    b.c(paramParcel, 3, paramTextInsertedDetails.LI);
    b.G(paramParcel, i);
  }
  
  public TextInsertedDetails aY(Parcel paramParcel)
  {
    int m = 0;
    int n = a.B(paramParcel);
    int i = 0;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= n)
      {
        if (paramParcel.dataPosition() == n) {
          return new TextInsertedDetails(k, i, m);
        }
        throw new a.a("Overread allowed size end=" + n, paramParcel);
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
        i = a.g(paramParcel, j);
        break;
      case 3: 
        m = a.g(paramParcel, j);
      }
    }
  }
  
  public TextInsertedDetails[] bV(int paramInt)
  {
    return new TextInsertedDetails[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.f
 * JD-Core Version:    0.7.0.1
 */