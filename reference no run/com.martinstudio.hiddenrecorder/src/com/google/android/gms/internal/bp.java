package com.google.android.gms.internal;

public final class bp
  extends bw.a
{
  private final Object lq = new Object();
  private br.a ny;
  private bo nz;
  
  public void a(bo parambo)
  {
    synchronized (this.lq)
    {
      this.nz = parambo;
      return;
    }
  }
  
  public void a(br.a parama)
  {
    synchronized (this.lq)
    {
      this.ny = parama;
      return;
    }
  }
  
  public void onAdClicked()
  {
    synchronized (this.lq)
    {
      if (this.nz != null) {
        this.nz.W();
      }
      return;
    }
  }
  
  public void onAdClosed()
  {
    synchronized (this.lq)
    {
      if (this.nz != null) {
        this.nz.X();
      }
      return;
    }
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    for (;;)
    {
      synchronized (this.lq)
      {
        if (this.ny != null)
        {
          if (paramInt == 3)
          {
            int i = 1;
            this.ny.g(i);
            this.ny = null;
          }
        }
        else {
          return;
        }
      }
      int j = 2;
    }
  }
  
  public void onAdLeftApplication()
  {
    synchronized (this.lq)
    {
      if (this.nz != null) {
        this.nz.Y();
      }
      return;
    }
  }
  
  public void onAdLoaded()
  {
    synchronized (this.lq)
    {
      if (this.ny != null)
      {
        this.ny.g(0);
        this.ny = null;
      }
      else if (this.nz != null)
      {
        this.nz.aa();
      }
    }
  }
  
  public void onAdOpened()
  {
    synchronized (this.lq)
    {
      if (this.nz != null) {
        this.nz.Z();
      }
      return;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bp
 * JD-Core Version:    0.7.0.1
 */