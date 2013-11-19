package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.utils.MarketUtils;

public class UpdateActivity
  extends BaseDialogActivity
{
  private static final String UPDATE_DIALOG = "update_dialog";
  private UpdateDialog mDialog;
  
  private void showDialogFragment(DialogFragment paramDialogFragment, String paramString)
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    if (getFragmentManager().findFragmentByTag(paramString) == null)
    {
      localFragmentTransaction.addToBackStack(null);
      paramDialogFragment.show(localFragmentTransaction, paramString);
    }
  }
  
  public static void showUpdateDialog(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, UpdateActivity.class);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mDialog = new UpdateDialog();
    showDialogFragment(this.mDialog, "update_dialog");
  }
  
  public static class UpdateDialog
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
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
      localBuilder.setTitle(2131099648);
      localBuilder.setMessage(2131099973);
      localBuilder.setPositiveButton(2131099974, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          MarketUtils.launchInfo(UpdateActivity.UpdateDialog.this.mActivity, "com.sonyericsson.extras.liveware");
        }
      });
      localBuilder.setCancelable(true);
      return localBuilder.create();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.UpdateActivity
 * JD-Core Version:    0.7.0.1
 */