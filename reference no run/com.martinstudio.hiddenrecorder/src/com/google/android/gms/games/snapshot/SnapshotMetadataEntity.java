package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;

public final class SnapshotMetadataEntity
  implements SafeParcelable, SnapshotMetadata
{
  public static final SnapshotMetadataEntityCreator CREATOR = new SnapshotMetadataEntityCreator();
  private final String HV;
  private final String Mm;
  private final String NH;
  private final GameEntity Rq;
  private final Uri Ue;
  private final PlayerEntity Ui;
  private final String Uj;
  private final long Uk;
  private final long Ul;
  private final float Um;
  private final String Un;
  private final int xJ;
  
  SnapshotMetadataEntity(int paramInt, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, float paramFloat, String paramString5)
  {
    this.xJ = paramInt;
    this.Rq = paramGameEntity;
    this.Ui = paramPlayerEntity;
    this.NH = paramString1;
    this.Ue = paramUri;
    this.Uj = paramString2;
    this.Um = paramFloat;
    this.HV = paramString3;
    this.Mm = paramString4;
    this.Uk = paramLong1;
    this.Ul = paramLong2;
    this.Un = paramString5;
  }
  
  public SnapshotMetadataEntity(SnapshotMetadata paramSnapshotMetadata)
  {
    this.xJ = 3;
    this.Rq = new GameEntity(paramSnapshotMetadata.getGame());
    this.Ui = new PlayerEntity(paramSnapshotMetadata.getOwner());
    this.NH = paramSnapshotMetadata.getSnapshotId();
    this.Ue = paramSnapshotMetadata.getCoverImageUri();
    this.Uj = paramSnapshotMetadata.getCoverImageUrl();
    this.Um = paramSnapshotMetadata.getCoverImageAspectRatio();
    this.HV = paramSnapshotMetadata.getTitle();
    this.Mm = paramSnapshotMetadata.getDescription();
    this.Uk = paramSnapshotMetadata.getLastModifiedTimestamp();
    this.Ul = paramSnapshotMetadata.getPlayedTime();
    this.Un = paramSnapshotMetadata.getUniqueName();
  }
  
  static int a(SnapshotMetadata paramSnapshotMetadata)
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = paramSnapshotMetadata.getGame();
    arrayOfObject[1] = paramSnapshotMetadata.getOwner();
    arrayOfObject[2] = paramSnapshotMetadata.getSnapshotId();
    arrayOfObject[3] = paramSnapshotMetadata.getCoverImageUri();
    arrayOfObject[4] = Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio());
    arrayOfObject[5] = paramSnapshotMetadata.getTitle();
    arrayOfObject[6] = paramSnapshotMetadata.getDescription();
    arrayOfObject[7] = Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp());
    arrayOfObject[8] = Long.valueOf(paramSnapshotMetadata.getPlayedTime());
    arrayOfObject[9] = paramSnapshotMetadata.getUniqueName();
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(SnapshotMetadata paramSnapshotMetadata, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof SnapshotMetadata))
    {
      if (paramSnapshotMetadata != paramObject)
      {
        SnapshotMetadata localSnapshotMetadata = (SnapshotMetadata)paramObject;
        if ((!hl.equal(localSnapshotMetadata.getGame(), paramSnapshotMetadata.getGame())) || (!hl.equal(localSnapshotMetadata.getOwner(), paramSnapshotMetadata.getOwner())) || (!hl.equal(localSnapshotMetadata.getSnapshotId(), paramSnapshotMetadata.getSnapshotId())) || (!hl.equal(localSnapshotMetadata.getCoverImageUri(), paramSnapshotMetadata.getCoverImageUri())) || (!hl.equal(Float.valueOf(localSnapshotMetadata.getCoverImageAspectRatio()), Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio()))) || (!hl.equal(localSnapshotMetadata.getTitle(), paramSnapshotMetadata.getTitle())) || (!hl.equal(localSnapshotMetadata.getDescription(), paramSnapshotMetadata.getDescription())) || (!hl.equal(Long.valueOf(localSnapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp()))) || (!hl.equal(Long.valueOf(localSnapshotMetadata.getPlayedTime()), Long.valueOf(paramSnapshotMetadata.getPlayedTime()))) || (!hl.equal(localSnapshotMetadata.getUniqueName(), paramSnapshotMetadata.getUniqueName()))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(SnapshotMetadata paramSnapshotMetadata)
  {
    return hl.e(paramSnapshotMetadata).a("Game", paramSnapshotMetadata.getGame()).a("Owner", paramSnapshotMetadata.getOwner()).a("SnapshotId", paramSnapshotMetadata.getSnapshotId()).a("CoverImageUri", paramSnapshotMetadata.getCoverImageUri()).a("CoverImageUrl", paramSnapshotMetadata.getCoverImageUrl()).a("CoverImageAspectRatio", Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio())).a("Description", paramSnapshotMetadata.getDescription()).a("LastModifiedTimestamp", Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp())).a("PlayedTime", Long.valueOf(paramSnapshotMetadata.getPlayedTime())).a("UniqueName", paramSnapshotMetadata.getUniqueName()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public SnapshotMetadata freeze()
  {
    return this;
  }
  
  public float getCoverImageAspectRatio()
  {
    return this.Um;
  }
  
  public Uri getCoverImageUri()
  {
    return this.Ue;
  }
  
  public String getCoverImageUrl()
  {
    return this.Uj;
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    il.b(this.Mm, paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.Rq;
  }
  
  public long getLastModifiedTimestamp()
  {
    return this.Uk;
  }
  
  public Player getOwner()
  {
    return this.Ui;
  }
  
  public long getPlayedTime()
  {
    return this.Ul;
  }
  
  public String getSnapshotId()
  {
    return this.NH;
  }
  
  public String getTitle()
  {
    return this.HV;
  }
  
  public String getUniqueName()
  {
    return this.Un;
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
    SnapshotMetadataEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadataEntity
 * JD-Core Version:    0.7.0.1
 */