package com.google.ads.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.m;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.i.b;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class f
  implements Runnable
{
  private final c a;
  private final d b;
  private final a c;
  private volatile boolean d;
  private boolean e;
  private String f;
  private Thread g = null;
  
  f(c paramc, d paramd)
  {
    this(paramc, paramd, new a()
    {
      public HttpURLConnection a(URL paramAnonymousURL)
        throws IOException
      {
        return (HttpURLConnection)paramAnonymousURL.openConnection();
      }
    });
  }
  
  f(c paramc, d paramd, a parama)
  {
    this.a = paramc;
    this.b = paramd;
    this.c = parama;
  }
  
  private void a(Context paramContext, HttpURLConnection paramHttpURLConnection)
  {
    String str = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("drt", "");
    if ((this.e) && (!TextUtils.isEmpty(str))) {
      if (AdUtil.a != 8) {
        paramHttpURLConnection.addRequestProperty("Cookie", str);
      } else {
        paramHttpURLConnection.addRequestProperty("X-Afma-drt-Cookie", str);
      }
    }
  }
  
  private void a(HttpURLConnection paramHttpURLConnection)
  {
    b(paramHttpURLConnection);
    f(paramHttpURLConnection);
    g(paramHttpURLConnection);
    h(paramHttpURLConnection);
    e(paramHttpURLConnection);
    i(paramHttpURLConnection);
    j(paramHttpURLConnection);
    k(paramHttpURLConnection);
    d(paramHttpURLConnection);
    c(paramHttpURLConnection);
    l(paramHttpURLConnection);
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, int paramInt)
    throws IOException
  {
    String str;
    if ((300 > paramInt) || (paramInt >= 400))
    {
      if (paramInt != 200)
      {
        if (paramInt != 400)
        {
          b.c("Invalid response code: " + paramInt);
          this.a.a(AdRequest.ErrorCode.INTERNAL_ERROR);
          a();
        }
        else
        {
          b.c("Bad request");
          this.a.a(AdRequest.ErrorCode.INVALID_REQUEST);
          a();
        }
      }
      else
      {
        a(paramHttpURLConnection);
        str = AdUtil.a(new InputStreamReader(paramHttpURLConnection.getInputStream())).trim();
        b.a("Response content is: " + str);
        if (!TextUtils.isEmpty(str))
        {
          this.a.a(str, this.f);
          a();
        }
        else
        {
          b.a("Response message is null or zero length: " + str);
          this.a.a(AdRequest.ErrorCode.NO_FILL);
          a();
        }
      }
    }
    else
    {
      str = paramHttpURLConnection.getHeaderField("Location");
      if (str != null)
      {
        a(paramHttpURLConnection);
        this.f = str;
      }
      else
      {
        b.c("Could not get redirect location from a " + paramInt + " redirect.");
        this.a.a(AdRequest.ErrorCode.INTERNAL_ERROR);
        a();
      }
    }
  }
  
  private void b()
    throws MalformedURLException, IOException
  {
    while (!this.d)
    {
      Object localObject1 = new URL(this.f);
      localObject1 = this.c.a((URL)localObject1);
      try
      {
        a((Context)this.b.h().f.a(), (HttpURLConnection)localObject1);
        AdUtil.a((HttpURLConnection)localObject1, (Context)this.b.h().f.a());
        ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
        ((HttpURLConnection)localObject1).connect();
        a((HttpURLConnection)localObject1, ((HttpURLConnection)localObject1).getResponseCode());
        ((HttpURLConnection)localObject1).disconnect();
      }
      finally
      {
        ((HttpURLConnection)localObject1).disconnect();
      }
    }
  }
  
  private void b(HttpURLConnection paramHttpURLConnection)
  {
    String str = paramHttpURLConnection.getHeaderField("X-Afma-Debug-Dialog");
    if (!TextUtils.isEmpty(str)) {
      this.a.e(str);
    }
  }
  
  private void c(HttpURLConnection paramHttpURLConnection)
  {
    String str = paramHttpURLConnection.getHeaderField("Content-Type");
    if (!TextUtils.isEmpty(str)) {
      this.a.b(str);
    }
  }
  
  private void d(HttpURLConnection paramHttpURLConnection)
  {
    String str = paramHttpURLConnection.getHeaderField("X-Afma-Mediation");
    if (!TextUtils.isEmpty(str)) {
      this.a.a(Boolean.valueOf(str).booleanValue());
    }
  }
  
  private void e(HttpURLConnection paramHttpURLConnection)
  {
    String str = paramHttpURLConnection.getHeaderField("X-Afma-Interstitial-Timeout");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      float f1 = Float.parseFloat(str);
      this.b.a((f1 * 1000.0F));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        b.d("Could not get timeout value: " + str, localNumberFormatException);
      }
    }
  }
  
  private void f(HttpURLConnection paramHttpURLConnection)
  {
    String str1 = paramHttpURLConnection.getHeaderField("X-Afma-Tracking-Urls");
    String[] arrayOfString;
    int j;
    if (!TextUtils.isEmpty(str1))
    {
      arrayOfString = str1.trim().split("\\s+");
      j = arrayOfString.length;
    }
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      String str2 = arrayOfString[i];
      this.b.b(str2);
    }
  }
  
  private void g(HttpURLConnection paramHttpURLConnection)
  {
    String str1 = paramHttpURLConnection.getHeaderField("X-Afma-Click-Tracking-Urls");
    String[] arrayOfString;
    int j;
    if (!TextUtils.isEmpty(str1))
    {
      arrayOfString = str1.trim().split("\\s+");
      j = arrayOfString.length;
    }
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      String str2 = arrayOfString[i];
      this.a.a(str2);
    }
  }
  
  private void h(HttpURLConnection paramHttpURLConnection)
  {
    String str = paramHttpURLConnection.getHeaderField("X-Afma-Refresh-Rate");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      f1 = Float.parseFloat(str);
      if (f1 > 0.0F)
      {
        this.b.a(f1);
        if (!this.b.s()) {
          this.b.f();
        }
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        float f1;
        b.d("Could not get refresh value: " + f1, localNumberFormatException);
        continue;
        if (this.b.s()) {
          this.b.e();
        }
      }
    }
  }
  
  private void i(HttpURLConnection paramHttpURLConnection)
  {
    String str = paramHttpURLConnection.getHeaderField("X-Afma-Orientation");
    if (!TextUtils.isEmpty(str)) {
      if (!str.equals("portrait"))
      {
        if (str.equals("landscape")) {
          this.a.a(AdUtil.a());
        }
      }
      else {
        this.a.a(AdUtil.b());
      }
    }
  }
  
  private void j(HttpURLConnection paramHttpURLConnection)
  {
    if (!TextUtils.isEmpty(paramHttpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life"))) {}
    try
    {
      long l = Long.parseLong(paramHttpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life"));
      this.b.b(l);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        b.e("Got bad value of Doritos cookie cache life from header: " + paramHttpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life") + ". Using default value instead.");
      }
    }
  }
  
  private void k(HttpURLConnection paramHttpURLConnection)
  {
    String str = paramHttpURLConnection.getHeaderField("Cache-Control");
    if (!TextUtils.isEmpty(str)) {
      this.a.c(str);
    }
  }
  
  private void l(HttpURLConnection paramHttpURLConnection)
  {
    String str = paramHttpURLConnection.getHeaderField("X-Afma-Ad-Size");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        String[] arrayOfString = str.split("x", 2);
        if (arrayOfString.length != 2)
        {
          b.e("Could not parse size header: " + str);
        }
        else
        {
          int i = Integer.parseInt(arrayOfString[0]);
          j = Integer.parseInt(arrayOfString[1]);
          this.a.a(new AdSize(i, j));
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int j;
        b.e("Could not parse size header: " + j);
      }
    }
  }
  
  void a()
  {
    this.d = true;
  }
  
  /**
   * @deprecated
   */
  void a(String paramString)
  {
    try
    {
      if (this.g == null)
      {
        this.f = paramString;
        this.d = false;
        this.g = new Thread(this);
        this.g.start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void run()
  {
    try
    {
      b();
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        b.b("Received malformed ad url from javascript.", localMalformedURLException);
        this.a.a(AdRequest.ErrorCode.INTERNAL_ERROR);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        b.d("IOException connecting to ad url.", localIOException);
        this.a.a(AdRequest.ErrorCode.NETWORK_ERROR);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.b("An unknown error occurred in AdResponseLoader.", localThrowable);
        this.a.a(AdRequest.ErrorCode.INTERNAL_ERROR);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract HttpURLConnection a(URL paramURL)
      throws IOException;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.internal.f
 * JD-Core Version:    0.7.0.1
 */