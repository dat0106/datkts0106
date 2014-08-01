package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import org.json.JSONException;

public class do
  extends en
  implements dq.a, ez.a
{
  private final bu kz;
  private final ey lL;
  private final Object lq = new Object();
  private final Context mContext;
  private bn nd;
  private dv pA;
  private boolean pB = false;
  private bl pC;
  private br pD;
  private final dn.a pv;
  private final Object pw = new Object();
  private final dt.a px;
  private final l py;
  private en pz;
  
  public do(Context paramContext, dt.a parama, l paraml, ey paramey, bu parambu, dn.a parama1)
  {
    this.kz = parambu;
    this.pv = parama1;
    this.lL = paramey;
    this.mContext = paramContext;
    this.px = parama;
    this.py = paraml;
  }
  
  private am a(dt paramdt)
    throws do.a
  {
    if (this.pA.qg == null) {
      throw new a("The ad response must specify one of the supported ad sizes.", 0);
    }
    String[] arrayOfString = this.pA.qg.split("x");
    if (arrayOfString.length != 2) {
      throw new a("Could not parse the ad size from the ad response: " + this.pA.qg, 0);
    }
    for (;;)
    {
      int m;
      am localam;
      try
      {
        int i = Integer.parseInt(arrayOfString[0]);
        int j = Integer.parseInt(arrayOfString[1]);
        am[] arrayOfam = paramdt.kR.me;
        int k = arrayOfam.length;
        m = 0;
        if (m >= k) {
          break;
        }
        localam = arrayOfam[m];
        float f = this.mContext.getResources().getDisplayMetrics().density;
        if (localam.width == -1)
        {
          n = (int)(localam.widthPixels / f);
          if (localam.height != -2) {
            break label252;
          }
          i1 = (int)(localam.heightPixels / f);
          if ((i != n) || (j != i1)) {
            break label262;
          }
          return new am(localam, paramdt.kR.me);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new a("Could not parse the ad size from the ad response: " + this.pA.qg, 0);
      }
      int n = localam.width;
      continue;
      label252:
      int i1 = localam.height;
      continue;
      label262:
      m++;
    }
    throw new a("The ad size from the ad response was not one of the requested sizes: " + this.pA.qg, 0);
  }
  
  private void a(dt paramdt, long paramLong)
    throws do.a
  {
    synchronized (this.pw)
    {
      this.pC = new bl(this.mContext, paramdt, this.kz, this.nd);
      this.pD = this.pC.a(paramLong, 60000L);
      switch (this.pD.nJ)
      {
      default: 
        throw new a("Unexpected mediation result: " + this.pD.nJ, 0);
      }
    }
    throw new a("No fill from any mediation ad networks.", 3);
  }
  
  private void bi()
    throws do.a
  {
    if (this.pA.errorCode == -3) {}
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(this.pA.qb)) {
        throw new a("No fill from ad server.", 3);
      }
      if (!this.pA.qd) {
        continue;
      }
      try
      {
        this.nd = new bn(this.pA.qb);
      }
      catch (JSONException localJSONException)
      {
        throw new a("Could not parse mediation config: " + this.pA.qb, 0);
      }
    }
  }
  
  private boolean c(long paramLong)
    throws do.a
  {
    long l = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    boolean bool;
    if (l <= 0L) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        this.lq.wait(bool);
        bool = true;
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new a("Ad request cancelled.", -1);
      }
    }
  }
  
  private void e(long paramLong)
    throws do.a
  {
    eu.ss.post(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 17	com/google/android/gms/internal/do$3:pE	Lcom/google/android/gms/internal/do;
        //   4: invokestatic 25	com/google/android/gms/internal/do:a	(Lcom/google/android/gms/internal/do;)Ljava/lang/Object;
        //   7: astore_1
        //   8: aload_1
        //   9: monitorenter
        //   10: aload_0
        //   11: getfield 17	com/google/android/gms/internal/do$3:pE	Lcom/google/android/gms/internal/do;
        //   14: invokestatic 29	com/google/android/gms/internal/do:c	(Lcom/google/android/gms/internal/do;)Lcom/google/android/gms/internal/dv;
        //   17: getfield 35	com/google/android/gms/internal/dv:errorCode	I
        //   20: bipush 254
        //   22: if_icmpeq +8 -> 30
        //   25: aload_1
        //   26: monitorexit
        //   27: goto +142 -> 169
        //   30: aload_0
        //   31: getfield 17	com/google/android/gms/internal/do$3:pE	Lcom/google/android/gms/internal/do;
        //   34: invokestatic 39	com/google/android/gms/internal/do:d	(Lcom/google/android/gms/internal/do;)Lcom/google/android/gms/internal/ey;
        //   37: invokevirtual 45	com/google/android/gms/internal/ey:bW	()Lcom/google/android/gms/internal/ez;
        //   40: aload_0
        //   41: getfield 17	com/google/android/gms/internal/do$3:pE	Lcom/google/android/gms/internal/do;
        //   44: invokevirtual 50	com/google/android/gms/internal/ez:a	(Lcom/google/android/gms/internal/ez$a;)V
        //   47: aload_0
        //   48: getfield 17	com/google/android/gms/internal/do$3:pE	Lcom/google/android/gms/internal/do;
        //   51: invokestatic 29	com/google/android/gms/internal/do:c	(Lcom/google/android/gms/internal/do;)Lcom/google/android/gms/internal/dv;
        //   54: getfield 35	com/google/android/gms/internal/dv:errorCode	I
        //   57: bipush 253
        //   59: if_icmpne +64 -> 123
        //   62: new 52	java/lang/StringBuilder
        //   65: dup
        //   66: invokespecial 53	java/lang/StringBuilder:<init>	()V
        //   69: ldc 55
        //   71: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   74: aload_0
        //   75: getfield 17	com/google/android/gms/internal/do$3:pE	Lcom/google/android/gms/internal/do;
        //   78: invokestatic 29	com/google/android/gms/internal/do:c	(Lcom/google/android/gms/internal/do;)Lcom/google/android/gms/internal/dv;
        //   81: getfield 63	com/google/android/gms/internal/dv:oy	Ljava/lang/String;
        //   84: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   87: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   90: invokestatic 73	com/google/android/gms/internal/ev:C	(Ljava/lang/String;)V
        //   93: aload_0
        //   94: getfield 17	com/google/android/gms/internal/do$3:pE	Lcom/google/android/gms/internal/do;
        //   97: invokestatic 39	com/google/android/gms/internal/do:d	(Lcom/google/android/gms/internal/do;)Lcom/google/android/gms/internal/ey;
        //   100: aload_0
        //   101: getfield 17	com/google/android/gms/internal/do$3:pE	Lcom/google/android/gms/internal/do;
        //   104: invokestatic 29	com/google/android/gms/internal/do:c	(Lcom/google/android/gms/internal/do;)Lcom/google/android/gms/internal/dv;
        //   107: getfield 63	com/google/android/gms/internal/dv:oy	Ljava/lang/String;
        //   110: invokevirtual 76	com/google/android/gms/internal/ey:loadUrl	(Ljava/lang/String;)V
        //   113: aload_1
        //   114: monitorexit
        //   115: goto +54 -> 169
        //   118: astore_2
        //   119: aload_1
        //   120: monitorexit
        //   121: aload_2
        //   122: athrow
        //   123: ldc 78
        //   125: invokestatic 73	com/google/android/gms/internal/ev:C	(Ljava/lang/String;)V
        //   128: aload_0
        //   129: getfield 17	com/google/android/gms/internal/do$3:pE	Lcom/google/android/gms/internal/do;
        //   132: invokestatic 39	com/google/android/gms/internal/do:d	(Lcom/google/android/gms/internal/do;)Lcom/google/android/gms/internal/ey;
        //   135: aload_0
        //   136: getfield 17	com/google/android/gms/internal/do$3:pE	Lcom/google/android/gms/internal/do;
        //   139: invokestatic 29	com/google/android/gms/internal/do:c	(Lcom/google/android/gms/internal/do;)Lcom/google/android/gms/internal/dv;
        //   142: getfield 63	com/google/android/gms/internal/dv:oy	Ljava/lang/String;
        //   145: invokestatic 84	com/google/android/gms/internal/ep:v	(Ljava/lang/String;)Ljava/lang/String;
        //   148: aload_0
        //   149: getfield 17	com/google/android/gms/internal/do$3:pE	Lcom/google/android/gms/internal/do;
        //   152: invokestatic 29	com/google/android/gms/internal/do:c	(Lcom/google/android/gms/internal/do;)Lcom/google/android/gms/internal/dv;
        //   155: getfield 87	com/google/android/gms/internal/dv:qb	Ljava/lang/String;
        //   158: ldc 89
        //   160: ldc 91
        //   162: aconst_null
        //   163: invokevirtual 95	com/google/android/gms/internal/ey:loadDataWithBaseURL	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   166: goto -53 -> 113
        //   169: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	170	0	this	3
        //   7	113	1	localObject1	Object
        //   118	4	2	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   10	121	118	finally
        //   123	166	118	finally
      }
    });
    h(paramLong);
  }
  
  private void g(long paramLong)
    throws do.a
  {
    do
    {
      if (!c(paramLong)) {
        throw new a("Timed out waiting for ad response.", 2);
      }
    } while (this.pA == null);
    synchronized (this.pw)
    {
      this.pz = null;
      if ((this.pA.errorCode != -2) && (this.pA.errorCode != -3)) {
        throw new a("There was a problem getting an ad response. ErrorCode: " + this.pA.errorCode, this.pA.errorCode);
      }
    }
  }
  
  private void h(long paramLong)
    throws do.a
  {
    while (c(paramLong)) {
      if (this.pB) {
        return;
      }
    }
    throw new a("Timed out waiting for WebView to finish loading.", 2);
  }
  
  public void a(dv paramdv)
  {
    synchronized (this.lq)
    {
      ev.z("Received ad response.");
      this.pA = paramdv;
      this.lq.notify();
      return;
    }
  }
  
  public void a(ey paramey)
  {
    synchronized (this.lq)
    {
      ev.z("WebView finished loading.");
      this.pB = true;
      this.lq.notify();
      return;
    }
  }
  
  /* Error */
  public void bc()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/google/android/gms/internal/do:lq	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: ldc_w 292
    //   10: invokestatic 281	com/google/android/gms/internal/ev:z	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 72	com/google/android/gms/internal/do:py	Lcom/google/android/gms/internal/l;
    //   17: invokevirtual 298	com/google/android/gms/internal/l:y	()Lcom/google/android/gms/internal/h;
    //   20: aload_0
    //   21: getfield 68	com/google/android/gms/internal/do:mContext	Landroid/content/Context;
    //   24: invokeinterface 303 2 0
    //   29: astore_2
    //   30: new 117	com/google/android/gms/internal/dt
    //   33: dup
    //   34: aload_0
    //   35: getfield 70	com/google/android/gms/internal/do:px	Lcom/google/android/gms/internal/dt$a;
    //   38: aload_2
    //   39: invokespecial 306	com/google/android/gms/internal/dt:<init>	(Lcom/google/android/gms/internal/dt$a;Ljava/lang/String;)V
    //   42: astore 5
    //   44: aconst_null
    //   45: astore 6
    //   47: bipush 254
    //   49: istore_2
    //   50: ldc2_w 307
    //   53: lstore_3
    //   54: invokestatic 233	android/os/SystemClock:elapsedRealtime	()J
    //   57: lstore 8
    //   59: aload_0
    //   60: getfield 68	com/google/android/gms/internal/do:mContext	Landroid/content/Context;
    //   63: aload 5
    //   65: aload_0
    //   66: invokestatic 313	com/google/android/gms/internal/dq:a	(Landroid/content/Context;Lcom/google/android/gms/internal/dt;Lcom/google/android/gms/internal/dq$a;)Lcom/google/android/gms/internal/en;
    //   69: astore 10
    //   71: aload_0
    //   72: getfield 56	com/google/android/gms/internal/do:pw	Ljava/lang/Object;
    //   75: astore 7
    //   77: aload 7
    //   79: monitorenter
    //   80: aload_0
    //   81: aload 10
    //   83: putfield 269	com/google/android/gms/internal/do:pz	Lcom/google/android/gms/internal/en;
    //   86: aload_0
    //   87: getfield 269	com/google/android/gms/internal/do:pz	Lcom/google/android/gms/internal/en;
    //   90: ifnonnull +358 -> 448
    //   93: new 18	com/google/android/gms/internal/do$a
    //   96: dup
    //   97: ldc_w 315
    //   100: iconst_0
    //   101: invokespecial 88	com/google/android/gms/internal/do$a:<init>	(Ljava/lang/String;I)V
    //   104: athrow
    //   105: astore_2
    //   106: aload 7
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    //   111: astore 7
    //   113: aload 7
    //   115: invokevirtual 319	com/google/android/gms/internal/do$a:getErrorCode	()I
    //   118: istore_2
    //   119: iload_2
    //   120: iconst_3
    //   121: if_icmpeq +9 -> 130
    //   124: iload_2
    //   125: bipush 255
    //   127: if_icmpne +411 -> 538
    //   130: aload 7
    //   132: invokevirtual 322	com/google/android/gms/internal/do$a:getMessage	()Ljava/lang/String;
    //   135: invokestatic 325	com/google/android/gms/internal/ev:B	(Ljava/lang/String;)V
    //   138: aload_0
    //   139: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   142: ifnonnull +407 -> 549
    //   145: aload_0
    //   146: new 79	com/google/android/gms/internal/dv
    //   149: dup
    //   150: iload_2
    //   151: invokespecial 328	com/google/android/gms/internal/dv:<init>	(I)V
    //   154: putfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   157: getstatic 250	com/google/android/gms/internal/eu:ss	Landroid/os/Handler;
    //   160: new 10	com/google/android/gms/internal/do$1
    //   163: dup
    //   164: aload_0
    //   165: invokespecial 329	com/google/android/gms/internal/do$1:<init>	(Lcom/google/android/gms/internal/do;)V
    //   168: invokevirtual 259	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   171: pop
    //   172: lload_3
    //   173: lstore_3
    //   174: aload 6
    //   176: astore 6
    //   178: aload_0
    //   179: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   182: getfield 332	com/google/android/gms/internal/dv:ql	Ljava/lang/String;
    //   185: invokestatic 210	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: istore 7
    //   190: iload 7
    //   192: ifne +389 -> 581
    //   195: aload_0
    //   196: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   199: getfield 332	com/google/android/gms/internal/dv:ql	Ljava/lang/String;
    //   202: astore 7
    //   204: new 334	org/json/JSONObject
    //   207: dup
    //   208: aload 7
    //   210: invokespecial 335	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   213: astore 11
    //   215: aload 5
    //   217: getfield 339	com/google/android/gms/internal/dt:pV	Lcom/google/android/gms/internal/aj;
    //   220: astore 10
    //   222: aload_0
    //   223: getfield 66	com/google/android/gms/internal/do:lL	Lcom/google/android/gms/internal/ey;
    //   226: astore 9
    //   228: aload_0
    //   229: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   232: getfield 343	com/google/android/gms/internal/dv:nr	Ljava/util/List;
    //   235: astore 15
    //   237: aload_0
    //   238: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   241: getfield 346	com/google/android/gms/internal/dv:ns	Ljava/util/List;
    //   244: astore 14
    //   246: aload_0
    //   247: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   250: getfield 349	com/google/android/gms/internal/dv:qf	Ljava/util/List;
    //   253: astore 12
    //   255: aload_0
    //   256: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   259: getfield 352	com/google/android/gms/internal/dv:orientation	I
    //   262: istore 13
    //   264: aload_0
    //   265: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   268: getfield 356	com/google/android/gms/internal/dv:nv	J
    //   271: lstore 7
    //   273: aload 5
    //   275: getfield 359	com/google/android/gms/internal/dt:pY	Ljava/lang/String;
    //   278: astore 17
    //   280: aload_0
    //   281: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   284: getfield 215	com/google/android/gms/internal/dv:qd	Z
    //   287: istore 5
    //   289: aload_0
    //   290: getfield 181	com/google/android/gms/internal/do:pD	Lcom/google/android/gms/internal/br;
    //   293: ifnull +294 -> 587
    //   296: aload_0
    //   297: getfield 181	com/google/android/gms/internal/do:pD	Lcom/google/android/gms/internal/br;
    //   300: getfield 363	com/google/android/gms/internal/br:nK	Lcom/google/android/gms/internal/bm;
    //   303: astore 16
    //   305: aload_0
    //   306: getfield 181	com/google/android/gms/internal/do:pD	Lcom/google/android/gms/internal/br;
    //   309: ifnull +284 -> 593
    //   312: aload_0
    //   313: getfield 181	com/google/android/gms/internal/do:pD	Lcom/google/android/gms/internal/br;
    //   316: getfield 367	com/google/android/gms/internal/br:nL	Lcom/google/android/gms/internal/bv;
    //   319: astore 21
    //   321: aload_0
    //   322: getfield 181	com/google/android/gms/internal/do:pD	Lcom/google/android/gms/internal/br;
    //   325: ifnull +274 -> 599
    //   328: aload_0
    //   329: getfield 181	com/google/android/gms/internal/do:pD	Lcom/google/android/gms/internal/br;
    //   332: getfield 370	com/google/android/gms/internal/br:nM	Ljava/lang/String;
    //   335: astore 20
    //   337: aload_0
    //   338: getfield 169	com/google/android/gms/internal/do:nd	Lcom/google/android/gms/internal/bn;
    //   341: astore 18
    //   343: aload_0
    //   344: getfield 181	com/google/android/gms/internal/do:pD	Lcom/google/android/gms/internal/br;
    //   347: ifnull +258 -> 605
    //   350: aload_0
    //   351: getfield 181	com/google/android/gms/internal/do:pD	Lcom/google/android/gms/internal/br;
    //   354: getfield 374	com/google/android/gms/internal/br:nN	Lcom/google/android/gms/internal/bp;
    //   357: astore 19
    //   359: new 376	com/google/android/gms/internal/eg
    //   362: dup
    //   363: aload 10
    //   365: aload 9
    //   367: aload 15
    //   369: iload_2
    //   370: aload 14
    //   372: aload 12
    //   374: iload 13
    //   376: lload 7
    //   378: aload 17
    //   380: iload 5
    //   382: aload 16
    //   384: aload 21
    //   386: aload 20
    //   388: aload 18
    //   390: aload 19
    //   392: aload_0
    //   393: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   396: getfield 379	com/google/android/gms/internal/dv:qe	J
    //   399: aload 6
    //   401: aload_0
    //   402: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   405: getfield 382	com/google/android/gms/internal/dv:qc	J
    //   408: lload_3
    //   409: aload_0
    //   410: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   413: getfield 385	com/google/android/gms/internal/dv:qh	J
    //   416: aload_0
    //   417: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   420: getfield 388	com/google/android/gms/internal/dv:qi	Ljava/lang/String;
    //   423: aload 11
    //   425: invokespecial 391	com/google/android/gms/internal/eg:<init>	(Lcom/google/android/gms/internal/aj;Lcom/google/android/gms/internal/ey;Ljava/util/List;ILjava/util/List;Ljava/util/List;IJLjava/lang/String;ZLcom/google/android/gms/internal/bm;Lcom/google/android/gms/internal/bv;Ljava/lang/String;Lcom/google/android/gms/internal/bn;Lcom/google/android/gms/internal/bp;JLcom/google/android/gms/internal/am;JJJLjava/lang/String;Lorg/json/JSONObject;)V
    //   428: astore_2
    //   429: getstatic 250	com/google/android/gms/internal/eu:ss	Landroid/os/Handler;
    //   432: new 12	com/google/android/gms/internal/do$2
    //   435: dup
    //   436: aload_0
    //   437: aload_2
    //   438: invokespecial 394	com/google/android/gms/internal/do$2:<init>	(Lcom/google/android/gms/internal/do;Lcom/google/android/gms/internal/eg;)V
    //   441: invokevirtual 259	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   444: pop
    //   445: aload_1
    //   446: monitorexit
    //   447: return
    //   448: aload 7
    //   450: monitorexit
    //   451: aload_0
    //   452: lload 8
    //   454: invokespecial 396	com/google/android/gms/internal/do:g	(J)V
    //   457: invokestatic 233	android/os/SystemClock:elapsedRealtime	()J
    //   460: lstore_3
    //   461: aload_0
    //   462: invokespecial 398	com/google/android/gms/internal/do:bi	()V
    //   465: aload 5
    //   467: getfield 121	com/google/android/gms/internal/dt:kR	Lcom/google/android/gms/internal/am;
    //   470: getfield 127	com/google/android/gms/internal/am:me	[Lcom/google/android/gms/internal/am;
    //   473: ifnull +11 -> 484
    //   476: aload_0
    //   477: aload 5
    //   479: invokespecial 400	com/google/android/gms/internal/do:a	(Lcom/google/android/gms/internal/dt;)Lcom/google/android/gms/internal/am;
    //   482: astore 6
    //   484: aload_0
    //   485: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   488: getfield 215	com/google/android/gms/internal/dv:qd	Z
    //   491: ifeq +14 -> 505
    //   494: aload_0
    //   495: aload 5
    //   497: lload 8
    //   499: invokespecial 402	com/google/android/gms/internal/do:a	(Lcom/google/android/gms/internal/dt;J)V
    //   502: goto +109 -> 611
    //   505: aload_0
    //   506: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   509: getfield 405	com/google/android/gms/internal/dv:qj	Z
    //   512: ifeq +17 -> 529
    //   515: aload_0
    //   516: lload 8
    //   518: invokevirtual 408	com/google/android/gms/internal/do:f	(J)V
    //   521: goto +90 -> 611
    //   524: astore_2
    //   525: aload_1
    //   526: monitorexit
    //   527: aload_2
    //   528: athrow
    //   529: aload_0
    //   530: lload 8
    //   532: invokespecial 410	com/google/android/gms/internal/do:e	(J)V
    //   535: goto +76 -> 611
    //   538: aload 7
    //   540: invokevirtual 322	com/google/android/gms/internal/do$a:getMessage	()Ljava/lang/String;
    //   543: invokestatic 413	com/google/android/gms/internal/ev:D	(Ljava/lang/String;)V
    //   546: goto -408 -> 138
    //   549: aload_0
    //   550: new 79	com/google/android/gms/internal/dv
    //   553: dup
    //   554: iload_2
    //   555: aload_0
    //   556: getfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   559: getfield 356	com/google/android/gms/internal/dv:nv	J
    //   562: invokespecial 416	com/google/android/gms/internal/dv:<init>	(IJ)V
    //   565: putfield 77	com/google/android/gms/internal/do:pA	Lcom/google/android/gms/internal/dv;
    //   568: goto -411 -> 157
    //   571: astore 7
    //   573: ldc_w 418
    //   576: aload 7
    //   578: invokestatic 421	com/google/android/gms/internal/ev:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   581: aconst_null
    //   582: astore 11
    //   584: goto -369 -> 215
    //   587: aconst_null
    //   588: astore 16
    //   590: goto -285 -> 305
    //   593: aconst_null
    //   594: astore 21
    //   596: goto -275 -> 321
    //   599: aconst_null
    //   600: astore 20
    //   602: goto -265 -> 337
    //   605: aconst_null
    //   606: astore 19
    //   608: goto -249 -> 359
    //   611: lload_3
    //   612: lstore_3
    //   613: aload 6
    //   615: astore 6
    //   617: goto -439 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	620	0	this	do
    //   4	522	1	localObject1	Object
    //   29	10	2	str1	String
    //   49	1	2	i	int
    //   105	5	2	localObject2	Object
    //   118	252	2	j	int
    //   428	10	2	localeg	eg
    //   524	31	2	localObject3	Object
    //   53	560	3	l1	long
    //   42	232	5	localdt	dt
    //   287	209	5	bool1	boolean
    //   45	571	6	localObject4	Object
    //   75	32	7	localObject5	Object
    //   111	20	7	locala	a
    //   188	3	7	bool2	boolean
    //   202	7	7	str2	String
    //   271	268	7	l2	long
    //   571	6	7	localException	Exception
    //   57	474	8	l3	long
    //   226	140	9	localey	ey
    //   69	295	10	localObject6	Object
    //   213	370	11	localJSONObject	org.json.JSONObject
    //   253	120	12	localList1	java.util.List
    //   262	113	13	k	int
    //   244	127	14	localList2	java.util.List
    //   235	133	15	localList3	java.util.List
    //   303	286	16	localbm	bm
    //   278	101	17	str3	String
    //   341	48	18	localbn	bn
    //   357	250	19	localbp	bp
    //   335	266	20	str4	String
    //   319	276	21	localbv	bv
    // Exception table:
    //   from	to	target	type
    //   80	109	105	finally
    //   448	451	105	finally
    //   54	80	111	com/google/android/gms/internal/do$a
    //   109	111	111	com/google/android/gms/internal/do$a
    //   451	521	111	com/google/android/gms/internal/do$a
    //   529	535	111	com/google/android/gms/internal/do$a
    //   7	44	524	finally
    //   54	80	524	finally
    //   109	111	524	finally
    //   113	190	524	finally
    //   195	215	524	finally
    //   215	447	524	finally
    //   451	521	524	finally
    //   525	527	524	finally
    //   529	535	524	finally
    //   538	581	524	finally
    //   195	215	571	java/lang/Exception
  }
  
  protected void f(long paramLong)
    throws do.a
  {
    am localam = this.lL.Q();
    int i;
    int j;
    if (!localam.md)
    {
      i = localam.widthPixels;
      j = localam.heightPixels;
    }
    else
    {
      i = this.mContext.getResources().getDisplayMetrics().widthPixels;
      j = this.mContext.getResources().getDisplayMetrics().heightPixels;
    }
    final dp localdp = new dp(this, this.lL, i, j);
    eu.ss.post(new Runnable()
    {
      public void run()
      {
        synchronized (do.a(do.this))
        {
          if (do.c(do.this).errorCode == -2)
          {
            do.d(do.this).bW().a(do.this);
            localdp.b(do.c(do.this));
          }
        }
      }
    });
    h(paramLong);
    if (!localdp.bl())
    {
      if (localdp.bm()) {
        return;
      }
      throw new a("AdNetwork timed out", 2);
    }
    ev.z("Ad-Network indicated no fill with passback URL.");
    throw new a("AdNetwork sent passback url", 3);
  }
  
  public void onStop()
  {
    synchronized (this.pw)
    {
      if (this.pz != null) {
        this.pz.cancel();
      }
      this.lL.stopLoading();
      ep.a(this.lL);
      if (this.pC != null) {
        this.pC.cancel();
      }
      return;
    }
  }
  
  private static final class a
    extends Exception
  {
    private final int pH;
    
    public a(String paramString, int paramInt)
    {
      super();
      this.pH = paramInt;
    }
    
    public int getErrorCode()
    {
      return this.pH;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.do
 * JD-Core Version:    0.7.0.1
 */