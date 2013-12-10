package com.actionbarsherlock.app;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app._ActionBarSherlockTrojanHorse.OnCreateOptionsMenuListener;
import android.support.v4.app._ActionBarSherlockTrojanHorse.OnOptionsItemSelectedListener;
import android.support.v4.app._ActionBarSherlockTrojanHorse.OnPrepareOptionsMenuListener;
import com.actionbarsherlock.internal.view.menu.MenuItemWrapper;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;

public class SherlockDialogFragment
  extends DialogFragment
  implements _ActionBarSherlockTrojanHorse.OnCreateOptionsMenuListener, _ActionBarSherlockTrojanHorse.OnPrepareOptionsMenuListener, _ActionBarSherlockTrojanHorse.OnOptionsItemSelectedListener
{
  private SherlockFragmentActivity mActivity;
  
  public SherlockFragmentActivity getSherlockActivity()
  {
    return this.mActivity;
  }
  
  public void onAttach(Activity paramActivity)
  {
    if ((paramActivity instanceof SherlockFragmentActivity))
    {
      this.mActivity = ((SherlockFragmentActivity)paramActivity);
      super.onAttach(paramActivity);
      return;
    }
    throw new IllegalStateException(getClass().getSimpleName() + " must be attached to a SherlockFragmentActivity.");
  }
  
  public final void onCreateOptionsMenu(android.view.Menu paramMenu, android.view.MenuInflater paramMenuInflater)
  {
    onCreateOptionsMenu(new MenuWrapper(paramMenu), this.mActivity.getSupportMenuInflater());
  }
  
  public void onCreateOptionsMenu(com.actionbarsherlock.view.Menu paramMenu, com.actionbarsherlock.view.MenuInflater paramMenuInflater) {}
  
  public void onDetach()
  {
    this.mActivity = null;
    super.onDetach();
  }
  
  public final boolean onOptionsItemSelected(android.view.MenuItem paramMenuItem)
  {
    return onOptionsItemSelected(new MenuItemWrapper(paramMenuItem));
  }
  
  public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem paramMenuItem)
  {
    return false;
  }
  
  public final void onPrepareOptionsMenu(android.view.Menu paramMenu)
  {
    onPrepareOptionsMenu(new MenuWrapper(paramMenu));
  }
  
  public void onPrepareOptionsMenu(com.actionbarsherlock.view.Menu paramMenu) {}
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.app.SherlockDialogFragment
 * JD-Core Version:    0.7.0.1
 */