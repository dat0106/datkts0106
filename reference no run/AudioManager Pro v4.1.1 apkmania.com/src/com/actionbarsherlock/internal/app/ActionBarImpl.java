package com.actionbarsherlock.internal.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.SpinnerAdapter;
import com.actionbarsherlock.R.attr;
import com.actionbarsherlock.R.bool;
import com.actionbarsherlock.R.id;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.LayoutParams;
import com.actionbarsherlock.app.ActionBar.OnMenuVisibilityListener;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator.AnimatorListener;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorListenerAdapter;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet.Builder;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineFrameLayout;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuBuilder.Callback;
import com.actionbarsherlock.internal.view.menu.MenuPopupHelper;
import com.actionbarsherlock.internal.view.menu.SubMenuBuilder;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.widget.ScrollingTabContainerView;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ActionBarImpl
  extends ActionBar
{
  private static final int CONTEXT_DISPLAY_NORMAL = 0;
  private static final int CONTEXT_DISPLAY_SPLIT = 1;
  private static final int INVALID_POSITION = -1;
  ActionModeImpl mActionMode;
  private ActionBarView mActionView;
  private Activity mActivity;
  private ActionBarContainer mContainerView;
  private NineFrameLayout mContentView;
  private Context mContext;
  private int mContextDisplayMode;
  private ActionBarContextView mContextView;
  private Animator mCurrentModeAnim;
  private Animator mCurrentShowAnim;
  ActionMode mDeferredDestroyActionMode;
  ActionMode.Callback mDeferredModeDestroyCallback;
  final Handler mHandler = new Handler();
  private boolean mHasEmbeddedTabs;
  final Animator.AnimatorListener mHideListener = new AnimatorListenerAdapter()
  {
    public void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      if (ActionBarImpl.this.mContentView != null)
      {
        ActionBarImpl.this.mContentView.setTranslationY(0.0F);
        ActionBarImpl.this.mContainerView.setTranslationY(0.0F);
      }
      if ((ActionBarImpl.this.mSplitView != null) && (ActionBarImpl.this.mContextDisplayMode == 1)) {
        ActionBarImpl.this.mSplitView.setVisibility(8);
      }
      ActionBarImpl.this.mContainerView.setVisibility(8);
      ActionBarImpl.this.mContainerView.setTransitioning(false);
      ActionBarImpl.access$402(ActionBarImpl.this, null);
      ActionBarImpl.this.completeDeferredDestroyActionMode();
    }
  };
  private boolean mLastMenuVisibility;
  private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList();
  private int mSavedTabPosition = -1;
  private TabImpl mSelectedTab;
  private boolean mShowHideAnimationEnabled;
  final Animator.AnimatorListener mShowListener = new AnimatorListenerAdapter()
  {
    public void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      ActionBarImpl.access$402(ActionBarImpl.this, null);
      ActionBarImpl.this.mContainerView.requestLayout();
    }
  };
  private ActionBarContainer mSplitView;
  private ScrollingTabContainerView mTabScrollView;
  Runnable mTabSelector;
  private ArrayList<TabImpl> mTabs = new ArrayList();
  private Context mThemedContext;
  boolean mWasHiddenBeforeMode;
  
  public ActionBarImpl(Activity paramActivity, int paramInt)
  {
    this.mActivity = paramActivity;
    View localView = paramActivity.getWindow().getDecorView();
    init(localView);
    if ((paramInt & 0x200) == 0) {
      this.mContentView = ((NineFrameLayout)localView.findViewById(16908290));
    }
  }
  
  public ActionBarImpl(Dialog paramDialog)
  {
    init(paramDialog.getWindow().getDecorView());
  }
  
  private void cleanupTabs()
  {
    if (this.mSelectedTab != null) {
      selectTab(null);
    }
    this.mTabs.clear();
    if (this.mTabScrollView != null) {
      this.mTabScrollView.removeAllTabs();
    }
    this.mSavedTabPosition = -1;
  }
  
  private void configureTab(ActionBar.Tab paramTab, int paramInt)
  {
    TabImpl localTabImpl = (TabImpl)paramTab;
    if (localTabImpl.getCallback() != null)
    {
      localTabImpl.setPosition(paramInt);
      this.mTabs.add(paramInt, localTabImpl);
      int j = this.mTabs.size();
      for (int i = paramInt + 1;; i++)
      {
        if (i >= j) {
          return;
        }
        ((TabImpl)this.mTabs.get(i)).setPosition(i);
      }
    }
    throw new IllegalStateException("Action Bar Tab must have a Callback");
  }
  
  private void ensureTabsExist()
  {
    int i = 0;
    if (this.mTabScrollView == null)
    {
      ScrollingTabContainerView localScrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
      if (!this.mHasEmbeddedTabs)
      {
        if (getNavigationMode() != 2) {
          i = 8;
        }
        localScrollingTabContainerView.setVisibility(i);
        this.mContainerView.setTabContainer(localScrollingTabContainerView);
      }
      else
      {
        localScrollingTabContainerView.setVisibility(0);
        this.mActionView.setEmbeddedTabView(localScrollingTabContainerView);
      }
      this.mTabScrollView = localScrollingTabContainerView;
    }
  }
  
  private void init(View paramView)
  {
    int j = 1;
    this.mContext = paramView.getContext();
    this.mActionView = ((ActionBarView)paramView.findViewById(R.id.abs__action_bar));
    this.mContextView = ((ActionBarContextView)paramView.findViewById(R.id.abs__action_context_bar));
    this.mContainerView = ((ActionBarContainer)paramView.findViewById(R.id.abs__action_bar_container));
    this.mSplitView = ((ActionBarContainer)paramView.findViewById(R.id.abs__split_action_bar));
    if ((this.mActionView != null) && (this.mContextView != null) && (this.mContainerView != null))
    {
      this.mActionView.setContextView(this.mContextView);
      int i;
      if (!this.mActionView.isSplitActionBar()) {
        i = 0;
      } else {
        i = j;
      }
      this.mContextDisplayMode = i;
      if (this.mContext.getApplicationInfo().targetSdkVersion >= 14) {
        j = 0;
      }
      setHomeButtonEnabled(j);
      setHasEmbeddedTabs(ResourcesCompat.getResources_getBoolean(this.mContext, R.bool.abs__action_bar_embed_tabs));
      return;
    }
    throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
  }
  
  private void setHasEmbeddedTabs(boolean paramBoolean)
  {
    boolean bool = true;
    this.mHasEmbeddedTabs = paramBoolean;
    if (this.mHasEmbeddedTabs)
    {
      this.mContainerView.setTabContainer(null);
      this.mActionView.setEmbeddedTabView(this.mTabScrollView);
    }
    else
    {
      this.mActionView.setEmbeddedTabView(null);
      this.mContainerView.setTabContainer(this.mTabScrollView);
    }
    int i;
    if (getNavigationMode() != 2) {
      i = 0;
    } else {
      i = bool;
    }
    if (this.mTabScrollView != null)
    {
      localObject = this.mTabScrollView;
      int j;
      if (i == 0) {
        j = 8;
      } else {
        j = 0;
      }
      ((ScrollingTabContainerView)localObject).setVisibility(j);
    }
    Object localObject = this.mActionView;
    if ((this.mHasEmbeddedTabs) || (i == 0)) {
      bool = false;
    }
    ((ActionBarView)localObject).setCollapsable(bool);
  }
  
  public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    this.mMenuVisibilityListeners.add(paramOnMenuVisibilityListener);
  }
  
  public void addTab(ActionBar.Tab paramTab)
  {
    addTab(paramTab, this.mTabs.isEmpty());
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt)
  {
    addTab(paramTab, paramInt, this.mTabs.isEmpty());
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    ensureTabsExist();
    this.mTabScrollView.addTab(paramTab, paramInt, paramBoolean);
    configureTab(paramTab, paramInt);
    if (paramBoolean) {
      selectTab(paramTab);
    }
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    ensureTabsExist();
    this.mTabScrollView.addTab(paramTab, paramBoolean);
    configureTab(paramTab, this.mTabs.size());
    if (paramBoolean) {
      selectTab(paramTab);
    }
  }
  
  void animateToMode(boolean paramBoolean)
  {
    ActionBarView localActionBarView1 = 8;
    if (paramBoolean) {
      show(false);
    }
    if (this.mCurrentModeAnim != null) {
      this.mCurrentModeAnim.end();
    }
    ActionBarView localActionBarView2 = this.mActionView;
    int j;
    if (!paramBoolean) {
      j = 0;
    } else {
      j = localActionBarView1;
    }
    localActionBarView2.animateToVisibility(j);
    ActionBarContextView localActionBarContextView = this.mContextView;
    int i;
    if (!paramBoolean) {
      localActionBarView2 = localActionBarView1;
    } else {
      i = 0;
    }
    localActionBarContextView.animateToVisibility(i);
    if ((this.mTabScrollView != null) && (!this.mActionView.hasEmbeddedTabs()) && (this.mActionView.isCollapsed()))
    {
      ScrollingTabContainerView localScrollingTabContainerView = this.mTabScrollView;
      if (!paramBoolean) {
        localActionBarView1 = 0;
      }
      localScrollingTabContainerView.animateToVisibility(localActionBarView1);
    }
  }
  
  void completeDeferredDestroyActionMode()
  {
    if (this.mDeferredModeDestroyCallback != null)
    {
      this.mDeferredModeDestroyCallback.onDestroyActionMode(this.mDeferredDestroyActionMode);
      this.mDeferredDestroyActionMode = null;
      this.mDeferredModeDestroyCallback = null;
    }
  }
  
  public void dispatchMenuVisibilityChanged(boolean paramBoolean)
  {
    int j;
    if (paramBoolean != this.mLastMenuVisibility)
    {
      this.mLastMenuVisibility = paramBoolean;
      j = this.mMenuVisibilityListeners.size();
    }
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return;
      }
      ((ActionBar.OnMenuVisibilityListener)this.mMenuVisibilityListeners.get(i)).onMenuVisibilityChanged(paramBoolean);
    }
  }
  
  public View getCustomView()
  {
    return this.mActionView.getCustomNavigationView();
  }
  
  public int getDisplayOptions()
  {
    return this.mActionView.getDisplayOptions();
  }
  
  public int getHeight()
  {
    return this.mContainerView.getHeight();
  }
  
  public int getNavigationItemCount()
  {
    int i = 0;
    switch (this.mActionView.getNavigationMode())
    {
    case 1: 
      SpinnerAdapter localSpinnerAdapter = this.mActionView.getDropdownAdapter();
      if (localSpinnerAdapter != null) {
        i = localSpinnerAdapter.getCount();
      }
      break;
    case 2: 
      i = this.mTabs.size();
    }
    return i;
  }
  
  public int getNavigationMode()
  {
    return this.mActionView.getNavigationMode();
  }
  
  public int getSelectedNavigationIndex()
  {
    int i = -1;
    switch (this.mActionView.getNavigationMode())
    {
    case 1: 
      i = this.mActionView.getDropdownSelectedPosition();
      break;
    case 2: 
      if (this.mSelectedTab != null) {
        i = this.mSelectedTab.getPosition();
      }
      break;
    }
    return i;
  }
  
  public ActionBar.Tab getSelectedTab()
  {
    return this.mSelectedTab;
  }
  
  public CharSequence getSubtitle()
  {
    return this.mActionView.getSubtitle();
  }
  
  public ActionBar.Tab getTabAt(int paramInt)
  {
    return (ActionBar.Tab)this.mTabs.get(paramInt);
  }
  
  public int getTabCount()
  {
    return this.mTabs.size();
  }
  
  public Context getThemedContext()
  {
    if (this.mThemedContext == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      int i = localTypedValue.resourceId;
      if (i == 0) {
        this.mThemedContext = this.mContext;
      } else {
        this.mThemedContext = new ContextThemeWrapper(this.mContext, i);
      }
    }
    return this.mThemedContext;
  }
  
  public CharSequence getTitle()
  {
    return this.mActionView.getTitle();
  }
  
  public void hide()
  {
    if (this.mCurrentShowAnim != null) {
      this.mCurrentShowAnim.end();
    }
    if (this.mContainerView.getVisibility() != 8) {
      if (!this.mShowHideAnimationEnabled)
      {
        this.mHideListener.onAnimationEnd(null);
      }
      else
      {
        this.mContainerView.setAlpha(1.0F);
        this.mContainerView.setTransitioning(true);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        Object localObject1 = this.mContainerView;
        Object localObject2 = new float[1];
        localObject2[0] = 0.0F;
        localObject1 = localAnimatorSet.play(ObjectAnimator.ofFloat(localObject1, "alpha", (float[])localObject2));
        Object localObject3;
        if (this.mContentView != null)
        {
          localObject3 = this.mContentView;
          localObject2 = new float[2];
          localObject2[0] = 0.0F;
          localObject2[1] = (-this.mContainerView.getHeight());
          ((AnimatorSet.Builder)localObject1).with(ObjectAnimator.ofFloat(localObject3, "translationY", (float[])localObject2));
          localObject2 = this.mContainerView;
          localObject3 = new float[1];
          localObject3[0] = (-this.mContainerView.getHeight());
          ((AnimatorSet.Builder)localObject1).with(ObjectAnimator.ofFloat(localObject2, "translationY", (float[])localObject3));
        }
        if ((this.mSplitView != null) && (this.mSplitView.getVisibility() == 0))
        {
          this.mSplitView.setAlpha(1.0F);
          localObject3 = this.mSplitView;
          localObject2 = new float[1];
          localObject2[0] = 0.0F;
          ((AnimatorSet.Builder)localObject1).with(ObjectAnimator.ofFloat(localObject3, "alpha", (float[])localObject2));
        }
        localAnimatorSet.addListener(this.mHideListener);
        this.mCurrentShowAnim = localAnimatorSet;
        localAnimatorSet.start();
      }
    }
  }
  
  public boolean isShowing()
  {
    boolean bool;
    if (this.mContainerView.getVisibility() != 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public ActionBar.Tab newTab()
  {
    return new TabImpl();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    setHasEmbeddedTabs(ResourcesCompat.getResources_getBoolean(this.mContext, R.bool.abs__action_bar_embed_tabs));
    if (Build.VERSION.SDK_INT < 8)
    {
      this.mActionView.onConfigurationChanged(paramConfiguration);
      if (this.mContextView != null) {
        this.mContextView.onConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  public void removeAllTabs()
  {
    cleanupTabs();
  }
  
  public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    this.mMenuVisibilityListeners.remove(paramOnMenuVisibilityListener);
  }
  
  public void removeTab(ActionBar.Tab paramTab)
  {
    removeTabAt(paramTab.getPosition());
  }
  
  public void removeTabAt(int paramInt)
  {
    int i;
    int j;
    if (this.mTabScrollView != null)
    {
      if (this.mSelectedTab == null) {
        i = this.mSavedTabPosition;
      } else {
        i = this.mSelectedTab.getPosition();
      }
      this.mTabScrollView.removeTabAt(paramInt);
      TabImpl localTabImpl2 = (TabImpl)this.mTabs.remove(paramInt);
      if (localTabImpl2 != null) {
        localTabImpl2.setPosition(-1);
      }
      j = this.mTabs.size();
    }
    for (int k = paramInt;; k++)
    {
      if (k >= j)
      {
        if (i == paramInt)
        {
          TabImpl localTabImpl1;
          if (!this.mTabs.isEmpty()) {
            localTabImpl1 = (TabImpl)this.mTabs.get(Math.max(0, paramInt - 1));
          } else {
            localTabImpl1 = null;
          }
          selectTab(localTabImpl1);
        }
        return;
      }
      ((TabImpl)this.mTabs.get(k)).setPosition(k);
    }
  }
  
  public void selectTab(ActionBar.Tab paramTab)
  {
    FragmentTransaction localFragmentTransaction2 = -1;
    FragmentTransaction localFragmentTransaction1;
    if (getNavigationMode() == 2)
    {
      localFragmentTransaction1 = null;
      if ((this.mActivity instanceof SherlockFragmentActivity)) {
        localFragmentTransaction1 = ((SherlockFragmentActivity)this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
      }
      if (this.mSelectedTab != paramTab)
      {
        ScrollingTabContainerView localScrollingTabContainerView = this.mTabScrollView;
        if (paramTab != null) {
          localFragmentTransaction2 = paramTab.getPosition();
        }
        localScrollingTabContainerView.setTabSelected(localFragmentTransaction2);
        if (this.mSelectedTab != null) {
          this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, localFragmentTransaction1);
        }
        this.mSelectedTab = ((TabImpl)paramTab);
        if (this.mSelectedTab != null) {
          this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, localFragmentTransaction1);
        }
      }
      else if (this.mSelectedTab != null)
      {
        this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, localFragmentTransaction1);
        this.mTabScrollView.animateToTab(paramTab.getPosition());
      }
      if ((localFragmentTransaction1 != null) && (!localFragmentTransaction1.isEmpty())) {
        localFragmentTransaction1.commit();
      }
    }
    else
    {
      int i;
      if (paramTab == null) {
        localFragmentTransaction1 = localFragmentTransaction2;
      } else {
        i = paramTab.getPosition();
      }
      this.mSavedTabPosition = i;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mContainerView.setPrimaryBackground(paramDrawable);
  }
  
  public void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.mActionView, false));
  }
  
  public void setCustomView(View paramView)
  {
    this.mActionView.setCustomNavigationView(paramView);
  }
  
  public void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    paramView.setLayoutParams(paramLayoutParams);
    this.mActionView.setCustomNavigationView(paramView);
  }
  
  public void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    setDisplayOptions(i, 4);
  }
  
  public void setDisplayOptions(int paramInt)
  {
    this.mActionView.setDisplayOptions(paramInt);
  }
  
  public void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.mActionView.getDisplayOptions();
    this.mActionView.setDisplayOptions(paramInt1 & paramInt2 | i & (paramInt2 ^ 0xFFFFFFFF));
  }
  
  public void setDisplayShowCustomEnabled(boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = 0;
    } else {
      i = 16;
    }
    setDisplayOptions(i, 16);
  }
  
  public void setDisplayShowHomeEnabled(boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = 0;
    } else {
      i = 2;
    }
    setDisplayOptions(i, 2);
  }
  
  public void setDisplayShowTitleEnabled(boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    setDisplayOptions(i, 8);
  }
  
  public void setDisplayUseLogoEnabled(boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = 0;
    } else {
      i = 1;
    }
    setDisplayOptions(i, 1);
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean)
  {
    this.mActionView.setHomeButtonEnabled(paramBoolean);
  }
  
  public void setIcon(int paramInt)
  {
    this.mActionView.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mActionView.setIcon(paramDrawable);
  }
  
  public void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, ActionBar.OnNavigationListener paramOnNavigationListener)
  {
    this.mActionView.setDropdownAdapter(paramSpinnerAdapter);
    this.mActionView.setCallback(paramOnNavigationListener);
  }
  
  public void setLogo(int paramInt)
  {
    this.mActionView.setLogo(paramInt);
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    this.mActionView.setLogo(paramDrawable);
  }
  
  public void setNavigationMode(int paramInt)
  {
    boolean bool = false;
    switch (this.mActionView.getNavigationMode())
    {
    case 2: 
      this.mSavedTabPosition = getSelectedNavigationIndex();
      selectTab(null);
      this.mTabScrollView.setVisibility(8);
    }
    this.mActionView.setNavigationMode(paramInt);
    switch (paramInt)
    {
    case 2: 
      ensureTabsExist();
      this.mTabScrollView.setVisibility(0);
      if (this.mSavedTabPosition != -1)
      {
        setSelectedNavigationItem(this.mSavedTabPosition);
        this.mSavedTabPosition = -1;
      }
      break;
    }
    ActionBarView localActionBarView = this.mActionView;
    if ((paramInt == 2) && (!this.mHasEmbeddedTabs)) {
      bool = true;
    }
    localActionBarView.setCollapsable(bool);
  }
  
  public void setSelectedNavigationItem(int paramInt)
  {
    switch (this.mActionView.getNavigationMode())
    {
    default: 
      throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    case 1: 
      this.mActionView.setDropdownSelectedPosition(paramInt);
      break;
    case 2: 
      selectTab((ActionBar.Tab)this.mTabs.get(paramInt));
    }
  }
  
  public void setShowHideAnimationEnabled(boolean paramBoolean)
  {
    this.mShowHideAnimationEnabled = paramBoolean;
    if ((!paramBoolean) && (this.mCurrentShowAnim != null)) {
      this.mCurrentShowAnim.end();
    }
  }
  
  public void setSplitBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.mSplitView != null) {
      this.mSplitView.setSplitBackground(paramDrawable);
    }
  }
  
  public void setStackedBackgroundDrawable(Drawable paramDrawable)
  {
    this.mContainerView.setStackedBackground(paramDrawable);
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(this.mContext.getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mActionView.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mActionView.setTitle(paramCharSequence);
  }
  
  public void show()
  {
    show(true);
  }
  
  void show(boolean paramBoolean)
  {
    if (this.mCurrentShowAnim != null) {
      this.mCurrentShowAnim.end();
    }
    if (this.mContainerView.getVisibility() != 0)
    {
      this.mContainerView.setVisibility(0);
      if (!this.mShowHideAnimationEnabled)
      {
        this.mContainerView.setAlpha(1.0F);
        this.mContainerView.setTranslationY(0.0F);
        this.mShowListener.onAnimationEnd(null);
      }
      else
      {
        this.mContainerView.setAlpha(0.0F);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        Object localObject2 = this.mContainerView;
        Object localObject1 = new float[1];
        localObject1[0] = 1.0F;
        localObject1 = localAnimatorSet.play(ObjectAnimator.ofFloat(localObject2, "alpha", (float[])localObject1));
        Object localObject3;
        if (this.mContentView != null)
        {
          localObject3 = this.mContentView;
          localObject2 = new float[2];
          localObject2[0] = (-this.mContainerView.getHeight());
          localObject2[1] = 0.0F;
          ((AnimatorSet.Builder)localObject1).with(ObjectAnimator.ofFloat(localObject3, "translationY", (float[])localObject2));
          this.mContainerView.setTranslationY(-this.mContainerView.getHeight());
          localObject2 = this.mContainerView;
          localObject3 = new float[1];
          localObject3[0] = 0.0F;
          ((AnimatorSet.Builder)localObject1).with(ObjectAnimator.ofFloat(localObject2, "translationY", (float[])localObject3));
        }
        if ((this.mSplitView != null) && (this.mContextDisplayMode == 1))
        {
          this.mSplitView.setAlpha(0.0F);
          this.mSplitView.setVisibility(0);
          localObject2 = this.mSplitView;
          localObject3 = new float[1];
          localObject3[0] = 1.0F;
          ((AnimatorSet.Builder)localObject1).with(ObjectAnimator.ofFloat(localObject2, "alpha", (float[])localObject3));
        }
        localAnimatorSet.addListener(this.mShowListener);
        this.mCurrentShowAnim = localAnimatorSet;
        localAnimatorSet.start();
      }
    }
    else if (paramBoolean)
    {
      this.mWasHiddenBeforeMode = false;
    }
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    boolean bool = false;
    if (this.mActionMode != null)
    {
      bool = this.mWasHiddenBeforeMode;
      this.mActionMode.finish();
    }
    this.mContextView.killMode();
    ActionModeImpl localActionModeImpl = new ActionModeImpl(paramCallback);
    if (!localActionModeImpl.dispatchOnCreate())
    {
      localActionModeImpl = null;
    }
    else
    {
      if ((isShowing()) && (!bool)) {
        bool = false;
      } else {
        bool = true;
      }
      this.mWasHiddenBeforeMode = bool;
      localActionModeImpl.invalidate();
      this.mContextView.initForMode(localActionModeImpl);
      animateToMode(true);
      if ((this.mSplitView != null) && (this.mContextDisplayMode == 1)) {
        this.mSplitView.setVisibility(0);
      }
      this.mContextView.sendAccessibilityEvent(32);
      this.mActionMode = localActionModeImpl;
    }
    return localActionModeImpl;
  }
  
  public class TabImpl
    extends ActionBar.Tab
  {
    private ActionBar.TabListener mCallback;
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    private int mPosition = -1;
    private Object mTag;
    private CharSequence mText;
    
    public TabImpl() {}
    
    public ActionBar.TabListener getCallback()
    {
      return this.mCallback;
    }
    
    public CharSequence getContentDescription()
    {
      return this.mContentDesc;
    }
    
    public View getCustomView()
    {
      return this.mCustomView;
    }
    
    public Drawable getIcon()
    {
      return this.mIcon;
    }
    
    public int getPosition()
    {
      return this.mPosition;
    }
    
    public Object getTag()
    {
      return this.mTag;
    }
    
    public CharSequence getText()
    {
      return this.mText;
    }
    
    public void select()
    {
      ActionBarImpl.this.selectTab(this);
    }
    
    public ActionBar.Tab setContentDescription(int paramInt)
    {
      return setContentDescription(ActionBarImpl.this.mContext.getResources().getText(paramInt));
    }
    
    public ActionBar.Tab setContentDescription(CharSequence paramCharSequence)
    {
      this.mContentDesc = paramCharSequence;
      if (this.mPosition >= 0) {
        ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
      }
      return this;
    }
    
    public ActionBar.Tab setCustomView(int paramInt)
    {
      return setCustomView(LayoutInflater.from(ActionBarImpl.this.getThemedContext()).inflate(paramInt, null));
    }
    
    public ActionBar.Tab setCustomView(View paramView)
    {
      this.mCustomView = paramView;
      if (this.mPosition >= 0) {
        ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
      }
      return this;
    }
    
    public ActionBar.Tab setIcon(int paramInt)
    {
      return setIcon(ActionBarImpl.this.mContext.getResources().getDrawable(paramInt));
    }
    
    public ActionBar.Tab setIcon(Drawable paramDrawable)
    {
      this.mIcon = paramDrawable;
      if (this.mPosition >= 0) {
        ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
      }
      return this;
    }
    
    public void setPosition(int paramInt)
    {
      this.mPosition = paramInt;
    }
    
    public ActionBar.Tab setTabListener(ActionBar.TabListener paramTabListener)
    {
      this.mCallback = paramTabListener;
      return this;
    }
    
    public ActionBar.Tab setTag(Object paramObject)
    {
      this.mTag = paramObject;
      return this;
    }
    
    public ActionBar.Tab setText(int paramInt)
    {
      return setText(ActionBarImpl.this.mContext.getResources().getText(paramInt));
    }
    
    public ActionBar.Tab setText(CharSequence paramCharSequence)
    {
      this.mText = paramCharSequence;
      if (this.mPosition >= 0) {
        ActionBarImpl.this.mTabScrollView.updateTab(this.mPosition);
      }
      return this;
    }
  }
  
  public class ActionModeImpl
    extends ActionMode
    implements MenuBuilder.Callback
  {
    private ActionMode.Callback mCallback;
    private WeakReference<View> mCustomView;
    private MenuBuilder mMenu;
    
    public ActionModeImpl(ActionMode.Callback paramCallback)
    {
      this.mCallback = paramCallback;
      this.mMenu = new MenuBuilder(ActionBarImpl.this.getThemedContext()).setDefaultShowAsAction(1);
      this.mMenu.setCallback(this);
    }
    
    public boolean dispatchOnCreate()
    {
      this.mMenu.stopDispatchingItemsChanged();
      try
      {
        boolean bool = this.mCallback.onCreateActionMode(this, this.mMenu);
        return bool;
      }
      finally
      {
        this.mMenu.startDispatchingItemsChanged();
      }
    }
    
    public void finish()
    {
      if (ActionBarImpl.this.mActionMode == this)
      {
        if (!ActionBarImpl.this.mWasHiddenBeforeMode)
        {
          this.mCallback.onDestroyActionMode(this);
        }
        else
        {
          ActionBarImpl.this.mDeferredDestroyActionMode = this;
          ActionBarImpl.this.mDeferredModeDestroyCallback = this.mCallback;
        }
        this.mCallback = null;
        ActionBarImpl.this.animateToMode(false);
        ActionBarImpl.this.mContextView.closeMode();
        ActionBarImpl.this.mActionView.sendAccessibilityEvent(32);
        ActionBarImpl.this.mActionMode = null;
        if (ActionBarImpl.this.mWasHiddenBeforeMode) {
          ActionBarImpl.this.hide();
        }
      }
    }
    
    public View getCustomView()
    {
      View localView;
      if (this.mCustomView == null) {
        localView = null;
      } else {
        localView = (View)this.mCustomView.get();
      }
      return localView;
    }
    
    public Menu getMenu()
    {
      return this.mMenu;
    }
    
    public MenuInflater getMenuInflater()
    {
      return new MenuInflater(ActionBarImpl.this.getThemedContext());
    }
    
    public CharSequence getSubtitle()
    {
      return ActionBarImpl.this.mContextView.getSubtitle();
    }
    
    public CharSequence getTitle()
    {
      return ActionBarImpl.this.mContextView.getTitle();
    }
    
    public void invalidate()
    {
      this.mMenu.stopDispatchingItemsChanged();
      try
      {
        this.mCallback.onPrepareActionMode(this, this.mMenu);
        return;
      }
      finally
      {
        this.mMenu.startDispatchingItemsChanged();
      }
    }
    
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
    
    public void onCloseSubMenu(SubMenuBuilder paramSubMenuBuilder) {}
    
    public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
    {
      boolean bool;
      if (this.mCallback == null) {
        bool = false;
      } else {
        bool = this.mCallback.onActionItemClicked(this, paramMenuItem);
      }
      return bool;
    }
    
    public void onMenuModeChange(MenuBuilder paramMenuBuilder)
    {
      if (this.mCallback != null)
      {
        invalidate();
        ActionBarImpl.this.mContextView.showOverflowMenu();
      }
    }
    
    public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
    {
      boolean bool = true;
      if (this.mCallback != null)
      {
        if (paramSubMenuBuilder.hasVisibleItems()) {
          new MenuPopupHelper(ActionBarImpl.this.getThemedContext(), paramSubMenuBuilder).show();
        }
      }
      else {
        bool = false;
      }
      return bool;
    }
    
    public void setCustomView(View paramView)
    {
      ActionBarImpl.this.mContextView.setCustomView(paramView);
      this.mCustomView = new WeakReference(paramView);
    }
    
    public void setSubtitle(int paramInt)
    {
      setSubtitle(ActionBarImpl.this.mContext.getResources().getString(paramInt));
    }
    
    public void setSubtitle(CharSequence paramCharSequence)
    {
      ActionBarImpl.this.mContextView.setSubtitle(paramCharSequence);
    }
    
    public void setTitle(int paramInt)
    {
      setTitle(ActionBarImpl.this.mContext.getResources().getString(paramInt));
    }
    
    public void setTitle(CharSequence paramCharSequence)
    {
      ActionBarImpl.this.mContextView.setTitle(paramCharSequence);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.app.ActionBarImpl
 * JD-Core Version:    0.7.0.1
 */