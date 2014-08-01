package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

public class ViewParentCompat
{
  static final ViewParentCompatImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT < 14) {
      IMPL = new ViewParentCompatStubImpl();
    } else {
      IMPL = new ViewParentCompatICSImpl();
    }
  }
  
  public static boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return IMPL.requestSendAccessibilityEvent(paramViewParent, paramView, paramAccessibilityEvent);
  }
  
  static class ViewParentCompatICSImpl
    extends ViewParentCompat.ViewParentCompatStubImpl
  {
    public boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return ViewParentCompatICS.requestSendAccessibilityEvent(paramViewParent, paramView, paramAccessibilityEvent);
    }
  }
  
  static class ViewParentCompatStubImpl
    implements ViewParentCompat.ViewParentCompatImpl
  {
    public boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      boolean bool;
      if (paramView != null)
      {
        ((AccessibilityManager)paramView.getContext().getSystemService("accessibility")).sendAccessibilityEvent(paramAccessibilityEvent);
        bool = true;
      }
      else
      {
        bool = false;
      }
      return bool;
    }
  }
  
  static abstract interface ViewParentCompatImpl
  {
    public abstract boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewParentCompat
 * JD-Core Version:    0.7.0.1
 */