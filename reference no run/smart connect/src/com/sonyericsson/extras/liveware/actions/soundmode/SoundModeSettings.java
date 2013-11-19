package com.sonyericsson.extras.liveware.actions.soundmode;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Vibrator;
import com.sonyericsson.extras.liveware.ui.BaseDialogActivity;
import com.sonyericsson.extras.liveware.ui.RadioListDialog;
import com.sonyericsson.extras.liveware.ui.RadioListDialog.IBucket;
import com.sonyericsson.extras.liveware.ui.RadioListDialog.IRunner;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import java.util.ArrayList;
import java.util.List;

public class SoundModeSettings
  extends BaseDialogActivity
{
  private static final int DLG_SETTINGS = 1;
  private String mRawSetting;
  
  private AlertDialog get()
  {
    Object localObject2 = (Vibrator)getSystemService("vibrator");
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(getBucket("normal"));
    if ((localObject2 != null) && (((Vibrator)localObject2).hasVibrator())) {
      ((List)localObject1).add(getBucket("vibrate"));
    }
    ((List)localObject1).add(getBucket("silent"));
    localObject2 = new Bucket(this.mRawSetting, SoundMode.getLabelByRawSetting(this, this.mRawSetting));
    localObject1 = new RadioListDialog(this, getResources().getString(2131099852), (List)localObject1, (RadioListDialog.IBucket)localObject2);
    ((RadioListDialog)localObject1).setOnClickAction(new Runner(null));
    ((RadioListDialog)localObject1).setOnCancelAction(new Runnable()
    {
      public void run()
      {
        SoundModeSettings.this.finish();
      }
    });
    return ((RadioListDialog)localObject1).get();
  }
  
  private RadioListDialog.IBucket getBucket(String paramString)
  {
    return new Bucket(paramString, SoundMode.getLabelByRawSetting(this, paramString));
  }
  
  private void updateSetting(String paramString)
  {
    ActionUtils.finishActivityWithSetting(this, paramString, SoundMode.getLabelByRawSetting(this, paramString));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRawSetting = getIntent().getStringExtra("setting_raw");
    Object localObject = this.mRawSetting;
    if ((!((String)localObject).equals("loud")) && (((String)localObject).equals("vibrate")))
    {
      localObject = (Vibrator)getSystemService("vibrator");
      if ((localObject == null) || (((Vibrator)localObject).hasVibrator())) {}
    }
    showDialog(1);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = super.onCreateDialog(paramInt);
      break;
    case 1: 
      localObject = get();
    }
    return localObject;
  }
  
  private static class Bucket
    implements RadioListDialog.IBucket
  {
    private String mKey;
    private String mValue;
    
    public Bucket(String paramString1, String paramString2)
    {
      this.mKey = paramString1;
      this.mValue = paramString2;
    }
    
    public String getKey()
    {
      return this.mKey;
    }
    
    public String getValue()
    {
      return this.mValue;
    }
  }
  
  private class Runner
    implements RadioListDialog.IRunner
  {
    private Runner() {}
    
    public void run(String paramString)
    {
      SoundModeSettings.this.updateSetting(paramString);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.soundmode.SoundModeSettings
 * JD-Core Version:    0.7.0.1
 */