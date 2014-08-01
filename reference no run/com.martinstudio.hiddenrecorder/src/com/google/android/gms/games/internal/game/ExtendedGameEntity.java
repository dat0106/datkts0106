package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import java.util.ArrayList;

public final class ExtendedGameEntity
  extends GamesDowngradeableSafeParcel
  implements ExtendedGame
{
  public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntityCreatorCompat();
  private final SnapshotMetadataEntity RA;
  private final GameEntity Rq;
  private final int Rr;
  private final boolean Rs;
  private final int Rt;
  private final long Ru;
  private final long Rv;
  private final String Rw;
  private final long Rx;
  private final String Ry;
  private final ArrayList<GameBadgeEntity> Rz;
  private final int xJ;
  
  ExtendedGameEntity(int paramInt1, GameEntity paramGameEntity, int paramInt2, boolean paramBoolean, int paramInt3, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, ArrayList<GameBadgeEntity> paramArrayList, SnapshotMetadataEntity paramSnapshotMetadataEntity)
  {
    this.xJ = paramInt1;
    this.Rq = paramGameEntity;
    this.Rr = paramInt2;
    this.Rs = paramBoolean;
    this.Rt = paramInt3;
    this.Ru = paramLong1;
    this.Rv = paramLong2;
    this.Rw = paramString1;
    this.Rx = paramLong3;
    this.Ry = paramString2;
    this.Rz = paramArrayList;
    this.RA = paramSnapshotMetadataEntity;
  }
  
  public ExtendedGameEntity(ExtendedGame paramExtendedGame)
  {
    this.xJ = 2;
    Object localObject2 = paramExtendedGame.getGame();
    if (localObject2 != null) {
      localObject2 = new GameEntity((Game)localObject2);
    } else {
      localObject2 = null;
    }
    this.Rq = ((GameEntity)localObject2);
    this.Rr = paramExtendedGame.hM();
    this.Rs = paramExtendedGame.hN();
    this.Rt = paramExtendedGame.hO();
    this.Ru = paramExtendedGame.hP();
    this.Rv = paramExtendedGame.hQ();
    this.Rw = paramExtendedGame.hR();
    this.Rx = paramExtendedGame.hS();
    this.Ry = paramExtendedGame.hT();
    localObject2 = paramExtendedGame.hU();
    if (localObject2 != null) {
      localObject1 = new SnapshotMetadataEntity((SnapshotMetadata)localObject2);
    }
    this.RA = ((SnapshotMetadataEntity)localObject1);
    localObject1 = paramExtendedGame.hL();
    int i = ((ArrayList)localObject1).size();
    this.Rz = new ArrayList(i);
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      this.Rz.add((GameBadgeEntity)((GameBadge)((ArrayList)localObject1).get(j)).freeze());
    }
  }
  
  static int a(ExtendedGame paramExtendedGame)
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = paramExtendedGame.getGame();
    arrayOfObject[1] = Integer.valueOf(paramExtendedGame.hM());
    arrayOfObject[2] = Boolean.valueOf(paramExtendedGame.hN());
    arrayOfObject[3] = Integer.valueOf(paramExtendedGame.hO());
    arrayOfObject[4] = Long.valueOf(paramExtendedGame.hP());
    arrayOfObject[5] = Long.valueOf(paramExtendedGame.hQ());
    arrayOfObject[6] = paramExtendedGame.hR();
    arrayOfObject[7] = Long.valueOf(paramExtendedGame.hS());
    arrayOfObject[8] = paramExtendedGame.hT();
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(ExtendedGame paramExtendedGame, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof ExtendedGame))
    {
      if (paramExtendedGame != paramObject)
      {
        ExtendedGame localExtendedGame = (ExtendedGame)paramObject;
        if ((!hl.equal(localExtendedGame.getGame(), paramExtendedGame.getGame())) || (!hl.equal(Integer.valueOf(localExtendedGame.hM()), Integer.valueOf(paramExtendedGame.hM()))) || (!hl.equal(Boolean.valueOf(localExtendedGame.hN()), Boolean.valueOf(paramExtendedGame.hN()))) || (!hl.equal(Integer.valueOf(localExtendedGame.hO()), Integer.valueOf(paramExtendedGame.hO()))) || (!hl.equal(Long.valueOf(localExtendedGame.hP()), Long.valueOf(paramExtendedGame.hP()))) || (!hl.equal(Long.valueOf(localExtendedGame.hQ()), Long.valueOf(paramExtendedGame.hQ()))) || (!hl.equal(localExtendedGame.hR(), paramExtendedGame.hR())) || (!hl.equal(Long.valueOf(localExtendedGame.hS()), Long.valueOf(paramExtendedGame.hS()))) || (!hl.equal(localExtendedGame.hT(), paramExtendedGame.hT()))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(ExtendedGame paramExtendedGame)
  {
    return hl.e(paramExtendedGame).a("Game", paramExtendedGame.getGame()).a("Availability", Integer.valueOf(paramExtendedGame.hM())).a("Owned", Boolean.valueOf(paramExtendedGame.hN())).a("AchievementUnlockedCount", Integer.valueOf(paramExtendedGame.hO())).a("LastPlayedServerTimestamp", Long.valueOf(paramExtendedGame.hP())).a("PriceMicros", Long.valueOf(paramExtendedGame.hQ())).a("FormattedPrice", paramExtendedGame.hR()).a("FullPriceMicros", Long.valueOf(paramExtendedGame.hS())).a("FormattedFullPrice", paramExtendedGame.hT()).a("Snapshot", paramExtendedGame.hU()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public ArrayList<GameBadge> hL()
  {
    return new ArrayList(this.Rz);
  }
  
  public int hM()
  {
    return this.Rr;
  }
  
  public boolean hN()
  {
    return this.Rs;
  }
  
  public int hO()
  {
    return this.Rt;
  }
  
  public long hP()
  {
    return this.Ru;
  }
  
  public long hQ()
  {
    return this.Rv;
  }
  
  public String hR()
  {
    return this.Rw;
  }
  
  public long hS()
  {
    return this.Rx;
  }
  
  public String hT()
  {
    return this.Ry;
  }
  
  public SnapshotMetadata hU()
  {
    return this.RA;
  }
  
  public GameEntity hV()
  {
    return this.Rq;
  }
  
  public ExtendedGame hW()
  {
    return this;
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
    int i = 0;
    if (fm())
    {
      this.Rq.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.Rr);
      if (!this.Rs) {
        j = 0;
      } else {
        j = 1;
      }
      paramParcel.writeInt(j);
      paramParcel.writeInt(this.Rt);
      paramParcel.writeLong(this.Ru);
      paramParcel.writeLong(this.Rv);
      paramParcel.writeString(this.Rw);
      paramParcel.writeLong(this.Rx);
      paramParcel.writeString(this.Ry);
      int j = this.Rz.size();
      paramParcel.writeInt(j);
      while (i < j)
      {
        ((GameBadgeEntity)this.Rz.get(i)).writeToParcel(paramParcel, paramInt);
        i++;
      }
    }
    ExtendedGameEntityCreator.a(this, paramParcel, paramInt);
  }
  
  static final class ExtendedGameEntityCreatorCompat
    extends ExtendedGameEntityCreator
  {
    public ExtendedGameEntity bg(Parcel paramParcel)
    {
      if ((!ExtendedGameEntity.b(ExtendedGameEntity.gM())) && (!ExtendedGameEntity.aQ(ExtendedGameEntity.class.getCanonicalName())))
      {
        GameEntity localGameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(paramParcel);
        int k = paramParcel.readInt();
        boolean bool;
        if (paramParcel.readInt() != 1) {
          bool = false;
        } else {
          bool = true;
        }
        int m = paramParcel.readInt();
        long l2 = paramParcel.readLong();
        long l3 = paramParcel.readLong();
        String str1 = paramParcel.readString();
        long l1 = paramParcel.readLong();
        String str2 = paramParcel.readString();
        int i = paramParcel.readInt();
        ArrayList localArrayList = new ArrayList(i);
        for (int j = 0;; j++)
        {
          if (j >= i)
          {
            localExtendedGameEntity = new ExtendedGameEntity(2, localGameEntity, k, bool, m, l2, l3, str1, l1, str2, localArrayList, null);
            break;
          }
          localArrayList.add(GameBadgeEntity.CREATOR.bh(paramParcel));
        }
      }
      ExtendedGameEntity localExtendedGameEntity = super.bg(paramParcel);
      return localExtendedGameEntity;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.ExtendedGameEntity
 * JD-Core Version:    0.7.0.1
 */