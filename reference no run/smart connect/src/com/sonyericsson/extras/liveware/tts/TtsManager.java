package com.sonyericsson.extras.liveware.tts;

import android.content.Context;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.EngineInfo;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class TtsManager
  implements TextToSpeech.OnUtteranceCompletedListener
{
  private static final String TTS_ACTION_UTTERANCE_ID = "ttsaction_id";
  private static final int TTS_INIT_TIMEOUT_IN_MILLIS = 2000;
  private Context mContext;
  private Runnable mEnginesInitTimer;
  private Handler mHandler;
  private boolean mHasSpeakStarted;
  private Locale mLocale;
  private String mTextToRead;
  private List<TtsEngine> mTtsEngines = new ArrayList();
  private TtsManagerListener mTtsManagerListener;
  
  public TtsManager(Context paramContext, TtsManagerListener paramTtsManagerListener, String paramString)
  {
    this.mContext = paramContext;
    this.mTextToRead = paramString;
    this.mHandler = new Handler();
    this.mTtsManagerListener = paramTtsManagerListener;
    initializeTtsEngines();
  }
  
  private void chooseEngineAndSpeak()
  {
    if (!this.mTtsEngines.isEmpty())
    {
      this.mHandler.removeCallbacks(this.mEnginesInitTimer);
      Object localObject1 = this.mTtsEngines.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((TtsEngine)((Iterator)localObject1).next()).updateLanguageStatus(this.mLocale);
      }
      localObject1 = null;
      Object localObject2 = this.mTtsEngines.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TtsEngine)((Iterator)localObject2).next();
        if (((TtsEngine)localObject3).hasLanguageStatus(2)) {
          localObject1 = localObject3;
        }
      }
      if (localObject1 == null)
      {
        localObject3 = this.mTtsEngines.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (TtsEngine)((Iterator)localObject3).next();
          if (((TtsEngine)localObject2).hasLanguageStatus(1)) {
            localObject1 = localObject2;
          }
        }
      }
      if (localObject1 == null)
      {
        localObject2 = this.mTtsEngines.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TtsEngine)((Iterator)localObject2).next();
          if (((TtsEngine)localObject3).hasLanguageStatus(0)) {
            localObject1 = localObject3;
          }
        }
      }
      if (localObject1 != null) {
        ((TtsEngine)localObject1).setTtsLanguage(this.mContext);
      } else {
        localObject1 = (TtsEngine)this.mTtsEngines.get(0);
      }
      Dbg.d("Choosen TTS engine: " + ((TtsEngine)localObject1).mPackageName);
      speak((TtsEngine)localObject1);
    }
  }
  
  private void initializeTtsEngines()
  {
    this.mLocale = Locale.getDefault();
    this.mHasSpeakStarted = false;
    this.mHandler.removeCallbacks(this.mEnginesInitTimer);
    Object localObject1 = new TtsEngine(this.mContext, null);
    Object localObject2 = ((TtsEngine)localObject1).mTts.getEngines();
    this.mTtsEngines.add(localObject1);
    localObject1 = ((TtsEngine)localObject1).mTts.getDefaultEngine();
    Iterator localIterator = ((List)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (TextToSpeech.EngineInfo)localIterator.next();
      if (!TextUtils.equals(((TextToSpeech.EngineInfo)localObject2).name, (CharSequence)localObject1)) {
        this.mTtsEngines.add(new TtsEngine(this.mContext, ((TextToSpeech.EngineInfo)localObject2).name));
      }
    }
    this.mEnginesInitTimer = new Runnable()
    {
      public void run()
      {
        Dbg.e("Timeout waiting for onInit on all engines, check if we have at least one and speak");
        TtsManager.this.chooseEngineAndSpeak();
      }
    };
    this.mHandler.postDelayed(this.mEnginesInitTimer, 2000L);
  }
  
  private void speak(TtsEngine paramTtsEngine)
  {
    if (!this.mHasSpeakStarted)
    {
      int i = -1;
      int j;
      if (!paramTtsEngine.mInitialized)
      {
        Dbg.e("Called speak on non-initialized engine: " + paramTtsEngine.mPackageName);
      }
      else
      {
        this.mHasSpeakStarted = true;
        TextToSpeech localTextToSpeech = paramTtsEngine.mTts;
        localTextToSpeech.setOnUtteranceCompletedListener(this);
        HashMap localHashMap = new HashMap();
        localHashMap.put("utteranceId", "ttsaction_id");
        j = localTextToSpeech.speak(this.mTextToRead, 1, localHashMap);
        if (j == 0) {
          Dbg.d("Called speak SUCCESS: " + paramTtsEngine.mPackageName);
        } else {
          Dbg.e("Called speak ERROR: " + paramTtsEngine.mPackageName);
        }
      }
      if (this.mTtsManagerListener == null)
      {
        Dbg.e("mTtsManagerListener null in speak()");
      }
      else
      {
        boolean bool = false;
        if (j != 0) {
          stopEngines();
        } else {
          bool = true;
        }
        Dbg.d("calling onInitCompleted: " + bool);
        this.mTtsManagerListener.onInitCompleted(bool);
      }
    }
  }
  
  private void stopEngines()
  {
    Iterator localIterator = this.mTtsEngines.iterator();
    while (localIterator.hasNext()) {
      ((TtsEngine)localIterator.next()).close();
    }
    this.mTtsEngines.clear();
  }
  
  public void cancel()
  {
    this.mTtsManagerListener = null;
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        TtsManager.this.stopEngines();
      }
    });
  }
  
  public void onUtteranceCompleted(String paramString)
  {
    Dbg.d("onUtteranceCompleted: " + paramString);
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        TtsManager.this.stopEngines();
        if (TtsManager.this.mTtsManagerListener == null)
        {
          Dbg.e("mTtsManagerListener null in onUtteranceCompleted");
        }
        else
        {
          TtsManager.this.mTtsManagerListener.onSpeechCompleted();
          Dbg.d("calling onSpeechCompleted");
        }
      }
    });
  }
  
  private class TtsEngine
    implements TextToSpeech.OnInitListener
  {
    Context mContext;
    boolean mInitialized;
    boolean mKillWhenInitialized;
    int mLanguageStatus;
    String mPackageName;
    TextToSpeech mTts = null;
    
    public TtsEngine(Context paramContext, String paramString)
    {
      this.mPackageName = paramString;
      this.mInitialized = false;
      this.mKillWhenInitialized = false;
      this.mContext = paramContext;
      this.mLanguageStatus = -1;
      this.mTts = new TextToSpeech(this.mContext, this, paramString);
    }
    
    private boolean isAllInitialized()
    {
      boolean bool = true;
      Iterator localIterator = TtsManager.this.mTtsEngines.iterator();
      while (localIterator.hasNext())
      {
        TtsEngine localTtsEngine = (TtsEngine)localIterator.next();
        Dbg.d(localTtsEngine.mPackageName + " " + localTtsEngine.mInitialized);
        if (!localTtsEngine.mInitialized) {
          bool = false;
        }
      }
      Dbg.d("all TTS engines initialized " + bool);
      return bool;
    }
    
    public void close()
    {
      if (!this.mInitialized)
      {
        this.mKillWhenInitialized = true;
      }
      else
      {
        this.mTts.stop();
        this.mTts.shutdown();
      }
    }
    
    public boolean hasLanguageStatus(int paramInt)
    {
      boolean bool;
      if (paramInt != this.mLanguageStatus) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public void onInit(int paramInt)
    {
      if (!this.mKillWhenInitialized)
      {
        this.mInitialized = true;
        Dbg.d("TtsEngine " + this.mPackageName + " initialized: " + paramInt);
        if (paramInt == 0) {
          this.mInitialized = true;
        }
        TtsManager.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            if (TtsManager.TtsEngine.this.isAllInitialized()) {
              TtsManager.this.chooseEngineAndSpeak();
            }
          }
        });
      }
      else
      {
        this.mTts.stop();
        this.mTts.shutdown();
      }
    }
    
    public void setTtsLanguage(Context paramContext)
    {
      if (!this.mInitialized)
      {
        Dbg.e("Called setTtsLanguage on non-initialized engine: " + this.mPackageName);
      }
      else
      {
        Locale localLocale = Locale.getDefault();
        int j = -2;
        int i = this.mTts.isLanguageAvailable(localLocale);
        switch (i)
        {
        case 0: 
        case 1: 
        case 2: 
          j = this.mTts.setLanguage(localLocale);
        }
        Dbg.d("setTtsLanguage:  locale: " + localLocale + " available: " + i + " result: " + j + " tts.getLanguage(): " + this.mTts.getLanguage() + " " + this.mTts.getDefaultEngine());
      }
    }
    
    public void updateLanguageStatus(Locale paramLocale)
    {
      if ((!this.mInitialized) || (this.mLanguageStatus != -1)) {
        this.mLanguageStatus = -1;
      } else {
        this.mLanguageStatus = this.mTts.isLanguageAvailable(paramLocale);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.tts.TtsManager
 * JD-Core Version:    0.7.0.1
 */