package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.actionbarsherlock.R.attr;
import com.actionbarsherlock.R.dimen;
import com.actionbarsherlock.R.layout;
import com.actionbarsherlock.internal.view.View_HasStateListenerSupport;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import com.actionbarsherlock.internal.widget.IcsListPopupWindow;
import com.actionbarsherlock.view.MenuItem;
import java.util.ArrayList;

public class MenuPopupHelper
  implements AdapterView.OnItemClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, PopupWindow.OnDismissListener, View_OnAttachStateChangeListener, MenuPresenter
{
  static final int ITEM_LAYOUT = R.layout.abs__popup_menu_item_layout;
  private MenuAdapter mAdapter;
  private View mAnchorView;
  private Context mContext;
  boolean mForceShowIcon;
  private LayoutInflater mInflater;
  private ViewGroup mMeasureParent;
  private MenuBuilder mMenu;
  private boolean mOverflowOnly;
  private IcsListPopupWindow mPopup;
  private int mPopupMaxWidth;
  private MenuPresenter.Callback mPresenterCallback;
  private ViewTreeObserver mTreeObserver;
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this(paramContext, paramMenuBuilder, null, false);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView)
  {
    this(paramContext, paramMenuBuilder, paramView, false);
  }
  
  public MenuPopupHelper(Context paramContext, MenuBuilder paramMenuBuilder, View paramView, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mMenu = paramMenuBuilder;
    this.mOverflowOnly = paramBoolean;
    Resources localResources = paramContext.getResources();
    this.mPopupMaxWidth = Math.max(localResources.getDisplayMetrics().widthPixels / 2, localResources.getDimensionPixelSize(R.dimen.abs__config_prefDialogWidth));
    this.mAnchorView = paramView;
    paramMenuBuilder.addMenuPresenter(this);
  }
  
  private int measureContentWidth(ListAdapter paramListAdapter)
  {
    int i1 = 0;
    View localView = null;
    int n = 0;
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int j = paramListAdapter.getCount();
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return i1;
      }
      int m = paramListAdapter.getItemViewType(i);
      if (m != n)
      {
        n = m;
        localView = null;
      }
      if (this.mMeasureParent == null) {
        this.mMeasureParent = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(i, localView, this.mMeasureParent);
      localView.measure(k, i2);
      i1 = Math.max(i1, localView.getMeasuredWidth());
    }
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public void dismiss()
  {
    if (isShowing()) {
      this.mPopup.dismiss();
    }
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
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
    throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {}
  
  public boolean isShowing()
  {
    boolean bool;
    if ((this.mPopup == null) || (!this.mPopup.isShowing())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (paramMenuBuilder == this.mMenu)
    {
      dismiss();
      if (this.mPresenterCallback != null) {
        this.mPresenterCallback.onCloseMenu(paramMenuBuilder, paramBoolean);
      }
    }
  }
  
  public void onDismiss()
  {
    this.mPopup = null;
    this.mMenu.close();
    if (this.mTreeObserver != null)
    {
      if (!this.mTreeObserver.isAlive()) {
        this.mTreeObserver = this.mAnchorView.getViewTreeObserver();
      }
      this.mTreeObserver.removeGlobalOnLayoutListener(this);
      this.mTreeObserver = null;
    }
    ((View_HasStateListenerSupport)this.mAnchorView).removeOnAttachStateChangeListener(this);
  }
  
  public void onGlobalLayout()
  {
    if (isShowing())
    {
      View localView = this.mAnchorView;
      if ((localView != null) && (localView.isShown()))
      {
        if (isShowing()) {
          this.mPopup.show();
        }
      }
      else {
        dismiss();
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    MenuAdapter localMenuAdapter = this.mAdapter;
    localMenuAdapter.mAdapterMenu.performItemAction(localMenuAdapter.getItem(paramInt), 0);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    int i = 1;
    if ((paramKeyEvent.getAction() != i) || (paramInt != 82)) {
      i = 0;
    } else {
      dismiss();
    }
    return i;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {}
  
  public Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    boolean bool2 = false;
    if (paramSubMenuBuilder.hasVisibleItems())
    {
      MenuPopupHelper localMenuPopupHelper = new MenuPopupHelper(this.mContext, paramSubMenuBuilder, this.mAnchorView, false);
      localMenuPopupHelper.setCallback(this.mPresenterCallback);
      boolean bool1 = false;
      int j = paramSubMenuBuilder.size();
      int i = 0;
      while (i < j)
      {
        MenuItem localMenuItem = paramSubMenuBuilder.getItem(i);
        if ((!localMenuItem.isVisible()) || (localMenuItem.getIcon() == null)) {
          i++;
        } else {
          bool1 = true;
        }
      }
      localMenuPopupHelper.setForceShowIcon(bool1);
      if (localMenuPopupHelper.tryShow())
      {
        if (this.mPresenterCallback != null) {
          this.mPresenterCallback.onOpenSubMenu(paramSubMenuBuilder);
        }
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (this.mTreeObserver != null)
    {
      if (!this.mTreeObserver.isAlive()) {
        this.mTreeObserver = paramView.getViewTreeObserver();
      }
      this.mTreeObserver.removeGlobalOnLayoutListener(this);
    }
    ((View_HasStateListenerSupport)paramView).removeOnAttachStateChangeListener(this);
  }
  
  public void setAnchorView(View paramView)
  {
    this.mAnchorView = paramView;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    this.mPresenterCallback = paramCallback;
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mForceShowIcon = paramBoolean;
  }
  
  public void show()
  {
    if (tryShow()) {
      return;
    }
    throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
  }
  
  public boolean tryShow()
  {
    int i = 0;
    boolean bool = true;
    this.mPopup = new IcsListPopupWindow(this.mContext, null, R.attr.popupMenuStyle);
    this.mPopup.setOnDismissListener(this);
    this.mPopup.setOnItemClickListener(this);
    this.mAdapter = new MenuAdapter(this.mMenu);
    this.mPopup.setAdapter(this.mAdapter);
    this.mPopup.setModal(bool);
    View localView = this.mAnchorView;
    if (localView == null)
    {
      bool = false;
    }
    else
    {
      if (this.mTreeObserver == null) {
        i = bool;
      }
      this.mTreeObserver = localView.getViewTreeObserver();
      if (i != 0) {
        this.mTreeObserver.addOnGlobalLayoutListener(this);
      }
      ((View_HasStateListenerSupport)localView).addOnAttachStateChangeListener(this);
      this.mPopup.setAnchorView(localView);
      this.mPopup.setContentWidth(Math.min(measureContentWidth(this.mAdapter), this.mPopupMaxWidth));
      this.mPopup.setInputMethodMode(2);
      this.mPopup.show();
      this.mPopup.getListView().setOnKeyListener(this);
    }
    return bool;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    if (this.mAdapter != null) {
      this.mAdapter.notifyDataSetChanged();
    }
  }
  
  private class ExpandedIndexObserver
    extends DataSetObserver
  {
    private ExpandedIndexObserver() {}
    
    public void onChanged()
    {
      MenuPopupHelper.this.mAdapter.findExpandedIndex();
    }
  }
  
  private class MenuAdapter
    extends BaseAdapter
  {
    private MenuBuilder mAdapterMenu;
    private int mExpandedIndex = -1;
    
    public MenuAdapter(MenuBuilder paramMenuBuilder)
    {
      this.mAdapterMenu = paramMenuBuilder;
      registerDataSetObserver(new MenuPopupHelper.ExpandedIndexObserver(MenuPopupHelper.this, null));
      findExpandedIndex();
    }
    
    void findExpandedIndex()
    {
      MenuItemImpl localMenuItemImpl = MenuPopupHelper.this.mMenu.getExpandedItem();
      ArrayList localArrayList;
      int j;
      if (localMenuItemImpl != null)
      {
        localArrayList = MenuPopupHelper.this.mMenu.getNonActionItems();
        j = localArrayList.size();
      }
      for (int i = 0;; i++)
      {
        if (i >= j)
        {
          this.mExpandedIndex = -1;
          return;
        }
        if ((MenuItemImpl)localArrayList.get(i) == localMenuItemImpl) {
          break;
        }
      }
      this.mExpandedIndex = i;
    }
    
    public int getCount()
    {
      ArrayList localArrayList;
      if (!MenuPopupHelper.this.mOverflowOnly) {
        localArrayList = this.mAdapterMenu.getVisibleItems();
      } else {
        localArrayList = this.mAdapterMenu.getNonActionItems();
      }
      int i;
      if (this.mExpandedIndex >= 0) {
        i = -1 + localArrayList.size();
      } else {
        i = i.size();
      }
      return i;
    }
    
    public MenuItemImpl getItem(int paramInt)
    {
      ArrayList localArrayList;
      if (!MenuPopupHelper.this.mOverflowOnly) {
        localArrayList = this.mAdapterMenu.getVisibleItems();
      } else {
        localArrayList = this.mAdapterMenu.getNonActionItems();
      }
      if ((this.mExpandedIndex >= 0) && (paramInt >= this.mExpandedIndex)) {
        paramInt++;
      }
      return (MenuItemImpl)localArrayList.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = MenuPopupHelper.this.mInflater.inflate(MenuPopupHelper.ITEM_LAYOUT, paramViewGroup, false);
      }
      MenuView.ItemView localItemView = (MenuView.ItemView)paramView;
      if (MenuPopupHelper.this.mForceShowIcon) {
        ((ListMenuItemView)paramView).setForceShowIcon(true);
      }
      localItemView.initialize(getItem(paramInt), 0);
      return paramView;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.view.menu.MenuPopupHelper
 * JD-Core Version:    0.7.0.1
 */