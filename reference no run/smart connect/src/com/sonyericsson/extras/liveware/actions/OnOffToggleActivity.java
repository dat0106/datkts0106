package com.sonyericsson.extras.liveware.actions;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.ui.BaseDialogActivity;
import com.sonyericsson.extras.liveware.ui.RadioListDialog;
import com.sonyericsson.extras.liveware.ui.RadioListDialog.IBucket;
import com.sonyericsson.extras.liveware.ui.RadioListDialog.IRunner;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class OnOffToggleActivity
  extends BaseDialogActivity
{
  private static final int DLG_SETTINGS = 1;
  public static final String SETTING_OFF = "off";
  public static final String SETTING_ON = "on";
  public static final String SETTING_TOGGLE = "toggle";
  private int mDialogTitleResId;
  private String mRawSetting;
  
  private AlertDialog get()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(getBucket("on"));
    localArrayList.add(getBucket("off"));
    localArrayList.add(getBucket("toggle"));
    Object localObject = new Bucket(this.mRawSetting, getLabelByRawSetting(this, this.mRawSetting));
    localObject = new RadioListDialog(this, getString(this.mDialogTitleResId), localArrayList, (RadioListDialog.IBucket)localObject);
    ((RadioListDialog)localObject).setOnClickAction(new Runner(null));
    ((RadioListDialog)localObject).setOnCancelAction(new Runnable()
    {
      public void run()
      {
        OnOffToggleActivity.this.finish();
      }
    });
    return ((RadioListDialog)localObject).get();
  }
  
  private RadioListDialog.IBucket getBucket(String paramString)
  {
    return new Bucket(paramString, getLabelByRawSetting(this, paramString));
  }
  
  public static String getLabelByRawSetting(Context paramContext, String paramString)
  {
    String str;
    if (!paramString.equalsIgnoreCase("on"))
    {
      if (!paramString.equalsIgnoreCase("off"))
      {
        if (!paramString.equalsIgnoreCase("toggle")) {
          str = "";
        } else {
          str = paramContext.getString(2131099865);
        }
      }
      else {
        str = paramContext.getString(2131099858);
      }
    }
    else {
      str = paramContext.getString(2131099859);
    }
    return str;
  }
  
  private void updateSetting(String paramString)
  {
    ActionUtils.finishActivityWithSetting(this, paramString, getLabelByRawSetting(this, paramString));
  }
  
  protected abstract int getDialogTitleResId();
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mDialogTitleResId = getDialogTitleResId();
    this.mRawSetting = getIntent().getStringExtra("setting_raw");
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
  
  protected void onPause()
  {
    super.onPause();
    dismissDialog(1);
  }
  
  protected void onResume()
  {
    super.onResume();
    showDialog(1);
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
      OnOffToggleActivity.this.updateSetting(paramString);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.OnOffToggleActivity
 * JD-Core Version:    0.7.0.1
 */