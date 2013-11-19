package com.sonyericsson.extras.liveware.ui;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class FirstTimeActivity
  extends BaseDialogActivity
{
  private static final String DIALOG_TAG = "first_time_dialog_tag";
  public static final String EXTRA_EXPERIENCE_ID = "extra_experience_id";
  private Experience mExperience;
  
  public static void showDialog(Context paramContext, Experience paramExperience)
  {
    Intent localIntent = new Intent(paramContext, FirstTimeActivity.class);
    localIntent.putExtra("extra_experience_id", paramExperience.getId());
    localIntent.addFlags(335544320);
    paramContext.startActivity(localIntent);
  }
  
  private void showDialogFragment(DialogFragment paramDialogFragment, String paramString)
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    if (getFragmentManager().findFragmentByTag(paramString) == null)
    {
      localFragmentTransaction.addToBackStack(null);
      paramDialogFragment.show(localFragmentTransaction, paramString);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(this);
    long l = getIntent().getLongExtra("extra_experience_id", -1L);
    if (l != -1L)
    {
      this.mExperience = localExperienceManager.getExperience(l);
      if (this.mExperience != null)
      {
        showDialogFragment(FirstTimeDeviceDialog.newInstance(this.mExperience), "first_time_dialog_tag");
      }
      else
      {
        if (Dbg.e()) {
          Dbg.e("FirstTimeActivity mExperience == null");
        }
        finish();
      }
    }
    else
    {
      if (Dbg.e()) {
        Dbg.e("FirstTimeActivity experienceId == -1");
      }
      finish();
    }
  }
  
  public void onDialogCancel(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      finish();
    }
    else
    {
      this.mExperience.setEnabledState(0);
      ExperienceUpdateTask localExperienceUpdateTask = new ExperienceUpdateTask(false);
      Experience[] arrayOfExperience = new Experience[1];
      arrayOfExperience[0] = this.mExperience;
      localExperienceUpdateTask.execute(arrayOfExperience);
    }
  }
  
  public void onDialogNext()
  {
    this.mExperience.setEnabledState(2);
    ExperienceUpdateTask localExperienceUpdateTask = new ExperienceUpdateTask(true);
    Experience[] arrayOfExperience = new Experience[1];
    arrayOfExperience[0] = this.mExperience;
    localExperienceUpdateTask.execute(arrayOfExperience);
  }
  
  private class ExperienceUpdateTask
    extends AsyncTask<Experience, Void, Void>
  {
    private final boolean mShowEdit;
    
    ExperienceUpdateTask(boolean paramBoolean)
    {
      this.mShowEdit = paramBoolean;
    }
    
    protected Void doInBackground(Experience... paramVarArgs)
    {
      ExperienceManager.getInstance(FirstTimeActivity.this).updateExperience(paramVarArgs[0]);
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      FirstTimeActivity.this.finish();
      if (this.mShowEdit) {
        HomeScreenActivity.showExperience(FirstTimeActivity.this, FirstTimeActivity.this.mExperience.getId());
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.FirstTimeActivity
 * JD-Core Version:    0.7.0.1
 */