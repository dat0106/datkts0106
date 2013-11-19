package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MillerDeprecatedDialog
  extends DialogFragment
{
  private static final String EXTRA_MILLER_IN_SYSTEM_APP = "EXTRA_MILLER_IN_SYSTEM_APP";
  private Activity mActivity;
  private CheckBox mShowAgainView;
  
  static MillerDeprecatedDialog newInstance(boolean paramBoolean)
  {
    MillerDeprecatedDialog localMillerDeprecatedDialog = new MillerDeprecatedDialog();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("EXTRA_MILLER_IN_SYSTEM_APP", paramBoolean);
    localMillerDeprecatedDialog.setArguments(localBundle);
    return localMillerDeprecatedDialog;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ((MillerDeprecatedActivity)this.mActivity).onDialogDone(this.mShowAgainView.isChecked());
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    View localView1 = this.mActivity.getLayoutInflater().inflate(2130903073, null);
    View localView2 = this.mActivity.getLayoutInflater().inflate(2130903046, null);
    boolean bool = getArguments().getBoolean("EXTRA_MILLER_IN_SYSTEM_APP");
    TextView localTextView = (TextView)localView1.findViewById(2131558483);
    this.mShowAgainView = ((CheckBox)localView1.findViewById(2131558484));
    if (!bool) {
      localTextView.setText(2131099922);
    } else {
      localTextView.setText(2131099923);
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
    localBuilder.setCustomTitle(localView2);
    localBuilder.setView(localView1);
    localBuilder.setNegativeButton(getString(2131099767), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((MillerDeprecatedActivity)MillerDeprecatedDialog.this.mActivity).onDialogDone(MillerDeprecatedDialog.this.mShowAgainView.isChecked());
      }
    });
    return localBuilder.create();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.MillerDeprecatedDialog
 * JD-Core Version:    0.7.0.1
 */