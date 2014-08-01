package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;

public class ei
{
  private static final ei rM = new ei();
  public static final String rN = rM.rO;
  private final Object lq = new Object();
  public final String rO = ep.bO();
  private final ej rP = new ej(this.rO);
  private BigInteger rQ = BigInteger.ONE;
  private final HashSet<eh> rR = new HashSet();
  private final HashMap<String, el> rS = new HashMap();
  private boolean rT = false;
  
  public static Bundle a(Context paramContext, ek paramek, String paramString)
  {
    return rM.b(paramContext, paramek, paramString);
  }
  
  public static void b(HashSet<eh> paramHashSet)
  {
    rM.c(paramHashSet);
  }
  
  public static ei bC()
  {
    return rM;
  }
  
  public static String bD()
  {
    return rM.bE();
  }
  
  public static ej bF()
  {
    return rM.bG();
  }
  
  public static boolean bH()
  {
    return rM.bI();
  }
  
  public void a(eh parameh)
  {
    synchronized (this.lq)
    {
      this.rR.add(parameh);
      return;
    }
  }
  
  public void a(String paramString, el paramel)
  {
    synchronized (this.lq)
    {
      this.rS.put(paramString, paramel);
      return;
    }
  }
  
  /* Error */
  public Bundle b(Context paramContext, ek paramek, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	com/google/android/gms/internal/ei:lq	Ljava/lang/Object;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: new 106	android/os/Bundle
    //   12: dup
    //   13: invokespecial 107	android/os/Bundle:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: ldc 109
    //   22: aload_0
    //   23: getfield 69	com/google/android/gms/internal/ei:rP	Lcom/google/android/gms/internal/ej;
    //   26: aload_1
    //   27: aload_3
    //   28: invokevirtual 112	com/google/android/gms/internal/ej:b	(Landroid/content/Context;Ljava/lang/String;)Landroid/os/Bundle;
    //   31: invokevirtual 116	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   34: new 106	android/os/Bundle
    //   37: dup
    //   38: invokespecial 107	android/os/Bundle:<init>	()V
    //   41: astore 8
    //   43: aload_0
    //   44: getfield 54	com/google/android/gms/internal/ei:rS	Ljava/util/HashMap;
    //   47: invokevirtual 120	java/util/HashMap:keySet	()Ljava/util/Set;
    //   50: invokeinterface 126 1 0
    //   55: astore 7
    //   57: aload 7
    //   59: invokeinterface 131 1 0
    //   64: ifeq +48 -> 112
    //   67: aload 7
    //   69: invokeinterface 135 1 0
    //   74: checkcast 137	java/lang/String
    //   77: astore 6
    //   79: aload 8
    //   81: aload 6
    //   83: aload_0
    //   84: getfield 54	com/google/android/gms/internal/ei:rS	Ljava/util/HashMap;
    //   87: aload 6
    //   89: invokevirtual 141	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 143	com/google/android/gms/internal/el
    //   95: invokevirtual 147	com/google/android/gms/internal/el:toBundle	()Landroid/os/Bundle;
    //   98: invokevirtual 116	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   101: goto -44 -> 57
    //   104: astore 5
    //   106: aload 4
    //   108: monitorexit
    //   109: aload 5
    //   111: athrow
    //   112: aload 5
    //   114: ldc 149
    //   116: aload 8
    //   118: invokevirtual 116	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   121: new 151	java/util/ArrayList
    //   124: dup
    //   125: invokespecial 152	java/util/ArrayList:<init>	()V
    //   128: astore 7
    //   130: aload_0
    //   131: getfield 49	com/google/android/gms/internal/ei:rR	Ljava/util/HashSet;
    //   134: invokevirtual 153	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   137: astore 6
    //   139: aload 6
    //   141: invokeinterface 131 1 0
    //   146: ifeq +25 -> 171
    //   149: aload 7
    //   151: aload 6
    //   153: invokeinterface 135 1 0
    //   158: checkcast 155	com/google/android/gms/internal/eh
    //   161: invokevirtual 156	com/google/android/gms/internal/eh:toBundle	()Landroid/os/Bundle;
    //   164: invokevirtual 157	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   167: pop
    //   168: goto -29 -> 139
    //   171: aload 5
    //   173: ldc 159
    //   175: aload 7
    //   177: invokevirtual 163	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   180: aload_2
    //   181: aload_0
    //   182: getfield 49	com/google/android/gms/internal/ei:rR	Ljava/util/HashSet;
    //   185: invokeinterface 167 2 0
    //   190: aload_0
    //   191: getfield 49	com/google/android/gms/internal/ei:rR	Ljava/util/HashSet;
    //   194: invokevirtual 170	java/util/HashSet:clear	()V
    //   197: aload 4
    //   199: monitorexit
    //   200: aload 5
    //   202: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	ei
    //   0	203	1	paramContext	Context
    //   0	203	2	paramek	ek
    //   0	203	3	paramString	String
    //   4	194	4	localObject1	Object
    //   16	3	5	localBundle1	Bundle
    //   104	97	5	localBundle2	Bundle
    //   77	75	6	localObject2	Object
    //   55	121	7	localObject3	Object
    //   41	76	8	localBundle3	Bundle
    // Exception table:
    //   from	to	target	type
    //   9	109	104	finally
    //   112	200	104	finally
  }
  
  public String bE()
  {
    synchronized (this.lq)
    {
      String str = this.rQ.toString();
      this.rQ = this.rQ.add(BigInteger.ONE);
      return str;
    }
  }
  
  public ej bG()
  {
    synchronized (this.lq)
    {
      ej localej = this.rP;
      return localej;
    }
  }
  
  public boolean bI()
  {
    synchronized (this.lq)
    {
      boolean bool = this.rT;
      this.rT = true;
      return bool;
    }
  }
  
  public void c(HashSet<eh> paramHashSet)
  {
    synchronized (this.lq)
    {
      this.rR.addAll(paramHashSet);
      return;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ei
 * JD-Core Version:    0.7.0.1
 */