package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

abstract interface ServiceProxy
{
  public abstract void clearHits();
  
  public abstract void createService();
  
  public abstract void dispatch();
  
  public abstract void putHit(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList);
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.ServiceProxy
 * JD-Core Version:    0.7.0.1
 */