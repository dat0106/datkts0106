package com.sonyericsson.extras.liveware.db;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.ArrayList;

public final class ExperienceProvider
  extends ContentProvider
{
  private static UriMatcher sUriMatcher = new UriMatcher(-1);
  private SQLiteOpenHelper mOpenHelper;
  
  static
  {
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "location", 10);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "time", 20);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "action", 30);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "experience", 40);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "action_set", 50);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "device", 60);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "feature", 70);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "location/#", 110);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "time/#", 120);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "action/#", 130);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "experience/#", 140);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "action_set/#", 150);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "device/#", 160);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.asf.experience", "feature/#", 170);
  }
  
  private String tableFromMatch(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    case 10: 
      str = "location";
      break;
    case 20: 
      str = "time";
      break;
    case 30: 
      str = "action";
      break;
    case 40: 
      str = "experience";
      break;
    case 50: 
      str = "action_set";
      break;
    case 60: 
      str = "device";
      break;
    case 70: 
      str = "feature";
      break;
    case 110: 
      str = "location";
      break;
    case 120: 
      str = "time";
      break;
    case 130: 
      str = "action";
      break;
    case 140: 
      str = "experience";
      break;
    case 150: 
      str = "action_set";
      break;
    case 160: 
      str = "device";
      break;
    case 170: 
      str = "feature";
    }
    return str;
  }
  
  public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
    throws OperationApplicationException
  {
    SQLiteDatabase localSQLiteDatabase = this.mOpenHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      ContentProviderResult[] arrayOfContentProviderResult = super.applyBatch(paramArrayList);
      localSQLiteDatabase.setTransactionSuccessful();
      return arrayOfContentProviderResult;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  /* Error */
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: getstatic 18	com/sonyericsson/extras/liveware/db/ExperienceProvider:sUriMatcher	Landroid/content/UriMatcher;
    //   3: aload_1
    //   4: invokevirtual 93	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   7: istore 6
    //   9: aload_0
    //   10: iload 6
    //   12: invokespecial 95	com/sonyericsson/extras/liveware/db/ExperienceProvider:tableFromMatch	(I)Ljava/lang/String;
    //   15: astore 5
    //   17: aload 5
    //   19: ifnull +243 -> 262
    //   22: aload_0
    //   23: invokevirtual 96	com/sonyericsson/extras/liveware/db/ExperienceProvider:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore 4
    //   28: aload 4
    //   30: invokevirtual 73	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   33: iload 6
    //   35: bipush 110
    //   37: if_icmpge +44 -> 81
    //   40: aload 4
    //   42: aload 5
    //   44: aload_2
    //   45: aload_3
    //   46: invokevirtual 99	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   49: istore 5
    //   51: aload 4
    //   53: invokevirtual 78	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   56: aload 4
    //   58: invokevirtual 81	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   61: iload 5
    //   63: ifle +15 -> 78
    //   66: aload_0
    //   67: invokevirtual 103	com/sonyericsson/extras/liveware/db/ExperienceProvider:getContext	()Landroid/content/Context;
    //   70: invokevirtual 109	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   73: aload_1
    //   74: aconst_null
    //   75: invokevirtual 115	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   78: iload 5
    //   80: ireturn
    //   81: iconst_1
    //   82: anewarray 117	java/lang/String
    //   85: astore 6
    //   87: aload 6
    //   89: iconst_0
    //   90: aload_1
    //   91: invokevirtual 123	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   94: aastore
    //   95: aload 4
    //   97: aload 5
    //   99: ldc 125
    //   101: aload 6
    //   103: invokevirtual 99	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   106: istore 5
    //   108: iload 5
    //   110: istore 5
    //   112: goto -61 -> 51
    //   115: astore 5
    //   117: invokestatic 131	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   120: ifeq +28 -> 148
    //   123: new 133	java/lang/StringBuilder
    //   126: dup
    //   127: ldc 135
    //   129: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: aload_1
    //   133: invokevirtual 141	android/net/Uri:toString	()Ljava/lang/String;
    //   136: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: aload 5
    //   144: invokestatic 149	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   147: pop
    //   148: iconst_0
    //   149: istore 5
    //   151: aload 4
    //   153: invokevirtual 81	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   156: goto -95 -> 61
    //   159: astore 4
    //   161: invokestatic 131	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   164: ifeq -103 -> 61
    //   167: ldc 151
    //   169: aload 4
    //   171: invokestatic 149	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   174: pop
    //   175: goto -114 -> 61
    //   178: astore 5
    //   180: invokestatic 131	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   183: ifeq +28 -> 211
    //   186: new 133	java/lang/StringBuilder
    //   189: dup
    //   190: ldc 153
    //   192: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: aload_1
    //   196: invokevirtual 141	android/net/Uri:toString	()Ljava/lang/String;
    //   199: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: aload 5
    //   207: invokestatic 149	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   210: pop
    //   211: aload 5
    //   213: athrow
    //   214: astore 5
    //   216: aload 4
    //   218: invokevirtual 81	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   221: aload 5
    //   223: athrow
    //   224: astore 4
    //   226: invokestatic 131	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   229: ifeq -8 -> 221
    //   232: ldc 151
    //   234: aload 4
    //   236: invokestatic 149	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   239: pop
    //   240: goto -19 -> 221
    //   243: astore 4
    //   245: invokestatic 131	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   248: ifeq -187 -> 61
    //   251: ldc 151
    //   253: aload 4
    //   255: invokestatic 149	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   258: pop
    //   259: goto -198 -> 61
    //   262: new 87	android/database/SQLException
    //   265: dup
    //   266: new 133	java/lang/StringBuilder
    //   269: dup
    //   270: ldc 155
    //   272: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload_1
    //   276: invokevirtual 141	android/net/Uri:toString	()Ljava/lang/String;
    //   279: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokespecial 156	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   288: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	ExperienceProvider
    //   0	289	1	paramUri	Uri
    //   0	289	2	paramString	String
    //   0	289	3	paramArrayOfString	String[]
    //   26	126	4	localSQLiteDatabase	SQLiteDatabase
    //   159	58	4	localSQLiteException1	android.database.sqlite.SQLiteException
    //   224	11	4	localSQLiteException2	android.database.sqlite.SQLiteException
    //   243	11	4	localSQLiteException3	android.database.sqlite.SQLiteException
    //   15	28	5	str	String
    //   49	62	5	i	int
    //   115	28	5	localSQLiteConstraintException	android.database.sqlite.SQLiteConstraintException
    //   149	1	5	j	int
    //   178	34	5	localSQLException	SQLException
    //   214	8	5	localObject	Object
    //   7	31	6	k	int
    //   85	17	6	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   40	56	115	android/database/sqlite/SQLiteConstraintException
    //   81	108	115	android/database/sqlite/SQLiteConstraintException
    //   151	156	159	android/database/sqlite/SQLiteException
    //   40	56	178	android/database/SQLException
    //   81	108	178	android/database/SQLException
    //   40	56	214	finally
    //   81	108	214	finally
    //   117	148	214	finally
    //   180	214	214	finally
    //   216	221	224	android/database/sqlite/SQLiteException
    //   56	61	243	android/database/sqlite/SQLiteException
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
      str = "vnd.android.cursor.dir/asf-location";
      break;
    case 20: 
      str = "vnd.android.cursor.dir/asf-time";
      break;
    case 30: 
      str = "vnd.android.cursor.dir/asf-action";
      break;
    case 40: 
      str = "vnd.android.cursor.dir/asf-experience";
      break;
    case 50: 
      str = "vnd.android.cursor.dir/asf-action_set";
      break;
    case 60: 
      str = "vnd.android.cursor.dir/asf-device";
      break;
    case 70: 
      str = "vnd.android.cursor.dir/asf-feature";
      break;
    case 110: 
      str = "vnd.android.cursor.item/asf-location";
      break;
    case 120: 
      str = "vnd.android.cursor.item/asf-time";
      break;
    case 130: 
      str = "vnd.android.cursor.item/asf-action";
      break;
    case 140: 
      str = "vnd.android.cursor.item/asf-experience";
      break;
    case 150: 
      str = "vnd.android.cursor.item/asf-action_set";
      break;
    case 160: 
      str = "vnd.android.cursor.item/asf-device";
      break;
    case 170: 
      str = "vnd.android.cursor.item/asf-feature";
    }
    return str;
  }
  
  SQLiteDatabase getWritableDatabase()
  {
    return this.mOpenHelper.getWritableDatabase();
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    int i = sUriMatcher.match(paramUri);
    Object localObject1 = tableFromMatch(i);
    SQLiteDatabase localSQLiteDatabase;
    if ((localObject1 != null) && (i < 110))
    {
      localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase.inTransaction()) {}
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          localSQLiteDatabase.beginTransaction();
        }
        try
        {
          long l = localSQLiteDatabase.insert((String)localObject1, "", paramContentValues);
          if (Dbg.v()) {
            Dbg.v("Insert in table " + (String)localObject1 + " with id " + l + ".");
          }
          if (i != 0) {
            localSQLiteDatabase.setTransactionSuccessful();
          }
          if (i != 0) {
            localSQLiteDatabase.endTransaction();
          }
          localObject1 = null;
          if (l != -1L)
          {
            localObject1 = Uri.withAppendedPath(paramUri, String.valueOf(l));
            if (localObject1 != null) {
              getContext().getContentResolver().notifyChange((Uri)localObject1, null);
            }
          }
          return localObject1;
        }
        catch (SQLException localSQLException)
        {
          if (!Dbg.e()) {
            break;
          }
          Dbg.e("Error when inserting into " + (String)localObject1, localSQLException);
          throw localSQLException;
        }
        finally
        {
          if (i == 0) {
            break label215;
          }
          localSQLiteDatabase.endTransaction();
        }
      }
    }
    label215:
    throw new SQLException("Invalid uri for this content provider. " + paramUri.toString());
  }
  
  public boolean onCreate()
  {
    this.mOpenHelper = new ExperienceDatabaseHelper(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int i = sUriMatcher.match(paramUri);
    Object localObject = tableFromMatch(i);
    if (localObject == null) {
      throw new SQLException("Invalid uri for this content provider. " + paramUri.toString());
    }
    if (i >= 110)
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = paramUri.getLastPathSegment();
      localObject = localSQLiteDatabase.query((String)localObject, paramArrayOfString1, "_id=?", arrayOfString, null, null, paramString2);
    }
    else
    {
      localObject = getWritableDatabase().query((String)localObject, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
    }
    return localObject;
  }
  
  /* Error */
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: getstatic 18	com/sonyericsson/extras/liveware/db/ExperienceProvider:sUriMatcher	Landroid/content/UriMatcher;
    //   3: aload_1
    //   4: invokevirtual 93	android/content/UriMatcher:match	(Landroid/net/Uri;)I
    //   7: istore 7
    //   9: aload_0
    //   10: iload 7
    //   12: invokespecial 95	com/sonyericsson/extras/liveware/db/ExperienceProvider:tableFromMatch	(I)Ljava/lang/String;
    //   15: astore 6
    //   17: aload 6
    //   19: ifnull +246 -> 265
    //   22: aload_0
    //   23: invokevirtual 96	com/sonyericsson/extras/liveware/db/ExperienceProvider:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore 5
    //   28: aload 5
    //   30: invokevirtual 73	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   33: iload 7
    //   35: bipush 110
    //   37: if_icmpge +46 -> 83
    //   40: aload 5
    //   42: aload 6
    //   44: aload_2
    //   45: aload_3
    //   46: aload 4
    //   48: invokevirtual 239	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   51: istore 6
    //   53: aload 5
    //   55: invokevirtual 78	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   58: aload 5
    //   60: invokevirtual 81	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   63: iload 6
    //   65: ifle +15 -> 80
    //   68: aload_0
    //   69: invokevirtual 103	com/sonyericsson/extras/liveware/db/ExperienceProvider:getContext	()Landroid/content/Context;
    //   72: invokevirtual 109	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   75: aload_1
    //   76: aconst_null
    //   77: invokevirtual 115	android/content/ContentResolver:notifyChange	(Landroid/net/Uri;Landroid/database/ContentObserver;)V
    //   80: iload 6
    //   82: ireturn
    //   83: iconst_1
    //   84: anewarray 117	java/lang/String
    //   87: astore 7
    //   89: aload 7
    //   91: iconst_0
    //   92: aload_1
    //   93: invokevirtual 123	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   96: aastore
    //   97: aload 5
    //   99: aload 6
    //   101: aload_2
    //   102: ldc 125
    //   104: aload 7
    //   106: invokevirtual 239	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   109: istore 6
    //   111: iload 6
    //   113: istore 6
    //   115: goto -62 -> 53
    //   118: astore 6
    //   120: invokestatic 131	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   123: ifeq +28 -> 151
    //   126: new 133	java/lang/StringBuilder
    //   129: dup
    //   130: ldc 135
    //   132: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload_1
    //   136: invokevirtual 141	android/net/Uri:toString	()Ljava/lang/String;
    //   139: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: aload 6
    //   147: invokestatic 149	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   150: pop
    //   151: iconst_0
    //   152: istore 6
    //   154: aload 5
    //   156: invokevirtual 81	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   159: goto -96 -> 63
    //   162: astore 5
    //   164: invokestatic 131	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   167: ifeq -104 -> 63
    //   170: ldc 151
    //   172: aload 5
    //   174: invokestatic 149	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   177: pop
    //   178: goto -115 -> 63
    //   181: astore 6
    //   183: invokestatic 131	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   186: ifeq +28 -> 214
    //   189: new 133	java/lang/StringBuilder
    //   192: dup
    //   193: ldc 135
    //   195: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload_1
    //   199: invokevirtual 141	android/net/Uri:toString	()Ljava/lang/String;
    //   202: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: aload 6
    //   210: invokestatic 149	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   213: pop
    //   214: aload 6
    //   216: athrow
    //   217: astore 6
    //   219: aload 5
    //   221: invokevirtual 81	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   224: aload 6
    //   226: athrow
    //   227: astore 5
    //   229: invokestatic 131	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   232: ifeq -8 -> 224
    //   235: ldc 151
    //   237: aload 5
    //   239: invokestatic 149	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   242: pop
    //   243: goto -19 -> 224
    //   246: astore 5
    //   248: invokestatic 131	com/sonyericsson/extras/liveware/utils/Dbg:e	()Z
    //   251: ifeq -188 -> 63
    //   254: ldc 151
    //   256: aload 5
    //   258: invokestatic 149	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   261: pop
    //   262: goto -199 -> 63
    //   265: new 87	android/database/SQLException
    //   268: dup
    //   269: new 133	java/lang/StringBuilder
    //   272: dup
    //   273: ldc 155
    //   275: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   278: aload_1
    //   279: invokevirtual 141	android/net/Uri:toString	()Ljava/lang/String;
    //   282: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokespecial 156	android/database/SQLException:<init>	(Ljava/lang/String;)V
    //   291: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	ExperienceProvider
    //   0	292	1	paramUri	Uri
    //   0	292	2	paramContentValues	ContentValues
    //   0	292	3	paramString	String
    //   0	292	4	paramArrayOfString	String[]
    //   26	129	5	localSQLiteDatabase	SQLiteDatabase
    //   162	58	5	localSQLiteException1	android.database.sqlite.SQLiteException
    //   227	11	5	localSQLiteException2	android.database.sqlite.SQLiteException
    //   246	11	5	localSQLiteException3	android.database.sqlite.SQLiteException
    //   15	28	6	str	String
    //   51	63	6	i	int
    //   118	28	6	localSQLiteConstraintException	android.database.sqlite.SQLiteConstraintException
    //   152	1	6	j	int
    //   181	34	6	localSQLException	SQLException
    //   217	8	6	localObject	Object
    //   7	31	7	k	int
    //   87	18	7	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   40	58	118	android/database/sqlite/SQLiteConstraintException
    //   83	111	118	android/database/sqlite/SQLiteConstraintException
    //   154	159	162	android/database/sqlite/SQLiteException
    //   40	58	181	android/database/SQLException
    //   83	111	181	android/database/SQLException
    //   40	58	217	finally
    //   83	111	217	finally
    //   120	151	217	finally
    //   183	217	217	finally
    //   219	224	227	android/database/sqlite/SQLiteException
    //   58	63	246	android/database/sqlite/SQLiteException
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.db.ExperienceProvider
 * JD-Core Version:    0.7.0.1
 */