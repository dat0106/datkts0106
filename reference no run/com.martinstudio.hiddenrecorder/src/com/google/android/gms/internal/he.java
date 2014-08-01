package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;

public final class he
  implements Handler.Callback
{
  private static final Object Gs = new Object();
  private static he Gt;
  private final HashMap<String, a> Gu = new HashMap();
  private final Context lx;
  private final Handler mHandler = new Handler(paramContext.getMainLooper(), this);
  
  private he(Context paramContext)
  {
    this.lx = paramContext.getApplicationContext();
  }
  
  public static he B(Context paramContext)
  {
    synchronized (Gs)
    {
      if (Gt == null) {
        Gt = new he(paramContext.getApplicationContext());
      }
      return Gt;
    }
  }
  
  /* Error */
  public boolean a(String paramString, hc<?>.f paramhc)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/google/android/gms/internal/he:Gu	Ljava/util/HashMap;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 46	com/google/android/gms/internal/he:Gu	Ljava/util/HashMap;
    //   11: aload_1
    //   12: invokevirtual 64	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 8	com/google/android/gms/internal/he$a
    //   18: astore 4
    //   20: aload 4
    //   22: ifnonnull +80 -> 102
    //   25: new 8	com/google/android/gms/internal/he$a
    //   28: dup
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 67	com/google/android/gms/internal/he$a:<init>	(Lcom/google/android/gms/internal/he;Ljava/lang/String;)V
    //   34: astore 4
    //   36: aload 4
    //   38: aload_2
    //   39: invokevirtual 70	com/google/android/gms/internal/he$a:a	(Lcom/google/android/gms/internal/hc$f;)V
    //   42: new 72	android/content/Intent
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 75	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   50: ldc 77
    //   52: invokevirtual 81	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   55: astore 5
    //   57: aload 4
    //   59: aload_0
    //   60: getfield 52	com/google/android/gms/internal/he:lx	Landroid/content/Context;
    //   63: aload 5
    //   65: aload 4
    //   67: invokevirtual 85	com/google/android/gms/internal/he$a:fs	()Lcom/google/android/gms/internal/he$a$a;
    //   70: sipush 129
    //   73: invokevirtual 89	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   76: invokevirtual 92	com/google/android/gms/internal/he$a:B	(Z)V
    //   79: aload_0
    //   80: getfield 46	com/google/android/gms/internal/he:Gu	Ljava/util/HashMap;
    //   83: aload_1
    //   84: aload 4
    //   86: invokevirtual 96	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload 4
    //   92: invokevirtual 100	com/google/android/gms/internal/he$a:isBound	()Z
    //   95: istore 4
    //   97: aload_3
    //   98: monitorexit
    //   99: iload 4
    //   101: ireturn
    //   102: aload_0
    //   103: getfield 41	com/google/android/gms/internal/he:mHandler	Landroid/os/Handler;
    //   106: iconst_0
    //   107: aload 4
    //   109: invokevirtual 104	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   112: aload 4
    //   114: aload_2
    //   115: invokevirtual 108	com/google/android/gms/internal/he$a:c	(Lcom/google/android/gms/internal/hc$f;)Z
    //   118: ifeq +37 -> 155
    //   121: new 110	java/lang/IllegalStateException
    //   124: dup
    //   125: new 112	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   132: ldc 115
    //   134: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_1
    //   138: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokespecial 124	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   147: athrow
    //   148: astore 4
    //   150: aload_3
    //   151: monitorexit
    //   152: aload 4
    //   154: athrow
    //   155: aload 4
    //   157: aload_2
    //   158: invokevirtual 70	com/google/android/gms/internal/he$a:a	(Lcom/google/android/gms/internal/hc$f;)V
    //   161: aload 4
    //   163: invokevirtual 128	com/google/android/gms/internal/he$a:getState	()I
    //   166: tableswitch	default:+79 -> 245, 1:+22->188, 2:+39->205
    //   189: aload 4
    //   191: invokevirtual 132	com/google/android/gms/internal/he$a:getComponentName	()Landroid/content/ComponentName;
    //   194: aload 4
    //   196: invokevirtual 136	com/google/android/gms/internal/he$a:getBinder	()Landroid/os/IBinder;
    //   199: invokevirtual 142	com/google/android/gms/internal/hc$f:onServiceConnected	(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    //   202: goto -112 -> 90
    //   205: new 72	android/content/Intent
    //   208: dup
    //   209: aload_1
    //   210: invokespecial 75	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   213: ldc 77
    //   215: invokevirtual 81	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   218: astore 5
    //   220: aload 4
    //   222: aload_0
    //   223: getfield 52	com/google/android/gms/internal/he:lx	Landroid/content/Context;
    //   226: aload 5
    //   228: aload 4
    //   230: invokevirtual 85	com/google/android/gms/internal/he$a:fs	()Lcom/google/android/gms/internal/he$a$a;
    //   233: sipush 129
    //   236: invokevirtual 89	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   239: invokevirtual 92	com/google/android/gms/internal/he$a:B	(Z)V
    //   242: goto -152 -> 90
    //   245: goto -155 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	he
    //   0	248	1	paramString	String
    //   0	248	2	paramhc	hc<?>.f
    //   4	147	3	localHashMap	HashMap
    //   18	73	4	locala	a
    //   95	18	4	bool	boolean
    //   148	81	4	localObject	Object
    //   55	172	5	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   7	152	148	finally
    //   155	242	148	finally
  }
  
  /* Error */
  public void b(String paramString, hc<?>.f paramhc)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/google/android/gms/internal/he:Gu	Ljava/util/HashMap;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 46	com/google/android/gms/internal/he:Gu	Ljava/util/HashMap;
    //   11: aload_1
    //   12: invokevirtual 64	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 8	com/google/android/gms/internal/he$a
    //   18: astore 4
    //   20: aload 4
    //   22: ifnonnull +37 -> 59
    //   25: new 110	java/lang/IllegalStateException
    //   28: dup
    //   29: new 112	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   36: ldc 146
    //   38: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 124	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   51: athrow
    //   52: astore 4
    //   54: aload_3
    //   55: monitorexit
    //   56: aload 4
    //   58: athrow
    //   59: aload 4
    //   61: aload_2
    //   62: invokevirtual 108	com/google/android/gms/internal/he$a:c	(Lcom/google/android/gms/internal/hc$f;)Z
    //   65: ifne +30 -> 95
    //   68: new 110	java/lang/IllegalStateException
    //   71: dup
    //   72: new 112	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   79: ldc 148
    //   81: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokespecial 124	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   94: athrow
    //   95: aload 4
    //   97: aload_2
    //   98: invokevirtual 150	com/google/android/gms/internal/he$a:b	(Lcom/google/android/gms/internal/hc$f;)V
    //   101: aload 4
    //   103: invokevirtual 153	com/google/android/gms/internal/he$a:fu	()Z
    //   106: ifeq +28 -> 134
    //   109: aload_0
    //   110: getfield 41	com/google/android/gms/internal/he:mHandler	Landroid/os/Handler;
    //   113: iconst_0
    //   114: aload 4
    //   116: invokevirtual 157	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   119: astore 4
    //   121: aload_0
    //   122: getfield 41	com/google/android/gms/internal/he:mHandler	Landroid/os/Handler;
    //   125: aload 4
    //   127: ldc2_w 158
    //   130: invokevirtual 163	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   133: pop
    //   134: aload_3
    //   135: monitorexit
    //   136: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	he
    //   0	137	1	paramString	String
    //   0	137	2	paramhc	hc<?>.f
    //   4	131	3	localHashMap	HashMap
    //   18	3	4	locala	a
    //   52	63	4	localObject	Object
    //   119	7	4	localMessage	Message
    // Exception table:
    //   from	to	target	type
    //   7	56	52	finally
    //   59	136	52	finally
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      a locala = (a)paramMessage.obj;
      synchronized (this.Gu)
      {
        if (locala.fu())
        {
          this.lx.unbindService(locala.fs());
          this.Gu.remove(locala.ft());
        }
        int i = 1;
      }
    }
  }
  
  final class a
  {
    private ComponentName GA;
    private final String Gv;
    private final a Gw;
    private final HashSet<hc<?>.f> Gx;
    private boolean Gy;
    private IBinder Gz;
    private int mState;
    
    public a(String paramString)
    {
      this.Gv = paramString;
      this.Gw = new a();
      this.Gx = new HashSet();
      this.mState = 0;
    }
    
    public void B(boolean paramBoolean)
    {
      this.Gy = paramBoolean;
    }
    
    public void a(hc<?>.f paramhc)
    {
      this.Gx.add(paramhc);
    }
    
    public void b(hc<?>.f paramhc)
    {
      this.Gx.remove(paramhc);
    }
    
    public boolean c(hc<?>.f paramhc)
    {
      return this.Gx.contains(paramhc);
    }
    
    public a fs()
    {
      return this.Gw;
    }
    
    public String ft()
    {
      return this.Gv;
    }
    
    public boolean fu()
    {
      return this.Gx.isEmpty();
    }
    
    public IBinder getBinder()
    {
      return this.Gz;
    }
    
    public ComponentName getComponentName()
    {
      return this.GA;
    }
    
    public int getState()
    {
      return this.mState;
    }
    
    public boolean isBound()
    {
      return this.Gy;
    }
    
    public class a
      implements ServiceConnection
    {
      public a() {}
      
      /* Error */
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 15	com/google/android/gms/internal/he$a$a:GC	Lcom/google/android/gms/internal/he$a;
        //   4: getfield 24	com/google/android/gms/internal/he$a:GB	Lcom/google/android/gms/internal/he;
        //   7: invokestatic 29	com/google/android/gms/internal/he:a	(Lcom/google/android/gms/internal/he;)Ljava/util/HashMap;
        //   10: astore_3
        //   11: aload_3
        //   12: monitorenter
        //   13: aload_0
        //   14: getfield 15	com/google/android/gms/internal/he$a$a:GC	Lcom/google/android/gms/internal/he$a;
        //   17: aload_2
        //   18: invokestatic 32	com/google/android/gms/internal/he$a:a	(Lcom/google/android/gms/internal/he$a;Landroid/os/IBinder;)Landroid/os/IBinder;
        //   21: pop
        //   22: aload_0
        //   23: getfield 15	com/google/android/gms/internal/he$a$a:GC	Lcom/google/android/gms/internal/he$a;
        //   26: aload_1
        //   27: invokestatic 35	com/google/android/gms/internal/he$a:a	(Lcom/google/android/gms/internal/he$a;Landroid/content/ComponentName;)Landroid/content/ComponentName;
        //   30: pop
        //   31: aload_0
        //   32: getfield 15	com/google/android/gms/internal/he$a$a:GC	Lcom/google/android/gms/internal/he$a;
        //   35: invokestatic 38	com/google/android/gms/internal/he$a:a	(Lcom/google/android/gms/internal/he$a;)Ljava/util/HashSet;
        //   38: invokevirtual 44	java/util/HashSet:iterator	()Ljava/util/Iterator;
        //   41: astore 4
        //   43: aload 4
        //   45: invokeinterface 50 1 0
        //   50: ifeq +28 -> 78
        //   53: aload 4
        //   55: invokeinterface 54 1 0
        //   60: checkcast 56	com/google/android/gms/internal/hc$f
        //   63: aload_1
        //   64: aload_2
        //   65: invokevirtual 58	com/google/android/gms/internal/hc$f:onServiceConnected	(Landroid/content/ComponentName;Landroid/os/IBinder;)V
        //   68: goto -25 -> 43
        //   71: astore 4
        //   73: aload_3
        //   74: monitorexit
        //   75: aload 4
        //   77: athrow
        //   78: aload_0
        //   79: getfield 15	com/google/android/gms/internal/he$a$a:GC	Lcom/google/android/gms/internal/he$a;
        //   82: iconst_1
        //   83: invokestatic 61	com/google/android/gms/internal/he$a:a	(Lcom/google/android/gms/internal/he$a;I)I
        //   86: pop
        //   87: aload_3
        //   88: monitorexit
        //   89: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramComponentName	ComponentName
        //   0	90	2	paramIBinder	IBinder
        //   10	78	3	localHashMap	HashMap
        //   41	13	4	localIterator	java.util.Iterator
        //   71	5	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   13	75	71	finally
        //   78	89	71	finally
      }
      
      /* Error */
      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 15	com/google/android/gms/internal/he$a$a:GC	Lcom/google/android/gms/internal/he$a;
        //   4: getfield 24	com/google/android/gms/internal/he$a:GB	Lcom/google/android/gms/internal/he;
        //   7: invokestatic 29	com/google/android/gms/internal/he:a	(Lcom/google/android/gms/internal/he;)Ljava/util/HashMap;
        //   10: astore_2
        //   11: aload_2
        //   12: monitorenter
        //   13: aload_0
        //   14: getfield 15	com/google/android/gms/internal/he$a$a:GC	Lcom/google/android/gms/internal/he$a;
        //   17: aconst_null
        //   18: invokestatic 32	com/google/android/gms/internal/he$a:a	(Lcom/google/android/gms/internal/he$a;Landroid/os/IBinder;)Landroid/os/IBinder;
        //   21: pop
        //   22: aload_0
        //   23: getfield 15	com/google/android/gms/internal/he$a$a:GC	Lcom/google/android/gms/internal/he$a;
        //   26: aload_1
        //   27: invokestatic 35	com/google/android/gms/internal/he$a:a	(Lcom/google/android/gms/internal/he$a;Landroid/content/ComponentName;)Landroid/content/ComponentName;
        //   30: pop
        //   31: aload_0
        //   32: getfield 15	com/google/android/gms/internal/he$a$a:GC	Lcom/google/android/gms/internal/he$a;
        //   35: invokestatic 38	com/google/android/gms/internal/he$a:a	(Lcom/google/android/gms/internal/he$a;)Ljava/util/HashSet;
        //   38: invokevirtual 44	java/util/HashSet:iterator	()Ljava/util/Iterator;
        //   41: astore_3
        //   42: aload_3
        //   43: invokeinterface 50 1 0
        //   48: ifeq +24 -> 72
        //   51: aload_3
        //   52: invokeinterface 54 1 0
        //   57: checkcast 56	com/google/android/gms/internal/hc$f
        //   60: aload_1
        //   61: invokevirtual 65	com/google/android/gms/internal/hc$f:onServiceDisconnected	(Landroid/content/ComponentName;)V
        //   64: goto -22 -> 42
        //   67: astore_3
        //   68: aload_2
        //   69: monitorexit
        //   70: aload_3
        //   71: athrow
        //   72: aload_0
        //   73: getfield 15	com/google/android/gms/internal/he$a$a:GC	Lcom/google/android/gms/internal/he$a;
        //   76: iconst_2
        //   77: invokestatic 61	com/google/android/gms/internal/he$a:a	(Lcom/google/android/gms/internal/he$a;I)I
        //   80: pop
        //   81: aload_2
        //   82: monitorexit
        //   83: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramComponentName	ComponentName
        //   10	72	2	localHashMap	HashMap
        //   41	11	3	localIterator	java.util.Iterator
        //   67	4	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   13	70	67	finally
        //   72	83	67	finally
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.he
 * JD-Core Version:    0.7.0.1
 */