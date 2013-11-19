package com.sonyericsson.extras.liveware.utils;

import android.os.Build.VERSION;
import android.view.View;

public class UIUtilsJellyBeanMR1
{
  public static void setTextDirection(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      paramView.setTextDirection(5);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.UIUtilsJellyBeanMR1
 * JD-Core Version:    0.7.0.1
 */