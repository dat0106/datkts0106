package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class RoomEntityCreator
  implements Parcelable.Creator<RoomEntity>
{
  static void a(RoomEntity paramRoomEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramRoomEntity.getRoomId(), false);
    b.c(paramParcel, 1000, paramRoomEntity.getVersionCode());
    b.a(paramParcel, 2, paramRoomEntity.getCreatorId(), false);
    b.a(paramParcel, 3, paramRoomEntity.getCreationTimestamp());
    b.c(paramParcel, 4, paramRoomEntity.getStatus());
    b.a(paramParcel, 5, paramRoomEntity.getDescription(), false);
    b.c(paramParcel, 6, paramRoomEntity.getVariant());
    b.a(paramParcel, 7, paramRoomEntity.getAutoMatchCriteria(), false);
    b.b(paramParcel, 8, paramRoomEntity.getParticipants(), false);
    b.c(paramParcel, 9, paramRoomEntity.getAutoMatchWaitEstimateSeconds());
    b.G(paramParcel, i);
  }
  
  public RoomEntity bo(Parcel paramParcel)
  {
    int n = 0;
    ArrayList localArrayList = null;
    int i = a.B(paramParcel);
    long l = 0L;
    Bundle localBundle = null;
    int k = 0;
    String str1 = null;
    int i1 = 0;
    String str3 = null;
    String str2 = null;
    int m = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i)
      {
        if (paramParcel.dataPosition() == i) {
          return new RoomEntity(m, str2, str3, l, i1, str1, k, localBundle, localArrayList, n);
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
        str2 = a.o(paramParcel, j);
        break;
      case 2: 
        str3 = a.o(paramParcel, j);
        break;
      case 3: 
        l = a.i(paramParcel, j);
        break;
      case 4: 
        i1 = a.g(paramParcel, j);
        break;
      case 5: 
        str1 = a.o(paramParcel, j);
        break;
      case 6: 
        k = a.g(paramParcel, j);
        break;
      case 7: 
        localBundle = a.q(paramParcel, j);
        break;
      case 8: 
        localArrayList = a.c(paramParcel, j, ParticipantEntity.CREATOR);
        break;
      case 9: 
        n = a.g(paramParcel, j);
        break;
      case 1000: 
        m = a.g(paramParcel, j);
      }
    }
  }
  
  public RoomEntity[] cA(int paramInt)
  {
    return new RoomEntity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RoomEntityCreator
 * JD-Core Version:    0.7.0.1
 */