package com.sonyericsson.extras.liveware.actions;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;

public abstract class ActionForResultService
  extends Service
{
  private Runnable mGiveUpStopSelfRunner = new Runnable()
  {
    public void run()
    {
      Dbg.d("Timeout, shut down.");
      ActionForResultService.this.stopSelf();
    }
  };
  private Handler mHandler = new Handler();
  private String mRawSetting = "";
  private Receiver mReceiver = null;
  protected String mUuid;
  
  private void sendReply(int paramInt)
  {
    ActionUtils.sendExecuteReplyIntent(this, this.mUuid, paramInt);
  }
  
  protected abstract void disable();
  
  protected abstract void enable();
  
  protected final String getRawSetting()
  {
    return this.mRawSetting;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mReceiver != null)
    {
      unregisterReceiver(this.mReceiver);
      this.mReceiver = null;
    }
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacks(this.mGiveUpStopSelfRunner);
      this.mHandler = null;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null)
    {
      stopSelf();
    }
    else
    {
      this.mUuid = paramIntent.getStringExtra("id");
      this.mRawSetting = paramIntent.getStringExtra("setting_raw");
      if ((this.mUuid != null) && (this.mUuid.length() != 0) && (this.mRawSetting != null))
      {
        start(paramIntent);
        this.mHandler.postDelayed(this.mGiveUpStopSelfRunner, 10000L);
      }
      else
      {
        stopSelf();
      }
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  protected abstract void onStateChange(Intent paramIntent);
  
  protected void replyAndStop(int paramInt)
  {
    sendReply(paramInt);
    stopSelf();
  }
  
  protected void start(Intent paramIntent)
  {
    String str = getRawSetting();
    if (!str.equalsIgnoreCase("on"))
    {
      if (!str.equalsIgnoreCase("off"))
      {
        if (!str.equalsIgnoreCase("toggle"))
        {
          Dbg.d("Unknown setting: " + str);
          stopSelf();
        }
        else
        {
          toggle();
        }
      }
      else {
        disable();
      }
    }
    else {
      enable();
    }
  }
  
  protected abstract void toggle();
  
  protected void waitForStateChange(String paramString)
  {
    sendReply(2);
    if (this.mReceiver != null) {
      unregisterReceiver(this.mReceiver);
    }
    this.mReceiver = new Receiver(null);
    IntentFilter localIntentFilter = new IntentFilter(paramString);
    registerReceiver(this.mReceiver, localIntentFilter);
  }
  
  private class Receiver
    extends BroadcastReceiver
  {
    private Receiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      ActionForResultService.this.onStateChange(paramIntent);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.ActionForResultService
 * JD-Core Version:    0.7.0.1
 */