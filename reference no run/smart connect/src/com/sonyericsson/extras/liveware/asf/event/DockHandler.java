package com.sonyericsson.extras.liveware.asf.event;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.sonyericsson.extras.liveware.asf.DeviceService;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DockHandler
  extends ConnectionHandler
{
  private static final String DOCK_ID = "Charging Dock";
  private static boolean sRecentlyConnected = false;
  
  private List<Intent> createOutIntent(Context paramContext, boolean paramBoolean)
  {
    Dbg.d("Dock event");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(DeviceService.getDeviceConnectionIntent(paramContext, "Charging Dock", paramBoolean, 14, 8, null));
    return localArrayList;
  }
  
  public static DockHandler getNewHandler()
  {
    return new DockHandler();
  }
  
  public static boolean isChargingDockConnected(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    if (paramIntent == null) {
      paramIntent = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.DOCK_EVENT"));
    }
    if ((paramIntent != null) && (paramIntent.getIntExtra("android.intent.extra.DOCK_STATE", 0) != 0)) {
      bool = true;
    }
    return bool;
  }
  
  private static void startRecentlyConnectedTask()
  {
    sRecentlyConnected = true;
    TimerTask local1 = new TimerTask()
    {
      public void run()
      {
        DockHandler.sRecentlyConnected = false;
      }
    };
    new Timer().schedule(local1, 1000L);
  }
  
  public static boolean wasChargingDockConnected(Context paramContext, Object paramObject)
  {
    return sRecentlyConnected;
  }
  
  public void disconnect(Context paramContext)
  {
    onDisconnectionEvent(paramContext, null);
  }
  
  public List<Intent> onConnectionEvent(Context paramContext, Intent paramIntent)
  {
    return createOutIntent(paramContext, true);
  }
  
  public List<Intent> onDisconnectionEvent(Context paramContext, Intent paramIntent)
  {
    startRecentlyConnectedTask();
    return createOutIntent(paramContext, false);
  }
  
  public void onStartup(Context paramContext, Intent paramIntent)
  {
    paramContext.startService((Intent)createOutIntent(paramContext, isChargingDockConnected(paramContext, paramIntent)).get(0));
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.event.DockHandler
 * JD-Core Version:    0.7.0.1
 */