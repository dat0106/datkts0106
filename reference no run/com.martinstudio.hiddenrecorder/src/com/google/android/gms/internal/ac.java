package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.WeakHashMap;

public final class ac
  implements ae
{
  private final Object lq = new Object();
  private WeakHashMap<eg, ad> lr = new WeakHashMap();
  private ArrayList<ad> ls = new ArrayList();
  
  public ad a(am paramam, eg parameg)
  {
    synchronized (this.lq)
    {
      ad localad1;
      if (c(parameg))
      {
        localad1 = (ad)this.lr.get(parameg);
      }
      else
      {
        localad1 = new ad(paramam, parameg);
        localad1.a(this);
        this.lr.put(parameg, localad1);
        this.ls.add(localad1);
      }
    }
    return localad2;
  }
  
  public void a(ad paramad)
  {
    synchronized (this.lq)
    {
      if (!paramad.au()) {
        this.ls.remove(paramad);
      }
      return;
    }
  }
  
  public boolean c(eg parameg)
  {
    for (;;)
    {
      synchronized (this.lq)
      {
        ad localad = (ad)this.lr.get(parameg);
        if ((localad != null) && (localad.au()))
        {
          boolean bool = true;
          return bool;
        }
      }
      int i = 0;
    }
  }
  
  public void d(eg parameg)
  {
    synchronized (this.lq)
    {
      ad localad = (ad)this.lr.get(parameg);
      if (localad != null) {
        localad.as();
      }
      return;
    }
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/google/android/gms/internal/ac:lq	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 30	com/google/android/gms/internal/ac:ls	Ljava/util/ArrayList;
    //   11: invokevirtual 74	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   14: astore_2
    //   15: aload_2
    //   16: invokeinterface 79 1 0
    //   21: ifeq +23 -> 44
    //   24: aload_2
    //   25: invokeinterface 83 1 0
    //   30: checkcast 42	com/google/android/gms/internal/ad
    //   33: invokevirtual 85	com/google/android/gms/internal/ad:pause	()V
    //   36: goto -21 -> 15
    //   39: astore_2
    //   40: aload_1
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    //   44: aload_1
    //   45: monitorexit
    //   46: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	ac
    //   4	41	1	localObject1	Object
    //   14	11	2	localIterator	java.util.Iterator
    //   39	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	42	39	finally
    //   44	46	39	finally
  }
  
  /* Error */
  public void resume()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/google/android/gms/internal/ac:lq	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 30	com/google/android/gms/internal/ac:ls	Ljava/util/ArrayList;
    //   11: invokevirtual 74	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   14: astore_2
    //   15: aload_2
    //   16: invokeinterface 79 1 0
    //   21: ifeq +23 -> 44
    //   24: aload_2
    //   25: invokeinterface 83 1 0
    //   30: checkcast 42	com/google/android/gms/internal/ad
    //   33: invokevirtual 88	com/google/android/gms/internal/ad:resume	()V
    //   36: goto -21 -> 15
    //   39: astore_2
    //   40: aload_1
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    //   44: aload_1
    //   45: monitorexit
    //   46: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	ac
    //   4	41	1	localObject1	Object
    //   14	11	2	localIterator	java.util.Iterator
    //   39	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	42	39	finally
    //   44	46	39	finally
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/google/android/gms/internal/ac:lq	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 30	com/google/android/gms/internal/ac:ls	Ljava/util/ArrayList;
    //   11: invokevirtual 74	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   14: astore_2
    //   15: aload_2
    //   16: invokeinterface 79 1 0
    //   21: ifeq +23 -> 44
    //   24: aload_2
    //   25: invokeinterface 83 1 0
    //   30: checkcast 42	com/google/android/gms/internal/ad
    //   33: invokevirtual 91	com/google/android/gms/internal/ad:stop	()V
    //   36: goto -21 -> 15
    //   39: astore_2
    //   40: aload_1
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    //   44: aload_1
    //   45: monitorexit
    //   46: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	ac
    //   4	41	1	localObject1	Object
    //   14	11	2	localIterator	java.util.Iterator
    //   39	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	42	39	finally
    //   44	46	39	finally
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ac
 * JD-Core Version:    0.7.0.1
 */