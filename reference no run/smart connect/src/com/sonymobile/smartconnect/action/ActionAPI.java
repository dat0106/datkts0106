package com.sonymobile.smartconnect.action;

public abstract interface ActionAPI
{
  public static final String CATEGORY_APPLICATIONS = "applications";
  public static final String CATEGORY_COMMUNICATION = "communication";
  public static final String CATEGORY_DISPLAY = "display";
  public static final String CATEGORY_MEDIA = "media";
  public static final String CATEGORY_NETWORK = "network";
  public static final String CATEGORY_OTHER = "other";
  public static final String CATEGORY_SOUND = "sound";
  public static final String CATEGORY_TEXT_TO_SPEECH = "text to speech";
  public static final String EXECUTE_ACTION = "com.sonymobile.smartconnect.action.EXECUTE_ACTION";
  public static final String EXECUTE_RESPONSE_ACTION = "com.sonymobile.smartconnect.action.EXECUTE_RESPONSE_ACTION";
  public static final int EXECUTE_TIME_OUT = 2000;
  public static final int EXECUTE_TIME_OUT_MAX = 10000;
  public static final String EXTRA_EXECUTION_RESULT = "execution_result";
  public static final String EXTRA_ID = "id";
  public static final String EXTRA_SETTING_LABEL = "setting_label";
  public static final String EXTRA_SETTING_RAW = "setting_raw";
  public static final String META_DATA_ACTIVITY = "activity";
  public static final String META_DATA_CATEGORY = "category";
  public static final int RESULT_LAST_ALLOW_VALUE = 2;
  public static final int RESULT_NOK = 1;
  public static final int RESULT_OK = 0;
  public static final int RESULT_PENDING = 2;
  public static final String SMART_CONNECT_ACTION_RESPONSE_SERVICE_COMPONENT = "com.sonyericsson.extras.liveware/.actions.ActionResultService";
  public static final String SMART_CONNECT_PACKAGE_NAME = "com.sonyericsson.extras.liveware";
  public static final String UPDATE_ACTION = "com.sonymobile.smartconnect.action.UPDATE_ACTION";
  public static final String UPDATE_RESPONSE_ACTION = "com.sonymobile.smartconnect.action.UPDATE_RESPONSE_ACTION";
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonymobile.smartconnect.action.ActionAPI
 * JD-Core Version:    0.7.0.1
 */