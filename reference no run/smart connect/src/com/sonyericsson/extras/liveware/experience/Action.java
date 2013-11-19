package com.sonyericsson.extras.liveware.experience;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.sonyericsson.extras.liveware.db.ExperienceDef.ActionTable;
import java.util.ArrayList;
import java.util.UUID;

public class Action
{
  public static final int CATEGORY_APPLICATIONS = 1;
  public static final int CATEGORY_COMMUNICATION = 4;
  public static final int CATEGORY_DISPLAY = 6;
  public static final int CATEGORY_LAST = 7;
  public static final int CATEGORY_MEDIA = 2;
  public static final int CATEGORY_NETWORK = 5;
  public static final int CATEGORY_OTHER = 0;
  public static final int CATEGORY_SOUND = 3;
  public static final int CATEGORY_TEXT_TO_SPEECH = 7;
  private String mActivityName;
  private int mCategory;
  private String mClassName;
  private boolean mDisabled = false;
  private String mIconUri;
  private long mId;
  private String mName;
  private String mPackageName;
  private UUID mUuid;
  
  public Action(String paramString1, String paramString2, String paramString3, UUID paramUUID, String paramString4, String paramString5, int paramInt)
  {
    this.mName = paramString1;
    this.mClassName = paramString2;
    this.mPackageName = paramString3;
    this.mUuid = paramUUID;
    this.mIconUri = paramString4;
    this.mActivityName = paramString5;
    this.mCategory = paramInt;
  }
  
  public ActionEditor edit()
  {
    return new ActionEditor(this);
  }
  
  public String getActivityName()
  {
    return this.mActivityName;
  }
  
  public int getCategory()
  {
    return this.mCategory;
  }
  
  public String getClassName()
  {
    return this.mClassName;
  }
  
  ContentValues getContentValues()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("name", this.mName);
    localContentValues.put("class", this.mClassName);
    localContentValues.put("package", this.mPackageName);
    localContentValues.put("activity", this.mActivityName);
    localContentValues.put("iconUri", this.mIconUri);
    localContentValues.put("UUID", this.mUuid.toString());
    int i;
    if (!this.mDisabled) {
      i = 0;
    } else {
      i = 1;
    }
    localContentValues.put("disabled", Integer.valueOf(i));
    localContentValues.put("category", Integer.valueOf(this.mCategory));
    return localContentValues;
  }
  
  public String getIconUri()
  {
    return this.mIconUri;
  }
  
  public long getId()
  {
    return this.mId;
  }
  
  ContentProviderOperation getInsertOperation()
  {
    return ContentProviderOperation.newInsert(ExperienceDef.ActionTable.URI).withValues(getContentValues()).build();
  }
  
  void getInsertOperation(ArrayList<ContentProviderOperation> paramArrayList)
  {
    paramArrayList.add(getInsertOperation());
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPackageName()
  {
    return this.mPackageName;
  }
  
  public UUID getUuid()
  {
    return this.mUuid;
  }
  
  public boolean isDisabled()
  {
    return this.mDisabled;
  }
  
  public void requestCompability(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("com.sonymobile.smartconnect.action.CHECK_COMPABILITY_ACTION");
    localIntent.putExtra("id", paramString);
    localIntent.setClassName(this.mPackageName, this.mClassName);
    paramContext.startService(localIntent);
  }
  
  public void setCategory(int paramInt)
  {
    this.mCategory = paramInt;
  }
  
  public void setClassName(String paramString)
  {
    this.mClassName = paramString;
  }
  
  public void setDisabled(boolean paramBoolean)
  {
    this.mDisabled = paramBoolean;
  }
  
  public void setIconUri(String paramString)
  {
    this.mIconUri = paramString;
  }
  
  public void setId(long paramLong)
  {
    this.mId = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.mPackageName = paramString;
  }
  
  public void setUuid(UUID paramUUID)
  {
    this.mUuid = paramUUID;
  }
  
  int unwrapContentProviderInsertResults(ContentProviderResult[] paramArrayOfContentProviderResult, int paramInt)
  {
    if (paramInt < paramArrayOfContentProviderResult.length)
    {
      setId(Long.parseLong(paramArrayOfContentProviderResult[paramInt].uri.getLastPathSegment()));
      paramInt++;
    }
    return paramInt;
  }
  
  public static class ActionEditor
  {
    private Action mAction;
    private String mActivityName;
    private Integer mCategory;
    private Boolean mDisabled;
    private String mIconUri;
    private String mName;
    
    public ActionEditor(Action paramAction)
    {
      this.mAction = paramAction;
    }
    
    public Action getAction()
    {
      return this.mAction;
    }
    
    public ContentValues getUpdatedValues()
    {
      ContentValues localContentValues = new ContentValues();
      if (this.mName != null) {
        localContentValues.put("name", this.mName);
      }
      if (this.mIconUri != null) {
        localContentValues.put("iconUri", this.mIconUri);
      }
      if (this.mDisabled != null)
      {
        int i;
        if (!this.mDisabled.booleanValue()) {
          i = 0;
        } else {
          i = 1;
        }
        localContentValues.put("disabled", Integer.valueOf(i));
      }
      if (this.mActivityName != null) {
        localContentValues.put("activity", this.mActivityName);
      }
      if (this.mCategory != null) {
        localContentValues.put("category", this.mCategory);
      }
      return localContentValues;
    }
    
    public ActionEditor setActivityName(String paramString)
    {
      this.mActivityName = paramString;
      return this;
    }
    
    public ActionEditor setCategory(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > 7)) {
        paramInt = 0;
      }
      this.mCategory = Integer.valueOf(paramInt);
      return this;
    }
    
    public ActionEditor setDisable(boolean paramBoolean)
    {
      this.mDisabled = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public ActionEditor setIconUri(String paramString)
    {
      this.mIconUri = paramString;
      return this;
    }
    
    public ActionEditor setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.experience.Action
 * JD-Core Version:    0.7.0.1
 */