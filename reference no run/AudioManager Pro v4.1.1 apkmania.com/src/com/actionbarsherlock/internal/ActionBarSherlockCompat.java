package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.ActionBarSherlock.Implementation;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeFinishedListener;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeStartedListener;
import com.actionbarsherlock.R.attr;
import com.actionbarsherlock.R.bool;
import com.actionbarsherlock.R.id;
import com.actionbarsherlock.R.layout;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.app.ActionBarImpl;
import com.actionbarsherlock.internal.view.StandaloneActionMode;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuBuilder.Callback;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.internal.view.menu.MenuPresenter.Callback;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.widget.IcsProgressBar;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@ActionBarSherlock.Implementation(api=7)
public class ActionBarSherlockCompat
  extends ActionBarSherlock
  implements MenuBuilder.Callback, com.actionbarsherlock.view.Window.Callback, MenuPresenter.Callback, MenuItem.OnMenuItemClickListener
{
  protected static final int DEFAULT_FEATURES;
  private ActionBarImpl aActionBar;
  private ActionMode mActionMode;
  private ActionBarContextView mActionModeView;
  private IcsProgressBar mCircularProgressBar;
  private boolean mClosingActionMenu;
  private ViewGroup mContentParent;
  private ViewGroup mDecor;
  private int mFeatures = 0;
  private IcsProgressBar mHorizontalProgressBar;
  private boolean mIsDestroyed = false;
  private boolean mIsFloating;
  private boolean mIsTitleReady = false;
  private MenuBuilder mMenu;
  private Bundle mMenuFrozenActionViewState;
  private boolean mMenuIsPrepared;
  private boolean mMenuKeyIsLongPress = false;
  private boolean mMenuRefreshContent;
  protected HashMap<android.view.MenuItem, MenuItemImpl> mNativeItemMap;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet = false;
  private CharSequence mTitle = null;
  private TextView mTitleView;
  private int mUiOptions = 0;
  private ActionBarView wActionBar;
  
  public ActionBarSherlockCompat(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
  }
  
  public static String cleanActivityName(String paramString1, String paramString2)
  {
    if (paramString2.charAt(0) != '.')
    {
      if (paramString2.indexOf('.', 1) == -1) {
        paramString2 = paramString1 + "." + paramString2;
      }
    }
    else {
      paramString2 = paramString1 + paramString2;
    }
    return paramString2;
  }
  
  private ViewGroup generateLayout()
  {
    TypedArray localTypedArray = this.mActivity.getTheme().obtainStyledAttributes(R.styleable.SherlockTheme);
    this.mIsFloating = localTypedArray.getBoolean(0, false);
    if (localTypedArray.hasValue(45))
    {
      if (!localTypedArray.getBoolean(44, false))
      {
        if (localTypedArray.getBoolean(45, false)) {
          requestFeature(8);
        }
      }
      else {
        requestFeature(1);
      }
      if (localTypedArray.getBoolean(46, false)) {
        requestFeature(9);
      }
      if (localTypedArray.getBoolean(47, false)) {
        requestFeature(10);
      }
      localTypedArray.recycle();
      int i;
      if (hasFeature(1))
      {
        if ((!hasFeature(10)) || (hasFeature(1))) {
          i = R.layout.abs__screen_simple;
        } else {
          i = R.layout.abs__screen_simple_overlay_action_mode;
        }
      }
      else if (!this.mIsFloating)
      {
        if (!hasFeature(9)) {
          i = R.layout.abs__screen_action_bar;
        } else {
          i = R.layout.abs__screen_action_bar_overlay;
        }
      }
      else
      {
        this.mDecor = ((ViewGroup)this.mDecor.getParent());
        this.mDecor.removeAllViews();
        i = R.layout.abs__dialog_title_holo;
      }
      Object localObject = this.mActivity.getLayoutInflater().inflate(i, null);
      this.mDecor.addView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
      ViewGroup localViewGroup = (ViewGroup)this.mDecor.findViewById(R.id.abs__content);
      if (localViewGroup != null)
      {
        this.mDecor.setId(-1);
        localViewGroup.setId(16908290);
        if (hasFeature(5))
        {
          localObject = getCircularProgressBar(false);
          if (localObject != null) {
            ((IcsProgressBar)localObject).setIndeterminate(true);
          }
        }
        return localViewGroup;
      }
      throw new RuntimeException("Couldn't find content container view");
    }
    throw new IllegalStateException("You must use Theme.Sherlock, Theme.Sherlock.Light, Theme.Sherlock.Light.DarkActionBar, or a derivative.");
  }
  
  private IcsProgressBar getCircularProgressBar(boolean paramBoolean)
  {
    IcsProgressBar localIcsProgressBar;
    if (this.mCircularProgressBar == null)
    {
      if ((this.mContentParent == null) && (paramBoolean)) {
        installDecor();
      }
      this.mCircularProgressBar = ((IcsProgressBar)this.mDecor.findViewById(R.id.abs__progress_circular));
      if (this.mCircularProgressBar != null) {
        this.mCircularProgressBar.setVisibility(4);
      }
      localIcsProgressBar = this.mCircularProgressBar;
    }
    else
    {
      localIcsProgressBar = this.mCircularProgressBar;
    }
    return localIcsProgressBar;
  }
  
  private int getFeatures()
  {
    return this.mFeatures;
  }
  
  private IcsProgressBar getHorizontalProgressBar(boolean paramBoolean)
  {
    IcsProgressBar localIcsProgressBar;
    if (this.mHorizontalProgressBar == null)
    {
      if ((this.mContentParent == null) && (paramBoolean)) {
        installDecor();
      }
      this.mHorizontalProgressBar = ((IcsProgressBar)this.mDecor.findViewById(R.id.abs__progress_horizontal));
      if (this.mHorizontalProgressBar != null) {
        this.mHorizontalProgressBar.setVisibility(4);
      }
      localIcsProgressBar = this.mHorizontalProgressBar;
    }
    else
    {
      localIcsProgressBar = this.mHorizontalProgressBar;
    }
    return localIcsProgressBar;
  }
  
  private void hideProgressBars(IcsProgressBar paramIcsProgressBar1, IcsProgressBar paramIcsProgressBar2)
  {
    int i = this.mFeatures;
    Animation localAnimation = AnimationUtils.loadAnimation(this.mActivity, 17432577);
    localAnimation.setDuration(1000L);
    if (((i & 0x20) != 0) && (paramIcsProgressBar2.getVisibility() == 0))
    {
      paramIcsProgressBar2.startAnimation(localAnimation);
      paramIcsProgressBar2.setVisibility(4);
    }
    if (((i & 0x4) != 0) && (paramIcsProgressBar1.getVisibility() == 0))
    {
      paramIcsProgressBar1.startAnimation(localAnimation);
      paramIcsProgressBar1.setVisibility(4);
    }
  }
  
  private void initActionBar()
  {
    if (this.mDecor == null) {
      installDecor();
    }
    if ((this.aActionBar == null) && (hasFeature(8)) && (!hasFeature(1)) && (!this.mActivity.isChild()))
    {
      this.aActionBar = new ActionBarImpl(this.mActivity, this.mFeatures);
      if (!this.mIsDelegate) {
        this.wActionBar.setWindowTitle(this.mActivity.getTitle());
      }
    }
  }
  
  private boolean initializePanelMenu()
  {
    Object localObject = this.mActivity;
    if (this.wActionBar != null)
    {
      TypedValue localTypedValue = new TypedValue();
      ((Context)localObject).getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
      int i = localTypedValue.resourceId;
      if (i != 0) {
        localObject = new ContextThemeWrapper((Context)localObject, i);
      }
    }
    this.mMenu = new MenuBuilder((Context)localObject);
    this.mMenu.setCallback(this);
    return true;
  }
  
  private void installDecor()
  {
    int i = 1;
    if (this.mDecor == null) {
      this.mDecor = ((ViewGroup)this.mActivity.getWindow().getDecorView().findViewById(16908290));
    }
    Object localObject2;
    int j;
    int k;
    if (this.mContentParent == null)
    {
      localObject2 = null;
      if (this.mDecor.getChildCount() > 0)
      {
        localObject2 = new ArrayList(i);
        j = 0;
        k = this.mDecor.getChildCount();
      }
    }
    for (;;)
    {
      boolean bool;
      Object localObject1;
      if (j >= k)
      {
        this.mContentParent = generateLayout();
        if (localObject2 != null) {
          localObject2 = ((List)localObject2).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext())
          {
            this.mTitleView = ((TextView)this.mDecor.findViewById(16908310));
            if (this.mTitleView == null)
            {
              this.wActionBar = ((ActionBarView)this.mDecor.findViewById(R.id.abs__action_bar));
              if (this.wActionBar != null)
              {
                this.wActionBar.setWindowCallback(this);
                if (this.wActionBar.getTitle() == null) {
                  this.wActionBar.setWindowTitle(this.mActivity.getTitle());
                }
                if (hasFeature(2)) {
                  this.wActionBar.initProgress();
                }
                if (hasFeature(5)) {
                  this.wActionBar.initIndeterminateProgress();
                }
                j = loadUiOptionsFromManifest(this.mActivity);
                if (j != 0) {
                  this.mUiOptions = j;
                }
                if ((0x1 & this.mUiOptions) == 0) {
                  i = 0;
                }
                if (i == 0) {
                  bool = this.mActivity.getTheme().obtainStyledAttributes(R.styleable.SherlockTheme).getBoolean(48, false);
                } else {
                  bool = ResourcesCompat.getResources_getBoolean(this.mActivity, R.bool.abs__split_action_bar_is_narrow);
                }
                localObject1 = (ActionBarContainer)this.mDecor.findViewById(R.id.abs__split_action_bar);
                if (localObject1 == null)
                {
                  if (bool) {
                    Log.e("ActionBarSherlock", "Requested split action bar with incompatible window decor! Ignoring request.");
                  }
                }
                else
                {
                  this.wActionBar.setSplitView((ActionBarContainer)localObject1);
                  this.wActionBar.setSplitActionBar(bool);
                  this.wActionBar.setSplitWhenNarrow(i);
                  this.mActionModeView = ((ActionBarContextView)this.mDecor.findViewById(R.id.abs__action_context_bar));
                  this.mActionModeView.setSplitView((ActionBarContainer)localObject1);
                  this.mActionModeView.setSplitActionBar(bool);
                  this.mActionModeView.setSplitWhenNarrow(i);
                }
                this.mDecor.post(new Runnable()
                {
                  public void run()
                  {
                    if ((!ActionBarSherlockCompat.this.mIsDestroyed) && (!ActionBarSherlockCompat.this.mActivity.isFinishing()) && (ActionBarSherlockCompat.this.mMenu == null)) {
                      ActionBarSherlockCompat.this.dispatchInvalidateOptionsMenu();
                    }
                  }
                });
              }
            }
            else if (!hasFeature(i))
            {
              this.mTitleView.setText(this.mTitle);
            }
            else
            {
              this.mTitleView.setVisibility(8);
              if ((this.mContentParent instanceof FrameLayout)) {
                ((FrameLayout)this.mContentParent).setForeground(null);
              }
            }
            return;
          }
          localObject1 = (View)bool.next();
          this.mContentParent.addView((View)localObject1);
        }
      }
      View localView = this.mDecor.getChildAt(0);
      this.mDecor.removeView(localView);
      bool.add(localView);
      localObject1++;
    }
  }
  
  private boolean isReservingOverflow()
  {
    if (!this.mReserveOverflowSet)
    {
      this.mReserveOverflow = ActionMenuPresenter.reserveOverflow(this.mActivity);
      this.mReserveOverflowSet = true;
    }
    return this.mReserveOverflow;
  }
  
  private static int loadUiOptionsFromManifest(Activity paramActivity)
  {
    int i = 0;
    try
    {
      String str1 = paramActivity.getClass().getName();
      String str2 = paramActivity.getApplicationInfo().packageName;
      XmlResourceParser localXmlResourceParser = paramActivity.createPackageContext(str2, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
      int j = localXmlResourceParser.getEventType();
      label129:
      Integer localInteger;
      int m;
      String str5;
      if (j != 1)
      {
        int k;
        if (j == 2)
        {
          String str3 = localXmlResourceParser.getName();
          if (!"application".equals(str3)) {
            break label129;
          }
          k = -1 + localXmlResourceParser.getAttributeCount();
          if (k >= 0)
          {
            if (!"uiOptions".equals(localXmlResourceParser.getAttributeName(k))) {
              break label279;
            }
            i = localXmlResourceParser.getAttributeIntValue(k, 0);
          }
        }
        while (!"activity".equals(k))
        {
          k = localXmlResourceParser.nextToken();
          break;
        }
        localInteger = null;
        str4 = null;
        m = 0;
        n = -1 + localXmlResourceParser.getAttributeCount();
        if (n >= 0)
        {
          str5 = localXmlResourceParser.getAttributeName(n);
          if ("uiOptions".equals(str5)) {
            localInteger = Integer.valueOf(localXmlResourceParser.getAttributeIntValue(n, 0));
          }
        }
      }
      for (;;)
      {
        if ((localInteger == null) || (str4 == null)) {
          break label285;
        }
        i = localInteger.intValue();
        break label285;
        if ("name".equals(str5))
        {
          str4 = cleanActivityName(str2, localXmlResourceParser.getAttributeValue(n));
          boolean bool = str1.equals(str4);
          if (!bool)
          {
            if (m == 0) {
              break;
            }
            return i;
          }
          m = 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str4;
        int n;
        localException.printStackTrace();
        continue;
        label279:
        str4--;
        continue;
        label285:
        n--;
      }
    }
  }
  
  private void onIntChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 2) || (paramInt1 == 5)) {
      updateProgressBars(paramInt2);
    }
  }
  
  private boolean preparePanel()
  {
    boolean bool = false;
    if (!this.mMenuIsPrepared)
    {
      if ((this.mMenu == null) || (this.mMenuRefreshContent))
      {
        if ((this.mMenu == null) && ((!initializePanelMenu()) || (this.mMenu == null))) {
          return bool;
        }
        if (this.wActionBar != null) {
          this.wActionBar.setMenu(this.mMenu, this);
        }
        this.mMenu.stopDispatchingItemsChanged();
        if (callbackCreateOptionsMenu(this.mMenu)) {
          this.mMenuRefreshContent = false;
        }
      }
      else
      {
        this.mMenu.stopDispatchingItemsChanged();
        if (this.mMenuFrozenActionViewState != null)
        {
          this.mMenu.restoreActionViewStates(this.mMenuFrozenActionViewState);
          this.mMenuFrozenActionViewState = null;
        }
        if (callbackPrepareOptionsMenu(this.mMenu))
        {
          KeyCharacterMap localKeyCharacterMap = KeyCharacterMap.load(-1);
          MenuBuilder localMenuBuilder = this.mMenu;
          if (localKeyCharacterMap.getKeyboardType() != 1) {
            bool = true;
          }
          localMenuBuilder.setQwertyMode(bool);
          this.mMenu.startDispatchingItemsChanged();
          this.mMenuIsPrepared = true;
          return true;
        }
        if (this.wActionBar != null) {
          this.wActionBar.setMenu(null, this);
        }
        this.mMenu.startDispatchingItemsChanged();
        return bool;
      }
      this.mMenu = null;
      if (this.wActionBar != null) {
        this.wActionBar.setMenu(null, this);
      }
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  private void reopenMenu(boolean paramBoolean)
  {
    if ((this.wActionBar != null) && (this.wActionBar.isOverflowReserved())) {
      if ((this.wActionBar.isOverflowMenuShowing()) && (paramBoolean)) {
        this.wActionBar.hideOverflowMenu();
      } else if ((this.wActionBar.getVisibility() == 0) && (callbackPrepareOptionsMenu(this.mMenu))) {
        this.wActionBar.showOverflowMenu();
      }
    }
  }
  
  private void setFeatureInt(int paramInt1, int paramInt2)
  {
    updateInt(paramInt1, paramInt2, false);
  }
  
  private void showProgressBars(IcsProgressBar paramIcsProgressBar1, IcsProgressBar paramIcsProgressBar2)
  {
    int i = this.mFeatures;
    if (((i & 0x20) != 0) && (paramIcsProgressBar2.getVisibility() == 4)) {
      paramIcsProgressBar2.setVisibility(0);
    }
    if (((i & 0x4) != 0) && (paramIcsProgressBar1.getProgress() < 10000)) {
      paramIcsProgressBar1.setVisibility(0);
    }
  }
  
  private void updateInt(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.mContentParent != null) && (((1 << paramInt1 & getFeatures()) != 0) || (paramBoolean))) {
      onIntChanged(paramInt1, paramInt2);
    }
  }
  
  private void updateProgressBars(int paramInt)
  {
    IcsProgressBar localIcsProgressBar1 = getCircularProgressBar(true);
    IcsProgressBar localIcsProgressBar2 = getHorizontalProgressBar(true);
    int i = this.mFeatures;
    if (paramInt != -1)
    {
      if (paramInt != -2)
      {
        if (paramInt != -3)
        {
          if (paramInt != -4)
          {
            if ((paramInt < 0) || (paramInt > 10000))
            {
              if ((20000 <= paramInt) && (paramInt <= 30000))
              {
                localIcsProgressBar2.setSecondaryProgress(paramInt - 20000);
                showProgressBars(localIcsProgressBar2, localIcsProgressBar1);
              }
            }
            else
            {
              localIcsProgressBar2.setProgress(paramInt + 0);
              if (paramInt >= 10000) {
                hideProgressBars(localIcsProgressBar2, localIcsProgressBar1);
              } else {
                showProgressBars(localIcsProgressBar2, localIcsProgressBar1);
              }
            }
          }
          else {
            localIcsProgressBar2.setIndeterminate(false);
          }
        }
        else {
          localIcsProgressBar2.setIndeterminate(true);
        }
      }
      else
      {
        if ((i & 0x4) != 0) {
          localIcsProgressBar2.setVisibility(8);
        }
        if ((i & 0x20) != 0) {
          localIcsProgressBar1.setVisibility(8);
        }
      }
    }
    else
    {
      if ((i & 0x4) != 0)
      {
        int j = localIcsProgressBar2.getProgress();
        if ((!localIcsProgressBar2.isIndeterminate()) && (j >= 10000)) {
          j = 4;
        } else {
          j = 0;
        }
        localIcsProgressBar2.setVisibility(j);
      }
      if ((i & 0x20) != 0) {
        localIcsProgressBar1.setVisibility(0);
      }
    }
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mContentParent == null) {
      installDecor();
    }
    this.mContentParent.addView(paramView, paramLayoutParams);
    initActionBar();
  }
  
  void checkCloseActionMenu(com.actionbarsherlock.view.Menu paramMenu)
  {
    if (!this.mClosingActionMenu)
    {
      this.mClosingActionMenu = true;
      this.wActionBar.dismissPopupMenus();
      this.mClosingActionMenu = false;
    }
  }
  
  public boolean dispatchCloseOptionsMenu()
  {
    boolean bool;
    if (isReservingOverflow()) {
      bool = this.wActionBar.hideOverflowMenu();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.aActionBar != null) {
      this.aActionBar.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean dispatchCreateOptionsMenu(android.view.Menu paramMenu)
  {
    return true;
  }
  
  public void dispatchDestroy()
  {
    this.mIsDestroyed = true;
  }
  
  public void dispatchInvalidateOptionsMenu()
  {
    if (this.mMenu != null)
    {
      Bundle localBundle = new Bundle();
      this.mMenu.saveActionViewStates(localBundle);
      if (localBundle.size() > 0) {
        this.mMenuFrozenActionViewState = localBundle;
      }
      this.mMenu.stopDispatchingItemsChanged();
      this.mMenu.clear();
    }
    this.mMenuRefreshContent = true;
    if (this.wActionBar != null)
    {
      this.mMenuIsPrepared = false;
      preparePanel();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    if (i == 4)
    {
      j = paramKeyEvent.getAction();
      if (this.mActionMode != null) {
        break label161;
      }
      if ((this.wActionBar != null) && (this.wActionBar.hasExpandedActionView())) {}
    }
    else
    {
      j = 0;
      if ((i != 82) || (!isReservingOverflow())) {
        return j;
      }
      if ((paramKeyEvent.getAction() != 0) || (!paramKeyEvent.isLongPress()))
      {
        if (paramKeyEvent.getAction() != 1) {
          return j;
        }
        if (!this.mMenuKeyIsLongPress)
        {
          if ((this.mActionMode == null) && (this.wActionBar != null)) {
            if (!this.wActionBar.isOverflowMenuShowing()) {
              this.wActionBar.showOverflowMenu();
            } else {
              this.wActionBar.hideOverflowMenu();
            }
          }
          j = 1;
        }
        this.mMenuKeyIsLongPress = false;
        return j;
      }
      this.mMenuKeyIsLongPress = true;
      return j;
    }
    if (j == 1) {
      this.wActionBar.collapseActionView();
    }
    int j = 1;
    return j;
    label161:
    if (j == 1) {
      this.mActionMode.finish();
    }
    j = 1;
    return j;
  }
  
  public boolean dispatchMenuOpened(int paramInt, android.view.Menu paramMenu)
  {
    boolean bool = true;
    if ((paramInt != 8) && (paramInt != 0)) {
      bool = false;
    } else if (this.aActionBar != null) {
      this.aActionBar.dispatchMenuVisibilityChanged(bool);
    }
    return bool;
  }
  
  public boolean dispatchOpenOptionsMenu()
  {
    boolean bool;
    if (isReservingOverflow()) {
      bool = this.wActionBar.showOverflowMenu();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean dispatchOptionsItemSelected(android.view.MenuItem paramMenuItem)
  {
    throw new IllegalStateException("Native callback invoked. Create a test case and report!");
  }
  
  public void dispatchPanelClosed(int paramInt, android.view.Menu paramMenu)
  {
    if (((paramInt == 8) || (paramInt == 0)) && (this.aActionBar != null)) {
      this.aActionBar.dispatchMenuVisibilityChanged(false);
    }
  }
  
  public void dispatchPause()
  {
    if ((this.wActionBar != null) && (this.wActionBar.isOverflowMenuShowing())) {
      this.wActionBar.hideOverflowMenu();
    }
  }
  
  public void dispatchPostCreate(Bundle paramBundle)
  {
    if (this.mIsDelegate) {
      this.mIsTitleReady = true;
    }
    if (this.mDecor == null) {
      initActionBar();
    }
  }
  
  public void dispatchPostResume()
  {
    if (this.aActionBar != null) {
      this.aActionBar.setShowHideAnimationEnabled(true);
    }
  }
  
  public boolean dispatchPrepareOptionsMenu(android.view.Menu paramMenu)
  {
    boolean bool = false;
    if (this.mActionMode == null)
    {
      this.mMenuIsPrepared = false;
      if ((preparePanel()) && (!isReservingOverflow()))
      {
        if (this.mNativeItemMap != null) {
          this.mNativeItemMap.clear();
        } else {
          this.mNativeItemMap = new HashMap();
        }
        if (this.mMenu != null) {
          bool = this.mMenu.bindNativeOverflow(paramMenu, this, this.mNativeItemMap);
        }
      }
    }
    return bool;
  }
  
  public void dispatchStop()
  {
    if (this.aActionBar != null) {
      this.aActionBar.setShowHideAnimationEnabled(false);
    }
  }
  
  public void dispatchTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    if ((!this.mIsDelegate) || (this.mIsTitleReady)) {
      if (this.mTitleView == null)
      {
        if (this.wActionBar != null) {
          this.wActionBar.setWindowTitle(paramCharSequence);
        }
      }
      else {
        this.mTitleView.setText(paramCharSequence);
      }
    }
    this.mTitle = paramCharSequence;
  }
  
  public ActionBar getActionBar()
  {
    initActionBar();
    return this.aActionBar;
  }
  
  protected Context getThemedContext()
  {
    return this.aActionBar.getThemedContext();
  }
  
  public boolean hasFeature(int paramInt)
  {
    int i = 1;
    if ((this.mFeatures & i << paramInt) == 0) {
      i = 0;
    }
    return i;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    checkCloseActionMenu(paramMenuBuilder);
  }
  
  public boolean onMenuItemClick(android.view.MenuItem paramMenuItem)
  {
    MenuItemImpl localMenuItemImpl = (MenuItemImpl)this.mNativeItemMap.get(paramMenuItem);
    if (localMenuItemImpl == null) {
      Log.e("ActionBarSherlock", "Options item \"" + paramMenuItem + "\" not found in mapping");
    } else {
      localMenuItemImpl.invoke();
    }
    return true;
  }
  
  public boolean onMenuItemSelected(int paramInt, com.actionbarsherlock.view.MenuItem paramMenuItem)
  {
    return callbackOptionsItemSelected(paramMenuItem);
  }
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, com.actionbarsherlock.view.MenuItem paramMenuItem)
  {
    return callbackOptionsItemSelected(paramMenuItem);
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    reopenMenu(true);
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    return true;
  }
  
  public boolean requestFeature(int paramInt)
  {
    int i = 1;
    if (this.mContentParent == null)
    {
      switch (paramInt)
      {
      case 3: 
      case 4: 
      case 6: 
      case 7: 
      default: 
        i = 0;
        break;
      case 1: 
      case 2: 
      case 5: 
      case 8: 
      case 9: 
      case 10: 
        this.mFeatures |= i << paramInt;
      }
      return i;
    }
    throw new AndroidRuntimeException("requestFeature() must be called before adding content");
  }
  
  public void setContentView(int paramInt)
  {
    if (this.mContentParent != null) {
      this.mContentParent.removeAllViews();
    } else {
      installDecor();
    }
    this.mActivity.getLayoutInflater().inflate(paramInt, this.mContentParent);
    android.view.Window.Callback localCallback = this.mActivity.getWindow().getCallback();
    if (localCallback != null) {
      localCallback.onContentChanged();
    }
    initActionBar();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mContentParent != null) {
      this.mContentParent.removeAllViews();
    } else {
      installDecor();
    }
    this.mContentParent.addView(paramView, paramLayoutParams);
    android.view.Window.Callback localCallback = this.mActivity.getWindow().getCallback();
    if (localCallback != null) {
      localCallback.onContentChanged();
    }
    initActionBar();
  }
  
  public void setProgress(int paramInt)
  {
    setFeatureInt(2, paramInt + 0);
  }
  
  public void setProgressBarIndeterminate(boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = -4;
    } else {
      i = -3;
    }
    setFeatureInt(2, i);
  }
  
  public void setProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = -2;
    } else {
      i = -1;
    }
    setFeatureInt(5, i);
  }
  
  public void setProgressBarVisibility(boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = -2;
    } else {
      i = -1;
    }
    setFeatureInt(2, i);
  }
  
  public void setSecondaryProgress(int paramInt)
  {
    setFeatureInt(2, paramInt + 20000);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    dispatchTitleChanged(paramCharSequence, 0);
  }
  
  public void setUiOptions(int paramInt)
  {
    this.mUiOptions = paramInt;
  }
  
  public void setUiOptions(int paramInt1, int paramInt2)
  {
    this.mUiOptions = (this.mUiOptions & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    Object localObject1 = new ActionModeCallbackWrapper(paramCallback);
    Object localObject2 = null;
    initActionBar();
    if (this.aActionBar != null) {
      localObject2 = this.aActionBar.startActionMode((ActionMode.Callback)localObject1);
    }
    if (localObject2 == null)
    {
      if (this.mActionModeView == null)
      {
        localObject2 = (ViewStub)this.mDecor.findViewById(R.id.abs__action_mode_bar_stub);
        if (localObject2 != null) {
          this.mActionModeView = ((ActionBarContextView)((ViewStub)localObject2).inflate());
        }
      }
      if (this.mActionModeView != null)
      {
        this.mActionModeView.killMode();
        localObject1 = new StandaloneActionMode(this.mActivity, this.mActionModeView, (ActionMode.Callback)localObject1, true);
        if (!paramCallback.onCreateActionMode((ActionMode)localObject1, ((ActionMode)localObject1).getMenu()))
        {
          this.mActionMode = null;
        }
        else
        {
          ((ActionMode)localObject1).invalidate();
          this.mActionModeView.initForMode((ActionMode)localObject1);
          this.mActionModeView.setVisibility(0);
          this.mActionMode = ((ActionMode)localObject1);
          this.mActionModeView.sendAccessibilityEvent(32);
        }
      }
    }
    else
    {
      this.mActionMode = ((ActionMode)localObject2);
    }
    if ((this.mActionMode != null) && ((this.mActivity instanceof ActionBarSherlock.OnActionModeStartedListener))) {
      ((ActionBarSherlock.OnActionModeStartedListener)this.mActivity).onActionModeStarted(this.mActionMode);
    }
    return this.mActionMode;
  }
  
  private class ActionModeCallbackWrapper
    implements ActionMode.Callback
  {
    private final ActionMode.Callback mWrapped;
    
    public ActionModeCallbackWrapper(ActionMode.Callback paramCallback)
    {
      this.mWrapped = paramCallback;
    }
    
    public boolean onActionItemClicked(ActionMode paramActionMode, com.actionbarsherlock.view.MenuItem paramMenuItem)
    {
      return this.mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, com.actionbarsherlock.view.Menu paramMenu)
    {
      return this.mWrapped.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      this.mWrapped.onDestroyActionMode(paramActionMode);
      if (ActionBarSherlockCompat.this.mActionModeView != null)
      {
        ActionBarSherlockCompat.this.mActionModeView.setVisibility(8);
        ActionBarSherlockCompat.this.mActionModeView.removeAllViews();
      }
      if ((ActionBarSherlockCompat.this.mActivity instanceof ActionBarSherlock.OnActionModeFinishedListener)) {
        ((ActionBarSherlock.OnActionModeFinishedListener)ActionBarSherlockCompat.this.mActivity).onActionModeFinished(ActionBarSherlockCompat.this.mActionMode);
      }
      ActionBarSherlockCompat.access$502(ActionBarSherlockCompat.this, null);
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, com.actionbarsherlock.view.Menu paramMenu)
    {
      return this.mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.ActionBarSherlockCompat
 * JD-Core Version:    0.7.0.1
 */