package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MenuItemCompat
{
  static final MenuVersionImpl IMPL;
  public static final int SHOW_AS_ACTION_ALWAYS = 2;
  public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
  public static final int SHOW_AS_ACTION_IF_ROOM = 1;
  public static final int SHOW_AS_ACTION_NEVER = 0;
  public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
  private static final String TAG = "MenuItemCompat";
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 14)
    {
      if (i < 11) {
        IMPL = new BaseMenuVersionImpl();
      } else {
        IMPL = new HoneycombMenuVersionImpl();
      }
    }
    else {
      IMPL = new IcsMenuVersionImpl();
    }
  }
  
  public static boolean collapseActionView(MenuItem paramMenuItem)
  {
    boolean bool;
    if (!(paramMenuItem instanceof SupportMenuItem)) {
      bool = IMPL.collapseActionView(paramMenuItem);
    } else {
      bool = ((SupportMenuItem)paramMenuItem).collapseActionView();
    }
    return bool;
  }
  
  public static boolean expandActionView(MenuItem paramMenuItem)
  {
    boolean bool;
    if (!(paramMenuItem instanceof SupportMenuItem)) {
      bool = IMPL.expandActionView(paramMenuItem);
    } else {
      bool = ((SupportMenuItem)paramMenuItem).expandActionView();
    }
    return bool;
  }
  
  public static ActionProvider getActionProvider(MenuItem paramMenuItem)
  {
    ActionProvider localActionProvider;
    if (!(paramMenuItem instanceof SupportMenuItem))
    {
      Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
      localActionProvider = null;
    }
    else
    {
      localActionProvider = ((SupportMenuItem)paramMenuItem).getSupportActionProvider();
    }
    return localActionProvider;
  }
  
  public static View getActionView(MenuItem paramMenuItem)
  {
    View localView;
    if (!(paramMenuItem instanceof SupportMenuItem)) {
      localView = IMPL.getActionView(paramMenuItem);
    } else {
      localView = ((SupportMenuItem)paramMenuItem).getActionView();
    }
    return localView;
  }
  
  public static boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    boolean bool;
    if (!(paramMenuItem instanceof SupportMenuItem)) {
      bool = IMPL.isActionViewExpanded(paramMenuItem);
    } else {
      bool = ((SupportMenuItem)paramMenuItem).isActionViewExpanded();
    }
    return bool;
  }
  
  public static MenuItem setActionProvider(MenuItem paramMenuItem, ActionProvider paramActionProvider)
  {
    if (!(paramMenuItem instanceof SupportMenuItem)) {
      Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
    } else {
      paramMenuItem = ((SupportMenuItem)paramMenuItem).setSupportActionProvider(paramActionProvider);
    }
    return paramMenuItem;
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
  {
    MenuItem localMenuItem;
    if (!(paramMenuItem instanceof SupportMenuItem)) {
      localMenuItem = IMPL.setActionView(paramMenuItem, paramInt);
    } else {
      localMenuItem = ((SupportMenuItem)paramMenuItem).setActionView(paramInt);
    }
    return localMenuItem;
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, View paramView)
  {
    MenuItem localMenuItem;
    if (!(paramMenuItem instanceof SupportMenuItem)) {
      localMenuItem = IMPL.setActionView(paramMenuItem, paramView);
    } else {
      localMenuItem = ((SupportMenuItem)paramMenuItem).setActionView(paramView);
    }
    return localMenuItem;
  }
  
  public static MenuItem setOnActionExpandListener(MenuItem paramMenuItem, OnActionExpandListener paramOnActionExpandListener)
  {
    Object localObject;
    if (!(paramMenuItem instanceof SupportMenuItem)) {
      localObject = IMPL.setOnActionExpandListener(paramMenuItem, paramOnActionExpandListener);
    } else {
      localObject = ((SupportMenuItem)paramMenuItem).setSupportOnActionExpandListener(paramOnActionExpandListener);
    }
    return localObject;
  }
  
  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    if (!(paramMenuItem instanceof SupportMenuItem)) {
      IMPL.setShowAsAction(paramMenuItem, paramInt);
    } else {
      ((SupportMenuItem)paramMenuItem).setShowAsAction(paramInt);
    }
  }
  
  static class IcsMenuVersionImpl
    extends MenuItemCompat.HoneycombMenuVersionImpl
  {
    public boolean collapseActionView(MenuItem paramMenuItem)
    {
      return MenuItemCompatIcs.collapseActionView(paramMenuItem);
    }
    
    public boolean expandActionView(MenuItem paramMenuItem)
    {
      return MenuItemCompatIcs.expandActionView(paramMenuItem);
    }
    
    public boolean isActionViewExpanded(MenuItem paramMenuItem)
    {
      return MenuItemCompatIcs.isActionViewExpanded(paramMenuItem);
    }
    
    public MenuItem setOnActionExpandListener(MenuItem paramMenuItem, final MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
    {
      MenuItem localMenuItem;
      if (paramOnActionExpandListener != null) {
        localMenuItem = MenuItemCompatIcs.setOnActionExpandListener(paramMenuItem, new MenuItemCompatIcs.SupportActionExpandProxy()
        {
          public boolean onMenuItemActionCollapse(MenuItem paramAnonymousMenuItem)
          {
            return paramOnActionExpandListener.onMenuItemActionCollapse(paramAnonymousMenuItem);
          }
          
          public boolean onMenuItemActionExpand(MenuItem paramAnonymousMenuItem)
          {
            return paramOnActionExpandListener.onMenuItemActionExpand(paramAnonymousMenuItem);
          }
        });
      } else {
        localMenuItem = MenuItemCompatIcs.setOnActionExpandListener(paramMenuItem, null);
      }
      return localMenuItem;
    }
  }
  
  static class HoneycombMenuVersionImpl
    implements MenuItemCompat.MenuVersionImpl
  {
    public boolean collapseActionView(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public boolean expandActionView(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public View getActionView(MenuItem paramMenuItem)
    {
      return MenuItemCompatHoneycomb.getActionView(paramMenuItem);
    }
    
    public boolean isActionViewExpanded(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
    {
      return MenuItemCompatHoneycomb.setActionView(paramMenuItem, paramInt);
    }
    
    public MenuItem setActionView(MenuItem paramMenuItem, View paramView)
    {
      return MenuItemCompatHoneycomb.setActionView(paramMenuItem, paramView);
    }
    
    public MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
    {
      return paramMenuItem;
    }
    
    public void setShowAsAction(MenuItem paramMenuItem, int paramInt)
    {
      MenuItemCompatHoneycomb.setShowAsAction(paramMenuItem, paramInt);
    }
  }
  
  static class BaseMenuVersionImpl
    implements MenuItemCompat.MenuVersionImpl
  {
    public boolean collapseActionView(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public boolean expandActionView(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public View getActionView(MenuItem paramMenuItem)
    {
      return null;
    }
    
    public boolean isActionViewExpanded(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
    {
      return paramMenuItem;
    }
    
    public MenuItem setActionView(MenuItem paramMenuItem, View paramView)
    {
      return paramMenuItem;
    }
    
    public MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
    {
      return paramMenuItem;
    }
    
    public void setShowAsAction(MenuItem paramMenuItem, int paramInt) {}
  }
  
  public static abstract interface OnActionExpandListener
  {
    public abstract boolean onMenuItemActionCollapse(MenuItem paramMenuItem);
    
    public abstract boolean onMenuItemActionExpand(MenuItem paramMenuItem);
  }
  
  static abstract interface MenuVersionImpl
  {
    public abstract boolean collapseActionView(MenuItem paramMenuItem);
    
    public abstract boolean expandActionView(MenuItem paramMenuItem);
    
    public abstract View getActionView(MenuItem paramMenuItem);
    
    public abstract boolean isActionViewExpanded(MenuItem paramMenuItem);
    
    public abstract MenuItem setActionView(MenuItem paramMenuItem, int paramInt);
    
    public abstract MenuItem setActionView(MenuItem paramMenuItem, View paramView);
    
    public abstract MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener);
    
    public abstract void setShowAsAction(MenuItem paramMenuItem, int paramInt);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.MenuItemCompat
 * JD-Core Version:    0.7.0.1
 */