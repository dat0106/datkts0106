package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
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
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

class PersistentAnalyticsStore
  implements AnalyticsStore
{
  @VisibleForTesting
  static final String BACKEND_LIBRARY_VERSION = "";
  private static final String CREATE_HITS_TABLE;
  private static final String DATABASE_FILENAME = "google_analytics_v2.db";
  @VisibleForTesting
  static final String HITS_TABLE = "hits2";
  @VisibleForTesting
  static final String HIT_APP_ID = "hit_app_id";
  @VisibleForTesting
  static final String HIT_ID = "hit_id";
  @VisibleForTesting
  static final String HIT_STRING = "hit_string";
  @VisibleForTesting
  static final String HIT_TIME = "hit_time";
  @VisibleForTesting
  static final String HIT_URL = "hit_url";
  private Clock mClock;
  private final Context mContext;
  private final String mDatabaseName;
  private final AnalyticsDatabaseHelper mDbHelper;
  private volatile Dispatcher mDispatcher;
  private long mLastDeleteStaleHitsTime;
  private final AnalyticsStoreStateListener mListener;
  
  static
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = "hits2";
    arrayOfObject[1] = "hit_id";
    arrayOfObject[2] = "hit_time";
    arrayOfObject[3] = "hit_url";
    arrayOfObject[4] = "hit_string";
    arrayOfObject[5] = "hit_app_id";
    CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", arrayOfObject);
  }
  
  PersistentAnalyticsStore(AnalyticsStoreStateListener paramAnalyticsStoreStateListener, Context paramContext)
  {
    this(paramAnalyticsStoreStateListener, paramContext, "google_analytics_v2.db");
  }
  
  @VisibleForTesting
  PersistentAnalyticsStore(AnalyticsStoreStateListener paramAnalyticsStoreStateListener, Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mDatabaseName = paramString;
    this.mListener = paramAnalyticsStoreStateListener;
    this.mClock = new Clock()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
    };
    this.mDbHelper = new AnalyticsDatabaseHelper(this.mContext, this.mDatabaseName);
    this.mDispatcher = new SimpleNetworkDispatcher(this, createDefaultHttpClientFactory(), this.mContext);
    this.mLastDeleteStaleHitsTime = 0L;
  }
  
  private HttpClientFactory createDefaultHttpClientFactory()
  {
    new HttpClientFactory()
    {
      public HttpClient newInstance()
      {
        return new DefaultHttpClient();
      }
    };
  }
  
  private void fillVersionParametersIfNecessary(Map<String, String> paramMap, Collection<Command> paramCollection)
  {
    Object localObject = paramCollection.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Command localCommand = (Command)((Iterator)localObject).next();
      if (localCommand.getId().equals("appendVersion"))
      {
        localObject = localCommand.getValue();
        storeVersion(paramMap, localCommand.getUrlParam(), (String)localObject);
      }
    }
  }
  
  public static String generateHitString(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return TextUtils.join("&", localArrayList);
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add((String)localEntry.getKey() + "=" + HitBuilder.encode((String)localEntry.getValue()));
    }
  }
  
  private SQLiteDatabase getWritableDatabase(String paramString)
  {
    try
    {
      localSQLiteDatabase = this.mDbHelper.getWritableDatabase();
      localSQLiteDatabase = localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        Log.w(paramString);
        SQLiteDatabase localSQLiteDatabase = null;
      }
    }
    return localSQLiteDatabase;
  }
  
  private void removeOldHitIfFull()
  {
    int i = 1 + (-2000 + getNumStoredHits());
    if (i > 0)
    {
      List localList = peekHits(i);
      Log.wDebug("Store full, deleting " + localList.size() + " hits to make room");
      deleteHits(localList);
    }
  }
  
  private void storeVersion(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    String str;
    if (paramString2 != null) {
      str = paramString2 + "";
    } else {
      str = "";
    }
    if (paramString1 != null) {
      paramMap.put(paramString1, str);
    }
  }
  
  private void writeHitToDatabase(Map<String, String> paramMap, long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for putHit");
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("hit_string", generateHitString(paramMap));
      localContentValues.put("hit_time", Long.valueOf(paramLong));
      long l = 0L;
      if (paramMap.containsKey("AppUID")) {}
      try
      {
        l = Long.parseLong((String)paramMap.get("AppUID"));
        l = l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label84:
        break label84;
      }
      localContentValues.put("hit_app_id", Long.valueOf(l));
      if (paramString == null) {
        paramString = "http://www.google-analytics.com/collect";
      }
      if (paramString.length() == 0)
      {
        Log.w("empty path: not sending hit");
      }
      else
      {
        localContentValues.put("hit_url", paramString);
        try
        {
          localSQLiteDatabase.insert("hits2", null, localContentValues);
          this.mListener.reportStoreIsEmpty(false);
        }
        catch (SQLiteException localSQLiteException)
        {
          Log.w("Error storing hit");
        }
      }
    }
  }
  
  public void clearHits(long paramLong)
  {
    boolean bool = true;
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for clearHits");
    if (localSQLiteDatabase != null)
    {
      if (paramLong != 0L)
      {
        localObject = new String[bool];
        localObject[0] = Long.valueOf(paramLong).toString();
        localSQLiteDatabase.delete("hits2", "hit_app_id = ?", (String[])localObject);
      }
      else
      {
        localSQLiteDatabase.delete("hits2", null, null);
      }
      Object localObject = this.mListener;
      if (getNumStoredHits() != 0) {
        bool = false;
      }
      ((AnalyticsStoreStateListener)localObject).reportStoreIsEmpty(bool);
    }
  }
  
  public void close()
  {
    try
    {
      this.mDbHelper.getWritableDatabase().close();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      for (;;)
      {
        Log.w("Error opening database for close");
      }
    }
  }
  
  public void deleteHits(Collection<Hit> paramCollection)
  {
    if (paramCollection == null) {
      throw new NullPointerException("hits cannot be null");
    }
    if (paramCollection.isEmpty()) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = getWritableDatabase("Error opening database for deleteHit");
    } while (localSQLiteDatabase == null);
    Object localObject1 = new String[paramCollection.size()];
    Object localObject2 = new Object[1];
    localObject2[0] = TextUtils.join(",", Collections.nCopies(localObject1.length, "?"));
    String str = String.format("HIT_ID in (%s)", (Object[])localObject2);
    int j = 0;
    localObject2 = paramCollection.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Hit localHit = (Hit)((Iterator)localObject2).next();
      int i = j + 1;
      localObject1[j] = Long.toString(localHit.getHitId());
      j = i;
    }
    for (;;)
    {
      try
      {
        localSQLiteDatabase.delete("hits2", str, (String[])localObject1);
        localObject1 = this.mListener;
        if (getNumStoredHits() != 0) {
          break label201;
        }
        bool = true;
        ((AnalyticsStoreStateListener)localObject1).reportStoreIsEmpty(bool);
      }
      catch (SQLiteException localSQLiteException)
      {
        Log.w("Error deleting hit " + paramCollection);
      }
      break;
      label201:
      boolean bool = false;
    }
  }
  
  int deleteStaleHits()
  {
    boolean bool = true;
    int i = 0;
    long l = this.mClock.currentTimeMillis();
    if (l > 86400000L + this.mLastDeleteStaleHitsTime)
    {
      this.mLastDeleteStaleHitsTime = l;
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for deleteStaleHits");
      if (localSQLiteDatabase != null)
      {
        l = this.mClock.currentTimeMillis() - 2592000000L;
        String[] arrayOfString = new String[bool];
        arrayOfString[i] = Long.toString(l);
        i = localSQLiteDatabase.delete("hits2", "HIT_TIME < ?", arrayOfString);
        AnalyticsStoreStateListener localAnalyticsStoreStateListener = this.mListener;
        if (getNumStoredHits() != 0) {
          bool = false;
        }
        localAnalyticsStoreStateListener.reportStoreIsEmpty(bool);
        i = i;
      }
    }
    return i;
  }
  
  public void dispatch()
  {
    Log.vDebug("dispatch running...");
    if (this.mDispatcher.okToDispatch())
    {
      List localList = peekHits(40);
      if (!localList.isEmpty())
      {
        int i = this.mDispatcher.dispatchHits(localList);
        Log.vDebug("sent " + i + " of " + localList.size() + " hits");
        deleteHits(localList.subList(0, Math.min(i, localList.size())));
        if ((i == localList.size()) && (getNumStoredHits() > 0)) {
          GAServiceManager.getInstance().dispatch();
        }
      }
      else
      {
        Log.vDebug("...nothing to dispatch");
        this.mListener.reportStoreIsEmpty(true);
      }
    }
  }
  
  @VisibleForTesting
  public AnalyticsDatabaseHelper getDbHelper()
  {
    return this.mDbHelper;
  }
  
  @VisibleForTesting
  AnalyticsDatabaseHelper getHelper()
  {
    return this.mDbHelper;
  }
  
  int getNumStoredHits()
  {
    int j = 0;
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for requestNumHitsPending");
    if (localSQLiteDatabase == null) {}
    for (int i = 0;; localCursor1 = localCursor2)
    {
      return i;
      Cursor localCursor1 = null;
      try
      {
        localCursor1 = localSQLiteDatabase.rawQuery("SELECT COUNT(*) from hits2", null);
        if (localCursor1.moveToFirst())
        {
          long l = localCursor1.getLong(0);
          localCursor2 = (int)l;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          Cursor localCursor2;
          Log.w("Error getting numStoredHits");
          if (localCursor1 != null) {
            localCursor1.close();
          }
        }
      }
      finally
      {
        if (localCursor1 == null) {
          break;
        }
        localCursor1.close();
      }
    }
  }
  
  /* Error */
  public List<Hit> peekHits(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 450
    //   4: invokespecial 263	com/google/analytics/tracking/android/PersistentAnalyticsStore:getWritableDatabase	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnonnull +13 -> 24
    //   14: new 161	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 451	java/util/ArrayList:<init>	()V
    //   21: astore_3
    //   22: aload_3
    //   23: areturn
    //   24: aconst_null
    //   25: astore_2
    //   26: new 161	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 451	java/util/ArrayList:<init>	()V
    //   33: pop
    //   34: iconst_3
    //   35: anewarray 59	java/lang/String
    //   38: astore_3
    //   39: aload_3
    //   40: iconst_0
    //   41: ldc 31
    //   43: aastore
    //   44: aload_3
    //   45: iconst_1
    //   46: ldc 37
    //   48: aastore
    //   49: aload_3
    //   50: iconst_2
    //   51: ldc 40
    //   53: aastore
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: astore 5
    //   60: aload 5
    //   62: iconst_0
    //   63: ldc 40
    //   65: aastore
    //   66: aload 5
    //   68: iconst_1
    //   69: ldc 31
    //   71: aastore
    //   72: aload 4
    //   74: ldc 25
    //   76: aload_3
    //   77: aconst_null
    //   78: aconst_null
    //   79: aconst_null
    //   80: aconst_null
    //   81: ldc_w 453
    //   84: aload 5
    //   86: invokestatic 63	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   89: iload_1
    //   90: invokestatic 458	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   93: invokevirtual 462	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   96: astore_2
    //   97: new 161	java/util/ArrayList
    //   100: dup
    //   101: invokespecial 451	java/util/ArrayList:<init>	()V
    //   104: astore_3
    //   105: aload_2
    //   106: invokeinterface 441 1 0
    //   111: ifeq +61 -> 172
    //   114: new 357	com/google/analytics/tracking/android/Hit
    //   117: dup
    //   118: aconst_null
    //   119: aload_2
    //   120: iconst_0
    //   121: invokeinterface 445 2 0
    //   126: aload_2
    //   127: iconst_1
    //   128: invokeinterface 445 2 0
    //   133: invokespecial 465	com/google/analytics/tracking/android/Hit:<init>	(Ljava/lang/String;JJ)V
    //   136: astore 5
    //   138: aload 5
    //   140: aload_2
    //   141: iconst_2
    //   142: invokeinterface 468 2 0
    //   147: invokevirtual 471	com/google/analytics/tracking/android/Hit:setHitUrl	(Ljava/lang/String;)V
    //   150: aload_3
    //   151: aload 5
    //   153: invokeinterface 215 2 0
    //   158: pop
    //   159: aload_2
    //   160: invokeinterface 474 1 0
    //   165: istore 5
    //   167: iload 5
    //   169: ifne -55 -> 114
    //   172: aload_2
    //   173: ifnull +9 -> 182
    //   176: aload_2
    //   177: invokeinterface 446 1 0
    //   182: iconst_0
    //   183: istore 5
    //   185: iconst_2
    //   186: anewarray 59	java/lang/String
    //   189: astore 6
    //   191: aload 6
    //   193: iconst_0
    //   194: ldc 31
    //   196: aastore
    //   197: aload 6
    //   199: iconst_1
    //   200: ldc 34
    //   202: aastore
    //   203: iconst_1
    //   204: anewarray 4	java/lang/Object
    //   207: astore 7
    //   209: aload 7
    //   211: iconst_0
    //   212: ldc 31
    //   214: aastore
    //   215: aload 4
    //   217: ldc 25
    //   219: aload 6
    //   221: aconst_null
    //   222: aconst_null
    //   223: aconst_null
    //   224: aconst_null
    //   225: ldc_w 476
    //   228: aload 7
    //   230: invokestatic 63	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   233: iload_1
    //   234: invokestatic 458	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   237: invokevirtual 462	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   240: astore_2
    //   241: aload_2
    //   242: invokeinterface 441 1 0
    //   247: ifeq +60 -> 307
    //   250: aload_2
    //   251: instanceof 478
    //   254: ifeq +284 -> 538
    //   257: aload_2
    //   258: checkcast 478	android/database/sqlite/SQLiteCursor
    //   261: invokevirtual 482	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   264: invokevirtual 487	android/database/CursorWindow:getNumRows	()I
    //   267: ifle +119 -> 386
    //   270: aload_3
    //   271: iload 5
    //   273: invokeinterface 490 2 0
    //   278: checkcast 357	com/google/analytics/tracking/android/Hit
    //   281: aload_2
    //   282: iconst_1
    //   283: invokeinterface 468 2 0
    //   288: invokevirtual 493	com/google/analytics/tracking/android/Hit:setHitString	(Ljava/lang/String;)V
    //   291: iinc 5 1
    //   294: aload_2
    //   295: invokeinterface 474 1 0
    //   300: istore 4
    //   302: iload 4
    //   304: ifne -54 -> 250
    //   307: aload_2
    //   308: ifnull -286 -> 22
    //   311: aload_2
    //   312: invokeinterface 446 1 0
    //   317: goto -295 -> 22
    //   320: astore 4
    //   322: new 189	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 495
    //   332: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 4
    //   337: invokevirtual 498	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   340: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 228	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   349: pop
    //   350: new 161	java/util/ArrayList
    //   353: dup
    //   354: invokespecial 451	java/util/ArrayList:<init>	()V
    //   357: astore_3
    //   358: aload_2
    //   359: ifnull -337 -> 22
    //   362: aload_2
    //   363: invokeinterface 446 1 0
    //   368: goto -346 -> 22
    //   371: astore 4
    //   373: aload_2
    //   374: ifnull +9 -> 383
    //   377: aload_2
    //   378: invokeinterface 446 1 0
    //   383: aload 4
    //   385: athrow
    //   386: new 189	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   393: ldc_w 500
    //   396: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_3
    //   400: iload 5
    //   402: invokeinterface 490 2 0
    //   407: checkcast 357	com/google/analytics/tracking/android/Hit
    //   410: invokevirtual 361	com/google/analytics/tracking/android/Hit:getHitId	()J
    //   413: invokevirtual 503	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   416: ldc_w 505
    //   419: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 228	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   428: pop
    //   429: goto -138 -> 291
    //   432: astore 4
    //   434: new 189	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   441: ldc_w 507
    //   444: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 4
    //   449: invokevirtual 498	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   452: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 228	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   461: pop
    //   462: new 161	java/util/ArrayList
    //   465: dup
    //   466: invokespecial 451	java/util/ArrayList:<init>	()V
    //   469: astore 5
    //   471: iconst_0
    //   472: istore 4
    //   474: aload_3
    //   475: invokeinterface 508 1 0
    //   480: astore 7
    //   482: aload 7
    //   484: invokeinterface 132 1 0
    //   489: ifeq +33 -> 522
    //   492: aload 7
    //   494: invokeinterface 136 1 0
    //   499: checkcast 357	com/google/analytics/tracking/android/Hit
    //   502: astore 6
    //   504: aload 6
    //   506: invokevirtual 511	com/google/analytics/tracking/android/Hit:getHitParams	()Ljava/lang/String;
    //   509: invokestatic 514	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   512: istore_3
    //   513: iload_3
    //   514: ifeq +64 -> 578
    //   517: iload 4
    //   519: ifeq +56 -> 575
    //   522: aload_2
    //   523: ifnull +9 -> 532
    //   526: aload_2
    //   527: invokeinterface 446 1 0
    //   532: aload 5
    //   534: astore_3
    //   535: goto -513 -> 22
    //   538: aload_3
    //   539: iload 5
    //   541: invokeinterface 490 2 0
    //   546: checkcast 357	com/google/analytics/tracking/android/Hit
    //   549: aload_2
    //   550: iconst_1
    //   551: invokeinterface 468 2 0
    //   556: invokevirtual 493	com/google/analytics/tracking/android/Hit:setHitString	(Ljava/lang/String;)V
    //   559: goto -268 -> 291
    //   562: astore_3
    //   563: aload_2
    //   564: ifnull +9 -> 573
    //   567: aload_2
    //   568: invokeinterface 446 1 0
    //   573: aload_3
    //   574: athrow
    //   575: iconst_1
    //   576: istore 4
    //   578: aload 5
    //   580: aload 6
    //   582: invokeinterface 215 2 0
    //   587: pop
    //   588: goto -106 -> 482
    //   591: astore 4
    //   593: aload_3
    //   594: pop
    //   595: goto -222 -> 373
    //   598: astore 4
    //   600: aload_3
    //   601: pop
    //   602: goto -280 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	605	0	this	PersistentAnalyticsStore
    //   0	605	1	paramInt	int
    //   25	543	2	localCursor	Cursor
    //   21	454	3	localObject1	Object
    //   512	2	3	bool1	boolean
    //   534	5	3	localObject2	Object
    //   562	39	3	localObject3	Object
    //   7	209	4	localSQLiteDatabase	SQLiteDatabase
    //   300	3	4	bool2	boolean
    //   320	16	4	localSQLiteException1	SQLiteException
    //   371	13	4	localObject4	Object
    //   432	16	4	localSQLiteException2	SQLiteException
    //   472	105	4	i	int
    //   591	1	4	localObject5	Object
    //   598	1	4	localSQLiteException3	SQLiteException
    //   58	94	5	localObject6	Object
    //   165	236	5	j	int
    //   469	110	5	localArrayList	ArrayList
    //   189	392	6	localObject7	Object
    //   207	286	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   34	105	320	android/database/sqlite/SQLiteException
    //   34	105	371	finally
    //   322	358	371	finally
    //   185	302	432	android/database/sqlite/SQLiteException
    //   386	429	432	android/database/sqlite/SQLiteException
    //   538	559	432	android/database/sqlite/SQLiteException
    //   185	302	562	finally
    //   386	429	562	finally
    //   434	513	562	finally
    //   538	559	562	finally
    //   578	588	562	finally
    //   105	167	591	finally
    //   105	167	598	android/database/sqlite/SQLiteException
  }
  
  public void putHit(Map<String, String> paramMap, long paramLong, String paramString, Collection<Command> paramCollection)
  {
    deleteStaleHits();
    fillVersionParametersIfNecessary(paramMap, paramCollection);
    removeOldHitIfFull();
    writeHitToDatabase(paramMap, paramLong, paramString);
  }
  
  @VisibleForTesting
  public void setClock(Clock paramClock)
  {
    this.mClock = paramClock;
  }
  
  public void setDispatch(boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean) {
      localObject = new NoopDispatcher();
    } else {
      localObject = new SimpleNetworkDispatcher(this, createDefaultHttpClientFactory(), this.mContext);
    }
    this.mDispatcher = ((Dispatcher)localObject);
  }
  
  @VisibleForTesting
  void setDispatcher(Dispatcher paramDispatcher)
  {
    this.mDispatcher = paramDispatcher;
  }
  
  @VisibleForTesting
  void setLastDeleteStaleHitsTime(long paramLong)
  {
    this.mLastDeleteStaleHitsTime = paramLong;
  }
  
  @VisibleForTesting
  class AnalyticsDatabaseHelper
    extends SQLiteOpenHelper
  {
    private boolean mBadDatabase;
    private long mLastDatabaseCheckTime = 0L;
    
    AnalyticsDatabaseHelper(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private boolean tablePresent(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      localCursor = null;
      try
      {
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = "name";
        String[] arrayOfString1 = new String[1];
        arrayOfString1[0] = paramString;
        localCursor = paramSQLiteDatabase.query("SQLITE_MASTER", arrayOfString2, "name=?", arrayOfString1, null, null, null);
        bool = localCursor.moveToFirst();
        bool = bool;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          Log.w("error querying for table " + paramString);
          if (localCursor != null) {
            localCursor.close();
          }
          boolean bool = false;
        }
      }
      finally
      {
        if (localCursor == null) {
          break label118;
        }
        localCursor.close();
      }
      return bool;
    }
    
    private void validateColumnsPresent(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = localCursor.getColumnNames();
        for (int j = 0; j < arrayOfString.length; j++) {
          localHashSet.add(arrayOfString[j]);
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
      if (!localObject.remove("hit_app_id")) {}
      for (int i = 1; !localObject.isEmpty(); i = 0) {
        throw new SQLiteException("Database has extra columns");
      }
      if (i != 0) {
        paramSQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
      }
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      if ((this.mBadDatabase) && (3600000L + this.mLastDatabaseCheckTime > PersistentAnalyticsStore.this.mClock.currentTimeMillis())) {
        throw new SQLiteException("Database creation failed");
      }
      SQLiteDatabase localSQLiteDatabase = null;
      this.mBadDatabase = true;
      this.mLastDatabaseCheckTime = PersistentAnalyticsStore.this.mClock.currentTimeMillis();
      try
      {
        localSQLiteDatabase = super.getWritableDatabase();
        localSQLiteDatabase = localSQLiteDatabase;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          PersistentAnalyticsStore.this.mContext.getDatabasePath(PersistentAnalyticsStore.this.mDatabaseName).delete();
        }
      }
      if (localSQLiteDatabase == null) {
        localSQLiteDatabase = super.getWritableDatabase();
      }
      this.mBadDatabase = false;
      return localSQLiteDatabase;
    }
    
    boolean isBadDatabase()
    {
      return this.mBadDatabase;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      FutureApis.setOwnerOnlyReadWrite(paramSQLiteDatabase.getPath());
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
          if (!tablePresent("hits2", paramSQLiteDatabase))
          {
            paramSQLiteDatabase.execSQL(PersistentAnalyticsStore.CREATE_HITS_TABLE);
            return;
          }
        }
        finally
        {
          localCursor.close();
        }
        validateColumnsPresent(paramSQLiteDatabase);
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
    
    void setBadDatabase(boolean paramBoolean)
    {
      this.mBadDatabase = paramBoolean;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.PersistentAnalyticsStore
 * JD-Core Version:    0.7.0.1
 */