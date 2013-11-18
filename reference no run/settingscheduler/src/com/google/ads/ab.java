package com.google.ads;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.a;
import com.google.ads.internal.d;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import com.google.ads.util.f;
import java.util.HashMap;

public class ab
  implements n
{
  private static final a a = (a)a.a.b();
  
  protected int a(HashMap<String, String> paramHashMap, String paramString, int paramInt, DisplayMetrics paramDisplayMetrics)
  {
    String str = (String)paramHashMap.get(paramString);
    if (str != null) {}
    try
    {
      f = TypedValue.applyDimension(1, Integer.parseInt(str), paramDisplayMetrics);
      paramInt = (int)f;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        float f;
        b.a("Could not parse \"" + paramString + "\" in a video gmsg: " + f);
      }
    }
    return paramInt;
  }
  
  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    String str2 = (String)paramHashMap.get("action");
    if (str2 == null) {
      b.a("No \"action\" parameter in a video gmsg.");
    }
    for (;;)
    {
      return;
      AdActivity localAdActivity;
      if ((paramWebView instanceof AdWebView))
      {
        AdWebView localAdWebView = (AdWebView)paramWebView;
        localAdActivity = localAdWebView.d();
        if (localAdActivity == null) {
          b.a("Could not get adActivity for a video gmsg.");
        }
      }
      else
      {
        b.a("Could not get adWebView for a video gmsg.");
        continue;
      }
      boolean bool1 = str2.equals("new");
      boolean bool2 = str2.equals("position");
      int m;
      int j;
      int k;
      if ((bool1) || (bool2))
      {
        DisplayMetrics localDisplayMetrics2 = AdUtil.a(localAdActivity);
        m = a(paramHashMap, "x", 0, localDisplayMetrics2);
        j = a(paramHashMap, "y", 0, localDisplayMetrics2);
        k = a(paramHashMap, "w", -1, localDisplayMetrics2);
        int n = a(paramHashMap, "h", -1, localDisplayMetrics2);
        if ((bool1) && (localAdActivity.getAdVideoView() == null)) {
          localAdActivity.newAdVideoView(m, j, k, n);
        } else {
          localAdActivity.moveAdVideoView(m, j, k, n);
        }
      }
      else
      {
        AdVideoView localAdVideoView = localAdActivity.getAdVideoView();
        if (localAdVideoView == null)
        {
          a.a(k, "onVideoEvent", "{'event': 'error', 'what': 'no_video_view'}");
        }
        else
        {
          long l;
          if (j.equals("click"))
          {
            DisplayMetrics localDisplayMetrics1 = AdUtil.a(localAdActivity);
            int i = a(paramHashMap, "x", 0, localDisplayMetrics1);
            m = a(paramHashMap, "y", 0, localDisplayMetrics1);
            l = SystemClock.uptimeMillis();
            localAdVideoView.a(MotionEvent.obtain(l, l, 0, i, m, 0));
          }
          else
          {
            String str1;
            if (l.equals("controls"))
            {
              str1 = (String)paramHashMap.get("enabled");
              if (str1 == null) {
                b.a("No \"enabled\" parameter in a controls video gmsg.");
              } else if (str1.equals("true")) {
                localAdVideoView.setMediaControllerEnabled(true);
              } else {
                localAdVideoView.setMediaControllerEnabled(false);
              }
            }
            else if (l.equals("currentTime"))
            {
              str1 = (String)paramHashMap.get("time");
              if (str1 == null) {
                b.a("No \"time\" parameter in a currentTime video gmsg.");
              } else {
                try
                {
                  localAdVideoView.a((int)(1000.0F * Float.parseFloat(str1)));
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  b.a("Could not parse \"time\" parameter: " + str1);
                }
              }
            }
            else if (l.equals("hide"))
            {
              localAdVideoView.setVisibility(4);
            }
            else if (l.equals("load"))
            {
              localAdVideoView.b();
            }
            else if (l.equals("pause"))
            {
              localAdVideoView.c();
            }
            else if (l.equals("play"))
            {
              localAdVideoView.d();
            }
            else if (l.equals("show"))
            {
              localAdVideoView.setVisibility(0);
            }
            else if (l.equals("src"))
            {
              localAdVideoView.setSrc((String)paramHashMap.get("src"));
            }
            else
            {
              b.a("Unknown video action: " + l);
            }
          }
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.ab
 * JD-Core Version:    0.7.0.1
 */