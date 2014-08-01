package android.support.v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;
import android.view.Window;
import java.util.ArrayList;

public class TransportMediator
  extends TransportController
{
  public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
  public static final int FLAG_KEY_MEDIA_NEXT = 128;
  public static final int FLAG_KEY_MEDIA_PAUSE = 16;
  public static final int FLAG_KEY_MEDIA_PLAY = 4;
  public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
  public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
  public static final int FLAG_KEY_MEDIA_REWIND = 2;
  public static final int FLAG_KEY_MEDIA_STOP = 32;
  public static final int KEYCODE_MEDIA_PAUSE = 127;
  public static final int KEYCODE_MEDIA_PLAY = 126;
  public static final int KEYCODE_MEDIA_RECORD = 130;
  final AudioManager mAudioManager;
  final TransportPerformer mCallbacks;
  final Context mContext;
  final TransportMediatorJellybeanMR2 mController;
  final Object mDispatcherState;
  final KeyEvent.Callback mKeyEventCallback = new KeyEvent.Callback()
  {
    public boolean onKeyDown(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      boolean bool;
      if (!TransportMediator.isMediaKey(paramAnonymousInt)) {
        bool = false;
      } else {
        bool = TransportMediator.this.mCallbacks.onMediaButtonDown(paramAnonymousInt, paramAnonymousKeyEvent);
      }
      return bool;
    }
    
    public boolean onKeyLongPress(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      return false;
    }
    
    public boolean onKeyMultiple(int paramAnonymousInt1, int paramAnonymousInt2, KeyEvent paramAnonymousKeyEvent)
    {
      return false;
    }
    
    public boolean onKeyUp(int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      boolean bool;
      if (!TransportMediator.isMediaKey(paramAnonymousInt)) {
        bool = false;
      } else {
        bool = TransportMediator.this.mCallbacks.onMediaButtonUp(paramAnonymousInt, paramAnonymousKeyEvent);
      }
      return bool;
    }
  };
  final ArrayList<TransportStateListener> mListeners = new ArrayList();
  final TransportMediatorCallback mTransportKeyCallback = new TransportMediatorCallback()
  {
    public long getPlaybackPosition()
    {
      return TransportMediator.this.mCallbacks.onGetCurrentPosition();
    }
    
    public void handleAudioFocusChange(int paramAnonymousInt)
    {
      TransportMediator.this.mCallbacks.onAudioFocusChange(paramAnonymousInt);
    }
    
    public void handleKey(KeyEvent paramAnonymousKeyEvent)
    {
      paramAnonymousKeyEvent.dispatch(TransportMediator.this.mKeyEventCallback);
    }
    
    public void playbackPositionUpdate(long paramAnonymousLong)
    {
      TransportMediator.this.mCallbacks.onSeekTo(paramAnonymousLong);
    }
  };
  final View mView;
  
  public TransportMediator(Activity paramActivity, TransportPerformer paramTransportPerformer)
  {
    this(paramActivity, null, paramTransportPerformer);
  }
  
  private TransportMediator(Activity paramActivity, View paramView, TransportPerformer paramTransportPerformer)
  {
    Object localObject;
    if (paramActivity == null) {
      localObject = paramView.getContext();
    } else {
      localObject = paramActivity;
    }
    this.mContext = ((Context)localObject);
    this.mCallbacks = paramTransportPerformer;
    this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
    if (paramActivity != null) {
      paramView = paramActivity.getWindow().getDecorView();
    }
    this.mView = paramView;
    this.mDispatcherState = KeyEventCompat.getKeyDispatcherState(this.mView);
    if (Build.VERSION.SDK_INT < 18) {
      this.mController = null;
    } else {
      this.mController = new TransportMediatorJellybeanMR2(this.mContext, this.mAudioManager, this.mView, this.mTransportKeyCallback);
    }
  }
  
  public TransportMediator(View paramView, TransportPerformer paramTransportPerformer)
  {
    this(null, paramView, paramTransportPerformer);
  }
  
  private TransportStateListener[] getListeners()
  {
    TransportStateListener[] arrayOfTransportStateListener;
    if (this.mListeners.size() > 0)
    {
      arrayOfTransportStateListener = new TransportStateListener[this.mListeners.size()];
      this.mListeners.toArray(arrayOfTransportStateListener);
    }
    else
    {
      arrayOfTransportStateListener = null;
    }
    return arrayOfTransportStateListener;
  }
  
  static boolean isMediaKey(int paramInt)
  {
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
      break;
    case 79: 
    case 85: 
    case 86: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    case 91: 
    case 126: 
    case 127: 
    case 130: 
      bool = true;
    }
    return bool;
  }
  
  private void pushControllerState()
  {
    if (this.mController != null) {
      this.mController.refreshState(this.mCallbacks.onIsPlaying(), this.mCallbacks.onGetCurrentPosition(), this.mCallbacks.onGetTransportControlFlags());
    }
  }
  
  private void reportPlayingChanged()
  {
    TransportStateListener[] arrayOfTransportStateListener = getListeners();
    int j;
    if (arrayOfTransportStateListener != null) {
      j = arrayOfTransportStateListener.length;
    }
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      arrayOfTransportStateListener[i].onPlayingChanged(this);
    }
  }
  
  private void reportTransportControlsChanged()
  {
    TransportStateListener[] arrayOfTransportStateListener = getListeners();
    int j;
    if (arrayOfTransportStateListener != null) {
      j = arrayOfTransportStateListener.length;
    }
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      arrayOfTransportStateListener[i].onTransportControlsChanged(this);
    }
  }
  
  public void destroy()
  {
    this.mController.destroy();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return KeyEventCompat.dispatch(paramKeyEvent, this.mKeyEventCallback, this.mDispatcherState, this);
  }
  
  public int getBufferPercentage()
  {
    return this.mCallbacks.onGetBufferPercentage();
  }
  
  public long getCurrentPosition()
  {
    return this.mCallbacks.onGetCurrentPosition();
  }
  
  public long getDuration()
  {
    return this.mCallbacks.onGetDuration();
  }
  
  public Object getRemoteControlClient()
  {
    Object localObject;
    if (this.mController == null) {
      localObject = null;
    } else {
      localObject = this.mController.getRemoteControlClient();
    }
    return localObject;
  }
  
  public int getTransportControlFlags()
  {
    return this.mCallbacks.onGetTransportControlFlags();
  }
  
  public boolean isPlaying()
  {
    return this.mCallbacks.onIsPlaying();
  }
  
  public void pausePlaying()
  {
    if (this.mController != null) {
      this.mController.pausePlaying();
    }
    this.mCallbacks.onPause();
    pushControllerState();
    reportPlayingChanged();
  }
  
  public void refreshState()
  {
    pushControllerState();
    reportPlayingChanged();
    reportTransportControlsChanged();
  }
  
  public void registerStateListener(TransportStateListener paramTransportStateListener)
  {
    this.mListeners.add(paramTransportStateListener);
  }
  
  public void seekTo(long paramLong)
  {
    this.mCallbacks.onSeekTo(paramLong);
  }
  
  public void startPlaying()
  {
    if (this.mController != null) {
      this.mController.startPlaying();
    }
    this.mCallbacks.onStart();
    pushControllerState();
    reportPlayingChanged();
  }
  
  public void stopPlaying()
  {
    if (this.mController != null) {
      this.mController.stopPlaying();
    }
    this.mCallbacks.onStop();
    pushControllerState();
    reportPlayingChanged();
  }
  
  public void unregisterStateListener(TransportStateListener paramTransportStateListener)
  {
    this.mListeners.remove(paramTransportStateListener);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.media.TransportMediator
 * JD-Core Version:    0.7.0.1
 */