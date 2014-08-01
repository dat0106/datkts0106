package com.google.android.gms.analytics;

import android.content.Context;
import java.util.Map;

class ai
  extends k<aj>
{
  public ai(Context paramContext)
  {
    super(paramContext, new a());
  }
  
  private static class a
    implements k.a<aj>
  {
    private final aj xt = new aj();
    
    public void a(String paramString, int paramInt)
    {
      if (!"ga_sessionTimeout".equals(paramString)) {
        aa.D("int configuration name not recognized:  " + paramString);
      } else {
        this.xt.xw = paramInt;
      }
    }
    
    public void c(String paramString1, String paramString2)
    {
      this.xt.xA.put(paramString1, paramString2);
    }
    
    public void c(String paramString, boolean paramBoolean)
    {
      int i = 1;
      aj localaj;
      if (!"ga_autoActivityTracking".equals(paramString))
      {
        if (!"ga_anonymizeIp".equals(paramString))
        {
          if (!"ga_reportUncaughtExceptions".equals(paramString))
          {
            aa.D("bool configuration name not recognized:  " + paramString);
          }
          else
          {
            localaj = this.xt;
            if (!paramBoolean) {
              i = 0;
            }
            localaj.xz = i;
          }
        }
        else
        {
          localaj = this.xt;
          if (!paramBoolean) {
            i = 0;
          }
          localaj.xy = i;
        }
      }
      else
      {
        localaj = this.xt;
        if (!paramBoolean) {
          i = 0;
        }
        localaj.xx = i;
      }
    }
    
    public void d(String paramString1, String paramString2)
    {
      if ("ga_trackingId".equals(paramString1)) {
        this.xt.xu = paramString2;
      }
      for (;;)
      {
        return;
        if ("ga_sampleFrequency".equals(paramString1)) {
          try
          {
            this.xt.xv = Double.parseDouble(paramString2);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            aa.A("Error parsing ga_sampleFrequency value: " + paramString2);
          }
        } else {
          aa.D("string configuration name not recognized:  " + paramString1);
        }
      }
    }
    
    public aj dy()
    {
      return this.xt;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ai
 * JD-Core Version:    0.7.0.1
 */