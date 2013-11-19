package com.sonyericsson.extras.liveware.actions.music;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.Locale;

public class SmartTagsMediaPlayer
{
  public static final String GOOGLE_VANILLA_MUSIC_PLAYER = "GoogleVanillaMusicPlayer";
  public static final String MEDIA_BUTTON_MUSIC_PLAYER = "MediaButtonMusicPlayer";
  public static final String MUSIC_PLAYER_LISTPREFERENCE = "MusicPlayerListPreference";
  private static final int SDK_VERSION_GINGERBREAD = 9;
  public static final String SEMC_MUSIC_PLAYER = "SemcMusicPlayer";
  private static final int VENDOR_GENERIC = 2;
  private static final int VENDOR_SONY = 1;
  private static final String VENDOR_SONY_STRING = "sony";
  private Context mContext;
  private PlaybackServiceInterface mPlaybackService = null;
  private MusicService mService;
  private int mVendor = -1;
  private SharedPreferences prefs;
  
  public SmartTagsMediaPlayer(Context paramContext, MusicService paramMusicService)
  {
    Dbg.d("constructor");
    this.mContext = paramContext;
    this.mService = paramMusicService;
    this.prefs = PreferenceManager.getDefaultSharedPreferences(this.mContext);
    if (!this.prefs.getString("MusicPlayerListPreference", "-1").equals("-1"))
    {
      if (!this.prefs.getString("MusicPlayerListPreference", "-1").equals("SemcMusicPlayer"))
      {
        if (this.prefs.getString("MusicPlayerListPreference", "-1").equals("MediaButtonMusicPlayer"))
        {
          Dbg.d("generic player pref set");
          setVendorGeneric();
        }
      }
      else
      {
        Dbg.d("semc player pref set");
        setVendorSemc();
      }
    }
    else
    {
      Dbg.d("no player pref set");
      findVendor();
    }
  }
  
  private boolean isASonyProduct()
  {
    return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("sony");
  }
  
  private boolean isVendorGenericCompliant()
  {
    boolean bool;
    if (this.mVendor != 2) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean isVendorSemcCompliant()
  {
    int i = 1;
    if (this.mVendor != i) {
      i = 0;
    }
    return i;
  }
  
  public void findVendor()
  {
    PackageManager localPackageManager = this.mContext.getPackageManager();
    try
    {
      Dbg.d("Version " + Build.VERSION.SDK_INT + " " + Build.MANUFACTURER);
      if ((isASonyProduct()) && (Build.VERSION.SDK_INT >= 9))
      {
        localPackageManager.getPackageInfo("com.sonyericsson.music", 1);
        this.mVendor = 1;
        this.prefs.edit().putString("MusicPlayerListPreference", "SemcMusicPlayer").commit();
      }
      else
      {
        this.mVendor = 2;
        this.prefs.edit().putString("MusicPlayerListPreference", "MediaButtonMusicPlayer").commit();
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      this.mVendor = 2;
      this.prefs.edit().putString("MusicPlayerListPreference", "MediaButtonMusicPlayer").commit();
    }
  }
  
  public boolean isConnected()
  {
    boolean bool = false;
    if (this.mPlaybackService != null) {
      bool = this.mPlaybackService.isServiceConnected();
    }
    return bool;
  }
  
  public boolean isPlaying()
  {
    boolean bool;
    if (this.mPlaybackService != null) {
      bool = this.mPlaybackService.isPlaying();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void next()
  {
    if (this.mPlaybackService != null) {
      this.mPlaybackService.next();
    }
  }
  
  public void pause()
  {
    if (this.mPlaybackService != null) {
      this.mPlaybackService.pause();
    }
  }
  
  public void play()
  {
    StringBuilder localStringBuilder = new StringBuilder("play, playbackService is ");
    String str;
    if (this.mPlaybackService != null) {
      str = "not null";
    } else {
      str = "null";
    }
    Dbg.d(str);
    if (this.mPlaybackService != null)
    {
      Dbg.d("playing");
      this.mPlaybackService.play();
    }
  }
  
  public void setVendorGeneric()
  {
    this.mVendor = 2;
  }
  
  public void setVendorSemc()
  {
    this.mVendor = 1;
  }
  
  public boolean startAndBindToMediaService()
  {
    Dbg.d("startAndBindToMediaService");
    if (this.mPlaybackService != null)
    {
      Dbg.d("unbinding media service");
      this.mPlaybackService.unbindService();
    }
    this.mPlaybackService = null;
    if (!isVendorSemcCompliant())
    {
      if (isVendorGenericCompliant()) {
        this.mPlaybackService = new GenericPlaybackService(this.mContext, this.mService);
      }
    }
    else {
      this.mPlaybackService = new SemcPlaybackService(this.mContext, this.mService);
    }
    boolean bool = false;
    if (this.mPlaybackService != null)
    {
      Dbg.d("binding service");
      bool = this.mPlaybackService.bindService();
    }
    if (bool)
    {
      Dbg.d("Successfully bound music service");
    }
    else
    {
      Dbg.d("Failed to bind to music service. Go for generic.");
      this.mPlaybackService = new GenericPlaybackService(this.mContext, this.mService);
      bool = this.mPlaybackService.bindService();
    }
    return bool;
  }
  
  public void unbindService()
  {
    if (this.mPlaybackService != null) {
      this.mPlaybackService.unbindService();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.music.SmartTagsMediaPlayer
 * JD-Core Version:    0.7.0.1
 */