package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.SortedSet;
import java.util.TreeSet;

class GAUsage
{
  private static final String BASE_64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
  private static final GAUsage INSTANCE = new GAUsage();
  private boolean mDisableUsage = false;
  private StringBuilder mSequence = new StringBuilder();
  private SortedSet<Field> mUsedFields = new TreeSet();
  
  public static GAUsage getInstance()
  {
    return INSTANCE;
  }
  
  @VisibleForTesting
  static GAUsage getPrivateInstance()
  {
    return new GAUsage();
  }
  
  /**
   * @deprecated
   */
  public String getAndClearSequence()
  {
    try
    {
      if (this.mSequence.length() > 0) {
        this.mSequence.insert(0, ".");
      }
      String str = this.mSequence.toString();
      this.mSequence = new StringBuilder();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public String getAndClearUsage()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      int i = 0;
      int k = 6;
      while (this.mUsedFields.size() > 0)
      {
        Field localField = (Field)this.mUsedFields.first();
        this.mUsedFields.remove(localField);
        int j = localField.ordinal();
        while (j >= k)
        {
          ((StringBuilder)localObject1).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i));
          i = 0;
          k += 6;
        }
        i += (1 << localField.ordinal() % 6);
      }
      if ((i > 0) || (((StringBuilder)localObject1).length() == 0)) {
        ((StringBuilder)localObject1).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i));
      }
      this.mUsedFields.clear();
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /**
   * @deprecated
   */
  public void setDisableUsage(boolean paramBoolean)
  {
    try
    {
      this.mDisableUsage = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void setUsage(Field paramField)
  {
    try
    {
      if (!this.mDisableUsage)
      {
        this.mUsedFields.add(paramField);
        this.mSequence.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(paramField.ordinal()));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static enum Field
  {
    static
    {
      TRACK_EVENT = new Field("TRACK_EVENT", 2);
      TRACK_TRANSACTION = new Field("TRACK_TRANSACTION", 3);
      TRACK_EXCEPTION_WITH_DESCRIPTION = new Field("TRACK_EXCEPTION_WITH_DESCRIPTION", 4);
      TRACK_EXCEPTION_WITH_THROWABLE = new Field("TRACK_EXCEPTION_WITH_THROWABLE", 5);
      BLANK_06 = new Field("BLANK_06", 6);
      TRACK_TIMING = new Field("TRACK_TIMING", 7);
      TRACK_SOCIAL = new Field("TRACK_SOCIAL", 8);
      GET = new Field("GET", 9);
      SET = new Field("SET", 10);
      SEND = new Field("SEND", 11);
      SET_START_SESSION = new Field("SET_START_SESSION", 12);
      BLANK_13 = new Field("BLANK_13", 13);
      SET_APP_NAME = new Field("SET_APP_NAME", 14);
      BLANK_15 = new Field("BLANK_15", 15);
      SET_APP_VERSION = new Field("SET_APP_VERSION", 16);
      BLANK_17 = new Field("BLANK_17", 17);
      SET_APP_SCREEN = new Field("SET_APP_SCREEN", 18);
      GET_TRACKING_ID = new Field("GET_TRACKING_ID", 19);
      SET_ANONYMIZE_IP = new Field("SET_ANONYMIZE_IP", 20);
      GET_ANONYMIZE_IP = new Field("GET_ANONYMIZE_IP", 21);
      SET_SAMPLE_RATE = new Field("SET_SAMPLE_RATE", 22);
      GET_SAMPLE_RATE = new Field("GET_SAMPLE_RATE", 23);
      SET_USE_SECURE = new Field("SET_USE_SECURE", 24);
      GET_USE_SECURE = new Field("GET_USE_SECURE", 25);
      SET_REFERRER = new Field("SET_REFERRER", 26);
      SET_CAMPAIGN = new Field("SET_CAMPAIGN", 27);
      SET_APP_ID = new Field("SET_APP_ID", 28);
      GET_APP_ID = new Field("GET_APP_ID", 29);
      SET_EXCEPTION_PARSER = new Field("SET_EXCEPTION_PARSER", 30);
      GET_EXCEPTION_PARSER = new Field("GET_EXCEPTION_PARSER", 31);
      CONSTRUCT_TRANSACTION = new Field("CONSTRUCT_TRANSACTION", 32);
      CONSTRUCT_EXCEPTION = new Field("CONSTRUCT_EXCEPTION", 33);
      CONSTRUCT_RAW_EXCEPTION = new Field("CONSTRUCT_RAW_EXCEPTION", 34);
      CONSTRUCT_TIMING = new Field("CONSTRUCT_TIMING", 35);
      CONSTRUCT_SOCIAL = new Field("CONSTRUCT_SOCIAL", 36);
      SET_DEBUG = new Field("SET_DEBUG", 37);
      GET_DEBUG = new Field("GET_DEBUG", 38);
      GET_TRACKER = new Field("GET_TRACKER", 39);
      GET_DEFAULT_TRACKER = new Field("GET_DEFAULT_TRACKER", 40);
      SET_DEFAULT_TRACKER = new Field("SET_DEFAULT_TRACKER", 41);
      SET_APP_OPT_OUT = new Field("SET_APP_OPT_OUT", 42);
      REQUEST_APP_OPT_OUT = new Field("REQUEST_APP_OPT_OUT", 43);
      DISPATCH = new Field("DISPATCH", 44);
      SET_DISPATCH_PERIOD = new Field("SET_DISPATCH_PERIOD", 45);
      BLANK_48 = new Field("BLANK_48", 46);
      REPORT_UNCAUGHT_EXCEPTIONS = new Field("REPORT_UNCAUGHT_EXCEPTIONS", 47);
      SET_AUTO_ACTIVITY_TRACKING = new Field("SET_AUTO_ACTIVITY_TRACKING", 48);
      SET_SESSION_TIMEOUT = new Field("SET_SESSION_TIMEOUT", 49);
      CONSTRUCT_EVENT = new Field("CONSTRUCT_EVENT", 50);
      CONSTRUCT_ITEM = new Field("CONSTRUCT_ITEM", 51);
      SET_APP_INSTALLER_ID = new Field("SET_APP_INSTALLER_ID", 52);
      GET_APP_INSTALLER_ID = new Field("GET_APP_INSTALLER_ID", 53);
      Field[] arrayOfField = new Field[54];
      arrayOfField[0] = TRACK_VIEW;
      arrayOfField[1] = TRACK_VIEW_WITH_APPSCREEN;
      arrayOfField[2] = TRACK_EVENT;
      arrayOfField[3] = TRACK_TRANSACTION;
      arrayOfField[4] = TRACK_EXCEPTION_WITH_DESCRIPTION;
      arrayOfField[5] = TRACK_EXCEPTION_WITH_THROWABLE;
      arrayOfField[6] = BLANK_06;
      arrayOfField[7] = TRACK_TIMING;
      arrayOfField[8] = TRACK_SOCIAL;
      arrayOfField[9] = GET;
      arrayOfField[10] = SET;
      arrayOfField[11] = SEND;
      arrayOfField[12] = SET_START_SESSION;
      arrayOfField[13] = BLANK_13;
      arrayOfField[14] = SET_APP_NAME;
      arrayOfField[15] = BLANK_15;
      arrayOfField[16] = SET_APP_VERSION;
      arrayOfField[17] = BLANK_17;
      arrayOfField[18] = SET_APP_SCREEN;
      arrayOfField[19] = GET_TRACKING_ID;
      arrayOfField[20] = SET_ANONYMIZE_IP;
      arrayOfField[21] = GET_ANONYMIZE_IP;
      arrayOfField[22] = SET_SAMPLE_RATE;
      arrayOfField[23] = GET_SAMPLE_RATE;
      arrayOfField[24] = SET_USE_SECURE;
      arrayOfField[25] = GET_USE_SECURE;
      arrayOfField[26] = SET_REFERRER;
      arrayOfField[27] = SET_CAMPAIGN;
      arrayOfField[28] = SET_APP_ID;
      arrayOfField[29] = GET_APP_ID;
      arrayOfField[30] = SET_EXCEPTION_PARSER;
      arrayOfField[31] = GET_EXCEPTION_PARSER;
      arrayOfField[32] = CONSTRUCT_TRANSACTION;
      arrayOfField[33] = CONSTRUCT_EXCEPTION;
      arrayOfField[34] = CONSTRUCT_RAW_EXCEPTION;
      arrayOfField[35] = CONSTRUCT_TIMING;
      arrayOfField[36] = CONSTRUCT_SOCIAL;
      arrayOfField[37] = SET_DEBUG;
      arrayOfField[38] = GET_DEBUG;
      arrayOfField[39] = GET_TRACKER;
      arrayOfField[40] = GET_DEFAULT_TRACKER;
      arrayOfField[41] = SET_DEFAULT_TRACKER;
      arrayOfField[42] = SET_APP_OPT_OUT;
      arrayOfField[43] = REQUEST_APP_OPT_OUT;
      arrayOfField[44] = DISPATCH;
      arrayOfField[45] = SET_DISPATCH_PERIOD;
      arrayOfField[46] = BLANK_48;
      arrayOfField[47] = REPORT_UNCAUGHT_EXCEPTIONS;
      arrayOfField[48] = SET_AUTO_ACTIVITY_TRACKING;
      arrayOfField[49] = SET_SESSION_TIMEOUT;
      arrayOfField[50] = CONSTRUCT_EVENT;
      arrayOfField[51] = CONSTRUCT_ITEM;
      arrayOfField[52] = SET_APP_INSTALLER_ID;
      arrayOfField[53] = GET_APP_INSTALLER_ID;
      $VALUES = arrayOfField;
    }
    
    private Field() {}
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.GAUsage
 * JD-Core Version:    0.7.0.1
 */