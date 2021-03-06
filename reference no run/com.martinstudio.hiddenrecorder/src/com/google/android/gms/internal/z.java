package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

public final class z
{
  private final a ld;
  private final Runnable le;
  private aj lf;
  private boolean lg = false;
  private boolean lh = false;
  private long li = 0L;
  
  public z(v paramv)
  {
    this(paramv, new a(eu.ss));
  }
  
  z(final v paramv, a parama)
  {
    this.ld = parama;
    this.le = new Runnable()
    {
      private final WeakReference<v> lj = new WeakReference(paramv);
      
      public void run()
      {
        z.a(z.this, false);
        v localv = (v)this.lj.get();
        if (localv != null) {
          localv.b(z.a(z.this));
        }
      }
    };
  }
  
  public void a(aj paramaj, long paramLong)
  {
    if (!this.lg)
    {
      this.lf = paramaj;
      this.lg = true;
      this.li = paramLong;
      if (!this.lh)
      {
        ev.B("Scheduling ad refresh " + paramLong + " milliseconds from now.");
        this.ld.postDelayed(this.le, paramLong);
      }
    }
    else
    {
      ev.D("An ad refresh is already scheduled.");
    }
  }
  
  public void cancel()
  {
    this.lg = false;
    this.ld.removeCallbacks(this.le);
  }
  
  public void d(aj paramaj)
  {
    a(paramaj, 60000L);
  }
  
  public void pause()
  {
    this.lh = true;
    if (this.lg) {
      this.ld.removeCallbacks(this.le);
    }
  }
  
  public void resume()
  {
    this.lh = false;
    if (this.lg)
    {
      this.lg = false;
      a(this.lf, this.li);
    }
  }
  
  public static class a
  {
    private final Handler mHandler;
    
    public a(Handler paramHandler)
    {
      this.mHandler = paramHandler;
    }
    
    public boolean postDelayed(Runnable paramRunnable, long paramLong)
    {
      return this.mHandler.postDelayed(paramRunnable, paramLong);
    }
    
    public void removeCallbacks(Runnable paramRunnable)
    {
      this.mHandler.removeCallbacks(paramRunnable);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.z
 * JD-Core Version:    0.7.0.1
 */