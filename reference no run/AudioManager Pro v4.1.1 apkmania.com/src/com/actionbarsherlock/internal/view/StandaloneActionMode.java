package com.actionbarsherlock.internal.view;

import android.content.Context;
import android.view.View;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuBuilder.Callback;
import com.actionbarsherlock.internal.view.menu.MenuPopupHelper;
import com.actionbarsherlock.internal.view.menu.SubMenuBuilder;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.lang.ref.WeakReference;

public class StandaloneActionMode
  extends ActionMode
  implements MenuBuilder.Callback
{
  private ActionMode.Callback mCallback;
  private Context mContext;
  private ActionBarContextView mContextView;
  private WeakReference<View> mCustomView;
  private boolean mFinished;
  private boolean mFocusable;
  private MenuBuilder mMenu;
  
  public StandaloneActionMode(Context paramContext, ActionBarContextView paramActionBarContextView, ActionMode.Callback paramCallback, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mContextView = paramActionBarContextView;
    this.mCallback = paramCallback;
    this.mMenu = new MenuBuilder(paramContext).setDefaultShowAsAction(1);
    this.mMenu.setCallback(this);
    this.mFocusable = paramBoolean;
  }
  
  public void finish()
  {
    if (!this.mFinished)
    {
      this.mFinished = true;
      this.mContextView.sendAccessibilityEvent(32);
      this.mCallback.onDestroyActionMode(this);
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
    return new MenuInflater(this.mContext);
  }
  
  public CharSequence getSubtitle()
  {
    return this.mContextView.getSubtitle();
  }
  
  public CharSequence getTitle()
  {
    return this.mContextView.getTitle();
  }
  
  public void invalidate()
  {
    this.mCallback.onPrepareActionMode(this, this.mMenu);
  }
  
  public boolean isUiFocusable()
  {
    return this.mFocusable;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onCloseSubMenu(SubMenuBuilder paramSubMenuBuilder) {}
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return this.mCallback.onActionItemClicked(this, paramMenuItem);
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    invalidate();
    this.mContextView.showOverflowMenu();
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    if (paramSubMenuBuilder.hasVisibleItems()) {
      new MenuPopupHelper(this.mContext, paramSubMenuBuilder).show();
    }
    return true;
  }
  
  public void setCustomView(View paramView)
  {
    this.mContextView.setCustomView(paramView);
    WeakReference localWeakReference;
    if (paramView == null) {
      localWeakReference = null;
    } else {
      localWeakReference = new WeakReference(paramView);
    }
    this.mCustomView = localWeakReference;
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(this.mContext.getString(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mContextView.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(this.mContext.getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mContextView.setTitle(paramCharSequence);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.view.StandaloneActionMode
 * JD-Core Version:    0.7.0.1
 */