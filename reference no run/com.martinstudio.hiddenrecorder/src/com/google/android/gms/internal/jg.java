package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.a.a;
import java.util.HashMap;

public class jg
{
  private final jk<jf> VG;
  private ContentProviderClient VH = null;
  private boolean VI = false;
  private HashMap<LocationListener, b> VJ = new HashMap();
  private final Context mContext;
  
  public jg(Context paramContext, jk<jf> paramjk)
  {
    this.mContext = paramContext;
    this.VG = paramjk;
  }
  
  public Location getLastLocation()
  {
    this.VG.ci();
    try
    {
      Location localLocation = ((jf)this.VG.fo()).bo(this.mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void iT()
  {
    if (this.VI) {}
    try
    {
      setMockMode(false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  /* Error */
  public void removeAllListeners()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/google/android/gms/internal/jg:VJ	Ljava/util/HashMap;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 36	com/google/android/gms/internal/jg:VJ	Ljava/util/HashMap;
    //   11: invokevirtual 80	java/util/HashMap:values	()Ljava/util/Collection;
    //   14: invokeinterface 86 1 0
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface 92 1 0
    //   26: ifeq +53 -> 79
    //   29: aload_2
    //   30: invokeinterface 96 1 0
    //   35: checkcast 9	com/google/android/gms/internal/jg$b
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull -20 -> 20
    //   43: aload_0
    //   44: getfield 40	com/google/android/gms/internal/jg:VG	Lcom/google/android/gms/internal/jk;
    //   47: invokeinterface 53 1 0
    //   52: checkcast 55	com/google/android/gms/internal/jf
    //   55: aload_3
    //   56: invokeinterface 99 2 0
    //   61: goto -41 -> 20
    //   64: astore_2
    //   65: aload_1
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    //   69: astore_1
    //   70: new 67	java/lang/IllegalStateException
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 70	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   78: athrow
    //   79: aload_0
    //   80: getfield 36	com/google/android/gms/internal/jg:VJ	Ljava/util/HashMap;
    //   83: invokevirtual 102	java/util/HashMap:clear	()V
    //   86: aload_1
    //   87: monitorexit
    //   88: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	jg
    //   4	62	1	localHashMap	HashMap
    //   69	18	1	localRemoteException	RemoteException
    //   19	11	2	localIterator	java.util.Iterator
    //   64	4	2	localObject	Object
    //   38	18	3	localb	b
    // Exception table:
    //   from	to	target	type
    //   7	67	64	finally
    //   79	88	64	finally
    //   0	7	69	android/os/RemoteException
    //   67	69	69	android/os/RemoteException
  }
  
  public void removeLocationUpdates(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.VG.ci();
    ((jf)this.VG.fo()).a(paramPendingIntent);
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
    throws RemoteException
  {
    this.VG.ci();
    hn.b(paramLocationListener, "Invalid null listener");
    synchronized (this.VJ)
    {
      b localb = (b)this.VJ.remove(paramLocationListener);
      if ((this.VH != null) && (this.VJ.isEmpty()))
      {
        this.VH.release();
        this.VH = null;
      }
      if (localb != null)
      {
        localb.release();
        ((jf)this.VG.fo()).a(localb);
      }
      return;
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.VG.ci();
    ((jf)this.VG.fo()).a(paramLocationRequest, paramPendingIntent);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
    throws RemoteException
  {
    this.VG.ci();
    if (paramLooper == null) {
      hn.b(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
    }
    for (;;)
    {
      synchronized (this.VJ)
      {
        b localb = (b)this.VJ.get(paramLocationListener);
        if (localb == null)
        {
          localb = new b(paramLocationListener, paramLooper);
          this.VJ.put(paramLocationListener, localb);
          ((jf)this.VG.fo()).a(paramLocationRequest, localb, this.mContext.getPackageName());
          return;
        }
      }
      Object localObject2 = localObject1;
    }
  }
  
  public void setMockLocation(Location paramLocation)
    throws RemoteException
  {
    this.VG.ci();
    ((jf)this.VG.fo()).setMockLocation(paramLocation);
  }
  
  public void setMockMode(boolean paramBoolean)
    throws RemoteException
  {
    this.VG.ci();
    ((jf)this.VG.fo()).setMockMode(paramBoolean);
    this.VI = paramBoolean;
  }
  
  private static class a
    extends Handler
  {
    private final LocationListener VK;
    
    public a(LocationListener paramLocationListener)
    {
      this.VK = paramLocationListener;
    }
    
    public a(LocationListener paramLocationListener, Looper paramLooper)
    {
      super();
      this.VK = paramLocationListener;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
        break;
      case 1: 
        Location localLocation = new Location((Location)paramMessage.obj);
        this.VK.onLocationChanged(localLocation);
      }
    }
  }
  
  private static class b
    extends a.a
  {
    private Handler VL;
    
    b(LocationListener paramLocationListener, Looper paramLooper)
    {
      jg.a locala;
      if (paramLooper != null) {
        locala = new jg.a(paramLocationListener, paramLooper);
      } else {
        locala = new jg.a(paramLocationListener);
      }
      this.VL = locala;
    }
    
    public void onLocationChanged(Location paramLocation)
    {
      if (this.VL != null)
      {
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.obj = paramLocation;
        this.VL.sendMessage(localMessage);
      }
      else
      {
        Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
      }
    }
    
    public void release()
    {
      this.VL = null;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jg
 * JD-Core Version:    0.7.0.1
 */