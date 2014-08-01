package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f
  implements Parcelable.Creator<DataHolder>
{
  static void a(DataHolder paramDataHolder, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramDataHolder.eS(), false);
    b.c(paramParcel, 1000, paramDataHolder.getVersionCode());
    b.a(paramParcel, 2, paramDataHolder.eT(), paramInt, false);
    b.c(paramParcel, 3, paramDataHolder.getStatusCode());
    b.a(paramParcel, 4, paramDataHolder.eP(), false);
    b.G(paramParcel, i);
  }
  
  public DataHolder[] ag(int paramInt)
  {
    return new DataHolder[paramInt];
  }
  
  public DataHolder x(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int k = a.B(paramParcel);
    CursorWindow[] arrayOfCursorWindow = null;
    String[] arrayOfString = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k)
        {
          DataHolder localDataHolder = new DataHolder(m, arrayOfString, arrayOfCursorWindow, i, localBundle);
          localDataHolder.eR();
          return localDataHolder;
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
        arrayOfString = a.A(paramParcel, n);
        break;
      case 2: 
        arrayOfCursorWindow = (CursorWindow[])a.b(paramParcel, n, CursorWindow.CREATOR);
        break;
      case 3: 
        int j = a.g(paramParcel, n);
        break;
      case 4: 
        localBundle = a.q(paramParcel, n);
        break;
      case 1000: 
        m = a.g(paramParcel, n);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.f
 * JD-Core Version:    0.7.0.1
 */