package com.sonyericsson.extras.liveware.actions.urllaunch;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.ui.BaseDialogActivity;
import com.sonyericsson.extras.liveware.ui.EditDialogFragment;
import com.sonyericsson.extras.liveware.ui.EditDialogFragment.EditDialogListener;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class UrlSettings
  extends BaseDialogActivity
  implements EditDialogFragment.EditDialogListener
{
  private static final int DLG_URI_ERROR = 2;
  private static final String HTTP_PREFIX = "http://";
  private static final String TAG_EDIT_URL = "tag_edit_url";
  private String mRawSetting;
  
  private Dialog getErrorDialog()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setMessage(getString(2131099869)).setNeutralButton(2131099767, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        UrlSettings.this.showEditDialog();
      }
    });
    return localBuilder.create();
  }
  
  private void showEditDialog()
  {
    String str = this.mRawSetting;
    if (TextUtils.isEmpty(str)) {
      str = "http://";
    }
    EditDialogFragment localEditDialogFragment = new EditDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("extra_title_id", 2131099855);
    localBundle.putInt("extra_input_type", 17);
    localBundle.putString("extra_value", str);
    localEditDialogFragment.setArguments(localBundle);
    UIUtils.showDialogFragment(getFragmentManager(), localEditDialogFragment, "tag_edit_url");
  }
  
  public void onCancel(int paramInt)
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRawSetting = getIntent().getStringExtra("setting_raw");
    showEditDialog();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Dialog localDialog;
    switch (paramInt)
    {
    default: 
      localDialog = super.onCreateDialog(paramInt);
      break;
    case 2: 
      Dbg.d("onCreateDialog, error");
      localDialog = getErrorDialog();
    }
    return localDialog;
  }
  
  protected Dialog onCreateDialog(int paramInt, Bundle paramBundle)
  {
    return super.onCreateDialog(paramInt, paramBundle);
  }
  
  public void onDone(String paramString, int paramInt)
  {
    if (Uri.parse(paramString).getScheme() == null) {
      showDialog(2);
    } else {
      ActionUtils.finishActivityWithSetting(this, paramString, UrlLauncher.getLabelByRawSetting(this, paramString));
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.urllaunch.UrlSettings
 * JD-Core Version:    0.7.0.1
 */