package com.sonyericsson.extras.liveware.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.asf.DeviceServiceHandler;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.Feature;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.ExperienceUtils;
import com.sonyericsson.extras.liveware.utils.PackageUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

public class LegacyDbUpgrader
{
  private static final String ACCESSORY_BEARER_TYPE_COLUMN = "bearer_type";
  private static final String ACCESSORY_CONNECTED_COLUMN = "connected";
  private static final String ACCESSORY_EDUCATION_LEVEL_COLUMN = "education_level";
  private static final String ACCESSORY_ICON_URL_COLUMN = "icon_url";
  private static final String ACCESSORY_NAME_COLUMN = "name";
  private static final String ACCESSORY_NOTIFY_EXTERNAL_COLUMN = "notify_external";
  private static final String ACCESSORY_REMOVABLE_COLUMN = "removable";
  private static final String ACCESSORY_TABLE = "accessories";
  private static final String ACCESSORY_TYPE_COLUMN = "type";
  private static final String ACCESSORY_USER_DEFINED_NAME_CHANGED_COLUMN = "user_defined_name_changed";
  private static final String ACCESSORY_USER_DEFINED_NAME_COLUMN = "user_defined_name";
  private static final String APP_LAUNCH_ACTION = "com.sonyericsson.extras.liveware.actions.launchapp.LaunchApp";
  private static final String FEATURE_ACCESSORY_ID_COLUMN = "accessory_id";
  private static final int FEATURE_APPLAUNCH = 1;
  public static final String FEATURE_APPSELECTION_COLUMN = "app_selection";
  private static final String FEATURE_CLASS_NAME_COLUMN = "class_name";
  private static final String FEATURE_COMPANION_NAME_COLUMN = "companion_name";
  private static final String FEATURE_COMPANION_PKG_COLUMN = "companion_pkg";
  public static final String FEATURE_ENABLED_COLUMN = "enabled";
  private static final String FEATURE_INTENT_COLUMN = "intent";
  private static final String FEATURE_MODIFIED_BY_USER_COLUMN = "modified_by_user";
  private static final String FEATURE_PACKAGE_NAME_COLUMN = "package_name";
  private static final String FEATURE_TABLE = "features";
  private static final String FEATURE_TYPE_COLUMN = "type";
  private static final String ID_COLUMN = "_id";
  private static final String OLD_DB_NAME = "asf.db";
  public static final int STATE_DISABLED = 0;
  public static final int STATE_ENABLED = 1;
  public static final int STATE_SETUP = 2;
  private static final ReentrantLock mLock = new ReentrantLock();
  private final Context mContext;
  
  public LegacyDbUpgrader(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private int convertEnableState(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
      paramInt = 0;
      break;
    case 1: 
      paramInt = 2;
      break;
    case 2: 
      paramInt = 1;
    }
    return paramInt;
  }
  
  private Experience convertToExperience(Device paramDevice)
  {
    int i = 0;
    Experience localExperience = new Experience(paramDevice.getProductName(), null, paramDevice, null, null, 0L, 1, null);
    List localList = paramDevice.getFeatureList();
    Object localObject = null;
    int j = 1;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      Feature localFeature = (Feature)localIterator.next();
      if (localFeature.getType() != 1)
      {
        j = 0;
      }
      else
      {
        localExperience.setEnabledState(convertEnableState(localFeature.getState()));
        localObject = new StringBuilder();
        if (TextUtils.isEmpty(localFeature.getPackageName()))
        {
          if (!TextUtils.isEmpty(localFeature.getClassName())) {
            ((StringBuilder)localObject).append(localFeature.getClassName());
          }
        }
        else
        {
          ((StringBuilder)localObject).append(localFeature.getPackageName());
          if (!TextUtils.isEmpty(localFeature.getClassName()))
          {
            ((StringBuilder)localObject).append("/");
            ((StringBuilder)localObject).append(localFeature.getClassName());
          }
        }
        localObject = new ActionSet(ExperienceManager.getInstance(this.mContext).getActionByClass("com.sonyericsson.extras.liveware.actions.launchapp.LaunchApp"), 0L, 0, 1, ((StringBuilder)localObject).toString(), "", UUID.randomUUID(), 2);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject);
        localExperience.setStartActions(localArrayList);
        localObject = localFeature;
        if (isApplaunchEnabled(localFeature)) {
          i = 1;
        }
      }
    }
    if (localObject != null) {
      localList.remove(localObject);
    }
    if ((j != 0) && (i == 0))
    {
      localExperience = DeviceServiceHandler.getPreconfigExperience(this.mContext, paramDevice.getProductId(), paramDevice.getBearerType());
      if (localExperience != null) {
        localExperience.setEnabledState(0);
      }
    }
    return localExperience;
  }
  
  private List<Experience> convertToExperiences(List<Device> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Device localDevice = (Device)localIterator.next();
        Experience localExperience = convertToExperience(localDevice);
        if (localExperience != null) {
          localArrayList.add(localExperience);
        }
        localDevice.setId(0L);
      }
    }
    return localArrayList;
  }
  
  private void deleteOldDb(SQLiteDatabase paramSQLiteDatabase)
  {
    if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.isOpen())) {
      paramSQLiteDatabase.close();
    }
    this.mContext.deleteDatabase("asf.db");
  }
  
  /* Error */
  private ArrayList<Device> getAccessories(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 204	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 205	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 4
    //   13: aload_1
    //   14: ldc 29
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 266	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore_2
    //   26: aload_2
    //   27: invokeinterface 271 1 0
    //   32: istore 5
    //   34: iload 5
    //   36: ifne +18 -> 54
    //   39: aload_2
    //   40: ifnull +9 -> 49
    //   43: aload_2
    //   44: invokeinterface 272 1 0
    //   49: aload 4
    //   51: pop
    //   52: aload_3
    //   53: areturn
    //   54: iconst_0
    //   55: istore 6
    //   57: aload_2
    //   58: aload_2
    //   59: ldc 23
    //   61: invokeinterface 276 2 0
    //   66: invokeinterface 279 2 0
    //   71: istore 5
    //   73: iload 5
    //   75: iconst_1
    //   76: if_icmpne +332 -> 408
    //   79: iconst_1
    //   80: istore 6
    //   82: new 157	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   89: astore 9
    //   91: aload_2
    //   92: aload_2
    //   93: ldc 17
    //   95: invokeinterface 282 2 0
    //   100: invokeinterface 286 2 0
    //   105: astore 7
    //   107: aconst_null
    //   108: astore 5
    //   110: aload 7
    //   112: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifne +46 -> 161
    //   118: aload 9
    //   120: ldc_w 288
    //   123: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 9
    //   129: aload 7
    //   131: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: new 157	java/lang/StringBuilder
    //   138: dup
    //   139: aload 9
    //   141: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 294	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   147: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: ldc_w 299
    //   153: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: astore 5
    //   161: aload_2
    //   162: aload_2
    //   163: ldc 20
    //   165: invokeinterface 282 2 0
    //   170: invokeinterface 286 2 0
    //   175: astore 7
    //   177: aload_2
    //   178: aload_2
    //   179: ldc 38
    //   181: invokeinterface 282 2 0
    //   186: invokeinterface 286 2 0
    //   191: astore 8
    //   193: aload 9
    //   195: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore 13
    //   200: aload_2
    //   201: aload_2
    //   202: ldc 8
    //   204: invokeinterface 282 2 0
    //   209: invokeinterface 279 2 0
    //   214: istore 12
    //   216: aload_2
    //   217: aload_2
    //   218: ldc 32
    //   220: invokeinterface 282 2 0
    //   225: invokeinterface 279 2 0
    //   230: istore 9
    //   232: aload_2
    //   233: aload_2
    //   234: ldc 11
    //   236: invokeinterface 282 2 0
    //   241: invokeinterface 279 2 0
    //   246: iconst_1
    //   247: if_icmpne +167 -> 414
    //   250: iconst_1
    //   251: istore 11
    //   253: aload_2
    //   254: aload_2
    //   255: ldc 26
    //   257: invokeinterface 282 2 0
    //   262: invokeinterface 279 2 0
    //   267: iconst_1
    //   268: if_icmpne +152 -> 420
    //   271: iconst_1
    //   272: istore 10
    //   274: new 111	com/sonyericsson/extras/liveware/experience/Device
    //   277: dup
    //   278: aload 7
    //   280: aload 8
    //   282: aload 13
    //   284: iload 12
    //   286: iload 9
    //   288: iload 11
    //   290: iload 10
    //   292: iload 6
    //   294: aload 5
    //   296: ldc2_w 116
    //   299: invokespecial 302	com/sonyericsson/extras/liveware/experience/Device:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZZZLjava/lang/String;J)V
    //   302: astore 4
    //   304: aload 4
    //   306: aload_2
    //   307: aload_2
    //   308: ldc 14
    //   310: invokeinterface 276 2 0
    //   315: invokeinterface 279 2 0
    //   320: invokevirtual 305	com/sonyericsson/extras/liveware/experience/Device:setEducationLevel	(I)V
    //   323: aload_2
    //   324: aload_2
    //   325: ldc 35
    //   327: invokeinterface 282 2 0
    //   332: invokeinterface 279 2 0
    //   337: iconst_1
    //   338: if_icmpne +88 -> 426
    //   341: iconst_1
    //   342: istore 5
    //   344: aload 4
    //   346: iload 5
    //   348: invokevirtual 309	com/sonyericsson/extras/liveware/experience/Device:setUserDefinedNameChanged	(Z)V
    //   351: aload 4
    //   353: aload_2
    //   354: aload_2
    //   355: ldc 78
    //   357: invokeinterface 282 2 0
    //   362: invokeinterface 313 2 0
    //   367: invokevirtual 240	com/sonyericsson/extras/liveware/experience/Device:setId	(J)V
    //   370: aload_0
    //   371: aload_1
    //   372: aload 4
    //   374: invokespecial 317	com/sonyericsson/extras/liveware/db/LegacyDbUpgrader:getFeatures	(Landroid/database/sqlite/SQLiteDatabase;Lcom/sonyericsson/extras/liveware/experience/Device;)Ljava/util/ArrayList;
    //   377: astore 5
    //   379: aload 5
    //   381: invokevirtual 320	java/util/ArrayList:size	()I
    //   384: ifle +10 -> 394
    //   387: aload 4
    //   389: aload 5
    //   391: invokevirtual 323	com/sonyericsson/extras/liveware/experience/Device:addFeatures	(Ljava/util/List;)V
    //   394: aload_3
    //   395: aload 4
    //   397: invokevirtual 209	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   400: pop
    //   401: aload 4
    //   403: astore 4
    //   405: goto -379 -> 26
    //   408: iconst_0
    //   409: istore 6
    //   411: goto -329 -> 82
    //   414: iconst_0
    //   415: istore 11
    //   417: goto -164 -> 253
    //   420: iconst_0
    //   421: istore 10
    //   423: goto -149 -> 274
    //   426: iconst_0
    //   427: istore 5
    //   429: goto -85 -> 344
    //   432: astore 5
    //   434: aload 4
    //   436: pop
    //   437: ldc_w 325
    //   440: aload 5
    //   442: invokestatic 331	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   445: pop
    //   446: aload_2
    //   447: ifnull -395 -> 52
    //   450: aload_2
    //   451: invokeinterface 272 1 0
    //   456: goto -404 -> 52
    //   459: astore_3
    //   460: aload 4
    //   462: pop
    //   463: aload_2
    //   464: ifnull +9 -> 473
    //   467: aload_2
    //   468: invokeinterface 272 1 0
    //   473: aload_3
    //   474: athrow
    //   475: astore_3
    //   476: goto -13 -> 463
    //   479: astore 5
    //   481: goto -44 -> 437
    //   484: pop
    //   485: goto -134 -> 351
    //   488: pop
    //   489: goto -166 -> 323
    //   492: pop
    //   493: goto -411 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	496	0	this	LegacyDbUpgrader
    //   0	496	1	paramSQLiteDatabase	SQLiteDatabase
    //   1	467	2	localCursor	android.database.Cursor
    //   9	386	3	localArrayList1	ArrayList
    //   459	15	3	localObject1	Object
    //   475	1	3	localObject2	Object
    //   11	450	4	localDevice	Device
    //   32	3	5	bool1	boolean
    //   71	6	5	i	int
    //   108	187	5	str1	String
    //   342	5	5	bool2	boolean
    //   377	13	5	localArrayList2	ArrayList
    //   427	1	5	j	int
    //   432	9	5	localSQLException1	SQLException
    //   479	1	5	localSQLException2	SQLException
    //   55	355	6	bool3	boolean
    //   105	174	7	str2	String
    //   191	90	8	str3	String
    //   89	105	9	localStringBuilder	StringBuilder
    //   230	57	9	k	int
    //   272	150	10	bool4	boolean
    //   251	165	11	bool5	boolean
    //   214	71	12	m	int
    //   198	85	13	str4	String
    //   484	1	24	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   488	1	25	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   492	1	26	localIllegalArgumentException3	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   13	34	432	android/database/SQLException
    //   57	73	432	android/database/SQLException
    //   82	304	432	android/database/SQLException
    //   13	34	459	finally
    //   57	73	459	finally
    //   82	304	459	finally
    //   304	323	475	finally
    //   323	351	475	finally
    //   351	401	475	finally
    //   437	446	475	finally
    //   304	323	479	android/database/SQLException
    //   323	351	479	android/database/SQLException
    //   351	401	479	android/database/SQLException
    //   323	351	484	java/lang/IllegalArgumentException
    //   304	323	488	java/lang/IllegalArgumentException
    //   57	73	492	java/lang/IllegalArgumentException
  }
  
  /* Error */
  private ArrayList<Feature> getFeatures(SQLiteDatabase paramSQLiteDatabase, Device paramDevice)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 204	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 205	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 5
    //   14: iconst_1
    //   15: anewarray 290	java/lang/String
    //   18: astore 6
    //   20: aload 6
    //   22: iconst_0
    //   23: aload_2
    //   24: invokevirtual 335	com/sonyericsson/extras/liveware/experience/Device:getId	()J
    //   27: invokestatic 338	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   30: aastore
    //   31: aload_1
    //   32: ldc 74
    //   34: aconst_null
    //   35: ldc_w 340
    //   38: aload 6
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 266	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +16 -> 64
    //   51: aload_3
    //   52: invokeinterface 271 1 0
    //   57: istore 6
    //   59: iload 6
    //   61: ifne +19 -> 80
    //   64: aload_3
    //   65: ifnull +9 -> 74
    //   68: aload_3
    //   69: invokeinterface 272 1 0
    //   74: aload 5
    //   76: pop
    //   77: aload 4
    //   79: areturn
    //   80: new 142	com/sonyericsson/extras/liveware/experience/Feature
    //   83: dup
    //   84: aload_2
    //   85: aload_3
    //   86: aload_3
    //   87: ldc 32
    //   89: invokeinterface 282 2 0
    //   94: invokeinterface 279 2 0
    //   99: aload_3
    //   100: aload_3
    //   101: ldc 71
    //   103: invokeinterface 282 2 0
    //   108: invokeinterface 286 2 0
    //   113: aload_3
    //   114: aload_3
    //   115: ldc 53
    //   117: invokeinterface 282 2 0
    //   122: invokeinterface 286 2 0
    //   127: aload_3
    //   128: aload_3
    //   129: ldc 65
    //   131: invokeinterface 282 2 0
    //   136: invokeinterface 286 2 0
    //   141: aload_3
    //   142: aload_3
    //   143: ldc 50
    //   145: invokeinterface 282 2 0
    //   150: invokeinterface 279 2 0
    //   155: aload_3
    //   156: aload_3
    //   157: ldc 56
    //   159: invokeinterface 282 2 0
    //   164: invokeinterface 286 2 0
    //   169: aload_3
    //   170: aload_3
    //   171: ldc 59
    //   173: invokeinterface 282 2 0
    //   178: invokeinterface 286 2 0
    //   183: invokespecial 343	com/sonyericsson/extras/liveware/experience/Feature:<init>	(Lcom/sonyericsson/extras/liveware/experience/Device;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   186: astore 5
    //   188: aload_3
    //   189: aload_3
    //   190: ldc 68
    //   192: invokeinterface 282 2 0
    //   197: invokeinterface 279 2 0
    //   202: iconst_1
    //   203: if_icmpne +47 -> 250
    //   206: iconst_1
    //   207: istore 6
    //   209: aload 5
    //   211: iload 6
    //   213: invokevirtual 346	com/sonyericsson/extras/liveware/experience/Feature:setModifiedByUser	(Z)V
    //   216: aload 5
    //   218: aload_3
    //   219: aload_3
    //   220: ldc 62
    //   222: invokeinterface 282 2 0
    //   227: invokeinterface 279 2 0
    //   232: invokevirtual 349	com/sonyericsson/extras/liveware/experience/Feature:setState	(I)V
    //   235: aload 4
    //   237: aload 5
    //   239: invokevirtual 209	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   242: pop
    //   243: aload 5
    //   245: astore 5
    //   247: goto -200 -> 47
    //   250: iconst_0
    //   251: istore 6
    //   253: goto -44 -> 209
    //   256: astore 6
    //   258: aload 5
    //   260: pop
    //   261: invokestatic 351	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   264: ifeq +12 -> 276
    //   267: ldc_w 353
    //   270: aload 6
    //   272: invokestatic 331	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   275: pop
    //   276: aload_3
    //   277: ifnull -200 -> 77
    //   280: aload_3
    //   281: invokeinterface 272 1 0
    //   286: goto -209 -> 77
    //   289: astore 4
    //   291: aload 5
    //   293: pop
    //   294: aload_3
    //   295: ifnull +9 -> 304
    //   298: aload_3
    //   299: invokeinterface 272 1 0
    //   304: aload 4
    //   306: athrow
    //   307: astore 4
    //   309: goto -15 -> 294
    //   312: astore 6
    //   314: goto -53 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	LegacyDbUpgrader
    //   0	317	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	317	2	paramDevice	Device
    //   1	298	3	localCursor	android.database.Cursor
    //   9	227	4	localArrayList	ArrayList
    //   289	16	4	localObject1	Object
    //   307	1	4	localObject2	Object
    //   12	280	5	localFeature	Feature
    //   18	21	6	arrayOfString	String[]
    //   57	195	6	bool	boolean
    //   256	15	6	localSQLException1	SQLException
    //   312	1	6	localSQLException2	SQLException
    // Exception table:
    //   from	to	target	type
    //   14	59	256	android/database/SQLException
    //   80	188	256	android/database/SQLException
    //   14	59	289	finally
    //   80	188	289	finally
    //   188	243	307	finally
    //   261	276	307	finally
    //   188	243	312	android/database/SQLException
  }
  
  private boolean isApplaunchEnabled(Feature paramFeature)
  {
    boolean bool = false;
    if (paramFeature.getState() == 1)
    {
      String str = paramFeature.getPackageName();
      if (!TextUtils.isEmpty(str))
      {
        if (!PackageUtils.existsPackage(this.mContext, str))
        {
          Dbg.d("isApplaunchEnabled false, NOT exist: " + str);
        }
        else
        {
          Dbg.d("isApplaunchEnabled true, exist: " + str);
          bool = true;
        }
      }
      else {
        Dbg.d("isApplaunchEnabled false, empty packageName " + str);
      }
    }
    else
    {
      Dbg.d("isApplaunchEnabled false, state: " + paramFeature.getState());
    }
    return bool;
  }
  
  private SQLiteDatabase openOldDb()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    File localFile = this.mContext.getDatabasePath("asf.db");
    if (localFile.exists()) {}
    try
    {
      localObject1 = SQLiteDatabase.openDatabase(localFile.getPath(), null, 0);
      localObject2 = localObject1;
      localObject1 = localObject2;
    }
    catch (SQLiteException localSQLiteException)
    {
      label35:
      break label35;
    }
    return localObject1;
  }
  
  public void importOldDb()
  {
    mLock.lock();
    try
    {
      localSQLiteDatabase = openOldDb();
      if (localSQLiteDatabase == null) {
        return;
      }
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        SQLiteDatabase localSQLiteDatabase;
        Object localObject2;
        ExperienceManager localExperienceManager;
        Iterator localIterator;
        Dbg.e("failed in importOldDb", localSQLException);
        mLock.unlock();
      }
    }
    finally
    {
      mLock.unlock();
    }
    localObject2 = convertToExperiences(getAccessories(localSQLiteDatabase));
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localExperienceManager = ExperienceManager.getInstance(this.mContext);
      localIterator = ((List)localObject2).iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localExperienceManager.updateMigratedFromOldDb();
        deleteOldDb(localSQLiteDatabase);
        mLock.unlock();
        break;
      }
      localObject2 = (Experience)localIterator.next();
      ExperienceUtils.handleExperienceConfigData(this.mContext, localExperienceManager, (Experience)localObject2, 1);
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.db.LegacyDbUpgrader
 * JD-Core Version:    0.7.0.1
 */