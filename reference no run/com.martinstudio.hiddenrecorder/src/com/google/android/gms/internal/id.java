package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class id
  implements Parcelable.Creator<ic>
{
  static void a(ic paramic, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramic.getVersionCode());
    b.b(paramParcel, 2, paramic.fQ(), false);
    b.a(paramParcel, 3, paramic.fR(), false);
    b.G(paramParcel, i);
  }
  
  public ic J(Parcel paramParcel)
  {
    String str = null;
    int k = a.B(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new ic(j, localArrayList, str);
        }
        throw new a.a("Overread allowed size end=" + k, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        j = a.g(paramParcel, i);
        break;
      case 2: 
        localArrayList = a.c(paramParcel, i, ic.a.CREATOR);
        break;
      case 3: 
        str = a.o(paramParcel, i);
      }
    }
  }
  
  public ic[] ay(int paramInt)
  {
    return new ic[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.id
 * JD-Core Version:    0.7.0.1
 */