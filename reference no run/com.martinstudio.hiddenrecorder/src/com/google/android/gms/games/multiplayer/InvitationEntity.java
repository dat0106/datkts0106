package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;

public final class InvitationEntity
  extends GamesDowngradeableSafeParcel
  implements Invitation
{
  public static final Parcelable.Creator<InvitationEntity> CREATOR = new InvitationEntityCreatorCompat();
  private final String NN;
  private final GameEntity Rq;
  private final long SR;
  private final int SS;
  private final ParticipantEntity ST;
  private final ArrayList<ParticipantEntity> SU;
  private final int SV;
  private final int SW;
  private final int xJ;
  
  InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList<ParticipantEntity> paramArrayList, int paramInt3, int paramInt4)
  {
    this.xJ = paramInt1;
    this.Rq = paramGameEntity;
    this.NN = paramString;
    this.SR = paramLong;
    this.SS = paramInt2;
    this.ST = paramParticipantEntity;
    this.SU = paramArrayList;
    this.SV = paramInt3;
    this.SW = paramInt4;
  }
  
  InvitationEntity(Invitation paramInvitation)
  {
    this.xJ = 2;
    this.Rq = new GameEntity(paramInvitation.getGame());
    this.NN = paramInvitation.getInvitationId();
    this.SR = paramInvitation.getCreationTimestamp();
    this.SS = paramInvitation.getInvitationType();
    this.SV = paramInvitation.getVariant();
    this.SW = paramInvitation.getAvailableAutoMatchSlots();
    String str = paramInvitation.getInviter().getParticipantId();
    Object localObject = null;
    ArrayList localArrayList = paramInvitation.getParticipants();
    int i = localArrayList.size();
    this.SU = new ArrayList(i);
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        hn.b(localObject, "Must have a valid inviter!");
        this.ST = ((ParticipantEntity)localObject.freeze());
        return;
      }
      Participant localParticipant = (Participant)localArrayList.get(j);
      if (localParticipant.getParticipantId().equals(str)) {
        localObject = localParticipant;
      }
      this.SU.add((ParticipantEntity)localParticipant.freeze());
    }
  }
  
  static int a(Invitation paramInvitation)
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = paramInvitation.getGame();
    arrayOfObject[1] = paramInvitation.getInvitationId();
    arrayOfObject[2] = Long.valueOf(paramInvitation.getCreationTimestamp());
    arrayOfObject[3] = Integer.valueOf(paramInvitation.getInvitationType());
    arrayOfObject[4] = paramInvitation.getInviter();
    arrayOfObject[5] = paramInvitation.getParticipants();
    arrayOfObject[6] = Integer.valueOf(paramInvitation.getVariant());
    arrayOfObject[7] = Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots());
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(Invitation paramInvitation, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof Invitation))
    {
      if (paramInvitation != paramObject)
      {
        Invitation localInvitation = (Invitation)paramObject;
        if ((!hl.equal(localInvitation.getGame(), paramInvitation.getGame())) || (!hl.equal(localInvitation.getInvitationId(), paramInvitation.getInvitationId())) || (!hl.equal(Long.valueOf(localInvitation.getCreationTimestamp()), Long.valueOf(paramInvitation.getCreationTimestamp()))) || (!hl.equal(Integer.valueOf(localInvitation.getInvitationType()), Integer.valueOf(paramInvitation.getInvitationType()))) || (!hl.equal(localInvitation.getInviter(), paramInvitation.getInviter())) || (!hl.equal(localInvitation.getParticipants(), paramInvitation.getParticipants())) || (!hl.equal(Integer.valueOf(localInvitation.getVariant()), Integer.valueOf(paramInvitation.getVariant()))) || (!hl.equal(Integer.valueOf(localInvitation.getAvailableAutoMatchSlots()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(Invitation paramInvitation)
  {
    return hl.e(paramInvitation).a("Game", paramInvitation.getGame()).a("InvitationId", paramInvitation.getInvitationId()).a("CreationTimestamp", Long.valueOf(paramInvitation.getCreationTimestamp())).a("InvitationType", Integer.valueOf(paramInvitation.getInvitationType())).a("Inviter", paramInvitation.getInviter()).a("Participants", paramInvitation.getParticipants()).a("Variant", Integer.valueOf(paramInvitation.getVariant())).a("AvailableAutoMatchSlots", Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Invitation freeze()
  {
    return this;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    return this.SW;
  }
  
  public long getCreationTimestamp()
  {
    return this.SR;
  }
  
  public Game getGame()
  {
    return this.Rq;
  }
  
  public String getInvitationId()
  {
    return this.NN;
  }
  
  public int getInvitationType()
  {
    return this.SS;
  }
  
  public Participant getInviter()
  {
    return this.ST;
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.SU);
  }
  
  public int getVariant()
  {
    return this.SV;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (fm())
    {
      this.Rq.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.NN);
      paramParcel.writeLong(this.SR);
      paramParcel.writeInt(this.SS);
      this.ST.writeToParcel(paramParcel, paramInt);
      int j = this.SU.size();
      paramParcel.writeInt(j);
      for (int i = 0; i < j; i++) {
        ((ParticipantEntity)this.SU.get(i)).writeToParcel(paramParcel, paramInt);
      }
    }
    InvitationEntityCreator.a(this, paramParcel, paramInt);
  }
  
  static final class InvitationEntityCreatorCompat
    extends InvitationEntityCreator
  {
    public InvitationEntity bl(Parcel paramParcel)
    {
      if ((!InvitationEntity.b(InvitationEntity.gM())) && (!InvitationEntity.aQ(InvitationEntity.class.getCanonicalName())))
      {
        GameEntity localGameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(paramParcel);
        String str = paramParcel.readString();
        long l = paramParcel.readLong();
        int j = paramParcel.readInt();
        ParticipantEntity localParticipantEntity = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(paramParcel);
        int i = paramParcel.readInt();
        ArrayList localArrayList = new ArrayList(i);
        for (int k = 0;; k++)
        {
          if (k >= i)
          {
            localInvitationEntity = new InvitationEntity(2, localGameEntity, str, l, j, localParticipantEntity, localArrayList, -1, 0);
            break;
          }
          localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
        }
      }
      InvitationEntity localInvitationEntity = super.bl(paramParcel);
      return localInvitationEntity;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.InvitationEntity
 * JD-Core Version:    0.7.0.1
 */