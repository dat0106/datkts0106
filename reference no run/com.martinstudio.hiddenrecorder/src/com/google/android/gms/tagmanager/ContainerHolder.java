package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;

public abstract interface ContainerHolder
  extends Releasable, Result
{
  public abstract Container getContainer();
  
  public abstract void refresh();
  
  public abstract void setContainerAvailableListener(ContainerAvailableListener paramContainerAvailableListener);
  
  public static abstract interface ContainerAvailableListener
  {
    public abstract void onContainerAvailable(ContainerHolder paramContainerHolder, String paramString);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ContainerHolder
 * JD-Core Version:    0.7.0.1
 */