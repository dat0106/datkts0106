package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;
import java.util.ArrayList;

public final class RoomEntity
  extends GamesDowngradeableSafeParcel
  implements Room
{
  public static final Parcelable.Creator<RoomEntity> CREATOR = new RoomEntityCreatorCompat();
  private final String Mm;
  private final String NP;
  private final long SR;
  private final ArrayList<ParticipantEntity> SU;
  private final int SV;
  private final Bundle Tl;
  private final String Tp;
  private final int Tq;
  private final int Tr;
  private final int xJ;
  
  RoomEntity(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3, Bundle paramBundle, ArrayList<ParticipantEntity> paramArrayList, int paramInt4)
  {
    this.xJ = paramInt1;
    this.NP = paramString1;
    this.Tp = paramString2;
    this.SR = paramLong;
    this.Tq = paramInt2;
    this.Mm = paramString3;
    this.SV = paramInt3;
    this.Tl = paramBundle;
    this.SU = paramArrayList;
    this.Tr = paramInt4;
  }
  
  public RoomEntity(Room paramRoom)
  {
    this.xJ = 2;
    this.NP = paramRoom.getRoomId();
    this.Tp = paramRoom.getCreatorId();
    this.SR = paramRoom.getCreationTimestamp();
    this.Tq = paramRoom.getStatus();
    this.Mm = paramRoom.getDescription();
    this.SV = paramRoom.getVariant();
    this.Tl = paramRoom.getAutoMatchCriteria();
    ArrayList localArrayList = paramRoom.getParticipants();
    int i = localArrayList.size();
    this.SU = new ArrayList(i);
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        this.Tr = paramRoom.getAutoMatchWaitEstimateSeconds();
        return;
      }
      this.SU.add((ParticipantEntity)((Participant)localArrayList.get(j)).freeze());
    }
  }
  
  static int a(Room paramRoom)
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = paramRoom.getRoomId();
    arrayOfObject[1] = paramRoom.getCreatorId();
    arrayOfObject[2] = Long.valueOf(paramRoom.getCreationTimestamp());
    arrayOfObject[3] = Integer.valueOf(paramRoom.getStatus());
    arrayOfObject[4] = paramRoom.getDescription();
    arrayOfObject[5] = Integer.valueOf(paramRoom.getVariant());
    arrayOfObject[6] = paramRoom.getAutoMatchCriteria();
    arrayOfObject[7] = paramRoom.getParticipants();
    arrayOfObject[8] = Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds());
    return hl.hashCode(arrayOfObject);
  }
  
  static int a(Room paramRoom, String paramString)
  {
    ArrayList localArrayList = paramRoom.getParticipants();
    int j = localArrayList.size();
    Participant localParticipant;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        throw new IllegalStateException("Participant " + paramString + " is not in room " + paramRoom.getRoomId());
      }
      localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(paramString)) {
        break;
      }
    }
    return localParticipant.getStatus();
  }
  
  static boolean a(Room paramRoom, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof Room))
    {
      if (paramRoom != paramObject)
      {
        Room localRoom = (Room)paramObject;
        if ((!hl.equal(localRoom.getRoomId(), paramRoom.getRoomId())) || (!hl.equal(localRoom.getCreatorId(), paramRoom.getCreatorId())) || (!hl.equal(Long.valueOf(localRoom.getCreationTimestamp()), Long.valueOf(paramRoom.getCreationTimestamp()))) || (!hl.equal(Integer.valueOf(localRoom.getStatus()), Integer.valueOf(paramRoom.getStatus()))) || (!hl.equal(localRoom.getDescription(), paramRoom.getDescription())) || (!hl.equal(Integer.valueOf(localRoom.getVariant()), Integer.valueOf(paramRoom.getVariant()))) || (!hl.equal(localRoom.getAutoMatchCriteria(), paramRoom.getAutoMatchCriteria())) || (!hl.equal(localRoom.getParticipants(), paramRoom.getParticipants())) || (!hl.equal(Integer.valueOf(localRoom.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds())))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(Room paramRoom)
  {
    return hl.e(paramRoom).a("RoomId", paramRoom.getRoomId()).a("CreatorId", paramRoom.getCreatorId()).a("CreationTimestamp", Long.valueOf(paramRoom.getCreationTimestamp())).a("RoomStatus", Integer.valueOf(paramRoom.getStatus())).a("Description", paramRoom.getDescription()).a("Variant", Integer.valueOf(paramRoom.getVariant())).a("AutoMatchCriteria", paramRoom.getAutoMatchCriteria()).a("Participants", paramRoom.getParticipants()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds())).toString();
  }
  
  static String b(Room paramRoom, String paramString)
  {
    ArrayList localArrayList = paramRoom.getParticipants();
    int j = localArrayList.size();
    Participant localParticipant;
    for (int i = 0;; str++)
    {
      if (i >= j) {
        return null;
      }
      localParticipant = (Participant)localArrayList.get(str);
      Player localPlayer = localParticipant.getPlayer();
      if ((localPlayer != null) && (localPlayer.getPlayerId().equals(paramString))) {
        break;
      }
    }
    String str = localParticipant.getParticipantId();
    return str;
  }
  
  static Participant c(Room paramRoom, String paramString)
  {
    ArrayList localArrayList = paramRoom.getParticipants();
    int j = localArrayList.size();
    Participant localParticipant;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        throw new IllegalStateException("Participant " + paramString + " is not in match " + paramRoom.getRoomId());
      }
      localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(paramString)) {
        break;
      }
    }
    return localParticipant;
  }
  
  static ArrayList<String> c(Room paramRoom)
  {
    ArrayList localArrayList2 = paramRoom.getParticipants();
    int i = localArrayList2.size();
    ArrayList localArrayList1 = new ArrayList(i);
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return localArrayList1;
      }
      localArrayList1.add(((Participant)localArrayList2.get(j)).getParticipantId());
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Room freeze()
  {
    return this;
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.Tl;
  }
  
  public int getAutoMatchWaitEstimateSeconds()
  {
    return this.Tr;
  }
  
  public long getCreationTimestamp()
  {
    return this.SR;
  }
  
  public String getCreatorId()
  {
    return this.Tp;
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mm, paramCharArrayBuffer);
  }
  
  public Participant getParticipant(String paramString)
  {
    return c(this, paramString);
  }
  
  public String getParticipantId(String paramString)
  {
    return b(this, paramString);
  }
  
  public ArrayList<String> getParticipantIds()
  {
    return c(this);
  }
  
  public int getParticipantStatus(String paramString)
  {
    return a(this, paramString);
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.SU);
  }
  
  public String getRoomId()
  {
    return this.NP;
  }
  
  public int getStatus()
  {
    return this.Tq;
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
      paramParcel.writeString(this.NP);
      paramParcel.writeString(this.Tp);
      paramParcel.writeLong(this.SR);
      paramParcel.writeInt(this.Tq);
      paramParcel.writeString(this.Mm);
      paramParcel.writeInt(this.SV);
      paramParcel.writeBundle(this.Tl);
      int i = this.SU.size();
      paramParcel.writeInt(i);
      for (int j = 0; j < i; j++) {
        ((ParticipantEntity)this.SU.get(j)).writeToParcel(paramParcel, paramInt);
      }
    }
    RoomEntityCreator.a(this, paramParcel, paramInt);
  }
  
  static final class RoomEntityCreatorCompat
    extends RoomEntityCreator
  {
    public RoomEntity bo(Parcel paramParcel)
    {
      if ((!RoomEntity.b(RoomEntity.gM())) && (!RoomEntity.aQ(RoomEntity.class.getCanonicalName())))
      {
        String str2 = paramParcel.readString();
        String str1 = paramParcel.readString();
        long l = paramParcel.readLong();
        int j = paramParcel.readInt();
        String str3 = paramParcel.readString();
        int i = paramParcel.readInt();
        Bundle localBundle = paramParcel.readBundle();
        int m = paramParcel.readInt();
        ArrayList localArrayList = new ArrayList(m);
        for (int k = 0;; k++)
        {
          if (k >= m)
          {
            localRoomEntity = new RoomEntity(2, str2, str1, l, j, str3, i, localBundle, localArrayList, -1);
            break;
          }
          localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
        }
      }
      RoomEntity localRoomEntity = super.bo(paramParcel);
      return localRoomEntity;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RoomEntity
 * JD-Core Version:    0.7.0.1
 */