package com.sonyericsson.extras.liveware.actions;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.sonyericsson.extras.liveware.utils.ActionUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;

public abstract class AbstractAction
  extends IntentService
{
  public AbstractAction(String paramString)
  {
    super(paramString);
  }
  
  protected abstract Intent getExecuteIntent(Context paramContext, Intent paramIntent);
  
  protected abstract Intent getInjectSettingsIntent(Context paramContext, Intent paramIntent);
  
  protected abstract String getLocalizedLabelFromIntent(Context paramContext, Intent paramIntent);
  
  protected abstract Intent getSettingsIntent(Context paramContext, Intent paramIntent);
  
  protected boolean isCompatible(Context paramContext)
  {
    return true;
  }
  
  protected void onCheckCompabilityAction(Context paramContext, Intent paramIntent)
  {
    ActionUtils.sendCompabilityResponseIntent(paramContext, paramIntent.getStringExtra("id"), isCompatible(paramContext));
  }
  
  protected void onExecute(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = getExecuteIntent(paramContext, paramIntent);
    if (localIntent != null)
    {
      localIntent.putExtras(paramIntent);
      paramContext.startService(localIntent);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (!paramIntent.getAction().equalsIgnoreCase("com.sonymobile.smartconnect.action.EXECUTE_ACTION"))
    {
      if (!paramIntent.getAction().equalsIgnoreCase("com.sonymobile.smartconnect.action.SETTINGS_INJECT"))
      {
        if (!paramIntent.getAction().equalsIgnoreCase("com.sonymobile.smartconnect.action.UPDATE_ACTION"))
        {
          if (!paramIntent.getAction().equalsIgnoreCase("com.sonymobile.smartconnect.action.CHECK_COMPABILITY_ACTION")) {
            Dbg.e("Intent not recognized.");
          } else {
            onCheckCompabilityAction(this, paramIntent);
          }
        }
        else {
          onUpdateAction(this, paramIntent);
        }
      }
      else if (paramIntent.getStringExtra("setting_inject") == null) {
        Dbg.e("AbstractActionReceiver SETTINGS_ACTION with no EXTRA_SETTING_INJECT");
      } else {
        onInjectSettings(this, paramIntent);
      }
    }
    else {
      onExecute(this, paramIntent);
    }
  }
  
  protected void onInjectSettings(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = getInjectSettingsIntent(paramContext, paramIntent);
    if (localIntent != null)
    {
      localIntent.putExtras(paramIntent);
      paramContext.startService(localIntent);
    }
  }
  
  protected void onUpdateAction(Context paramContext, Intent paramIntent)
  {
    ActionUtils.sendUpdateActionResponseIntent(paramContext, paramIntent.getStringExtra("id"), getLocalizedLabelFromIntent(paramContext, paramIntent));
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.AbstractAction
 * JD-Core Version:    0.7.0.1
 */