package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import com.actionbarsherlock.R.attr;
import com.actionbarsherlock.R.integer;
import com.actionbarsherlock.R.layout;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.internal.view.View_HasStateListenerSupport;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import com.actionbarsherlock.view.ActionProvider;
import com.actionbarsherlock.view.ActionProvider.SubUiVisibilityListener;
import com.actionbarsherlock.view.MenuItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ActionMenuPresenter
  extends BaseMenuPresenter
  implements ActionProvider.SubUiVisibilityListener
{
  private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
  private ActionButtonSubmenu mActionButtonPopup;
  private int mActionItemWidthLimit;
  private boolean mExpandedActionViewsExclusive;
  private int mMaxItems;
  private boolean mMaxItemsSet;
  private int mMinCellSize;
  int mOpenSubMenuId;
  private View mOverflowButton;
  private OverflowPopup mOverflowPopup;
  final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback(null);
  private OpenOverflowRunnable mPostedOpenRunnable;
  private boolean mReserveOverflow;
  private boolean mReserveOverflowSet;
  private View mScrapActionButtonView;
  private boolean mStrictWidthLimit;
  private int mWidthLimit;
  private boolean mWidthLimitSet;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, R.layout.abs__action_menu_layout, R.layout.abs__action_menu_item_layout);
  }
  
  private View findViewForItem(MenuItem paramMenuItem)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    if (localViewGroup != null)
    {
      int j = localViewGroup.getChildCount();
      for (int i = 0;; i++)
      {
        if (i >= j)
        {
          localView = null;
          break;
        }
        localView = localViewGroup.getChildAt(i);
        if (((localView instanceof MenuView.ItemView)) && (((MenuView.ItemView)localView).getItemData() == paramMenuItem)) {
          break;
        }
      }
    }
    View localView = null;
    return localView;
  }
  
  public static boolean reserveOverflow(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(R.styleable.SherlockTheme);
    boolean bool1 = localTypedArray.getBoolean(52, false);
    localTypedArray.recycle();
    if (!bool1) {
      if (Build.VERSION.SDK_INT >= 14)
      {
        if (HasPermanentMenuKey.get(paramContext)) {
          bool2 = false;
        }
      }
      else if (Build.VERSION.SDK_INT < 11) {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView)
  {
    paramItemView.initialize(paramMenuItemImpl, 0);
    ActionMenuView localActionMenuView = (ActionMenuView)this.mMenuView;
    ((ActionMenuItemView)paramItemView).setItemInvoker(localActionMenuView);
  }
  
  public boolean dismissPopupMenus()
  {
    return hideOverflowMenu() | hideSubMenus();
  }
  
  public boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    boolean bool;
    if (paramViewGroup.getChildAt(paramInt) != this.mOverflowButton) {
      bool = super.filterLeftoverView(paramViewGroup, paramInt);
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean flagActionItems()
  {
    ArrayList localArrayList = this.mMenu.getVisibleItems();
    int j = localArrayList.size();
    int n = this.mMaxItems;
    int i = this.mActionItemWidthLimit;
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    int i3 = 0;
    int i5 = 0;
    int k = 0;
    int i4 = 0;
    for (int i2 = 0;; i2++)
    {
      if (i2 >= j)
      {
        if ((this.mReserveOverflow) && ((i4 != 0) || (i3 + i5 > n))) {
          n--;
        }
        i3 = n - i3;
        SparseBooleanArray localSparseBooleanArray = this.mActionButtonGroups;
        localSparseBooleanArray.clear();
        i4 = 0;
        i2 = 0;
        if (this.mStrictWidthLimit)
        {
          i2 = i / this.mMinCellSize;
          i4 = i % this.mMinCellSize;
          i4 = this.mMinCellSize + i4 / i2;
        }
        for (i5 = 0;; i5++)
        {
          if (i5 >= j) {
            return true;
          }
          localMenuItemImpl1 = (MenuItemImpl)localArrayList.get(i5);
          if (!localMenuItemImpl1.requiresActionButton())
          {
            if (localMenuItemImpl1.requestsActionButton())
            {
              int i6 = localMenuItemImpl1.getGroupId();
              int i9 = localSparseBooleanArray.get(i6);
              int i8;
              if (((i3 <= 0) && (i9 == 0)) || (i <= 0) || ((this.mStrictWidthLimit) && (i2 <= 0))) {
                i8 = 0;
              } else {
                i8 = 1;
              }
              if (i8 != 0)
              {
                View localView2 = getItemView(localMenuItemImpl1, this.mScrapActionButtonView, localViewGroup);
                if (this.mScrapActionButtonView == null) {
                  this.mScrapActionButtonView = localView2;
                }
                if (!this.mStrictWidthLimit)
                {
                  localView2.measure(m, m);
                }
                else
                {
                  i10 = ActionMenuView.measureChildForCells(localView2, i4, i2, m, 0);
                  i2 -= i10;
                  if (i10 == 0) {
                    i8 = 0;
                  }
                }
                int i10 = localView2.getMeasuredWidth();
                i -= i10;
                if (k == 0) {
                  k = i10;
                }
                if (!this.mStrictWidthLimit)
                {
                  if (i + k <= 0) {
                    i10 = 0;
                  } else {
                    i10 = 1;
                  }
                  i8 &= i10;
                }
                else
                {
                  int i11;
                  if (i < 0) {
                    i11 = 0;
                  } else {
                    i11 = 1;
                  }
                  i8 &= i11;
                }
              }
              if ((i8 == 0) || (i6 == 0))
              {
                if (i9 != 0)
                {
                  localSparseBooleanArray.put(i6, false);
                  i9 = 0;
                }
              }
              else {
                while (i9 < i5)
                {
                  MenuItemImpl localMenuItemImpl2 = (MenuItemImpl)localArrayList.get(i9);
                  if (localMenuItemImpl2.getGroupId() == i6)
                  {
                    if (localMenuItemImpl2.isActionButton()) {
                      i3++;
                    }
                    localMenuItemImpl2.setIsActionButton(false);
                  }
                  i9++;
                  continue;
                  localSparseBooleanArray.put(i6, true);
                }
              }
              if (i8 != 0) {
                i3--;
              }
              localMenuItemImpl1.setIsActionButton(i8);
            }
          }
          else
          {
            View localView1 = getItemView(localMenuItemImpl1, this.mScrapActionButtonView, localViewGroup);
            if (this.mScrapActionButtonView == null) {
              this.mScrapActionButtonView = localView1;
            }
            if (!this.mStrictWidthLimit) {
              localView1.measure(m, m);
            } else {
              i2 -= ActionMenuView.measureChildForCells(localView1, i4, i2, m, 0);
            }
            int i7 = localView1.getMeasuredWidth();
            i -= i7;
            if (k == 0) {
              k = i7;
            }
            i7 = localMenuItemImpl1.getGroupId();
            if (i7 != 0) {
              localSparseBooleanArray.put(i7, true);
            }
            localMenuItemImpl1.setIsActionButton(true);
          }
        }
      }
      MenuItemImpl localMenuItemImpl1 = (MenuItemImpl)localArrayList.get(i2);
      if (!localMenuItemImpl1.requiresActionButton())
      {
        if (!localMenuItemImpl1.requestsActionButton()) {
          i4 = 1;
        } else {
          i5++;
        }
      }
      else {
        i3++;
      }
      if ((this.mExpandedActionViewsExclusive) && (localMenuItemImpl1.isActionViewExpanded())) {
        int i1 = 0;
      }
    }
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramMenuItemImpl.getActionView();
    if ((localView == null) || (paramMenuItemImpl.hasCollapsibleActionView()))
    {
      if (!(paramView instanceof ActionMenuItemView)) {
        paramView = null;
      }
      localView = super.getItemView(paramMenuItemImpl, paramView, paramViewGroup);
    }
    int i;
    if (!paramMenuItemImpl.isActionViewExpanded()) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    ActionMenuView localActionMenuView = (ActionMenuView)paramViewGroup;
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (!localActionMenuView.checkLayoutParams(localLayoutParams)) {
      localView.setLayoutParams(localActionMenuView.generateLayoutParams(localLayoutParams));
    }
    return localView;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    MenuView localMenuView = super.getMenuView(paramViewGroup);
    ((ActionMenuView)localMenuView).setPresenter(this);
    return localMenuView;
  }
  
  public boolean hideOverflowMenu()
  {
    boolean bool;
    if ((this.mPostedOpenRunnable == null) || (this.mMenuView == null))
    {
      OverflowPopup localOverflowPopup = this.mOverflowPopup;
      if (localOverflowPopup == null)
      {
        bool = false;
      }
      else
      {
        bool.dismiss();
        bool = true;
      }
    }
    else
    {
      ((View)this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
      this.mPostedOpenRunnable = null;
      bool = true;
    }
    return bool;
  }
  
  public boolean hideSubMenus()
  {
    boolean bool;
    if (this.mActionButtonPopup == null)
    {
      bool = false;
    }
    else
    {
      this.mActionButtonPopup.dismiss();
      bool = true;
    }
    return bool;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    super.initForMenu(paramContext, paramMenuBuilder);
    Resources localResources = paramContext.getResources();
    if (!this.mReserveOverflowSet) {
      this.mReserveOverflow = reserveOverflow(this.mContext);
    }
    if (!this.mWidthLimitSet) {
      this.mWidthLimit = (localResources.getDisplayMetrics().widthPixels / 2);
    }
    if (!this.mMaxItemsSet) {
      this.mMaxItems = ResourcesCompat.getResources_getInteger(paramContext, R.integer.abs__max_action_buttons);
    }
    int j = this.mWidthLimit;
    if (!this.mReserveOverflow)
    {
      this.mOverflowButton = null;
    }
    else
    {
      if (this.mOverflowButton == null)
      {
        this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
        int i = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(i, i);
      }
      j -= this.mOverflowButton.getMeasuredWidth();
    }
    this.mActionItemWidthLimit = j;
    this.mMinCellSize = ((int)(56.0F * localResources.getDisplayMetrics().density));
    this.mScrapActionButtonView = null;
  }
  
  public boolean isOverflowMenuShowing()
  {
    boolean bool;
    if ((this.mOverflowPopup == null) || (!this.mOverflowPopup.isShowing())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    dismissPopupMenus();
    super.onCloseMenu(paramMenuBuilder, paramBoolean);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mMaxItemsSet)
    {
      this.mMaxItems = ResourcesCompat.getResources_getInteger(this.mContext, R.integer.abs__max_action_buttons);
      if (this.mMenu != null) {
        this.mMenu.onItemsChanged(true);
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    Object localObject = (SavedState)paramParcelable;
    if (((SavedState)localObject).openSubMenuId > 0)
    {
      localObject = this.mMenu.findItem(((SavedState)localObject).openSubMenuId);
      if (localObject != null) {
        onSubMenuSelected((SubMenuBuilder)((MenuItem)localObject).getSubMenu());
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.openSubMenuId = this.mOpenSubMenuId;
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    boolean bool = false;
    if (paramSubMenuBuilder.hasVisibleItems()) {}
    for (Object localObject = paramSubMenuBuilder;; localObject = (SubMenuBuilder)((SubMenuBuilder)localObject).getParentMenu()) {
      if (((SubMenuBuilder)localObject).getParentMenu() == this.mMenu)
      {
        localObject = findViewForItem(((SubMenuBuilder)localObject).getItem());
        if (localObject == null)
        {
          if (this.mOverflowButton != null) {
            localObject = this.mOverflowButton;
          }
        }
        else
        {
          this.mOpenSubMenuId = paramSubMenuBuilder.getItem().getItemId();
          this.mActionButtonPopup = new ActionButtonSubmenu(this.mContext, paramSubMenuBuilder);
          this.mActionButtonPopup.setAnchorView((View)localObject);
          this.mActionButtonPopup.show();
          super.onSubMenuSelected(paramSubMenuBuilder);
          bool = true;
        }
        return bool;
      }
    }
  }
  
  public void onSubUiVisibilityChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.mMenu.close(false);
    } else {
      super.onSubMenuSelected(null);
    }
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.mExpandedActionViewsExclusive = paramBoolean;
  }
  
  public void setItemLimit(int paramInt)
  {
    this.mMaxItems = paramInt;
    this.mMaxItemsSet = true;
  }
  
  public void setReserveOverflow(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
    this.mReserveOverflowSet = true;
  }
  
  public void setWidthLimit(int paramInt, boolean paramBoolean)
  {
    this.mWidthLimit = paramInt;
    this.mStrictWidthLimit = paramBoolean;
    this.mWidthLimitSet = true;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return paramMenuItemImpl.isActionButton();
  }
  
  public boolean showOverflowMenu()
  {
    boolean bool = true;
    if ((!this.mReserveOverflow) || (isOverflowMenuShowing()) || (this.mMenu == null) || (this.mMenuView == null) || (this.mPostedOpenRunnable != null) || (this.mMenu.getNonActionItems().isEmpty()))
    {
      bool = false;
    }
    else
    {
      this.mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, bool));
      ((View)this.mMenuView).post(this.mPostedOpenRunnable);
      super.onSubMenuSelected(null);
    }
    return bool;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    super.updateMenuView(paramBoolean);
    Object localObject;
    int k;
    if (this.mMenu != null)
    {
      localObject = this.mMenu.getActionItems();
      k = ((ArrayList)localObject).size();
    }
    for (int j = 0;; j++)
    {
      if (j >= k)
      {
        if (this.mMenu == null) {
          localObject = null;
        } else {
          localObject = this.mMenu.getNonActionItems();
        }
        int i = 0;
        if ((this.mReserveOverflow) && (localObject != null))
        {
          i = ((ArrayList)localObject).size();
          if (i != 1)
          {
            if (i <= 0) {
              i = 0;
            } else {
              i = 1;
            }
          }
          else if (((MenuItemImpl)((ArrayList)localObject).get(0)).isActionViewExpanded()) {
            i = 0;
          } else {
            i = 1;
          }
        }
        if (i == 0)
        {
          if ((this.mOverflowButton != null) && (this.mOverflowButton.getParent() == this.mMenuView)) {
            ((ViewGroup)this.mMenuView).removeView(this.mOverflowButton);
          }
        }
        else
        {
          if (this.mOverflowButton == null) {
            this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
          }
          localObject = (ViewGroup)this.mOverflowButton.getParent();
          if (localObject != this.mMenuView)
          {
            if (localObject != null) {
              ((ViewGroup)localObject).removeView(this.mOverflowButton);
            }
            localObject = (ActionMenuView)this.mMenuView;
            ((ActionMenuView)localObject).addView(this.mOverflowButton, ((ActionMenuView)localObject).generateOverflowButtonLayoutParams());
          }
        }
        ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
        return;
      }
      ActionProvider localActionProvider = ((MenuItemImpl)((ArrayList)localObject).get(j)).getActionProvider();
      if (localActionProvider != null) {
        localActionProvider.setSubUiVisibilityListener(this);
      }
    }
  }
  
  private class OpenOverflowRunnable
    implements Runnable
  {
    private ActionMenuPresenter.OverflowPopup mPopup;
    
    public OpenOverflowRunnable(ActionMenuPresenter.OverflowPopup paramOverflowPopup)
    {
      this.mPopup = paramOverflowPopup;
    }
    
    public void run()
    {
      ActionMenuPresenter.this.mMenu.changeMenuMode();
      View localView = (View)ActionMenuPresenter.this.mMenuView;
      if ((localView != null) && (localView.getWindowToken() != null) && (this.mPopup.tryShow())) {
        ActionMenuPresenter.access$102(ActionMenuPresenter.this, this.mPopup);
      }
      ActionMenuPresenter.access$402(ActionMenuPresenter.this, null);
    }
  }
  
  private class PopupPresenterCallback
    implements MenuPresenter.Callback
  {
    private PopupPresenterCallback() {}
    
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
      if ((paramMenuBuilder instanceof SubMenuBuilder)) {
        ((SubMenuBuilder)paramMenuBuilder).getRootMenu().close(false);
      }
    }
    
    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      if (paramMenuBuilder != null) {
        ActionMenuPresenter.this.mOpenSubMenuId = ((SubMenuBuilder)paramMenuBuilder).getItem().getItemId();
      }
      return false;
    }
  }
  
  private class ActionButtonSubmenu
    extends MenuPopupHelper
  {
    public ActionButtonSubmenu(Context paramContext, SubMenuBuilder paramSubMenuBuilder)
    {
      super(paramSubMenuBuilder);
      if (!((MenuItemImpl)paramSubMenuBuilder.getItem()).isActionButton())
      {
        View localView;
        if (ActionMenuPresenter.this.mOverflowButton != null) {
          localView = ActionMenuPresenter.this.mOverflowButton;
        } else {
          localView = (View)ActionMenuPresenter.this.mMenuView;
        }
        setAnchorView(localView);
      }
      setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
      boolean bool = false;
      int j = paramSubMenuBuilder.size();
      int i = 0;
      while (i < j)
      {
        MenuItem localMenuItem = paramSubMenuBuilder.getItem(i);
        if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {
          i++;
        } else {
          bool = true;
        }
      }
      setForceShowIcon(bool);
    }
    
    public void onDismiss()
    {
      super.onDismiss();
      ActionMenuPresenter.access$302(ActionMenuPresenter.this, null);
      ActionMenuPresenter.this.mOpenSubMenuId = 0;
    }
  }
  
  private class OverflowPopup
    extends MenuPopupHelper
  {
    public OverflowPopup(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean)
    {
      super(paramMenuBuilder, paramView, paramBoolean);
      setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
    }
    
    public void onDismiss()
    {
      super.onDismiss();
      ActionMenuPresenter.this.mMenu.close();
      ActionMenuPresenter.access$102(ActionMenuPresenter.this, null);
    }
  }
  
  private class OverflowMenuButton
    extends ImageButton
    implements ActionMenuView.ActionMenuChildView, View_HasStateListenerSupport
  {
    private final Set<View_OnAttachStateChangeListener> mListeners = new HashSet();
    
    public OverflowMenuButton(Context paramContext)
    {
      super(null, R.attr.actionOverflowButtonStyle);
      setClickable(true);
      setFocusable(true);
      setVisibility(0);
      setEnabled(true);
    }
    
    public void addOnAttachStateChangeListener(View_OnAttachStateChangeListener paramView_OnAttachStateChangeListener)
    {
      this.mListeners.add(paramView_OnAttachStateChangeListener);
    }
    
    public boolean needsDividerAfter()
    {
      return false;
    }
    
    public boolean needsDividerBefore()
    {
      return false;
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      Iterator localIterator = this.mListeners.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        ((View_OnAttachStateChangeListener)localIterator.next()).onViewAttachedToWindow(this);
      }
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      Iterator localIterator = this.mListeners.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return;
        }
        ((View_OnAttachStateChangeListener)localIterator.next()).onViewDetachedFromWindow(this);
      }
    }
    
    public boolean performClick()
    {
      if (!super.performClick())
      {
        playSoundEffect(0);
        ActionMenuPresenter.this.showOverflowMenu();
      }
      return true;
    }
    
    public void removeOnAttachStateChangeListener(View_OnAttachStateChangeListener paramView_OnAttachStateChangeListener)
    {
      this.mListeners.remove(paramView_OnAttachStateChangeListener);
    }
  }
  
  private static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ActionMenuPresenter.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ActionMenuPresenter.SavedState(paramAnonymousParcel);
      }
      
      public ActionMenuPresenter.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ActionMenuPresenter.SavedState[paramAnonymousInt];
      }
    };
    public int openSubMenuId;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.openSubMenuId = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.openSubMenuId);
    }
  }
  
  private static class HasPermanentMenuKey
  {
    public static boolean get(Context paramContext)
    {
      return ViewConfiguration.get(paramContext).hasPermanentMenuKey();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.view.menu.ActionMenuPresenter
 * JD-Core Version:    0.7.0.1
 */