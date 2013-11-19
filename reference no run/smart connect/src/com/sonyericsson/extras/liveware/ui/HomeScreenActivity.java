package com.sonyericsson.extras.liveware.ui;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;
import com.sonyericsson.extras.liveware.preference.SettingsActivity;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.PreferenceHelper;
import com.sonyericsson.extras.liveware.utils.SyncedProperty;

public class HomeScreenActivity
  extends BaseActivity
  implements ExperienceFragmentContainer
{
  private static final String EXTRA_DEVICE_ID = "extra_device_id";
  private static final String EXTRA_EXPERIENCE_ID = "extra_experience_id";
  private static final String START_WITH_DEVICE_TAB = "com.sonyericsson.extras.liveware.START_WITH_DEVICE_TAB";
  private static final int TAB_INDEX_DEVICE = 0;
  private static final int TAB_INDEX_EXPERIENCE = 1;
  private long mDeviceId = -1L;
  private View mDeviceTabView;
  private boolean mDualPane = false;
  private long mExperienceId = -2L;
  private View mExperienceTabView;
  SyncedProperty<Boolean> mSaved = new SyncedProperty(Boolean.valueOf(false));
  private ViewGroup mViewGroup;
  
  private void checkLaunchExperienceActivity()
  {
    if (!this.mDualPane) {
      if (this.mExperienceId == -2L)
      {
        if (this.mDeviceId != -1L)
        {
          finish();
          ExperienceActivity.newExperience(this, this.mDeviceId);
          this.mDeviceId = -1L;
        }
      }
      else
      {
        finish();
        ExperienceActivity.show(this, this.mExperienceId);
        this.mExperienceId = -2L;
      }
    }
  }
  
  public static void createExperience(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, HomeScreenActivity.class);
    localIntent.putExtra("extra_device_id", paramLong);
    localIntent.addFlags(335544320);
    paramContext.startActivity(localIntent);
  }
  
  private void getInfoFromIntent(Intent paramIntent)
  {
    if (paramIntent.hasExtra("extra_experience_id")) {
      this.mExperienceId = paramIntent.getLongExtra("extra_experience_id", -2L);
    }
    if (paramIntent.hasExtra("extra_device_id")) {
      this.mDeviceId = paramIntent.getLongExtra("extra_device_id", -1L);
    }
    if (paramIntent.getAction() != null) {
      SmartConnectAnalytics.trackEvent(this, "Launch", "Notification");
    }
  }
  
  public static Intent getShowExperienceIntent(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, HomeScreenActivity.class);
    localIntent.putExtra("extra_experience_id", paramLong);
    localIntent.addFlags(335544320);
    return localIntent;
  }
  
  private boolean isShowingEventsTab()
  {
    boolean bool;
    if (((Integer)getActionBar().getSelectedTab().getTag()).intValue() != 1) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void show(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, HomeScreenActivity.class);
    localIntent.addFlags(67108864);
    paramContext.startActivity(localIntent);
  }
  
  public static void showDeviceTab(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, HomeScreenActivity.class);
    localIntent.putExtra("com.sonyericsson.extras.liveware.START_WITH_DEVICE_TAB", true);
    localIntent.addFlags(335544320);
    paramContext.startActivity(localIntent);
  }
  
  public static void showExperience(Context paramContext, long paramLong)
  {
    paramContext.startActivity(getShowExperienceIntent(paramContext, paramLong));
  }
  
  public void closeExperience()
  {
    Dbg.d("HomeScreenActivity.closeExperience");
    if (this.mDualPane)
    {
      Object localObject = getFragmentManager();
      Fragment localFragment = ((FragmentManager)localObject).findFragmentById(2131558438);
      FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      localFragmentTransaction.remove(localFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      localObject = (ExperienceListFragment)((FragmentManager)localObject).findFragmentById(2131558437);
      if (localObject != null) {
        ((ExperienceListFragment)localObject).resetSelection();
      }
    }
  }
  
  public void createNewExperience(long paramLong)
  {
    this.mDeviceId = paramLong;
    getActionBar().getTabAt(1).select();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Dbg.d("HomeScreenActivity.onCreate ");
    Object localObject = LayoutInflater.from(this);
    this.mDeviceTabView = ((LayoutInflater)localObject).inflate(2130903082, null);
    this.mExperienceTabView = ((LayoutInflater)localObject).inflate(2130903057, null);
    localObject = this.mExperienceTabView.findViewById(2131558438);
    boolean bool;
    if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    this.mDualPane = bool;
    if (paramBundle == null)
    {
      getInfoFromIntent(getIntent());
    }
    else
    {
      this.mExperienceId = paramBundle.getLong("extra_experience_id", -2L);
      this.mDeviceId = paramBundle.getLong("extra_device_id", -1L);
    }
    checkLaunchExperienceActivity();
    setContentView(2130903063);
    this.mViewGroup = ((ViewGroup)findViewById(2131558458));
    ActionBar localActionBar = getActionBar();
    localActionBar.setNavigationMode(2);
    localActionBar.addTab(localActionBar.newTab().setText(2131099792).setTabListener(new DeviceTabListener(null)).setTag(Integer.valueOf(0)));
    localActionBar.addTab(localActionBar.newTab().setText(2131099793).setTabListener(new ExperienceTabListener(null)).setTag(Integer.valueOf(1)));
    int i;
    if (PreferenceHelper.readLastUsedTab(this) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    getActionBar().getTabAt(i).select();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131689479, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    Dbg.d("HomeScreenActivity.onNewIntent ");
    getInfoFromIntent(paramIntent);
    checkLaunchExperienceActivity();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (Dbg.d()) {
        Dbg.d("Illegal menu item.");
      }
      break;
    case 2131558563: 
      WelcomeActivity.show(this);
      break;
    case 2131558564: 
      SettingsActivity.show(this);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    super.onPause();
    Dbg.d("HomeScreenActivity.onPause ");
    PreferenceHelper.saveLastUsedTab(this, ((Integer)getActionBar().getSelectedTab().getTag()).intValue());
  }
  
  protected void onResume()
  {
    super.onResume();
    Dbg.d("HomeScreenActivity.onResume ");
    this.mSaved.set(Boolean.valueOf(false));
    Intent localIntent = getIntent();
    if (localIntent.getBooleanExtra("com.sonyericsson.extras.liveware.START_WITH_DEVICE_TAB", false))
    {
      invalidateOptionsMenu();
      getActionBar().getTabAt(0).select();
      localIntent.removeExtra("com.sonyericsson.extras.liveware.START_WITH_DEVICE_TAB");
    }
    if (this.mExperienceId == -2L)
    {
      if (this.mDeviceId != -1L) {
        getActionBar().getTabAt(1).select();
      }
    }
    else {
      getActionBar().getTabAt(1).select();
    }
    getActionBar().setDisplayHomeAsUpEnabled(false);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mSaved.set(Boolean.valueOf(true));
    paramBundle.putLong("extra_experience_id", this.mExperienceId);
    paramBundle.putLong("extra_device_id", this.mDeviceId);
  }
  
  public void setTitle(int paramInt) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public void showExperience(long paramLong)
  {
    Dbg.d("showExperience: " + paramLong);
    if ((!this.mDualPane) || (!isShowingEventsTab()))
    {
      ExperienceActivity.show(this, paramLong);
    }
    else
    {
      Object localObject = getFragmentManager();
      ExperienceFragment localExperienceFragment = ExperienceFragment.newInstance(paramLong);
      localObject = ((FragmentManager)localObject).beginTransaction();
      ((FragmentTransaction)localObject).replace(2131558438, localExperienceFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  public void showExperienceTab()
  {
    getActionBar().getTabAt(1).select();
  }
  
  public void showInitialExperience(long paramLong)
  {
    if (Dbg.d()) {
      Dbg.d("HomeScreenActivity.showInitialExperience: " + paramLong);
    }
    if ((this.mDualPane) && (isShowingEventsTab()) && (getFragmentManager().findFragmentById(2131558438) == null))
    {
      ExperienceFragment localExperienceFragment = ExperienceFragment.newInstance(paramLong);
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131558438, localExperienceFragment);
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  private class DeviceTabListener
    implements ActionBar.TabListener
  {
    private DeviceTabListener() {}
    
    public void onTabReselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
    {
      HomeScreenActivity.this.getActionBar().setDisplayHomeAsUpEnabled(false);
    }
    
    public void onTabSelected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
    {
      Dbg.d("HomeScreenActivity DeviceTabListener.onTabSelected");
      if (!((Boolean)HomeScreenActivity.this.mSaved.get()).booleanValue())
      {
        FragmentManager localFragmentManager = HomeScreenActivity.this.getFragmentManager();
        FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
        Fragment localFragment = localFragmentManager.findFragmentById(2131558510);
        if (localFragment == null) {
          localFragmentTransaction.add(2131558510, new SmartDeviceFragment());
        } else {
          localFragmentTransaction.attach(localFragment);
        }
        localFragmentTransaction.commit();
        HomeScreenActivity.this.mViewGroup.addView(HomeScreenActivity.this.mDeviceTabView);
        localFragmentManager.executePendingTransactions();
        onTabReselected(paramTab, paramFragmentTransaction);
      }
      else
      {
        Dbg.w("HomeScreenActivity DeviceTabListener.onTabSelected ignored");
      }
    }
    
    public void onTabUnselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
    {
      Dbg.d("HomeScreenActivity DeviceTabListener.onTabUnselected");
      if (!((Boolean)HomeScreenActivity.this.mSaved.get()).booleanValue())
      {
        FragmentManager localFragmentManager = HomeScreenActivity.this.getFragmentManager();
        Fragment localFragment = localFragmentManager.findFragmentById(2131558510);
        if (localFragment != null)
        {
          FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
          localFragmentTransaction.detach(localFragment);
          localFragmentTransaction.commit();
          localFragmentManager.executePendingTransactions();
        }
        HomeScreenActivity.this.mViewGroup.removeAllViews();
      }
      else
      {
        Dbg.w("HomeScreenActivity DeviceTabListener.onTabUnselected ignored");
      }
    }
  }
  
  private class ExperienceTabListener
    implements ActionBar.TabListener
  {
    private ExperienceTabListener() {}
    
    public void onTabReselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
    {
      Dbg.d("HomeScreenActivity ExperienceTabListener.onTabReselected");
      if (!((Boolean)HomeScreenActivity.this.mSaved.get()).booleanValue())
      {
        FragmentManager localFragmentManager = HomeScreenActivity.this.getFragmentManager();
        Object localObject = localFragmentManager.beginTransaction();
        Fragment localFragment = localFragmentManager.findFragmentById(2131558437);
        if (HomeScreenActivity.this.mExperienceId == -2L)
        {
          if (localFragment == null) {
            ((FragmentTransaction)localObject).add(2131558437, ExperienceListFragment.newInstance(HomeScreenActivity.this.mDualPane, HomeScreenActivity.this.mExperienceId));
          } else {
            ((FragmentTransaction)localObject).attach(localFragment);
          }
        }
        else
        {
          if (localFragment != null) {
            ((FragmentTransaction)localObject).remove(localFragment);
          }
          ((FragmentTransaction)localObject).add(2131558437, ExperienceListFragment.newInstance(HomeScreenActivity.this.mDualPane, HomeScreenActivity.this.mExperienceId));
        }
        localFragment = localFragmentManager.findFragmentById(2131558438);
        if (HomeScreenActivity.this.mDeviceId == -1L)
        {
          if (HomeScreenActivity.this.mExperienceId == -2L)
          {
            if (localFragment != null) {
              ((FragmentTransaction)localObject).attach(localFragment);
            }
          }
          else
          {
            if (!HomeScreenActivity.this.mDualPane)
            {
              ExperienceActivity.show(HomeScreenActivity.this, HomeScreenActivity.this.mExperienceId);
            }
            else
            {
              if (localFragment != null) {
                ((FragmentTransaction)localObject).remove(localFragment);
              }
              ((FragmentTransaction)localObject).add(2131558438, ExperienceFragment.newInstance(HomeScreenActivity.this.mExperienceId));
            }
            HomeScreenActivity.this.mExperienceId = -2L;
          }
        }
        else
        {
          if (!HomeScreenActivity.this.mDualPane)
          {
            ExperienceActivity.newExperience(HomeScreenActivity.this, HomeScreenActivity.this.mDeviceId);
          }
          else
          {
            if (localFragment != null) {
              ((FragmentTransaction)localObject).remove(localFragment);
            }
            ((FragmentTransaction)localObject).add(2131558438, ExperienceFragment.newInstanceWithDevice(HomeScreenActivity.this.mDeviceId));
          }
          HomeScreenActivity.this.mDeviceId = -1L;
        }
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
        localObject = HomeScreenActivity.this.getActionBar();
        boolean bool;
        if (localFragmentManager.getBackStackEntryCount() <= 0) {
          bool = false;
        } else {
          bool = true;
        }
        ((ActionBar)localObject).setDisplayHomeAsUpEnabled(bool);
      }
      else
      {
        Dbg.w("HomeScreenActivity ExperienceTabListener.onTabReselected ignored");
      }
    }
    
    public void onTabSelected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
    {
      Dbg.d("HomeScreenActivity ExperienceTabListener.onTabSelected");
      onTabReselected(paramTab, paramFragmentTransaction);
      HomeScreenActivity.this.mViewGroup.addView(HomeScreenActivity.this.mExperienceTabView);
      HomeScreenActivity.this.getFragmentManager().executePendingTransactions();
    }
    
    public void onTabUnselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
    {
      Dbg.d("HomeScreenActivity ExperienceTabListener.onTabUnselected");
      if (!((Boolean)HomeScreenActivity.this.mSaved.get()).booleanValue())
      {
        FragmentManager localFragmentManager = HomeScreenActivity.this.getFragmentManager();
        Fragment localFragment2 = localFragmentManager.findFragmentById(2131558437);
        Fragment localFragment1 = localFragmentManager.findFragmentById(2131558438);
        if ((localFragment2 != null) || (localFragment1 != null))
        {
          FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
          if (localFragment2 != null) {
            localFragmentTransaction.detach(localFragment2);
          }
          if (localFragment1 != null) {
            localFragmentTransaction.detach(localFragment1);
          }
          localFragmentTransaction.commitAllowingStateLoss();
          localFragmentManager.executePendingTransactions();
        }
        HomeScreenActivity.this.mViewGroup.removeAllViews();
      }
      else
      {
        Dbg.w("HomeScreenActivity ExperienceTabListener.onTabUnselected ignored");
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.HomeScreenActivity
 * JD-Core Version:    0.7.0.1
 */