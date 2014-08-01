package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;

public class aw
  extends c
{
  private final a.d<Status> yO;
  
  public aw(a.d<Status> paramd)
  {
    this.yO = paramd;
  }
  
  public void o(Status paramStatus)
    throws RemoteException
  {
    this.yO.a(paramStatus);
  }
  
  public void onSuccess()
    throws RemoteException
  {
    this.yO.a(Status.Ek);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.aw
 * JD-Core Version:    0.7.0.1
 */