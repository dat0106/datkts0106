package com.google.ads.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.AdSize;
import com.google.ads.m;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.g;
import com.google.ads.util.g.a;
import com.google.ads.util.h.a;
import com.google.ads.util.i.b;
import java.lang.ref.WeakReference;

public class AdWebView
  extends WebView
{
  private WeakReference<AdActivity> a;
  private AdSize b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public AdWebView(m paramm, AdSize paramAdSize)
  {
    super((Context)paramm.f.a());
    this.b = paramAdSize;
    this.a = null;
    this.c = false;
    this.d = false;
    this.e = false;
    setBackgroundColor(0);
    AdUtil.a(this);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setSupportMultipleWindows(false);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSavePassword(false);
    setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        try
        {
          Intent localIntent = new Intent("android.intent.action.VIEW");
          localIntent.setDataAndType(Uri.parse(paramAnonymousString1), paramAnonymousString4);
          AdActivity localAdActivity = AdWebView.this.d();
          if ((localAdActivity != null) && (AdUtil.a(localIntent, localAdActivity))) {
            localAdActivity.startActivity(localIntent);
          }
          return;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          for (;;)
          {
            b.a("Couldn't find an Activity to view url/mimetype: " + paramAnonymousString1 + " / " + paramAnonymousString4);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            b.b("Unknown error trying to start activity to view URL: " + paramAnonymousString1, localThrowable);
          }
        }
      }
    });
    if (AdUtil.a >= 11) {
      g.a(localWebSettings, paramm);
    }
    setScrollBarStyle(33554432);
    if (AdUtil.a < 14)
    {
      if (AdUtil.a >= 11) {
        setWebChromeClient(new g.a(paramm));
      }
    }
    else {
      setWebChromeClient(new h.a(paramm));
    }
  }
  
  public void a()
  {
    AdActivity localAdActivity = d();
    if (localAdActivity != null) {
      localAdActivity.finish();
    }
  }
  
  public void b()
  {
    if (AdUtil.a >= 11) {
      g.a(this);
    }
    this.d = true;
  }
  
  public void c()
  {
    if ((this.d) && (AdUtil.a >= 11)) {
      g.b(this);
    }
    this.d = false;
  }
  
  public AdActivity d()
  {
    AdActivity localAdActivity;
    if (this.a == null) {
      localAdActivity = null;
    } else {
      localAdActivity = (AdActivity)this.a.get();
    }
    return localAdActivity;
  }
  
  public void destroy()
  {
    try
    {
      super.destroy();
      setWebViewClient(new WebViewClient());
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.b("An error occurred while destroying an AdWebView:", localThrowable);
      }
    }
  }
  
  public boolean e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.d;
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.b("An error occurred while loading data in AdWebView:", localThrowable);
      }
    }
  }
  
  public void loadUrl(String paramString)
  {
    try
    {
      super.loadUrl(paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.b("An error occurred while loading a URL in AdWebView:", localThrowable);
      }
    }
  }
  
  /**
   * @deprecated
   */
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = 2147483647;
    try
    {
      if (isInEditMode()) {
        super.onMeasure(paramInt1, paramInt2);
      }
      for (;;)
      {
        return;
        if ((this.b != null) && (!this.c)) {
          break;
        }
        super.onMeasure(paramInt1, paramInt2);
      }
      i2 = View.MeasureSpec.getMode(paramInt1);
    }
    finally {}
    int i2;
    int n = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt2);
    float f = getContext().getResources().getDisplayMetrics().density;
    int m = (int)(f * this.b.getWidth());
    int j = (int)(f * this.b.getHeight());
    if (i2 != -2147483648) {
      if (i2 == 1073741824) {
        break label226;
      }
    }
    for (;;)
    {
      label133:
      b.e("Not enough space to show ad! Wants: <" + m + ", " + j + ">, Has: <" + n + ", " + k + ">");
      setVisibility(8);
      setMeasuredDimension(n, k);
      break;
      label226:
      label230:
      do
      {
        setMeasuredDimension(m, j);
        break;
        i2 = i1;
        break label230;
        i2 = n;
        if ((i == -2147483648) || (i == 1073741824)) {
          i1 = k;
        }
        if (m - f * 6.0F > i2) {
          break label133;
        }
      } while (j <= i1);
    }
  }
  
  public void setAdActivity(AdActivity paramAdActivity)
  {
    this.a = new WeakReference(paramAdActivity);
  }
  
  /**
   * @deprecated
   */
  public void setAdSize(AdSize paramAdSize)
  {
    try
    {
      this.b = paramAdSize;
      requestLayout();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCustomClose(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.a != null)
    {
      AdActivity localAdActivity = (AdActivity)this.a.get();
      if (localAdActivity != null) {
        localAdActivity.setCustomClose(paramBoolean);
      }
    }
  }
  
  public void setIsExpandedMraid(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void stopLoading()
  {
    try
    {
      super.stopLoading();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        b.d("An error occurred while stopping loading in AdWebView:", localThrowable);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.internal.AdWebView
 * JD-Core Version:    0.7.0.1
 */