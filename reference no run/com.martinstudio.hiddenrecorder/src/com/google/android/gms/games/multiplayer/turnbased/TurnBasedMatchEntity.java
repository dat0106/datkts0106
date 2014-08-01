package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;
import java.util.ArrayList;

public final class TurnBasedMatchEntity
  implements SafeParcelable, TurnBasedMatch
{
  public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();
  private final String Mm;
  private final String Of;
  private final GameEntity Rq;
  private final long SR;
  private final ArrayList<ParticipantEntity> SU;
  private final int SV;
  private final int TA;
  private final int TB;
  private final byte[] TC;
  private final String TD;
  private final byte[] TE;
  private final int TF;
  private final int TG;
  private final boolean TH;
  private final String TI;
  private final Bundle Tl;
  private final String Tp;
  private final String Tx;
  private final long Ty;
  private final String Tz;
  private final int xJ;
  
  TurnBasedMatchEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2, String paramString4, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, ArrayList<ParticipantEntity> paramArrayList, String paramString5, byte[] paramArrayOfByte2, int paramInt5, Bundle paramBundle, int paramInt6, boolean paramBoolean, String paramString6, String paramString7)
  {
    this.xJ = paramInt1;
    this.Rq = paramGameEntity;
    this.Of = paramString1;
    this.Tp = paramString2;
    this.SR = paramLong1;
    this.Tx = paramString3;
    this.Ty = paramLong2;
    this.Tz = paramString4;
    this.TA = paramInt2;
    this.TG = paramInt6;
    this.SV = paramInt3;
    this.TB = paramInt4;
    this.TC = paramArrayOfByte1;
    this.SU = paramArrayList;
    this.TD = paramString5;
    this.TE = paramArrayOfByte2;
    this.TF = paramInt5;
    this.Tl = paramBundle;
    this.TH = paramBoolean;
    this.Mm = paramString6;
    this.TI = paramString7;
  }
  
  public TurnBasedMatchEntity(TurnBasedMatch paramTurnBasedMatch)
  {
    this.xJ = 2;
    this.Rq = new GameEntity(paramTurnBasedMatch.getGame());
    this.Of = paramTurnBasedMatch.getMatchId();
    this.Tp = paramTurnBasedMatch.getCreatorId();
    this.SR = paramTurnBasedMatch.getCreationTimestamp();
    this.Tx = paramTurnBasedMatch.getLastUpdaterId();
    this.Ty = paramTurnBasedMatch.getLastUpdatedTimestamp();
    this.Tz = paramTurnBasedMatch.getPendingParticipantId();
    this.TA = paramTurnBasedMatch.getStatus();
    this.TG = paramTurnBasedMatch.getTurnStatus();
    this.SV = paramTurnBasedMatch.getVariant();
    this.TB = paramTurnBasedMatch.getVersion();
    this.TD = paramTurnBasedMatch.getRematchId();
    this.TF = paramTurnBasedMatch.getMatchNumber();
    this.Tl = paramTurnBasedMatch.getAutoMatchCriteria();
    this.TH = paramTurnBasedMatch.isLocallyModified();
    this.Mm = paramTurnBasedMatch.getDescription();
    this.TI = paramTurnBasedMatch.getDescriptionParticipantId();
    Object localObject = paramTurnBasedMatch.getData();
    if (localObject != null)
    {
      this.TC = new byte[localObject.length];
      System.arraycopy(localObject, 0, this.TC, 0, localObject.length);
    }
    else
    {
      this.TC = null;
    }
    localObject = paramTurnBasedMatch.getPreviousMatchData();
    if (localObject != null)
    {
      this.TE = new byte[localObject.length];
      System.arraycopy(localObject, 0, this.TE, 0, localObject.length);
    }
    else
    {
      this.TE = null;
    }
    localObject = paramTurnBasedMatch.getParticipants();
    int j = ((ArrayList)localObject).size();
    this.SU = new ArrayList(j);
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      this.SU.add((ParticipantEntity)((Participant)((ArrayList)localObject).get(i)).freeze());
    }
  }
  
  static int a(TurnBasedMatch paramTurnBasedMatch)
  {
    Object[] arrayOfObject = new Object[18];
    arrayOfObject[0] = paramTurnBasedMatch.getGame();
    arrayOfObject[1] = paramTurnBasedMatch.getMatchId();
    arrayOfObject[2] = paramTurnBasedMatch.getCreatorId();
    arrayOfObject[3] = Long.valueOf(paramTurnBasedMatch.getCreationTimestamp());
    arrayOfObject[4] = paramTurnBasedMatch.getLastUpdaterId();
    arrayOfObject[5] = Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp());
    arrayOfObject[6] = paramTurnBasedMatch.getPendingParticipantId();
    arrayOfObject[7] = Integer.valueOf(paramTurnBasedMatch.getStatus());
    arrayOfObject[8] = Integer.valueOf(paramTurnBasedMatch.getTurnStatus());
    arrayOfObject[9] = paramTurnBasedMatch.getDescription();
    arrayOfObject[10] = Integer.valueOf(paramTurnBasedMatch.getVariant());
    arrayOfObject[11] = Integer.valueOf(paramTurnBasedMatch.getVersion());
    arrayOfObject[12] = paramTurnBasedMatch.getParticipants();
    arrayOfObject[13] = paramTurnBasedMatch.getRematchId();
    arrayOfObject[14] = Integer.valueOf(paramTurnBasedMatch.getMatchNumber());
    arrayOfObject[15] = paramTurnBasedMatch.getAutoMatchCriteria();
    arrayOfObject[16] = Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots());
    arrayOfObject[17] = Boolean.valueOf(paramTurnBasedMatch.isLocallyModified());
    return hl.hashCode(arrayOfObject);
  }
  
  static int a(TurnBasedMatch paramTurnBasedMatch, String paramString)
  {
    ArrayList localArrayList = paramTurnBasedMatch.getParticipants();
    int i = localArrayList.size();
    Participant localParticipant;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        throw new IllegalStateException("Participant " + paramString + " is not in match " + paramTurnBasedMatch.getMatchId());
      }
      localParticipant = (Participant)localArrayList.get(j);
      if (localParticipant.getParticipantId().equals(paramString)) {
        break;
      }
    }
    return localParticipant.getStatus();
  }
  
  static boolean a(TurnBasedMatch paramTurnBasedMatch, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof TurnBasedMatch))
    {
      if (paramTurnBasedMatch != paramObject)
      {
        TurnBasedMatch localTurnBasedMatch = (TurnBasedMatch)paramObject;
        if ((!hl.equal(localTurnBasedMatch.getGame(), paramTurnBasedMatch.getGame())) || (!hl.equal(localTurnBasedMatch.getMatchId(), paramTurnBasedMatch.getMatchId())) || (!hl.equal(localTurnBasedMatch.getCreatorId(), paramTurnBasedMatch.getCreatorId())) || (!hl.equal(Long.valueOf(localTurnBasedMatch.getCreationTimestamp()), Long.valueOf(paramTurnBasedMatch.getCreationTimestamp()))) || (!hl.equal(localTurnBasedMatch.getLastUpdaterId(), paramTurnBasedMatch.getLastUpdaterId())) || (!hl.equal(Long.valueOf(localTurnBasedMatch.getLastUpdatedTimestamp()), Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp()))) || (!hl.equal(localTurnBasedMatch.getPendingParticipantId(), paramTurnBasedMatch.getPendingParticipantId())) || (!hl.equal(Integer.valueOf(localTurnBasedMatch.getStatus()), Integer.valueOf(paramTurnBasedMatch.getStatus()))) || (!hl.equal(Integer.valueOf(localTurnBasedMatch.getTurnStatus()), Integer.valueOf(paramTurnBasedMatch.getTurnStatus()))) || (!hl.equal(localTurnBasedMatch.getDescription(), paramTurnBasedMatch.getDescription())) || (!hl.equal(Integer.valueOf(localTurnBasedMatch.getVariant()), Integer.valueOf(paramTurnBasedMatch.getVariant()))) || (!hl.equal(Integer.valueOf(localTurnBasedMatch.getVersion()), Integer.valueOf(paramTurnBasedMatch.getVersion()))) || (!hl.equal(localTurnBasedMatch.getParticipants(), paramTurnBasedMatch.getParticipants())) || (!hl.equal(localTurnBasedMatch.getRematchId(), paramTurnBasedMatch.getRematchId())) || (!hl.equal(Integer.valueOf(localTurnBasedMatch.getMatchNumber()), Integer.valueOf(paramTurnBasedMatch.getMatchNumber()))) || (!hl.equal(localTurnBasedMatch.getAutoMatchCriteria(), paramTurnBasedMatch.getAutoMatchCriteria())) || (!hl.equal(Integer.valueOf(localTurnBasedMatch.getAvailableAutoMatchSlots()), Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots()))) || (!hl.equal(Boolean.valueOf(localTurnBasedMatch.isLocallyModified()), Boolean.valueOf(paramTurnBasedMatch.isLocallyModified())))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(TurnBasedMatch paramTurnBasedMatch)
  {
    return hl.e(paramTurnBasedMatch).a("Game", paramTurnBasedMatch.getGame()).a("MatchId", paramTurnBasedMatch.getMatchId()).a("CreatorId", paramTurnBasedMatch.getCreatorId()).a("CreationTimestamp", Long.valueOf(paramTurnBasedMatch.getCreationTimestamp())).a("LastUpdaterId", paramTurnBasedMatch.getLastUpdaterId()).a("LastUpdatedTimestamp", Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp())).a("PendingParticipantId", paramTurnBasedMatch.getPendingParticipantId()).a("MatchStatus", Integer.valueOf(paramTurnBasedMatch.getStatus())).a("TurnStatus", Integer.valueOf(paramTurnBasedMatch.getTurnStatus())).a("Description", paramTurnBasedMatch.getDescription()).a("Variant", Integer.valueOf(paramTurnBasedMatch.getVariant())).a("Data", paramTurnBasedMatch.getData()).a("Version", Integer.valueOf(paramTurnBasedMatch.getVersion())).a("Participants", paramTurnBasedMatch.getParticipants()).a("RematchId", paramTurnBasedMatch.getRematchId()).a("PreviousData", paramTurnBasedMatch.getPreviousMatchData()).a("MatchNumber", Integer.valueOf(paramTurnBasedMatch.getMatchNumber())).a("AutoMatchCriteria", paramTurnBasedMatch.getAutoMatchCriteria()).a("AvailableAutoMatchSlots", Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots())).a("LocallyModified", Boolean.valueOf(paramTurnBasedMatch.isLocallyModified())).a("DescriptionParticipantId", paramTurnBasedMatch.getDescriptionParticipantId()).toString();
  }
  
  static String b(TurnBasedMatch paramTurnBasedMatch, String paramString)
  {
    Object localObject = paramTurnBasedMatch.getParticipants();
    int i = ((ArrayList)localObject).size();
    Participant localParticipant;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return null;
      }
      localParticipant = (Participant)((ArrayList)localObject).get(j);
      Player localPlayer = localParticipant.getPlayer();
      if ((localPlayer != null) && (localPlayer.getPlayerId().equals(paramString))) {
        break;
      }
    }
    localObject = localParticipant.getParticipantId();
    return localObject;
  }
  
  static Participant c(TurnBasedMatch paramTurnBasedMatch, String paramString)
  {
    ArrayList localArrayList = paramTurnBasedMatch.getParticipants();
    int j = localArrayList.size();
    Participant localParticipant;
    for (int i = 0;; i++)
    {
      if (i >= j) {
        throw new IllegalStateException("Participant " + paramString + " is not in match " + paramTurnBasedMatch.getMatchId());
      }
      localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(paramString)) {
        break;
      }
    }
    return localParticipant;
  }
  
  static ArrayList<String> c(TurnBasedMatch paramTurnBasedMatch)
  {
    ArrayList localArrayList1 = paramTurnBasedMatch.getParticipants();
    int i = localArrayList1.size();
    ArrayList localArrayList2 = new ArrayList(i);
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return localArrayList2;
      }
      localArrayList2.add(((Participant)localArrayList1.get(j)).getParticipantId());
    }
  }
  
  public boolean canRematch()
  {
    boolean bool;
    if ((this.TA != 2) || (this.TD != null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public TurnBasedMatch freeze()
  {
    return this;
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.Tl;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    int i;
    if (this.Tl != null) {
      i = this.Tl.getInt("max_automatch_players");
    } else {
      i = 0;
    }
    return i;
  }
  
  public long getCreationTimestamp()
  {
    return this.SR;
  }
  
  public String getCreatorId()
  {
    return this.Tp;
  }
  
  public byte[] getData()
  {
    return this.TC;
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mm, paramCharArrayBuffer);
  }
  
  public Participant getDescriptionParticipant()
  {
    return getParticipant(getDescriptionParticipantId());
  }
  
  public String getDescriptionParticipantId()
  {
    return this.TI;
  }
  
  public Game getGame()
  {
    return this.Rq;
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.Ty;
  }
  
  public String getLastUpdaterId()
  {
    return this.Tx;
  }
  
  public String getMatchId()
  {
    return this.Of;
  }
  
  public int getMatchNumber()
  {
    return this.TF;
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
  
  public String getPendingParticipantId()
  {
    return this.Tz;
  }
  
  public byte[] getPreviousMatchData()
  {
    return this.TE;
  }
  
  public String getRematchId()
  {
    return this.TD;
  }
  
  public int getStatus()
  {
    return this.TA;
  }
  
  public int getTurnStatus()
  {
    return this.TG;
  }
  
  public int getVariant()
  {
    return this.SV;
  }
  
  public int getVersion()
  {
    return this.TB;
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
  
  public boolean isLocallyModified()
  {
    return this.TH;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    TurnBasedMatchEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntity
 * JD-Core Version:    0.7.0.1
 */