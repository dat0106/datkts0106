package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import com.google.android.gms.internal.il;

public final class ParticipantEntity
  extends GamesDowngradeableSafeParcel
  implements Participant
{
  public static final Parcelable.Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
  private final int Am;
  private final String Lk;
  private final String MA;
  private final Uri Mo;
  private final Uri Mp;
  private final String Mz;
  private final PlayerEntity Ng;
  private final String Nk;
  private final String On;
  private final int SY;
  private final boolean SZ;
  private final ParticipantResult Ta;
  private final int xJ;
  
  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult, String paramString4, String paramString5)
  {
    this.xJ = paramInt1;
    this.On = paramString1;
    this.Lk = paramString2;
    this.Mo = paramUri1;
    this.Mp = paramUri2;
    this.SY = paramInt2;
    this.Nk = paramString3;
    this.SZ = paramBoolean;
    this.Ng = paramPlayerEntity;
    this.Am = paramInt3;
    this.Ta = paramParticipantResult;
    this.Mz = paramString4;
    this.MA = paramString5;
  }
  
  public ParticipantEntity(Participant paramParticipant)
  {
    this.xJ = 3;
    this.On = paramParticipant.getParticipantId();
    this.Lk = paramParticipant.getDisplayName();
    this.Mo = paramParticipant.getIconImageUri();
    this.Mp = paramParticipant.getHiResImageUri();
    this.SY = paramParticipant.getStatus();
    this.Nk = paramParticipant.gR();
    this.SZ = paramParticipant.isConnectedToRoom();
    Object localObject = paramParticipant.getPlayer();
    if (localObject != null) {
      localObject = new PlayerEntity((Player)localObject);
    } else {
      localObject = null;
    }
    this.Ng = ((PlayerEntity)localObject);
    this.Am = paramParticipant.getCapabilities();
    this.Ta = paramParticipant.getResult();
    this.Mz = paramParticipant.getIconImageUrl();
    this.MA = paramParticipant.getHiResImageUrl();
  }
  
  static int a(Participant paramParticipant)
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = paramParticipant.getPlayer();
    arrayOfObject[1] = Integer.valueOf(paramParticipant.getStatus());
    arrayOfObject[2] = paramParticipant.gR();
    arrayOfObject[3] = Boolean.valueOf(paramParticipant.isConnectedToRoom());
    arrayOfObject[4] = paramParticipant.getDisplayName();
    arrayOfObject[5] = paramParticipant.getIconImageUri();
    arrayOfObject[6] = paramParticipant.getHiResImageUri();
    arrayOfObject[7] = Integer.valueOf(paramParticipant.getCapabilities());
    arrayOfObject[8] = paramParticipant.getResult();
    arrayOfObject[9] = paramParticipant.getParticipantId();
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(Participant paramParticipant, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof Participant))
    {
      if (paramParticipant != paramObject)
      {
        Participant localParticipant = (Participant)paramObject;
        if ((!hl.equal(localParticipant.getPlayer(), paramParticipant.getPlayer())) || (!hl.equal(Integer.valueOf(localParticipant.getStatus()), Integer.valueOf(paramParticipant.getStatus()))) || (!hl.equal(localParticipant.gR(), paramParticipant.gR())) || (!hl.equal(Boolean.valueOf(localParticipant.isConnectedToRoom()), Boolean.valueOf(paramParticipant.isConnectedToRoom()))) || (!hl.equal(localParticipant.getDisplayName(), paramParticipant.getDisplayName())) || (!hl.equal(localParticipant.getIconImageUri(), paramParticipant.getIconImageUri())) || (!hl.equal(localParticipant.getHiResImageUri(), paramParticipant.getHiResImageUri())) || (!hl.equal(Integer.valueOf(localParticipant.getCapabilities()), Integer.valueOf(paramParticipant.getCapabilities()))) || (!hl.equal(localParticipant.getResult(), paramParticipant.getResult())) || (!hl.equal(localParticipant.getParticipantId(), paramParticipant.getParticipantId()))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(Participant paramParticipant)
  {
    return hl.e(paramParticipant).a("ParticipantId", paramParticipant.getParticipantId()).a("Player", paramParticipant.getPlayer()).a("Status", Integer.valueOf(paramParticipant.getStatus())).a("ClientAddress", paramParticipant.gR()).a("ConnectedToRoom", Boolean.valueOf(paramParticipant.isConnectedToRoom())).a("DisplayName", paramParticipant.getDisplayName()).a("IconImage", paramParticipant.getIconImageUri()).a("IconImageUrl", paramParticipant.getIconImageUrl()).a("HiResImage", paramParticipant.getHiResImageUri()).a("HiResImageUrl", paramParticipant.getHiResImageUrl()).a("Capabilities", Integer.valueOf(paramParticipant.getCapabilities())).a("Result", paramParticipant.getResult()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Participant freeze()
  {
    return this;
  }
  
  public String gR()
  {
    return this.Nk;
  }
  
  public int getCapabilities()
  {
    return this.Am;
  }
  
  public String getDisplayName()
  {
    String str;
    if (this.Ng != null) {
      str = this.Ng.getDisplayName();
    } else {
      str = this.Lk;
    }
    return str;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.Ng != null) {
      this.Ng.getDisplayName(paramCharArrayBuffer);
    } else {
      il.b(this.Lk, paramCharArrayBuffer);
    }
  }
  
  public Uri getHiResImageUri()
  {
    Uri localUri;
    if (this.Ng != null) {
      localUri = this.Ng.getHiResImageUri();
    } else {
      localUri = this.Mp;
    }
    return localUri;
  }
  
  public String getHiResImageUrl()
  {
    String str;
    if (this.Ng != null) {
      str = this.Ng.getHiResImageUrl();
    } else {
      str = this.MA;
    }
    return str;
  }
  
  public Uri getIconImageUri()
  {
    Uri localUri;
    if (this.Ng != null) {
      localUri = this.Ng.getIconImageUri();
    } else {
      localUri = this.Mo;
    }
    return localUri;
  }
  
  public String getIconImageUrl()
  {
    String str;
    if (this.Ng != null) {
      str = this.Ng.getIconImageUrl();
    } else {
      str = this.Mz;
    }
    return str;
  }
  
  public String getParticipantId()
  {
    return this.On;
  }
  
  public Player getPlayer()
  {
    return this.Ng;
  }
  
  public ParticipantResult getResult()
  {
    return this.Ta;
  }
  
  public int getStatus()
  {
    return this.SY;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isConnectedToRoom()
  {
    return this.SZ;
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
    String str2 = null;
    int i = 0;
    if (fm())
    {
      paramParcel.writeString(this.On);
      paramParcel.writeString(this.Lk);
      String str1;
      if (this.Mo != null) {
        str1 = this.Mo.toString();
      } else {
        str1 = null;
      }
      paramParcel.writeString(str1);
      if (this.Mp != null) {
        str2 = this.Mp.toString();
      }
      paramParcel.writeString(str2);
      paramParcel.writeInt(this.SY);
      paramParcel.writeString(this.Nk);
      int j;
      if (!this.SZ) {
        j = 0;
      } else {
        j = 1;
      }
      paramParcel.writeInt(j);
      if (this.Ng != null) {
        i = 1;
      }
      paramParcel.writeInt(i);
      if (this.Ng != null) {
        this.Ng.writeToParcel(paramParcel, paramInt);
      }
    }
    else
    {
      ParticipantEntityCreator.a(this, paramParcel, paramInt);
    }
  }
  
  static final class ParticipantEntityCreatorCompat
    extends ParticipantEntityCreator
  {
    public ParticipantEntity bm(Parcel paramParcel)
    {
      boolean bool1 = true;
      Object localObject1;
      if ((!ParticipantEntity.b(ParticipantEntity.gM())) && (!ParticipantEntity.aQ(ParticipantEntity.class.getCanonicalName())))
      {
        String str1 = paramParcel.readString();
        localObject1 = paramParcel.readString();
        Object localObject2 = paramParcel.readString();
        if (localObject2 != null) {
          localObject2 = Uri.parse((String)localObject2);
        } else {
          localObject2 = null;
        }
        String str2 = paramParcel.readString();
        Uri localUri;
        if (str2 != null) {
          localUri = Uri.parse(str2);
        } else {
          localUri = null;
        }
        int i = paramParcel.readInt();
        String str3 = paramParcel.readString();
        boolean bool2;
        if (paramParcel.readInt() <= 0) {
          bool2 = false;
        } else {
          bool2 = bool1;
        }
        if (paramParcel.readInt() <= 0) {
          bool1 = false;
        }
        PlayerEntity localPlayerEntity;
        if (!bool1) {
          localPlayerEntity = null;
        } else {
          localPlayerEntity = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(paramParcel);
        }
        localObject1 = new ParticipantEntity(3, str1, (String)localObject1, (Uri)localObject2, localUri, i, str3, bool2, localPlayerEntity, 7, null, null, null);
      }
      else
      {
        localObject1 = super.bm(paramParcel);
      }
      return localObject1;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.ParticipantEntity
 * JD-Core Version:    0.7.0.1
 */