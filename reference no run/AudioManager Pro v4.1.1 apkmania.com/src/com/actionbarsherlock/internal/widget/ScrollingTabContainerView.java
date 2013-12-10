package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.actionbarsherlock.R.attr;
import com.actionbarsherlock.R.layout;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator.AnimatorListener;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineHorizontalScrollView;

public class ScrollingTabContainerView
  extends NineHorizontalScrollView
  implements IcsAdapterView.OnItemSelectedListener
{
  private static final int FADE_DURATION = 200;
  private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
  private boolean mAllowCollapse;
  private int mContentHeight;
  private LayoutInflater mInflater;
  int mMaxTabWidth;
  private int mSelectedTabIndex;
  private TabClickListener mTabClickListener;
  private IcsLinearLayout mTabLayout;
  Runnable mTabSelector;
  private IcsSpinner mTabSpinner;
  protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
  protected Animator mVisibilityAnim;
  
  public ScrollingTabContainerView(Context paramContext)
  {
    super(paramContext);
    setHorizontalScrollBarEnabled(false);
    TypedArray localTypedArray = getContext().obtainStyledAttributes(null, R.styleable.SherlockActionBar, R.attr.actionBarStyle, 0);
    setContentHeight(localTypedArray.getLayoutDimension(4, 0));
    localTypedArray.recycle();
    this.mInflater = LayoutInflater.from(paramContext);
    this.mTabLayout = createTabLayout();
    addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
  }
  
  private IcsSpinner createSpinner()
  {
    IcsSpinner localIcsSpinner = new IcsSpinner(getContext(), null, R.attr.actionDropDownStyle);
    localIcsSpinner.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    localIcsSpinner.setOnItemSelectedListener(this);
    return localIcsSpinner;
  }
  
  private IcsLinearLayout createTabLayout()
  {
    IcsLinearLayout localIcsLinearLayout = (IcsLinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.abs__action_bar_tab_bar_view, null);
    localIcsLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    return localIcsLinearLayout;
  }
  
  private TabView createTabView(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    TabView localTabView = (TabView)this.mInflater.inflate(R.layout.abs__action_bar_tab, null);
    localTabView.init(this, paramTab, paramBoolean);
    if (!paramBoolean)
    {
      localTabView.setFocusable(true);
      if (this.mTabClickListener == null) {
        this.mTabClickListener = new TabClickListener(null);
      }
      localTabView.setOnClickListener(this.mTabClickListener);
    }
    else
    {
      localTabView.setBackgroundDrawable(null);
      localTabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
    }
    return localTabView;
  }
  
  private boolean isCollapsed()
  {
    boolean bool;
    if ((this.mTabSpinner == null) || (this.mTabSpinner.getParent() != this)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void performCollapse()
  {
    if (!isCollapsed())
    {
      if (this.mTabSpinner == null) {
        this.mTabSpinner = createSpinner();
      }
      removeView(this.mTabLayout);
      addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
      if (this.mTabSpinner.getAdapter() == null) {
        this.mTabSpinner.setAdapter(new TabAdapter(null));
      }
      if (this.mTabSelector != null)
      {
        removeCallbacks(this.mTabSelector);
        this.mTabSelector = null;
      }
      this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }
  }
  
  private boolean performExpand()
  {
    if (isCollapsed())
    {
      removeView(this.mTabSpinner);
      addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
      setTabSelected(this.mTabSpinner.getSelectedItemPosition());
    }
    return false;
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    TabView localTabView = createTabView(paramTab, false);
    this.mTabLayout.addView(localTabView, paramInt, new LinearLayout.LayoutParams(0, -1, 1.0F));
    if (this.mTabSpinner != null) {
      ((TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (paramBoolean) {
      localTabView.setSelected(true);
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    TabView localTabView = createTabView(paramTab, false);
    this.mTabLayout.addView(localTabView, new LinearLayout.LayoutParams(0, -1, 1.0F));
    if (this.mTabSpinner != null) {
      ((TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (paramBoolean) {
      localTabView.setSelected(true);
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void animateToTab(int paramInt)
  {
    final View localView = this.mTabLayout.getChildAt(paramInt);
    if (this.mTabSelector != null) {
      removeCallbacks(this.mTabSelector);
    }
    this.mTabSelector = new Runnable()
    {
      public void run()
      {
        int i = localView.getLeft() - (ScrollingTabContainerView.this.getWidth() - localView.getWidth()) / 2;
        ScrollingTabContainerView.this.smoothScrollTo(i, 0);
        ScrollingTabContainerView.this.mTabSelector = null;
      }
    };
    post(this.mTabSelector);
  }
  
  public void animateToVisibility(int paramInt)
  {
    if (this.mVisibilityAnim != null) {
      this.mVisibilityAnim.cancel();
    }
    Object localObject;
    if (paramInt != 0)
    {
      localObject = new float[1];
      localObject[0] = 0.0F;
      localObject = ObjectAnimator.ofFloat(this, "alpha", (float[])localObject);
      ((ObjectAnimator)localObject).setDuration(200L);
      ((ObjectAnimator)localObject).setInterpolator(sAlphaInterpolator);
      ((ObjectAnimator)localObject).addListener(this.mVisAnimListener.withFinalVisibility(paramInt));
      ((ObjectAnimator)localObject).start();
    }
    else
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      localObject = new float[1];
      localObject[0] = 1.0F;
      localObject = ObjectAnimator.ofFloat(this, "alpha", (float[])localObject);
      ((ObjectAnimator)localObject).setDuration(200L);
      ((ObjectAnimator)localObject).setInterpolator(sAlphaInterpolator);
      ((ObjectAnimator)localObject).addListener(this.mVisAnimListener.withFinalVisibility(paramInt));
      ((ObjectAnimator)localObject).start();
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mTabSelector != null) {
      post(this.mTabSelector);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    TypedArray localTypedArray = getContext().obtainStyledAttributes(null, R.styleable.SherlockActionBar, R.attr.actionBarStyle, 0);
    setContentHeight(localTypedArray.getLayoutDimension(4, 0));
    localTypedArray.recycle();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mTabSelector != null) {
      removeCallbacks(this.mTabSelector);
    }
  }
  
  public void onItemSelected(IcsAdapterView<?> paramIcsAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((TabView)paramView).getTab().select();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    if (j != 1073741824) {
      bool = false;
    } else {
      bool = true;
    }
    setFillViewport(bool);
    int i = this.mTabLayout.getChildCount();
    if ((i <= 1) || ((j != 1073741824) && (j != -2147483648))) {
      this.mMaxTabWidth = -1;
    } else if (i <= 2) {
      this.mMaxTabWidth = (View.MeasureSpec.getSize(paramInt1) / 2);
    } else {
      this.mMaxTabWidth = ((int)(0.4F * View.MeasureSpec.getSize(paramInt1)));
    }
    j = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
    if ((bool) || (!this.mAllowCollapse)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      performExpand();
    }
    else
    {
      this.mTabLayout.measure(0, j);
      if (this.mTabLayout.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        performExpand();
      } else {
        performCollapse();
      }
    }
    i = getMeasuredWidth();
    super.onMeasure(paramInt1, j);
    j = getMeasuredWidth();
    if ((bool) && (i != j)) {
      setTabSelected(this.mSelectedTabIndex);
    }
  }
  
  public void onNothingSelected(IcsAdapterView<?> paramIcsAdapterView) {}
  
  public void removeAllTabs()
  {
    this.mTabLayout.removeAllViews();
    if (this.mTabSpinner != null) {
      ((TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void removeTabAt(int paramInt)
  {
    this.mTabLayout.removeViewAt(paramInt);
    if (this.mTabSpinner != null) {
      ((TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    this.mAllowCollapse = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt)
  {
    this.mSelectedTabIndex = paramInt;
    int j = this.mTabLayout.getChildCount();
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      View localView = this.mTabLayout.getChildAt(i);
      boolean bool;
      if (i != paramInt) {
        bool = false;
      } else {
        bool = true;
      }
      localView.setSelected(bool);
      if (bool) {
        animateToTab(paramInt);
      }
    }
  }
  
  public void updateTab(int paramInt)
  {
    ((TabView)this.mTabLayout.getChildAt(paramInt)).update();
    if (this.mTabSpinner != null) {
      ((TabAdapter)this.mTabSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  protected class VisibilityAnimListener
    implements Animator.AnimatorListener
  {
    private boolean mCanceled = false;
    private int mFinalVisibility;
    
    protected VisibilityAnimListener() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.mCanceled = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.mCanceled)
      {
        ScrollingTabContainerView.this.mVisibilityAnim = null;
        ScrollingTabContainerView.this.setVisibility(this.mFinalVisibility);
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      ScrollingTabContainerView.this.setVisibility(0);
      ScrollingTabContainerView.this.mVisibilityAnim = paramAnimator;
      this.mCanceled = false;
    }
    
    public VisibilityAnimListener withFinalVisibility(int paramInt)
    {
      this.mFinalVisibility = paramInt;
      return this;
    }
  }
  
  private class TabClickListener
    implements View.OnClickListener
  {
    private TabClickListener() {}
    
    public void onClick(View paramView)
    {
      ((ScrollingTabContainerView.TabView)paramView).getTab().select();
      int j = ScrollingTabContainerView.this.mTabLayout.getChildCount();
      for (int i = 0;; i++)
      {
        if (i >= j) {
          return;
        }
        View localView = ScrollingTabContainerView.this.mTabLayout.getChildAt(i);
        boolean bool;
        if (localView != paramView) {
          bool = false;
        } else {
          bool = true;
        }
        localView.setSelected(bool);
      }
    }
  }
  
  private class TabAdapter
    extends BaseAdapter
  {
    private TabAdapter() {}
    
    public int getCount()
    {
      return ScrollingTabContainerView.this.mTabLayout.getChildCount();
    }
    
    public Object getItem(int paramInt)
    {
      return ((ScrollingTabContainerView.TabView)ScrollingTabContainerView.this.mTabLayout.getChildAt(paramInt)).getTab();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView != null) {
        ((ScrollingTabContainerView.TabView)paramView).bindTab((ActionBar.Tab)getItem(paramInt));
      } else {
        paramView = ScrollingTabContainerView.this.createTabView((ActionBar.Tab)getItem(paramInt), true);
      }
      return paramView;
    }
  }
  
  public static class TabView
    extends LinearLayout
  {
    private View mCustomView;
    private ImageView mIconView;
    private ScrollingTabContainerView mParent;
    private ActionBar.Tab mTab;
    private CapitalizingTextView mTextView;
    
    public TabView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public void bindTab(ActionBar.Tab paramTab)
    {
      this.mTab = paramTab;
      update();
    }
    
    public ActionBar.Tab getTab()
    {
      return this.mTab;
    }
    
    public void init(ScrollingTabContainerView paramScrollingTabContainerView, ActionBar.Tab paramTab, boolean paramBoolean)
    {
      this.mParent = paramScrollingTabContainerView;
      this.mTab = paramTab;
      if (paramBoolean) {
        setGravity(19);
      }
      update();
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if ((this.mParent.mMaxTabWidth > 0) && (getMeasuredWidth() > this.mParent.mMaxTabWidth)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mParent.mMaxTabWidth, 1073741824), paramInt2);
      }
    }
    
    public void update()
    {
      Object localObject1 = this.mTab;
      Object localObject2 = ((ActionBar.Tab)localObject1).getCustomView();
      if (localObject2 == null)
      {
        if (this.mCustomView != null)
        {
          removeView(this.mCustomView);
          this.mCustomView = null;
        }
        Drawable localDrawable = ((ActionBar.Tab)localObject1).getIcon();
        localObject2 = ((ActionBar.Tab)localObject1).getText();
        Object localObject3;
        LinearLayout.LayoutParams localLayoutParams;
        if (localDrawable == null)
        {
          if (this.mIconView != null)
          {
            this.mIconView.setVisibility(8);
            this.mIconView.setImageDrawable(null);
          }
        }
        else
        {
          if (this.mIconView == null)
          {
            localObject3 = new ImageView(getContext());
            localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            localLayoutParams.gravity = 16;
            ((ImageView)localObject3).setLayoutParams(localLayoutParams);
            addView((View)localObject3, 0);
            this.mIconView = ((ImageView)localObject3);
          }
          this.mIconView.setImageDrawable(localDrawable);
          this.mIconView.setVisibility(0);
        }
        if (localObject2 == null)
        {
          if (this.mTextView != null)
          {
            this.mTextView.setVisibility(8);
            this.mTextView.setText(null);
          }
        }
        else
        {
          if (this.mTextView == null)
          {
            localObject3 = new CapitalizingTextView(getContext(), null, R.attr.actionBarTabTextStyle);
            ((CapitalizingTextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
            localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
            localLayoutParams.gravity = 16;
            ((CapitalizingTextView)localObject3).setLayoutParams(localLayoutParams);
            addView((View)localObject3);
            this.mTextView = ((CapitalizingTextView)localObject3);
          }
          this.mTextView.setTextCompat((CharSequence)localObject2);
          this.mTextView.setVisibility(0);
        }
        if (this.mIconView != null) {
          this.mIconView.setContentDescription(((ActionBar.Tab)localObject1).getContentDescription());
        }
      }
      else
      {
        localObject1 = ((View)localObject2).getParent();
        if (localObject1 != this)
        {
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localObject2);
          }
          addView((View)localObject2);
        }
        this.mCustomView = ((View)localObject2);
        if (this.mTextView != null) {
          this.mTextView.setVisibility(8);
        }
        if (this.mIconView != null)
        {
          this.mIconView.setVisibility(8);
          this.mIconView.setImageDrawable(null);
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.ScrollingTabContainerView
 * JD-Core Version:    0.7.0.1
 */