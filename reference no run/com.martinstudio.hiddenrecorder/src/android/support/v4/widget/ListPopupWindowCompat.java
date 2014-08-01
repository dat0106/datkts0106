package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnTouchListener;

public class ListPopupWindowCompat
{
  static final ListPopupWindowImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT < 19) {
      IMPL = new BaseListPopupWindowImpl();
    } else {
      IMPL = new KitKatListPopupWindowImpl();
    }
  }
  
  public static View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView)
  {
    return IMPL.createDragToOpenListener(paramObject, paramView);
  }
  
  static class KitKatListPopupWindowImpl
    extends ListPopupWindowCompat.BaseListPopupWindowImpl
  {
    public View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView)
    {
      return ListPopupWindowCompatKitKat.createDragToOpenListener(paramObject, paramView);
    }
  }
  
  static class BaseListPopupWindowImpl
    implements ListPopupWindowCompat.ListPopupWindowImpl
  {
    public View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView)
    {
      return null;
    }
  }
  
  static abstract interface ListPopupWindowImpl
  {
    public abstract View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ListPopupWindowCompat
 * JD-Core Version:    0.7.0.1
 */