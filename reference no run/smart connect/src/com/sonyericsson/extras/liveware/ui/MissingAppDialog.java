package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class MissingAppDialog
  extends DialogFragment
{
  public static final int CHOOSE_ALTERNATIVE = 1;
  private static final String EXTRA_APP_LABEL = "extra_app_label";
  private static final String EXTRA_TITLE = "extra_title";
  public static final int SEARCH_MARKET;
  private String[] mActionNames;
  private Activity mActivity;
  private String mAppLabel;
  private String mTitle;
  
  public static MissingAppDialog newInstance(String paramString1, String paramString2)
  {
    MissingAppDialog localMissingAppDialog = new MissingAppDialog();
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_title", paramString1);
    localBundle.putString("extra_app_label", paramString2);
    localMissingAppDialog.setArguments(localBundle);
    return localMissingAppDialog;
  }
  
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
    this.mTitle = getArguments().getString("extra_title", "");
    this.mAppLabel = getArguments().getString("extra_app_label", "");
    String[] arrayOfString = new String[2];
    arrayOfString[0] = getString(2131099997);
    arrayOfString[1] = getString(2131099998);
    this.mActionNames = arrayOfString;
    new AlertDialog.Builder(this.mActivity).setTitle(this.mTitle + ": " + this.mAppLabel).setItems(this.mActionNames, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        String str = MissingAppDialog.this.mActionNames[paramAnonymousInt];
        if (!MissingAppDialog.this.getString(2131099997).equals(str))
        {
          if (MissingAppDialog.this.getString(2131099998).equals(str)) {
            ((MissingAppHandlerActivity)MissingAppDialog.this.mActivity).onMissingAppSelection(1);
          }
        }
        else {
          ((MissingAppHandlerActivity)MissingAppDialog.this.mActivity).onMissingAppSelection(0);
        }
      }
    }).setNegativeButton(getString(2131099820), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MissingAppDialog.this.mActivity.finish();
      }
    }).create();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.MissingAppDialog
 * JD-Core Version:    0.7.0.1
 */