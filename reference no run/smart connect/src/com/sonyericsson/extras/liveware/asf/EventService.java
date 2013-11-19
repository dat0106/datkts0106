package com.sonyericsson.extras.liveware.asf;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class EventService
  extends Service
{
  EventReceiver mEventReceiver;
  
  private void doRegisterReceiver()
  {
    Dbg.d("EventService.doRegisterReceiver");
    this.mEventReceiver = new EventReceiver();
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
    registerReceiver(this.mEventReceiver, localIntentFilter);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    Dbg.d("EventService.onCreate");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mEventReceiver != null) {
      unregisterReceiver(this.mEventReceiver);
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    doRegisterReceiver();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Dbg.d("EventService.onStartCommand");
    doRegisterReceiver();
    return 1;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.EventService
 * JD-Core Version:    0.7.0.1
 */