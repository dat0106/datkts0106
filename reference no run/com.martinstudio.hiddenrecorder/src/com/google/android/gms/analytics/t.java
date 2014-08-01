package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.fe;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class t
  extends Thread
  implements f
{
  private static t uL;
  private volatile boolean mClosed = false;
  private final Context mContext;
  private final LinkedBlockingQueue<Runnable> uH = new LinkedBlockingQueue();
  private volatile boolean uI = false;
  private volatile List<fe> uJ;
  private volatile String uK;
  private volatile ag uM;
  
  private t(Context paramContext)
  {
    super("GAThread");
    if (paramContext == null) {
      this.mContext = paramContext;
    } else {
      this.mContext = paramContext.getApplicationContext();
    }
    start();
  }
  
  static int O(String paramString)
  {
    int i = 1;
    if (!TextUtils.isEmpty(paramString))
    {
      j = -1 + paramString.length();
      i = 0;
    }
    for (int j = j;; j--)
    {
      if (j < 0) {
        return i;
      }
      int k = paramString.charAt(j);
      i = k + (0xFFFFFFF & i << 6) + (k << 14);
      k = 0xFE00000 & i;
      if (k != 0) {
        i ^= k >> 21;
      }
    }
  }
  
  private String a(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  private String q(Map<String, String> paramMap)
  {
    String str;
    if (!paramMap.containsKey("useSecure")) {
      str = "https:";
    } else if (!ak.d((String)paramMap.get("useSecure"), true)) {
      str = "http:";
    } else {
      str = "https:";
    }
    return str;
  }
  
  private boolean r(Map<String, String> paramMap)
  {
    boolean bool;
    if (paramMap.get("&sf") != null)
    {
      double d = ak.a((String)paramMap.get("&sf"), 100.0D);
      if (d < 100.0D)
      {
        if (O((String)paramMap.get("&cid")) % 10000 < d * 100.0D)
        {
          int i = 0;
        }
        else
        {
          String str;
          if (paramMap.get("&t") != null) {
            str = (String)paramMap.get("&t");
          } else {
            str = "unknown";
          }
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = str;
          aa.C(String.format("%s hit sampled out", arrayOfObject));
          bool = true;
        }
      }
      else {
        bool = false;
      }
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  private void s(Map<String, String> paramMap)
  {
    m localm = a.p(this.mContext);
    ak.a(paramMap, "&adid", localm.getValue("&adid"));
    ak.a(paramMap, "&ate", localm.getValue("&ate"));
  }
  
  private void t(Map<String, String> paramMap)
  {
    g localg = g.cp();
    ak.a(paramMap, "&an", localg.getValue("&an"));
    ak.a(paramMap, "&av", localg.getValue("&av"));
    ak.a(paramMap, "&aid", localg.getValue("&aid"));
    ak.a(paramMap, "&aiid", localg.getValue("&aiid"));
    paramMap.put("&v", "1");
  }
  
  static t u(Context paramContext)
  {
    if (uL == null) {
      uL = new t(paramContext);
    }
    return uL;
  }
  
  static String v(Context paramContext)
  {
    Object localObject1 = null;
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput("gaInstallData");
      localObject2 = new byte[8192];
      i = localFileInputStream.read((byte[])localObject2, 0, 8192);
      if (localFileInputStream.available() > 0)
      {
        aa.A("Too much campaign data, ignoring it.");
        localFileInputStream.close();
        paramContext.deleteFile("gaInstallData");
      }
      else
      {
        localFileInputStream.close();
        paramContext.deleteFile("gaInstallData");
        if (i <= 0) {
          aa.D("Campaign file is empty.");
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      int i;
      aa.B("No campaign data found.");
      return localObject1;
      Object localObject2 = new String((byte[])localObject2, 0, i);
      aa.B("Campaign found: " + (String)localObject2);
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      aa.A("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
    }
    return localObject1;
  }
  
  void a(Runnable paramRunnable)
  {
    this.uH.add(paramRunnable);
  }
  
  public void cg()
  {
    a(new Runnable()
    {
      public void run()
      {
        t.d(t.this).cg();
      }
    });
  }
  
  public void cl()
  {
    a(new Runnable()
    {
      public void run()
      {
        t.d(t.this).cl();
      }
    });
  }
  
  public void cn()
  {
    a(new Runnable()
    {
      public void run()
      {
        t.d(t.this).cn();
      }
    });
  }
  
  public LinkedBlockingQueue<Runnable> co()
  {
    return this.uH;
  }
  
  public Thread getThread()
  {
    return this;
  }
  
  protected void init()
  {
    this.uM.cG();
    this.uJ = new ArrayList();
    this.uJ.add(new fe("appendVersion", "&_v".substring(1), "ma4.0.2"));
    this.uJ.add(new fe("appendQueueTime", "&qt".substring(1), null));
    this.uJ.add(new fe("appendCacheBuster", "&z".substring(1), null));
  }
  
  public void p(Map<String, String> paramMap)
  {
    final HashMap localHashMap = new HashMap(paramMap);
    String str = (String)paramMap.get("&ht");
    if (str != null) {}
    try
    {
      Long.valueOf(str);
      if (str == null) {
        localHashMap.put("&ht", Long.toString(System.currentTimeMillis()));
      }
      a(new Runnable()
      {
        public void run()
        {
          t.a(t.this, localHashMap);
          if (TextUtils.isEmpty((CharSequence)localHashMap.get("&cid"))) {
            localHashMap.put("&cid", h.cq().getValue("&cid"));
          }
          if ((!GoogleAnalytics.getInstance(t.a(t.this)).getAppOptOut()) && (!t.b(t.this, localHashMap)))
          {
            if (!TextUtils.isEmpty(t.b(t.this)))
            {
              u.cP().u(true);
              localHashMap.putAll(new HitBuilders.HitBuilder().setCampaignParamsFromUrl(t.b(t.this)).build());
              u.cP().u(false);
              t.a(t.this, null);
            }
            t.c(t.this, localHashMap);
            Map localMap = y.u(localHashMap);
            t.d(t.this).b(localMap, Long.valueOf((String)localHashMap.get("&ht")).longValue(), t.d(t.this, localHashMap), t.c(t.this));
          }
        }
      });
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        str = null;
      }
    }
  }
  
  public void run()
  {
    Process.setThreadPriority(10);
    try
    {
      Thread.sleep(5000L);
    }
    catch (InterruptedException localInterruptedException2)
    {
      try
      {
        for (;;)
        {
          if (this.uM == null) {
            this.uM = new s(this.mContext, this);
          }
          init();
          this.uK = v(this.mContext);
          aa.C("Initialized GA Thread");
          while (!this.mClosed) {
            try
            {
              Runnable localRunnable = (Runnable)this.uH.take();
              if (!this.uI) {
                localRunnable.run();
              }
            }
            catch (InterruptedException localInterruptedException1)
            {
              aa.B(localInterruptedException1.toString());
            }
            catch (Throwable localThrowable1)
            {
              aa.A("Error on GAThread: " + a(localThrowable1));
              aa.A("Google Analytics is shutting down.");
              this.uI = true;
            }
          }
          localInterruptedException2;
          aa.D("sleep interrupted in GAThread initialize");
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          aa.A("Error initializing the GAThread: " + a(localThrowable2));
          aa.A("Google Analytics will not start up.");
          this.uI = true;
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.t
 * JD-Core Version:    0.7.0.1
 */