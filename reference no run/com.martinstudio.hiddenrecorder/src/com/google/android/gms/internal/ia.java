package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ia
  implements Parcelable.Creator<hz.a>
{
  static void a(hz.a parama, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, parama.getVersionCode());
    b.c(paramParcel, 2, parama.fz());
    b.a(paramParcel, 3, parama.fF());
    b.c(paramParcel, 4, parama.fA());
    b.a(paramParcel, 5, parama.fG());
    b.a(paramParcel, 6, parama.fH(), false);
    b.c(paramParcel, 7, parama.fI());
    b.a(paramParcel, 8, parama.fK(), false);
    b.a(paramParcel, 9, parama.fM(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public hz.a H(Parcel paramParcel)
  {
    hu localhu = null;
    int i1 = 0;
    int i = a.B(paramParcel);
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    int k = 0;
    boolean bool2 = false;
    int m = 0;
    int j = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new hz.a(j, m, bool2, k, bool1, str2, i1, str1, localhu);
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
        m = a.g(paramParcel, n);
        break;
      case 3: 
        bool2 = a.c(paramParcel, n);
        break;
      case 4: 
        k = a.g(paramParcel, n);
        break;
      case 5: 
        bool1 = a.c(paramParcel, n);
        break;
      case 6: 
        str2 = a.o(paramParcel, n);
        break;
      case 7: 
        i1 = a.g(paramParcel, n);
        break;
      case 8: 
        str1 = a.o(paramParcel, n);
        break;
      case 9: 
        localhu = (hu)a.a(paramParcel, n, hu.CREATOR);
      }
    }
  }
  
  public hz.a[] aw(int paramInt)
  {
    return new hz.a[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ia
 * JD-Core Version:    0.7.0.1
 */