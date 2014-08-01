package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity
  implements SafeParcelable, GameRequest
{
  public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
  private final int AQ;
  private final String Oy;
  private final GameEntity Rq;
  private final long SR;
  private final int SY;
  private final byte[] TC;
  private final PlayerEntity TX;
  private final ArrayList<PlayerEntity> TY;
  private final long TZ;
  private final Bundle Ua;
  private final int xJ;
  
  GameRequestEntity(int paramInt1, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, byte[] paramArrayOfByte, String paramString, ArrayList<PlayerEntity> paramArrayList, int paramInt2, long paramLong1, long paramLong2, Bundle paramBundle, int paramInt3)
  {
    this.xJ = paramInt1;
    this.Rq = paramGameEntity;
    this.TX = paramPlayerEntity;
    this.TC = paramArrayOfByte;
    this.Oy = paramString;
    this.TY = paramArrayList;
    this.AQ = paramInt2;
    this.SR = paramLong1;
    this.TZ = paramLong2;
    this.Ua = paramBundle;
    this.SY = paramInt3;
  }
  
  public GameRequestEntity(GameRequest paramGameRequest)
  {
    this.xJ = 2;
    this.Rq = new GameEntity(paramGameRequest.getGame());
    this.TX = new PlayerEntity(paramGameRequest.getSender());
    this.Oy = paramGameRequest.getRequestId();
    this.AQ = paramGameRequest.getType();
    this.SR = paramGameRequest.getCreationTimestamp();
    this.TZ = paramGameRequest.getExpirationTimestamp();
    this.SY = paramGameRequest.getStatus();
    Object localObject = paramGameRequest.getData();
    if (localObject != null)
    {
      this.TC = new byte[localObject.length];
      System.arraycopy(localObject, 0, this.TC, 0, localObject.length);
    }
    else
    {
      this.TC = null;
    }
    List localList = paramGameRequest.getRecipients();
    int i = localList.size();
    this.TY = new ArrayList(i);
    this.Ua = new Bundle();
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      localObject = (Player)((Player)localList.get(j)).freeze();
      String str = ((Player)localObject).getPlayerId();
      this.TY.add((PlayerEntity)localObject);
      this.Ua.putInt(str, paramGameRequest.getRecipientStatus(str));
    }
  }
  
  static int a(GameRequest paramGameRequest)
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = paramGameRequest.getGame();
    arrayOfObject[1] = paramGameRequest.getRecipients();
    arrayOfObject[2] = paramGameRequest.getRequestId();
    arrayOfObject[3] = paramGameRequest.getSender();
    arrayOfObject[4] = b(paramGameRequest);
    arrayOfObject[5] = Integer.valueOf(paramGameRequest.getType());
    arrayOfObject[6] = Long.valueOf(paramGameRequest.getCreationTimestamp());
    arrayOfObject[7] = Long.valueOf(paramGameRequest.getExpirationTimestamp());
    return hl.hashCode(arrayOfObject);
  }
  
  static boolean a(GameRequest paramGameRequest, Object paramObject)
  {
    boolean bool = true;
    if ((paramObject instanceof GameRequest))
    {
      if (paramGameRequest != paramObject)
      {
        GameRequest localGameRequest = (GameRequest)paramObject;
        if ((!hl.equal(localGameRequest.getGame(), paramGameRequest.getGame())) || (!hl.equal(localGameRequest.getRecipients(), paramGameRequest.getRecipients())) || (!hl.equal(localGameRequest.getRequestId(), paramGameRequest.getRequestId())) || (!hl.equal(localGameRequest.getSender(), paramGameRequest.getSender())) || (!Arrays.equals(b(localGameRequest), b(paramGameRequest))) || (!hl.equal(Integer.valueOf(localGameRequest.getType()), Integer.valueOf(paramGameRequest.getType()))) || (!hl.equal(Long.valueOf(localGameRequest.getCreationTimestamp()), Long.valueOf(paramGameRequest.getCreationTimestamp()))) || (!hl.equal(Long.valueOf(localGameRequest.getExpirationTimestamp()), Long.valueOf(paramGameRequest.getExpirationTimestamp())))) {
          bool = false;
        }
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  private static int[] b(GameRequest paramGameRequest)
  {
    List localList = paramGameRequest.getRecipients();
    int i = localList.size();
    int[] arrayOfInt = new int[i];
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return arrayOfInt;
      }
      arrayOfInt[j] = paramGameRequest.getRecipientStatus(((Player)localList.get(j)).getPlayerId());
    }
  }
  
  static String c(GameRequest paramGameRequest)
  {
    return hl.e(paramGameRequest).a("Game", paramGameRequest.getGame()).a("Sender", paramGameRequest.getSender()).a("Recipients", paramGameRequest.getRecipients()).a("Data", paramGameRequest.getData()).a("RequestId", paramGameRequest.getRequestId()).a("Type", Integer.valueOf(paramGameRequest.getType())).a("CreationTimestamp", Long.valueOf(paramGameRequest.getCreationTimestamp())).a("ExpirationTimestamp", Long.valueOf(paramGameRequest.getExpirationTimestamp())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public GameRequest freeze()
  {
    return this;
  }
  
  public long getCreationTimestamp()
  {
    return this.SR;
  }
  
  public byte[] getData()
  {
    return this.TC;
  }
  
  public long getExpirationTimestamp()
  {
    return this.TZ;
  }
  
  public Game getGame()
  {
    return this.Rq;
  }
  
  public int getRecipientStatus(String paramString)
  {
    return this.Ua.getInt(paramString, 0);
  }
  
  public List<Player> getRecipients()
  {
    return new ArrayList(this.TY);
  }
  
  public String getRequestId()
  {
    return this.Oy;
  }
  
  public Player getSender()
  {
    return this.TX;
  }
  
  public int getStatus()
  {
    return this.SY;
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
  
  public Bundle iG()
  {
    return this.Ua;
  }
  
  public boolean isConsumed(String paramString)
  {
    int i = 1;
    if (getRecipientStatus(paramString) != i) {
      i = 0;
    }
    return i;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return c(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GameRequestEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.request.GameRequestEntity
 * JD-Core Version:    0.7.0.1
 */