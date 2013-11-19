package com.sonyericsson.extras.liveware.ui;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class ExperienceActivity
  extends BaseActivity
  implements ExperienceFragmentContainer
{
  private static final String EXTRA_DEVICE_ID = "extra_device_id";
  private static final String EXTRA_EXPERIENCE_ID = "extra_experience_id";
  
  private void goUp()
  {
    HomeScreenActivity.showExperience(this, -2L);
    finish();
  }
  
  public static void newExperience(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, ExperienceActivity.class);
    localIntent.putExtra("extra_device_id", paramLong);
    paramContext.startActivity(localIntent);
  }
  
  public static void show(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, ExperienceActivity.class);
    localIntent.putExtra("extra_experience_id", paramLong);
    localIntent.addFlags(67108864);
    paramContext.startActivity(localIntent);
  }
  
  public void closeExperience()
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Dbg.d("ExperienceActivity.onCreate()");
    setContentView(2130903057);
    if (paramBundle == null)
    {
      long l2 = getIntent().getLongExtra("extra_experience_id", -1L);
      long l1 = getIntent().getLongExtra("extra_device_id", -1L);
      ExperienceFragment localExperienceFragment;
      if (l2 == -1L) {
        localExperienceFragment = ExperienceFragment.newInstanceWithDevice(l1);
      } else {
        localExperienceFragment = ExperienceFragment.newInstance(l2);
      }
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.add(2131558437, localExperienceFragment);
      localFragmentTransaction.commit();
    }
    getActionBar().setDisplayHomeAsUpEnabled(true);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Dbg.d("ExperienceActivity.onOptionsItemSelected");
    boolean bool;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = false;
      break;
    case 16908332: 
      goUp();
      bool = true;
    }
    return bool;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ExperienceActivity
 * JD-Core Version:    0.7.0.1
 */