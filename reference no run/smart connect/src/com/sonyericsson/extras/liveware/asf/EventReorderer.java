package com.sonyericsson.extras.liveware.asf;

import android.content.Intent;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EventReorderer
{
  private static final long COLLECTION_WINDOW_TIME = 1000L;
  private static final int HIGHEST_PRIORITY = 1;
  private static final int NO_PRIORITY = 0;
  public static final long UNDEFINED_TIME = -1L;
  private static EventReorderer sInstance;
  private Comparator<Intent> mComparator = new PriorityComparator(this);
  private List<Intent> mIntents = new LinkedList();
  private final Map<String, Integer> mPriority = new HashMap();
  private long mReleaseTime;
  
  private EventReorderer()
  {
    this.mPriority.put("com.sonyericsson.hardware.action.APPLICATION_BUTTON", Integer.valueOf(0));
    this.mPriority.put("android.intent.action.HDMI_PLUGGED", Integer.valueOf(1));
    this.mPriority.put("android.intent.action.HEADSET_PLUG", Integer.valueOf(2));
    this.mPriority.put("com.sonyericsson.system.intent.action.HEADSET_PLUG", Integer.valueOf(2));
    this.mPriority.put("com.sonyericsson.hardware.action.USB_OTG_ACA_CONNECTED", Integer.valueOf(3));
    this.mPriority.put("com.sonyericsson.hardware.action.USB_OTG_ACA_DISCONNECTED", Integer.valueOf(3));
    this.mPriority.put("com.sonyericsson.hardware.action.USB_OTG_DEVICE_CONNECTED", Integer.valueOf(3));
    this.mPriority.put("com.sonyericsson.hardware.action.USB_OTG_DEVICE_DISCONNECTED", Integer.valueOf(3));
    this.mPriority.put("android.hardware.usb.action.USB_DEVICE_ATTACHED", Integer.valueOf(3));
    this.mPriority.put("android.hardware.usb.action.USB_DEVICE_DETACHED", Integer.valueOf(3));
    this.mPriority.put("android.intent.action.ACTION_POWER_CONNECTED", Integer.valueOf(4));
    this.mPriority.put("android.intent.action.ACTION_POWER_DISCONNECTED", Integer.valueOf(4));
    this.mPriority.put("com.sonymobile.smartconnect.DEVICE_CONFIGURED", Integer.valueOf(5));
    this.mPriority.put("android.intent.action.MEDIA_REMOVED", Integer.valueOf(6));
    this.mPriority.put("android.intent.action.MEDIA_MOUNTED", Integer.valueOf(6));
    this.mReleaseTime = -1L;
  }
  
  /**
   * @deprecated
   */
  public static EventReorderer getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new EventReorderer();
      }
      EventReorderer localEventReorderer = sInstance;
      return localEventReorderer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int getPriority(Intent paramIntent)
  {
    Integer localInteger = (Integer)this.mPriority.get(paramIntent.getAction());
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new IllegalArgumentException("Found unexpected action string not in priority list: " + paramIntent.getAction());
  }
  
  public static EventReorderer getTestInstance()
  {
    return new EventReorderer();
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public Intent getNextIntent()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 145	android/os/SystemClock:elapsedRealtime	()J
    //   5: aload_0
    //   6: getfield 94	com/sonyericsson/extras/liveware/asf/EventReorderer:mReleaseTime	J
    //   9: lcmp
    //   10: iflt +52 -> 62
    //   13: aload_0
    //   14: getfield 40	com/sonyericsson/extras/liveware/asf/EventReorderer:mIntents	Ljava/util/List;
    //   17: invokeinterface 150 1 0
    //   22: ifle +40 -> 62
    //   25: aload_0
    //   26: getfield 40	com/sonyericsson/extras/liveware/asf/EventReorderer:mIntents	Ljava/util/List;
    //   29: iconst_0
    //   30: invokeinterface 154 2 0
    //   35: checkcast 107	android/content/Intent
    //   38: astore_1
    //   39: aload_0
    //   40: getfield 40	com/sonyericsson/extras/liveware/asf/EventReorderer:mIntents	Ljava/util/List;
    //   43: invokeinterface 150 1 0
    //   48: ifne +10 -> 58
    //   51: aload_0
    //   52: ldc2_w 18
    //   55: putfield 94	com/sonyericsson/extras/liveware/asf/EventReorderer:mReleaseTime	J
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: areturn
    //   62: aconst_null
    //   63: astore_1
    //   64: goto -6 -> 58
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	EventReorderer
    //   38	26	1	localIntent	Intent
    //   67	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	58	67	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public long getWaitTime()
  {
    // Byte code:
    //   0: ldc2_w 18
    //   3: lstore 5
    //   5: aload_0
    //   6: monitorenter
    //   7: invokestatic 145	android/os/SystemClock:elapsedRealtime	()J
    //   10: lstore_1
    //   11: aload_0
    //   12: getfield 94	com/sonyericsson/extras/liveware/asf/EventReorderer:mReleaseTime	J
    //   15: lstore_3
    //   16: lload_3
    //   17: lload 5
    //   19: lcmp
    //   20: ifne +8 -> 28
    //   23: aload_0
    //   24: monitorexit
    //   25: lload 5
    //   27: lreturn
    //   28: aload_0
    //   29: getfield 94	com/sonyericsson/extras/liveware/asf/EventReorderer:mReleaseTime	J
    //   32: lstore_3
    //   33: lload_3
    //   34: lload_1
    //   35: lsub
    //   36: lstore 5
    //   38: lload 5
    //   40: ldc2_w 156
    //   43: lcmp
    //   44: ifge -21 -> 23
    //   47: ldc2_w 156
    //   50: lstore 5
    //   52: goto -29 -> 23
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	EventReorderer
    //   10	25	1	l1	long
    //   55	4	1	localObject	Object
    //   15	19	3	l2	long
    //   3	48	5	l3	long
    // Exception table:
    //   from	to	target	type
    //   7	16	55	finally
    //   28	33	55	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public boolean pushIntent(Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 45	com/sonyericsson/extras/liveware/asf/EventReorderer:mPriority	Ljava/util/Map;
    //   8: aload_1
    //   9: invokevirtual 111	android/content/Intent:getAction	()Ljava/lang/String;
    //   12: invokeinterface 115 2 0
    //   17: checkcast 54	java/lang/Integer
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +41 -> 63
    //   25: invokestatic 165	com/sonyericsson/extras/liveware/utils/Dbg:w	()Z
    //   28: ifeq +31 -> 59
    //   31: new 123	java/lang/StringBuilder
    //   34: dup
    //   35: ldc 167
    //   37: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_1
    //   41: invokevirtual 111	android/content/Intent:getAction	()Ljava/lang/String;
    //   44: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 169
    //   49: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 172	com/sonyericsson/extras/liveware/utils/Dbg:w	(Ljava/lang/String;)Z
    //   58: pop
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: ireturn
    //   63: aload_2
    //   64: invokevirtual 119	java/lang/Integer:intValue	()I
    //   67: ifeq -8 -> 59
    //   70: aload_0
    //   71: getfield 40	com/sonyericsson/extras/liveware/asf/EventReorderer:mIntents	Ljava/util/List;
    //   74: invokeinterface 150 1 0
    //   79: ifne +14 -> 93
    //   82: aload_0
    //   83: ldc2_w 10
    //   86: invokestatic 145	android/os/SystemClock:elapsedRealtime	()J
    //   89: ladd
    //   90: putfield 94	com/sonyericsson/extras/liveware/asf/EventReorderer:mReleaseTime	J
    //   93: aload_0
    //   94: getfield 40	com/sonyericsson/extras/liveware/asf/EventReorderer:mIntents	Ljava/util/List;
    //   97: aload_1
    //   98: invokeinterface 176 2 0
    //   103: pop
    //   104: aload_0
    //   105: getfield 40	com/sonyericsson/extras/liveware/asf/EventReorderer:mIntents	Ljava/util/List;
    //   108: aload_0
    //   109: getfield 50	com/sonyericsson/extras/liveware/asf/EventReorderer:mComparator	Ljava/util/Comparator;
    //   112: invokestatic 182	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   115: aload_0
    //   116: aload_1
    //   117: invokespecial 100	com/sonyericsson/extras/liveware/asf/EventReorderer:getPriority	(Landroid/content/Intent;)I
    //   120: iconst_1
    //   121: if_icmpne +10 -> 131
    //   124: aload_0
    //   125: ldc2_w 18
    //   128: putfield 94	com/sonyericsson/extras/liveware/asf/EventReorderer:mReleaseTime	J
    //   131: iconst_1
    //   132: istore_3
    //   133: goto -74 -> 59
    //   136: astore_2
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_2
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	EventReorderer
    //   0	141	1	paramIntent	Intent
    //   20	44	2	localInteger	Integer
    //   136	4	2	localObject	Object
    //   1	132	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	59	136	finally
    //   63	131	136	finally
  }
  
  private static class PriorityComparator
    implements Comparator<Intent>
  {
    private final EventReorderer mEventReorderer;
    
    public PriorityComparator(EventReorderer paramEventReorderer)
    {
      this.mEventReorderer = paramEventReorderer;
    }
    
    public int compare(Intent paramIntent1, Intent paramIntent2)
    {
      return this.mEventReorderer.getPriority(paramIntent1) - this.mEventReorderer.getPriority(paramIntent2);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.asf.EventReorderer
 * JD-Core Version:    0.7.0.1
 */