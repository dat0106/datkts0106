package com.sonyericsson.extras.liveware.actions.facebook;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.ui.BaseActivity;
import com.sonyericsson.extras.liveware.ui.RadioListDialog;
import com.sonyericsson.extras.liveware.ui.RadioListDialog.IBucket;
import com.sonyericsson.extras.liveware.ui.RadioListDialog.IRunner;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookSettings
  extends BaseActivity
{
  private static final String ACTION_LOGGED_IN = "com.sonyericsson.extras.liveware.actions.facebook.ACTION_LOGGED_IN";
  private static final String ACTION_LOGGED_IN_AND_EXIT = "com.sonyericsson.extras.liveware.actions.facebook.ACTION_LOGGED_IN_AND_EXIT";
  private static final int DEFAULT_AUDIENCE = 2;
  private static final int DIALOG_AUDIENCE_PICKER = 2;
  private static final int DIALOG_LOG_OUT = 1;
  private static final int DIALOG_PROGRESS_WORKING = 0;
  public static final String FACEBOOK_AUDIENCE = "facebook_audience";
  private static final String FACEBOOK_LOGIN_DONE = "facebook_login_done";
  public static final String FACEBOOK_MESSAGE = "facebook_message";
  public static final String LOGIN_INTENT_EXTRA = "facebook_login";
  private static final int TASK_LOG_OUT;
  private CheckBox loginStatus = null;
  private int mAudience = -1;
  private Button mDoneButton;
  private boolean mFacebookLoginDone = false;
  private FacebookUtils mFacebookUtils = null;
  private FacebookLoggedInBroadCastReceiver mLoggedInBroadCastReceiver = null;
  private MenuItem mOkActionItem;
  PerformTask mPerformTask = null;
  private String mRawSetting;
  
  private AlertDialog createAudienceDialog(int paramInt)
  {
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(new Bucket(String.valueOf(5), this.mFacebookUtils.getLocalizedAudience(5)));
    ((List)localObject1).add(new Bucket(String.valueOf(3), this.mFacebookUtils.getLocalizedAudience(3)));
    ((List)localObject1).add(new Bucket(String.valueOf(2), this.mFacebookUtils.getLocalizedAudience(2)));
    ((List)localObject1).add(new Bucket(String.valueOf(0), this.mFacebookUtils.getLocalizedAudience(0)));
    Object localObject2 = this.mFacebookUtils.getLocalizedAudience(paramInt);
    if ((paramInt == -1) || (localObject2 == null))
    {
      paramInt = 2;
      localObject2 = this.mFacebookUtils.getLocalizedAudience(paramInt);
    }
    localObject2 = new Bucket(paramInt, (String)localObject2);
    localObject1 = new RadioListDialog(this, getResources().getString(2131099903), (List)localObject1, (RadioListDialog.IBucket)localObject2);
    ((RadioListDialog)localObject1).setOnClickAction(new Runner(null));
    ((RadioListDialog)localObject1).setOnCancelAction(new Runnable()
    {
      public void run()
      {
        FacebookSettings.this.removeDialog(2);
      }
    });
    return ((RadioListDialog)localObject1).get();
  }
  
  private Dialog createLogOutDialog()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setMessage(2131099911).setPositiveButton(2131099767, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (FacebookSettings.this.mPerformTask == null)
        {
          Dbg.d("onClick - log out");
          FacebookSettings.this.mPerformTask = new FacebookSettings.PerformTask(FacebookSettings.this, FacebookSettings.this.mFacebookUtils);
          FacebookSettings.PerformTask localPerformTask = FacebookSettings.this.mPerformTask;
          Integer[] arrayOfInteger = new Integer[1];
          arrayOfInteger[0] = Integer.valueOf(0);
          localPerformTask.execute(arrayOfInteger);
        }
      }
    }).setNegativeButton(2131099743, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    });
    return localBuilder.create();
  }
  
  private Dialog createProgressDialog()
  {
    ProgressDialog localProgressDialog = new ProgressDialog(this);
    localProgressDialog.setProgressStyle(0);
    localProgressDialog.setMessage(getString(2131099912));
    localProgressDialog.setCancelable(true);
    localProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        FacebookSettings.this.mPerformTask.cancel(true);
        FacebookSettings.this.mPerformTask = null;
      }
    });
    return localProgressDialog;
  }
  
  private void onDone()
  {
    Dbg.w("Facebook: Done Pressed ");
    String str = ((EditText)findViewById(2131558446)).getText().toString();
    saveAndFinish(this.mAudience, str);
  }
  
  private void saveAndFinish(int paramInt, String paramString)
  {
    if (Dbg.w())
    {
      Dbg.w("Facebook: save audience =" + this.mFacebookUtils.getLocalizedAudience(paramInt) + "=" + paramInt);
      Dbg.w("Facebook: save message =" + paramString);
    }
    String str = FacebookAction.getRawSetting(paramInt, paramString);
    ActionUtils.finishActivityWithSetting(this, str, FacebookAction.getLabelByRawSetting(this, str));
  }
  
  private boolean settingExist()
  {
    boolean bool;
    if (((EditText)findViewById(2131558446)).length() <= 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void updateDoneButtonVisibility()
  {
    boolean bool;
    if (!TextUtils.isEmpty(((EditText)findViewById(2131558446)).getText().toString())) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.mDoneButton != null) {
      this.mDoneButton.setEnabled(bool);
    }
    if (this.mOkActionItem != null) {
      this.mOkActionItem.setEnabled(bool);
    }
  }
  
  public void finishAsyncTaskTask()
  {
    this.mPerformTask = null;
    dismissDialog(0);
    this.loginStatus.setChecked(this.mFacebookUtils.isSessionValid());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mFacebookUtils.authorizeCallback(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mRawSetting = getIntent().getStringExtra("setting_raw");
    if (paramBundle != null) {
      this.mFacebookLoginDone = paramBundle.getBoolean("facebook_login_done", false);
    }
    boolean bool1 = getIntent().getBooleanExtra("facebook_login", false);
    if (Dbg.v()) {
      Dbg.v("FacebookSettings: onCreate() startIntent.getStringExtra(LOGIN_INTENT_EXTRA)=" + bool1 + " mFacebookLoginDone=" + this.mFacebookLoginDone);
    }
    this.mFacebookUtils = FacebookUtils.getInstance(this);
    if (!this.mFacebookLoginDone)
    {
      if (!bool1) {
        break label492;
      }
      Dbg.v("FacebookSettings: onCreate() ACTION_LOGGED_IN_AND_EXIT");
      bool1 = this.mFacebookUtils.facebookLogin(this, "com.sonyericsson.extras.liveware.actions.facebook.ACTION_LOGGED_IN_AND_EXIT");
      Dbg.v("FacebookSettings: onCreate() callingAuthorize=" + bool1);
      if (!bool1) {
        finish();
      }
    }
    for (;;)
    {
      this.mFacebookLoginDone = true;
      Object localObject2 = this.mRawSetting;
      Object localObject1 = "";
      this.mAudience = 2;
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        localObject1 = ((JSONObject)localObject2).optString("facebook_message", "");
        this.mAudience = ((JSONObject)localObject2).getInt("facebook_audience");
        if (paramBundle != null) {
          this.mAudience = paramBundle.getInt("facebook_audience", 2);
        }
        setContentView(2130903059);
        setTitle(2131099901);
        this.loginStatus = ((CheckBox)findViewById(2131558442));
        this.loginStatus.setChecked(this.mFacebookUtils.isSessionValid());
        ((TextView)findViewById(2131558445)).setText(this.mFacebookUtils.getLocalizedAudience(this.mAudience));
        localObject2 = (EditText)findViewById(2131558446);
        ((EditText)localObject2).setText((CharSequence)localObject1);
        if (this.mLoggedInBroadCastReceiver == null)
        {
          this.mLoggedInBroadCastReceiver = new FacebookLoggedInBroadCastReceiver(null);
          registerReceiver(this.mLoggedInBroadCastReceiver, new IntentFilter("com.sonyericsson.extras.liveware.actions.facebook.ACTION_LOGGED_IN"));
          registerReceiver(this.mLoggedInBroadCastReceiver, new IntentFilter("com.sonyericsson.extras.liveware.actions.facebook.ACTION_LOGGED_IN_AND_EXIT"));
        }
        ((LinearLayout)findViewById(2131558441)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (FacebookSettings.this.loginStatus.isChecked())
            {
              FacebookSettings.this.loginStatus.setChecked(FacebookSettings.this.mFacebookUtils.isSessionValid());
              FacebookSettings.this.showDialog(1);
            }
            else
            {
              FacebookSettings.this.loginStatus.setChecked(FacebookSettings.this.mFacebookUtils.isSessionValid());
              FacebookSettings.this.mFacebookUtils.facebookLogin(FacebookSettings.this, "com.sonyericsson.extras.liveware.actions.facebook.ACTION_LOGGED_IN");
            }
          }
        });
        ((LinearLayout)findViewById(2131558443)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            FacebookSettings.this.showDialog(2);
          }
        });
        localObject1 = (Button)findViewById(2131558456);
        if (localObject1 != null) {
          ((Button)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              FacebookSettings.this.finish();
            }
          });
        }
        this.mDoneButton = ((Button)findViewById(2131558457));
        if (this.mDoneButton != null)
        {
          this.mDoneButton.setEnabled(settingExist());
          this.mDoneButton.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              FacebookSettings.this.onDone();
            }
          });
        }
        updateDoneButtonVisibility();
        ((EditText)localObject2).addTextChangedListener(new TextWatcher()
        {
          public void afterTextChanged(Editable paramAnonymousEditable)
          {
            FacebookSettings.this.updateDoneButtonVisibility();
          }
          
          public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        });
        getActionBar().setDisplayHomeAsUpEnabled(true);
        return;
        label492:
        Dbg.v("FacebookSettings: onCreate() ACTION_LOGGED_IN ");
        boolean bool2 = this.mFacebookUtils.facebookLogin(this, "com.sonyericsson.extras.liveware.actions.facebook.ACTION_LOGGED_IN");
        if (!Dbg.v()) {
          continue;
        }
        Dbg.v("FacebookSettings: onCreate() callingAuthorize=" + bool2);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Dbg.e(localJSONException);
        }
      }
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    case 0: 
      localObject = createProgressDialog();
      break;
    case 1: 
      localObject = createLogOutDialog();
      break;
    case 2: 
      localObject = createAudienceDialog(this.mAudience);
    }
    return localObject;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131689472, paramMenu);
    this.mOkActionItem = paramMenu.findItem(2131558549);
    updateDoneButtonVisibility();
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mLoggedInBroadCastReceiver != null)
    {
      unregisterReceiver(this.mLoggedInBroadCastReceiver);
      this.mLoggedInBroadCastReceiver = null;
    }
    this.loginStatus = null;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool = false;
      break;
    case 16908332: 
      finish();
      break;
    case 2131558548: 
      finish();
      break;
    case 2131558549: 
      onDone();
    }
    return bool;
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    this.mAudience = paramBundle.getInt("facebook_audience", 3);
    this.mFacebookLoginDone = paramBundle.getBoolean("facebook_login_done", false);
    if (Dbg.v()) {
      Dbg.v("Facebook: onRestoreInstanceState()  mAudience=" + this.mAudience + " mFacebookLoginDone=" + this.mFacebookLoginDone);
    }
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (Dbg.v()) {
      Dbg.v("Facebook: onSaveInstanceState() mAudience=" + this.mAudience + " mFacebookLoginDone=" + this.mFacebookLoginDone);
    }
    paramBundle.putInt("facebook_audience", this.mAudience);
    paramBundle.putBoolean("facebook_login_done", this.mFacebookLoginDone);
    super.onSaveInstanceState(paramBundle);
  }
  
  private static class Bucket
    implements RadioListDialog.IBucket
  {
    private String mKey;
    private String mValue;
    
    public Bucket(int paramInt, String paramString)
    {
      this.mKey = Integer.toString(paramInt);
      this.mValue = paramString;
    }
    
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
  
  private class FacebookLoggedInBroadCastReceiver
    extends BroadcastReceiver
  {
    private FacebookLoggedInBroadCastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent != null) {
        if (!"com.sonyericsson.extras.liveware.actions.facebook.ACTION_LOGGED_IN_AND_EXIT".equals(paramIntent.getAction()))
        {
          if ("com.sonyericsson.extras.liveware.actions.facebook.ACTION_LOGGED_IN".equals(paramIntent.getAction()))
          {
            Dbg.w("Facebook: FacebookLoggedInBroadCastReceiver onReceive()com.sonyericsson.extras.liveware.actions.facebook.ACTION_LOGGED_IN");
            Dbg.d("FacebookLoggedInBroadCastReceiver onReceive: " + paramIntent.getAction());
            if (FacebookSettings.this.loginStatus != null) {
              FacebookSettings.this.loginStatus.setChecked(FacebookSettings.this.mFacebookUtils.isSessionValid());
            }
          }
        }
        else
        {
          Dbg.w("Facebook: FacebookLoggedInBroadCastReceiver onReceive()com.sonyericsson.extras.liveware.actions.facebook.ACTION_LOGGED_IN_AND_EXIT");
          FacebookSettings.this.finish();
        }
      }
    }
  }
  
  private static class PerformTask
    extends AsyncTask<Integer, Integer, Boolean>
  {
    FacebookSettings mActivity = null;
    FacebookUtils mFacebookUtils = null;
    
    PerformTask(FacebookSettings paramFacebookSettings, FacebookUtils paramFacebookUtils)
    {
      this.mActivity = paramFacebookSettings;
      this.mFacebookUtils = paramFacebookUtils;
    }
    
    protected Boolean doInBackground(Integer... paramVarArgs)
    {
      boolean bool = false;
      Boolean localBoolean;
      if ((paramVarArgs != null) && (paramVarArgs.length == 1))
      {
        int i = paramVarArgs[0].intValue();
        switch (i)
        {
        default: 
          if (Dbg.d()) {
            Dbg.d("PerformTask, not a valid task: " + i);
          }
          break;
        case 0: 
          this.mFacebookUtils.facebookLogOut(this.mActivity);
          bool = true;
        }
        localBoolean = Boolean.valueOf(bool);
      }
      else
      {
        localBoolean = Boolean.valueOf(false);
      }
      return localBoolean;
    }
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      try
      {
        this.mActivity.finishAsyncTaskTask();
        this.mActivity = null;
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          if (Dbg.d()) {
            Dbg.d("onPostExecute Error: " + localIllegalArgumentException.getMessage());
          }
          this.mActivity = null;
        }
      }
    }
    
    protected void onPreExecute()
    {
      this.mActivity.showDialog(0);
    }
  }
  
  private class Runner
    implements RadioListDialog.IRunner
  {
    private Runner() {}
    
    public void run(String paramString)
    {
      try
      {
        FacebookSettings.this.mAudience = Integer.valueOf(paramString).intValue();
        String str = FacebookSettings.this.mFacebookUtils.getLocalizedAudience(FacebookSettings.this.mAudience);
        ((TextView)FacebookSettings.this.findViewById(2131558445)).setText(str);
        FacebookSettings.this.removeDialog(2);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          FacebookSettings.this.mAudience = 2;
        }
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.facebook.FacebookSettings
 * JD-Core Version:    0.7.0.1
 */