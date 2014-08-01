package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class e
  implements Parcelable.Creator<TextDeletedDetails>
{
  static void a(TextDeletedDetails paramTextDeletedDetails, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramTextDeletedDetails.xJ);
    b.c(paramParcel, 2, paramTextDeletedDetails.mIndex);
    b.c(paramParcel, 3, paramTextDeletedDetails.LI);
    b.G(paramParcel, i);
  }
  
  public TextDeletedDetails aX(Parcel paramParcel)
  {
    int m = 0;
    int k = a.B(paramParcel);
    int i = 0;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new TextDeletedDetails(j, i, m);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        j = a.g(paramParcel, n);
        break;
      case 2: 
        i = a.g(paramParcel, n);
        break;
      case 3: 
        m = a.g(paramParcel, n);
      }
    }
  }
  
  public TextDeletedDetails[] bU(int paramInt)
  {
    return new TextDeletedDetails[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.e
 * JD-Core Version:    0.7.0.1
 */