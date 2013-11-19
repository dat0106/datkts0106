package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import com.sonyericsson.extras.liveware.experience.Time;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.SyncedProperty;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class ChooseWeekDaysDialog
  extends DialogFragment
{
  private static final String CHECKED_DAYS = "checked_days";
  private static final int[] sDayMap;
  private Activity mActivity;
  private boolean[] mCheckedDays;
  private SyncedProperty<Boolean> mSaved = new SyncedProperty(Boolean.valueOf(false));
  
  static
  {
    int[] arrayOfInt = new int[7];
    arrayOfInt[0] = 2;
    arrayOfInt[1] = 3;
    arrayOfInt[2] = 4;
    arrayOfInt[3] = 5;
    arrayOfInt[4] = 6;
    arrayOfInt[5] = 7;
    arrayOfInt[6] = 1;
    sDayMap = arrayOfInt;
  }
  
  private int getArrayAsBitField(boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    for (int j = 0; j < paramArrayOfBoolean.length; j++) {
      if (paramArrayOfBoolean[j] != 0) {
        i += Time.getDayMask(sDayMap[j]);
      }
    }
    return i;
  }
  
  private boolean[] getArrayFromBitField(int paramInt)
  {
    boolean[] arrayOfBoolean = new boolean[7];
    for (int i = 0; i < arrayOfBoolean.length; i++) {
      arrayOfBoolean[i] = Time.isDayInBitField(sDayMap[i], paramInt);
    }
    return arrayOfBoolean;
  }
  
  public static ChooseWeekDaysDialog newInstance(int paramInt)
  {
    ChooseWeekDaysDialog localChooseWeekDaysDialog = new ChooseWeekDaysDialog();
    Bundle localBundle = new Bundle();
    localBundle.putInt("checked_days", paramInt);
    localChooseWeekDaysDialog.setArguments(localBundle);
    return localChooseWeekDaysDialog;
  }
  
  private void updateBidi()
  {
    Object localObject = getDialog();
    if (localObject != null)
    {
      localObject = ((AlertDialog)localObject).getListView();
      if (localObject != null) {
        UIUtils.applyDirectionality((View)localObject);
      }
    }
    else
    {
      Dbg.w("ChooseWeekDaysDialog.updateBidi dialog == null");
    }
  }
  
  private void updateDoneEnable()
  {
    Dialog localDialog = getDialog();
    if (localDialog != null)
    {
      Button localButton = ((AlertDialog)localDialog).getButton(-1);
      if (localButton != null)
      {
        boolean[] arrayOfBoolean = this.mCheckedDays;
        int i = arrayOfBoolean.length;
        int j = 0;
        while (j < i) {
          if (arrayOfBoolean[j] == 0)
          {
            j++;
          }
          else
          {
            localButton.setEnabled(true);
            return;
          }
        }
        localButton.setEnabled(false);
      }
      else
      {
        Dbg.w("ChooseWeekDaysDialog.updateDoneEnable doneButton == null");
      }
    }
    else
    {
      Dbg.w("ChooseWeekDaysDialog.updateDoneEnable dialog == null");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    Object localObject = new String[8];
    localObject[0] = "";
    localObject[1] = DateUtils.getDayOfWeekString(1, 10);
    localObject[2] = DateUtils.getDayOfWeekString(2, 10);
    localObject[3] = DateUtils.getDayOfWeekString(3, 10);
    localObject[4] = DateUtils.getDayOfWeekString(4, 10);
    localObject[5] = DateUtils.getDayOfWeekString(5, 10);
    localObject[6] = DateUtils.getDayOfWeekString(6, 10);
    localObject[7] = DateUtils.getDayOfWeekString(7, 10);
    String[] arrayOfString = new String[7];
    arrayOfString[0] = localObject[2];
    arrayOfString[1] = localObject[3];
    arrayOfString[2] = localObject[4];
    arrayOfString[3] = localObject[5];
    arrayOfString[4] = localObject[6];
    arrayOfString[5] = localObject[7];
    arrayOfString[6] = localObject[1];
    if (paramBundle == null) {
      this.mCheckedDays = getArrayFromBitField(getArguments().getInt("checked_days"));
    } else {
      this.mCheckedDays = getArrayFromBitField(paramBundle.getInt("checked_days"));
    }
    localObject = new AlertDialog.Builder(this.mActivity);
    ((AlertDialog.Builder)localObject).setTitle(2131099934);
    ((AlertDialog.Builder)localObject).setMultiChoiceItems(arrayOfString, this.mCheckedDays, new DialogInterface.OnMultiChoiceClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (!((Boolean)ChooseWeekDaysDialog.this.mSaved.get()).booleanValue())
        {
          ChooseWeekDaysDialog.this.mCheckedDays[paramAnonymousInt] = paramAnonymousBoolean;
          ChooseWeekDaysDialog.this.updateDoneEnable();
        }
        else
        {
          Dbg.w("ChooseWeekDaysDialog MultiChoice.onClick ignored");
        }
      }
    });
    ((AlertDialog.Builder)localObject).setPositiveButton(2131099936, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (!((Boolean)ChooseWeekDaysDialog.this.mSaved.get()).booleanValue()) {
          ((TimeTriggerActivity)ChooseWeekDaysDialog.this.mActivity).onWeekDaysSet(ChooseWeekDaysDialog.this.getArrayAsBitField(ChooseWeekDaysDialog.this.mCheckedDays));
        } else {
          Dbg.w("ChooseWeekDaysDialog DoneButton.onClick ignored");
        }
      }
    });
    ((AlertDialog.Builder)localObject).setNegativeButton(getString(2131099820), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    return ((AlertDialog.Builder)localObject).create();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mSaved.set(Boolean.valueOf(false));
    updateDoneEnable();
    updateBidi();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mSaved.set(Boolean.valueOf(true));
    paramBundle.putInt("checked_days", getArrayAsBitField(this.mCheckedDays));
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.ChooseWeekDaysDialog
 * JD-Core Version:    0.7.0.1
 */