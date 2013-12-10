package com.smartandroidapps.audiowidgetlib.guidedtour;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.RunTimeConfig;

public class GuidedTourPagerAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  public static final String SHOW_HINTS = "hints";
  protected transient Activity mContext;
  private int mLastPage;
  private int mLength = 0;
  private int[] mPageLayouts;
  private int[] mPageLayoutsPaid;
  private int[] mPages;
  
  public GuidedTourPagerAdapter(Activity paramActivity, int paramInt)
  {
    int[] arrayOfInt = new int[9];
    arrayOfInt[0] = R.layout.guided_tour_page_1;
    arrayOfInt[1] = R.layout.guided_tour_page_2;
    arrayOfInt[2] = R.layout.guided_tour_page_3;
    arrayOfInt[3] = R.layout.guided_tour_page_4;
    arrayOfInt[4] = R.layout.guided_tour_page_5;
    arrayOfInt[5] = R.layout.guided_tour_page_6;
    arrayOfInt[6] = R.layout.guided_tour_page_7;
    arrayOfInt[7] = R.layout.guided_tour_page_8;
    arrayOfInt[8] = R.layout.guided_tour_page_9;
    this.mPageLayouts = arrayOfInt;
    arrayOfInt = new int[8];
    arrayOfInt[0] = R.layout.guided_tour_page_1;
    arrayOfInt[1] = R.layout.guided_tour_page_2;
    arrayOfInt[2] = R.layout.guided_tour_page_3;
    arrayOfInt[3] = R.layout.guided_tour_page_4;
    arrayOfInt[4] = R.layout.guided_tour_page_5;
    arrayOfInt[5] = R.layout.guided_tour_page_6;
    arrayOfInt[6] = R.layout.guided_tour_page_7;
    arrayOfInt[7] = R.layout.guided_tour_page_9_paid;
    this.mPageLayoutsPaid = arrayOfInt;
    this.mContext = paramActivity;
    this.mLength = paramInt;
    if (!RunTimeConfig.isFullVersion(paramActivity))
    {
      this.mPages = this.mPageLayouts;
      this.mLastPage = 8;
    }
    else
    {
      this.mPages = this.mPageLayoutsPaid;
      this.mLastPage = 7;
    }
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)paramObject);
  }
  
  public void finishUpdate(View paramView) {}
  
  public int getCount()
  {
    return this.mLength;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    View localView = this.mContext.getLayoutInflater().inflate(this.mPages[paramInt], null);
    ((ViewPager)paramView).addView(localView, 0);
    if (paramInt == this.mLastPage) {
      ((Button)localView.findViewById(R.id.continueButton)).setOnClickListener(this);
    }
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    boolean bool;
    if (paramView != (View)paramObject) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.continueButton)
    {
      this.mContext.setResult(-1);
      this.mContext.finish();
    }
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
  }
  
  public void startUpdate(View paramView) {}
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.guidedtour.GuidedTourPagerAdapter
 * JD-Core Version:    0.7.0.1
 */