package com.astuetz.viewpager.extensions;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;

public class ScrollingTabsView
  extends HorizontalScrollView
  implements ViewPager.OnPageChangeListener
{
  private static final String TAG = "com.astuetz.viewpager.extensions";
  private TabsAdapter mAdapter;
  private TabClickListener mClickListener;
  private LinearLayout mContainer;
  private Context mContext;
  private int mDividerColor = -10263709;
  private Drawable mDividerDrawable;
  private int mDividerMarginBottom = 12;
  private int mDividerMarginTop = 12;
  private int mDividerWidth = 1;
  private ViewPager mPager;
  private ArrayList<View> mTabs = new ArrayList();
  
  public ScrollingTabsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollingTabsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrollingTabsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.mDividerMarginTop = ((int)(getResources().getDisplayMetrics().density * this.mDividerMarginTop));
    this.mDividerMarginBottom = ((int)(getResources().getDisplayMetrics().density * this.mDividerMarginBottom));
    this.mDividerWidth = ((int)(getResources().getDisplayMetrics().density * this.mDividerWidth));
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewPagerExtensions, paramInt, 0);
    this.mDividerColor = ((TypedArray)localObject).getColor(7, this.mDividerColor);
    this.mDividerMarginTop = ((TypedArray)localObject).getDimensionPixelSize(8, this.mDividerMarginTop);
    this.mDividerMarginBottom = ((TypedArray)localObject).getDimensionPixelSize(9, this.mDividerMarginBottom);
    this.mDividerDrawable = ((TypedArray)localObject).getDrawable(10);
    ((TypedArray)localObject).recycle();
    setHorizontalScrollBarEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
    this.mContainer = new LinearLayout(paramContext);
    localObject = new LinearLayout.LayoutParams(-1, -1);
    this.mContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mContainer.setOrientation(0);
    addView(this.mContainer);
  }
  
  private View getSeparator()
  {
    View localView = new View(this.mContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.mDividerWidth, -1);
    localLayoutParams.setMargins(0, this.mDividerMarginTop, 0, this.mDividerMarginBottom);
    localView.setLayoutParams(localLayoutParams);
    if (this.mDividerDrawable == null) {
      localView.setBackgroundColor(this.mDividerColor);
    } else {
      localView.setBackgroundDrawable(this.mDividerDrawable);
    }
    return localView;
  }
  
  private void initTabs()
  {
    this.mContainer.removeAllViews();
    this.mTabs.clear();
    if (this.mAdapter != null) {}
    for (int j = 0;; j++)
    {
      if (j >= this.mPager.getAdapter().getCount())
      {
        selectTab(this.mPager.getCurrentItem());
        return;
      }
      final int i = j;
      View localView = this.mAdapter.getView(j);
      this.mContainer.addView(localView);
      localView.setFocusable(true);
      this.mTabs.add(localView);
      if (j != -1 + this.mPager.getAdapter().getCount()) {
        this.mContainer.addView(getSeparator());
      }
      localView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (ScrollingTabsView.this.mClickListener != null) {
            ScrollingTabsView.this.mClickListener.onClick(i);
          }
          if (ScrollingTabsView.this.mPager.getCurrentItem() != i) {
            ScrollingTabsView.this.mPager.setCurrentItem(i);
          } else {
            ScrollingTabsView.this.selectTab(i);
          }
        }
      });
    }
  }
  
  private void selectTab(int paramInt)
  {
    int k = 0;
    View localView1;
    for (int i = 0;; localView1++)
    {
      if (k >= this.mContainer.getChildCount())
      {
        localView1 = this.mContainer.getChildAt(paramInt * 2);
        if (localView1 != null)
        {
          int j = localView1.getMeasuredWidth();
          smoothScrollTo(localView1.getLeft() - getWidth() / 2 + j / 2, getScrollY());
        }
        return;
      }
      View localView2 = this.mContainer.getChildAt(k);
      boolean bool;
      if (localView1 != paramInt) {
        bool = false;
      } else {
        bool = true;
      }
      localView2.setSelected(bool);
      k += 2;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      selectTab(this.mPager.getCurrentItem());
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    selectTab(paramInt);
  }
  
  public void setAdapter(TabsAdapter paramTabsAdapter)
  {
    this.mAdapter = paramTabsAdapter;
    if ((this.mPager != null) && (this.mAdapter != null)) {
      initTabs();
    }
  }
  
  public void setTabClickListener(TabClickListener paramTabClickListener)
  {
    this.mClickListener = paramTabClickListener;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.mPager = paramViewPager;
    this.mPager.setOnPageChangeListener(this);
    if ((this.mPager != null) && (this.mAdapter != null)) {
      initTabs();
    }
  }
  
  public static abstract interface TabClickListener
  {
    public abstract void onClick(int paramInt);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.viewpager.extensions.ScrollingTabsView
 * JD-Core Version:    0.7.0.1
 */