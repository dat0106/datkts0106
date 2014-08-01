package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.ik;
import com.google.android.gms.internal.im;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class v
  implements DataLayer.c
{
  private static final String afg;
  private ik aec;
  private final Executor afh;
  private a afi;
  private int afj;
  private final Context mContext;
  
  static
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = "datalayer";
    arrayOfObject[1] = "ID";
    arrayOfObject[2] = "key";
    arrayOfObject[3] = "value";
    arrayOfObject[4] = "expires";
    afg = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", arrayOfObject);
  }
  
  public v(Context paramContext)
  {
    this(paramContext, im.fW(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
  }
  
  v(Context paramContext, ik paramik, String paramString, int paramInt, Executor paramExecutor)
  {
    this.mContext = paramContext;
    this.aec = paramik;
    this.afj = paramInt;
    this.afh = paramExecutor;
    this.afi = new a(this.mContext, paramString);
  }
  
  private SQLiteDatabase S(String paramString)
  {
    try
    {
      localSQLiteDatabase = this.afi.getWritableDatabase();
      localSQLiteDatabase = localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        bh.D(paramString);
        SQLiteDatabase localSQLiteDatabase = null;
      }
    }
    return localSQLiteDatabase;
  }
  
  /* Error */
  /**
   * @deprecated
   */
  private void b(List<b> paramList, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	com/google/android/gms/tagmanager/v:aec	Lcom/google/android/gms/internal/ik;
    //   6: invokeinterface 120 1 0
    //   11: lstore 4
    //   13: aload_0
    //   14: lload 4
    //   16: invokespecial 124	com/google/android/gms/tagmanager/v:x	(J)V
    //   19: aload_0
    //   20: aload_1
    //   21: invokeinterface 130 1 0
    //   26: invokespecial 134	com/google/android/gms/tagmanager/v:do	(I)V
    //   29: aload_0
    //   30: aload_1
    //   31: lload 4
    //   33: lload_2
    //   34: ladd
    //   35: invokespecial 137	com/google/android/gms/tagmanager/v:c	(Ljava/util/List;J)V
    //   38: aload_0
    //   39: invokespecial 140	com/google/android/gms/tagmanager/v:lA	()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore 4
    //   47: aload_0
    //   48: invokespecial 140	com/google/android/gms/tagmanager/v:lA	()V
    //   51: aload 4
    //   53: athrow
    //   54: astore 4
    //   56: aload_0
    //   57: monitorexit
    //   58: aload 4
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	v
    //   0	61	1	paramList	List<b>
    //   0	61	2	paramLong	long
    //   11	21	4	l	long
    //   45	7	4	localObject1	Object
    //   54	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	45	finally
    //   38	42	54	finally
    //   47	54	54	finally
  }
  
  private void bQ(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = S("Error opening database for clearKeysWithPrefix.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      try
      {
        String[] arrayOfString = new String[2];
        arrayOfString[0] = paramString;
        arrayOfString[1] = (paramString + ".%");
        int i = localSQLiteDatabase.delete("datalayer", "key = ? OR key LIKE ?", arrayOfString);
        bh.C("Cleared " + i + " items");
        lA();
      }
      catch (SQLiteException localSQLiteException)
      {
        bh.D("Error deleting entries with key prefix: " + paramString + " (" + localSQLiteException + ").");
        lA();
      }
      finally
      {
        lA();
      }
    }
  }
  
  private void c(List<b> paramList, long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = S("Error opening database for writeEntryToDatabase.");
    Iterator localIterator;
    if (localSQLiteDatabase != null) {
      localIterator = paramList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      b localb = (b)localIterator.next();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("expires", Long.valueOf(paramLong));
      localContentValues.put("key", localb.JI);
      localContentValues.put("value", localb.afp);
      localSQLiteDatabase.insert("datalayer", null, localContentValues);
    }
  }
  
  private void jdMethod_do(int paramInt)
  {
    int i = paramInt + (lz() - this.afj);
    if (i > 0)
    {
      List localList = dp(i);
      bh.B("DataLayer store full, deleting " + localList.size() + " entries to make room.");
      g((String[])localList.toArray(new String[0]));
    }
  }
  
  /* Error */
  private List<String> dp(int paramInt)
  {
    // Byte code:
    //   0: new 256	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 257	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: iload_1
    //   9: ifgt +13 -> 22
    //   12: ldc_w 259
    //   15: invokestatic 100	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   18: aload_2
    //   19: astore_2
    //   20: aload_2
    //   21: areturn
    //   22: aload_0
    //   23: ldc_w 261
    //   26: invokespecial 144	com/google/android/gms/tagmanager/v:S	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore 5
    //   31: aload 5
    //   33: ifnonnull +8 -> 41
    //   36: aload_2
    //   37: astore_2
    //   38: goto -18 -> 20
    //   41: iconst_1
    //   42: anewarray 46	java/lang/String
    //   45: astore_3
    //   46: aload_3
    //   47: iconst_0
    //   48: ldc 36
    //   50: aastore
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: astore 4
    //   57: aload 4
    //   59: iconst_0
    //   60: ldc 36
    //   62: aastore
    //   63: aload 5
    //   65: ldc 34
    //   67: aload_3
    //   68: aconst_null
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: ldc_w 263
    //   75: aload 4
    //   77: invokestatic 50	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   80: iload_1
    //   81: invokestatic 268	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   84: invokevirtual 272	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore_3
    //   88: aload_3
    //   89: astore_3
    //   90: aload_3
    //   91: invokeinterface 277 1 0
    //   96: ifeq +33 -> 129
    //   99: aload_2
    //   100: aload_3
    //   101: iconst_0
    //   102: invokeinterface 281 2 0
    //   107: invokestatic 284	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   110: invokeinterface 288 2 0
    //   115: pop
    //   116: aload_3
    //   117: invokeinterface 291 1 0
    //   122: istore 4
    //   124: iload 4
    //   126: ifne -27 -> 99
    //   129: aload_3
    //   130: ifnull +9 -> 139
    //   133: aload_3
    //   134: invokeinterface 294 1 0
    //   139: aload_2
    //   140: astore_2
    //   141: goto -121 -> 20
    //   144: astore 4
    //   146: aconst_null
    //   147: astore_3
    //   148: new 146	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 296
    //   158: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 4
    //   163: invokevirtual 299	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   166: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 100	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   175: aload_3
    //   176: ifnull -37 -> 139
    //   179: aload_3
    //   180: invokeinterface 294 1 0
    //   185: goto -46 -> 139
    //   188: astore_2
    //   189: aconst_null
    //   190: astore_3
    //   191: aload_3
    //   192: ifnull +9 -> 201
    //   195: aload_3
    //   196: invokeinterface 294 1 0
    //   201: aload_2
    //   202: athrow
    //   203: astore_2
    //   204: goto -13 -> 191
    //   207: astore 4
    //   209: goto -61 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	v
    //   0	212	1	paramInt	int
    //   7	134	2	localArrayList	ArrayList
    //   188	14	2	localObject1	Object
    //   203	1	2	localObject2	Object
    //   45	151	3	localObject3	Object
    //   55	21	4	arrayOfObject	Object[]
    //   122	3	4	bool	boolean
    //   144	18	4	localSQLiteException1	SQLiteException
    //   207	1	4	localSQLiteException2	SQLiteException
    //   29	35	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   41	88	144	android/database/sqlite/SQLiteException
    //   41	88	188	finally
    //   90	124	203	finally
    //   148	175	203	finally
    //   90	124	207	android/database/sqlite/SQLiteException
  }
  
  private List<DataLayer.a> e(List<b> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      b localb = (b)localIterator.next();
      localArrayList.add(new DataLayer.a(localb.JI, j(localb.afp)));
    }
  }
  
  private List<b> f(List<DataLayer.a> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      DataLayer.a locala = (DataLayer.a)localIterator.next();
      localArrayList.add(new b(locala.JI, j(locala.afe)));
    }
  }
  
  private void g(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    for (;;)
    {
      return;
      SQLiteDatabase localSQLiteDatabase = S("Error opening database for deleteEntries.");
      if (localSQLiteDatabase != null)
      {
        Object localObject = new Object[2];
        localObject[0] = "ID";
        localObject[1] = TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?"));
        localObject = String.format("%s in (%s)", (Object[])localObject);
        try
        {
          localSQLiteDatabase.delete("datalayer", (String)localObject, paramArrayOfString);
        }
        catch (SQLiteException localSQLiteException)
        {
          bh.D("Error deleting entries " + Arrays.toString(paramArrayOfString));
        }
      }
    }
  }
  
  /* Error */
  private Object j(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 354	java/io/ByteArrayInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 357	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore_3
    //   12: new 359	java/io/ObjectInputStream
    //   15: dup
    //   16: aload_3
    //   17: invokespecial 362	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 365	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   25: astore 4
    //   27: aload 4
    //   29: astore 4
    //   31: aload_2
    //   32: ifnull +7 -> 39
    //   35: aload_2
    //   36: invokevirtual 366	java/io/ObjectInputStream:close	()V
    //   39: aload_3
    //   40: invokevirtual 367	java/io/ByteArrayInputStream:close	()V
    //   43: aload 4
    //   45: areturn
    //   46: pop
    //   47: aconst_null
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +7 -> 57
    //   53: aload_2
    //   54: invokevirtual 366	java/io/ObjectInputStream:close	()V
    //   57: aload_3
    //   58: invokevirtual 367	java/io/ByteArrayInputStream:close	()V
    //   61: goto -18 -> 43
    //   64: pop
    //   65: goto -22 -> 43
    //   68: pop
    //   69: aconst_null
    //   70: astore_2
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 366	java/io/ObjectInputStream:close	()V
    //   79: aload_3
    //   80: invokevirtual 367	java/io/ByteArrayInputStream:close	()V
    //   83: goto -40 -> 43
    //   86: pop
    //   87: goto -44 -> 43
    //   90: astore 4
    //   92: aconst_null
    //   93: astore_2
    //   94: aload 4
    //   96: astore 4
    //   98: aload_2
    //   99: ifnull +7 -> 106
    //   102: aload_2
    //   103: invokevirtual 366	java/io/ObjectInputStream:close	()V
    //   106: aload_3
    //   107: invokevirtual 367	java/io/ByteArrayInputStream:close	()V
    //   110: aload 4
    //   112: athrow
    //   113: pop
    //   114: goto -4 -> 110
    //   117: astore 4
    //   119: goto -21 -> 98
    //   122: pop
    //   123: goto -52 -> 71
    //   126: pop
    //   127: goto -78 -> 49
    //   130: pop
    //   131: goto -88 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	v
    //   0	134	1	paramArrayOfByte	byte[]
    //   20	83	2	localObjectInputStream	java.io.ObjectInputStream
    //   11	96	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   1	43	4	localObject1	Object
    //   90	5	4	localObject2	Object
    //   96	15	4	localObject3	Object
    //   117	1	4	localObject4	Object
    //   46	1	8	localIOException1	java.io.IOException
    //   64	1	9	localIOException2	java.io.IOException
    //   68	1	10	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   86	1	11	localIOException3	java.io.IOException
    //   113	1	12	localIOException4	java.io.IOException
    //   122	1	13	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   126	1	14	localIOException5	java.io.IOException
    //   130	1	15	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   12	21	46	java/io/IOException
    //   53	61	64	java/io/IOException
    //   12	21	68	java/lang/ClassNotFoundException
    //   75	83	86	java/io/IOException
    //   12	21	90	finally
    //   102	110	113	java/io/IOException
    //   21	27	117	finally
    //   21	27	122	java/lang/ClassNotFoundException
    //   21	27	126	java/io/IOException
    //   35	43	130	java/io/IOException
  }
  
  /* Error */
  private byte[] j(Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 369	java/io/ByteArrayOutputStream
    //   6: dup
    //   7: invokespecial 370	java/io/ByteArrayOutputStream:<init>	()V
    //   10: astore_2
    //   11: new 372	java/io/ObjectOutputStream
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 375	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   19: astore_3
    //   20: aload_3
    //   21: aload_1
    //   22: invokevirtual 379	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   25: aload_2
    //   26: invokevirtual 383	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   29: astore 4
    //   31: aload 4
    //   33: astore 4
    //   35: aload_3
    //   36: ifnull +7 -> 43
    //   39: aload_3
    //   40: invokevirtual 384	java/io/ObjectOutputStream:close	()V
    //   43: aload_2
    //   44: invokevirtual 385	java/io/ByteArrayOutputStream:close	()V
    //   47: aload 4
    //   49: areturn
    //   50: pop
    //   51: aconst_null
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull +7 -> 61
    //   57: aload_3
    //   58: invokevirtual 384	java/io/ObjectOutputStream:close	()V
    //   61: aload_2
    //   62: invokevirtual 385	java/io/ByteArrayOutputStream:close	()V
    //   65: goto -18 -> 47
    //   68: pop
    //   69: goto -22 -> 47
    //   72: astore 4
    //   74: aconst_null
    //   75: astore_3
    //   76: aload 4
    //   78: astore 4
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 384	java/io/ObjectOutputStream:close	()V
    //   88: aload_2
    //   89: invokevirtual 385	java/io/ByteArrayOutputStream:close	()V
    //   92: aload 4
    //   94: athrow
    //   95: pop
    //   96: goto -4 -> 92
    //   99: astore 4
    //   101: goto -21 -> 80
    //   104: pop
    //   105: goto -52 -> 53
    //   108: pop
    //   109: goto -62 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	v
    //   0	112	1	paramObject	Object
    //   10	79	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   19	66	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   1	47	4	arrayOfByte	byte[]
    //   72	5	4	localObject1	Object
    //   78	15	4	localObject2	Object
    //   99	1	4	localObject3	Object
    //   50	1	8	localIOException1	java.io.IOException
    //   68	1	9	localIOException2	java.io.IOException
    //   95	1	10	localIOException3	java.io.IOException
    //   104	1	11	localIOException4	java.io.IOException
    //   108	1	12	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   11	20	50	java/io/IOException
    //   57	65	68	java/io/IOException
    //   11	20	72	finally
    //   84	92	95	java/io/IOException
    //   20	31	99	finally
    //   20	31	104	java/io/IOException
    //   39	47	108	java/io/IOException
  }
  
  private void lA()
  {
    try
    {
      this.afi.close();
      label7:
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      break label7;
    }
  }
  
  private List<DataLayer.a> lx()
  {
    try
    {
      x(this.aec.currentTimeMillis());
      List localList = e(ly());
      return localList;
    }
    finally
    {
      lA();
    }
  }
  
  private List<b> ly()
  {
    SQLiteDatabase localSQLiteDatabase = S("Error opening database for loadSerialized.");
    ArrayList localArrayList = new ArrayList();
    if (localSQLiteDatabase == null) {
      localArrayList = localArrayList;
    }
    for (;;)
    {
      return localArrayList;
      Object localObject3 = new String[2];
      localObject3[0] = "key";
      localObject3[1] = "value";
      localObject3 = localSQLiteDatabase.query("datalayer", (String[])localObject3, null, null, null, null, "ID", null);
      try
      {
        while (((Cursor)localObject3).moveToNext()) {
          localArrayList.add(new b(((Cursor)localObject3).getString(0), ((Cursor)localObject3).getBlob(1)));
        }
        Object localObject2 = localObject1;
      }
      finally
      {
        ((Cursor)localObject3).close();
      }
    }
  }
  
  private int lz()
  {
    Cursor localCursor = null;
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = S("Error opening database for getNumStoredEntries.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return i;
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("SELECT COUNT(*) from datalayer", null);
        if (localCursor.moveToFirst())
        {
          long l = localCursor.getLong(0);
          int j = (int)l;
        }
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      catch (SQLiteException localSQLiteException)
      {
        bh.D("Error getting numStoredEntries");
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
  }
  
  private void x(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = S("Error opening database for deleteOlderThan.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      try
      {
        String[] arrayOfString = new String[1];
        arrayOfString[0] = Long.toString(paramLong);
        int i = localSQLiteDatabase.delete("datalayer", "expires <= ?", arrayOfString);
        bh.C("Deleted " + i + " expired items");
      }
      catch (SQLiteException localSQLiteException)
      {
        bh.D("Error deleting old entries.");
      }
    }
  }
  
  public void a(final DataLayer.c.a parama)
  {
    this.afh.execute(new Runnable()
    {
      public void run()
      {
        parama.d(v.a(v.this));
      }
    });
  }
  
  public void a(List<DataLayer.a> paramList, final long paramLong)
  {
    final List localList = f(paramList);
    this.afh.execute(new Runnable()
    {
      public void run()
      {
        v.a(v.this, localList, paramLong);
      }
    });
  }
  
  public void bP(final String paramString)
  {
    this.afh.execute(new Runnable()
    {
      public void run()
      {
        v.a(v.this, paramString);
      }
    });
  }
  
  private static class b
  {
    final String JI;
    final byte[] afp;
    
    b(String paramString, byte[] paramArrayOfByte)
    {
      this.JI = paramString;
      this.afp = paramArrayOfByte;
    }
    
    public String toString()
    {
      return "KeyAndSerialized: key = " + this.JI + " serialized hash = " + Arrays.hashCode(this.afp);
    }
  }
  
  class a
    extends SQLiteOpenHelper
  {
    a(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private void a(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = localCursor.getColumnNames();
        for (int i = 0; i < arrayOfString.length; i++) {
          localHashSet.add(arrayOfString[i]);
        }
        localCursor.close();
        if ((!localHashSet.remove("key")) || (!localHashSet.remove("value")) || (!localHashSet.remove("ID")) || (!localHashSet.remove("expires"))) {
          throw new SQLiteException("Database column missing");
        }
      }
      finally
      {
        localCursor.close();
      }
      if (!localObject.isEmpty()) {
        throw new SQLiteException("Database has extra columns");
      }
    }
    
    /* Error */
    private boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: iconst_1
      //   3: anewarray 72	java/lang/String
      //   6: astore 4
      //   8: aload 4
      //   10: iconst_0
      //   11: ldc 74
      //   13: aastore
      //   14: iconst_1
      //   15: anewarray 72	java/lang/String
      //   18: astore 5
      //   20: aload 5
      //   22: iconst_0
      //   23: aload_1
      //   24: aastore
      //   25: aload_2
      //   26: ldc 76
      //   28: aload 4
      //   30: ldc 78
      //   32: aload 5
      //   34: aconst_null
      //   35: aconst_null
      //   36: aconst_null
      //   37: invokevirtual 82	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   40: astore_3
      //   41: aload_3
      //   42: invokeinterface 85 1 0
      //   47: istore 4
      //   49: iload 4
      //   51: istore 4
      //   53: aload_3
      //   54: ifnull +9 -> 63
      //   57: aload_3
      //   58: invokeinterface 45 1 0
      //   63: iload 4
      //   65: ireturn
      //   66: pop
      //   67: aconst_null
      //   68: astore_3
      //   69: new 87	java/lang/StringBuilder
      //   72: dup
      //   73: invokespecial 88	java/lang/StringBuilder:<init>	()V
      //   76: ldc 90
      //   78: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   81: aload_1
      //   82: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   85: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   88: invokestatic 103	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
      //   91: aload_3
      //   92: ifnull +9 -> 101
      //   95: aload_3
      //   96: invokeinterface 45 1 0
      //   101: iconst_0
      //   102: istore 4
      //   104: goto -41 -> 63
      //   107: astore 4
      //   109: aload_3
      //   110: ifnull +9 -> 119
      //   113: aload_3
      //   114: invokeinterface 45 1 0
      //   119: aload 4
      //   121: athrow
      //   122: astore 4
      //   124: aload_3
      //   125: astore_3
      //   126: goto -17 -> 109
      //   129: astore 4
      //   131: aload_3
      //   132: astore_3
      //   133: aload 4
      //   135: astore 4
      //   137: goto -28 -> 109
      //   140: pop
      //   141: aload_3
      //   142: astore_3
      //   143: goto -74 -> 69
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	146	0	this	a
      //   0	146	1	paramString	String
      //   0	146	2	paramSQLiteDatabase	SQLiteDatabase
      //   1	142	3	localCursor	Cursor
      //   6	23	4	arrayOfString1	String[]
      //   47	56	4	bool	boolean
      //   107	13	4	localObject1	Object
      //   122	1	4	localObject2	Object
      //   129	5	4	localObject3	Object
      //   135	1	4	localObject4	Object
      //   18	15	5	arrayOfString2	String[]
      //   66	1	11	localSQLiteException1	SQLiteException
      //   140	1	12	localSQLiteException2	SQLiteException
      // Exception table:
      //   from	to	target	type
      //   2	41	66	android/database/sqlite/SQLiteException
      //   2	41	107	finally
      //   41	49	122	finally
      //   69	91	129	finally
      //   41	49	140	android/database/sqlite/SQLiteException
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      SQLiteDatabase localSQLiteDatabase = null;
      try
      {
        localSQLiteDatabase = super.getWritableDatabase();
        localSQLiteDatabase = localSQLiteDatabase;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          v.b(v.this).getDatabasePath("google_tagmanager.db").delete();
        }
      }
      if (localSQLiteDatabase == null) {
        localSQLiteDatabase = super.getWritableDatabase();
      }
      return localSQLiteDatabase;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      ak.N(paramSQLiteDatabase.getPath());
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor;
      if (Build.VERSION.SDK_INT < 15) {
        localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
      }
      for (;;)
      {
        try
        {
          localCursor.moveToFirst();
          localCursor.close();
          if (!a("datalayer", paramSQLiteDatabase))
          {
            paramSQLiteDatabase.execSQL(v.lB());
            return;
          }
        }
        finally
        {
          localCursor.close();
        }
        a(paramSQLiteDatabase);
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.v
 * JD-Core Version:    0.7.0.1
 */