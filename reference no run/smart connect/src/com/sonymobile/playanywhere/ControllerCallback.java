package com.sonymobile.playanywhere;

public abstract interface ControllerCallback
{
  public abstract void onSinkAdded(int paramInt);
  
  public abstract void onSinkAvailable();
  
  public abstract void onSinkRemoved(int paramInt);
  
  public abstract void onSinkUnavailable();
  
  public abstract void onStreamEnded(int paramInt);
  
  public abstract void onStreamStarted(int paramInt);
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonymobile.playanywhere.ControllerCallback
 * JD-Core Version:    0.7.0.1
 */