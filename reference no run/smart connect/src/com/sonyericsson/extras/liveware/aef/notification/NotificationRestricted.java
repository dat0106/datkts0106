package com.sonyericsson.extras.liveware.aef.notification;

public class NotificationRestricted
  extends Notification
{
  public static abstract interface EventColumns
  {
    public static final String PLUGIN_ID = "plugin_id";
    public static final String UID_NAME = "userId";
  }
  
  public static abstract interface SourceColumns
  {
    public static final String EXTENSION_ID = "extension_id";
    public static final String UID_NAME = "userId";
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.notification.NotificationRestricted
 * JD-Core Version:    0.7.0.1
 */