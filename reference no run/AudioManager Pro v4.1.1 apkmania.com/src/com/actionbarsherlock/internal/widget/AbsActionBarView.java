package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.actionbarsherlock.R.attr;
import com.actionbarsherlock.R.bool;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator.AnimatorListener;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet.Builder;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import com.actionbarsherlock.internal.nineoldandroids.view.NineViewGroup;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.ActionMenuView;

public abstract class AbsActionBarView
  extends NineViewGroup
{
  private static final int FADE_DURATION = 200;
  private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
  protected ActionMenuPresenter mActionMenuPresenter;
  protected int mContentHeight;
  final Context mContext;
  protected ActionMenuView mMenuView;
  protected boolean mSplitActionBar;
  protected ActionBarContainer mSplitView;
  protected boolean mSplitWhenNarrow;
  protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
  protected Animator mVisibilityAnim;
  
  public AbsActionBarView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  public void animateToVisibility(int paramInt)
  {
    if (this.mVisibilityAnim != null) {
      this.mVisibilityAnim.cancel();
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    float[] arrayOfFloat;
    if (paramInt != 0)
    {
      localObject1 = new float[1];
      localObject1[0] = 0.0F;
      localObject2 = ObjectAnimator.ofFloat(this, "alpha", (float[])localObject1);
      ((ObjectAnimator)localObject2).setDuration(200L);
      ((ObjectAnimator)localObject2).setInterpolator(sAlphaInterpolator);
      if ((this.mSplitView == null) || (this.mMenuView == null))
      {
        ((ObjectAnimator)localObject2).addListener(this.mVisAnimListener.withFinalVisibility(paramInt));
        ((ObjectAnimator)localObject2).start();
      }
      else
      {
        localObject1 = new AnimatorSet();
        localObject3 = this.mMenuView;
        arrayOfFloat = new float[1];
        arrayOfFloat[0] = 0.0F;
        localObject3 = ObjectAnimator.ofFloat(localObject3, "alpha", arrayOfFloat);
        ((ObjectAnimator)localObject3).setDuration(200L);
        ((AnimatorSet)localObject1).addListener(this.mVisAnimListener.withFinalVisibility(paramInt));
        ((AnimatorSet)localObject1).play((Animator)localObject2).with((Animator)localObject3);
        ((AnimatorSet)localObject1).start();
      }
    }
    else
    {
      if (getVisibility() != 0)
      {
        setAlpha(0.0F);
        if ((this.mSplitView != null) && (this.mMenuView != null)) {
          this.mMenuView.setAlpha(0.0F);
        }
      }
      localObject1 = new float[1];
      localObject1[0] = 1.0F;
      localObject1 = ObjectAnimator.ofFloat(this, "alpha", (float[])localObject1);
      ((ObjectAnimator)localObject1).setDuration(200L);
      ((ObjectAnimator)localObject1).setInterpolator(sAlphaInterpolator);
      if ((this.mSplitView == null) || (this.mMenuView == null))
      {
        ((ObjectAnimator)localObject1).addListener(this.mVisAnimListener.withFinalVisibility(paramInt));
        ((ObjectAnimator)localObject1).start();
      }
      else
      {
        localObject2 = new AnimatorSet();
        localObject3 = this.mMenuView;
        arrayOfFloat = new float[1];
        arrayOfFloat[0] = 1.0F;
        localObject3 = ObjectAnimator.ofFloat(localObject3, "alpha", arrayOfFloat);
        ((ObjectAnimator)localObject3).setDuration(200L);
        ((AnimatorSet)localObject2).addListener(this.mVisAnimListener.withFinalVisibility(paramInt));
        ((AnimatorSet)localObject2).play((Animator)localObject1).with((Animator)localObject3);
        ((AnimatorSet)localObject2).start();
      }
    }
  }
  
  public void dismissPopupMenus()
  {
    if (this.mActionMenuPresenter != null) {
      this.mActionMenuPresenter.dismissPopupMenus();
    }
  }
  
  public int getAnimatedVisibility()
  {
    int i;
    if (this.mVisibilityAnim == null) {
      i = getVisibility();
    } else {
      i = this.mVisAnimListener.mFinalVisibility;
    }
    return i;
  }
  
  public int getContentHeight()
  {
    return this.mContentHeight;
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
  
  public boolean isOverflowReserved()
  {
    boolean bool;
    if ((this.mActionMenuPresenter == null) || (!this.mActionMenuPresenter.isOverflowReserved())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected int measureChildView(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() - paramInt3);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT < 8)
    {
      if (this.mMenuView != null) {
        this.mMenuView.onConfigurationChanged(paramConfiguration);
      }
    }
    else {
      super.onConfigurationChanged(paramConfiguration);
    }
    TypedArray localTypedArray = getContext().obtainStyledAttributes(null, R.styleable.SherlockActionBar, R.attr.actionBarStyle, 0);
    setContentHeight(localTypedArray.getLayoutDimension(4, 0));
    localTypedArray.recycle();
    if (this.mSplitWhenNarrow) {
      setSplitActionBar(ResourcesCompat.getResources_getBoolean(getContext(), R.bool.abs__split_action_bar_is_narrow));
    }
    if (this.mActionMenuPresenter != null) {
      this.mActionMenuPresenter.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected int positionChild(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramView.getMeasuredWidth();
    int k = paramView.getMeasuredHeight();
    int i = paramInt2 + (paramInt3 - k) / 2;
    paramView.layout(paramInt1, i, paramInt1 + j, i + k);
    return j;
  }
  
  protected int positionChildInverse(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    int k = paramInt2 + (paramInt3 - j) / 2;
    paramView.layout(paramInt1 - i, k, paramInt1, k + j);
    return i;
  }
  
  public void postShowOverflowMenu()
  {
    post(new Runnable()
    {
      public void run()
      {
        AbsActionBarView.this.showOverflowMenu();
      }
    });
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
    requestLayout();
  }
  
  public void setSplitActionBar(boolean paramBoolean)
  {
    this.mSplitActionBar = paramBoolean;
  }
  
  public void setSplitView(ActionBarContainer paramActionBarContainer)
  {
    this.mSplitView = paramActionBarContainer;
  }
  
  public void setSplitWhenNarrow(boolean paramBoolean)
  {
    this.mSplitWhenNarrow = paramBoolean;
  }
  
  public void setVisibility(int paramInt)
  {
    if (this.mVisibilityAnim != null) {
      this.mVisibilityAnim.end();
    }
    super.setVisibility(paramInt);
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
  
  protected class VisibilityAnimListener
    implements Animator.AnimatorListener
  {
    private boolean mCanceled = false;
    int mFinalVisibility;
    
    protected VisibilityAnimListener() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.mCanceled = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.mCanceled)
      {
        AbsActionBarView.this.mVisibilityAnim = null;
        AbsActionBarView.this.setVisibility(this.mFinalVisibility);
        if ((AbsActionBarView.this.mSplitView != null) && (AbsActionBarView.this.mMenuView != null)) {
          AbsActionBarView.this.mMenuView.setVisibility(this.mFinalVisibility);
        }
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator)
    {
      AbsActionBarView.this.setVisibility(0);
      AbsActionBarView.this.mVisibilityAnim = paramAnimator;
      this.mCanceled = false;
    }
    
    public VisibilityAnimListener withFinalVisibility(int paramInt)
    {
      this.mFinalVisibility = paramInt;
      return this;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.AbsActionBarView
 * JD-Core Version:    0.7.0.1
 */