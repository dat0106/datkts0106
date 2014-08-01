package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class gu
  extends Drawable
  implements Drawable.Callback
{
  private b FA;
  private Drawable FB;
  private Drawable FC;
  private boolean FD;
  private boolean FE;
  private boolean FF;
  private int FG;
  private boolean Fm = true;
  private int Fs = 0;
  private long Ft;
  private int Fu;
  private int Fv;
  private int Fw = 255;
  private int Fx;
  private int Fy = 0;
  private boolean Fz;
  
  public gu(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    if (paramDrawable1 == null) {
      paramDrawable1 = a.fc();
    }
    this.FB = paramDrawable1;
    paramDrawable1.setCallback(this);
    b localb = this.FA;
    localb.FK |= paramDrawable1.getChangingConfigurations();
    if (paramDrawable2 == null) {
      paramDrawable2 = a.fc();
    }
    this.FC = paramDrawable2;
    paramDrawable2.setCallback(this);
    localb = this.FA;
    localb.FK |= paramDrawable2.getChangingConfigurations();
  }
  
  gu(b paramb)
  {
    this.FA = new b(paramb);
  }
  
  public boolean canConstantState()
  {
    if (!this.FD)
    {
      boolean bool;
      if ((this.FB.getConstantState() == null) || (this.FC.getConstantState() == null)) {
        bool = false;
      } else {
        bool = true;
      }
      this.FE = bool;
      this.FD = true;
    }
    return this.FE;
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f2 = 1;
    int i = 0;
    switch (this.Fs)
    {
    case 1: 
      this.Ft = SystemClock.uptimeMillis();
      this.Fs = 2;
      break;
    case 2: 
      if (this.Ft >= 0L)
      {
        f1 = (float)(SystemClock.uptimeMillis() - this.Ft) / this.Fx;
        if (f1 < 1.0F) {
          f2 = 0;
        }
        if (f2 != 0) {
          this.Fs = 0;
        }
        f1 = Math.min(f1, 1.0F);
        this.Fy = ((int)(this.Fu + f1 * (this.Fv - this.Fu)));
      }
      break;
    }
    float f1 = f2;
    int j = this.Fy;
    boolean bool = this.Fm;
    Drawable localDrawable2 = this.FB;
    Drawable localDrawable1 = this.FC;
    if (f1 == 0)
    {
      if (bool) {
        localDrawable2.setAlpha(this.Fw - j);
      }
      localDrawable2.draw(paramCanvas);
      if (bool) {
        localDrawable2.setAlpha(this.Fw);
      }
      if (j > 0)
      {
        localDrawable1.setAlpha(j);
        localDrawable1.draw(paramCanvas);
        localDrawable1.setAlpha(this.Fw);
      }
      invalidateSelf();
    }
    else
    {
      if ((!bool) || (j == 0)) {
        localDrawable2.draw(paramCanvas);
      }
      if (j == this.Fw)
      {
        localDrawable1.setAlpha(this.Fw);
        localDrawable1.draw(paramCanvas);
      }
    }
  }
  
  public Drawable fb()
  {
    return this.FC;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.FA.FJ | this.FA.FK;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    b localb;
    if (!canConstantState())
    {
      localb = null;
    }
    else
    {
      this.FA.FJ = getChangingConfigurations();
      localb = this.FA;
    }
    return localb;
  }
  
  public int getIntrinsicHeight()
  {
    return Math.max(this.FB.getIntrinsicHeight(), this.FC.getIntrinsicHeight());
  }
  
  public int getIntrinsicWidth()
  {
    return Math.max(this.FB.getIntrinsicWidth(), this.FC.getIntrinsicWidth());
  }
  
  public int getOpacity()
  {
    if (!this.FF)
    {
      this.FG = Drawable.resolveOpacity(this.FB.getOpacity(), this.FC.getOpacity());
      this.FF = true;
    }
    return this.FG;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (iq.fX())
    {
      Drawable.Callback localCallback = getCallback();
      if (localCallback != null) {
        localCallback.invalidateDrawable(this);
      }
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.Fz) && (super.mutate() == this))
    {
      if (canConstantState())
      {
        this.FB.mutate();
        this.FC.mutate();
        this.Fz = true;
      }
    }
    else {
      return this;
    }
    throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.FB.setBounds(paramRect);
    this.FC.setBounds(paramRect);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (iq.fX())
    {
      Drawable.Callback localCallback = getCallback();
      if (localCallback != null) {
        localCallback.scheduleDrawable(this, paramRunnable, paramLong);
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.Fy == this.Fw) {
      this.Fy = paramInt;
    }
    this.Fw = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.FB.setColorFilter(paramColorFilter);
    this.FC.setColorFilter(paramColorFilter);
  }
  
  public void startTransition(int paramInt)
  {
    this.Fu = 0;
    this.Fv = this.Fw;
    this.Fy = 0;
    this.Fx = paramInt;
    this.Fs = 1;
    invalidateSelf();
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (iq.fX())
    {
      Drawable.Callback localCallback = getCallback();
      if (localCallback != null) {
        localCallback.unscheduleDrawable(this, paramRunnable);
      }
    }
  }
  
  private static final class a
    extends Drawable
  {
    private static final a FH = new a();
    private static final a FI = new a(null);
    
    public void draw(Canvas paramCanvas) {}
    
    public Drawable.ConstantState getConstantState()
    {
      return FI;
    }
    
    public int getOpacity()
    {
      return -2;
    }
    
    public void setAlpha(int paramInt) {}
    
    public void setColorFilter(ColorFilter paramColorFilter) {}
    
    private static final class a
      extends Drawable.ConstantState
    {
      public int getChangingConfigurations()
      {
        return 0;
      }
      
      public Drawable newDrawable()
      {
        return gu.a.fc();
      }
    }
  }
  
  static final class b
    extends Drawable.ConstantState
  {
    int FJ;
    int FK;
    
    b(b paramb)
    {
      if (paramb != null)
      {
        this.FJ = paramb.FJ;
        this.FK = paramb.FK;
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.FJ;
    }
    
    public Drawable newDrawable()
    {
      return new gu(this);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gu
 * JD-Core Version:    0.7.0.1
 */