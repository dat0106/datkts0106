package com.sonyericsson.extras.liveware.aef.notification.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Binder;
import com.sonyericsson.extras.liveware.aef.notification.NotificationInternal.EventImpl;
import com.sonyericsson.extras.liveware.aef.notification.NotificationInternal.SourceEventImpl;
import com.sonyericsson.extras.liveware.aef.notification.NotificationInternal.SourceImpl;
import com.sonyericsson.extras.liveware.aef.registration.provider.RegistrationDatabaseHelper;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.TreeMap;

public final class NotificationProvider
  extends ContentProvider
{
  private static NotificationPermission mNotificationPermission = new NotificationPermission();
  private static final int sCurrentApiVersion = 1;
  private static UriMatcher sUriMatcher = new UriMatcher(-1);
  private SQLiteOpenHelper mOpenHelper;
  private SQLiteOpenHelper mRegistrationDatabaseHelper;
  
  static
  {
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.notification", "source", 10);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.notification", "source/#", 15);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.notification", "event", 20);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.notification", "event/#", 25);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.notification", "read_status", 30);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.notification", "source_event", 35);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.notification", "source_event/#", 40);
  }
  
  /* Error */
  private Uri doInsert(Uri paramUri, ContentValues paramContentValues, String paramString, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokevirtual 63	android/content/ContentValues:size	()I
    //   8: ifne +9 -> 17
    //   11: aconst_null
    //   12: astore 6
    //   14: aload 6
    //   16: areturn
    //   17: new 59	android/content/ContentValues
    //   20: dup
    //   21: aload_2
    //   22: invokespecial 66	android/content/ContentValues:<init>	(Landroid/content/ContentValues;)V
    //   25: astore 8
    //   27: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   30: aload 8
    //   32: invokevirtual 69	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:checkForSqlInjectionAttempt	(Landroid/content/ContentValues;)V
    //   35: getstatic 30	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:sUriMatcher	Landroid/content/UriMatcher;
    //   38: aload_1
    //   39: invokevirtual 73	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   42: istore 6
    //   44: invokestatic 78	android/os/Binder:getCallingUid	()I
    //   47: istore 7
    //   49: iload 6
    //   51: lookupswitch	default:+25->76, 10:+187->238, 20:+35->86
    //   77: nop
    //   78: lstore 89
    //   80: ldc 80
    //   82: invokespecial 83	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   85: athrow
    //   86: ldc 42
    //   88: astore 6
    //   90: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   93: aload 8
    //   95: invokestatic 89	com/sonyericsson/extras/liveware/aef/notification/NotificationInternal$EventImpl:restrictedModifyColumns	()[Ljava/lang/String;
    //   98: invokevirtual 93	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:verifyContentValues	(Landroid/content/ContentValues;[Ljava/lang/String;)V
    //   101: aload 8
    //   103: ldc 95
    //   105: invokevirtual 98	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   108: aload 8
    //   110: ldc 95
    //   112: aload_3
    //   113: invokevirtual 102	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload 4
    //   118: invokevirtual 108	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   121: ifeq +208 -> 329
    //   124: iconst_0
    //   125: istore 7
    //   127: iload 7
    //   129: ifeq +8 -> 137
    //   132: aload 4
    //   134: invokevirtual 111	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   137: aload 4
    //   139: aload 6
    //   141: ldc 113
    //   143: aload 8
    //   145: invokevirtual 117	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   148: lstore 8
    //   150: invokestatic 122	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   153: ifeq +39 -> 192
    //   156: new 124	java/lang/StringBuilder
    //   159: dup
    //   160: ldc 126
    //   162: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: aload 6
    //   167: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc 133
    //   172: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: lload 8
    //   177: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: ldc 138
    //   182: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   191: pop
    //   192: iload 7
    //   194: ifeq +8 -> 202
    //   197: aload 4
    //   199: invokevirtual 148	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   202: iload 7
    //   204: ifeq +8 -> 212
    //   207: aload 4
    //   209: invokevirtual 151	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   212: aconst_null
    //   213: astore 6
    //   215: lload 8
    //   217: ldc2_w 152
    //   220: lcmp
    //   221: ifeq -207 -> 14
    //   224: aload_1
    //   225: lload 8
    //   227: invokestatic 159	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   230: invokestatic 165	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   233: astore 6
    //   235: goto -221 -> 14
    //   238: ldc 34
    //   240: astore 6
    //   242: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   245: aload 8
    //   247: invokestatic 168	com/sonyericsson/extras/liveware/aef/notification/NotificationInternal$SourceImpl:restrictedModifyColumns	()[Ljava/lang/String;
    //   250: invokevirtual 93	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:verifyContentValues	(Landroid/content/ContentValues;[Ljava/lang/String;)V
    //   253: aload_0
    //   254: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   257: invokevirtual 178	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   260: iload 7
    //   262: invokevirtual 184	android/content/pm/PackageManager:getPackagesForUid	(I)[Ljava/lang/String;
    //   265: astore 9
    //   267: aload 9
    //   269: ifnull +28 -> 297
    //   272: aload 9
    //   274: arraylength
    //   275: iconst_1
    //   276: if_icmpne +21 -> 297
    //   279: aload 8
    //   281: ldc 186
    //   283: invokevirtual 98	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   286: aload 8
    //   288: ldc 186
    //   290: aload 9
    //   292: iconst_0
    //   293: aaload
    //   294: invokevirtual 102	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   300: iload 7
    //   302: aload_0
    //   303: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   306: aload 8
    //   308: invokevirtual 190	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:verifyPackage	(ILandroid/content/Context;Landroid/content/ContentValues;)V
    //   311: aload 8
    //   313: ldc 95
    //   315: invokevirtual 98	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   318: aload 8
    //   320: ldc 95
    //   322: aload_3
    //   323: invokevirtual 102	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: goto -210 -> 116
    //   329: iconst_1
    //   330: istore 7
    //   332: goto -205 -> 127
    //   335: astore 8
    //   337: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   340: ifeq +26 -> 366
    //   343: new 124	java/lang/StringBuilder
    //   346: dup
    //   347: ldc 195
    //   349: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   352: aload 6
    //   354: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: aload 8
    //   362: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   365: pop
    //   366: aload 8
    //   368: athrow
    //   369: astore 6
    //   371: iload 7
    //   373: ifeq +8 -> 381
    //   376: aload 4
    //   378: invokevirtual 151	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   381: aload 6
    //   383: athrow
    //   384: astore 7
    //   386: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   389: ifeq -8 -> 381
    //   392: ldc 200
    //   394: aload 7
    //   396: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   399: pop
    //   400: goto -19 -> 381
    //   403: astore 6
    //   405: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   408: ifeq -196 -> 212
    //   411: ldc 200
    //   413: aload 6
    //   415: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   418: pop
    //   419: goto -207 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	NotificationProvider
    //   0	422	1	paramUri	Uri
    //   0	422	2	paramContentValues	ContentValues
    //   0	422	3	paramString	String
    //   0	422	4	paramSQLiteDatabase	SQLiteDatabase
    //   0	422	5	paramInt	int
    //   12	3	6	localUri	Uri
    //   42	8	6	i	int
    //   88	265	6	localObject1	Object
    //   369	13	6	localObject2	Object
    //   403	11	6	localSQLiteException1	SQLiteException
    //   47	325	7	j	int
    //   384	11	7	localSQLiteException2	SQLiteException
    //   25	119	8	localContentValues	ContentValues
    //   148	171	8	l	long
    //   335	32	8	localSQLException	SQLException
    //   265	26	9	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   137	202	335	android/database/SQLException
    //   137	202	369	finally
    //   337	369	369	finally
    //   376	381	384	android/database/sqlite/SQLiteException
    //   207	212	403	android/database/sqlite/SQLiteException
  }
  
  private int getEventIdOfSelection(String paramString, String[] paramArrayOfString)
  {
    if (!paramString.matches(".*_id\\s*=\\s*\\?.*"))
    {
      if (paramString.matches(".*_id\\s*=\\s*'?[0-9]+'?.*")) {
        for (int i = paramString.indexOf("_id") + "_id".length();; j++) {
          if ((i >= paramString.length()) || (Character.isDigit(paramString.charAt(i))))
          {
            Number localNumber = NumberFormat.getInstance().parse(paramString, new ParsePosition(i));
            if (localNumber == null) {
              break;
            }
            return localNumber.intValue();
          }
        }
      }
    }
    else
    {
      int m = paramString.indexOf("_id");
      j = 0;
      for (int k = 0; k < m; k++) {
        if (paramString.charAt(k) == '?') {
          j++;
        }
      }
      if ((paramArrayOfString != null) && (j < paramArrayOfString.length)) {
        break label139;
      }
    }
    int j = 0;
    return j;
    label139:
    j = Integer.parseInt(paramArrayOfString[j]);
    return j;
  }
  
  private String getPackageNameForUid(PackageManager paramPackageManager, int paramInt)
  {
    Object localObject = paramPackageManager.getPackagesForUid(paramInt);
    if ((localObject == null) || (localObject.length < 1))
    {
      if (Dbg.w()) {
        Dbg.w("No packagename found for uid = " + paramInt);
      }
      localObject = null;
    }
    else
    {
      localObject = localObject[0];
    }
    return localObject;
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i;
    if ((paramArrayOfContentValues == null) || (paramArrayOfContentValues.length == 0)) {
      i = 0;
    }
    SQLiteDatabase localSQLiteDatabase2;
    for (;;)
    {
      return i;
      if (paramArrayOfContentValues.length > 4096) {
        throw new IllegalArgumentException("Too many entries for one operation.");
      }
      SQLiteDatabase localSQLiteDatabase1 = this.mRegistrationDatabaseHelper.getReadableDatabase();
      Object localObject2 = mNotificationPermission.lookUpExtensionsForUid(Binder.getCallingUid(), localSQLiteDatabase1, getContext(), 1);
      int j = -1;
      if (!((TreeMap)localObject2).isEmpty()) {
        j = ((Integer)((TreeMap)localObject2).get(((TreeMap)localObject2).firstKey())).intValue();
      }
      int m = mNotificationPermission.checkPermission(getContext(), j);
      int n = Binder.getCallingUid();
      localObject2 = getContext().getPackageManager().getNameForUid(n);
      String str;
      if (m == 3)
      {
        str = getPackageNameForUid(getContext().getPackageManager(), n);
        throw new SecurityException("You do not have sufficient permission to bulk insert data! Caller package name: " + str);
      }
      n = sUriMatcher.match(paramUri);
      if ((n != 10) && (n != 20)) {
        throw new SQLException("Invalid uri for this content provider.");
      }
      if ((m != 2) || (str == -1))
      {
        if (Dbg.v()) {
          Dbg.v("Caller is not a registered plugin");
        }
        throw new SecurityException("You do not have sufficient permission to perform a insert");
      }
      localSQLiteDatabase2 = getWritableDatabase();
      localSQLiteDatabase2.beginTransaction();
      int k = 0;
      int i3 = 0;
      try
      {
        int i2 = paramArrayOfContentValues.length;
        for (int i1 = 0;; i1++)
        {
          for (;;)
          {
            if (i1 < i2) {
              break label365;
            }
            if (Dbg.d()) {
              Dbg.d("Bulk insert " + i3 + "/" + paramArrayOfContentValues.length + " entrie(s) in " + paramUri.toString() + ".");
            }
            localSQLiteDatabase2.setTransactionSuccessful();
            getContext().getContentResolver().notifyChange(paramUri, null);
            k = paramArrayOfContentValues.length;
            try
            {
              localSQLiteDatabase2.endTransaction();
            }
            catch (SQLiteException localSQLiteException1) {}
          }
          if (!Dbg.e()) {
            break;
          }
          Dbg.e("Error during endTransaction().", localSQLiteException1);
          break;
          label365:
          Uri localUri = doInsert(paramUri, paramArrayOfContentValues[i1], localSQLiteException1, localSQLiteDatabase2, m);
          if (localUri != null) {
            i3++;
          }
        }
      }
      catch (SQLException localSQLException)
      {
        localSQLException = localSQLException;
        if (Dbg.e()) {
          Dbg.e("Error when inserting into " + paramUri.toString(), localSQLException);
        }
        try
        {
          localSQLiteDatabase2.endTransaction();
        }
        catch (SQLiteException localSQLiteException2) {}
        if (Dbg.e()) {
          Dbg.e("Error during endTransaction().", localSQLiteException2);
        }
      }
      finally {}
    }
    try
    {
      localSQLiteDatabase2.endTransaction();
      throw localObject1;
    }
    catch (SQLiteException localSQLiteException3)
    {
      for (;;)
      {
        if (Dbg.e()) {
          Dbg.e("Error during endTransaction().", localSQLiteException3);
        }
      }
    }
  }
  
  /* Error */
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 272	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mRegistrationDatabaseHelper	Landroid/database/sqlite/SQLiteOpenHelper;
    //   4: invokevirtual 278	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore 4
    //   9: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   12: invokestatic 78	android/os/Binder:getCallingUid	()I
    //   15: aload 4
    //   17: aload_0
    //   18: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   21: iconst_1
    //   22: invokevirtual 282	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:lookUpExtensionsForUid	(ILandroid/database/sqlite/SQLiteDatabase;Landroid/content/Context;I)Ljava/util/TreeMap;
    //   25: astore 5
    //   27: bipush 255
    //   29: istore 4
    //   31: aload 5
    //   33: invokevirtual 287	java/util/TreeMap:isEmpty	()Z
    //   36: ifne +21 -> 57
    //   39: aload 5
    //   41: aload 5
    //   43: invokevirtual 291	java/util/TreeMap:firstKey	()Ljava/lang/Object;
    //   46: invokevirtual 295	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 248	java/lang/Integer
    //   52: invokevirtual 296	java/lang/Integer:intValue	()I
    //   55: istore 4
    //   57: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   60: aload_0
    //   61: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   64: iload 4
    //   66: invokevirtual 300	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:checkPermission	(Landroid/content/Context;I)I
    //   69: istore 7
    //   71: invokestatic 78	android/os/Binder:getCallingUid	()I
    //   74: istore 4
    //   76: aload_0
    //   77: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   80: invokevirtual 178	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   83: iload 4
    //   85: invokevirtual 304	android/content/pm/PackageManager:getNameForUid	(I)Ljava/lang/String;
    //   88: astore 5
    //   90: iload 7
    //   92: iconst_3
    //   93: if_icmpne +29 -> 122
    //   96: new 308	java/lang/SecurityException
    //   99: dup
    //   100: new 124	java/lang/StringBuilder
    //   103: dup
    //   104: ldc_w 348
    //   107: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload 5
    //   112: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 311	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
    //   121: athrow
    //   122: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   125: aload_2
    //   126: invokevirtual 350	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:checkForSqlInjectionAttempt	(Ljava/lang/String;)V
    //   129: iconst_0
    //   130: istore 6
    //   132: aconst_null
    //   133: astore 4
    //   135: aload_0
    //   136: invokevirtual 318	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   139: astore 4
    //   141: aload 4
    //   143: invokevirtual 111	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   146: getstatic 30	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:sUriMatcher	Landroid/content/UriMatcher;
    //   149: aload_1
    //   150: invokevirtual 73	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   153: lookupswitch	default:+43->196, 10:+327->480, 15:+445->598, 20:+144->297, 25:+242->395
    //   197: nop
    //   198: lstore 89
    //   200: ldc 80
    //   202: invokespecial 83	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   205: athrow
    //   206: astore 5
    //   208: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   211: ifeq +29 -> 240
    //   214: new 124	java/lang/StringBuilder
    //   217: dup
    //   218: ldc_w 352
    //   221: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   224: aload_1
    //   225: invokevirtual 328	android/net/Uri:toString	()Ljava/lang/String;
    //   228: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: aload 5
    //   236: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   239: pop
    //   240: iconst_0
    //   241: istore 6
    //   243: aload 4
    //   245: ifnull +8 -> 253
    //   248: aload 4
    //   250: invokevirtual 151	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   253: invokestatic 321	com/sonyericsson/extras/liveware/utils/Dbg:d	()Z
    //   256: ifeq +38 -> 294
    //   259: new 124	java/lang/StringBuilder
    //   262: dup
    //   263: ldc_w 354
    //   266: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   269: iload 6
    //   271: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: ldc_w 356
    //   277: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_1
    //   281: invokevirtual 328	android/net/Uri:toString	()Ljava/lang/String;
    //   284: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 330	com/sonyericsson/extras/liveware/utils/Dbg:d	(Ljava/lang/String;)Z
    //   293: pop
    //   294: iload 6
    //   296: ireturn
    //   297: iload 7
    //   299: iconst_1
    //   300: if_icmpne +68 -> 368
    //   303: aload 4
    //   305: ldc 42
    //   307: aload_2
    //   308: aload_3
    //   309: invokevirtual 359	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   312: istore 6
    //   314: aload 4
    //   316: invokevirtual 148	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   319: iload 6
    //   321: ifle +15 -> 336
    //   324: aload_0
    //   325: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   328: invokevirtual 334	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   331: aload_1
    //   332: aconst_null
    //   333: invokevirtual 340	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   336: aload 4
    //   338: ifnull -85 -> 253
    //   341: aload 4
    //   343: invokevirtual 151	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   346: goto -93 -> 253
    //   349: astore 4
    //   351: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   354: ifeq -101 -> 253
    //   357: ldc 200
    //   359: aload 4
    //   361: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   364: pop
    //   365: goto -112 -> 253
    //   368: iload 7
    //   370: iconst_2
    //   371: if_icmpne -57 -> 314
    //   374: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   377: aload_2
    //   378: aload_3
    //   379: aload 5
    //   381: ldc 95
    //   383: ldc 42
    //   385: aload 4
    //   387: invokevirtual 363	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:restrictedDelete	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)I
    //   390: istore 6
    //   392: goto -78 -> 314
    //   395: iload 7
    //   397: iconst_1
    //   398: if_icmpne +34 -> 432
    //   401: iconst_1
    //   402: anewarray 155	java/lang/String
    //   405: astore 5
    //   407: aload 5
    //   409: iconst_0
    //   410: aload_1
    //   411: invokevirtual 366	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   414: aastore
    //   415: aload 4
    //   417: ldc 42
    //   419: ldc_w 368
    //   422: aload 5
    //   424: invokevirtual 359	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   427: istore 6
    //   429: goto -115 -> 314
    //   432: iload 7
    //   434: iconst_2
    //   435: if_icmpne -121 -> 314
    //   438: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   441: astore 7
    //   443: iconst_1
    //   444: anewarray 155	java/lang/String
    //   447: astore 6
    //   449: aload 6
    //   451: iconst_0
    //   452: aload_1
    //   453: invokevirtual 366	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   456: aastore
    //   457: aload 7
    //   459: ldc_w 368
    //   462: aload 6
    //   464: aload 5
    //   466: ldc 95
    //   468: ldc 42
    //   470: aload 4
    //   472: invokevirtual 363	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:restrictedDelete	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)I
    //   475: istore 6
    //   477: goto -163 -> 314
    //   480: iload 7
    //   482: iconst_1
    //   483: if_icmpne +88 -> 571
    //   486: aload 4
    //   488: ldc 34
    //   490: aload_2
    //   491: aload_3
    //   492: invokevirtual 359	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   495: istore 6
    //   497: iload 6
    //   499: ifle -185 -> 314
    //   502: aload_0
    //   503: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   506: invokevirtual 334	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   509: getstatic 374	com/sonyericsson/extras/liveware/aef/notification/Notification$Event:URI	Landroid/net/Uri;
    //   512: aconst_null
    //   513: invokevirtual 340	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   516: goto -202 -> 314
    //   519: astore 5
    //   521: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   524: ifeq +29 -> 553
    //   527: new 124	java/lang/StringBuilder
    //   530: dup
    //   531: ldc_w 376
    //   534: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   537: aload_1
    //   538: invokevirtual 328	android/net/Uri:toString	()Ljava/lang/String;
    //   541: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: aload 5
    //   549: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   552: pop
    //   553: aload 5
    //   555: athrow
    //   556: astore 5
    //   558: aload 4
    //   560: ifnull +8 -> 568
    //   563: aload 4
    //   565: invokevirtual 151	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   568: aload 5
    //   570: athrow
    //   571: iload 7
    //   573: iconst_2
    //   574: if_icmpne -77 -> 497
    //   577: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   580: aload_2
    //   581: aload_3
    //   582: aload 5
    //   584: ldc 95
    //   586: ldc 34
    //   588: aload 4
    //   590: invokevirtual 363	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:restrictedDelete	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)I
    //   593: istore 6
    //   595: goto -98 -> 497
    //   598: iload 7
    //   600: iconst_1
    //   601: if_icmpne +53 -> 654
    //   604: iconst_1
    //   605: anewarray 155	java/lang/String
    //   608: astore 5
    //   610: aload 5
    //   612: iconst_0
    //   613: aload_1
    //   614: invokevirtual 366	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   617: aastore
    //   618: aload 4
    //   620: ldc 34
    //   622: ldc_w 368
    //   625: aload 5
    //   627: invokevirtual 359	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   630: istore 6
    //   632: iload 6
    //   634: ifle -320 -> 314
    //   637: aload_0
    //   638: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   641: invokevirtual 334	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   644: getstatic 374	com/sonyericsson/extras/liveware/aef/notification/Notification$Event:URI	Landroid/net/Uri;
    //   647: aconst_null
    //   648: invokevirtual 340	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   651: goto -337 -> 314
    //   654: iload 7
    //   656: iconst_2
    //   657: if_icmpne -25 -> 632
    //   660: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   663: astore 7
    //   665: iconst_1
    //   666: anewarray 155	java/lang/String
    //   669: astore 6
    //   671: aload 6
    //   673: iconst_0
    //   674: aload_1
    //   675: invokevirtual 366	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   678: aastore
    //   679: aload 7
    //   681: ldc_w 368
    //   684: aload 6
    //   686: aload 5
    //   688: ldc 95
    //   690: ldc 34
    //   692: aload 4
    //   694: invokevirtual 363	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:restrictedDelete	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)I
    //   697: istore 5
    //   699: iload 5
    //   701: istore 6
    //   703: goto -71 -> 632
    //   706: astore 4
    //   708: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   711: ifeq -458 -> 253
    //   714: ldc 200
    //   716: aload 4
    //   718: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   721: pop
    //   722: goto -469 -> 253
    //   725: astore 4
    //   727: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   730: ifeq -162 -> 568
    //   733: ldc 200
    //   735: aload 4
    //   737: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   740: pop
    //   741: goto -173 -> 568
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	744	0	this	NotificationProvider
    //   0	744	1	paramUri	Uri
    //   0	744	2	paramString	String
    //   0	744	3	paramArrayOfString	String[]
    //   7	9	4	localSQLiteDatabase1	SQLiteDatabase
    //   29	55	4	i	int
    //   133	209	4	localSQLiteDatabase2	SQLiteDatabase
    //   349	344	4	localSQLiteException1	SQLiteException
    //   706	11	4	localSQLiteException2	SQLiteException
    //   725	11	4	localSQLiteException3	SQLiteException
    //   25	86	5	localObject	Object
    //   206	174	5	localSQLiteConstraintException	android.database.sqlite.SQLiteConstraintException
    //   405	60	5	arrayOfString1	String[]
    //   519	35	5	localSQLException	SQLException
    //   556	27	5	str	String
    //   608	79	5	arrayOfString2	String[]
    //   697	3	5	arrayOfString3	String[]
    //   130	298	6	j	int
    //   447	16	6	arrayOfString4	String[]
    //   475	158	6	k	int
    //   669	33	6	arrayOfString5	String[]
    //   69	367	7	m	int
    //   441	239	7	localNotificationPermission	NotificationPermission
    // Exception table:
    //   from	to	target	type
    //   135	206	206	android/database/sqlite/SQLiteConstraintException
    //   303	336	206	android/database/sqlite/SQLiteConstraintException
    //   374	516	206	android/database/sqlite/SQLiteConstraintException
    //   577	699	206	android/database/sqlite/SQLiteConstraintException
    //   341	346	349	android/database/sqlite/SQLiteException
    //   135	206	519	android/database/SQLException
    //   303	336	519	android/database/SQLException
    //   374	516	519	android/database/SQLException
    //   577	699	519	android/database/SQLException
    //   135	206	556	finally
    //   208	240	556	finally
    //   303	336	556	finally
    //   374	516	556	finally
    //   521	556	556	finally
    //   577	699	556	finally
    //   248	253	706	android/database/sqlite/SQLiteException
    //   563	568	725	android/database/sqlite/SQLiteException
  }
  
  SQLiteDatabase getReadableDatabase()
  {
    return this.mOpenHelper.getReadableDatabase();
  }
  
  public String getType(Uri paramUri)
  {
    String str;
    switch (sUriMatcher.match(paramUri))
    {
    default: 
      str = null;
      break;
    case 10: 
      str = "vnd.android.cursor.dir/aef-source";
      break;
    case 15: 
      str = "vnd.android.cursor.item/aef-source";
      break;
    case 20: 
      str = "vnd.android.cursor.dir/aef-event";
      break;
    case 25: 
      str = "vnd.android.cursor.item/aef-event";
    }
    return str;
  }
  
  SQLiteDatabase getWritableDatabase()
  {
    return this.mOpenHelper.getWritableDatabase();
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject1 = this.mRegistrationDatabaseHelper.getReadableDatabase();
    TreeMap localTreeMap = mNotificationPermission.lookUpExtensionsForUid(Binder.getCallingUid(), (SQLiteDatabase)localObject1, getContext(), 1);
    int j = Binder.getCallingUid();
    Object localObject2 = getContext().getPackageManager();
    localObject1 = ((PackageManager)localObject2).getNameForUid(j);
    int i;
    if (!paramContentValues.containsKey("packageName"))
    {
      String[] arrayOfString = ((PackageManager)localObject2).getPackagesForUid(j);
      if ((arrayOfString == null) || (arrayOfString.length != 1))
      {
        i = ((Integer)localTreeMap.get(localTreeMap.firstKey())).intValue();
      }
      else
      {
        localObject2 = new ContentValues();
        ((ContentValues)localObject2).put("packageName", arrayOfString[0]);
        i = mNotificationPermission.getExtensionIdForPackage(i, (ContentValues)localObject2);
      }
    }
    else
    {
      i = mNotificationPermission.getExtensionIdForPackage(i, paramContentValues);
    }
    int k = mNotificationPermission.checkPermission(getContext(), i);
    if (k != 3)
    {
      if ((k == 2) && (i != -1))
      {
        localObject1 = doInsert(paramUri, paramContentValues, (String)localObject1, getWritableDatabase(), k);
        if (localObject1 != null) {
          getContext().getContentResolver().notifyChange(paramUri, null);
        }
        return localObject1;
      }
      if (Dbg.v()) {
        Dbg.v("Caller is not a registered plugin");
      }
      throw new SecurityException("You do not have sufficient permission to perform a insert");
    }
    throw new SecurityException("You do not have sufficient permission to insert data! Caller package name: " + (String)localObject1);
  }
  
  public boolean onCreate()
  {
    this.mOpenHelper = new NotificationDatabaseHelper(getContext());
    this.mRegistrationDatabaseHelper = new RegistrationDatabaseHelper(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase1 = this.mRegistrationDatabaseHelper.getReadableDatabase();
    Object localObject1 = mNotificationPermission.lookUpExtensionsForUid(Binder.getCallingUid(), localSQLiteDatabase1, getContext(), 1);
    int i = -1;
    if (!((TreeMap)localObject1).isEmpty()) {
      i = ((Integer)((TreeMap)localObject1).get(((TreeMap)localObject1).firstKey())).intValue();
    }
    int j = mNotificationPermission.checkPermission(getContext(), i);
    i = Binder.getCallingUid();
    localObject1 = getContext().getPackageManager().getNameForUid(i);
    Object localObject3 = null;
    SQLiteDatabase localSQLiteDatabase2 = getWritableDatabase();
    Object localObject2;
    switch (sUriMatcher.match(paramUri))
    {
    default: 
      throw new SQLException("Invalid uri for this content provider.");
    case 10: 
      if (j != 2)
      {
        if (j == 1) {
          localObject3 = localSQLiteDatabase2.query("source", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        }
      }
      else
      {
        if (paramArrayOfString1 == null)
        {
          paramArrayOfString1 = NotificationInternal.SourceImpl.sourceProjection();
        }
        else
        {
          localObject2 = mNotificationPermission;
          localObject3 = NotificationInternal.SourceImpl.restrictedQueryColumns();
          ((NotificationPermission)localObject2).verifyProjection(paramArrayOfString1, (String[])localObject3);
        }
        localObject3 = mNotificationPermission.restrictedQuery(localSQLiteDatabase2, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (String)localObject1, "userId", "source");
      }
      break;
    case 15: 
      if (localObject2 != 2)
      {
        if (localObject2 == 1)
        {
          localObject1 = new String[1];
          localObject1[0] = paramUri.getLastPathSegment();
          localObject3 = localSQLiteDatabase2.query("source", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        }
      }
      else
      {
        if (paramArrayOfString1 == null)
        {
          paramArrayOfString1 = NotificationInternal.SourceImpl.sourceProjection();
        }
        else
        {
          localObject2 = mNotificationPermission;
          localObject3 = NotificationInternal.SourceImpl.restrictedQueryColumns();
          ((NotificationPermission)localObject2).verifyProjection(paramArrayOfString1, (String[])localObject3);
        }
        localObject3 = mNotificationPermission;
        localObject2 = new String[1];
        localObject2[0] = paramUri.getLastPathSegment();
        localObject3 = ((NotificationPermission)localObject3).restrictedQuery(localSQLiteDatabase2, paramArrayOfString1, "_id=?", (String[])localObject2, paramString2, (String)localObject1, "userId", "source");
      }
      break;
    case 20: 
      if (localObject2 != 2)
      {
        if (localObject2 == 1) {
          localObject3 = localSQLiteDatabase2.query("event", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        }
      }
      else
      {
        if (paramArrayOfString1 == null)
        {
          paramArrayOfString1 = NotificationInternal.EventImpl.eventProjection();
        }
        else
        {
          localObject2 = mNotificationPermission;
          localObject3 = NotificationInternal.EventImpl.restrictedQueryColumns();
          ((NotificationPermission)localObject2).verifyProjection(paramArrayOfString1, (String[])localObject3);
        }
        localObject3 = mNotificationPermission.restrictedQuery(localSQLiteDatabase2, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (String)localObject1, "userId", "event");
      }
      break;
    case 25: 
      if (localObject2 != 2)
      {
        if (localObject2 == 1)
        {
          localObject1 = new String[1];
          localObject1[0] = paramUri.getLastPathSegment();
          localObject3 = localSQLiteDatabase2.query("event", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        }
      }
      else
      {
        if (paramArrayOfString1 == null)
        {
          paramArrayOfString1 = NotificationInternal.EventImpl.eventProjection();
        }
        else
        {
          localObject3 = mNotificationPermission;
          localObject2 = NotificationInternal.EventImpl.restrictedQueryColumns();
          ((NotificationPermission)localObject3).verifyProjection(paramArrayOfString1, (String[])localObject2);
        }
        localObject3 = mNotificationPermission;
        localObject2 = new String[1];
        localObject2[0] = paramUri.getLastPathSegment();
        localObject3 = ((NotificationPermission)localObject3).restrictedQuery(localSQLiteDatabase2, paramArrayOfString1, "_id=?", (String[])localObject2, paramString2, (String)localObject1, "userId", "event");
      }
      break;
    case 35: 
      if ((paramString2 == null) || (paramString2.length() == 0)) {
        paramString2 = "source._id,sourceId";
      }
      if (localObject2 != 2)
      {
        if (localObject2 == 1)
        {
          if (paramArrayOfString1 == null) {
            paramArrayOfString1 = NotificationInternal.SourceEventImpl.sourceEventProjection();
          }
          localObject3 = localSQLiteDatabase2.query("source INNER JOIN event ON source._id = sourceId", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        }
      }
      else
      {
        if (paramArrayOfString1 == null)
        {
          paramArrayOfString1 = NotificationInternal.SourceEventImpl.sourceEventProjection();
        }
        else
        {
          localObject2 = mNotificationPermission;
          localObject3 = NotificationInternal.SourceEventImpl.restrictedQueryColumns();
          ((NotificationPermission)localObject2).verifyProjection(paramArrayOfString1, (String[])localObject3);
        }
        localObject3 = mNotificationPermission.restrictedQuery(localSQLiteDatabase2, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (String)localObject1, "source.userId", "source INNER JOIN event ON source._id = sourceId");
      }
      break;
    case 40: 
      if ((paramString2 == null) || (paramString2.length() == 0)) {
        paramString2 = "source._id,sourceId";
      }
      if (localObject2 != 2)
      {
        if (localObject2 == 1)
        {
          if (paramArrayOfString1 == null) {
            paramArrayOfString1 = NotificationInternal.SourceEventImpl.sourceEventProjection();
          }
          localObject1 = new String[1];
          localObject1[0] = paramUri.getLastPathSegment();
          localObject3 = localSQLiteDatabase2.query("source INNER JOIN event ON source._id = sourceId", paramArrayOfString1, "event._id=?", (String[])localObject1, null, null, paramString2);
        }
      }
      else
      {
        if (paramArrayOfString1 == null)
        {
          paramArrayOfString1 = NotificationInternal.SourceEventImpl.sourceEventProjection();
        }
        else
        {
          localObject2 = mNotificationPermission;
          localObject3 = NotificationInternal.SourceEventImpl.restrictedQueryColumns();
          ((NotificationPermission)localObject2).verifyProjection(paramArrayOfString1, (String[])localObject3);
        }
        localObject2 = mNotificationPermission;
        localObject3 = new String[1];
        localObject3[0] = paramUri.getLastPathSegment();
        localObject3 = ((NotificationPermission)localObject2).restrictedQuery(localSQLiteDatabase2, paramArrayOfString1, "event._id=?", (String[])localObject3, paramString2, (String)localObject1, "source.userId", "source INNER JOIN event ON source._id = sourceId");
      }
      break;
    }
    return localObject3;
  }
  
  /* Error */
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 272	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mRegistrationDatabaseHelper	Landroid/database/sqlite/SQLiteOpenHelper;
    //   4: invokevirtual 278	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore 5
    //   9: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   12: invokestatic 78	android/os/Binder:getCallingUid	()I
    //   15: aload 5
    //   17: aload_0
    //   18: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   21: iconst_1
    //   22: invokevirtual 282	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:lookUpExtensionsForUid	(ILandroid/database/sqlite/SQLiteDatabase;Landroid/content/Context;I)Ljava/util/TreeMap;
    //   25: astore 5
    //   27: bipush 255
    //   29: istore 6
    //   31: aload 5
    //   33: invokevirtual 287	java/util/TreeMap:isEmpty	()Z
    //   36: ifne +21 -> 57
    //   39: aload 5
    //   41: aload 5
    //   43: invokevirtual 291	java/util/TreeMap:firstKey	()Ljava/lang/Object;
    //   46: invokevirtual 295	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 248	java/lang/Integer
    //   52: invokevirtual 296	java/lang/Integer:intValue	()I
    //   55: istore 6
    //   57: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   60: aload_0
    //   61: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   64: iload 6
    //   66: invokevirtual 300	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:checkPermission	(Landroid/content/Context;I)I
    //   69: istore 10
    //   71: invokestatic 78	android/os/Binder:getCallingUid	()I
    //   74: istore 11
    //   76: aload_0
    //   77: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   80: invokevirtual 178	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   83: iload 11
    //   85: invokevirtual 304	android/content/pm/PackageManager:getNameForUid	(I)Ljava/lang/String;
    //   88: astore 9
    //   90: iload 10
    //   92: iconst_3
    //   93: if_icmpne +44 -> 137
    //   96: aload_0
    //   97: aload_0
    //   98: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   101: invokevirtual 178	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   104: iload 11
    //   106: invokespecial 306	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getPackageNameForUid	(Landroid/content/pm/PackageManager;I)Ljava/lang/String;
    //   109: astore 5
    //   111: new 308	java/lang/SecurityException
    //   114: dup
    //   115: new 124	java/lang/StringBuilder
    //   118: dup
    //   119: ldc_w 400
    //   122: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload 5
    //   127: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokespecial 311	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
    //   136: athrow
    //   137: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   140: aload_3
    //   141: invokevirtual 350	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:checkForSqlInjectionAttempt	(Ljava/lang/String;)V
    //   144: iconst_0
    //   145: istore 7
    //   147: aconst_null
    //   148: astore 5
    //   150: iconst_0
    //   151: istore 8
    //   153: iconst_0
    //   154: istore 6
    //   156: aload_0
    //   157: invokevirtual 318	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   160: astore 5
    //   162: aload 5
    //   164: invokevirtual 111	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   167: getstatic 30	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:sUriMatcher	Landroid/content/UriMatcher;
    //   170: aload_1
    //   171: invokevirtual 73	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   174: lookupswitch	default:+42->216, 10:+526->700, 15:+673->847, 20:+143->317, 25:+373->547
    //   217: nop
    //   218: lstore 89
    //   220: ldc 80
    //   222: invokespecial 83	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   225: athrow
    //   226: astore 6
    //   228: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   231: ifeq +29 -> 260
    //   234: new 124	java/lang/StringBuilder
    //   237: dup
    //   238: ldc_w 352
    //   241: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   244: aload_1
    //   245: invokevirtual 328	android/net/Uri:toString	()Ljava/lang/String;
    //   248: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: aload 6
    //   256: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   259: pop
    //   260: iconst_0
    //   261: istore 7
    //   263: aload 5
    //   265: ifnull +8 -> 273
    //   268: aload 5
    //   270: invokevirtual 151	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   273: invokestatic 321	com/sonyericsson/extras/liveware/utils/Dbg:d	()Z
    //   276: ifeq +38 -> 314
    //   279: new 124	java/lang/StringBuilder
    //   282: dup
    //   283: ldc_w 452
    //   286: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   289: iload 7
    //   291: invokevirtual 261	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: ldc_w 356
    //   297: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_1
    //   301: invokevirtual 328	android/net/Uri:toString	()Ljava/lang/String;
    //   304: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 330	com/sonyericsson/extras/liveware/utils/Dbg:d	(Ljava/lang/String;)Z
    //   313: pop
    //   314: iload 7
    //   316: ireturn
    //   317: iload 10
    //   319: iconst_1
    //   320: if_icmpne +195 -> 515
    //   323: aload_2
    //   324: ldc_w 454
    //   327: invokevirtual 393	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   330: ifeq +38 -> 368
    //   333: aload_2
    //   334: ldc_w 454
    //   337: invokevirtual 458	android/content/ContentValues:getAsBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   340: astore 7
    //   342: aload 7
    //   344: ifnull +151 -> 495
    //   347: aload 7
    //   349: invokevirtual 463	java/lang/Boolean:booleanValue	()Z
    //   352: istore 8
    //   354: iload 8
    //   356: ifeq +12 -> 368
    //   359: aload_0
    //   360: aload_3
    //   361: aload 4
    //   363: invokespecial 465	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getEventIdOfSelection	(Ljava/lang/String;[Ljava/lang/String;)I
    //   366: istore 6
    //   368: aload 5
    //   370: ldc 42
    //   372: aload_2
    //   373: aload_3
    //   374: aload 4
    //   376: invokevirtual 468	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   379: istore 7
    //   381: aload 5
    //   383: invokevirtual 148	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   386: iload 7
    //   388: ifle +75 -> 463
    //   391: aload_0
    //   392: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   395: invokevirtual 334	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   398: aload_1
    //   399: aconst_null
    //   400: invokevirtual 340	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   403: iload 8
    //   405: ifeq +58 -> 463
    //   408: iload 6
    //   410: ifle +53 -> 463
    //   413: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   416: astore 9
    //   418: aload_0
    //   419: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   422: astore 8
    //   424: aload 9
    //   426: iload 6
    //   428: aload 5
    //   430: aload 8
    //   432: invokevirtual 472	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:lookUpSourceId	(ILandroid/database/sqlite/SQLiteDatabase;Landroid/content/Context;)I
    //   435: istore 6
    //   437: getstatic 475	com/sonyericsson/extras/liveware/aef/notification/Notification$Event:READ_STATUS_URI	Landroid/net/Uri;
    //   440: iload 6
    //   442: invokestatic 477	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   445: invokestatic 165	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   448: astore 6
    //   450: aload_0
    //   451: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   454: invokevirtual 334	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   457: aload 6
    //   459: aconst_null
    //   460: invokevirtual 340	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   463: aload 5
    //   465: ifnull -192 -> 273
    //   468: aload 5
    //   470: invokevirtual 151	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   473: goto -200 -> 273
    //   476: astore 5
    //   478: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   481: ifeq -208 -> 273
    //   484: ldc 200
    //   486: aload 5
    //   488: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   491: pop
    //   492: goto -219 -> 273
    //   495: aload_2
    //   496: ldc_w 454
    //   499: invokevirtual 481	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   502: invokevirtual 296	java/lang/Integer:intValue	()I
    //   505: iconst_1
    //   506: if_icmpne -152 -> 354
    //   509: iconst_1
    //   510: istore 8
    //   512: goto -158 -> 354
    //   515: iload 10
    //   517: iconst_2
    //   518: if_icmpne -137 -> 381
    //   521: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   524: aload_1
    //   525: aload_2
    //   526: aload_3
    //   527: aload 4
    //   529: ldc 42
    //   531: aload 5
    //   533: ldc 95
    //   535: aload 9
    //   537: ldc 211
    //   539: invokevirtual 485	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:restrictedUpdate	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   542: istore 7
    //   544: goto -163 -> 381
    //   547: iload 10
    //   549: iconst_1
    //   550: if_icmpne +98 -> 648
    //   553: aload_2
    //   554: ldc_w 454
    //   557: invokevirtual 393	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   560: ifeq +36 -> 596
    //   563: aload_2
    //   564: ldc_w 454
    //   567: invokevirtual 458	android/content/ContentValues:getAsBoolean	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   570: astore 7
    //   572: aload 7
    //   574: ifnull +54 -> 628
    //   577: aload 7
    //   579: invokevirtual 463	java/lang/Boolean:booleanValue	()Z
    //   582: istore 8
    //   584: iload 8
    //   586: ifeq +10 -> 596
    //   589: aload_1
    //   590: invokestatic 491	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   593: l2i
    //   594: istore 6
    //   596: iconst_1
    //   597: anewarray 155	java/lang/String
    //   600: astore 7
    //   602: aload 7
    //   604: iconst_0
    //   605: aload_1
    //   606: invokevirtual 366	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   609: aastore
    //   610: aload 5
    //   612: ldc 42
    //   614: aload_2
    //   615: ldc_w 368
    //   618: aload 7
    //   620: invokevirtual 468	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   623: istore 7
    //   625: goto -244 -> 381
    //   628: aload_2
    //   629: ldc_w 454
    //   632: invokevirtual 481	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   635: invokevirtual 296	java/lang/Integer:intValue	()I
    //   638: iconst_1
    //   639: if_icmpne -55 -> 584
    //   642: iconst_1
    //   643: istore 8
    //   645: goto -61 -> 584
    //   648: iload 10
    //   650: iconst_2
    //   651: if_icmpne -270 -> 381
    //   654: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   657: astore 7
    //   659: iconst_1
    //   660: anewarray 155	java/lang/String
    //   663: astore 10
    //   665: aload 10
    //   667: iconst_0
    //   668: aload_1
    //   669: invokevirtual 366	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   672: aastore
    //   673: aload 7
    //   675: aload_1
    //   676: aload_2
    //   677: ldc_w 368
    //   680: aload 10
    //   682: ldc 42
    //   684: aload 5
    //   686: ldc 95
    //   688: aload 9
    //   690: ldc 211
    //   692: invokevirtual 485	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:restrictedUpdate	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   695: istore 7
    //   697: goto -316 -> 381
    //   700: iload 10
    //   702: iconst_1
    //   703: if_icmpne +90 -> 793
    //   706: aload 5
    //   708: ldc 34
    //   710: aload_2
    //   711: aload_3
    //   712: aload 4
    //   714: invokevirtual 468	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   717: istore 7
    //   719: iload 7
    //   721: ifle -340 -> 381
    //   724: aload_0
    //   725: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   728: invokevirtual 334	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   731: getstatic 374	com/sonyericsson/extras/liveware/aef/notification/Notification$Event:URI	Landroid/net/Uri;
    //   734: aconst_null
    //   735: invokevirtual 340	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   738: goto -357 -> 381
    //   741: astore 6
    //   743: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   746: ifeq +29 -> 775
    //   749: new 124	java/lang/StringBuilder
    //   752: dup
    //   753: ldc_w 352
    //   756: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   759: aload_1
    //   760: invokevirtual 328	android/net/Uri:toString	()Ljava/lang/String;
    //   763: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: aload 6
    //   771: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   774: pop
    //   775: aload 6
    //   777: athrow
    //   778: astore 6
    //   780: aload 5
    //   782: ifnull +8 -> 790
    //   785: aload 5
    //   787: invokevirtual 151	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   790: aload 6
    //   792: athrow
    //   793: iload 10
    //   795: iconst_2
    //   796: if_icmpne -77 -> 719
    //   799: aload_2
    //   800: ldc 186
    //   802: invokevirtual 393	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   805: ifeq +16 -> 821
    //   808: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   811: iload 11
    //   813: aload_0
    //   814: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   817: aload_2
    //   818: invokevirtual 190	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:verifyPackage	(ILandroid/content/Context;Landroid/content/ContentValues;)V
    //   821: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   824: aload_1
    //   825: aload_2
    //   826: aload_3
    //   827: aload 4
    //   829: ldc 34
    //   831: aload 5
    //   833: ldc 95
    //   835: aload 9
    //   837: ldc 211
    //   839: invokevirtual 485	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:restrictedUpdate	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   842: istore 7
    //   844: goto -125 -> 719
    //   847: iload 10
    //   849: iconst_1
    //   850: if_icmpne +54 -> 904
    //   853: iconst_1
    //   854: anewarray 155	java/lang/String
    //   857: astore 7
    //   859: aload 7
    //   861: iconst_0
    //   862: aload_1
    //   863: invokevirtual 366	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   866: aastore
    //   867: aload 5
    //   869: ldc 34
    //   871: aload_2
    //   872: ldc_w 368
    //   875: aload 7
    //   877: invokevirtual 468	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   880: istore 7
    //   882: iload 7
    //   884: ifle -503 -> 381
    //   887: aload_0
    //   888: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   891: invokevirtual 334	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   894: getstatic 374	com/sonyericsson/extras/liveware/aef/notification/Notification$Event:URI	Landroid/net/Uri;
    //   897: aconst_null
    //   898: invokevirtual 340	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   901: goto -520 -> 381
    //   904: iload 10
    //   906: iconst_2
    //   907: if_icmpne -25 -> 882
    //   910: aload_2
    //   911: ldc 186
    //   913: invokevirtual 393	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   916: ifeq +16 -> 932
    //   919: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   922: iload 11
    //   924: aload_0
    //   925: invokevirtual 172	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:getContext	()Landroid/content/Context;
    //   928: aload_2
    //   929: invokevirtual 190	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:verifyPackage	(ILandroid/content/Context;Landroid/content/ContentValues;)V
    //   932: getstatic 23	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationProvider:mNotificationPermission	Lcom/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission;
    //   935: aload_1
    //   936: aload_2
    //   937: aconst_null
    //   938: aconst_null
    //   939: ldc 34
    //   941: aload 5
    //   943: ldc 95
    //   945: aload 9
    //   947: ldc 211
    //   949: invokevirtual 485	com/sonyericsson/extras/liveware/aef/notification/provider/NotificationPermission:restrictedUpdate	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   952: istore 7
    //   954: goto -72 -> 882
    //   957: astore 6
    //   959: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   962: ifeq -499 -> 463
    //   965: ldc_w 493
    //   968: aload 6
    //   970: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   973: pop
    //   974: goto -511 -> 463
    //   977: astore 5
    //   979: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   982: ifeq -709 -> 273
    //   985: ldc 200
    //   987: aload 5
    //   989: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   992: pop
    //   993: goto -720 -> 273
    //   996: astore 5
    //   998: invokestatic 193	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   1001: ifeq -211 -> 790
    //   1004: ldc 200
    //   1006: aload 5
    //   1008: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   1011: pop
    //   1012: goto -222 -> 790
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1015	0	this	NotificationProvider
    //   0	1015	1	paramUri	Uri
    //   0	1015	2	paramContentValues	ContentValues
    //   0	1015	3	paramString	String
    //   0	1015	4	paramArrayOfString	String[]
    //   7	462	5	localObject1	Object
    //   476	466	5	localSQLiteException1	SQLiteException
    //   977	11	5	localSQLiteException2	SQLiteException
    //   996	11	5	localSQLiteException3	SQLiteException
    //   29	126	6	i	int
    //   226	29	6	localSQLiteConstraintException	android.database.sqlite.SQLiteConstraintException
    //   366	75	6	j	int
    //   448	10	6	localUri	Uri
    //   594	1	6	k	int
    //   741	35	6	localSQLException	SQLException
    //   778	13	6	localObject2	Object
    //   957	12	6	localException	java.lang.Exception
    //   145	170	7	m	int
    //   340	8	7	localBoolean	java.lang.Boolean
    //   379	164	7	n	int
    //   570	49	7	localObject3	Object
    //   623	1	7	i1	int
    //   657	17	7	localNotificationPermission	NotificationPermission
    //   695	148	7	i2	int
    //   857	19	7	arrayOfString1	String[]
    //   880	73	7	i3	int
    //   151	253	8	bool1	boolean
    //   422	9	8	localContext	Context
    //   510	134	8	bool2	boolean
    //   88	858	9	localObject4	Object
    //   69	583	10	i4	int
    //   663	245	10	arrayOfString2	String[]
    //   74	849	11	i5	int
    // Exception table:
    //   from	to	target	type
    //   156	226	226	android/database/sqlite/SQLiteConstraintException
    //   323	403	226	android/database/sqlite/SQLiteConstraintException
    //   413	463	226	android/database/sqlite/SQLiteConstraintException
    //   495	738	226	android/database/sqlite/SQLiteConstraintException
    //   799	974	226	android/database/sqlite/SQLiteConstraintException
    //   468	473	476	android/database/sqlite/SQLiteException
    //   156	226	741	android/database/SQLException
    //   323	403	741	android/database/SQLException
    //   413	463	741	android/database/SQLException
    //   495	738	741	android/database/SQLException
    //   799	974	741	android/database/SQLException
    //   156	226	778	finally
    //   228	260	778	finally
    //   323	403	778	finally
    //   413	463	778	finally
    //   495	738	778	finally
    //   743	778	778	finally
    //   799	974	778	finally
    //   413	463	957	java/lang/Exception
    //   268	273	977	android/database/sqlite/SQLiteException
    //   785	790	996	android/database/sqlite/SQLiteException
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.notification.provider.NotificationProvider
 * JD-Core Version:    0.7.0.1
 */