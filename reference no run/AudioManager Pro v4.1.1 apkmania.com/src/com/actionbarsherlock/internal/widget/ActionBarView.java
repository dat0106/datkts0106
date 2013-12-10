package com.actionbarsherlock.internal.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.actionbarsherlock.R.attr;
import com.actionbarsherlock.R.bool;
import com.actionbarsherlock.R.id;
import com.actionbarsherlock.R.layout;
import com.actionbarsherlock.R.string;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.app.ActionBar.LayoutParams;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.internal.ActionBarSherlockCompat;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.view.menu.ActionMenuItem;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.ActionMenuView;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.internal.view.menu.MenuPresenter;
import com.actionbarsherlock.internal.view.menu.MenuPresenter.Callback;
import com.actionbarsherlock.internal.view.menu.MenuView;
import com.actionbarsherlock.internal.view.menu.SubMenuBuilder;
import com.actionbarsherlock.view.CollapsibleActionView;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Window.Callback;
import java.util.List;

public class ActionBarView
  extends AbsActionBarView
{
  private static final boolean DEBUG = false;
  private static final int DEFAULT_CUSTOM_GRAVITY = 19;
  public static final int DISPLAY_DEFAULT = 0;
  private static final int DISPLAY_RELAYOUT_MASK = 31;
  private static final String TAG = "ActionBarView";
  private ActionBar.OnNavigationListener mCallback;
  private ActionBarContextView mContextView;
  private View mCustomNavView;
  private int mDisplayOptions = -1;
  View mExpandedActionView;
  private final View.OnClickListener mExpandedActionViewUpListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      MenuItemImpl localMenuItemImpl = ActionBarView.this.mExpandedMenuPresenter.mCurrentExpandedItem;
      if (localMenuItemImpl != null) {
        localMenuItemImpl.collapseActionView();
      }
    }
  };
  private HomeView mExpandedHomeLayout;
  private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
  private HomeView mHomeLayout;
  private Drawable mIcon;
  private boolean mIncludeTabs;
  private int mIndeterminateProgressStyle;
  private IcsProgressBar mIndeterminateProgressView;
  private boolean mIsCollapsable;
  private boolean mIsCollapsed;
  private int mItemPadding;
  private IcsLinearLayout mListNavLayout;
  private Drawable mLogo;
  private ActionMenuItem mLogoNavItem;
  private final IcsAdapterView.OnItemSelectedListener mNavItemSelectedListener = new IcsAdapterView.OnItemSelectedListener()
  {
    public void onItemSelected(IcsAdapterView paramAnonymousIcsAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if (ActionBarView.this.mCallback != null) {
        ActionBarView.this.mCallback.onNavigationItemSelected(paramAnonymousInt, paramAnonymousLong);
      }
    }
    
    public void onNothingSelected(IcsAdapterView paramAnonymousIcsAdapterView) {}
  };
  private int mNavigationMode;
  private MenuBuilder mOptionsMenu;
  private int mProgressBarPadding;
  private int mProgressStyle;
  private IcsProgressBar mProgressView;
  private IcsSpinner mSpinner;
  private SpinnerAdapter mSpinnerAdapter;
  private CharSequence mSubtitle;
  private int mSubtitleStyleRes;
  private TextView mSubtitleView;
  private ScrollingTabContainerView mTabScrollView;
  private CharSequence mTitle;
  private LinearLayout mTitleLayout;
  private int mTitleStyleRes;
  private View mTitleUpView;
  private TextView mTitleView;
  private final View.OnClickListener mUpClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      ActionBarView.this.mWindowCallback.onMenuItemSelected(0, ActionBarView.this.mLogoNavItem);
    }
  };
  private boolean mUserTitle;
  Window.Callback mWindowCallback;
  
  public ActionBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundResource(0);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockActionBar, R.attr.actionBarStyle, 0);
    ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    Object localObject = paramContext.getPackageManager();
    this.mNavigationMode = localTypedArray.getInt(6, 0);
    this.mTitle = localTypedArray.getText(8);
    this.mSubtitle = localTypedArray.getText(9);
    this.mLogo = localTypedArray.getDrawable(11);
    if (this.mLogo == null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        break label493;
      }
      if ((paramContext instanceof Activity))
      {
        int j = loadLogoFromManifest((Activity)paramContext);
        if (j != 0) {
          this.mLogo = paramContext.getResources().getDrawable(j);
        }
      }
    }
    for (;;)
    {
      this.mIcon = localTypedArray.getDrawable(10);
      if ((this.mIcon != null) || ((paramContext instanceof Activity))) {}
      try
      {
        this.mIcon = ((PackageManager)localObject).getActivityIcon(((Activity)paramContext).getComponentName());
        if (this.mIcon == null) {
          this.mIcon = localApplicationInfo.loadIcon((PackageManager)localObject);
        }
        localObject = LayoutInflater.from(paramContext);
        int i = localTypedArray.getResourceId(14, R.layout.abs__action_bar_home);
        this.mHomeLayout = ((HomeView)((LayoutInflater)localObject).inflate(i, this, false));
        this.mExpandedHomeLayout = ((HomeView)((LayoutInflater)localObject).inflate(i, this, false));
        this.mExpandedHomeLayout.setUp(true);
        this.mExpandedHomeLayout.setOnClickListener(this.mExpandedActionViewUpListener);
        this.mExpandedHomeLayout.setContentDescription(getResources().getText(R.string.abs__action_bar_up_description));
        this.mTitleStyleRes = localTypedArray.getResourceId(0, 0);
        this.mSubtitleStyleRes = localTypedArray.getResourceId(1, 0);
        this.mProgressStyle = localTypedArray.getResourceId(15, 0);
        this.mIndeterminateProgressStyle = localTypedArray.getResourceId(16, 0);
        this.mProgressBarPadding = localTypedArray.getDimensionPixelOffset(17, 0);
        this.mItemPadding = localTypedArray.getDimensionPixelOffset(18, 0);
        setDisplayOptions(localTypedArray.getInt(7, 0));
        i = localTypedArray.getResourceId(13, 0);
        if (i != 0)
        {
          this.mCustomNavView = ((LayoutInflater)localObject).inflate(i, this, false);
          this.mNavigationMode = 0;
          setDisplayOptions(0x10 | this.mDisplayOptions);
        }
        this.mContentHeight = localTypedArray.getLayoutDimension(4, 0);
        localTypedArray.recycle();
        this.mLogoNavItem = new ActionMenuItem(paramContext, 0, 16908332, 0, 0, this.mTitle);
        this.mHomeLayout.setOnClickListener(this.mUpClickListener);
        this.mHomeLayout.setClickable(true);
        this.mHomeLayout.setFocusable(true);
        return;
        label493:
        if ((paramContext instanceof Activity)) {}
        try
        {
          this.mLogo = ((PackageManager)localObject).getActivityLogo(((Activity)paramContext).getComponentName());
          if (this.mLogo != null) {
            continue;
          }
          this.mLogo = i.loadLogo((PackageManager)localObject);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1)
        {
          for (;;)
          {
            Log.e("ActionBarView", "Activity component name not found!", localNameNotFoundException1);
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException2)
      {
        for (;;)
        {
          Log.e("ActionBarView", "Activity component name not found!", localNameNotFoundException2);
        }
      }
    }
  }
  
  private void configPresenters(MenuBuilder paramMenuBuilder)
  {
    if (paramMenuBuilder == null)
    {
      this.mActionMenuPresenter.initForMenu(this.mContext, null);
      this.mExpandedMenuPresenter.initForMenu(this.mContext, null);
      this.mActionMenuPresenter.updateMenuView(true);
      this.mExpandedMenuPresenter.updateMenuView(true);
    }
    else
    {
      paramMenuBuilder.addMenuPresenter(this.mActionMenuPresenter);
      paramMenuBuilder.addMenuPresenter(this.mExpandedMenuPresenter);
    }
  }
  
  private void initTitle()
  {
    boolean bool = true;
    if (this.mTitleLayout == null)
    {
      this.mTitleLayout = ((LinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.abs__action_bar_title_item, this, false));
      this.mTitleView = ((TextView)this.mTitleLayout.findViewById(R.id.abs__action_bar_title));
      this.mSubtitleView = ((TextView)this.mTitleLayout.findViewById(R.id.abs__action_bar_subtitle));
      this.mTitleUpView = this.mTitleLayout.findViewById(R.id.abs__up);
      this.mTitleLayout.setOnClickListener(this.mUpClickListener);
      if (this.mTitleStyleRes != 0) {
        this.mTitleView.setTextAppearance(this.mContext, this.mTitleStyleRes);
      }
      if (this.mTitle != null) {
        this.mTitleView.setText(this.mTitle);
      }
      if (this.mSubtitleStyleRes != 0) {
        this.mSubtitleView.setTextAppearance(this.mContext, this.mSubtitleStyleRes);
      }
      if (this.mSubtitle != null)
      {
        this.mSubtitleView.setText(this.mSubtitle);
        this.mSubtitleView.setVisibility(0);
      }
      int j;
      if ((0x4 & this.mDisplayOptions) == 0) {
        j = 0;
      } else {
        j = bool;
      }
      int i;
      if ((0x2 & this.mDisplayOptions) == 0) {
        i = 0;
      } else {
        i = bool;
      }
      Object localObject = this.mTitleUpView;
      int k;
      if (i != 0) {
        k = 8;
      } else if (j == 0) {
        k = 4;
      } else {
        k = 0;
      }
      ((View)localObject).setVisibility(k);
      localObject = this.mTitleLayout;
      if ((j == 0) || (i != 0)) {
        bool = false;
      }
      ((LinearLayout)localObject).setEnabled(bool);
    }
    addView(this.mTitleLayout);
    if ((this.mExpandedActionView != null) || ((TextUtils.isEmpty(this.mTitle)) && (TextUtils.isEmpty(this.mSubtitle)))) {
      this.mTitleLayout.setVisibility(8);
    }
  }
  
  private static int loadLogoFromManifest(Activity paramActivity)
  {
    int i = 0;
    try
    {
      String str2 = paramActivity.getClass().getName();
      String str1 = paramActivity.getApplicationInfo().packageName;
      XmlResourceParser localXmlResourceParser = paramActivity.createPackageContext(str1, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
      int j = localXmlResourceParser.getEventType();
      label128:
      String str4;
      int m;
      String str5;
      if (j != 1)
      {
        int k;
        if (j == 2)
        {
          String str3 = localXmlResourceParser.getName();
          if (!"application".equals(str3)) {
            break label128;
          }
          k = -1 + localXmlResourceParser.getAttributeCount();
          if (k >= 0)
          {
            if (!"logo".equals(localXmlResourceParser.getAttributeName(k))) {
              break label278;
            }
            i = localXmlResourceParser.getAttributeResourceValue(k, 0);
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
          if ("logo".equals(str5)) {
            localInteger = Integer.valueOf(localXmlResourceParser.getAttributeResourceValue(n, 0));
          }
        }
      }
      for (;;)
      {
        if ((localInteger == null) || (str4 == null)) {
          break label284;
        }
        i = localInteger.intValue();
        break label284;
        if ("name".equals(str5))
        {
          str4 = ActionBarSherlockCompat.cleanActivityName(str1, localXmlResourceParser.getAttributeValue(n));
          boolean bool = str2.equals(str4);
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
        Integer localInteger;
        int n;
        localException.printStackTrace();
        continue;
        label278:
        localInteger--;
        continue;
        label284:
        n--;
      }
    }
  }
  
  private void setTitleImpl(CharSequence paramCharSequence)
  {
    int j = 0;
    this.mTitle = paramCharSequence;
    if (this.mTitleView != null)
    {
      this.mTitleView.setText(paramCharSequence);
      int i;
      if ((this.mExpandedActionView != null) || ((0x8 & this.mDisplayOptions) == 0) || ((TextUtils.isEmpty(this.mTitle)) && (TextUtils.isEmpty(this.mSubtitle)))) {
        i = 0;
      } else {
        i = 1;
      }
      LinearLayout localLinearLayout = this.mTitleLayout;
      if (i == 0) {
        j = 8;
      }
      localLinearLayout.setVisibility(j);
    }
    if (this.mLogoNavItem != null) {
      this.mLogoNavItem.setTitle(paramCharSequence);
    }
  }
  
  public void collapseActionView()
  {
    MenuItemImpl localMenuItemImpl;
    if (this.mExpandedMenuPresenter != null) {
      localMenuItemImpl = this.mExpandedMenuPresenter.mCurrentExpandedItem;
    } else {
      localMenuItemImpl = null;
    }
    if (localMenuItemImpl != null) {
      localMenuItemImpl.collapseActionView();
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ActionBar.LayoutParams(19);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ActionBar.LayoutParams(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams == null) {
      paramLayoutParams = generateDefaultLayoutParams();
    }
    return paramLayoutParams;
  }
  
  public View getCustomNavigationView()
  {
    return this.mCustomNavView;
  }
  
  public int getDisplayOptions()
  {
    return this.mDisplayOptions;
  }
  
  public SpinnerAdapter getDropdownAdapter()
  {
    return this.mSpinnerAdapter;
  }
  
  public int getDropdownSelectedPosition()
  {
    return this.mSpinner.getSelectedItemPosition();
  }
  
  public int getNavigationMode()
  {
    return this.mNavigationMode;
  }
  
  public CharSequence getSubtitle()
  {
    return this.mSubtitle;
  }
  
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public boolean hasEmbeddedTabs()
  {
    return this.mIncludeTabs;
  }
  
  public boolean hasExpandedActionView()
  {
    boolean bool;
    if ((this.mExpandedMenuPresenter == null) || (this.mExpandedMenuPresenter.mCurrentExpandedItem == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void initIndeterminateProgress()
  {
    this.mIndeterminateProgressView = new IcsProgressBar(this.mContext, null, 0, this.mIndeterminateProgressStyle);
    this.mIndeterminateProgressView.setId(R.id.abs__progress_circular);
    addView(this.mIndeterminateProgressView);
  }
  
  public void initProgress()
  {
    this.mProgressView = new IcsProgressBar(this.mContext, null, 0, this.mProgressStyle);
    this.mProgressView.setId(R.id.abs__progress_horizontal);
    this.mProgressView.setMax(10000);
    addView(this.mProgressView);
  }
  
  public boolean isCollapsed()
  {
    return this.mIsCollapsed;
  }
  
  public boolean isSplitActionBar()
  {
    return this.mSplitActionBar;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mTitleView = null;
    this.mSubtitleView = null;
    this.mTitleUpView = null;
    if ((this.mTitleLayout != null) && (this.mTitleLayout.getParent() == this)) {
      removeView(this.mTitleLayout);
    }
    this.mTitleLayout = null;
    if ((0x8 & this.mDisplayOptions) != 0) {
      initTitle();
    }
    if ((this.mTabScrollView != null) && (this.mIncludeTabs))
    {
      ViewGroup.LayoutParams localLayoutParams = this.mTabScrollView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = -2;
        localLayoutParams.height = -1;
      }
      this.mTabScrollView.setAllowCollapse(true);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mActionMenuPresenter != null)
    {
      this.mActionMenuPresenter.hideOverflowMenu();
      this.mActionMenuPresenter.hideSubMenus();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    addView(this.mHomeLayout);
    if ((this.mCustomNavView != null) && ((0x10 & this.mDisplayOptions) != 0))
    {
      ViewParent localViewParent = this.mCustomNavView.getParent();
      if (localViewParent != this)
      {
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(this.mCustomNavView);
        }
        addView(this.mCustomNavView);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    if (k > 0)
    {
      HomeView localHomeView;
      if (this.mExpandedActionView == null) {
        localHomeView = this.mHomeLayout;
      } else {
        localHomeView = this.mExpandedHomeLayout;
      }
      if (localHomeView.getVisibility() != 8)
      {
        n = localHomeView.getLeftOffset();
        i += n + positionChild(localHomeView, i + n, j, k);
      }
      if (this.mExpandedActionView == null)
      {
        if ((this.mTitleLayout == null) || (this.mTitleLayout.getVisibility() == 8) || ((0x8 & this.mDisplayOptions) == 0)) {
          n = 0;
        } else {
          n = 1;
        }
        if (n != 0) {
          i += positionChild(this.mTitleLayout, i, j, k);
        }
        switch (this.mNavigationMode)
        {
        case 1: 
          if (this.mListNavLayout != null)
          {
            if (n != 0) {
              i += this.mItemPadding;
            }
            i += positionChild(this.mListNavLayout, i, j, k) + this.mItemPadding;
          }
          break;
        case 2: 
          if (this.mTabScrollView != null)
          {
            if (n != 0) {
              i += this.mItemPadding;
            }
            i += positionChild(this.mTabScrollView, i, j, k) + this.mItemPadding;
          }
          break;
        }
      }
      int n = paramInt3 - paramInt1 - getPaddingRight();
      if ((this.mMenuView != null) && (this.mMenuView.getParent() == this))
      {
        positionChildInverse(this.mMenuView, n, j, k);
        n -= this.mMenuView.getMeasuredWidth();
      }
      if ((this.mIndeterminateProgressView != null) && (this.mIndeterminateProgressView.getVisibility() != 8))
      {
        positionChildInverse(this.mIndeterminateProgressView, n, j, k);
        n -= this.mIndeterminateProgressView.getMeasuredWidth();
      }
      View localView = null;
      if (this.mExpandedActionView == null)
      {
        if (((0x10 & this.mDisplayOptions) != 0) && (this.mCustomNavView != null)) {
          localView = this.mCustomNavView;
        }
      }
      else {
        localView = this.mExpandedActionView;
      }
      if (localView != null)
      {
        Object localObject = localView.getLayoutParams();
        if (!(localObject instanceof ActionBar.LayoutParams)) {
          localObject = null;
        } else {
          localObject = (ActionBar.LayoutParams)localObject;
        }
        if (localObject == null) {
          i3 = 19;
        } else {
          i3 = ((ActionBar.LayoutParams)localObject).gravity;
        }
        int i4 = localView.getMeasuredWidth();
        int i1 = 0;
        int i2 = 0;
        if (localObject != null)
        {
          i += ((ActionBar.LayoutParams)localObject).leftMargin;
          n -= ((ActionBar.LayoutParams)localObject).rightMargin;
          i1 = ((ActionBar.LayoutParams)localObject).topMargin;
          i2 = ((ActionBar.LayoutParams)localObject).bottomMargin;
        }
        int i5 = i3 & 0x7;
        if (i5 != 1)
        {
          if (i3 == -1) {
            i5 = 3;
          }
        }
        else
        {
          m = (getRight() - getLeft() - i4) / 2;
          if (m >= i)
          {
            if (m + i4 > n) {
              i5 = 5;
            }
          }
          else {
            i5 = 3;
          }
        }
        int m = 0;
        switch (i5)
        {
        case 1: 
          m = (getRight() - getLeft() - i4) / 2;
          break;
        case 3: 
          m = i;
          break;
        case 5: 
          m = n - i4;
        }
        i4 = i3 & 0x70;
        if (i3 == -1) {
          i4 = 16;
        }
        n = 0;
        switch (i4)
        {
        case 16: 
          n = getPaddingTop();
          n = (getBottom() - getTop() - getPaddingBottom() - n - localView.getMeasuredHeight()) / 2;
          break;
        case 48: 
          n = i1 + getPaddingTop();
          break;
        case 80: 
          n = getHeight() - getPaddingBottom() - localView.getMeasuredHeight() - i2;
        }
        i1 = localView.getMeasuredWidth();
        i2 = m + i1;
        int i3 = n + localView.getMeasuredHeight();
        localView.layout(m, n, i2, i3);
        (i + i1);
      }
      if (this.mProgressView != null)
      {
        this.mProgressView.bringToFront();
        i = this.mProgressView.getMeasuredHeight() / 2;
        this.mProgressView.layout(this.mProgressBarPadding, -i, this.mProgressBarPadding + this.mProgressView.getMeasuredWidth(), i);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    int m;
    if (this.mIsCollapsable) {
      m = 0;
    }
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        if (m != 0)
        {
          this.mIsCollapsed = false;
          if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
          {
            if (View.MeasureSpec.getMode(paramInt2) == -2147483648)
            {
              j = View.MeasureSpec.getSize(paramInt1);
              if (this.mContentHeight <= 0) {
                m = View.MeasureSpec.getSize(paramInt2);
              } else {
                m = this.mContentHeight;
              }
              int k = getPaddingTop() + getPaddingBottom();
              int n = getPaddingLeft();
              int i1 = getPaddingRight();
              int i2 = m - k;
              int i3 = View.MeasureSpec.makeMeasureSpec(i2, -2147483648);
              i1 = j - n - i1;
              int i4 = i1 / 2;
              n = i4;
              HomeView localHomeView;
              if (this.mExpandedActionView == null) {
                localHomeView = this.mHomeLayout;
              } else {
                localHomeView = this.mExpandedHomeLayout;
              }
              int i5;
              int i7;
              if (localHomeView.getVisibility() != 8)
              {
                ViewGroup.LayoutParams localLayoutParams1 = localHomeView.getLayoutParams();
                if (localLayoutParams1.width >= 0) {
                  i5 = View.MeasureSpec.makeMeasureSpec(localLayoutParams1.width, 1073741824);
                } else {
                  i5 = View.MeasureSpec.makeMeasureSpec(i1, -2147483648);
                }
                i7 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
                localHomeView.measure(i5, i7);
                i5 = localHomeView.getMeasuredWidth() + localHomeView.getLeftOffset();
                i1 = Math.max(0, i1 - i5);
                i5 = Math.max(0, i1 - i5);
              }
              if ((this.mMenuView != null) && (this.mMenuView.getParent() == this))
              {
                i1 = measureChildView(this.mMenuView, i1, i3, 0);
                n = Math.max(0, n - this.mMenuView.getMeasuredWidth());
              }
              if ((this.mIndeterminateProgressView != null) && (this.mIndeterminateProgressView.getVisibility() != 8))
              {
                i1 = measureChildView(this.mIndeterminateProgressView, i1, i3, 0);
                n = Math.max(0, n - this.mIndeterminateProgressView.getMeasuredWidth());
              }
              if ((this.mTitleLayout == null) || (this.mTitleLayout.getVisibility() == 8) || ((0x8 & this.mDisplayOptions) == 0)) {
                i3 = 0;
              } else {
                i3 = 1;
              }
              if (this.mExpandedActionView == null)
              {
                int i6;
                switch (this.mNavigationMode)
                {
                case 1: 
                  if (this.mListNavLayout != null)
                  {
                    if (i3 == 0) {
                      i6 = this.mItemPadding;
                    } else {
                      i6 = 2 * this.mItemPadding;
                    }
                    i1 = Math.max(0, i1 - i6);
                    i6 = Math.max(0, i5 - i6);
                    this.mListNavLayout.measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
                    i5 = this.mListNavLayout.getMeasuredWidth();
                    i1 = Math.max(0, i1 - i5);
                    i5 = Math.max(0, i6 - i5);
                  }
                  break;
                case 2: 
                  if (this.mTabScrollView != null)
                  {
                    if (i3 == 0) {
                      i6 = this.mItemPadding;
                    } else {
                      i6 = 2 * this.mItemPadding;
                    }
                    i1 = Math.max(0, i1 - i6);
                    i6 = Math.max(0, i5 - i6);
                    this.mTabScrollView.measure(View.MeasureSpec.makeMeasureSpec(i1, -2147483648), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
                    i5 = this.mTabScrollView.getMeasuredWidth();
                    i1 = Math.max(0, i1 - i5);
                    i5 = Math.max(0, i6 - i5);
                  }
                  break;
                }
              }
              View localView2 = null;
              if (this.mExpandedActionView == null)
              {
                if (((0x10 & this.mDisplayOptions) != 0) && (this.mCustomNavView != null)) {
                  localView2 = this.mCustomNavView;
                }
              }
              else {
                localView2 = this.mExpandedActionView;
              }
              if (localView2 != null)
              {
                ViewGroup.LayoutParams localLayoutParams2 = generateLayoutParams(localView2.getLayoutParams());
                ActionBar.LayoutParams localLayoutParams;
                if (!(localLayoutParams2 instanceof ActionBar.LayoutParams)) {
                  localLayoutParams = null;
                } else {
                  localLayoutParams = (ActionBar.LayoutParams)localLayoutParams2;
                }
                int i8 = 0;
                int i10 = 0;
                if (localLayoutParams != null)
                {
                  i8 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
                  i10 = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
                }
                if (this.mContentHeight > 0)
                {
                  if (localLayoutParams2.height == -2) {
                    i7 = -2147483648;
                  } else {
                    i7 = 1073741824;
                  }
                }
                else {
                  i7 = -2147483648;
                }
                if (localLayoutParams2.height >= 0) {
                  i2 = Math.min(localLayoutParams2.height, i2);
                }
                i2 = Math.max(0, i2 - i10);
                if (localLayoutParams2.width == -2) {
                  i10 = -2147483648;
                } else {
                  i10 = 1073741824;
                }
                if (localLayoutParams2.width < 0) {
                  i11 = i1;
                } else {
                  i11 = Math.min(localLayoutParams2.width, i1);
                }
                int i11 = Math.max(0, i11 - i8);
                int i9;
                if (localLayoutParams == null) {
                  i9 = 19;
                } else {
                  i9 = i9.gravity;
                }
                if (((i9 & 0x7) == 1) && (localLayoutParams2.width == -1)) {
                  i11 = 2 * Math.min(i5, n);
                }
                localView2.measure(View.MeasureSpec.makeMeasureSpec(i11, i10), View.MeasureSpec.makeMeasureSpec(i2, i7));
                i1 -= i8 + localView2.getMeasuredWidth();
              }
              if ((this.mExpandedActionView == null) && (i3 != 0))
              {
                measureChildView(this.mTitleLayout, i1, View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824), 0);
                Math.max(0, i5 - this.mTitleLayout.getMeasuredWidth());
              }
              if (this.mContentHeight > 0) {
                setMeasuredDimension(j, m);
              } else {
                m = 0;
              }
              for (i1 = 0;; i1++)
              {
                if (i1 >= i)
                {
                  setMeasuredDimension(j, m);
                  if (this.mContextView != null) {
                    this.mContextView.setContentHeight(getMeasuredHeight());
                  }
                  if ((this.mProgressView == null) || (this.mProgressView.getVisibility() == 8)) {
                    break;
                  }
                  this.mProgressView.measure(View.MeasureSpec.makeMeasureSpec(j - 2 * this.mProgressBarPadding, 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), -2147483648));
                  break;
                }
                n = k + getChildAt(i1).getMeasuredHeight();
                if (n > m) {
                  m = n;
                }
              }
            }
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
          }
          throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        setMeasuredDimension(0, 0);
        this.mIsCollapsed = true;
        return;
      }
      View localView1 = getChildAt(j);
      if ((localView1.getVisibility() != 8) && ((localView1 != this.mMenuView) || (this.mMenuView.getChildCount() != 0))) {
        m++;
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if ((localSavedState.expandedMenuItemId != 0) && (this.mExpandedMenuPresenter != null) && (this.mOptionsMenu != null))
    {
      MenuItem localMenuItem = this.mOptionsMenu.findItem(localSavedState.expandedMenuItemId);
      if (localMenuItem != null) {
        localMenuItem.expandActionView();
      }
    }
    if (localSavedState.isOverflowOpen) {
      postShowOverflowMenu();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.mExpandedMenuPresenter != null) && (this.mExpandedMenuPresenter.mCurrentExpandedItem != null)) {
      localSavedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
    }
    localSavedState.isOverflowOpen = isOverflowMenuShowing();
    return localSavedState;
  }
  
  public void setCallback(ActionBar.OnNavigationListener paramOnNavigationListener)
  {
    this.mCallback = paramOnNavigationListener;
  }
  
  public void setCollapsable(boolean paramBoolean)
  {
    this.mIsCollapsable = paramBoolean;
  }
  
  public void setContextView(ActionBarContextView paramActionBarContextView)
  {
    this.mContextView = paramActionBarContextView;
  }
  
  public void setCustomNavigationView(View paramView)
  {
    int i;
    if ((0x10 & this.mDisplayOptions) == 0) {
      i = 0;
    } else {
      i = 1;
    }
    if ((this.mCustomNavView != null) && (i != 0)) {
      removeView(this.mCustomNavView);
    }
    this.mCustomNavView = paramView;
    if ((this.mCustomNavView != null) && (i != 0)) {
      addView(this.mCustomNavView);
    }
  }
  
  public void setDisplayOptions(int paramInt)
  {
    int m = 8;
    int i = -1;
    int k = 1;
    if (this.mDisplayOptions != i) {
      i = paramInt ^ this.mDisplayOptions;
    }
    this.mDisplayOptions = paramInt;
    if ((i & 0x1F) == 0)
    {
      invalidate();
    }
    else
    {
      int j;
      if ((paramInt & 0x2) == 0) {
        j = 0;
      } else {
        j = k;
      }
      int n;
      if ((j == 0) || (this.mExpandedActionView != null)) {
        n = m;
      } else {
        n = 0;
      }
      this.mHomeLayout.setVisibility(n);
      if ((i & 0x4) != 0)
      {
        if ((paramInt & 0x4) == 0) {
          n = 0;
        } else {
          n = k;
        }
        this.mHomeLayout.setUp(n);
        if (n != 0) {
          setHomeButtonEnabled(k);
        }
      }
      Object localObject;
      if ((i & 0x1) != 0)
      {
        int i2;
        if ((this.mLogo == null) || ((paramInt & 0x1) == 0)) {
          i2 = 0;
        } else {
          i2 = k;
        }
        HomeView localHomeView = this.mHomeLayout;
        if (i2 == 0) {
          localObject = this.mIcon;
        } else {
          localObject = this.mLogo;
        }
        localHomeView.setIcon((Drawable)localObject);
      }
      if ((i & 0x8) != 0) {
        if ((paramInt & 0x8) == 0) {
          removeView(this.mTitleLayout);
        } else {
          initTitle();
        }
      }
      if ((this.mTitleLayout != null) && ((i & 0x6) != 0))
      {
        int i1;
        if ((0x4 & this.mDisplayOptions) == 0) {
          i1 = 0;
        } else {
          i1 = k;
        }
        localObject = this.mTitleUpView;
        if (j == 0) {
          if (i1 == 0) {
            m = 4;
          } else {
            m = 0;
          }
        }
        ((View)localObject).setVisibility(m);
        LinearLayout localLinearLayout = this.mTitleLayout;
        if ((j != 0) || (i1 == 0)) {
          k = 0;
        }
        localLinearLayout.setEnabled(k);
      }
      if (((i & 0x10) != 0) && (this.mCustomNavView != null)) {
        if ((paramInt & 0x10) == 0) {
          removeView(this.mCustomNavView);
        } else {
          addView(this.mCustomNavView);
        }
      }
      requestLayout();
    }
    if (this.mHomeLayout.isEnabled())
    {
      if ((paramInt & 0x4) == 0) {
        this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(R.string.abs__action_bar_home_description));
      } else {
        this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(R.string.abs__action_bar_up_description));
      }
    }
    else {
      this.mHomeLayout.setContentDescription(null);
    }
  }
  
  public void setDropdownAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    this.mSpinnerAdapter = paramSpinnerAdapter;
    if (this.mSpinner != null) {
      this.mSpinner.setAdapter(paramSpinnerAdapter);
    }
  }
  
  public void setDropdownSelectedPosition(int paramInt)
  {
    this.mSpinner.setSelection(paramInt);
  }
  
  public void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if (this.mTabScrollView != null) {
      removeView(this.mTabScrollView);
    }
    this.mTabScrollView = paramScrollingTabContainerView;
    boolean bool;
    if (paramScrollingTabContainerView == null) {
      bool = false;
    } else {
      bool = true;
    }
    this.mIncludeTabs = bool;
    if ((this.mIncludeTabs) && (this.mNavigationMode == 2))
    {
      addView(this.mTabScrollView);
      ViewGroup.LayoutParams localLayoutParams = this.mTabScrollView.getLayoutParams();
      localLayoutParams.width = -2;
      localLayoutParams.height = -1;
      paramScrollingTabContainerView.setAllowCollapse(true);
    }
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean)
  {
    this.mHomeLayout.setEnabled(paramBoolean);
    this.mHomeLayout.setFocusable(paramBoolean);
    if (paramBoolean)
    {
      if ((0x4 & this.mDisplayOptions) == 0) {
        this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(R.string.abs__action_bar_home_description));
      } else {
        this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(R.string.abs__action_bar_up_description));
      }
    }
    else {
      this.mHomeLayout.setContentDescription(null);
    }
  }
  
  public void setIcon(int paramInt)
  {
    setIcon(this.mContext.getResources().getDrawable(paramInt));
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mIcon = paramDrawable;
    if ((paramDrawable != null) && (((0x1 & this.mDisplayOptions) == 0) || (this.mLogo == null))) {
      this.mHomeLayout.setIcon(paramDrawable);
    }
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(this.mContext.getResources().getDrawable(paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    this.mLogo = paramDrawable;
    if ((paramDrawable != null) && ((0x1 & this.mDisplayOptions) != 0)) {
      this.mHomeLayout.setIcon(paramDrawable);
    }
  }
  
  public void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback)
  {
    if (paramMenu != this.mOptionsMenu)
    {
      if (this.mOptionsMenu != null)
      {
        this.mOptionsMenu.removeMenuPresenter(this.mActionMenuPresenter);
        this.mOptionsMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
      }
      Object localObject2 = (MenuBuilder)paramMenu;
      this.mOptionsMenu = ((MenuBuilder)localObject2);
      if (this.mMenuView != null)
      {
        localObject1 = (ViewGroup)this.mMenuView.getParent();
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView(this.mMenuView);
        }
      }
      if (this.mActionMenuPresenter == null)
      {
        this.mActionMenuPresenter = new ActionMenuPresenter(this.mContext);
        this.mActionMenuPresenter.setCallback(paramCallback);
        this.mActionMenuPresenter.setId(R.id.abs__action_menu_presenter);
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(null);
      }
      Object localObject1 = new ViewGroup.LayoutParams(-2, -1);
      ViewGroup localViewGroup;
      if (this.mSplitActionBar)
      {
        this.mActionMenuPresenter.setExpandedActionViewsExclusive(false);
        this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
        this.mActionMenuPresenter.setItemLimit(2147483647);
        ((ViewGroup.LayoutParams)localObject1).width = -1;
        configPresenters((MenuBuilder)localObject2);
        localObject2 = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
        if (this.mSplitView == null)
        {
          ((ActionMenuView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        else
        {
          localViewGroup = (ViewGroup)((ActionMenuView)localObject2).getParent();
          if ((localViewGroup != null) && (localViewGroup != this.mSplitView)) {
            localViewGroup.removeView((View)localObject2);
          }
          ((ActionMenuView)localObject2).setVisibility(getAnimatedVisibility());
          this.mSplitView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        }
      }
      else
      {
        this.mActionMenuPresenter.setExpandedActionViewsExclusive(ResourcesCompat.getResources_getBoolean(getContext(), R.bool.abs__action_bar_expanded_action_views_exclusive));
        configPresenters((MenuBuilder)localObject2);
        localObject2 = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
        localViewGroup = (ViewGroup)((ActionMenuView)localObject2).getParent();
        if ((localViewGroup != null) && (localViewGroup != this)) {
          localViewGroup.removeView((View)localObject2);
        }
        addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      }
      this.mMenuView = ((ActionMenuView)localObject2);
    }
  }
  
  public void setNavigationMode(int paramInt)
  {
    int i = this.mNavigationMode;
    if (paramInt != i)
    {
      switch (i)
      {
      case 1: 
        if (this.mListNavLayout != null) {
          removeView(this.mListNavLayout);
        }
        break;
      case 2: 
        if ((this.mTabScrollView != null) && (this.mIncludeTabs)) {
          removeView(this.mTabScrollView);
        }
        break;
      }
      switch (paramInt)
      {
      case 1: 
        if (this.mSpinner == null)
        {
          this.mSpinner = new IcsSpinner(this.mContext, null, R.attr.actionDropDownStyle);
          this.mListNavLayout = ((IcsLinearLayout)LayoutInflater.from(this.mContext).inflate(R.layout.abs__action_bar_tab_bar_view, null));
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
          localLayoutParams.gravity = 17;
          this.mListNavLayout.addView(this.mSpinner, localLayoutParams);
        }
        if (this.mSpinner.getAdapter() != this.mSpinnerAdapter) {
          this.mSpinner.setAdapter(this.mSpinnerAdapter);
        }
        this.mSpinner.setOnItemSelectedListener(this.mNavItemSelectedListener);
        addView(this.mListNavLayout);
        break;
      case 2: 
        if ((this.mTabScrollView != null) && (this.mIncludeTabs)) {
          addView(this.mTabScrollView);
        }
        break;
      }
      this.mNavigationMode = paramInt;
      requestLayout();
    }
  }
  
  public void setSplitActionBar(boolean paramBoolean)
  {
    if (this.mSplitActionBar != paramBoolean)
    {
      if (this.mMenuView != null)
      {
        ViewGroup localViewGroup = (ViewGroup)this.mMenuView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(this.mMenuView);
        }
        if (!paramBoolean) {
          addView(this.mMenuView);
        } else if (this.mSplitView != null) {
          this.mSplitView.addView(this.mMenuView);
        }
      }
      if (this.mSplitView != null)
      {
        ActionBarContainer localActionBarContainer = this.mSplitView;
        int i;
        if (!paramBoolean) {
          i = 8;
        } else {
          i = 0;
        }
        localActionBarContainer.setVisibility(i);
      }
      super.setSplitActionBar(paramBoolean);
    }
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    int i = 0;
    this.mSubtitle = paramCharSequence;
    if (this.mSubtitleView != null)
    {
      this.mSubtitleView.setText(paramCharSequence);
      TextView localTextView = this.mSubtitleView;
      int k;
      if (paramCharSequence == null) {
        k = 8;
      } else {
        k = 0;
      }
      localTextView.setVisibility(k);
      int j;
      if ((this.mExpandedActionView != null) || ((0x8 & this.mDisplayOptions) == 0) || ((TextUtils.isEmpty(this.mTitle)) && (TextUtils.isEmpty(this.mSubtitle)))) {
        j = 0;
      } else {
        j = 1;
      }
      LinearLayout localLinearLayout = this.mTitleLayout;
      if (j == 0) {
        i = 8;
      }
      localLinearLayout.setVisibility(i);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mUserTitle = true;
    setTitleImpl(paramCharSequence);
  }
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    this.mWindowCallback = paramCallback;
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    if (!this.mUserTitle) {
      setTitleImpl(paramCharSequence);
    }
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  private class ExpandedActionViewMenuPresenter
    implements MenuPresenter
  {
    MenuItemImpl mCurrentExpandedItem;
    MenuBuilder mMenu;
    
    private ExpandedActionViewMenuPresenter() {}
    
    public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
    {
      if ((ActionBarView.this.mExpandedActionView instanceof CollapsibleActionView)) {
        ((CollapsibleActionView)ActionBarView.this.mExpandedActionView).onActionViewCollapsed();
      }
      ActionBarView.this.removeView(ActionBarView.this.mExpandedActionView);
      ActionBarView.this.removeView(ActionBarView.this.mExpandedHomeLayout);
      ActionBarView.this.mExpandedActionView = null;
      if ((0x2 & ActionBarView.this.mDisplayOptions) != 0) {
        ActionBarView.this.mHomeLayout.setVisibility(0);
      }
      if ((0x8 & ActionBarView.this.mDisplayOptions) != 0) {
        if (ActionBarView.this.mTitleLayout != null) {
          ActionBarView.this.mTitleLayout.setVisibility(0);
        } else {
          ActionBarView.this.initTitle();
        }
      }
      if ((ActionBarView.this.mTabScrollView != null) && (ActionBarView.this.mNavigationMode == 2)) {
        ActionBarView.this.mTabScrollView.setVisibility(0);
      }
      if ((ActionBarView.this.mSpinner != null) && (ActionBarView.this.mNavigationMode == 1)) {
        ActionBarView.this.mSpinner.setVisibility(0);
      }
      if ((ActionBarView.this.mCustomNavView != null) && ((0x10 & ActionBarView.this.mDisplayOptions) != 0)) {
        ActionBarView.this.mCustomNavView.setVisibility(0);
      }
      ActionBarView.this.mExpandedHomeLayout.setIcon(null);
      this.mCurrentExpandedItem = null;
      ActionBarView.this.requestLayout();
      paramMenuItemImpl.setActionViewExpanded(false);
      return true;
    }
    
    public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
    {
      ActionBarView.this.mExpandedActionView = paramMenuItemImpl.getActionView();
      ActionBarView.this.mExpandedHomeLayout.setIcon(ActionBarView.this.mIcon.getConstantState().newDrawable());
      this.mCurrentExpandedItem = paramMenuItemImpl;
      if (ActionBarView.this.mExpandedActionView.getParent() != ActionBarView.this) {
        ActionBarView.this.addView(ActionBarView.this.mExpandedActionView);
      }
      if (ActionBarView.this.mExpandedHomeLayout.getParent() != ActionBarView.this) {
        ActionBarView.this.addView(ActionBarView.this.mExpandedHomeLayout);
      }
      ActionBarView.this.mHomeLayout.setVisibility(8);
      if (ActionBarView.this.mTitleLayout != null) {
        ActionBarView.this.mTitleLayout.setVisibility(8);
      }
      if (ActionBarView.this.mTabScrollView != null) {
        ActionBarView.this.mTabScrollView.setVisibility(8);
      }
      if (ActionBarView.this.mSpinner != null) {
        ActionBarView.this.mSpinner.setVisibility(8);
      }
      if (ActionBarView.this.mCustomNavView != null) {
        ActionBarView.this.mCustomNavView.setVisibility(8);
      }
      ActionBarView.this.requestLayout();
      paramMenuItemImpl.setActionViewExpanded(true);
      if ((ActionBarView.this.mExpandedActionView instanceof CollapsibleActionView)) {
        ((CollapsibleActionView)ActionBarView.this.mExpandedActionView).onActionViewExpanded();
      }
      return true;
    }
    
    public boolean flagActionItems()
    {
      return false;
    }
    
    public int getId()
    {
      return 0;
    }
    
    public MenuView getMenuView(ViewGroup paramViewGroup)
    {
      return null;
    }
    
    public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
    {
      if ((this.mMenu != null) && (this.mCurrentExpandedItem != null)) {
        this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
      }
      this.mMenu = paramMenuBuilder;
    }
    
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
    {
      return false;
    }
    
    public void setCallback(MenuPresenter.Callback paramCallback) {}
    
    public void updateMenuView(boolean paramBoolean)
    {
      if (this.mCurrentExpandedItem != null)
      {
        int k = 0;
        if (this.mMenu != null)
        {
          int i = this.mMenu.size();
          int j = 0;
          while (j < i) {
            if (this.mMenu.getItem(j) != this.mCurrentExpandedItem) {
              j++;
            } else {
              k = 1;
            }
          }
        }
        if (k == 0) {
          collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
        }
      }
    }
  }
  
  public static class HomeView
    extends FrameLayout
  {
    private ImageView mIconView;
    private View mUpView;
    private int mUpWidth;
    
    public HomeView(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public HomeView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
    {
      return onHoverEvent(paramMotionEvent);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      onPopulateAccessibilityEvent(paramAccessibilityEvent);
      return true;
    }
    
    public int getLeftOffset()
    {
      int i;
      if (this.mUpView.getVisibility() != 8) {
        i = 0;
      } else {
        i = this.mUpWidth;
      }
      return i;
    }
    
    protected void onFinishInflate()
    {
      this.mUpView = findViewById(R.id.abs__up);
      this.mIconView = ((ImageView)findViewById(R.id.abs__home));
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = (paramInt4 - paramInt2) / 2;
      int n = 0;
      if (this.mUpView.getVisibility() != 8)
      {
        FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.mUpView.getLayoutParams();
        j = this.mUpView.getMeasuredHeight();
        int m = this.mUpView.getMeasuredWidth();
        n = i - j / 2;
        this.mUpView.layout(0, n, m, n + j);
        n = m + localLayoutParams1.leftMargin + localLayoutParams1.rightMargin;
        paramInt1 += n;
      }
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.mIconView.getLayoutParams();
      int k = this.mIconView.getMeasuredHeight();
      int j = this.mIconView.getMeasuredWidth();
      int i1 = (paramInt3 - paramInt1) / 2;
      n += Math.max(localLayoutParams2.leftMargin, i1 - j / 2);
      i = Math.max(localLayoutParams2.topMargin, i - k / 2);
      this.mIconView.layout(n, i, n + j, i + k);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      measureChildWithMargins(this.mUpView, paramInt1, 0, paramInt2, 0);
      FrameLayout.LayoutParams localLayoutParams1 = (FrameLayout.LayoutParams)this.mUpView.getLayoutParams();
      this.mUpWidth = (localLayoutParams1.leftMargin + this.mUpView.getMeasuredWidth() + localLayoutParams1.rightMargin);
      int i;
      if (this.mUpView.getVisibility() != 8) {
        i = this.mUpWidth;
      } else {
        i = 0;
      }
      int j = localLayoutParams1.topMargin + this.mUpView.getMeasuredHeight() + localLayoutParams1.bottomMargin;
      measureChildWithMargins(this.mIconView, paramInt1, i, paramInt2, 0);
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.mIconView.getLayoutParams();
      i += localLayoutParams2.leftMargin + this.mIconView.getMeasuredWidth() + localLayoutParams2.rightMargin;
      int i1 = Math.max(j, localLayoutParams2.topMargin + this.mIconView.getMeasuredHeight() + localLayoutParams2.bottomMargin);
      j = View.MeasureSpec.getMode(paramInt1);
      int m = View.MeasureSpec.getMode(paramInt2);
      int k = View.MeasureSpec.getSize(paramInt1);
      int n = View.MeasureSpec.getSize(paramInt2);
      switch (j)
      {
      case -2147483648: 
        i = Math.min(i, k);
        break;
      case 1073741824: 
        i = k;
      }
      switch (m)
      {
      case -2147483648: 
        i1 = Math.min(i1, n);
        break;
      case 1073741824: 
        i1 = n;
      }
      setMeasuredDimension(i, i1);
    }
    
    public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      if (Build.VERSION.SDK_INT >= 14) {
        super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
      }
      CharSequence localCharSequence = getContentDescription();
      if (!TextUtils.isEmpty(localCharSequence)) {
        paramAccessibilityEvent.getText().add(localCharSequence);
      }
    }
    
    public void setIcon(Drawable paramDrawable)
    {
      this.mIconView.setImageDrawable(paramDrawable);
    }
    
    public void setUp(boolean paramBoolean)
    {
      View localView = this.mUpView;
      int i;
      if (!paramBoolean) {
        i = 8;
      } else {
        i = 0;
      }
      localView.setVisibility(i);
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ActionBarView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ActionBarView.SavedState(paramAnonymousParcel, null);
      }
      
      public ActionBarView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ActionBarView.SavedState[paramAnonymousInt];
      }
    };
    int expandedMenuItemId;
    boolean isOverflowOpen;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.expandedMenuItemId = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readInt() == 0) {
        bool = false;
      } else {
        bool = true;
      }
      this.isOverflowOpen = bool;
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.expandedMenuItemId);
      int i;
      if (!this.isOverflowOpen) {
        i = 0;
      } else {
        i = 1;
      }
      paramParcel.writeInt(i);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.ActionBarView
 * JD-Core Version:    0.7.0.1
 */