package com.sonyericsson.extras.liveware.experience;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import com.sonyericsson.extras.liveware.db.ExperienceDef.LocationTriggerTable;

public class Location
{
  private boolean mConnected;
  private String mDescription;
  private long mId;
  private String mMacAddress;
  private String mName;
  private String mSSID;
  
  public Location(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.mName = paramString1;
    this.mDescription = paramString2;
    this.mMacAddress = paramString3;
    this.mSSID = paramString4;
    this.mConnected = paramBoolean;
  }
  
  public boolean getConnected()
  {
    return this.mConnected;
  }
  
  ContentValues getContentValues()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("name", this.mName);
    localContentValues.put("description", this.mDescription);
    localContentValues.put("mac_address", this.mMacAddress);
    localContentValues.put("ssid", this.mSSID);
    localContentValues.put("trigger_status", Boolean.valueOf(this.mConnected));
    return localContentValues;
  }
  
  public String getDescription()
  {
    return this.mDescription;
  }
  
  public long getId()
  {
    return this.mId;
  }
  
  ContentProviderOperation getInsertOperation()
  {
    return ContentProviderOperation.newInsert(ExperienceDef.LocationTriggerTable.URI).withValues(getContentValues()).build();
  }
  
  public String getMacAddress()
  {
    return this.mMacAddress;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getSSID()
  {
    return this.mSSID;
  }
  
  public void setConnected(boolean paramBoolean)
  {
    this.mConnected = paramBoolean;
  }
  
  public void setDescription(String paramString)
  {
    this.mDescription = paramString;
  }
  
  public void setId(long paramLong)
  {
    this.mId = paramLong;
  }
  
  public void setMacAddress(String paramString)
  {
    this.mMacAddress = paramString;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setSSID(String paramString)
  {
    this.mSSID = paramString;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.experience.Location
 * JD-Core Version:    0.7.0.1
 */