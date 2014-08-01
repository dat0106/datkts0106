package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class PlayerLevelCreator
  implements Parcelable.Creator<PlayerLevel>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(PlayerLevel paramPlayerLevel, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramPlayerLevel.getLevelNumber());
    b.c(paramParcel, 1000, paramPlayerLevel.getVersionCode());
    b.a(paramParcel, 2, paramPlayerLevel.getMinXp());
    b.a(paramParcel, 3, paramPlayerLevel.getMaxXp());
    b.G(paramParcel, i);
  }
  
  public PlayerLevel createFromParcel(Parcel paramParcel)
  {
    long l2 = 0L;
    int j = 0;
    int k = a.B(paramParcel);
    long l1 = l2;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= k)
      {
        if (paramParcel.dataPosition() == k) {
          return new PlayerLevel(m, j, l1, l2);
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
        l1 = a.i(paramParcel, i);
        break;
      case 3: 
        l2 = a.i(paramParcel, i);
        break;
      case 1000: 
        m = a.g(paramParcel, i);
      }
    }
  }
  
  public PlayerLevel[] newArray(int paramInt)
  {
    return new PlayerLevel[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerLevelCreator
 * JD-Core Version:    0.7.0.1
 */