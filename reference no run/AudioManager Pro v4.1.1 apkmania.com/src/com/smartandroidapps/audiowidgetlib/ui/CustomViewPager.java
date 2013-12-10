package com.smartandroidapps.audiowidgetlib.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.smartandroidapps.audiowidgetlib.Constants;
import com.smartandroidapps.audiowidgetlib.data.SettingsManager;

public class CustomViewPager
  extends ViewPager
  implements Constants
{
  private boolean enabled;
  
  public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.enabled = new SettingsManager(paramContext).getEnableSwipeNavigation();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (!this.enabled) {
      bool = false;
    } else {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (!this.enabled) {
      bool = false;
    } else {
      bool = super.onTouchEvent(paramMotionEvent);
    }
    return bool;
  }
  
  public void setPagingEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.ui.CustomViewPager
 * JD-Core Version:    0.7.0.1
 */