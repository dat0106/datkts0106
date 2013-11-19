package com.sonyericsson.extras.liveware.actions.ttssms;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import com.sonyericsson.extras.liveware.tts.TtsManager;
import com.sonyericsson.extras.liveware.tts.TtsManagerListener;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.text.DateFormat;
import java.util.Date;

public class IncommingSmsService
  extends Service
  implements TtsManagerListener
{
  private static final Uri SMS_CONTENT_URI = Uri.parse("content://sms");
  private static final Uri SMS_INBOX_CONTENT_URI = Uri.withAppendedPath(SMS_CONTENT_URI, "inbox");
  private static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";
  private Handler mBgHandler;
  private Looper mBgLooper;
  private Handler mFgHandler = new Handler();
  private boolean mInitializingManager;
  private String mTextToSpeak;
  private TtsManager mTtsManager;
  
  private String getSmsText(Context paramContext)
  {
    String str = null;
    Object localObject2 = paramContext.getContentResolver();
    Uri localUri = SMS_INBOX_CONTENT_URI;
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "_id";
    arrayOfString[1] = "thread_id";
    arrayOfString[2] = "address";
    arrayOfString[3] = "person";
    arrayOfString[4] = "date";
    arrayOfString[5] = "body";
    localObject2 = ((ContentResolver)localObject2).query(localUri, arrayOfString, null, null, "date DESC");
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        if (((Cursor)localObject2).getCount() <= 0) {
          break label131;
        }
        ((Cursor)localObject2).moveToFirst();
        str = ((Cursor)localObject2).getString(5);
        str = str;
      }
      catch (SQLException localSQLException)
      {
        Dbg.e("Failed to read sms");
        ((Cursor)localObject2).close();
        continue;
      }
      finally
      {
        ((Cursor)localObject2).close();
      }
      return str;
      label131:
      ((Cursor)localObject2).close();
    }
  }
  
  private void handleReceivedSms()
  {
    String str2 = getString(2131099856) + ". ";
    String str1 = DateFormat.getTimeInstance(3).format(new Date());
    str1 = new StringBuilder(String.valueOf(str2)).append(str1).append(". ").toString() + getSmsText(this);
    Dbg.d("Will now speak: \"" + str1 + "\"");
    this.mFgHandler.post(new ReadTextRunner(str1));
  }
  
  private void newTextFromDatabase(String paramString)
  {
    if (paramString.equals(this.mTextToSpeak))
    {
      Dbg.e("Already reading text identical to text from newTextFromDatabase");
    }
    else if (!this.mInitializingManager)
    {
      this.mTextToSpeak = paramString;
      startTtsManager(this.mTextToSpeak);
    }
    else
    {
      Dbg.e("Speak SMS ignored, still initializing");
    }
  }
  
  private void startTtsManager(String paramString)
  {
    stopTtsManager();
    this.mTtsManager = new TtsManager(this, this, paramString);
    this.mInitializingManager = true;
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
    Dbg.d("IncommingSmsService: onCreate");
    HandlerThread localHandlerThread = new HandlerThread("ExperienceService Bg", 10);
    localHandlerThread.start();
    this.mBgLooper = localHandlerThread.getLooper();
    this.mBgHandler = new Handler(this.mBgLooper);
  }
  
  public void onDestroy()
  {
    Dbg.d("IncommingSmsService: onDestroy");
    this.mBgLooper.quit();
  }
  
  public void onInitCompleted(boolean paramBoolean)
  {
    this.mInitializingManager = false;
    if (!paramBoolean) {
      stopSelf();
    }
  }
  
  public void onSpeechCompleted()
  {
    stopSelf();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null) {
      if (!"android.provider.Telephony.SMS_RECEIVED".equals(paramIntent.getAction()))
      {
        stopSelf();
      }
      else if (!TtsSmsUtils.isSpeakSmsEnabled(this))
      {
        Dbg.e("Speak sms is not enabled, ignore");
        stopSelf();
      }
      else
      {
        this.mBgHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            IncommingSmsService.this.handleReceivedSms();
          }
        }, 4000L);
      }
    }
    return 1;
  }
  
  private class ReadTextRunner
    implements Runnable
  {
    protected String mText;
    
    ReadTextRunner(String paramString)
    {
      this.mText = paramString;
    }
    
    public void run()
    {
      IncommingSmsService.this.newTextFromDatabase(this.mText);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.ttssms.IncommingSmsService
 * JD-Core Version:    0.7.0.1
 */