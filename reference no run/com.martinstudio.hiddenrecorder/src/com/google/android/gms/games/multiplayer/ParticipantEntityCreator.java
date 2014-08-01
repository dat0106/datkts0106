package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;

public class ParticipantEntityCreator
  implements Parcelable.Creator<ParticipantEntity>
{
  static void a(ParticipantEntity paramParticipantEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramParticipantEntity.getParticipantId(), false);
    b.c(paramParcel, 1000, paramParticipantEntity.getVersionCode());
    b.a(paramParcel, 2, paramParticipantEntity.getDisplayName(), false);
    b.a(paramParcel, 3, paramParticipantEntity.getIconImageUri(), paramInt, false);
    b.a(paramParcel, 4, paramParticipantEntity.getHiResImageUri(), paramInt, false);
    b.c(paramParcel, 5, paramParticipantEntity.getStatus());
    b.a(paramParcel, 6, paramParticipantEntity.gR(), false);
    b.a(paramParcel, 7, paramParticipantEntity.isConnectedToRoom());
    b.a(paramParcel, 8, paramParticipantEntity.getPlayer(), paramInt, false);
    b.c(paramParcel, 9, paramParticipantEntity.getCapabilities());
    b.a(paramParcel, 10, paramParticipantEntity.getResult(), paramInt, false);
    b.a(paramParcel, 11, paramParticipantEntity.getIconImageUrl(), false);
    b.a(paramParcel, 12, paramParticipantEntity.getHiResImageUrl(), false);
    b.G(paramParcel, i);
  }
  
  public ParticipantEntity bm(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int m = 0;
    String str5 = null;
    String str3 = null;
    Uri localUri1 = null;
    Uri localUri2 = null;
    int k = 0;
    String str4 = null;
    boolean bool = false;
    PlayerEntity localPlayerEntity = null;
    int n = 0;
    ParticipantResult localParticipantResult = null;
    String str2 = null;
    String str1 = null;
    for (;;)
    {
      if (paramParcel.dataPosition() >= j)
      {
        if (paramParcel.dataPosition() == j) {
          return new ParticipantEntity(m, str5, str3, localUri1, localUri2, k, str4, bool, localPlayerEntity, n, localParticipantResult, str2, str1);
        }
        throw new a.a("Overread allowed size end=" + j, paramParcel);
      }
      int i = a.A(paramParcel);
      switch (a.ar(i))
      {
      default: 
        a.b(paramParcel, i);
        break;
      case 1: 
        str5 = a.o(paramParcel, i);
        break;
      case 2: 
        str3 = a.o(paramParcel, i);
        break;
      case 3: 
        localUri1 = (Uri)a.a(paramParcel, i, Uri.CREATOR);
        break;
      case 4: 
        localUri2 = (Uri)a.a(paramParcel, i, Uri.CREATOR);
        break;
      case 5: 
        k = a.g(paramParcel, i);
        break;
      case 6: 
        str4 = a.o(paramParcel, i);
        break;
      case 7: 
        bool = a.c(paramParcel, i);
        break;
      case 8: 
        localPlayerEntity = (PlayerEntity)a.a(paramParcel, i, PlayerEntity.CREATOR);
        break;
      case 9: 
        n = a.g(paramParcel, i);
        break;
      case 10: 
        localParticipantResult = (ParticipantResult)a.a(paramParcel, i, ParticipantResult.CREATOR);
        break;
      case 11: 
        str2 = a.o(paramParcel, i);
        break;
      case 12: 
        str1 = a.o(paramParcel, i);
        break;
      case 1000: 
        m = a.g(paramParcel, i);
      }
    }
  }
  
  public ParticipantEntity[] cy(int paramInt)
  {
    return new ParticipantEntity[paramInt];
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.ParticipantEntityCreator
 * JD-Core Version:    0.7.0.1
 */