package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
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
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class da
  implements ab
{
  private final Context ahH;
  private final String ahY;
  private final HttpClient ahZ;
  private a aia;
  
  da(HttpClient paramHttpClient, Context paramContext, a parama)
  {
    this.ahH = paramContext.getApplicationContext();
    this.ahY = a("GoogleTagManager", "4.00", Build.VERSION.RELEASE, c(Locale.getDefault()), Build.MODEL, Build.ID);
    this.ahZ = paramHttpClient;
    this.aia = parama;
  }
  
  private HttpEntityEnclosingRequest a(URL paramURL)
  {
    for (;;)
    {
      try
      {
        BasicHttpEntityEnclosingRequest localBasicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", paramURL.toURI().toString());
        bh.D("Exception sending hit: " + localURISyntaxException2.getClass().getSimpleName());
      }
      catch (URISyntaxException localURISyntaxException1)
      {
        try
        {
          localBasicHttpEntityEnclosingRequest.addHeader("User-Agent", this.ahY);
          return localBasicHttpEntityEnclosingRequest;
        }
        catch (URISyntaxException localURISyntaxException3)
        {
          URISyntaxException localURISyntaxException2;
          break label36;
        }
        localURISyntaxException1 = localURISyntaxException1;
        localBasicHttpEntityEnclosingRequest = null;
        localURISyntaxException2 = localURISyntaxException1;
      }
      label36:
      bh.D(localURISyntaxException2.getMessage());
    }
  }
  
  private void a(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = paramHttpEntityEnclosingRequest.getAllHeaders();
    int i = localObject.length;
    for (int j = 0; j < i; j++) {
      localStringBuffer.append(localObject[j].toString()).append("\n");
    }
    localStringBuffer.append(paramHttpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
    if (paramHttpEntityEnclosingRequest.getEntity() != null) {}
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
      bh.C(localStringBuffer.toString());
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        bh.C("Error Writing hit to log...");
      }
    }
  }
  
  static String c(Locale paramLocale)
  {
    Object localObject = null;
    if ((paramLocale != null) && (paramLocale.getLanguage() != null) && (paramLocale.getLanguage().length() != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLocale.getLanguage().toLowerCase());
      if ((paramLocale.getCountry() != null) && (paramLocale.getCountry().length() != 0)) {
        ((StringBuilder)localObject).append("-").append(paramLocale.getCountry().toLowerCase());
      }
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
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
  
  public boolean cx()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.ahH.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool;
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
    {
      bool = true;
    }
    else
    {
      bh.C("...no network connectivity");
      bool = false;
    }
    return bool;
  }
  
  URL d(ap paramap)
  {
    Object localObject = paramap.lJ();
    try
    {
      localObject = new URL((String)localObject);
      return localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        bh.A("Error trying to parse the GTM url.");
        localObject = null;
      }
    }
  }
  
  public void g(List<ap> paramList)
  {
    int i = Math.min(paramList.size(), 40);
    int k = 1;
    int j = 0;
    ap localap;
    Object localObject2;
    if (j < i)
    {
      localap = (ap)paramList.get(j);
      localObject2 = d(localap);
      if (localObject2 == null)
      {
        bh.D("No destination: discarding hit.");
        this.aia.b(localap);
        k = k;
      }
    }
    for (;;)
    {
      j++;
      k = k;
      break;
      Object localObject1 = a((URL)localObject2);
      if (localObject1 == null)
      {
        this.aia.b(localap);
        k = k;
      }
      else
      {
        localObject2 = new HttpHost(((URL)localObject2).getHost(), ((URL)localObject2).getPort(), ((URL)localObject2).getProtocol());
        ((HttpEntityEnclosingRequest)localObject1).addHeader("Host", ((HttpHost)localObject2).toHostString());
        a((HttpEntityEnclosingRequest)localObject1);
        if (k != 0) {}
        try
        {
          bn.t(this.ahH);
          k = 0;
          localObject1 = this.ahZ.execute((HttpHost)localObject2, (HttpRequest)localObject1);
          int m = ((HttpResponse)localObject1).getStatusLine().getStatusCode();
          HttpEntity localHttpEntity = ((HttpResponse)localObject1).getEntity();
          if (localHttpEntity != null) {
            localHttpEntity.consumeContent();
          }
          if (m != 200)
          {
            bh.D("Bad response: " + ((HttpResponse)localObject1).getStatusLine().getStatusCode());
            this.aia.c(localap);
          }
          else
          {
            this.aia.a(localap);
          }
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          bh.D("ClientProtocolException sending hit; discarding hit...");
          this.aia.b(localap);
          k = k;
          continue;
        }
        catch (IOException localIOException)
        {
          bh.D("Exception sending hit: " + localIOException.getClass().getSimpleName());
          bh.D(localIOException.getMessage());
          this.aia.c(localap);
          k = k;
        }
        continue;
        return;
        k = k;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ap paramap);
    
    public abstract void b(ap paramap);
    
    public abstract void c(ap paramap);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.da
 * JD-Core Version:    0.7.0.1
 */