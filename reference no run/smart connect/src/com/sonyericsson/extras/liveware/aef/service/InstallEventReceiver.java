package com.sonyericsson.extras.liveware.aef.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sonyericsson.extras.liveware.actions.appshortcut.AppShortcut;
import com.sonyericsson.extras.liveware.actions.launchapp.LaunchApp;
import com.sonyericsson.extras.liveware.experience.Action;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.ActionSet.ActionSetEditor;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.Iterator;
import java.util.List;

public class InstallEventReceiver
  extends BroadcastReceiver
{
  private static void launchService(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (Dbg.d()) {
      Dbg.d("action = " + (String)localObject);
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(paramContext, DbMaintenanceService.class));
    if (!((String)localObject).equals("android.intent.action.PACKAGE_ADDED"))
    {
      if ((((String)localObject).equals("android.intent.action.PACKAGE_REMOVED")) && (!paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false)))
      {
        localObject = paramIntent.getData();
        if (localObject != null)
        {
          localObject = ((Uri)localObject).getSchemeSpecificPart();
          if (localObject != null)
          {
            updateActions(paramContext, (String)localObject);
            localIntent.putExtra("SERVICE_COMMAND", "PACKAGE_REMOVED");
            localIntent.putExtra("PACKAGE_UID", paramIntent.getIntExtra("android.intent.extra.UID", 0));
            localIntent.putExtra("PACKAGE_NAME", (String)localObject);
            paramContext.startService(localIntent);
          }
        }
      }
    }
    else
    {
      if ((paramIntent.getData() != null) && (paramIntent.getData().getSchemeSpecificPart() != null)) {
        updateActions(paramContext, paramIntent.getData().getSchemeSpecificPart());
      }
      localIntent.putExtra("SERVICE_COMMAND", "PACKAGE_ADDED");
      localIntent.putExtra("PACKAGE_UID", paramIntent.getIntExtra("android.intent.extra.UID", 0));
      paramContext.startService(localIntent);
    }
  }
  
  private static void updateActions(Context paramContext, final String paramString)
  {
    new Thread(new Runnable()
    {
      ExperienceManager experienceManager = ExperienceManager.getInstance(InstallEventReceiver.this);
      
      public void run()
      {
        Iterator localIterator = this.experienceManager.getActionSetByPackageName(paramString).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (ActionSet)localIterator.next();
          String str = null;
          if (!LaunchApp.class.getName().equals(((ActionSet)localObject).getAction().getClassName()))
          {
            if (AppShortcut.class.getName().equals(((ActionSet)localObject).getAction().getClassName())) {
              str = AppShortcut.getLabelByRawSetting(InstallEventReceiver.this, ((ActionSet)localObject).getRawSetting());
            }
          }
          else {
            str = LaunchApp.getLabelByRawSetting(InstallEventReceiver.this, ((ActionSet)localObject).getRawSetting());
          }
          if (str != null)
          {
            localObject = ((ActionSet)localObject).edit();
            ((ActionSet.ActionSetEditor)localObject).setSettingsLabel(str);
            this.experienceManager.updateActionSet((ActionSet.ActionSetEditor)localObject);
          }
        }
      }
    }).start();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (Dbg.d()) {
      Dbg.d("InstallEventReceiver.onReceive");
    }
    launchService(paramContext, paramIntent);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.service.InstallEventReceiver
 * JD-Core Version:    0.7.0.1
 */