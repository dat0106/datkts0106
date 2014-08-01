package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;

public class dp
  implements Runnable
{
  private final int ks;
  private final int kt;
  protected final ey lL;
  private final Handler pI;
  private final long pJ;
  private long pK;
  private ez.a pL;
  protected boolean pM;
  protected boolean pN;
  
  public dp(ez.a parama, ey paramey, int paramInt1, int paramInt2)
  {
    this(parama, paramey, paramInt1, paramInt2, 200L, 50L);
  }
  
  public dp(ez.a parama, ey paramey, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.pJ = paramLong1;
    this.pK = paramLong2;
    this.pI = new Handler(Looper.getMainLooper());
    this.lL = paramey;
    this.pL = parama;
    this.pM = false;
    this.pN = false;
    this.kt = paramInt2;
    this.ks = paramInt1;
  }
  
  public void a(dv paramdv, fd paramfd)
  {
    this.lL.setWebViewClient(paramfd);
    ey localey = this.lL;
    String str;
    if (!TextUtils.isEmpty(paramdv.oy)) {
      str = ep.v(paramdv.oy);
    } else {
      str = null;
    }
    localey.loadDataWithBaseURL(str, paramdv.qb, "text/html", "UTF-8", null);
  }
  
  public void b(dv paramdv)
  {
    a(paramdv, new fd(this, this.lL, paramdv.qk));
  }
  
  public void bj()
  {
    this.pI.postDelayed(this, this.pJ);
  }
  
  /**
   * @deprecated
   */
  public void bk()
  {
    try
    {
      this.pM = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public boolean bl()
  {
    try
    {
      boolean bool = this.pM;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean bm()
  {
    return this.pN;
  }
  
  public void run()
  {
    if ((this.lL != null) && (!bl())) {
      new a(this.lL).execute(new Void[0]);
    } else {
      this.pL.a(this.lL);
    }
  }
  
  protected final class a
    extends AsyncTask<Void, Void, Boolean>
  {
    private final WebView pO;
    private Bitmap pP;
    
    public a(WebView paramWebView)
    {
      this.pO = paramWebView;
    }
    
    /**
     * @deprecated
     */
    protected Boolean a(Void... paramVarArgs)
    {
      for (;;)
      {
        int m;
        try
        {
          int i1 = this.pP.getWidth();
          int k = this.pP.getHeight();
          if ((i1 == 0) || (k == 0))
          {
            Boolean localBoolean1 = Boolean.valueOf(false);
            localBoolean1 = localBoolean1;
            return localBoolean1;
          }
          m = 0;
          int n = 0;
          int i;
          if (m < i1)
          {
            i = 0;
            if (i >= k) {
              break label126;
            }
            if (this.pP.getPixel(m, i) != 0) {
              n++;
            }
          }
          else
          {
            if (n / (i1 * k / 100.0D) > 0.1D)
            {
              i = 1;
              Boolean localBoolean2 = Boolean.valueOf(i);
              localBoolean2 = localBoolean2;
              continue;
            }
            int j = 0;
            continue;
          }
          localObject += 10;
        }
        finally {}
        continue;
        label126:
        m += 10;
      }
    }
    
    protected void a(Boolean paramBoolean)
    {
      dp.c(dp.this);
      if ((!paramBoolean.booleanValue()) && (!dp.this.bl()) && (dp.d(dp.this) > 0L))
      {
        if (dp.d(dp.this) > 0L)
        {
          if (ev.p(2)) {
            ev.z("Ad not detected, scheduling another run.");
          }
          dp.g(dp.this).postDelayed(dp.this, dp.f(dp.this));
        }
      }
      else
      {
        dp.this.pN = paramBoolean.booleanValue();
        dp.e(dp.this).a(dp.this.lL);
      }
    }
    
    /**
     * @deprecated
     */
    protected void onPreExecute()
    {
      try
      {
        this.pP = Bitmap.createBitmap(dp.a(dp.this), dp.b(dp.this), Bitmap.Config.ARGB_8888);
        this.pO.setVisibility(0);
        this.pO.measure(View.MeasureSpec.makeMeasureSpec(dp.a(dp.this), 0), View.MeasureSpec.makeMeasureSpec(dp.b(dp.this), 0));
        this.pO.layout(0, 0, dp.a(dp.this), dp.b(dp.this));
        Canvas localCanvas = new Canvas(this.pP);
        this.pO.draw(localCanvas);
        this.pO.invalidate();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dp
 * JD-Core Version:    0.7.0.1
 */