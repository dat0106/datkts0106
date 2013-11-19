package com.sonyericsson.extras.liveware.ui;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.asf.EventHandler;
import com.sonyericsson.extras.liveware.asf.event.SmartTagsHandler;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class MillerDeprecatedActivity
  extends BaseDialogActivity
{
  private static final String DIALOG_TAG = "miller_depricated_dialog_tag";
  private static final String INTENT_EXTRA_MILLER_IS_SYSTEM_APP = "INTENT_EXTRA_MILLER_IS_SYSTEM_APP";
  private static final String INTENT_EXTRA_TAG_PRODUCT_ID = "INTENT_EXTRA_TAG_PRODUCT_ID";
  String mTagProductId;
  
  private void fireDelayedTagTriggerIntent()
  {
    Dbg.d("MillerDepricatedActivity fireDelayedTagTriggerIntent");
    EventHandler.sendIntentsToDeviceService(this, SmartTagsHandler.getTriggerIntents(this, this.mTagProductId));
  }
  
  public static void showDialog(Context paramContext, boolean paramBoolean, String paramString)
  {
    Intent localIntent = new Intent(paramContext, MillerDeprecatedActivity.class);
    localIntent.addFlags(335544320);
    localIntent.putExtra("INTENT_EXTRA_MILLER_IS_SYSTEM_APP", paramBoolean);
    localIntent.putExtra("INTENT_EXTRA_TAG_PRODUCT_ID", paramString);
    paramContext.startActivity(localIntent);
  }
  
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
    Intent localIntent = getIntent();
    boolean bool = localIntent.getBooleanExtra("INTENT_EXTRA_MILLER_IS_SYSTEM_APP", true);
    this.mTagProductId = localIntent.getStringExtra("INTENT_EXTRA_TAG_PRODUCT_ID");
    showDialogFragment(MillerDeprecatedDialog.newInstance(bool), "miller_depricated_dialog_tag");
  }
  
  public void onDialogDone(boolean paramBoolean)
  {
    if (paramBoolean) {
      SmartTagsHandler.neverShowMillerDeprecatedDialogAgain(this);
    }
    finish();
    fireDelayedTagTriggerIntent();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.MillerDeprecatedActivity
 * JD-Core Version:    0.7.0.1
 */