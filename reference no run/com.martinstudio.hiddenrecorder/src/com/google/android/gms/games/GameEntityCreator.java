package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class GameEntityCreator
  implements Parcelable.Creator<GameEntity>
{
  static void a(GameEntity paramGameEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramGameEntity.getApplicationId(), false);
    b.a(paramParcel, 2, paramGameEntity.getDisplayName(), false);
    b.a(paramParcel, 3, paramGameEntity.getPrimaryCategory(), false);
    b.a(paramParcel, 4, paramGameEntity.getSecondaryCategory(), false);
    b.a(paramParcel, 5, paramGameEntity.getDescription(), false);
    b.a(paramParcel, 6, paramGameEntity.getDeveloperName(), false);
    b.a(paramParcel, 7, paramGameEntity.getIconImageUri(), paramInt, false);
    b.a(paramParcel, 8, paramGameEntity.getHiResImageUri(), paramInt, false);
    b.a(paramParcel, 9, paramGameEntity.getFeaturedImageUri(), paramInt, false);
    b.a(paramParcel, 10, paramGameEntity.gH());
    b.a(paramParcel, 11, paramGameEntity.gJ());
    b.a(paramParcel, 12, paramGameEntity.gK(), false);
    b.c(paramParcel, 13, paramGameEntity.gL());
    b.c(paramParcel, 14, paramGameEntity.getAchievementTotalCount());
    b.c(paramParcel, 15, paramGameEntity.getLeaderboardCount());
    b.a(paramParcel, 17, paramGameEntity.isTurnBasedMultiplayerEnabled());
    b.a(paramParcel, 16, paramGameEntity.isRealTimeMultiplayerEnabled());
    b.c(paramParcel, 1000, paramGameEntity.getVersionCode());
    b.a(paramParcel, 19, paramGameEntity.getHiResImageUrl(), false);
    b.a(paramParcel, 18, paramGameEntity.getIconImageUrl(), false);
    b.a(paramParcel, 21, paramGameEntity.isMuted());
    b.a(paramParcel, 20, paramGameEntity.getFeaturedImageUrl(), false);
    b.a(paramParcel, 23, paramGameEntity.areSnapshotsEnabled());
    b.a(paramParcel, 22, paramGameEntity.gI());
    b.G(paramParcel, i);
  }
  
  public GameEntity bd(Parcel paramParcel)
  {
    int i = a.B(paramParcel);
    int n = 0;
    String str4 = null;
    String str3 = null;
    String str8 = null;
    String str2 = null;
    String str7 = null;
    String str9 = null;
    Uri localUri1 = null;
    Uri localUri3 = null;
    Uri localUri2 = null;
    boolean bool3 = false;
    boolean bool4 = false;
    String str6 = null;
    int i1 = 0;
    int m = 0;
    int k = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    String str1 = null;
    String str5 = null;
    String str10 = null;
    boolean bool7 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new GameEntity(n, str4, str3, str8, str2, str7, str9, localUri1, localUri3, localUri2, bool3, bool4, str6, i1, m, k, bool2, bool1, str1, str5, str10, bool7, bool5, bool6);
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
        str4 = a.o(paramParcel, j);
        break;
      case 2: 
        str3 = a.o(paramParcel, j);
        break;
      case 3: 
        str8 = a.o(paramParcel, j);
        break;
      case 4: 
        str2 = a.o(paramParcel, j);
        break;
      case 5: 
        str7 = a.o(paramParcel, j);
        break;
      case 6: 
        str9 = a.o(paramParcel, j);
        break;
      case 7: 
        localUri1 = (Uri)a.a(paramParcel, j, Uri.CREATOR);
        break;
      case 8: 
        localUri3 = (Uri)a.a(paramParcel, j, Uri.CREATOR);
        break;
      case 9: 
        localUri2 = (Uri)a.a(paramParcel, j, Uri.CREATOR);
        break;
      case 10: 
        bool3 = a.c(paramParcel, j);
        break;
      case 11: 
        bool4 = a.c(paramParcel, j);
        break;
      case 12: 
        str6 = a.o(paramParcel, j);
        break;
      case 13: 
        i1 = a.g(paramParcel, j);
        break;
      case 14: 
        m = a.g(paramParcel, j);
        break;
      case 15: 
        k = a.g(paramParcel, j);
        break;
      case 16: 
        bool2 = a.c(paramParcel, j);
        break;
      case 17: 
        bool1 = a.c(paramParcel, j);
        break;
      case 18: 
        str1 = a.o(paramParcel, j);
        break;
      case 19: 
        str5 = a.o(paramParcel, j);
        break;
      case 20: 
        str10 = a.o(paramParcel, j);
        break;
      case 21: 
        bool7 = a.c(paramParcel, j);
        break;
      case 22: 
        bool5 = a.c(paramParcel, j);
        break;
      case 23: 
        bool6 = a.c(paramParcel, j);
        break;
      case 1000: 
        n = a.g(paramParcel, j);
      }
    }
  }
  
  public GameEntity[] cb(int paramInt)
  {
    return new GameEntity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.GameEntityCreator
 * JD-Core Version:    0.7.0.1
 */