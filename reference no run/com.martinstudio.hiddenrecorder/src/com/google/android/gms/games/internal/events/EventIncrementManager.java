package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager
{
  private final AtomicReference<EventIncrementCache> Rp = new AtomicReference();
  
  public void flush()
  {
    EventIncrementCache localEventIncrementCache = (EventIncrementCache)this.Rp.get();
    if (localEventIncrementCache != null) {
      localEventIncrementCache.flush();
    }
  }
  
  protected abstract EventIncrementCache hs();
  
  public void l(String paramString, int paramInt)
  {
    EventIncrementCache localEventIncrementCache = (EventIncrementCache)this.Rp.get();
    if (localEventIncrementCache == null)
    {
      localEventIncrementCache = hs();
      if (!this.Rp.compareAndSet(null, localEventIncrementCache)) {
        localEventIncrementCache = (EventIncrementCache)this.Rp.get();
      }
    }
    localEventIncrementCache.u(paramString, paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.events.EventIncrementManager
 * JD-Core Version:    0.7.0.1
 */