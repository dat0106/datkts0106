package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.R.attr;
import com.actionbarsherlock.R.id;
import com.actionbarsherlock.R.layout;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator.AnimatorListener;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet.Builder;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import com.actionbarsherlock.internal.nineoldandroids.view.animation.AnimatorProxy;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineLinearLayout;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.ActionMenuView;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.view.ActionMode;

public class ActionBarContextView
  extends AbsActionBarView
  implements Animator.AnimatorListener
{
  private static final int ANIMATE_IDLE = 0;
  private static final int ANIMATE_IN = 1;
  private static final int ANIMATE_OUT = 2;
  private boolean mAnimateInOnLayout;
  private int mAnimationMode;
  private NineLinearLayout mClose;
  private Animator mCurrentAnimation;
  private View mCustomView;
  private Drawable mSplitBackground;
  private CharSequence mSubtitle;
  private int mSubtitleStyleRes;
  private TextView mSubtitleView;
  private CharSequence mTitle;
  private LinearLayout mTitleLayout;
  private int mTitleStyleRes;
  private TextView mTitleView;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockActionMode, paramInt, 0);
    setBackgroundDrawable(localTypedArray.getDrawable(2));
    this.mTitleStyleRes = localTypedArray.getResourceId(0, 0);
    this.mSubtitleStyleRes = localTypedArray.getResourceId(1, 0);
    this.mContentHeight = localTypedArray.getLayoutDimension(4, 0);
    this.mSplitBackground = localTypedArray.getDrawable(3);
    localTypedArray.recycle();
  }
  
  private void finishAnimation()
  {
    Animator localAnimator = this.mCurrentAnimation;
    if (localAnimator != null)
    {
      this.mCurrentAnimation = null;
      localAnimator.end();
    }
  }
  
  private void initTitle()
  {
    int i = 8;
    if (this.mTitleLayout == null)
    {
      LayoutInflater.from(getContext()).inflate(R.layout.abs__action_bar_title_item, this);
      this.mTitleLayout = ((LinearLayout)getChildAt(-1 + getChildCount()));
      this.mTitleView = ((TextView)this.mTitleLayout.findViewById(R.id.abs__action_bar_title));
      this.mSubtitleView = ((TextView)this.mTitleLayout.findViewById(R.id.abs__action_bar_subtitle));
      if (this.mTitleStyleRes != 0) {
        this.mTitleView.setTextAppearance(this.mContext, this.mTitleStyleRes);
      }
      if (this.mSubtitleStyleRes != 0) {
        this.mSubtitleView.setTextAppearance(this.mContext, this.mSubtitleStyleRes);
      }
    }
    this.mTitleView.setText(this.mTitle);
    this.mSubtitleView.setText(this.mSubtitle);
    int k;
    if (TextUtils.isEmpty(this.mTitle)) {
      k = 0;
    } else {
      k = 1;
    }
    int j;
    if (TextUtils.isEmpty(this.mSubtitle)) {
      j = 0;
    } else {
      j = 1;
    }
    TextView localTextView = this.mSubtitleView;
    int m;
    if (j == 0) {
      m = i;
    } else {
      m = 0;
    }
    localTextView.setVisibility(m);
    LinearLayout localLinearLayout = this.mTitleLayout;
    if ((k != 0) || (j != 0)) {
      i = 0;
    }
    localLinearLayout.setVisibility(i);
    if (this.mTitleLayout.getParent() == null) {
      addView(this.mTitleLayout);
    }
  }
  
  private Animator makeInAnimation()
  {
    this.mClose.setTranslationX(-this.mClose.getWidth() - ((ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams()).leftMargin);
    Object localObject1 = this.mClose;
    Object localObject2 = new float[1];
    localObject2[0] = 0.0F;
    localObject2 = ObjectAnimator.ofFloat(localObject1, "translationX", (float[])localObject2);
    ((ObjectAnimator)localObject2).setDuration(200L);
    ((ObjectAnimator)localObject2).addListener(this);
    ((ObjectAnimator)localObject2).setInterpolator(new DecelerateInterpolator());
    localObject1 = new AnimatorSet();
    localObject2 = ((AnimatorSet)localObject1).play((Animator)localObject2);
    int j;
    if (this.mMenuView != null)
    {
      i = this.mMenuView.getChildCount();
      if (i > 0) {
        j = i - 1;
      }
    }
    for (int i = 0;; i++)
    {
      if (j < 0) {
        return localObject1;
      }
      Object localObject3 = AnimatorProxy.wrap(this.mMenuView.getChildAt(j));
      ((AnimatorProxy)localObject3).setScaleY(0.0F);
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 1.0F;
      localObject3 = ObjectAnimator.ofFloat(localObject3, "scaleY", arrayOfFloat);
      ((ObjectAnimator)localObject3).setDuration(100L);
      ((ObjectAnimator)localObject3).setStartDelay(i * 70);
      ((AnimatorSet.Builder)localObject2).with((Animator)localObject3);
      j--;
    }
  }
  
  private Animator makeOutAnimation()
  {
    Object localObject1 = this.mClose;
    Object localObject2 = new float[1];
    localObject2[0] = (-this.mClose.getWidth() - ((ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams()).leftMargin);
    localObject2 = ObjectAnimator.ofFloat(localObject1, "translationX", (float[])localObject2);
    ((ObjectAnimator)localObject2).setDuration(200L);
    ((ObjectAnimator)localObject2).addListener(this);
    ((ObjectAnimator)localObject2).setInterpolator(new DecelerateInterpolator());
    localObject1 = new AnimatorSet();
    localObject2 = ((AnimatorSet)localObject1).play((Animator)localObject2);
    if ((this.mMenuView != null) && (this.mMenuView.getChildCount() > 0)) {}
    for (int i = 0;; i++)
    {
      if (i >= 0) {
        return localObject1;
      }
      Object localObject3 = AnimatorProxy.wrap(this.mMenuView.getChildAt(i));
      ((AnimatorProxy)localObject3).setScaleY(0.0F);
      float[] arrayOfFloat = new float[1];
      arrayOfFloat[0] = 0.0F;
      localObject3 = ObjectAnimator.ofFloat(localObject3, "scaleY", arrayOfFloat);
      ((ObjectAnimator)localObject3).setDuration(100L);
      ((ObjectAnimator)localObject3).setStartDelay(i * 70);
      ((AnimatorSet.Builder)localObject2).with((Animator)localObject3);
    }
  }
  
  public void closeMode()
  {
    if (this.mAnimationMode != 2) {
      if (this.mClose != null)
      {
        finishAnimation();
        this.mAnimationMode = 2;
        this.mCurrentAnimation = makeOutAnimation();
        this.mCurrentAnimation.start();
      }
      else
      {
        killMode();
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return this.mSubtitle;
  }
  
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public boolean hideOverflowMenu()
  {
    boolean bool;
    if (this.mActionMenuPresenter == null) {
      bool = false;
    } else {
      bool = this.mActionMenuPresenter.hideOverflowMenu();
    }
    return bool;
  }
  
  public void initForMode(final ActionMode paramActionMode)
  {
    if (this.mClose != null)
    {
      if (this.mClose.getParent() == null) {
        addView(this.mClose);
      }
    }
    else
    {
      this.mClose = ((NineLinearLayout)LayoutInflater.from(this.mContext).inflate(R.layout.abs__action_mode_close_item, this, false));
      addView(this.mClose);
    }
    this.mClose.findViewById(R.id.abs__action_mode_close_button).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramActionMode.finish();
      }
    });
    MenuBuilder localMenuBuilder = (MenuBuilder)paramActionMode.getMenu();
    if (this.mActionMenuPresenter != null) {
      this.mActionMenuPresenter.dismissPopupMenus();
    }
    this.mActionMenuPresenter = new ActionMenuPresenter(this.mContext);
    this.mActionMenuPresenter.setReserveOverflow(true);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
    if (this.mSplitActionBar)
    {
      this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
      this.mActionMenuPresenter.setItemLimit(2147483647);
      localLayoutParams.width = -1;
      localLayoutParams.height = this.mContentHeight;
      localMenuBuilder.addMenuPresenter(this.mActionMenuPresenter);
      this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
      this.mMenuView.setBackgroundDrawable(this.mSplitBackground);
      this.mSplitView.addView(this.mMenuView, localLayoutParams);
    }
    else
    {
      localMenuBuilder.addMenuPresenter(this.mActionMenuPresenter);
      this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
      this.mMenuView.setBackgroundDrawable(null);
      addView(this.mMenuView, localLayoutParams);
    }
    this.mAnimateInOnLayout = true;
  }
  
  public boolean isOverflowMenuShowing()
  {
    boolean bool;
    if (this.mActionMenuPresenter == null) {
      bool = false;
    } else {
      bool = this.mActionMenuPresenter.isOverflowMenuShowing();
    }
    return bool;
  }
  
  public void killMode()
  {
    finishAnimation();
    removeAllViews();
    if (this.mSplitView != null) {
      this.mSplitView.removeView(this.mMenuView);
    }
    this.mCustomView = null;
    this.mMenuView = null;
    this.mAnimateInOnLayout = false;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.mAnimationMode == 2) {
      killMode();
    }
    this.mAnimationMode = 0;
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mActionMenuPresenter != null)
    {
      this.mActionMenuPresenter.hideOverflowMenu();
      this.mActionMenuPresenter.hideSubMenus();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.mTitle);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m = getPaddingLeft();
    int j = getPaddingTop();
    int i = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    if ((this.mClose != null) && (this.mClose.getVisibility() != 8))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
      m += localMarginLayoutParams.leftMargin;
      m = m + positionChild(this.mClose, m, j, i) + localMarginLayoutParams.rightMargin;
      if (this.mAnimateInOnLayout)
      {
        this.mAnimationMode = 1;
        this.mCurrentAnimation = makeInAnimation();
        this.mCurrentAnimation.start();
        this.mAnimateInOnLayout = false;
      }
    }
    if ((this.mTitleLayout != null) && (this.mCustomView == null)) {
      m += positionChild(this.mTitleLayout, m, j, i);
    }
    if (this.mCustomView != null) {
      (m + positionChild(this.mCustomView, m, j, i));
    }
    int k = paramInt3 - paramInt1 - getPaddingRight();
    if (this.mMenuView != null) {
      (k - positionChildInverse(this.mMenuView, k, j, i));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
    {
      if (View.MeasureSpec.getMode(paramInt2) != 0)
      {
        int i = View.MeasureSpec.getSize(paramInt1);
        int k;
        if (this.mContentHeight <= 0) {
          k = View.MeasureSpec.getSize(paramInt2);
        } else {
          k = this.mContentHeight;
        }
        int j = getPaddingTop() + getPaddingBottom();
        int i1 = i - getPaddingLeft() - getPaddingRight();
        int m = k - j;
        int n = View.MeasureSpec.makeMeasureSpec(m, -2147483648);
        int i3;
        int i2;
        if (this.mClose != null)
        {
          i3 = measureChildView(this.mClose, i1, n, 0);
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
          i2 = i3 - (localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin);
        }
        if ((this.mMenuView != null) && (this.mMenuView.getParent() == this)) {
          i2 = measureChildView(this.mMenuView, i2, n, 0);
        }
        if ((this.mTitleLayout != null) && (this.mCustomView == null)) {
          i2 = measureChildView(this.mTitleLayout, i2, n, 0);
        }
        if (this.mCustomView != null)
        {
          ViewGroup.LayoutParams localLayoutParams = this.mCustomView.getLayoutParams();
          if (localLayoutParams.width == -2) {
            n = -2147483648;
          } else {
            n = 1073741824;
          }
          if (localLayoutParams.width < 0) {
            i3 = i2;
          } else {
            i3 = Math.min(localLayoutParams.width, i2);
          }
          if (localLayoutParams.height == -2) {
            i2 = -2147483648;
          } else {
            i2 = 1073741824;
          }
          if (localLayoutParams.height < 0) {
            m = m;
          } else {
            m = Math.min(localLayoutParams.height, m);
          }
          this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(i3, n), View.MeasureSpec.makeMeasureSpec(m, i2));
        }
        if (this.mContentHeight > 0)
        {
          setMeasuredDimension(i, k);
        }
        else
        {
          i2 = 0;
          k = getChildCount();
        }
        for (n = 0;; n++)
        {
          if (n >= k)
          {
            setMeasuredDimension(i, i2);
            return;
          }
          m = j + getChildAt(n).getMeasuredHeight();
          if (m > i2) {
            i2 = m;
          }
        }
      }
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
    }
    throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    if (this.mCustomView != null) {
      removeView(this.mCustomView);
    }
    this.mCustomView = paramView;
    if (this.mTitleLayout != null)
    {
      removeView(this.mTitleLayout);
      this.mTitleLayout = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSplitActionBar(boolean paramBoolean)
  {
    if (this.mSplitActionBar != paramBoolean)
    {
      if (this.mActionMenuPresenter != null)
      {
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
        ViewGroup localViewGroup;
        if (paramBoolean)
        {
          this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
          this.mActionMenuPresenter.setItemLimit(2147483647);
          localLayoutParams.width = -1;
          localLayoutParams.height = this.mContentHeight;
          this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
          this.mMenuView.setBackgroundDrawable(this.mSplitBackground);
          localViewGroup = (ViewGroup)this.mMenuView.getParent();
          if (localViewGroup != null) {
            localViewGroup.removeView(this.mMenuView);
          }
          this.mSplitView.addView(this.mMenuView, localLayoutParams);
        }
        else
        {
          this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
          this.mMenuView.setBackgroundDrawable(null);
          localViewGroup = (ViewGroup)this.mMenuView.getParent();
          if (localViewGroup != null) {
            localViewGroup.removeView(this.mMenuView);
          }
          addView(this.mMenuView, localLayoutParams);
        }
      }
      super.setSplitActionBar(paramBoolean);
    }
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mSubtitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    initTitle();
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public boolean showOverflowMenu()
  {
    boolean bool;
    if (this.mActionMenuPresenter == null) {
      bool = false;
    } else {
      bool = this.mActionMenuPresenter.showOverflowMenu();
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.ActionBarContextView
 * JD-Core Version:    0.7.0.1
 */