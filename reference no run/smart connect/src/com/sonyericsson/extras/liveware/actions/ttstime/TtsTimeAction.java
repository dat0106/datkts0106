package com.sonyericsson.extras.liveware.actions.ttstime;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.sonyericsson.extras.liveware.tts.TtsManager;
import com.sonyericsson.extras.liveware.tts.TtsManagerListener;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.text.DateFormat;
import java.util.Date;

public class TtsTimeAction
  extends Service
  implements TtsManagerListener
{
  private Handler mHandler;
  private Runnable mRunnable;
  private long mStartedTimestamp;
  private TtsManager mTtsManager;
  private String mUuid;
  
  private void startTtsManager()
  {
    stopTtsManager();
    String str = DateFormat.getTimeInstance(3).format(new Date());
    this.mTtsManager = new TtsManager(this, this, getString(2131099868) + " " + str);
  }
  
  private void stopTtsManager()
  {
    if (this.mTtsManager != null)
    {
      this.mTtsManager.cancel();
      this.mTtsManager = null;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mHandler = new Handler();
  }
  
  public void onDestroy()
  {
    Dbg.e("onDestroy TtsTimeAction current time service");
    super.onDestroy();
  }
  
  public void onInitCompleted(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ActionUtils.sendExecuteReplyIntent(this, this.mUuid, 1);
      stopSelf();
    }
    else
    {
      this.mRunnable = new Runnable()
      {
        public void run()
        {
          ActionUtils.sendExecuteReplyIntent(TtsTimeAction.this, TtsTimeAction.this.mUuid, 0);
        }
      };
      this.mHandler.postDelayed(this.mRunnable, Math.max(9000L - (System.currentTimeMillis() - this.mStartedTimestamp), 0L));
    }
  }
  
  public void onSpeechCompleted()
  {
    this.mHandler.removeCallbacks(this.mRunnable);
    ActionUtils.sendExecuteReplyIntent(this, this.mUuid, 0);
    stopSelf();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramIntent == null)
    {
      Dbg.e("startCommand, null intent");
    }
    else
    {
      this.mUuid = paramIntent.getStringExtra("id");
      if (this.mUuid == null)
      {
        Dbg.e("startCommand, mUuid null");
      }
      else
      {
        startTtsManager();
        i = 1;
      }
    }
    if (i != 0)
    {
      this.mStartedTimestamp = System.currentTimeMillis();
      ActionUtils.sendExecuteReplyIntent(this, this.mUuid, 2);
    }
    else
    {
      ActionUtils.sendExecuteReplyIntent(this, this.mUuid, 1);
      stopSelf();
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.ttstime.TtsTimeAction
 * JD-Core Version:    0.7.0.1
 */