package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity
  implements SafeParcelable, Quest
{
  public static final QuestEntityCreator CREATOR = new QuestEntityCreator();
  private final int AQ;
  private final String Mm;
  private final GameEntity Rq;
  private final String TM;
  private final long TN;
  private final Uri TO;
  private final String TP;
  private final long TQ;
  private final Uri TR;
  private final String TS;
  private final long TT;
  private final long TU;
  private final ArrayList<MilestoneEntity> TV;
  private final long Ty;
  private final String mName;
  private final int mState;
  private final int xJ;
  
  QuestEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, long paramLong1, Uri paramUri1, String paramString2, String paramString3, long paramLong2, long paramLong3, Uri paramUri2, String paramString4, String paramString5, long paramLong4, long paramLong5, int paramInt2, int paramInt3, ArrayList<MilestoneEntity> paramArrayList)
  {
    this.xJ = paramInt1;
    this.Rq = paramGameEntity;
    this.TM = paramString1;
    this.TN = paramLong1;
    this.TO = paramUri1;
    this.TP = paramString2;
    this.Mm = paramString3;
    this.TQ = paramLong2;
    this.Ty = paramLong3;
    this.TR = paramUri2;
    this.TS = paramString4;
    this.mName = paramString5;
    this.TT = paramLong4;
    this.TU = paramLong5;
    this.mState = paramInt2;
    this.AQ = paramInt3;
    this.TV = paramArrayList;
  }
  
  public QuestEntity(Quest paramQuest)
  {
    this.xJ = 2;
    this.Rq = new GameEntity(paramQuest.getGame());
    this.TM = paramQuest.getQuestId();
    this.TN = paramQuest.getAcceptedTimestamp();
    this.Mm = paramQuest.getDescription();
    this.TO = paramQuest.getBannerImageUri();
    this.TP = paramQuest.getBannerImageUrl();
    this.TQ = paramQuest.getEndTimestamp();
    this.TR = paramQuest.getIconImageUri();
    this.TS = paramQuest.getIconImageUrl();
    this.Ty = paramQuest.getLastUpdatedTimestamp();
    this.mName = paramQuest.getName();
    this.TT = paramQuest.iF();
    this.TU = paramQuest.getStartTimestamp();
    this.mState = paramQuest.getState();
    this.AQ = paramQuest.getType();
    List localList = paramQuest.iE();
    int i = localList.size();
    this.TV = new ArrayList(i);
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      this.TV.add((MilestoneEntity)((Milestone)localList.get(j)).freeze());
    }
  }
  
  static int a(Quest paramQuest)
  {
    Object[] arrayOfObject = new Object[13];
    arrayOfObject[0] = paramQuest.getGame();
    arrayOfObject[1] = paramQuest.getQuestId();
    arrayOfObject[2] = Long.valueOf(paramQuest.getAcceptedTimestamp());
    arrayOfObject[3] = paramQuest.getBannerImageUri();
    arrayOfObject[4] = paramQuest.getDescription();
    arrayOfObject[5] = Long.valueOf(paramQuest.getEndTimestamp());
    arrayOfObject[6] = paramQuest.getIconImageUri();
    arrayOfObject[7] = Long.valueOf(paramQuest.getLastUpdatedTimestamp());
    arrayOfObject[8] = paramQuest.iE();
    arrayOfObject[9] = paramQuest.getName();
    arrayOfObject[10] = Long.valueOf(paramQuest.iF());
    arrayOfObject[11] = Long.valueOf(paramQuest.getStartTimestamp());
    arrayOfObject[12] = Integer.valueOf(paramQuest.getState());
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(Quest paramQuest, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof Quest))
    {
      if (paramQuest != paramObject)
      {
        Quest localQuest = (Quest)paramObject;
        if ((!hl.equal(localQuest.getGame(), paramQuest.getGame())) || (!hl.equal(localQuest.getQuestId(), paramQuest.getQuestId())) || (!hl.equal(Long.valueOf(localQuest.getAcceptedTimestamp()), Long.valueOf(paramQuest.getAcceptedTimestamp()))) || (!hl.equal(localQuest.getBannerImageUri(), paramQuest.getBannerImageUri())) || (!hl.equal(localQuest.getDescription(), paramQuest.getDescription())) || (!hl.equal(Long.valueOf(localQuest.getEndTimestamp()), Long.valueOf(paramQuest.getEndTimestamp()))) || (!hl.equal(localQuest.getIconImageUri(), paramQuest.getIconImageUri())) || (!hl.equal(Long.valueOf(localQuest.getLastUpdatedTimestamp()), Long.valueOf(paramQuest.getLastUpdatedTimestamp()))) || (!hl.equal(localQuest.iE(), paramQuest.iE())) || (!hl.equal(localQuest.getName(), paramQuest.getName())) || (!hl.equal(Long.valueOf(localQuest.iF()), Long.valueOf(paramQuest.iF()))) || (!hl.equal(Long.valueOf(localQuest.getStartTimestamp()), Long.valueOf(paramQuest.getStartTimestamp()))) || (!hl.equal(Integer.valueOf(localQuest.getState()), Integer.valueOf(paramQuest.getState())))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(Quest paramQuest)
  {
    return hl.e(paramQuest).a("Game", paramQuest.getGame()).a("QuestId", paramQuest.getQuestId()).a("AcceptedTimestamp", Long.valueOf(paramQuest.getAcceptedTimestamp())).a("BannerImageUri", paramQuest.getBannerImageUri()).a("BannerImageUrl", paramQuest.getBannerImageUrl()).a("Description", paramQuest.getDescription()).a("EndTimestamp", Long.valueOf(paramQuest.getEndTimestamp())).a("IconImageUri", paramQuest.getIconImageUri()).a("IconImageUrl", paramQuest.getIconImageUrl()).a("LastUpdatedTimestamp", Long.valueOf(paramQuest.getLastUpdatedTimestamp())).a("Milestones", paramQuest.iE()).a("Name", paramQuest.getName()).a("NotifyTimestamp", Long.valueOf(paramQuest.iF())).a("StartTimestamp", Long.valueOf(paramQuest.getStartTimestamp())).a("State", Integer.valueOf(paramQuest.getState())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Quest freeze()
  {
    return this;
  }
  
  public long getAcceptedTimestamp()
  {
    return this.TN;
  }
  
  public Uri getBannerImageUri()
  {
    return this.TO;
  }
  
  public String getBannerImageUrl()
  {
    return this.TP;
  }
  
  public Milestone getCurrentMilestone()
  {
    return (Milestone)iE().get(0);
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mm, paramCharArrayBuffer);
  }
  
  public long getEndTimestamp()
  {
    return this.TQ;
  }
  
  public Game getGame()
  {
    return this.Rq;
  }
  
  public Uri getIconImageUri()
  {
    return this.TR;
  }
  
  public String getIconImageUrl()
  {
    return this.TS;
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.Ty;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.mName, paramCharArrayBuffer);
  }
  
  public String getQuestId()
  {
    return this.TM;
  }
  
  public long getStartTimestamp()
  {
    return this.TU;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public int getType()
  {
    return this.AQ;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public List<Milestone> iE()
  {
    return new ArrayList(this.TV);
  }
  
  public long iF()
  {
    return this.TT;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isEndingSoon()
  {
    boolean bool;
    if (this.TT > 1800000L + System.currentTimeMillis()) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    QuestEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.QuestEntity
 * JD-Core Version:    0.7.0.1
 */