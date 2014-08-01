package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class MostRecentGameInfoEntityCreator
  implements Parcelable.Creator<MostRecentGameInfoEntity>
{
  static void a(MostRecentGameInfoEntity paramMostRecentGameInfoEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramMostRecentGameInfoEntity.ik(), false);
    b.c(paramParcel, 1000, paramMostRecentGameInfoEntity.getVersionCode());
    b.a(paramParcel, 2, paramMostRecentGameInfoEntity.il(), false);
    b.a(paramParcel, 3, paramMostRecentGameInfoEntity.im());
    b.a(paramParcel, 4, paramMostRecentGameInfoEntity.in(), paramInt, false);
    b.a(paramParcel, 5, paramMostRecentGameInfoEntity.io(), paramInt, false);
    b.a(paramParcel, 6, paramMostRecentGameInfoEntity.ip(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public MostRecentGameInfoEntity bj(Parcel paramParcel)
  {
    Uri localUri1 = null;
    int i = a.B(paramParcel);
    int j = 0;
    long l = 0L;
    Uri localUri2 = null;
    Uri localUri3 = null;
    String str2 = null;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new MostRecentGameInfoEntity(j, str1, str2, l, localUri3, localUri2, localUri1);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str1 = a.o(paramParcel, k);
        break;
      case 2: 
        str2 = a.o(paramParcel, k);
        break;
      case 3: 
        l = a.i(paramParcel, k);
        break;
      case 4: 
        localUri3 = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 5: 
        localUri2 = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 6: 
        localUri1 = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
      }
    }
  }
  
  public MostRecentGameInfoEntity[] cu(int paramInt)
  {
    return new MostRecentGameInfoEntity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.MostRecentGameInfoEntityCreator
 * JD-Core Version:    0.7.0.1
 */