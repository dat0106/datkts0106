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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class ca
  implements at
{
  private static final String wM;
  private ik aec;
  private final b agn;
  private volatile ab ago;
  private final au agp;
  private final Context mContext;
  private final String wP;
  private long wR;
  private final int wS;
  
  static
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = "gtm_hits";
    arrayOfObject[1] = "hit_id";
    arrayOfObject[2] = "hit_time";
    arrayOfObject[3] = "hit_url";
    arrayOfObject[4] = "hit_first_send_time";
    wM = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", arrayOfObject);
  }
  
  ca(au paramau, Context paramContext)
  {
    this(paramau, paramContext, "gtm_urls.db", 2000);
  }
  
  ca(au paramau, Context paramContext, String paramString, int paramInt)
  {
    this.mContext = paramContext.getApplicationContext();
    this.wP = paramString;
    this.agp = paramau;
    this.aec = im.fW();
    this.agn = new b(this.mContext, this.wP);
    this.ago = new da(new DefaultHttpClient(), this.mContext, new a());
    this.wR = 0L;
    this.wS = paramInt;
  }
  
  private SQLiteDatabase S(String paramString)
  {
    try
    {
      localSQLiteDatabase = this.agn.getWritableDatabase();
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
  
  private void c(long paramLong1, long paramLong2)
  {
    SQLiteDatabase localSQLiteDatabase = S("Error opening database for getNumStoredHits.");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("hit_first_send_time", Long.valueOf(paramLong2));
      try
      {
        String[] arrayOfString = new String[1];
        arrayOfString[0] = String.valueOf(paramLong1);
        localSQLiteDatabase.update("gtm_hits", localContentValues, "hit_id=?", arrayOfString);
      }
      catch (SQLiteException localSQLiteException)
      {
        bh.D("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + paramLong1);
        y(paramLong1);
      }
    }
  }
  
  private void dm()
  {
    int i = 1 + (jdMethod_do() - this.wS);
    if (i > 0)
    {
      List localList = A(i);
      bh.C("Store full, deleting " + localList.size() + " hits to make room.");
      a((String[])localList.toArray(new String[0]));
    }
  }
  
  private void g(long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = S("Error opening database for putHit");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("hit_time", Long.valueOf(paramLong));
      localContentValues.put("hit_url", paramString);
      localContentValues.put("hit_first_send_time", Integer.valueOf(0));
      try
      {
        localSQLiteDatabase.insert("gtm_hits", null, localContentValues);
        this.agp.s(false);
      }
      catch (SQLiteException localSQLiteException)
      {
        bh.D("Error storing hit");
      }
    }
  }
  
  private void y(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    a(arrayOfString);
  }
  
  /* Error */
  List<String> A(int paramInt)
  {
    // Byte code:
    //   0: new 238	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 239	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: iload_1
    //   9: ifgt +12 -> 21
    //   12: ldc 241
    //   14: invokestatic 118	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   17: aload_2
    //   18: astore_2
    //   19: aload_2
    //   20: areturn
    //   21: aload_0
    //   22: ldc 243
    //   24: invokespecial 135	com/google/android/gms/tagmanager/ca:S	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnonnull +8 -> 39
    //   34: aload_2
    //   35: astore_2
    //   36: goto -17 -> 19
    //   39: iconst_1
    //   40: anewarray 45	java/lang/String
    //   43: astore_3
    //   44: aload_3
    //   45: iconst_0
    //   46: ldc 35
    //   48: aastore
    //   49: iconst_1
    //   50: anewarray 4	java/lang/Object
    //   53: astore 5
    //   55: aload 5
    //   57: iconst_0
    //   58: ldc 35
    //   60: aastore
    //   61: aload 4
    //   63: ldc 33
    //   65: aload_3
    //   66: aconst_null
    //   67: aconst_null
    //   68: aconst_null
    //   69: aconst_null
    //   70: ldc 245
    //   72: aload 5
    //   74: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   77: iload_1
    //   78: invokestatic 248	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   81: invokevirtual 252	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore_3
    //   85: aload_3
    //   86: astore_3
    //   87: aload_3
    //   88: invokeinterface 258 1 0
    //   93: ifeq +33 -> 126
    //   96: aload_2
    //   97: aload_3
    //   98: iconst_0
    //   99: invokeinterface 262 2 0
    //   104: invokestatic 151	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   107: invokeinterface 266 2 0
    //   112: pop
    //   113: aload_3
    //   114: invokeinterface 269 1 0
    //   119: istore 4
    //   121: iload 4
    //   123: ifne -27 -> 96
    //   126: aload_3
    //   127: ifnull +9 -> 136
    //   130: aload_3
    //   131: invokeinterface 272 1 0
    //   136: aload_2
    //   137: astore_2
    //   138: goto -119 -> 19
    //   141: astore 4
    //   143: aconst_null
    //   144: astore_3
    //   145: new 161	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 274
    //   155: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 4
    //   160: invokevirtual 277	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 118	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   172: aload_3
    //   173: ifnull -37 -> 136
    //   176: aload_3
    //   177: invokeinterface 272 1 0
    //   182: goto -46 -> 136
    //   185: astore_2
    //   186: aconst_null
    //   187: astore_3
    //   188: aload_3
    //   189: ifnull +9 -> 198
    //   192: aload_3
    //   193: invokeinterface 272 1 0
    //   198: aload_2
    //   199: athrow
    //   200: astore_2
    //   201: goto -13 -> 188
    //   204: astore 4
    //   206: goto -61 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	ca
    //   0	209	1	paramInt	int
    //   7	131	2	localArrayList	java.util.ArrayList
    //   185	14	2	localObject1	Object
    //   200	1	2	localObject2	Object
    //   43	150	3	localObject3	Object
    //   27	35	4	localSQLiteDatabase	SQLiteDatabase
    //   119	3	4	bool	boolean
    //   141	18	4	localSQLiteException1	SQLiteException
    //   204	1	4	localSQLiteException2	SQLiteException
    //   53	20	5	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   39	85	141	android/database/sqlite/SQLiteException
    //   39	85	185	finally
    //   87	121	200	finally
    //   145	172	200	finally
    //   87	121	204	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public List<ap> B(int paramInt)
  {
    // Byte code:
    //   0: new 238	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 239	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: ldc_w 280
    //   12: invokespecial 135	com/google/android/gms/tagmanager/ca:S	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +7 -> 26
    //   22: aload_3
    //   23: astore_3
    //   24: aload_3
    //   25: areturn
    //   26: aconst_null
    //   27: astore_2
    //   28: iconst_3
    //   29: anewarray 45	java/lang/String
    //   32: astore 5
    //   34: aload 5
    //   36: iconst_0
    //   37: ldc 35
    //   39: aastore
    //   40: aload 5
    //   42: iconst_1
    //   43: ldc 37
    //   45: aastore
    //   46: aload 5
    //   48: iconst_2
    //   49: ldc 41
    //   51: aastore
    //   52: iconst_1
    //   53: anewarray 4	java/lang/Object
    //   56: astore 6
    //   58: aload 6
    //   60: iconst_0
    //   61: ldc 35
    //   63: aastore
    //   64: aload 4
    //   66: ldc 33
    //   68: aload 5
    //   70: aconst_null
    //   71: aconst_null
    //   72: aconst_null
    //   73: aconst_null
    //   74: ldc 245
    //   76: aload 6
    //   78: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   81: iload_1
    //   82: invokestatic 248	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   85: invokevirtual 252	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore_2
    //   89: aload_2
    //   90: astore_2
    //   91: new 238	java/util/ArrayList
    //   94: dup
    //   95: invokespecial 239	java/util/ArrayList:<init>	()V
    //   98: astore_3
    //   99: aload_2
    //   100: invokeinterface 258 1 0
    //   105: ifeq +51 -> 156
    //   108: aload_3
    //   109: new 282	com/google/android/gms/tagmanager/ap
    //   112: dup
    //   113: aload_2
    //   114: iconst_0
    //   115: invokeinterface 262 2 0
    //   120: aload_2
    //   121: iconst_1
    //   122: invokeinterface 262 2 0
    //   127: aload_2
    //   128: iconst_2
    //   129: invokeinterface 262 2 0
    //   134: invokespecial 285	com/google/android/gms/tagmanager/ap:<init>	(JJJ)V
    //   137: invokeinterface 266 2 0
    //   142: pop
    //   143: aload_2
    //   144: invokeinterface 269 1 0
    //   149: istore 5
    //   151: iload 5
    //   153: ifne -45 -> 108
    //   156: aload_2
    //   157: ifnull +9 -> 166
    //   160: aload_2
    //   161: invokeinterface 272 1 0
    //   166: iconst_2
    //   167: anewarray 45	java/lang/String
    //   170: astore 6
    //   172: aload 6
    //   174: iconst_0
    //   175: ldc 35
    //   177: aastore
    //   178: aload 6
    //   180: iconst_1
    //   181: ldc 39
    //   183: aastore
    //   184: iconst_1
    //   185: anewarray 4	java/lang/Object
    //   188: astore 5
    //   190: aload 5
    //   192: iconst_0
    //   193: ldc 35
    //   195: aastore
    //   196: aload 4
    //   198: ldc 33
    //   200: aload 6
    //   202: aconst_null
    //   203: aconst_null
    //   204: aconst_null
    //   205: aconst_null
    //   206: ldc 245
    //   208: aload 5
    //   210: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   213: iload_1
    //   214: invokestatic 248	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   217: invokevirtual 252	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   220: astore_2
    //   221: aload_2
    //   222: invokeinterface 258 1 0
    //   227: ifeq +59 -> 286
    //   230: iconst_0
    //   231: istore 5
    //   233: aload_2
    //   234: checkcast 287	android/database/sqlite/SQLiteCursor
    //   237: invokevirtual 291	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   240: invokevirtual 296	android/database/CursorWindow:getNumRows	()I
    //   243: ifle +119 -> 362
    //   246: aload_3
    //   247: iload 5
    //   249: invokeinterface 300 2 0
    //   254: checkcast 282	com/google/android/gms/tagmanager/ap
    //   257: aload_2
    //   258: iconst_1
    //   259: invokeinterface 303 2 0
    //   264: invokevirtual 306	com/google/android/gms/tagmanager/ap:R	(Ljava/lang/String;)V
    //   267: iload 5
    //   269: iconst_1
    //   270: iadd
    //   271: istore 5
    //   273: aload_2
    //   274: invokeinterface 269 1 0
    //   279: istore 4
    //   281: iload 4
    //   283: ifne +304 -> 587
    //   286: aload_2
    //   287: ifnull +9 -> 296
    //   290: aload_2
    //   291: invokeinterface 272 1 0
    //   296: aload_3
    //   297: astore_3
    //   298: goto -274 -> 24
    //   301: astore_2
    //   302: aload_2
    //   303: astore 4
    //   305: aconst_null
    //   306: astore_2
    //   307: aload_3
    //   308: astore_3
    //   309: new 161	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 274
    //   319: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 4
    //   324: invokevirtual 277	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   327: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 118	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   336: aload_2
    //   337: ifnull -313 -> 24
    //   340: aload_2
    //   341: invokeinterface 272 1 0
    //   346: goto -322 -> 24
    //   349: astore_3
    //   350: aload_2
    //   351: ifnull +9 -> 360
    //   354: aload_2
    //   355: invokeinterface 272 1 0
    //   360: aload_3
    //   361: athrow
    //   362: iconst_1
    //   363: anewarray 4	java/lang/Object
    //   366: astore 4
    //   368: aload 4
    //   370: iconst_0
    //   371: aload_3
    //   372: iload 5
    //   374: invokeinterface 300 2 0
    //   379: checkcast 282	com/google/android/gms/tagmanager/ap
    //   382: invokevirtual 310	com/google/android/gms/tagmanager/ap:dg	()J
    //   385: invokestatic 144	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   388: aastore
    //   389: ldc_w 312
    //   392: aload 4
    //   394: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   397: invokestatic 118	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   400: goto -133 -> 267
    //   403: astore 4
    //   405: aload_2
    //   406: astore_2
    //   407: new 161	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 314
    //   417: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload 4
    //   422: invokevirtual 277	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   425: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 118	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   434: new 238	java/util/ArrayList
    //   437: dup
    //   438: invokespecial 239	java/util/ArrayList:<init>	()V
    //   441: astore 4
    //   443: iconst_0
    //   444: istore 5
    //   446: aload_3
    //   447: invokeinterface 318 1 0
    //   452: astore_3
    //   453: aload_3
    //   454: invokeinterface 323 1 0
    //   459: ifeq +34 -> 493
    //   462: aload_3
    //   463: invokeinterface 327 1 0
    //   468: checkcast 282	com/google/android/gms/tagmanager/ap
    //   471: astore 7
    //   473: aload 7
    //   475: invokevirtual 330	com/google/android/gms/tagmanager/ap:lJ	()Ljava/lang/String;
    //   478: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   481: istore 6
    //   483: iload 6
    //   485: ifeq +27 -> 512
    //   488: iload 5
    //   490: ifeq +19 -> 509
    //   493: aload_2
    //   494: ifnull +9 -> 503
    //   497: aload_2
    //   498: invokeinterface 272 1 0
    //   503: aload 4
    //   505: astore_3
    //   506: goto -482 -> 24
    //   509: iconst_1
    //   510: istore 5
    //   512: aload 4
    //   514: aload 7
    //   516: invokeinterface 266 2 0
    //   521: pop
    //   522: goto -69 -> 453
    //   525: astore_3
    //   526: aload_2
    //   527: ifnull +9 -> 536
    //   530: aload_2
    //   531: invokeinterface 272 1 0
    //   536: aload_3
    //   537: athrow
    //   538: astore_3
    //   539: aload_2
    //   540: astore_2
    //   541: goto -15 -> 526
    //   544: astore 4
    //   546: goto -139 -> 407
    //   549: astore_3
    //   550: aload_2
    //   551: astore_2
    //   552: goto -202 -> 350
    //   555: astore_3
    //   556: aload_2
    //   557: astore_2
    //   558: goto -208 -> 350
    //   561: astore 4
    //   563: aload 4
    //   565: astore 4
    //   567: aload_2
    //   568: astore_2
    //   569: aload_3
    //   570: astore_3
    //   571: goto -262 -> 309
    //   574: astore 4
    //   576: aload 4
    //   578: astore 4
    //   580: aload_2
    //   581: astore_2
    //   582: aload_3
    //   583: astore_3
    //   584: goto -275 -> 309
    //   587: iload 5
    //   589: istore 5
    //   591: goto -358 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	ca
    //   0	594	1	paramInt	int
    //   27	264	2	localCursor	Cursor
    //   301	2	2	localSQLiteException1	SQLiteException
    //   306	276	2	localObject1	Object
    //   7	302	3	localArrayList1	java.util.ArrayList
    //   349	98	3	localObject2	Object
    //   452	54	3	localObject3	Object
    //   525	12	3	localObject4	Object
    //   538	1	3	localObject5	Object
    //   549	1	3	localObject6	Object
    //   555	15	3	localObject7	Object
    //   570	14	3	localObject8	Object
    //   15	182	4	localSQLiteDatabase	SQLiteDatabase
    //   279	3	4	bool1	boolean
    //   303	90	4	localObject9	Object
    //   403	18	4	localSQLiteException2	SQLiteException
    //   441	72	4	localArrayList2	java.util.ArrayList
    //   544	1	4	localSQLiteException3	SQLiteException
    //   561	3	4	localSQLiteException4	SQLiteException
    //   565	1	4	localSQLiteException5	SQLiteException
    //   574	3	4	localSQLiteException6	SQLiteException
    //   578	1	4	localSQLiteException7	SQLiteException
    //   32	37	5	arrayOfString	String[]
    //   149	3	5	bool2	boolean
    //   188	21	5	arrayOfObject	Object[]
    //   231	359	5	i	int
    //   56	145	6	localObject10	Object
    //   481	3	6	bool3	boolean
    //   471	44	7	localap	ap
    // Exception table:
    //   from	to	target	type
    //   28	89	301	android/database/sqlite/SQLiteException
    //   28	89	349	finally
    //   221	281	403	android/database/sqlite/SQLiteException
    //   362	400	403	android/database/sqlite/SQLiteException
    //   166	221	525	finally
    //   407	483	525	finally
    //   512	522	525	finally
    //   221	281	538	finally
    //   362	400	538	finally
    //   166	221	544	android/database/sqlite/SQLiteException
    //   91	99	549	finally
    //   99	151	549	finally
    //   309	336	555	finally
    //   91	99	561	android/database/sqlite/SQLiteException
    //   99	151	574	android/database/sqlite/SQLiteException
  }
  
  void a(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
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
        ((SQLiteDatabase)localObject1).delete("gtm_hits", (String)localObject2, paramArrayOfString);
        localObject1 = this.agp;
        if (jdMethod_do() != 0) {
          break label100;
        }
        ((au)localObject1).s(bool);
      }
      catch (SQLiteException localSQLiteException)
      {
        bh.D("Error deleting hits");
      }
      break;
      label100:
      bool = false;
    }
  }
  
  public void cl()
  {
    bh.C("GTM Dispatch running...");
    if (this.ago.cx())
    {
      List localList = B(40);
      if (!localList.isEmpty())
      {
        this.ago.g(localList);
        if (lW() > 0) {
          cx.mL().cl();
        }
      }
      else
      {
        bh.C("...nothing to dispatch");
        this.agp.s(true);
      }
    }
  }
  
  int dn()
  {
    boolean bool = true;
    int i = 0;
    long l = this.aec.currentTimeMillis();
    au localau1;
    if (l > 86400000L + this.wR)
    {
      this.wR = l;
      SQLiteDatabase localSQLiteDatabase = S("Error opening database for deleteStaleHits.");
      if (localSQLiteDatabase != null)
      {
        l = this.aec.currentTimeMillis() - 2592000000L;
        String[] arrayOfString = new String[bool];
        arrayOfString[i] = Long.toString(l);
        au localau2 = localSQLiteDatabase.delete("gtm_hits", "HIT_TIME < ?", arrayOfString);
        localau1 = this.agp;
        if (jdMethod_do() != 0) {
          bool = false;
        }
        localau1.s(bool);
        localau1 = localau2;
      }
    }
    return localau1;
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
        localCursor = localSQLiteDatabase.rawQuery("SELECT COUNT(*) from gtm_hits", null);
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
        bh.D("Error getting numStoredHits");
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
  
  public void f(long paramLong, String paramString)
  {
    dn();
    dm();
    g(paramLong, paramString);
  }
  
  /* Error */
  int lW()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: ldc 133
    //   7: invokespecial 135	com/google/android/gms/tagmanager/ca:S	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +5 -> 17
    //   15: iload_3
    //   16: ireturn
    //   17: iconst_2
    //   18: anewarray 45	java/lang/String
    //   21: astore_3
    //   22: aload_3
    //   23: iconst_0
    //   24: ldc 35
    //   26: aastore
    //   27: aload_3
    //   28: iconst_1
    //   29: ldc 41
    //   31: aastore
    //   32: aload_2
    //   33: ldc 33
    //   35: aload_3
    //   36: ldc_w 421
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 424	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_1
    //   47: aload_1
    //   48: invokeinterface 427 1 0
    //   53: istore_2
    //   54: iload_2
    //   55: istore_2
    //   56: aload_1
    //   57: ifnull +9 -> 66
    //   60: aload_1
    //   61: invokeinterface 272 1 0
    //   66: iload_2
    //   67: istore_3
    //   68: goto -53 -> 15
    //   71: pop
    //   72: aconst_null
    //   73: astore_1
    //   74: ldc_w 429
    //   77: invokestatic 118	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: ifnull +47 -> 128
    //   84: aload_1
    //   85: invokeinterface 272 1 0
    //   90: iconst_0
    //   91: istore_2
    //   92: goto -26 -> 66
    //   95: astore_2
    //   96: aload_1
    //   97: ifnull +9 -> 106
    //   100: aload_1
    //   101: invokeinterface 272 1 0
    //   106: aload_2
    //   107: athrow
    //   108: astore_2
    //   109: aload_1
    //   110: astore_1
    //   111: goto -15 -> 96
    //   114: astore_2
    //   115: aload_1
    //   116: astore_1
    //   117: aload_2
    //   118: astore_2
    //   119: goto -23 -> 96
    //   122: pop
    //   123: aload_1
    //   124: astore_1
    //   125: goto -51 -> 74
    //   128: iconst_0
    //   129: istore_2
    //   130: goto -64 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	ca
    //   3	122	1	localCursor	Cursor
    //   10	23	2	localSQLiteDatabase	SQLiteDatabase
    //   53	39	2	arrayOfString1	String[]
    //   95	12	2	localObject1	Object
    //   108	1	2	localObject2	Object
    //   114	4	2	localObject3	Object
    //   118	1	2	localObject4	Object
    //   129	1	2	i	int
    //   1	15	3	j	int
    //   21	47	3	arrayOfString2	String[]
    //   71	1	11	localSQLiteException1	SQLiteException
    //   122	1	12	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   17	47	71	android/database/sqlite/SQLiteException
    //   17	47	95	finally
    //   47	54	108	finally
    //   74	80	114	finally
    //   47	54	122	android/database/sqlite/SQLiteException
  }
  
  class b
    extends SQLiteOpenHelper
  {
    private boolean wU;
    private long wV = 0L;
    
    b(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private void a(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = localCursor.getColumnNames();
        for (int i = 0; i < arrayOfString.length; i++) {
          localHashSet.add(arrayOfString[i]);
        }
        localCursor.close();
        if ((!localHashSet.remove("hit_id")) || (!localHashSet.remove("hit_url")) || (!localHashSet.remove("hit_time")) || (!localHashSet.remove("hit_first_send_time"))) {
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
      //   3: anewarray 81	java/lang/String
      //   6: astore 4
      //   8: aload 4
      //   10: iconst_0
      //   11: ldc 83
      //   13: aastore
      //   14: iconst_1
      //   15: anewarray 81	java/lang/String
      //   18: astore 5
      //   20: aload 5
      //   22: iconst_0
      //   23: aload_1
      //   24: aastore
      //   25: aload_2
      //   26: ldc 85
      //   28: aload 4
      //   30: ldc 87
      //   32: aload 5
      //   34: aconst_null
      //   35: aconst_null
      //   36: aconst_null
      //   37: invokevirtual 91	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   40: astore_3
      //   41: aload_3
      //   42: invokeinterface 94 1 0
      //   47: istore 4
      //   49: iload 4
      //   51: istore 4
      //   53: aload_3
      //   54: ifnull +9 -> 63
      //   57: aload_3
      //   58: invokeinterface 54 1 0
      //   63: iload 4
      //   65: ireturn
      //   66: pop
      //   67: aconst_null
      //   68: astore_3
      //   69: new 96	java/lang/StringBuilder
      //   72: dup
      //   73: invokespecial 97	java/lang/StringBuilder:<init>	()V
      //   76: ldc 99
      //   78: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   81: aload_1
      //   82: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   85: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   88: invokestatic 112	com/google/android/gms/tagmanager/bh:D	(Ljava/lang/String;)V
      //   91: aload_3
      //   92: ifnull +9 -> 101
      //   95: aload_3
      //   96: invokeinterface 54 1 0
      //   101: iconst_0
      //   102: istore 4
      //   104: goto -41 -> 63
      //   107: astore 4
      //   109: aload_3
      //   110: ifnull +9 -> 119
      //   113: aload_3
      //   114: invokeinterface 54 1 0
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
      //   0	146	0	this	b
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
      if ((this.wU) && (3600000L + this.wV > ca.a(ca.this).currentTimeMillis())) {
        throw new SQLiteException("Database creation failed");
      }
      SQLiteDatabase localSQLiteDatabase = null;
      this.wU = true;
      this.wV = ca.a(ca.this).currentTimeMillis();
      try
      {
        localSQLiteDatabase = super.getWritableDatabase();
        localSQLiteDatabase = localSQLiteDatabase;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          ca.c(ca.this).getDatabasePath(ca.b(ca.this)).delete();
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
          if (!a("gtm_hits", paramSQLiteDatabase))
          {
            paramSQLiteDatabase.execSQL(ca.lX());
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
  
  class a
    implements da.a
  {
    a() {}
    
    public void a(ap paramap)
    {
      ca.a(ca.this, paramap.dg());
    }
    
    public void b(ap paramap)
    {
      ca.a(ca.this, paramap.dg());
      bh.C("Permanent failure dispatching hitId: " + paramap.dg());
    }
    
    public void c(ap paramap)
    {
      long l = paramap.lI();
      if (l != 0L)
      {
        if (l + 14400000L < ca.a(ca.this).currentTimeMillis())
        {
          ca.a(ca.this, paramap.dg());
          bh.C("Giving up on failed hitId: " + paramap.dg());
        }
      }
      else {
        ca.a(ca.this, paramap.dg(), ca.a(ca.this).currentTimeMillis());
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ca
 * JD-Core Version:    0.7.0.1
 */