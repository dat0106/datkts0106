package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ConnectionInfoCreator
  implements Parcelable.Creator<ConnectionInfo>
{
  static void a(ConnectionInfo paramConnectionInfo, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramConnectionInfo.gR(), false);
    b.c(paramParcel, 1000, paramConnectionInfo.getVersionCode());
    b.c(paramParcel, 2, paramConnectionInfo.gS());
    b.G(paramParcel, i);
  }
  
  public ConnectionInfo bf(Parcel paramParcel)
  {
    int m = 0;
    int k = a.B(paramParcel);
    String str = null;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new ConnectionInfo(i, str, m);
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
        str = a.o(paramParcel, j);
        break;
      case 2: 
        m = a.g(paramParcel, j);
        break;
      case 1000: 
        i = a.g(paramParcel, j);
      }
    }
  }
  
  public ConnectionInfo[] cf(int paramInt)
  {
    return new ConnectionInfo[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.ConnectionInfoCreator
 * JD-Core Version:    0.7.0.1
 */