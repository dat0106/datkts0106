package com.google.analytics.tracking.android;

class Hit
{
  private final long mHitId;
  private String mHitString;
  private final long mHitTime;
  private String mHitUrl;
  
  Hit(String paramString, long paramLong1, long paramLong2)
  {
    this.mHitString = paramString;
    this.mHitId = paramLong1;
    this.mHitTime = paramLong2;
  }
  
  long getHitId()
  {
    return this.mHitId;
  }
  
  String getHitParams()
  {
    return this.mHitString;
  }
  
  long getHitTime()
  {
    return this.mHitTime;
  }
  
  String getHitUrl()
  {
    return this.mHitUrl;
  }
  
  void setHitString(String paramString)
  {
    this.mHitString = paramString;
  }
  
  void setHitUrl(String paramString)
  {
    this.mHitUrl = paramString;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Hit
 * JD-Core Version:    0.7.0.1
 */