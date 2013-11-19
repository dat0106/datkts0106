package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class DeleteItemDialog
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
    new AlertDialog.Builder(this.mActivity).setMessage(getString(2131099836)).setPositiveButton(getString(2131099821), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((DeleteItemsActivity)DeleteItemDialog.this.mActivity).onDeleteConfirm();
      }
    }).setNegativeButton(getString(2131099820), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((DeleteItemsActivity)DeleteItemDialog.this.mActivity).onDeleteCancel();
      }
    }).create();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.DeleteItemDialog
 * JD-Core Version:    0.7.0.1
 */