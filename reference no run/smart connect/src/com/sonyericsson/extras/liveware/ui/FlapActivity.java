package com.sonyericsson.extras.liveware.ui;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import com.sonyericsson.extras.liveware.utils.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlapActivity
  extends Activity
{
  private static final String EXTRA_BUFFERED_INTENT = "buffered_intent";
  private static final String KEY_FLAP_DISABLE = "disable_warn_flaps";
  Handler mHandler = new Handler();
  
  public static void cancel(Context paramContext)
  {
    PendingIntent.getActivity(paramContext, 0, createIntent(paramContext), 268435456);
  }
  
  private static Intent createIntent(Context paramContext)
  {
    Intent localIntent;
    if (!((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
      localIntent = new Intent(paramContext, DialogActivity.class);
    } else {
      localIntent = new Intent(paramContext, FlapActivity.class);
    }
    localIntent.addFlags(268435456);
    return localIntent;
  }
  
  private static boolean isFlapWarningDisabled(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("disable_warn_flaps", false);
  }
  
  public static Dialog makeDialog(Activity paramActivity)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setIcon(17301543);
    View localView1 = View.inflate(paramActivity, 2130903061, null);
    ((TextView)localView1.findViewById(2131558453)).setText(AsfUtils.getWaterproofDialogTextId(paramActivity));
    View localView2 = localView1.findViewById(2131558452);
    int i;
    if (!AsfUtils.shouldShowWaterproofTextOnly(paramActivity)) {
      i = 0;
    } else {
      i = 8;
    }
    localView2.setVisibility(i);
    final CheckBox localCheckBox = (CheckBox)localView1.findViewById(2131558455);
    localCheckBox.setChecked(isFlapWarningDisabled(paramActivity));
    localBuilder.setTitle(AsfUtils.getWaterproofDialogTitle(paramActivity));
    localBuilder.setView(localView1);
    localBuilder.setPositiveButton(2131099767, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        FlapActivity.setFlapWarning(FlapActivity.this, localCheckBox.isChecked());
        FlapActivity.runBufferedIntents(FlapActivity.this);
        FlapActivity.this.finish();
      }
    });
    localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        FlapActivity.runBufferedIntents(FlapActivity.this);
        FlapActivity.this.finish();
      }
    });
    return localBuilder.create();
  }
  
  public static void runBufferedIntents(Activity paramActivity)
  {
    ArrayList localArrayList = paramActivity.getIntent().getParcelableArrayListExtra("buffered_intent");
    if (localArrayList != null) {
      runBufferedIntents(paramActivity, localArrayList);
    }
  }
  
  public static void runBufferedIntents(Context paramContext, List<Intent> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      paramContext.startService((Intent)localIterator.next());
    }
  }
  
  private static void setFlapWarning(Context paramContext, boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean("disable_warn_flaps", paramBoolean).commit();
  }
  
  public static void show(Context paramContext, List<Intent> paramList)
  {
    if (!isFlapWarningDisabled(paramContext))
    {
      Object localObject = createIntent(paramContext);
      ((Intent)localObject).putParcelableArrayListExtra("buffered_intent", new ArrayList(paramList));
      localObject = PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 134217728);
      ((AlarmManager)paramContext.getSystemService("alarm")).set(2, 1000L + SystemClock.elapsedRealtime(), (PendingIntent)localObject);
      ((PowerManager)paramContext.getSystemService("power")).newWakeLock(26, "flap").acquire(3000L);
    }
    else
    {
      runBufferedIntents(paramContext, paramList);
    }
  }
  
  private void startTimeout()
  {
    this.mHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        FlapActivity.runBufferedIntents(FlapActivity.this);
        FlapActivity.this.finish();
      }
    }, 30000L);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (!getResources().getBoolean(2131427338)) {
      setTheme(2131361942);
    } else {
      setTheme(2131361938);
    }
    super.onCreate(paramBundle);
    Window localWindow = getWindow();
    localWindow.requestFeature(1);
    localWindow.addFlags(2);
    localWindow.setDimAmount(0.0F);
    localWindow.addFlags(2097152);
    localWindow.addFlags(524288);
    localWindow.addFlags(128);
    localWindow.addFlags(1024);
    localWindow.addFlags(1048576);
    localWindow.setBackgroundDrawableResource(17301673);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    return makeDialog(this);
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    super.onPrepareDialog(paramInt, paramDialog);
    UIUtils.applyDirectionality(paramDialog.getWindow().getDecorView());
  }
  
  protected void onResume()
  {
    super.onResume();
    startTimeout();
    showDialog(0);
  }
  
  public static class DialogActivity
    extends Activity
  {
    protected void onCreate(Bundle paramBundle)
    {
      if (!getResources().getBoolean(2131427338)) {
        super.setTheme(2131361943);
      } else {
        super.setTheme(2131361939);
      }
      super.onCreate(paramBundle);
      showDialog(0);
    }
    
    protected Dialog onCreateDialog(int paramInt)
    {
      return FlapActivity.makeDialog(this);
    }
    
    protected void onPrepareDialog(int paramInt, Dialog paramDialog)
    {
      super.onPrepareDialog(paramInt, paramDialog);
      UIUtils.applyDirectionality(paramDialog.getWindow().getDecorView());
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.FlapActivity
 * JD-Core Version:    0.7.0.1
 */