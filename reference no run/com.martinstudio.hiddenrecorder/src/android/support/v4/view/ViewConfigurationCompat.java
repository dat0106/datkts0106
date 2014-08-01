package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class ViewConfigurationCompat
{
  static final ViewConfigurationVersionImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT < 11) {
      IMPL = new BaseViewConfigurationVersionImpl();
    } else {
      IMPL = new FroyoViewConfigurationVersionImpl();
    }
  }
  
  public static int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration)
  {
    return IMPL.getScaledPagingTouchSlop(paramViewConfiguration);
  }
  
  static class FroyoViewConfigurationVersionImpl
    implements ViewConfigurationCompat.ViewConfigurationVersionImpl
  {
    public int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration)
    {
      return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(paramViewConfiguration);
    }
  }
  
  static class BaseViewConfigurationVersionImpl
    implements ViewConfigurationCompat.ViewConfigurationVersionImpl
  {
    public int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration)
    {
      return paramViewConfiguration.getScaledTouchSlop();
    }
  }
  
  static abstract interface ViewConfigurationVersionImpl
  {
    public abstract int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewConfigurationCompat
 * JD-Core Version:    0.7.0.1
 */