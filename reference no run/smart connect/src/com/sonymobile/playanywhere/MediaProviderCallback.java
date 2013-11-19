package com.sonymobile.playanywhere;

public abstract interface MediaProviderCallback
{
  public abstract boolean onConnected(int paramInt);
  
  public abstract void onDisconnected();
  
  public abstract void onEnd();
  
  public abstract void onPause(long paramLong);
  
  public abstract void onPlay(long paramLong);
  
  public abstract void onPosition(long paramLong);
  
  public abstract void onUnsolicitedNext();
  
  public abstract void onUnsolicitedPrevious();
  
  public abstract void onUnsolicitedStop();
  
  public abstract void onUnsolicitedYield();
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonymobile.playanywhere.MediaProviderCallback
 * JD-Core Version:    0.7.0.1
 */