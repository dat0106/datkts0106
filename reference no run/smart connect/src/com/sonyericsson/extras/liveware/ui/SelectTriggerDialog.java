package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import java.util.ArrayList;

public class SelectTriggerDialog
  extends DialogFragment
{
  private static final String EXTRA_SHOW_DEVICE = "extra_show_device";
  private static final String EXTRA_SHOW_TIME = "extra_show_time";
  public static final int TRIGGER_DEVICE = 0;
  public static final int TRIGGER_TIME = 1;
  private Activity mActivity;
  private boolean mShowDevice;
  private boolean mShowTime;
  private ArrayList<String> mTriggerNames;
  
  public static SelectTriggerDialog newInstance(boolean paramBoolean1, boolean paramBoolean2)
  {
    SelectTriggerDialog localSelectTriggerDialog = new SelectTriggerDialog();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("extra_show_device", paramBoolean1);
    localBundle.putBoolean("extra_show_time", paramBoolean2);
    localSelectTriggerDialog.setArguments(localBundle);
    return localSelectTriggerDialog;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    this.mShowDevice = getArguments().getBoolean("extra_show_device");
    this.mShowTime = getArguments().getBoolean("extra_show_time");
    this.mTriggerNames = new ArrayList();
    if (this.mShowDevice) {
      this.mTriggerNames.add(getString(2131099798));
    }
    if (this.mShowTime) {
      this.mTriggerNames.add(getString(2131099799));
    }
    new AlertDialog.Builder(this.mActivity).setTitle(2131099927).setItems((CharSequence[])this.mTriggerNames.toArray(new String[this.mTriggerNames.size()]), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        String str = (String)SelectTriggerDialog.this.mTriggerNames.get(paramAnonymousInt);
        if (!SelectTriggerDialog.this.getString(2131099798).equals(str))
        {
          if (SelectTriggerDialog.this.getString(2131099799).equals(str)) {
            ((ExperienceFragment)SelectTriggerDialog.this.getTargetFragment()).onTriggerSelect(1);
          }
        }
        else {
          ((ExperienceFragment)SelectTriggerDialog.this.getTargetFragment()).onTriggerSelect(0);
        }
      }
    }).setNegativeButton(getString(2131099820), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).create();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.SelectTriggerDialog
 * JD-Core Version:    0.7.0.1
 */