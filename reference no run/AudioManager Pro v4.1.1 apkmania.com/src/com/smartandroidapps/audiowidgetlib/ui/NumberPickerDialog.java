package com.smartandroidapps.audiowidgetlib.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import com.smartandroidapps.audiowidgetlib.R.id;
import com.smartandroidapps.audiowidgetlib.R.layout;
import com.smartandroidapps.audiowidgetlib.R.string;
import com.smartandroidapps.audiowidgetlib.util.MiscUtils;

public class NumberPickerDialog
  extends AlertDialog
  implements DialogInterface.OnClickListener
{
  private NumberPicker mHourPicker;
  private int mInitialValueHour;
  private int mInitialValueMin;
  private OnNumberSetListener mListener;
  private NumberPicker mMinutePicker;
  
  public NumberPickerDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    this.mInitialValueHour = paramInt2;
    this.mInitialValueMin = paramInt3;
    setButton(-1, paramContext.getString(R.string.ok), this);
    setButton(-2, paramContext.getString(R.string.cancel), (DialogInterface.OnClickListener)null);
    Object localObject = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    if (!MiscUtils.isAtLeastLargeHC(paramContext)) {
      localObject = ((LayoutInflater)localObject).inflate(R.layout.number_picker_pref_phone, null);
    } else {
      localObject = ((LayoutInflater)localObject).inflate(R.layout.number_picker_pref, null);
    }
    setView((View)localObject);
    this.mHourPicker = ((NumberPicker)((View)localObject).findViewById(R.id.hour_picker));
    this.mMinutePicker = ((NumberPicker)((View)localObject).findViewById(R.id.min_picker));
    this.mMinutePicker.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
    this.mHourPicker.setRange(0, 23);
    this.mMinutePicker.setRange(0, 59);
    this.mHourPicker.setCurrent(this.mInitialValueHour);
    this.mMinutePicker.setCurrent(this.mInitialValueMin);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.mListener != null) {
      this.mListener.onNumberSet(this.mHourPicker.getCurrent(), this.mMinutePicker.getCurrent());
    }
  }
  
  public void setOnNumberSetListener(OnNumberSetListener paramOnNumberSetListener)
  {
    this.mListener = paramOnNumberSetListener;
  }
  
  public static abstract interface OnNumberSetListener
  {
    public abstract void onNumberSet(int paramInt1, int paramInt2);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.smartandroidapps.audiowidgetlib.ui.NumberPickerDialog
 * JD-Core Version:    0.7.0.1
 */