package com.sonyericsson.extras.liveware.experience;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.actions.bluetooth.Bluetooth;
import com.sonyericsson.extras.liveware.analytics.SmartConnectAnalytics;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.List;
import java.util.UUID;

public class ExperienceRunner
{
  private static final int VIBRATION_LENGTH = 300;
  public List<ActionSet> mActionSets;
  private Context mContext;
  private int mCurrentAction;
  public Experience mExperience;
  private boolean mStartActions;
  
  public ExperienceRunner(Context paramContext, Experience paramExperience, List<ActionSet> paramList, boolean paramBoolean)
  {
    this.mExperience = paramExperience;
    this.mActionSets = paramList;
    this.mContext = paramContext;
    this.mCurrentAction = -1;
    this.mStartActions = paramBoolean;
  }
  
  public ActionSet getActionSet(String paramString)
  {
    ActionSet localActionSet = getCurrentActionSet();
    if (localActionSet != null)
    {
      if (!localActionSet.getUuid().toString().equals(paramString)) {
        localActionSet = null;
      }
    }
    else {
      localActionSet = null;
    }
    return localActionSet;
  }
  
  public ActionSet getCurrentActionSet()
  {
    ActionSet localActionSet;
    if ((this.mActionSets != null) && (1 + this.mCurrentAction <= this.mActionSets.size())) {
      localActionSet = (ActionSet)this.mActionSets.get(this.mCurrentAction);
    } else {
      localActionSet = null;
    }
    return localActionSet;
  }
  
  boolean isActionPermittedForDevice(Action paramAction, Device paramDevice)
  {
    boolean bool = true;
    if ((paramDevice != null) && (paramDevice.getBearerType() == 4) && (Bluetooth.class.getCanonicalName().equals(paramAction.getClassName()))) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isRunning()
  {
    boolean bool;
    if (this.mCurrentAction <= -1) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public String runAction()
  {
    this.mCurrentAction = (1 + this.mCurrentAction);
    Object localObject2 = getCurrentActionSet();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((ActionSet)localObject2).getAction();
      if (isActionPermittedForDevice((Action)localObject1, this.mExperience.getDevice())) {
        ((ActionSet)localObject2).execute(this.mContext);
      }
      localObject2 = ((ActionSet)localObject2).getUuid().toString();
      Dbg.d("  ExperienceRunner executing action: " + ((Action)localObject1).getName());
      localObject1 = localObject2;
    }
    else
    {
      Dbg.d("  ExperienceRunner actionSet null, done executing experience: " + this.mExperience.getName());
      localObject1 = null;
    }
    return localObject1;
  }
  
  public String start()
  {
    if (!this.mStartActions)
    {
      this.mExperience.setStoppedTimeStamp(System.currentTimeMillis());
      this.mExperience.setStarted(false);
    }
    else
    {
      this.mExperience.setTimeStamp(System.currentTimeMillis());
      this.mExperience.setStarted(true);
    }
    ExperienceManager.getInstance(this.mContext).updateExperience(this.mExperience);
    String str = runAction();
    if ((PreferenceManager.getDefaultSharedPreferences(this.mContext).getBoolean(this.mContext.getString(2131099731), true)) && (!TextUtils.isEmpty(str)))
    {
      Object localObject = (AudioManager)this.mContext.getSystemService("audio");
      if ((localObject != null) && (((AudioManager)localObject).getRingerMode() != 0)) {
        ((Vibrator)this.mContext.getSystemService("vibrator")).vibrate(300L);
      }
      Context localContext = this.mContext;
      Experience localExperience = this.mExperience;
      if (!this.mStartActions) {
        localObject = "EventStop";
      } else {
        localObject = "EventStart";
      }
      SmartConnectAnalytics.trackExperienceRun(localContext, localExperience, (String)localObject);
    }
    return str;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.experience.ExperienceRunner
 * JD-Core Version:    0.7.0.1
 */