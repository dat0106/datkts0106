package com.sonymobile.smartconnect.internal;

import android.net.Uri;

public class SmartConnectAPI
{
  public static final int CONNECTION_TYPE_BT = 4;
  public static final int CONNECTION_TYPE_DMR = 2;
  public static final int CONNECTION_TYPE_DMS = 3;
  public static final int CONNECTION_TYPE_PS3 = 1;
  public static final int CONNECTION_TYPE_WFD = 5;
  public static final int DEVICE_CATEGORY_BDR = 20;
  public static final int DEVICE_CATEGORY_CAMERA = 4;
  public static final int DEVICE_CATEGORY_HEADPHONES = 6;
  public static final int DEVICE_CATEGORY_KEYBOARD = 9;
  public static final int DEVICE_CATEGORY_MOUSE = 8;
  public static final int DEVICE_CATEGORY_NAS = 2;
  public static final int DEVICE_CATEGORY_PC = 3;
  public static final int DEVICE_CATEGORY_PHONE = 18;
  public static final int DEVICE_CATEGORY_PHONE_HEADSET = 5;
  public static final int DEVICE_CATEGORY_PS3 = 19;
  public static final int DEVICE_CATEGORY_SPEAKER = 7;
  public static final int DEVICE_CATEGORY_TV = 1;
  public static final int DEVICE_CATEGORY_UNKNOWN = 10;
  public static final String DEVICE_CONFIGURED = "com.sonymobile.smartconnect.DEVICE_CONFIGURED";
  public static final String EXTRA_CONNECTION_TYPE = "com.sonymobile.smartconnect.EXTRA_CONNECTION_TYPE";
  public static final String EXTRA_DEVICE_CATEGORY = "com.sonymobile.smartconnect.EXTRA_DEVICE_CATEGORY";
  public static final String EXTRA_DEVICE_COOKIE = "com.sonymobile.smartconnect.EXTRA_DEVICE_COOKIE";
  public static final String EXTRA_DEVICE_DISPLAY_NAME = "com.sonymobile.smartconnect.EXTRA_DEVICE_DISPLAY_NAME";
  public static final String EXTRA_DEVICE_ICON_DATA = "com.sonymobile.smartconnect.EXTRA_DEVICE_ICON_DATA";
  public static final String EXTRA_DEVICE_IDENTIFY_NAME = "com.sonymobile.smartconnect.EXTRA_DEVICE_IDENTIFY_NAME";
  public static final String EXTRA_DEVICE_MANUFACTURER = "com.sonymobile.smartconnect.EXTRA_DEVICE_MANUFACTURER";
  public static final String EXTRA_DEVICE_SEARCH_ORIGIN = "com.sonymobile.smartconnect.EXTRA_DEVICE_SEARCH_ORIGIN";
  public static final String EXTRA_DEVICE_UNIQUE_ID = "com.sonymobile.smartconnect.EXTRA_DEVICE_UNIQUE_ID";
  public static final int MANUFACTURER_OTHER = 2;
  public static final int MANUFACTURER_SONY = 1;
  public static final int MANUFACTURER_UNKNOWN = 0;
  public static final String SEARCH_PAGE_ACTIVITY_NAME = "CCDeviceListActivity";
  public static final String SEARCH_PAGE_PACKAGE_NAME = "com.sonymobile.connectivitycenter";
  
  public static abstract interface SmartConnectDevices
  {
    public static final String AUTHORITY = "com.sonymobile.smartconnect.internal.device";
    public static final int CONFIGURED_EXPERIENCE_ALLOWED = 1;
    public static final int CONFIGURED_EXPERIENCE_NOT_ALLOWED = 2;
    public static final int DEVICES_MATCH = 10;
    public static final String DEVICES_PATH = "devices";
    public static final String DEVICE_CATEGORY_COLUMN = "device_category";
    public static final String DEVICE_CONFIGURED_COLUMN = "configured";
    public static final String DEVICE_CONNECTION_TYPE_COLUMN = "connection_type";
    public static final String DEVICE_COOKIE_COLUMN = "cookie";
    public static final String DEVICE_DISPLAY_NAME_COLUMN = "device_display_name";
    public static final String DEVICE_ICON_DATA_COLUMN = "device_icon_data";
    public static final String DEVICE_IDENTIFY_NAME_COLUMN = "device_identify_name";
    public static final String DEVICE_MANUFACTURER_COLUMN = "manufacturer";
    public static final String DEVICE_PAGE_ACTIVITY_COLUMN = "device_page_activity";
    public static final String DEVICE_UNIQUE_ID_COLUMN = "device_unique_id";
    public static final int LIGHT_THEME_ICONS = 20;
    public static final String LIGHT_THEME_ICONS_PATH = "light_theme";
    public static final Uri LIGHT_THEME_URI = Uri.withAppendedPath(Uri.parse("content://com.sonymobile.smartconnect.internal.device"), "light_theme");
    public static final String MIME_TYPE = "smart_connect_devices";
    public static final int NOT_CONFIGURED;
    public static final Uri URI = Uri.withAppendedPath(Uri.parse("content://com.sonymobile.smartconnect.internal.device"), "devices");
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonymobile.smartconnect.internal.SmartConnectAPI
 * JD-Core Version:    0.7.0.1
 */