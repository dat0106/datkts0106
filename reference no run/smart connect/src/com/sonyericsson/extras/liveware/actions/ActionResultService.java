package com.sonyericsson.extras.liveware.actions;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.asf.ExperienceService;
import com.sonyericsson.extras.liveware.experience.Action;
import com.sonyericsson.extras.liveware.experience.Action.ActionEditor;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.ActionSet.ActionSetEditor;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.UUID;

public class ActionResultService
  extends IntentService
{
  private static final String NAME = "ActionResultService";
  private Intent mIntent;
  
  public ActionResultService()
  {
    super("ActionResultService");
  }
  
  private void handleCompabilityResponse()
  {
    boolean bool = false;
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(this);
    Object localObject = localExperienceManager.getActionByUuid(this.mIntent.getStringExtra("id"));
    if (localObject != null)
    {
      localObject = ((Action)localObject).edit();
      if (!this.mIntent.getBooleanExtra("is_compatible", false)) {
        bool = true;
      }
      localExperienceManager.updateAction(((Action.ActionEditor)localObject).setDisable(bool));
    }
  }
  
  private void handleSettingsInjectResponse()
  {
    Object localObject = this.mIntent.getStringExtra("id");
    try
    {
      UUID localUUID = UUID.fromString((String)localObject);
      int i = this.mIntent.getIntExtra("inject_result", 1);
      ExperienceManager localExperienceManager = ExperienceManager.getInstance(this);
      localObject = localExperienceManager.getActionSetByUuid(localUUID.toString());
      String str;
      if ((localObject != null) && (i == 0))
      {
        str = this.mIntent.getStringExtra("setting_raw");
        if ((str != null) && (!str.equals(((ActionSet)localObject).getRawSetting()))) {
          localExperienceManager.updateActionSet(((ActionSet)localObject).edit().setRawSetting(str));
        }
        localExperienceManager.getActionSetByUuid(localUUID.toString()).requestUpdate(this);
      }
      else if (Dbg.e())
      {
        Dbg.e("handleSettingsInjectResponse actionSet: " + localObject + " status: " + str);
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      Dbg.e("handleSettingsInjectResponse: ", localNullPointerException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Dbg.e("handleSettingsInjectResponse: ", localIllegalArgumentException);
    }
  }
  
  private void handleUpdateResponse()
  {
    ExperienceManager localExperienceManager = ExperienceManager.getInstance(this);
    Object localObject = this.mIntent.getStringExtra("id");
    String str = this.mIntent.getStringExtra("setting_label");
    ActionSet localActionSet = localExperienceManager.getActionSetByUuid((String)localObject);
    if (localActionSet != null)
    {
      localObject = localActionSet.edit();
      ((ActionSet.ActionSetEditor)localObject).setSettingsLabel(str);
      if (!localActionSet.isFinalized()) {
        ((ActionSet.ActionSetEditor)localObject).setFinalizedStatus(1);
      }
      localExperienceManager.updateActionSet((ActionSet.ActionSetEditor)localObject);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())))
    {
      if (!paramIntent.getAction().equals("com.sonymobile.smartconnect.action.UPDATE_RESPONSE_ACTION"))
      {
        if (!paramIntent.getAction().equals("com.sonymobile.smartconnect.action.EXECUTE_RESPONSE_ACTION"))
        {
          if (!paramIntent.getAction().equals("com.sonymobile.smartconnect.action.SETTINGS_INJECT_RESPONSE_ACTION"))
          {
            if (!paramIntent.getAction().equals("com.sonymobile.smartconnect.action.CHECK_COMPABILITY_ACTION_RESPONSE_ACTION")) {
              Dbg.e("Invalid action " + paramIntent.getAction());
            } else {
              handleCompabilityResponse();
            }
          }
          else {
            handleSettingsInjectResponse();
          }
        }
        else
        {
          paramIntent.setComponent(new ComponentName(this, ExperienceService.class));
          startService(paramIntent);
        }
      }
      else {
        handleUpdateResponse();
      }
    }
    else {
      Dbg.e("Empty action");
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.actions.ActionResultService
 * JD-Core Version:    0.7.0.1
 */