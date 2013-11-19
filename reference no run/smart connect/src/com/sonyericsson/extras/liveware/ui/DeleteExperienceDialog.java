package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class DeleteExperienceDialog
  extends DialogFragment
{
  private static String EXTRA_NAME = "extra_name";
  private Activity mActivity;
  
  static DeleteExperienceDialog newInstance(String paramString)
  {
    DeleteExperienceDialog localDeleteExperienceDialog = new DeleteExperienceDialog();
    Bundle localBundle = new Bundle();
    localBundle.putString(EXTRA_NAME, paramString);
    localDeleteExperienceDialog.setArguments(localBundle);
    return localDeleteExperienceDialog;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    String str2 = getArguments().getString(EXTRA_NAME);
    String str1 = getString(2131099810);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = str2;
    str1 = String.format(str1, arrayOfObject);
    new AlertDialog.Builder(this.mActivity).setTitle(getString(2131099809)).setMessage(str1).setPositiveButton(getString(2131099821), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((ExperienceFragment)DeleteExperienceDialog.this.getTargetFragment()).onDeleteExperience();
      }
    }).setNegativeButton(getString(2131099820), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).create();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.DeleteExperienceDialog
 * JD-Core Version:    0.7.0.1
 */