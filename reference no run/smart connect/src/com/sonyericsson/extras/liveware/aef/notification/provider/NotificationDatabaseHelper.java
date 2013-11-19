package com.sonyericsson.extras.liveware.aef.notification.provider;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class NotificationDatabaseHelper
  extends SQLiteOpenHelper
{
  static final String DELETE_EVENTS_FOR_USER = "DELETE FROM event WHERE userId =? ";
  static final String DELETE_SOURCE_FOR_USER = "DELETE FROM source WHERE userId =? ";
  static final String EVENT_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS event_source_id_delete_fk BEFORE DELETE ON source FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table source violates foreign key constraint sourceId') WHERE  (SELECT sourceId FROM event WHERE sourceId = OLD._id) IS NOT NULL; END;";
  static final String EVENT_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS event_source_id_insert_fk BEFORE INSERT ON event FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table event violates foreign key constraint sourceId') WHERE  (SELECT _id FROM source WHERE _id = NEW.sourceId) IS NULL; END;";
  static final String EVENT_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS event_source_id_update_fk BEFORE UPDATE ON event FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table event violates foreign key constraint sourceId') WHERE  (SELECT _id FROM source WHERE _id = NEW.sourceId) IS NULL; END;";
  static final String EVENT_SOURCE_ID_INDEX_SQL = "CREATE INDEX IF NOT EXISTS event_source_id_idx ON event(sourceId);";
  static final String EVENT_SQL = "CREATE TABLE IF NOT EXISTS event (_id INTEGER PRIMARY KEY AUTOINCREMENT, sourceId INTEGER NOT NULL, message TEXT, imageUri TEXT, publishedTime UNSIGNED BIG INT NOT NULL, title TEXT, personal SHORT INTEGER NOT NULL, geoData TEXT, readStatus SHORT INTEGER NOT NULL DEFAULT 0, userId TEXT NOT NULL, timeStamp UNSIGNED BIG INT DEFAULT CURRENT_TIMESTAMP, display_name TEXT, profile_image_uri TEXT, contacts_reference TEXT, friend_key TEXT, CHECK (readStatus IN (0,1)), FOREIGN KEY(sourceId) REFERENCES source(_id))";
  static final String EVENT_TIDY_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS event_tidy_trigger AFTER INSERT ON event BEGIN DELETE FROM event WHERE _id IN (SELECT _id FROM event WHERE sourceId=NEW.sourceId ORDER BY publishedTime DESC , _id DESC LIMIT -1 OFFSET 100);END;";
  static final String SOURCE_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS source_event_id_delete_fk BEFORE DELETE ON source FOR EACH ROW BEGIN DELETE FROM event WHERE sourceId = OLD._id; END;";
  static final String SOURCE_LIMIT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS source_limit_trigger BEFORE INSERT ON source WHEN EXISTS (select cnt from (SELECT COUNT(*) as cnt from source where packageName = NEW.packageName) where cnt >= 8) BEGIN select RAISE(FAIL,'Maximum number of source allowed for a plugin is 8'); END";
  static final String SOURCE_SQL = "CREATE TABLE IF NOT EXISTS source (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, iconUri1 TEXT, iconUri2 TEXT, iconUriBlackWhite TEXT, enabled SHORT INTEGER NOT NULL DEFAULT 0, action_1 TEXT, action_2 TEXT, action_3 TEXT, updateTime UNSIGNED BIG INT, userId TEXT NOT NULL, textToSpeech TEXT, extension_specific_id TEXT, packageName TEXT NOT NULL, CHECK (enabled IN (0,1)))";
  
  public NotificationDatabaseHelper(Context paramContext)
  {
    super(paramContext, "notification.db", null, 1);
  }
  
  private void dropAllDatabaseObjects(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS event_source_id_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS event_source_id_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS event_source_id_delete_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS event_tidy_trigger");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS source_event_id_delete_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS source_limit_trigger");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS event_source_id_idx");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS event");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS source");
  }
  
  public void deleteAllForExtensions(String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    new NotificationPermission().restrictedDelete(null, null, paramArrayOfString, "packageName", "source", localSQLiteDatabase);
    if (localSQLiteDatabase.isOpen()) {
      localSQLiteDatabase.close();
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS source (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, iconUri1 TEXT, iconUri2 TEXT, iconUriBlackWhite TEXT, enabled SHORT INTEGER NOT NULL DEFAULT 0, action_1 TEXT, action_2 TEXT, action_3 TEXT, updateTime UNSIGNED BIG INT, userId TEXT NOT NULL, textToSpeech TEXT, extension_specific_id TEXT, packageName TEXT NOT NULL, CHECK (enabled IN (0,1)))");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS event (_id INTEGER PRIMARY KEY AUTOINCREMENT, sourceId INTEGER NOT NULL, message TEXT, imageUri TEXT, publishedTime UNSIGNED BIG INT NOT NULL, title TEXT, personal SHORT INTEGER NOT NULL, geoData TEXT, readStatus SHORT INTEGER NOT NULL DEFAULT 0, userId TEXT NOT NULL, timeStamp UNSIGNED BIG INT DEFAULT CURRENT_TIMESTAMP, display_name TEXT, profile_image_uri TEXT, contacts_reference TEXT, friend_key TEXT, CHECK (readStatus IN (0,1)), FOREIGN KEY(sourceId) REFERENCES source(_id))");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS event_source_id_idx ON event(sourceId);");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS event_source_id_insert_fk BEFORE INSERT ON event FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table event violates foreign key constraint sourceId') WHERE  (SELECT _id FROM source WHERE _id = NEW.sourceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS event_source_id_update_fk BEFORE UPDATE ON event FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table event violates foreign key constraint sourceId') WHERE  (SELECT _id FROM source WHERE _id = NEW.sourceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS source_event_id_delete_fk BEFORE DELETE ON source FOR EACH ROW BEGIN DELETE FROM event WHERE sourceId = OLD._id; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS event_tidy_trigger AFTER INSERT ON event BEGIN DELETE FROM event WHERE _id IN (SELECT _id FROM event WHERE sourceId=NEW.sourceId ORDER BY publishedTime DESC , _id DESC LIMIT -1 OFFSET 100);END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS source_limit_trigger BEFORE INSERT ON source WHEN EXISTS (select cnt from (SELECT COUNT(*) as cnt from source where packageName = NEW.packageName) where cnt >= 8) BEGIN select RAISE(FAIL,'Maximum number of source allowed for a plugin is 8'); END");
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        if (Dbg.e()) {
          Dbg.e("Error creating Registration database.", localSQLException);
        }
      }
    }
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (Dbg.d()) {
      Dbg.d("Reinstall of first version - drop all tables.");
    }
    dropAllDatabaseObjects(paramSQLiteDatabase);
    onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (Dbg.d()) {
      Dbg.d("Reinstall of first version - drop all tables.");
    }
    dropAllDatabaseObjects(paramSQLiteDatabase);
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.notification.provider.NotificationDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */