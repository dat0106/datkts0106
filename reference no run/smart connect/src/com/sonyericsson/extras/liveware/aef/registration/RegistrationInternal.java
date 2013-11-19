package com.sonyericsson.extras.liveware.aef.registration;

import android.net.Uri;
import android.provider.BaseColumns;

public final class RegistrationInternal
{
  public static final String CAPABILITIES_VIEW_NAME = "capabilities";
  public static final String DATABASE_NAME = "registration.db";
  public static final int DATABASE_VERSION = 2;
  
  public static abstract interface ApiRegistration
  {
    public static final String REGISTRATION_EXTENSION_HOSTAPP_INX = "registration_extension_hostapp_index";
    public static final String REGISTRATION_EXTENSION_HOSTAPP_UNQ = "registration_extension_hostapp_unique";
    public static final String REGISTRATION_EXTENSION_ID_DELETE_FK = "registration_extension_id_delete_fk";
    public static final String REGISTRATION_EXTENSION_ID_INSERT_FK = "registration_extension_id_insert_fk";
    public static final String REGISTRATION_EXTENSION_ID_UPDATE_FK = "registration_extension_id_update_fk";
    public static final String SINGLE_EXTENSION_PATH = "registrations/#";
    public static final String TABLE_NAME = "registration";
  }
  
  public static class ApiRegistrationImpl
  {
    public static String[] registrationProjection()
    {
      String[] arrayOfString = new String[6];
      arrayOfString[0] = "_id";
      arrayOfString[1] = "hostAppPackageName";
      arrayOfString[2] = "widgetApiVersion";
      arrayOfString[3] = "controlApiVersion";
      arrayOfString[4] = "sensorApiVersion";
      arrayOfString[5] = "extensionId";
      return arrayOfString;
    }
    
    public static String[] restrictedModifyColumns()
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "_id";
      return arrayOfString;
    }
    
    public static String[] restrictedQueryColumns()
    {
      return new String[0];
    }
  }
  
  public static abstract interface Constants
  {
    public static final int API_REGISTRATIONS_MATCH = 20;
    public static final int API_REGISTRATION_MATCH = 25;
    public static final int CAPABILITIES_MATCH = 110;
    public static final int CAPABILITIY_MATCH = 115;
    public static final int DEVICES_MATCH = 40;
    public static final int DEVICE_MATCH = 45;
    public static final String DIR_TYPE_BASE = "vnd.android.cursor.dir/";
    public static final int DISPLAYS_MATCH = 50;
    public static final int DISPLAY_MATCH = 55;
    public static final int EXTENSIONS_MATCH = 10;
    public static final int EXTENSION_MATCH = 15;
    public static final int HOST_APPS_MATCH = 30;
    public static final int HOST_APP_MATCH = 35;
    public static final int INPUTS_MATCH = 80;
    public static final int INPUT_MATCH = 85;
    public static final int KEYPADS_MATCH = 100;
    public static final int KEYPAD_MATCH = 105;
    public static final int LEDS_MATCH = 70;
    public static final int LED_MATCH = 75;
    public static final int PERMISSION_REQUESTS_MATCH = 130;
    public static final int PERMISSION_REQUEST_MATCH = 140;
    public static final int RAW_QUERY_MATCH = 120;
    public static final int SENSORS_MATCH = 60;
    public static final int SENSOR_MATCH = 65;
    public static final int SENSOR_TYPES_MATCH = 90;
    public static final int SENSOR_TYPE_MATCH = 95;
  }
  
  public static abstract interface Device
  {
    public static final String DEVICE_HOSTAPP_ID_DELETE_FK = "device_hostapp_id_delete_fk";
    public static final String DEVICE_HOSTAPP_ID_IDX = "device_hostapp_id_idx";
    public static final String DEVICE_HOSTAPP_ID_INSERT_FK = "device_hostapp_id_insert_fk";
    public static final String DEVICE_HOSTAPP_ID_UPDATE_FK = "device_hostapp_id_update_fk";
    public static final String SINGLE_DEVICE_PATH = "device/#";
    public static final String TABLE_NAME = "device";
  }
  
  public static class DeviceImpl
  {
    public static String[] deviceProjection()
    {
      String[] arrayOfString = new String[10];
      arrayOfString[0] = "model";
      arrayOfString[1] = "type";
      arrayOfString[2] = "subType";
      arrayOfString[3] = "marketingName";
      arrayOfString[4] = "vendor";
      arrayOfString[5] = "uid";
      arrayOfString[6] = "firmwareVersion";
      arrayOfString[7] = "widgetImageHeight";
      arrayOfString[8] = "widgetImageWidtht";
      arrayOfString[9] = "vendor";
      return arrayOfString;
    }
  }
  
  public static abstract interface Display
  {
    public static final String DISPLAY_DEVICE_ID_DELETE_FK = "display_device_delete_fk";
    public static final String DISPLAY_DEVICE_ID_IDX = "display_device_id_idx";
    public static final String DISPLAY_DEVICE_ID_INSERT_FK = "display_device_insert_fk";
    public static final String DISPLAY_DEVICE_ID_UPDATE_FK = "display_device_update_fk";
    public static final String SINGLE_DISPLAY_PATH = "display/#";
    public static final String TABLE_NAME = "display";
  }
  
  public static class DisplayImpl
  {
    public static String[] displayProjection()
    {
      String[] arrayOfString = new String[7];
      arrayOfString[0] = "width";
      arrayOfString[1] = "height";
      arrayOfString[2] = "colors";
      arrayOfString[3] = "refreshRate";
      arrayOfString[4] = "latency";
      arrayOfString[5] = "tapTouch";
      arrayOfString[6] = "motionTouch";
      return arrayOfString;
    }
  }
  
  public static abstract interface Extension
  {
    public static final String EXTENSION_REGISTRATION_ID_DELETE_FK = "extension_registration_id_delete_fk";
    public static final String SINGLE_EXTENSION_PATH = "extensions/#";
    public static final String TABLE_NAME = "extension";
  }
  
  public static class ExtensionImpl
  {
    public static String[] pluginProjection()
    {
      String[] arrayOfString = new String[9];
      arrayOfString[0] = "_id";
      arrayOfString[1] = "name";
      arrayOfString[2] = "configurationActivity";
      arrayOfString[3] = "configurationText";
      arrayOfString[4] = "iconLargeUri";
      arrayOfString[5] = "extensionIconUri";
      arrayOfString[6] = "extensionIconUriBlackWhite";
      arrayOfString[7] = "notificationApiVersion";
      arrayOfString[8] = "packageName";
      return arrayOfString;
    }
    
    public static String[] restrictedModifyColumns()
    {
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "userId";
      arrayOfString[1] = "_id";
      return arrayOfString;
    }
    
    public static String[] restrictedQueryColumns()
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "userId";
      return arrayOfString;
    }
  }
  
  public static abstract interface HostApp
  {
    public static final String SINGLE_HOST_APP_PATH = "host_application/#";
    public static final String TABLE_NAME = "host_application";
  }
  
  public static class HostAppImpl
  {
    public static String[] hostAppProjection()
    {
      String[] arrayOfString = new String[6];
      arrayOfString[0] = "version";
      arrayOfString[1] = "packageName";
      arrayOfString[2] = "widgetApiVersion";
      arrayOfString[3] = "controlApiVersion";
      arrayOfString[4] = "sensorApiVersion";
      arrayOfString[5] = "notificationApiVersion";
      return arrayOfString;
    }
  }
  
  public static abstract interface Input
  {
    public static final String INPUT_DEVICE_ID_DELETE_FK = "input_device_delete_fk";
    public static final String INPUT_DEVICE_ID_IDX = "input_device_id_idx";
    public static final String INPUT_DEVICE_ID_INSERT_FK = "input_device_insert_fk";
    public static final String INPUT_DEVICE_ID_UPDATE_FK = "input_device_update_fk";
    public static final String INPUT_KEYPAD_ID_IDX = "input_keypad_id_idx";
    public static final String INPUT_KEY_PAD_ID_DELETE_FK = "input_key_pad_delete_fk";
    public static final String INPUT_KEY_PAD_ID_INSERT_FK = "input_key_pad_insert_fk";
    public static final String INPUT_KEY_PAD_ID_UPDATE_FK = "input_key_pad_update_fk";
    public static final String SINGLE_INPUT_PATH = "input/#";
    public static final String TABLE_NAME = "input";
  }
  
  public static class InputImpl
  {
    public static String[] inputProjection()
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "enabled";
      return arrayOfString;
    }
  }
  
  public static abstract interface KeyPad
  {
    public static final String SINGLE_KEYPAD_PATH = "keypad/#";
    public static final String TABLE_NAME = "keypad";
  }
  
  public static abstract interface Led
  {
    public static final String LED_DEVICE_ID_DELETE_FK = "led_device_delete_fk";
    public static final String LED_DEVICE_ID_IDX = "led_device_id_idx";
    public static final String LED_DEVICE_ID_INSERT_FK = "led_device_insert_fk";
    public static final String LED_DEVICE_ID_UPDATE_FK = "led_device_update_fk";
    public static final String SINGLE_LED_PATH = "led/#";
    public static final String TABLE_NAME = "led";
  }
  
  public static class LedImpl
  {
    public static String[] ledProjection()
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "colors";
      return arrayOfString;
    }
  }
  
  public static abstract interface PermissionRequest
    extends BaseColumns
  {
    public static final String MIME_TYPE = "aef-permission_request";
    public static final String PACKAGE_NAME = "packageName";
    public static final String PERMISSION_GRANTED = "permissionGranted";
    public static final String PERMISSION_INTENT = "com.sonyericsson.extras.liveware.aef.registration.REQUEST_PERMISSION";
    public static final String PERMISSION_REQUESTED = "permissionRequested";
    public static final String PERMISSION_REQUEST_PATH = "permission_request";
    public static final String SINGLE_PERMISSION_REQUEST_PATH = "permission_request/#";
    public static final String TABLE_NAME = "permission_request";
    public static final Uri URI = Uri.withAppendedPath(Registration.BASE_URI, "permission_request");
  }
  
  public static abstract interface Sensor
  {
    public static final String SENSOR_DEVICE_ID_DELETE_FK = "sensor_device_delete_fk";
    public static final String SENSOR_DEVICE_ID_IDX = "sensor_device_id_idx";
    public static final String SENSOR_DEVICE_ID_INSERT_FK = "sensor_device_insert_fk";
    public static final String SENSOR_DEVICE_ID_UPDATE_FK = "sensor_device_update_fk";
    public static final String SENSOR_SENSOR_TYPE_ID_DELETE_FK = "sensor_sensor_type_delete_fk";
    public static final String SENSOR_SENSOR_TYPE_ID_IDX = "sensor_sensor_type_id_idx";
    public static final String SENSOR_SENSOR_TYPE_ID_INSERT_FK = "sensor_sensor_type_insert_fk";
    public static final String SENSOR_SENSOR_TYPE_ID_UPDATE_FK = "sensor_sensor_type_update_fk";
    public static final String SINGLE_SENSOR_PATH = "sensor/#";
    public static final String TABLE_NAME = "sensor";
  }
  
  public static class SensorImpl
  {
    public static String[] sensorProjection()
    {
      String[] arrayOfString = new String[5];
      arrayOfString[0] = "resolution";
      arrayOfString[1] = "minimumDelay";
      arrayOfString[2] = "maximumRange";
      arrayOfString[3] = "name";
      arrayOfString[4] = "sensorId";
      return arrayOfString;
    }
  }
  
  public static abstract interface SensorType
  {
    public static final String SINGLE_SENSOR_TYPE_PATH = "sensor_type/#";
    public static final String TABLE_NAME = "sensor_type";
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.registration.RegistrationInternal
 * JD-Core Version:    0.7.0.1
 */