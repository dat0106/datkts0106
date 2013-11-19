package com.google.analytics.tracking.android;

import java.util.List;

abstract interface Dispatcher
{
  public abstract int dispatchHits(List<Hit> paramList);
  
  public abstract boolean okToDispatch();
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Dispatcher
 * JD-Core Version:    0.7.0.1
 */