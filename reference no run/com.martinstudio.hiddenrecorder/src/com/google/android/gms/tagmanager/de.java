package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

class de
{
  private GoogleAnalytics aig;
  private Context mContext;
  private Tracker tM;
  
  de(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  /**
   * @deprecated
   */
  private void cn(String paramString)
  {
    try
    {
      if (this.aig == null)
      {
        this.aig = GoogleAnalytics.getInstance(this.mContext);
        this.aig.setLogger(new a());
        this.tM = this.aig.newTracker(paramString);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Tracker cm(String paramString)
  {
    cn(paramString);
    return this.tM;
  }
  
  static class a
    implements Logger
  {
    private static int dv(int paramInt)
    {
      int i = 3;
      switch (paramInt)
      {
      case 2: 
        i = 0;
        break;
      case 3: 
      case 4: 
        i = 1;
        break;
      case 5: 
        i = 2;
      }
      return i;
    }
    
    public void error(Exception paramException)
    {
      bh.b("", paramException);
    }
    
    public void error(String paramString)
    {
      bh.A(paramString);
    }
    
    public int getLogLevel()
    {
      return dv(bh.getLogLevel());
    }
    
    public void info(String paramString)
    {
      bh.B(paramString);
    }
    
    public void setLogLevel(int paramInt)
    {
      bh.D("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }
    
    public void verbose(String paramString)
    {
      bh.C(paramString);
    }
    
    public void warn(String paramString)
    {
      bh.D(paramString);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.de
 * JD-Core Version:    0.7.0.1
 */