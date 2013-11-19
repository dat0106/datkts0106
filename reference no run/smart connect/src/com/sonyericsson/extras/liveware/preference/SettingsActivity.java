package com.sonyericsson.extras.liveware.preference;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.sonyericsson.extras.liveware.ui.BaseActivity;

public class SettingsActivity
  extends BaseActivity
{
  public static void show(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, SettingsActivity.class));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    getFragmentManager().beginTransaction().replace(16908290, new SettingsFragment()).commit();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = false;
      break;
    case 16908332: 
      finish();
      bool = true;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.preference.SettingsActivity
 * JD-Core Version:    0.7.0.1
 */