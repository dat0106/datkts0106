package com.sonymobile.playanywhere;

public class MediaProviderList
{
  public MediaProviderList(IMediaProviderCB paramIMediaProviderCB) {}
  
  public boolean add(IMediaProviderCallback paramIMediaProviderCallback, int paramInt)
  {
    throw new RuntimeException("stub");
  }
  
  public void callback(MediaProviderExec paramMediaProviderExec)
  {
    throw new RuntimeException("stub");
  }
  
  public int getStream(int paramInt)
  {
    throw new RuntimeException("stub");
  }
  
  public boolean isStreaming(int paramInt)
  {
    throw new RuntimeException("stub");
  }
  
  public boolean isTattleTale(int paramInt)
  {
    throw new RuntimeException("stub");
  }
  
  public void playbackAborted(int paramInt)
  {
    throw new RuntimeException("stub");
  }
  
  public void playbackEnded(int paramInt)
  {
    throw new RuntimeException("stub");
  }
  
  public void playbackStarted(int paramInt, long paramLong)
  {
    throw new RuntimeException("stub");
  }
  
  public void playbackSuspended(int paramInt, long paramLong)
  {
    throw new RuntimeException("stub");
  }
  
  public boolean remove(IMediaProviderCallback paramIMediaProviderCallback)
  {
    throw new RuntimeException("stub");
  }
  
  public void streamBegin(int paramInt1, int paramInt2, int paramInt3)
  {
    throw new RuntimeException("stub");
  }
  
  public void streamEnd(int paramInt)
  {
    throw new RuntimeException("stub");
  }
  
  public void streamErrorHandler(int paramInt, boolean paramBoolean)
  {
    throw new RuntimeException("stub");
  }
  
  public boolean streamPause(int paramInt)
  {
    throw new RuntimeException("stub");
  }
  
  public long streamPosition(int paramInt)
  {
    throw new RuntimeException("stub");
  }
  
  public void streamPrepare(int paramInt1, int paramInt2, int paramInt3)
  {
    throw new RuntimeException("stub");
  }
  
  public boolean streamResume(int paramInt)
  {
    throw new RuntimeException("stub");
  }
  
  public long streamSeek(int paramInt, long paramLong)
  {
    throw new RuntimeException("stub");
  }
  
  public void streamYield()
  {
    throw new RuntimeException("stub");
  }
  
  public static abstract interface MediaProviderExec
  {
    public abstract void exec(IMediaProviderCallback paramIMediaProviderCallback);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonymobile.playanywhere.MediaProviderList
 * JD-Core Version:    0.7.0.1
 */