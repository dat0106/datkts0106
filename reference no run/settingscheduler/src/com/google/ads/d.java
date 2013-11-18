package com.google.ads;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

public class d
{
  private c a = null;
  private long b = -1L;
  
  public void a(c paramc, int paramInt)
  {
    this.a = paramc;
    this.b = (TimeUnit.MILLISECONDS.convert(paramInt, TimeUnit.SECONDS) + SystemClock.elapsedRealtime());
  }
  
  public boolean a()
  {
    boolean bool;
    if ((this.a == null) || (SystemClock.elapsedRealtime() >= this.b)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public c b()
  {
    return this.a;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.d
 * JD-Core Version:    0.7.0.1
 */