package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout.LayoutParams;
import com.actionbarsherlock.internal.widget.IcsLinearLayout;

public class ActionMenuView
  extends IcsLinearLayout
  implements MenuBuilder.ItemInvoker, MenuView
{
  static final int GENERATED_ITEM_PADDING = 4;
  private static final boolean IS_FROYO = false;
  static final int MIN_CELL_SIZE = 56;
  private boolean mFirst = true;
  private boolean mFormatItems;
  private int mFormatItemsWidth;
  private int mGeneratedItemPadding;
  private MenuBuilder mMenu;
  private int mMinCellSize;
  private ActionMenuPresenter mPresenter;
  private boolean mReserveOverflow;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 8) {
      bool = false;
    } else {
      bool = true;
    }
    IS_FROYO = bool;
  }
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mMinCellSize = ((int)(56.0F * f));
    this.mGeneratedItemPadding = ((int)(4.0F * f));
  }
  
  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    int j = 0;
    if (paramInt2 > 0)
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, -2147483648), i);
      int k = paramView.getMeasuredWidth();
      j = k / paramInt1;
      if (k % paramInt1 != 0) {
        j++;
      }
    }
    ActionMenuItemView localActionMenuItemView;
    if (!(paramView instanceof ActionMenuItemView)) {
      localActionMenuItemView = null;
    } else {
      localActionMenuItemView = (ActionMenuItemView)paramView;
    }
    boolean bool;
    if ((localLayoutParams.isOverflowButton) || (localActionMenuItemView == null) || (!localActionMenuItemView.hasText())) {
      bool = false;
    } else {
      bool = true;
    }
    localLayoutParams.expandable = bool;
    localLayoutParams.cellsUsed = j;
    paramView.measure(View.MeasureSpec.makeMeasureSpec(j * paramInt1, 1073741824), i);
    return j;
  }
  
  private void onMeasureExactFormat(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    int k = getPaddingLeft() + getPaddingRight();
    int i1 = getPaddingTop() + getPaddingBottom();
    k = m - k;
    int n = k / this.mMinCellSize;
    m = k % this.mMinCellSize;
    if (n != 0)
    {
      m = this.mMinCellSize + m / n;
      int i4 = n;
      n = 0;
      int i6 = 0;
      int i9 = 0;
      int i8 = 0;
      int i10 = 0;
      long l1 = 0L;
      int i2 = getChildCount();
      int i12;
      for (int i11 = 0;; i12++)
      {
        boolean bool;
        int i7;
        View localView1;
        LayoutParams localLayoutParams1;
        LayoutParams localLayoutParams2;
        View localView3;
        if (i11 >= i2)
        {
          if ((i10 == 0) || (i8 != 2)) {
            bool = false;
          } else {
            bool = true;
          }
          i11 = 0;
          int i15;
          long l3;
          int i17;
          if ((i9 > 0) && (i4 > 0))
          {
            i15 = 2147483647;
            l3 = 0L;
            i17 = 0;
          }
          for (int i16 = 0;; i16++)
          {
            LayoutParams localLayoutParams4;
            if (i16 >= i2)
            {
              l1 |= l3;
              View localView4;
              if (i17 <= i4)
              {
                i16 = i15 + 1;
                for (i15 = 0;; i15++)
                {
                  if (i15 >= i2)
                  {
                    i11 = 1;
                    break;
                  }
                  localView4 = getChildAt(i15);
                  localLayoutParams4 = (LayoutParams)localView4.getLayoutParams();
                  if ((l3 & 1 << i15) != 0L)
                  {
                    if ((bool) && (localLayoutParams4.preventEdgeOffset) && (i4 == 1)) {
                      localView4.setPadding(m + this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
                    }
                    localLayoutParams4.cellsUsed = (1 + localLayoutParams4.cellsUsed);
                    localLayoutParams4.expanded = true;
                    i4--;
                  }
                  else if (localLayoutParams4.cellsUsed == i16)
                  {
                    l1 |= 1 << i15;
                  }
                }
              }
              if ((i10 != 0) || (i8 != 1)) {
                i9 = 0;
              } else {
                i9 = 1;
              }
              if ((i4 > 0) && (l1 != 0L) && ((i4 < i8 - 1) || (i9 != 0) || (i6 > 1)))
              {
                float f = Long.bitCount(l1);
                if (i9 == 0)
                {
                  if (((0x1 & l1) != 0L) && (!((LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset)) {
                    f -= 0.5F;
                  }
                  if (((l1 & 1 << i2 - 1) != 0L) && (!((LayoutParams)getChildAt(i2 - 1).getLayoutParams()).preventEdgeOffset)) {
                    f -= 0.5F;
                  }
                }
                if (f <= 0.0F) {
                  i7 = 0;
                } else {
                  i7 = (int)(i4 * m / i7);
                }
              }
              for (i4 = 0;; localView1++)
              {
                if (i4 >= i2)
                {
                  if (localView4 != 0) {
                    i1 = View.MeasureSpec.makeMeasureSpec(j - i1, i);
                  }
                  for (int i3 = 0;; i3++)
                  {
                    if (i3 >= i2)
                    {
                      if (i != 1073741824) {
                        j = n;
                      }
                      setMeasuredDimension(k, j);
                      break;
                    }
                    localView1 = getChildAt(i3);
                    localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
                    if (localLayoutParams1.expanded) {
                      localView1.measure(View.MeasureSpec.makeMeasureSpec(m * localLayoutParams1.cellsUsed + localLayoutParams1.extraPixels, 1073741824), i1);
                    }
                  }
                }
                if ((localLayoutParams1 & 1 << localView1) != 0L)
                {
                  View localView2 = getChildAt(localView1);
                  localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
                  if (!(localView2 instanceof ActionMenuItemView))
                  {
                    if (!localLayoutParams2.isOverflowButton)
                    {
                      if (localView1 != 0) {
                        localLayoutParams2.leftMargin = (i7 / 2);
                      }
                      localView3 = i2 - 1;
                      if (localView1 != localView3) {
                        localLayoutParams2.rightMargin = (i7 / 2);
                      }
                    }
                    else
                    {
                      localLayoutParams2.extraPixels = i7;
                      localLayoutParams2.expanded = true;
                      localLayoutParams2.rightMargin = (-i7 / 2);
                      i12 = 1;
                    }
                  }
                  else
                  {
                    localLayoutParams2.extraPixels = i7;
                    localLayoutParams2.expanded = true;
                    if ((localView1 == 0) && (!localLayoutParams2.preventEdgeOffset)) {
                      localLayoutParams2.leftMargin = (-i7 / 2);
                    }
                    i12 = 1;
                  }
                }
              }
            }
            LayoutParams localLayoutParams5 = (LayoutParams)getChildAt(i16).getLayoutParams();
            if (localLayoutParams5.expandable) {
              if (localLayoutParams5.cellsUsed >= i15)
              {
                if (localLayoutParams5.cellsUsed == i15)
                {
                  l3 |= 1 << i16;
                  localLayoutParams4++;
                }
              }
              else
              {
                i15 = localLayoutParams5.cellsUsed;
                l3 = 1 << i16;
                int i18 = 1;
              }
            }
          }
        }
        View localView5 = getChildAt(i12);
        if (localView5.getVisibility() != 8)
        {
          bool = localView5 instanceof ActionMenuItemView;
          localLayoutParams2++;
          if (bool) {
            localView5.setPadding(this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
          }
          LayoutParams localLayoutParams3 = (LayoutParams)localView5.getLayoutParams();
          localLayoutParams3.expanded = false;
          localLayoutParams3.extraPixels = 0;
          localLayoutParams3.cellsUsed = 0;
          localLayoutParams3.expandable = false;
          localLayoutParams3.leftMargin = 0;
          localLayoutParams3.rightMargin = 0;
          if ((!bool) || (!((ActionMenuItemView)localView5).hasText())) {
            bool = false;
          } else {
            bool = true;
          }
          localLayoutParams3.preventEdgeOffset = bool;
          if (!localLayoutParams3.isOverflowButton) {
            int i14 = localView1;
          } else {
            localView6 = 1;
          }
          View localView6 = measureChildForCells(localView5, m, localView6, paramInt2, i1);
          i7 = Math.max(i7, localView6);
          if (localLayoutParams3.expandable) {
            localView3++;
          }
          if (localLayoutParams3.isOverflowButton) {
            i10 = 1;
          }
          int i5;
          localView1 -= localView6;
          int i13 = localView5.getMeasuredHeight();
          n = Math.max(n, i13);
          if (localView6 == 1)
          {
            long l2;
            localLayoutParams1 |= 1 << i12;
          }
        }
      }
    }
    setMeasuredDimension(k, 0);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    boolean bool;
    if ((paramLayoutParams == null) || (!(paramLayoutParams instanceof LayoutParams))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    LayoutParams localLayoutParams;
    if (!(paramLayoutParams instanceof LayoutParams))
    {
      localLayoutParams = generateDefaultLayoutParams();
    }
    else
    {
      localLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      if (localLayoutParams.gravity <= 0) {
        localLayoutParams.gravity = 16;
      }
    }
    return localLayoutParams;
  }
  
  public LayoutParams generateOverflowButtonLayoutParams()
  {
    LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.isOverflowButton = true;
    return localLayoutParams;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  protected boolean hasDividerBeforeChildAt(int paramInt)
  {
    View localView2 = getChildAt(paramInt - 1);
    View localView1 = getChildAt(paramInt);
    boolean bool = false;
    if ((paramInt < getChildCount()) && ((localView2 instanceof ActionMenuChildView))) {
      bool = false | ((ActionMenuChildView)localView2).needsDividerAfter();
    }
    if ((paramInt > 0) && ((localView1 instanceof ActionMenuChildView))) {
      bool |= ((ActionMenuChildView)localView1).needsDividerBefore();
    }
    return bool;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.mMenu = paramMenuBuilder;
  }
  
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl)
  {
    return this.mMenu.performItemAction(paramMenuItemImpl, 0);
  }
  
  public boolean isExpandedFormat()
  {
    return this.mFormatItems;
  }
  
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (IS_FROYO) {
      super.onConfigurationChanged(paramConfiguration);
    }
    this.mPresenter.updateMenuView(false);
    if ((this.mPresenter != null) && (this.mPresenter.isOverflowMenuShowing()))
    {
      this.mPresenter.hideOverflowMenu();
      this.mPresenter.showOverflowMenu();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mPresenter.dismissPopupMenus();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((IS_FROYO) || (!this.mFirst))
    {
      super.onDraw(paramCanvas);
    }
    else
    {
      this.mFirst = false;
      requestLayout();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mFormatItems)
    {
      int j = getChildCount();
      int i = (paramInt2 + paramInt4) / 2;
      int m = 0;
      int k = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
      int i3 = 0;
      for (int i2 = 0;; i2++)
      {
        View localView1;
        int i4;
        int i7;
        if (i2 >= j)
        {
          if ((j != 1) || (i3 != 0))
          {
            int n;
            if (i3 == 0) {
              n = 1;
            } else {
              n = 0;
            }
            m -= n;
            if (m <= 0) {
              k = 0;
            } else {
              k /= m;
            }
            i2 = Math.max(0, k);
            i3 = getPaddingLeft();
            for (k = 0; k < j; k++)
            {
              localView1 = getChildAt(k);
              LayoutParams localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
              if ((localView1.getVisibility() != 8) && (!localLayoutParams1.isOverflowButton))
              {
                i3 += localLayoutParams1.leftMargin;
                i4 = localView1.getMeasuredWidth();
                i7 = localView1.getMeasuredHeight();
                int i5 = i - i7 / 2;
                localView1.layout(i3, i5, i3 + i4, i5 + i7);
                i3 += i2 + (i4 + localLayoutParams1.rightMargin);
              }
            }
          }
          localView1 = getChildAt(0);
          k = localView1.getMeasuredWidth();
          j = localView1.getMeasuredHeight();
          int i1 = (paramInt3 - paramInt1) / 2 - k / 2;
          i -= j / 2;
          localView1.layout(i1, i, i1 + k, i + j);
          break;
        }
        View localView2 = getChildAt(i2);
        if (localView2.getVisibility() != 8)
        {
          LayoutParams localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
          if (!localLayoutParams2.isOverflowButton)
          {
            k -= localView2.getMeasuredWidth() + localLayoutParams2.leftMargin + localLayoutParams2.rightMargin;
            localView1++;
          }
          else
          {
            i4 = localView2.getMeasuredWidth();
            if (hasDividerBeforeChildAt(i2)) {
              i4 += 0;
            }
            i3 = localView2.getMeasuredHeight();
            int i6 = getWidth() - getPaddingRight() - localLayoutParams2.rightMargin;
            i7 = i6 - i4;
            int i8 = i - i3 / 2;
            localView2.layout(i7, i8, i6, i8 + i3);
            k -= i4;
            i3 = 1;
          }
        }
      }
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool1 = this.mFormatItems;
    boolean bool2;
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    this.mFormatItems = bool2;
    if (bool1 != this.mFormatItems) {
      this.mFormatItemsWidth = 0;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    if ((this.mFormatItems) && (this.mMenu != null) && (i != this.mFormatItemsWidth))
    {
      this.mFormatItemsWidth = i;
      this.mMenu.onItemsChanged(true);
    }
    if (!this.mFormatItems) {
      super.onMeasure(paramInt1, paramInt2);
    } else {
      onMeasureExactFormat(paramInt1, paramInt2);
    }
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.mPresenter = paramActionMenuPresenter;
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    public int cellsUsed;
    public boolean expandable;
    public boolean expanded;
    public int extraPixels;
    public boolean isOverflowButton;
    public boolean preventEdgeOffset;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.isOverflowButton = false;
    }
    
    public LayoutParams(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super(paramInt2);
      this.isOverflowButton = paramBoolean;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.isOverflowButton = paramLayoutParams.isOverflowButton;
    }
  }
  
  public static abstract interface ActionMenuChildView
  {
    public abstract boolean needsDividerAfter();
    
    public abstract boolean needsDividerBefore();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.view.menu.ActionMenuView
 * JD-Core Version:    0.7.0.1
 */