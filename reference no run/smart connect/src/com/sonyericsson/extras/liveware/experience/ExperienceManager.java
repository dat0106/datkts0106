package com.sonyericsson.extras.liveware.experience;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import com.sonyericsson.extras.liveware.db.ExperienceDatabaseHelper;
import com.sonyericsson.extras.liveware.db.ExperienceDef.ActionSetTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.ActionTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.DeviceTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.ExperienceTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.FeatureTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.LocationTriggerTable;
import com.sonyericsson.extras.liveware.db.ExperienceDef.TimeTriggerTable;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ExperienceManager
{
  private static SQLiteDatabase sDatabase;
  private static Map<Context, ExperienceManager> sInstanceMap = new HashMap();
  private ContentResolver mContentResolver;
  private Context mContext;
  
  private ExperienceManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.mContentResolver = paramContext.getContentResolver();
  }
  
  private static String[] args(Object... paramVarArgs)
  {
    String[] arrayOfString = new String[paramVarArgs.length];
    for (int i = 0; i < arrayOfString.length; i++) {
      arrayOfString[i] = String.valueOf(paramVarArgs[i]);
    }
    return arrayOfString;
  }
  
  private void deleteFile(String paramString)
  {
    File localFile = new File(paramString);
    if ((localFile != null) && (!localFile.delete()) && (Dbg.w())) {
      Dbg.w("Failed to delete file: " + paramString);
    }
  }
  
  private ArrayList<Device> devicesFromCursor(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = null;
    if (paramCursor != null) {
      for (;;)
      {
        for (;;)
        {
          Object localObject3;
          boolean bool1;
          boolean bool3;
          boolean bool2;
          try
          {
            if (!paramCursor.moveToNext()) {
              break label406;
            }
            String str1 = paramCursor.getString(paramCursor.getColumnIndex("product_id"));
            String str2 = paramCursor.getString(paramCursor.getColumnIndex("device_name"));
            localObject3 = paramCursor.getString(paramCursor.getColumnIndex("iconName"));
            int i = paramCursor.getInt(paramCursor.getColumnIndex("bearer_type"));
            int j = paramCursor.getInt(paramCursor.getColumnIndex("type"));
            if (paramCursor.getInt(paramCursor.getColumnIndex("connected")) == 1)
            {
              bool1 = true;
              if (paramCursor.getInt(paramCursor.getColumnIndex("removable")) != 1) {
                continue;
              }
              bool3 = true;
              if (paramCursor.getInt(paramCursor.getColumnIndex("notify_external")) != 1) {
                continue;
              }
              bool2 = true;
              localObject3 = new Device(str1, str2, (String)localObject3, i, j, bool1, bool3, bool2, paramCursor.getString(paramCursor.getColumnIndex("iconLargeName")), paramCursor.getLong(paramCursor.getColumnIndex("timestamp")), paramCursor.getString(paramCursor.getColumnIndex("device_key")), paramCursor.getInt(paramCursor.getColumnIndex("configured")), paramCursor.getString(paramCursor.getColumnIndex("device_page_activity")), paramCursor.getInt(paramCursor.getColumnIndex("manufacturer")), paramCursor.getLong(paramCursor.getColumnIndex("cookie")));
            }
          }
          catch (SQLException localSQLException1) {}
          try
          {
            ((Device)localObject3).setId(paramCursor.getLong(paramCursor.getColumnIndex("_id")));
            ((Device)localObject3).setEducationLevel(paramCursor.getInt(paramCursor.getColumnIndex("education_level")));
            localObject2 = getFeatures((Device)localObject3);
            if (((ArrayList)localObject2).size() > 0) {
              ((Device)localObject3).addFeatures((List)localObject2);
            }
            localArrayList.add(localObject3);
            localObject2 = localObject3;
          }
          catch (SQLException localSQLException2)
          {
            label384:
            Object localObject1;
            break label384;
          }
        }
        bool1 = false;
        continue;
        bool3 = false;
        continue;
        bool2 = false;
        continue;
        if (Dbg.e()) {
          Dbg.e("Error when fetching a device", localSQLException1);
        }
        return null;
      }
    }
    label406:
    return localSQLException2;
  }
  
  private Experience experienceFromCursor(Cursor paramCursor)
  {
    Device localDevice = getDeviceById(paramCursor.getLong(paramCursor.getColumnIndex("deviceId")));
    Time localTime = getTime(paramCursor.getLong(paramCursor.getColumnIndex("timeId")));
    Location localLocation = getLocation(paramCursor.getLong(paramCursor.getColumnIndex("locationId")));
    String str1 = paramCursor.getString(paramCursor.getColumnIndex("name"));
    String str2 = paramCursor.getString(paramCursor.getColumnIndex("pictureName"));
    long l1 = paramCursor.getLong(paramCursor.getColumnIndex("timestamp"));
    int i = paramCursor.getInt(paramCursor.getColumnIndex("enabled_state"));
    boolean bool1;
    if (paramCursor.getInt(paramCursor.getColumnIndex("name_changed_by_user")) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    long l2 = paramCursor.getLong(paramCursor.getColumnIndex("stop_timestamp"));
    boolean bool2;
    if (paramCursor.getInt(paramCursor.getColumnIndex("started")) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Experience localExperience = new Experience(str1, str2, localDevice, localLocation, localTime, l1, i, bool1, l2, bool2, paramCursor.getString(paramCursor.getColumnIndex("name_resource")));
    localExperience.setId(paramCursor.getLong(paramCursor.getColumnIndex("_id")));
    localExperience.setStartActions(getActionSetByType(localExperience.getId(), 0));
    localExperience.setStopActions(getActionSetByType(localExperience.getId(), 1));
    return localExperience;
  }
  
  private Action getActionFromCursor(Cursor paramCursor)
  {
    try
    {
      localObject = UUID.fromString(paramCursor.getString(paramCursor.getColumnIndex("UUID")));
      localObject = new Action(paramCursor.getString(paramCursor.getColumnIndex("name")), paramCursor.getString(paramCursor.getColumnIndex("class")), paramCursor.getString(paramCursor.getColumnIndex("package")), (UUID)localObject, paramCursor.getString(paramCursor.getColumnIndex("iconUri")), paramCursor.getString(paramCursor.getColumnIndex("activity")), paramCursor.getInt(paramCursor.getColumnIndex("category")));
      ((Action)localObject).setId(paramCursor.getLong(paramCursor.getColumnIndex("_id")));
      if (paramCursor.getInt(paramCursor.getColumnIndex("disabled")) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((Action)localObject).setDisabled(bool);
        return localObject;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Dbg.e("Malformed UUID");
        localObject = null;
      }
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Dbg.e("Error querying action table");
        Object localObject = null;
      }
    }
  }
  
  private Action getActionFromQuery(String paramString, String[] paramArrayOfString)
  {
    localCursor = null;
    Action localAction = null;
    try
    {
      localCursor = this.mContentResolver.query(ExperienceDef.ActionTable.URI, null, paramString, paramArrayOfString, null);
      if ((localCursor != null) && (localCursor.moveToFirst()))
      {
        localAction = getActionFromCursor(localCursor);
        localAction = localAction;
      }
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Dbg.e("Error getActionFromQuery");
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
    finally
    {
      if (localCursor == null) {
        break label90;
      }
      localCursor.close();
    }
    return localAction;
  }
  
  private List<ActionSet> getActionSetByQuery(String paramString, String[] paramArrayOfString)
  {
    localCursor = null;
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        localCursor = this.mContentResolver.query(ExperienceDef.ActionSetTable.URI, null, paramString, paramArrayOfString, "position ASC");
        if (localCursor != null)
        {
          boolean bool = localCursor.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (SQLException localSQLException)
      {
        ActionSet localActionSet;
        Dbg.e("getActionSetByQuery failed query.");
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        continue;
      }
      finally
      {
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      return localArrayList;
      localActionSet = getActionSetFromCursor(localCursor);
      if (localActionSet != null) {
        localArrayList.add(localActionSet);
      }
    }
  }
  
  /* Error */
  private ActionSet getActionSetFromCursor(Cursor paramCursor)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_1
    //   3: ldc_w 308
    //   6: invokeinterface 94 2 0
    //   11: invokeinterface 126 2 0
    //   16: invokevirtual 312	com/sonyericsson/extras/liveware/experience/ExperienceManager:getActionById	(J)Lcom/sonyericsson/extras/liveware/experience/Action;
    //   19: astore_3
    //   20: aload_1
    //   21: aload_1
    //   22: ldc 235
    //   24: invokeinterface 94 2 0
    //   29: invokeinterface 98 2 0
    //   34: invokestatic 241	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
    //   37: astore_2
    //   38: new 314	com/sonyericsson/extras/liveware/experience/ActionSet
    //   41: dup
    //   42: aload_3
    //   43: aload_1
    //   44: aload_1
    //   45: ldc_w 316
    //   48: invokeinterface 94 2 0
    //   53: invokeinterface 126 2 0
    //   58: aload_1
    //   59: aload_1
    //   60: ldc_w 318
    //   63: invokeinterface 94 2 0
    //   68: invokeinterface 108 2 0
    //   73: aload_1
    //   74: aload_1
    //   75: ldc_w 320
    //   78: invokeinterface 94 2 0
    //   83: invokeinterface 108 2 0
    //   88: aload_1
    //   89: aload_1
    //   90: ldc_w 322
    //   93: invokeinterface 94 2 0
    //   98: invokeinterface 98 2 0
    //   103: aload_1
    //   104: aload_1
    //   105: ldc_w 324
    //   108: invokeinterface 94 2 0
    //   113: invokeinterface 98 2 0
    //   118: aload_2
    //   119: aload_1
    //   120: aload_1
    //   121: ldc_w 326
    //   124: invokeinterface 94 2 0
    //   129: invokeinterface 108 2 0
    //   134: invokespecial 329	com/sonyericsson/extras/liveware/experience/ActionSet:<init>	(Lcom/sonyericsson/extras/liveware/experience/Action;JIILjava/lang/String;Ljava/lang/String;Ljava/util/UUID;I)V
    //   137: astore_2
    //   138: aload_2
    //   139: aload_1
    //   140: aload_1
    //   141: ldc 141
    //   143: invokeinterface 94 2 0
    //   148: invokeinterface 126 2 0
    //   153: invokevirtual 330	com/sonyericsson/extras/liveware/experience/ActionSet:setId	(J)V
    //   156: aload_2
    //   157: astore_2
    //   158: aload_2
    //   159: areturn
    //   160: pop
    //   161: ldc_w 269
    //   164: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   167: pop
    //   168: aconst_null
    //   169: astore_2
    //   170: goto -12 -> 158
    //   173: pop
    //   174: ldc_w 332
    //   177: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   180: pop
    //   181: aconst_null
    //   182: astore_2
    //   183: goto -25 -> 158
    //   186: pop
    //   187: goto -13 -> 174
    //   190: pop
    //   191: goto -30 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	ExperienceManager
    //   0	194	1	paramCursor	Cursor
    //   37	146	2	localObject	Object
    //   19	24	3	localAction	Action
    //   160	1	4	localSQLException1	SQLException
    //   173	1	5	localIllegalArgumentException1	IllegalArgumentException
    //   186	1	6	localIllegalArgumentException2	IllegalArgumentException
    //   190	1	7	localSQLException2	SQLException
    // Exception table:
    //   from	to	target	type
    //   0	138	160	android/database/SQLException
    //   0	138	173	java/lang/IllegalArgumentException
    //   138	156	186	java/lang/IllegalArgumentException
    //   138	156	190	android/database/SQLException
  }
  
  private ContentProviderOperation getDeviceDeleteOperation(long paramLong)
  {
    ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newDelete(ExperienceDef.DeviceTable.URI);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    localBuilder.withSelection("_id=?", args(arrayOfObject));
    return localBuilder.build();
  }
  
  private ContentProviderOperation getDeviceUpdateOperation(Device.DeviceEditor paramDeviceEditor)
  {
    Object localObject1 = ContentProviderOperation.newUpdate(ExperienceDef.DeviceTable.URI);
    Object localObject2 = new ContentValues();
    Object localObject3 = paramDeviceEditor.editedConnected();
    if (localObject3 == null)
    {
      localObject3 = paramDeviceEditor.editedTimestamp();
      if (localObject3 != null) {
        ((ContentValues)localObject2).put("timestamp", (Long)localObject3);
      }
    }
    else
    {
      int i;
      if (!((Boolean)localObject3).booleanValue()) {
        i = 0;
      } else {
        i = 1;
      }
      ((ContentValues)localObject2).put("connected", Integer.valueOf(i));
      if (((Boolean)localObject3).booleanValue()) {
        ((ContentValues)localObject2).put("timestamp", Long.valueOf(System.currentTimeMillis()));
      }
    }
    localObject3 = paramDeviceEditor.editedEducationLevel();
    if (localObject3 != null) {
      ((ContentValues)localObject2).put("education_level", Integer.valueOf(((Integer)localObject3).intValue()));
    }
    if (paramDeviceEditor.isUserDefNameChanged())
    {
      ((ContentValues)localObject2).put("device_name", paramDeviceEditor.getProductName());
      ((ContentValues)localObject2).put("user_defined_name_changed", Integer.valueOf(1));
    }
    if (paramDeviceEditor.isProductNameChanged())
    {
      ((ContentValues)localObject2).put("device_name", paramDeviceEditor.getProductName());
      ((ContentValues)localObject2).put("user_defined_name_changed", Integer.valueOf(0));
    }
    if (paramDeviceEditor.isKeyIdChanged()) {
      ((ContentValues)localObject2).put("device_key", paramDeviceEditor.getKeyId());
    }
    if (paramDeviceEditor.isProductIdChanged()) {
      ((ContentValues)localObject2).put("product_id", paramDeviceEditor.getProductId());
    }
    if (paramDeviceEditor.isIconNameChanged()) {
      ((ContentValues)localObject2).put("iconName", paramDeviceEditor.getIconName());
    }
    if (paramDeviceEditor.isLargeIconNameChanged()) {
      ((ContentValues)localObject2).put("iconLargeName", paramDeviceEditor.getLargeIconName());
    }
    if (paramDeviceEditor.isConfiguredChanged()) {
      ((ContentValues)localObject2).put("configured", Integer.valueOf(paramDeviceEditor.getConfigured()));
    }
    if (paramDeviceEditor.isDevicePageActivityChanged()) {
      ((ContentValues)localObject2).put("device_page_activity", paramDeviceEditor.getDevicePageActivity());
    }
    if (paramDeviceEditor.isManufacturerChanged()) {
      ((ContentValues)localObject2).put("manufacturer", Integer.valueOf(paramDeviceEditor.getManufacturer()));
    }
    if (paramDeviceEditor.isCookieChanged()) {
      ((ContentValues)localObject2).put("cookie", Long.valueOf(paramDeviceEditor.getCookie()));
    }
    if (((ContentValues)localObject2).size() != 0)
    {
      ((ContentProviderOperation.Builder)localObject1).withValues((ContentValues)localObject2);
      localObject2 = new Object[1];
      localObject2[0] = Long.valueOf(paramDeviceEditor.getId());
      ((ContentProviderOperation.Builder)localObject1).withSelection("_id=?", args((Object[])localObject2));
      localObject1 = ((ContentProviderOperation.Builder)localObject1).build();
    }
    else
    {
      localObject1 = null;
    }
    return localObject1;
  }
  
  private ArrayList<Device> getDevicesFromQuery(String paramString, String[] paramArrayOfString)
  {
    localCursor = null;
    try
    {
      localCursor = this.mContentResolver.query(ExperienceDef.DeviceTable.URI, null, paramString, paramArrayOfString, null);
      localArrayList = devicesFromCursor(localCursor);
      localArrayList = localArrayList;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Dbg.e("Error getDeviceFromQuery");
        if (localCursor != null) {
          localCursor.close();
        }
        ArrayList localArrayList = new ArrayList();
      }
    }
    finally
    {
      if (localCursor == null) {
        break label83;
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  private ArrayList<Experience> getExperiencesFromQuery(String paramString, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    localCursor = null;
    for (;;)
    {
      try
      {
        localCursor = this.mContentResolver.query(ExperienceDef.ExperienceTable.URI, null, paramString, paramArrayOfString, "_id DESC");
        if (localCursor != null)
        {
          boolean bool = localCursor.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (SQLException localSQLException)
      {
        Dbg.e("Error getExperiencesFromQuery");
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        continue;
      }
      finally
      {
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      return localArrayList;
      localArrayList.add(experienceFromCursor(localCursor));
    }
  }
  
  private ContentProviderOperation getFeatureDeleteOperation(long paramLong)
  {
    ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newDelete(ExperienceDef.FeatureTable.URI);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    localBuilder.withSelection("_id=?", args(arrayOfObject));
    return localBuilder.build();
  }
  
  private ContentProviderOperation getFeatureInsertOnDeviceIdOperation(long paramLong, Feature paramFeature)
  {
    ContentProviderOperation.Builder localBuilder = getFeatureInsertOperationBuilder(paramFeature);
    localBuilder.withValue("device_id", Long.valueOf(paramLong));
    return localBuilder.build();
  }
  
  private ContentProviderOperation.Builder getFeatureInsertOperationBuilder(Feature paramFeature)
  {
    ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newInsert(ExperienceDef.FeatureTable.URI);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("type", Integer.valueOf(paramFeature.getType()));
    localContentValues.put("enabled", Integer.valueOf(paramFeature.getState()));
    localContentValues.put("app_selection", Integer.valueOf(paramFeature.getAppSelection()));
    localContentValues.put("modified_by_user", Boolean.valueOf(paramFeature.isModifiedByUser()));
    localContentValues.put("package_name", paramFeature.getPackageName());
    localContentValues.put("class_name", paramFeature.getClassName());
    localContentValues.put("intent", paramFeature.getIntent());
    localContentValues.put("companion_name", paramFeature.getCompanionName());
    localContentValues.put("companion_pkg", paramFeature.getCompanionPkg());
    localBuilder.withValues(localContentValues);
    return localBuilder;
  }
  
  /* Error */
  private ArrayList<Feature> getFeatures(Device paramDevice)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 82	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 83	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 4
    //   13: aload_0
    //   14: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   17: astore 6
    //   19: getstatic 497	com/sonyericsson/extras/liveware/db/ExperienceDef$FeatureTable:URI	Landroid/net/Uri;
    //   22: astore 5
    //   24: iconst_1
    //   25: anewarray 41	java/lang/String
    //   28: astore 7
    //   30: aload 7
    //   32: iconst_0
    //   33: aload_1
    //   34: invokevirtual 564	com/sonyericsson/extras/liveware/experience/Device:getId	()J
    //   37: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   40: aastore
    //   41: aload 6
    //   43: aload 5
    //   45: aconst_null
    //   46: ldc_w 569
    //   49: aload 7
    //   51: aconst_null
    //   52: invokevirtual 283	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnull +16 -> 73
    //   60: aload_2
    //   61: invokeinterface 88 1 0
    //   66: istore 5
    //   68: iload 5
    //   70: ifne +18 -> 88
    //   73: aload_2
    //   74: ifnull +9 -> 83
    //   77: aload_2
    //   78: invokeinterface 291 1 0
    //   83: aload 4
    //   85: pop
    //   86: aload_3
    //   87: areturn
    //   88: aload_2
    //   89: aload_2
    //   90: ldc 110
    //   92: invokeinterface 94 2 0
    //   97: invokeinterface 108 2 0
    //   102: istore 5
    //   104: aload_2
    //   105: aload_2
    //   106: ldc_w 540
    //   109: invokeinterface 94 2 0
    //   114: invokeinterface 573 2 0
    //   119: ifeq +180 -> 299
    //   122: aconst_null
    //   123: astore 9
    //   125: aload_2
    //   126: aload_2
    //   127: ldc_w 545
    //   130: invokeinterface 94 2 0
    //   135: invokeinterface 573 2 0
    //   140: ifeq +179 -> 319
    //   143: aconst_null
    //   144: astore 10
    //   146: aload_2
    //   147: aload_2
    //   148: ldc_w 550
    //   151: invokeinterface 94 2 0
    //   156: invokeinterface 98 2 0
    //   161: astore 6
    //   163: aload_2
    //   164: aload_2
    //   165: ldc_w 524
    //   168: invokeinterface 94 2 0
    //   173: invokeinterface 108 2 0
    //   178: istore 7
    //   180: aload_2
    //   181: aload_2
    //   182: ldc_w 555
    //   185: invokeinterface 94 2 0
    //   190: invokeinterface 573 2 0
    //   195: ifeq +144 -> 339
    //   198: aconst_null
    //   199: astore 8
    //   201: aload_2
    //   202: aload_2
    //   203: ldc_w 560
    //   206: invokeinterface 94 2 0
    //   211: invokeinterface 573 2 0
    //   216: ifeq +143 -> 359
    //   219: aconst_null
    //   220: astore 11
    //   222: new 514	com/sonyericsson/extras/liveware/experience/Feature
    //   225: dup
    //   226: aload_1
    //   227: iload 5
    //   229: aload 9
    //   231: aload 10
    //   233: aload 6
    //   235: iload 7
    //   237: aload 8
    //   239: aload 11
    //   241: invokespecial 576	com/sonyericsson/extras/liveware/experience/Feature:<init>	(Lcom/sonyericsson/extras/liveware/experience/Device;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   244: astore 4
    //   246: aload 4
    //   248: aload_2
    //   249: aload_2
    //   250: ldc 141
    //   252: invokeinterface 94 2 0
    //   257: invokeinterface 126 2 0
    //   262: invokevirtual 577	com/sonyericsson/extras/liveware/experience/Feature:setId	(J)V
    //   265: aload 4
    //   267: aload_2
    //   268: aload_2
    //   269: ldc_w 519
    //   272: invokeinterface 94 2 0
    //   277: invokeinterface 108 2 0
    //   282: invokevirtual 580	com/sonyericsson/extras/liveware/experience/Feature:setState	(I)V
    //   285: aload_3
    //   286: aload 4
    //   288: invokevirtual 167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   291: pop
    //   292: aload 4
    //   294: astore 4
    //   296: goto -240 -> 56
    //   299: aload_2
    //   300: aload_2
    //   301: ldc_w 540
    //   304: invokeinterface 94 2 0
    //   309: invokeinterface 98 2 0
    //   314: astore 9
    //   316: goto -191 -> 125
    //   319: aload_2
    //   320: aload_2
    //   321: ldc_w 545
    //   324: invokeinterface 94 2 0
    //   329: invokeinterface 98 2 0
    //   334: astore 10
    //   336: goto -190 -> 146
    //   339: aload_2
    //   340: aload_2
    //   341: ldc_w 555
    //   344: invokeinterface 94 2 0
    //   349: invokeinterface 98 2 0
    //   354: astore 8
    //   356: goto -155 -> 201
    //   359: aload_2
    //   360: aload_2
    //   361: ldc_w 560
    //   364: invokeinterface 94 2 0
    //   369: invokeinterface 98 2 0
    //   374: astore 11
    //   376: aload 11
    //   378: astore 11
    //   380: goto -158 -> 222
    //   383: astore 5
    //   385: aload 4
    //   387: pop
    //   388: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   391: ifeq +12 -> 403
    //   394: ldc_w 582
    //   397: aload 5
    //   399: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   402: pop
    //   403: aload_2
    //   404: ifnull -318 -> 86
    //   407: aload_2
    //   408: invokeinterface 291 1 0
    //   413: goto -327 -> 86
    //   416: astore_3
    //   417: aload 4
    //   419: pop
    //   420: aload_2
    //   421: ifnull +9 -> 430
    //   424: aload_2
    //   425: invokeinterface 291 1 0
    //   430: aload_3
    //   431: athrow
    //   432: astore_3
    //   433: goto -13 -> 420
    //   436: astore 5
    //   438: goto -50 -> 388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	ExperienceManager
    //   0	441	1	paramDevice	Device
    //   1	424	2	localCursor	Cursor
    //   9	277	3	localArrayList	ArrayList
    //   416	15	3	localObject1	Object
    //   432	1	3	localObject2	Object
    //   11	407	4	localFeature	Feature
    //   22	22	5	localUri	Uri
    //   66	3	5	bool	boolean
    //   102	126	5	i	int
    //   383	15	5	localSQLException1	SQLException
    //   436	1	5	localSQLException2	SQLException
    //   17	217	6	localObject3	Object
    //   28	22	7	arrayOfString	String[]
    //   178	58	7	j	int
    //   199	156	8	str1	String
    //   123	192	9	str2	String
    //   144	191	10	str3	String
    //   220	159	11	str4	String
    // Exception table:
    //   from	to	target	type
    //   13	68	383	android/database/SQLException
    //   88	246	383	android/database/SQLException
    //   299	376	383	android/database/SQLException
    //   13	68	416	finally
    //   88	246	416	finally
    //   299	376	416	finally
    //   246	292	432	finally
    //   388	403	432	finally
    //   246	292	436	android/database/SQLException
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public static ExperienceManager getInstance(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual 590	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   7: astore_2
    //   8: aload_2
    //   9: instanceof 592
    //   12: istore_1
    //   13: iload_1
    //   14: ifeq +5 -> 19
    //   17: aload_2
    //   18: astore_0
    //   19: getstatic 25	com/sonyericsson/extras/liveware/experience/ExperienceManager:sInstanceMap	Ljava/util/Map;
    //   22: aload_0
    //   23: invokeinterface 598 2 0
    //   28: checkcast 2	com/sonyericsson/extras/liveware/experience/ExperienceManager
    //   31: astore_1
    //   32: aload_1
    //   33: ifnonnull +23 -> 56
    //   36: new 2	com/sonyericsson/extras/liveware/experience/ExperienceManager
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 600	com/sonyericsson/extras/liveware/experience/ExperienceManager:<init>	(Landroid/content/Context;)V
    //   44: astore_1
    //   45: getstatic 25	com/sonyericsson/extras/liveware/experience/ExperienceManager:sInstanceMap	Ljava/util/Map;
    //   48: aload_0
    //   49: aload_1
    //   50: invokeinterface 603 3 0
    //   55: pop
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: pop
    //   68: goto -49 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramContext	Context
    //   12	2	1	bool	boolean
    //   31	29	1	localExperienceManager	ExperienceManager
    //   61	5	1	localObject	Object
    //   7	11	2	localContext	Context
    //   67	1	5	localUnsupportedOperationException	java.lang.UnsupportedOperationException
    // Exception table:
    //   from	to	target	type
    //   3	13	61	finally
    //   19	56	61	finally
    //   3	13	67	java/lang/UnsupportedOperationException
  }
  
  private Location getLocation(long paramLong)
  {
    Cursor localCursor = null;
    label124:
    try
    {
      ContentResolver localContentResolver = this.mContentResolver;
      Uri localUri = ExperienceDef.LocationTriggerTable.URI;
      localObject1 = new String[1];
      localObject1[0] = String.valueOf(paramLong);
      localCursor = localContentResolver.query(localUri, null, "_id = ?", (String[])localObject1, null);
      if ((localCursor == null) || (!localCursor.moveToFirst())) {
        break label127;
      }
      localObject1 = locationFromCursor(localCursor);
      localObject1 = localObject1;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Object localObject1;
        if (Dbg.e()) {
          Dbg.e("Error getLocation", localSQLException);
        }
        if (localCursor != null) {
          localCursor.close();
        }
        localObject2 = null;
      }
    }
    finally
    {
      if (localCursor == null) {
        break label124;
      }
      localCursor.close();
    }
    return localObject1;
    for (;;)
    {
      Object localObject2;
      label127:
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
  
  private Location locationFromCursor(Cursor paramCursor)
  {
    int i = 1;
    String str3 = paramCursor.getString(paramCursor.getColumnIndex("name"));
    String str2 = paramCursor.getString(paramCursor.getColumnIndex("description"));
    Object localObject = paramCursor.getString(paramCursor.getColumnIndex("mac_address"));
    String str1 = paramCursor.getString(paramCursor.getColumnIndex("ssid"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("trigger_status")) != i) {
      i = 0;
    }
    localObject = new Location(str3, str2, (String)localObject, str1, i);
    ((Location)localObject).setId(paramCursor.getLong(paramCursor.getColumnIndex("_id")));
    return localObject;
  }
  
  private List<Time> queryTime(String paramString, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    localCursor = null;
    for (;;)
    {
      try
      {
        localCursor = this.mContentResolver.query(ExperienceDef.TimeTriggerTable.URI, null, paramString, paramArrayOfString, null);
        if (localCursor != null)
        {
          boolean bool = localCursor.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (SQLException localSQLException)
      {
        if (!Dbg.e()) {
          continue;
        }
        Dbg.e("Error getInitiators at", localSQLException);
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        continue;
      }
      finally
      {
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      return localArrayList;
      localArrayList.add(timeFromCursor(localCursor));
    }
  }
  
  /**
   * @deprecated
   */
  private void setDatabase()
  {
    try
    {
      if ((sDatabase == null) || (!sDatabase.isOpen())) {
        sDatabase = new ExperienceDatabaseHelper(this.mContext).getWritableDatabase();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private Time timeFromCursor(Cursor paramCursor)
  {
    int i = 1;
    long l1 = paramCursor.getLong(paramCursor.getColumnIndex("start_time"));
    long l2 = paramCursor.getLong(paramCursor.getColumnIndex("end_time"));
    if (paramCursor.getInt(paramCursor.getColumnIndex("trigger_status")) != i) {
      i = 0;
    }
    Time localTime = new Time(l1, l2, i, paramCursor.getInt(paramCursor.getColumnIndex("weekdays")));
    localTime.setId(paramCursor.getLong(paramCursor.getColumnIndex("_id")));
    return localTime;
  }
  
  /**
   * @deprecated
   */
  public void addAction(Action paramAction)
    throws ExperienceManager.EmException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramAction);
      addActions(localArrayList);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void addActionSet(ActionSet paramActionSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 82	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 83	java/util/ArrayList:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: aload_1
    //   12: invokevirtual 683	com/sonyericsson/extras/liveware/experience/ActionSet:getInsertOperation	()Landroid/content/ContentProviderOperation;
    //   15: invokevirtual 167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   18: pop
    //   19: aload_0
    //   20: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   23: ldc_w 685
    //   26: aload_2
    //   27: invokevirtual 689	android/content/ContentResolver:applyBatch	(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_2
    //   35: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   38: ifeq -7 -> 31
    //   41: ldc_w 691
    //   44: aload_2
    //   45: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   48: pop
    //   49: goto -18 -> 31
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    //   57: astore_2
    //   58: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   61: ifeq -30 -> 31
    //   64: ldc_w 691
    //   67: aload_2
    //   68: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   71: pop
    //   72: goto -41 -> 31
    //   75: astore_2
    //   76: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   79: ifeq -48 -> 31
    //   82: ldc_w 691
    //   85: aload_2
    //   86: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   89: pop
    //   90: goto -59 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	ExperienceManager
    //   0	93	1	paramActionSet	ActionSet
    //   9	18	2	localArrayList	ArrayList
    //   34	11	2	localOperationApplicationException	OperationApplicationException
    //   52	4	2	localObject	Object
    //   57	11	2	localRemoteException	RemoteException
    //   75	11	2	localSQLException	SQLException
    // Exception table:
    //   from	to	target	type
    //   19	31	34	android/content/OperationApplicationException
    //   2	19	52	finally
    //   19	31	52	finally
    //   35	49	52	finally
    //   58	90	52	finally
    //   19	31	57	android/os/RemoteException
    //   19	31	75	android/database/SQLException
  }
  
  /**
   * @deprecated
   */
  public void addActions(ArrayList<Action> paramArrayList)
    throws ExperienceManager.EmException
  {
    for (;;)
    {
      Object localObject2;
      ContentProviderResult[] arrayOfContentProviderResult;
      boolean bool2;
      try
      {
        ((ContentProviderResult[])null);
        localObject2 = new ArrayList();
        Iterator localIterator = paramArrayList.iterator();
        boolean bool1 = localIterator.hasNext();
        if (bool1) {}
      }
      finally {}
      try
      {
        arrayOfContentProviderResult = this.mContentResolver.applyBatch("com.sonyericsson.extras.liveware.asf.experience", (ArrayList)localObject2);
        i = 0;
        localObject2 = paramArrayList.iterator();
        bool2 = ((Iterator)localObject2).hasNext();
        if (bool2) {
          break label160;
        }
        return;
      }
      catch (OperationApplicationException localOperationApplicationException)
      {
        if (!Dbg.e()) {
          break label106;
        }
        Dbg.e("Error when adding an action", localOperationApplicationException);
        throw new EmException();
      }
      catch (RemoteException localRemoteException)
      {
        if (!Dbg.e()) {
          break label129;
        }
        Dbg.e("Error when adding an action", localRemoteException);
        throw new EmException();
      }
      catch (SQLException localSQLException)
      {
        label106:
        if (!Dbg.e()) {
          break label152;
        }
        label129:
        Dbg.e("Error when adding an action", localSQLException);
        label152:
        throw new EmException();
      }
      ((Action)i.next()).getInsertOperation((ArrayList)localObject2);
      continue;
      label160:
      int i = ((Action)((Iterator)localObject2).next()).unwrapContentProviderInsertResults(localSQLException, i);
      i = i;
    }
  }
  
  /**
   * @deprecated
   */
  public Device addDevice(Device paramDevice)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new ArrayList();
        paramDevice.getInsertOperation((ArrayList)localObject1);
        ((ContentProviderResult[])null);
        try
        {
          localObject1 = this.mContentResolver.applyBatch("com.sonyericsson.extras.liveware.asf.experience", (ArrayList)localObject1);
          paramDevice.unwrapContentProviderInsertResults((ContentProviderResult[])localObject1, 0);
        }
        catch (OperationApplicationException localOperationApplicationException)
        {
          if (!Dbg.e()) {
            break label104;
          }
          Dbg.e("Error when adding a device", localOperationApplicationException);
        }
        catch (RemoteException localRemoteException)
        {
          if (!Dbg.e()) {
            break label109;
          }
          Dbg.e("Error when adding a device", localRemoteException);
          break label109;
        }
        catch (SQLException localSQLException)
        {
          if (!Dbg.e()) {
            continue;
          }
          Dbg.e("Error when adding a device", localSQLException);
          paramDevice = null;
          continue;
        }
        return paramDevice;
      }
      finally {}
      label104:
      paramDevice = null;
      continue;
      label109:
      paramDevice = null;
    }
  }
  
  /**
   * @deprecated
   */
  public void addDevices(ArrayList<Device> paramArrayList)
    throws ExperienceManager.EmException
  {
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      int i;
      boolean bool;
      try
      {
        ((ContentProviderResult[])null);
        localObject1 = new ArrayList();
        localObject3 = paramArrayList.iterator();
        i = ((Iterator)localObject3).hasNext();
        if (i != 0) {}
      }
      finally {}
      try
      {
        localObject3 = this.mContentResolver.applyBatch("com.sonyericsson.extras.liveware.asf.experience", (ArrayList)localObject1);
        i = 0;
        localObject1 = paramArrayList.iterator();
        bool = ((Iterator)localObject1).hasNext();
        if (bool) {
          break label159;
        }
        return;
      }
      catch (OperationApplicationException localOperationApplicationException)
      {
        if (!Dbg.e()) {
          break label105;
        }
        Dbg.e("Error when adding a device", localOperationApplicationException);
        throw new EmException();
      }
      catch (RemoteException localRemoteException)
      {
        if (!Dbg.e()) {
          break label128;
        }
        Dbg.e("Error when adding a device", localRemoteException);
        throw new EmException();
      }
      catch (SQLException localSQLException)
      {
        if (!Dbg.e()) {
          break label151;
        }
        Dbg.e("Error when adding a device", localSQLException);
        throw new EmException();
      }
      ((Device)((Iterator)localObject3).next()).getInsertOperation((ArrayList)localObject1);
      continue;
      label105:
      int j = ((Device)localSQLException.next()).unwrapContentProviderInsertResults((ContentProviderResult[])localObject3, i);
      label128:
      label151:
      label159:
      j = j;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public Experience addExperience(Experience paramExperience)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 727
    //   5: lstore 6
    //   7: ldc2_w 727
    //   10: lstore 4
    //   12: iconst_0
    //   13: istore_2
    //   14: iconst_0
    //   15: istore_3
    //   16: aload_0
    //   17: invokespecial 730	com/sonyericsson/extras/liveware/experience/ExperienceManager:setDatabase	()V
    //   20: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   23: invokevirtual 733	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   26: iconst_1
    //   27: istore_3
    //   28: aload_1
    //   29: invokevirtual 736	com/sonyericsson/extras/liveware/experience/Experience:getTime	()Lcom/sonyericsson/extras/liveware/experience/Time;
    //   32: astore 8
    //   34: aload 8
    //   36: ifnull +50 -> 86
    //   39: aload 8
    //   41: invokevirtual 737	com/sonyericsson/extras/liveware/experience/Time:getId	()J
    //   44: lstore 6
    //   46: lload 6
    //   48: ldc2_w 727
    //   51: lcmp
    //   52: ifne +391 -> 443
    //   55: aload 8
    //   57: invokevirtual 741	com/sonyericsson/extras/liveware/experience/Time:getInsertContentValues	()Landroid/content/ContentValues;
    //   60: astore 6
    //   62: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   65: ldc_w 743
    //   68: aconst_null
    //   69: aload 6
    //   71: invokevirtual 747	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   74: lstore 6
    //   76: aload 8
    //   78: lload 6
    //   80: invokevirtual 668	com/sonyericsson/extras/liveware/experience/Time:setId	(J)V
    //   83: goto +888 -> 971
    //   86: aload_1
    //   87: invokevirtual 750	com/sonyericsson/extras/liveware/experience/Experience:getLocation	()Lcom/sonyericsson/extras/liveware/experience/Location;
    //   90: astore 9
    //   92: aload 9
    //   94: ifnull +47 -> 141
    //   97: aload 9
    //   99: invokevirtual 751	com/sonyericsson/extras/liveware/experience/Location:getId	()J
    //   102: lstore 4
    //   104: aload 9
    //   106: invokevirtual 754	com/sonyericsson/extras/liveware/experience/Location:getContentValues	()Landroid/content/ContentValues;
    //   109: astore 8
    //   111: lload 4
    //   113: ldc2_w 727
    //   116: lcmp
    //   117: ifne +436 -> 553
    //   120: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   123: ldc_w 756
    //   126: aconst_null
    //   127: aload 8
    //   129: invokevirtual 747	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   132: lstore 4
    //   134: aload 9
    //   136: lload 4
    //   138: invokevirtual 628	com/sonyericsson/extras/liveware/experience/Location:setId	(J)V
    //   141: aload_1
    //   142: invokevirtual 757	com/sonyericsson/extras/liveware/experience/Experience:getInsertContentValues	()Landroid/content/ContentValues;
    //   145: astore 8
    //   147: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   150: ldc_w 759
    //   153: aconst_null
    //   154: aload 8
    //   156: invokevirtual 747	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   159: lstore 8
    //   161: aload_1
    //   162: lload 8
    //   164: invokevirtual 215	com/sonyericsson/extras/liveware/experience/Experience:setId	(J)V
    //   167: lload 8
    //   169: ldc2_w 727
    //   172: lcmp
    //   173: ifle +740 -> 913
    //   176: aload_1
    //   177: invokevirtual 763	com/sonyericsson/extras/liveware/experience/Experience:getStartActions	()Ljava/util/List;
    //   180: astore 10
    //   182: aload 10
    //   184: ifnull +22 -> 206
    //   187: aload 10
    //   189: invokeinterface 764 1 0
    //   194: astore 10
    //   196: aload 10
    //   198: invokeinterface 702 1 0
    //   203: ifne +436 -> 639
    //   206: aload_1
    //   207: invokevirtual 767	com/sonyericsson/extras/liveware/experience/Experience:getStopActions	()Ljava/util/List;
    //   210: astore 10
    //   212: aload 10
    //   214: ifnull +22 -> 236
    //   217: aload 10
    //   219: invokeinterface 764 1 0
    //   224: astore 10
    //   226: aload 10
    //   228: invokeinterface 702 1 0
    //   233: ifne +463 -> 696
    //   236: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   239: invokevirtual 770	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   242: lload 6
    //   244: ldc2_w 727
    //   247: lcmp
    //   248: ifle +29 -> 277
    //   251: getstatic 632	com/sonyericsson/extras/liveware/db/ExperienceDef$TimeTriggerTable:URI	Landroid/net/Uri;
    //   254: lload 6
    //   256: invokestatic 772	java/lang/Long:toString	(J)Ljava/lang/String;
    //   259: invokestatic 778	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   262: astore 6
    //   264: aload_0
    //   265: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   268: invokevirtual 35	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   271: aload 6
    //   273: aconst_null
    //   274: invokevirtual 782	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   277: lload 4
    //   279: ldc2_w 727
    //   282: lcmp
    //   283: ifle +29 -> 312
    //   286: getstatic 606	com/sonyericsson/extras/liveware/db/ExperienceDef$LocationTriggerTable:URI	Landroid/net/Uri;
    //   289: lload 4
    //   291: invokestatic 772	java/lang/Long:toString	(J)Ljava/lang/String;
    //   294: invokestatic 778	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   297: astore 4
    //   299: aload_0
    //   300: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   303: invokevirtual 35	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   306: aload 4
    //   308: aconst_null
    //   309: invokevirtual 782	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   312: getstatic 487	com/sonyericsson/extras/liveware/db/ExperienceDef$ExperienceTable:URI	Landroid/net/Uri;
    //   315: lload 8
    //   317: invokestatic 772	java/lang/Long:toString	(J)Ljava/lang/String;
    //   320: invokestatic 778	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   323: astore 4
    //   325: aload_0
    //   326: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   329: invokevirtual 35	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   332: aload 4
    //   334: aconst_null
    //   335: invokevirtual 782	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   338: aload_1
    //   339: invokevirtual 763	com/sonyericsson/extras/liveware/experience/Experience:getStartActions	()Ljava/util/List;
    //   342: astore 4
    //   344: aload 4
    //   346: ifnull +22 -> 368
    //   349: aload 4
    //   351: invokeinterface 764 1 0
    //   356: astore 4
    //   358: aload 4
    //   360: invokeinterface 702 1 0
    //   365: ifne +388 -> 753
    //   368: aload_1
    //   369: invokevirtual 767	com/sonyericsson/extras/liveware/experience/Experience:getStopActions	()Ljava/util/List;
    //   372: astore 4
    //   374: aload 4
    //   376: ifnull +26 -> 402
    //   379: aload 4
    //   381: invokeinterface 764 1 0
    //   386: astore 4
    //   388: aload 4
    //   390: invokeinterface 702 1 0
    //   395: istore 5
    //   397: iload 5
    //   399: ifne +407 -> 806
    //   402: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   405: astore 4
    //   407: aload 4
    //   409: ifnull +13 -> 422
    //   412: iload_3
    //   413: ifeq +9 -> 422
    //   416: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   419: invokevirtual 785	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   422: iload_2
    //   423: ifeq +16 -> 439
    //   426: aload_0
    //   427: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   430: invokestatic 790	com/sonyericsson/extras/liveware/utils/AsfTimeUtils:millisSinceMidnight	()J
    //   433: invokestatic 793	com/sonyericsson/extras/liveware/utils/AsfTimeUtils:getDayOfWeek	()I
    //   436: invokestatic 799	com/sonyericsson/extras/liveware/asf/TimeService:timeTriggerUpdated	(Landroid/content/Context;JI)V
    //   439: aload_0
    //   440: monitorexit
    //   441: aload_1
    //   442: areturn
    //   443: aload 8
    //   445: invokevirtual 802	com/sonyericsson/extras/liveware/experience/Time:getUpdateContentValues	()Landroid/content/ContentValues;
    //   448: astore 10
    //   450: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   453: astore 9
    //   455: iconst_1
    //   456: anewarray 41	java/lang/String
    //   459: astore 11
    //   461: aload 11
    //   463: iconst_0
    //   464: lload 6
    //   466: invokestatic 772	java/lang/Long:toString	(J)Ljava/lang/String;
    //   469: aastore
    //   470: aload 9
    //   472: ldc_w 743
    //   475: aload 10
    //   477: ldc_w 804
    //   480: aload 11
    //   482: invokevirtual 808	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   485: pop
    //   486: aload 8
    //   488: invokevirtual 811	com/sonyericsson/extras/liveware/experience/Time:resetChangedFlags	()V
    //   491: goto +480 -> 971
    //   494: astore 4
    //   496: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   499: ifeq +12 -> 511
    //   502: ldc_w 813
    //   505: aload 4
    //   507: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   510: pop
    //   511: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   514: astore 4
    //   516: aload 4
    //   518: ifnull +13 -> 531
    //   521: iload_3
    //   522: ifeq +9 -> 531
    //   525: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   528: invokevirtual 785	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   531: iload_2
    //   532: ifeq +16 -> 548
    //   535: aload_0
    //   536: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   539: invokestatic 790	com/sonyericsson/extras/liveware/utils/AsfTimeUtils:millisSinceMidnight	()J
    //   542: invokestatic 793	com/sonyericsson/extras/liveware/utils/AsfTimeUtils:getDayOfWeek	()I
    //   545: invokestatic 799	com/sonyericsson/extras/liveware/asf/TimeService:timeTriggerUpdated	(Landroid/content/Context;JI)V
    //   548: aconst_null
    //   549: astore_1
    //   550: goto -111 -> 439
    //   553: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   556: astore 10
    //   558: iconst_1
    //   559: anewarray 41	java/lang/String
    //   562: astore 9
    //   564: aload 9
    //   566: iconst_0
    //   567: lload 4
    //   569: invokestatic 772	java/lang/Long:toString	(J)Ljava/lang/String;
    //   572: aastore
    //   573: aload 10
    //   575: ldc_w 756
    //   578: aload 8
    //   580: ldc_w 804
    //   583: aload 9
    //   585: invokevirtual 808	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   588: pop
    //   589: goto -448 -> 141
    //   592: astore 4
    //   594: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   597: astore 5
    //   599: aload 5
    //   601: ifnull +13 -> 614
    //   604: iload_3
    //   605: ifeq +9 -> 614
    //   608: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   611: invokevirtual 785	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   614: iload_2
    //   615: ifeq +16 -> 631
    //   618: aload_0
    //   619: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   622: invokestatic 790	com/sonyericsson/extras/liveware/utils/AsfTimeUtils:millisSinceMidnight	()J
    //   625: invokestatic 793	com/sonyericsson/extras/liveware/utils/AsfTimeUtils:getDayOfWeek	()I
    //   628: invokestatic 799	com/sonyericsson/extras/liveware/asf/TimeService:timeTriggerUpdated	(Landroid/content/Context;JI)V
    //   631: aload 4
    //   633: athrow
    //   634: astore_2
    //   635: aload_0
    //   636: monitorexit
    //   637: aload_2
    //   638: athrow
    //   639: aload 10
    //   641: invokeinterface 706 1 0
    //   646: checkcast 314	com/sonyericsson/extras/liveware/experience/ActionSet
    //   649: astore 12
    //   651: aload 12
    //   653: invokevirtual 814	com/sonyericsson/extras/liveware/experience/ActionSet:getId	()J
    //   656: ldc2_w 727
    //   659: lcmp
    //   660: ifne -464 -> 196
    //   663: aload 12
    //   665: aload_1
    //   666: invokevirtual 818	com/sonyericsson/extras/liveware/experience/ActionSet:setExperience	(Lcom/sonyericsson/extras/liveware/experience/Experience;)V
    //   669: aload 12
    //   671: invokevirtual 819	com/sonyericsson/extras/liveware/experience/ActionSet:getContentValues	()Landroid/content/ContentValues;
    //   674: astore 11
    //   676: aload 12
    //   678: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   681: ldc_w 821
    //   684: aconst_null
    //   685: aload 11
    //   687: invokevirtual 747	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   690: invokevirtual 330	com/sonyericsson/extras/liveware/experience/ActionSet:setId	(J)V
    //   693: goto -497 -> 196
    //   696: aload 10
    //   698: invokeinterface 706 1 0
    //   703: checkcast 314	com/sonyericsson/extras/liveware/experience/ActionSet
    //   706: astore 11
    //   708: aload 11
    //   710: invokevirtual 814	com/sonyericsson/extras/liveware/experience/ActionSet:getId	()J
    //   713: ldc2_w 727
    //   716: lcmp
    //   717: ifne -491 -> 226
    //   720: aload 11
    //   722: aload_1
    //   723: invokevirtual 818	com/sonyericsson/extras/liveware/experience/ActionSet:setExperience	(Lcom/sonyericsson/extras/liveware/experience/Experience;)V
    //   726: aload 11
    //   728: invokevirtual 819	com/sonyericsson/extras/liveware/experience/ActionSet:getContentValues	()Landroid/content/ContentValues;
    //   731: astore 12
    //   733: aload 11
    //   735: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   738: ldc_w 821
    //   741: aconst_null
    //   742: aload 12
    //   744: invokevirtual 747	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   747: invokevirtual 330	com/sonyericsson/extras/liveware/experience/ActionSet:setId	(J)V
    //   750: goto -524 -> 226
    //   753: aload 4
    //   755: invokeinterface 706 1 0
    //   760: checkcast 314	com/sonyericsson/extras/liveware/experience/ActionSet
    //   763: invokevirtual 814	com/sonyericsson/extras/liveware/experience/ActionSet:getId	()J
    //   766: lstore 5
    //   768: lload 5
    //   770: ldc2_w 727
    //   773: lcmp
    //   774: ifle -416 -> 358
    //   777: getstatic 298	com/sonyericsson/extras/liveware/db/ExperienceDef$ActionSetTable:URI	Landroid/net/Uri;
    //   780: lload 5
    //   782: invokestatic 772	java/lang/Long:toString	(J)Ljava/lang/String;
    //   785: invokestatic 778	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   788: astore 5
    //   790: aload_0
    //   791: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   794: invokevirtual 35	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   797: aload 5
    //   799: aconst_null
    //   800: invokevirtual 782	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   803: goto -445 -> 358
    //   806: aload 4
    //   808: invokeinterface 706 1 0
    //   813: checkcast 314	com/sonyericsson/extras/liveware/experience/ActionSet
    //   816: invokevirtual 814	com/sonyericsson/extras/liveware/experience/ActionSet:getId	()J
    //   819: lstore 5
    //   821: lload 5
    //   823: ldc2_w 727
    //   826: lcmp
    //   827: ifle -439 -> 388
    //   830: getstatic 298	com/sonyericsson/extras/liveware/db/ExperienceDef$ActionSetTable:URI	Landroid/net/Uri;
    //   833: lload 5
    //   835: invokestatic 772	java/lang/Long:toString	(J)Ljava/lang/String;
    //   838: invokestatic 778	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   841: astore 5
    //   843: aload_0
    //   844: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   847: invokevirtual 35	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   850: aload 5
    //   852: aconst_null
    //   853: invokevirtual 782	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   856: goto -468 -> 388
    //   859: astore_3
    //   860: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   863: ifeq -441 -> 422
    //   866: ldc_w 823
    //   869: aload_3
    //   870: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   873: pop
    //   874: goto -452 -> 422
    //   877: astore_3
    //   878: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   881: ifeq -350 -> 531
    //   884: ldc_w 823
    //   887: aload_3
    //   888: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   891: pop
    //   892: goto -361 -> 531
    //   895: astore_3
    //   896: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   899: ifeq -285 -> 614
    //   902: ldc_w 823
    //   905: aload_3
    //   906: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   909: pop
    //   910: goto -296 -> 614
    //   913: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   916: astore 4
    //   918: aload 4
    //   920: ifnull +13 -> 933
    //   923: iload_3
    //   924: ifeq +9 -> 933
    //   927: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   930: invokevirtual 785	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   933: iload_2
    //   934: ifeq +42 -> 976
    //   937: aload_0
    //   938: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   941: invokestatic 790	com/sonyericsson/extras/liveware/utils/AsfTimeUtils:millisSinceMidnight	()J
    //   944: invokestatic 793	com/sonyericsson/extras/liveware/utils/AsfTimeUtils:getDayOfWeek	()I
    //   947: invokestatic 799	com/sonyericsson/extras/liveware/asf/TimeService:timeTriggerUpdated	(Landroid/content/Context;JI)V
    //   950: goto +26 -> 976
    //   953: astore_3
    //   954: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   957: ifeq -24 -> 933
    //   960: ldc_w 823
    //   963: aload_3
    //   964: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   967: pop
    //   968: goto -35 -> 933
    //   971: iconst_1
    //   972: istore_2
    //   973: goto -887 -> 86
    //   976: aconst_null
    //   977: astore_1
    //   978: goto -539 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	981	0	this	ExperienceManager
    //   0	981	1	paramExperience	Experience
    //   13	602	2	i	int
    //   634	300	2	localObject1	Object
    //   972	1	2	j	int
    //   15	590	3	k	int
    //   859	11	3	localSQLiteException1	SQLiteException
    //   877	11	3	localSQLiteException2	SQLiteException
    //   895	29	3	localSQLiteException3	SQLiteException
    //   953	11	3	localSQLiteException4	SQLiteException
    //   10	280	4	l1	long
    //   297	111	4	localObject2	Object
    //   494	12	4	localSQLException	SQLException
    //   514	54	4	localSQLiteDatabase1	SQLiteDatabase
    //   592	215	4	localObject3	Object
    //   916	3	4	localSQLiteDatabase2	SQLiteDatabase
    //   395	3	5	bool	boolean
    //   597	3	5	localSQLiteDatabase3	SQLiteDatabase
    //   766	15	5	l2	long
    //   788	10	5	localUri1	Uri
    //   819	15	5	l3	long
    //   841	10	5	localUri2	Uri
    //   5	42	6	l4	long
    //   60	10	6	localContentValues	ContentValues
    //   74	181	6	l5	long
    //   262	203	6	localUri3	Uri
    //   32	123	8	localObject4	Object
    //   159	420	8	l6	long
    //   90	494	9	localObject5	Object
    //   180	517	10	localObject6	Object
    //   459	275	11	localObject7	Object
    //   649	94	12	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   16	397	494	android/database/SQLException
    //   443	491	494	android/database/SQLException
    //   553	589	494	android/database/SQLException
    //   639	856	494	android/database/SQLException
    //   16	397	592	finally
    //   443	491	592	finally
    //   496	511	592	finally
    //   553	589	592	finally
    //   639	856	592	finally
    //   402	407	634	finally
    //   416	422	634	finally
    //   426	439	634	finally
    //   511	516	634	finally
    //   525	531	634	finally
    //   535	548	634	finally
    //   594	599	634	finally
    //   608	614	634	finally
    //   618	634	634	finally
    //   860	918	634	finally
    //   927	933	634	finally
    //   937	968	634	finally
    //   416	422	859	android/database/sqlite/SQLiteException
    //   525	531	877	android/database/sqlite/SQLiteException
    //   608	614	895	android/database/sqlite/SQLiteException
    //   927	933	953	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void deleteActionSet(ActionSet paramActionSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 814	com/sonyericsson/extras/liveware/experience/ActionSet:getId	()J
    //   6: lstore_2
    //   7: iconst_1
    //   8: anewarray 41	java/lang/String
    //   11: astore 4
    //   13: aload 4
    //   15: iconst_0
    //   16: lload_2
    //   17: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   20: aastore
    //   21: aload_0
    //   22: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   25: getstatic 298	com/sonyericsson/extras/liveware/db/ExperienceDef$ActionSetTable:URI	Landroid/net/Uri;
    //   28: ldc_w 350
    //   31: aload 4
    //   33: invokevirtual 827	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: pop
    //   41: ldc_w 829
    //   44: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   47: pop
    //   48: goto -11 -> 37
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ExperienceManager
    //   0	56	1	paramActionSet	ActionSet
    //   6	11	2	l	long
    //   51	4	2	localObject	Object
    //   11	21	4	arrayOfString	String[]
    //   40	1	5	localSQLException	SQLException
    // Exception table:
    //   from	to	target	type
    //   21	37	40	android/database/SQLException
    //   2	21	51	finally
    //   21	37	51	finally
    //   41	48	51	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void deleteActionSets(Experience paramExperience)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 219	com/sonyericsson/extras/liveware/experience/Experience:getId	()J
    //   6: lstore_2
    //   7: iconst_1
    //   8: anewarray 41	java/lang/String
    //   11: astore 4
    //   13: aload 4
    //   15: iconst_0
    //   16: lload_2
    //   17: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   20: aastore
    //   21: aload_0
    //   22: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   25: getstatic 298	com/sonyericsson/extras/liveware/db/ExperienceDef$ActionSetTable:URI	Landroid/net/Uri;
    //   28: ldc_w 832
    //   31: aload 4
    //   33: invokevirtual 827	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: pop
    //   41: ldc_w 829
    //   44: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   47: pop
    //   48: goto -11 -> 37
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	ExperienceManager
    //   0	56	1	paramExperience	Experience
    //   6	11	2	l	long
    //   51	4	2	localObject	Object
    //   11	21	4	arrayOfString	String[]
    //   40	1	5	localSQLException	SQLException
    // Exception table:
    //   from	to	target	type
    //   21	37	40	android/database/SQLException
    //   2	21	51	finally
    //   21	37	51	finally
    //   41	48	51	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void deleteExperience(Experience paramExperience)
    throws ExperienceManager.EmException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   8: aload_1
    //   9: invokestatic 839	com/sonyericsson/extras/liveware/utils/UIUtils:removeExperienceNotification	(Landroid/content/Context;Lcom/sonyericsson/extras/liveware/experience/Experience;)V
    //   12: aload_1
    //   13: invokevirtual 842	com/sonyericsson/extras/liveware/experience/Experience:getPictureName	()Ljava/lang/String;
    //   16: invokestatic 845	com/sonyericsson/extras/liveware/experience/Experience:isExternalStorageEventPicture	(Ljava/lang/String;)Z
    //   19: ifeq +8 -> 27
    //   22: aload_1
    //   23: invokevirtual 842	com/sonyericsson/extras/liveware/experience/Experience:getPictureName	()Ljava/lang/String;
    //   26: astore_2
    //   27: getstatic 487	com/sonyericsson/extras/liveware/db/ExperienceDef$ExperienceTable:URI	Landroid/net/Uri;
    //   30: aload_1
    //   31: invokevirtual 219	com/sonyericsson/extras/liveware/experience/Experience:getId	()J
    //   34: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: invokestatic 778	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   40: astore_3
    //   41: aload_0
    //   42: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   45: aload_3
    //   46: aconst_null
    //   47: aconst_null
    //   48: invokevirtual 827	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   51: pop
    //   52: aload_2
    //   53: ifnull +11 -> 64
    //   56: aload_0
    //   57: aload_2
    //   58: invokestatic 849	com/sonyericsson/extras/liveware/experience/Experience:getEventPictureFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokespecial 851	com/sonyericsson/extras/liveware/experience/ExperienceManager:deleteFile	(Ljava/lang/String;)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: astore_3
    //   68: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   71: ifeq +11 -> 82
    //   74: ldc_w 853
    //   77: aload_3
    //   78: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   81: pop
    //   82: new 6	com/sonyericsson/extras/liveware/experience/ExperienceManager$EmException
    //   85: dup
    //   86: invokespecial 711	com/sonyericsson/extras/liveware/experience/ExperienceManager$EmException:<init>	()V
    //   89: athrow
    //   90: astore_3
    //   91: aload_2
    //   92: ifnull +11 -> 103
    //   95: aload_0
    //   96: aload_2
    //   97: invokestatic 849	com/sonyericsson/extras/liveware/experience/Experience:getEventPictureFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   100: invokespecial 851	com/sonyericsson/extras/liveware/experience/ExperienceManager:deleteFile	(Ljava/lang/String;)V
    //   103: aload_3
    //   104: athrow
    //   105: astore_2
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_2
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	ExperienceManager
    //   0	110	1	paramExperience	Experience
    //   3	94	2	str	String
    //   105	4	2	localObject1	Object
    //   40	6	3	localUri	Uri
    //   67	11	3	localSQLException	SQLException
    //   90	14	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   41	52	67	android/database/SQLException
    //   41	52	90	finally
    //   68	90	90	finally
    //   4	41	105	finally
    //   56	64	105	finally
    //   95	105	105	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void deleteLocation(long paramLong)
    throws ExperienceManager.EmException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 606	com/sonyericsson/extras/liveware/db/ExperienceDef$LocationTriggerTable:URI	Landroid/net/Uri;
    //   5: lload_1
    //   6: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   9: invokestatic 778	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   12: astore_3
    //   13: aload_0
    //   14: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   17: aload_3
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 827	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   23: pop
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_3
    //   28: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   31: ifeq +11 -> 42
    //   34: ldc_w 856
    //   37: aload_3
    //   38: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   41: pop
    //   42: new 6	com/sonyericsson/extras/liveware/experience/ExperienceManager$EmException
    //   45: dup
    //   46: invokespecial 711	com/sonyericsson/extras/liveware/experience/ExperienceManager$EmException:<init>	()V
    //   49: athrow
    //   50: astore_3
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_3
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	ExperienceManager
    //   0	55	1	paramLong	long
    //   12	6	3	localUri	Uri
    //   27	11	3	localSQLException	SQLException
    //   50	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	24	27	android/database/SQLException
    //   2	13	50	finally
    //   13	24	50	finally
    //   28	50	50	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void deleteTime(long paramLong)
    throws ExperienceManager.EmException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 632	com/sonyericsson/extras/liveware/db/ExperienceDef$TimeTriggerTable:URI	Landroid/net/Uri;
    //   5: lload_1
    //   6: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   9: invokestatic 778	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   12: astore_3
    //   13: aload_0
    //   14: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   17: aload_3
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 827	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   23: pop
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_3
    //   28: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   31: ifeq +11 -> 42
    //   34: ldc_w 859
    //   37: aload_3
    //   38: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   41: pop
    //   42: new 6	com/sonyericsson/extras/liveware/experience/ExperienceManager$EmException
    //   45: dup
    //   46: invokespecial 711	com/sonyericsson/extras/liveware/experience/ExperienceManager$EmException:<init>	()V
    //   49: athrow
    //   50: astore_3
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_3
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	ExperienceManager
    //   0	55	1	paramLong	long
    //   12	6	3	localUri	Uri
    //   27	11	3	localSQLException	SQLException
    //   50	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	24	27	android/database/SQLException
    //   2	13	50	finally
    //   13	24	50	finally
    //   28	50	50	finally
  }
  
  /**
   * @deprecated
   */
  public Action getActionByClass(String paramString)
  {
    try
    {
      Object localObject1 = new String[1];
      localObject1[0] = paramString;
      localObject1 = getActionFromQuery("class=?", (String[])localObject1);
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /**
   * @deprecated
   */
  public Action getActionById(long paramLong)
  {
    try
    {
      Object localObject1 = new Object[1];
      localObject1[0] = Long.valueOf(paramLong);
      localObject1 = getActionFromQuery("_id=?", args((Object[])localObject1));
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /**
   * @deprecated
   */
  public Action getActionByUuid(String paramString)
  {
    try
    {
      Object localObject1 = new String[1];
      localObject1[0] = paramString;
      localObject1 = getActionFromQuery("UUID=?", (String[])localObject1);
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /**
   * @deprecated
   */
  public List<ActionSet> getActionSetByPackageName(String paramString)
  {
    try
    {
      List localList = getActionSetByQuery("rawSetting LIKE '%" + paramString + "%'", null);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public List<ActionSet> getActionSetByType(long paramLong, int paramInt)
  {
    try
    {
      Object localObject1 = new Object[2];
      localObject1[0] = Integer.valueOf(paramInt);
      localObject1[1] = Long.valueOf(paramLong);
      localObject1 = getActionSetByQuery("actionSetType=? AND experienceId=?", args((Object[])localObject1));
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public ActionSet getActionSetByUuid(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: anewarray 41	java/lang/String
    //   6: astore_2
    //   7: aload_2
    //   8: iconst_0
    //   9: aload_1
    //   10: aastore
    //   11: aload_0
    //   12: ldc_w 868
    //   15: aload_2
    //   16: invokespecial 876	com/sonyericsson/extras/liveware/experience/ExperienceManager:getActionSetByQuery	(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface 881 1 0
    //   26: iconst_1
    //   27: if_icmpge +39 -> 66
    //   30: invokestatic 884	com/sonyericsson/extras/liveware/utils/Dbg:d	()Z
    //   33: ifeq +27 -> 60
    //   36: new 62	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 886
    //   43: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload_1
    //   47: invokevirtual 887	java/lang/String:toString	()Ljava/lang/String;
    //   50: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 889	com/sonyericsson/extras/liveware/utils/Dbg:d	(Ljava/lang/String;)Z
    //   59: pop
    //   60: aconst_null
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: areturn
    //   66: aload_2
    //   67: iconst_0
    //   68: invokeinterface 892 2 0
    //   73: checkcast 314	com/sonyericsson/extras/liveware/experience/ActionSet
    //   76: astore_2
    //   77: goto -15 -> 62
    //   80: astore_2
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_2
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	ExperienceManager
    //   0	85	1	paramString	String
    //   6	71	2	localObject1	Object
    //   80	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	60	80	finally
    //   66	77	80	finally
  }
  
  /**
   * @deprecated
   */
  public ArrayList<Device> getAllDevices()
  {
    try
    {
      ArrayList localArrayList = getDevicesFromQuery(null, null);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public List<Action> getAllEnabledActions()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 82	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 83	java/util/ArrayList:<init>	()V
    //   9: astore_2
    //   10: aconst_null
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   16: getstatic 277	com/sonyericsson/extras/liveware/db/ExperienceDef$ActionTable:URI	Landroid/net/Uri;
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: ldc_w 899
    //   25: invokevirtual 283	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull +14 -> 44
    //   33: aload_1
    //   34: invokeinterface 88 1 0
    //   39: istore_3
    //   40: iload_3
    //   41: ifne +17 -> 58
    //   44: aload_1
    //   45: ifnull +9 -> 54
    //   48: aload_1
    //   49: invokeinterface 291 1 0
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: areturn
    //   58: aload_0
    //   59: aload_1
    //   60: invokespecial 288	com/sonyericsson/extras/liveware/experience/ExperienceManager:getActionFromCursor	(Landroid/database/Cursor;)Lcom/sonyericsson/extras/liveware/experience/Action;
    //   63: astore_3
    //   64: aload_3
    //   65: ifnull -32 -> 33
    //   68: aload_3
    //   69: invokevirtual 902	com/sonyericsson/extras/liveware/experience/Action:isDisabled	()Z
    //   72: ifne -39 -> 33
    //   75: aload_2
    //   76: aload_3
    //   77: invokevirtual 167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   80: pop
    //   81: goto -48 -> 33
    //   84: pop
    //   85: ldc_w 904
    //   88: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   91: pop
    //   92: aload_1
    //   93: ifnull -39 -> 54
    //   96: aload_1
    //   97: invokeinterface 291 1 0
    //   102: goto -48 -> 54
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: astore_2
    //   111: aload_1
    //   112: ifnull +9 -> 121
    //   115: aload_1
    //   116: invokeinterface 291 1 0
    //   121: aload_2
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	ExperienceManager
    //   11	86	1	localCursor	Cursor
    //   105	11	1	localObject1	Object
    //   9	67	2	localArrayList	ArrayList
    //   110	12	2	localObject2	Object
    //   39	2	3	bool	boolean
    //   63	14	3	localAction	Action
    //   84	1	7	localSQLException	SQLException
    // Exception table:
    //   from	to	target	type
    //   12	40	84	android/database/SQLException
    //   58	81	84	android/database/SQLException
    //   2	10	105	finally
    //   48	54	105	finally
    //   96	102	105	finally
    //   115	123	105	finally
    //   12	40	110	finally
    //   58	81	110	finally
    //   85	92	110	finally
  }
  
  /**
   * @deprecated
   */
  public ArrayList<Experience> getAllExperiences()
  {
    try
    {
      ArrayList localArrayList = getExperiencesFromQuery(null, null);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public Device getDeviceById(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: anewarray 4	java/lang/Object
    //   6: astore_3
    //   7: aload_3
    //   8: iconst_0
    //   9: lload_1
    //   10: invokestatic 348	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   13: aastore
    //   14: aload_0
    //   15: ldc_w 909
    //   18: aload_3
    //   19: invokestatic 352	com/sonyericsson/extras/liveware/experience/ExperienceManager:args	([Ljava/lang/Object;)[Ljava/lang/String;
    //   22: invokespecial 896	com/sonyericsson/extras/liveware/experience/ExperienceManager:getDevicesFromQuery	(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/ArrayList;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +23 -> 50
    //   30: aload_3
    //   31: invokevirtual 159	java/util/ArrayList:size	()I
    //   34: ifle +16 -> 50
    //   37: aload_3
    //   38: iconst_0
    //   39: invokevirtual 910	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   42: checkcast 118	com/sonyericsson/extras/liveware/experience/Device
    //   45: astore_3
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_3
    //   49: areturn
    //   50: aconst_null
    //   51: astore_3
    //   52: goto -6 -> 46
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	ExperienceManager
    //   0	60	1	paramLong	long
    //   6	46	3	localObject1	Object
    //   55	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	46	55	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public Device getDeviceByKeyId(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: anewarray 41	java/lang/String
    //   6: astore_2
    //   7: aload_2
    //   8: iconst_0
    //   9: aload_1
    //   10: aastore
    //   11: aload_0
    //   12: ldc_w 914
    //   15: aload_2
    //   16: invokespecial 896	com/sonyericsson/extras/liveware/experience/ExperienceManager:getDevicesFromQuery	(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/ArrayList;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +23 -> 44
    //   24: aload_2
    //   25: invokevirtual 159	java/util/ArrayList:size	()I
    //   28: ifle +16 -> 44
    //   31: aload_2
    //   32: iconst_0
    //   33: invokevirtual 910	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   36: checkcast 118	com/sonyericsson/extras/liveware/experience/Device
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: areturn
    //   44: aconst_null
    //   45: astore_2
    //   46: goto -6 -> 40
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	ExperienceManager
    //   0	54	1	paramString	String
    //   6	40	2	localObject1	Object
    //   49	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	40	49	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public Device getDeviceByProductId(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: anewarray 41	java/lang/String
    //   6: astore_2
    //   7: aload_2
    //   8: iconst_0
    //   9: aload_1
    //   10: aastore
    //   11: aload_0
    //   12: ldc_w 917
    //   15: aload_2
    //   16: invokespecial 896	com/sonyericsson/extras/liveware/experience/ExperienceManager:getDevicesFromQuery	(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/ArrayList;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +23 -> 44
    //   24: aload_2
    //   25: invokevirtual 159	java/util/ArrayList:size	()I
    //   28: ifle +16 -> 44
    //   31: aload_2
    //   32: iconst_0
    //   33: invokevirtual 910	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   36: checkcast 118	com/sonyericsson/extras/liveware/experience/Device
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: areturn
    //   44: aconst_null
    //   45: astore_2
    //   46: goto -6 -> 40
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	ExperienceManager
    //   0	54	1	paramString	String
    //   6	40	2	localObject1	Object
    //   49	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	40	49	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public Device getDeviceByProductIdAndBearer(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iload_2
    //   5: invokevirtual 923	com/sonyericsson/extras/liveware/experience/ExperienceManager:getDevicesByProductIdAndBearer	(Ljava/lang/String;I)Ljava/util/ArrayList;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +23 -> 33
    //   13: aload_3
    //   14: invokevirtual 159	java/util/ArrayList:size	()I
    //   17: ifle +16 -> 33
    //   20: aload_3
    //   21: iconst_0
    //   22: invokevirtual 910	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   25: checkcast 118	com/sonyericsson/extras/liveware/experience/Device
    //   28: astore_3
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: areturn
    //   33: aconst_null
    //   34: astore_3
    //   35: goto -6 -> 29
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	ExperienceManager
    //   0	43	1	paramString	String
    //   0	43	2	paramInt	int
    //   8	27	3	localObject1	Object
    //   38	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	38	finally
  }
  
  /**
   * @deprecated
   */
  public List<Device> getDevicesByBearer(int paramInt)
  {
    try
    {
      Object localObject1 = new Object[1];
      localObject1[0] = Integer.valueOf(paramInt);
      localObject1 = getDevicesFromQuery("bearer_type=?", args((Object[])localObject1));
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /**
   * @deprecated
   */
  public ArrayList<Device> getDevicesByProductIdAndBearer(String paramString, int paramInt)
  {
    try
    {
      Object localObject1 = new Object[2];
      localObject1[0] = paramString;
      localObject1[1] = Integer.valueOf(paramInt);
      localObject1 = getDevicesFromQuery("product_id =? AND bearer_type=? AND configured > 0", args((Object[])localObject1));
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /**
   * @deprecated
   */
  public ArrayList<Device> getDevicesWithUnmodifiedUserDefNames()
  {
    try
    {
      ArrayList localArrayList = getDevicesFromQuery("user_defined_name_changed = 0 ", null);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public ArrayList<Experience> getEnabledExperiences()
  {
    try
    {
      Object localObject1 = new Object[1];
      localObject1[0] = Integer.valueOf(2);
      localObject1 = getExperiencesFromQuery("enabled_state=?", args((Object[])localObject1));
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public Experience getExperience(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: anewarray 4	java/lang/Object
    //   6: astore_3
    //   7: aload_3
    //   8: iconst_0
    //   9: lload_1
    //   10: invokestatic 348	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   13: aastore
    //   14: aload_0
    //   15: ldc_w 350
    //   18: aload_3
    //   19: invokestatic 352	com/sonyericsson/extras/liveware/experience/ExperienceManager:args	([Ljava/lang/Object;)[Ljava/lang/String;
    //   22: invokespecial 907	com/sonyericsson/extras/liveware/experience/ExperienceManager:getExperiencesFromQuery	(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/ArrayList;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +23 -> 50
    //   30: aload_3
    //   31: invokevirtual 159	java/util/ArrayList:size	()I
    //   34: ifle +16 -> 50
    //   37: aload_3
    //   38: iconst_0
    //   39: invokevirtual 910	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   42: checkcast 209	com/sonyericsson/extras/liveware/experience/Experience
    //   45: astore_3
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_3
    //   49: areturn
    //   50: aconst_null
    //   51: astore_3
    //   52: goto -6 -> 46
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	ExperienceManager
    //   0	60	1	paramLong	long
    //   6	46	3	localObject1	Object
    //   55	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	46	55	finally
  }
  
  /**
   * @deprecated
   */
  public ArrayList<Experience> getExperiencesByDeviceId(long paramLong)
  {
    try
    {
      Object localObject1 = new Object[1];
      localObject1[0] = Long.valueOf(paramLong);
      localObject1 = getExperiencesFromQuery("deviceId=?", args((Object[])localObject1));
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public ArrayList<Experience> getExperiencesByTimeIds(long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 62	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 944	java/lang/StringBuilder:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: ldc_w 946
    //   14: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: bipush 255
    //   23: aload_1
    //   24: arraylength
    //   25: iadd
    //   26: if_icmplt +37 -> 63
    //   29: aload_3
    //   30: aload_1
    //   31: bipush 255
    //   33: aload_1
    //   34: arraylength
    //   35: iadd
    //   36: laload
    //   37: invokevirtual 949	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: ldc_w 951
    //   45: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_0
    //   50: aload_3
    //   51: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: aconst_null
    //   55: invokespecial 907	com/sonyericsson/extras/liveware/experience/ExperienceManager:getExperiencesFromQuery	(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/ArrayList;
    //   58: astore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: areturn
    //   63: aload_3
    //   64: new 62	java/lang/StringBuilder
    //   67: dup
    //   68: aload_1
    //   69: iload_2
    //   70: laload
    //   71: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   74: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: ldc_w 953
    //   80: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: iinc 2 1
    //   93: goto -73 -> 20
    //   96: astore_2
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	ExperienceManager
    //   0	101	1	paramArrayOfLong	long[]
    //   19	8	2	i	int
    //   58	33	2	localArrayList	ArrayList
    //   96	4	2	localObject	Object
    //   9	55	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	59	96	finally
    //   63	90	96	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public List<Time> getInitiatorsAt(long paramLong, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload 4
    //   4: ifeq +92 -> 96
    //   7: ldc_w 660
    //   10: astore 5
    //   12: new 62	java/lang/StringBuilder
    //   15: dup
    //   16: aload 5
    //   18: invokestatic 45	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: ldc_w 957
    //   27: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 5
    //   35: iconst_1
    //   36: anewarray 41	java/lang/String
    //   39: astore 6
    //   41: aload 6
    //   43: iconst_0
    //   44: lload_1
    //   45: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   48: aastore
    //   49: aload_0
    //   50: aload 5
    //   52: aload 6
    //   54: invokespecial 959	com/sonyericsson/extras/liveware/experience/ExperienceManager:queryTime	(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   57: astore 6
    //   59: new 82	java/util/ArrayList
    //   62: dup
    //   63: invokespecial 83	java/util/ArrayList:<init>	()V
    //   66: astore 5
    //   68: aload 6
    //   70: invokeinterface 764 1 0
    //   75: astore 6
    //   77: aload 6
    //   79: invokeinterface 702 1 0
    //   84: istore 7
    //   86: iload 7
    //   88: ifne +16 -> 104
    //   91: aload_0
    //   92: monitorexit
    //   93: aload 5
    //   95: areturn
    //   96: ldc_w 658
    //   99: astore 5
    //   101: goto -89 -> 12
    //   104: aload 6
    //   106: invokeinterface 706 1 0
    //   111: checkcast 662	com/sonyericsson/extras/liveware/experience/Time
    //   114: astore 7
    //   116: iload_3
    //   117: istore 8
    //   119: iload 4
    //   121: ifeq +24 -> 145
    //   124: aload 7
    //   126: invokevirtual 962	com/sonyericsson/extras/liveware/experience/Time:getStartTime	()J
    //   129: aload 7
    //   131: invokevirtual 965	com/sonyericsson/extras/liveware/experience/Time:getStopTime	()J
    //   134: lcmp
    //   135: ifle +10 -> 145
    //   138: iload 8
    //   140: invokestatic 968	com/sonyericsson/extras/liveware/utils/AsfTimeUtils:getPreviousDay	(I)I
    //   143: istore 8
    //   145: aload 7
    //   147: iload 8
    //   149: invokevirtual 971	com/sonyericsson/extras/liveware/experience/Time:getDayState	(I)Z
    //   152: ifeq -75 -> 77
    //   155: aload 5
    //   157: aload 7
    //   159: invokeinterface 639 2 0
    //   164: pop
    //   165: goto -88 -> 77
    //   168: astore 5
    //   170: aload_0
    //   171: monitorexit
    //   172: aload 5
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	ExperienceManager
    //   0	175	1	paramLong	long
    //   0	175	3	paramInt	int
    //   0	175	4	paramBoolean	boolean
    //   10	146	5	localObject1	Object
    //   168	5	5	localObject2	Object
    //   39	66	6	localObject3	Object
    //   84	3	7	bool	boolean
    //   114	44	7	localTime	Time
    //   117	31	8	i	int
    // Exception table:
    //   from	to	target	type
    //   7	86	168	finally
    //   96	165	168	finally
  }
  
  /**
   * @deprecated
   */
  public ArrayList<Device> getNotConfiguredDevices()
  {
    try
    {
      ArrayList localArrayList = getDevicesFromQuery("configured = 0", null);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public Time getTime(long paramLong)
  {
    Cursor localCursor = null;
    for (;;)
    {
      try
      {
        ContentResolver localContentResolver = this.mContentResolver;
        Object localObject2 = ExperienceDef.TimeTriggerTable.URI;
        String[] arrayOfString = new String[1];
        arrayOfString[0] = String.valueOf(paramLong);
        localCursor = localContentResolver.query((Uri)localObject2, null, "_id = ?", arrayOfString, null);
        if ((localCursor != null) && (localCursor.moveToFirst()))
        {
          localObject2 = timeFromCursor(localCursor);
          localObject2 = localObject2;
          if (localCursor == null) {}
        }
        if (localObject1 == null) {
          break label143;
        }
      }
      catch (SQLException localSQLException)
      {
        localSQLException = localSQLException;
        if (Dbg.e()) {
          Dbg.e("Error getTime", localSQLException);
        }
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
      localObject1.close();
      label143:
      Object localObject4 = null;
    }
  }
  
  /**
   * @deprecated
   */
  public List<Time> getTimeInitators()
  {
    try
    {
      List localList = queryTime(null, null);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public List<Long> getTimeInitiatorTimes(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: invokestatic 981	com/sonyericsson/extras/liveware/utils/AsfTimeUtils:getNextDay	(I)I
    //   6: istore 7
    //   8: iload_3
    //   9: invokestatic 968	com/sonyericsson/extras/liveware/utils/AsfTimeUtils:getPreviousDay	(I)I
    //   12: istore 6
    //   14: new 82	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 83	java/util/ArrayList:<init>	()V
    //   21: astore 5
    //   23: aconst_null
    //   24: astore 4
    //   26: aload_0
    //   27: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   30: getstatic 632	com/sonyericsson/extras/liveware/db/ExperienceDef$TimeTriggerTable:URI	Landroid/net/Uri;
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: invokevirtual 283	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore 4
    //   42: aload 4
    //   44: ifnull +17 -> 61
    //   47: aload 4
    //   49: invokeinterface 88 1 0
    //   54: istore 8
    //   56: iload 8
    //   58: ifne +20 -> 78
    //   61: aload 4
    //   63: ifnull +10 -> 73
    //   66: aload 4
    //   68: invokeinterface 291 1 0
    //   73: aload_0
    //   74: monitorexit
    //   75: aload 5
    //   77: areturn
    //   78: aload_0
    //   79: aload 4
    //   81: invokespecial 636	com/sonyericsson/extras/liveware/experience/ExperienceManager:timeFromCursor	(Landroid/database/Cursor;)Lcom/sonyericsson/extras/liveware/experience/Time;
    //   84: astore 12
    //   86: aload 12
    //   88: invokevirtual 962	com/sonyericsson/extras/liveware/experience/Time:getStartTime	()J
    //   91: lstore 8
    //   93: aload 12
    //   95: invokevirtual 965	com/sonyericsson/extras/liveware/experience/Time:getStopTime	()J
    //   98: lstore 10
    //   100: lload 8
    //   102: lload_1
    //   103: lcmp
    //   104: iflt +12 -> 116
    //   107: aload 12
    //   109: iload_3
    //   110: invokevirtual 971	com/sonyericsson/extras/liveware/experience/Time:getDayState	(I)Z
    //   113: ifne +20 -> 133
    //   116: lload 8
    //   118: lload_1
    //   119: lcmp
    //   120: ifge +26 -> 146
    //   123: aload 12
    //   125: iload 7
    //   127: invokevirtual 971	com/sonyericsson/extras/liveware/experience/Time:getDayState	(I)Z
    //   130: ifeq +16 -> 146
    //   133: aload 5
    //   135: lload 8
    //   137: invokestatic 348	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   140: invokeinterface 639 2 0
    //   145: pop
    //   146: lload 8
    //   148: lload 10
    //   150: lcmp
    //   151: ifgt +49 -> 200
    //   154: lload 10
    //   156: lload_1
    //   157: lcmp
    //   158: iflt +12 -> 170
    //   161: aload 12
    //   163: iload_3
    //   164: invokevirtual 971	com/sonyericsson/extras/liveware/experience/Time:getDayState	(I)Z
    //   167: ifne +20 -> 187
    //   170: lload 10
    //   172: lload_1
    //   173: lcmp
    //   174: ifge +26 -> 200
    //   177: aload 12
    //   179: iload 7
    //   181: invokevirtual 971	com/sonyericsson/extras/liveware/experience/Time:getDayState	(I)Z
    //   184: ifeq +16 -> 200
    //   187: aload 5
    //   189: lload 10
    //   191: invokestatic 348	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   194: invokeinterface 639 2 0
    //   199: pop
    //   200: lload 8
    //   202: lload 10
    //   204: lcmp
    //   205: ifle +20 -> 225
    //   208: lload 10
    //   210: lload_1
    //   211: lcmp
    //   212: iflt +13 -> 225
    //   215: aload 12
    //   217: iload 6
    //   219: invokevirtual 971	com/sonyericsson/extras/liveware/experience/Time:getDayState	(I)Z
    //   222: ifne +19 -> 241
    //   225: lload 10
    //   227: lload_1
    //   228: lcmp
    //   229: ifge -187 -> 42
    //   232: aload 12
    //   234: iload_3
    //   235: invokevirtual 971	com/sonyericsson/extras/liveware/experience/Time:getDayState	(I)Z
    //   238: ifeq -196 -> 42
    //   241: aload 5
    //   243: lload 10
    //   245: invokestatic 348	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   248: invokeinterface 639 2 0
    //   253: pop
    //   254: goto -212 -> 42
    //   257: astore 6
    //   259: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   262: ifeq +12 -> 274
    //   265: ldc_w 983
    //   268: aload 6
    //   270: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   273: pop
    //   274: aload 4
    //   276: ifnull -203 -> 73
    //   279: aload 4
    //   281: invokeinterface 291 1 0
    //   286: goto -213 -> 73
    //   289: astore 4
    //   291: aload_0
    //   292: monitorexit
    //   293: aload 4
    //   295: athrow
    //   296: astore 5
    //   298: aload 4
    //   300: ifnull +10 -> 310
    //   303: aload 4
    //   305: invokeinterface 291 1 0
    //   310: aload 5
    //   312: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	ExperienceManager
    //   0	313	1	paramLong	long
    //   0	313	3	paramInt	int
    //   24	256	4	localCursor	Cursor
    //   289	15	4	localObject1	Object
    //   21	221	5	localArrayList	ArrayList
    //   296	15	5	localObject2	Object
    //   12	206	6	i	int
    //   257	12	6	localSQLException	SQLException
    //   6	174	7	j	int
    //   54	3	8	bool	boolean
    //   91	110	8	l1	long
    //   98	146	10	l2	long
    //   84	149	12	localTime	Time
    // Exception table:
    //   from	to	target	type
    //   26	56	257	android/database/SQLException
    //   78	254	257	android/database/SQLException
    //   2	23	289	finally
    //   66	73	289	finally
    //   279	286	289	finally
    //   303	313	289	finally
    //   26	56	296	finally
    //   78	254	296	finally
    //   259	274	296	finally
  }
  
  /**
   * @deprecated
   */
  public List<ActionSet> getUnfinalizedPreconfigActionSets()
  {
    try
    {
      Object localObject1 = new Object[1];
      localObject1[0] = Integer.valueOf(2);
      localObject1 = getActionSetByQuery("finalized = ?", args((Object[])localObject1));
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  /**
   * @deprecated
   */
  public ArrayList<Experience> getUnmodifiedExperienceNames()
  {
    try
    {
      ArrayList localArrayList = getExperiencesFromQuery("name_changed_by_user = 0 AND name_resource IS NOT NULL ", null);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /**
   * @deprecated
   */
  public void purgeUnfinalizedUserActionSets()
  {
    for (;;)
    {
      ActionSet localActionSet;
      try
      {
        Iterator localIterator = getActionSetByQuery(null, null).iterator();
        boolean bool = localIterator.hasNext();
        if (!bool) {
          return;
        }
        localActionSet = (ActionSet)localIterator.next();
        if (localActionSet.getFinalizedStatus() == 0)
        {
          deleteActionSet(localActionSet);
          continue;
        }
        if (localActionSet.getFinalizedStatus() != 2) {
          continue;
        }
      }
      finally {}
      if (Dbg.d()) {
        Dbg.d("ExperienceManager.purgeUnfinalizedUserActionSets not deleting:" + localActionSet.getFormattedString());
      }
    }
  }
  
  /**
   * @deprecated
   */
  public boolean removeDevice(Device paramDevice)
  {
    boolean bool1 = false;
    for (;;)
    {
      ArrayList localArrayList;
      Iterator localIterator;
      try
      {
        localArrayList = new ArrayList();
        localArrayList.add(getDeviceDeleteOperation(paramDevice.getId()));
        localIterator = paramDevice.getFeatureList().iterator();
        boolean bool2 = localIterator.hasNext();
        if (bool2) {}
      }
      finally {}
      try
      {
        this.mContentResolver.applyBatch("com.sonyericsson.extras.liveware.asf.experience", localArrayList);
        bool1 = true;
      }
      catch (OperationApplicationException localOperationApplicationException)
      {
        if (!Dbg.e()) {
          continue;
        }
        Dbg.e("Could not remove device ", localOperationApplicationException);
        continue;
      }
      catch (RemoteException localRemoteException)
      {
        if (!Dbg.e()) {
          continue;
        }
        Dbg.e("Could not remove device ", localRemoteException);
        continue;
      }
      catch (SQLException localSQLException)
      {
        if (!Dbg.e()) {
          continue;
        }
        Dbg.e("Could not remove device ", localSQLException);
        continue;
      }
      return bool1;
      localArrayList.add(getFeatureDeleteOperation(((Feature)localIterator.next()).getId()));
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void updateAction(Action.ActionEditor paramActionEditor)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 1020	com/sonyericsson/extras/liveware/experience/Action$ActionEditor:getAction	()Lcom/sonyericsson/extras/liveware/experience/Action;
    //   6: astore_3
    //   7: aload_1
    //   8: invokevirtual 1023	com/sonyericsson/extras/liveware/experience/Action$ActionEditor:getUpdatedValues	()Landroid/content/ContentValues;
    //   11: astore 4
    //   13: iconst_1
    //   14: anewarray 41	java/lang/String
    //   17: astore_2
    //   18: aload_2
    //   19: iconst_0
    //   20: aload_3
    //   21: invokevirtual 1024	com/sonyericsson/extras/liveware/experience/Action:getId	()J
    //   24: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   27: aastore
    //   28: aload_0
    //   29: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   32: getstatic 277	com/sonyericsson/extras/liveware/db/ExperienceDef$ActionTable:URI	Landroid/net/Uri;
    //   35: aload 4
    //   37: ldc_w 350
    //   40: aload_2
    //   41: invokevirtual 1027	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   44: pop
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: pop
    //   49: ldc_w 1029
    //   52: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   55: pop
    //   56: goto -11 -> 45
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ExperienceManager
    //   0	64	1	paramActionEditor	Action.ActionEditor
    //   17	24	2	arrayOfString	String[]
    //   59	4	2	localObject	Object
    //   6	15	3	localAction	Action
    //   11	25	4	localContentValues	ContentValues
    //   48	1	6	localSQLException	SQLException
    // Exception table:
    //   from	to	target	type
    //   28	45	48	android/database/SQLException
    //   2	28	59	finally
    //   28	45	59	finally
    //   49	56	59	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void updateActionSet(ActionSet.ActionSetEditor paramActionSetEditor)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 1037	com/sonyericsson/extras/liveware/experience/ActionSet$ActionSetEditor:getActionSet	()Lcom/sonyericsson/extras/liveware/experience/ActionSet;
    //   6: astore_3
    //   7: aload_1
    //   8: invokevirtual 1038	com/sonyericsson/extras/liveware/experience/ActionSet$ActionSetEditor:getUpdatedValues	()Landroid/content/ContentValues;
    //   11: astore 4
    //   13: iconst_1
    //   14: anewarray 41	java/lang/String
    //   17: astore_2
    //   18: aload_2
    //   19: iconst_0
    //   20: aload_3
    //   21: invokevirtual 814	com/sonyericsson/extras/liveware/experience/ActionSet:getId	()J
    //   24: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   27: aastore
    //   28: aload_0
    //   29: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   32: getstatic 298	com/sonyericsson/extras/liveware/db/ExperienceDef$ActionSetTable:URI	Landroid/net/Uri;
    //   35: aload 4
    //   37: ldc_w 350
    //   40: aload_2
    //   41: invokevirtual 1027	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   44: pop
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: pop
    //   49: ldc_w 1040
    //   52: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   55: pop
    //   56: goto -11 -> 45
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ExperienceManager
    //   0	64	1	paramActionSetEditor	ActionSet.ActionSetEditor
    //   17	24	2	arrayOfString	String[]
    //   59	4	2	localObject	Object
    //   6	15	3	localActionSet	ActionSet
    //   11	25	4	localContentValues	ContentValues
    //   48	1	6	localSQLException	SQLException
    // Exception table:
    //   from	to	target	type
    //   28	45	48	android/database/SQLException
    //   2	28	59	finally
    //   28	45	59	finally
    //   49	56	59	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public boolean updateDevice(Device.DeviceEditor paramDeviceEditor)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: new 82	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 83	java/util/ArrayList:<init>	()V
    //   11: astore 4
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 1044	com/sonyericsson/extras/liveware/experience/ExperienceManager:getDeviceUpdateOperation	(Lcom/sonyericsson/extras/liveware/experience/Device$DeviceEditor;)Landroid/content/ContentProviderOperation;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +10 -> 30
    //   23: aload 4
    //   25: aload_3
    //   26: invokevirtual 167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   29: pop
    //   30: aload 4
    //   32: invokevirtual 159	java/util/ArrayList:size	()I
    //   35: istore_3
    //   36: aload_1
    //   37: invokevirtual 1047	com/sonyericsson/extras/liveware/experience/Device$DeviceEditor:getAddedFeatures	()Ljava/util/List;
    //   40: invokeinterface 764 1 0
    //   45: astore 5
    //   47: aload 5
    //   49: invokeinterface 702 1 0
    //   54: ifne +78 -> 132
    //   57: aload 4
    //   59: invokevirtual 159	java/util/ArrayList:size	()I
    //   62: istore 5
    //   64: aload_1
    //   65: invokevirtual 1050	com/sonyericsson/extras/liveware/experience/Device$DeviceEditor:getRemovedFeatures	()Ljava/util/List;
    //   68: invokeinterface 764 1 0
    //   73: astore 7
    //   75: aload 7
    //   77: invokeinterface 702 1 0
    //   82: istore 6
    //   84: iload 6
    //   86: ifne +82 -> 168
    //   89: aload_0
    //   90: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   93: ldc_w 685
    //   96: aload 4
    //   98: invokevirtual 689	android/content/ContentResolver:applyBatch	(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
    //   101: astore 4
    //   103: new 82	java/util/ArrayList
    //   106: dup
    //   107: invokespecial 83	java/util/ArrayList:<init>	()V
    //   110: astore 6
    //   112: iload_3
    //   113: istore_3
    //   114: iload_3
    //   115: iload 5
    //   117: if_icmplt +77 -> 194
    //   120: aload_1
    //   121: aload 6
    //   123: invokevirtual 1053	com/sonyericsson/extras/liveware/experience/Device$DeviceEditor:setIdOnAddedFeatures	(Ljava/util/List;)V
    //   126: iconst_1
    //   127: istore_2
    //   128: aload_0
    //   129: monitorexit
    //   130: iload_2
    //   131: ireturn
    //   132: aload 5
    //   134: invokeinterface 706 1 0
    //   139: checkcast 514	com/sonyericsson/extras/liveware/experience/Feature
    //   142: astore 6
    //   144: aload 4
    //   146: aload_0
    //   147: aload_1
    //   148: invokevirtual 477	com/sonyericsson/extras/liveware/experience/Device$DeviceEditor:getId	()J
    //   151: aload 6
    //   153: invokespecial 1055	com/sonyericsson/extras/liveware/experience/ExperienceManager:getFeatureInsertOnDeviceIdOperation	(JLcom/sonyericsson/extras/liveware/experience/Feature;)Landroid/content/ContentProviderOperation;
    //   156: invokevirtual 167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   159: pop
    //   160: goto -113 -> 47
    //   163: astore_2
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_2
    //   167: athrow
    //   168: aload 4
    //   170: aload_0
    //   171: aload 7
    //   173: invokeinterface 706 1 0
    //   178: checkcast 514	com/sonyericsson/extras/liveware/experience/Feature
    //   181: invokevirtual 1008	com/sonyericsson/extras/liveware/experience/Feature:getId	()J
    //   184: invokespecial 1010	com/sonyericsson/extras/liveware/experience/ExperienceManager:getFeatureDeleteOperation	(J)Landroid/content/ContentProviderOperation;
    //   187: invokevirtual 167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   190: pop
    //   191: goto -116 -> 75
    //   194: aload 6
    //   196: aload 4
    //   198: iload_3
    //   199: aaload
    //   200: getfield 1060	android/content/ContentProviderResult:uri	Landroid/net/Uri;
    //   203: invokestatic 1066	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   206: l2i
    //   207: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: invokevirtual 167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   213: pop
    //   214: iinc 3 1
    //   217: goto -103 -> 114
    //   220: astore_3
    //   221: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   224: ifeq -96 -> 128
    //   227: ldc_w 1068
    //   230: aload_3
    //   231: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   234: pop
    //   235: goto -107 -> 128
    //   238: astore_3
    //   239: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   242: ifeq -114 -> 128
    //   245: ldc_w 1068
    //   248: aload_3
    //   249: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   252: pop
    //   253: goto -125 -> 128
    //   256: astore_3
    //   257: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   260: ifeq -132 -> 128
    //   263: ldc_w 1068
    //   266: aload_3
    //   267: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   270: pop
    //   271: goto -143 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	ExperienceManager
    //   0	274	1	paramDeviceEditor	Device.DeviceEditor
    //   1	130	2	bool1	boolean
    //   163	4	2	localObject1	Object
    //   18	8	3	localContentProviderOperation	ContentProviderOperation
    //   35	180	3	i	int
    //   220	11	3	localOperationApplicationException	OperationApplicationException
    //   238	11	3	localRemoteException	RemoteException
    //   256	11	3	localSQLException	SQLException
    //   11	186	4	localObject2	Object
    //   45	3	5	localIterator1	Iterator
    //   62	71	5	j	int
    //   82	3	6	bool2	boolean
    //   110	85	6	localObject3	Object
    //   73	99	7	localIterator2	Iterator
    // Exception table:
    //   from	to	target	type
    //   4	84	163	finally
    //   89	126	163	finally
    //   132	160	163	finally
    //   168	191	163	finally
    //   194	214	163	finally
    //   221	271	163	finally
    //   89	126	220	android/content/OperationApplicationException
    //   194	214	220	android/content/OperationApplicationException
    //   89	126	238	android/os/RemoteException
    //   194	214	238	android/os/RemoteException
    //   89	126	256	android/database/SQLException
    //   194	214	256	android/database/SQLException
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public Experience updateExperience(Experience paramExperience)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 8
    //   5: aload_1
    //   6: invokevirtual 1072	com/sonyericsson/extras/liveware/experience/Experience:isPictureNameUpdated	()Z
    //   9: ifeq +27 -> 36
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 219	com/sonyericsson/extras/liveware/experience/Experience:getId	()J
    //   17: invokevirtual 1074	com/sonyericsson/extras/liveware/experience/ExperienceManager:getExperience	(J)Lcom/sonyericsson/extras/liveware/experience/Experience;
    //   20: invokevirtual 842	com/sonyericsson/extras/liveware/experience/Experience:getPictureName	()Ljava/lang/String;
    //   23: astore 8
    //   25: aload 8
    //   27: invokestatic 845	com/sonyericsson/extras/liveware/experience/Experience:isExternalStorageEventPicture	(Ljava/lang/String;)Z
    //   30: ifne +6 -> 36
    //   33: aconst_null
    //   34: astore 8
    //   36: ldc2_w 727
    //   39: lstore 10
    //   41: aload_1
    //   42: invokevirtual 1077	com/sonyericsson/extras/liveware/experience/Experience:updateTime	()Z
    //   45: istore_2
    //   46: iconst_0
    //   47: istore 4
    //   49: ldc2_w 727
    //   52: lstore 6
    //   54: aload_1
    //   55: invokevirtual 1080	com/sonyericsson/extras/liveware/experience/Experience:updateEnabledState	()Z
    //   58: istore_3
    //   59: aload_1
    //   60: invokevirtual 1082	com/sonyericsson/extras/liveware/experience/Experience:updateDevice	()Z
    //   63: istore 5
    //   65: iconst_0
    //   66: istore 9
    //   68: aload_0
    //   69: invokespecial 730	com/sonyericsson/extras/liveware/experience/ExperienceManager:setDatabase	()V
    //   72: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   75: invokevirtual 733	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   78: iconst_1
    //   79: istore 9
    //   81: aload_1
    //   82: invokevirtual 1077	com/sonyericsson/extras/liveware/experience/Experience:updateTime	()Z
    //   85: ifeq +58 -> 143
    //   88: aload_1
    //   89: invokevirtual 736	com/sonyericsson/extras/liveware/experience/Experience:getTime	()Lcom/sonyericsson/extras/liveware/experience/Time;
    //   92: astore 12
    //   94: aload 12
    //   96: ifnull +303 -> 399
    //   99: aload 12
    //   101: invokevirtual 737	com/sonyericsson/extras/liveware/experience/Time:getId	()J
    //   104: lstore 10
    //   106: lload 10
    //   108: ldc2_w 727
    //   111: lcmp
    //   112: ifne +139 -> 251
    //   115: aload 12
    //   117: invokevirtual 741	com/sonyericsson/extras/liveware/experience/Time:getInsertContentValues	()Landroid/content/ContentValues;
    //   120: astore 10
    //   122: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   125: ldc_w 743
    //   128: aconst_null
    //   129: aload 10
    //   131: invokevirtual 747	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   134: lstore 10
    //   136: aload 12
    //   138: lload 10
    //   140: invokevirtual 668	com/sonyericsson/extras/liveware/experience/Time:setId	(J)V
    //   143: aload_1
    //   144: invokevirtual 1083	com/sonyericsson/extras/liveware/experience/Experience:getUpdateContentValues	()Landroid/content/ContentValues;
    //   147: astore 13
    //   149: aload 13
    //   151: invokevirtual 472	android/content/ContentValues:size	()I
    //   154: ifne +318 -> 472
    //   157: invokestatic 60	com/sonyericsson/extras/liveware/utils/Dbg:w	()Z
    //   160: ifeq +10 -> 170
    //   163: ldc_w 1085
    //   166: invokestatic 76	com/sonyericsson/extras/liveware/utils/Dbg:w	(Ljava/lang/String;)Z
    //   169: pop
    //   170: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   173: astore 10
    //   175: aload 10
    //   177: ifnull +14 -> 191
    //   180: iload 9
    //   182: ifeq +9 -> 191
    //   185: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   188: invokevirtual 785	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   191: iload_2
    //   192: ifne +12 -> 204
    //   195: iload_3
    //   196: ifne +8 -> 204
    //   199: iload 5
    //   201: ifeq +32 -> 233
    //   204: iload 4
    //   206: ifeq +18 -> 224
    //   209: lload 6
    //   211: ldc2_w 727
    //   214: lcmp
    //   215: ifeq +9 -> 224
    //   218: aload_0
    //   219: lload 6
    //   221: invokevirtual 1087	com/sonyericsson/extras/liveware/experience/ExperienceManager:deleteTime	(J)V
    //   224: aload_0
    //   225: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   228: aload_1
    //   229: iload_2
    //   230: invokestatic 1093	com/sonyericsson/extras/liveware/asf/ExperienceService:startExperienceUpdated	(Landroid/content/Context;Lcom/sonyericsson/extras/liveware/experience/Experience;Z)V
    //   233: aload 8
    //   235: ifnull +12 -> 247
    //   238: aload_0
    //   239: aload 8
    //   241: invokestatic 849	com/sonyericsson/extras/liveware/experience/Experience:getEventPictureFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   244: invokespecial 851	com/sonyericsson/extras/liveware/experience/ExperienceManager:deleteFile	(Ljava/lang/String;)V
    //   247: aload_0
    //   248: monitorexit
    //   249: aload_1
    //   250: areturn
    //   251: aload 12
    //   253: invokevirtual 802	com/sonyericsson/extras/liveware/experience/Time:getUpdateContentValues	()Landroid/content/ContentValues;
    //   256: astore 14
    //   258: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   261: astore 13
    //   263: iconst_1
    //   264: anewarray 41	java/lang/String
    //   267: astore 15
    //   269: aload 15
    //   271: iconst_0
    //   272: lload 10
    //   274: invokestatic 772	java/lang/Long:toString	(J)Ljava/lang/String;
    //   277: aastore
    //   278: aload 13
    //   280: ldc_w 743
    //   283: aload 14
    //   285: ldc_w 804
    //   288: aload 15
    //   290: invokevirtual 808	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   293: pop
    //   294: aload 12
    //   296: invokevirtual 811	com/sonyericsson/extras/liveware/experience/Time:resetChangedFlags	()V
    //   299: goto -156 -> 143
    //   302: astore 10
    //   304: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   307: ifeq +12 -> 319
    //   310: ldc_w 1095
    //   313: aload 10
    //   315: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   318: pop
    //   319: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   322: astore 8
    //   324: aload 8
    //   326: ifnull +14 -> 340
    //   329: iload 9
    //   331: ifeq +9 -> 340
    //   334: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   337: invokevirtual 785	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   340: iload_2
    //   341: ifne +12 -> 353
    //   344: iload_3
    //   345: ifne +8 -> 353
    //   348: iload 5
    //   350: ifeq +32 -> 382
    //   353: iload 4
    //   355: ifeq +18 -> 373
    //   358: lload 6
    //   360: ldc2_w 727
    //   363: lcmp
    //   364: ifeq +9 -> 373
    //   367: aload_0
    //   368: lload 6
    //   370: invokevirtual 1087	com/sonyericsson/extras/liveware/experience/ExperienceManager:deleteTime	(J)V
    //   373: aload_0
    //   374: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   377: aload_1
    //   378: iload_2
    //   379: invokestatic 1093	com/sonyericsson/extras/liveware/asf/ExperienceService:startExperienceUpdated	(Landroid/content/Context;Lcom/sonyericsson/extras/liveware/experience/Experience;Z)V
    //   382: iconst_0
    //   383: ifeq +11 -> 394
    //   386: aload_0
    //   387: aconst_null
    //   388: invokestatic 849	com/sonyericsson/extras/liveware/experience/Experience:getEventPictureFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   391: invokespecial 851	com/sonyericsson/extras/liveware/experience/ExperienceManager:deleteFile	(Ljava/lang/String;)V
    //   394: aconst_null
    //   395: astore_1
    //   396: goto -149 -> 247
    //   399: iconst_1
    //   400: istore 4
    //   402: aload_1
    //   403: invokevirtual 1098	com/sonyericsson/extras/liveware/experience/Experience:getOldTimeId	()J
    //   406: lstore 6
    //   408: lload 6
    //   410: lstore 6
    //   412: goto -269 -> 143
    //   415: astore 9
    //   417: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   420: ifeq -229 -> 191
    //   423: ldc_w 823
    //   426: aload 9
    //   428: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   431: pop
    //   432: goto -241 -> 191
    //   435: astore_2
    //   436: aload_0
    //   437: monitorexit
    //   438: aload_2
    //   439: athrow
    //   440: pop
    //   441: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   444: ifeq -220 -> 224
    //   447: new 62	java/lang/StringBuilder
    //   450: dup
    //   451: ldc_w 1100
    //   454: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   457: lload 6
    //   459: invokevirtual 949	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   462: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   468: pop
    //   469: goto -245 -> 224
    //   472: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   475: astore 14
    //   477: iconst_1
    //   478: anewarray 41	java/lang/String
    //   481: astore 12
    //   483: aload 12
    //   485: iconst_0
    //   486: aload_1
    //   487: invokevirtual 219	com/sonyericsson/extras/liveware/experience/Experience:getId	()J
    //   490: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   493: aastore
    //   494: aload 14
    //   496: ldc_w 759
    //   499: aload 13
    //   501: ldc_w 608
    //   504: aload 12
    //   506: invokevirtual 808	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   509: i2l
    //   510: lstore 12
    //   512: lload 12
    //   514: ldc2_w 727
    //   517: lcmp
    //   518: ifle +392 -> 910
    //   521: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   524: invokevirtual 770	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   527: lload 10
    //   529: ldc2_w 727
    //   532: lcmp
    //   533: ifle +29 -> 562
    //   536: getstatic 632	com/sonyericsson/extras/liveware/db/ExperienceDef$TimeTriggerTable:URI	Landroid/net/Uri;
    //   539: lload 10
    //   541: invokestatic 772	java/lang/Long:toString	(J)Ljava/lang/String;
    //   544: invokestatic 778	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   547: astore 10
    //   549: aload_0
    //   550: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   553: invokevirtual 35	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   556: aload 10
    //   558: aconst_null
    //   559: invokevirtual 782	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   562: getstatic 487	com/sonyericsson/extras/liveware/db/ExperienceDef$ExperienceTable:URI	Landroid/net/Uri;
    //   565: lload 12
    //   567: invokestatic 772	java/lang/Long:toString	(J)Ljava/lang/String;
    //   570: invokestatic 778	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   573: astore 10
    //   575: aload_0
    //   576: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   579: invokevirtual 35	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   582: aload 10
    //   584: aconst_null
    //   585: invokevirtual 782	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   588: aload_1
    //   589: invokevirtual 1101	com/sonyericsson/extras/liveware/experience/Experience:resetChangedFlags	()V
    //   592: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   595: astore 10
    //   597: aload 10
    //   599: ifnull +14 -> 613
    //   602: iload 9
    //   604: ifeq +9 -> 613
    //   607: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   610: invokevirtual 785	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   613: iload_2
    //   614: ifne +12 -> 626
    //   617: iload_3
    //   618: ifne +8 -> 626
    //   621: iload 5
    //   623: ifeq +32 -> 655
    //   626: iload 4
    //   628: ifeq +18 -> 646
    //   631: lload 6
    //   633: ldc2_w 727
    //   636: lcmp
    //   637: ifeq +9 -> 646
    //   640: aload_0
    //   641: lload 6
    //   643: invokevirtual 1087	com/sonyericsson/extras/liveware/experience/ExperienceManager:deleteTime	(J)V
    //   646: aload_0
    //   647: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   650: aload_1
    //   651: iload_2
    //   652: invokestatic 1093	com/sonyericsson/extras/liveware/asf/ExperienceService:startExperienceUpdated	(Landroid/content/Context;Lcom/sonyericsson/extras/liveware/experience/Experience;Z)V
    //   655: aload 8
    //   657: ifnull -410 -> 247
    //   660: aload_0
    //   661: aload 8
    //   663: invokestatic 849	com/sonyericsson/extras/liveware/experience/Experience:getEventPictureFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   666: invokespecial 851	com/sonyericsson/extras/liveware/experience/ExperienceManager:deleteFile	(Ljava/lang/String;)V
    //   669: goto -422 -> 247
    //   672: astore 9
    //   674: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   677: ifeq -64 -> 613
    //   680: ldc_w 823
    //   683: aload 9
    //   685: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   688: pop
    //   689: goto -76 -> 613
    //   692: pop
    //   693: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   696: ifeq -50 -> 646
    //   699: new 62	java/lang/StringBuilder
    //   702: dup
    //   703: ldc_w 1100
    //   706: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   709: lload 6
    //   711: invokevirtual 949	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   714: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   720: pop
    //   721: goto -75 -> 646
    //   724: astore 8
    //   726: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   729: ifeq -389 -> 340
    //   732: ldc_w 823
    //   735: aload 8
    //   737: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   740: pop
    //   741: goto -401 -> 340
    //   744: pop
    //   745: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   748: ifeq -375 -> 373
    //   751: new 62	java/lang/StringBuilder
    //   754: dup
    //   755: ldc_w 1100
    //   758: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   761: lload 6
    //   763: invokevirtual 949	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   766: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   772: pop
    //   773: goto -400 -> 373
    //   776: astore 10
    //   778: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   781: astore 11
    //   783: aload 11
    //   785: ifnull +14 -> 799
    //   788: iload 9
    //   790: ifeq +9 -> 799
    //   793: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   796: invokevirtual 785	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   799: iload_2
    //   800: ifne +12 -> 812
    //   803: iload_3
    //   804: ifne +8 -> 812
    //   807: iload 5
    //   809: ifeq +32 -> 841
    //   812: iload 4
    //   814: ifeq +18 -> 832
    //   817: lload 6
    //   819: ldc2_w 727
    //   822: lcmp
    //   823: ifeq +9 -> 832
    //   826: aload_0
    //   827: lload 6
    //   829: invokevirtual 1087	com/sonyericsson/extras/liveware/experience/ExperienceManager:deleteTime	(J)V
    //   832: aload_0
    //   833: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   836: aload_1
    //   837: iload_2
    //   838: invokestatic 1093	com/sonyericsson/extras/liveware/asf/ExperienceService:startExperienceUpdated	(Landroid/content/Context;Lcom/sonyericsson/extras/liveware/experience/Experience;Z)V
    //   841: aload 8
    //   843: ifnull +12 -> 855
    //   846: aload_0
    //   847: aload 8
    //   849: invokestatic 849	com/sonyericsson/extras/liveware/experience/Experience:getEventPictureFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   852: invokespecial 851	com/sonyericsson/extras/liveware/experience/ExperienceManager:deleteFile	(Ljava/lang/String;)V
    //   855: aload 10
    //   857: athrow
    //   858: astore 9
    //   860: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   863: ifeq -64 -> 799
    //   866: ldc_w 823
    //   869: aload 9
    //   871: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   874: pop
    //   875: goto -76 -> 799
    //   878: pop
    //   879: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   882: ifeq -50 -> 832
    //   885: new 62	java/lang/StringBuilder
    //   888: dup
    //   889: ldc_w 1100
    //   892: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   895: lload 6
    //   897: invokevirtual 949	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   900: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   906: pop
    //   907: goto -75 -> 832
    //   910: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   913: astore 10
    //   915: aload 10
    //   917: ifnull +14 -> 931
    //   920: iload 9
    //   922: ifeq +9 -> 931
    //   925: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   928: invokevirtual 785	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   931: iload_2
    //   932: ifne +12 -> 944
    //   935: iload_3
    //   936: ifne +8 -> 944
    //   939: iload 5
    //   941: ifeq +32 -> 973
    //   944: iload 4
    //   946: ifeq +18 -> 964
    //   949: lload 6
    //   951: ldc2_w 727
    //   954: lcmp
    //   955: ifeq +9 -> 964
    //   958: aload_0
    //   959: lload 6
    //   961: invokevirtual 1087	com/sonyericsson/extras/liveware/experience/ExperienceManager:deleteTime	(J)V
    //   964: aload_0
    //   965: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   968: aload_1
    //   969: iload_2
    //   970: invokestatic 1093	com/sonyericsson/extras/liveware/asf/ExperienceService:startExperienceUpdated	(Landroid/content/Context;Lcom/sonyericsson/extras/liveware/experience/Experience;Z)V
    //   973: aload 8
    //   975: ifnull +67 -> 1042
    //   978: aload_0
    //   979: aload 8
    //   981: invokestatic 849	com/sonyericsson/extras/liveware/experience/Experience:getEventPictureFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   984: invokespecial 851	com/sonyericsson/extras/liveware/experience/ExperienceManager:deleteFile	(Ljava/lang/String;)V
    //   987: goto +55 -> 1042
    //   990: astore 9
    //   992: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   995: ifeq -64 -> 931
    //   998: ldc_w 823
    //   1001: aload 9
    //   1003: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   1006: pop
    //   1007: goto -76 -> 931
    //   1010: pop
    //   1011: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   1014: ifeq -50 -> 964
    //   1017: new 62	java/lang/StringBuilder
    //   1020: dup
    //   1021: ldc_w 1100
    //   1024: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1027: lload 6
    //   1029: invokevirtual 949	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1032: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1035: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   1038: pop
    //   1039: goto -75 -> 964
    //   1042: aconst_null
    //   1043: astore_1
    //   1044: goto -797 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1047	0	this	ExperienceManager
    //   0	1047	1	paramExperience	Experience
    //   45	334	2	bool1	boolean
    //   435	535	2	localObject1	Object
    //   58	878	3	bool2	boolean
    //   47	898	4	i	int
    //   63	877	5	bool3	boolean
    //   52	976	6	l1	long
    //   3	659	8	localObject2	Object
    //   724	256	8	localSQLiteException1	SQLiteException
    //   66	264	9	j	int
    //   415	188	9	localSQLiteException2	SQLiteException
    //   672	117	9	localSQLiteException3	SQLiteException
    //   858	63	9	localSQLiteException4	SQLiteException
    //   990	12	9	localSQLiteException5	SQLiteException
    //   39	68	10	l2	long
    //   120	10	10	localContentValues	ContentValues
    //   134	5	10	l3	long
    //   173	100	10	localSQLiteDatabase1	SQLiteDatabase
    //   302	238	10	localSQLException	SQLException
    //   547	51	10	localObject3	Object
    //   776	80	10	localObject4	Object
    //   913	3	10	localSQLiteDatabase2	SQLiteDatabase
    //   781	3	11	localSQLiteDatabase3	SQLiteDatabase
    //   92	413	12	localObject5	Object
    //   510	56	12	l4	long
    //   147	353	13	localObject6	Object
    //   256	239	14	localObject7	Object
    //   267	22	15	arrayOfString	String[]
    //   440	1	29	localEmException1	EmException
    //   692	1	30	localEmException2	EmException
    //   744	1	31	localEmException3	EmException
    //   878	1	32	localEmException4	EmException
    //   1010	1	33	localEmException5	EmException
    // Exception table:
    //   from	to	target	type
    //   68	170	302	android/database/SQLException
    //   251	299	302	android/database/SQLException
    //   402	408	302	android/database/SQLException
    //   472	592	302	android/database/SQLException
    //   185	191	415	android/database/sqlite/SQLiteException
    //   5	65	435	finally
    //   170	175	435	finally
    //   185	191	435	finally
    //   218	224	435	finally
    //   224	247	435	finally
    //   319	324	435	finally
    //   334	340	435	finally
    //   367	373	435	finally
    //   373	394	435	finally
    //   417	432	435	finally
    //   441	469	435	finally
    //   592	597	435	finally
    //   607	613	435	finally
    //   640	646	435	finally
    //   646	783	435	finally
    //   793	799	435	finally
    //   826	832	435	finally
    //   832	915	435	finally
    //   925	931	435	finally
    //   958	964	435	finally
    //   964	1039	435	finally
    //   218	224	440	com/sonyericsson/extras/liveware/experience/ExperienceManager$EmException
    //   607	613	672	android/database/sqlite/SQLiteException
    //   640	646	692	com/sonyericsson/extras/liveware/experience/ExperienceManager$EmException
    //   334	340	724	android/database/sqlite/SQLiteException
    //   367	373	744	com/sonyericsson/extras/liveware/experience/ExperienceManager$EmException
    //   68	170	776	finally
    //   251	299	776	finally
    //   304	319	776	finally
    //   402	408	776	finally
    //   472	592	776	finally
    //   793	799	858	android/database/sqlite/SQLiteException
    //   826	832	878	com/sonyericsson/extras/liveware/experience/ExperienceManager$EmException
    //   925	931	990	android/database/sqlite/SQLiteException
    //   958	964	1010	com/sonyericsson/extras/liveware/experience/ExperienceManager$EmException
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void updateFeature(Feature.FeatureEditor paramFeatureEditor)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 1109	com/sonyericsson/extras/liveware/experience/Feature$FeatureEditor:getFeature	()Lcom/sonyericsson/extras/liveware/experience/Feature;
    //   6: astore 4
    //   8: aload_1
    //   9: invokevirtual 1110	com/sonyericsson/extras/liveware/experience/Feature$FeatureEditor:getUpdatedValues	()Landroid/content/ContentValues;
    //   12: astore_3
    //   13: iconst_1
    //   14: anewarray 41	java/lang/String
    //   17: astore_2
    //   18: aload_2
    //   19: iconst_0
    //   20: aload 4
    //   22: invokevirtual 1008	com/sonyericsson/extras/liveware/experience/Feature:getId	()J
    //   25: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   28: aastore
    //   29: aload_0
    //   30: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   33: getstatic 497	com/sonyericsson/extras/liveware/db/ExperienceDef$FeatureTable:URI	Landroid/net/Uri;
    //   36: aload_3
    //   37: ldc_w 350
    //   40: aload_2
    //   41: invokevirtual 1027	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   44: pop
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: pop
    //   49: ldc_w 1112
    //   52: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   55: pop
    //   56: goto -11 -> 45
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	ExperienceManager
    //   0	64	1	paramFeatureEditor	Feature.FeatureEditor
    //   17	24	2	arrayOfString	String[]
    //   59	4	2	localObject	Object
    //   12	25	3	localContentValues	ContentValues
    //   6	15	4	localFeature	Feature
    //   48	1	6	localSQLException	SQLException
    // Exception table:
    //   from	to	target	type
    //   29	45	48	android/database/SQLException
    //   2	29	59	finally
    //   29	45	59	finally
    //   49	56	59	finally
  }
  
  /**
   * @deprecated
   */
  public void updateMigratedFromOldDb()
  {
    int i = 1;
    for (;;)
    {
      if (i > 10) {
        return;
      }
      try
      {
        if (Dbg.d()) {
          Dbg.e("updateMigratedFromOldDb toVersion " + i);
        }
        setDatabase();
        ExperienceDatabaseHelper.updateToVersion(sDatabase, i);
        i++;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          Dbg.e(localSQLiteException);
        }
      }
      finally {}
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public boolean updateTime(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: lload_1
    //   7: invokevirtual 189	com/sonyericsson/extras/liveware/experience/ExperienceManager:getTime	(J)Lcom/sonyericsson/extras/liveware/experience/Time;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnonnull +8 -> 22
    //   17: aload_0
    //   18: monitorexit
    //   19: iload 6
    //   21: ireturn
    //   22: iconst_1
    //   23: istore 6
    //   25: aload 4
    //   27: iload_3
    //   28: invokevirtual 1129	com/sonyericsson/extras/liveware/experience/Time:setConnected	(Z)V
    //   31: aload 4
    //   33: invokevirtual 802	com/sonyericsson/extras/liveware/experience/Time:getUpdateContentValues	()Landroid/content/ContentValues;
    //   36: astore 5
    //   38: aload 5
    //   40: ifnull +47 -> 87
    //   43: aload 5
    //   45: invokevirtual 472	android/content/ContentValues:size	()I
    //   48: ifle +39 -> 87
    //   51: iconst_1
    //   52: anewarray 41	java/lang/String
    //   55: astore 7
    //   57: aload 7
    //   59: iconst_0
    //   60: aload 4
    //   62: invokevirtual 737	com/sonyericsson/extras/liveware/experience/Time:getId	()J
    //   65: invokestatic 567	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   68: aastore
    //   69: aload_0
    //   70: getfield 37	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContentResolver	Landroid/content/ContentResolver;
    //   73: getstatic 632	com/sonyericsson/extras/liveware/db/ExperienceDef$TimeTriggerTable:URI	Landroid/net/Uri;
    //   76: aload 5
    //   78: ldc_w 350
    //   81: aload 7
    //   83: invokevirtual 1027	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   86: pop
    //   87: aload 4
    //   89: invokevirtual 811	com/sonyericsson/extras/liveware/experience/Time:resetChangedFlags	()V
    //   92: goto -75 -> 17
    //   95: astore 4
    //   97: aload_0
    //   98: monitorexit
    //   99: aload 4
    //   101: athrow
    //   102: pop
    //   103: ldc_w 1131
    //   106: invokestatic 267	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   109: pop
    //   110: iconst_0
    //   111: istore 6
    //   113: aload 4
    //   115: invokevirtual 811	com/sonyericsson/extras/liveware/experience/Time:resetChangedFlags	()V
    //   118: goto -101 -> 17
    //   121: astore 5
    //   123: aload 4
    //   125: invokevirtual 811	com/sonyericsson/extras/liveware/experience/Time:resetChangedFlags	()V
    //   128: aload 5
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	ExperienceManager
    //   0	131	1	paramLong	long
    //   0	131	3	paramBoolean	boolean
    //   10	78	4	localTime	Time
    //   95	29	4	localObject1	Object
    //   36	41	5	localContentValues	ContentValues
    //   121	8	5	localObject2	Object
    //   1	111	6	bool	boolean
    //   55	27	7	arrayOfString	String[]
    //   102	1	9	localSQLException	SQLException
    // Exception table:
    //   from	to	target	type
    //   5	12	95	finally
    //   87	92	95	finally
    //   113	131	95	finally
    //   25	87	102	android/database/SQLException
    //   25	87	121	finally
    //   103	110	121	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public void updateUnmodifiedExperienceNames(List<Experience> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 369	android/content/ContentValues
    //   5: dup
    //   6: invokespecial 370	android/content/ContentValues:<init>	()V
    //   9: astore 4
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: invokespecial 730	com/sonyericsson/extras/liveware/experience/ExperienceManager:setDatabase	()V
    //   17: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   20: invokevirtual 733	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   23: iconst_1
    //   24: istore_2
    //   25: aload_1
    //   26: invokeinterface 764 1 0
    //   31: astore_3
    //   32: aload_3
    //   33: invokeinterface 702 1 0
    //   38: ifne +30 -> 68
    //   41: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   44: invokevirtual 770	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   47: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +13 -> 65
    //   55: iload_2
    //   56: ifeq +9 -> 65
    //   59: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   62: invokevirtual 785	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: aload_3
    //   69: invokeinterface 706 1 0
    //   74: checkcast 209	com/sonyericsson/extras/liveware/experience/Experience
    //   77: astore 5
    //   79: aload 4
    //   81: ldc 197
    //   83: aload 5
    //   85: invokevirtual 1135	com/sonyericsson/extras/liveware/experience/Experience:getName	()Ljava/lang/String;
    //   88: invokevirtual 418	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   94: ldc_w 759
    //   97: aload 4
    //   99: new 62	java/lang/StringBuilder
    //   102: dup
    //   103: ldc_w 1137
    //   106: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: aload 5
    //   111: invokevirtual 219	com/sonyericsson/extras/liveware/experience/Experience:getId	()J
    //   114: invokestatic 772	java/lang/Long:toString	(J)Ljava/lang/String;
    //   117: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: aconst_null
    //   124: invokevirtual 808	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   127: pop
    //   128: getstatic 487	com/sonyericsson/extras/liveware/db/ExperienceDef$ExperienceTable:URI	Landroid/net/Uri;
    //   131: aload 5
    //   133: invokevirtual 219	com/sonyericsson/extras/liveware/experience/Experience:getId	()J
    //   136: invokestatic 772	java/lang/Long:toString	(J)Ljava/lang/String;
    //   139: invokestatic 778	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   142: astore 5
    //   144: aload_0
    //   145: getfield 29	com/sonyericsson/extras/liveware/experience/ExperienceManager:mContext	Landroid/content/Context;
    //   148: invokevirtual 35	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   151: aload 5
    //   153: aconst_null
    //   154: invokevirtual 782	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   157: goto -125 -> 32
    //   160: astore_3
    //   161: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   164: ifeq +11 -> 175
    //   167: ldc_w 1139
    //   170: aload_3
    //   171: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   174: pop
    //   175: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   178: astore_3
    //   179: aload_3
    //   180: ifnull -115 -> 65
    //   183: iload_2
    //   184: ifeq -119 -> 65
    //   187: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   190: invokevirtual 785	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   193: goto -128 -> 65
    //   196: astore_2
    //   197: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   200: ifeq -135 -> 65
    //   203: ldc_w 823
    //   206: aload_2
    //   207: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   210: pop
    //   211: goto -146 -> 65
    //   214: astore_2
    //   215: aload_0
    //   216: monitorexit
    //   217: aload_2
    //   218: athrow
    //   219: astore_3
    //   220: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   223: astore 4
    //   225: aload 4
    //   227: ifnull +13 -> 240
    //   230: iload_2
    //   231: ifeq +9 -> 240
    //   234: getstatic 644	com/sonyericsson/extras/liveware/experience/ExperienceManager:sDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   237: invokevirtual 785	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   240: aload_3
    //   241: athrow
    //   242: astore_2
    //   243: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   246: ifeq -6 -> 240
    //   249: ldc_w 823
    //   252: aload_2
    //   253: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   256: pop
    //   257: goto -17 -> 240
    //   260: astore_2
    //   261: invokestatic 170	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   264: ifeq -199 -> 65
    //   267: ldc_w 823
    //   270: aload_2
    //   271: invokestatic 175	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   274: pop
    //   275: goto -210 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	ExperienceManager
    //   0	278	1	paramList	List<Experience>
    //   12	172	2	i	int
    //   196	11	2	localSQLiteException1	SQLiteException
    //   214	17	2	localObject1	Object
    //   242	11	2	localSQLiteException2	SQLiteException
    //   260	11	2	localSQLiteException3	SQLiteException
    //   31	38	3	localObject2	Object
    //   160	11	3	localSQLException	SQLException
    //   178	2	3	localSQLiteDatabase	SQLiteDatabase
    //   219	22	3	localObject3	Object
    //   9	217	4	localObject4	Object
    //   77	75	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   13	47	160	android/database/SQLException
    //   68	157	160	android/database/SQLException
    //   187	193	196	android/database/sqlite/SQLiteException
    //   2	11	214	finally
    //   47	51	214	finally
    //   59	65	214	finally
    //   175	179	214	finally
    //   187	193	214	finally
    //   197	211	214	finally
    //   220	225	214	finally
    //   234	240	214	finally
    //   240	275	214	finally
    //   13	47	219	finally
    //   68	157	219	finally
    //   161	175	219	finally
    //   234	240	242	android/database/sqlite/SQLiteException
    //   59	65	260	android/database/sqlite/SQLiteException
  }
  
  public static class EmException
    extends Exception
  {
    private static final long serialVersionUID = 9169688435610463663L;
    
    public EmException() {}
    
    public EmException(String paramString)
    {
      super();
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.experience.ExperienceManager
 * JD-Core Version:    0.7.0.1
 */