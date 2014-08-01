package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class eo
{
  private static final ThreadFactory se = new ThreadFactory()
  {
    private final AtomicInteger sh = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      return new Thread(paramAnonymousRunnable, "AdWorker #" + this.sh.getAndIncrement());
    }
  };
  private static final ThreadPoolExecutor sf = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), se);
  
  public static void execute(Runnable paramRunnable)
  {
    try
    {
      sf.execute(new Runnable()
      {
        public void run()
        {
          Process.setThreadPriority(10);
          eo.this.run();
        }
      });
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      for (;;)
      {
        ev.c("Too many background threads already running. Aborting task.  Current pool size: " + getPoolSize(), localRejectedExecutionException);
      }
    }
  }
  
  public static int getPoolSize()
  {
    return sf.getPoolSize();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.eo
 * JD-Core Version:    0.7.0.1
 */