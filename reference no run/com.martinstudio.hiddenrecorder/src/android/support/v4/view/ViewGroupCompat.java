package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ViewGroupCompat
{
  static final ViewGroupCompatImpl IMPL;
  public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
  public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 18)
    {
      if (i < 14)
      {
        if (i < 11) {
          IMPL = new ViewGroupCompatStubImpl();
        } else {
          IMPL = new ViewGroupCompatHCImpl();
        }
      }
      else {
        IMPL = new ViewGroupCompatIcsImpl();
      }
    }
    else {
      IMPL = new ViewGroupCompatJellybeanMR2Impl();
    }
  }
  
  public static int getLayoutMode(ViewGroup paramViewGroup)
  {
    return IMPL.getLayoutMode(paramViewGroup);
  }
  
  public static boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return IMPL.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public static void setLayoutMode(ViewGroup paramViewGroup, int paramInt)
  {
    IMPL.setLayoutMode(paramViewGroup, paramInt);
  }
  
  public static void setMotionEventSplittingEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    IMPL.setMotionEventSplittingEnabled(paramViewGroup, paramBoolean);
  }
  
  static class ViewGroupCompatJellybeanMR2Impl
    extends ViewGroupCompat.ViewGroupCompatIcsImpl
  {
    public int getLayoutMode(ViewGroup paramViewGroup)
    {
      return ViewGroupCompatJellybeanMR2.getLayoutMode(paramViewGroup);
    }
    
    public void setLayoutMode(ViewGroup paramViewGroup, int paramInt)
    {
      ViewGroupCompatJellybeanMR2.setLayoutMode(paramViewGroup, paramInt);
    }
  }
  
  static class ViewGroupCompatIcsImpl
    extends ViewGroupCompat.ViewGroupCompatHCImpl
  {
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
  }
  
  static class ViewGroupCompatHCImpl
    extends ViewGroupCompat.ViewGroupCompatStubImpl
  {
    public void setMotionEventSplittingEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      ViewGroupCompatHC.setMotionEventSplittingEnabled(paramViewGroup, paramBoolean);
    }
  }
  
  static class ViewGroupCompatStubImpl
    implements ViewGroupCompat.ViewGroupCompatImpl
  {
    public int getLayoutMode(ViewGroup paramViewGroup)
    {
      return 0;
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return true;
    }
    
    public void setLayoutMode(ViewGroup paramViewGroup, int paramInt) {}
    
    public void setMotionEventSplittingEnabled(ViewGroup paramViewGroup, boolean paramBoolean) {}
  }
  
  static abstract interface ViewGroupCompatImpl
  {
    public abstract int getLayoutMode(ViewGroup paramViewGroup);
    
    public abstract boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent);
    
    public abstract void setLayoutMode(ViewGroup paramViewGroup, int paramInt);
    
    public abstract void setMotionEventSplittingEnabled(ViewGroup paramViewGroup, boolean paramBoolean);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewGroupCompat
 * JD-Core Version:    0.7.0.1
 */