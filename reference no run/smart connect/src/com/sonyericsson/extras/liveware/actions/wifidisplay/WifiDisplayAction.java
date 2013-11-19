package com.sonyericsson.extras.liveware.actions.wifidisplay;

import android.content.Intent;
import com.sonyericsson.extras.liveware.actions.ActionForResultService;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class WifiDisplayAction
  extends ActionForResultService
{
  public static final String ACTION_WIFI_DISPLAY_STATE_CHANGED = "com.sonymobile.tvout.wifidisplay.intent.action.WIFI_DISPLAY_STATE_CHANGED";
  public static final String CONTROL_FROM_SMART_TAGS = "com.sonymobile.tvout.wifidisplay.intent.action.CONTROL_FROM_SMART_TAGS";
  private static final int CONTROL_START = 1;
  private static final int CONTROL_STOP = 2;
  public static final String EXTRA_CONTROL_MODE = "com.sonymobile.tvout.wifidisplay.intent.extra.CONTROL_MODE";
  public static final String EXTRA_DEVICE_MAC_ADDRESS = "com.sonymobile.tvout.wifidisplay.intent.extra.DEVICE_MAC_ADDRESS";
  public static final String EXTRA_DEVICE_NAME = "com.sonymobile.tvout.wifidisplay.intent.extra.DEVICE_NAME";
  public static final String EXTRA_WIFI_DISPLAY_STATE = "com.sonymobile.tvout.wifidisplay.intent.extra.WIFI_DISPLAY_STATE";
  public static final int STATE_DEVICE_CONNECTED = 3;
  public static final int STATE_DEVICE_CONNECTING = 2;
  public static final int STATE_DEVICE_SEARCHING = 1;
  public static final int STATE_DISPLAY_STARTED = 5;
  public static final int STATE_DISPLAY_STARTING = 4;
  public static final int STATE_DISPLAY_STOPPING = 6;
  public static final int STATE_READY = 7;
  public static final int STATE_STANDBY = 0;
  public static final int STATE_UNKNOWN = -1;
  int mState = 0;
  
  private void notifyWifiDisplay(int paramInt)
  {
    if (Dbg.v()) {
      Dbg.v("Wi-Fi Display - Send intent:com.sonymobile.tvout.wifidisplay.intent.action.CONTROL_FROM_SMART_TAGS");
    }
    Intent localIntent = new Intent("com.sonymobile.tvout.wifidisplay.intent.action.CONTROL_FROM_SMART_TAGS");
    localIntent.putExtra("com.sonymobile.tvout.wifidisplay.intent.extra.CONTROL_MODE", paramInt);
    localIntent.addFlags(32);
    sendBroadcast(localIntent);
  }
  
  private void toggleWiFiDisplay()
  {
    Dbg.v("Wi-Fi Display - getWiFiDisplayState()");
    this.mState = 0;
    waitForStateChange("com.sonymobile.tvout.wifidisplay.intent.action.WIFI_DISPLAY_STATE_CHANGED");
  }
  
  protected void disable()
  {
    Dbg.v("Wi-Fi Display - disable()");
    notifyWifiDisplay(2);
    replyAndStop(0);
  }
  
  protected void enable()
  {
    Dbg.v("Wi-Fi Display - enable()");
    notifyWifiDisplay(1);
    replyAndStop(0);
  }
  
  protected void onStateChange(Intent paramIntent)
  {
    if (Dbg.v()) {
      Dbg.v("Wi-Fi Display - onStateChange() #onReceive/in[" + paramIntent + "]");
    }
    if ((paramIntent != null) && ("com.sonymobile.tvout.wifidisplay.intent.action.WIFI_DISPLAY_STATE_CHANGED".equals(paramIntent.getAction())))
    {
      this.mState = paramIntent.getIntExtra("com.sonymobile.tvout.wifidisplay.intent.extra.WIFI_DISPLAY_STATE", -1);
      if (Dbg.v()) {
        Dbg.v("Wi-Fi Display - WFD state[" + this.mState + "]");
      }
      if (this.mState != 5) {
        notifyWifiDisplay(1);
      } else {
        notifyWifiDisplay(2);
      }
    }
    replyAndStop(0);
    stopSelf();
  }
  
  protected void toggle()
  {
    Dbg.v("Wi-Fi Display - toggle()");
    toggleWiFiDisplay();
    replyAndStop(0);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.wifidisplay.WifiDisplayAction
 * JD-Core Version:    0.7.0.1
 */