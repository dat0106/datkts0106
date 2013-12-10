package android.support.v4.app;

import android.view.View;
import com.actionbarsherlock.ActionBarSherlock.OnCreatePanelMenuListener;
import com.actionbarsherlock.ActionBarSherlock.OnMenuItemSelectedListener;
import com.actionbarsherlock.ActionBarSherlock.OnPreparePanelListener;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import java.util.ArrayList;

public abstract class _ActionBarSherlockTrojanHorse
  extends FragmentActivity
  implements ActionBarSherlock.OnCreatePanelMenuListener, ActionBarSherlock.OnPreparePanelListener, ActionBarSherlock.OnMenuItemSelectedListener
{
  private static final boolean DEBUG = false;
  private static final String TAG = "_ActionBarSherlockTrojanHorse";
  private ArrayList<Fragment> mCreatedMenus;
  
  public abstract MenuInflater getSupportMenuInflater();
  
  public abstract boolean onCreateOptionsMenu(Menu paramMenu);
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    boolean bool1;
    boolean bool2;
    ArrayList localArrayList;
    if (paramInt != 0)
    {
      bool1 = false;
    }
    else
    {
      bool2 = onCreateOptionsMenu(paramMenu);
      MenuInflater localMenuInflater = getSupportMenuInflater();
      bool1 = false;
      localArrayList = null;
      if (this.mFragments.mActive == null) {}
    }
    for (int j = 0;; j++)
    {
      int i;
      if (j >= this.mFragments.mAdded.size())
      {
        if (this.mCreatedMenus != null) {}
        for (i = 0;; i++)
        {
          if (i >= this.mCreatedMenus.size())
          {
            this.mCreatedMenus = localArrayList;
            bool1 = bool2 | bool1;
            return bool1;
          }
          localFragment = (Fragment)this.mCreatedMenus.get(i);
          if ((localArrayList == null) || (!localArrayList.contains(localFragment))) {
            localFragment.onDestroyOptionsMenu();
          }
        }
      }
      Fragment localFragment = (Fragment)this.mFragments.mAdded.get(j);
      if ((localFragment != null) && (!localFragment.mHidden) && (localFragment.mHasMenu) && (localFragment.mMenuVisible) && ((localFragment instanceof OnCreateOptionsMenuListener)))
      {
        bool1 = true;
        ((OnCreateOptionsMenuListener)localFragment).onCreateOptionsMenu(paramMenu, i);
        if (localArrayList == null) {
          localArrayList = new ArrayList();
        }
        localArrayList.add(localFragment);
      }
    }
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    boolean bool = true;
    if (paramInt == 0)
    {
      if (onOptionsItemSelected(paramMenuItem)) {
        break label110;
      }
      if (this.mFragments.mActive == null) {}
    }
    for (int i = 0;; i++)
    {
      if (i >= this.mFragments.mAdded.size())
      {
        bool = false;
      }
      else
      {
        Fragment localFragment = (Fragment)this.mFragments.mAdded.get(i);
        if ((localFragment == null) || (localFragment.mHidden) || (!localFragment.mHasMenu) || (!localFragment.mMenuVisible) || (!(localFragment instanceof OnOptionsItemSelectedListener)) || (!((OnOptionsItemSelectedListener)localFragment).onOptionsItemSelected(paramMenuItem))) {
          continue;
        }
      }
      label110:
      return bool;
    }
  }
  
  public abstract boolean onOptionsItemSelected(MenuItem paramMenuItem);
  
  public abstract boolean onPrepareOptionsMenu(Menu paramMenu);
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (paramInt != 0)
    {
      bool1 = false;
    }
    else
    {
      bool2 = onPrepareOptionsMenu(paramMenu);
      bool3 = false;
      if (this.mFragments.mActive == null) {}
    }
    for (int i = 0;; i++)
    {
      if (i >= this.mFragments.mAdded.size())
      {
        bool1 = (bool2 | bool3) & paramMenu.hasVisibleItems();
        return bool1;
      }
      Fragment localFragment = (Fragment)this.mFragments.mAdded.get(i);
      if ((localFragment != null) && (!localFragment.mHidden) && (localFragment.mHasMenu) && (localFragment.mMenuVisible) && ((localFragment instanceof OnPrepareOptionsMenuListener)))
      {
        bool3 = true;
        ((OnPrepareOptionsMenuListener)localFragment).onPrepareOptionsMenu(paramMenu);
      }
    }
  }
  
  public static abstract interface OnOptionsItemSelectedListener
  {
    public abstract boolean onOptionsItemSelected(MenuItem paramMenuItem);
  }
  
  public static abstract interface OnPrepareOptionsMenuListener
  {
    public abstract void onPrepareOptionsMenu(Menu paramMenu);
  }
  
  public static abstract interface OnCreateOptionsMenuListener
  {
    public abstract void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app._ActionBarSherlockTrojanHorse
 * JD-Core Version:    0.7.0.1
 */