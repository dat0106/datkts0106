package com.sonyericsson.extras.liveware.asf.event;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.KeyEvent;
import com.sonyericsson.extras.liveware.asf.DeviceService;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.ArrayList;
import java.util.List;

public class LivekeyHandler
{
  public static final int KEY_SRC_3_5_MM = 1;
  public static final int KEY_SRC_BLUETOOTH = 2;
  public static final int KEY_SRC_UNDEFINED = -1;
  public static final int KEY_SRC_USB_OTG = 3;
  private static final int LIVEKEY_ACTION_UNDEFINED = -1;
  public static final String PLATFORM_LIVEKEY_INTENT = "com.sonyericsson.hardware.action.APPLICATION_BUTTON";
  
  private List<Intent> actionOnKey(Context paramContext, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    switch (paramInt2)
    {
    case 1: 
      localArrayList.add(DeviceService.getSmartKeyIntent(paramContext, AudioConnectionHandler.getAudioProductId(5), paramInt1, 5, 7, null));
    }
    return localArrayList;
  }
  
  public static LivekeyHandler getNewHandler()
  {
    return new LivekeyHandler();
  }
  
  private boolean isCoconut(Context paramContext)
  {
    boolean bool;
    if ((!Build.MANUFACTURER.equals("Sony Ericsson")) || (!Build.MODEL.startsWith("WT19"))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public List<Intent> onKey(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    List localList = null;
    Dbg.v("Key event");
    if ((!paramIntent.getAction().equals("com.sonyericsson.intent.action.VENDOR_BUTTON")) || (!isCoconut(paramContext))) {
      if (!paramIntent.getAction().equals("com.sonyericsson.hardware.action.APPLICATION_BUTTON"))
      {
        if (paramIntent.getAction().equals("com.sonyericsson.intent.action.VENDOR_BUTTON"))
        {
          KeyEvent localKeyEvent = (KeyEvent)paramIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
          if (localKeyEvent.getAction() != i) {
            i = 0;
          }
          if (localKeyEvent.getRepeatCount() <= 0) {
            localList = actionOnKey(paramContext, i, 1);
          }
        }
      }
      else
      {
        i = paramIntent.getIntExtra("action", -1);
        int j = paramIntent.getIntExtra("source", -1);
        if ((-1 != i) && (-1 != j)) {
          localList = actionOnKey(paramContext, i, j);
        } else {
          Dbg.e("handleKey() failed, missing an action or source");
        }
      }
    }
    return localList;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.event.LivekeyHandler
 * JD-Core Version:    0.7.0.1
 */