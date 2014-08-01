package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.internal.hn;

public class x<C extends DriveEvent>
  extends ac.a
{
  private final int In;
  private final DriveEvent.Listener<C> Jk;
  private final a<C> Jl;
  
  public x(Looper paramLooper, int paramInt, DriveEvent.Listener<C> paramListener)
  {
    this.In = paramInt;
    this.Jk = paramListener;
    this.Jl = new a(paramLooper, null);
  }
  
  public void a(OnEventResponse paramOnEventResponse)
    throws RemoteException
  {
    boolean bool;
    if (this.In != paramOnEventResponse.getEventType()) {
      bool = false;
    } else {
      bool = true;
    }
    hn.A(bool);
    switch (paramOnEventResponse.getEventType())
    {
    default: 
      Log.w("EventCallback", "Unexpected event type:" + paramOnEventResponse.getEventType());
      break;
    case 1: 
      this.Jl.a(this.Jk, paramOnEventResponse.gr());
      break;
    case 2: 
      this.Jl.a(this.Jk, paramOnEventResponse.gs());
    }
  }
  
  private static class a<E extends DriveEvent>
    extends Handler
  {
    private a(Looper paramLooper)
    {
      super();
    }
    
    public void a(DriveEvent.Listener<E> paramListener, E paramE)
    {
      sendMessage(obtainMessage(1, new Pair(paramListener, paramE)));
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.wtf("EventCallback", "Don't know how to handle this event");
        break;
      case 1: 
        Pair localPair = (Pair)paramMessage.obj;
        ((DriveEvent.Listener)localPair.first).onEvent((DriveEvent)localPair.second);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.x
 * JD-Core Version:    0.7.0.1
 */