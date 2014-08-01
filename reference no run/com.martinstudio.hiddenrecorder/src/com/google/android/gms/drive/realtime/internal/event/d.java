package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
  implements Parcelable.Creator<ReferenceShiftedDetails>
{
  static void a(ReferenceShiftedDetails paramReferenceShiftedDetails, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramReferenceShiftedDetails.xJ);
    b.a(paramParcel, 2, paramReferenceShiftedDetails.LE, false);
    b.a(paramParcel, 3, paramReferenceShiftedDetails.LF, false);
    b.c(paramParcel, 4, paramReferenceShiftedDetails.LG);
    b.c(paramParcel, 5, paramReferenceShiftedDetails.LH);
    b.G(paramParcel, i);
  }
  
  public ReferenceShiftedDetails aW(Parcel paramParcel)
  {
    String str2 = null;
    int k = 0;
    int i = a.B(paramParcel);
    int m = 0;
    String str1 = null;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new ReferenceShiftedDetails(j, str1, str2, m, k);
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
        j = a.g(paramParcel, n);
        break;
      case 2: 
        str1 = a.o(paramParcel, n);
        break;
      case 3: 
        str2 = a.o(paramParcel, n);
        break;
      case 4: 
        m = a.g(paramParcel, n);
        break;
      case 5: 
        k = a.g(paramParcel, n);
      }
    }
  }
  
  public ReferenceShiftedDetails[] bT(int paramInt)
  {
    return new ReferenceShiftedDetails[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.d
 * JD-Core Version:    0.7.0.1
 */