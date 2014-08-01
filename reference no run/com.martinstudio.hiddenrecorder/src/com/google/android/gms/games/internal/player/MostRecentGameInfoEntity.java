package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public final class MostRecentGameInfoEntity
  implements SafeParcelable, MostRecentGameInfo
{
  public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
  private final String RF;
  private final String RG;
  private final long RH;
  private final Uri RI;
  private final Uri RJ;
  private final Uri RK;
  private final int xJ;
  
  MostRecentGameInfoEntity(int paramInt, String paramString1, String paramString2, long paramLong, Uri paramUri1, Uri paramUri2, Uri paramUri3)
  {
    this.xJ = paramInt;
    this.RF = paramString1;
    this.RG = paramString2;
    this.RH = paramLong;
    this.RI = paramUri1;
    this.RJ = paramUri2;
    this.RK = paramUri3;
  }
  
  public MostRecentGameInfoEntity(MostRecentGameInfo paramMostRecentGameInfo)
  {
    this.xJ = 2;
    this.RF = paramMostRecentGameInfo.ik();
    this.RG = paramMostRecentGameInfo.il();
    this.RH = paramMostRecentGameInfo.im();
    this.RI = paramMostRecentGameInfo.in();
    this.RJ = paramMostRecentGameInfo.io();
    this.RK = paramMostRecentGameInfo.ip();
  }
  
  static int a(MostRecentGameInfo paramMostRecentGameInfo)
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = paramMostRecentGameInfo.ik();
    arrayOfObject[1] = paramMostRecentGameInfo.il();
    arrayOfObject[2] = Long.valueOf(paramMostRecentGameInfo.im());
    arrayOfObject[3] = paramMostRecentGameInfo.in();
    arrayOfObject[4] = paramMostRecentGameInfo.io();
    arrayOfObject[5] = paramMostRecentGameInfo.ip();
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(MostRecentGameInfo paramMostRecentGameInfo, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof MostRecentGameInfo))
    {
      if (paramMostRecentGameInfo != paramObject)
      {
        MostRecentGameInfo localMostRecentGameInfo = (MostRecentGameInfo)paramObject;
        if ((!hl.equal(localMostRecentGameInfo.ik(), paramMostRecentGameInfo.ik())) || (!hl.equal(localMostRecentGameInfo.il(), paramMostRecentGameInfo.il())) || (!hl.equal(Long.valueOf(localMostRecentGameInfo.im()), Long.valueOf(paramMostRecentGameInfo.im()))) || (!hl.equal(localMostRecentGameInfo.in(), paramMostRecentGameInfo.in())) || (!hl.equal(localMostRecentGameInfo.io(), paramMostRecentGameInfo.io())) || (!hl.equal(localMostRecentGameInfo.ip(), paramMostRecentGameInfo.ip()))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  static String b(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return hl.e(paramMostRecentGameInfo).a("GameId", paramMostRecentGameInfo.ik()).a("GameName", paramMostRecentGameInfo.il()).a("ActivityTimestampMillis", Long.valueOf(paramMostRecentGameInfo.im())).a("GameIconUri", paramMostRecentGameInfo.in()).a("GameHiResUri", paramMostRecentGameInfo.io()).a("GameFeaturedUri", paramMostRecentGameInfo.ip()).toString();
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
  
  public int hashCode()
  {
    return a(this);
  }
  
  public String ik()
  {
    return this.RF;
  }
  
  public String il()
  {
    return this.RG;
  }
  
  public long im()
  {
    return this.RH;
  }
  
  public Uri in()
  {
    return this.RI;
  }
  
  public Uri io()
  {
    return this.RJ;
  }
  
  public Uri ip()
  {
    return this.RK;
  }
  
  public MostRecentGameInfo iq()
  {
    return this;
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
    MostRecentGameInfoEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
 * JD-Core Version:    0.7.0.1
 */