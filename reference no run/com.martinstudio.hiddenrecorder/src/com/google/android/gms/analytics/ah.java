package com.google.android.gms.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class ah
  implements n
{
  private final Context mContext;
  private GoogleAnalytics ui;
  private final String wX;
  private final HttpClient wY;
  private URL wZ;
  
  ah(HttpClient paramHttpClient, Context paramContext)
  {
    this(paramHttpClient, GoogleAnalytics.getInstance(paramContext), paramContext);
  }
  
  ah(HttpClient paramHttpClient, GoogleAnalytics paramGoogleAnalytics, Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.wX = a("GoogleAnalytics", "3.0", Build.VERSION.RELEASE, ak.a(Locale.getDefault()), Build.MODEL, Build.ID);
    this.wY = paramHttpClient;
    this.ui = paramGoogleAnalytics;
  }
  
  /* Error */
  private void a(ab paramab, URL paramURL, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 89	com/google/android/gms/analytics/ab:dl	()Ljava/lang/String;
    //   4: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 99	com/google/android/gms/analytics/ah:ds	()Z
    //   14: ifne +4 -> 18
    //   17: return
    //   18: aload_2
    //   19: ifnonnull +260 -> 279
    //   22: aload_0
    //   23: getfield 101	com/google/android/gms/analytics/ah:wZ	Ljava/net/URL;
    //   26: ifnull +193 -> 219
    //   29: aload_0
    //   30: getfield 101	com/google/android/gms/analytics/ah:wZ	Ljava/net/URL;
    //   33: astore 5
    //   35: new 103	org/apache/http/HttpHost
    //   38: dup
    //   39: aload 5
    //   41: invokevirtual 108	java/net/URL:getHost	()Ljava/lang/String;
    //   44: aload 5
    //   46: invokevirtual 112	java/net/URL:getPort	()I
    //   49: aload 5
    //   51: invokevirtual 115	java/net/URL:getProtocol	()Ljava/lang/String;
    //   54: invokespecial 118	org/apache/http/HttpHost:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: astore 4
    //   59: aload_0
    //   60: aload_1
    //   61: invokevirtual 89	com/google/android/gms/analytics/ab:dl	()Ljava/lang/String;
    //   64: aload 5
    //   66: invokevirtual 121	java/net/URL:getPath	()Ljava/lang/String;
    //   69: invokespecial 125	com/google/android/gms/analytics/ah:e	(Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/HttpEntityEnclosingRequest;
    //   72: astore 5
    //   74: aload 5
    //   76: ifnull -59 -> 17
    //   79: aload 5
    //   81: ldc 127
    //   83: aload 4
    //   85: invokevirtual 130	org/apache/http/HttpHost:toHostString	()Ljava/lang/String;
    //   88: invokeinterface 136 3 0
    //   93: invokestatic 141	com/google/android/gms/analytics/aa:dk	()Z
    //   96: ifeq +9 -> 105
    //   99: aload_0
    //   100: aload 5
    //   102: invokespecial 144	com/google/android/gms/analytics/ah:a	(Lorg/apache/http/HttpEntityEnclosingRequest;)V
    //   105: iload_3
    //   106: ifeq +10 -> 116
    //   109: aload_0
    //   110: getfield 38	com/google/android/gms/analytics/ah:mContext	Landroid/content/Context;
    //   113: invokestatic 150	com/google/android/gms/analytics/q:t	(Landroid/content/Context;)V
    //   116: aload_0
    //   117: getfield 74	com/google/android/gms/analytics/ah:wY	Lorg/apache/http/client/HttpClient;
    //   120: aload 4
    //   122: aload 5
    //   124: invokeinterface 156 3 0
    //   129: astore 4
    //   131: aload 4
    //   133: invokeinterface 162 1 0
    //   138: invokeinterface 167 1 0
    //   143: istore 6
    //   145: aload 4
    //   147: invokeinterface 171 1 0
    //   152: astore 5
    //   154: aload 5
    //   156: ifnull +10 -> 166
    //   159: aload 5
    //   161: invokeinterface 176 1 0
    //   166: iload 6
    //   168: sipush 200
    //   171: if_icmpeq -154 -> 17
    //   174: new 178	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   181: ldc 181
    //   183: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 4
    //   188: invokeinterface 162 1 0
    //   193: invokeinterface 167 1 0
    //   198: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 195	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   207: goto -190 -> 17
    //   210: pop
    //   211: ldc 197
    //   213: invokestatic 195	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   216: goto -199 -> 17
    //   219: new 105	java/net/URL
    //   222: dup
    //   223: ldc 199
    //   225: invokespecial 201	java/net/URL:<init>	(Ljava/lang/String;)V
    //   228: astore 5
    //   230: goto -195 -> 35
    //   233: pop
    //   234: goto -217 -> 17
    //   237: astore 4
    //   239: new 178	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   246: ldc 203
    //   248: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 4
    //   253: invokevirtual 207	java/lang/Object:getClass	()Ljava/lang/Class;
    //   256: invokevirtual 212	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   259: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 195	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   268: aload 4
    //   270: invokevirtual 215	java/io/IOException:getMessage	()Ljava/lang/String;
    //   273: invokestatic 195	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   276: goto -259 -> 17
    //   279: aload_2
    //   280: astore 5
    //   282: goto -247 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	ah
    //   0	285	1	paramab	ab
    //   0	285	2	paramURL	URL
    //   0	285	3	paramBoolean	boolean
    //   57	130	4	localObject1	Object
    //   237	32	4	localIOException	IOException
    //   33	248	5	localObject2	Object
    //   143	29	6	i	int
    //   210	1	8	localClientProtocolException	ClientProtocolException
    //   233	1	9	localMalformedURLException	MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   59	207	210	org/apache/http/client/ClientProtocolException
    //   22	35	233	java/net/MalformedURLException
    //   219	230	233	java/net/MalformedURLException
    //   59	207	237	java/io/IOException
  }
  
  private void a(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Header[] arrayOfHeader = paramHttpEntityEnclosingRequest.getAllHeaders();
    int j = arrayOfHeader.length;
    for (int i = 0; i < j; i++) {
      localStringBuffer.append(arrayOfHeader[i].toString()).append("\n");
    }
    localStringBuffer.append(paramHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
    if (paramHttpEntityEnclosingRequest.getEntity() != null) {}
    try
    {
      InputStream localInputStream = paramHttpEntityEnclosingRequest.getEntity().getContent();
      if (localInputStream != null)
      {
        j = localInputStream.available();
        if (j > 0)
        {
          byte[] arrayOfByte = new byte[j];
          localInputStream.read(arrayOfByte);
          localStringBuffer.append("POST:\n");
          localStringBuffer.append(new String(arrayOfByte)).append("\n");
        }
      }
      aa.C(localStringBuffer.toString());
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        aa.C("Error Writing hit to log...");
      }
    }
  }
  
  private HttpEntityEnclosingRequest e(String paramString1, String paramString2)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString1))
    {
      aa.D("Empty hit, discarding.");
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = paramString2 + "?" + paramString1;
      if (((String)localObject).length() < 2036) {
        localObject = new BasicHttpEntityEnclosingRequest("GET", (String)localObject);
      }
      for (;;)
      {
        ((HttpEntityEnclosingRequest)localObject).addHeader("User-Agent", this.wX);
        break;
        localObject = new BasicHttpEntityEnclosingRequest("POST", paramString2);
        try
        {
          ((HttpEntityEnclosingRequest)localObject).setEntity(new StringEntity(paramString1));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          aa.D("Encoding error, discarding hit");
          localObject = null;
        }
      }
    }
  }
  
  public void M(String paramString)
  {
    try
    {
      this.wZ = new URL(paramString);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        this.wZ = null;
      }
    }
  }
  
  public int a(List<x> paramList, ab paramab, boolean paramBoolean)
  {
    int i1 = 0;
    int m = Math.min(paramList.size(), 40);
    paramab.c("_hr", paramList.size());
    int j = 0;
    Object localObject3 = null;
    int i = 1;
    int k = 0;
    label246:
    int i2;
    if (k < m)
    {
      Object localObject2 = (x)paramList.get(k);
      URL localURL = a((x)localObject2);
      Object localObject1;
      if (localURL == null)
      {
        if (aa.dk()) {
          aa.D("No destination: discarding hit: " + ((x)localObject2).df());
        }
        for (;;)
        {
          int n = i1 + 1;
          j++;
          localObject2 = localObject3;
          i1 = n;
          localObject1 = localObject2;
          k++;
          i1 = i1;
          localObject3 = localObject1;
          break;
          aa.D("No destination: discarding hit.");
        }
      }
      localObject3 = new HttpHost(localObject1.getHost(), localObject1.getPort(), localObject1.getProtocol());
      Object localObject4 = localObject1.getPath();
      if (TextUtils.isEmpty(((x)localObject2).df())) {}
      for (localObject2 = "";; localObject2 = y.a((x)localObject2, System.currentTimeMillis()))
      {
        localObject4 = e((String)localObject2, (String)localObject4);
        if (localObject4 != null) {
          break label246;
        }
        i1 += 1;
        j++;
        i1 = i1;
        localObject1 = localObject1;
        break;
      }
      ((HttpEntityEnclosingRequest)localObject4).addHeader("Host", ((HttpHost)localObject3).toHostString());
      if (aa.dk()) {
        a((HttpEntityEnclosingRequest)localObject4);
      }
      if (((String)localObject2).length() > 8192)
      {
        aa.D("Hit too long (> 8192 bytes)--not sent");
        j++;
      }
      for (;;)
      {
        paramab.c("_td", ((String)localObject2).getBytes().length);
        i1 += 1;
        localObject1 = localObject1;
        break;
        if (this.ui.isDryRunEnabled())
        {
          aa.B("Dry run enabled. Hit not actually sent.");
        }
        else
        {
          if (i != 0) {}
          try
          {
            q.t(this.mContext);
            i = 0;
            localObject4 = this.wY.execute((HttpHost)localObject3, (HttpRequest)localObject4);
            i2 = ((HttpResponse)localObject4).getStatusLine().getStatusCode();
            HttpEntity localHttpEntity = ((HttpResponse)localObject4).getEntity();
            if (localHttpEntity != null) {
              localHttpEntity.consumeContent();
            }
            if (i2 != 200) {
              aa.D("Bad response: " + ((HttpResponse)localObject4).getStatusLine().getStatusCode());
            }
          }
          catch (ClientProtocolException localClientProtocolException)
          {
            aa.D("ClientProtocolException sending hit; discarding hit...");
            paramab.c("_hd", j);
          }
          catch (IOException localIOException)
          {
            aa.D("Exception sending hit: " + localIOException.getClass().getSimpleName());
            aa.D(localIOException.getMessage());
            paramab.c("_de", 1);
            paramab.c("_hd", j);
            paramab.c("_hs", i1);
            a(paramab, localObject1, i);
            i = i1;
          }
        }
      }
    }
    for (;;)
    {
      return i;
      paramab.c("_hd", j);
      paramab.c("_hs", i1);
      if (paramBoolean) {
        a(paramab, i2, i);
      }
      i = i1;
    }
  }
  
  String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = paramString2;
    arrayOfObject[2] = paramString3;
    arrayOfObject[3] = paramString4;
    arrayOfObject[4] = paramString5;
    arrayOfObject[5] = paramString6;
    return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", arrayOfObject);
  }
  
  URL a(x paramx)
  {
    if (this.wZ != null)
    {
      localObject = this.wZ;
      return localObject;
    }
    for (Object localObject = paramx.di();; localObject = "https://ssl.google-analytics.com/collect")
    {
      try
      {
        if (!"http:".equals(localObject)) {
          continue;
        }
        localObject = "http://www.google-analytics.com/collect";
        localObject = new URL((String)localObject);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        aa.A("Error trying to parse the hardcoded host url. This really shouldn't happen.");
        localObject = null;
      }
      break;
    }
  }
  
  public boolean cx()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool;
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
    {
      bool = true;
    }
    else
    {
      aa.C("...no network connectivity");
      bool = false;
    }
    return bool;
  }
  
  boolean ds()
  {
    boolean bool;
    if (100.0D * Math.random() > 1.0D) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ah
 * JD-Core Version:    0.7.0.1
 */