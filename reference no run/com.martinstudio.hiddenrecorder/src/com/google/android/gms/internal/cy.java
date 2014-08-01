package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class cy
{
  private static final Object lq = new Object();
  private static final String pp;
  private static cy pr;
  private final a pq;
  
  static
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = "InAppPurchase";
    arrayOfObject[1] = "purchase_id";
    arrayOfObject[2] = "product_id";
    arrayOfObject[3] = "developer_payload";
    arrayOfObject[4] = "record_time";
    pp = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", arrayOfObject);
  }
  
  private cy(Context paramContext)
  {
    this.pq = new a(paramContext, "google_inapp_purchase.db");
  }
  
  public static cy h(Context paramContext)
  {
    synchronized (lq)
    {
      if (pr == null) {
        pr = new cy(paramContext);
      }
      cy localcy = pr;
      return localcy;
    }
  }
  
  public cw a(Cursor paramCursor)
  {
    cw localcw;
    if (paramCursor != null) {
      localcw = new cw(paramCursor.getLong(0), paramCursor.getString(1), paramCursor.getString(2));
    } else {
      localcw = null;
    }
    return localcw;
  }
  
  /* Error */
  public void a(cw paramcw)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: getstatic 42	com/google/android/gms/internal/cy:lq	Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: monitorenter
    //   11: aload_0
    //   12: invokevirtual 79	com/google/android/gms/internal/cy:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +13 -> 32
    //   22: aload_2
    //   23: monitorexit
    //   24: goto -20 -> 4
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    //   32: iconst_2
    //   33: anewarray 4	java/lang/Object
    //   36: astore_3
    //   37: aload_3
    //   38: iconst_0
    //   39: ldc 21
    //   41: aastore
    //   42: aload_3
    //   43: iconst_1
    //   44: aload_1
    //   45: getfield 83	com/google/android/gms/internal/cw:pj	J
    //   48: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   51: aastore
    //   52: aload 4
    //   54: ldc 19
    //   56: ldc 91
    //   58: aload_3
    //   59: invokestatic 35	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   62: aconst_null
    //   63: invokevirtual 97	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   66: pop
    //   67: aload_2
    //   68: monitorexit
    //   69: goto -65 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	cy
    //   0	72	1	paramcw	cw
    //   8	60	2	localObject1	Object
    //   27	4	3	localObject2	Object
    //   36	23	3	arrayOfObject	Object[]
    //   15	38	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   11	30	27	finally
    //   32	69	27	finally
  }
  
  /* Error */
  public void b(cw paramcw)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: getstatic 42	com/google/android/gms/internal/cy:lq	Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: monitorenter
    //   11: aload_0
    //   12: invokevirtual 79	com/google/android/gms/internal/cy:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +13 -> 32
    //   22: aload_2
    //   23: monitorexit
    //   24: goto -20 -> 4
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    //   32: new 100	android/content/ContentValues
    //   35: dup
    //   36: invokespecial 101	android/content/ContentValues:<init>	()V
    //   39: astore_3
    //   40: aload_3
    //   41: ldc 23
    //   43: aload_1
    //   44: getfield 104	com/google/android/gms/internal/cw:pl	Ljava/lang/String;
    //   47: invokevirtual 108	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_3
    //   51: ldc 25
    //   53: aload_1
    //   54: getfield 111	com/google/android/gms/internal/cw:pk	Ljava/lang/String;
    //   57: invokevirtual 108	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_3
    //   61: ldc 27
    //   63: invokestatic 117	android/os/SystemClock:elapsedRealtime	()J
    //   66: invokestatic 89	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   69: invokevirtual 120	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   72: aload_1
    //   73: aload 4
    //   75: ldc 19
    //   77: aconst_null
    //   78: aload_3
    //   79: invokevirtual 124	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   82: putfield 83	com/google/android/gms/internal/cw:pj	J
    //   85: aload_0
    //   86: invokevirtual 128	com/google/android/gms/internal/cy:getRecordCount	()I
    //   89: i2l
    //   90: ldc2_w 129
    //   93: lcmp
    //   94: ifle +7 -> 101
    //   97: aload_0
    //   98: invokevirtual 133	com/google/android/gms/internal/cy:bf	()V
    //   101: aload_2
    //   102: monitorexit
    //   103: goto -99 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	cy
    //   0	106	1	paramcw	cw
    //   8	94	2	localObject1	Object
    //   27	4	3	localObject2	Object
    //   39	40	3	localContentValues	android.content.ContentValues
    //   15	59	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   11	30	27	finally
    //   32	103	27	finally
  }
  
  /* Error */
  public void bf()
  {
    // Byte code:
    //   0: getstatic 42	com/google/android/gms/internal/cy:lq	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: invokevirtual 79	com/google/android/gms/internal/cy:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: aload_1
    //   16: monitorexit
    //   17: return
    //   18: aload_2
    //   19: ldc 19
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: ldc 137
    //   28: ldc 139
    //   30: invokevirtual 143	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_2
    //   34: aload_2
    //   35: astore_2
    //   36: aload_2
    //   37: ifnull +21 -> 58
    //   40: aload_2
    //   41: invokeinterface 147 1 0
    //   46: ifeq +12 -> 58
    //   49: aload_0
    //   50: aload_0
    //   51: aload_2
    //   52: invokevirtual 149	com/google/android/gms/internal/cy:a	(Landroid/database/Cursor;)Lcom/google/android/gms/internal/cw;
    //   55: invokevirtual 151	com/google/android/gms/internal/cy:a	(Lcom/google/android/gms/internal/cw;)V
    //   58: aload_2
    //   59: ifnull +9 -> 68
    //   62: aload_2
    //   63: invokeinterface 154 1 0
    //   68: aload_1
    //   69: monitorexit
    //   70: goto -53 -> 17
    //   73: astore_2
    //   74: aload_1
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    //   78: astore_3
    //   79: aconst_null
    //   80: astore_2
    //   81: new 156	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   88: ldc 159
    //   90: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: invokevirtual 166	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 175	com/google/android/gms/internal/ev:D	(Ljava/lang/String;)V
    //   106: aload_2
    //   107: ifnull -39 -> 68
    //   110: aload_2
    //   111: invokeinterface 154 1 0
    //   116: goto -48 -> 68
    //   119: aload_2
    //   120: ifnull +9 -> 129
    //   123: aload_2
    //   124: invokeinterface 154 1 0
    //   129: aload_3
    //   130: athrow
    //   131: astore_3
    //   132: goto -13 -> 119
    //   135: astore_3
    //   136: goto -55 -> 81
    //   139: astore_3
    //   140: aconst_null
    //   141: astore_2
    //   142: goto -23 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	cy
    //   3	72	1	localObject1	Object
    //   10	53	2	localObject2	Object
    //   73	4	2	localObject3	Object
    //   80	62	2	localObject4	Object
    //   78	52	3	localSQLiteException1	SQLiteException
    //   131	1	3	localObject5	Object
    //   135	1	3	localSQLiteException2	SQLiteException
    //   139	1	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   6	17	73	finally
    //   62	76	73	finally
    //   110	131	73	finally
    //   18	34	78	android/database/sqlite/SQLiteException
    //   40	58	131	finally
    //   81	106	131	finally
    //   40	58	135	android/database/sqlite/SQLiteException
    //   18	34	139	finally
  }
  
  /* Error */
  public java.util.List<cw> d(long paramLong)
  {
    // Byte code:
    //   0: getstatic 42	com/google/android/gms/internal/cy:lq	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: new 179	java/util/LinkedList
    //   9: dup
    //   10: invokespecial 180	java/util/LinkedList:<init>	()V
    //   13: astore 4
    //   15: lload_1
    //   16: ldc2_w 181
    //   19: lcmp
    //   20: ifgt +12 -> 32
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: astore 4
    //   29: goto +189 -> 218
    //   32: aload_0
    //   33: invokevirtual 79	com/google/android/gms/internal/cy:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore 5
    //   38: aload 5
    //   40: ifnonnull +12 -> 52
    //   43: aload_3
    //   44: monitorexit
    //   45: aload 4
    //   47: astore 4
    //   49: goto +169 -> 218
    //   52: aload 5
    //   54: ldc 19
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: ldc 137
    //   63: lload_1
    //   64: invokestatic 185	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   67: invokevirtual 143	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore 5
    //   72: aload 5
    //   74: astore 5
    //   76: aload 5
    //   78: invokeinterface 147 1 0
    //   83: ifeq +31 -> 114
    //   86: aload 4
    //   88: aload_0
    //   89: aload 5
    //   91: invokevirtual 149	com/google/android/gms/internal/cy:a	(Landroid/database/Cursor;)Lcom/google/android/gms/internal/cw;
    //   94: invokeinterface 191 2 0
    //   99: pop
    //   100: aload 5
    //   102: invokeinterface 194 1 0
    //   107: istore 6
    //   109: iload 6
    //   111: ifne -25 -> 86
    //   114: aload 5
    //   116: ifnull +10 -> 126
    //   119: aload 5
    //   121: invokeinterface 154 1 0
    //   126: aload_3
    //   127: monitorexit
    //   128: aload 4
    //   130: astore 4
    //   132: goto +86 -> 218
    //   135: astore 6
    //   137: aconst_null
    //   138: astore 5
    //   140: new 156	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   147: ldc 196
    //   149: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 6
    //   154: invokevirtual 166	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 175	com/google/android/gms/internal/ev:D	(Ljava/lang/String;)V
    //   166: aload 5
    //   168: ifnull -42 -> 126
    //   171: aload 5
    //   173: invokeinterface 154 1 0
    //   178: goto -52 -> 126
    //   181: astore 4
    //   183: aload_3
    //   184: monitorexit
    //   185: aload 4
    //   187: athrow
    //   188: astore 4
    //   190: aconst_null
    //   191: astore 5
    //   193: aload 5
    //   195: ifnull +10 -> 205
    //   198: aload 5
    //   200: invokeinterface 154 1 0
    //   205: aload 4
    //   207: athrow
    //   208: astore 4
    //   210: goto -17 -> 193
    //   213: astore 6
    //   215: goto -75 -> 140
    //   218: aload 4
    //   220: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	cy
    //   0	221	1	paramLong	long
    //   3	181	3	localObject1	Object
    //   13	118	4	localLinkedList	java.util.LinkedList
    //   181	5	4	localObject2	Object
    //   188	18	4	localObject3	Object
    //   208	11	4	localList	java.util.List<cw>
    //   36	163	5	localObject4	Object
    //   107	3	6	bool	boolean
    //   135	18	6	localSQLiteException1	SQLiteException
    //   213	1	6	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   52	72	135	android/database/sqlite/SQLiteException
    //   6	45	181	finally
    //   119	128	181	finally
    //   171	185	181	finally
    //   198	208	181	finally
    //   52	72	188	finally
    //   76	109	208	finally
    //   140	166	208	finally
    //   76	109	213	android/database/sqlite/SQLiteException
  }
  
  public int getRecordCount()
  {
    Cursor localCursor = null;
    int i = 0;
    for (;;)
    {
      SQLiteDatabase localSQLiteDatabase;
      synchronized (lq)
      {
        localSQLiteDatabase = getWritableDatabase();
        if (localSQLiteDatabase == null) {
          return i;
        }
      }
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("select count(*) from InAppPurchase", null);
        if (localCursor.moveToFirst())
        {
          i = localCursor.getInt(0);
          i = i;
          if (localCursor != null) {
            localCursor.close();
          }
          continue;
          localObject2 = finally;
          throw localObject2;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          ev.D("Error getting record count" + localSQLiteException.getMessage());
          if (localObject2 != null) {
            localObject2.close();
          }
        }
      }
      finally
      {
        if (localObject2 == null) {
          break;
        }
        localObject2.close();
      }
    }
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      localSQLiteDatabase = this.pq.getWritableDatabase();
      localSQLiteDatabase = localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        ev.D("Error opening writable conversion tracking database");
        SQLiteDatabase localSQLiteDatabase = null;
      }
    }
    return localSQLiteDatabase;
  }
  
  public class a
    extends SQLiteOpenHelper
  {
    public a(Context paramContext, String paramString)
    {
      super(paramString, null, 4);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL(cy.bg());
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      ev.B("Database updated from version " + paramInt1 + " to version " + paramInt2);
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cy
 * JD-Core Version:    0.7.0.1
 */