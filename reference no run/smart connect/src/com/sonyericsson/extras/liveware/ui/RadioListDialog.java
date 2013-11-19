package com.sonyericsson.extras.liveware.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.List;

public class RadioListDialog
{
  private Context mContext = null;
  private IBucket mCurrentSetting;
  private Runnable mOnCancelAction = null;
  private IRunner mOnClickAction = null;
  private List<IBucket> mSettings;
  private String mTitle;
  
  public RadioListDialog(Context paramContext, String paramString, List<IBucket> paramList, IBucket paramIBucket)
  {
    this.mContext = paramContext;
    this.mTitle = paramString;
    this.mSettings = paramList;
    this.mCurrentSetting = paramIBucket;
  }
  
  private AlertDialog build()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
    localBuilder.setTitle(this.mTitle);
    localBuilder.setNegativeButton(2131099743, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        RadioListDialog.this.mOnCancelAction.run();
      }
    });
    try
    {
      final RadioListAdapter localRadioListAdapter = new RadioListAdapter(this.mContext, this.mSettings, this.mCurrentSetting);
      localBuilder.setAdapter(localRadioListAdapter, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (RadioListDialog.this.mOnClickAction != null)
          {
            RadioListDialog.IBucket localIBucket = localRadioListAdapter.getItem(paramAnonymousInt);
            RadioListDialog.this.mOnClickAction.run(localIBucket.getKey());
          }
        }
      });
      localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          if (RadioListDialog.this.mOnCancelAction != null) {
            RadioListDialog.this.mOnCancelAction.run();
          }
        }
      });
      return localBuilder.create();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Dbg.e("Fail.", localException);
      }
    }
  }
  
  public AlertDialog get()
  {
    return build();
  }
  
  public void setOnCancelAction(Runnable paramRunnable)
  {
    this.mOnCancelAction = paramRunnable;
  }
  
  public void setOnClickAction(IRunner paramIRunner)
  {
    this.mOnClickAction = paramIRunner;
  }
  
  public static abstract interface IBucket
  {
    public abstract String getKey();
    
    public abstract String getValue();
  }
  
  public static abstract interface IRunner
  {
    public abstract void run(String paramString);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.RadioListDialog
 * JD-Core Version:    0.7.0.1
 */