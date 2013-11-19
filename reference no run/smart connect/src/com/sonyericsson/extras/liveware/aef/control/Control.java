package com.sonyericsson.extras.liveware.aef.control;

public class Control
{
  public static abstract interface Intents
  {
    public static final int CONTROL_ACTION_OFF = 1;
    public static final int CONTROL_ACTION_ON = 0;
    public static final String CONTROL_CLEAR_DISPLAY_INTENT = "com.sonyericsson.extras.aef.control.CLEAR_DISPLAY";
    public static final String CONTROL_DISPLAY_DATA_INTENT = "com.sonyericsson.extras.aef.control.DISPLAY_DATA";
    public static final String CONTROL_ERROR_INTENT = "com.sonyericsson.extras.aef.control.ERROR";
    public static final String CONTROL_KEY_EVENT_INTENT = "com.sonyericsson.extras.aef.control.KEY_EVENT";
    public static final String CONTROL_LED_INTENT = "com.sonyericsson.extras.aef.control.LED";
    public static final String CONTROL_PAUSE_INTENT = "com.sonyericsson.extras.aef.control.PAUSE";
    public static final String CONTROL_RESUME_INTENT = "com.sonyericsson.extras.aef.control.RESUME";
    public static final String CONTROL_SET_SCREEN_STATE_INTENT = "com.sonyericsson.extras.aef.control.SET_SCREEN_STATE";
    public static final String CONTROL_START_INTENT = "com.sonyericsson.extras.aef.control.START";
    public static final String CONTROL_START_REQUEST_INTENT = "com.sonyericsson.extras.aef.control.START_REQUEST";
    public static final String CONTROL_STOP_INTENT = "com.sonyericsson.extras.aef.control.STOP";
    public static final String CONTROL_STOP_LED_INTENT = "com.sonyericsson.extras.aef.control.STOP_LED";
    public static final String CONTROL_STOP_REQUEST_INTENT = "com.sonyericsson.extras.aef.control.STOP_REQUEST";
    public static final String CONTROL_STOP_VIBRATE_INTENT = "com.sonyericsson.extras.aef.control.STOP_VIBRATE";
    public static final String CONTROL_SWIPE_EVENT_INTENT = "com.sonyericsson.extras.aef.control.SWIPE_EVENT";
    public static final String CONTROL_TOUCH_EVENT_INTENT = "com.sonyericsson.extras.aef.control.TOUCH_EVENT";
    public static final String CONTROL_VIBRATE_INTENT = "com.sonyericsson.extras.aef.control.VIBRATE";
    public static final String EXTRA_AEA_PACKAGE_NAME = "aea_package_name";
    public static final String EXTRA_AHA_PACKAGE_NAME = "aha_package_name";
    public static final String EXTRA_DATA = "data";
    public static final String EXTRA_DATA_URI = "data_uri";
    public static final String EXTRA_ERROR_CODE = "error_code";
    public static final String EXTRA_EXTENSION_KEY = "extension_key";
    public static final String EXTRA_KEY_ACTION = "event_type";
    public static final String EXTRA_KEY_CODE = "key_code";
    public static final String EXTRA_LED_COLOR = "led_color";
    public static final String EXTRA_LED_ID = "led_id";
    public static final String EXTRA_OFF_DURATION = "off_duration";
    public static final String EXTRA_ON_DURATION = "on_duration";
    public static final String EXTRA_REPEATS = "repeats";
    public static final String EXTRA_SCREEN_STATE = "screen_state";
    public static final String EXTRA_SWIPE_DIRECTION = "direction";
    public static final String EXTRA_TIMESTAMP = "timestamp";
    public static final String EXTRA_TOUCH_ACTION = "action";
    public static final String EXTRA_X_OFFSET = "x_offset";
    public static final String EXTRA_X_POS = "x_pos";
    public static final String EXTRA_Y_OFFSET = "y_offset";
    public static final String EXTRA_Y_POS = "y_pos";
    public static final int KEY_ACTION_PRESS = 0;
    public static final int KEY_ACTION_RELEASE = 1;
    public static final int KEY_ACTION_REPEAT = 2;
    public static final int REPEAT_UNTIL_STOP_INTENT = -1;
    public static final int SCREEN_STATE_AUTO = 3;
    public static final int SCREEN_STATE_DIM = 1;
    public static final int SCREEN_STATE_OFF = 0;
    public static final int SCREEN_STATE_ON = 2;
    public static final int SWIPE_DIRECTION_DOWN = 1;
    public static final int SWIPE_DIRECTION_LEFT = 2;
    public static final int SWIPE_DIRECTION_RIGHT = 3;
    public static final int SWIPE_DIRECTION_UP = 0;
    public static final int TOUCH_ACTION_LONGPRESS = 1;
    public static final int TOUCH_ACTION_PRESS = 0;
    public static final int TOUCH_ACTION_RELEASE = 2;
  }
  
  public static abstract interface KeyCodes
  {
    public static final int KEYCODE_ACTION = 4;
    public static final int KEYCODE_BACK = 7;
    public static final int KEYCODE_NEXT = 2;
    public static final int KEYCODE_PLAY = 1;
    public static final int KEYCODE_PREVIOUS = 3;
    public static final int KEYCODE_VOLUME_DOWN = 5;
    public static final int KEYCODE_VOLUME_UP = 6;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.control.Control
 * JD-Core Version:    0.7.0.1
 */