package com.sonyericsson.extras.liveware.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.sonyericsson.extras.liveware.utils.ToastMaster;

public class ToastService
  extends IntentService
{
  private static final int DELAY_MILLIS = 100;
  public static final String MSG_EXTRA = "msg_extra";
  public static final String TITLE_EXTRA = "title_extra";
  public static final String TOAST_ACTION = "com.sonyericsson.extras.TOAST_ACTION";
  Handler mHandler;
  
  public ToastService()
  {
    super(ToastService.class.getName());
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.sonyericsson.extras.TOAST_ACTION"))
    {
      final String str2 = paramIntent.getStringExtra("title_extra");
      final String str1 = paramIntent.getStringExtra("msg_extra");
      if (this.mHandler != null) {
        this.mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            ToastMaster.showLWToast(ToastService.this, str2, str1);
          }
        }, 100L);
      }
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if ((Looper.myQueue() != null) && (this.mHandler == null)) {
      this.mHandler = new Handler();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.service.ToastService
 * JD-Core Version:    0.7.0.1
 */