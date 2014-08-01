package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class dy
  extends dx.a
{
  private static final Object qm = new Object();
  private static dy qn;
  private final Context mContext;
  private final ee qo;
  private final bj qp;
  private final az qq;
  
  dy(Context paramContext, az paramaz, bj parambj, ee paramee)
  {
    this.mContext = paramContext;
    this.qo = paramee;
    this.qp = parambj;
    this.qq = paramaz;
  }
  
  private static dv a(Context paramContext, az paramaz, bj parambj, ee paramee, final dt paramdt)
  {
    ev.z("Starting ad request from service.");
    parambj.init();
    Object localObject3 = new ed(paramContext);
    Object localObject1;
    if (((ed)localObject3).rj != -1)
    {
      localObject1 = new ea(paramdt.applicationInfo.packageName);
      Object localObject2;
      if (paramdt.pV.extras != null)
      {
        localObject2 = paramdt.pV.extras.getString("_ad");
        if (localObject2 != null) {}
      }
      else
      {
        Location localLocation = parambj.a(250L);
        localObject2 = paramaz.aI();
        localObject3 = dz.a(paramdt, (ed)localObject3, localLocation, paramaz.aJ());
        if (localObject3 != null)
        {
          localObject3 = s((String)localObject3);
          eu.ss.post(new Runnable()
          {
            public void run()
            {
              ey localey = ey.a(dy.this, new am(), false, false, null, paramdt.kO);
              localey.setWillNotDraw(true);
              this.qt.b(localey);
              ez localez = localey.bW();
              localez.a("/invalidRequest", this.qt.qA);
              localez.a("/loadAdURL", this.qt.qB);
              localez.a("/log", bc.mX);
              localez.a(this.qu);
              ev.z("Loading the JS library.");
              localey.loadUrl(this.qv);
            }
          });
          localObject2 = ((ea)localObject1).bs();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((ec)localObject2).getUrl())))
          {
            localObject1 = null;
            if (((ec)localObject2).bv()) {
              localObject1 = paramee.u(paramdt.pW.packageName);
            }
            localObject1 = a(paramContext, paramdt.kO.st, ((ec)localObject2).getUrl(), (String)localObject1, (ec)localObject2);
            break label280;
          }
          localObject1 = new dv(((ea)localObject1).getErrorCode());
          break label280;
        }
        localObject1 = new dv(0);
        break label280;
      }
      localObject1 = dz.a(paramContext, paramdt, (String)localObject2);
    }
    else
    {
      ev.z("Device is offline.");
      localObject1 = new dv(2);
    }
    label280:
    return localObject1;
  }
  
  public static dv a(Context paramContext, String paramString1, String paramString2, String paramString3, ec paramec)
  {
    try
    {
      localeb = new eb();
      localObject1 = new URL(paramString2);
      l = SystemClock.elapsedRealtime();
      localObject4 = localObject1;
      int i = 0;
      localObject1 = (HttpURLConnection)((URL)localObject4).openConnection();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          eb localeb;
          Object localObject1;
          long l;
          Object localObject4;
          ep.a(paramContext, paramString1, false, (HttpURLConnection)localObject1);
          if (!TextUtils.isEmpty(paramString3)) {
            ((HttpURLConnection)localObject1).addRequestProperty("x-afma-drt-cookie", paramString3);
          }
          if ((paramec != null) && (!TextUtils.isEmpty(paramec.bu())))
          {
            ((HttpURLConnection)localObject1).setDoOutput(true);
            byte[] arrayOfByte = paramec.bu().getBytes();
            ((HttpURLConnection)localObject1).setFixedLengthStreamingMode(arrayOfByte.length);
            localObject3 = new BufferedOutputStream(((HttpURLConnection)localObject1).getOutputStream());
            ((BufferedOutputStream)localObject3).write(arrayOfByte);
            ((BufferedOutputStream)localObject3).close();
          }
          int j = ((HttpURLConnection)localObject1).getResponseCode();
          Object localObject3 = ((HttpURLConnection)localObject1).getHeaderFields();
          String str1;
          dv localdv2;
          if ((j >= 200) && (j < 300))
          {
            str1 = ((URL)localObject4).toString();
            localObject4 = ep.a(new InputStreamReader(((HttpURLConnection)localObject1).getInputStream()));
            a(str1, (Map)localObject3, (String)localObject4, j);
            localeb.a(str1, (Map)localObject3, (String)localObject4);
            localdv2 = localeb.i(l);
            ((HttpURLConnection)localObject1).disconnect();
            localObject1 = localdv2;
            return localObject1;
          }
          a(((URL)localObject4).toString(), (Map)localObject3, null, j);
          String str2;
          if ((j >= 300) && (j < 400))
          {
            str2 = ((HttpURLConnection)localObject1).getHeaderField("Location");
            if (TextUtils.isEmpty(str2))
            {
              ev.D("No location header to follow redirect.");
              localdv2 = new dv(0);
              ((HttpURLConnection)localObject1).disconnect();
              localObject1 = localdv2;
              continue;
            }
            localObject4 = new URL(str2);
            str1++;
            if (str1 > 5)
            {
              ev.D("Too many redirects.");
              localdv2 = new dv(0);
              ((HttpURLConnection)localObject1).disconnect();
              localObject1 = localdv2;
            }
          }
          else
          {
            ev.D("Received error HTTP response code: " + str2);
            localdv2 = new dv(0);
            ((HttpURLConnection)localObject1).disconnect();
            localObject1 = localdv2;
            continue;
          }
          localeb.d((Map)localObject3);
          ((HttpURLConnection)localObject1).disconnect();
          continue;
        }
        finally
        {
          dv localdv1;
          localdv1.disconnect();
        }
        localIOException = localIOException;
        ev.D("Error while connecting to ad server: " + localIOException.getMessage());
        localdv1 = new dv(2);
      }
    }
  }
  
  public static dy a(Context paramContext, az paramaz, bj parambj, ee paramee)
  {
    synchronized (qm)
    {
      if (qn == null) {
        qn = new dy(paramContext.getApplicationContext(), paramaz, parambj, paramee);
      }
      dy localdy = qn;
      return localdy;
    }
  }
  
  private static void a(String paramString1, Map<String, List<String>> paramMap, String paramString2, int paramInt)
  {
    Iterator localIterator;
    if (ev.p(2))
    {
      ev.C("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null) {
        localIterator = paramMap.keySet().iterator();
      }
    }
    for (;;)
    {
      int i;
      if (!localIterator.hasNext())
      {
        ev.C("  Body:");
        if (paramString2 == null) {
          ev.C("    null");
        }
        for (i = 0;; i += 1000)
        {
          if (i >= Math.min(paramString2.length(), 100000))
          {
            ev.C("  Response Code:\n    " + paramInt + "\n}");
            return;
          }
          ev.C(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
        }
      }
      Object localObject = (String)i.next();
      ev.C("    " + (String)localObject + ":");
      localObject = ((List)paramMap.get(localObject)).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        ev.C("      " + str);
      }
    }
  }
  
  private static ez.a s(String paramString)
  {
    new ez.a()
    {
      public void a(ey paramAnonymousey)
      {
        Object localObject = new Object[2];
        localObject[0] = "AFMA_buildAdURL";
        localObject[1] = dy.this;
        localObject = String.format("javascript:%s(%s);", (Object[])localObject);
        ev.C("About to execute: " + (String)localObject);
        paramAnonymousey.loadUrl((String)localObject);
      }
    };
  }
  
  public dv b(dt paramdt)
  {
    return a(this.mContext, this.qq, this.qp, this.qo, paramdt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dy
 * JD-Core Version:    0.7.0.1
 */