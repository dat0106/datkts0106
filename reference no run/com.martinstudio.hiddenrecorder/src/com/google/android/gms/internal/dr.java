package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;

public abstract class dr
  extends en
{
  private final dt nc;
  private final dq.a pR;
  
  public dr(dt paramdt, dq.a parama)
  {
    this.nc = paramdt;
    this.pR = parama;
  }
  
  private static dv a(dx paramdx, dt paramdt)
  {
    dv localdv = null;
    try
    {
      localdv = paramdx.b(paramdt);
      localdv = localdv;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ev.c("Could not fetch ad response from ad request service.", localRemoteException);
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        ev.c("Could not fetch ad response from ad request service due to an Exception.", localNullPointerException);
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        ev.c("Could not fetch ad response from ad request service due to an Exception.", localSecurityException);
      }
    }
    return localdv;
  }
  
  /* Error */
  public final void bc()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 50	com/google/android/gms/internal/dr:bo	()Lcom/google/android/gms/internal/dx;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +27 -> 33
    //   9: new 52	com/google/android/gms/internal/dv
    //   12: dup
    //   13: iconst_0
    //   14: invokespecial 55	com/google/android/gms/internal/dv:<init>	(I)V
    //   17: astore_1
    //   18: aload_0
    //   19: invokevirtual 58	com/google/android/gms/internal/dr:bn	()V
    //   22: aload_0
    //   23: getfield 23	com/google/android/gms/internal/dr:pR	Lcom/google/android/gms/internal/dq$a;
    //   26: aload_1
    //   27: invokeinterface 63 2 0
    //   32: return
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 21	com/google/android/gms/internal/dr:nc	Lcom/google/android/gms/internal/dt;
    //   38: invokestatic 65	com/google/android/gms/internal/dr:a	(Lcom/google/android/gms/internal/dx;Lcom/google/android/gms/internal/dt;)Lcom/google/android/gms/internal/dv;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnonnull -25 -> 18
    //   46: new 52	com/google/android/gms/internal/dv
    //   49: dup
    //   50: iconst_0
    //   51: invokespecial 55	com/google/android/gms/internal/dv:<init>	(I)V
    //   54: astore_1
    //   55: goto -37 -> 18
    //   58: astore_1
    //   59: aload_0
    //   60: invokevirtual 58	com/google/android/gms/internal/dr:bn	()V
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	dr
    //   4	51	1	localObject1	Object
    //   58	6	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	18	58	finally
    //   33	55	58	finally
  }
  
  public abstract void bn();
  
  public abstract dx bo();
  
  public final void onStop()
  {
    bn();
  }
  
  public static final class b
    extends dr
    implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener
  {
    private final Object lq = new Object();
    private final dq.a pR;
    private final ds pS;
    
    public b(Context paramContext, dt paramdt, dq.a parama)
    {
      super(parama);
      this.pR = parama;
      this.pS = new ds(paramContext, this, this, paramdt.kO.sv);
      this.pS.connect();
    }
    
    public void bn()
    {
      synchronized (this.lq)
      {
        if ((this.pS.isConnected()) || (this.pS.isConnecting())) {
          this.pS.disconnect();
        }
        return;
      }
    }
    
    public dx bo()
    {
      synchronized (this.lq)
      {
        try
        {
          localdx1 = this.pS.br();
          localdx1 = localdx1;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          dx localdx1 = null;
        }
      }
      return localdx2;
    }
    
    public void onConnected(Bundle paramBundle)
    {
      start();
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      this.pR.a(new dv(0));
    }
    
    public void onDisconnected()
    {
      ev.z("Disconnected from remote ad request service.");
    }
  }
  
  public static final class a
    extends dr
  {
    private final Context mContext;
    
    public a(Context paramContext, dt paramdt, dq.a parama)
    {
      super(parama);
      this.mContext = paramContext;
    }
    
    public void bn() {}
    
    public dx bo()
    {
      az localaz = new az();
      return dy.a(this.mContext, localaz, new bk(), new ef());
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dr
 * JD-Core Version:    0.7.0.1
 */