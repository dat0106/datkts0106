package com.sonyericsson.extras.liveware.aef.registration.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Binder;
import com.sonyericsson.extras.liveware.aef.notification.provider.NotificationDatabaseHelper;
import com.sonyericsson.extras.liveware.aef.registration.RegistrationInternal.ApiRegistrationImpl;
import com.sonyericsson.extras.liveware.aef.registration.RegistrationInternal.ExtensionImpl;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.TreeMap;

public final class RegistrationProvider
  extends ContentProvider
{
  private static RegistrationPermission mRegistrationPermission = new RegistrationPermission();
  private static UriMatcher sUriMatcher = new UriMatcher(-1);
  private SQLiteOpenHelper mOpenHelper;
  
  static
  {
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "extensions", 10);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "extensions/#", 15);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "registrations", 20);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "registrations/#", 25);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "host_application", 30);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "host_application/#", 35);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "device", 40);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "device/#", 45);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "display", 50);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "display/#", 55);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "sensor", 60);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "sensor/#", 65);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "input", 80);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "input/#", 85);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "led", 70);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "led/#", 75);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "sensor_type", 90);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "sensor_type/#", 95);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "keypad", 100);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "keypad/#", 105);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "capabilities", 110);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "raw_query", 120);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "permission_request", 130);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.aef.registration", "permission_request/#", 140);
  }
  
  /* Error */
  private Uri doInsert(Uri paramUri, ContentValues paramContentValues, int paramInt1, SQLiteDatabase paramSQLiteDatabase, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokevirtual 93	android/content/ContentValues:size	()I
    //   8: ifne +13 -> 21
    //   11: new 95	java/lang/IllegalArgumentException
    //   14: dup
    //   15: ldc 97
    //   17: invokespecial 100	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: new 89	android/content/ContentValues
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 103	android/content/ContentValues:<init>	(Landroid/content/ContentValues;)V
    //   29: astore 7
    //   31: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   34: aload 7
    //   36: invokevirtual 106	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:checkForSqlInjectionAttempt	(Landroid/content/ContentValues;)V
    //   39: getstatic 26	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:sUriMatcher	Landroid/content/UriMatcher;
    //   42: aload_1
    //   43: invokevirtual 110	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   46: istore 6
    //   48: iload 6
    //   50: lookupswitch	default:+90->140, 10:+100->150, 20:+429->479, 30:+468->518, 40:+475->525, 50:+482->532, 60:+489->539, 70:+503->553, 80:+496->546, 90:+510->560, 100:+517->567
    //   141: nop
    //   142: castore
    //   143: dup
    //   144: ldc 112
    //   146: invokespecial 113	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   149: athrow
    //   150: invokestatic 118	android/os/Binder:getCallingUid	()I
    //   153: istore 8
    //   155: aload_0
    //   156: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   159: invokevirtual 128	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   162: astore 10
    //   164: aload 10
    //   166: iload 8
    //   168: invokevirtual 134	android/content/pm/PackageManager:getNameForUid	(I)Ljava/lang/String;
    //   171: astore 9
    //   173: aload 9
    //   175: ifnull +11 -> 186
    //   178: aload 9
    //   180: invokevirtual 139	java/lang/String:length	()I
    //   183: ifne +21 -> 204
    //   186: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   189: ifeq +9 -> 198
    //   192: ldc 147
    //   194: invokestatic 150	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   197: pop
    //   198: aconst_null
    //   199: astore 10
    //   201: aload 10
    //   203: areturn
    //   204: aload 10
    //   206: iload 8
    //   208: invokevirtual 154	android/content/pm/PackageManager:getPackagesForUid	(I)[Ljava/lang/String;
    //   211: astore 10
    //   213: aload 10
    //   215: ifnull +28 -> 243
    //   218: aload 10
    //   220: arraylength
    //   221: iconst_1
    //   222: if_icmpne +21 -> 243
    //   225: aload 7
    //   227: ldc 156
    //   229: invokevirtual 159	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   232: aload 7
    //   234: ldc 156
    //   236: aload 10
    //   238: iconst_0
    //   239: aaload
    //   240: invokevirtual 163	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   246: aload 7
    //   248: invokestatic 169	com/sonyericsson/extras/liveware/aef/registration/RegistrationInternal$ExtensionImpl:restrictedModifyColumns	()[Ljava/lang/String;
    //   251: invokevirtual 173	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:verifyContentValues	(Landroid/content/ContentValues;[Ljava/lang/String;)V
    //   254: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   257: iload 8
    //   259: aload_0
    //   260: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   263: aload 7
    //   265: invokevirtual 177	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:verifyPackage	(ILandroid/content/Context;Landroid/content/ContentValues;)V
    //   268: aload 7
    //   270: ldc 179
    //   272: invokevirtual 159	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   275: aload 7
    //   277: ldc 179
    //   279: aload 9
    //   281: invokevirtual 163	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: ldc 181
    //   286: astore 11
    //   288: aload 4
    //   290: invokevirtual 186	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   293: ifeq +281 -> 574
    //   296: iconst_0
    //   297: istore 10
    //   299: iload 10
    //   301: ifeq +8 -> 309
    //   304: aload 4
    //   306: invokevirtual 189	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   309: aload 4
    //   311: aload 11
    //   313: ldc 191
    //   315: aload 7
    //   317: invokevirtual 195	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   320: lstore 8
    //   322: invokestatic 198	com/sonyericsson/extras/liveware/utils/Dbg:v	()Z
    //   325: ifeq +39 -> 364
    //   328: new 200	java/lang/StringBuilder
    //   331: dup
    //   332: ldc 202
    //   334: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   337: aload 11
    //   339: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc 209
    //   344: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: lload 8
    //   349: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   352: ldc 214
    //   354: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 220	com/sonyericsson/extras/liveware/utils/Dbg:v	(Ljava/lang/String;)Z
    //   363: pop
    //   364: iload 10
    //   366: ifeq +8 -> 374
    //   369: aload 4
    //   371: invokevirtual 223	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   374: iload 10
    //   376: ifeq +8 -> 384
    //   379: aload 4
    //   381: invokevirtual 226	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   384: aconst_null
    //   385: astore 10
    //   387: lload 8
    //   389: ldc2_w 227
    //   392: lcmp
    //   393: ifeq -192 -> 201
    //   396: aload_1
    //   397: lload 8
    //   399: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   402: invokestatic 238	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   405: astore 10
    //   407: aload_0
    //   408: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   411: invokevirtual 242	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   414: aload_1
    //   415: aconst_null
    //   416: invokevirtual 248	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   419: iload 6
    //   421: bipush 30
    //   423: if_icmpne +247 -> 670
    //   426: new 250	android/content/Intent
    //   429: dup
    //   430: invokespecial 251	android/content/Intent:<init>	()V
    //   433: astore 6
    //   435: aload 6
    //   437: new 253	android/content/ComponentName
    //   440: dup
    //   441: aload_0
    //   442: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   445: ldc 255
    //   447: invokespecial 258	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   450: invokevirtual 262	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   453: pop
    //   454: aload 6
    //   456: ldc_w 264
    //   459: ldc_w 266
    //   462: invokevirtual 270	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   465: pop
    //   466: aload_0
    //   467: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   470: aload 6
    //   472: invokevirtual 274	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   475: pop
    //   476: goto -275 -> 201
    //   479: aload 7
    //   481: ldc_w 276
    //   484: invokevirtual 159	android/content/ContentValues:remove	(Ljava/lang/String;)V
    //   487: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   490: aload 7
    //   492: invokestatic 279	com/sonyericsson/extras/liveware/aef/registration/RegistrationInternal$ApiRegistrationImpl:restrictedModifyColumns	()[Ljava/lang/String;
    //   495: invokevirtual 173	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:verifyContentValues	(Landroid/content/ContentValues;[Ljava/lang/String;)V
    //   498: aload 7
    //   500: ldc_w 276
    //   503: iload_3
    //   504: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   507: invokevirtual 287	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   510: ldc_w 289
    //   513: astore 11
    //   515: goto -227 -> 288
    //   518: ldc 42
    //   520: astore 11
    //   522: goto -234 -> 288
    //   525: ldc 46
    //   527: astore 11
    //   529: goto -241 -> 288
    //   532: ldc 50
    //   534: astore 11
    //   536: goto -248 -> 288
    //   539: ldc 54
    //   541: astore 11
    //   543: goto -255 -> 288
    //   546: ldc 58
    //   548: astore 11
    //   550: goto -262 -> 288
    //   553: ldc 62
    //   555: astore 11
    //   557: goto -269 -> 288
    //   560: ldc 66
    //   562: astore 11
    //   564: goto -276 -> 288
    //   567: ldc 70
    //   569: astore 11
    //   571: goto -283 -> 288
    //   574: iconst_1
    //   575: istore 10
    //   577: goto -278 -> 299
    //   580: astore 6
    //   582: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   585: ifeq +27 -> 612
    //   588: new 200	java/lang/StringBuilder
    //   591: dup
    //   592: ldc_w 291
    //   595: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   598: aload 11
    //   600: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: aload 6
    //   608: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   611: pop
    //   612: aload 6
    //   614: athrow
    //   615: astore 6
    //   617: iload 10
    //   619: ifeq +8 -> 627
    //   622: aload 4
    //   624: invokevirtual 226	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   627: aload 6
    //   629: athrow
    //   630: astore 7
    //   632: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   635: ifeq -8 -> 627
    //   638: ldc_w 296
    //   641: aload 7
    //   643: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   646: pop
    //   647: goto -20 -> 627
    //   650: astore 10
    //   652: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   655: ifeq -271 -> 384
    //   658: ldc_w 296
    //   661: aload 10
    //   663: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   666: pop
    //   667: goto -283 -> 384
    //   670: iload 6
    //   672: bipush 10
    //   674: if_icmpne -473 -> 201
    //   677: aload_0
    //   678: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   681: ldc_w 298
    //   684: aload 7
    //   686: ldc 156
    //   688: invokevirtual 302	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   691: invokestatic 308	com/sonyericsson/extras/liveware/analytics/SmartConnectAnalytics:trackEvent	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   694: goto -493 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	697	0	this	RegistrationProvider
    //   0	697	1	paramUri	Uri
    //   0	697	2	paramContentValues	ContentValues
    //   0	697	3	paramInt1	int
    //   0	697	4	paramSQLiteDatabase	SQLiteDatabase
    //   0	697	5	paramInt2	int
    //   46	378	6	i	int
    //   433	38	6	localIntent	Intent
    //   580	33	6	localSQLException	SQLException
    //   615	60	6	localObject1	Object
    //   29	470	7	localContentValues	ContentValues
    //   630	55	7	localSQLiteException1	android.database.sqlite.SQLiteException
    //   153	105	8	j	int
    //   320	78	8	l	long
    //   171	109	9	str1	String
    //   162	75	10	localObject2	Object
    //   297	78	10	k	int
    //   385	21	10	localUri	Uri
    //   575	43	10	m	int
    //   650	12	10	localSQLiteException2	android.database.sqlite.SQLiteException
    //   286	313	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   309	374	580	android/database/SQLException
    //   309	374	615	finally
    //   582	615	615	finally
    //   622	627	630	android/database/sqlite/SQLiteException
    //   379	384	650	android/database/sqlite/SQLiteException
  }
  
  private void syncNotificationDatabase(Context paramContext, int paramInt, TreeMap<String, Integer> paramTreeMap)
  {
    String[] arrayOfString2 = (String[])mRegistrationPermission.lookUpExtensionsForUid(paramInt, getWritableDatabase(), paramContext, 0).keySet().toArray(new String[0]);
    int i = arrayOfString2.length;
    for (int j = 0; j < i; j++) {
      paramTreeMap.remove(arrayOfString2[j]);
    }
    if (!paramTreeMap.isEmpty())
    {
      String[] arrayOfString1 = (String[])paramTreeMap.keySet().toArray(new String[0]);
      new NotificationDatabaseHelper(getContext()).deleteAllForExtensions(arrayOfString1);
    }
  }
  
  /* Error */
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 118	android/os/Binder:getCallingUid	()I
    //   3: istore 6
    //   5: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   8: iload 6
    //   10: aload_0
    //   11: invokevirtual 314	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: aload_0
    //   15: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   18: iconst_0
    //   19: invokevirtual 318	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:lookUpExtensionsForUid	(ILandroid/database/sqlite/SQLiteDatabase;Landroid/content/Context;I)Ljava/util/TreeMap;
    //   22: astore 5
    //   24: iconst_0
    //   25: istore 4
    //   27: aload_0
    //   28: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   31: invokevirtual 128	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   34: iload 6
    //   36: invokevirtual 134	android/content/pm/PackageManager:getNameForUid	(I)Ljava/lang/String;
    //   39: astore 8
    //   41: bipush 255
    //   43: istore 6
    //   45: aload 5
    //   47: invokevirtual 338	java/util/TreeMap:isEmpty	()Z
    //   50: ifne +21 -> 71
    //   53: aload 5
    //   55: aload 5
    //   57: invokevirtual 357	java/util/TreeMap:firstKey	()Ljava/lang/Object;
    //   60: invokevirtual 360	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 281	java/lang/Integer
    //   66: invokevirtual 363	java/lang/Integer:intValue	()I
    //   69: istore 6
    //   71: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   74: aload_0
    //   75: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   78: iload 6
    //   80: invokevirtual 367	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:checkPermission	(Landroid/content/Context;I)I
    //   83: istore 9
    //   85: iload 9
    //   87: iconst_3
    //   88: if_icmpne +29 -> 117
    //   91: new 369	java/lang/SecurityException
    //   94: dup
    //   95: new 200	java/lang/StringBuilder
    //   98: dup
    //   99: ldc_w 371
    //   102: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload 8
    //   107: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokespecial 372	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
    //   116: athrow
    //   117: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   120: aload_2
    //   121: invokevirtual 374	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:checkForSqlInjectionAttempt	(Ljava/lang/String;)V
    //   124: iconst_0
    //   125: istore 7
    //   127: aconst_null
    //   128: astore 6
    //   130: aload_0
    //   131: invokevirtual 314	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   134: astore 6
    //   136: aload 6
    //   138: invokevirtual 189	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   141: getstatic 26	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:sUriMatcher	Landroid/content/UriMatcher;
    //   144: aload_1
    //   145: invokevirtual 110	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   148: lookupswitch	default:+188->336, 10:+307->455, 15:+432->580, 20:+511->659, 25:+580->728, 30:+673->821, 35:+833->981, 40:+693->841, 45:+870->1018, 50:+713->861, 55:+907->1055, 60:+733->881, 65:+944->1092, 70:+773->921, 75:+1018->1166, 80:+753->901, 85:+981->1129, 90:+793->941, 95:+1055->1203, 100:+813->961, 105:+1092->1240, 130:+1129->1277, 140:+1149->1297
    //   337: nop
    //   338: castore
    //   339: dup
    //   340: ldc 112
    //   342: invokespecial 113	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   345: athrow
    //   346: astore 7
    //   348: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   351: ifeq +29 -> 380
    //   354: new 200	java/lang/StringBuilder
    //   357: dup
    //   358: ldc_w 376
    //   361: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   364: aload_1
    //   365: invokevirtual 377	android/net/Uri:toString	()Ljava/lang/String;
    //   368: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: aload 7
    //   376: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   379: pop
    //   380: iconst_0
    //   381: istore 7
    //   383: aload 6
    //   385: ifnull +26 -> 411
    //   388: aload 6
    //   390: invokevirtual 226	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   393: iload 4
    //   395: ifeq +16 -> 411
    //   398: aload_0
    //   399: aload_0
    //   400: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   403: invokestatic 118	android/os/Binder:getCallingUid	()I
    //   406: aload 5
    //   408: invokespecial 379	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:syncNotificationDatabase	(Landroid/content/Context;ILjava/util/TreeMap;)V
    //   411: invokestatic 382	com/sonyericsson/extras/liveware/utils/Dbg:d	()Z
    //   414: ifeq +38 -> 452
    //   417: new 200	java/lang/StringBuilder
    //   420: dup
    //   421: ldc_w 384
    //   424: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   427: iload 7
    //   429: invokevirtual 387	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: ldc_w 389
    //   435: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_1
    //   439: invokevirtual 377	android/net/Uri:toString	()Ljava/lang/String;
    //   442: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 391	com/sonyericsson/extras/liveware/utils/Dbg:d	(Ljava/lang/String;)Z
    //   451: pop
    //   452: iload 7
    //   454: ireturn
    //   455: iload 9
    //   457: iconst_1
    //   458: if_icmpne +87 -> 545
    //   461: aload 6
    //   463: ldc 181
    //   465: aload_2
    //   466: aload_3
    //   467: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   470: istore 7
    //   472: aload 6
    //   474: invokevirtual 223	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   477: iload 7
    //   479: ifle +15 -> 494
    //   482: aload_0
    //   483: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   486: invokevirtual 242	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   489: aload_1
    //   490: aconst_null
    //   491: invokevirtual 248	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   494: aload 6
    //   496: ifnull -85 -> 411
    //   499: aload 6
    //   501: invokevirtual 226	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   504: iload 4
    //   506: ifeq -95 -> 411
    //   509: aload_0
    //   510: aload_0
    //   511: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   514: invokestatic 118	android/os/Binder:getCallingUid	()I
    //   517: aload 5
    //   519: invokespecial 379	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:syncNotificationDatabase	(Landroid/content/Context;ILjava/util/TreeMap;)V
    //   522: goto -111 -> 411
    //   525: astore 4
    //   527: invokestatic 382	com/sonyericsson/extras/liveware/utils/Dbg:d	()Z
    //   530: ifeq -119 -> 411
    //   533: aload 4
    //   535: invokevirtual 395	java/lang/Exception:toString	()Ljava/lang/String;
    //   538: invokestatic 391	com/sonyericsson/extras/liveware/utils/Dbg:d	(Ljava/lang/String;)Z
    //   541: pop
    //   542: goto -131 -> 411
    //   545: iload 9
    //   547: iconst_2
    //   548: if_icmpne -76 -> 472
    //   551: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   554: aload_2
    //   555: aload_3
    //   556: aload 8
    //   558: ldc 179
    //   560: ldc 181
    //   562: aload 6
    //   564: invokevirtual 399	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:restrictedDelete	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)I
    //   567: istore 7
    //   569: iload 7
    //   571: ifle -99 -> 472
    //   574: iconst_1
    //   575: istore 4
    //   577: goto -105 -> 472
    //   580: iload 9
    //   582: iconst_1
    //   583: if_icmpne +34 -> 617
    //   586: iconst_1
    //   587: anewarray 136	java/lang/String
    //   590: astore 7
    //   592: aload 7
    //   594: iconst_0
    //   595: aload_1
    //   596: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   599: aastore
    //   600: aload 6
    //   602: ldc 181
    //   604: ldc_w 404
    //   607: aload 7
    //   609: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   612: istore 7
    //   614: goto -142 -> 472
    //   617: iload 9
    //   619: iconst_2
    //   620: if_icmpne -148 -> 472
    //   623: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   626: aload_2
    //   627: aload_3
    //   628: aload 8
    //   630: ldc 179
    //   632: aload_1
    //   633: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   636: ldc_w 406
    //   639: ldc 181
    //   641: aload 6
    //   643: invokevirtual 409	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:restrictedDelete	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)I
    //   646: istore 7
    //   648: iload 7
    //   650: ifle -178 -> 472
    //   653: iconst_1
    //   654: istore 4
    //   656: goto -184 -> 472
    //   659: iload 9
    //   661: iconst_1
    //   662: if_icmpne +18 -> 680
    //   665: aload 6
    //   667: ldc_w 289
    //   670: aload_2
    //   671: aload_3
    //   672: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   675: istore 7
    //   677: goto -205 -> 472
    //   680: iload 9
    //   682: iconst_2
    //   683: if_icmpne -211 -> 472
    //   686: aload 5
    //   688: invokevirtual 413	java/util/TreeMap:values	()Ljava/util/Collection;
    //   691: iconst_0
    //   692: anewarray 281	java/lang/Integer
    //   695: invokeinterface 416 2 0
    //   700: checkcast 418	[Ljava/lang/Integer;
    //   703: astore 7
    //   705: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   708: aload_2
    //   709: aload_3
    //   710: aload 7
    //   712: ldc_w 276
    //   715: ldc_w 289
    //   718: aload 6
    //   720: invokevirtual 421	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:restrictedDelete	(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)I
    //   723: istore 7
    //   725: goto -253 -> 472
    //   728: iload 9
    //   730: iconst_1
    //   731: if_icmpne +35 -> 766
    //   734: iconst_1
    //   735: anewarray 136	java/lang/String
    //   738: astore 7
    //   740: aload 7
    //   742: iconst_0
    //   743: aload_1
    //   744: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   747: aastore
    //   748: aload 6
    //   750: ldc_w 289
    //   753: ldc_w 404
    //   756: aload 7
    //   758: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   761: istore 7
    //   763: goto -291 -> 472
    //   766: iload 9
    //   768: iconst_2
    //   769: if_icmpne -297 -> 472
    //   772: aload 5
    //   774: invokevirtual 413	java/util/TreeMap:values	()Ljava/util/Collection;
    //   777: iconst_0
    //   778: anewarray 281	java/lang/Integer
    //   781: invokeinterface 416 2 0
    //   786: checkcast 418	[Ljava/lang/Integer;
    //   789: astore 7
    //   791: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   794: aload_2
    //   795: aload_3
    //   796: aload 7
    //   798: ldc_w 276
    //   801: aload_1
    //   802: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   805: ldc_w 406
    //   808: ldc_w 289
    //   811: aload 6
    //   813: invokevirtual 424	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:restrictedDelete	(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;)I
    //   816: istore 7
    //   818: goto -346 -> 472
    //   821: iload 9
    //   823: iconst_1
    //   824: if_icmpne -352 -> 472
    //   827: aload 6
    //   829: ldc 42
    //   831: aload_2
    //   832: aload_3
    //   833: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   836: istore 7
    //   838: goto -366 -> 472
    //   841: iload 9
    //   843: iconst_1
    //   844: if_icmpne -372 -> 472
    //   847: aload 6
    //   849: ldc 46
    //   851: aload_2
    //   852: aload_3
    //   853: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   856: istore 7
    //   858: goto -386 -> 472
    //   861: iload 9
    //   863: iconst_1
    //   864: if_icmpne -392 -> 472
    //   867: aload 6
    //   869: ldc 50
    //   871: aload_2
    //   872: aload_3
    //   873: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   876: istore 7
    //   878: goto -406 -> 472
    //   881: iload 9
    //   883: iconst_1
    //   884: if_icmpne -412 -> 472
    //   887: aload 6
    //   889: ldc 54
    //   891: aload_2
    //   892: aload_3
    //   893: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   896: istore 7
    //   898: goto -426 -> 472
    //   901: iload 9
    //   903: iconst_1
    //   904: if_icmpne -432 -> 472
    //   907: aload 6
    //   909: ldc 58
    //   911: aload_2
    //   912: aload_3
    //   913: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   916: istore 7
    //   918: goto -446 -> 472
    //   921: iload 9
    //   923: iconst_1
    //   924: if_icmpne -452 -> 472
    //   927: aload 6
    //   929: ldc 62
    //   931: aload_2
    //   932: aload_3
    //   933: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   936: istore 7
    //   938: goto -466 -> 472
    //   941: iload 9
    //   943: iconst_1
    //   944: if_icmpne -472 -> 472
    //   947: aload 6
    //   949: ldc 66
    //   951: aload_2
    //   952: aload_3
    //   953: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   956: istore 7
    //   958: goto -486 -> 472
    //   961: iload 9
    //   963: iconst_1
    //   964: if_icmpne -492 -> 472
    //   967: aload 6
    //   969: ldc 70
    //   971: aload_2
    //   972: aload_3
    //   973: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   976: istore 7
    //   978: goto -506 -> 472
    //   981: iload 9
    //   983: iconst_1
    //   984: if_icmpne -512 -> 472
    //   987: iconst_1
    //   988: anewarray 136	java/lang/String
    //   991: astore 7
    //   993: aload 7
    //   995: iconst_0
    //   996: aload_1
    //   997: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1000: aastore
    //   1001: aload 6
    //   1003: ldc 42
    //   1005: ldc_w 404
    //   1008: aload 7
    //   1010: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1013: istore 7
    //   1015: goto -543 -> 472
    //   1018: iload 9
    //   1020: iconst_1
    //   1021: if_icmpne -549 -> 472
    //   1024: iconst_1
    //   1025: anewarray 136	java/lang/String
    //   1028: astore 7
    //   1030: aload 7
    //   1032: iconst_0
    //   1033: aload_1
    //   1034: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1037: aastore
    //   1038: aload 6
    //   1040: ldc 46
    //   1042: ldc_w 404
    //   1045: aload 7
    //   1047: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1050: istore 7
    //   1052: goto -580 -> 472
    //   1055: iload 9
    //   1057: iconst_1
    //   1058: if_icmpne -586 -> 472
    //   1061: iconst_1
    //   1062: anewarray 136	java/lang/String
    //   1065: astore 7
    //   1067: aload 7
    //   1069: iconst_0
    //   1070: aload_1
    //   1071: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1074: aastore
    //   1075: aload 6
    //   1077: ldc 50
    //   1079: ldc_w 404
    //   1082: aload 7
    //   1084: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1087: istore 7
    //   1089: goto -617 -> 472
    //   1092: iload 9
    //   1094: iconst_1
    //   1095: if_icmpne -623 -> 472
    //   1098: iconst_1
    //   1099: anewarray 136	java/lang/String
    //   1102: astore 7
    //   1104: aload 7
    //   1106: iconst_0
    //   1107: aload_1
    //   1108: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1111: aastore
    //   1112: aload 6
    //   1114: ldc 54
    //   1116: ldc_w 404
    //   1119: aload 7
    //   1121: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1124: istore 7
    //   1126: goto -654 -> 472
    //   1129: iload 9
    //   1131: iconst_1
    //   1132: if_icmpne -660 -> 472
    //   1135: iconst_1
    //   1136: anewarray 136	java/lang/String
    //   1139: astore 7
    //   1141: aload 7
    //   1143: iconst_0
    //   1144: aload_1
    //   1145: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1148: aastore
    //   1149: aload 6
    //   1151: ldc 58
    //   1153: ldc_w 404
    //   1156: aload 7
    //   1158: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1161: istore 7
    //   1163: goto -691 -> 472
    //   1166: iload 9
    //   1168: iconst_1
    //   1169: if_icmpne -697 -> 472
    //   1172: iconst_1
    //   1173: anewarray 136	java/lang/String
    //   1176: astore 7
    //   1178: aload 7
    //   1180: iconst_0
    //   1181: aload_1
    //   1182: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1185: aastore
    //   1186: aload 6
    //   1188: ldc 62
    //   1190: ldc_w 404
    //   1193: aload 7
    //   1195: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1198: istore 7
    //   1200: goto -728 -> 472
    //   1203: iload 9
    //   1205: iconst_1
    //   1206: if_icmpne -734 -> 472
    //   1209: iconst_1
    //   1210: anewarray 136	java/lang/String
    //   1213: astore 7
    //   1215: aload 7
    //   1217: iconst_0
    //   1218: aload_1
    //   1219: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1222: aastore
    //   1223: aload 6
    //   1225: ldc 66
    //   1227: ldc_w 404
    //   1230: aload 7
    //   1232: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1235: istore 7
    //   1237: goto -765 -> 472
    //   1240: iload 9
    //   1242: iconst_1
    //   1243: if_icmpne -771 -> 472
    //   1246: iconst_1
    //   1247: anewarray 136	java/lang/String
    //   1250: astore 7
    //   1252: aload 7
    //   1254: iconst_0
    //   1255: aload_1
    //   1256: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1259: aastore
    //   1260: aload 6
    //   1262: ldc 70
    //   1264: ldc_w 404
    //   1267: aload 7
    //   1269: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1272: istore 7
    //   1274: goto -802 -> 472
    //   1277: iload 9
    //   1279: iconst_1
    //   1280: if_icmpne -808 -> 472
    //   1283: aload 6
    //   1285: ldc 78
    //   1287: aload_2
    //   1288: aload_3
    //   1289: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1292: istore 7
    //   1294: goto -822 -> 472
    //   1297: iload 9
    //   1299: iconst_1
    //   1300: if_icmpne -828 -> 472
    //   1303: iconst_1
    //   1304: anewarray 136	java/lang/String
    //   1307: astore 7
    //   1309: aload 7
    //   1311: iconst_0
    //   1312: aload_1
    //   1313: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1316: aastore
    //   1317: aload 6
    //   1319: ldc 78
    //   1321: ldc_w 404
    //   1324: aload 7
    //   1326: invokevirtual 394	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1329: istore 7
    //   1331: iload 7
    //   1333: istore 7
    //   1335: goto -863 -> 472
    //   1338: astore 6
    //   1340: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   1343: ifeq -950 -> 393
    //   1346: ldc_w 296
    //   1349: aload 6
    //   1351: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   1354: pop
    //   1355: goto -962 -> 393
    //   1358: astore 4
    //   1360: invokestatic 382	com/sonyericsson/extras/liveware/utils/Dbg:d	()Z
    //   1363: ifeq -952 -> 411
    //   1366: aload 4
    //   1368: invokevirtual 395	java/lang/Exception:toString	()Ljava/lang/String;
    //   1371: invokestatic 391	com/sonyericsson/extras/liveware/utils/Dbg:d	(Ljava/lang/String;)Z
    //   1374: pop
    //   1375: goto -964 -> 411
    //   1378: astore 7
    //   1380: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   1383: ifeq +29 -> 1412
    //   1386: new 200	java/lang/StringBuilder
    //   1389: dup
    //   1390: ldc_w 426
    //   1393: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1396: aload_1
    //   1397: invokevirtual 377	android/net/Uri:toString	()Ljava/lang/String;
    //   1400: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1406: aload 7
    //   1408: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   1411: pop
    //   1412: aload 7
    //   1414: athrow
    //   1415: astore 7
    //   1417: aload 6
    //   1419: ifnull +26 -> 1445
    //   1422: aload 6
    //   1424: invokevirtual 226	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   1427: iload 4
    //   1429: ifeq +16 -> 1445
    //   1432: aload_0
    //   1433: aload_0
    //   1434: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   1437: invokestatic 118	android/os/Binder:getCallingUid	()I
    //   1440: aload 5
    //   1442: invokespecial 379	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:syncNotificationDatabase	(Landroid/content/Context;ILjava/util/TreeMap;)V
    //   1445: aload 7
    //   1447: athrow
    //   1448: astore 6
    //   1450: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   1453: ifeq -26 -> 1427
    //   1456: ldc_w 296
    //   1459: aload 6
    //   1461: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   1464: pop
    //   1465: goto -38 -> 1427
    //   1468: astore 4
    //   1470: invokestatic 382	com/sonyericsson/extras/liveware/utils/Dbg:d	()Z
    //   1473: ifeq -28 -> 1445
    //   1476: aload 4
    //   1478: invokevirtual 395	java/lang/Exception:toString	()Ljava/lang/String;
    //   1481: invokestatic 391	com/sonyericsson/extras/liveware/utils/Dbg:d	(Ljava/lang/String;)Z
    //   1484: pop
    //   1485: goto -40 -> 1445
    //   1488: astore 6
    //   1490: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   1493: ifeq -989 -> 504
    //   1496: ldc_w 296
    //   1499: aload 6
    //   1501: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   1504: pop
    //   1505: goto -1001 -> 504
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1508	0	this	RegistrationProvider
    //   0	1508	1	paramUri	Uri
    //   0	1508	2	paramString	String
    //   0	1508	3	paramArrayOfString	String[]
    //   25	480	4	i	int
    //   525	9	4	localException1	java.lang.Exception
    //   575	80	4	j	int
    //   1358	70	4	localException2	java.lang.Exception
    //   1468	9	4	localException3	java.lang.Exception
    //   22	1419	5	localTreeMap	TreeMap
    //   3	76	6	k	int
    //   128	1190	6	localSQLiteDatabase	SQLiteDatabase
    //   1338	85	6	localSQLiteException1	android.database.sqlite.SQLiteException
    //   1448	12	6	localSQLiteException2	android.database.sqlite.SQLiteException
    //   1488	12	6	localSQLiteException3	android.database.sqlite.SQLiteException
    //   125	1	7	m	int
    //   346	29	7	localSQLiteConstraintException	android.database.sqlite.SQLiteConstraintException
    //   381	189	7	n	int
    //   590	18	7	arrayOfString1	String[]
    //   612	64	7	i1	int
    //   703	8	7	arrayOfInteger1	Integer[]
    //   723	1	7	i2	int
    //   738	19	7	arrayOfString2	String[]
    //   761	1	7	i3	int
    //   789	8	7	arrayOfInteger2	Integer[]
    //   816	161	7	i4	int
    //   991	18	7	arrayOfString3	String[]
    //   1013	1	7	i5	int
    //   1028	18	7	arrayOfString4	String[]
    //   1050	1	7	i6	int
    //   1065	18	7	arrayOfString5	String[]
    //   1087	1	7	i7	int
    //   1102	18	7	arrayOfString6	String[]
    //   1124	1	7	i8	int
    //   1139	18	7	arrayOfString7	String[]
    //   1161	1	7	i9	int
    //   1176	18	7	arrayOfString8	String[]
    //   1198	1	7	i10	int
    //   1213	18	7	arrayOfString9	String[]
    //   1235	1	7	i11	int
    //   1250	18	7	arrayOfString10	String[]
    //   1272	21	7	i12	int
    //   1307	18	7	arrayOfString11	String[]
    //   1329	5	7	i13	int
    //   1378	35	7	localSQLException	SQLException
    //   1415	31	7	localObject	Object
    //   39	590	8	str	String
    //   83	1218	9	i14	int
    // Exception table:
    //   from	to	target	type
    //   130	346	346	android/database/sqlite/SQLiteConstraintException
    //   461	494	346	android/database/sqlite/SQLiteConstraintException
    //   551	1331	346	android/database/sqlite/SQLiteConstraintException
    //   509	522	525	java/lang/Exception
    //   388	393	1338	android/database/sqlite/SQLiteException
    //   398	411	1358	java/lang/Exception
    //   130	346	1378	android/database/SQLException
    //   461	494	1378	android/database/SQLException
    //   551	1331	1378	android/database/SQLException
    //   130	346	1415	finally
    //   348	380	1415	finally
    //   461	494	1415	finally
    //   551	1331	1415	finally
    //   1380	1415	1415	finally
    //   1422	1427	1448	android/database/sqlite/SQLiteException
    //   1432	1445	1468	java/lang/Exception
    //   499	504	1488	android/database/sqlite/SQLiteException
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
    case 15: 
      str = "vnd.android.cursor.dir/aef-extensions";
      break;
    case 20: 
    case 25: 
      str = "vnd.android.cursor.dir/aef-registration";
      break;
    case 30: 
    case 35: 
      str = "vnd.android.cursor.dir/aef-host_application";
      break;
    case 40: 
    case 45: 
      str = "vnd.android.cursor.dir/aef-device";
      break;
    case 50: 
    case 55: 
      str = "vnd.android.cursor.dir/aef-display";
      break;
    case 60: 
    case 65: 
      str = "vnd.android.cursor.dir/aef-sensor";
      break;
    case 70: 
    case 75: 
      str = "vnd.android.cursor.dir/aef-led";
      break;
    case 80: 
    case 85: 
      str = "vnd.android.cursor.dir/aef-input";
      break;
    case 90: 
    case 95: 
      str = "vnd.android.cursor.dir/aef-sensor_type";
      break;
    case 100: 
    case 105: 
      str = "vnd.android.cursor.dir/aef-keypad";
    }
    return str;
  }
  
  SQLiteDatabase getWritableDatabase()
  {
    return this.mOpenHelper.getWritableDatabase();
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    int i1 = Binder.getCallingUid();
    TreeMap localTreeMap = mRegistrationPermission.lookUpExtensionsForUid(i1, getWritableDatabase(), getContext(), 0);
    PackageManager localPackageManager = getContext().getPackageManager();
    String str = localPackageManager.getNameForUid(i1);
    int i = -1;
    if (paramContentValues.containsKey("extensionId"))
    {
      i = mRegistrationPermission.getExtensionIdForExtensionId(localTreeMap, paramContentValues);
      localObject = null;
      if (!paramContentValues.containsKey("packageName")) {
        break label314;
      }
    }
    int k;
    label314:
    String[] arrayOfString;
    for (Object localObject = paramContentValues.getAsString("packageName");; localObject = arrayOfString[0]) {
      do
      {
        int n = mRegistrationPermission.checkPermissionExtended(getContext(), i, getWritableDatabase(), (String)localObject);
        i1 = sUriMatcher.match(paramUri);
        if (n != 3) {
          break label344;
        }
        if ((i1 == 10) && (mRegistrationPermission.isAnyHostAppPresent(getWritableDatabase())) && (localObject != null) && (!mRegistrationPermission.isPermissionRequesed(getWritableDatabase(), (String)localObject)) && (mRegistrationPermission.insertPermissionRequest(getWritableDatabase(), (String)localObject) > 0L))
        {
          Intent localIntent = new Intent("com.sonyericsson.extras.liveware.aef.registration.REQUEST_PERMISSION");
          localIntent.putExtra("packageName", (String)localObject);
          localIntent.addFlags(805306368);
          getContext().startActivity(localIntent);
        }
        throw new SecurityException("You do not have sufficient permission to insert data! Caller package name: " + str);
        if (paramContentValues.containsKey("packageName"))
        {
          int j = mRegistrationPermission.getExtensionIdForPackage(localTreeMap, paramContentValues);
          break;
        }
        localObject = n.getPackagesForUid(i1);
        if ((localObject == null) || (localObject.length != 1)) {
          break;
        }
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("packageName", localObject[0]);
        k = mRegistrationPermission.getExtensionIdForPackage(localTreeMap, localContentValues);
        break;
        arrayOfString = n.getPackagesForUid(i1);
      } while ((arrayOfString == null) || (arrayOfString.length != 1));
    }
    label344:
    if ((i1 != 10) && (i1 != 20))
    {
      if (arrayOfString == 2)
      {
        if (Dbg.v()) {
          Dbg.v("Caller is not a registered plugin");
        }
        throw new SecurityException("You do not have sufficient permission to perform a insert");
      }
    }
    else
    {
      if (mRegistrationPermission.checkHostAppPermission(getContext())) {
        throw new SecurityException("You do not have sufficient permission to perform a insert");
      }
      if (i1 == 10)
      {
        int m = 0;
        if (paramContentValues.containsKey("notificationApiVersion")) {
          m = paramContentValues.getAsInteger("notificationApiVersion").intValue();
        }
        if (m >= 1)
        {
          if (!mRegistrationPermission.isAnyHostAppSupportingNotificationApi(getWritableDatabase()))
          {
            if (Dbg.v()) {
              Dbg.v("Host app does not support notification");
            }
            throw new SecurityException("Host application is not registered");
          }
        }
        else if (!mRegistrationPermission.isAnyHostAppPresent(getWritableDatabase()))
        {
          if (Dbg.v()) {
            Dbg.v("No host application present");
          }
          throw new SecurityException("Host application is not registered");
        }
      }
      else if (i1 == 20)
      {
        if (!paramContentValues.containsKey("hostAppPackageName")) {
          throw new SQLException("Missing column 'hostAppPackageName' for ContentValues.");
        }
      }
    }
    try
    {
      EnumSet localEnumSet = mRegistrationPermission.enumApiContentvalues(paramContentValues);
      mRegistrationPermission.verifyHostAppUse(paramContentValues.getAsString("hostAppPackageName"), localEnumSet, getWritableDatabase(), getContext());
      return doInsert(paramUri, paramContentValues, k, getWritableDatabase(), arrayOfString);
    }
    catch (SQLException localSQLException)
    {
      throw new SecurityException(localSQLException.getMessage());
    }
  }
  
  public boolean onCreate()
  {
    this.mOpenHelper = new RegistrationDatabaseHelper(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int i = Binder.getCallingUid();
    Object localObject2 = mRegistrationPermission.lookUpExtensionsForUid(i, getWritableDatabase(), getContext(), 0);
    Object localObject1 = getContext().getPackageManager().getNameForUid(i);
    i = -1;
    if (!((TreeMap)localObject2).isEmpty()) {
      i = ((Integer)((TreeMap)localObject2).get(((TreeMap)localObject2).firstKey())).intValue();
    }
    int k = mRegistrationPermission.checkPermission(getContext(), i);
    Cursor localCursor = null;
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
    int j = sUriMatcher.match(paramUri);
    if ((j == 10) || (j == 15) || (j == 20) || (j == 25) || (k != 3))
    {
      Object localObject3;
      switch (j)
      {
      default: 
        throw new SQLException("Invalid uri for this content provider.");
      case 10: 
        if (k != 2)
        {
          if (k == 1) {
            localCursor = localSQLiteDatabase.query("extension", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
          }
        }
        else
        {
          if (paramArrayOfString1 == null)
          {
            paramArrayOfString1 = RegistrationInternal.ExtensionImpl.pluginProjection();
          }
          else
          {
            localObject2 = mRegistrationPermission;
            localObject3 = RegistrationInternal.ExtensionImpl.restrictedQueryColumns();
            ((RegistrationPermission)localObject2).verifyProjection(paramArrayOfString1, (String[])localObject3);
          }
          localCursor = mRegistrationPermission.restrictedQuery(localSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (String)localObject1, "userId", "extension");
        }
        break;
      case 15: 
        if (k != 1)
        {
          if (k == 2)
          {
            if (paramArrayOfString1 == null)
            {
              paramArrayOfString1 = RegistrationInternal.ExtensionImpl.pluginProjection();
            }
            else
            {
              localObject2 = mRegistrationPermission;
              localObject3 = RegistrationInternal.ExtensionImpl.restrictedQueryColumns();
              ((RegistrationPermission)localObject2).verifyProjection(paramArrayOfString1, (String[])localObject3);
            }
            localObject3 = mRegistrationPermission;
            localObject2 = paramUri.getLastPathSegment();
            localCursor = ((RegistrationPermission)localObject3).restrictedQuery(localSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (String)localObject1, "userId", (String)localObject2, "_id", "extension");
          }
        }
        else
        {
          localObject1 = new String[1];
          localObject1[0] = paramUri.getLastPathSegment();
          localCursor = localSQLiteDatabase.query("extension", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        }
        break;
      case 20: 
        if (k != 2)
        {
          if (k == 1) {
            localCursor = localSQLiteDatabase.query("registration", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
          }
        }
        else
        {
          if (paramArrayOfString1 == null)
          {
            paramArrayOfString1 = RegistrationInternal.ApiRegistrationImpl.registrationProjection();
          }
          else
          {
            localObject3 = mRegistrationPermission;
            localObject1 = RegistrationInternal.ApiRegistrationImpl.restrictedQueryColumns();
            ((RegistrationPermission)localObject3).verifyProjection(paramArrayOfString1, (String[])localObject1);
          }
          localObject1 = (Integer[])((TreeMap)localObject2).values().toArray(new Integer[0]);
          localCursor = mRegistrationPermission.restrictedQuery(localSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (Integer[])localObject1, "extensionId", "registration");
        }
        break;
      case 25: 
        if (k != 1)
        {
          if (k == 2)
          {
            if (paramArrayOfString1 == null)
            {
              paramArrayOfString1 = RegistrationInternal.ApiRegistrationImpl.registrationProjection();
            }
            else
            {
              localObject3 = mRegistrationPermission;
              localObject1 = RegistrationInternal.ApiRegistrationImpl.restrictedQueryColumns();
              ((RegistrationPermission)localObject3).verifyProjection(paramArrayOfString1, (String[])localObject1);
            }
            localObject1 = (Integer[])((TreeMap)localObject2).values().toArray(new Integer[0]);
            localObject3 = mRegistrationPermission;
            localObject2 = paramUri.getLastPathSegment();
            localCursor = ((RegistrationPermission)localObject3).restrictedQuery(localSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (Integer[])localObject1, "extensionId", (String)localObject2, "_id", "registration");
          }
        }
        else
        {
          localObject1 = new String[1];
          localObject1[0] = paramUri.getLastPathSegment();
          localCursor = localSQLiteDatabase.query("registration", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        }
        break;
      case 30: 
        localCursor = localSQLiteDatabase.query("host_application", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        break;
      case 35: 
        localObject1 = new String[1];
        localObject1[0] = paramUri.getLastPathSegment();
        localCursor = localSQLiteDatabase.query("host_application", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        break;
      case 40: 
        localCursor = localSQLiteDatabase.query("device", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        break;
      case 45: 
        localObject1 = new String[1];
        localObject1[0] = paramUri.getLastPathSegment();
        localCursor = localSQLiteDatabase.query("device", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        break;
      case 50: 
        localCursor = localSQLiteDatabase.query("display", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        break;
      case 55: 
        localObject1 = new String[1];
        localObject1[0] = paramUri.getLastPathSegment();
        localCursor = localSQLiteDatabase.query("display", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        break;
      case 60: 
        localCursor = localSQLiteDatabase.query("sensor", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        break;
      case 65: 
        localObject1 = new String[1];
        localObject1[0] = paramUri.getLastPathSegment();
        localCursor = localSQLiteDatabase.query("sensor", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        break;
      case 70: 
        localCursor = localSQLiteDatabase.query("led", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        break;
      case 75: 
        localObject1 = new String[1];
        localObject1[0] = paramUri.getLastPathSegment();
        localCursor = localSQLiteDatabase.query("led", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        break;
      case 80: 
        localCursor = localSQLiteDatabase.query("input", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        break;
      case 85: 
        localObject1 = new String[1];
        localObject1[0] = paramUri.getLastPathSegment();
        localCursor = localSQLiteDatabase.query("input", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        break;
      case 90: 
        localCursor = localSQLiteDatabase.query("sensor_type", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        break;
      case 95: 
        localObject1 = new String[1];
        localObject1[0] = paramUri.getLastPathSegment();
        localCursor = localSQLiteDatabase.query("sensor_type", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        break;
      case 100: 
        localCursor = localSQLiteDatabase.query("keypad", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        break;
      case 105: 
        localObject1 = new String[1];
        localObject1[0] = paramUri.getLastPathSegment();
        localCursor = localSQLiteDatabase.query("keypad", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        break;
      case 110: 
        localCursor = localSQLiteDatabase.query("capabilities", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        break;
      case 120: 
        if (k == 1) {
          localCursor = localSQLiteDatabase.rawQuery(paramString1, paramArrayOfString2);
        }
        break;
      case 130: 
        if (k == 1) {
          localCursor = localSQLiteDatabase.query("permission_request", paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
        }
        break;
      case 140: 
        if (k == 1)
        {
          localObject1 = new String[1];
          localObject1[0] = paramUri.getLastPathSegment();
          localCursor = localSQLiteDatabase.query("permission_request", paramArrayOfString1, "_id=?", (String[])localObject1, null, null, paramString2);
        }
        break;
      }
      return localCursor;
    }
    throw new SecurityException("You do not have sufficient permission to query data! Caller package name: " + (String)localObject1);
  }
  
  /* Error */
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokevirtual 93	android/content/ContentValues:size	()I
    //   8: ifne +14 -> 22
    //   11: new 95	java/lang/IllegalArgumentException
    //   14: dup
    //   15: ldc_w 586
    //   18: invokespecial 100	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   21: athrow
    //   22: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   25: aload_2
    //   26: invokevirtual 106	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:checkForSqlInjectionAttempt	(Landroid/content/ContentValues;)V
    //   29: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   32: aload_3
    //   33: invokevirtual 374	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:checkForSqlInjectionAttempt	(Ljava/lang/String;)V
    //   36: invokestatic 118	android/os/Binder:getCallingUid	()I
    //   39: istore 7
    //   41: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   44: iload 7
    //   46: aload_0
    //   47: invokevirtual 314	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: aload_0
    //   51: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   54: iconst_0
    //   55: invokevirtual 318	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:lookUpExtensionsForUid	(ILandroid/database/sqlite/SQLiteDatabase;Landroid/content/Context;I)Ljava/util/TreeMap;
    //   58: astore 5
    //   60: aload_0
    //   61: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   64: invokevirtual 128	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   67: iload 7
    //   69: invokevirtual 134	android/content/pm/PackageManager:getNameForUid	(I)Ljava/lang/String;
    //   72: astore 9
    //   74: bipush 255
    //   76: istore 8
    //   78: aload 5
    //   80: invokevirtual 338	java/util/TreeMap:isEmpty	()Z
    //   83: ifne +21 -> 104
    //   86: aload 5
    //   88: aload 5
    //   90: invokevirtual 357	java/util/TreeMap:firstKey	()Ljava/lang/Object;
    //   93: invokevirtual 360	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: checkcast 281	java/lang/Integer
    //   99: invokevirtual 363	java/lang/Integer:intValue	()I
    //   102: istore 8
    //   104: aload 5
    //   106: invokevirtual 413	java/util/TreeMap:values	()Ljava/util/Collection;
    //   109: iconst_0
    //   110: anewarray 281	java/lang/Integer
    //   113: invokeinterface 416 2 0
    //   118: checkcast 418	[Ljava/lang/Integer;
    //   121: astore 6
    //   123: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   126: aload_0
    //   127: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   130: iload 8
    //   132: invokevirtual 367	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:checkPermission	(Landroid/content/Context;I)I
    //   135: istore 8
    //   137: iload 8
    //   139: iconst_3
    //   140: if_icmpne +29 -> 169
    //   143: new 369	java/lang/SecurityException
    //   146: dup
    //   147: new 200	java/lang/StringBuilder
    //   150: dup
    //   151: ldc_w 588
    //   154: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload 9
    //   159: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokespecial 372	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
    //   168: athrow
    //   169: iload 8
    //   171: iconst_2
    //   172: if_icmpne +37 -> 209
    //   175: aload 5
    //   177: invokevirtual 338	java/util/TreeMap:isEmpty	()Z
    //   180: ifeq +29 -> 209
    //   183: new 369	java/lang/SecurityException
    //   186: dup
    //   187: new 200	java/lang/StringBuilder
    //   190: dup
    //   191: ldc_w 588
    //   194: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   197: aload 9
    //   199: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokespecial 372	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
    //   208: athrow
    //   209: iconst_0
    //   210: istore 9
    //   212: aconst_null
    //   213: astore 5
    //   215: aload_0
    //   216: invokevirtual 314	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   219: astore 5
    //   221: aload 5
    //   223: invokevirtual 189	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   226: getstatic 26	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:sUriMatcher	Landroid/content/UriMatcher;
    //   229: aload_1
    //   230: invokevirtual 110	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   233: lookupswitch	default:+187->420, 10:+247->480, 15:+485->718, 20:+635->868, 25:+658->891, 30:+864->1097, 35:+1040->1273, 40:+886->1119, 45:+1078->1311, 50:+908->1141, 55:+1116->1349, 60:+930->1163, 65:+1154->1387, 70:+974->1207, 75:+1230->1463, 80:+952->1185, 85:+1192->1425, 90:+996->1229, 95:+1268->1501, 100:+1018->1251, 105:+1306->1539, 130:+1344->1577, 140:+1366->1599
    //   421: nop
    //   422: castore
    //   423: dup
    //   424: ldc 112
    //   426: invokespecial 113	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   429: athrow
    //   430: astore 6
    //   432: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   435: ifeq +29 -> 464
    //   438: new 200	java/lang/StringBuilder
    //   441: dup
    //   442: ldc_w 376
    //   445: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   448: aload_1
    //   449: invokevirtual 377	android/net/Uri:toString	()Ljava/lang/String;
    //   452: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: aload 6
    //   460: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   463: pop
    //   464: iconst_0
    //   465: istore 9
    //   467: aload 5
    //   469: ifnull +8 -> 477
    //   472: aload 5
    //   474: invokevirtual 226	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   477: iload 9
    //   479: ireturn
    //   480: aload_2
    //   481: ldc 156
    //   483: invokevirtual 460	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   486: ifeq +16 -> 502
    //   489: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   492: iload 7
    //   494: aload_0
    //   495: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   498: aload_2
    //   499: invokevirtual 177	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:verifyPackage	(ILandroid/content/Context;Landroid/content/ContentValues;)V
    //   502: iload 8
    //   504: iconst_1
    //   505: if_icmpne +71 -> 576
    //   508: aload 5
    //   510: ldc 181
    //   512: aload_2
    //   513: aload_3
    //   514: aload 4
    //   516: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   519: istore 9
    //   521: aload 5
    //   523: invokevirtual 223	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   526: iload 9
    //   528: ifle +15 -> 543
    //   531: aload_0
    //   532: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   535: invokevirtual 242	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   538: aload_1
    //   539: aconst_null
    //   540: invokevirtual 248	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   543: aload 5
    //   545: ifnull -68 -> 477
    //   548: aload 5
    //   550: invokevirtual 226	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   553: goto -76 -> 477
    //   556: astore 5
    //   558: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   561: ifeq -84 -> 477
    //   564: ldc_w 296
    //   567: aload 5
    //   569: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   572: pop
    //   573: goto -96 -> 477
    //   576: iload 8
    //   578: iconst_2
    //   579: if_icmpne -58 -> 521
    //   582: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   585: aload_2
    //   586: invokestatic 169	com/sonyericsson/extras/liveware/aef/registration/RegistrationInternal$ExtensionImpl:restrictedModifyColumns	()[Ljava/lang/String;
    //   589: invokevirtual 173	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:verifyContentValues	(Landroid/content/ContentValues;[Ljava/lang/String;)V
    //   592: aload_2
    //   593: ldc_w 510
    //   596: invokevirtual 460	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   599: ifeq +91 -> 690
    //   602: aload_2
    //   603: ldc_w 510
    //   606: invokevirtual 514	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   609: invokevirtual 363	java/lang/Integer:intValue	()I
    //   612: iconst_1
    //   613: if_icmplt +77 -> 690
    //   616: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   619: aload 5
    //   621: invokevirtual 517	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:isAnyHostAppSupportingNotificationApi	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   624: ifne +66 -> 690
    //   627: new 369	java/lang/SecurityException
    //   630: dup
    //   631: ldc_w 521
    //   634: invokespecial 372	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
    //   637: athrow
    //   638: astore 6
    //   640: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   643: ifeq +29 -> 672
    //   646: new 200	java/lang/StringBuilder
    //   649: dup
    //   650: ldc_w 376
    //   653: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   656: aload_1
    //   657: invokevirtual 377	android/net/Uri:toString	()Ljava/lang/String;
    //   660: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: aload 6
    //   668: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   671: pop
    //   672: aload 6
    //   674: athrow
    //   675: astore 6
    //   677: aload 5
    //   679: ifnull +8 -> 687
    //   682: aload 5
    //   684: invokevirtual 226	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   687: aload 6
    //   689: athrow
    //   690: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   693: aload_1
    //   694: aload_2
    //   695: aload_3
    //   696: aload 4
    //   698: ldc 181
    //   700: aload 5
    //   702: ldc_w 406
    //   705: aload 6
    //   707: ldc_w 406
    //   710: invokevirtual 595	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:restrictedUpdate	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/String;)I
    //   713: istore 9
    //   715: goto -194 -> 521
    //   718: aload_2
    //   719: ldc 156
    //   721: invokevirtual 460	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   724: ifeq +16 -> 740
    //   727: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   730: iload 7
    //   732: aload_0
    //   733: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   736: aload_2
    //   737: invokevirtual 177	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:verifyPackage	(ILandroid/content/Context;Landroid/content/ContentValues;)V
    //   740: iload 8
    //   742: iconst_1
    //   743: if_icmpne +35 -> 778
    //   746: iconst_1
    //   747: anewarray 136	java/lang/String
    //   750: astore 6
    //   752: aload 6
    //   754: iconst_0
    //   755: aload_1
    //   756: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   759: aastore
    //   760: aload 5
    //   762: ldc 181
    //   764: aload_2
    //   765: ldc_w 404
    //   768: aload 6
    //   770: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   773: istore 9
    //   775: goto -254 -> 521
    //   778: iload 8
    //   780: iconst_2
    //   781: if_icmpne -260 -> 521
    //   784: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   787: aload_2
    //   788: invokestatic 169	com/sonyericsson/extras/liveware/aef/registration/RegistrationInternal$ExtensionImpl:restrictedModifyColumns	()[Ljava/lang/String;
    //   791: invokevirtual 173	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:verifyContentValues	(Landroid/content/ContentValues;[Ljava/lang/String;)V
    //   794: aload_2
    //   795: ldc_w 510
    //   798: invokevirtual 460	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   801: ifeq +39 -> 840
    //   804: aload_2
    //   805: ldc_w 510
    //   808: invokevirtual 514	android/content/ContentValues:getAsInteger	(Ljava/lang/String;)Ljava/lang/Integer;
    //   811: invokevirtual 363	java/lang/Integer:intValue	()I
    //   814: iconst_1
    //   815: if_icmplt +25 -> 840
    //   818: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   821: aload 5
    //   823: invokevirtual 517	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:isAnyHostAppSupportingNotificationApi	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   826: ifne +14 -> 840
    //   829: new 369	java/lang/SecurityException
    //   832: dup
    //   833: ldc_w 521
    //   836: invokespecial 372	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
    //   839: athrow
    //   840: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   843: aload_1
    //   844: aload_2
    //   845: aload_3
    //   846: aload 4
    //   848: ldc 181
    //   850: aload 5
    //   852: ldc_w 406
    //   855: aload 6
    //   857: ldc_w 406
    //   860: invokevirtual 595	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:restrictedUpdate	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/String;)I
    //   863: istore 9
    //   865: goto -344 -> 521
    //   868: iload 8
    //   870: iconst_1
    //   871: if_icmpne -350 -> 521
    //   874: aload 5
    //   876: ldc_w 289
    //   879: aload_2
    //   880: aload_3
    //   881: aload 4
    //   883: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   886: istore 9
    //   888: goto -367 -> 521
    //   891: iload 8
    //   893: iconst_1
    //   894: if_icmpne +36 -> 930
    //   897: iconst_1
    //   898: anewarray 136	java/lang/String
    //   901: astore 6
    //   903: aload 6
    //   905: iconst_0
    //   906: aload_1
    //   907: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   910: aastore
    //   911: aload 5
    //   913: ldc_w 289
    //   916: aload_2
    //   917: ldc_w 404
    //   920: aload 6
    //   922: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   925: istore 9
    //   927: goto -406 -> 521
    //   930: iload 8
    //   932: iconst_2
    //   933: if_icmpne -412 -> 521
    //   936: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   939: aload_2
    //   940: invokestatic 279	com/sonyericsson/extras/liveware/aef/registration/RegistrationInternal$ApiRegistrationImpl:restrictedModifyColumns	()[Ljava/lang/String;
    //   943: invokevirtual 173	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:verifyContentValues	(Landroid/content/ContentValues;[Ljava/lang/String;)V
    //   946: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   949: aload_2
    //   950: invokevirtual 531	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:enumApiContentvalues	(Landroid/content/ContentValues;)Ljava/util/EnumSet;
    //   953: astore 7
    //   955: aload_2
    //   956: ldc_w 525
    //   959: invokevirtual 460	android/content/ContentValues:containsKey	(Ljava/lang/String;)Z
    //   962: ifeq +104 -> 1066
    //   965: aload_2
    //   966: ldc_w 525
    //   969: invokevirtual 302	android/content/ContentValues:getAsString	(Ljava/lang/String;)Ljava/lang/String;
    //   972: astore 8
    //   974: aload 8
    //   976: astore 8
    //   978: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   981: aload 7
    //   983: aload_1
    //   984: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   987: aload_0
    //   988: invokevirtual 314	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   991: aload_0
    //   992: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   995: invokevirtual 599	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:enumApiUse	(Ljava/util/EnumSet;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Landroid/content/Context;)V
    //   998: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   1001: aload 7
    //   1003: aload_2
    //   1004: invokevirtual 603	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:resetApiContentvalues	(Ljava/util/EnumSet;Landroid/content/ContentValues;)V
    //   1007: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   1010: astore 9
    //   1012: aload_0
    //   1013: invokevirtual 314	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1016: astore 11
    //   1018: aload_0
    //   1019: invokevirtual 122	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getContext	()Landroid/content/Context;
    //   1022: astore 10
    //   1024: aload 9
    //   1026: aload 8
    //   1028: aload 7
    //   1030: aload 11
    //   1032: aload 10
    //   1034: invokevirtual 535	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:verifyHostAppUse	(Ljava/lang/String;Ljava/util/EnumSet;Landroid/database/sqlite/SQLiteDatabase;Landroid/content/Context;)V
    //   1037: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   1040: aload_1
    //   1041: aload_2
    //   1042: aload_3
    //   1043: aload 4
    //   1045: ldc_w 289
    //   1048: aload 5
    //   1050: ldc_w 276
    //   1053: aload 6
    //   1055: ldc_w 406
    //   1058: invokevirtual 595	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:restrictedUpdate	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Integer;Ljava/lang/String;)I
    //   1061: istore 9
    //   1063: goto -542 -> 521
    //   1066: getstatic 19	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:mRegistrationPermission	Lcom/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission;
    //   1069: aload_1
    //   1070: aload_0
    //   1071: invokevirtual 314	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationProvider:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   1074: invokevirtual 607	com/sonyericsson/extras/liveware/aef/registration/provider/RegistrationPermission:lookUpHostAppPackage	(Landroid/net/Uri;Landroid/database/sqlite/SQLiteDatabase;)Ljava/lang/String;
    //   1077: astore 8
    //   1079: goto -101 -> 978
    //   1082: astore 6
    //   1084: new 369	java/lang/SecurityException
    //   1087: dup
    //   1088: aload 6
    //   1090: invokevirtual 540	android/database/SQLException:getMessage	()Ljava/lang/String;
    //   1093: invokespecial 372	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
    //   1096: athrow
    //   1097: iload 8
    //   1099: iconst_1
    //   1100: if_icmpne -579 -> 521
    //   1103: aload 5
    //   1105: ldc 42
    //   1107: aload_2
    //   1108: aload_3
    //   1109: aload 4
    //   1111: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1114: istore 9
    //   1116: goto -595 -> 521
    //   1119: iload 8
    //   1121: iconst_1
    //   1122: if_icmpne -601 -> 521
    //   1125: aload 5
    //   1127: ldc 46
    //   1129: aload_2
    //   1130: aload_3
    //   1131: aload 4
    //   1133: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1136: istore 9
    //   1138: goto -617 -> 521
    //   1141: iload 8
    //   1143: iconst_1
    //   1144: if_icmpne -623 -> 521
    //   1147: aload 5
    //   1149: ldc 50
    //   1151: aload_2
    //   1152: aload_3
    //   1153: aload 4
    //   1155: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1158: istore 9
    //   1160: goto -639 -> 521
    //   1163: iload 8
    //   1165: iconst_1
    //   1166: if_icmpne -645 -> 521
    //   1169: aload 5
    //   1171: ldc 54
    //   1173: aload_2
    //   1174: aload_3
    //   1175: aload 4
    //   1177: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1180: istore 9
    //   1182: goto -661 -> 521
    //   1185: iload 8
    //   1187: iconst_1
    //   1188: if_icmpne -667 -> 521
    //   1191: aload 5
    //   1193: ldc 58
    //   1195: aload_2
    //   1196: aload_3
    //   1197: aload 4
    //   1199: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1202: istore 9
    //   1204: goto -683 -> 521
    //   1207: iload 8
    //   1209: iconst_1
    //   1210: if_icmpne -689 -> 521
    //   1213: aload 5
    //   1215: ldc 62
    //   1217: aload_2
    //   1218: aload_3
    //   1219: aload 4
    //   1221: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1224: istore 9
    //   1226: goto -705 -> 521
    //   1229: iload 8
    //   1231: iconst_1
    //   1232: if_icmpne -711 -> 521
    //   1235: aload 5
    //   1237: ldc 66
    //   1239: aload_2
    //   1240: aload_3
    //   1241: aload 4
    //   1243: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1246: istore 9
    //   1248: goto -727 -> 521
    //   1251: iload 8
    //   1253: iconst_1
    //   1254: if_icmpne -733 -> 521
    //   1257: aload 5
    //   1259: ldc 70
    //   1261: aload_2
    //   1262: aload_3
    //   1263: aload 4
    //   1265: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1268: istore 9
    //   1270: goto -749 -> 521
    //   1273: iload 8
    //   1275: iconst_1
    //   1276: if_icmpne -755 -> 521
    //   1279: iconst_1
    //   1280: anewarray 136	java/lang/String
    //   1283: astore 6
    //   1285: aload 6
    //   1287: iconst_0
    //   1288: aload_1
    //   1289: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1292: aastore
    //   1293: aload 5
    //   1295: ldc 42
    //   1297: aload_2
    //   1298: ldc_w 404
    //   1301: aload 6
    //   1303: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1306: istore 9
    //   1308: goto -787 -> 521
    //   1311: iload 8
    //   1313: iconst_1
    //   1314: if_icmpne -793 -> 521
    //   1317: iconst_1
    //   1318: anewarray 136	java/lang/String
    //   1321: astore 6
    //   1323: aload 6
    //   1325: iconst_0
    //   1326: aload_1
    //   1327: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1330: aastore
    //   1331: aload 5
    //   1333: ldc 46
    //   1335: aload_2
    //   1336: ldc_w 404
    //   1339: aload 6
    //   1341: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1344: istore 9
    //   1346: goto -825 -> 521
    //   1349: iload 8
    //   1351: iconst_1
    //   1352: if_icmpne -831 -> 521
    //   1355: iconst_1
    //   1356: anewarray 136	java/lang/String
    //   1359: astore 6
    //   1361: aload 6
    //   1363: iconst_0
    //   1364: aload_1
    //   1365: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1368: aastore
    //   1369: aload 5
    //   1371: ldc 50
    //   1373: aload_2
    //   1374: ldc_w 404
    //   1377: aload 6
    //   1379: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1382: istore 9
    //   1384: goto -863 -> 521
    //   1387: iload 8
    //   1389: iconst_1
    //   1390: if_icmpne -869 -> 521
    //   1393: iconst_1
    //   1394: anewarray 136	java/lang/String
    //   1397: astore 6
    //   1399: aload 6
    //   1401: iconst_0
    //   1402: aload_1
    //   1403: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1406: aastore
    //   1407: aload 5
    //   1409: ldc 54
    //   1411: aload_2
    //   1412: ldc_w 404
    //   1415: aload 6
    //   1417: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1420: istore 9
    //   1422: goto -901 -> 521
    //   1425: iload 8
    //   1427: iconst_1
    //   1428: if_icmpne -907 -> 521
    //   1431: iconst_1
    //   1432: anewarray 136	java/lang/String
    //   1435: astore 6
    //   1437: aload 6
    //   1439: iconst_0
    //   1440: aload_1
    //   1441: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1444: aastore
    //   1445: aload 5
    //   1447: ldc 58
    //   1449: aload_2
    //   1450: ldc_w 404
    //   1453: aload 6
    //   1455: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1458: istore 9
    //   1460: goto -939 -> 521
    //   1463: iload 8
    //   1465: iconst_1
    //   1466: if_icmpne -945 -> 521
    //   1469: iconst_1
    //   1470: anewarray 136	java/lang/String
    //   1473: astore 6
    //   1475: aload 6
    //   1477: iconst_0
    //   1478: aload_1
    //   1479: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1482: aastore
    //   1483: aload 5
    //   1485: ldc 62
    //   1487: aload_2
    //   1488: ldc_w 404
    //   1491: aload 6
    //   1493: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1496: istore 9
    //   1498: goto -977 -> 521
    //   1501: iload 8
    //   1503: iconst_1
    //   1504: if_icmpne -983 -> 521
    //   1507: iconst_1
    //   1508: anewarray 136	java/lang/String
    //   1511: astore 6
    //   1513: aload 6
    //   1515: iconst_0
    //   1516: aload_1
    //   1517: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1520: aastore
    //   1521: aload 5
    //   1523: ldc 66
    //   1525: aload_2
    //   1526: ldc_w 404
    //   1529: aload 6
    //   1531: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1534: istore 9
    //   1536: goto -1015 -> 521
    //   1539: iload 8
    //   1541: iconst_1
    //   1542: if_icmpne -1021 -> 521
    //   1545: iconst_1
    //   1546: anewarray 136	java/lang/String
    //   1549: astore 6
    //   1551: aload 6
    //   1553: iconst_0
    //   1554: aload_1
    //   1555: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1558: aastore
    //   1559: aload 5
    //   1561: ldc 70
    //   1563: aload_2
    //   1564: ldc_w 404
    //   1567: aload 6
    //   1569: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1572: istore 9
    //   1574: goto -1053 -> 521
    //   1577: iload 8
    //   1579: iconst_1
    //   1580: if_icmpne -1059 -> 521
    //   1583: aload 5
    //   1585: ldc 78
    //   1587: aload_2
    //   1588: aload_3
    //   1589: aload 4
    //   1591: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1594: istore 9
    //   1596: goto -1075 -> 521
    //   1599: iload 8
    //   1601: iconst_1
    //   1602: if_icmpne -1081 -> 521
    //   1605: iconst_1
    //   1606: anewarray 136	java/lang/String
    //   1609: astore 6
    //   1611: aload 6
    //   1613: iconst_0
    //   1614: aload_1
    //   1615: invokevirtual 402	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   1618: aastore
    //   1619: aload 5
    //   1621: ldc 78
    //   1623: aload_2
    //   1624: ldc_w 404
    //   1627: aload 6
    //   1629: invokevirtual 591	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1632: istore 6
    //   1634: iload 6
    //   1636: istore 9
    //   1638: goto -1117 -> 521
    //   1641: astore 5
    //   1643: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   1646: ifeq -1169 -> 477
    //   1649: ldc_w 296
    //   1652: aload 5
    //   1654: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   1657: pop
    //   1658: goto -1181 -> 477
    //   1661: astore 5
    //   1663: invokestatic 145	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   1666: ifeq -979 -> 687
    //   1669: ldc_w 296
    //   1672: aload 5
    //   1674: invokestatic 294	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   1677: pop
    //   1678: goto -991 -> 687
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1681	0	this	RegistrationProvider
    //   0	1681	1	paramUri	Uri
    //   0	1681	2	paramContentValues	ContentValues
    //   0	1681	3	paramString	String
    //   0	1681	4	paramArrayOfString	String[]
    //   58	491	5	localObject	Object
    //   556	1064	5	localSQLiteException1	android.database.sqlite.SQLiteException
    //   1641	12	5	localSQLiteException2	android.database.sqlite.SQLiteException
    //   1661	12	5	localSQLiteException3	android.database.sqlite.SQLiteException
    //   121	1	6	arrayOfInteger1	Integer[]
    //   430	29	6	localSQLiteConstraintException	android.database.sqlite.SQLiteConstraintException
    //   638	35	6	localSQLException1	SQLException
    //   675	31	6	arrayOfInteger2	Integer[]
    //   750	304	6	arrayOfString1	String[]
    //   1082	7	6	localSQLException2	SQLException
    //   1283	345	6	arrayOfString2	String[]
    //   1632	3	6	i	int
    //   39	692	7	j	int
    //   953	76	7	localEnumSet	EnumSet
    //   76	858	8	k	int
    //   972	631	8	str1	String
    //   72	126	9	str2	String
    //   210	716	9	m	int
    //   1010	15	9	localRegistrationPermission	RegistrationPermission
    //   1061	576	9	n	int
    //   1022	11	10	localContext	Context
    //   1016	15	11	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   215	430	430	android/database/sqlite/SQLiteConstraintException
    //   480	543	430	android/database/sqlite/SQLiteConstraintException
    //   582	638	430	android/database/sqlite/SQLiteConstraintException
    //   690	974	430	android/database/sqlite/SQLiteConstraintException
    //   978	1037	430	android/database/sqlite/SQLiteConstraintException
    //   1037	1634	430	android/database/sqlite/SQLiteConstraintException
    //   548	553	556	android/database/sqlite/SQLiteException
    //   215	430	638	android/database/SQLException
    //   480	543	638	android/database/SQLException
    //   582	638	638	android/database/SQLException
    //   690	974	638	android/database/SQLException
    //   1037	1634	638	android/database/SQLException
    //   215	430	675	finally
    //   432	464	675	finally
    //   480	543	675	finally
    //   582	638	675	finally
    //   640	675	675	finally
    //   690	974	675	finally
    //   978	1037	675	finally
    //   1037	1634	675	finally
    //   978	1037	1082	android/database/SQLException
    //   472	477	1641	android/database/sqlite/SQLiteException
    //   682	687	1661	android/database/sqlite/SQLiteException
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.registration.provider.RegistrationProvider
 * JD-Core Version:    0.7.0.1
 */