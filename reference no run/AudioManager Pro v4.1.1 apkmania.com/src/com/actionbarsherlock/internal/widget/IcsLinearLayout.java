package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineLinearLayout;

public class IcsLinearLayout
  extends NineLinearLayout
{
  private static final int[] LinearLayout;
  private static final int LinearLayout_divider = 0;
  private static final int LinearLayout_dividerPadding = 2;
  private static final int LinearLayout_showDividers = 1;
  public static final int SHOW_DIVIDER_BEGINNING = 1;
  public static final int SHOW_DIVIDER_END = 4;
  public static final int SHOW_DIVIDER_MIDDLE = 2;
  public static final int SHOW_DIVIDER_NONE;
  private Drawable mDivider;
  private int mDividerHeight;
  private int mDividerPadding;
  private int mDividerWidth;
  private int mShowDividers;
  
  static
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = 16843049;
    arrayOfInt[1] = 16843561;
    arrayOfInt[2] = 16843562;
    LinearLayout = arrayOfInt;
  }
  
  public IcsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, LinearLayout);
    setDividerDrawable(localTypedArray.getDrawable(0));
    this.mShowDividers = localTypedArray.getInt(1, 0);
    this.mDividerPadding = localTypedArray.getDimensionPixelSize(2, 0);
    localTypedArray.recycle();
  }
  
  void drawDividersHorizontal(Canvas paramCanvas)
  {
    int i = getChildCount();
    for (int k = 0;; k++)
    {
      if (k >= i)
      {
        if (hasDividerBeforeChildAt(i))
        {
          View localView1 = getChildAt(i - 1);
          int j;
          if (localView1 != null)
          {
            ((LinearLayout.LayoutParams)localView1.getLayoutParams());
            j = localView1.getRight();
          }
          else
          {
            j = getWidth() - getPaddingRight() - this.mDividerWidth;
          }
          drawVerticalDivider(paramCanvas, j);
        }
        return;
      }
      View localView2 = getChildAt(k);
      if ((localView2 != null) && (localView2.getVisibility() != 8) && (hasDividerBeforeChildAt(k)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        drawVerticalDivider(paramCanvas, localView2.getLeft() - localLayoutParams.leftMargin);
      }
    }
  }
  
  void drawDividersVertical(Canvas paramCanvas)
  {
    int k = getChildCount();
    int j;
    for (int i = 0;; j++)
    {
      if (i >= k)
      {
        if (hasDividerBeforeChildAt(k))
        {
          View localView1 = getChildAt(k - 1);
          if (localView1 != null)
          {
            ((LinearLayout.LayoutParams)localView1.getLayoutParams());
            j = localView1.getBottom();
          }
          else
          {
            j = getHeight() - getPaddingBottom() - this.mDividerHeight;
          }
          drawHorizontalDivider(paramCanvas, j);
        }
        return;
      }
      View localView2 = getChildAt(j);
      if ((localView2 != null) && (localView2.getVisibility() != 8) && (hasDividerBeforeChildAt(j)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        drawHorizontalDivider(paramCanvas, localView2.getTop() - localLayoutParams.topMargin);
      }
    }
  }
  
  void drawHorizontalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, paramInt, getWidth() - getPaddingRight() - this.mDividerPadding, paramInt + this.mDividerHeight);
    this.mDivider.draw(paramCanvas);
  }
  
  void drawVerticalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(paramInt, getPaddingTop() + this.mDividerPadding, paramInt + this.mDividerWidth, getHeight() - getPaddingBottom() - this.mDividerPadding);
    this.mDivider.draw(paramCanvas);
  }
  
  public int getDividerPadding()
  {
    return this.mDividerPadding;
  }
  
  public int getDividerWidth()
  {
    return this.mDividerWidth;
  }
  
  public int getShowDividers()
  {
    return this.mShowDividers;
  }
  
  protected boolean hasDividerBeforeChildAt(int paramInt)
  {
    int i = 1;
    if (paramInt != 0)
    {
      if (paramInt != getChildCount())
      {
        if ((0x2 & this.mShowDividers) == 0)
        {
          i = 0;
        }
        else
        {
          int j = 0;
          i = paramInt - 1;
          while (i >= 0) {
            if (getChildAt(i).getVisibility() == 8) {
              i--;
            } else {
              j = 1;
            }
          }
          i = j;
        }
      }
      else if ((0x4 & this.mShowDividers) == 0) {
        i = 0;
      }
    }
    else if ((0x1 & this.mShowDividers) == 0) {
      i = 0;
    }
    return i;
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = indexOfChild(paramView);
    int j = getOrientation();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (hasDividerBeforeChildAt(i)) {
      if (j != 1) {
        localLayoutParams.leftMargin = this.mDividerWidth;
      } else {
        localLayoutParams.topMargin = this.mDividerHeight;
      }
    }
    int k = getChildCount();
    if ((i == k - 1) && (hasDividerBeforeChildAt(k))) {
      if (j != 1) {
        localLayoutParams.rightMargin = this.mDividerWidth;
      } else {
        localLayoutParams.bottomMargin = this.mDividerHeight;
      }
    }
    super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mDivider != null) {
      if (getOrientation() != 1) {
        drawDividersHorizontal(paramCanvas);
      } else {
        drawDividersVertical(paramCanvas);
      }
    }
    super.onDraw(paramCanvas);
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    boolean bool = false;
    if (paramDrawable != this.mDivider)
    {
      this.mDivider = paramDrawable;
      if (paramDrawable == null)
      {
        this.mDividerWidth = 0;
        this.mDividerHeight = 0;
      }
      else
      {
        this.mDividerWidth = paramDrawable.getIntrinsicWidth();
        this.mDividerHeight = paramDrawable.getIntrinsicHeight();
      }
      if (paramDrawable == null) {
        bool = true;
      }
      setWillNotDraw(bool);
      requestLayout();
    }
  }
  
  public void setDividerPadding(int paramInt)
  {
    this.mDividerPadding = paramInt;
  }
  
  public void setShowDividers(int paramInt)
  {
    if (paramInt != this.mShowDividers)
    {
      requestLayout();
      invalidate();
    }
    this.mShowDividers = paramInt;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.IcsLinearLayout
 * JD-Core Version:    0.7.0.1
 */