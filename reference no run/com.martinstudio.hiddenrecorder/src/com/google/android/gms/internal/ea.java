package com.google.android.gms.internal;

import java.util.Map;

public final class ea
{
  private ey lL;
  private final Object lq = new Object();
  private int pH = -2;
  public final bd qA = new bd()
  {
    public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
    {
      synchronized (ea.a(ea.this))
      {
        ec localec = new ec(paramAnonymousMap);
        ev.D("Invalid " + localec.getType() + " request error: " + localec.bt());
        ea.a(ea.this, 1);
        ea.a(ea.this).notify();
        return;
      }
    }
  };
  public final bd qB = new bd()
  {
    public void b(ey paramAnonymousey, Map<String, String> paramAnonymousMap)
    {
      synchronized (ea.a(ea.this))
      {
        ec localec = new ec(paramAnonymousMap);
        String str = localec.getUrl();
        if (str == null)
        {
          ev.D("URL missing in loadAdUrl GMSG.");
        }
        else
        {
          if (str.contains("%40mediation_adapters%40"))
          {
            str = str.replaceAll("%40mediation_adapters%40", em.a(paramAnonymousey.getContext(), (String)paramAnonymousMap.get("check_adapters"), ea.b(ea.this)));
            ev.C("Ad request URL modified to " + str);
          }
          ea.a(ea.this, localec);
          ea.a(ea.this).notify();
        }
      }
    }
  };
  private String qy;
  private ec qz;
  
  public ea(String paramString)
  {
    this.qy = paramString;
  }
  
  public void b(ey paramey)
  {
    synchronized (this.lq)
    {
      this.lL = paramey;
      return;
    }
  }
  
  public ec bs()
  {
    synchronized (this.lq)
    {
      for (;;)
      {
        if (this.qz == null)
        {
          int i = this.pH;
          if (i == -2) {
            try
            {
              this.lq.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              ev.D("Ad request service was interrupted.");
              return null;
            }
          }
        }
      }
      ec localec1 = this.qz;
    }
    return localec2;
  }
  
  public int getErrorCode()
  {
    synchronized (this.lq)
    {
      int i = this.pH;
      return i;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ea
 * JD-Core Version:    0.7.0.1
 */