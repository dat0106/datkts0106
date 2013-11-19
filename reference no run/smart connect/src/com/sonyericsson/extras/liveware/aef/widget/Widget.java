package com.sonyericsson.extras.liveware.aef.widget;

public class Widget
{
  public static abstract interface Intents
  {
    public static final int EVENT_TYPE_LONG_TAP = 1;
    public static final int EVENT_TYPE_SHORT_TAP = 0;
    public static final String EXTRA_AEA_PACKAGE_NAME = "aea_package_name";
    public static final String EXTRA_AHA_PACKAGE_NAME = "aha_package_name";
    public static final String EXTRA_EVENT_TYPE = "widget_event_type";
    public static final String EXTRA_EVENT_X_POS = "widget_event_x_pos";
    public static final String EXTRA_EVENT_Y_POS = "widget_event_y_pos";
    public static final String EXTRA_EXTENSION_KEY = "extension_key";
    public static final String EXTRA_WIDGET_IMAGE_DATA = "widget_image_data";
    public static final String EXTRA_WIDGET_IMAGE_URI = "widget_image_uri";
    public static final String WIDGET_ENTER_NEXT_LEVEL_INTENT = "com.sonyericsson.extras.aef.widget.ENTER_NEW_LEVEL";
    public static final String WIDGET_IMAGE_UPDATE_INTENT = "com.sonyericsson.extras.aef.widget.IMAGE_UPDATE";
    public static final String WIDGET_ONTOUCH_INTENT = "com.sonyericsson.extras.aef.widget.ONTOUCH";
    public static final String WIDGET_START_REFRESH_IMAGE_INTENT = "com.sonyericsson.extras.aef.widget.START_REFRESH_IMAGE_REQUEST";
    public static final String WIDGET_STOP_REFRESH_IMAGE_INTENT = "com.sonyericsson.extras.aef.widget.STOP_REFRESH_IMAGE_REQUEST";
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.widget.Widget
 * JD-Core Version:    0.7.0.1
 */