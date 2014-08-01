package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.fe;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class ac
  implements d
{
  private static final String wM;
  private final Context mContext;
  private final e tZ;
  private i ur;
  private final a wN;
  private volatile n wO;
  private final String wP;
  private ab wQ;
  private long wR;
  private final int wS;
  
  static
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = "hits2";
    arrayOfObject[1] = "hit_id";
    arrayOfObject[2] = "hit_time";
    arrayOfObject[3] = "hit_url";
    arrayOfObject[4] = "hit_string";
    arrayOfObject[5] = "hit_app_id";
    wM = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", arrayOfObject);
  }
  
  ac(e parame, Context paramContext)
  {
    this(parame, paramContext, "google_analytics_v4.db", 2000);
  }
  
  ac(e parame, Context paramContext, String paramString, int paramInt)
  {
    this.mContext = paramContext.getApplicationContext();
    this.wP = paramString;
    this.tZ = parame;
    this.ur = new i()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    this.wN = new a(this.mContext, this.wP);
    this.wO = new ah(new DefaultHttpClient(), this.mContext);
    this.wR = 0L;
    this.wS = paramInt;
  }
  
  private SQLiteDatabase S(String paramString)
  {
    try
    {
      localSQLiteDatabase = this.wN.getWritableDatabase();
      localSQLiteDatabase = localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        aa.D(paramString);
        SQLiteDatabase localSQLiteDatabase = null;
      }
    }
    return localSQLiteDatabase;
  }
  
  private void a(Map<String, String> paramMap, long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = S("Error opening database for putHit");
    if (localSQLiteDatabase == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_string", v(paramMap));
    localContentValues.put("hit_time", Long.valueOf(paramLong));
    if (paramMap.containsKey("AppUID")) {}
    for (;;)
    {
      try
      {
        l = Long.parseLong((String)paramMap.get("AppUID"));
        l = l;
        localContentValues.put("hit_app_id", Long.valueOf(l));
        if (paramString == null) {
          paramString = "http://www.google-analytics.com/collect";
        }
        if (paramString.length() == 0) {
          aa.D("Empty path: not sending hit");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          l = 0L;
          continue;
          localContentValues.put("hit_url", paramString);
          try
          {
            localSQLiteDatabase.insert("hits2", null, localContentValues);
            this.tZ.s(false);
          }
          catch (SQLiteException localSQLiteException)
          {
            aa.D("Error storing hit");
          }
        }
      }
      break;
      long l = 0L;
    }
  }
  
  private void a(Map<String, String> paramMap, Collection<fe> paramCollection)
  {
    String str = "&_v".substring(1);
    if (paramCollection != null)
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        fe localfe = (fe)localIterator.next();
        if ("appendVersion".equals(localfe.getId())) {
          paramMap.put(str, localfe.getValue());
        }
      }
    }
  }
  
  private void dm()
  {
    int i = 1 + (jdMethod_do() - this.wS);
    if (i > 0)
    {
      List localList = A(i);
      aa.C("Store full, deleting " + localList.size() + " hits to make room.");
      a((String[])localList.toArray(new String[0]));
    }
  }
  
  static String v(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return TextUtils.join("&", localArrayList);
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(y.encode((String)localEntry.getKey()) + "=" + y.encode((String)localEntry.getValue()));
    }
  }
  
  /* Error */
  List<String> A(int paramInt)
  {
    // Byte code:
    //   0: new 270	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 308	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: iload_1
    //   9: ifgt +13 -> 22
    //   12: ldc_w 310
    //   15: invokestatic 115	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   18: aload_2
    //   19: astore_2
    //   20: aload_2
    //   21: areturn
    //   22: aload_0
    //   23: ldc_w 312
    //   26: invokespecial 123	com/google/android/gms/analytics/ac:S	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore_3
    //   30: aload_3
    //   31: ifnonnull +8 -> 39
    //   34: aload_2
    //   35: astore_2
    //   36: goto -16 -> 20
    //   39: iconst_1
    //   40: anewarray 48	java/lang/String
    //   43: astore 5
    //   45: aload 5
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
    //   63: aload_3
    //   64: ldc 34
    //   66: aload 5
    //   68: aconst_null
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: ldc_w 314
    //   75: aload 4
    //   77: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   80: iload_1
    //   81: invokestatic 318	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   84: invokevirtual 322	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   87: astore_3
    //   88: aload_3
    //   89: astore_3
    //   90: aload_3
    //   91: invokeinterface 327 1 0
    //   96: ifeq +33 -> 129
    //   99: aload_2
    //   100: aload_3
    //   101: iconst_0
    //   102: invokeinterface 331 2 0
    //   107: invokestatic 334	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   110: invokeinterface 307 2 0
    //   115: pop
    //   116: aload_3
    //   117: invokeinterface 337 1 0
    //   122: istore 4
    //   124: iload 4
    //   126: ifne -27 -> 99
    //   129: aload_3
    //   130: ifnull +9 -> 139
    //   133: aload_3
    //   134: invokeinterface 340 1 0
    //   139: aload_2
    //   140: astore_2
    //   141: goto -121 -> 20
    //   144: astore 4
    //   146: aconst_null
    //   147: astore_3
    //   148: new 235	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 342
    //   158: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 4
    //   163: invokevirtual 345	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   166: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 115	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   175: aload_3
    //   176: ifnull -37 -> 139
    //   179: aload_3
    //   180: invokeinterface 340 1 0
    //   185: goto -46 -> 139
    //   188: astore_2
    //   189: aconst_null
    //   190: astore_3
    //   191: aload_3
    //   192: ifnull +9 -> 201
    //   195: aload_3
    //   196: invokeinterface 340 1 0
    //   201: aload_2
    //   202: athrow
    //   203: astore_2
    //   204: goto -13 -> 191
    //   207: astore 4
    //   209: goto -61 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	ac
    //   0	212	1	paramInt	int
    //   7	134	2	localArrayList	ArrayList
    //   188	14	2	localObject1	Object
    //   203	1	2	localObject2	Object
    //   29	167	3	localObject3	Object
    //   55	21	4	arrayOfObject	Object[]
    //   122	3	4	bool	boolean
    //   144	18	4	localSQLiteException1	SQLiteException
    //   207	1	4	localSQLiteException2	SQLiteException
    //   43	24	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   39	88	144	android/database/sqlite/SQLiteException
    //   39	88	188	finally
    //   90	124	203	finally
    //   148	175	203	finally
    //   90	124	207	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public List<x> B(int paramInt)
  {
    // Byte code:
    //   0: new 270	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 308	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: ldc_w 348
    //   12: invokespecial 123	com/google/android/gms/analytics/ac:S	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +7 -> 26
    //   22: aload_3
    //   23: astore_3
    //   24: aload_3
    //   25: areturn
    //   26: aconst_null
    //   27: astore_2
    //   28: iconst_2
    //   29: anewarray 48	java/lang/String
    //   32: astore 5
    //   34: aload 5
    //   36: iconst_0
    //   37: ldc 36
    //   39: aastore
    //   40: aload 5
    //   42: iconst_1
    //   43: ldc 38
    //   45: aastore
    //   46: iconst_1
    //   47: anewarray 4	java/lang/Object
    //   50: astore 6
    //   52: aload 6
    //   54: iconst_0
    //   55: ldc 36
    //   57: aastore
    //   58: aload 4
    //   60: ldc 34
    //   62: aload 5
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: aconst_null
    //   68: ldc_w 314
    //   71: aload 6
    //   73: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   76: iload_1
    //   77: invokestatic 318	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   80: invokevirtual 322	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore_2
    //   84: aload_2
    //   85: astore_2
    //   86: new 270	java/util/ArrayList
    //   89: dup
    //   90: invokespecial 308	java/util/ArrayList:<init>	()V
    //   93: astore_3
    //   94: aload_2
    //   95: invokeinterface 327 1 0
    //   100: ifeq +45 -> 145
    //   103: aload_3
    //   104: new 350	com/google/android/gms/analytics/x
    //   107: dup
    //   108: aconst_null
    //   109: aload_2
    //   110: iconst_0
    //   111: invokeinterface 331 2 0
    //   116: aload_2
    //   117: iconst_1
    //   118: invokeinterface 331 2 0
    //   123: invokespecial 353	com/google/android/gms/analytics/x:<init>	(Ljava/lang/String;JJ)V
    //   126: invokeinterface 307 2 0
    //   131: pop
    //   132: aload_2
    //   133: invokeinterface 337 1 0
    //   138: istore 5
    //   140: iload 5
    //   142: ifne -39 -> 103
    //   145: aload_2
    //   146: ifnull +9 -> 155
    //   149: aload_2
    //   150: invokeinterface 340 1 0
    //   155: iconst_3
    //   156: anewarray 48	java/lang/String
    //   159: astore 6
    //   161: aload 6
    //   163: iconst_0
    //   164: ldc 36
    //   166: aastore
    //   167: aload 6
    //   169: iconst_1
    //   170: ldc 42
    //   172: aastore
    //   173: aload 6
    //   175: iconst_2
    //   176: ldc 40
    //   178: aastore
    //   179: iconst_1
    //   180: anewarray 4	java/lang/Object
    //   183: astore 5
    //   185: aload 5
    //   187: iconst_0
    //   188: ldc 36
    //   190: aastore
    //   191: aload 4
    //   193: ldc 34
    //   195: aload 6
    //   197: aconst_null
    //   198: aconst_null
    //   199: aconst_null
    //   200: aconst_null
    //   201: ldc_w 314
    //   204: aload 5
    //   206: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   209: iload_1
    //   210: invokestatic 318	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   213: invokevirtual 322	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   216: astore_2
    //   217: aload_2
    //   218: invokeinterface 327 1 0
    //   223: ifeq +80 -> 303
    //   226: iconst_0
    //   227: istore 5
    //   229: aload_2
    //   230: checkcast 355	android/database/sqlite/SQLiteCursor
    //   233: invokevirtual 359	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   236: invokevirtual 364	android/database/CursorWindow:getNumRows	()I
    //   239: ifle +140 -> 379
    //   242: aload_3
    //   243: iload 5
    //   245: invokeinterface 367 2 0
    //   250: checkcast 350	com/google/android/gms/analytics/x
    //   253: aload_2
    //   254: iconst_1
    //   255: invokeinterface 370 2 0
    //   260: invokevirtual 373	com/google/android/gms/analytics/x:Q	(Ljava/lang/String;)V
    //   263: aload_3
    //   264: iload 5
    //   266: invokeinterface 367 2 0
    //   271: checkcast 350	com/google/android/gms/analytics/x
    //   274: aload_2
    //   275: iconst_2
    //   276: invokeinterface 370 2 0
    //   281: invokevirtual 376	com/google/android/gms/analytics/x:R	(Ljava/lang/String;)V
    //   284: iload 5
    //   286: iconst_1
    //   287: iadd
    //   288: istore 4
    //   290: aload_2
    //   291: invokeinterface 337 1 0
    //   296: istore 5
    //   298: iload 5
    //   300: ifne +304 -> 604
    //   303: aload_2
    //   304: ifnull +9 -> 313
    //   307: aload_2
    //   308: invokeinterface 340 1 0
    //   313: aload_3
    //   314: astore_3
    //   315: goto -291 -> 24
    //   318: astore_2
    //   319: aload_2
    //   320: astore 4
    //   322: aconst_null
    //   323: astore_2
    //   324: aload_3
    //   325: astore_3
    //   326: new 235	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   333: ldc_w 342
    //   336: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload 4
    //   341: invokevirtual 345	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   344: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 115	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   353: aload_2
    //   354: ifnull -330 -> 24
    //   357: aload_2
    //   358: invokeinterface 340 1 0
    //   363: goto -339 -> 24
    //   366: astore_3
    //   367: aload_2
    //   368: ifnull +9 -> 377
    //   371: aload_2
    //   372: invokeinterface 340 1 0
    //   377: aload_3
    //   378: athrow
    //   379: iconst_1
    //   380: anewarray 4	java/lang/Object
    //   383: astore 4
    //   385: aload 4
    //   387: iconst_0
    //   388: aload_3
    //   389: iload 5
    //   391: invokeinterface 367 2 0
    //   396: checkcast 350	com/google/android/gms/analytics/x
    //   399: invokevirtual 380	com/google/android/gms/analytics/x:dg	()J
    //   402: invokestatic 140	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   405: aastore
    //   406: ldc_w 382
    //   409: aload 4
    //   411: invokestatic 52	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   414: invokestatic 115	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   417: goto -133 -> 284
    //   420: astore 4
    //   422: aload_2
    //   423: astore_2
    //   424: new 235	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   431: ldc_w 384
    //   434: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload 4
    //   439: invokevirtual 345	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   442: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 115	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
    //   451: new 270	java/util/ArrayList
    //   454: dup
    //   455: invokespecial 308	java/util/ArrayList:<init>	()V
    //   458: astore 5
    //   460: iconst_0
    //   461: istore 4
    //   463: aload_3
    //   464: invokeinterface 385 1 0
    //   469: astore 6
    //   471: aload 6
    //   473: invokeinterface 200 1 0
    //   478: ifeq +33 -> 511
    //   481: aload 6
    //   483: invokeinterface 204 1 0
    //   488: checkcast 350	com/google/android/gms/analytics/x
    //   491: astore_3
    //   492: aload_3
    //   493: invokevirtual 388	com/google/android/gms/analytics/x:df	()Ljava/lang/String;
    //   496: invokestatic 392	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   499: istore 7
    //   501: iload 7
    //   503: ifeq +27 -> 530
    //   506: iload 4
    //   508: ifeq +19 -> 527
    //   511: aload_2
    //   512: ifnull +9 -> 521
    //   515: aload_2
    //   516: invokeinterface 340 1 0
    //   521: aload 5
    //   523: astore_3
    //   524: goto -500 -> 24
    //   527: iconst_1
    //   528: istore 4
    //   530: aload 5
    //   532: aload_3
    //   533: invokeinterface 307 2 0
    //   538: pop
    //   539: goto -68 -> 471
    //   542: astore_3
    //   543: aload_2
    //   544: ifnull +9 -> 553
    //   547: aload_2
    //   548: invokeinterface 340 1 0
    //   553: aload_3
    //   554: athrow
    //   555: astore_3
    //   556: aload_2
    //   557: astore_2
    //   558: goto -15 -> 543
    //   561: astore 4
    //   563: goto -139 -> 424
    //   566: astore_3
    //   567: aload_2
    //   568: astore_2
    //   569: goto -202 -> 367
    //   572: astore_3
    //   573: aload_2
    //   574: astore_2
    //   575: goto -208 -> 367
    //   578: astore 4
    //   580: aload 4
    //   582: astore 4
    //   584: aload_2
    //   585: astore_2
    //   586: aload_3
    //   587: astore_3
    //   588: goto -262 -> 326
    //   591: astore 4
    //   593: aload 4
    //   595: astore 4
    //   597: aload_2
    //   598: astore_2
    //   599: aload_3
    //   600: astore_3
    //   601: goto -275 -> 326
    //   604: iload 4
    //   606: istore 5
    //   608: goto -379 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	611	0	this	ac
    //   0	611	1	paramInt	int
    //   27	281	2	localCursor	Cursor
    //   318	2	2	localSQLiteException1	SQLiteException
    //   323	276	2	localObject1	Object
    //   7	319	3	localArrayList1	ArrayList
    //   366	98	3	localObject2	Object
    //   491	42	3	localObject3	Object
    //   542	12	3	localObject4	Object
    //   555	1	3	localObject5	Object
    //   566	1	3	localObject6	Object
    //   572	15	3	localObject7	Object
    //   587	14	3	localObject8	Object
    //   15	177	4	localSQLiteDatabase	SQLiteDatabase
    //   288	1	4	i	int
    //   320	90	4	localObject9	Object
    //   420	18	4	localSQLiteException2	SQLiteException
    //   461	68	4	j	int
    //   561	1	4	localSQLiteException3	SQLiteException
    //   578	3	4	localSQLiteException4	SQLiteException
    //   582	1	4	localSQLiteException5	SQLiteException
    //   591	3	4	localSQLiteException6	SQLiteException
    //   595	10	4	localSQLiteException7	SQLiteException
    //   32	31	5	arrayOfString	String[]
    //   138	3	5	bool1	boolean
    //   183	22	5	arrayOfObject	Object[]
    //   227	61	5	k	int
    //   296	94	5	m	int
    //   458	73	5	localArrayList2	ArrayList
    //   606	1	5	n	int
    //   50	432	6	localObject10	Object
    //   499	3	7	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   28	84	318	android/database/sqlite/SQLiteException
    //   28	84	366	finally
    //   217	298	420	android/database/sqlite/SQLiteException
    //   379	417	420	android/database/sqlite/SQLiteException
    //   155	217	542	finally
    //   424	501	542	finally
    //   530	539	542	finally
    //   217	298	555	finally
    //   379	417	555	finally
    //   155	217	561	android/database/sqlite/SQLiteException
    //   86	94	566	finally
    //   94	140	566	finally
    //   326	353	572	finally
    //   86	94	578	android/database/sqlite/SQLiteException
    //   94	140	591	android/database/sqlite/SQLiteException
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, Collection<fe> paramCollection)
  {
    dn();
    dm();
    a(paramMap, paramCollection);
    a(paramMap, paramLong, paramString);
  }
  
  void a(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      aa.D("Empty hitIds passed to deleteHits.");
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = S("Error opening database for deleteHits.");
    } while (localObject1 == null);
    Object localObject2 = new Object[bool];
    localObject2[0] = TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?"));
    localObject2 = String.format("HIT_ID in (%s)", (Object[])localObject2);
    for (;;)
    {
      try
      {
        ((SQLiteDatabase)localObject1).delete("hits2", (String)localObject2, paramArrayOfString);
        localObject1 = this.tZ;
        if (jdMethod_do() != 0) {
          break label123;
        }
        ((e)localObject1).s(bool);
      }
      catch (SQLiteException localSQLiteException)
      {
        aa.D("Error deleting hits " + paramArrayOfString);
      }
      break;
      label123:
      bool = false;
    }
  }
  
  @Deprecated
  void b(Collection<x> paramCollection)
  {
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      String[] arrayOfString = new String[paramCollection.size()];
      Iterator localIterator = paramCollection.iterator();
      int j;
      for (int i = 0;; i = j)
      {
        if (!localIterator.hasNext())
        {
          a(arrayOfString);
          break;
        }
        x localx = (x)localIterator.next();
        j = i + 1;
        arrayOfString[i] = String.valueOf(localx.dg());
      }
    }
    aa.D("Empty/Null collection passed to deleteHits.");
  }
  
  public void cl()
  {
    boolean bool = true;
    aa.C("Dispatch running...");
    if (this.wO.cx())
    {
      List localList = B(40);
      int i;
      if (!localList.isEmpty())
      {
        if (this.wQ == null) {
          this.wQ = new ab("_t=dispatch&_v=ma4.0.2", bool);
        }
        if (jdMethod_do() > localList.size()) {
          bool = false;
        }
        i = this.wO.a(localList, this.wQ, bool);
        aa.C("sent " + i + " of " + localList.size() + " hits");
        b(localList.subList(0, Math.min(i, localList.size())));
        if ((i != localList.size()) || (jdMethod_do() <= 0)) {
          this.wQ = null;
        } else {
          GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
        }
      }
      else
      {
        aa.C("...nothing to dispatch");
        this.tZ.s(i);
      }
    }
  }
  
  public n cm()
  {
    return this.wO;
  }
  
  int dn()
  {
    boolean bool = true;
    int i = 0;
    long l = this.ur.currentTimeMillis();
    e locale1;
    if (l > 86400000L + this.wR)
    {
      this.wR = l;
      SQLiteDatabase localSQLiteDatabase = S("Error opening database for deleteStaleHits.");
      if (localSQLiteDatabase != null)
      {
        l = this.ur.currentTimeMillis() - 2592000000L;
        String[] arrayOfString = new String[bool];
        arrayOfString[i] = Long.toString(l);
        e locale2 = localSQLiteDatabase.delete("hits2", "HIT_TIME < ?", arrayOfString);
        locale1 = this.tZ;
        if (jdMethod_do() != 0) {
          bool = false;
        }
        locale1.s(bool);
        locale1 = locale2;
      }
    }
    return locale1;
  }
  
  int jdMethod_do()
  {
    Cursor localCursor = null;
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = S("Error opening database for getNumStoredHits.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return i;
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("SELECT COUNT(*) from hits2", null);
        if (localCursor.moveToFirst())
        {
          long l = localCursor.getLong(0);
          i = (int)l;
        }
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      catch (SQLiteException localSQLiteException)
      {
        aa.D("Error getting numStoredHits");
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
  
  public void l(long paramLong)
  {
    boolean bool = true;
    Object localObject = S("Error opening database for clearHits");
    if (localObject != null)
    {
      if (paramLong != 0L)
      {
        String[] arrayOfString = new String[bool];
        arrayOfString[0] = Long.valueOf(paramLong).toString();
        ((SQLiteDatabase)localObject).delete("hits2", "hit_app_id = ?", arrayOfString);
      }
      else
      {
        ((SQLiteDatabase)localObject).delete("hits2", null, null);
      }
      localObject = this.tZ;
      if (jdMethod_do() != 0) {
        bool = false;
      }
      ((e)localObject).s(bool);
    }
  }
  
  class a
    extends SQLiteOpenHelper
  {
    private boolean wU;
    private long wV = 0L;
    
    a(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private void a(SQLiteDatabase paramSQLiteDatabase)
    {
      int j = 0;
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = localCursor.getColumnNames();
        for (int i = 0; i < arrayOfString.length; i++) {
          localHashSet.add(arrayOfString[i]);
        }
        localCursor.close();
        if ((!localHashSet.remove("hit_id")) || (!localHashSet.remove("hit_url")) || (!localHashSet.remove("hit_string")) || (!localHashSet.remove("hit_time"))) {
          throw new SQLiteException("Database column missing");
        }
      }
      finally
      {
        localCursor.close();
      }
      if (!localObject.remove("hit_app_id")) {
        j = 1;
      }
      if (!localObject.isEmpty()) {
        throw new SQLiteException("Database has extra columns");
      }
      if (j != 0) {
        paramSQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
      }
    }
    
    /* Error */
    private boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: iconst_1
      //   3: anewarray 87	java/lang/String
      //   6: astore 5
      //   8: aload 5
      //   10: iconst_0
      //   11: ldc 89
      //   13: aastore
      //   14: iconst_1
      //   15: anewarray 87	java/lang/String
      //   18: astore 4
      //   20: aload 4
      //   22: iconst_0
      //   23: aload_1
      //   24: aastore
      //   25: aload_2
      //   26: ldc 91
      //   28: aload 5
      //   30: ldc 93
      //   32: aload 4
      //   34: aconst_null
      //   35: aconst_null
      //   36: aconst_null
      //   37: invokevirtual 97	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   40: astore_3
      //   41: aload_3
      //   42: invokeinterface 100 1 0
      //   47: istore 4
      //   49: iload 4
      //   51: istore 4
      //   53: aload_3
      //   54: ifnull +9 -> 63
      //   57: aload_3
      //   58: invokeinterface 53 1 0
      //   63: iload 4
      //   65: ireturn
      //   66: pop
      //   67: aconst_null
      //   68: astore_3
      //   69: new 102	java/lang/StringBuilder
      //   72: dup
      //   73: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   76: ldc 105
      //   78: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   81: aload_1
      //   82: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   85: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   88: invokestatic 118	com/google/android/gms/analytics/aa:D	(Ljava/lang/String;)V
      //   91: aload_3
      //   92: ifnull +9 -> 101
      //   95: aload_3
      //   96: invokeinterface 53 1 0
      //   101: iconst_0
      //   102: istore 4
      //   104: goto -41 -> 63
      //   107: astore 4
      //   109: aload_3
      //   110: ifnull +9 -> 119
      //   113: aload_3
      //   114: invokeinterface 53 1 0
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
      //   18	15	4	arrayOfString1	String[]
      //   47	56	4	bool	boolean
      //   107	13	4	localObject1	Object
      //   122	1	4	localObject2	Object
      //   129	5	4	localObject3	Object
      //   135	1	4	localObject4	Object
      //   6	23	5	arrayOfString2	String[]
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
      if ((this.wU) && (3600000L + this.wV > ac.a(ac.this).currentTimeMillis())) {
        throw new SQLiteException("Database creation failed");
      }
      SQLiteDatabase localSQLiteDatabase = null;
      this.wU = true;
      this.wV = ac.a(ac.this).currentTimeMillis();
      try
      {
        localSQLiteDatabase = super.getWritableDatabase();
        localSQLiteDatabase = localSQLiteDatabase;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          ac.c(ac.this).getDatabasePath(ac.b(ac.this)).delete();
        }
      }
      if (localSQLiteDatabase == null) {
        localSQLiteDatabase = super.getWritableDatabase();
      }
      this.wU = false;
      return localSQLiteDatabase;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      p.N(paramSQLiteDatabase.getPath());
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
          if (!a("hits2", paramSQLiteDatabase))
          {
            paramSQLiteDatabase.execSQL(ac.dp());
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
 * Qualified Name:     com.google.android.gms.analytics.ac
 * JD-Core Version:    0.7.0.1
 */