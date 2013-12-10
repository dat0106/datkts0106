package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.actionbarsherlock.R.id;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineFrameLayout;

public class ActionBarContainer
  extends NineFrameLayout
{
  private ActionBarView mActionBarView;
  private Drawable mBackground;
  private boolean mIsSplit;
  private boolean mIsStacked;
  private boolean mIsTransitioning;
  private Drawable mSplitBackground;
  private Drawable mStackedBackground;
  private View mTabContainer;
  
  public ActionBarContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundDrawable(null);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockActionBar);
    this.mBackground = localTypedArray.getDrawable(2);
    this.mStackedBackground = localTypedArray.getDrawable(12);
    if (getId() == R.id.abs__split_action_bar)
    {
      this.mIsSplit = bool;
      this.mSplitBackground = localTypedArray.getDrawable(3);
    }
    localTypedArray.recycle();
    if (!this.mIsSplit)
    {
      if ((this.mBackground != null) || (this.mStackedBackground != null)) {
        bool = false;
      }
    }
    else if (this.mSplitBackground != null) {
      bool = false;
    }
    setWillNotDraw(bool);
  }
  
  public View getTabContainer()
  {
    return this.mTabContainer;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((getWidth() != 0) && (getHeight() != 0)) {
      if (!this.mIsSplit)
      {
        if (this.mBackground != null) {
          this.mBackground.draw(paramCanvas);
        }
        if ((this.mStackedBackground != null) && (this.mIsStacked)) {
          this.mStackedBackground.draw(paramCanvas);
        }
      }
      else if (this.mSplitBackground != null)
      {
        this.mSplitBackground.draw(paramCanvas);
      }
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.mActionBarView = ((ActionBarView)findViewById(R.id.abs__action_bar));
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if ((!this.mIsTransitioning) && (!super.onInterceptTouchEvent(paramMotionEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    boolean bool;
    if ((this.mTabContainer == null) || (this.mTabContainer.getVisibility() == 8)) {
      bool = false;
    } else {
      bool = true;
    }
    int j;
    int i;
    if ((this.mTabContainer != null) && (this.mTabContainer.getVisibility() != 8))
    {
      j = getMeasuredHeight();
      i = this.mTabContainer.getMeasuredHeight();
      if ((0x2 & this.mActionBarView.getDisplayOptions()) != 0) {
        this.mTabContainer.layout(paramInt1, j - i, paramInt3, j);
      } else {
        j = getChildCount();
      }
    }
    for (int k = 0;; k++)
    {
      if (k >= j)
      {
        this.mTabContainer.layout(paramInt1, 0, paramInt3, i);
        i = 0;
        if (!this.mIsSplit)
        {
          if (this.mBackground != null)
          {
            this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
            i = 1;
          }
          if ((!bool) || (this.mStackedBackground == null)) {
            bool = false;
          } else {
            bool = true;
          }
          this.mIsStacked = bool;
          if (bool)
          {
            this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
            i = 1;
          }
        }
        else if (this.mSplitBackground != null)
        {
          this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
          i = 1;
        }
        if (i != 0) {
          invalidate();
        }
        return;
      }
      View localView = getChildAt(k);
      if ((localView != this.mTabContainer) && (!this.mActionBarView.isCollapsed())) {
        localView.offsetTopAndBottom(i);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.mActionBarView != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mActionBarView.getLayoutParams();
      int i;
      if (!this.mActionBarView.isCollapsed()) {
        i = this.mActionBarView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
      } else {
        i = 0;
      }
      if ((this.mTabContainer != null) && (this.mTabContainer.getVisibility() != 8) && (View.MeasureSpec.getMode(paramInt2) == -2147483648))
      {
        int j = View.MeasureSpec.getSize(paramInt2);
        setMeasuredDimension(getMeasuredWidth(), Math.min(i + this.mTabContainer.getMeasuredHeight(), j));
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    this.mBackground = paramDrawable;
    invalidate();
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    this.mSplitBackground = paramDrawable;
    invalidate();
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    this.mStackedBackground = paramDrawable;
    invalidate();
  }
  
  public void setTabContainer(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if (this.mTabContainer != null) {
      removeView(this.mTabContainer);
    }
    this.mTabContainer = paramScrollingTabContainerView;
    if (paramScrollingTabContainerView != null)
    {
      addView(paramScrollingTabContainerView);
      ViewGroup.LayoutParams localLayoutParams = paramScrollingTabContainerView.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramScrollingTabContainerView.setAllowCollapse(false);
    }
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    this.mIsTransitioning = paramBoolean;
    int i;
    if (!paramBoolean) {
      i = 262144;
    } else {
      i = 393216;
    }
    setDescendantFocusability(i);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.ActionBarContainer
 * JD-Core Version:    0.7.0.1
 */