package com.sonyericsson.extras.liveware.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.asf.InstallReceiver;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.Feature;
import com.sonyericsson.extras.liveware.experience.Feature.FeatureEditor;
import com.sonyericsson.extras.liveware.service.BtService;
import com.sonyericsson.extras.liveware.service.BtService.BtBinder;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.MarketUtils;
import com.sonyericsson.extras.liveware.utils.TestDialogManager;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class InstallActivity
  extends BaseDialogActivity
{
  public static final String CUSTOMIZED_INTENT = "com.sonyericsson.extras.liveware.SHOW_CUSTOMIZED_MSG";
  private static final int DLG_INSTALL = 2;
  private Device mAccessory;
  private BtService mBtService;
  private String mCompanionApp;
  private ServiceConnection mConnection;
  private Feature mFeature;
  private boolean mQuitNagging = false;
  private boolean mSendStatus = false;
  public TestDialogManager testDialogManager = new TestDialogManager();
  
  private void bindService()
  {
    this.mConnection = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        InstallActivity.this.mBtService = ((BtService.BtBinder)paramAnonymousIBinder).getService();
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        InstallActivity.this.mBtService = null;
      }
    };
    bindService(new Intent(this, BtService.class), this.mConnection, 1);
  }
  
  private void enableFeature()
  {
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(this);
    if (this.mFeature.getType() == 2) {
      localExperienceManager.updateFeature(this.mFeature.edit().setAppSelection(0));
    }
    localExperienceManager.updateFeature(this.mFeature.edit().setState(1));
  }
  
  private Dialog handleAppInstall()
  {
    Object localObject2 = null;
    Object localObject1 = new InstallationDialog(this);
    ((InstallationDialog)localObject1).mCancelAction = new CancelAction(null);
    try
    {
      localObject1 = ((InstallationDialog)localObject1).get();
      localObject2 = localObject1;
    }
    catch (InstallActivity.InstallationDialog.InstallDlgException localInstallDlgException)
    {
      label32:
      break label32;
    }
    return localObject2;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    long l = localIntent.getLongExtra("com.sonyericsson.extras.liveware.extra.smartdevice", -1L);
    if (l != -1L)
    {
      this.mSendStatus = localIntent.getBooleanExtra("com.sonyericsson.extras.liveware.extra.sendsstatus", false);
      if (this.mSendStatus) {
        bindService();
      }
      this.mAccessory = ExperienceManager.getInstance(this).getDeviceById(l);
      if (this.mAccessory != null)
      {
        int i = localIntent.getIntExtra("com.sonyericsson.extras.liveware.extra.feature_type", -1);
        if (i != -1)
        {
          this.mFeature = this.mAccessory.getFeature(i);
          if (this.mFeature != null)
          {
            this.mCompanionApp = this.mFeature.getCompanionPkg();
            showDialog(2);
          }
          else
          {
            if (Dbg.e()) {
              Dbg.e("Couldn't get feature");
            }
            finish();
          }
        }
        else
        {
          if (Dbg.e()) {
            Dbg.e("No feature type!");
          }
          finish();
        }
      }
      else
      {
        if (Dbg.e()) {
          Dbg.e("No accessory!");
        }
        finish();
      }
    }
    else
    {
      finish();
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Dialog localDialog;
    switch (paramInt)
    {
    default: 
      finish();
      localDialog = null;
      break;
    case 2: 
      localDialog = handleAppInstall();
    }
    this.testDialogManager.manage(paramInt, localDialog);
    return localDialog;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mSendStatus) {
      unbindService(this.mConnection);
    }
  }
  
  private final class AppViewAction
    implements Runnable
  {
    private final Device mAcc;
    
    private AppViewAction(Device paramDevice)
    {
      this.mAcc = paramDevice;
    }
    
    public void run()
    {
      InstallActivity.this.enableFeature();
      ApplicationSelectionActivity.launchApplicationSelection(InstallActivity.this, this.mAcc, true);
    }
  }
  
  private final class CancelAction
    implements Runnable
  {
    private CancelAction() {}
    
    public void run()
    {
      InstallActivity.this.setResult(0);
      if ((InstallActivity.this.mSendStatus) && (InstallActivity.this.mBtService != null)) {
        InstallActivity.this.mBtService.sendAsyncEvent(1, 3);
      }
    }
  }
  
  private class DisableAction
    implements Runnable
  {
    private DisableAction() {}
    
    public void run()
    {
      ExperienceManager localExperienceManager = ExperienceManager.getInstance(InstallActivity.this);
      if ((InstallActivity.this.mFeature.getType() == 2) && (InstallActivity.this.mQuitNagging)) {
        localExperienceManager.updateFeature(InstallActivity.this.mFeature.edit().setAppSelection(0));
      }
      if (InstallActivity.this.mQuitNagging) {
        localExperienceManager.updateFeature(InstallActivity.this.mFeature.edit().setState(0));
      }
    }
  }
  
  private class InstallationDialog
  {
    private Runnable mCancelAction = null;
    private Context mContext = null;
    private int mFeatureType;
    private Runnable mNegativeAction = null;
    private String mNegativeText = null;
    private Runnable mPositiveAction = null;
    private String mPositiveText = null;
    
    public InstallationDialog(Context paramContext)
    {
      this.mContext = paramContext;
      this.mFeatureType = InstallActivity.this.mFeature.getType();
    }
    
    private void addTitle(AlertDialog.Builder paramBuilder)
    {
      View localView = View.inflate(this.mContext, 2130903047, null);
      UIUtils.applyDirectionality(localView);
      paramBuilder.setCustomTitle(localView);
    }
    
    private AlertDialog build()
      throws InstallActivity.InstallationDialog.InstallDlgException
    {
      if (InstallActivity.this.mAccessory != null)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
        addTitle(localBuilder);
        if (!InstallActivity.this.mAccessory.hasFeature(this.mFeatureType)) {
          throw new InstallDlgException();
        }
        switch (this.mFeatureType)
        {
        case 3: 
        default: 
          throw new InstallDlgException();
        case 2: 
          buildLiveKey(localBuilder);
          break;
        case 4: 
          buildSmartlaunch(localBuilder);
        }
        this.mNegativeText = this.mContext.getString(2131099789);
        this.mPositiveText = this.mContext.getString(2131099788);
        this.mCancelAction = new InstallActivity.CancelAction(InstallActivity.this, null);
        if (this.mPositiveText != null) {
          localBuilder.setPositiveButton(this.mPositiveText, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              if (InstallActivity.InstallationDialog.this.mPositiveAction != null) {
                InstallActivity.InstallationDialog.this.mPositiveAction.run();
              }
              InstallActivity.this.finish();
            }
          });
        }
        if (this.mNegativeText != null) {
          localBuilder.setNegativeButton(this.mNegativeText, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              if (InstallActivity.InstallationDialog.this.mNegativeAction != null) {
                InstallActivity.InstallationDialog.this.mNegativeAction.run();
              }
              InstallActivity.this.finish();
            }
          });
        }
        localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            if (InstallActivity.InstallationDialog.this.mCancelAction != null) {
              InstallActivity.InstallationDialog.this.mCancelAction.run();
            }
            InstallActivity.this.finish();
          }
        });
        return localBuilder.create();
      }
      throw new InstallDlgException();
    }
    
    private void buildLiveKey(AlertDialog.Builder paramBuilder)
    {
      LinearLayout localLinearLayout = (LinearLayout)View.inflate(this.mContext, 2130903064, null);
      TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131558462);
      TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131558466);
      CheckBox localCheckBox = (CheckBox)localLinearLayout.findViewById(2131558468);
      ((LinearLayout)localLinearLayout.findViewById(2131558467)).setVisibility(0);
      localCheckBox.setOnClickListener(new CheckListener(null));
      localTextView2.setVisibility(8);
      localTextView1.setText(InstallActivity.this.getString(2131099786));
      this.mPositiveAction = new InstallActivity.AppViewAction(InstallActivity.this, InstallActivity.this.mAccessory, null);
      this.mNegativeAction = new InstallActivity.DisableAction(InstallActivity.this, null);
      wrapInScrollView(paramBuilder, localLinearLayout);
    }
    
    private void buildSmartlaunch(AlertDialog.Builder paramBuilder)
    {
      LinearLayout localLinearLayout = (LinearLayout)View.inflate(this.mContext, 2130903065, null);
      TextView localTextView2 = (TextView)localLinearLayout.findViewById(2131558469);
      TextView localTextView1 = (TextView)localLinearLayout.findViewById(2131558470);
      Context localContext = this.mContext;
      Object localObject = new Object[1];
      localObject[0] = InstallActivity.this.mAccessory.getProductName();
      localTextView2.setText(localContext.getString(2131099782, (Object[])localObject));
      if (InstallActivity.this.mFeature.getAppSelection() == 2)
      {
        localTextView1.setText(2131099783);
      }
      else
      {
        localObject = (CheckBox)localLinearLayout.findViewById(2131558473);
        ((LinearLayout)localLinearLayout.findViewById(2131558472)).setVisibility(0);
        ((CheckBox)localObject).setOnClickListener(new CheckListener(null));
        localTextView1.setText(2131099784);
      }
      ((ImageView)localLinearLayout.findViewById(2131558471)).setImageDrawable(UIUtils.getDialogIcon(this.mContext, InstallActivity.this.mAccessory, true));
      this.mPositiveAction = new InstallActivity.MarketAction(InstallActivity.this, InstallActivity.this.mCompanionApp, null);
      this.mNegativeAction = new InstallActivity.DisableAction(InstallActivity.this, null);
      wrapInScrollView(paramBuilder, localLinearLayout);
    }
    
    private void wrapInScrollView(AlertDialog.Builder paramBuilder, LinearLayout paramLinearLayout)
    {
      ScrollView localScrollView = new ScrollView(this.mContext);
      localScrollView.addView(paramLinearLayout);
      UIUtils.applyDirectionality(localScrollView);
      paramBuilder.setView(localScrollView);
    }
    
    public AlertDialog get()
      throws InstallActivity.InstallationDialog.InstallDlgException
    {
      return build();
    }
    
    private class CheckListener
      implements View.OnClickListener
    {
      private CheckListener() {}
      
      public void onClick(View paramView)
      {
        if ((paramView instanceof CheckBox))
        {
          CheckBox localCheckBox = (CheckBox)paramView;
          if (localCheckBox != null) {
            InstallActivity.this.mQuitNagging = localCheckBox.isChecked();
          }
        }
      }
    }
    
    public class InstallDlgException
      extends Exception
    {
      private static final long serialVersionUID = 1L;
      
      public InstallDlgException() {}
    }
  }
  
  private final class MarketAction
    implements Runnable
  {
    private final String mPackageName;
    
    private MarketAction(String paramString)
    {
      this.mPackageName = paramString;
    }
    
    public void run()
    {
      MarketUtils.launchInfo(InstallActivity.this, this.mPackageName);
      if (InstallActivity.this.mFeature.getType() != 4) {
        InstallReceiver.runInstallReceiver(InstallActivity.this, this.mPackageName, InstallActivity.this.mAccessory.getId(), InstallActivity.this.mFeature.getType(), false);
      }
      InstallActivity.this.setResult(1);
      if ((InstallActivity.this.mSendStatus) && (InstallActivity.this.mBtService != null)) {
        InstallActivity.this.mBtService.sendAsyncEvent(1, 2);
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.InstallActivity
 * JD-Core Version:    0.7.0.1
 */