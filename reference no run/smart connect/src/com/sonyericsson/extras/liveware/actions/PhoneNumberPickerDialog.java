package com.sonyericsson.extras.liveware.actions;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.utils.PhoneUtils;
import com.sonyericsson.extras.liveware.utils.PhoneUtils.PhoneNumber;
import java.util.List;

public class PhoneNumberPickerDialog
{
  private final Context mContext;
  private final PhonePickerListener mListener;
  
  public PhoneNumberPickerDialog(Context paramContext, PhonePickerListener paramPhonePickerListener)
  {
    this.mContext = paramContext;
    this.mListener = paramPhonePickerListener;
  }
  
  private AlertDialog build(Uri paramUri)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
    Object localObject = PhoneUtils.getContactPhoneNumbers(this.mContext, paramUri);
    localBuilder.setTitle(PhoneUtils.getContactName(this.mContext, paramUri));
    if ((localObject == null) || (((List)localObject).size() != 0))
    {
      localObject = new PhoneNumberAdapter(this.mContext, (List)localObject);
      localBuilder.setSingleChoiceItems((ListAdapter)localObject, -1, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          PhoneUtils.PhoneNumber localPhoneNumber = (PhoneUtils.PhoneNumber)this.val$adapter.getItem(paramAnonymousInt);
          if ((localPhoneNumber != null) && (PhoneNumberPickerDialog.this.mListener != null)) {
            PhoneNumberPickerDialog.this.mListener.onPhoneNumberSelected(localPhoneNumber);
          }
          paramAnonymousDialogInterface.dismiss();
        }
      });
      localBuilder.setNegativeButton(17039360, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          PhoneNumberPickerDialog.this.mListener.onPhoneNumberCanceled();
          paramAnonymousDialogInterface.dismiss();
        }
      });
    }
    else
    {
      localBuilder.setView(View.inflate(this.mContext, 2130903076, null));
      localBuilder.setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          PhoneNumberPickerDialog.this.mListener.onPhoneNumberCanceled();
          paramAnonymousDialogInterface.dismiss();
        }
      });
    }
    localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        PhoneNumberPickerDialog.this.mListener.onPhoneNumberCanceled();
        paramAnonymousDialogInterface.dismiss();
      }
    });
    return localBuilder.create();
  }
  
  public AlertDialog get(Uri paramUri)
  {
    return build(paramUri);
  }
  
  class PhoneNumberAdapter
    extends ArrayAdapter<PhoneUtils.PhoneNumber>
  {
    public PhoneNumberAdapter(List<PhoneUtils.PhoneNumber> paramList)
    {
      super(0, 0, localList);
    }
    
    private void renderView(View paramView, PhoneUtils.PhoneNumber paramPhoneNumber)
    {
      int i = 1;
      Object localObject = (TextView)paramView.findViewById(2131558416);
      if (localObject != null) {
        ((TextView)localObject).setText(paramPhoneNumber.number);
      }
      localObject = (TextView)paramView.findViewById(2131558495);
      if (localObject != null) {
        ((TextView)localObject).setText(paramPhoneNumber.label);
      }
      localObject = (RadioButton)paramView.findViewById(2131558496);
      if (localObject != null)
      {
        if (getCount() != i) {
          i = 0;
        }
        ((RadioButton)localObject).setChecked(i);
      }
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null) {
        localView = View.inflate(PhoneNumberPickerDialog.this.mContext, 2130903077, null);
      } else {
        localView = paramView;
      }
      PhoneUtils.PhoneNumber localPhoneNumber = (PhoneUtils.PhoneNumber)getItem(paramInt);
      if (localPhoneNumber != null) {
        renderView(localView, localPhoneNumber);
      }
      return localView;
    }
  }
  
  public static abstract interface PhonePickerListener
  {
    public abstract void onPhoneNumberCanceled();
    
    public abstract void onPhoneNumberSelected(PhoneUtils.PhoneNumber paramPhoneNumber);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.PhoneNumberPickerDialog
 * JD-Core Version:    0.7.0.1
 */