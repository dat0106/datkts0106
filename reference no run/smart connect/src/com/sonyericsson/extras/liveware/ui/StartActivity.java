package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import com.sonyericsson.extras.liveware.utils.PreferenceHelper;

public class StartActivity
  extends BaseActivity
{
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
    if (!PackageUtils.disableAppIfNotOwner(this))
    {
      if (!PreferenceHelper.isFirstLaunch(this))
      {
        HomeScreenActivity.show(this);
        finish();
      }
      else
      {
        WelcomeActivity.show(this);
        finish();
      }
    }
    else {
      showDialogFragment(new OnlyOwnerDialog(), "OnlyOwnerDialog");
    }
  }
  
  public static class OnlyOwnerDialog
    extends DialogFragment
  {
    private Activity mActivity;
    
    public void onAttach(Activity paramActivity)
    {
      super.onAttach(paramActivity);
      this.mActivity = paramActivity;
    }
    
    public void onCancel(DialogInterface paramDialogInterface)
    {
      super.onCancel(paramDialogInterface);
      this.mActivity.finish();
    }
    
    public Dialog onCreateDialog(Bundle paramBundle)
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
      localBuilder.setTitle(2131099648);
      localBuilder.setMessage(2131099993);
      localBuilder.setNeutralButton(2131099767, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          StartActivity.OnlyOwnerDialog.this.mActivity.finish();
        }
      });
      localBuilder.setCancelable(true);
      return localBuilder.create();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.StartActivity
 * JD-Core Version:    0.7.0.1
 */