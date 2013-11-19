package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class EditDialogFragment
  extends DialogFragment
{
  public static final String EXTRA_HINT_ID = "extra_hint_id";
  public static final String EXTRA_INPUT_TYPE = "extra_input_type";
  public static final String EXTRA_NEGATIVE_BUTTON_ID = "extra_negative_button_id";
  public static final String EXTRA_POSITIVE_BUTTON_ID = "extra_positive_button_id";
  public static final String EXTRA_SELECT_ALL_ON_FOCUS = "extra_select_all_on_focus";
  public static final String EXTRA_TITLE_ID = "extra_title_id";
  public static final String EXTRA_VALUE = "extra_value";
  public static final int NO_REQUEST_CODE = 0;
  public static final int NO_RESOURCE_ID = -1;
  private Activity mActivity;
  private AlertDialog mDialog;
  private EditText mEditText;
  
  private void onCancel()
  {
    if (getTargetFragment() == null) {
      ((EditDialogListener)this.mActivity).onCancel(0);
    } else {
      ((EditDialogListener)getTargetFragment()).onCancel(getTargetRequestCode());
    }
  }
  
  private void onDone(String paramString)
  {
    if (getTargetFragment() == null) {
      ((EditDialogListener)this.mActivity).onDone(paramString, 0);
    } else {
      ((EditDialogListener)getTargetFragment()).onDone(paramString, getTargetRequestCode());
    }
  }
  
  private void updatePositiveButtonEnableState(AlertDialog paramAlertDialog, EditText paramEditText)
  {
    Button localButton = paramAlertDialog.getButton(-1);
    if (!paramEditText.getText().toString().trim().equals("")) {
      localButton.setEnabled(true);
    } else {
      localButton.setEnabled(false);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    onCancel();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    int i = getArguments().getInt("extra_title_id", -1);
    int m = getArguments().getInt("extra_positive_button_id", 2131099767);
    int j = getArguments().getInt("extra_negative_button_id", 2131099820);
    int k = getArguments().getInt("extra_hint_id", -1);
    boolean bool = getArguments().getBoolean("extra_select_all_on_focus");
    View localView = LayoutInflater.from(getActivity()).inflate(2130903053, null);
    this.mEditText = ((EditText)localView.findViewById(2131558420));
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mActivity);
    localBuilder.setTitle(i);
    if (k != -1) {
      this.mEditText.setHint(k);
    }
    localBuilder.setView(localView);
    localBuilder.setPositiveButton(m, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        EditDialogFragment.this.onDone(EditDialogFragment.this.mEditText.getText().toString());
      }
    });
    localBuilder.setNegativeButton(j, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        EditDialogFragment.this.onCancel();
      }
    });
    this.mDialog = localBuilder.create();
    this.mEditText.setText(getArguments().getString("extra_value"));
    this.mEditText.setInputType(getArguments().getInt("extra_input_type", 1));
    this.mEditText.setSelectAllOnFocus(bool);
    if (!bool) {
      this.mEditText.setSelection(this.mEditText.getText().length());
    }
    this.mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        boolean bool;
        if ((6 != paramAnonymousInt) || (TextUtils.isEmpty(EditDialogFragment.this.mEditText.getText())))
        {
          bool = false;
        }
        else
        {
          EditDialogFragment.this.onDone(paramAnonymousTextView.getText().toString());
          EditDialogFragment.this.dismissAllowingStateLoss();
          bool = true;
        }
        return bool;
      }
    });
    this.mEditText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        EditDialogFragment.this.updatePositiveButtonEnableState(EditDialogFragment.this.mDialog, EditDialogFragment.this.mEditText);
      }
    });
    this.mDialog.getWindow().setSoftInputMode(5);
    return this.mDialog;
  }
  
  public void onResume()
  {
    super.onResume();
    updatePositiveButtonEnableState(this.mDialog, this.mEditText);
  }
  
  public static abstract interface EditDialogListener
  {
    public abstract void onCancel(int paramInt);
    
    public abstract void onDone(String paramString, int paramInt);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.EditDialogFragment
 * JD-Core Version:    0.7.0.1
 */