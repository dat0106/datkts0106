package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class cq
  implements Parcelable.Creator<cr>
{
  static void a(cr paramcr, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramcr.versionCode);
    b.a(paramParcel, 2, paramcr.aY(), false);
    b.a(paramParcel, 3, paramcr.aZ(), false);
    b.a(paramParcel, 4, paramcr.ba(), false);
    b.a(paramParcel, 5, paramcr.bb(), false);
    b.G(paramParcel, i);
  }
  
  public cr g(Parcel paramParcel)
  {
    IBinder localIBinder2 = null;
    int k = a.B(paramParcel);
    int i = 0;
    IBinder localIBinder1 = null;
    IBinder localIBinder3 = null;
    IBinder localIBinder4 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new cr(i, localIBinder4, localIBinder3, localIBinder1, localIBinder2);
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
        i = a.g(paramParcel, j);
        break;
      case 2: 
        localIBinder4 = a.p(paramParcel, j);
        break;
      case 3: 
        localIBinder3 = a.p(paramParcel, j);
        break;
      case 4: 
        localIBinder1 = a.p(paramParcel, j);
        break;
      case 5: 
        localIBinder2 = a.p(paramParcel, j);
      }
    }
  }
  
  public cr[] k(int paramInt)
  {
    return new cr[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cq
 * JD-Core Version:    0.7.0.1
 */