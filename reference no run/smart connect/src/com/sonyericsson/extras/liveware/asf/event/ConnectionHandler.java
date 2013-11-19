package com.sonyericsson.extras.liveware.asf.event;

import android.content.Context;
import android.content.Intent;
import java.util.List;

public abstract class ConnectionHandler
{
  public abstract List<Intent> onConnectionEvent(Context paramContext, Intent paramIntent);
  
  public abstract List<Intent> onDisconnectionEvent(Context paramContext, Intent paramIntent);
  
  public abstract void onStartup(Context paramContext, Intent paramIntent);
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.event.ConnectionHandler
 * JD-Core Version:    0.7.0.1
 */