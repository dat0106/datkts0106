package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

public class fd
  extends WebViewClient
{
  private final ey lL;
  private final String sQ = G(paramString);
  private boolean sR = false;
  private final dp sS;
  
  public fd(dp paramdp, ey paramey, String paramString)
  {
    this.lL = paramey;
    this.sS = paramdp;
  }
  
  private String G(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        if (paramString.endsWith("/"))
        {
          String str = paramString.substring(0, -1 + paramString.length());
          paramString = str;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        ev.A(localIndexOutOfBoundsException.getMessage());
      }
    }
  }
  
  protected boolean F(String paramString)
  {
    boolean bool = false;
    String str1 = G(paramString);
    if (TextUtils.isEmpty(str1)) {}
    for (;;)
    {
      return bool;
      try
      {
        Object localObject2 = new URI(str1);
        if ("passback".equals(((URI)localObject2).getScheme()))
        {
          ev.z("Passback received");
          this.sS.bk();
          bool = true;
        }
        else if (!TextUtils.isEmpty(this.sQ))
        {
          Object localObject1 = new URI(this.sQ);
          str1 = ((URI)localObject1).getHost();
          String str2 = ((URI)localObject2).getHost();
          localObject1 = ((URI)localObject1).getPath();
          localObject2 = ((URI)localObject2).getPath();
          if ((hl.equal(str1, str2)) && (hl.equal(localObject1, localObject2)))
          {
            ev.z("Passback received");
            this.sS.bk();
            bool = true;
          }
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        ev.A(localURISyntaxException.getMessage());
      }
    }
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    ev.z("JavascriptAdWebViewClient::onLoadResource: " + paramString);
    if (!F(paramString)) {
      this.lL.bW().onLoadResource(this.lL, paramString);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    ev.z("JavascriptAdWebViewClient::onPageFinished: " + paramString);
    if (!this.sR)
    {
      this.sS.bj();
      this.sR = true;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    ev.z("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + paramString);
    boolean bool;
    if (!F(paramString))
    {
      bool = this.lL.bW().shouldOverrideUrlLoading(this.lL, paramString);
    }
    else
    {
      ev.z("shouldOverrideUrlLoading: received passback url");
      bool = true;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fd
 * JD-Core Version:    0.7.0.1
 */