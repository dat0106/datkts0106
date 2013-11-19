package com.sonyericsson.extras.liveware.actions.ttssms;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.ui.BaseDialogActivity;

public class TtsSmsTurnOffActivity
  extends BaseDialogActivity
{
  private static final String DIALOG_TAG = "tts_sms_turn_off";
  
  private void showDialogFragment(DialogFragment paramDialogFragment, String paramString)
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    if (getFragmentManager().findFragmentByTag(paramString) == null)
    {
      localFragmentTransaction.addToBackStack(null);
      paramDialogFragment.show(localFragmentTransaction, paramString);
    }
  }
  
  public void onCancel()
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    showDialogFragment(new TtsSmsTurnOffDialog(), "tts_sms_turn_off");
  }
  
  public void onTurnOff()
  {
    new PreferenceUpdateTask(null).execute(new Void[0]);
    finish();
  }
  
  private class PreferenceUpdateTask
    extends AsyncTask<Void, Void, Void>
  {
    private PreferenceUpdateTask() {}
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      TtsSmsUtils.enablesSpeakSms(TtsSmsTurnOffActivity.this, false);
      return null;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.ttssms.TtsSmsTurnOffActivity
 * JD-Core Version:    0.7.0.1
 */