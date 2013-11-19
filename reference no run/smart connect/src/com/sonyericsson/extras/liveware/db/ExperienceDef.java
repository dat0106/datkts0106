package com.sonyericsson.extras.liveware.db;

import android.net.Uri;
import android.provider.BaseColumns;

public final class ExperienceDef
{
  public static final String AUTHORITY = "com.sonyericsson.extras.liveware.asf.experience";
  protected static final Uri BASE_URI = Uri.parse("content://com.sonyericsson.extras.liveware.asf.experience");
  
  public static abstract interface ActionColumns
    extends BaseColumns
  {
    public static final String ACTIVITY_CLASS_NAME = "activity";
    public static final String CATEGORY = "category";
    public static final String CLASS_NAME = "class";
    public static final String DISABLED = "disabled";
    public static final String ICON_URI = "iconUri";
    public static final String NAME = "name";
    public static final String PACKAGE_NAME = "package";
    public static final String UUID = "UUID";
  }
  
  public static abstract interface ActionSetColumns
    extends BaseColumns
  {
    public static final String ACTION_ID = "actionId";
    public static final String ACTION_SET_TYPE = "actionSetType";
    public static final String EXPERIENCE_ID = "experienceId";
    public static final String FINALIZED = "finalized";
    public static final String POSITION = "position";
    public static final String RAW_SETTING = "rawSetting";
    public static final String SETTINGS_LABEL = "label";
    public static final String UUID = "UUID";
  }
  
  public static abstract interface ActionSetConstants
  {
    public static final int ACTION_SET_START_ACTIONS = 0;
    public static final int ACTION_SET_STOP_ACTIONS = 1;
    public static final int FINALIZED = 1;
    public static final int NOT_FINALIZED_PRECONFIG = 2;
    public static final int NOT_FINALIZED_USER;
  }
  
  public static abstract interface ActionSetTable
  {
    public static final String ACTION_SETS_PATH = "action_set";
    public static final String ACTION_SET_ACTION_ID_DELETE_FK = "action_set_action_id_delete_fk";
    public static final String ACTION_SET_ACTION_ID_INDEX_IDX = "action_set_action_id_index_idx";
    public static final String ACTION_SET_ACTION_ID_INSERT_FK = "action_set_action_id_insert_fk";
    public static final String ACTION_SET_ACTION_ID_UPDATE_FK = "action_set_action_id_update_fk";
    public static final String ACTION_SET_EXPERIENCE_ID_DELETE_FK = "action_set_experience_id_delete_fk";
    public static final String ACTION_SET_EXPERIENCE_ID_INDEX_IDX = "action_set_experience_id_index_idx";
    public static final String ACTION_SET_EXPERIENCE_ID_INSERT_FK = "action_set_experience_id_insert_fk";
    public static final String ACTION_SET_EXPERIENCE_ID_UPDATE_FK = "action_set_experience_id_update_fk";
    public static final String MIME_TYPE = "asf-action_set";
    public static final String SINGLE_ACTION_SETS_PATH = "action_set/#";
    public static final String TABLE_NAME = "action_set";
    public static final Uri URI = Uri.withAppendedPath(ExperienceDef.BASE_URI, "action_set");
  }
  
  public static abstract interface ActionTable
  {
    public static final String ACTION_PATH = "action";
    public static final String MIME_TYPE = "asf-action";
    public static final String NAME_IDX = "actions_name_index";
    public static final String SINGLE_ACTION_PATH = "action/#";
    public static final String TABLE_NAME = "action";
    public static final Uri URI = Uri.withAppendedPath(ExperienceDef.BASE_URI, "action");
  }
  
  public static abstract interface Constants
  {
    public static final int ACTION_MATCH = 30;
    public static final int ACTION_SET_MATCH = 50;
    public static final int ACTION_SET_SINGLE_MATCH = 150;
    public static final int ACTION_SINGLE_MATCH = 130;
    public static final String DATABASE_NAME = "experience.db";
    public static final int DATABASE_VERSION = 10;
    public static final int DEVICE_MATCH = 60;
    public static final int DEVICE_SINGLE_MATCH = 160;
    public static final String DIR_TYPE_BASE = "vnd.android.cursor.dir/";
    public static final int EXPERIENCE_MATCH = 40;
    public static final int EXPERIENCE_SINGLE_MATCH = 140;
    public static final int FEATURE_MATCH = 70;
    public static final int FEATURE_SINGLE_MATCH = 170;
    public static final String ITEM_TYPE_BASE = "vnd.android.cursor.item/";
    public static final int LOCATION_MATCH = 10;
    public static final int LOCATION_SINGLE_MATCH = 110;
    public static final int TIME_MATCH = 20;
    public static final int TIME_SINGLE_MATCH = 120;
  }
  
  public static abstract interface DeviceColumns
    extends BaseColumns
  {
    public static final String BEARER_TYPE = "bearer_type";
    public static final String CONFIGURED = "configured";
    public static final String CONNECTED = "connected";
    public static final String COOKIE = "cookie";
    public static final String DEVICE_KEY = "device_key";
    public static final String DEVICE_NAME = "device_name";
    public static final String DEVICE_PAGE_ACTIVITY = "device_page_activity";
    public static final String EDUCATION_LEVEL = "education_level";
    public static final String ICON_LARGE_NAME = "iconLargeName";
    public static final String ICON_NAME = "iconName";
    public static final String MANUFACTURER = "manufacturer";
    public static final String NOTIFY_EXTERNAL = "notify_external";
    public static final String PRODUCT_ID = "product_id";
    public static final String REMOVABLE = "removable";
    public static final String TIMESTAMP = "timestamp";
    public static final String TYPE = "type";
    public static final String USER_DEFINED_NAME_CHANGED = "user_defined_name_changed";
  }
  
  public static abstract interface DeviceConstants
  {
    public static final int BEARER_AUDIO = 7;
    public static final int BEARER_BT = 4;
    public static final int BEARER_DMR = 2;
    public static final int BEARER_DMS = 3;
    public static final int BEARER_HDMI = 9;
    public static final int BEARER_NFC = 10;
    public static final int BEARER_NOT_DEFINED = 0;
    public static final int BEARER_POWER = 8;
    public static final int BEARER_PS3 = 1;
    public static final int BEARER_USB = 6;
    public static final int BEARER_WFD = 5;
    public static final int CONFIGURED_EXPERIENCE_ALLOWED = 1;
    public static final int CONFIGURED_EXPERIENCE_NOT_ALLOWED = 2;
    public static final int EDUCATION_LEVEL_NONE = 0;
    public static final int EDUCATION_LEVEL_SETTINGS = 1;
    public static final int MANUFACTURER_OTHER = 2;
    public static final int MANUFACTURER_SONY = 1;
    public static final int NAME_CHANGED = 1;
    public static final int NAME_NOT_CHANGED = 0;
    public static final int NOTIFY_EXTRNAL = 1;
    public static final int NOT_CONFIGURED = 0;
    public static final int NOT_NOTIFY_EXTRNAL = 0;
    public static final int NOT_REMOVABLE = 1;
    public static final int REMOVABLE = 0;
    public static final int TYPE_AAS_DEVICE = 15;
    public static final int TYPE_AUDIO_DEVICE = 11;
    public static final int TYPE_BDR = 20;
    public static final int TYPE_CAMERA = 4;
    public static final int TYPE_CHARGER_DEVICE = 12;
    public static final int TYPE_DOCK_DEVICE = 14;
    public static final int TYPE_HEADPHONES = 6;
    public static final int TYPE_HEADSET_DEVICE = 5;
    public static final int TYPE_INPUT_DEVICE = 13;
    public static final int TYPE_KEYBOARD = 9;
    public static final int TYPE_MOUSE = 8;
    public static final int TYPE_NAS = 2;
    public static final int TYPE_NFC_KEY_TAG = 17;
    public static final int TYPE_NFC_LAUNCH_TAG = 16;
    public static final int TYPE_NOT_DEFINED = 0;
    public static final int TYPE_PC = 3;
    public static final int TYPE_PHONE = 18;
    public static final int TYPE_PS3 = 19;
    public static final int TYPE_SPEAKER = 7;
    public static final int TYPE_TV = 1;
    public static final int TYPE_UNKNOWN = 10;
  }
  
  public static abstract interface DeviceTable
  {
    public static final String DEVICES_PATH = "device";
    public static final String MIME_TYPE = "asf-device";
    public static final String SINGLE_DEVICES_PATH = "device/#";
    public static final String TABLE_NAME = "device";
    public static final Uri URI = Uri.withAppendedPath(ExperienceDef.BASE_URI, "device");
  }
  
  public static abstract interface ExperienceColumns
    extends BaseColumns
  {
    public static final String DEVICE_ID = "deviceId";
    public static final String ENABLED_STATE = "enabled_state";
    public static final String LOCATION_ID = "locationId";
    public static final String NAME = "name";
    public static final String NAME_CHANGED_BY_USER = "name_changed_by_user";
    public static final String NAME_RESOURCE = "name_resource";
    public static final String PICTURE_NAME = "pictureName";
    public static final String STARTED = "started";
    public static final String STOP_TIMESTAMP = "stop_timestamp";
    public static final String TIMESTAMP = "timestamp";
    public static final String TIME_ID = "timeId";
  }
  
  public static abstract interface ExperienceConstants
  {
    public static final int NAME_CHANGED = 1;
    public static final int NAME_NOT_CHANGED = 0;
    public static final int STATE_DISABLED = 0;
    public static final int STATE_ENABLED = 2;
    public static final int STATE_SETUP = 1;
  }
  
  public static abstract interface ExperienceTable
  {
    public static final String EXPERIENCE_DEVICE_ID_DELETE_FK = "experience_device_id_delete_fk";
    public static final String EXPERIENCE_DEVICE_ID_INDEX_IDX = "experience_device_id_index_idx";
    public static final String EXPERIENCE_DEVICE_ID_INSERT_FK = "experience_device_id_insert_fk";
    public static final String EXPERIENCE_DEVICE_ID_UPDATE_FK = "experience_device_id_update_fk";
    public static final String EXPERIENCE_LOCATION_ID_DELETE_FK = "experience_location_id_delete_fk";
    public static final String EXPERIENCE_LOCATION_ID_INDEX_IDX = "experience_location_id_index_idx";
    public static final String EXPERIENCE_LOCATION_ID_INSERT_FK = "experience_location_id_insert_fk";
    public static final String EXPERIENCE_LOCATION_ID_UPDATE_FK = "experience_location_id_update_fk";
    public static final String EXPERIENCE_PATH = "experience";
    public static final String EXPERIENCE_TIME_ID_DELETE_FK = "experience_time_id_delete_fk";
    public static final String EXPERIENCE_TIME_ID_INDEX_IDX = "experience_time_id_index_idx";
    public static final String EXPERIENCE_TIME_ID_INSERT_FK = "experience_time_id_insert_fk";
    public static final String EXPERIENCE_TIME_ID_UPDATE_FK = "experience_time_id_update_fk";
    public static final String MIME_TYPE = "asf-experience";
    public static final String SINGLE_EXPERIENCE_PATH = "experience/#";
    public static final String TABLE_NAME = "experience";
    public static final Uri URI = Uri.withAppendedPath(ExperienceDef.BASE_URI, "experience");
  }
  
  public static abstract interface FeatureColumns
    extends BaseColumns
  {
    public static final String APP_SELECTION = "app_selection";
    public static final String CLASS_NAME = "class_name";
    public static final String COMPANION_NAME = "companion_name";
    public static final String COMPANION_PKG = "companion_pkg";
    public static final String DEVICE_ID = "device_id";
    public static final String ENABLED = "enabled";
    public static final String INTENT = "intent";
    public static final String MODIFIED_BY_USER = "modified_by_user";
    public static final String PACKAGE_NAME = "package_name";
    public static final String TYPE = "type";
  }
  
  public static abstract interface FeatureConstants
  {
    public static final int APPSELECTION_MANDATORY = 2;
    public static final int APPSELECTION_NEVER = 0;
    public static final int APPSELECTION_OPTIONAL = 1;
    public static final int FEATURE_LIVEKEY = 2;
    public static final int FEATURE_MODIFIED = 1;
    public static final int FEATURE_NONE = 0;
    public static final int FEATURE_NOT_MODIFIED = 0;
    public static final int FEATURE_SMARTLAUNCH = 4;
    public static final int STATE_DISABLED = 0;
    public static final int STATE_ENABLED = 1;
    public static final int STATE_SETUP = 2;
  }
  
  public static abstract interface FeatureTable
  {
    public static final String FEATURES_PATH = "feature";
    public static final String MIME_TYPE = "asf-feature";
    public static final String SINGLE_FEATURES_PATH = "feature/#";
    public static final String TABLE_NAME = "feature";
    public static final Uri URI = Uri.withAppendedPath(ExperienceDef.BASE_URI, "feature");
  }
  
  public static abstract interface LocationTriggerColumns
    extends BaseColumns
  {
    public static final String DESCRIPTION = "description";
    public static final String MAC_ADDRESS = "mac_address";
    public static final String NAME = "name";
    public static final String SSID = "ssid";
    public static final String TRIGGER_STATUS = "trigger_status";
  }
  
  public static abstract interface LocationTriggerTable
  {
    public static final String LOCATION_PATH = "location";
    public static final String MIME_TYPE = "asf-location";
    public static final String NAME_IDX = "location_triggers_name_index";
    public static final String SINGLE_LOCATION_PATH = "location/#";
    public static final String TABLE_NAME = "location";
    public static final Uri URI = Uri.withAppendedPath(ExperienceDef.BASE_URI, "location");
  }
  
  public static abstract interface TimeTriggerColumns
    extends BaseColumns
  {
    public static final String END_TIME = "end_time";
    public static final String START_TIME = "start_time";
    public static final String TRIGGER_STATUS = "trigger_status";
    public static final String WEEK_DAYS = "weekdays";
  }
  
  public static abstract interface TimeTriggerTable
  {
    public static final String MIME_TYPE = "asf-time";
    public static final String SINGLE_TIME_PATH = "time/#";
    public static final String START_IDX = "time_triggers_start_index";
    public static final String TABLE_NAME = "time";
    public static final String TIME_PATH = "time";
    public static final Uri URI = Uri.withAppendedPath(ExperienceDef.BASE_URI, "time");
  }
  
  public static abstract interface TriggerConstants
  {
    public static final int TRIGGER_STATUS_OFF = 0;
    public static final int TRIGGER_STATUS_ON = 1;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.db.ExperienceDef
 * JD-Core Version:    0.7.0.1
 */