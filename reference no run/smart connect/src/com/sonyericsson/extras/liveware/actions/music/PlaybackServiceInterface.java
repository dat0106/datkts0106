package com.sonyericsson.extras.liveware.actions.music;

public abstract interface PlaybackServiceInterface
{
  public abstract boolean bindService();
  
  public abstract boolean isPlaying();
  
  public abstract boolean isServiceConnected();
  
  public abstract void next();
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void unbindService();
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.music.PlaybackServiceInterface
 * JD-Core Version:    0.7.0.1
 */