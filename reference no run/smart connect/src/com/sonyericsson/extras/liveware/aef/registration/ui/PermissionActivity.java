package com.sonyericsson.extras.liveware.aef.registration.ui;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.aef.registration.RegistrationInternal.PermissionRequest;
import com.sonyericsson.extras.liveware.ui.BaseDialogActivity;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.Iterator;
import java.util.LinkedList;

public class PermissionActivity
  extends BaseDialogActivity
{
  private static final String CURRENT_PACKAGE_LIST = "CURRENT_PACKAGES";
  private static final int DLG_PERMISSION = 1;
  private static final int TRUE = 1;
  private Context mContext;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  private LinkedList<Intent> mIntents;
  private String mPackageName;
  private Runnable mRunnable;
  
  private void addTitle(AlertDialog.Builder paramBuilder)
  {
    View localView = View.inflate(this.mContext, 2130903046, null);
    UIUtils.applyDirectionality(localView);
    paramBuilder.setCustomTitle(localView);
  }
  
  private Dialog makePermissionDialog()
  {
    Object localObject1 = new AlertDialog.Builder(this);
    ((AlertDialog.Builder)localObject1).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        PermissionActivity.this.removeDialog(1);
        PermissionActivity.this.showNextOrFinish();
      }
    });
    addTitle((AlertDialog.Builder)localObject1);
    Object localObject3 = getLayoutInflater().inflate(2130903075, (ViewGroup)findViewById(2131558492));
    UIUtils.applyDirectionality((View)localObject3);
    Object localObject2 = new ScrollView(this);
    ((ScrollView)localObject2).addView((View)localObject3);
    ((AlertDialog.Builder)localObject1).setView((View)localObject2);
    localObject2 = getPackageManager();
    Object localObject4 = (ImageView)((View)localObject3).findViewById(2131558493);
    if (localObject4 != null) {}
    try
    {
      ((ImageView)localObject4).setImageDrawable(((PackageManager)localObject2).getApplicationIcon(this.mPackageName));
      label104:
      localObject4 = (TextView)((View)localObject3).findViewById(2131558494);
      if (localObject4 != null) {}
      try
      {
        localObject3 = ((PackageManager)localObject2).getApplicationInfo(this.mPackageName, 6);
        if (localObject3 != null) {
          ((TextView)localObject4).setText(getResources().getString(2131099776).replace("%s", ((PackageManager)localObject2).getApplicationLabel((ApplicationInfo)localObject3).toString()));
        }
        label164:
        ((AlertDialog.Builder)localObject1).setPositiveButton(2131099779, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            PermissionActivity.this.mRunnable = new Runnable()
            {
              public void run()
              {
                ContentValues localContentValues = new ContentValues();
                localContentValues.put("permissionGranted", Integer.valueOf(1));
                int i = 0;
                try
                {
                  ContentResolver localContentResolver = PermissionActivity.this.getContentResolver();
                  Uri localUri = RegistrationInternal.PermissionRequest.URI;
                  String[] arrayOfString = new String[1];
                  arrayOfString[0] = PermissionActivity.this.mPackageName;
                  i = localContentResolver.update(localUri, localContentValues, "packageName = ?", arrayOfString);
                  i = i;
                }
                catch (SQLException localSQLException)
                {
                  for (;;)
                  {
                    Intent localIntent;
                    Dbg.e("update failed in makePermissionDialog", localSQLException);
                  }
                }
                if (i == 1)
                {
                  localIntent = new Intent("com.sonyericsson.extras.liveware.aef.registration.EXTENSION_REGISTER_REQUEST");
                  localIntent.setPackage(PermissionActivity.this.mPackageName);
                  if (AsfUtils.isHoneycombOrHigher(PermissionActivity.this.mContext)) {
                    localIntent.addFlags(32);
                  }
                  PermissionActivity.this.mContext.sendBroadcast(localIntent);
                }
                PermissionActivity.this.runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    PermissionActivity.this.removeDialog(1);
                    PermissionActivity.this.showNextOrFinish();
                  }
                });
              }
            };
            PermissionActivity.this.mHandler.post(PermissionActivity.this.mRunnable);
          }
        });
        ((AlertDialog.Builder)localObject1).setNegativeButton(2131099780, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            PermissionActivity.this.removeDialog(1);
            PermissionActivity.this.showNextOrFinish();
          }
        });
        localObject1 = ((AlertDialog.Builder)localObject1).create();
        ((AlertDialog)localObject1).show();
        return localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        break label164;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException2)
    {
      break label104;
    }
  }
  
  private void showNextOrFinish()
  {
    if (this.mIntents != null) {
      if (!this.mIntents.isEmpty())
      {
        Intent localIntent = (Intent)this.mIntents.poll();
        setIntent(localIntent);
        this.mPackageName = localIntent.getStringExtra("packageName");
        showDialog(1);
      }
      else
      {
        finish();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.mIntents = new LinkedList();
    if (paramBundle != null)
    {
      String[] arrayOfString = paramBundle.getStringArray("CURRENT_PACKAGES");
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        for (int i = 0; i < j; i++)
        {
          String str = arrayOfString[i];
          Intent localIntent = new Intent("com.sonyericsson.extras.liveware.aef.registration.REQUEST_PERMISSION");
          localIntent.putExtra("packageName", str);
          this.mIntents.add(localIntent);
        }
      }
    }
    super.onCreate(paramBundle);
    this.mContext = this;
    this.mPackageName = getIntent().getStringExtra("packageName");
    if (this.mHandlerThread == null)
    {
      this.mHandlerThread = new HandlerThread("Permission request");
      this.mHandlerThread.start();
    }
    if (this.mHandler == null) {
      this.mHandler = new Handler(this.mHandlerThread.getLooper());
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
    case 1: 
      localDialog = makePermissionDialog();
    }
    return localDialog;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mHandler.removeCallbacks(this.mRunnable);
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    this.mIntents = null;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    this.mIntents.add(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    removeDialog(1);
  }
  
  protected void onResume()
  {
    super.onResume();
    showDialog(1);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.mIntents != null)
    {
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = this.mIntents.iterator();
      while (localIterator.hasNext())
      {
        String str = ((Intent)localIterator.next()).getStringExtra("packageName");
        if (str != null) {
          localLinkedList.add(str);
        }
      }
      if (!localLinkedList.isEmpty()) {
        paramBundle.putStringArray("CURRENT_PACKAGES", (String[])localLinkedList.toArray(new String[0]));
      }
    }
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.registration.ui.PermissionActivity
 * JD-Core Version:    0.7.0.1
 */