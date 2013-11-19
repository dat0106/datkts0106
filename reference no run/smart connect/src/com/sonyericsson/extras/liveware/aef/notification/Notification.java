package com.sonyericsson.extras.liveware.aef.notification;

import android.net.Uri;
import android.provider.BaseColumns;

public class Notification
{
  public static final String AUTHORITY = "com.sonyericsson.extras.liveware.aef.notification";
  protected static final Uri BASE_URI = Uri.parse("content://com.sonyericsson.extras.liveware.aef.notification");
  
  public static abstract interface Event
  {
    public static final String EVENTS_PATH = "event";
    public static final String EVENT_READ_STATUS_PATH = "read_status";
    public static final String MIME_TYPE = "aef-event";
    public static final Uri READ_STATUS_URI = Uri.withAppendedPath(Notification.BASE_URI, "read_status");
    public static final String TABLE_NAME = "event";
    public static final Uri URI = Uri.withAppendedPath(Notification.BASE_URI, "event");
  }
  
  public static abstract interface EventColumns
    extends BaseColumns
  {
    public static final String CONTACTS_REFERENCE = "contacts_reference";
    public static final String DISPLAY_NAME = "display_name";
    public static final String EVENT_READ_STATUS = "readStatus";
    public static final String FRIEND_KEY = "friend_key";
    public static final String GEO_DATA = "geoData";
    public static final String IMAGE_URI = "imageUri";
    public static final String MESSAGE = "message";
    public static final String PERSONAL = "personal";
    public static final String PROFILE_IMAGE_URI = "profile_image_uri";
    public static final String PUBLISHED_TIME = "publishedTime";
    public static final String SOURCE_ID = "sourceId";
    public static final String TIME_STAMP = "timeStamp";
    public static final String TITLE = "title";
  }
  
  public static abstract interface Intents
  {
    public static final String EXTENSION_ACTION_1 = "action_1";
    public static final String EXTENSION_ACTION_2 = "action_2";
    public static final String EXTENSION_ACTION_3 = "action_3";
    public static final String EXTRA_ACTION = "action";
    public static final String EXTRA_AHA_PACKAGE_NAME = "aha_package_name";
    public static final String EXTRA_EVENT_ID = "event_id";
    public static final String EXTRA_EXTENSION_KEY = "extension_key";
    public static final String EXTRA_SOURCE_ID = "source_id";
    public static final String REFRESH_REQUEST_INTENT = "com.sonyericsson.extras.liveware.aef.notification.REFRESH_REQUEST";
    public static final String VIEW_EVENT_INTENT = "com.sonyericsson.extras.liveware.aef.notification.VIEW_EVENT_DETAIL";
  }
  
  public static abstract interface Source
  {
    public static final String MIME_TYPE = "aef-source";
    public static final String SOURCES_PATH = "source";
    public static final String TABLE_NAME = "source";
    public static final Uri URI = Uri.withAppendedPath(Notification.BASE_URI, "source");
  }
  
  public static abstract interface SourceColumns
    extends BaseColumns
  {
    public static final String ACTION_1 = "action_1";
    public static final String ACTION_2 = "action_2";
    public static final String ACTION_3 = "action_3";
    public static final String ENABLED = "enabled";
    public static final String EXTENSION_SPECIFIC_ID = "extension_specific_id";
    public static final String ICON_URI_1 = "iconUri1";
    public static final String ICON_URI_2 = "iconUri2";
    public static final String ICON_URI_BLACK_WHITE = "iconUriBlackWhite";
    public static final String NAME = "name";
    public static final String PACKAGE_NAME = "packageName";
    public static final String TEXT_TO_SPEECH = "textToSpeech";
    public static final String UPDATE_TIME = "updateTime";
  }
  
  public static abstract interface SourceEvent
  {
    public static final String MIME_TYPE = "aef-source-event";
    public static final String SOURCES_EVENTS_PATH = "source_event";
    public static final Uri URI = Uri.withAppendedPath(Notification.BASE_URI, "source_event");
  }
  
  public static abstract interface SourceEventColumns
    extends Notification.SourceColumns, Notification.EventColumns
  {
    public static final String EVENT_ID = "eventId";
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.notification.Notification
 * JD-Core Version:    0.7.0.1
 */