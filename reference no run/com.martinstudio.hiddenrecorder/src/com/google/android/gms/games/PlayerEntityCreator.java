package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator
  implements Parcelable.Creator<PlayerEntity>
{
  static void a(PlayerEntity paramPlayerEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramPlayerEntity.getPlayerId(), false);
    b.a(paramParcel, 2, paramPlayerEntity.getDisplayName(), false);
    b.a(paramParcel, 3, paramPlayerEntity.getIconImageUri(), paramInt, false);
    b.a(paramParcel, 4, paramPlayerEntity.getHiResImageUri(), paramInt, false);
    b.a(paramParcel, 5, paramPlayerEntity.getRetrievedTimestamp());
    b.c(paramParcel, 6, paramPlayerEntity.gN());
    b.a(paramParcel, 7, paramPlayerEntity.getLastPlayedWithTimestamp());
    b.a(paramParcel, 8, paramPlayerEntity.getIconImageUrl(), false);
    b.a(paramParcel, 9, paramPlayerEntity.getHiResImageUrl(), false);
    b.a(paramParcel, 14, paramPlayerEntity.getTitle(), false);
    b.a(paramParcel, 15, paramPlayerEntity.gP(), paramInt, false);
    b.a(paramParcel, 17, paramPlayerEntity.gO());
    b.a(paramParcel, 16, paramPlayerEntity.getLevelInfo(), paramInt, false);
    b.c(paramParcel, 1000, paramPlayerEntity.getVersionCode());
    b.G(paramParcel, i);
  }
  
  public PlayerEntity be(Parcel paramParcel)
  {
    int i = a.B(paramParcel);
    int k = 0;
    String str1 = null;
    String str2 = null;
    Uri localUri2 = null;
    Uri localUri1 = null;
    long l1 = 0L;
    int m = 0;
    long l2 = 0L;
    String str3 = null;
    String str5 = null;
    String str4 = null;
    MostRecentGameInfoEntity localMostRecentGameInfoEntity = null;
    PlayerLevelInfo localPlayerLevelInfo = null;
    boolean bool = false;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new PlayerEntity(k, str1, str2, localUri2, localUri1, l1, m, l2, str3, str5, str4, localMostRecentGameInfoEntity, localPlayerLevelInfo, bool);
        }
        throw new a.a("Overread allowed size end=" + i, paramParcel);
      }
      int j = a.A(paramParcel);
      switch (a.ar(j))
      {
      default: 
        a.b(paramParcel, j);
        break;
      case 1: 
        str1 = a.o(paramParcel, j);
        break;
      case 2: 
        str2 = a.o(paramParcel, j);
        break;
      case 3: 
        localUri2 = (Uri)a.a(paramParcel, j, Uri.CREATOR);
        break;
      case 4: 
        localUri1 = (Uri)a.a(paramParcel, j, Uri.CREATOR);
        break;
      case 5: 
        l1 = a.i(paramParcel, j);
        break;
      case 6: 
        m = a.g(paramParcel, j);
        break;
      case 7: 
        l2 = a.i(paramParcel, j);
        break;
      case 8: 
        str3 = a.o(paramParcel, j);
        break;
      case 9: 
        str5 = a.o(paramParcel, j);
        break;
      case 14: 
        str4 = a.o(paramParcel, j);
        break;
      case 15: 
        localMostRecentGameInfoEntity = (MostRecentGameInfoEntity)a.a(paramParcel, j, MostRecentGameInfoEntity.CREATOR);
        break;
      case 16: 
        localPlayerLevelInfo = (PlayerLevelInfo)a.a(paramParcel, j, PlayerLevelInfo.CREATOR);
        break;
      case 17: 
        bool = a.c(paramParcel, j);
        break;
      case 1000: 
        k = a.g(paramParcel, j);
      }
    }
  }
  
  public PlayerEntity[] cc(int paramInt)
  {
    return new PlayerEntity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerEntityCreator
 * JD-Core Version:    0.7.0.1
 */