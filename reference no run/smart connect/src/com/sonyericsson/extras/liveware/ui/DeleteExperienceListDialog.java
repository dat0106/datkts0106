package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class DeleteExperienceListDialog
  extends DialogFragment
{
  private Activity mActivity;
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    new AlertDialog.Builder(this.mActivity).setMessage(2131099811).setPositiveButton(2131099821, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((ExperienceListFragment)DeleteExperienceListDialog.this.getTargetFragment()).onDelete();
      }
    }).setNegativeButton(2131099820, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).create();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.DeleteExperienceListDialog
 * JD-Core Version:    0.7.0.1
 */