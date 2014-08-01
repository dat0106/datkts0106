package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public class jo
  implements Parcelable.Creator<jn>
{
  static void a(jn paramjn, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.b(paramParcel, 1, paramjn.VZ, false);
    b.c(paramParcel, 1000, paramjn.xJ);
    b.a(paramParcel, 2, paramjn.jb(), false);
    b.a(paramParcel, 3, paramjn.jc());
    b.b(paramParcel, 4, paramjn.Wc, false);
    b.a(paramParcel, 5, paramjn.jd(), false);
    b.a(paramParcel, 6, paramjn.We, false);
    b.G(paramParcel, i);
  }
  
  public jn bv(Parcel paramParcel)
  {
    boolean bool = false;
    Object localObject1 = null;
    int j = a.B(paramParcel);
    String str1 = null;
    Object localObject3 = null;
    String str2 = null;
    Object localObject2 = null;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new jn(i, (List)localObject2, str2, bool, (List)localObject3, str1, (List)localObject1);
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
        localObject2 = a.c(paramParcel, k, jt.CREATOR);
        break;
      case 2: 
        str2 = a.o(paramParcel, k);
        break;
      case 3: 
        bool = a.c(paramParcel, k);
        break;
      case 4: 
        localObject3 = a.c(paramParcel, k, jx.CREATOR);
        break;
      case 5: 
        str1 = a.o(paramParcel, k);
        break;
      case 6: 
        localObject1 = a.B(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
      }
    }
  }
  
  public jn[] cQ(int paramInt)
  {
    return new jn[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jo
 * JD-Core Version:    0.7.0.1
 */