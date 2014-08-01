package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class GameBadgeEntityCreator
  implements Parcelable.Creator<GameBadgeEntity>
{
  static void a(GameBadgeEntity paramGameBadgeEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramGameBadgeEntity.getType());
    b.c(paramParcel, 1000, paramGameBadgeEntity.getVersionCode());
    b.a(paramParcel, 2, paramGameBadgeEntity.getTitle(), false);
    b.a(paramParcel, 3, paramGameBadgeEntity.getDescription(), false);
    b.a(paramParcel, 4, paramGameBadgeEntity.getIconImageUri(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public GameBadgeEntity bh(Parcel paramParcel)
  {
    int i = 0;
    Uri localUri = null;
    int j = a.B(paramParcel);
    String str2 = null;
    String str1 = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new GameBadgeEntity(m, i, str1, str2, localUri);
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
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
        break;
      case 4: 
        localUri = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 1000: 
        m = a.g(paramParcel, k);
      }
    }
  }
  
  public GameBadgeEntity[] cq(int paramInt)
  {
    return new GameBadgeEntity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.GameBadgeEntityCreator
 * JD-Core Version:    0.7.0.1
 */