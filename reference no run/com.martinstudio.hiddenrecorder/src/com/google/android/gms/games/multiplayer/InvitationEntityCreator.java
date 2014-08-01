package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class InvitationEntityCreator
  implements Parcelable.Creator<InvitationEntity>
{
  static void a(InvitationEntity paramInvitationEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramInvitationEntity.getGame(), paramInt, false);
    b.c(paramParcel, 1000, paramInvitationEntity.getVersionCode());
    b.a(paramParcel, 2, paramInvitationEntity.getInvitationId(), false);
    b.a(paramParcel, 3, paramInvitationEntity.getCreationTimestamp());
    b.c(paramParcel, 4, paramInvitationEntity.getInvitationType());
    b.a(paramParcel, 5, paramInvitationEntity.getInviter(), paramInt, false);
    b.b(paramParcel, 6, paramInvitationEntity.getParticipants(), false);
    b.c(paramParcel, 7, paramInvitationEntity.getVariant());
    b.c(paramParcel, 8, paramInvitationEntity.getAvailableAutoMatchSlots());
    b.G(paramParcel, i);
  }
  
  public InvitationEntity bl(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int i = 0;
    int i1 = a.B(paramParcel);
    long l = 0L;
    int j = 0;
    ParticipantEntity localParticipantEntity = null;
    int m = 0;
    String str = null;
    GameEntity localGameEntity = null;
    int k = 0;
    for (;;)
    {
      if (paramParcel.dataPosition() >= i1)
      {
        if (paramParcel.dataPosition() == i1) {
          return new InvitationEntity(k, localGameEntity, str, l, m, localParticipantEntity, localArrayList, j, i);
        }
        throw new a.a("Overread allowed size end=" + i1, paramParcel);
      }
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        localGameEntity = (GameEntity)a.a(paramParcel, n, GameEntity.CREATOR);
        break;
      case 2: 
        str = a.o(paramParcel, n);
        break;
      case 3: 
        l = a.i(paramParcel, n);
        break;
      case 4: 
        m = a.g(paramParcel, n);
        break;
      case 5: 
        localParticipantEntity = (ParticipantEntity)a.a(paramParcel, n, ParticipantEntity.CREATOR);
        break;
      case 6: 
        localArrayList = a.c(paramParcel, n, ParticipantEntity.CREATOR);
        break;
      case 7: 
        j = a.g(paramParcel, n);
        break;
      case 8: 
        i = a.g(paramParcel, n);
        break;
      case 1000: 
        k = a.g(paramParcel, n);
      }
    }
  }
  
  public InvitationEntity[] cx(int paramInt)
  {
    return new InvitationEntity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.InvitationEntityCreator
 * JD-Core Version:    0.7.0.1
 */