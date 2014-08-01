package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.List;

public final class bl
{
  private final bu kz;
  private final Object lq = new Object();
  private final Context mContext;
  private final dt nc;
  private final bn nd;
  private boolean ne = false;
  private bq nf;
  
  public bl(Context paramContext, dt paramdt, bu parambu, bn parambn)
  {
    this.mContext = paramContext;
    this.nc = paramdt;
    this.kz = parambu;
    this.nd = parambn;
  }
  
  public br a(long paramLong1, long paramLong2)
  {
    ev.z("Starting mediation.");
    Iterator localIterator1 = this.nd.np.iterator();
    while (localIterator1.hasNext())
    {
      bm localbm = (bm)localIterator1.next();
      ev.B("Trying mediation network: " + localbm.nj);
      Iterator localIterator2 = localbm.nk.iterator();
      while (localIterator2.hasNext())
      {
        localObject3 = (String)localIterator2.next();
        synchronized (this.lq)
        {
          if (this.ne)
          {
            localObject3 = new br(-1);
          }
          else
          {
            this.nf = new bq(this.mContext, (String)localObject3, this.kz, this.nd, localbm, this.nc.pV, this.nc.kR, this.nc.kO);
            localObject3 = this.nf.b(paramLong1, paramLong2);
            if (((br)localObject3).nJ == 0) {
              ev.z("Adapter succeeded.");
            }
          }
        }
        if (((br)localObject3).nL != null) {
          eu.ss.post(new Runnable()
          {
            public void run()
            {
              try
              {
                this.ng.nL.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                for (;;)
                {
                  ev.c("Could not destroy mediation adapter.", localRemoteException);
                }
              }
            }
          });
        }
      }
    }
    Object localObject3 = new br(1);
    return localObject3;
  }
  
  public void cancel()
  {
    synchronized (this.lq)
    {
      this.ne = true;
      if (this.nf != null) {
        this.nf.cancel();
      }
      return;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bl
 * JD-Core Version:    0.7.0.1
 */