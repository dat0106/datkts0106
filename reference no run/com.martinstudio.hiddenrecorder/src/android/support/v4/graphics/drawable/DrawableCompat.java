package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public class DrawableCompat
{
  static final DrawableImpl IMPL;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 19)
    {
      if (i < 11) {
        IMPL = new BaseDrawableImpl();
      } else {
        IMPL = new HoneycombDrawableImpl();
      }
    }
    else {
      IMPL = new KitKatDrawableImpl();
    }
  }
  
  public static boolean isAutoMirrored(Drawable paramDrawable)
  {
    return IMPL.isAutoMirrored(paramDrawable);
  }
  
  public static void jumpToCurrentState(Drawable paramDrawable)
  {
    IMPL.jumpToCurrentState(paramDrawable);
  }
  
  public static void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
  {
    IMPL.setAutoMirrored(paramDrawable, paramBoolean);
  }
  
  static class KitKatDrawableImpl
    extends DrawableCompat.HoneycombDrawableImpl
  {
    public boolean isAutoMirrored(Drawable paramDrawable)
    {
      return DrawableCompatKitKat.isAutoMirrored(paramDrawable);
    }
    
    public void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
    {
      DrawableCompatKitKat.setAutoMirrored(paramDrawable, paramBoolean);
    }
  }
  
  static class HoneycombDrawableImpl
    extends DrawableCompat.BaseDrawableImpl
  {
    public void jumpToCurrentState(Drawable paramDrawable)
    {
      DrawableCompatHoneycomb.jumpToCurrentState(paramDrawable);
    }
  }
  
  static class BaseDrawableImpl
    implements DrawableCompat.DrawableImpl
  {
    public boolean isAutoMirrored(Drawable paramDrawable)
    {
      return false;
    }
    
    public void jumpToCurrentState(Drawable paramDrawable) {}
    
    public void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean) {}
  }
  
  static abstract interface DrawableImpl
  {
    public abstract boolean isAutoMirrored(Drawable paramDrawable);
    
    public abstract void jumpToCurrentState(Drawable paramDrawable);
    
    public abstract void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat
 * JD-Core Version:    0.7.0.1
 */