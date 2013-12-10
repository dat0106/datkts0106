package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import android.widget.AdapterView.OnItemClickListener;

public abstract class IcsAdapterView<T extends Adapter>
  extends ViewGroup
{
  public static final int INVALID_POSITION = -1;
  public static final long INVALID_ROW_ID = -9223372036854775808L;
  public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
  public static final int ITEM_VIEW_TYPE_IGNORE = -1;
  static final int SYNC_FIRST_POSITION = 1;
  static final int SYNC_MAX_DURATION_MILLIS = 100;
  static final int SYNC_SELECTED_POSITION;
  boolean mBlockLayoutRequests = false;
  boolean mDataChanged;
  private boolean mDesiredFocusableInTouchModeState;
  private boolean mDesiredFocusableState;
  private View mEmptyView;
  @ViewDebug.ExportedProperty(category="scrolling")
  int mFirstPosition = 0;
  boolean mInLayout = false;
  @ViewDebug.ExportedProperty(category="list")
  int mItemCount;
  private int mLayoutHeight;
  boolean mNeedSync = false;
  @ViewDebug.ExportedProperty(category="list")
  int mNextSelectedPosition = -1;
  long mNextSelectedRowId = -9223372036854775808L;
  int mOldItemCount;
  int mOldSelectedPosition = -1;
  long mOldSelectedRowId = -9223372036854775808L;
  AdapterView.OnItemClickListener mOnItemClickListener;
  OnItemLongClickListener mOnItemLongClickListener;
  OnItemSelectedListener mOnItemSelectedListener;
  @ViewDebug.ExportedProperty(category="list")
  int mSelectedPosition = -1;
  long mSelectedRowId = -9223372036854775808L;
  private IcsAdapterView<T>.SelectionNotifier mSelectionNotifier;
  int mSpecificTop;
  long mSyncHeight;
  int mSyncMode;
  int mSyncPosition;
  long mSyncRowId = -9223372036854775808L;
  
  public IcsAdapterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public IcsAdapterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public IcsAdapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void fireOnSelected()
  {
    if (this.mOnItemSelectedListener != null)
    {
      int i = getSelectedItemPosition();
      if (i < 0)
      {
        this.mOnItemSelectedListener.onNothingSelected(this);
      }
      else
      {
        View localView = getSelectedView();
        this.mOnItemSelectedListener.onItemSelected(this, localView, i, getAdapter().getItemId(i));
      }
    }
  }
  
  private boolean isScrollableForAccessibility()
  {
    boolean bool = false;
    Adapter localAdapter = getAdapter();
    if (localAdapter != null)
    {
      int i = localAdapter.getCount();
      if ((i > 0) && ((getFirstVisiblePosition() > 0) || (getLastVisiblePosition() < i - 1))) {
        bool = true;
      }
    }
    return bool;
  }
  
  private void updateEmptyStatus(boolean paramBoolean)
  {
    if (isInFilterMode()) {
      paramBoolean = false;
    }
    if (!paramBoolean)
    {
      if (this.mEmptyView != null) {
        this.mEmptyView.setVisibility(8);
      }
      setVisibility(0);
    }
    else
    {
      if (this.mEmptyView == null)
      {
        setVisibility(0);
      }
      else
      {
        this.mEmptyView.setVisibility(0);
        setVisibility(8);
      }
      if (this.mDataChanged) {
        onLayout(false, getLeft(), getTop(), getRight(), getBottom());
      }
    }
  }
  
  public void addView(View paramView)
  {
    throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
  }
  
  protected boolean canAnimate()
  {
    boolean bool;
    if ((!super.canAnimate()) || (this.mItemCount <= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  void checkFocus()
  {
    boolean bool1 = false;
    Adapter localAdapter = getAdapter();
    boolean bool2;
    if ((localAdapter != null) && (localAdapter.getCount() != 0)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    if ((bool2) && (!isInFilterMode())) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    boolean bool3;
    if ((!bool2) || (!this.mDesiredFocusableInTouchModeState)) {
      bool3 = false;
    } else {
      bool3 = true;
    }
    super.setFocusableInTouchMode(bool3);
    if ((!bool2) || (!this.mDesiredFocusableState)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    super.setFocusable(bool2);
    if (this.mEmptyView != null)
    {
      if ((localAdapter == null) || (localAdapter.isEmpty())) {
        bool1 = true;
      }
      updateEmptyStatus(bool1);
    }
  }
  
  void checkSelectionChanged()
  {
    if ((this.mSelectedPosition != this.mOldSelectedPosition) || (this.mSelectedRowId != this.mOldSelectedRowId))
    {
      selectionChanged();
      this.mOldSelectedPosition = this.mSelectedPosition;
      this.mOldSelectedRowId = this.mSelectedRowId;
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    View localView = getSelectedView();
    boolean bool;
    if ((localView == null) || (localView.getVisibility() != 0) || (!localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  int findSyncPosition()
  {
    int i = this.mItemCount;
    int i3;
    if (i != 0)
    {
      long l1 = this.mSyncRowId;
      int j = this.mSyncPosition;
      if (l1 != -9223372036854775808L)
      {
        j = Math.max(0, j);
        i3 = Math.min(i - 1, j);
        long l2 = 100L + SystemClock.uptimeMillis();
        int n = i3;
        int m = i3;
        int k = 0;
        Adapter localAdapter = getAdapter();
        if (localAdapter != null)
        {
          while (SystemClock.uptimeMillis() <= l2)
          {
            if (localAdapter.getItemId(i3) == l1) {
              break label222;
            }
            int i2;
            if (m != i - 1) {
              i2 = 0;
            } else {
              i2 = 1;
            }
            int i1;
            if (n != 0) {
              i1 = 0;
            } else {
              i1 = 1;
            }
            if ((i2 != 0) && (i1 != 0)) {
              break;
            }
            if ((i1 == 0) && ((k == 0) || (i2 != 0)))
            {
              if ((i2 != 0) || ((k == 0) && (i1 == 0)))
              {
                n--;
                i3 = n;
                k = 1;
              }
            }
            else
            {
              m++;
              i3 = m;
              k = 0;
            }
          }
          i3 = -1;
        }
        else
        {
          i3 = -1;
        }
      }
      else
      {
        i3 = -1;
      }
    }
    else
    {
      i3 = -1;
    }
    label222:
    return i3;
  }
  
  public abstract T getAdapter();
  
  @ViewDebug.CapturedViewProperty
  public int getCount()
  {
    return this.mItemCount;
  }
  
  public View getEmptyView()
  {
    return this.mEmptyView;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.mFirstPosition;
  }
  
  public Object getItemAtPosition(int paramInt)
  {
    Object localObject = getAdapter();
    if ((localObject != null) && (paramInt >= 0)) {
      localObject = ((Adapter)localObject).getItem(paramInt);
    } else {
      localObject = null;
    }
    return localObject;
  }
  
  public long getItemIdAtPosition(int paramInt)
  {
    Adapter localAdapter = getAdapter();
    long l;
    if ((localAdapter != null) && (paramInt >= 0)) {
      l = localAdapter.getItemId(paramInt);
    } else {
      l = -9223372036854775808L;
    }
    return l;
  }
  
  public int getLastVisiblePosition()
  {
    return -1 + (this.mFirstPosition + getChildCount());
  }
  
  public final AdapterView.OnItemClickListener getOnItemClickListener()
  {
    return this.mOnItemClickListener;
  }
  
  public final OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.mOnItemLongClickListener;
  }
  
  public final OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.mOnItemSelectedListener;
  }
  
  public int getPositionForView(View paramView)
  {
    int i = -1;
    Object localObject = paramView;
    int k;
    try
    {
      for (;;)
      {
        View localView = (View)((View)localObject).getParent();
        k = localView.equals(this);
        if (k != 0) {
          break;
        }
        localObject = localView;
      }
      return i;
    }
    catch (ClassCastException localClassCastException) {}
    label80:
    for (;;)
    {
      int j = getChildCount();
      for (k = 0;; k++)
      {
        if (k >= j) {
          break label80;
        }
        if (getChildAt(k).equals(localObject))
        {
          i = k + this.mFirstPosition;
          break;
        }
      }
    }
  }
  
  public Object getSelectedItem()
  {
    Object localObject = getAdapter();
    int i = getSelectedItemPosition();
    if ((localObject == null) || (((Adapter)localObject).getCount() <= 0) || (i < 0)) {
      localObject = null;
    } else {
      localObject = ((Adapter)localObject).getItem(i);
    }
    return localObject;
  }
  
  @ViewDebug.CapturedViewProperty
  public long getSelectedItemId()
  {
    return this.mNextSelectedRowId;
  }
  
  @ViewDebug.CapturedViewProperty
  public int getSelectedItemPosition()
  {
    return this.mNextSelectedPosition;
  }
  
  public abstract View getSelectedView();
  
  void handleDataChanged()
  {
    int j = this.mItemCount;
    int i = 0;
    if (j > 0)
    {
      int k;
      if (this.mNeedSync)
      {
        this.mNeedSync = false;
        k = findSyncPosition();
        if ((k >= 0) && (lookForSelectablePosition(k, true) == k))
        {
          setNextSelectedPositionInt(k);
          i = 1;
        }
      }
      if (i == 0)
      {
        k = getSelectedItemPosition();
        if (k >= j) {
          k = j - 1;
        }
        if (k < 0) {
          k = 0;
        }
        j = lookForSelectablePosition(k, true);
        if (j < 0) {
          j = lookForSelectablePosition(k, false);
        }
        if (j >= 0)
        {
          setNextSelectedPositionInt(j);
          checkSelectionChanged();
          i = 1;
        }
      }
    }
    if (i == 0)
    {
      this.mSelectedPosition = -1;
      this.mSelectedRowId = -9223372036854775808L;
      this.mNextSelectedPosition = -1;
      this.mNextSelectedRowId = -9223372036854775808L;
      this.mNeedSync = false;
      checkSelectionChanged();
    }
  }
  
  boolean isInFilterMode()
  {
    return false;
  }
  
  int lookForSelectablePosition(int paramInt, boolean paramBoolean)
  {
    return paramInt;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.mSelectionNotifier);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setScrollable(isScrollableForAccessibility());
    View localView = getSelectedView();
    if (localView != null) {
      paramAccessibilityEvent.setEnabled(localView.isEnabled());
    }
    paramAccessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
    paramAccessibilityEvent.setFromIndex(getFirstVisiblePosition());
    paramAccessibilityEvent.setToIndex(getLastVisiblePosition());
    paramAccessibilityEvent.setItemCount(getCount());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setScrollable(isScrollableForAccessibility());
    View localView = getSelectedView();
    if (localView != null) {
      paramAccessibilityNodeInfo.setEnabled(localView.isEnabled());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLayoutHeight = getHeight();
  }
  
  public boolean onRequestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool;
    if (!super.onRequestSendAccessibilityEvent(paramView, paramAccessibilityEvent))
    {
      int i = 0;
    }
    else
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      onInitializeAccessibilityEvent(localAccessibilityEvent);
      paramView.dispatchPopulateAccessibilityEvent(localAccessibilityEvent);
      paramAccessibilityEvent.appendRecord(localAccessibilityEvent);
      bool = true;
    }
    return bool;
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    boolean bool = false;
    if (this.mOnItemClickListener != null)
    {
      playSoundEffect(0);
      if (paramView != null) {
        paramView.sendAccessibilityEvent(1);
      }
      this.mOnItemClickListener.onItemClick(null, paramView, paramInt, paramLong);
      bool = true;
    }
    return bool;
  }
  
  void rememberSyncState()
  {
    if (getChildCount() > 0)
    {
      this.mNeedSync = true;
      this.mSyncHeight = this.mLayoutHeight;
      View localView;
      if (this.mSelectedPosition < 0)
      {
        localView = getChildAt(0);
        Adapter localAdapter = getAdapter();
        if ((this.mFirstPosition < 0) || (this.mFirstPosition >= localAdapter.getCount())) {
          this.mSyncRowId = -1L;
        } else {
          this.mSyncRowId = localAdapter.getItemId(this.mFirstPosition);
        }
        this.mSyncPosition = this.mFirstPosition;
        if (localView != null) {
          this.mSpecificTop = localView.getTop();
        }
        this.mSyncMode = 1;
      }
      else
      {
        localView = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        this.mSyncRowId = this.mNextSelectedRowId;
        this.mSyncPosition = this.mNextSelectedPosition;
        if (localView != null) {
          this.mSpecificTop = localView.getTop();
        }
        this.mSyncMode = 0;
      }
    }
  }
  
  public void removeAllViews()
  {
    throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
  }
  
  public void removeView(View paramView)
  {
    throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
  }
  
  public void removeViewAt(int paramInt)
  {
    throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
  }
  
  void selectionChanged()
  {
    if (this.mOnItemSelectedListener != null) {
      if ((!this.mInLayout) && (!this.mBlockLayoutRequests))
      {
        fireOnSelected();
      }
      else
      {
        if (this.mSelectionNotifier == null) {
          this.mSelectionNotifier = new SelectionNotifier(null);
        }
        post(this.mSelectionNotifier);
      }
    }
    if ((this.mSelectedPosition != -1) && (isShown()) && (!isInTouchMode())) {
      sendAccessibilityEvent(4);
    }
  }
  
  public abstract void setAdapter(T paramT);
  
  public void setEmptyView(View paramView)
  {
    this.mEmptyView = paramView;
    Adapter localAdapter = getAdapter();
    boolean bool;
    if ((localAdapter != null) && (!localAdapter.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    updateEmptyStatus(bool);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    boolean bool = true;
    Adapter localAdapter = getAdapter();
    int i;
    if ((localAdapter != null) && (localAdapter.getCount() != 0)) {
      i = 0;
    } else {
      i = bool;
    }
    this.mDesiredFocusableState = paramBoolean;
    if (!paramBoolean) {
      this.mDesiredFocusableInTouchModeState = false;
    }
    if ((!paramBoolean) || ((i != 0) && (!isInFilterMode()))) {
      bool = false;
    }
    super.setFocusable(bool);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    boolean bool = true;
    Adapter localAdapter = getAdapter();
    int i;
    if ((localAdapter != null) && (localAdapter.getCount() != 0)) {
      i = 0;
    } else {
      i = bool;
    }
    this.mDesiredFocusableInTouchModeState = paramBoolean;
    if (paramBoolean) {
      this.mDesiredFocusableState = bool;
    }
    if ((!paramBoolean) || ((i != 0) && (!isInFilterMode()))) {
      bool = false;
    }
    super.setFocusableInTouchMode(bool);
  }
  
  void setNextSelectedPositionInt(int paramInt)
  {
    this.mNextSelectedPosition = paramInt;
    this.mNextSelectedRowId = getItemIdAtPosition(paramInt);
    if ((this.mNeedSync) && (this.mSyncMode == 0) && (paramInt >= 0))
    {
      this.mSyncPosition = paramInt;
      this.mSyncRowId = this.mNextSelectedRowId;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mOnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(OnItemLongClickListener paramOnItemLongClickListener)
  {
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.mOnItemLongClickListener = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.mOnItemSelectedListener = paramOnItemSelectedListener;
  }
  
  void setSelectedPositionInt(int paramInt)
  {
    this.mSelectedPosition = paramInt;
    this.mSelectedRowId = getItemIdAtPosition(paramInt);
  }
  
  public abstract void setSelection(int paramInt);
  
  private class SelectionNotifier
    implements Runnable
  {
    private SelectionNotifier() {}
    
    public void run()
    {
      if (!IcsAdapterView.this.mDataChanged) {
        IcsAdapterView.this.fireOnSelected();
      } else if (IcsAdapterView.this.getAdapter() != null) {
        IcsAdapterView.this.post(this);
      }
    }
  }
  
  class AdapterDataSetObserver
    extends DataSetObserver
  {
    private Parcelable mInstanceState = null;
    
    AdapterDataSetObserver() {}
    
    public void clearSavedState()
    {
      this.mInstanceState = null;
    }
    
    public void onChanged()
    {
      IcsAdapterView.this.mDataChanged = true;
      IcsAdapterView.this.mOldItemCount = IcsAdapterView.this.mItemCount;
      IcsAdapterView.this.mItemCount = IcsAdapterView.this.getAdapter().getCount();
      if ((!IcsAdapterView.this.getAdapter().hasStableIds()) || (this.mInstanceState == null) || (IcsAdapterView.this.mOldItemCount != 0) || (IcsAdapterView.this.mItemCount <= 0))
      {
        IcsAdapterView.this.rememberSyncState();
      }
      else
      {
        IcsAdapterView.this.onRestoreInstanceState(this.mInstanceState);
        this.mInstanceState = null;
      }
      IcsAdapterView.this.checkFocus();
      IcsAdapterView.this.requestLayout();
    }
    
    public void onInvalidated()
    {
      IcsAdapterView.this.mDataChanged = true;
      if (IcsAdapterView.this.getAdapter().hasStableIds()) {
        this.mInstanceState = IcsAdapterView.this.onSaveInstanceState();
      }
      IcsAdapterView.this.mOldItemCount = IcsAdapterView.this.mItemCount;
      IcsAdapterView.this.mItemCount = 0;
      IcsAdapterView.this.mSelectedPosition = -1;
      IcsAdapterView.this.mSelectedRowId = -9223372036854775808L;
      IcsAdapterView.this.mNextSelectedPosition = -1;
      IcsAdapterView.this.mNextSelectedRowId = -9223372036854775808L;
      IcsAdapterView.this.mNeedSync = false;
      IcsAdapterView.this.checkFocus();
      IcsAdapterView.this.requestLayout();
    }
  }
  
  public static class AdapterContextMenuInfo
    implements ContextMenu.ContextMenuInfo
  {
    public long id;
    public int position;
    public View targetView;
    
    public AdapterContextMenuInfo(View paramView, int paramInt, long paramLong)
    {
      this.targetView = paramView;
      this.position = paramInt;
      this.id = paramLong;
    }
  }
  
  public static abstract interface OnItemSelectedListener
  {
    public abstract void onItemSelected(IcsAdapterView<?> paramIcsAdapterView, View paramView, int paramInt, long paramLong);
    
    public abstract void onNothingSelected(IcsAdapterView<?> paramIcsAdapterView);
  }
  
  public static abstract interface OnItemLongClickListener
  {
    public abstract boolean onItemLongClick(IcsAdapterView<?> paramIcsAdapterView, View paramView, int paramInt, long paramLong);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.IcsAdapterView
 * JD-Core Version:    0.7.0.1
 */