package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<LaunchOptions>
{
  static void a(LaunchOptions paramLaunchOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramLaunchOptions.getVersionCode());
    b.a(paramParcel, 2, paramLaunchOptions.getRelaunchIfRunning());
    b.a(paramParcel, 3, paramLaunchOptions.getLanguage(), false);
    b.G(paramParcel, i);
  }
  
  public LaunchOptions[] Q(int paramInt)
  {
    return new LaunchOptions[paramInt];
  }
  
  public LaunchOptions t(Parcel paramParcel)
  {
    boolean bool = false;
    int j = a.B(paramParcel);
    String str = null;
    int i = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new LaunchOptions(i, bool, str);
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
        bool = a.c(paramParcel, k);
        break;
      case 3: 
        str = a.o(paramParcel, k);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.c
 * JD-Core Version:    0.7.0.1
 */