package com.sonyericsson.extras.liveware.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.test.IsolatedContext;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class ExperienceDatabaseHelper
  extends SQLiteOpenHelper
{
  static final String ACTIONS_SQL = "CREATE TABLE IF NOT EXISTS action (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, iconUri TEXT, package TEXT NOT NULL, class TEXT NOT NULL, category INTEGER NOT NULL DEFAULT 0, activity TEXT DEFAULT NULL, UUID TEXT NOT NULL, disabled INTEGER NOT NULL)";
  static final String ACTION_NAME_INDEX_SQL = "CREATE INDEX IF NOT EXISTS actions_name_index ON action(name);";
  static final String ACTION_SET_ACTION_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS action_set_action_id_delete_fk BEFORE DELETE ON action FOR EACH ROW BEGIN DELETE FROM action_set WHERE actionId = OLD._id; END;";
  static final String ACTION_SET_ACTION_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS action_set_action_id_insert_fk BEFORE INSERT ON action_set FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table action_set violates foreign key constraint actionId') WHERE (SELECT _id FROM action WHERE _id = NEW.actionId) IS NULL; END;";
  static final String ACTION_SET_ACTION_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS action_set_action_id_update_fk BEFORE UPDATE ON action_set FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table action_set violates foreign key constraint actionId') WHERE (SELECT _id FROM action WHERE _id = NEW.actionId) IS NULL; END;";
  static final String ACTION_SET_ACTION_ID_INDEX_SQL = "CREATE INDEX IF NOT EXISTS action_set_action_id_index_idx ON action_set(actionId);";
  static final String ACTION_SET_EXPERIENCE_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS action_set_experience_id_delete_fk BEFORE DELETE ON experience FOR EACH ROW BEGIN DELETE FROM action_set WHERE experienceId = OLD._id; END;";
  static final String ACTION_SET_EXPERIENCE_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS action_set_experience_id_insert_fk BEFORE INSERT ON action_set FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table action_set violates foreign key constraint experienceId') WHERE (SELECT _id FROM experience WHERE _id = NEW.experienceId) IS NULL; END;";
  static final String ACTION_SET_EXPERIENCE_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS action_set_experience_id_update_fk BEFORE UPDATE ON action_set FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table action_set violates foreign key constraint experienceId') WHERE (SELECT _id FROM experience WHERE _id = NEW.experienceId) IS NULL; END;";
  static final String ACTION_SET_EXPERIENCE_ID_INDEX_SQL = "CREATE INDEX IF NOT EXISTS action_set_experience_id_index_idx ON action_set(experienceId);";
  static final String ACTION_SET_SQL = "CREATE TABLE IF NOT EXISTS action_set (_id INTEGER PRIMARY KEY AUTOINCREMENT, experienceId INTEGER NOT NULL, actionSetType INTEGER NOT NULL DEFAULT 0, position INTEGER NOT NULL, actionId INTEGER NOT NULL, label TEXT NOT NULL, rawSetting TEXT NOT NULL DEFAULT '', UUID TEXT UNIQUE NOT NULL, finalized INTEGER NOT NULL,  UNIQUE (experienceId, actionSetType, position))";
  static final String DEVICES_SQL = "CREATE TABLE IF NOT EXISTS device (_id INTEGER PRIMARY KEY AUTOINCREMENT,iconName TEXT, iconLargeName TEXT, product_id TEXT NOT NULL, device_name TEXT, bearer_type INTEGER NOT NULL, type INTEGER NOT NULL, removable INTEGER NOT NULL DEFAULT 0, connected INTEGER NOT NULL DEFAULT 0, education_level INTEGER NOT NULL DEFAULT 0, user_defined_name_changed INTEGER NOT NULL DEFAULT 0, timestamp UNSIGNED BIG INT NOT NULL DEFAULT 0, notify_external INTEGER NOT NULL DEFAULT 0, device_key TEXT, configured INTEGER DEFAULT 0, device_page_activity TEXT, manufacturer INTEGER NOT NULL DEFAULT 2, cookie BIG INT NOT NULL DEFAULT 0, CHECK (connected IN ( 0, 1)), CHECK (removable IN ( 0, 1)), CHECK (user_defined_name_changed IN ( 0, 1)), CHECK (configured IN ( 0, 1, 2)), CHECK (manufacturer IN ( 0, 1, 2)))";
  static final String EXPERIENCES_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS experience_device_id_delete_fk BEFORE DELETE ON device FOR EACH ROW BEGIN UPDATE experience SET deviceId = 0  WHERE deviceId = OLD._id; END;";
  static final String EXPERIENCES_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS experience_device_id_insert_fk BEFORE INSERT ON experience FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table experience violates foreign key constraint deviceId') WHERE  NEW.deviceId > 0 AND  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;";
  static final String EXPERIENCES_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS experience_device_id_update_fk BEFORE UPDATE ON experience FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table experience violates foreign key constraint deviceId') WHERE  NEW.deviceId > 0 AND  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;";
  static final String EXPERIENCES_LOCATION_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS experience_location_id_delete_fk BEFORE DELETE ON location FOR EACH ROW BEGIN UPDATE experience SET locationId = 0  WHERE locationId = OLD._id; END;";
  static final String EXPERIENCES_LOCATION_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS experience_location_id_insert_fk BEFORE INSERT ON experience FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table experience violates foreign key constraint locationId') WHERE  NEW.locationId > 0 AND (SELECT _id FROM location WHERE _id = NEW.locationId) IS NULL; END;";
  static final String EXPERIENCES_LOCATION_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS experience_location_id_update_fk BEFORE UPDATE ON experience FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table experience violates foreign key constraint locationId') WHERE  NEW.locationId > 0 AND (SELECT _id FROM location WHERE _id = NEW.locationId) IS NULL; END;";
  static final String EXPERIENCES_SQL = "CREATE TABLE IF NOT EXISTS experience (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, pictureName TEXT, locationId INTEGER NOT NULL, timeId INTEGER NOT NULL, deviceId INTEGER NOT NULL, timestamp UNSIGNED BIG INT NOT NULL DEFAULT 0, enabled_state INTEGER NOT NULL DEFAULT 0, name_changed_by_user INTEGER NOT NULL DEFAULT 1, stop_timestamp UNSIGNED BIG INT NOT NULL DEFAULT 0, started INTEGER NOT NULL DEFAULT 0, name_resource TEXT)";
  static final String EXPERIENCES_TIME_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS experience_time_id_delete_fk BEFORE DELETE ON time FOR EACH ROW BEGIN UPDATE experience SET timeId = 0  WHERE timeId = OLD._id; END;";
  static final String EXPERIENCES_TIME_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS experience_time_id_insert_fk BEFORE INSERT ON experience FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table experience violates foreign key constraint timeId') WHERE  NEW.timeId > 0 AND (SELECT _id FROM time WHERE _id = NEW.timeId) IS NULL; END;";
  static final String EXPERIENCES_TIME_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS experience_time_id_update_fk BEFORE UPDATE ON experience FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table experience violates foreign key constraint timeId') WHERE  NEW.timeId > 0 AND (SELECT _id FROM time WHERE _id = NEW.timeId) IS NULL; END;";
  static final String EXPERIENCE_DEVICE_ID_INDEX_SQL = "CREATE INDEX IF NOT EXISTS experience_device_id_index_idx ON experience(deviceId);";
  static final String EXPERIENCE_LOCATION_ID_INDEX_SQL = "CREATE INDEX IF NOT EXISTS experience_location_id_index_idx ON experience(locationId);";
  static final String EXPERIENCE_TIME_ID_INDEX_SQL = "CREATE INDEX IF NOT EXISTS experience_location_id_index_idx ON experience(timeId);";
  static final String FEATURES_SQL = "CREATE TABLE IF NOT EXISTS feature (_id INTEGER PRIMARY KEY AUTOINCREMENT, device_id INTEGER NOT NULL, type INTEGER NOT NULL, package_name TEXT, class_name TEXT, intent TEXT NOT NULL, companion_name TEXT, companion_pkg TEXT, app_selection INTEGER NOT NULL, enabled INTEGER NOT NULL DEFAULT 0,modified_by_user INTEGER NOT NULL DEFAULT 0, CHECK (enabled IN ( 0, 1, 2)), CHECK (modified_by_user IN ( 0, 1)), CHECK (app_selection IN ( 0, 1, 2)))";
  static final String LOCATION_NAME_INDEX_SQL = "CREATE INDEX IF NOT EXISTS location_triggers_name_index ON location(name);";
  static final String LOCATION_TRIGGERS_SQL = "CREATE TABLE IF NOT EXISTS location (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, description TEXT, ssid TEXT NOT NULL, mac_address TEXT NOT NULL, trigger_status INT NOT NULL DEFAULT 0, CHECK (trigger_status IN (0,1)))";
  static final String TIME_START_INDEX_SQL = "CREATE INDEX IF NOT EXISTS time_triggers_start_index ON time(start_time);";
  static final String TIME_TRIGGERS_SQL = "CREATE TABLE IF NOT EXISTS time (_id INTEGER PRIMARY KEY AUTOINCREMENT, weekdays UNSIGNED INTEGER NOT NULL DEFAULT 254, start_time UNSIGNED BIG INT NOT NULL, end_time UNSIGNED BIG INT NOT NULL, trigger_status INT NOT NULL DEFAULT 0, CHECK (trigger_status IN (0,1)))";
  Context mCtx;
  
  public ExperienceDatabaseHelper(Context paramContext)
  {
    super(paramContext, "experience.db", null, 10);
    this.mCtx = paramContext;
  }
  
  private void dropAllDatabaseObjects(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS location_triggers_name_index");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS time_triggers_start_index");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS experience_device_id_index_idx");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS experience_location_id_index_idx");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS experience_time_id_index_idx");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS experience_device_id_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS experience_device_id_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS experience_device_id_delete_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS experience_location_id_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS experience_location_id_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS experience_location_id_delete_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS experience_time_id_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS experience_time_id_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS experience_time_id_delete_fk");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS action_set_experience_id_index_idx");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS action_set_experience_id_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS action_set_experience_id_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS action_set_experience_id_delete_fk");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS action_set_action_id_index_idx");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS action_set_action_id_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS action_set_action_id_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS action_set_action_id_delete_fk");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS experience");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS location");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS time");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS action_set");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS action");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS feature");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS device");
  }
  
  public static void execSqlAndLog(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if (Dbg.d()) {
      Dbg.d("execSqlAndLog: " + paramString);
    }
    paramSQLiteDatabase.execSQL(paramString);
  }
  
  private static void initializeStartedField(SQLiteDatabase paramSQLiteDatabase)
  {
    execSqlAndLog(paramSQLiteDatabase, "UPDATE experience SET started=1  WHERE stop_timestamp<timestamp");
  }
  
  private static String productIdsWhereString(String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WHERE product_id IN (");
    for (int i = 0; i < paramVarArgs.length; i++)
    {
      localStringBuilder.append("'" + paramVarArgs[i] + "'");
      if (i < -1 + paramVarArgs.length) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private static void removeDeviceFullIcon(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    execSqlAndLog(paramSQLiteDatabase, "UPDATE device SET iconLargeName = NULL WHERE iconLargeName = '" + paramString + "'");
  }
  
  private static void setDeviceIcons(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    execSqlAndLog(paramSQLiteDatabase, "UPDATE device SET iconName = '" + paramString2 + "'" + " WHERE " + "iconName" + " = " + "'" + paramString1 + "'");
    removeDeviceFullIcon(paramSQLiteDatabase, paramString1 + "_full");
  }
  
  private static void setDevicePageForDevices(SQLiteDatabase paramSQLiteDatabase, String paramString, String... paramVarArgs)
  {
    execSqlAndLog(paramSQLiteDatabase, "UPDATE device SET device_page_activity = '" + paramString + "' " + productIdsWhereString(paramVarArgs));
  }
  
  private static void setManufacturerForDevices(SQLiteDatabase paramSQLiteDatabase, String... paramVarArgs)
  {
    execSqlAndLog(paramSQLiteDatabase, "UPDATE device SET manufacturer = 1 " + productIdsWhereString(paramVarArgs));
  }
  
  private static void setTypeForDevices(SQLiteDatabase paramSQLiteDatabase, int paramInt, String... paramVarArgs)
  {
    execSqlAndLog(paramSQLiteDatabase, "UPDATE device SET type = " + paramInt + " " + productIdsWhereString(paramVarArgs));
  }
  
  private static void updateDeviceBearerFromVersion2to3(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    execSqlAndLog(paramSQLiteDatabase, "UPDATE device SET bearer_type = " + paramInt2 + " WHERE " + "bearer_type" + " = " + paramInt1);
  }
  
  private static void updateDeviceTypeFromVersion2to3(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    execSqlAndLog(paramSQLiteDatabase, "UPDATE device SET type = " + paramInt2 + " WHERE " + "type" + " = " + paramInt1);
  }
  
  private static void updateNonSonyManufacturerForDeviceFromVersion3to4(SQLiteDatabase paramSQLiteDatabase)
  {
    execSqlAndLog(paramSQLiteDatabase, "UPDATE device SET manufacturer = 2 WHERE manufacturer = 0");
  }
  
  public static void updateToVersion(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    String[] arrayOfString;
    switch (paramInt)
    {
    case 3: 
      execSqlAndLog(paramSQLiteDatabase, "UPDATE device SET configured = 1");
      updateDeviceBearerFromVersion2to3(paramSQLiteDatabase, 6, 10);
      updateDeviceBearerFromVersion2to3(paramSQLiteDatabase, 5, 9);
      updateDeviceBearerFromVersion2to3(paramSQLiteDatabase, 4, 8);
      updateDeviceBearerFromVersion2to3(paramSQLiteDatabase, 3, 7);
      updateDeviceBearerFromVersion2to3(paramSQLiteDatabase, 2, 6);
      updateDeviceBearerFromVersion2to3(paramSQLiteDatabase, 1, 4);
      updateDeviceTypeFromVersion2to3(paramSQLiteDatabase, 9, 17);
      updateDeviceTypeFromVersion2to3(paramSQLiteDatabase, 8, 16);
      updateDeviceTypeFromVersion2to3(paramSQLiteDatabase, 6, 15);
      updateDeviceTypeFromVersion2to3(paramSQLiteDatabase, 5, 14);
      updateDeviceTypeFromVersion2to3(paramSQLiteDatabase, 4, 13);
      updateDeviceTypeFromVersion2to3(paramSQLiteDatabase, 3, 12);
      updateDeviceTypeFromVersion2to3(paramSQLiteDatabase, 2, 11);
      updateDeviceTypeFromVersion2to3(paramSQLiteDatabase, 1, 10);
      updateDeviceTypeFromVersion2to3(paramSQLiteDatabase, 7, 5);
      break;
    case 4: 
      setDeviceIcons(paramSQLiteDatabase, "accy_headphones", "smartconnect_headphone_device_icn");
      setDeviceIcons(paramSQLiteDatabase, "accy_headset", "smartconnect_headset_device_icn");
      setDeviceIcons(paramSQLiteDatabase, "accy_keyboard", "smartconnect_keyboard_device_icn");
      setDeviceIcons(paramSQLiteDatabase, "accy_mouse", "smartconnect_mouse_device_icn");
      setDeviceIcons(paramSQLiteDatabase, "accy_speaker", "smartconnect_speaker_device_icn");
      setDeviceIcons(paramSQLiteDatabase, "accy_usb", "smartconnect_default_device_icn");
      arrayOfString = new String[2];
      arrayOfString[0] = "Bluetooth headphones";
      arrayOfString[1] = "Headphones";
      setTypeForDevices(paramSQLiteDatabase, 6, arrayOfString);
      arrayOfString = new String[4];
      arrayOfString[0] = "Bluetooth headset";
      arrayOfString[1] = "MW600";
      arrayOfString[2] = "Smart Wireless Headset pro";
      arrayOfString[3] = "SBH50";
      setTypeForDevices(paramSQLiteDatabase, 5, arrayOfString);
      arrayOfString = new String[1];
      arrayOfString[0] = "Bluetooth gamecontroller";
      setTypeForDevices(paramSQLiteDatabase, 13, arrayOfString);
      arrayOfString = new String[2];
      arrayOfString[0] = "Bluetooth keyboard";
      arrayOfString[1] = "usb_class:Keyboard";
      setTypeForDevices(paramSQLiteDatabase, 9, arrayOfString);
      arrayOfString = new String[2];
      arrayOfString[0] = "Bluetooth mouse";
      arrayOfString[1] = "usb_class:Mouse";
      setTypeForDevices(paramSQLiteDatabase, 8, arrayOfString);
      arrayOfString = new String[4];
      arrayOfString[0] = "Bluetooth speaker";
      arrayOfString[1] = "SRS-BTV25";
      arrayOfString[2] = "SRS-BTV5";
      arrayOfString[3] = "SR-7734";
      setTypeForDevices(paramSQLiteDatabase, 7, arrayOfString);
      arrayOfString = new String[1];
      arrayOfString[0] = "Sony BDR";
      setTypeForDevices(paramSQLiteDatabase, 20, arrayOfString);
      arrayOfString = new String[8];
      arrayOfString[0] = "Bluetooth headphones";
      arrayOfString[1] = "Bluetooth headset";
      arrayOfString[2] = "Bluetooth speaker";
      arrayOfString[3] = "MW600";
      arrayOfString[4] = "Sony Tablet S";
      arrayOfString[5] = "SRS-BTV25";
      arrayOfString[6] = "SRS-BTV5";
      arrayOfString[7] = "SR-7734";
      setDevicePageForDevices(paramSQLiteDatabase, "com.sonymobile.connectivitycenter/com.sonymobile.connectivitycenter.CCDefaultDevicePageActivity", arrayOfString);
      arrayOfString = new String[9];
      arrayOfString[0] = "LiveView";
      arrayOfString[1] = "MW600";
      arrayOfString[2] = "Smart Wireless Headset pro";
      arrayOfString[3] = "SBH50";
      arrayOfString[4] = "SmartWatch";
      arrayOfString[5] = "Sony Tablet S";
      arrayOfString[6] = "SRS-BTV25";
      arrayOfString[7] = "SRS-BTV5";
      arrayOfString[8] = "SR-7734";
      setManufacturerForDevices(paramSQLiteDatabase, arrayOfString);
      updateNonSonyManufacturerForDeviceFromVersion3to4(paramSQLiteDatabase);
      break;
    case 5: 
      setDeviceIcons(paramSQLiteDatabase, "accy_bluetooth", "smartconnect_bluetooth_device_icn");
      setDeviceIcons(paramSQLiteDatabase, "accy_mhl", "smartconnect_tv_device_icn");
      arrayOfString = new String[2];
      arrayOfString[0] = "HDMI";
      arrayOfString[1] = "MHL";
      setTypeForDevices(paramSQLiteDatabase, 1, arrayOfString);
      removeDeviceFullIcon(paramSQLiteDatabase, "accy_gamecontroller_full");
      removeDeviceFullIcon(paramSQLiteDatabase, "accy_sony_tablet_s_full");
      removeDeviceFullIcon(paramSQLiteDatabase, "accy_external_memory_full");
      removeDeviceFullIcon(paramSQLiteDatabase, "accy_charger_full");
      removeDeviceFullIcon(paramSQLiteDatabase, "accy_blink_full");
      break;
    case 6: 
      arrayOfString = new String[2];
      arrayOfString[0] = "Bluetooth mouse";
      arrayOfString[1] = "Bluetooth keyboard";
      setDevicePageForDevices(paramSQLiteDatabase, "com.sonyericsson.extras.liveware/.ui.SCGenericDevicePages", arrayOfString);
      break;
    case 8: 
      initializeStartedField(paramSQLiteDatabase);
    }
  }
  
  public void cleanupDeviceTable(SQLiteDatabase paramSQLiteDatabase)
  {
    execSqlAndLog(paramSQLiteDatabase, "ALTER TABLE device RENAME TO device_temp");
    execSqlAndLog(paramSQLiteDatabase, "CREATE TABLE IF NOT EXISTS device (_id INTEGER PRIMARY KEY AUTOINCREMENT,iconName TEXT, iconLargeName TEXT, product_id TEXT NOT NULL, device_name TEXT, bearer_type INTEGER NOT NULL, type INTEGER NOT NULL, removable INTEGER NOT NULL DEFAULT 0, connected INTEGER NOT NULL DEFAULT 0, education_level INTEGER NOT NULL DEFAULT 0, user_defined_name_changed INTEGER NOT NULL DEFAULT 0, timestamp UNSIGNED BIG INT NOT NULL DEFAULT 0, notify_external INTEGER NOT NULL DEFAULT 0, device_key TEXT, configured INTEGER DEFAULT 0, device_page_activity TEXT, manufacturer INTEGER NOT NULL DEFAULT 2, cookie BIG INT NOT NULL DEFAULT 0, CHECK (connected IN ( 0, 1)), CHECK (removable IN ( 0, 1)), CHECK (user_defined_name_changed IN ( 0, 1)), CHECK (configured IN ( 0, 1, 2)), CHECK (manufacturer IN ( 0, 1, 2)))");
    execSqlAndLog(paramSQLiteDatabase, "INSERT INTO device SELECT * FROM device_temp");
    execSqlAndLog(paramSQLiteDatabase, "DROP TABLE IF EXISTS device_temp");
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS device (_id INTEGER PRIMARY KEY AUTOINCREMENT,iconName TEXT, iconLargeName TEXT, product_id TEXT NOT NULL, device_name TEXT, bearer_type INTEGER NOT NULL, type INTEGER NOT NULL, removable INTEGER NOT NULL DEFAULT 0, connected INTEGER NOT NULL DEFAULT 0, education_level INTEGER NOT NULL DEFAULT 0, user_defined_name_changed INTEGER NOT NULL DEFAULT 0, timestamp UNSIGNED BIG INT NOT NULL DEFAULT 0, notify_external INTEGER NOT NULL DEFAULT 0, device_key TEXT, configured INTEGER DEFAULT 0, device_page_activity TEXT, manufacturer INTEGER NOT NULL DEFAULT 2, cookie BIG INT NOT NULL DEFAULT 0, CHECK (connected IN ( 0, 1)), CHECK (removable IN ( 0, 1)), CHECK (user_defined_name_changed IN ( 0, 1)), CHECK (configured IN ( 0, 1, 2)), CHECK (manufacturer IN ( 0, 1, 2)))");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS feature (_id INTEGER PRIMARY KEY AUTOINCREMENT, device_id INTEGER NOT NULL, type INTEGER NOT NULL, package_name TEXT, class_name TEXT, intent TEXT NOT NULL, companion_name TEXT, companion_pkg TEXT, app_selection INTEGER NOT NULL, enabled INTEGER NOT NULL DEFAULT 0,modified_by_user INTEGER NOT NULL DEFAULT 0, CHECK (enabled IN ( 0, 1, 2)), CHECK (modified_by_user IN ( 0, 1)), CHECK (app_selection IN ( 0, 1, 2)))");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS action (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, iconUri TEXT, package TEXT NOT NULL, class TEXT NOT NULL, category INTEGER NOT NULL DEFAULT 0, activity TEXT DEFAULT NULL, UUID TEXT NOT NULL, disabled INTEGER NOT NULL)");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS time (_id INTEGER PRIMARY KEY AUTOINCREMENT, weekdays UNSIGNED INTEGER NOT NULL DEFAULT 254, start_time UNSIGNED BIG INT NOT NULL, end_time UNSIGNED BIG INT NOT NULL, trigger_status INT NOT NULL DEFAULT 0, CHECK (trigger_status IN (0,1)))");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS location (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, description TEXT, ssid TEXT NOT NULL, mac_address TEXT NOT NULL, trigger_status INT NOT NULL DEFAULT 0, CHECK (trigger_status IN (0,1)))");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS experience (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, pictureName TEXT, locationId INTEGER NOT NULL, timeId INTEGER NOT NULL, deviceId INTEGER NOT NULL, timestamp UNSIGNED BIG INT NOT NULL DEFAULT 0, enabled_state INTEGER NOT NULL DEFAULT 0, name_changed_by_user INTEGER NOT NULL DEFAULT 1, stop_timestamp UNSIGNED BIG INT NOT NULL DEFAULT 0, started INTEGER NOT NULL DEFAULT 0, name_resource TEXT)");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS location_triggers_name_index ON location(name);");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS time_triggers_start_index ON time(start_time);");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS action_set (_id INTEGER PRIMARY KEY AUTOINCREMENT, experienceId INTEGER NOT NULL, actionSetType INTEGER NOT NULL DEFAULT 0, position INTEGER NOT NULL, actionId INTEGER NOT NULL, label TEXT NOT NULL, rawSetting TEXT NOT NULL DEFAULT '', UUID TEXT UNIQUE NOT NULL, finalized INTEGER NOT NULL,  UNIQUE (experienceId, actionSetType, position))");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS experience_device_id_index_idx ON experience(deviceId);");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS experience_device_id_insert_fk BEFORE INSERT ON experience FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table experience violates foreign key constraint deviceId') WHERE  NEW.deviceId > 0 AND  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS experience_device_id_update_fk BEFORE UPDATE ON experience FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table experience violates foreign key constraint deviceId') WHERE  NEW.deviceId > 0 AND  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS experience_device_id_delete_fk BEFORE DELETE ON device FOR EACH ROW BEGIN UPDATE experience SET deviceId = 0  WHERE deviceId = OLD._id; END;");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS experience_location_id_index_idx ON experience(locationId);");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS experience_location_id_insert_fk BEFORE INSERT ON experience FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table experience violates foreign key constraint locationId') WHERE  NEW.locationId > 0 AND (SELECT _id FROM location WHERE _id = NEW.locationId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS experience_location_id_update_fk BEFORE UPDATE ON experience FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table experience violates foreign key constraint locationId') WHERE  NEW.locationId > 0 AND (SELECT _id FROM location WHERE _id = NEW.locationId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS experience_location_id_delete_fk BEFORE DELETE ON location FOR EACH ROW BEGIN UPDATE experience SET locationId = 0  WHERE locationId = OLD._id; END;");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS experience_location_id_index_idx ON experience(timeId);");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS experience_time_id_insert_fk BEFORE INSERT ON experience FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table experience violates foreign key constraint timeId') WHERE  NEW.timeId > 0 AND (SELECT _id FROM time WHERE _id = NEW.timeId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS experience_time_id_update_fk BEFORE UPDATE ON experience FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table experience violates foreign key constraint timeId') WHERE  NEW.timeId > 0 AND (SELECT _id FROM time WHERE _id = NEW.timeId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS experience_time_id_delete_fk BEFORE DELETE ON time FOR EACH ROW BEGIN UPDATE experience SET timeId = 0  WHERE timeId = OLD._id; END;");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS action_set_experience_id_index_idx ON action_set(experienceId);");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS action_set_experience_id_insert_fk BEFORE INSERT ON action_set FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table action_set violates foreign key constraint experienceId') WHERE (SELECT _id FROM experience WHERE _id = NEW.experienceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS action_set_experience_id_update_fk BEFORE UPDATE ON action_set FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table action_set violates foreign key constraint experienceId') WHERE (SELECT _id FROM experience WHERE _id = NEW.experienceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS action_set_experience_id_delete_fk BEFORE DELETE ON experience FOR EACH ROW BEGIN DELETE FROM action_set WHERE experienceId = OLD._id; END;");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS action_set_action_id_index_idx ON action_set(actionId);");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS action_set_action_id_insert_fk BEFORE INSERT ON action_set FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table action_set violates foreign key constraint actionId') WHERE (SELECT _id FROM action WHERE _id = NEW.actionId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS action_set_action_id_update_fk BEFORE UPDATE ON action_set FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table action_set violates foreign key constraint actionId') WHERE (SELECT _id FROM action WHERE _id = NEW.actionId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS action_set_action_id_delete_fk BEFORE DELETE ON action FOR EACH ROW BEGIN DELETE FROM action_set WHERE actionId = OLD._id; END;");
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        if (Dbg.e()) {
          Dbg.e("Error creating Experience database.", localSQLException);
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
    int i = paramInt1 + 1;
    if (Dbg.d()) {
      Dbg.e("onUpgrade oldVersion " + paramInt1);
    }
    if (i > paramInt2) {}
    for (;;)
    {
      return;
      try
      {
        if (!Dbg.d()) {
          break;
        }
        Dbg.e("onUpgrade toVersion " + i);
      }
      catch (SQLiteException localSQLiteException)
      {
        Dbg.e(localSQLiteException);
        i++;
      }
      if (Dbg.d()) {
        Dbg.d("onUpgrade " + i + " drop all tables.");
      }
      dropAllDatabaseObjects(paramSQLiteDatabase);
      onCreate(paramSQLiteDatabase);
      if (!IsolatedContext.class.isInstance(this.mCtx)) {
        this.mCtx.getSharedPreferences("preload_prefs", 0).edit().clear().commit();
      }
    }
    for (;;)
    {
      break;
      execSqlAndLog(paramSQLiteDatabase, "ALTER TABLE experience ADD COLUMN name_resource TEXT");
      continue;
      execSqlAndLog(paramSQLiteDatabase, "ALTER TABLE device ADD COLUMN device_key TEXT");
      execSqlAndLog(paramSQLiteDatabase, "ALTER TABLE device ADD COLUMN configured INTEGER DEFAULT 0");
      execSqlAndLog(paramSQLiteDatabase, "ALTER TABLE device ADD COLUMN device_page_activity TEXT");
      execSqlAndLog(paramSQLiteDatabase, "ALTER TABLE device ADD COLUMN manufacturer INTEGER NOT NULL DEFAULT 2");
      updateToVersion(paramSQLiteDatabase, i);
      continue;
      updateToVersion(paramSQLiteDatabase, i);
      continue;
      updateToVersion(paramSQLiteDatabase, i);
      continue;
      updateToVersion(paramSQLiteDatabase, i);
      continue;
      execSqlAndLog(paramSQLiteDatabase, "ALTER TABLE time ADD COLUMN weekdays UNSIGNED INTEGER NOT NULL DEFAULT 254");
      continue;
      execSqlAndLog(paramSQLiteDatabase, "ALTER TABLE experience ADD COLUMN started INTEGER NOT NULL DEFAULT 0");
      updateToVersion(paramSQLiteDatabase, i);
      continue;
      execSqlAndLog(paramSQLiteDatabase, "ALTER TABLE device ADD COLUMN cookie BIG INT NOT NULL DEFAULT 0");
      continue;
      execSqlAndLog(paramSQLiteDatabase, "ALTER TABLE action ADD COLUMN category INTEGER NOT NULL DEFAULT 0");
      execSqlAndLog(paramSQLiteDatabase, "ALTER TABLE action ADD COLUMN activity TEXT DEFAULT NULL");
      execSqlAndLog(paramSQLiteDatabase, "ALTER TABLE action_set ADD COLUMN rawSetting TEXT NOT NULL DEFAULT ''");
      LegacyActionSetsFromPrefsUpgrader.migrateAll(this.mCtx, paramSQLiteDatabase);
      cleanupDeviceTable(paramSQLiteDatabase);
    }
    switch (i)
    {
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.db.ExperienceDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */