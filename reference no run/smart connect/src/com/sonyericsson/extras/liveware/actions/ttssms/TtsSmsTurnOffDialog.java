package com.sonyericsson.extras.liveware.actions.ttssms;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class TtsSmsTurnOffDialog
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
    ((TtsSmsTurnOffActivity)this.mActivity).onCancel();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
    localBuilder.setTitle(2131099867);
    localBuilder.setMessage(2131099949);
    localBuilder.setPositiveButton(getString(2131099950), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((TtsSmsTurnOffActivity)TtsSmsTurnOffDialog.this.mActivity).onTurnOff();
      }
    });
    localBuilder.setNegativeButton(getString(2131099820), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    });
    return localBuilder.create();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.ttssms.TtsSmsTurnOffDialog
 * JD-Core Version:    0.7.0.1
 */