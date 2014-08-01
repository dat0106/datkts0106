package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.model.internal.d;
import com.google.android.gms.maps.model.internal.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class IndoorBuilding
{
  private final d aaF;
  
  public IndoorBuilding(d paramd)
  {
    this.aaF = ((d)hn.f(paramd));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (!(paramObject instanceof IndoorBuilding)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        bool = this.aaF.b(((IndoorBuilding)paramObject).aaF);
        bool = bool;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }
  
  public int getActiveLevelIndex()
  {
    try
    {
      int i = this.aaF.getActiveLevelIndex();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public int getDefaultLevelIndex()
  {
    try
    {
      int i = this.aaF.getActiveLevelIndex();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public List<IndoorLevel> getLevels()
  {
    try
    {
      Object localObject = this.aaF.getLevels();
      ArrayList localArrayList = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(new IndoorLevel(e.a.bb((IBinder)((Iterator)localObject).next())));
      }
      return localRemoteException;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = this.aaF.hashCodeRemote();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isUnderground()
  {
    try
    {
      boolean bool = this.aaF.isUnderground();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.IndoorBuilding
 * JD-Core Version:    0.7.0.1
 */