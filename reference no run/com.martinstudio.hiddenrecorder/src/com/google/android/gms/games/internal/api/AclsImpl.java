package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl
  implements Acls
{
  private static Acls.LoadAclResult x(Status paramStatus)
  {
    new Acls.LoadAclResult()
    {
      public Status getStatus()
      {
        return AclsImpl.this;
      }
      
      public void release() {}
    };
  }
  
  private static abstract class UpdateNotifyAclImpl
    extends Games.BaseGamesApiMethodImpl<Status>
  {
    public Status d(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  private static abstract class LoadNotifyAclImpl
    extends Games.BaseGamesApiMethodImpl<Acls.LoadAclResult>
  {
    public Acls.LoadAclResult z(Status paramStatus)
    {
      return AclsImpl.y(paramStatus);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.api.AclsImpl
 * JD-Core Version:    0.7.0.1
 */