package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View.OnTouchListener;

public class PopupMenuCompat
{
  static final PopupMenuImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT < 19) {
      IMPL = new BasePopupMenuImpl();
    } else {
      IMPL = new KitKatPopupMenuImpl();
    }
  }
  
  public static View.OnTouchListener getDragToOpenListener(Object paramObject)
  {
    return IMPL.getDragToOpenListener(paramObject);
  }
  
  static class KitKatPopupMenuImpl
    extends PopupMenuCompat.BasePopupMenuImpl
  {
    public View.OnTouchListener getDragToOpenListener(Object paramObject)
    {
      return PopupMenuCompatKitKat.getDragToOpenListener(paramObject);
    }
  }
  
  static class BasePopupMenuImpl
    implements PopupMenuCompat.PopupMenuImpl
  {
    public View.OnTouchListener getDragToOpenListener(Object paramObject)
    {
      return null;
    }
  }
  
  static abstract interface PopupMenuImpl
  {
    public abstract View.OnTouchListener getDragToOpenListener(Object paramObject);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.PopupMenuCompat
 * JD-Core Version:    0.7.0.1
 */