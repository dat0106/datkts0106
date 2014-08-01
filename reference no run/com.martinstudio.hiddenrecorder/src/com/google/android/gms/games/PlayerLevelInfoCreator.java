package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class PlayerLevelInfoCreator
  implements Parcelable.Creator<PlayerLevelInfo>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(PlayerLevelInfo paramPlayerLevelInfo, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramPlayerLevelInfo.getCurrentXpTotal());
    b.c(paramParcel, 1000, paramPlayerLevelInfo.getVersionCode());
    b.a(paramParcel, 2, paramPlayerLevelInfo.getLastLevelUpTimestamp());
    b.a(paramParcel, 3, paramPlayerLevelInfo.getCurrentLevel(), paramInt, false);
    b.a(paramParcel, 4, paramPlayerLevelInfo.getNextLevel(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public PlayerLevelInfo createFromParcel(Parcel paramParcel)
  {
    long l2 = 0L;
    PlayerLevel localPlayerLevel1 = null;
    int i = a.B(paramParcel);
    int j = 0;
    PlayerLevel localPlayerLevel2 = null;
    long l1 = l2;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new PlayerLevelInfo(j, l1, l2, localPlayerLevel2, localPlayerLevel1);
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
        l1 = a.i(paramParcel, k);
        break;
      case 2: 
        l2 = a.i(paramParcel, k);
        break;
      case 3: 
        localPlayerLevel2 = (PlayerLevel)a.a(paramParcel, k, PlayerLevel.CREATOR);
        break;
      case 4: 
        localPlayerLevel1 = (PlayerLevel)a.a(paramParcel, k, PlayerLevel.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
      }
    }
  }
  
  public PlayerLevelInfo[] newArray(int paramInt)
  {
    return new PlayerLevelInfo[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerLevelInfoCreator
 * JD-Core Version:    0.7.0.1
 */