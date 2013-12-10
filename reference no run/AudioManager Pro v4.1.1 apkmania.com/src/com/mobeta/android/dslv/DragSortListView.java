package com.mobeta.android.dslv;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ListView.FixedViewInfo;
import android.widget.RelativeLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DragSortListView
  extends ListView
{
  private static final int FLING = 0;
  public static final int NO_DRAG = 0;
  private static final int SLIDE = 1;
  private static final int SLIDELEFT = 2;
  public static final int SRC_ABOVE = 2;
  public static final int SRC_BELOW = 3;
  public static final int SRC_EXP = 1;
  private static final int TRASH = 3;
  private AdapterWrapper mAdapterWrapper;
  private int mDownScrollStartY;
  private float mDownScrollStartYF;
  private int mDownY;
  private Bitmap mDragBitmap;
  private float mDragDownScrollHeight;
  private float mDragDownScrollStartFrac = 0.3333333F;
  private DragListener mDragListener;
  private int mDragPointX;
  private int mDragPointY;
  private DragScroller mDragScroller;
  private int mDragState = 0;
  private float mDragUpScrollHeight;
  private float mDragUpScrollStartFrac = 0.3333333F;
  private DropListener mDropListener;
  private int mExpBottom;
  private int mExpDragPos;
  private int mExpTop;
  private int mExpandedChildHeight;
  private int mFloatBGColor;
  private ImageView mFloatView;
  private int mFloatViewHeight;
  private int mFloatViewHeightHalf;
  private ArrayList<Integer> mFooterHeights = new ArrayList();
  private int mFootersTotalHeight = 0;
  private GestureDetector mGestureDetector;
  private ArrayList<Integer> mHeaderHeights = new ArrayList();
  private int mHeadersTotalHeight = 0;
  private int mItemHeightCollapsed = 1;
  private int mLastX;
  private int mLastY;
  private float mMaxScrollSpeed = 0.3F;
  private RemoveListener mRemoveListener;
  private int mRemoveMode = -1;
  private View[] mSampleViewTypes = new View[1];
  private DragScrollProfile mScrollProfile = new DragScrollProfile()
  {
    public float getSpeed(float paramAnonymousFloat, long paramAnonymousLong)
    {
      return paramAnonymousFloat * DragSortListView.this.mMaxScrollSpeed;
    }
  };
  private int mSrcBottom;
  private int mSrcDragPos;
  private int mSrcTop;
  private int[] mTempLoc = new int[2];
  private Rect mTempRect = new Rect();
  private final int mTouchSlop;
  private boolean mTrackDragScroll = false;
  private Drawable mTrashcan;
  private int mUpScrollStartY;
  private float mUpScrollStartYF;
  private WindowManager mWindowManager;
  private WindowManager.LayoutParams mWindowParams;
  private int mXOffset;
  private int mYOffset;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView, 0, 0);
      this.mItemHeightCollapsed = localTypedArray.getDimensionPixelSize(0, this.mItemHeightCollapsed);
      this.mTrackDragScroll = localTypedArray.getBoolean(5, false);
      this.mFloatBGColor = localTypedArray.getColor(3, 0);
      this.mRemoveMode = localTypedArray.getInt(4, -1);
      setDragScrollStart(localTypedArray.getFloat(1, this.mDragUpScrollStartFrac));
      this.mMaxScrollSpeed = localTypedArray.getFloat(2, this.mMaxScrollSpeed);
      localTypedArray.recycle();
    }
    this.mDragScroller = new DragScroller();
    setOnScrollListener(this.mDragScroller);
  }
  
  private void collapseItem(int paramInt)
  {
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      int i = localLayoutParams.height;
      if (paramInt != this.mSrcDragPos)
      {
        if (paramInt != this.mExpDragPos) {
          Log.d("mobeta", "collapse ignored, pos=" + paramInt);
        } else {
          localLayoutParams.height = -2;
        }
      }
      else {
        localLayoutParams.height = this.mItemHeightCollapsed;
      }
      if (localLayoutParams.height != i) {
        localView.requestLayout();
      }
    }
  }
  
  private void dragView(int paramInt1, int paramInt2)
  {
    float f;
    if (this.mRemoveMode == 1)
    {
      f = 1.0F;
      i = this.mFloatView.getWidth();
      if (paramInt1 > i / 2) {
        f = (i - paramInt1) / (i / 2);
      }
      this.mWindowParams.alpha = f;
    }
    if (this.mRemoveMode == 2)
    {
      f = 1.0F;
      i = this.mFloatView.getWidth();
      if (paramInt1 < i / 2) {
        f = paramInt1 / (i / 2);
      }
      this.mWindowParams.alpha = f;
    }
    if ((this.mRemoveMode != 0) && (this.mRemoveMode != 3)) {
      this.mWindowParams.x = (this.mXOffset + getPaddingLeft());
    } else {
      this.mWindowParams.x = (paramInt1 - this.mDragPointX + this.mXOffset);
    }
    int n = getHeaderViewsCount();
    int i = getFooterViewsCount();
    int m = getFirstVisiblePosition();
    int k = getLastVisiblePosition();
    int j = getPaddingTop();
    if (m < n) {
      j = getChildAt(-1 + (n - m)).getBottom();
    }
    n = getHeight() - getPaddingBottom();
    if (k >= getCount() - i) {
      n = getChildAt(getCount() - i - m).getTop();
    }
    if (paramInt2 - this.mDragPointY >= j)
    {
      if (paramInt2 - this.mDragPointY + this.mFloatViewHeight <= n) {
        this.mWindowParams.y = (paramInt2 - this.mDragPointY + this.mYOffset);
      } else {
        this.mWindowParams.y = (n + this.mYOffset - this.mFloatViewHeight);
      }
    }
    else {
      this.mWindowParams.y = (j + this.mYOffset);
    }
    this.mWindowManager.updateViewLayout(this.mFloatView, this.mWindowParams);
    if (this.mTrashcan != null)
    {
      i = this.mFloatView.getWidth();
      if (paramInt2 <= 3 * getHeight() / 4)
      {
        if ((i <= 0) || (paramInt1 <= i / 4)) {
          this.mTrashcan.setLevel(0);
        } else {
          this.mTrashcan.setLevel(1);
        }
      }
      else {
        this.mTrashcan.setLevel(2);
      }
    }
  }
  
  private void dropFloatView(boolean paramBoolean)
  {
    this.mDragScroller.stopScrolling(true);
    if (!paramBoolean)
    {
      if ((this.mDropListener != null) && (this.mExpDragPos >= 0) && (this.mExpDragPos < getCount()))
      {
        i = getHeaderViewsCount();
        this.mDropListener.drop(this.mSrcDragPos - i, this.mExpDragPos - i);
      }
      int i = getFirstVisiblePosition();
      View localView2 = getChildAt(this.mExpDragPos - i);
      if (localView2 != null)
      {
        localView2.getLayoutParams().height = -2;
        localView2.requestLayout();
      }
      View localView1;
      if (this.mSrcDragPos >= i)
      {
        if (this.mSrcDragPos <= getLastVisiblePosition())
        {
          localView1 = getChildAt(this.mSrcDragPos - i);
          localView1.getLayoutParams().height = -2;
          localView1.requestLayout();
          localView1.setVisibility(0);
        }
      }
      else
      {
        localView2 = getChildAt(0);
        int j = 0;
        if (localView2 != null) {
          j = localView2.getTop();
        }
        setSelectionFromTop(localView1 - 1, j - getPaddingTop());
      }
    }
    else if (this.mRemoveListener != null)
    {
      this.mRemoveListener.remove(this.mSrcDragPos - getHeaderViewsCount());
    }
    removeFloatView();
    this.mDragState = 0;
  }
  
  private void expandItem(int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)getChildAt(paramInt - getFirstVisiblePosition());
    if ((localRelativeLayout != null) && (this.mFloatView != null))
    {
      ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
      int i = localLayoutParams.height;
      if ((localLayoutParams.height != this.mItemHeightCollapsed) || (paramInt != this.mSrcDragPos))
      {
        if ((localLayoutParams.height != -2) || (paramInt == this.mExpDragPos))
        {
          Log.d("mobeta", "expand item skipped");
        }
        else
        {
          localLayoutParams.height = (localRelativeLayout.getHeight() + this.mFloatViewHeight + getDividerHeight());
          if (paramInt <= this.mSrcDragPos) {
            localRelativeLayout.setGravity(80);
          } else {
            localRelativeLayout.setGravity(48);
          }
        }
      }
      else {
        localLayoutParams.height = -2;
      }
      if (localLayoutParams.height != i) {
        localRelativeLayout.requestLayout();
      }
    }
  }
  
  private int getDragEdge(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      int i;
      if (paramInt1 > this.mExpDragPos)
      {
        i = paramInt2 + (getVisualItemHeight(paramInt1) - this.mFloatViewHeight) / 2;
        if (this.mDragState == 1) {
          i += this.mItemHeightCollapsed;
        }
      }
      else
      {
        i = paramInt2 + (this.mFloatViewHeight - getVisualItemHeight(paramInt1 - 1)) / 2;
        if (this.mDragState == 1) {
          i -= this.mItemHeightCollapsed;
        }
      }
      paramInt2 = i;
    }
    return paramInt2;
  }
  
  private int getFloatPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = Math.max(this.mFloatViewHeightHalf + getPaddingTop(), Math.min(getHeight() - getPaddingBottom() - this.mFloatViewHeightHalf, paramInt1 - this.mDragPointY + this.mFloatViewHeightHalf));
    int m = getDividerHeight();
    int j;
    switch (this.mDragState)
    {
    default: 
      i = paramInt3;
      j = paramInt2;
      break;
    case 2: 
      i = paramInt3;
      if (paramInt2 == 1 + this.mSrcDragPos) {
        i -= m + this.mItemHeightCollapsed;
      }
      if ((paramInt2 <= this.mSrcDragPos) || (paramInt2 > this.mExpDragPos)) {
        j = paramInt2;
      } else {
        j = paramInt2 - 1;
      }
      break;
    case 3: 
      i = paramInt3;
      if (paramInt2 == this.mSrcDragPos)
      {
        if (paramInt2 != -1 + getCount()) {
          i += m + this.mItemHeightCollapsed;
        }
      }
      else
      {
        if ((paramInt2 > this.mSrcDragPos) || (paramInt2 <= this.mExpDragPos))
        {
          j = paramInt2;
          break;
        }
        j = paramInt2 + 1;
        break;
      }
      j = getItemHeight(paramInt2 - 1);
      if (paramInt2 - 1 != this.mExpDragPos) {
        i -= j + m;
      } else {
        i -= j - this.mFloatViewHeight;
      }
      j = paramInt2;
    }
    if (k >= getDragEdge(j, i))
    {
      m = getCount();
      while ((j < m) && (j != m - 1))
      {
        i += getVisualItemHeight(j);
        if (k < getDragEdge(j + 1, i)) {
          break;
        }
        j++;
      }
    }
    while (j >= 0)
    {
      j--;
      if (j > 0)
      {
        i -= getVisualItemHeight(j);
        if (k >= getDragEdge(j, i)) {
          break;
        }
      }
      else
      {
        j = 0;
      }
    }
    k = getHeaderViewsCount();
    int i = getFooterViewsCount();
    if (j >= k) {
      if (j < getCount() - i) {
        k = j;
      } else {
        k = -1 + (getCount() - i);
      }
    }
    return k;
  }
  
  private int getItemHeight(int paramInt)
  {
    int j = getFirstVisiblePosition();
    int i = getLastVisiblePosition();
    int k;
    if ((paramInt < j) || (paramInt > i))
    {
      Object localObject = getAdapter();
      j = ((ListAdapter)localObject).getItemViewType(paramInt);
      int m = ((ListAdapter)localObject).getViewTypeCount();
      if (m != this.mSampleViewTypes.length) {
        this.mSampleViewTypes = new View[m];
      }
      if (j < 0)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
      }
      else if (this.mSampleViewTypes[j] != null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, this.mSampleViewTypes[j], this);
      }
      else
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.mSampleViewTypes[j] = localObject;
      }
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
      if (localLayoutParams != null) {
        k = localLayoutParams.height;
      } else {
        k = 0;
      }
      if (k <= 0)
      {
        k = View.MeasureSpec.makeMeasureSpec(0, 0);
        ((View)localObject).measure(k, k);
        k = ((View)localObject).getMeasuredHeight();
      }
    }
    else
    {
      k = getChildAt(paramInt - k).getHeight();
    }
    return k;
  }
  
  private int getViewHeight(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i;
    if (localLayoutParams != null) {
      i = localLayoutParams.height;
    } else {
      i = 0;
    }
    if (i <= 0)
    {
      i = View.MeasureSpec.makeMeasureSpec(0, 0);
      paramView.measure(i, i);
      i = paramView.getMeasuredHeight();
    }
    return i;
  }
  
  private int getVisualItemHeight(int paramInt)
  {
    int i = getDividerHeight();
    if (paramInt != this.mExpDragPos)
    {
      switch (this.mDragState)
      {
      case 2: 
        if ((paramInt >= this.mSrcDragPos) && (paramInt < this.mExpDragPos))
        {
          j = getItemHeight(paramInt + 1);
          if (paramInt == this.mSrcDragPos) {
            j += i + this.mItemHeightCollapsed;
          }
          if (paramInt == -1 + this.mExpDragPos) {
            j -= this.mFloatViewHeight;
          }
          i = j + i;
        }
        break;
      case 3: 
        if ((paramInt <= this.mSrcDragPos) && (paramInt > this.mExpDragPos)) {
          break label136;
        }
      }
      return getItemHeight(paramInt) + getDividerHeight();
      label136:
      int j = getItemHeight(paramInt - 1);
      if (paramInt == this.mSrcDragPos) {
        j += i + this.mItemHeightCollapsed;
      }
      if (paramInt == 1 + this.mExpDragPos) {
        j -= this.mFloatViewHeight;
      }
      i = j + i;
    }
    else
    {
      i += this.mFloatViewHeight;
    }
    return i;
  }
  
  private void removeFloatView()
  {
    if (this.mFloatView != null)
    {
      this.mFloatView.setVisibility(8);
      ((WindowManager)getContext().getSystemService("window")).removeView(this.mFloatView);
      this.mFloatView.setImageDrawable(null);
      this.mFloatView = null;
    }
    if (this.mDragBitmap != null)
    {
      this.mDragBitmap.recycle();
      this.mDragBitmap = null;
    }
    if (this.mTrashcan != null) {
      this.mTrashcan.setLevel(0);
    }
  }
  
  private boolean shuffleItems(int paramInt)
  {
    int i;
    if (paramInt == this.mExpDragPos)
    {
      i = 0;
    }
    else
    {
      collapseItem(this.mExpDragPos);
      expandItem(paramInt);
      if (this.mDragListener != null)
      {
        i = getHeaderViewsCount();
        this.mDragListener.drag(this.mExpDragPos - i, paramInt - i);
      }
      this.mExpDragPos = paramInt;
      updateListState();
      i = 1;
    }
    return i;
  }
  
  private void startDragging(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    this.mWindowParams = new WindowManager.LayoutParams();
    this.mWindowParams.gravity = 51;
    this.mWindowParams.x = (paramInt1 - this.mDragPointX + this.mXOffset);
    this.mWindowParams.y = (paramInt2 - this.mDragPointY + this.mYOffset);
    this.mWindowParams.height = -2;
    this.mWindowParams.width = -2;
    this.mWindowParams.flags = 920;
    this.mWindowParams.format = -3;
    this.mWindowParams.windowAnimations = 0;
    Context localContext = getContext();
    ImageView localImageView = new ImageView(localContext);
    localImageView.setBackgroundColor(this.mFloatBGColor);
    localImageView.setPadding(0, 0, 0, 0);
    localImageView.setImageBitmap(paramBitmap);
    this.mDragBitmap = paramBitmap;
    this.mWindowManager = ((WindowManager)localContext.getSystemService("window"));
    this.mWindowManager.addView(localImageView, this.mWindowParams);
    this.mFloatView = localImageView;
    this.mDragState = 1;
  }
  
  private void updateListState()
  {
    if (this.mFloatView != null)
    {
      if (this.mExpDragPos != this.mSrcDragPos)
      {
        if (this.mSrcDragPos >= this.mExpDragPos) {
          this.mDragState = 3;
        } else {
          this.mDragState = 2;
        }
      }
      else {
        this.mDragState = 1;
      }
    }
    else {
      this.mDragState = 0;
    }
  }
  
  private void updateScrollStarts()
  {
    int i = getPaddingTop();
    int j = getHeight() - i - getPaddingBottom();
    float f = j;
    this.mUpScrollStartYF = (i + f * this.mDragUpScrollStartFrac);
    this.mDownScrollStartYF = (i + f * (1.0F - this.mDragDownScrollStartFrac));
    this.mUpScrollStartY = ((int)this.mUpScrollStartYF);
    this.mDownScrollStartY = ((int)this.mDownScrollStartYF);
    Log.d("mobeta", "up start=" + this.mUpScrollStartY);
    Log.d("mobeta", "down start=" + this.mDownScrollStartY);
    this.mDragUpScrollHeight = (this.mUpScrollStartYF - i);
    this.mDragDownScrollHeight = (i + j - this.mDownScrollStartYF);
  }
  
  public void addFooterView(View paramView, Object paramObject, boolean paramBoolean)
  {
    super.addFooterView(paramView, paramObject, paramBoolean);
    this.mFooterHeights.add(Integer.valueOf(getViewHeight(paramView)));
    this.mFootersTotalHeight += ((Integer)this.mFooterHeights.get(-1 + this.mFooterHeights.size())).intValue();
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    super.addHeaderView(paramView, paramObject, paramBoolean);
    this.mHeaderHeights.add(Integer.valueOf(getViewHeight(paramView)));
    this.mHeadersTotalHeight += ((Integer)this.mHeaderHeights.get(-1 + this.mHeaderHeights.size())).intValue();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.mFloatView != null) && (this.mDragState != 0) && (this.mDragState != 1))
    {
      Drawable localDrawable = getDivider();
      int k = getDividerHeight();
      if ((localDrawable != null) && (k != 0))
      {
        View localView = getChildAt(this.mExpDragPos - getFirstVisiblePosition());
        if (localView != null)
        {
          int j = getPaddingLeft();
          int i = getWidth() - getPaddingRight();
          int n;
          int m;
          if (this.mDragState != 2)
          {
            n = localView.getTop() + this.mFloatViewHeight;
            m = n + k;
          }
          else
          {
            m = m.getBottom() - this.mFloatViewHeight;
            n = m - k;
          }
          localDrawable.setBounds(j, n, i, m);
          localDrawable.draw(paramCanvas);
        }
      }
    }
  }
  
  public ListAdapter getInputAdapter()
  {
    ListAdapter localListAdapter;
    if (this.mAdapterWrapper != null) {
      localListAdapter = this.mAdapterWrapper.getAdapter();
    } else {
      localListAdapter = null;
    }
    return localListAdapter;
  }
  
  protected void layoutChildren()
  {
    if (this.mFloatView == null) {
      super.layoutChildren();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mRemoveListener != null) && (this.mGestureDetector == null) && (this.mRemoveMode == 0)) {
      this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()
      {
        public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          boolean bool = true;
          if (DragSortListView.this.mFloatView == null)
          {
            bool = false;
          }
          else if (paramAnonymousFloat1 > 1000.0F)
          {
            Rect localRect = DragSortListView.this.mTempRect;
            DragSortListView.this.mFloatView.getDrawingRect(localRect);
            if (paramAnonymousMotionEvent2.getX() > 2 * localRect.right / 3) {
              DragSortListView.this.dropFloatView(bool);
            }
          }
          return bool;
        }
      });
    }
    int k;
    int m;
    ViewGroup localViewGroup;
    if ((this.mDragListener != null) || (this.mDropListener != null)) {
      switch (paramMotionEvent.getAction())
      {
      case 0: 
        k = (int)paramMotionEvent.getX();
        m = (int)paramMotionEvent.getY();
        this.mLastX = k;
        this.mLastY = m;
        this.mDownY = m;
        int i = pointToPosition(k, m);
        int n = getHeaderViewsCount();
        int i1 = getFooterViewsCount();
        if ((i != -1) && (i >= n) && (i < getCount() - i1))
        {
          localViewGroup = (ViewGroup)getChildAt(i - getFirstVisiblePosition());
          this.mDragPointX = (k - localViewGroup.getLeft());
          this.mDragPointY = (m - localViewGroup.getTop());
          int i3 = (int)paramMotionEvent.getRawX();
          int i2 = (int)paramMotionEvent.getRawY();
          this.mXOffset = (i3 - k);
          this.mYOffset = (i2 - m);
          View localView = (View)localViewGroup.getTag();
          i1 = 0;
          if (localView != null)
          {
            localView.getLocationOnScreen(this.mTempLoc);
            if ((i3 <= this.mTempLoc[0]) || (i2 <= this.mTempLoc[1]) || (i3 >= this.mTempLoc[0] + localView.getWidth()) || (i2 >= this.mTempLoc[1] + localView.getHeight())) {
              i1 = 0;
            } else {
              i1 = 1;
            }
          }
          if (i1 != 0) {
            break label332;
          }
          removeFloatView();
        }
        break;
      }
    }
    int j = super.onInterceptTouchEvent(paramMotionEvent);
    return j;
    label332:
    localViewGroup.setDrawingCacheEnabled(true);
    Bitmap localBitmap = Bitmap.createBitmap(localViewGroup.getDrawingCache());
    localViewGroup.setDrawingCacheEnabled(false);
    this.mFloatViewHeight = localViewGroup.getHeight();
    this.mFloatViewHeightHalf = (this.mFloatViewHeight / 2);
    this.mExpDragPos = j;
    this.mSrcDragPos = j;
    startDragging(localBitmap, k, m);
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    localMotionEvent.setAction(3);
    super.onInterceptTouchEvent(localMotionEvent);
    boolean bool = true;
    return bool;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    updateScrollStarts();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mGestureDetector != null) {
      this.mGestureDetector.onTouchEvent(paramMotionEvent);
    }
    int i;
    if (((this.mDragListener == null) && (this.mDropListener == null)) || (this.mFloatView == null))
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
    }
    else
    {
      int k = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      i = (int)paramMotionEvent.getY();
      Object localObject;
      switch (k & 0xFF)
      {
      case 1: 
      case 3: 
        localObject = this.mTempRect;
        this.mFloatView.getDrawingRect((Rect)localObject);
        if ((this.mRemoveMode != 1) || (paramMotionEvent.getX() <= 3 * ((Rect)localObject).right / 4))
        {
          if ((this.mRemoveMode != 2) || (paramMotionEvent.getX() >= 1 * ((Rect)localObject).right / 4)) {
            dropFloatView(false);
          } else {
            dropFloatView(true);
          }
        }
        else {
          dropFloatView(true);
        }
        break;
      case 2: 
        if (this.mLastY == this.mDownY)
        {
          localObject = getChildAt(this.mSrcDragPos - getFirstVisiblePosition());
          if (localObject != null) {
            ((View)localObject).setVisibility(4);
          }
        }
        dragView(j, i);
        if (!this.mDragScroller.isScrolling())
        {
          int i1 = getFirstVisiblePosition();
          View localView = getChildAt(this.mExpDragPos - i1);
          int n;
          if (localView != null)
          {
            m = this.mExpDragPos;
            n = localView.getTop();
          }
          else
          {
            m = i1 + getChildCount() / 2;
            n = getChildAt(m - i1).getTop();
            Log.d("mobeta", "startView was null");
          }
          if (shuffleItems(getFloatPosition(i, m, n))) {
            super.layoutChildren();
          }
        }
        int m = this.mDragScroller.getScrollDir();
        if ((i <= this.mLastY) || (i <= this.mDownScrollStartY) || (m == 1))
        {
          if ((i >= this.mLastY) || (i >= this.mUpScrollStartY) || (m == 0))
          {
            if ((i >= this.mUpScrollStartY) && (i <= this.mDownScrollStartY) && (this.mDragScroller.isScrolling())) {
              this.mDragScroller.stopScrolling(true);
            }
          }
          else
          {
            if (m != -1) {
              this.mDragScroller.stopScrolling(true);
            }
            this.mDragScroller.startScrolling(0);
          }
        }
        else
        {
          if (m != -1) {
            this.mDragScroller.stopScrolling(true);
          }
          this.mDragScroller.startScrolling(1);
        }
        break;
      }
      this.mLastX = j;
      this.mLastY = i;
      i = 1;
    }
    return i;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    this.mAdapterWrapper = new AdapterWrapper(null, null, paramListAdapter);
    super.setAdapter(this.mAdapterWrapper);
    dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0));
  }
  
  public void setDragBackgroundColor(int paramInt)
  {
    this.mFloatBGColor = paramInt;
  }
  
  public void setDragListener(DragListener paramDragListener)
  {
    this.mDragListener = paramDragListener;
  }
  
  public void setDragScrollProfile(DragScrollProfile paramDragScrollProfile)
  {
    if (paramDragScrollProfile != null) {
      this.mScrollProfile = paramDragScrollProfile;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    setDragScrollStarts(paramFloat, paramFloat);
  }
  
  public void setDragScrollStarts(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 <= 0.5F) {
      this.mDragDownScrollStartFrac = paramFloat2;
    } else {
      this.mDragDownScrollStartFrac = 0.5F;
    }
    if (paramFloat1 <= 0.5F) {
      this.mDragUpScrollStartFrac = paramFloat1;
    } else {
      this.mDragUpScrollStartFrac = 0.5F;
    }
    if (getHeight() != 0) {
      updateScrollStarts();
    }
  }
  
  public void setDropListener(DropListener paramDropListener)
  {
    this.mDropListener = paramDropListener;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.mMaxScrollSpeed = paramFloat;
  }
  
  public void setRemoveListener(RemoveListener paramRemoveListener)
  {
    this.mRemoveListener = paramRemoveListener;
  }
  
  public void setTrashcan(Drawable paramDrawable)
  {
    this.mTrashcan = paramDrawable;
    this.mRemoveMode = 3;
  }
  
  private class StateTracker
  {
    StringBuilder mBuilder = new StringBuilder();
    File mFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
    private HashMap<String, Integer> mInts = new HashMap();
    private int mNumFlushes = 0;
    private int mNumInBuffer = 0;
    private boolean mTracking = false;
    
    public StateTracker()
    {
      if (!this.mFile.exists()) {}
      try
      {
        this.mFile.createNewFile();
        Log.d("mobeta", "file created");
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.w("mobeta", "Could not create dslv_state.txt");
          Log.d("mobeta", localIOException.getMessage());
        }
      }
    }
    
    public void appendState()
    {
      int i;
      int k;
      if (this.mTracking)
      {
        this.mBuilder.append("<DSLVState>\n");
        i = DragSortListView.this.getChildCount();
        k = DragSortListView.this.getFirstVisiblePosition();
        this.mBuilder.append("  <Positions>");
      }
      for (int j = 0;; j++)
      {
        if (j >= i)
        {
          this.mBuilder.append("</Positions>\n");
          this.mBuilder.append("  <Tops>");
          for (j = 0;; j++)
          {
            if (j >= i)
            {
              this.mBuilder.append("</Tops>\n");
              this.mBuilder.append("  <Bottoms>");
              for (j = 0;; j++)
              {
                if (j >= i)
                {
                  this.mBuilder.append("</Bottoms>\n");
                  this.mBuilder.append("  <ExpPos>").append(DragSortListView.this.mExpDragPos).append("</ExpPos>\n");
                  this.mBuilder.append("  <SrcPos>").append(DragSortListView.this.mSrcDragPos).append("</SrcPos>\n");
                  this.mBuilder.append("  <DragState>").append(DragSortListView.this.mDragState).append("</DragState>\n");
                  this.mBuilder.append("  <SrcHeight>").append(DragSortListView.this.mFloatViewHeight + DragSortListView.this.getDividerHeight()).append("</SrcHeight>\n");
                  this.mBuilder.append("  <ViewHeight>").append(DragSortListView.this.getHeight()).append("</ViewHeight>\n");
                  this.mBuilder.append("  <LastY>").append(DragSortListView.this.mLastY).append("</LastY>\n");
                  this.mBuilder.append("</DSLVState>\n");
                  this.mNumInBuffer = (1 + this.mNumInBuffer);
                  if (this.mNumInBuffer > 1000)
                  {
                    flush();
                    this.mNumInBuffer = 0;
                  }
                  return;
                }
                this.mBuilder.append(DragSortListView.this.getChildAt(j).getBottom()).append(",");
              }
            }
            this.mBuilder.append(DragSortListView.this.getChildAt(j).getTop()).append(",");
          }
        }
        this.mBuilder.append(k + j).append(",");
      }
    }
    
    public void flush()
    {
      if (!this.mTracking) {}
      for (;;)
      {
        return;
        boolean bool = true;
        try
        {
          if (this.mNumFlushes == 0) {
            bool = false;
          }
          FileWriter localFileWriter = new FileWriter(this.mFile, bool);
          localFileWriter.write(this.mBuilder.toString());
          this.mBuilder.delete(0, this.mBuilder.length());
          localFileWriter.flush();
          localFileWriter.close();
          this.mNumFlushes = (1 + this.mNumFlushes);
        }
        catch (IOException localIOException) {}
      }
    }
    
    public void putInt(String paramString, int paramInt)
    {
      this.mInts.put(paramString, Integer.valueOf(paramInt));
    }
    
    public void startTracking()
    {
      this.mBuilder.append("<DSLVStates>\n");
      this.mNumFlushes = 0;
      this.mTracking = true;
    }
    
    public void stopTracking()
    {
      if (this.mTracking)
      {
        this.mBuilder.append("</DSLVStates>\n");
        flush();
        this.mTracking = false;
      }
    }
  }
  
  private class DragScroller
    implements Runnable, AbsListView.OnScrollListener
  {
    public static final int DOWN = 1;
    public static final int STOP = -1;
    public static final int UP;
    private float dt;
    private int dy;
    private boolean mAbort;
    private int mFirstFooter;
    private int mLastHeader;
    private long mPrevTime;
    private float mScrollSpeed;
    private boolean mScrolling = false;
    private DragSortListView.StateTracker mStateTracker;
    private int scrollDir;
    private long tStart;
    
    public DragScroller()
    {
      if (DragSortListView.this.mTrackDragScroll)
      {
        Log.d("mobeta", "state tracker created");
        this.mStateTracker = new DragSortListView.StateTracker(DragSortListView.this);
      }
    }
    
    public int getScrollDir()
    {
      int i;
      if (!this.mScrolling) {
        i = -1;
      } else {
        i = this.scrollDir;
      }
      return i;
    }
    
    public boolean isScrolling()
    {
      return this.mScrolling;
    }
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((this.mScrolling) && (paramInt2 != 0))
      {
        int i;
        int j;
        if (paramInt1 > this.mLastHeader)
        {
          if (paramInt1 + paramInt2 > this.mFirstFooter)
          {
            i = DragSortListView.this.mLastY - DragSortListView.this.mDragPointY + DragSortListView.this.mFloatViewHeight;
            j = DragSortListView.this.getChildAt(this.mFirstFooter - paramInt1).getTop();
            if (i > j)
            {
              DragSortListView.this.mWindowParams.y = (j + DragSortListView.this.mYOffset - DragSortListView.this.mFloatViewHeight);
              DragSortListView.this.mWindowManager.updateViewLayout(DragSortListView.this.mFloatView, DragSortListView.this.mWindowParams);
            }
          }
        }
        else
        {
          i = DragSortListView.this.mLastY - DragSortListView.this.mDragPointY;
          j = DragSortListView.this.getChildAt(this.mLastHeader - paramInt1).getBottom();
          if (i < j)
          {
            DragSortListView.this.mWindowParams.y = (j + DragSortListView.this.mYOffset);
            DragSortListView.this.mWindowManager.updateViewLayout(DragSortListView.this.mFloatView, DragSortListView.this.mWindowParams);
          }
        }
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
    
    public void run()
    {
      if (!this.mAbort)
      {
        if (DragSortListView.this.mTrackDragScroll) {
          this.mStateTracker.appendState();
        }
        if (this.scrollDir != 0) {
          this.mScrollSpeed = (-DragSortListView.this.mScrollProfile.getSpeed((DragSortListView.this.mLastY - DragSortListView.this.mDownScrollStartYF) / DragSortListView.this.mDragDownScrollHeight, this.mPrevTime));
        } else {
          this.mScrollSpeed = DragSortListView.this.mScrollProfile.getSpeed((DragSortListView.this.mUpScrollStartYF - DragSortListView.this.mLastY) / DragSortListView.this.mDragUpScrollHeight, this.mPrevTime);
        }
        this.dt = ((float)(SystemClock.uptimeMillis() - this.mPrevTime));
        this.dy = Math.round(this.mScrollSpeed * this.dt);
        if (this.dy != 0)
        {
          int i = DragSortListView.this.getFirstVisiblePosition();
          int m = DragSortListView.this.getLastVisiblePosition();
          int n = DragSortListView.this.getCount();
          int k = DragSortListView.this.getPaddingTop();
          int j = DragSortListView.this.getHeight() - k - DragSortListView.this.getPaddingBottom();
          if (this.dy <= 0)
          {
            if ((m != n - 1) || (DragSortListView.this.getChildAt(m - i).getBottom() > j + k))
            {
              k = m;
              this.dy = Math.max(-j, this.dy);
            }
            else
            {
              this.mScrolling = false;
              return;
            }
          }
          else
          {
            View localView = DragSortListView.this.getChildAt(0);
            if ((localView == null) || ((i == 0) && (localView.getTop() == k))) {
              break label506;
            }
            k = i;
            this.dy = Math.min(j, this.dy);
          }
          i = DragSortListView.this.getChildAt(k - i).getTop() + this.dy;
          j = DragSortListView.this.getFloatPosition(DragSortListView.this.mLastY, k, i);
          if (j != DragSortListView.this.mExpDragPos) {
            if ((this.scrollDir != 1) || (j != k))
            {
              if ((j < k) && ((this.scrollDir == 0) || ((this.scrollDir == 1) && (k == DragSortListView.this.mExpDragPos)))) {
                i += DragSortListView.this.mFloatViewHeight + DragSortListView.this.getDividerHeight();
              }
            }
            else {
              i -= DragSortListView.this.mFloatViewHeight + DragSortListView.this.getDividerHeight();
            }
          }
          DragSortListView.this.shuffleItems(j);
          DragSortListView.this.setSelectionFromTop(k, i - DragSortListView.this.getPaddingTop());
          DragSortListView.this.layoutChildren();
          this.mPrevTime = (((float)this.mPrevTime + this.dt));
          DragSortListView.this.post(this);
          return;
          label506:
          this.mScrolling = false;
        }
        else
        {
          this.mPrevTime = (((float)this.mPrevTime + this.dt));
          DragSortListView.this.post(this);
        }
      }
      else
      {
        this.mScrolling = false;
      }
    }
    
    public void startScrolling(int paramInt)
    {
      if (!this.mScrolling)
      {
        if (DragSortListView.this.mTrackDragScroll)
        {
          this.mStateTracker.startTracking();
          Log.d("mobeta", "scroll tracking started");
        }
        this.mAbort = false;
        this.mScrolling = true;
        this.tStart = SystemClock.uptimeMillis();
        this.mPrevTime = this.tStart;
        this.mLastHeader = (-1 + DragSortListView.this.getHeaderViewsCount());
        this.mFirstFooter = (DragSortListView.this.getCount() - DragSortListView.this.getFooterViewsCount());
        this.scrollDir = paramInt;
        DragSortListView.this.post(this);
      }
    }
    
    public void stopScrolling(boolean paramBoolean)
    {
      if (!paramBoolean)
      {
        this.mAbort = true;
      }
      else
      {
        DragSortListView.this.removeCallbacks(this);
        this.mScrolling = false;
      }
      if (DragSortListView.this.mTrackDragScroll) {
        this.mStateTracker.stopTracking();
      }
    }
  }
  
  public static abstract interface DragScrollProfile
  {
    public abstract float getSpeed(float paramFloat, long paramLong);
  }
  
  public static abstract interface RemoveListener
  {
    public abstract void remove(int paramInt);
  }
  
  public static abstract interface DropListener
  {
    public abstract void drop(int paramInt1, int paramInt2);
  }
  
  public static abstract interface DragListener
  {
    public abstract void drag(int paramInt1, int paramInt2);
  }
  
  private class AdapterWrapper
    extends HeaderViewListAdapter
  {
    private ListAdapter mAdapter;
    
    public AdapterWrapper(ArrayList<ListView.FixedViewInfo> paramArrayList, ListAdapter paramListAdapter)
    {
      super(paramListAdapter, localListAdapter);
      this.mAdapter = localListAdapter;
    }
    
    public ListAdapter getAdapter()
    {
      return this.mAdapter;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject2;
      Object localObject1;
      View localView;
      if (paramView == null)
      {
        localObject2 = new AbsListView.LayoutParams(-1, -2);
        localObject1 = DragSortListView.this.getContext();
        localObject1 = new RelativeLayout((Context)localObject1);
        ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localView = this.mAdapter.getView(paramInt, null, (ViewGroup)localObject1);
        ((RelativeLayout)localObject1).addView(localView);
        localObject2 = localView.findViewById(R.id.drag);
        ((RelativeLayout)localObject1).setTag(localObject2);
      }
      else
      {
        localObject1 = (RelativeLayout)paramView;
        localObject2 = ((RelativeLayout)localObject1).getChildAt(0);
        localView = this.mAdapter.getView(paramInt, (View)localObject2, (ViewGroup)localObject1);
        if (localView != localObject2)
        {
          ((RelativeLayout)localObject1).removeViewAt(0);
          ((RelativeLayout)localObject1).addView(localView);
          localObject2 = localView.findViewById(R.id.drag);
          ((RelativeLayout)localObject1).setTag(localObject2);
        }
      }
      ViewGroup.LayoutParams localLayoutParams2 = ((RelativeLayout)localObject1).getLayoutParams();
      int k = DragSortListView.this.getHeaderViewsCount();
      int i = DragSortListView.this.mSrcDragPos - k;
      int m = DragSortListView.this.mExpDragPos - k;
      if ((paramInt == i) || (paramInt == m)) {
        k = 0;
      } else {
        k = 1;
      }
      int n;
      if ((DragSortListView.this.mDragState != 2) && (DragSortListView.this.mDragState != 3)) {
        n = 0;
      } else {
        n = 1;
      }
      int i1;
      if ((k == 0) && (n != 0)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      k = localLayoutParams2.height;
      if ((i1 == 0) || (localLayoutParams2.height == -2))
      {
        if (n != 0) {
          if ((paramInt != i) || (localLayoutParams2.height == DragSortListView.this.mItemHeightCollapsed))
          {
            if (paramInt == m)
            {
              m = View.MeasureSpec.makeMeasureSpec(0, 0);
              localView.measure(m, m);
              DragSortListView.access$502(DragSortListView.this, localView.getMeasuredHeight());
              localLayoutParams1 = DragSortListView.this.mExpandedChildHeight + DragSortListView.this.mFloatViewHeight + DragSortListView.this.getDividerHeight();
              if (localLayoutParams2.height != localLayoutParams1) {
                localLayoutParams2.height = localLayoutParams1;
              }
              if (DragSortListView.this.mDragState != 2) {
                ((RelativeLayout)localObject1).setGravity(80);
              } else {
                ((RelativeLayout)localObject1).setGravity(48);
              }
            }
          }
          else {
            localLayoutParams2.height = DragSortListView.this.mItemHeightCollapsed;
          }
        }
      }
      else {
        localLayoutParams2.height = -2;
      }
      if (localLayoutParams2.height != k) {
        ((RelativeLayout)localObject1).setLayoutParams(localLayoutParams2);
      }
      ViewGroup.LayoutParams localLayoutParams1 = ((RelativeLayout)localObject1).getVisibility();
      localLayoutParams2 = localLayoutParams1;
      int j;
      if ((paramInt != i) || (DragSortListView.this.mDragState == 0))
      {
        if (localLayoutParams2 == 4) {
          j = 0;
        }
      }
      else if (j == 0) {
        j = 4;
      }
      if (j != localLayoutParams1) {
        ((RelativeLayout)localObject1).setVisibility(j);
      }
      return localObject1;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.mobeta.android.dslv.DragSortListView
 * JD-Core Version:    0.7.0.1
 */