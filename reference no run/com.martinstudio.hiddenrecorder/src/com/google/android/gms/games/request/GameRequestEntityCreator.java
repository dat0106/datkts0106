package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator
  implements Parcelable.Creator<GameRequestEntity>
{
  public static final int CONTENT_DESCRIPTION;
  
  static void a(GameRequestEntity paramGameRequestEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramGameRequestEntity.getGame(), paramInt, false);
    b.c(paramParcel, 1000, paramGameRequestEntity.getVersionCode());
    b.a(paramParcel, 2, paramGameRequestEntity.getSender(), paramInt, false);
    b.a(paramParcel, 3, paramGameRequestEntity.getData(), false);
    b.a(paramParcel, 4, paramGameRequestEntity.getRequestId(), false);
    b.b(paramParcel, 5, paramGameRequestEntity.getRecipients(), false);
    b.c(paramParcel, 7, paramGameRequestEntity.getType());
    b.a(paramParcel, 9, paramGameRequestEntity.getCreationTimestamp());
    b.a(paramParcel, 10, paramGameRequestEntity.getExpirationTimestamp());
    b.a(paramParcel, 11, paramGameRequestEntity.iG(), false);
    b.c(paramParcel, 12, paramGameRequestEntity.getStatus());
    b.G(paramParcel, i);
  }
  
  public GameRequestEntity createFromParcel(Parcel paramParcel)
  {
    int m = a.B(paramParcel);
    int k = 0;
    GameEntity localGameEntity = null;
    PlayerEntity localPlayerEntity = null;
    byte[] arrayOfByte = null;
    String str = null;
    ArrayList localArrayList = null;
    int j = 0;
    long l1 = 0L;
    long l2 = 0L;
    Bundle localBundle = null;
    int n = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= m)
      {
        if (paramParcel.dataPosition() == m) {
          return new GameRequestEntity(k, localGameEntity, localPlayerEntity, arrayOfByte, str, localArrayList, j, l1, l2, localBundle, n);
        }
        throw new a.a("Overread allowed size end=" + m, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        localGameEntity = (GameEntity)a.a(paramParcel, i, GameEntity.CREATOR);
        break;
      case 2: 
        localPlayerEntity = (PlayerEntity)a.a(paramParcel, i, PlayerEntity.CREATOR);
        break;
      case 3: 
        arrayOfByte = a.r(paramParcel, i);
        break;
      case 4: 
        str = a.o(paramParcel, i);
        break;
      case 5: 
        localArrayList = a.c(paramParcel, i, PlayerEntity.CREATOR);
        break;
      case 7: 
        j = a.g(paramParcel, i);
        break;
      case 9: 
        l1 = a.i(paramParcel, i);
        break;
      case 10: 
        l2 = a.i(paramParcel, i);
        break;
      case 11: 
        localBundle = a.q(paramParcel, i);
        break;
      case 12: 
        n = a.g(paramParcel, i);
        break;
      case 1000: 
        k = a.g(paramParcel, i);
      }
    }
  }
  
  public GameRequestEntity[] newArray(int paramInt)
  {
    return new GameRequestEntity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.request.GameRequestEntityCreator
 * JD-Core Version:    0.7.0.1
 */