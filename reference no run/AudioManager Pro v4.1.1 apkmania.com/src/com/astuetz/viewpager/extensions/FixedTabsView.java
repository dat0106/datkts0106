package com.astuetz.viewpager.extensions;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;

public class FixedTabsView
  extends LinearLayout
  implements ViewPager.OnPageChangeListener
{
  private static final String TAG = "com.astuetz.viewpager.extensions";
  private TabsAdapter mAdapter;
  private Context mContext;
  private int mDividerColor = -10263709;
  private Drawable mDividerDrawable;
  private int mDividerMarginBottom = 21;
  private int mDividerMarginTop = 12;
  private ViewPager mPager;
  private ArrayList<View> mTabs = new ArrayList();
  
  public FixedTabsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FixedTabsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FixedTabsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewPagerExtensions, paramInt, 0);
    this.mDividerColor = localTypedArray.getColor(7, this.mDividerColor);
    this.mDividerMarginTop = localTypedArray.getDimensionPixelSize(8, this.mDividerMarginTop);
    this.mDividerMarginBottom = localTypedArray.getDimensionPixelSize(9, this.mDividerMarginBottom);
    this.mDividerDrawable = localTypedArray.getDrawable(10);
    localTypedArray.recycle();
    setOrientation(0);
  }
  
  private View getSeparator()
  {
    View localView = new View(this.mContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(1, -1);
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
    removeAllViews();
    this.mTabs.clear();
    if (this.mAdapter != null) {}
    for (int i = 0;; i++)
    {
      if (i >= this.mPager.getAdapter().getCount())
      {
        selectTab(this.mPager.getCurrentItem());
        return;
      }
      final int j = i;
      View localView = this.mAdapter.getView(i);
      localView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0F));
      addView(localView);
      this.mTabs.add(localView);
      if (i != -1 + this.mPager.getAdapter().getCount()) {
        addView(getSeparator());
      }
      localView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FixedTabsView.this.mPager.setCurrentItem(j);
        }
      });
    }
  }
  
  private void selectTab(int paramInt)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j >= getChildCount()) {
        return;
      }
      if ((getChildAt(j) instanceof ViewPagerTabButton))
      {
        View localView = getChildAt(j);
        boolean bool;
        if (i != paramInt) {
          bool = false;
        } else {
          bool = true;
        }
        localView.setSelected(bool);
        i++;
      }
      j++;
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
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.mPager = paramViewPager;
    this.mPager.setOnPageChangeListener(this);
    if ((this.mPager != null) && (this.mAdapter != null)) {
      initTabs();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.viewpager.extensions.FixedTabsView
 * JD-Core Version:    0.7.0.1
 */