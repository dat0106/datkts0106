package com.google.analytics.tracking.android;

public abstract interface ServiceManager
{
  public abstract void dispatch();
  
  public abstract void setDispatchPeriod(int paramInt);
  
  public abstract void updateConnectivityStatus(boolean paramBoolean);
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.ServiceManager
 * JD-Core Version:    0.7.0.1
 */