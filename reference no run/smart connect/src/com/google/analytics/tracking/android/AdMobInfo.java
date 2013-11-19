package com.google.analytics.tracking.android;

import java.util.Map;
import java.util.Random;

class AdMobInfo
{
  private static final AdMobInfo INSTANCE = new AdMobInfo();
  private int mAdHitId;
  private Random mRandom = new Random();
  
  static AdMobInfo getInstance()
  {
    return INSTANCE;
  }
  
  int generateAdHitId()
  {
    this.mAdHitId = (1 + this.mRandom.nextInt(2147483646));
    return this.mAdHitId;
  }
  
  int getAdHitId()
  {
    return this.mAdHitId;
  }
  
  Map<String, String> getJoinIds()
  {
    return null;
  }
  
  void setAdHitId(int paramInt)
  {
    this.mAdHitId = paramInt;
  }
  
  static enum AdMobKey
  {
    private String mBowParameter;
    
    static
    {
      AdMobKey[] arrayOfAdMobKey = new AdMobKey[4];
      arrayOfAdMobKey[0] = CLIENT_ID_KEY;
      arrayOfAdMobKey[1] = HIT_ID_KEY;
      arrayOfAdMobKey[2] = PROPERTY_ID_KEY;
      arrayOfAdMobKey[3] = VISITOR_ID_KEY;
      $VALUES = arrayOfAdMobKey;
    }
    
    private AdMobKey(String paramString)
    {
      this.mBowParameter = paramString;
    }
    
    String getBowParameter()
    {
      return this.mBowParameter;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.AdMobInfo
 * JD-Core Version:    0.7.0.1
 */