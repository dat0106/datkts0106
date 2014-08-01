package com.google.android.gms.analytics;

import android.content.Context;

class v
  extends k<w>
{
  public v(Context paramContext)
  {
    super(paramContext, new a());
  }
  
  private static class a
    implements k.a<w>
  {
    private final w wf = new w();
    
    public void a(String paramString, int paramInt)
    {
      if (!"ga_dispatchPeriod".equals(paramString)) {
        aa.D("int configuration name not recognized:  " + paramString);
      } else {
        this.wf.wh = paramInt;
      }
    }
    
    public void c(String paramString1, String paramString2) {}
    
    public void c(String paramString, boolean paramBoolean)
    {
      if (!"ga_dryRun".equals(paramString))
      {
        aa.D("bool configuration name not recognized:  " + paramString);
      }
      else
      {
        w localw = this.wf;
        int i;
        if (!paramBoolean) {
          i = 0;
        } else {
          i = 1;
        }
        localw.wi = i;
      }
    }
    
    public w cS()
    {
      return this.wf;
    }
    
    public void d(String paramString1, String paramString2)
    {
      if (!"ga_appName".equals(paramString1))
      {
        if (!"ga_appVersion".equals(paramString1))
        {
          if (!"ga_logLevel".equals(paramString1)) {
            aa.D("string configuration name not recognized:  " + paramString1);
          } else {
            this.wf.wg = paramString2;
          }
        }
        else {
          this.wf.tA = paramString2;
        }
      }
      else {
        this.wf.tz = paramString2;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.v
 * JD-Core Version:    0.7.0.1
 */