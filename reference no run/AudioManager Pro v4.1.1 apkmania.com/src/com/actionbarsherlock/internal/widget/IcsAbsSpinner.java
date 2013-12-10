package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;

public abstract class IcsAbsSpinner
  extends IcsAdapterView<SpinnerAdapter>
{
  private static final boolean IS_HONEYCOMB;
  SpinnerAdapter mAdapter;
  boolean mBlockLayoutRequests;
  private DataSetObserver mDataSetObserver;
  int mHeightMeasureSpec;
  final RecycleBin mRecycler = new RecycleBin();
  int mSelectionBottomPadding = 0;
  int mSelectionLeftPadding = 0;
  int mSelectionRightPadding = 0;
  int mSelectionTopPadding = 0;
  final Rect mSpinnerPadding = new Rect();
  private Rect mTouchFrame;
  int mWidthMeasureSpec;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 11) {
      bool = false;
    } else {
      bool = true;
    }
    IS_HONEYCOMB = bool;
  }
  
  public IcsAbsSpinner(Context paramContext)
  {
    super(paramContext);
    initAbsSpinner();
  }
  
  public IcsAbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IcsAbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initAbsSpinner();
  }
  
  private void initAbsSpinner()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public SpinnerAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  int getChildHeight(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  int getChildWidth(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  public int getCount()
  {
    return this.mItemCount;
  }
  
  public View getSelectedView()
  {
    View localView;
    if ((this.mItemCount <= 0) || (this.mSelectedPosition < 0)) {
      localView = null;
    } else {
      localView = getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }
    return localView;
  }
  
  abstract void layout(int paramInt, boolean paramBoolean);
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int i3 = getPaddingLeft();
    int n = getPaddingTop();
    int k = getPaddingRight();
    int j = getPaddingBottom();
    Rect localRect3 = this.mSpinnerPadding;
    if (i3 <= this.mSelectionLeftPadding) {
      i3 = this.mSelectionLeftPadding;
    }
    localRect3.left = i3;
    localRect3 = this.mSpinnerPadding;
    if (n <= this.mSelectionTopPadding) {
      n = this.mSelectionTopPadding;
    }
    localRect3.top = n;
    Rect localRect2 = this.mSpinnerPadding;
    if (k <= this.mSelectionRightPadding) {
      k = this.mSelectionRightPadding;
    }
    localRect2.right = k;
    Rect localRect1 = this.mSpinnerPadding;
    if (j <= this.mSelectionBottomPadding) {
      j = this.mSelectionBottomPadding;
    }
    localRect1.bottom = j;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    int i1 = 0;
    j = 0;
    int i2 = 1;
    int m = getSelectedItemPosition();
    if ((m >= 0) && (this.mAdapter != null) && (m < this.mAdapter.getCount()))
    {
      View localView = this.mRecycler.get(m);
      if (localView == null) {
        localView = this.mAdapter.getView(m, null, this);
      }
      if (localView != null) {
        this.mRecycler.put(m, localView);
      }
      if (localView != null)
      {
        if (localView.getLayoutParams() == null)
        {
          this.mBlockLayoutRequests = true;
          localView.setLayoutParams(generateDefaultLayoutParams());
          this.mBlockLayoutRequests = false;
        }
        measureChild(localView, paramInt1, paramInt2);
        i1 = getChildHeight(localView) + this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
        j = getChildWidth(localView) + this.mSpinnerPadding.left + this.mSpinnerPadding.right;
        i2 = 0;
      }
    }
    if (i2 != 0)
    {
      i1 = this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
      if (i == 0) {
        j = this.mSpinnerPadding.left + this.mSpinnerPadding.right;
      }
    }
    i = Math.max(i1, getSuggestedMinimumHeight());
    j = Math.max(j, getSuggestedMinimumWidth());
    if (!IS_HONEYCOMB)
    {
      i = resolveSize(i, paramInt2);
      j = resolveSize(j, paramInt1);
    }
    else
    {
      i = resolveSizeAndState(i, paramInt2, 0);
      j = resolveSizeAndState(j, paramInt1, 0);
    }
    setMeasuredDimension(j, i);
    this.mHeightMeasureSpec = paramInt2;
    this.mWidthMeasureSpec = paramInt1;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.selectedId >= 0L)
    {
      this.mDataChanged = true;
      this.mNeedSync = true;
      this.mSyncRowId = localSavedState.selectedId;
      this.mSyncPosition = localSavedState.position;
      this.mSyncMode = 0;
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.selectedId = getSelectedItemId();
    if (localSavedState.selectedId < 0L) {
      localSavedState.position = -1;
    } else {
      localSavedState.position = getSelectedItemPosition();
    }
    return localSavedState;
  }
  
  public int pointToPosition(int paramInt1, int paramInt2)
  {
    Rect localRect = this.mTouchFrame;
    if (localRect == null)
    {
      this.mTouchFrame = new Rect();
      localRect = this.mTouchFrame;
    }
    for (int j = -1 + getChildCount();; j--)
    {
      if (j < 0) {
        return -1;
      }
      View localView = getChildAt(j);
      if (localView.getVisibility() == 0)
      {
        localView.getHitRect(i);
        if (i.contains(paramInt1, paramInt2)) {
          break;
        }
      }
    }
    int i = j + this.mFirstPosition;
    return i;
  }
  
  void recycleAllViews()
  {
    int k = getChildCount();
    RecycleBin localRecycleBin = this.mRecycler;
    int i = this.mFirstPosition;
    for (int j = 0;; j++)
    {
      if (j >= k) {
        return;
      }
      View localView = getChildAt(j);
      localRecycleBin.put(i + j, localView);
    }
  }
  
  public void requestLayout()
  {
    if (!this.mBlockLayoutRequests) {
      super.requestLayout();
    }
  }
  
  void resetList()
  {
    this.mDataChanged = false;
    this.mNeedSync = false;
    removeAllViewsInLayout();
    this.mOldSelectedPosition = -1;
    this.mOldSelectedRowId = -9223372036854775808L;
    setSelectedPositionInt(-1);
    setNextSelectedPositionInt(-1);
    invalidate();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    int i = -1;
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
      resetList();
    }
    this.mAdapter = paramSpinnerAdapter;
    this.mOldSelectedPosition = i;
    this.mOldSelectedRowId = -9223372036854775808L;
    if (this.mAdapter == null)
    {
      checkFocus();
      resetList();
      checkSelectionChanged();
    }
    else
    {
      this.mOldItemCount = this.mItemCount;
      this.mItemCount = this.mAdapter.getCount();
      checkFocus();
      this.mDataSetObserver = new IcsAdapterView.AdapterDataSetObserver(this);
      this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
      if (this.mItemCount > 0) {
        i = 0;
      }
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      if (this.mItemCount == 0) {
        checkSelectionChanged();
      }
    }
    requestLayout();
  }
  
  public void setSelection(int paramInt)
  {
    setNextSelectedPositionInt(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    boolean bool;
    if ((!paramBoolean) || (this.mFirstPosition > paramInt) || (paramInt > -1 + (this.mFirstPosition + getChildCount()))) {
      bool = false;
    } else {
      bool = true;
    }
    setSelectionInt(paramInt, bool);
  }
  
  void setSelectionInt(int paramInt, boolean paramBoolean)
  {
    if (paramInt != this.mOldSelectedPosition)
    {
      this.mBlockLayoutRequests = true;
      int i = paramInt - this.mSelectedPosition;
      setNextSelectedPositionInt(paramInt);
      layout(i, paramBoolean);
      this.mBlockLayoutRequests = false;
    }
  }
  
  class RecycleBin
  {
    private final SparseArray<View> mScrapHeap = new SparseArray();
    
    RecycleBin() {}
    
    void clear()
    {
      SparseArray localSparseArray = this.mScrapHeap;
      int i = localSparseArray.size();
      for (int j = 0;; j++)
      {
        if (j >= i)
        {
          localSparseArray.clear();
          return;
        }
        View localView = (View)localSparseArray.valueAt(j);
        if (localView != null) {
          IcsAbsSpinner.this.removeDetachedView(localView, true);
        }
      }
    }
    
    View get(int paramInt)
    {
      View localView = (View)this.mScrapHeap.get(paramInt);
      if (localView != null) {
        this.mScrapHeap.delete(paramInt);
      }
      return localView;
    }
    
    public void put(int paramInt, View paramView)
    {
      this.mScrapHeap.put(paramInt, paramView);
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public IcsAbsSpinner.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new IcsAbsSpinner.SavedState(paramAnonymousParcel, null);
      }
      
      public IcsAbsSpinner.SavedState[] newArray(int paramAnonymousInt)
      {
        return new IcsAbsSpinner.SavedState[paramAnonymousInt];
      }
    };
    int position;
    long selectedId;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.selectedId = paramParcel.readLong();
      this.position = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeLong(this.selectedId);
      paramParcel.writeInt(this.position);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.IcsAbsSpinner
 * JD-Core Version:    0.7.0.1
 */