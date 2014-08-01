package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class a
  implements ServiceConnection
{
  boolean CN = false;
  private final BlockingQueue<IBinder> CO = new LinkedBlockingQueue();
  
  public IBinder er()
    throws InterruptedException
  {
    if (!this.CN)
    {
      this.CN = true;
      return (IBinder)this.CO.take();
    }
    throw new IllegalStateException();
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.CO.put(paramIBinder);
      label10:
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label10;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.a
 * JD-Core Version:    0.7.0.1
 */