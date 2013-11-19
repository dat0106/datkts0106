package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

class GAThread
  extends Thread
  implements AnalyticsThread
{
  static final String API_VERSION = "1";
  private static final String CLIENT_VERSION = "ma1b4";
  private static final int MAX_SAMPLE_RATE = 100;
  private static final int SAMPLE_RATE_MODULO = 10000;
  private static final int SAMPLE_RATE_MULTIPLIER = 100;
  private static GAThread sInstance;
  private volatile boolean mAppOptOut;
  private volatile String mClientId;
  private volatile boolean mClosed = false;
  private volatile List<Command> mCommands;
  private final Context mContext;
  private volatile boolean mDisabled = false;
  private volatile String mInstallCampaign;
  private volatile MetaModel mMetaModel;
  private volatile ServiceProxy mServiceProxy;
  private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue();
  
  private GAThread(Context paramContext)
  {
    super("GAThread");
    if (paramContext == null) {
      this.mContext = paramContext;
    } else {
      this.mContext = paramContext.getApplicationContext();
    }
    start();
  }
  
  @VisibleForTesting
  GAThread(Context paramContext, ServiceProxy paramServiceProxy)
  {
    super("GAThread");
    if (paramContext == null) {
      this.mContext = paramContext;
    } else {
      this.mContext = paramContext.getApplicationContext();
    }
    this.mServiceProxy = paramServiceProxy;
    start();
  }
  
  private void fillAppParameters(Map<String, String> paramMap)
  {
    PackageManager localPackageManager = this.mContext.getPackageManager();
    String str4 = this.mContext.getPackageName();
    String str2 = localPackageManager.getInstallerPackageName(str4);
    String str1 = str4;
    String str3 = null;
    try
    {
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(this.mContext.getPackageName(), 0);
      if (localPackageInfo != null)
      {
        str1 = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo).toString();
        str3 = localPackageInfo.versionName;
      }
      putIfAbsent(paramMap, "appName", str1);
      putIfAbsent(paramMap, "appVersion", str3);
      putIfAbsent(paramMap, "appId", str4);
      putIfAbsent(paramMap, "appInstallerId", str2);
      paramMap.put("apiVersion", "1");
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Log.e("Error retrieving package info: appName set to " + str1);
      }
    }
  }
  
  private void fillCampaignParameters(Map<String, String> paramMap)
  {
    Object localObject = Utils.filterCampaign((String)paramMap.get("campaign"));
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = Utils.parseURLParameters((String)localObject);
      paramMap.put("campaignContent", ((Map)localObject).get("utm_content"));
      paramMap.put("campaignMedium", ((Map)localObject).get("utm_medium"));
      paramMap.put("campaignName", ((Map)localObject).get("utm_campaign"));
      paramMap.put("campaignSource", ((Map)localObject).get("utm_source"));
      paramMap.put("campaignKeyword", ((Map)localObject).get("utm_term"));
      paramMap.put("campaignId", ((Map)localObject).get("utm_id"));
      paramMap.put("gclid", ((Map)localObject).get("gclid"));
      paramMap.put("dclid", ((Map)localObject).get("dclid"));
      paramMap.put("gmob_t", ((Map)localObject).get("gmob_t"));
    }
  }
  
  private void fillExceptionParameters(Map<String, String> paramMap)
  {
    Object localObject1 = (String)paramMap.get("rawException");
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      paramMap.remove("rawException");
      localObject1 = new ByteArrayInputStream(Utils.hexDecode((String)localObject1));
      try
      {
        Object localObject2 = new ObjectInputStream((InputStream)localObject1);
        localObject1 = ((ObjectInputStream)localObject2).readObject();
        ((ObjectInputStream)localObject2).close();
        if ((localObject1 instanceof Throwable))
        {
          localObject2 = (Throwable)localObject1;
          localObject1 = new ArrayList();
          paramMap.put("exDescription", new StandardExceptionParser(this.mContext, (Collection)localObject1).getDescription((String)paramMap.get("exceptionThreadName"), (Throwable)localObject2));
        }
      }
      catch (IOException localIOException)
      {
        Log.w("IOException reading exception");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.w("ClassNotFoundException reading exception");
      }
    }
  }
  
  private String generateClientId()
  {
    String str = UUID.randomUUID().toString().toLowerCase();
    if (!storeClientId(str)) {
      str = "0";
    }
    return str;
  }
  
  @VisibleForTesting
  static String getAndClearCampaign(Context paramContext)
  {
    String str;
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput("gaInstallData");
      byte[] arrayOfByte = new byte[8192];
      int i = localFileInputStream.read(arrayOfByte, 0, 8192);
      if (localFileInputStream.available() > 0)
      {
        Log.e("Too much campaign data, ignoring it.");
        localFileInputStream.close();
        paramContext.deleteFile("gaInstallData");
        str = null;
      }
      else
      {
        localFileInputStream.close();
        paramContext.deleteFile("gaInstallData");
        if (str <= 0)
        {
          Log.w("Campaign file is empty.");
          str = null;
        }
        else
        {
          str = new String(arrayOfByte, 0, str);
          Log.i("Campaign found: " + str);
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.i("No campaign data found.");
      str = null;
    }
    catch (IOException localIOException)
    {
      Log.e("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
      str = null;
    }
    return str;
  }
  
  private String getHostUrl(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("internalHitUrl");
    if (str == null) {
      if (!paramMap.containsKey("useSecure")) {
        str = "https://ssl.google-analytics.com/collect";
      } else if (!Utils.safeParseBoolean((String)paramMap.get("useSecure"))) {
        str = "http://www.google-analytics.com/collect";
      } else {
        str = "https://ssl.google-analytics.com/collect";
      }
    }
    return str;
  }
  
  static GAThread getInstance(Context paramContext)
  {
    if (sInstance == null) {
      sInstance = new GAThread(paramContext);
    }
    return sInstance;
  }
  
  private void init()
  {
    this.mServiceProxy.createService();
    this.mCommands = new ArrayList();
    this.mCommands.add(new Command("appendVersion", "_v", "ma1b4"));
    this.mCommands.add(new Command("appendQueueTime", "qt", null));
    this.mCommands.add(new Command("appendCacheBuster", "z", null));
    this.mMetaModel = new MetaModel();
    MetaModelInitializer.set(this.mMetaModel);
  }
  
  private boolean isSampledOut(Map<String, String> paramMap)
  {
    if (paramMap.get("sampleRate") != null)
    {
      double d = Utils.safeParseDouble((String)paramMap.get("sampleRate"));
      if (d <= 0.0D) {
        break label95;
      }
      if (d < 100.0D)
      {
        String str = (String)paramMap.get("clientId");
        if ((str != null) && (Math.abs(str.hashCode()) % 10000 >= 100.0D * d)) {
          break label90;
        }
      }
    }
    boolean bool = false;
    return bool;
    label90:
    return true;
    label95:
    bool = true;
    return bool;
  }
  
  private boolean loadAppOptOut()
  {
    return this.mContext.getFileStreamPath("gaOptOut").exists();
  }
  
  private String printStackTrace(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  private void putIfAbsent(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (!paramMap.containsKey(paramString1)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  private void queueToThread(Runnable paramRunnable)
  {
    this.queue.add(paramRunnable);
  }
  
  private boolean storeClientId(String paramString)
  {
    boolean bool = false;
    try
    {
      FileOutputStream localFileOutputStream = this.mContext.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      bool = true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        Log.e("Error creating clientId file.");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("Error writing to clientId file.");
      }
    }
    return bool;
  }
  
  @VisibleForTesting
  void close()
  {
    this.mClosed = true;
    interrupt();
  }
  
  public void dispatch()
  {
    queueToThread(new Runnable()
    {
      public void run()
      {
        GAThread.this.mServiceProxy.dispatch();
      }
    });
  }
  
  public LinkedBlockingQueue<Runnable> getQueue()
  {
    return this.queue;
  }
  
  public Thread getThread()
  {
    return this;
  }
  
  /* Error */
  @VisibleForTesting
  String initializeClientId()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 69	com/google/analytics/tracking/android/GAThread:mContext	Landroid/content/Context;
    //   6: ldc_w 494
    //   9: invokevirtual 346	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   12: astore_1
    //   13: sipush 128
    //   16: newarray byte
    //   18: astore 4
    //   20: aload_1
    //   21: aload 4
    //   23: iconst_0
    //   24: sipush 128
    //   27: invokevirtual 352	java/io/FileInputStream:read	([BII)I
    //   30: istore_2
    //   31: aload_1
    //   32: invokevirtual 356	java/io/FileInputStream:available	()I
    //   35: ifle +25 -> 60
    //   38: ldc_w 529
    //   41: invokestatic 209	com/google/analytics/tracking/android/Log:e	(Ljava/lang/String;)I
    //   44: pop
    //   45: aload_1
    //   46: invokevirtual 359	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: getfield 69	com/google/analytics/tracking/android/GAThread:mContext	Landroid/content/Context;
    //   53: ldc_w 342
    //   56: invokevirtual 362	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   59: pop
    //   60: iload_2
    //   61: ifgt +36 -> 97
    //   64: ldc_w 531
    //   67: invokestatic 209	com/google/analytics/tracking/android/Log:e	(Ljava/lang/String;)I
    //   70: pop
    //   71: aload_1
    //   72: invokevirtual 359	java/io/FileInputStream:close	()V
    //   75: aload_0
    //   76: getfield 69	com/google/analytics/tracking/android/GAThread:mContext	Landroid/content/Context;
    //   79: ldc_w 342
    //   82: invokevirtual 362	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   85: pop
    //   86: aload_3
    //   87: ifnonnull +8 -> 95
    //   90: aload_0
    //   91: invokespecial 533	com/google/analytics/tracking/android/GAThread:generateClientId	()Ljava/lang/String;
    //   94: astore_3
    //   95: aload_3
    //   96: areturn
    //   97: new 217	java/lang/String
    //   100: dup
    //   101: aload 4
    //   103: iconst_0
    //   104: iload_2
    //   105: invokespecial 367	java/lang/String:<init>	([BII)V
    //   108: astore_2
    //   109: aload_1
    //   110: invokevirtual 359	java/io/FileInputStream:close	()V
    //   113: aload_2
    //   114: astore_3
    //   115: goto -29 -> 86
    //   118: pop
    //   119: ldc_w 535
    //   122: invokestatic 209	com/google/analytics/tracking/android/Log:e	(Ljava/lang/String;)I
    //   125: pop
    //   126: aload_0
    //   127: getfield 69	com/google/analytics/tracking/android/GAThread:mContext	Landroid/content/Context;
    //   130: ldc_w 342
    //   133: invokevirtual 362	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   136: pop
    //   137: goto -51 -> 86
    //   140: pop
    //   141: ldc_w 537
    //   144: invokestatic 209	com/google/analytics/tracking/android/Log:e	(Ljava/lang/String;)I
    //   147: pop
    //   148: aload_0
    //   149: getfield 69	com/google/analytics/tracking/android/GAThread:mContext	Landroid/content/Context;
    //   152: ldc_w 342
    //   155: invokevirtual 362	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   158: pop
    //   159: goto -73 -> 86
    //   162: pop
    //   163: aload_2
    //   164: astore_3
    //   165: goto -24 -> 141
    //   168: pop
    //   169: aload_2
    //   170: astore_3
    //   171: goto -52 -> 119
    //   174: pop
    //   175: goto -89 -> 86
    //   178: pop
    //   179: aload_2
    //   180: astore_3
    //   181: goto -95 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	GAThread
    //   12	98	1	localFileInputStream	FileInputStream
    //   30	75	2	i	int
    //   108	72	2	str	String
    //   1	180	3	localObject	Object
    //   18	84	4	arrayOfByte	byte[]
    //   118	1	6	localIOException1	IOException
    //   140	1	7	localNumberFormatException1	java.lang.NumberFormatException
    //   162	1	8	localNumberFormatException2	java.lang.NumberFormatException
    //   168	1	9	localIOException2	IOException
    //   174	1	10	localFileNotFoundException1	FileNotFoundException
    //   178	1	11	localFileNotFoundException2	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   2	86	118	java/io/IOException
    //   97	109	118	java/io/IOException
    //   2	86	140	java/lang/NumberFormatException
    //   97	109	140	java/lang/NumberFormatException
    //   109	113	162	java/lang/NumberFormatException
    //   109	113	168	java/io/IOException
    //   2	86	174	java/io/FileNotFoundException
    //   97	109	174	java/io/FileNotFoundException
    //   109	113	178	java/io/FileNotFoundException
  }
  
  @VisibleForTesting
  boolean isDisabled()
  {
    return this.mDisabled;
  }
  
  public void requestAppOptOut(final GoogleAnalytics.AppOptOutCallback paramAppOptOutCallback)
  {
    queueToThread(new Runnable()
    {
      public void run()
      {
        paramAppOptOutCallback.reportAppOptOut(GAThread.this.mAppOptOut);
      }
    });
  }
  
  public void requestClientId(final AnalyticsThread.ClientIdCallback paramClientIdCallback)
  {
    queueToThread(new Runnable()
    {
      public void run()
      {
        paramClientIdCallback.reportClientId(GAThread.this.mClientId);
      }
    });
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      if (this.mServiceProxy == null) {
        this.mServiceProxy = new GAServiceProxy(this.mContext, this);
      }
      init();
    }
    catch (InterruptedException localInterruptedException2)
    {
      try
      {
        this.mAppOptOut = loadAppOptOut();
        this.mClientId = initializeClientId();
        this.mInstallCampaign = getAndClearCampaign(this.mContext);
        while (!this.mClosed)
        {
          try
          {
            Runnable localRunnable = (Runnable)this.queue.take();
            if (this.mDisabled) {
              continue;
            }
            localRunnable.run();
          }
          catch (InterruptedException localInterruptedException1)
          {
            Log.i(localInterruptedException1.toString());
          }
          catch (Throwable localThrowable1)
          {
            Log.e("Error on GAThread: " + printStackTrace(localThrowable1));
            Log.e("Google Analytics is shutting down.");
            this.mDisabled = true;
          }
          continue;
          localInterruptedException2;
          Log.w("sleep interrupted in GAThread initialize");
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Log.e("Error initializing the GAThread: " + printStackTrace(localThrowable2));
          Log.e("Google Analytics will not start up.");
          this.mDisabled = true;
        }
      }
    }
  }
  
  public void sendHit(Map<String, String> paramMap)
  {
    final HashMap localHashMap = new HashMap(paramMap);
    final long l = System.currentTimeMillis();
    localHashMap.put("hitTime", Long.toString(l));
    queueToThread(new Runnable()
    {
      public void run()
      {
        localHashMap.put("clientId", GAThread.this.mClientId);
        if ((!GAThread.this.mAppOptOut) && (!GAThread.this.isSampledOut(localHashMap)))
        {
          if (!TextUtils.isEmpty(GAThread.this.mInstallCampaign))
          {
            localHashMap.put("campaign", GAThread.this.mInstallCampaign);
            GAThread.access$302(GAThread.this, null);
          }
          GAThread.this.fillAppParameters(localHashMap);
          GAThread.this.fillCampaignParameters(localHashMap);
          GAThread.this.fillExceptionParameters(localHashMap);
          Map localMap = HitBuilder.generateHitParams(GAThread.this.mMetaModel, localHashMap);
          GAThread.this.mServiceProxy.putHit(localMap, l, GAThread.this.getHostUrl(localHashMap), GAThread.this.mCommands);
        }
      }
    });
  }
  
  public void setAppOptOut(final boolean paramBoolean)
  {
    queueToThread(new Runnable()
    {
      public void run()
      {
        if (GAThread.this.mAppOptOut == paramBoolean) {
          return;
        }
        File localFile;
        if (paramBoolean) {
          localFile = GAThread.this.mContext.getFileStreamPath("gaOptOut");
        }
        for (;;)
        {
          try
          {
            localFile.createNewFile();
            GAThread.this.mServiceProxy.clearHits();
            GAThread.access$102(GAThread.this, paramBoolean);
          }
          catch (IOException localIOException)
          {
            Log.w("Error creating optOut file.");
            continue;
          }
          GAThread.this.mContext.deleteFile("gaOptOut");
        }
      }
    });
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.GAThread
 * JD-Core Version:    0.7.0.1
 */