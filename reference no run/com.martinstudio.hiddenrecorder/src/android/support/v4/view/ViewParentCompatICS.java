package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class ViewParentCompatICS
{
  public static boolean requestSendAccessibilityEvent(ViewParent paramViewParent, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return paramViewParent.requestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewParentCompatICS
 * JD-Core Version:    0.7.0.1
 */