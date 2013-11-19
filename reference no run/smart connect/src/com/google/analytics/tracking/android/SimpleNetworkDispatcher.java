package com.google.analytics.tracking.android;

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

class SimpleNetworkDispatcher
  implements Dispatcher
{
  private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
  private final Context ctx;
  private final HttpClientFactory httpClientFactory;
  private final String userAgent;
  
  SimpleNetworkDispatcher(AnalyticsStore paramAnalyticsStore, HttpClientFactory paramHttpClientFactory, Context paramContext)
  {
    this(paramHttpClientFactory, paramContext);
  }
  
  SimpleNetworkDispatcher(HttpClientFactory paramHttpClientFactory, Context paramContext)
  {
    this.ctx = paramContext.getApplicationContext();
    this.userAgent = createUserAgentString("GoogleAnalytics", "2.0", Build.VERSION.RELEASE, Utils.getLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
    this.httpClientFactory = paramHttpClientFactory;
  }
  
  private HttpEntityEnclosingRequest buildRequest(String paramString1, String paramString2)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString1))
    {
      Log.w("Empty hit, discarding.");
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
        ((HttpEntityEnclosingRequest)localObject).addHeader("User-Agent", this.userAgent);
        break;
        localObject = new BasicHttpEntityEnclosingRequest("POST", paramString2);
        try
        {
          ((HttpEntityEnclosingRequest)localObject).setEntity(new StringEntity(paramString1));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Log.w("Encoding error, discarding hit");
          localObject = null;
        }
      }
    }
  }
  
  private URL getUrl(Hit paramHit)
  {
    URL localURL = null;
    if (TextUtils.isEmpty(paramHit.getHitUrl())) {}
    for (;;)
    {
      return localURL;
      try
      {
        localURL = new URL(paramHit.getHitUrl());
        localURL = localURL;
      }
      catch (MalformedURLException localMalformedURLException1)
      {
        try
        {
          localURL = new URL("http://www.google-analytics.com/collect");
          localURL = localURL;
        }
        catch (MalformedURLException localMalformedURLException2) {}
      }
    }
  }
  
  private void logDebugInformation(boolean paramBoolean, HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    StringBuffer localStringBuffer;
    Object localObject;
    int i;
    if (paramBoolean)
    {
      localStringBuffer = new StringBuffer();
      localObject = paramHttpEntityEnclosingRequest.getAllHeaders();
      i = localObject.length;
      for (int j = 0; j < i; j++) {
        localStringBuffer.append(localObject[j].toString()).append("\n");
      }
      localStringBuffer.append(paramHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
      if (paramHttpEntityEnclosingRequest.getEntity() == null) {}
    }
    try
    {
      localObject = paramHttpEntityEnclosingRequest.getEntity().getContent();
      if (localObject != null)
      {
        i = ((InputStream)localObject).available();
        if (i > 0)
        {
          byte[] arrayOfByte = new byte[i];
          ((InputStream)localObject).read(arrayOfByte);
          localStringBuffer.append("POST:\n");
          localStringBuffer.append(new String(arrayOfByte)).append("\n");
        }
      }
      Log.i(localStringBuffer.toString());
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.w("Error Writing hit to log...");
      }
    }
  }
  
  String createUserAgentString(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
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
  
  public int dispatchHits(List<Hit> paramList)
  {
    int i = 0;
    int k = Math.min(paramList.size(), 40);
    int j = 0;
    Object localObject1;
    Object localObject3;
    HttpHost localHttpHost;
    if (j < k)
    {
      localObject1 = this.httpClientFactory.newInstance();
      Object localObject2 = (Hit)paramList.get(j);
      localObject3 = getUrl((Hit)localObject2);
      if (localObject3 == null)
      {
        if (Log.isDebugEnabled()) {
          Log.w("No destination: discarding hit: " + ((Hit)localObject2).getHitParams());
        }
        for (;;)
        {
          i++;
          j++;
          break;
          Log.w("No destination: discarding hit.");
        }
      }
      localHttpHost = new HttpHost(((URL)localObject3).getHost(), ((URL)localObject3).getPort(), ((URL)localObject3).getProtocol());
      localObject3 = ((URL)localObject3).getPath();
      if (TextUtils.isEmpty(((Hit)localObject2).getHitParams())) {}
      for (localObject2 = "";; localObject2 = HitBuilder.postProcessHit((Hit)localObject2, System.currentTimeMillis()))
      {
        localObject3 = buildRequest((String)localObject2, (String)localObject3);
        if (localObject3 != null) {
          break label191;
        }
        i++;
        break;
      }
      label191:
      ((HttpEntityEnclosingRequest)localObject3).addHeader("Host", localHttpHost.toHostString());
      logDebugInformation(Log.isDebugEnabled(), (HttpEntityEnclosingRequest)localObject3);
      if (((String)localObject2).length() > 8192) {
        Log.w("Hit too long (> 8192 bytes)--not sent");
      }
    }
    for (;;)
    {
      i++;
      break;
      try
      {
        localObject1 = ((HttpClient)localObject1).execute(localHttpHost, (HttpRequest)localObject3);
        if (((HttpResponse)localObject1).getStatusLine().getStatusCode() == 200) {
          continue;
        }
        Log.w("Bad response: " + ((HttpResponse)localObject1).getStatusLine().getStatusCode());
        return i;
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        Log.w("ClientProtocolException sending hit; discarding hit...");
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.w("Exception sending hit: " + localIOException.getClass().getSimpleName());
          Log.w(localIOException.getMessage());
        }
      }
    }
  }
  
  public boolean okToDispatch()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.ctx.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool;
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
    {
      bool = true;
    }
    else
    {
      Log.vDebug("...no network connectivity");
      bool = false;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.SimpleNetworkDispatcher
 * JD-Core Version:    0.7.0.1
 */