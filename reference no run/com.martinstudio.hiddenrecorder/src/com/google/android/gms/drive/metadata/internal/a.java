package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Collection;

public class a
  implements Parcelable.Creator<AppVisibleCustomProperties>
{
  static void a(AppVisibleCustomProperties paramAppVisibleCustomProperties, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramAppVisibleCustomProperties.xJ);
    b.b(paramParcel, 2, paramAppVisibleCustomProperties.JL, false);
    b.G(paramParcel, i);
  }
  
  public AppVisibleCustomProperties aA(Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    int j = 0;
    Object localObject = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new AppVisibleCustomProperties(j, (Collection)localObject);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2: 
        localObject = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, CustomProperty.CREATOR);
      }
    }
  }
  
  public AppVisibleCustomProperties[] bw(int paramInt)
  {
    return new AppVisibleCustomProperties[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.a
 * JD-Core Version:    0.7.0.1
 */