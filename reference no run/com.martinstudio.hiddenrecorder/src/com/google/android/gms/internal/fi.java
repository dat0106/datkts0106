package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class fi
  implements Parcelable.Creator<fh>
{
  static void a(fh paramfh, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramfh.xK, paramInt, false);
    b.c(paramParcel, 1000, paramfh.xJ);
    b.a(paramParcel, 2, paramfh.xL, false);
    b.a(paramParcel, 3, paramfh.xM);
    b.G(paramParcel, i);
  }
  
  public fh[] D(int paramInt)
  {
    return new fh[paramInt];
  }
  
  public fh l(Parcel paramParcel)
  {
    Object localObject1 = null;
    int j = 0;
    int i = a.B(paramParcel);
    Object localObject3 = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new fh(k, (fl[])localObject3, (String)localObject1, j);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int m = a.A(paramParcel);
      int n;
      String str2;
      String str1;
      int i1;
      Object localObject5;
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        m = j;
        localObject2 = localObject1;
        localObject1 = localObject3;
        k = k;
        break;
      case 1: 
        fl[] arrayOffl = (fl[])a.b(paramParcel, m, fl.CREATOR);
        k = k;
        localObject3 = localObject1;
        localObject1 = arrayOffl;
        n = localObject2;
        localObject2 = localObject3;
        break;
      case 2: 
        str2 = a.o(paramParcel, n);
        localObject1 = localObject3;
        k = k;
        str1 = localObject2;
        localObject2 = str2;
        str2 = str1;
        break;
      case 3: 
        i1 = a.c(paramParcel, str2);
        localObject2 = localObject1;
        localObject1 = str1;
        k = k;
        break;
      case 1000: 
        k = a.g(paramParcel, i1);
        localObject5 = localObject2;
        localObject2 = localObject1;
        localObject1 = str1;
        k = k;
        localObject5 = localObject5;
      }
      k = k;
      Object localObject4 = localObject1;
      localObject1 = localObject2;
      Object localObject2 = localObject5;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fi
 * JD-Core Version:    0.7.0.1
 */