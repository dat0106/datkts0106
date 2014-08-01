package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

public final class gs
{
  private static final go BD = new go("RequestTracker");
  public static final Object CK = new Object();
  private long CG;
  private long CH;
  private long CI;
  private gr CJ;
  
  public gs(long paramLong)
  {
    this.CG = paramLong;
    this.CH = -1L;
    this.CI = 0L;
  }
  
  private void ep()
  {
    this.CH = -1L;
    this.CJ = null;
    this.CI = 0L;
  }
  
  public void a(long paramLong, gr paramgr)
  {
    synchronized (CK)
    {
      gr localgr = this.CJ;
      long l = this.CH;
      this.CH = paramLong;
      this.CJ = paramgr;
      this.CI = SystemClock.elapsedRealtime();
      if (localgr != null) {
        localgr.n(l);
      }
      return;
    }
  }
  
  public boolean b(long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    boolean bool = true;
    Object localObject3 = null;
    for (;;)
    {
      synchronized (CK)
      {
        if ((this.CH != -1L) && (this.CH == paramLong))
        {
          localObject3 = BD;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Long.valueOf(this.CH);
          ((go)localObject3).b("request %d completed", arrayOfObject);
          localObject3 = this.CJ;
          ep();
          if (localObject3 != null) {
            ((gr)localObject3).a(paramLong, paramInt, paramJSONObject);
          }
          return bool;
        }
      }
      int i = 0;
    }
  }
  
  public boolean c(long paramLong, int paramInt)
  {
    return b(paramLong, paramInt, null);
  }
  
  public void clear()
  {
    synchronized (CK)
    {
      if (this.CH != -1L) {
        ep();
      }
      return;
    }
  }
  
  public boolean d(long paramLong, int paramInt)
  {
    boolean bool = true;
    long l1 = 0L;
    for (;;)
    {
      synchronized (CK)
      {
        if ((this.CH != -1L) && (paramLong - this.CI >= this.CG))
        {
          go localgo = BD;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Long.valueOf(this.CH);
          localgo.b("request %d timed out", arrayOfObject);
          long l2 = this.CH;
          localgr = this.CJ;
          ep();
          if (localgr != null) {
            localgr.a(l2, paramInt, null);
          }
          return bool;
        }
      }
      int i = 0;
      gr localgr = null;
    }
  }
  
  public boolean eq()
  {
    for (;;)
    {
      synchronized (CK)
      {
        if (this.CH != -1L)
        {
          boolean bool = true;
          return bool;
        }
      }
      int i = 0;
    }
  }
  
  public boolean p(long paramLong)
  {
    for (;;)
    {
      synchronized (CK)
      {
        if ((this.CH != -1L) && (this.CH == paramLong))
        {
          boolean bool = true;
          return bool;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gs
 * JD-Core Version:    0.7.0.1
 */