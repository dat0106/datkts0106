package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache
{
  final Object Rj = new Object();
  private Handler Rk;
  private boolean Rl;
  private HashMap<String, AtomicInteger> Rm;
  private int Rn;
  
  public EventIncrementCache(Looper paramLooper, int paramInt)
  {
    this.Rk = new Handler(paramLooper);
    this.Rm = new HashMap();
    this.Rn = paramInt;
  }
  
  private void hK()
  {
    synchronized (this.Rj)
    {
      this.Rl = false;
      flush();
      return;
    }
  }
  
  /* Error */
  public void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/google/android/gms/games/internal/events/EventIncrementCache:Rj	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 36	com/google/android/gms/games/internal/events/EventIncrementCache:Rm	Ljava/util/HashMap;
    //   11: invokevirtual 52	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   14: invokeinterface 58 1 0
    //   19: astore_3
    //   20: aload_3
    //   21: invokeinterface 64 1 0
    //   26: ifeq +46 -> 72
    //   29: aload_3
    //   30: invokeinterface 68 1 0
    //   35: checkcast 70	java/util/Map$Entry
    //   38: astore_2
    //   39: aload_0
    //   40: aload_2
    //   41: invokeinterface 73 1 0
    //   46: checkcast 75	java/lang/String
    //   49: aload_2
    //   50: invokeinterface 78 1 0
    //   55: checkcast 80	java/util/concurrent/atomic/AtomicInteger
    //   58: invokevirtual 84	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   61: invokevirtual 88	com/google/android/gms/games/internal/events/EventIncrementCache:o	(Ljava/lang/String;I)V
    //   64: goto -44 -> 20
    //   67: astore_2
    //   68: aload_1
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    //   72: aload_0
    //   73: getfield 36	com/google/android/gms/games/internal/events/EventIncrementCache:Rm	Ljava/util/HashMap;
    //   76: invokevirtual 91	java/util/HashMap:clear	()V
    //   79: aload_1
    //   80: monitorexit
    //   81: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	EventIncrementCache
    //   4	76	1	localObject1	Object
    //   38	12	2	localEntry	java.util.Map.Entry
    //   67	4	2	localObject2	Object
    //   19	11	3	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   7	70	67	finally
    //   72	81	67	finally
  }
  
  protected abstract void o(String paramString, int paramInt);
  
  public void u(String paramString, int paramInt)
  {
    synchronized (this.Rj)
    {
      if (!this.Rl)
      {
        this.Rl = true;
        this.Rk.postDelayed(new Runnable()
        {
          public void run()
          {
            EventIncrementCache.a(EventIncrementCache.this);
          }
        }, this.Rn);
      }
      AtomicInteger localAtomicInteger = (AtomicInteger)this.Rm.get(paramString);
      if (localAtomicInteger == null)
      {
        localAtomicInteger = new AtomicInteger();
        this.Rm.put(paramString, localAtomicInteger);
      }
      localAtomicInteger.addAndGet(paramInt);
      return;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.events.EventIncrementCache
 * JD-Core Version:    0.7.0.1
 */