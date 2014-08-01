package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class j
  implements Parcelable.Creator<DataItemAssetParcelable>
{
  static void a(DataItemAssetParcelable paramDataItemAssetParcelable, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramDataItemAssetParcelable.xJ);
    b.a(paramParcel, 2, paramDataItemAssetParcelable.getId(), false);
    b.a(paramParcel, 3, paramDataItemAssetParcelable.getDataItemKey(), false);
    b.G(paramParcel, i);
  }
  
  public DataItemAssetParcelable cw(Parcel paramParcel)
  {
    String str2 = null;
    int k = a.B(paramParcel);
    int j = 0;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new DataItemAssetParcelable(j, str1, str2);
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
        str1 = a.o(paramParcel, i);
        break;
      case 3: 
        str2 = a.o(paramParcel, i);
      }
    }
  }
  
  public DataItemAssetParcelable[] ef(int paramInt)
  {
    return new DataItemAssetParcelable[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.j
 * JD-Core Version:    0.7.0.1
 */