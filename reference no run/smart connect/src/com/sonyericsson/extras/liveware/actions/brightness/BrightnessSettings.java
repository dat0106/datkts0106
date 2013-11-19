package com.sonyericsson.extras.liveware.actions.brightness;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.ui.BaseDialogActivity;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class BrightnessSettings
  extends BaseDialogActivity
{
  private static final int BRIGHTNESS_DIALOG = 1;
  private Dialog mDialog = null;
  private TextView mPercentageView = null;
  private String mRawSetting;
  private SeekBar mSeekBar = null;
  
  private Dialog createBrightnessDialog()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    View localView = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903044, (ViewGroup)findViewById(2131558407));
    UIUtils.applyDirectionality(localView);
    localBuilder.setView(localView);
    localBuilder.setTitle(2131099963);
    this.mPercentageView = ((TextView)localView.findViewById(2131558408));
    this.mSeekBar = ((SeekBar)localView.findViewById(2131558409));
    this.mSeekBar.setMax(235);
    this.mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        BrightnessSettings.this.mPercentageView.setText(Brightness.getBrightnessPercentageString(paramAnonymousInt + 20));
      }
      
      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}
      
      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
    });
    localBuilder.setPositiveButton(getString(2131099767), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        BrightnessSettings.this.setBrightness(BrightnessSettings.this.mSeekBar.getProgress());
      }
    });
    localBuilder.setNegativeButton(getString(2131099743), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        BrightnessSettings.this.finish();
      }
    });
    localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        BrightnessSettings.this.finish();
      }
    });
    return localBuilder.create();
  }
  
  private int getBrightness()
  {
    int i = -1;
    if (!TextUtils.isEmpty(this.mRawSetting)) {}
    try
    {
      i = Integer.parseInt(this.mRawSetting);
      i = i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Dbg.e(localNumberFormatException);
      }
    }
    if (i < 0) {
      i = Settings.System.getInt(getContentResolver(), "screen_brightness", 100);
    }
    Dbg.d("BrightnessActivity: getBrightness, brightness=" + i);
    return i;
  }
  
  private void setBrightness(int paramInt)
  {
    int i = paramInt + 20;
    Dbg.d("BrightnessActivity: setBrightness, brightness=" + i);
    String str = Integer.toString(i);
    ActionUtils.finishActivityWithSetting(this, str, Brightness.getLabelByRawSetting(this, str));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRawSetting = getIntent().getStringExtra("setting_raw");
    showDialog(1);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Dialog localDialog;
    switch (paramInt)
    {
    default: 
      localDialog = super.onCreateDialog(paramInt);
      break;
    case 1: 
      this.mDialog = createBrightnessDialog();
      localDialog = this.mDialog;
    }
    return localDialog;
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    super.onPrepareDialog(paramInt, paramDialog);
    int i = getBrightness();
    this.mSeekBar.setProgress(i - 20);
    this.mPercentageView.setText(Brightness.getBrightnessPercentageString(i));
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.brightness.BrightnessSettings
 * JD-Core Version:    0.7.0.1
 */