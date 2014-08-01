package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class fb
  extends ez
{
  public fb(ey paramey, boolean paramBoolean)
  {
    super(paramey, paramBoolean);
  }
  
  protected WebResourceResponse c(Context paramContext, String paramString1, String paramString2)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString2).openConnection();
    try
    {
      ep.a(paramContext, paramString1, true, localHttpURLConnection);
      localHttpURLConnection.connect();
      WebResourceResponse localWebResourceResponse = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(ep.a(new InputStreamReader(localHttpURLConnection.getInputStream())).getBytes("UTF-8")));
      return localWebResourceResponse;
    }
    finally
    {
      localHttpURLConnection.disconnect();
    }
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    WebResourceResponse localWebResourceResponse;
    try
    {
      Object localObject;
      if (!"mraid.js".equalsIgnoreCase(new File(paramString).getName()))
      {
        localObject = super.shouldInterceptRequest(paramWebView, paramString);
      }
      else if (!(paramWebView instanceof ey))
      {
        ev.D("Tried to intercept request from a WebView that wasn't an AdWebView.");
        localObject = super.shouldInterceptRequest(paramWebView, paramString);
      }
      else
      {
        localObject = (ey)paramWebView;
        ((ey)localObject).bW().aN();
        if (((ey)localObject).Q().md)
        {
          ev.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
          localObject = c(((ey)localObject).getContext(), this.lL.bY().st, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
        }
        else if (((ey)localObject).bZ())
        {
          ev.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
          localObject = c(((ey)localObject).getContext(), this.lL.bY().st, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
        }
        else
        {
          ev.C("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
          localObject = c(((ey)localObject).getContext(), this.lL.bY().st, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
          localObject = localObject;
        }
      }
    }
    catch (IOException localIOException)
    {
      ev.D("Could not fetching MRAID JS. " + localIOException.getMessage());
      localWebResourceResponse = super.shouldInterceptRequest(paramWebView, paramString);
    }
    return localWebResourceResponse;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fb
 * JD-Core Version:    0.7.0.1
 */