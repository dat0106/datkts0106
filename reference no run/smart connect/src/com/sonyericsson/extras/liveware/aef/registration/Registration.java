package com.sonyericsson.extras.liveware.aef.registration;

import android.net.Uri;
import android.provider.BaseColumns;

public class Registration
{
  public static final String AUTHORITY = "com.sonyericsson.extras.liveware.aef.registration";
  protected static final Uri BASE_URI = Uri.parse("content://com.sonyericsson.extras.liveware.aef.registration");
  public static final String EXTENSION_PERMISSION = "com.sonyericsson.extras.liveware.aef.EXTENSION_PERMISSION";
  public static final String HOSTAPP_PERMISSION = "com.sonyericsson.extras.liveware.aef.HOSTAPP_PERMISSION";
  
  public static abstract interface AccessoryConnectionStatus
  {
    public static final int STATUS_CONNECTED = 1;
    public static final int STATUS_DISCONNECTED;
  }
  
  public static abstract interface ApiRegistration
  {
    public static final String EXTENSIONS_PATH = "registrations";
    public static final String MIME_TYPE = "aef-registration";
    public static final Uri URI = Uri.withAppendedPath(Registration.BASE_URI, "registrations");
  }
  
  public static abstract interface ApiRegistrationColumns
    extends BaseColumns
  {
    public static final String CONTROL_API_VERSION = "controlApiVersion";
    public static final String EXTENSION_ID = "extensionId";
    public static final String HOST_APPLICATION_PACKAGE = "hostAppPackageName";
    public static final String SENSOR_API_VERSION = "sensorApiVersion";
    public static final String WIDGET_API_VERSION = "widgetApiVersion";
  }
  
  public static abstract interface Capabilities
  {
    public static final String CAPABILITIES_MIME_TYPE = "aef-capabilities";
    public static final String CAPABILITIES_PATH = "capabilities";
    public static final Uri URI = Uri.withAppendedPath(Registration.BASE_URI, "capabilities");
  }
  
  public static abstract interface Device
  {
    public static final String DEVICES_PATH = "device";
    public static final String MIME_TYPE = "aef-device";
    public static final Uri URI = Uri.withAppendedPath(Registration.BASE_URI, "device");
  }
  
  public static abstract interface DeviceColumns
    extends BaseColumns
  {
    public static final String ACCESSORY_CONNECTED = "accessory_connected";
    public static final String FIRMWARE_VERSION = "firmwareVersion";
    public static final String HOST_APPLICATION_ID = "hostAppId";
    public static final String MARKETING_NAME = "marketingName";
    public static final String MODEL = "model";
    public static final String SUB_TYPE = "subType";
    public static final String TYPE = "type";
    public static final String UID = "uid";
    public static final String VENDOR = "vendor";
    public static final String VIBRATOR = "vibrator";
    public static final String WIDGET_IMAGE_HEIGHT = "widgetImageHeight";
    public static final String WIDGET_IMAGE_WIDTH = "widgetImageWidtht";
  }
  
  public static abstract interface Display
  {
    public static final String DISPLAYS_PATH = "display";
    public static final String MIME_TYPE = "aef-display";
    public static final Uri URI = Uri.withAppendedPath(Registration.BASE_URI, "display");
  }
  
  public static abstract interface DisplayColumns
    extends BaseColumns
  {
    public static final String COLORS = "colors";
    public static final String DEVICE_ID = "deviceId";
    public static final String DISPLAY_HEIGHT = "height";
    public static final String DISPLAY_WIDTH = "width";
    public static final String LATENCY = "latency";
    public static final String MOTION_TOUCH = "motionTouch";
    public static final String REFRESH_RATE = "refreshRate";
    public static final String TAP_TOUCH = "tapTouch";
  }
  
  public static abstract interface Extension
  {
    public static final String EXTENSIONS_PATH = "extensions";
    public static final String MIME_TYPE = "aef-extensions";
    public static final Uri URI = Uri.withAppendedPath(Registration.BASE_URI, "extensions");
  }
  
  public static abstract interface ExtensionColumns
    extends BaseColumns
  {
    public static final String CONFIGURATION_ACTIVITY = "configurationActivity";
    public static final String CONFIGURATION_TEXT = "configurationText";
    public static final String EXTENSION_ICON_URI = "extensionIconUri";
    public static final String EXTENSION_ICON_URI_BLACK_WHITE = "extensionIconUriBlackWhite";
    public static final String EXTENSION_KEY = "extension_key";
    public static final String HOST_APP_ICON_URI = "iconLargeUri";
    public static final String NAME = "name";
    public static final String NOTIFICATION_API_VERSION = "notificationApiVersion";
    public static final String PACKAGE_NAME = "packageName";
  }
  
  public static abstract interface HostApp
  {
    public static final String HOST_APP_PATH = "host_application";
    public static final String MIME_TYPE = "aef-host_application";
    public static final Uri URI = Uri.withAppendedPath(Registration.BASE_URI, "host_application");
  }
  
  public static abstract interface HostAppColumns
    extends BaseColumns
  {
    public static final String CONTROL_API_VERSION = "controlApiVersion";
    public static final String NOTIFICATION_API_VERSION = "notificationApiVersion";
    public static final String PACKAGE_NAME = "packageName";
    public static final String SENSOR_API_VERSION = "sensorApiVersion";
    public static final String VERSION = "version";
    public static final String WIDGET_API_VERSION = "widgetApiVersion";
    public static final String WIDGET_REFRESH_RATE = "widgetRefreshrate";
  }
  
  public static abstract interface Input
  {
    public static final String INPUTS_PATH = "input";
    public static final String MIME_TYPE = "aef-input";
    public static final Uri URI = Uri.withAppendedPath(Registration.BASE_URI, "input");
  }
  
  public static abstract interface InputColumns
    extends BaseColumns
  {
    public static final String DEVICE_ID = "deviceId";
    public static final String ENABLED = "enabled";
    public static final String KEY_PAD_ID = "keyPadId";
  }
  
  public static abstract interface Intents
  {
    public static final String ACCESSORY_CONNECTION_INTENT = "com.sonyericsson.extras.liveware.aef.registration.ACCESSORY_CONNECTION";
    public static final String EXTENSION_REGISTER_REQUEST_INTENT = "com.sonyericsson.extras.liveware.aef.registration.EXTENSION_REGISTER_REQUEST";
    public static final String EXTRA_ACCESSORY_SUPPORTS_ACTIONS = "supports_actions";
    public static final String EXTRA_ACCESSORY_SUPPORTS_HISTORY = "supports_history";
    public static final String EXTRA_AHA_PACKAGE_NAME = "aha_package_name";
    public static final String EXTRA_CONNECTION_STATUS = "connnection_status";
  }
  
  public static abstract interface KeyPad
  {
    public static final String KEYPADS_PATH = "keypad";
    public static final String MIME_TYPE = "aef-keypad";
    public static final Uri URI = Uri.withAppendedPath(Registration.BASE_URI, "keypad");
  }
  
  public static abstract interface KeyPadColumns
    extends BaseColumns
  {
    public static final String TYPE = "type";
  }
  
  public static abstract interface Led
  {
    public static final String LEDS_PATH = "led";
    public static final String MIME_TYPE = "aef-led";
    public static final Uri URI = Uri.withAppendedPath(Registration.BASE_URI, "led");
  }
  
  public static abstract interface LedColumns
    extends BaseColumns
  {
    public static final String COLORS = "colors";
    public static final String DEVICE_ID = "deviceId";
  }
  
  public static abstract interface Sensor
  {
    public static final String MIME_TYPE = "aef-sensor";
    public static final String SENSORS_PATH = "sensor";
    public static final Uri URI = Uri.withAppendedPath(Registration.BASE_URI, "sensor");
  }
  
  public static abstract interface SensorColumns
    extends BaseColumns
  {
    public static final String DEVICE_ID = "deviceId";
    public static final String MAXIMUM_RANGE = "maximumRange";
    public static final String MINIMUM_DELAY = "minimumDelay";
    public static final String NAME = "name";
    public static final String RESOLUTION = "resolution";
    public static final String SENSOR_ID = "sensorId";
    public static final String SENSOR_TYPE_ID = "sensorTypeId";
    public static final String SUPPORTS_SENSOR_INTERRUPT = "sensorInterrupt";
  }
  
  public static abstract interface SensorType
  {
    public static final String MIME_TYPE = "aef-sensor_type";
    public static final String SENSOR_TYPES_PATH = "sensor_type";
    public static final Uri URI = Uri.withAppendedPath(Registration.BASE_URI, "sensor_type");
  }
  
  public static abstract interface SensorTypeColumns
    extends BaseColumns
  {
    public static final String DELICATE_SENSOR_DATA = "delicate_data";
    public static final String TYPE = "type";
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.registration.Registration
 * JD-Core Version:    0.7.0.1
 */