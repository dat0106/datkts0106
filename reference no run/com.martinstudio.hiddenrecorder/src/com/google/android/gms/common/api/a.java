package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class a
{
  static void a(Result paramResult)
  {
    if ((paramResult instanceof Releasable)) {}
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.w("GoogleApi", "Unable to release " + paramResult, localRuntimeException);
      }
    }
  }
  
  public static class c<R extends Result>
    extends Handler
  {
    public c()
    {
      this(Looper.getMainLooper());
    }
    
    public c(Looper paramLooper)
    {
      super();
    }
    
    public void a(ResultCallback<R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
    
    public void a(a.a<R> parama, long paramLong)
    {
      sendMessageDelayed(obtainMessage(2, parama), paramLong);
    }
    
    protected void b(ResultCallback<R> paramResultCallback, R paramR)
    {
      try
      {
        paramResultCallback.onResult(paramR);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        a.a(paramR);
        throw localRuntimeException;
      }
    }
    
    public void eC()
    {
      removeMessages(2);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.wtf("GoogleApi", "Don't know how to handle this message.");
        break;
      case 1: 
        Pair localPair = (Pair)paramMessage.obj;
        b((ResultCallback)localPair.first, (Result)localPair.second);
        break;
      case 2: 
        a.a.a((a.a)paramMessage.obj);
      }
    }
  }
  
  public static abstract class a<R extends Result>
    implements PendingResult<R>, a.d<R>
  {
    private final Object Dm = new Object();
    private a.c<R> Dn;
    private final ArrayList<PendingResult.a> Do = new ArrayList();
    private ResultCallback<R> Dp;
    private volatile R Dq;
    private volatile boolean Dr;
    private boolean Ds;
    private boolean Dt;
    private hh Du;
    private final CountDownLatch kI = new CountDownLatch(1);
    
    a() {}
    
    public a(Looper paramLooper)
    {
      this.Dn = new a.c(paramLooper);
    }
    
    public a(a.c<R> paramc)
    {
      this.Dn = paramc;
    }
    
    private void c(R paramR)
    {
      this.Dq = paramR;
      this.Du = null;
      this.kI.countDown();
      Status localStatus = this.Dq.getStatus();
      if (this.Dp != null)
      {
        this.Dn.eC();
        if (!this.Ds) {
          this.Dn.a(this.Dp, ex());
        }
      }
      Iterator localIterator = this.Do.iterator();
      for (;;)
      {
        if (!localIterator.hasNext())
        {
          this.Do.clear();
          return;
        }
        ((PendingResult.a)localIterator.next()).n(localStatus);
      }
    }
    
    private void eA()
    {
      synchronized (this.Dm)
      {
        if (!isReady())
        {
          b(c(Status.En));
          this.Dt = true;
        }
        return;
      }
    }
    
    private R ex()
    {
      for (;;)
      {
        synchronized (this.Dm)
        {
          if (!this.Dr)
          {
            boolean bool = true;
            hn.a(bool, "Result has already been consumed.");
            hn.a(isReady(), "Result is not ready.");
            Result localResult = this.Dq;
            ey();
            return localResult;
          }
        }
        int i = 0;
      }
    }
    
    private void ez()
    {
      synchronized (this.Dm)
      {
        if (!isReady())
        {
          b(c(Status.El));
          this.Dt = true;
        }
        return;
      }
    }
    
    public final void a(PendingResult.a parama)
    {
      boolean bool;
      if (!this.Dr) {
        bool = true;
      }
      for (;;)
      {
        hn.a(bool, "Result has already been consumed.");
        int i;
        synchronized (this.Dm)
        {
          if (isReady())
          {
            parama.n(this.Dq.getStatus());
            return;
          }
          this.Do.add(parama);
        }
      }
    }
    
    protected void a(a.c<R> paramc)
    {
      this.Dn = paramc;
    }
    
    protected final void a(hh paramhh)
    {
      synchronized (this.Dm)
      {
        this.Du = paramhh;
        return;
      }
    }
    
    public final R await()
    {
      boolean bool1 = true;
      boolean bool2;
      if (Looper.myLooper() != Looper.getMainLooper()) {
        bool2 = bool1;
      }
      for (;;)
      {
        hn.a(bool2, "await must not be called on the UI thread");
        if (!this.Dr) {
          hn.a(bool1, "Result has already been consumed");
        }
        try
        {
          this.kI.await();
          hn.a(isReady(), "Result is not ready.");
          return ex();
          bool2 = false;
          continue;
          bool1 = false;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ez();
          }
        }
      }
    }
    
    public final R await(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool2 = true;
      boolean bool1;
      if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
        bool1 = bool2;
      }
      for (;;)
      {
        hn.a(bool1, "await must not be called on the UI thread when time is greater than zero.");
        if (!this.Dr) {
          hn.a(bool2, "Result has already been consumed.");
        }
        try
        {
          if (!this.kI.await(paramLong, paramTimeUnit)) {
            eA();
          }
          hn.a(isReady(), "Result is not ready.");
          return ex();
          bool1 = false;
          continue;
          bool2 = false;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ez();
          }
        }
      }
    }
    
    public final void b(R paramR)
    {
      boolean bool2 = true;
      for (;;)
      {
        synchronized (this.Dm)
        {
          if ((this.Dt) || (this.Ds))
          {
            a.a(paramR);
            break;
          }
          if (!isReady())
          {
            boolean bool1 = bool2;
            hn.a(bool1, "Results have already been set");
            if (this.Dr) {
              break label83;
            }
            hn.a(bool2, "Result has already been consumed");
            c(paramR);
          }
        }
        int i = 0;
        continue;
        label83:
        bool2 = false;
      }
    }
    
    protected abstract R c(Status paramStatus);
    
    public void cancel()
    {
      synchronized (this.Dm)
      {
        if ((!this.Ds) && (this.Dr)) {
          return;
        }
        hh localhh = this.Du;
        if (localhh == null) {}
      }
      try
      {
        this.Du.cancel();
        label44:
        a.a(this.Dq);
        this.Dp = null;
        this.Ds = true;
        c(c(Status.Eo));
        return;
        localObject2 = finally;
        throw localObject2;
      }
      catch (RemoteException localRemoteException)
      {
        break label44;
      }
    }
    
    protected void ey()
    {
      this.Dr = true;
      this.Dq = null;
      this.Dp = null;
    }
    
    public boolean isCanceled()
    {
      synchronized (this.Dm)
      {
        boolean bool = this.Ds;
        return bool;
      }
    }
    
    public final boolean isReady()
    {
      boolean bool;
      if (this.kI.getCount() != 0L) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public final void setResultCallback(ResultCallback<R> paramResultCallback)
    {
      if (!this.Dr) {}
      int i;
      for (boolean bool = true;; i = 0)
      {
        hn.a(bool, "Result has already been consumed.");
        synchronized (this.Dm)
        {
          if (!isCanceled()) {
            if (isReady()) {
              this.Dn.a(paramResultCallback, ex());
            }
          }
        }
      }
    }
    
    public final void setResultCallback(ResultCallback<R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
    {
      if (!this.Dr) {}
      int i;
      for (boolean bool = true;; i = 0)
      {
        hn.a(bool, "Result has already been consumed.");
        synchronized (this.Dm)
        {
          if (!isCanceled()) {
            if (isReady()) {
              this.Dn.a(paramResultCallback, ex());
            }
          }
        }
      }
    }
  }
  
  public static abstract class b<R extends Result, A extends Api.a>
    extends a.a<R>
    implements c.c<A>
  {
    private final Api.c<A> Dk;
    private c.a Dv;
    
    protected b(Api.c<A> paramc)
    {
      this.Dk = ((Api.c)hn.f(paramc));
    }
    
    private void a(RemoteException paramRemoteException)
    {
      m(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }
    
    protected abstract void a(A paramA)
      throws RemoteException;
    
    public void a(c.a parama)
    {
      this.Dv = parama;
    }
    
    public final void b(A paramA)
      throws DeadObjectException
    {
      a(new a.c(paramA.getLooper()));
      try
      {
        a(paramA);
        return;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        a(localDeadObjectException);
        throw localDeadObjectException;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          a(localRemoteException);
        }
      }
    }
    
    public int eB()
    {
      return 0;
    }
    
    public final Api.c<A> ew()
    {
      return this.Dk;
    }
    
    protected void ey()
    {
      super.ey();
      if (this.Dv != null)
      {
        this.Dv.b(this);
        this.Dv = null;
      }
    }
    
    public final void m(Status paramStatus)
    {
      boolean bool;
      if (paramStatus.isSuccess()) {
        bool = false;
      } else {
        bool = true;
      }
      hn.b(bool, "Failed result must not be success");
      b(c(paramStatus));
    }
  }
  
  public static abstract interface d<R>
  {
    public abstract void a(R paramR);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.a
 * JD-Core Version:    0.7.0.1
 */