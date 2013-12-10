package com.astuetz.viewpager.extensions;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewPagerObserver
  implements ViewPager.OnPageChangeListener
{
  private static final String TAG = "com.astuetz.viewpager.extensions";
  private ArrayList<ViewPager.OnPageChangeListener> mListeners = new ArrayList();
  
  public void addListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mListeners.add(paramOnPageChangeListener);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((ViewPager.OnPageChangeListener)localIterator.next()).onPageSelected(paramInt);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.viewpager.extensions.ViewPagerObserver
 * JD-Core Version:    0.7.0.1
 */