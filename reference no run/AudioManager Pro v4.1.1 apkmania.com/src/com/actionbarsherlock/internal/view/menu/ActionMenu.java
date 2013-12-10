package com.actionbarsherlock.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;
import java.util.ArrayList;
import java.util.List;

public class ActionMenu
  implements Menu
{
  private Context mContext;
  private boolean mIsQwerty;
  private ArrayList<ActionMenuItem> mItems;
  
  public ActionMenu(Context paramContext)
  {
    this.mContext = paramContext;
    this.mItems = new ArrayList();
  }
  
  private int findItemIndex(int paramInt)
  {
    ArrayList localArrayList = this.mItems;
    int i = localArrayList.size();
    for (int j = 0;; j++)
    {
      if (j >= i)
      {
        j = -1;
        break;
      }
      if (((ActionMenuItem)localArrayList.get(j)).getItemId() == paramInt) {
        break;
      }
    }
    return j;
  }
  
  private ActionMenuItem findItemWithShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = this.mIsQwerty;
    ArrayList localArrayList = this.mItems;
    int j = localArrayList.size();
    ActionMenuItem localActionMenuItem;
    for (int k = 0;; k++)
    {
      if (k >= j)
      {
        localActionMenuItem = null;
        break;
      }
      localActionMenuItem = (ActionMenuItem)localArrayList.get(k);
      int i;
      if (!bool) {
        i = localActionMenuItem.getNumericShortcut();
      } else {
        i = localActionMenuItem.getAlphabeticShortcut();
      }
      if (paramInt == i) {
        break;
      }
    }
    return localActionMenuItem;
  }
  
  public MenuItem add(int paramInt)
  {
    return add(0, 0, 0, paramInt);
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return add(paramInt1, paramInt2, paramInt3, this.mContext.getResources().getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    ActionMenuItem localActionMenuItem = new ActionMenuItem(getContext(), paramInt1, paramInt2, 0, paramInt3, paramCharSequence);
    this.mItems.add(paramInt3, localActionMenuItem);
    return localActionMenuItem;
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return add(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = this.mContext.getPackageManager();
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int j;
    if (localList == null) {
      j = 0;
    } else {
      j = localList.size();
    }
    if ((paramInt4 & 0x1) == 0) {
      removeGroup(paramInt1);
    }
    for (int i = 0;; i++)
    {
      if (i >= j) {
        return j;
      }
      ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i);
      if (localResolveInfo.specificIndex >= 0) {
        localObject = paramArrayOfIntent[localResolveInfo.specificIndex];
      } else {
        localObject = paramIntent;
      }
      Object localObject = new Intent((Intent)localObject);
      ((Intent)localObject).setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
      localObject = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent((Intent)localObject);
      if ((paramArrayOfMenuItem != null) && (localResolveInfo.specificIndex >= 0)) {
        paramArrayOfMenuItem[localResolveInfo.specificIndex] = localObject;
      }
    }
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return null;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return null;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return null;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return null;
  }
  
  public void clear()
  {
    this.mItems.clear();
  }
  
  public void close() {}
  
  public MenuItem findItem(int paramInt)
  {
    return (MenuItem)this.mItems.get(findItemIndex(paramInt));
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.mItems.get(paramInt);
  }
  
  public boolean hasVisibleItems()
  {
    ArrayList localArrayList = this.mItems;
    int i = localArrayList.size();
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return 0;
      }
      if (((ActionMenuItem)localArrayList.get(j)).isVisible()) {
        break;
      }
    }
    i = 1;
    return i;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (findItemWithShortcut(paramInt, paramKeyEvent) == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    int i = findItemIndex(paramInt1);
    boolean bool;
    if (i >= 0) {
      bool = ((ActionMenuItem)this.mItems.get(i)).invoke();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    ActionMenuItem localActionMenuItem = findItemWithShortcut(paramInt1, paramKeyEvent);
    boolean bool;
    if (localActionMenuItem != null) {
      bool = localActionMenuItem.invoke();
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void removeGroup(int paramInt)
  {
    ArrayList localArrayList = this.mItems;
    int j = localArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      if (((ActionMenuItem)localArrayList.get(i)).getGroupId() != paramInt)
      {
        i++;
      }
      else
      {
        localArrayList.remove(i);
        j--;
      }
    }
  }
  
  public void removeItem(int paramInt)
  {
    this.mItems.remove(findItemIndex(paramInt));
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = this.mItems;
    int i = localArrayList.size();
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      ActionMenuItem localActionMenuItem = (ActionMenuItem)localArrayList.get(j);
      if (localActionMenuItem.getGroupId() == paramInt)
      {
        localActionMenuItem.setCheckable(paramBoolean1);
        localActionMenuItem.setExclusiveCheckable(paramBoolean2);
      }
    }
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.mItems;
    int i = localArrayList.size();
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      ActionMenuItem localActionMenuItem = (ActionMenuItem)localArrayList.get(j);
      if (localActionMenuItem.getGroupId() == paramInt) {
        localActionMenuItem.setEnabled(paramBoolean);
      }
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.mItems;
    int i = localArrayList.size();
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      ActionMenuItem localActionMenuItem = (ActionMenuItem)localArrayList.get(j);
      if (localActionMenuItem.getGroupId() == paramInt) {
        localActionMenuItem.setVisible(paramBoolean);
      }
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.mIsQwerty = paramBoolean;
  }
  
  public int size()
  {
    return this.mItems.size();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.view.menu.ActionMenu
 * JD-Core Version:    0.7.0.1
 */