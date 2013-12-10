package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class BaseMenuPresenter
  implements MenuPresenter
{
  private static final boolean IS_HONEYCOMB;
  private MenuPresenter.Callback mCallback;
  protected Context mContext;
  private int mId;
  protected LayoutInflater mInflater;
  private int mItemLayoutRes;
  protected MenuBuilder mMenu;
  private int mMenuLayoutRes;
  protected MenuView mMenuView;
  protected Context mSystemContext;
  protected LayoutInflater mSystemInflater;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 11) {
      bool = false;
    } else {
      bool = true;
    }
    IS_HONEYCOMB = bool;
  }
  
  public BaseMenuPresenter(Context paramContext, int paramInt1, int paramInt2)
  {
    this.mSystemContext = paramContext;
    this.mSystemInflater = LayoutInflater.from(paramContext);
    this.mMenuLayoutRes = paramInt1;
    this.mItemLayoutRes = paramInt2;
  }
  
  protected void addItemView(View paramView, int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(paramView);
    }
    ((ViewGroup)this.mMenuView).addView(paramView, paramInt);
  }
  
  public abstract void bindItemView(MenuItemImpl paramMenuItemImpl, MenuView.ItemView paramItemView);
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public MenuView.ItemView createItemView(ViewGroup paramViewGroup)
  {
    return (MenuView.ItemView)this.mSystemInflater.inflate(this.mItemLayoutRes, paramViewGroup, false);
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  protected boolean filterLeftoverView(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.removeViewAt(paramInt);
    return true;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public View getItemView(MenuItemImpl paramMenuItemImpl, View paramView, ViewGroup paramViewGroup)
  {
    MenuView.ItemView localItemView;
    if (!(paramView instanceof MenuView.ItemView)) {
      localItemView = createItemView(paramViewGroup);
    } else {
      localItemView = (MenuView.ItemView)paramView;
    }
    bindItemView(paramMenuItemImpl, localItemView);
    return (View)localItemView;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (this.mMenuView == null)
    {
      this.mMenuView = ((MenuView)this.mSystemInflater.inflate(this.mMenuLayoutRes, paramViewGroup, false));
      this.mMenuView.initialize(this.mMenu);
      updateMenuView(true);
    }
    return this.mMenuView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(this.mContext);
    this.mMenu = paramMenuBuilder;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (this.mCallback != null) {
      this.mCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    boolean bool;
    if (this.mCallback == null) {
      bool = false;
    } else {
      bool = this.mCallback.onOpenSubMenu(paramSubMenuBuilder);
    }
    return bool;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public void setId(int paramInt)
  {
    this.mId = paramInt;
  }
  
  public boolean shouldIncludeItem(int paramInt, MenuItemImpl paramMenuItemImpl)
  {
    return true;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)this.mMenuView;
    int j;
    ArrayList localArrayList;
    int k;
    if (localViewGroup != null)
    {
      j = 0;
      if (this.mMenu != null)
      {
        this.mMenu.flagActionItems();
        localArrayList = this.mMenu.getVisibleItems();
        k = localArrayList.size();
      }
    }
    for (int i = 0;; i++)
    {
      if (i >= k) {
        for (;;)
        {
          if (j >= localViewGroup.getChildCount()) {
            return;
          }
          if (!filterLeftoverView(localViewGroup, j)) {
            j++;
          }
        }
      }
      MenuItemImpl localMenuItemImpl2 = (MenuItemImpl)localArrayList.get(i);
      if (shouldIncludeItem(j, localMenuItemImpl2))
      {
        View localView2 = localViewGroup.getChildAt(j);
        MenuItemImpl localMenuItemImpl1;
        if (!(localView2 instanceof MenuView.ItemView)) {
          localMenuItemImpl1 = null;
        } else {
          localMenuItemImpl1 = ((MenuView.ItemView)localView2).getItemData();
        }
        View localView1 = getItemView(localMenuItemImpl2, localView2, localViewGroup);
        if (localMenuItemImpl2 != localMenuItemImpl1)
        {
          localView1.setPressed(false);
          if (IS_HONEYCOMB) {
            localView1.jumpDrawablesToCurrentState();
          }
        }
        if (localView1 != localView2) {
          addItemView(localView1, j);
        }
        j++;
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.view.menu.BaseMenuPresenter
 * JD-Core Version:    0.7.0.1
 */