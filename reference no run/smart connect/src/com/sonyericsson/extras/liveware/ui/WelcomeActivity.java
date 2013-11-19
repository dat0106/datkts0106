package com.sonyericsson.extras.liveware.ui;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.MarketUtils;
import com.sonyericsson.extras.liveware.utils.PreferenceHelper;
import com.sonyericsson.extras.liveware.utils.UIUtils;

public class WelcomeActivity
  extends BaseActivity
{
  private static final int DLG_ABOUT = 1;
  private static final int DLG_LEGAL = 2;
  
  private void addTitle(AlertDialog.Builder paramBuilder, int paramInt)
  {
    View localView = View.inflate(this, paramInt, null);
    UIUtils.applyDirectionality(localView);
    paramBuilder.setCustomTitle(localView);
  }
  
  public static void show(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, WelcomeActivity.class);
    localIntent.addFlags(67108864);
    paramContext.startActivity(localIntent);
  }
  
  private Dialog showMessageDialog(final int paramInt1, String paramString, int paramInt2)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    addTitle(localBuilder, paramInt2);
    Object localObject1 = getLayoutInflater().inflate(2130903048, (ViewGroup)findViewById(2131558411));
    Object localObject2 = new ScrollView(this);
    ((ScrollView)localObject2).addView((View)localObject1);
    localBuilder.setView((View)localObject2);
    localObject2 = (TextView)((View)localObject1).findViewById(2131558412);
    if (localObject2 != null)
    {
      localObject1 = new SpannableString(paramString);
      Linkify.addLinks((Spannable)localObject1, 15);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
    }
    localBuilder.setNeutralButton(getString(2131099767), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        WelcomeActivity.this.removeDialog(paramInt1);
      }
    });
    return localBuilder.create();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(LayoutInflater.from(this).inflate(2130903089, null));
    findViewById(2131558547).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HomeScreenActivity.show(WelcomeActivity.this);
        PreferenceHelper.saveFirstLaunch(WelcomeActivity.this, false);
        WelcomeActivity.this.finish();
      }
    });
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject = super.onCreateDialog(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localObject;
      localObject = null;
      try
      {
        localObject = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        label48:
        StringBuilder localStringBuilder = new StringBuilder("v").append((String)localObject).append("\n\n");
        localObject = new Object[1];
        localObject[0] = getString(2131099670);
        localObject = showMessageDialog(1, getString(2131099791, (Object[])localObject), 2130903047);
        continue;
        localObject = showMessageDialog(2, getString(2131099975) + "\n\n" + getString(2131099669), 2130903046);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        break label48;
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131689481, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      if (Dbg.d()) {
        Dbg.d("Illegal menu item.");
      }
      break;
    case 2131558566: 
      MarketUtils.launchInfo(this, getPackageName());
      break;
    case 2131558567: 
      showDialog(2);
      break;
    case 2131558568: 
      showDialog(1);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.ui.WelcomeActivity
 * JD-Core Version:    0.7.0.1
 */