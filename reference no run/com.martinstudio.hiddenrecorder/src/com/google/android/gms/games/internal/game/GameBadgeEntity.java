package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class GameBadgeEntity
  extends GamesDowngradeableSafeParcel
  implements GameBadge
{
  public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
  private int AQ;
  private String HV;
  private String Mm;
  private Uri Mo;
  private final int xJ;
  
  GameBadgeEntity(int paramInt1, int paramInt2, String paramString1, String paramString2, Uri paramUri)
  {
    this.xJ = paramInt1;
    this.AQ = paramInt2;
    this.HV = paramString1;
    this.Mm = paramString2;
    this.Mo = paramUri;
  }
  
  public GameBadgeEntity(GameBadge paramGameBadge)
  {
    this.xJ = 1;
    this.AQ = paramGameBadge.getType();
    this.HV = paramGameBadge.getTitle();
    this.Mm = paramGameBadge.getDescription();
    this.Mo = paramGameBadge.getIconImageUri();
  }
  
  static int a(GameBadge paramGameBadge)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(paramGameBadge.getType());
    arrayOfObject[1] = paramGameBadge.getTitle();
    arrayOfObject[2] = paramGameBadge.getDescription();
    arrayOfObject[3] = paramGameBadge.getIconImageUri();
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(GameBadge paramGameBadge, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof GameBadge))
    {
      if (paramGameBadge != paramObject)
      {
        GameBadge localGameBadge = (GameBadge)paramObject;
        if ((!hl.equal(Integer.valueOf(localGameBadge.getType()), paramGameBadge.getTitle())) || (!hl.equal(localGameBadge.getDescription(), paramGameBadge.getIconImageUri()))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(GameBadge paramGameBadge)
  {
    return hl.e(paramGameBadge).a("Type", Integer.valueOf(paramGameBadge.getType())).a("Title", paramGameBadge.getTitle()).a("Description", paramGameBadge.getDescription()).a("IconImageUri", paramGameBadge.getIconImageUri()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDescription()
  {
    return this.Mm;
  }
  
  public Uri getIconImageUri()
  {
    return this.Mo;
  }
  
  public String getTitle()
  {
    return this.HV;
  }
  
  public int getType()
  {
    return this.AQ;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public GameBadge hX()
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
    if (fm())
    {
      paramParcel.writeInt(this.AQ);
      paramParcel.writeString(this.HV);
      paramParcel.writeString(this.Mm);
      String str;
      if (this.Mo != null) {
        str = this.Mo.toString();
      } else {
        str = null;
      }
      paramParcel.writeString(str);
    }
    else
    {
      GameBadgeEntityCreator.a(this, paramParcel, paramInt);
    }
  }
  
  static final class GameBadgeEntityCreatorCompat
    extends GameBadgeEntityCreator
  {
    public GameBadgeEntity bh(Parcel paramParcel)
    {
      GameBadgeEntity localGameBadgeEntity;
      if ((!GameBadgeEntity.b(GameBadgeEntity.gM())) && (!GameBadgeEntity.aQ(GameBadgeEntity.class.getCanonicalName())))
      {
        int i = paramParcel.readInt();
        String str2 = paramParcel.readString();
        String str1 = paramParcel.readString();
        Object localObject = paramParcel.readString();
        if (localObject != null) {
          localObject = Uri.parse((String)localObject);
        } else {
          localObject = null;
        }
        localGameBadgeEntity = new GameBadgeEntity(1, i, str2, str1, (Uri)localObject);
      }
      else
      {
        localGameBadgeEntity = super.bh(paramParcel);
      }
      return localGameBadgeEntity;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.GameBadgeEntity
 * JD-Core Version:    0.7.0.1
 */