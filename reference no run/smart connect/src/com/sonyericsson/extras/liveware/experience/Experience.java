package com.sonyericsson.extras.liveware.experience;

import android.content.ContentValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Experience
{
  public static final int DEVICE_INDEX = 0;
  private static final float DISABLED_ALPHA = 0.5F;
  private static final float ENABLED_ALPHA = 1.0F;
  public static final int TIME_INDEX = 1;
  private int mEnabledState;
  private long mId;
  private Location mLocation;
  private String mName;
  private boolean mNameChangedByUser;
  private long mOldTimeId = 0L;
  private String mPictureName;
  private String mResourceName;
  private List<ActionSet> mStartActions;
  private boolean mStarted;
  private List<ActionSet> mStopActions;
  private long mStoppedTimeStamp;
  private long mTimeStamp;
  private Trigger[] mTriggers;
  private boolean mUpdateDevice = false;
  private boolean mUpdateEnabledState = false;
  private boolean mUpdateLocation = false;
  private boolean mUpdateName = false;
  private boolean mUpdateNameChangedByUser = false;
  private boolean mUpdatePictureName = false;
  private boolean mUpdateStarted = false;
  private boolean mUpdateStoppedTimeStamp = false;
  private boolean mUpdateTime = false;
  private boolean mUpdateTimeStamp = false;
  
  public Experience(String paramString1, String paramString2, Device paramDevice, Location paramLocation, Time paramTime, long paramLong, int paramInt, String paramString3)
  {
    this.mName = paramString1;
    this.mPictureName = paramString2;
    this.mLocation = paramLocation;
    this.mTimeStamp = paramLong;
    this.mEnabledState = paramInt;
    this.mNameChangedByUser = false;
    this.mStoppedTimeStamp = (1L + this.mTimeStamp);
    this.mResourceName = paramString3;
    this.mStarted = false;
    this.mTriggers = new Trigger[2];
    this.mTriggers[0] = paramDevice;
    this.mTriggers[1] = paramTime;
  }
  
  public Experience(String paramString1, String paramString2, Device paramDevice, Location paramLocation, Time paramTime, long paramLong1, int paramInt, boolean paramBoolean1, long paramLong2, boolean paramBoolean2, String paramString3)
  {
    this.mName = paramString1;
    this.mPictureName = paramString2;
    this.mLocation = paramLocation;
    this.mTimeStamp = paramLong1;
    this.mEnabledState = paramInt;
    this.mNameChangedByUser = paramBoolean1;
    this.mStoppedTimeStamp = paramLong2;
    this.mStarted = paramBoolean2;
    this.mResourceName = paramString3;
    this.mTriggers = new Trigger[2];
    this.mTriggers[0] = paramDevice;
    this.mTriggers[1] = paramTime;
  }
  
  private List<ActionSet> getAvailableActionSets(List<ActionSet> paramList)
  {
    if (paramList != null)
    {
      localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ActionSet localActionSet = (ActionSet)localIterator.next();
        if (localActionSet.isAvailable()) {
          localArrayList.add(localActionSet);
        }
      }
    }
    ArrayList localArrayList = null;
    return localArrayList;
  }
  
  public static String getEventPictureFileName(String paramString)
  {
    return paramString.substring(6);
  }
  
  private boolean hasAvailableActionSets(List<ActionSet> paramList)
  {
    boolean bool = false;
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((ActionSet)localIterator.next()).isAvailable()) {
          bool = true;
        }
      }
    }
    return bool;
  }
  
  public static boolean isExternalStorageEventPicture(String paramString)
  {
    boolean bool;
    if (paramString != null) {
      bool = paramString.startsWith("file://");
    } else {
      bool = false;
    }
    return bool;
  }
  
  public List<ActionSet> getAvailableStartActions()
  {
    return getAvailableActionSets(this.mStartActions);
  }
  
  public List<ActionSet> getAvailableStopActions()
  {
    return getAvailableActionSets(this.mStopActions);
  }
  
  public Device getDevice()
  {
    return (Device)this.mTriggers[0];
  }
  
  public int getEnabledState()
  {
    return this.mEnabledState;
  }
  
  public long getId()
  {
    return this.mId;
  }
  
  ContentValues getInsertContentValues()
  {
    int i = 1;
    long l1 = 0L;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("name", this.mName);
    localContentValues.put("pictureName", this.mPictureName);
    long l2;
    if (getDevice() == null) {
      l2 = l1;
    } else {
      l2 = getDevice().getId();
    }
    localContentValues.put("deviceId", Long.valueOf(l2));
    if (this.mLocation == null) {
      l2 = l1;
    } else {
      l2 = this.mLocation.getId();
    }
    localContentValues.put("locationId", Long.valueOf(l2));
    if (getTime() != null) {
      l1 = getTime().getId();
    }
    localContentValues.put("timeId", Long.valueOf(l1));
    localContentValues.put("timestamp", Long.valueOf(this.mTimeStamp));
    localContentValues.put("enabled_state", Integer.valueOf(this.mEnabledState));
    int j;
    if (!this.mNameChangedByUser) {
      j = 0;
    } else {
      j = i;
    }
    localContentValues.put("name_changed_by_user", Integer.valueOf(j));
    localContentValues.put("stop_timestamp", Long.valueOf(this.mStoppedTimeStamp));
    if (!this.mStarted) {
      i = 0;
    }
    localContentValues.put("started", Integer.valueOf(i));
    localContentValues.put("name_resource", this.mResourceName);
    return localContentValues;
  }
  
  public Location getLocation()
  {
    return this.mLocation;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public boolean getNameChangedByUser()
  {
    return this.mNameChangedByUser;
  }
  
  public int getNumberOfAvailableStartActions()
  {
    List localList = getAvailableActionSets(this.mStartActions);
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getNumberOfAvailableStopActions()
  {
    List localList = getAvailableActionSets(this.mStopActions);
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    return i;
  }
  
  public long getOldTimeId()
  {
    return this.mOldTimeId;
  }
  
  public float getPictureAlpha()
  {
    int i;
    if (getEnabledState() != 2) {
      i = 0;
    } else {
      i = 1;
    }
    float f;
    if (i == 0) {
      f = 0.5F;
    } else {
      f = 1.0F;
    }
    return f;
  }
  
  public String getPictureName()
  {
    return this.mPictureName;
  }
  
  public String getResourceName()
  {
    return this.mResourceName;
  }
  
  public List<ActionSet> getStartActions()
  {
    return this.mStartActions;
  }
  
  public List<ActionSet> getStopActions()
  {
    return this.mStopActions;
  }
  
  public long getStoppedTimeStamp()
  {
    return this.mStoppedTimeStamp;
  }
  
  public Time getTime()
  {
    return (Time)this.mTriggers[1];
  }
  
  public long getTimeStamp()
  {
    return this.mTimeStamp;
  }
  
  ContentValues getUpdateContentValues()
  {
    int i = 1;
    long l1 = 0L;
    ContentValues localContentValues = new ContentValues();
    if (this.mUpdateName) {
      localContentValues.put("name", this.mName);
    }
    if (this.mUpdatePictureName) {
      localContentValues.put("pictureName", this.mPictureName);
    }
    long l2;
    if (this.mUpdateDevice)
    {
      if (getDevice() == null) {
        l2 = l1;
      } else {
        l2 = getDevice().getId();
      }
      localContentValues.put("deviceId", Long.valueOf(l2));
    }
    if (this.mUpdateLocation)
    {
      if (this.mLocation == null) {
        l2 = l1;
      } else {
        l2 = this.mLocation.getId();
      }
      localContentValues.put("locationId", Long.valueOf(l2));
    }
    if (this.mUpdateTime)
    {
      if (getTime() != null) {
        l1 = getTime().getId();
      }
      localContentValues.put("timeId", Long.valueOf(l1));
    }
    if (this.mUpdateTimeStamp) {
      localContentValues.put("timestamp", Long.valueOf(this.mTimeStamp));
    }
    if (this.mUpdateEnabledState) {
      localContentValues.put("enabled_state", Integer.valueOf(this.mEnabledState));
    }
    if (this.mUpdateNameChangedByUser)
    {
      int j;
      if (!this.mNameChangedByUser) {
        j = 0;
      } else {
        j = i;
      }
      localContentValues.put("name_changed_by_user", Integer.valueOf(j));
    }
    if (this.mUpdateStoppedTimeStamp) {
      localContentValues.put("stop_timestamp", Long.valueOf(this.mStoppedTimeStamp));
    }
    if (this.mUpdateStarted)
    {
      if (!this.mStarted) {
        i = 0;
      }
      localContentValues.put("started", Integer.valueOf(i));
    }
    return localContentValues;
  }
  
  public boolean hasAvailableStopActions()
  {
    return hasAvailableActionSets(this.mStopActions);
  }
  
  public boolean hasItems()
  {
    boolean bool = true;
    Trigger[] arrayOfTrigger = this.mTriggers;
    int i = arrayOfTrigger.length;
    for (int j = 0; j < i; j++) {
      if (arrayOfTrigger[j] != null) {
        break label47;
      }
    }
    if ((getNumberOfAvailableStartActions() <= 0) && (getNumberOfAvailableStopActions() <= 0)) {
      bool = false;
    }
    label47:
    return bool;
  }
  
  public boolean isPictureNameUpdated()
  {
    return this.mUpdatePictureName;
  }
  
  public boolean isStarted()
  {
    return this.mStarted;
  }
  
  public boolean isTriggersConnected()
  {
    boolean bool = false;
    Trigger[] arrayOfTrigger = this.mTriggers;
    int j = arrayOfTrigger.length;
    int i = 0;
    while (i < j)
    {
      Trigger localTrigger = arrayOfTrigger[i];
      if (localTrigger != null)
      {
        if (localTrigger.isConnected()) {
          bool = true;
        }
      }
      else
      {
        i++;
        continue;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean isValid()
  {
    boolean bool = false;
    int i = 0;
    Trigger[] arrayOfTrigger = this.mTriggers;
    int j = arrayOfTrigger.length;
    for (int k = 0; k < j; k++) {
      if (arrayOfTrigger[k] != null) {
        i = 1;
      }
    }
    if (i != 0) {
      if (getNumberOfAvailableStartActions() <= 0)
      {
        if (getNumberOfAvailableStopActions() > 0) {
          bool = true;
        }
      }
      else {
        bool = true;
      }
    }
    return bool;
  }
  
  public void resetChangedFlags()
  {
    this.mUpdateName = false;
    this.mUpdatePictureName = false;
    this.mUpdateDevice = false;
    this.mUpdateLocation = false;
    this.mUpdateTime = false;
    this.mUpdateTimeStamp = false;
    this.mUpdateEnabledState = false;
    this.mUpdateNameChangedByUser = false;
    this.mUpdateStoppedTimeStamp = false;
    this.mUpdateStarted = false;
    this.mOldTimeId = 0L;
  }
  
  public void setDevice(Device paramDevice)
  {
    this.mTriggers[0] = paramDevice;
    this.mUpdateDevice = true;
  }
  
  public void setEnabledState(int paramInt)
  {
    this.mEnabledState = paramInt;
    this.mUpdateEnabledState = true;
  }
  
  public void setId(long paramLong)
  {
    this.mId = paramLong;
  }
  
  public void setLocation(Location paramLocation)
  {
    this.mLocation = paramLocation;
    this.mUpdateLocation = true;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
    this.mUpdateName = true;
  }
  
  public void setNameChangedByUser(boolean paramBoolean)
  {
    this.mNameChangedByUser = paramBoolean;
    this.mUpdateNameChangedByUser = true;
  }
  
  public void setPictureName(String paramString)
  {
    this.mPictureName = paramString;
    this.mUpdatePictureName = true;
  }
  
  public void setResourcename(String paramString)
  {
    this.mResourceName = paramString;
  }
  
  public void setStartActions(List<ActionSet> paramList)
  {
    this.mStartActions = paramList;
  }
  
  public void setStarted(boolean paramBoolean)
  {
    this.mStarted = paramBoolean;
    this.mUpdateStarted = true;
  }
  
  public void setStopActions(List<ActionSet> paramList)
  {
    this.mStopActions = paramList;
  }
  
  public void setStoppedTimeStamp(long paramLong)
  {
    this.mStoppedTimeStamp = paramLong;
    this.mUpdateStoppedTimeStamp = true;
  }
  
  public void setTime(Time paramTime)
  {
    if (this.mTriggers[1] != null) {
      this.mOldTimeId = ((Time)this.mTriggers[1]).getId();
    }
    this.mTriggers[1] = paramTime;
    this.mUpdateTime = true;
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.mTimeStamp = paramLong;
    this.mUpdateTimeStamp = true;
  }
  
  public boolean updateDevice()
  {
    return this.mUpdateDevice;
  }
  
  public boolean updateEnabledState()
  {
    return this.mUpdateEnabledState;
  }
  
  public boolean updateTime()
  {
    return this.mUpdateTime;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.experience.Experience
 * JD-Core Version:    0.7.0.1
 */