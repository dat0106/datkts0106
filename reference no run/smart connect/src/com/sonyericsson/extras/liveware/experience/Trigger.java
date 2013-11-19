package com.sonyericsson.extras.liveware.experience;

public abstract class Trigger
{
  protected boolean mConnected;
  
  public Trigger(boolean paramBoolean)
  {
    this.mConnected = paramBoolean;
  }
  
  public boolean isConnected()
  {
    return this.mConnected;
  }
  
  public void setConnected(boolean paramBoolean)
  {
    this.mConnected = paramBoolean;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.experience.Trigger
 * JD-Core Version:    0.7.0.1
 */