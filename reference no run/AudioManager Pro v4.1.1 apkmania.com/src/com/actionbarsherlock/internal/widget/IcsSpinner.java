package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SpinnerAdapter;
import com.actionbarsherlock.R.attr;
import com.actionbarsherlock.R.styleable;

public class IcsSpinner
  extends IcsAbsSpinner
  implements DialogInterface.OnClickListener
{
  private static final int MAX_ITEMS_MEASURED = 15;
  public static final int MODE_DROPDOWN = 1;
  private boolean mDisableChildrenWhenDisabled;
  int mDropDownWidth;
  private int mGravity;
  private SpinnerPopup mPopup;
  private DropDownAdapter mTempAdapter;
  private Rect mTempRect = new Rect();
  
  public IcsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.actionDropDownStyle);
  }
  
  public IcsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockSpinner, paramInt, 0);
    DropdownPopup localDropdownPopup = new DropdownPopup(paramContext, paramAttributeSet, paramInt);
    this.mDropDownWidth = localTypedArray.getLayoutDimension(4, -2);
    localDropdownPopup.setBackgroundDrawable(localTypedArray.getDrawable(2));
    int i = localTypedArray.getDimensionPixelOffset(6, 0);
    if (i != 0) {
      localDropdownPopup.setVerticalOffset(i);
    }
    i = localTypedArray.getDimensionPixelOffset(5, 0);
    if (i != 0) {
      localDropdownPopup.setHorizontalOffset(i);
    }
    this.mPopup = localDropdownPopup;
    this.mGravity = localTypedArray.getInt(0, 17);
    this.mPopup.setPromptText(localTypedArray.getString(3));
    this.mDisableChildrenWhenDisabled = true;
    localTypedArray.recycle();
    if (this.mTempAdapter != null)
    {
      this.mPopup.setAdapter(this.mTempAdapter);
      this.mTempAdapter = null;
    }
  }
  
  private View makeAndAddView(int paramInt)
  {
    if (!this.mDataChanged)
    {
      localView = this.mRecycler.get(paramInt);
      if (localView != null) {}
    }
    else
    {
      localView = this.mAdapter.getView(paramInt, null, this);
      setUpChild(localView);
      return localView;
    }
    setUpChild(localView);
    View localView = localView;
    return localView;
  }
  
  private void setUpChild(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = generateDefaultLayoutParams();
    }
    addViewInLayout(paramView, 0, localLayoutParams);
    paramView.setSelected(hasFocus());
    if (this.mDisableChildrenWhenDisabled) {
      paramView.setEnabled(isEnabled());
    }
    int i = ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, localLayoutParams.height);
    paramView.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, localLayoutParams.width), i);
    int j = this.mSpinnerPadding.top + (getMeasuredHeight() - this.mSpinnerPadding.bottom - this.mSpinnerPadding.top - paramView.getMeasuredHeight()) / 2;
    i = j + paramView.getMeasuredHeight();
    paramView.layout(0, j, 0 + paramView.getMeasuredWidth(), i);
  }
  
  public int getBaseline()
  {
    int j = -1;
    View localView = null;
    if (getChildCount() <= 0)
    {
      if ((this.mAdapter != null) && (this.mAdapter.getCount() > 0))
      {
        localView = makeAndAddView(0);
        this.mRecycler.put(0, localView);
        removeAllViewsInLayout();
      }
    }
    else {
      localView = getChildAt(0);
    }
    if (localView != null)
    {
      int i = localView.getBaseline();
      if (i >= 0) {
        j = i + localView.getTop();
      }
    }
    return j;
  }
  
  public CharSequence getPrompt()
  {
    return this.mPopup.getHintText();
  }
  
  void layout(int paramInt, boolean paramBoolean)
  {
    int m = this.mSpinnerPadding.left;
    int i = getRight() - getLeft() - this.mSpinnerPadding.left - this.mSpinnerPadding.right;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount != 0)
    {
      if (this.mNextSelectedPosition >= 0) {
        setSelectedPositionInt(this.mNextSelectedPosition);
      }
      recycleAllViews();
      removeAllViewsInLayout();
      this.mFirstPosition = this.mSelectedPosition;
      View localView = makeAndAddView(this.mSelectedPosition);
      int k = localView.getMeasuredWidth();
      int j = m;
      switch (0x7 & this.mGravity)
      {
      case 1: 
        j = m + i / 2 - k / 2;
        break;
      case 5: 
        j = m + i - k;
      }
      localView.offsetLeftAndRight(j);
      this.mRecycler.clear();
      invalidate();
      checkSelectionChanged();
      this.mDataChanged = false;
      this.mNeedSync = false;
      setNextSelectedPositionInt(this.mSelectedPosition);
    }
    else
    {
      resetList();
    }
  }
  
  int measureContentWidth(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    if (paramSpinnerAdapter != null)
    {
      n = 0;
      View localView = null;
      int j = 0;
      int k = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i1 = Math.max(0, getSelectedItemPosition());
      int m = Math.min(paramSpinnerAdapter.getCount(), i1 + 15);
      for (i1 = Math.max(0, i1 - (15 - (m - i1)));; i1++)
      {
        if (i1 >= m)
        {
          if (paramDrawable == null) {
            break;
          }
          paramDrawable.getPadding(this.mTempRect);
          n += this.mTempRect.left + this.mTempRect.right;
          break;
        }
        int i2 = paramSpinnerAdapter.getItemViewType(i1);
        if (i2 != j)
        {
          j = i2;
          localView = null;
        }
        localView = paramSpinnerAdapter.getView(i1, localView, this);
        if (localView.getLayoutParams() == null) {
          localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        localView.measure(k, i);
        n = Math.max(n, localView.getMeasuredWidth());
      }
    }
    int n = 0;
    return n;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    setSelection(paramInt);
    paramDialogInterface.dismiss();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.mPopup != null) && (this.mPopup.isShowing())) {
      this.mPopup.dismiss();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mInLayout = true;
    layout(0, false);
    this.mInLayout = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mPopup != null) && (View.MeasureSpec.getMode(paramInt1) == -2147483648)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    if (!bool)
    {
      bool = true;
      if (!this.mPopup.isShowing()) {
        this.mPopup.show();
      }
    }
    return bool;
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    super.setAdapter(paramSpinnerAdapter);
    if (this.mPopup == null) {
      this.mTempAdapter = new DropDownAdapter(paramSpinnerAdapter);
    } else {
      this.mPopup.setAdapter(new DropDownAdapter(paramSpinnerAdapter));
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    int i;
    if (this.mDisableChildrenWhenDisabled) {
      i = getChildCount();
    }
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      getChildAt(j).setEnabled(paramBoolean);
    }
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      if ((paramInt & 0x7) == 0) {
        paramInt |= 0x3;
      }
      this.mGravity = paramInt;
      requestLayout();
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    this.mPopup.setPromptText(paramCharSequence);
  }
  
  public void setPromptId(int paramInt)
  {
    setPrompt(getContext().getText(paramInt));
  }
  
  private class DropdownPopup
    extends IcsListPopupWindow
    implements IcsSpinner.SpinnerPopup
  {
    private ListAdapter mAdapter;
    private CharSequence mHintText;
    
    public DropdownPopup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, 0, paramInt);
      setAnchorView(IcsSpinner.this);
      setModal(true);
      setPromptPosition(0);
      setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          IcsSpinner.this.setSelection(paramAnonymousInt);
          IcsSpinner.DropdownPopup.this.dismiss();
        }
      });
    }
    
    public CharSequence getHintText()
    {
      return this.mHintText;
    }
    
    public void setAdapter(ListAdapter paramListAdapter)
    {
      super.setAdapter(paramListAdapter);
      this.mAdapter = paramListAdapter;
    }
    
    public void setPromptText(CharSequence paramCharSequence)
    {
      this.mHintText = paramCharSequence;
    }
    
    public void show()
    {
      int i = IcsSpinner.this.getPaddingLeft();
      int j;
      if (IcsSpinner.this.mDropDownWidth != -2)
      {
        if (IcsSpinner.this.mDropDownWidth != -1)
        {
          setContentWidth(IcsSpinner.this.mDropDownWidth);
        }
        else
        {
          k = IcsSpinner.this.getWidth();
          j = IcsSpinner.this.getPaddingRight();
          setContentWidth(k - i - j);
        }
      }
      else
      {
        k = IcsSpinner.this.getWidth();
        j = IcsSpinner.this.getPaddingRight();
        setContentWidth(Math.max(IcsSpinner.this.measureContentWidth((SpinnerAdapter)this.mAdapter, IcsSpinner.this.getBackground()), k - i - j));
      }
      Drawable localDrawable = IcsSpinner.this.getBackground();
      int k = 0;
      if (localDrawable != null)
      {
        localDrawable.getPadding(IcsSpinner.this.mTempRect);
        k = -IcsSpinner.this.mTempRect.left;
      }
      setHorizontalOffset(k + i);
      setInputMethodMode(2);
      super.show();
      getListView().setChoiceMode(1);
      IcsSpinner.this.setSelection(IcsSpinner.this.getSelectedItemPosition());
    }
  }
  
  private static abstract interface SpinnerPopup
  {
    public abstract void dismiss();
    
    public abstract CharSequence getHintText();
    
    public abstract boolean isShowing();
    
    public abstract void setAdapter(ListAdapter paramListAdapter);
    
    public abstract void setPromptText(CharSequence paramCharSequence);
    
    public abstract void show();
  }
  
  private static class DropDownAdapter
    implements ListAdapter, SpinnerAdapter
  {
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;
    
    public DropDownAdapter(SpinnerAdapter paramSpinnerAdapter)
    {
      this.mAdapter = paramSpinnerAdapter;
      if ((paramSpinnerAdapter instanceof ListAdapter)) {
        this.mListAdapter = ((ListAdapter)paramSpinnerAdapter);
      }
    }
    
    public boolean areAllItemsEnabled()
    {
      ListAdapter localListAdapter = this.mListAdapter;
      boolean bool;
      if (localListAdapter == null) {
        bool = true;
      } else {
        bool = bool.areAllItemsEnabled();
      }
      return bool;
    }
    
    public int getCount()
    {
      int i;
      if (this.mAdapter != null) {
        i = this.mAdapter.getCount();
      } else {
        i = 0;
      }
      return i;
    }
    
    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (this.mAdapter != null) {
        localView = this.mAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
      } else {
        localView = null;
      }
      return localView;
    }
    
    public Object getItem(int paramInt)
    {
      Object localObject;
      if (this.mAdapter != null) {
        localObject = this.mAdapter.getItem(paramInt);
      } else {
        localObject = null;
      }
      return localObject;
    }
    
    public long getItemId(int paramInt)
    {
      long l;
      if (this.mAdapter != null) {
        l = this.mAdapter.getItemId(paramInt);
      } else {
        l = -1L;
      }
      return l;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return getDropDownView(paramInt, paramView, paramViewGroup);
    }
    
    public int getViewTypeCount()
    {
      return 1;
    }
    
    public boolean hasStableIds()
    {
      boolean bool;
      if ((this.mAdapter == null) || (!this.mAdapter.hasStableIds())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean isEmpty()
    {
      boolean bool;
      if (getCount() != 0) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean isEnabled(int paramInt)
    {
      ListAdapter localListAdapter = this.mListAdapter;
      boolean bool;
      if (localListAdapter == null) {
        bool = true;
      } else {
        bool = bool.isEnabled(paramInt);
      }
      return bool;
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.mAdapter != null) {
        this.mAdapter.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      if (this.mAdapter != null) {
        this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.IcsSpinner
 * JD-Core Version:    0.7.0.1
 */