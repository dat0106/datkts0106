package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager
{
  private static TagManager aid;
  private final DataLayer aer;
  private final r agL;
  private final a aib;
  private final ConcurrentMap<n, Boolean> aic;
  private final Context mContext;
  
  TagManager(Context paramContext, a parama, DataLayer paramDataLayer)
  {
    if (paramContext != null)
    {
      this.mContext = paramContext.getApplicationContext();
      this.aib = parama;
      this.aic = new ConcurrentHashMap();
      this.aer = paramDataLayer;
      this.aer.a(new DataLayer.b()
      {
        public void x(Map<String, Object> paramAnonymousMap)
        {
          Object localObject = paramAnonymousMap.get("event");
          if (localObject != null) {
            TagManager.a(TagManager.this, localObject.toString());
          }
        }
      });
      this.aer.a(new d(this.mContext));
      this.agL = new r();
      return;
    }
    throw new NullPointerException("context cannot be null");
  }
  
  private void cl(String paramString)
  {
    Iterator localIterator = this.aic.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((n)localIterator.next()).bH(paramString);
    }
  }
  
  /* Error */
  public static TagManager getInstance(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 108	com/google/android/gms/tagmanager/TagManager:aid	Lcom/google/android/gms/tagmanager/TagManager;
    //   6: ifnonnull +59 -> 65
    //   9: aload_0
    //   10: ifnonnull +22 -> 32
    //   13: ldc 110
    //   15: invokestatic 115	com/google/android/gms/tagmanager/bh:A	(Ljava/lang/String;)V
    //   18: new 68	java/lang/NullPointerException
    //   21: dup
    //   22: invokespecial 116	java/lang/NullPointerException:<init>	()V
    //   25: athrow
    //   26: astore_1
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    //   32: new 2	com/google/android/gms/tagmanager/TagManager
    //   35: dup
    //   36: aload_0
    //   37: new 8	com/google/android/gms/tagmanager/TagManager$2
    //   40: dup
    //   41: invokespecial 117	com/google/android/gms/tagmanager/TagManager$2:<init>	()V
    //   44: new 53	com/google/android/gms/tagmanager/DataLayer
    //   47: dup
    //   48: new 119	com/google/android/gms/tagmanager/v
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 120	com/google/android/gms/tagmanager/v:<init>	(Landroid/content/Context;)V
    //   56: invokespecial 123	com/google/android/gms/tagmanager/DataLayer:<init>	(Lcom/google/android/gms/tagmanager/DataLayer$c;)V
    //   59: invokespecial 125	com/google/android/gms/tagmanager/TagManager:<init>	(Landroid/content/Context;Lcom/google/android/gms/tagmanager/TagManager$a;Lcom/google/android/gms/tagmanager/DataLayer;)V
    //   62: putstatic 108	com/google/android/gms/tagmanager/TagManager:aid	Lcom/google/android/gms/tagmanager/TagManager;
    //   65: getstatic 108	com/google/android/gms/tagmanager/TagManager:aid	Lcom/google/android/gms/tagmanager/TagManager;
    //   68: astore_1
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_1
    //   73: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramContext	Context
    //   26	5	1	localObject	Object
    //   68	5	1	localTagManager	TagManager
    // Exception table:
    //   from	to	target	type
    //   3	30	26	finally
    //   32	72	26	finally
  }
  
  void a(n paramn)
  {
    this.aic.put(paramn, Boolean.valueOf(true));
  }
  
  boolean b(n paramn)
  {
    boolean bool;
    if (this.aic.remove(paramn) == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public DataLayer getDataLayer()
  {
    return this.aer;
  }
  
  /**
   * @deprecated
   */
  boolean h(Uri paramUri)
  {
    for (;;)
    {
      boolean bool;
      Object localObject3;
      try
      {
        localObject2 = cd.lY();
        if (!((cd)localObject2).h(paramUri)) {
          break label221;
        }
        String str = ((cd)localObject2).getContainerId();
        int j = 3.aif[localObject2.lZ().ordinal()];
        switch (j)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      Object localObject2 = this.aic.keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (n)((Iterator)localObject2).next();
        if (((n)localObject3).getContainerId().equals(bool))
        {
          ((n)localObject3).bJ(null);
          ((n)localObject3).refresh();
        }
      }
      else
      {
        continue;
        localObject3 = this.aic.keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          n localn = (n)((Iterator)localObject3).next();
          if (localn.getContainerId().equals(localObject1))
          {
            localn.bJ(((cd)localObject2).ma());
            localn.refresh();
          }
          else if (localn.lj() != null)
          {
            localn.bJ(null);
            localn.refresh();
          }
        }
        continue;
        label221:
        int i = 0;
      }
    }
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt)
  {
    o localo = this.aib.a(this.mContext, this, null, paramString, paramInt, this.agL);
    localo.lm();
    return localo;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt, Handler paramHandler)
  {
    o localo = this.aib.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.agL);
    localo.lm();
    return localo;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt)
  {
    o localo = this.aib.a(this.mContext, this, null, paramString, paramInt, this.agL);
    localo.lo();
    return localo;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt, Handler paramHandler)
  {
    o localo = this.aib.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.agL);
    localo.lo();
    return localo;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt)
  {
    o localo = this.aib.a(this.mContext, this, null, paramString, paramInt, this.agL);
    localo.ln();
    return localo;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt, Handler paramHandler)
  {
    o localo = this.aib.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.agL);
    localo.ln();
    return localo;
  }
  
  public void setVerboseLoggingEnabled(boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = 5;
    } else {
      i = 2;
    }
    bh.setLogLevel(i);
  }
  
  static abstract interface a
  {
    public abstract o a(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, r paramr);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.TagManager
 * JD-Core Version:    0.7.0.1
 */