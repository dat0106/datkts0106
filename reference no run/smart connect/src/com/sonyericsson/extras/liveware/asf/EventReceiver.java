package com.sonyericsson.extras.liveware.asf;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class EventReceiver
  extends BroadcastReceiver
{
  private static Runnable sEventReorderingCallback = null;
  private static Handler sEventReorderingHandler = null;
  
  public static void checkAlreadyConnected(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("SERVICE_ACTION");
    localIntent.putExtra("SERVICE_COMMAND", "ALREADY_CONNECTED");
    localIntent.setComponent(new ComponentName(paramContext, EventHandler.class));
    paramContext.startService(localIntent);
  }
  
  private void dispatchIntent(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (Dbg.d()) {
      Dbg.d("EventReceiver.dispatchIntent: " + (String)localObject);
    }
    localObject = new Intent(paramIntent);
    ((Intent)localObject).setComponent(new ComponentName(paramContext, EventHandler.class));
    paramContext.startService((Intent)localObject);
  }
  
  private void dispatchIntentsFromReorderer(EventReorderer paramEventReorderer, Context paramContext)
  {
    for (;;)
    {
      Intent localIntent = paramEventReorderer.getNextIntent();
      if (localIntent == null) {
        break;
      }
      dispatchIntent(paramContext, localIntent);
    }
  }
  
  private Runnable getEventReorderingCallback(EventReorderer paramEventReorderer, Context paramContext)
  {
    if (sEventReorderingCallback == null) {
      sEventReorderingCallback = new EventReorderingCallback(paramEventReorderer, paramContext);
    }
    return sEventReorderingCallback;
  }
  
  private Handler getEventReorderingHandler()
  {
    if (sEventReorderingHandler == null) {
      sEventReorderingHandler = new Handler(Looper.getMainLooper());
    }
    return sEventReorderingHandler;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (Dbg.d()) {
        Dbg.d("EventReceiver: " + paramIntent.getAction());
      }
      Object localObject = EventReorderer.getInstance();
      if (((EventReorderer)localObject).pushIntent(paramIntent))
      {
        dispatchIntentsFromReorderer((EventReorderer)localObject, paramContext);
        long l = ((EventReorderer)localObject).getWaitTime();
        if (l != -1L)
        {
          Handler localHandler = getEventReorderingHandler();
          localObject = getEventReorderingCallback((EventReorderer)localObject, paramContext);
          localHandler.removeCallbacks((Runnable)localObject);
          localHandler.postDelayed((Runnable)localObject, l);
        }
      }
      else
      {
        dispatchIntent(paramContext, paramIntent);
      }
    }
  }
  
  private class EventReorderingCallback
    implements Runnable
  {
    private final Context ctx;
    private final EventReorderer er;
    
    public EventReorderingCallback(EventReorderer paramEventReorderer, Context paramContext)
    {
      this.er = paramEventReorderer;
      this.ctx = paramContext.getApplicationContext();
    }
    
    public void run()
    {
      EventReceiver.this.dispatchIntentsFromReorderer(this.er, this.ctx);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.EventReceiver
 * JD-Core Version:    0.7.0.1
 */