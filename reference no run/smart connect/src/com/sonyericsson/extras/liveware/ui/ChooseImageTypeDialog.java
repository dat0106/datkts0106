package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class ChooseImageTypeDialog
  extends DialogFragment
{
  private Activity mActivity;
  
  public static ChooseImageTypeDialog newInstance()
  {
    return new ChooseImageTypeDialog();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    final String[] arrayOfString = new String[2];
    arrayOfString[0] = getString(2131099939);
    arrayOfString[1] = getString(2131099940);
    new AlertDialog.Builder(this.mActivity).setTitle(2131099941).setItems(arrayOfString, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        String str = arrayOfString[paramAnonymousInt];
        if (!ChooseImageTypeDialog.this.getString(2131099939).equals(str))
        {
          if (ChooseImageTypeDialog.this.getString(2131099940).equals(str)) {
            ((ChooseImageTypeDialog.ChooseImageTypeListener)ChooseImageTypeDialog.this.getTargetFragment()).onChooseCameraImage();
          }
        }
        else {
          ((ChooseImageTypeDialog.ChooseImageTypeListener)ChooseImageTypeDialog.this.getTargetFragment()).onChooseAlbumImage();
        }
      }
    }).create();
  }
  
  public static abstract interface ChooseImageTypeListener
  {
    public abstract void onChooseAlbumImage();
    
    public abstract void onChooseCameraImage();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ChooseImageTypeDialog
 * JD-Core Version:    0.7.0.1
 */