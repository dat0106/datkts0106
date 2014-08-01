package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.model.internal.e;

public final class IndoorLevel
{
  private final e aaG;
  
  public IndoorLevel(e parame)
  {
    this.aaG = ((e)hn.f(parame));
  }
  
  public void activate()
  {
    try
    {
      this.aaG.activate();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (!(paramObject instanceof IndoorLevel)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        bool = this.aaG.a(((IndoorLevel)paramObject).aaG);
        bool = bool;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }
  
  public String getName()
  {
    try
    {
      String str = this.aaG.getName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public String getShortName()
  {
    try
    {
      String str = this.aaG.getShortName();
      return str;
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
      int i = this.aaG.hashCodeRemote();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.IndoorLevel
 * JD-Core Version:    0.7.0.1
 */