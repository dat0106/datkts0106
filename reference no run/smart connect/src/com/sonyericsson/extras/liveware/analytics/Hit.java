package com.sonyericsson.extras.liveware.analytics;

import android.content.ContentValues;

class Hit
{
  private final String mAction;
  private final String mCategory;
  private long mId = -1L;
  private final String mLabel;
  private int mValue = 1;
  
  Hit(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this.mId = paramLong;
    this.mCategory = paramString1;
    this.mAction = paramString2;
    this.mLabel = paramString3;
  }
  
  Hit(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.mId = paramLong;
    this.mCategory = paramString1;
    this.mAction = paramString2;
    this.mLabel = paramString3;
    this.mValue = paramInt;
  }
  
  Hit(String paramString1, String paramString2, String paramString3)
  {
    this.mCategory = paramString1;
    this.mAction = paramString2;
    this.mLabel = paramString3;
  }
  
  Hit(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.mCategory = paramString1;
    this.mAction = paramString2;
    this.mLabel = paramString3;
    this.mValue = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this != paramObject) {
      if (paramObject != null)
      {
        if (getClass() == paramObject.getClass())
        {
          Hit localHit = (Hit)paramObject;
          if (this.mAction != null)
          {
            if (!this.mAction.equals(localHit.mAction)) {
              return false;
            }
          }
          else {
            if (localHit.mAction != null) {
              break label152;
            }
          }
          if (this.mCategory != null)
          {
            if (!this.mCategory.equals(localHit.mCategory)) {
              return false;
            }
          }
          else {
            if (localHit.mCategory != null) {
              break label147;
            }
          }
          if (this.mLabel != null)
          {
            if (!this.mLabel.equals(localHit.mLabel)) {
              return false;
            }
          }
          else {
            if (localHit.mLabel != null) {
              break label142;
            }
          }
          if (this.mValue != localHit.mValue)
          {
            return false;
            label142:
            return false;
            label147:
            return false;
            label152:
            bool = false;
          }
        }
        else
        {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
    return bool;
  }
  
  String getAction()
  {
    return this.mAction;
  }
  
  String getCategory()
  {
    return this.mCategory;
  }
  
  ContentValues getContentValues()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("category", this.mCategory);
    localContentValues.put("action", this.mAction);
    localContentValues.put("label", this.mLabel);
    localContentValues.put("value", Integer.valueOf(this.mValue));
    return localContentValues;
  }
  
  long getId()
  {
    return this.mId;
  }
  
  String getLabel()
  {
    return this.mLabel;
  }
  
  int getValue()
  {
    return this.mValue;
  }
  
  public int hashCode()
  {
    int i = 0;
    if (this.mAction != null) {
      j = this.mAction.hashCode();
    } else {
      j = 0;
    }
    int j = 31 * (j + 31);
    int k;
    if (this.mCategory != null) {
      k = this.mCategory.hashCode();
    } else {
      k = 0;
    }
    j = 31 * (j + k);
    if (this.mLabel != null) {
      i = this.mLabel.hashCode();
    }
    return 31 * (j + i) + this.mValue;
  }
  
  void incrementValue(int paramInt)
  {
    this.mValue = (paramInt + this.mValue);
  }
  
  void setId(long paramLong)
  {
    this.mId = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("C: ");
    localStringBuilder.append(this.mCategory);
    localStringBuilder.append(" A: ");
    localStringBuilder.append(this.mAction);
    localStringBuilder.append(" L: ");
    localStringBuilder.append(this.mLabel);
    localStringBuilder.append(" V: ");
    localStringBuilder.append(this.mValue);
    return localStringBuilder.toString();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.analytics.Hit
 * JD-Core Version:    0.7.0.1
 */