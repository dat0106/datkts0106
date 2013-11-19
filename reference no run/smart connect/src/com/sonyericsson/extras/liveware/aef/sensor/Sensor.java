package com.sonyericsson.extras.liveware.aef.sensor;

public class Sensor
{
  public static final String SENSOR_TYPE_ACCELEROMETER = "Accelerometer";
  public static final String SENSOR_TYPE_LIGHT = "Light";
  
  public static abstract interface Intents
  {
    public static final String EXTRA_AEA_PACKAGE_NAME = "aea_package_name";
    public static final String EXTRA_ERROR_CODE = "error_code";
    public static final String EXTRA_SENSOR_ID = "sensor_id";
    public static final String EXTRA_SENSOR_INTERRUPT_MODE = "interrupt_mode";
    public static final String EXTRA_SENSOR_LOCAL_SERVER_SOCKET_NAME = "local_server_socket_name";
    public static final String EXTRA_SENSOR_REQUESTED_RATE = "requested_rate";
    public static final String SENSOR_ERROR_MESSAGE_INTENT = "com.sonyericsson.extras.aef.sensor.ERROR_MESSSAGE";
    public static final String SENSOR_REGISTER_LISTENER_INTENT = "com.sonyericsson.extras.aef.sensor.REGISTER_LISTENER";
    public static final String SENSOR_UNREGISTER_LISTENER_INTENT = "com.sonyericsson.extras.aef.sensor.UNREGISTER_LISTENER";
  }
  
  public static abstract interface SensorAccuracy
  {
    public static final int SENSOR_STATUS_ACCURACY_HIGH = 3;
    public static final int SENSOR_STATUS_ACCURACY_LOW = 1;
    public static final int SENSOR_STATUS_ACCURACY_MEDIUM = 2;
    public static final int SENSOR_STATUS_UNRELIABLE;
  }
  
  public static abstract interface SensorApiErrorCodes
  {
    public static final int SENSOR_ERROR_CODE_NOT_ALLOWED;
  }
  
  public static abstract interface SensorInterruptMode
  {
    public static final int SENSOR_INTERRUPT_DISABLED = 0;
    public static final int SENSOR_INTERRUPT_ENABLED = 1;
  }
  
  public static abstract interface SensorRates
  {
    public static final int SENSOR_DELAY_FASTEST = 1;
    public static final int SENSOR_DELAY_GAME = 2;
    public static final int SENSOR_DELAY_NORMAL = 3;
    public static final int SENSOR_DELAY_UI = 4;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.sensor.Sensor
 * JD-Core Version:    0.7.0.1
 */