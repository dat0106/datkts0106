package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.actionbarsherlock.R.attr;

public class IcsListPopupWindow
{
  private static final int EXPAND_LIST_TIMEOUT = 250;
  public static final int POSITION_PROMPT_ABOVE = 0;
  public static final int POSITION_PROMPT_BELOW = 1;
  private ListAdapter mAdapter;
  private Context mContext;
  private View mDropDownAnchorView;
  private int mDropDownHeight = -2;
  private int mDropDownHorizontalOffset;
  private DropDownListView mDropDownList;
  private Drawable mDropDownListHighlight;
  private int mDropDownVerticalOffset;
  private boolean mDropDownVerticalOffsetSet;
  private int mDropDownWidth = -2;
  private Handler mHandler = new Handler();
  private final ListSelectorHider mHideSelector = new ListSelectorHider(null);
  private AdapterView.OnItemClickListener mItemClickListener;
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  private int mListItemExpandMaximum = 2147483647;
  private boolean mModal;
  private DataSetObserver mObserver;
  private PopupWindow mPopup;
  private int mPromptPosition = 0;
  private View mPromptView;
  private final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable(null);
  private final PopupScrollListener mScrollListener = new PopupScrollListener(null);
  private Rect mTempRect = new Rect();
  private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor(null);
  
  public IcsListPopupWindow(Context paramContext)
  {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  public IcsListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.mContext = paramContext;
    this.mPopup = new PopupWindow(paramContext, paramAttributeSet, paramInt);
    this.mPopup.setInputMethodMode(1);
  }
  
  public IcsListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    if (Build.VERSION.SDK_INT >= 11) {
      this.mPopup = new PopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    } else {
      this.mPopup = new PopupWindow(new ContextThemeWrapper(paramContext, paramInt2), paramAttributeSet, paramInt1);
    }
    this.mPopup.setInputMethodMode(1);
  }
  
  private int buildDropDown()
  {
    int i = 0;
    int k;
    if (this.mDropDownList != null)
    {
      ((ViewGroup)this.mPopup.getContentView());
      View localView1 = this.mPromptView;
      if (localView1 != null)
      {
        LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localView1.getLayoutParams();
        int j = localView1.getMeasuredHeight() + localLayoutParams1.topMargin + localLayoutParams1.bottomMargin;
      }
    }
    else
    {
      localObject1 = this.mContext;
      boolean bool1;
      if (this.mModal) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      this.mDropDownList = new DropDownListView((Context)localObject1, bool1);
      if (this.mDropDownListHighlight != null) {
        this.mDropDownList.setSelector(this.mDropDownListHighlight);
      }
      this.mDropDownList.setAdapter(this.mAdapter);
      this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
      this.mDropDownList.setFocusable(true);
      this.mDropDownList.setFocusableInTouchMode(true);
      this.mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          if (paramAnonymousInt != -1)
          {
            IcsListPopupWindow.DropDownListView localDropDownListView = IcsListPopupWindow.this.mDropDownList;
            if (localDropDownListView != null) {
              IcsListPopupWindow.DropDownListView.access$502(localDropDownListView, false);
            }
          }
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      this.mDropDownList.setOnScrollListener(this.mScrollListener);
      if (this.mItemSelectedListener != null) {
        this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
      }
      Object localObject2 = this.mDropDownList;
      View localView2 = this.mPromptView;
      if (localView2 != null)
      {
        localObject1 = new LinearLayout((Context)localObject1);
        ((LinearLayout)localObject1).setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.mPromptPosition)
        {
        case 0: 
          ((LinearLayout)localObject1).addView(localView2);
          ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams2);
          break;
        case 1: 
          ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams2);
          ((LinearLayout)localObject1).addView(localView2);
        }
        localView2.measure(View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, -2147483648), 0);
        localLayoutParams2 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        k = localView2.getMeasuredHeight() + localLayoutParams2.topMargin + localLayoutParams2.bottomMargin;
        localObject2 = localObject1;
      }
      this.mPopup.setContentView((View)localObject2);
    }
    int m = 0;
    Object localObject1 = this.mPopup.getBackground();
    if (localObject1 != null)
    {
      ((Drawable)localObject1).getPadding(this.mTempRect);
      m = this.mTempRect.top + this.mTempRect.bottom;
      if (!this.mDropDownVerticalOffsetSet) {
        this.mDropDownVerticalOffset = (-this.mTempRect.top);
      }
    }
    boolean bool2;
    if (this.mPopup.getInputMethodMode() != 2) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    int n = getMaxAvailableHeight(this.mDropDownAnchorView, this.mDropDownVerticalOffset, bool2);
    if (this.mDropDownHeight != -1)
    {
      n = measureHeightOfChildren(0, 0, -1, n - k, -1);
      if (n > 0) {
        k += m;
      }
      k = n + k;
    }
    else
    {
      k = n + m;
    }
    return k;
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = localRect.bottom;
    if (paramBoolean) {
      i = paramView.getContext().getResources().getDisplayMetrics().heightPixels;
    }
    i = Math.max(i - (arrayOfInt[1] + paramView.getHeight()) - paramInt, paramInt + (arrayOfInt[1] - localRect.top));
    if (this.mPopup.getBackground() != null)
    {
      this.mPopup.getBackground().getPadding(this.mTempRect);
      i -= this.mTempRect.top + this.mTempRect.bottom;
    }
    return i;
  }
  
  private boolean isInputMethodNotNeeded()
  {
    boolean bool;
    if (this.mPopup.getInputMethodMode() != 2) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private int measureHeightOfChildren(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ListAdapter localListAdapter = this.mAdapter;
    int k;
    if (localListAdapter != null)
    {
      int j = this.mDropDownList.getListPaddingTop() + this.mDropDownList.getListPaddingBottom();
      int i;
      if ((this.mDropDownList.getDividerHeight() <= 0) || (this.mDropDownList.getDivider() == null)) {
        i = 0;
      } else {
        i = this.mDropDownList.getDividerHeight();
      }
      k = 0;
      if (paramInt3 == -1) {
        paramInt3 = -1 + localListAdapter.getCount();
      }
      for (int m = paramInt2;; m++)
      {
        if (m > paramInt3)
        {
          k = j;
          break label247;
        }
        View localView = this.mAdapter.getView(m, null, this.mDropDownList);
        if (this.mDropDownList.getCacheColorHint() != 0) {
          localView.setDrawingCacheBackgroundColor(this.mDropDownList.getCacheColorHint());
        }
        measureScrapChild(localView, m, paramInt1);
        if (m > 0) {
          j += i;
        }
        j += localView.getMeasuredHeight();
        if (j >= paramInt4) {
          break;
        }
        if ((paramInt5 >= 0) && (m >= paramInt5)) {
          k = j;
        }
      }
      if ((paramInt5 < 0) || (m <= paramInt5) || (k <= 0) || (j == paramInt4)) {
        k = paramInt4;
      }
    }
    else
    {
      k = this.mDropDownList.getListPaddingTop() + this.mDropDownList.getListPaddingBottom();
    }
    label247:
    return k;
  }
  
  private void measureScrapChild(View paramView, int paramInt1, int paramInt2)
  {
    AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      localLayoutParams = new AbsListView.LayoutParams(-1, -2, 0);
      paramView.setLayoutParams(localLayoutParams);
    }
    int i = ViewGroup.getChildMeasureSpec(paramInt2, this.mDropDownList.getPaddingLeft() + this.mDropDownList.getPaddingRight(), localLayoutParams.width);
    int j = localLayoutParams.height;
    if (j <= 0) {
      j = View.MeasureSpec.makeMeasureSpec(0, 0);
    } else {
      j = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
    }
    paramView.measure(i, j);
  }
  
  public void clearListSelection()
  {
    DropDownListView localDropDownListView = this.mDropDownList;
    if (localDropDownListView != null)
    {
      DropDownListView.access$502(localDropDownListView, true);
      localDropDownListView.requestLayout();
    }
  }
  
  public void dismiss()
  {
    this.mPopup.dismiss();
    if (this.mPromptView != null)
    {
      ViewParent localViewParent = this.mPromptView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.mPromptView);
      }
    }
    this.mPopup.setContentView(null);
    this.mDropDownList = null;
    this.mHandler.removeCallbacks(this.mResizePopupRunnable);
  }
  
  public ListView getListView()
  {
    return this.mDropDownList;
  }
  
  public boolean isShowing()
  {
    return this.mPopup.isShowing();
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.mObserver != null)
    {
      if (this.mAdapter != null) {
        this.mAdapter.unregisterDataSetObserver(this.mObserver);
      }
    }
    else {
      this.mObserver = new PopupDataSetObserver(null);
    }
    this.mAdapter = paramListAdapter;
    if (this.mAdapter != null) {
      paramListAdapter.registerDataSetObserver(this.mObserver);
    }
    if (this.mDropDownList != null) {
      this.mDropDownList.setAdapter(this.mAdapter);
    }
  }
  
  public void setAnchorView(View paramView)
  {
    this.mDropDownAnchorView = paramView;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mPopup.setBackgroundDrawable(paramDrawable);
  }
  
  public void setContentWidth(int paramInt)
  {
    Drawable localDrawable = this.mPopup.getBackground();
    if (localDrawable == null)
    {
      this.mDropDownWidth = paramInt;
    }
    else
    {
      localDrawable.getPadding(this.mTempRect);
      this.mDropDownWidth = (paramInt + (this.mTempRect.left + this.mTempRect.right));
    }
  }
  
  public void setHorizontalOffset(int paramInt)
  {
    this.mDropDownHorizontalOffset = paramInt;
  }
  
  public void setInputMethodMode(int paramInt)
  {
    this.mPopup.setInputMethodMode(paramInt);
  }
  
  public void setModal(boolean paramBoolean)
  {
    this.mModal = true;
    this.mPopup.setFocusable(paramBoolean);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClickListener = paramOnItemClickListener;
  }
  
  public void setPromptPosition(int paramInt)
  {
    this.mPromptPosition = paramInt;
  }
  
  public void setVerticalOffset(int paramInt)
  {
    this.mDropDownVerticalOffset = paramInt;
    this.mDropDownVerticalOffsetSet = true;
  }
  
  public void show()
  {
    int j = 0;
    int i = -1;
    int m = buildDropDown();
    int n = 0;
    int k = 0;
    boolean bool = isInputMethodNotNeeded();
    if (!this.mPopup.isShowing())
    {
      if (this.mDropDownWidth != i)
      {
        if (this.mDropDownWidth != -2) {
          this.mPopup.setWidth(this.mDropDownWidth);
        } else {
          this.mPopup.setWidth(this.mDropDownAnchorView.getWidth());
        }
      }
      else {
        n = -1;
      }
      if (this.mDropDownHeight != i)
      {
        if (this.mDropDownHeight != -2) {
          this.mPopup.setHeight(this.mDropDownHeight);
        } else {
          this.mPopup.setHeight(m);
        }
      }
      else {
        k = -1;
      }
      this.mPopup.setWindowLayoutMode(n, k);
      this.mPopup.setOutsideTouchable(true);
      this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
      this.mPopup.showAsDropDown(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset);
      this.mDropDownList.setSelection(i);
      if ((!this.mModal) || (this.mDropDownList.isInTouchMode())) {
        clearListSelection();
      }
      if (!this.mModal) {
        this.mHandler.post(this.mHideSelector);
      }
    }
    else
    {
      if (this.mDropDownWidth != i)
      {
        if (this.mDropDownWidth != -2) {
          k = this.mDropDownWidth;
        } else {
          k = this.mDropDownAnchorView.getWidth();
        }
      }
      else {
        k = -1;
      }
      if (this.mDropDownHeight != i)
      {
        if (this.mDropDownHeight != -2) {
          m = this.mDropDownHeight;
        } else {
          m = m;
        }
      }
      else
      {
        if (!bool) {
          m = i;
        } else {
          m = m;
        }
        if (!bool)
        {
          PopupWindow localPopupWindow2 = this.mPopup;
          if (this.mDropDownWidth == i) {
            j = i;
          }
          localPopupWindow2.setWindowLayoutMode(j, i);
        }
        else
        {
          PopupWindow localPopupWindow1 = this.mPopup;
          if (this.mDropDownWidth != i) {
            i = 0;
          }
          localPopupWindow1.setWindowLayoutMode(i, 0);
        }
      }
      this.mPopup.setOutsideTouchable(true);
      this.mPopup.update(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, k, m);
    }
  }
  
  private class PopupScrollListener
    implements AbsListView.OnScrollListener
  {
    private PopupScrollListener() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!IcsListPopupWindow.this.isInputMethodNotNeeded()) && (IcsListPopupWindow.this.mPopup.getContentView() != null))
      {
        IcsListPopupWindow.this.mHandler.removeCallbacks(IcsListPopupWindow.this.mResizePopupRunnable);
        IcsListPopupWindow.this.mResizePopupRunnable.run();
      }
    }
  }
  
  private class PopupTouchInterceptor
    implements View.OnTouchListener
  {
    private PopupTouchInterceptor() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int k = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int i = (int)paramMotionEvent.getY();
      if ((k != 0) || (IcsListPopupWindow.this.mPopup == null) || (!IcsListPopupWindow.this.mPopup.isShowing()) || (j < 0) || (j >= IcsListPopupWindow.this.mPopup.getWidth()) || (i < 0) || (i >= IcsListPopupWindow.this.mPopup.getHeight()))
      {
        if (k == 1) {
          IcsListPopupWindow.this.mHandler.removeCallbacks(IcsListPopupWindow.this.mResizePopupRunnable);
        }
      }
      else {
        IcsListPopupWindow.this.mHandler.postDelayed(IcsListPopupWindow.this.mResizePopupRunnable, 250L);
      }
      return false;
    }
  }
  
  private class ResizePopupRunnable
    implements Runnable
  {
    private ResizePopupRunnable() {}
    
    public void run()
    {
      if ((IcsListPopupWindow.this.mDropDownList != null) && (IcsListPopupWindow.this.mDropDownList.getCount() > IcsListPopupWindow.this.mDropDownList.getChildCount()) && (IcsListPopupWindow.this.mDropDownList.getChildCount() <= IcsListPopupWindow.this.mListItemExpandMaximum))
      {
        IcsListPopupWindow.this.mPopup.setInputMethodMode(2);
        IcsListPopupWindow.this.show();
      }
    }
  }
  
  private class ListSelectorHider
    implements Runnable
  {
    private ListSelectorHider() {}
    
    public void run()
    {
      IcsListPopupWindow.this.clearListSelection();
    }
  }
  
  private class PopupDataSetObserver
    extends DataSetObserver
  {
    private PopupDataSetObserver() {}
    
    public void onChanged()
    {
      if (IcsListPopupWindow.this.isShowing()) {
        IcsListPopupWindow.this.show();
      }
    }
    
    public void onInvalidated()
    {
      IcsListPopupWindow.this.dismiss();
    }
  }
  
  private static class DropDownListView
    extends ListView
  {
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    
    public DropDownListView(Context paramContext, boolean paramBoolean)
    {
      super(null, R.attr.dropDownListViewStyle);
      this.mHijackFocus = paramBoolean;
      setCacheColorHint(0);
    }
    
    public boolean hasFocus()
    {
      boolean bool;
      if ((!this.mHijackFocus) && (!super.hasFocus())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean hasWindowFocus()
    {
      boolean bool;
      if ((!this.mHijackFocus) && (!super.hasWindowFocus())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean isFocused()
    {
      boolean bool;
      if ((!this.mHijackFocus) && (!super.isFocused())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean isInTouchMode()
    {
      boolean bool;
      if (((!this.mHijackFocus) || (!this.mListSelectionHidden)) && (!super.isInTouchMode())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.IcsListPopupWindow
 * JD-Core Version:    0.7.0.1
 */