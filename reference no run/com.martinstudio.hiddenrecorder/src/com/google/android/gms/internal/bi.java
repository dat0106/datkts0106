package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

public final class bi
  implements bd
{
  private static int a(DisplayMetrics paramDisplayMetrics, Map<String, String> paramMap, String paramString, int paramInt)
  {
    String str = (String)paramMap.get(paramString);
    if (str != null) {}
    try
    {
      i = eu.a(paramDisplayMetrics, Integer.parseInt(str));
      paramInt = i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i;
        ev.D("Could not parse " + paramString + " in a video GMSG: " + i);
      }
    }
    return paramInt;
  }
  
  public void b(ey paramey, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("action");
    if (str == null) {
      ev.D("Action missing from video GMSG.");
    }
    for (;;)
    {
      return;
      Object localObject1 = paramey.bV();
      if (localObject1 == null)
      {
        ev.D("Could not get ad overlay for a video GMSG.");
      }
      else
      {
        boolean bool1 = "new".equalsIgnoreCase(str);
        boolean bool2 = "position".equalsIgnoreCase(str);
        int j;
        int m;
        if ((bool1) || (bool2))
        {
          DisplayMetrics localDisplayMetrics2 = paramey.getContext().getResources().getDisplayMetrics();
          j = a(localDisplayMetrics2, paramMap, "x", 0);
          int k = a(localDisplayMetrics2, paramMap, "y", 0);
          m = a(localDisplayMetrics2, paramMap, "w", -1);
          int n = a(localDisplayMetrics2, paramMap, "h", -1);
          if ((bool1) && (((cg)localObject1).aL() == null)) {
            ((cg)localObject1).c(j, k, m, n);
          } else {
            ((cg)localObject1).b(j, k, m, n);
          }
        }
        else
        {
          localObject1 = ((cg)localObject1).aL();
          if (localObject1 == null)
          {
            ck.a(paramey, "no_video_view", null);
          }
          else
          {
            long l;
            Object localObject2;
            if ("click".equalsIgnoreCase(j))
            {
              DisplayMetrics localDisplayMetrics1 = paramey.getContext().getResources().getDisplayMetrics();
              int i = a(localDisplayMetrics1, paramMap, "x", 0);
              m = a(localDisplayMetrics1, paramMap, "y", 0);
              l = SystemClock.uptimeMillis();
              localObject2 = MotionEvent.obtain(l, l, 0, i, m, 0);
              ((ck)localObject1).b((MotionEvent)localObject2);
              ((MotionEvent)localObject2).recycle();
            }
            else if ("controls".equalsIgnoreCase(l))
            {
              localObject2 = (String)paramMap.get("enabled");
              if (localObject2 == null) {
                ev.D("Enabled parameter missing from controls video GMSG.");
              } else {
                ((ck)localObject1).l(Boolean.parseBoolean((String)localObject2));
              }
            }
            else if ("currentTime".equalsIgnoreCase(l))
            {
              localObject2 = (String)paramMap.get("time");
              if (localObject2 == null) {
                ev.D("Time parameter missing from currentTime video GMSG.");
              } else {
                try
                {
                  ((ck)localObject1).seekTo((int)(1000.0F * Float.parseFloat((String)localObject2)));
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  ev.D("Could not parse time parameter from currentTime video GMSG: " + (String)localObject2);
                }
              }
            }
            else if ("hide".equalsIgnoreCase(l))
            {
              ((ck)localObject1).setVisibility(4);
            }
            else if ("load".equalsIgnoreCase(l))
            {
              ((ck)localObject1).aV();
            }
            else if ("pause".equalsIgnoreCase(l))
            {
              ((ck)localObject1).pause();
            }
            else if ("play".equalsIgnoreCase(l))
            {
              ((ck)localObject1).play();
            }
            else if ("show".equalsIgnoreCase(l))
            {
              ((ck)localObject1).setVisibility(0);
            }
            else if ("src".equalsIgnoreCase(l))
            {
              ((ck)localObject1).o((String)paramMap.get("src"));
            }
            else
            {
              ev.D("Unknown video action: " + l);
            }
          }
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bi
 * JD-Core Version:    0.7.0.1
 */