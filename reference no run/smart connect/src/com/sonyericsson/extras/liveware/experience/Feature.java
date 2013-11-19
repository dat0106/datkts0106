package com.sonyericsson.extras.liveware.experience;

import android.content.ComponentName;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import com.sonyericsson.extras.liveware.db.ExperienceDef.FeatureConstants;
import com.sonyericsson.extras.liveware.db.ExperienceDef.FeatureTable;

public class Feature
  implements ExperienceDef.FeatureConstants
{
  private int mAppSelection;
  private String mClassName;
  private String mCompanionName;
  private String mCompanionPkg;
  private Device mDevice;
  private long mId;
  private String mIntent;
  private boolean mModifiedByUser;
  private String mPackageName;
  private int mState;
  private int mType;
  
  public Feature(Device paramDevice, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5)
  {
    this.mDevice = paramDevice;
    this.mType = paramInt1;
    this.mPackageName = paramString1;
    this.mClassName = paramString2;
    this.mIntent = paramString3;
    this.mCompanionName = paramString4;
    this.mCompanionPkg = paramString5;
    this.mId = 0L;
    this.mModifiedByUser = false;
    this.mAppSelection = paramInt2;
    this.mState = 2;
  }
  
  public FeatureEditor edit()
  {
    return new FeatureEditor(this);
  }
  
  public int getAppSelection()
  {
    return this.mAppSelection;
  }
  
  public String getClassName()
  {
    return this.mClassName;
  }
  
  public String getCompanionName()
  {
    return this.mCompanionName;
  }
  
  public String getCompanionPkg()
  {
    return this.mCompanionPkg;
  }
  
  public ComponentName getComponentName()
  {
    ComponentName localComponentName;
    if ((this.mPackageName == null) || (this.mClassName == null)) {
      localComponentName = null;
    } else {
      localComponentName = new ComponentName(this.mPackageName, this.mClassName);
    }
    return localComponentName;
  }
  
  ContentValues getContentValues()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("type", Integer.valueOf(this.mType));
    localContentValues.put("app_selection", Integer.valueOf(this.mAppSelection));
    localContentValues.put("package_name", this.mPackageName);
    localContentValues.put("class_name", this.mClassName);
    localContentValues.put("intent", this.mIntent);
    localContentValues.put("companion_name", this.mCompanionName);
    localContentValues.put("companion_pkg", this.mCompanionPkg);
    localContentValues.put("enabled", Integer.valueOf(this.mState));
    localContentValues.put("modified_by_user", Boolean.valueOf(this.mModifiedByUser));
    localContentValues.put("device_id", Long.valueOf(this.mDevice.getId()));
    return localContentValues;
  }
  
  public long getId()
  {
    return this.mId;
  }
  
  ContentProviderOperation getInsertOperation(int paramInt)
  {
    ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newInsert(ExperienceDef.FeatureTable.URI).withValues(getContentValues());
    localBuilder.withValueBackReference("device_id", paramInt);
    return localBuilder.build();
  }
  
  public String getIntent()
  {
    return this.mIntent;
  }
  
  public String getPackageName()
  {
    return this.mPackageName;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public boolean isModifiedByUser()
  {
    return this.mModifiedByUser;
  }
  
  public void setId(long paramLong)
  {
    this.mId = paramLong;
  }
  
  public void setModifiedByUser(boolean paramBoolean)
  {
    this.mModifiedByUser = paramBoolean;
  }
  
  public void setState(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public static class FeatureEditor
  {
    private Integer mAppSelection;
    private String mClassName;
    private boolean mEditedName;
    private Feature mFeature;
    private String mPackageName;
    private Integer mState;
    
    public FeatureEditor(Feature paramFeature)
    {
      this.mFeature = paramFeature;
      this.mEditedName = false;
    }
    
    public Feature getFeature()
    {
      return this.mFeature;
    }
    
    public ContentValues getUpdatedValues()
    {
      ContentValues localContentValues = new ContentValues();
      if (this.mAppSelection != null) {
        localContentValues.put("app_selection", this.mAppSelection);
      }
      if (this.mState != null) {
        localContentValues.put("enabled", this.mState);
      }
      if (this.mEditedName)
      {
        localContentValues.put("class_name", this.mClassName);
        localContentValues.put("package_name", this.mPackageName);
      }
      return localContentValues;
    }
    
    public FeatureEditor setAppSelection(int paramInt)
    {
      this.mAppSelection = Integer.valueOf(paramInt);
      return this;
    }
    
    public FeatureEditor setComponentName(ComponentName paramComponentName)
    {
      if (paramComponentName == null)
      {
        this.mClassName = null;
        this.mPackageName = null;
      }
      else
      {
        this.mClassName = paramComponentName.getClassName();
        this.mPackageName = paramComponentName.getPackageName();
      }
      this.mEditedName = true;
      return this;
    }
    
    public FeatureEditor setState(int paramInt)
    {
      this.mState = Integer.valueOf(paramInt);
      return this;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.experience.Feature
 * JD-Core Version:    0.7.0.1
 */