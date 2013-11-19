package com.sonyericsson.extras.liveware.experience;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.db.ExperienceDef.ActionSetTable;
import java.util.UUID;

public class ActionSet
{
  private Action mAction;
  private long mExperienceId;
  private int mFinalizedStatus;
  private long mId;
  private int mPosition;
  private String mRawSetting;
  private String mSettingsLabel;
  private int mType;
  private UUID mUuid;
  
  public ActionSet(Action paramAction, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, UUID paramUUID, int paramInt3)
  {
    this.mAction = paramAction;
    this.mExperienceId = paramLong;
    this.mType = paramInt1;
    this.mPosition = paramInt2;
    this.mSettingsLabel = paramString1;
    this.mRawSetting = paramString2;
    this.mUuid = paramUUID;
    this.mFinalizedStatus = paramInt3;
  }
  
  public ActionSetEditor edit()
  {
    return new ActionSetEditor(this);
  }
  
  public void execute(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("id", this.mUuid.toString());
    localIntent.putExtra("setting_raw", this.mRawSetting);
    localIntent.setAction("com.sonymobile.smartconnect.action.EXECUTE_ACTION");
    localIntent.setClassName(this.mAction.getPackageName(), this.mAction.getClassName());
    paramContext.startService(localIntent);
  }
  
  public Action getAction()
  {
    return this.mAction;
  }
  
  public ContentValues getContentValues()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("experienceId", Long.valueOf(this.mExperienceId));
    localContentValues.put("actionId", Long.valueOf(this.mAction.getId()));
    localContentValues.put("actionSetType", Integer.valueOf(this.mType));
    localContentValues.put("position", Integer.valueOf(this.mPosition));
    localContentValues.put("label", this.mSettingsLabel);
    localContentValues.put("rawSetting", this.mRawSetting);
    localContentValues.put("UUID", this.mUuid.toString());
    localContentValues.put("finalized", Integer.valueOf(this.mFinalizedStatus));
    return localContentValues;
  }
  
  public long getExperience()
  {
    return this.mExperienceId;
  }
  
  public int getFinalizedStatus()
  {
    return this.mFinalizedStatus;
  }
  
  public String getFormattedString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mAction.getName());
    if (!TextUtils.isEmpty(this.mSettingsLabel))
    {
      localStringBuilder.append(": ");
      localStringBuilder.append(this.mSettingsLabel);
    }
    return localStringBuilder.toString();
  }
  
  public long getId()
  {
    return this.mId;
  }
  
  public ContentProviderOperation getInsertOperation()
  {
    return ContentProviderOperation.newInsert(ExperienceDef.ActionSetTable.URI).withValues(getContentValues()).build();
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  public String getRawSetting()
  {
    return this.mRawSetting;
  }
  
  public String getSettingsLabel()
  {
    return this.mSettingsLabel;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public UUID getUuid()
  {
    return this.mUuid;
  }
  
  public boolean isAvailable()
  {
    boolean bool;
    if ((!isFinalized()) || (this.mAction.isDisabled())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean isFinalized()
  {
    int i = 1;
    if (this.mFinalizedStatus != i) {
      i = 0;
    }
    return i;
  }
  
  public void requestUpdate(Context paramContext)
  {
    Intent localIntent = new Intent("com.sonymobile.smartconnect.action.UPDATE_ACTION");
    localIntent.putExtra("id", getUuid().toString());
    localIntent.putExtra("setting_raw", getRawSetting());
    localIntent.setClassName(this.mAction.getPackageName(), this.mAction.getClassName());
    paramContext.startService(localIntent);
  }
  
  public void setAction(Action paramAction)
  {
    this.mAction = paramAction;
  }
  
  public void setExperience(Experience paramExperience)
  {
    this.mExperienceId = paramExperience.getId();
  }
  
  public void setFinalizedStatus(int paramInt)
  {
    this.mFinalizedStatus = paramInt;
  }
  
  public void setId(long paramLong)
  {
    this.mId = paramLong;
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
  
  public void setSettingsLabel(String paramString)
  {
    this.mSettingsLabel = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public void setUuid(UUID paramUUID)
  {
    this.mUuid = paramUUID;
  }
  
  public void settingsInject(Context paramContext)
  {
    Intent localIntent = new Intent("com.sonymobile.smartconnect.action.SETTINGS_INJECT");
    localIntent.putExtra("id", this.mUuid.toString());
    localIntent.putExtra("setting_inject", this.mSettingsLabel);
    localIntent.setClassName(this.mAction.getPackageName(), this.mAction.getClassName());
    paramContext.startService(localIntent);
  }
  
  public int settingsUi(Fragment paramFragment, Activity paramActivity, int paramInt)
  {
    int i = 2;
    if (TextUtils.isEmpty(this.mAction.getActivityName())) {
      i = 0;
    }
    for (;;)
    {
      return i;
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.putExtra("id", this.mUuid.toString());
      localIntent.putExtra("setting_raw", this.mRawSetting);
      localIntent.setComponent(ComponentName.unflattenFromString(this.mAction.getPackageName() + "/" + this.mAction.getActivityName()));
      if (paramFragment != null) {}
      try
      {
        paramFragment.startActivityForResult(localIntent, paramInt);
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        i = 1;
      }
      paramActivity.startActivityForResult(localIntent, paramInt);
    }
  }
  
  public static class ActionSetEditor
  {
    private Action mAction;
    private ActionSet mActionSet;
    private Experience mExperience;
    private Integer mFinalizedStatus;
    private Integer mPosition;
    private String mRawSetting;
    private String mSettingsLabel;
    
    public ActionSetEditor(ActionSet paramActionSet)
    {
      this.mActionSet = paramActionSet;
    }
    
    public ActionSet getActionSet()
    {
      return this.mActionSet;
    }
    
    public ContentValues getUpdatedValues()
    {
      ContentValues localContentValues = new ContentValues();
      if (this.mFinalizedStatus != null) {
        localContentValues.put("finalized", this.mFinalizedStatus);
      }
      if (this.mExperience != null) {
        localContentValues.put("experienceId", Long.valueOf(this.mExperience.getId()));
      }
      if (this.mAction != null) {
        localContentValues.put("actionId", Long.valueOf(this.mAction.getId()));
      }
      if (this.mPosition != null) {
        localContentValues.put("position", this.mPosition);
      }
      if (this.mSettingsLabel != null) {
        localContentValues.put("label", this.mSettingsLabel);
      }
      if (this.mRawSetting != null) {
        localContentValues.put("rawSetting", this.mRawSetting);
      }
      return localContentValues;
    }
    
    public ActionSetEditor setAction(Action paramAction)
    {
      this.mAction = paramAction;
      return this;
    }
    
    public ActionSetEditor setExperience(Experience paramExperience)
    {
      this.mExperience = paramExperience;
      return this;
    }
    
    public ActionSetEditor setFinalizedStatus(int paramInt)
    {
      this.mFinalizedStatus = Integer.valueOf(paramInt);
      return this;
    }
    
    public ActionSetEditor setPosition(int paramInt)
    {
      this.mPosition = Integer.valueOf(paramInt);
      return this;
    }
    
    public ActionSetEditor setRawSetting(String paramString)
    {
      this.mRawSetting = paramString;
      return this;
    }
    
    public ActionSetEditor setSettingsLabel(String paramString)
    {
      this.mSettingsLabel = paramString;
      return this;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.experience.ActionSet
 * JD-Core Version:    0.7.0.1
 */