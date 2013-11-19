package com.sonyericsson.extras.liveware.aef.registration.provider;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.sonyericsson.extras.liveware.aef.registration.RegistrationInternal.DeviceImpl;
import com.sonyericsson.extras.liveware.aef.registration.RegistrationInternal.DisplayImpl;
import com.sonyericsson.extras.liveware.aef.registration.RegistrationInternal.HostAppImpl;
import com.sonyericsson.extras.liveware.aef.registration.RegistrationInternal.InputImpl;
import com.sonyericsson.extras.liveware.aef.registration.RegistrationInternal.LedImpl;
import com.sonyericsson.extras.liveware.aef.registration.RegistrationInternal.SensorImpl;
import com.sonyericsson.extras.liveware.utils.Dbg;

public class RegistrationDatabaseHelper
  extends SQLiteOpenHelper
{
  static final String CAPABILITIES_QUERY = "SELECT host_application._id, " + HOSTAPP_FIELDS + ", " + "device" + "." + "_id" + ", " + DEVICE_FIELDS + ", " + "display" + "." + "_id" + ", " + DISPLAY_FIELDS + ", " + "sensor" + "." + "_id" + ", " + SENSOR_FIELDS + ", " + "sensor_type" + "." + "type" + ", " + "led" + "." + "_id" + ", " + LED_FIELDS + ", " + "input" + "." + "_id" + ", " + INPUT_FIELDS + ", " + "keypad" + "." + "type" + " FROM " + "host_application" + " JOIN " + "device" + " ON " + "device" + "." + "hostAppId" + "=" + "host_application" + "." + "_id" + " LEFT JOIN " + "display" + " ON " + "display" + "." + "deviceId" + "=" + "device" + "." + "_id" + " LEFT JOIN " + "sensor" + " ON " + "sensor" + "." + "deviceId" + "=" + "device" + "." + "_id" + " LEFT JOIN " + "sensor_type" + " ON " + "sensor_type" + "." + "_id" + "=" + "sensor" + "." + "sensorTypeId" + " LEFT JOIN " + "led" + " ON " + "led" + "." + "deviceId" + "=" + "device" + "." + "_id" + " LEFT JOIN " + "input" + " ON " + "input" + "." + "deviceId" + "=" + "device" + "." + "_id" + " LEFT JOIN " + "keypad" + " ON " + "keypad" + "." + "_id" + "=" + "input" + "." + "keyPadId" + ";";
  static final String CAPABILITIES_VIEW_SQL = "CREATE VIEW IF NOT EXISTS capabilities AS " + CAPABILITIES_QUERY;
  static final String DEVICE_FIELDS;
  static final String DEVICE_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS device_hostapp_id_delete_fk BEFORE DELETE ON host_application FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table host_application violates foreign key constraint hostAppId') WHERE  (SELECT hostAppId FROM device WHERE hostAppId = OLD._id) IS NOT NULL; END;";
  static final String DEVICE_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS device_hostapp_id_insert_fk BEFORE INSERT ON device FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table device violates foreign key constraint hostAppId') WHERE  (SELECT _id FROM host_application WHERE _id = NEW.hostAppId) IS NULL; END;";
  static final String DEVICE_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS device_hostapp_id_update_fk BEFORE UPDATE ON device FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table device violates foreign key constraint hostAppId') WHERE  (SELECT _id FROM host_application WHERE _id = NEW.hostAppId) IS NULL; END;";
  static final String DEVICE_HOSTAPP_ID_INDEX_SQL = "CREATE INDEX IF NOT EXISTS device_hostapp_id_idx ON device(hostAppId);";
  static final String DEVICE_SQL = "CREATE TABLE IF NOT EXISTS device (_id INTEGER PRIMARY KEY AUTOINCREMENT, hostAppId INTEGER NOT NULL, model TEXT, type TEXT, subType TEXT, marketingName TEXT, vendor TEXT, uid TEXT, firmwareVersion TEXT, widgetImageHeight UNSIGNED INTEGER, widgetImageWidtht UNSIGNED INTEGER, vibrator SHORT INTEGER NOT NULL DEFAULT 0, accessory_connected SHORT INTEGER NOT NULL DEFAULT 0, CHECK (vibrator IN ( 0, 1)), CHECK (accessory_connected IN ( 0, 1)), FOREIGN KEY(hostAppId) REFERENCES host_application(_id))";
  static final String DISPLAY_DEVICE_ID_INDEX_IDX = "CREATE INDEX IF NOT EXISTS display_device_id_idx ON display(deviceId);";
  static final String DISPLAY_FIELDS;
  static final String DISPLAY_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS display_device_delete_fk BEFORE DELETE ON device FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table device violates foreign key constraint deviceId') WHERE  (SELECT deviceId FROM display WHERE deviceId = OLD._id) IS NOT NULL; END;";
  static final String DISPLAY_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS display_device_insert_fk BEFORE INSERT ON display FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table display violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;";
  static final String DISPLAY_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS display_device_update_fk BEFORE UPDATE ON display FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table display violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;";
  static final String DISPLAY_SQL = "CREATE TABLE IF NOT EXISTS display (_id INTEGER PRIMARY KEY AUTOINCREMENT, deviceId INTEGER NOT NULL, width INTEGER NOT NULL, height INTEGER NOT NULL, colors INTEGER NOT NULL, refreshRate INTEGER NOT NULL, latency INTEGER NOT NULL, tapTouch SHORT INTEGER NOT NULL DEFAULT 0, motionTouch SHORT INTEGER NOT NULL DEFAULT 0, CHECK (tapTouch IN ( 0, 1)), CHECK (motionTouch IN ( 0, 1)), FOREIGN KEY(deviceId) REFERENCES device(_id))";
  static final String EXTENSION_SQL = "CREATE TABLE IF NOT EXISTS extension (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, configurationActivity TEXT, configurationText TEXT, iconLargeUri TEXT, iconSmallUri TEXT, extensionIconUri TEXT, extensionIconUriBlackWhite TEXT, extension_key TEXT NOT NULL, notificationApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, packageName TEXT UNIQUE NOT NULL, userId TEXT NOT NULL )";
  static final String HOSTAPP_FIELDS;
  static final String HOST_APP_SQL = "CREATE TABLE IF NOT EXISTS host_application (_id INTEGER PRIMARY KEY AUTOINCREMENT, version TEXT NOT NULL, packageName TEXT UNIQUE NOT NULL, widgetApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, controlApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, sensorApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, notificationApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, widgetRefreshrate INTEGER )";
  static final String INPUT_DEVICE_ID_INDEX_IDX = "CREATE INDEX IF NOT EXISTS input_device_id_idx ON input(deviceId);";
  static final String INPUT_FIELDS;
  static final String INPUT_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS input_device_delete_fk BEFORE DELETE ON device FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table device violates foreign key constraint deviceId') WHERE  (SELECT deviceId FROM input WHERE deviceId = OLD._id) IS NOT NULL; END;";
  static final String INPUT_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS input_device_insert_fk BEFORE INSERT ON input FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table input violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;";
  static final String INPUT_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS input_device_update_fk BEFORE UPDATE ON input FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table input violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;";
  static final String INPUT_KEYPAD_ID_INDEX_IDX = "CREATE INDEX IF NOT EXISTS input_keypad_id_idx ON input(keyPadId);";
  static final String INPUT_KEY_PAD_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS input_key_pad_delete_fk BEFORE DELETE ON keypad FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table keypad violates foreign key constraint keyPadId') WHERE  (SELECT keyPadId FROM input WHERE keyPadId = OLD._id) IS NOT NULL; END;";
  static final String INPUT_KEY_PAD_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS input_key_pad_insert_fk BEFORE INSERT ON input FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table input violates foreign key constraint keyPadId') WHERE  (SELECT _id FROM keypad WHERE _id = NEW.keyPadId) IS NULL; END;";
  static final String INPUT_KEY_PAD_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS input_key_pad_update_fk BEFORE UPDATE ON input FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table input violates foreign key constraint keyPadId') WHERE  (SELECT _id FROM keypad WHERE _id = NEW.keyPadId) IS NULL; END;";
  static final String INPUT_SQL = "CREATE TABLE IF NOT EXISTS input (_id INTEGER PRIMARY KEY AUTOINCREMENT, deviceId INTEGER NOT NULL, keyPadId INTEGER NOT NULL, enabled SHORT INTEGER NOT NULL DEFAULT 0, CHECK (enabled IN (0,1)), FOREIGN KEY(deviceId) REFERENCES device(_id), FOREIGN KEY(keyPadId) REFERENCES keypad(_id))";
  static final String KEY_PAD_SQL = "CREATE TABLE IF NOT EXISTS keypad (_id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT NOT NULL)";
  static final String LED_DEVICE_ID_INDEX_IDX = "CREATE INDEX IF NOT EXISTS led_device_id_idx ON led(deviceId);";
  static final String LED_FIELDS;
  static final String LED_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS led_device_delete_fk BEFORE DELETE ON device FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table device violates foreign key constraint deviceId') WHERE  (SELECT deviceId FROM led WHERE deviceId = OLD._id) IS NOT NULL; END;";
  static final String LED_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS led_device_insert_fk BEFORE INSERT ON led FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table led violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;";
  static final String LED_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS led_device_update_fk BEFORE UPDATE ON led FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table led violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;";
  static final String LED_SQL = "CREATE TABLE IF NOT EXISTS led (_id INTEGER PRIMARY KEY AUTOINCREMENT, deviceId INTEGER NOT NULL, colors INTEGER NOT NULL, FOREIGN KEY(deviceId) REFERENCES device(_id))";
  static final String PERMISSION_REQUEST_SQL = "CREATE TABLE IF NOT EXISTS permission_request (_id INTEGER PRIMARY KEY AUTOINCREMENT, packageName TEXT UNIQUE NOT NULL, permissionRequested UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, permissionGranted UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0 )";
  static final String REGISTRATION_EXTENSION_HOSTAPP_ID_INDEX_SQL = "CREATE INDEX IF NOT EXISTS registration_extension_hostapp_index ON registration(extensionId, hostAppPackageName);";
  static final String REGISTRATION_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS registration_extension_id_delete_fk BEFORE DELETE ON extension FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table extension violates foreign key constraint extensionId') WHERE  (SELECT extensionId FROM registration WHERE extensionId = OLD._id) IS NOT NULL; END;";
  static final String REGISTRATION_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS registration_extension_id_insert_fk BEFORE INSERT ON registration FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table registration violates foreign key constraint extensionId') WHERE  (SELECT _id FROM extension WHERE _id = NEW.extensionId) IS NULL; END;";
  static final String REGISTRATION_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS registration_extension_id_update_fk BEFORE UPDATE ON registration FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table registration violates foreign key constraint extensionId') WHERE  (SELECT _id FROM extension WHERE _id = NEW.extensionId) IS NULL; END;";
  static final String REGISTRATION_SQL = "CREATE TABLE IF NOT EXISTS registration (_id INTEGER PRIMARY KEY AUTOINCREMENT, extensionId INTEGER NOT NULL, hostAppPackageName TEXT NOT NULL, widgetApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, controlApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, sensorApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, FOREIGN KEY(extensionId) REFERENCES extension(_id), CONSTRAINT registration_extension_hostapp_unique UNIQUE (extensionId, hostAppPackageName))";
  static final String SENSOR_DEVICE_ID_INDEX_IDX = "CREATE INDEX IF NOT EXISTS sensor_device_id_idx ON sensor(deviceId);";
  static final String SENSOR_FIELDS;
  static final String SENSOR_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS sensor_device_delete_fk BEFORE DELETE ON device FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table device violates foreign key constraint deviceId') WHERE  (SELECT deviceId FROM sensor WHERE deviceId = OLD._id) IS NOT NULL; END;";
  static final String SENSOR_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS sensor_device_insert_fk BEFORE INSERT ON sensor FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table sensor violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;";
  static final String SENSOR_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS sensor_device_update_fk BEFORE UPDATE ON sensor FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table sensor violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;";
  static final String SENSOR_SENSOR_TYPE_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS sensor_sensor_type_delete_fk BEFORE DELETE ON sensor_type FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table sensor_type violates foreign key constraint sensorTypeId') WHERE  (SELECT sensorTypeId FROM sensor WHERE sensorTypeId = OLD._id) IS NOT NULL; END;";
  static final String SENSOR_SENSOR_TYPE_FK_INSERT_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS sensor_sensor_type_insert_fk BEFORE INSERT ON sensor FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table sensor violates foreign key constraint sensorTypeId') WHERE  (SELECT _id FROM sensor_type WHERE _id = NEW.sensorTypeId) IS NULL; END;";
  static final String SENSOR_SENSOR_TYPE_FK_UPDATE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS sensor_sensor_type_update_fk BEFORE UPDATE ON sensor FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table sensor violates foreign key constraint sensorTypeId') WHERE  (SELECT _id FROM sensor_type WHERE _id = NEW.sensorTypeId) IS NULL; END;";
  static final String SENSOR_SENSOR_TYPE_ID_INDEX_IDX = "CREATE INDEX IF NOT EXISTS sensor_sensor_type_id_idx ON sensor(sensorTypeId);";
  static final String SENSOR_SQL = "CREATE TABLE IF NOT EXISTS sensor (_id INTEGER PRIMARY KEY AUTOINCREMENT, deviceId INTEGER NOT NULL, sensorTypeId INTEGER NOT NULL, resolution REAL, minimumDelay UNSIGNED INTEGER, maximumRange REAL, name TEXT, sensorId UNSIGNED INTEGER NOT NULL, sensorInterrupt SHORT INTEGER NOT NULL DEFAULT 0, CHECK (sensorInterrupt IN ( 0, 1)), FOREIGN KEY(deviceId) REFERENCES device(_id), FOREIGN KEY(sensorTypeId) REFERENCES sensor_type(_id))";
  static final String SENSOR_TYPE_SQL = "CREATE TABLE IF NOT EXISTS sensor_type (_id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT NOT NULL, delicate_data SHORT INTEGER NOT NULL DEFAULT 0, CHECK (delicate_data IN ( 0, 1)))";
  static final String SOURCE_FK_DELETE_TRIGGER_SQL = "CREATE TRIGGER IF NOT EXISTS extension_registration_id_delete_fk BEFORE DELETE ON extension FOR EACH ROW BEGIN DELETE FROM registration WHERE extensionId = OLD._id; END;";
  
  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder(RegistrationInternal.HostAppImpl.hostAppProjection().length);
    for (int j = 0; j < RegistrationInternal.HostAppImpl.hostAppProjection().length; j++)
    {
      if (j > 0) {
        localStringBuilder1.append(", ");
      }
      localStringBuilder1.append("host_application.");
      localStringBuilder1.append(RegistrationInternal.HostAppImpl.hostAppProjection()[j]);
    }
    HOSTAPP_FIELDS = localStringBuilder1.toString();
    StringBuilder localStringBuilder3 = new StringBuilder(RegistrationInternal.DeviceImpl.deviceProjection().length);
    for (int i = 0; i < RegistrationInternal.DeviceImpl.deviceProjection().length; i++)
    {
      if (i > 0) {
        localStringBuilder3.append(", ");
      }
      localStringBuilder3.append("device.");
      localStringBuilder3.append(RegistrationInternal.DeviceImpl.deviceProjection()[i]);
    }
    DEVICE_FIELDS = localStringBuilder3.toString();
    StringBuilder localStringBuilder2 = new StringBuilder(RegistrationInternal.DisplayImpl.displayProjection().length);
    for (int k = 0; k < RegistrationInternal.DisplayImpl.displayProjection().length; k++)
    {
      if (k > 0) {
        localStringBuilder2.append(", ");
      }
      localStringBuilder2.append("display.");
      localStringBuilder2.append(RegistrationInternal.DisplayImpl.displayProjection()[k]);
    }
    DISPLAY_FIELDS = localStringBuilder2.toString();
    localStringBuilder2 = new StringBuilder(RegistrationInternal.LedImpl.ledProjection().length);
    for (k = 0; k < RegistrationInternal.LedImpl.ledProjection().length; k++)
    {
      if (k > 0) {
        localStringBuilder2.append(", ");
      }
      localStringBuilder2.append("led.");
      localStringBuilder2.append(RegistrationInternal.LedImpl.ledProjection()[k]);
    }
    LED_FIELDS = localStringBuilder2.toString();
    localStringBuilder2 = new StringBuilder(RegistrationInternal.SensorImpl.sensorProjection().length);
    for (k = 0; k < RegistrationInternal.SensorImpl.sensorProjection().length; k++)
    {
      if (k > 0) {
        localStringBuilder2.append(", ");
      }
      localStringBuilder2.append("sensor.");
      localStringBuilder2.append(RegistrationInternal.SensorImpl.sensorProjection()[k]);
    }
    SENSOR_FIELDS = localStringBuilder2.toString();
    localStringBuilder2 = new StringBuilder(RegistrationInternal.InputImpl.inputProjection().length);
    for (k = 0; k < RegistrationInternal.InputImpl.inputProjection().length; k++)
    {
      if (k > 0) {
        localStringBuilder2.append(", ");
      }
      localStringBuilder2.append("input.");
      localStringBuilder2.append(RegistrationInternal.InputImpl.inputProjection()[k]);
    }
    INPUT_FIELDS = localStringBuilder2.toString();
  }
  
  public RegistrationDatabaseHelper(Context paramContext)
  {
    super(paramContext, "registration.db", null, 2);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS extension (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, configurationActivity TEXT, configurationText TEXT, iconLargeUri TEXT, iconSmallUri TEXT, extensionIconUri TEXT, extensionIconUriBlackWhite TEXT, extension_key TEXT NOT NULL, notificationApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, packageName TEXT UNIQUE NOT NULL, userId TEXT NOT NULL )");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS registration (_id INTEGER PRIMARY KEY AUTOINCREMENT, extensionId INTEGER NOT NULL, hostAppPackageName TEXT NOT NULL, widgetApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, controlApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, sensorApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, FOREIGN KEY(extensionId) REFERENCES extension(_id), CONSTRAINT registration_extension_hostapp_unique UNIQUE (extensionId, hostAppPackageName))");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS registration_extension_hostapp_index ON registration(extensionId, hostAppPackageName);");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS registration_extension_id_insert_fk BEFORE INSERT ON registration FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table registration violates foreign key constraint extensionId') WHERE  (SELECT _id FROM extension WHERE _id = NEW.extensionId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS registration_extension_id_update_fk BEFORE UPDATE ON registration FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table registration violates foreign key constraint extensionId') WHERE  (SELECT _id FROM extension WHERE _id = NEW.extensionId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS registration_extension_id_delete_fk BEFORE DELETE ON extension FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table extension violates foreign key constraint extensionId') WHERE  (SELECT extensionId FROM registration WHERE extensionId = OLD._id) IS NOT NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS host_application (_id INTEGER PRIMARY KEY AUTOINCREMENT, version TEXT NOT NULL, packageName TEXT UNIQUE NOT NULL, widgetApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, controlApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, sensorApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, notificationApiVersion UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, widgetRefreshrate INTEGER )");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS device (_id INTEGER PRIMARY KEY AUTOINCREMENT, hostAppId INTEGER NOT NULL, model TEXT, type TEXT, subType TEXT, marketingName TEXT, vendor TEXT, uid TEXT, firmwareVersion TEXT, widgetImageHeight UNSIGNED INTEGER, widgetImageWidtht UNSIGNED INTEGER, vibrator SHORT INTEGER NOT NULL DEFAULT 0, accessory_connected SHORT INTEGER NOT NULL DEFAULT 0, CHECK (vibrator IN ( 0, 1)), CHECK (accessory_connected IN ( 0, 1)), FOREIGN KEY(hostAppId) REFERENCES host_application(_id))");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS device_hostapp_id_idx ON device(hostAppId);");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS display (_id INTEGER PRIMARY KEY AUTOINCREMENT, deviceId INTEGER NOT NULL, width INTEGER NOT NULL, height INTEGER NOT NULL, colors INTEGER NOT NULL, refreshRate INTEGER NOT NULL, latency INTEGER NOT NULL, tapTouch SHORT INTEGER NOT NULL DEFAULT 0, motionTouch SHORT INTEGER NOT NULL DEFAULT 0, CHECK (tapTouch IN ( 0, 1)), CHECK (motionTouch IN ( 0, 1)), FOREIGN KEY(deviceId) REFERENCES device(_id))");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS display_device_id_idx ON display(deviceId);");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sensor_type (_id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT NOT NULL, delicate_data SHORT INTEGER NOT NULL DEFAULT 0, CHECK (delicate_data IN ( 0, 1)))");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sensor (_id INTEGER PRIMARY KEY AUTOINCREMENT, deviceId INTEGER NOT NULL, sensorTypeId INTEGER NOT NULL, resolution REAL, minimumDelay UNSIGNED INTEGER, maximumRange REAL, name TEXT, sensorId UNSIGNED INTEGER NOT NULL, sensorInterrupt SHORT INTEGER NOT NULL DEFAULT 0, CHECK (sensorInterrupt IN ( 0, 1)), FOREIGN KEY(deviceId) REFERENCES device(_id), FOREIGN KEY(sensorTypeId) REFERENCES sensor_type(_id))");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS sensor_device_id_idx ON sensor(deviceId);");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS sensor_sensor_type_id_idx ON sensor(sensorTypeId);");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS led (_id INTEGER PRIMARY KEY AUTOINCREMENT, deviceId INTEGER NOT NULL, colors INTEGER NOT NULL, FOREIGN KEY(deviceId) REFERENCES device(_id))");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS led_device_id_idx ON led(deviceId);");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS keypad (_id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT NOT NULL)");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS input (_id INTEGER PRIMARY KEY AUTOINCREMENT, deviceId INTEGER NOT NULL, keyPadId INTEGER NOT NULL, enabled SHORT INTEGER NOT NULL DEFAULT 0, CHECK (enabled IN (0,1)), FOREIGN KEY(deviceId) REFERENCES device(_id), FOREIGN KEY(keyPadId) REFERENCES keypad(_id))");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS input_device_id_idx ON input(deviceId);");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS input_keypad_id_idx ON input(keyPadId);");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS device_hostapp_id_insert_fk BEFORE INSERT ON device FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table device violates foreign key constraint hostAppId') WHERE  (SELECT _id FROM host_application WHERE _id = NEW.hostAppId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS device_hostapp_id_update_fk BEFORE UPDATE ON device FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table device violates foreign key constraint hostAppId') WHERE  (SELECT _id FROM host_application WHERE _id = NEW.hostAppId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS device_hostapp_id_delete_fk BEFORE DELETE ON host_application FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table host_application violates foreign key constraint hostAppId') WHERE  (SELECT hostAppId FROM device WHERE hostAppId = OLD._id) IS NOT NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS display_device_insert_fk BEFORE INSERT ON display FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table display violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS display_device_update_fk BEFORE UPDATE ON display FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table display violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS display_device_delete_fk BEFORE DELETE ON device FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table device violates foreign key constraint deviceId') WHERE  (SELECT deviceId FROM display WHERE deviceId = OLD._id) IS NOT NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS led_device_insert_fk BEFORE INSERT ON led FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table led violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS led_device_update_fk BEFORE UPDATE ON led FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table led violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS led_device_delete_fk BEFORE DELETE ON device FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table device violates foreign key constraint deviceId') WHERE  (SELECT deviceId FROM led WHERE deviceId = OLD._id) IS NOT NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS input_device_insert_fk BEFORE INSERT ON input FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table input violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS input_device_update_fk BEFORE UPDATE ON input FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table input violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS input_device_delete_fk BEFORE DELETE ON device FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table device violates foreign key constraint deviceId') WHERE  (SELECT deviceId FROM input WHERE deviceId = OLD._id) IS NOT NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS sensor_device_insert_fk BEFORE INSERT ON sensor FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table sensor violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS sensor_device_update_fk BEFORE UPDATE ON sensor FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'update on table sensor violates foreign key constraint deviceId') WHERE  (SELECT _id FROM device WHERE _id = NEW.deviceId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS sensor_device_delete_fk BEFORE DELETE ON device FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table device violates foreign key constraint deviceId') WHERE  (SELECT deviceId FROM sensor WHERE deviceId = OLD._id) IS NOT NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS sensor_sensor_type_insert_fk BEFORE INSERT ON sensor FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table sensor violates foreign key constraint sensorTypeId') WHERE  (SELECT _id FROM sensor_type WHERE _id = NEW.sensorTypeId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS sensor_sensor_type_update_fk BEFORE UPDATE ON sensor FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table sensor violates foreign key constraint sensorTypeId') WHERE  (SELECT _id FROM sensor_type WHERE _id = NEW.sensorTypeId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS sensor_sensor_type_delete_fk BEFORE DELETE ON sensor_type FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table sensor_type violates foreign key constraint sensorTypeId') WHERE  (SELECT sensorTypeId FROM sensor WHERE sensorTypeId = OLD._id) IS NOT NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS input_key_pad_insert_fk BEFORE INSERT ON input FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table input violates foreign key constraint keyPadId') WHERE  (SELECT _id FROM keypad WHERE _id = NEW.keyPadId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS input_key_pad_update_fk BEFORE UPDATE ON input FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'insert on table input violates foreign key constraint keyPadId') WHERE  (SELECT _id FROM keypad WHERE _id = NEW.keyPadId) IS NULL; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS input_key_pad_delete_fk BEFORE DELETE ON keypad FOR EACH ROW BEGIN SELECT RAISE(ROLLBACK, 'delete on table keypad violates foreign key constraint keyPadId') WHERE  (SELECT keyPadId FROM input WHERE keyPadId = OLD._id) IS NOT NULL; END;");
      paramSQLiteDatabase.execSQL(CAPABILITIES_VIEW_SQL);
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS permission_request (_id INTEGER PRIMARY KEY AUTOINCREMENT, packageName TEXT UNIQUE NOT NULL, permissionRequested UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, permissionGranted UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0 )");
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
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS registration_extension_id_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS registration_extension_id_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS registration_extension_id_delete_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS device_hostapp_id_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS device_hostapp_id_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS device_hostapp_id_delete_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS display_device_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS display_device_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS display_device_delete_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS sensor_device_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS sensor_device_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS sensor_device_delete_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS sensor_sensor_type_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS sensor_sensor_type_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS sensor_sensor_type_delete_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS led_device_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS led_device_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS led_device_delete_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS input_device_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS input_device_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS input_device_delete_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS input_key_pad_insert_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS input_key_pad_update_fk");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS input_key_pad_delete_fk");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS registration_extension_hostapp_index");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS device_hostapp_id_idx");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS display_device_id_idx");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS sensor_device_id_idx");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS sensor_sensor_type_id_idx");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS led_device_id_idx");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS input_device_id_idx");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS input_keypad_id_idx");
    paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS input_keypad_id_idx");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS extension");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS registration");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS host_application");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS device");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS display");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS sensor");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS led");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS input");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS sensor_type");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS keypad");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS permission_request");
    onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 1;
    if (i > paramInt2) {
      return;
    }
    switch (i)
    {
    }
    for (;;)
    {
      i++;
      break;
      try
      {
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS permission_request");
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS permission_request (_id INTEGER PRIMARY KEY AUTOINCREMENT, packageName TEXT UNIQUE NOT NULL, permissionRequested UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0, permissionGranted UNSIGNED SHORT INTEGER NOT NULL DEFAULT 0 )");
      }
      catch (SQLiteException localSQLiteException)
      {
        localSQLiteException.printStackTrace();
      }
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.registration.provider.RegistrationDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */