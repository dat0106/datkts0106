package com.astuetz.viewpager.extensions;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class SwipeyTabsView
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnTouchListener
{
  private static final int SHADOW_WIDTH = 20;
  private static final String TAG = "com.astuetz.viewpager.extensions";
  private TabsAdapter mAdapter;
  private int mCenter = 0;
  private float mDragX = 0.0F;
  private int mHeightMeasureSpec = 0;
  private int mHighlightOffset = 0;
  private int mOutsideOffset = -1;
  private ViewPager mPager;
  private int mPosition;
  private ArrayList<TabPosition> mPositions = new ArrayList();
  private int mTabsCount = 0;
  private int mWidth = 0;
  private int mWidthMeasureSpec = 0;
  
  public SwipeyTabsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeyTabsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeyTabsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewPagerExtensions, paramInt, 0);
    this.mOutsideOffset = ((int)localTypedArray.getDimension(11, -1.0F));
    localTypedArray.recycle();
    setHorizontalFadingEdgeEnabled(true);
    setFadingEdgeLength((int)(20.0F * getResources().getDisplayMetrics().density));
    setWillNotDraw(false);
    setOnTouchListener(this);
  }
  
  private void alignCenter(int paramInt)
  {
    TabPosition localTabPosition = (TabPosition)this.mPositions.get(paramInt);
    localTabPosition.leftPos = left(paramInt);
    localTabPosition.oldPos = center(paramInt);
    localTabPosition.rightPos = right(paramInt);
  }
  
  private void alignLeft(int paramInt)
  {
    TabPosition localTabPosition = (TabPosition)this.mPositions.get(paramInt);
    localTabPosition.leftPos = leftOutside(paramInt);
    localTabPosition.oldPos = left(paramInt);
    localTabPosition.rightPos = center(paramInt);
  }
  
  private void alignLeftOutside(int paramInt, boolean paramBoolean)
  {
    TabPosition localTabPosition = (TabPosition)this.mPositions.get(paramInt);
    localTabPosition.oldPos = leftOutside(paramInt);
    localTabPosition.leftPos = localTabPosition.oldPos;
    int i;
    if (!paramBoolean) {
      i = localTabPosition.oldPos;
    } else {
      i = left(paramInt);
    }
    localTabPosition.rightPos = i;
  }
  
  private void alignRight(int paramInt)
  {
    TabPosition localTabPosition = (TabPosition)this.mPositions.get(paramInt);
    localTabPosition.leftPos = center(paramInt);
    localTabPosition.oldPos = right(paramInt);
    localTabPosition.rightPos = rightOutside(paramInt);
  }
  
  private void alignRightOutside(int paramInt, boolean paramBoolean)
  {
    TabPosition localTabPosition = (TabPosition)this.mPositions.get(paramInt);
    localTabPosition.oldPos = rightOutside(paramInt);
    localTabPosition.rightPos = localTabPosition.oldPos;
    int i;
    if (!paramBoolean) {
      i = localTabPosition.oldPos;
    } else {
      i = right(paramInt);
    }
    localTabPosition.leftPos = i;
  }
  
  private void calculateNewPositions(boolean paramBoolean)
  {
    if (this.mTabsCount != 0) {
      int j = this.mPosition;
    }
    TabPosition localTabPosition;
    for (int i = 0;; localTabPosition++)
    {
      Iterator localIterator;
      if (i >= this.mTabsCount)
      {
        preventFromOverlapping();
        if (paramBoolean) {
          localIterator = this.mPositions.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            requestLayout();
            return;
          }
          localTabPosition = (TabPosition)localIterator.next();
          localTabPosition.currentPos = localTabPosition.oldPos;
        }
      }
      if (localTabPosition >= localIterator - 2)
      {
        if (localTabPosition != localIterator - 2)
        {
          if (localTabPosition != localIterator - 1)
          {
            if (localTabPosition != localIterator)
            {
              if (localTabPosition != localIterator + 1)
              {
                if (localTabPosition != localIterator + 2)
                {
                  if (localTabPosition > localIterator + 2) {
                    alignRightOutside(localTabPosition, false);
                  }
                }
                else {
                  alignRightOutside(localTabPosition, true);
                }
              }
              else {
                alignRight(localTabPosition);
              }
            }
            else {
              alignCenter(localTabPosition);
            }
          }
          else {
            alignLeft(localTabPosition);
          }
        }
        else {
          alignLeftOutside(localTabPosition, true);
        }
      }
      else {
        alignLeftOutside(localTabPosition, false);
      }
    }
  }
  
  private int center(int paramInt)
  {
    int i = getChildAt(paramInt).getMeasuredWidth();
    return this.mWidth / 2 - i / 2;
  }
  
  private void initTabs()
  {
    removeAllViews();
    this.mPositions.clear();
    if ((this.mAdapter != null) && (this.mPager != null)) {}
    for (int i = 0;; i++)
    {
      if (i >= this.mPager.getAdapter().getCount())
      {
        this.mTabsCount = getChildCount();
        this.mPosition = this.mPager.getCurrentItem();
        return;
      }
      addTab(this.mAdapter.getView(i), i);
      this.mPositions.add(new TabPosition(null));
    }
  }
  
  private int left(int paramInt)
  {
    return 0 - getChildAt(paramInt).getPaddingLeft();
  }
  
  private int leftOutside(int paramInt)
  {
    return -1 * getChildAt(paramInt).getMeasuredWidth() - this.mOutsideOffset;
  }
  
  private void preventFromOverlapping()
  {
    int i = this.mPosition;
    TabPosition localTabPosition2;
    if (i <= 1) {
      localTabPosition2 = null;
    } else {
      localTabPosition2 = (TabPosition)this.mPositions.get(i - 2);
    }
    TabPosition localTabPosition4;
    if (i <= 0) {
      localTabPosition4 = null;
    } else {
      localTabPosition4 = (TabPosition)this.mPositions.get(i - 1);
    }
    TabPosition localTabPosition1 = (TabPosition)this.mPositions.get(i);
    TabPosition localTabPosition3;
    if (i >= -1 + this.mTabsCount) {
      localTabPosition3 = null;
    } else {
      localTabPosition3 = (TabPosition)this.mPositions.get(i + 1);
    }
    TabPosition localTabPosition5;
    if (i >= -2 + this.mTabsCount) {
      localTabPosition5 = null;
    } else {
      localTabPosition5 = (TabPosition)this.mPositions.get(localTabPosition5 + 2);
    }
    if ((localTabPosition2 != null) && (localTabPosition2.rightPos + localTabPosition2.width >= localTabPosition4.rightPos)) {
      localTabPosition4.rightPos -= localTabPosition2.width;
    }
    if (localTabPosition4 != null)
    {
      if (localTabPosition4.oldPos + localTabPosition4.width >= localTabPosition1.oldPos) {
        localTabPosition1.oldPos -= localTabPosition4.width;
      }
      if (localTabPosition1.rightPos <= localTabPosition4.rightPos + localTabPosition4.width) {
        localTabPosition4.rightPos += localTabPosition4.width;
      }
    }
    if (localTabPosition3 != null)
    {
      if (localTabPosition3.oldPos <= localTabPosition1.oldPos + localTabPosition1.width) {
        localTabPosition1.oldPos += localTabPosition1.width;
      }
      if (localTabPosition1.leftPos + localTabPosition1.width >= localTabPosition3.leftPos) {
        localTabPosition3.leftPos -= localTabPosition1.width;
      }
    }
    if ((localTabPosition5 != null) && (localTabPosition5.leftPos <= localTabPosition3.leftPos + localTabPosition3.width)) {
      localTabPosition3.leftPos += localTabPosition3.width;
    }
  }
  
  private int right(int paramInt)
  {
    View localView = getChildAt(paramInt);
    int i = localView.getMeasuredWidth();
    return this.mWidth - i + localView.getPaddingRight();
  }
  
  private int rightOutside(int paramInt)
  {
    return this.mWidth + this.mOutsideOffset;
  }
  
  public void addTab(View paramView, final int paramInt)
  {
    if (paramView != null)
    {
      addView(paramView);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          SwipeyTabsView.this.mPager.setCurrentItem(paramInt);
        }
      });
      paramView.setOnTouchListener(this);
    }
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    return 1.0F;
  }
  
  protected float getRightFadingEdgeStrength()
  {
    return 1.0F;
  }
  
  public void notifyDatasetChanged()
  {
    if ((this.mPager != null) && (this.mAdapter != null))
    {
      initTabs();
      measure(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
      calculateNewPositions(true);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingTop();
    for (int j = 0;; j++)
    {
      if (j >= this.mTabsCount) {
        return;
      }
      View localView = getChildAt(j);
      TabPosition localTabPosition = (TabPosition)this.mPositions.get(j);
      if ((localView instanceof SwipeyTab))
      {
        int k = ((TabPosition)this.mPositions.get(j)).currentPos + localView.getMeasuredWidth() / 2;
        int m = Math.abs(this.mCenter - k);
        int n = m * 100 / this.mHighlightOffset;
        SwipeyTab localSwipeyTab = (SwipeyTab)localView;
        if (m > this.mHighlightOffset) {
          m = 0;
        } else {
          m = 100 - n;
        }
        localSwipeyTab.setHighlightPercentage(m);
      }
      localView.layout(localTabPosition.currentPos, i, localTabPosition.currentPos + localTabPosition.width, i + localTabPosition.height);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    this.mWidthMeasureSpec = paramInt1;
    this.mHeightMeasureSpec = paramInt2;
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), -2147483648);
    int k = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), -2147483648);
    for (int j = 0;; j++)
    {
      if (j >= this.mTabsCount)
      {
        setMeasuredDimension(resolveSize(0, paramInt1), resolveSize(m + getPaddingTop() + getPaddingBottom(), paramInt2));
        return;
      }
      View localView = getChildAt(j);
      if (localView.getVisibility() != 8)
      {
        localView.measure(i, k);
        ((TabPosition)this.mPositions.get(j)).width = localView.getMeasuredWidth();
        ((TabPosition)this.mPositions.get(j)).height = localView.getMeasuredHeight();
        m = Math.max(m, ((TabPosition)this.mPositions.get(j)).height);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Direction localDirection = Direction.None;
    if (paramInt1 != this.mPosition)
    {
      this.mPosition = paramInt1;
      calculateNewPositions(true);
    }
    int i = this.mPosition * (this.mPager.getWidth() + this.mPager.getPageMargin());
    if (this.mPager.getScrollX() >= i)
    {
      if (this.mPager.getScrollX() > i) {
        localDirection = Direction.Right;
      }
    }
    else {
      localDirection = Direction.Left;
    }
    float f3 = 0.0F;
    if (localDirection != Direction.Left)
    {
      if (localDirection == Direction.Right) {
        f3 = paramFloat;
      }
    }
    else {
      f3 = 1.0F - paramFloat;
    }
    for (int j = 0;; j++)
    {
      if (j >= this.mTabsCount)
      {
        requestLayout();
        return;
      }
      TabPosition localTabPosition = (TabPosition)this.mPositions.get(j);
      float f1 = localTabPosition.oldPos;
      float f2;
      if (localDirection != Direction.Left)
      {
        if (localDirection != Direction.Right) {
          f2 = localTabPosition.oldPos;
        } else {
          f2 = localTabPosition.leftPos;
        }
      }
      else {
        f2 = localTabPosition.rightPos;
      }
      if (f2 != f1) {
        localTabPosition.currentPos = ((int)(f1 + (f2 * f3 - f1 * f3)));
      }
    }
  }
  
  public void onPageSelected(int paramInt) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mOutsideOffset < 0) {
      this.mOutsideOffset = paramInt1;
    }
    this.mWidth = paramInt1;
    this.mCenter = (paramInt1 / 2);
    this.mHighlightOffset = (paramInt1 / 5);
    if (this.mPager != null) {
      this.mPosition = this.mPager.getCurrentItem();
    }
    calculateNewPositions(true);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f = paramMotionEvent.getRawX();
    switch (paramMotionEvent.getAction())
    {
    case 0: 
      this.mDragX = f;
      this.mPager.beginFakeDrag();
      break;
    case 1: 
      if (this.mPager.isFakeDragging()) {
        this.mPager.endFakeDrag();
      }
      break;
    case 2: 
      if (this.mPager.isFakeDragging())
      {
        this.mPager.fakeDragBy(-1.0F * (this.mDragX - f));
        this.mDragX = f;
      }
      break;
    }
    boolean bool;
    if (!paramView.equals(this)) {
      bool = super.onTouchEvent(paramMotionEvent);
    } else {
      bool = true;
    }
    return bool;
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
  
  private class TabPosition
  {
    public int currentPos;
    public int height;
    public int leftPos;
    public int oldPos;
    public int rightPos;
    public int width;
    
    private TabPosition() {}
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("oldPos: ").append(this.oldPos).append(", ");
      localStringBuilder.append("leftPos: ").append(this.leftPos).append(", ");
      localStringBuilder.append("rightPos: ").append(this.rightPos).append(", ");
      localStringBuilder.append("currentPos: ").append(this.currentPos);
      return localStringBuilder.toString();
    }
  }
  
  private static enum Direction
  {
    static
    {
      Left = new Direction("Left", 1);
      Right = new Direction("Right", 2);
      Direction[] arrayOfDirection = new Direction[3];
      arrayOfDirection[0] = None;
      arrayOfDirection[1] = Left;
      arrayOfDirection[2] = Right;
      $VALUES = arrayOfDirection;
    }
    
    private Direction() {}
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.astuetz.viewpager.extensions.SwipeyTabsView
 * JD-Core Version:    0.7.0.1
 */