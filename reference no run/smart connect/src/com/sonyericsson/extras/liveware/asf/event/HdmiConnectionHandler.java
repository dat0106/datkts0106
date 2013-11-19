package com.sonyericsson.extras.liveware.asf.event;

import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.asf.DeviceService;
import com.sonyericsson.extras.liveware.ui.FlapActivity;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import java.util.ArrayList;
import java.util.List;

public class HdmiConnectionHandler
  extends ConnectionHandler
{
  public static final String EXTRA_HDMI_PLUGGED_STATE = "state";
  public static final String HDMI_PLUGGED_INTENT = "android.intent.action.HDMI_PLUGGED";
  public static final String PRODUCT_ID = "MHL";
  
  public static HdmiConnectionHandler getNewHandler()
  {
    return new HdmiConnectionHandler();
  }
  
  private List<Intent> handleHdmi(Context paramContext, Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("state", false);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(DeviceService.getDeviceConnectionIntent(paramContext, "MHL", bool, 10, 9, null));
    return localArrayList;
  }
  
  public void disconnect(Context paramContext)
  {
    paramContext.startService(DeviceService.getDeviceConnectionIntent(paramContext, "MHL", false, 10, 9, null));
  }
  
  public List<Intent> onConnectionEvent(Context paramContext, Intent paramIntent)
  {
    return handleHdmi(paramContext, paramIntent);
  }
  
  public List<Intent> onDisconnectionEvent(Context paramContext, Intent paramIntent)
  {
    List localList = handleHdmi(paramContext, paramIntent);
    if (AsfUtils.isWaterproof(paramContext))
    {
      FlapActivity.show(paramContext, localList);
      localList = null;
    }
    return localList;
  }
  
  public void onStartup(Context paramContext, Intent paramIntent)
  {
    paramContext.startService((Intent)handleHdmi(paramContext, paramIntent).get(0));
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.event.HdmiConnectionHandler
 * JD-Core Version:    0.7.0.1
 */