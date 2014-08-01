package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

class a
  implements m
{
  private static Object tn = new Object();
  private static a to;
  private Context mContext;
  private AdvertisingIdClient.Info tp;
  private long tq;
  private String tr;
  private boolean ts = false;
  private Object tt = new Object();
  
  a(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  static String H(String paramString)
  {
    MessageDigest localMessageDigest = ak.W("MD5");
    Object localObject;
    if (localMessageDigest != null)
    {
      localObject = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = new BigInteger(1, localMessageDigest.digest(paramString.getBytes()));
      localObject = String.format((Locale)localObject, "%032X", arrayOfObject);
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  private boolean I(String paramString)
  {
    boolean bool = false;
    try
    {
      String str = H(paramString);
      aa.C("Storing hashed adid.");
      FileOutputStream localFileOutputStream = this.mContext.openFileOutput("gaClientIdData", 0);
      localFileOutputStream.write(str.getBytes());
      localFileOutputStream.close();
      this.tr = str;
      bool = true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        aa.A("Error creating hash file.");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        aa.A("Error writing to hash file.");
      }
    }
    return bool;
  }
  
  /* Error */
  private boolean a(AdvertisingIdClient.Info paramInfo1, AdvertisingIdClient.Info paramInfo2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_2
    //   4: ifnonnull +20 -> 24
    //   7: aconst_null
    //   8: astore 4
    //   10: aload 4
    //   12: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +18 -> 33
    //   18: iconst_1
    //   19: istore 4
    //   21: iload 4
    //   23: ireturn
    //   24: aload_2
    //   25: invokevirtual 134	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:getId	()Ljava/lang/String;
    //   28: astore 4
    //   30: goto -20 -> 10
    //   33: aload_0
    //   34: getfield 41	com/google/android/gms/analytics/a:mContext	Landroid/content/Context;
    //   37: invokestatic 139	com/google/android/gms/analytics/h:r	(Landroid/content/Context;)V
    //   40: invokestatic 143	com/google/android/gms/analytics/h:cq	()Lcom/google/android/gms/analytics/h;
    //   43: astore 6
    //   45: aload 6
    //   47: ldc 145
    //   49: invokevirtual 148	com/google/android/gms/analytics/h:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 5
    //   54: aload_0
    //   55: getfield 33	com/google/android/gms/analytics/a:tt	Ljava/lang/Object;
    //   58: astore_3
    //   59: aload_3
    //   60: monitorenter
    //   61: aload_0
    //   62: getfield 31	com/google/android/gms/analytics/a:ts	Z
    //   65: ifne +67 -> 132
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 41	com/google/android/gms/analytics/a:mContext	Landroid/content/Context;
    //   73: invokestatic 152	com/google/android/gms/analytics/a:q	(Landroid/content/Context;)Ljava/lang/String;
    //   76: putfield 113	com/google/android/gms/analytics/a:tr	Ljava/lang/String;
    //   79: aload_0
    //   80: iconst_1
    //   81: putfield 31	com/google/android/gms/analytics/a:ts	Z
    //   84: new 154	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   91: aload 4
    //   93: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 5
    //   98: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 88	com/google/android/gms/analytics/a:H	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 7
    //   109: aload 7
    //   111: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifeq +107 -> 221
    //   117: iconst_0
    //   118: istore 4
    //   120: aload_3
    //   121: monitorexit
    //   122: goto -101 -> 21
    //   125: astore 4
    //   127: aload_3
    //   128: monitorexit
    //   129: aload 4
    //   131: athrow
    //   132: aload_0
    //   133: getfield 113	com/google/android/gms/analytics/a:tr	Ljava/lang/String;
    //   136: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifeq -55 -> 84
    //   142: aload_1
    //   143: ifnonnull +39 -> 182
    //   146: aload 7
    //   148: ifnonnull +43 -> 191
    //   151: aload_0
    //   152: new 154	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   159: aload 4
    //   161: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 5
    //   166: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokespecial 164	com/google/android/gms/analytics/a:I	(Ljava/lang/String;)Z
    //   175: istore 4
    //   177: aload_3
    //   178: monitorexit
    //   179: goto -158 -> 21
    //   182: aload_1
    //   183: invokevirtual 134	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:getId	()Ljava/lang/String;
    //   186: astore 7
    //   188: goto -42 -> 146
    //   191: aload_0
    //   192: new 154	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   199: aload 7
    //   201: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 5
    //   206: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 88	com/google/android/gms/analytics/a:H	(Ljava/lang/String;)Ljava/lang/String;
    //   215: putfield 113	com/google/android/gms/analytics/a:tr	Ljava/lang/String;
    //   218: goto -134 -> 84
    //   221: aload 7
    //   223: aload_0
    //   224: getfield 113	com/google/android/gms/analytics/a:tr	Ljava/lang/String;
    //   227: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   230: ifeq +11 -> 241
    //   233: aload_3
    //   234: monitorexit
    //   235: iconst_1
    //   236: istore 4
    //   238: goto -217 -> 21
    //   241: aload_0
    //   242: getfield 113	com/google/android/gms/analytics/a:tr	Ljava/lang/String;
    //   245: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   248: ifne +69 -> 317
    //   251: ldc 170
    //   253: invokestatic 96	com/google/android/gms/analytics/aa:C	(Ljava/lang/String;)V
    //   256: aload 6
    //   258: invokevirtual 173	com/google/android/gms/analytics/h:cr	()Ljava/lang/String;
    //   261: astore 5
    //   263: new 154	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   270: ldc 175
    //   272: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload 5
    //   277: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 96	com/google/android/gms/analytics/aa:C	(Ljava/lang/String;)V
    //   286: aload_0
    //   287: new 154	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   294: aload 4
    //   296: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 5
    //   301: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokespecial 164	com/google/android/gms/analytics/a:I	(Ljava/lang/String;)Z
    //   310: istore 4
    //   312: aload_3
    //   313: monitorexit
    //   314: goto -293 -> 21
    //   317: aload 5
    //   319: astore 5
    //   321: goto -35 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	a
    //   0	324	1	paramInfo1	AdvertisingIdClient.Info
    //   0	324	2	paramInfo2	AdvertisingIdClient.Info
    //   58	255	3	localObject	Object
    //   8	3	4	localCharSequence	java.lang.CharSequence
    //   19	3	4	bool1	boolean
    //   28	64	4	str1	String
    //   118	1	4	i	int
    //   125	35	4	str2	String
    //   175	136	4	bool2	boolean
    //   52	268	5	str3	String
    //   43	214	6	localh	h
    //   1	221	7	str4	String
    // Exception table:
    //   from	to	target	type
    //   61	129	125	finally
    //   132	314	125	finally
  }
  
  public static m p(Context paramContext)
  {
    if (to == null) {}
    synchronized (tn)
    {
      if (to == null) {
        to = new a(paramContext);
      }
      return to;
    }
  }
  
  /* Error */
  static String q(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ldc 98
    //   5: invokevirtual 185	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   8: astore_1
    //   9: sipush 128
    //   12: newarray byte
    //   14: astore 4
    //   16: aload_1
    //   17: aload 4
    //   19: iconst_0
    //   20: sipush 128
    //   23: invokevirtual 191	java/io/FileInputStream:read	([BII)I
    //   26: istore_2
    //   27: aload_1
    //   28: invokevirtual 195	java/io/FileInputStream:available	()I
    //   31: ifle +22 -> 53
    //   34: ldc 197
    //   36: invokestatic 200	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   39: aload_1
    //   40: invokevirtual 201	java/io/FileInputStream:close	()V
    //   43: aload_0
    //   44: ldc 98
    //   46: invokevirtual 204	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   49: pop
    //   50: goto +65 -> 115
    //   53: iload_2
    //   54: ifgt +15 -> 69
    //   57: ldc 206
    //   59: invokestatic 209	com/google/android/gms/analytics/aa:B	(Ljava/lang/String;)V
    //   62: aload_1
    //   63: invokevirtual 201	java/io/FileInputStream:close	()V
    //   66: goto +49 -> 115
    //   69: new 61	java/lang/String
    //   72: dup
    //   73: aload 4
    //   75: iconst_0
    //   76: iload_2
    //   77: invokespecial 212	java/lang/String:<init>	([BII)V
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual 201	java/io/FileInputStream:close	()V
    //   85: aload_2
    //   86: astore_3
    //   87: goto +28 -> 115
    //   90: pop
    //   91: ldc 214
    //   93: invokestatic 200	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: ldc 98
    //   99: invokevirtual 204	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   102: pop
    //   103: goto +12 -> 115
    //   106: pop
    //   107: aload_2
    //   108: astore_3
    //   109: goto -18 -> 91
    //   112: pop
    //   113: aload_2
    //   114: astore_3
    //   115: aload_3
    //   116: areturn
    //   117: pop
    //   118: goto -3 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramContext	Context
    //   8	74	1	localFileInputStream	java.io.FileInputStream
    //   26	51	2	i	int
    //   80	34	2	str	String
    //   1	115	3	localObject	Object
    //   14	60	4	arrayOfByte	byte[]
    //   90	1	6	localIOException1	IOException
    //   106	1	7	localIOException2	IOException
    //   112	1	8	localFileNotFoundException1	FileNotFoundException
    //   117	1	9	localFileNotFoundException2	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   2	81	90	java/io/IOException
    //   81	85	106	java/io/IOException
    //   81	85	112	java/io/FileNotFoundException
    //   2	81	117	java/io/FileNotFoundException
  }
  
  AdvertisingIdClient.Info cf()
  {
    AdvertisingIdClient.Info localInfo = null;
    try
    {
      localInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
      localInfo = localInfo;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        aa.D("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
      }
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      for (;;)
      {
        aa.D("GooglePlayServicesRepairableException getting Ad Id Info");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        aa.D("IOException getting Ad Id Info");
      }
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      for (;;)
      {
        aa.D("GooglePlayServicesNotAvailableException getting Ad Id Info");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        aa.D("Unknown exception. Could not get the ad Id.");
      }
    }
    return localInfo;
  }
  
  public String getValue(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.tq > 1000L)
    {
      AdvertisingIdClient.Info localInfo = cf();
      if (!a(this.tp, localInfo)) {
        this.tp = new AdvertisingIdClient.Info("", false);
      } else {
        this.tp = localInfo;
      }
      this.tq = l;
    }
    String str;
    if (this.tp != null)
    {
      if ("&adid".equals(paramString)) {
        break label121;
      }
      if ("&ate".equals(paramString)) {}
    }
    else
    {
      return null;
    }
    if (!this.tp.isLimitAdTrackingEnabled())
    {
      str = "1";
    }
    else
    {
      return "0";
      label121:
      str = this.tp.getId();
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.a
 * JD-Core Version:    0.7.0.1
 */