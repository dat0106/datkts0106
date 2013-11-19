package com.sonyericsson.extras.liveware.aef.notification;

public final class NotificationInternal
{
  public static final String DATABASE_NAME = "notification.db";
  public static final int DATABASE_VERSION = 1;
  
  public static abstract interface Constants
  {
    public static final int ABUSE_INSERT_LIMIT = 4096;
    public static final String DIR_TYPE_BASE = "vnd.android.cursor.dir/";
    public static final int EVENTS_MATCH = 20;
    public static final int EVENT_MATCH = 25;
    public static final int EVENT_READ_STATUS_MATCH = 30;
    public static final String ITEM_TYPE_BASE = "vnd.android.cursor.item/";
    public static final int SOURCES_EVENTS_MATCH = 35;
    public static final int SOURCES_MATCH = 10;
    public static final int SOURCE_EVENT_MATCH = 40;
    public static final int SOURCE_MATCH = 15;
  }
  
  public static abstract interface Event
  {
    public static final int COUNT_LIMIT = 100;
    public static final String EVENT_SOURCE_ID_DELETE_FK = "event_source_id_delete_fk";
    public static final String EVENT_SOURCE_ID_INDEX_IDX = "event_source_id_idx";
    public static final String EVENT_SOURCE_ID_INSERT_FK = "event_source_id_insert_fk";
    public static final String EVENT_SOURCE_ID_UPDATE_FK = "event_source_id_update_fk";
    public static final String EVENT_TIDY_TRIGGER = "event_tidy_trigger";
    public static final String SINGLE_EVENT_PATH = "event/#";
  }
  
  public static class EventImpl
  {
    public static String[] eventProjection()
    {
      String[] arrayOfString = new String[13];
      arrayOfString[0] = "_id";
      arrayOfString[1] = "sourceId";
      arrayOfString[2] = "title";
      arrayOfString[3] = "publishedTime";
      arrayOfString[4] = "personal";
      arrayOfString[5] = "message";
      arrayOfString[6] = "imageUri";
      arrayOfString[7] = "geoData";
      arrayOfString[8] = "readStatus";
      arrayOfString[9] = "friend_key";
      arrayOfString[10] = "profile_image_uri";
      arrayOfString[11] = "display_name";
      arrayOfString[12] = "contacts_reference";
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
  
  public static abstract interface Source
  {
    public static final int COUNT_LIMIT = 8;
    public static final String SINGLE_SOURCE_PATH = "source/#";
    public static final String SOURCE_EVENT_ID_DELETE_FK = "source_event_id_delete_fk";
    public static final String SOURCE_LIMIT_TRIGGER = "source_limit_trigger";
  }
  
  public static abstract interface SourceEvent
  {
    public static final String SINGLE_SOURCE_EVENT_PATH = "source_event/#";
    public static final String SQL = "source INNER JOIN event ON source._id = sourceId";
  }
  
  public static class SourceEventImpl
  {
    public static String[] restrictedQueryColumns()
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "userId";
      return arrayOfString;
    }
    
    public static String[] sourceEventProjection()
    {
      String[] arrayOfString = new String[25];
      arrayOfString[0] = "name";
      arrayOfString[1] = "enabled";
      arrayOfString[2] = "iconUri1";
      arrayOfString[3] = "iconUri2";
      arrayOfString[4] = "iconUriBlackWhite";
      arrayOfString[5] = "action_1";
      arrayOfString[6] = "action_2";
      arrayOfString[7] = "action_3";
      arrayOfString[8] = "updateTime";
      arrayOfString[9] = "textToSpeech";
      arrayOfString[10] = "extension_specific_id";
      arrayOfString[11] = "packageName";
      arrayOfString[12] = "event._id AS eventId";
      arrayOfString[13] = "sourceId";
      arrayOfString[14] = "title";
      arrayOfString[15] = "publishedTime";
      arrayOfString[16] = "personal";
      arrayOfString[17] = "message";
      arrayOfString[18] = "imageUri";
      arrayOfString[19] = "geoData";
      arrayOfString[20] = "readStatus";
      arrayOfString[21] = "friend_key";
      arrayOfString[22] = "profile_image_uri";
      arrayOfString[23] = "display_name";
      arrayOfString[24] = "contacts_reference";
      return arrayOfString;
    }
  }
  
  public static class SourceImpl
  {
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
    
    public static String[] sourceProjection()
    {
      String[] arrayOfString = new String[13];
      arrayOfString[0] = "_id";
      arrayOfString[1] = "name";
      arrayOfString[2] = "enabled";
      arrayOfString[3] = "iconUri1";
      arrayOfString[4] = "iconUri2";
      arrayOfString[5] = "iconUriBlackWhite";
      arrayOfString[6] = "action_1";
      arrayOfString[7] = "action_2";
      arrayOfString[8] = "action_3";
      arrayOfString[9] = "updateTime";
      arrayOfString[10] = "textToSpeech";
      arrayOfString[11] = "extension_specific_id";
      arrayOfString[12] = "packageName";
      return arrayOfString;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.notification.NotificationInternal
 * JD-Core Version:    0.7.0.1
 */