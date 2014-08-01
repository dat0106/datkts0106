package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class StatusCreator
  implements Parcelable.Creator<Status>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(Status paramStatus, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramStatus.getStatusCode());
    b.c(paramParcel, 1000, paramStatus.getVersionCode());
    b.a(paramParcel, 2, paramStatus.getStatusMessage(), false);
    b.a(paramParcel, 3, paramStatus.eL(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public Status createFromParcel(Parcel paramParcel)
  {
    PendingIntent localPendingIntent = null;
    int i = 0;
    int j = a.B(paramParcel);
    String str = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new Status(m, i, str, localPendingIntent);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
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
        str = a.o(paramParcel, k);
        break;
      case 3: 
        localPendingIntent = (PendingIntent)a.a(paramParcel, k, PendingIntent.CREATOR);
        break;
      case 1000: 
        m = a.g(paramParcel, k);
      }
    }
  }
  
  public Status[] newArray(int paramInt)
  {
    return new Status[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.StatusCreator
 * JD-Core Version:    0.7.0.1
 */