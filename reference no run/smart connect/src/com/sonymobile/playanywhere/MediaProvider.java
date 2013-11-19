package com.sonymobile.playanywhere;

public abstract class MediaProvider
{
  public abstract boolean registerProvider(MediaProviderCallback paramMediaProviderCallback);
  
  public abstract int streamBegin(long paramLong);
  
  public abstract int streamEnd();
  
  public abstract void streamErrorHandler(boolean paramBoolean);
  
  public abstract int streamPause();
  
  public abstract long streamPosition();
  
  public abstract int streamPrepare(String paramString);
  
  public abstract int streamResume();
  
  public abstract long streamSeek(long paramLong);
  
  public abstract void unregisterProvider(MediaProviderCallback paramMediaProviderCallback);
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonymobile.playanywhere.MediaProvider
 * JD-Core Version:    0.7.0.1
 */