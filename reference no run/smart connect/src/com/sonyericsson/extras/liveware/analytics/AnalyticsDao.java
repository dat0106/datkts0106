package com.sonyericsson.extras.liveware.analytics;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import com.sonyericsson.extras.liveware.utils.Dbg;

class AnalyticsDao
{
  private final Context mContext;
  
  AnalyticsDao(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Hit getHit(String paramString1, String paramString2, String paramString3)
  {
    Cursor localCursor = null;
    label134:
    try
    {
      localObject1 = this.mContext.getContentResolver();
      Uri localUri = AnalyticsDef.HitTable.URI;
      String[] arrayOfString = new String[3];
      arrayOfString[0] = paramString1;
      arrayOfString[1] = paramString2;
      arrayOfString[2] = paramString3;
      localCursor = ((ContentResolver)localObject1).query(localUri, null, "category = ? AND action = ? AND label = ? ", arrayOfString, null);
      if ((localCursor == null) || (!localCursor.moveToFirst())) {
        break label137;
      }
      localObject1 = getHitFromCursor(localCursor);
      localObject1 = localObject1;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Object localObject1;
        Dbg.e(localSQLException);
        if (localCursor != null) {
          localCursor.close();
        }
        localObject2 = null;
      }
    }
    finally
    {
      if (localCursor == null) {
        break label134;
      }
      localCursor.close();
    }
    return localObject1;
    for (;;)
    {
      Object localObject2;
      label137:
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
  
  private static Hit getHitFromCursor(Cursor paramCursor)
  {
    return new Hit(paramCursor.getLong(paramCursor.getColumnIndexOrThrow("_id")), paramCursor.getString(paramCursor.getColumnIndexOrThrow("category")), paramCursor.getString(paramCursor.getColumnIndexOrThrow("action")), paramCursor.getString(paramCursor.getColumnIndexOrThrow("label")), paramCursor.getInt(paramCursor.getColumnIndexOrThrow("value")));
  }
  
  private Hit insertHit(Hit paramHit)
  {
    try
    {
      Uri localUri = this.mContext.getContentResolver().insert(AnalyticsDef.HitTable.URI, paramHit.getContentValues());
      if (localUri != null)
      {
        paramHit.setId(Long.parseLong(localUri.getLastPathSegment()));
        return paramHit;
      }
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Dbg.e(localSQLException);
        paramHit = null;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Dbg.e(localNumberFormatException);
      }
    }
  }
  
  private void updateHit(Hit paramHit)
  {
    try
    {
      ContentResolver localContentResolver = this.mContext.getContentResolver();
      Uri localUri = AnalyticsDef.HitTable.URI;
      ContentValues localContentValues = paramHit.getContentValues();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = Long.toString(paramHit.getId());
      localContentResolver.update(localUri, localContentValues, "_id = ?", arrayOfString);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Dbg.e(localSQLException);
      }
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  Hit addHit(Hit paramHit)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 137	com/sonyericsson/extras/liveware/analytics/Hit:getCategory	()Ljava/lang/String;
    //   7: aload_1
    //   8: invokevirtual 140	com/sonyericsson/extras/liveware/analytics/Hit:getAction	()Ljava/lang/String;
    //   11: aload_1
    //   12: invokevirtual 143	com/sonyericsson/extras/liveware/analytics/Hit:getLabel	()Ljava/lang/String;
    //   15: invokespecial 145	com/sonyericsson/extras/liveware/analytics/AnalyticsDao:getHit	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/sonyericsson/extras/liveware/analytics/Hit;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnonnull +15 -> 35
    //   23: aload_0
    //   24: aload_1
    //   25: invokespecial 147	com/sonyericsson/extras/liveware/analytics/AnalyticsDao:insertHit	(Lcom/sonyericsson/extras/liveware/analytics/Hit;)Lcom/sonyericsson/extras/liveware/analytics/Hit;
    //   28: astore_2
    //   29: aload_2
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: areturn
    //   35: aload_2
    //   36: aload_1
    //   37: invokevirtual 151	com/sonyericsson/extras/liveware/analytics/Hit:getValue	()I
    //   40: invokevirtual 155	com/sonyericsson/extras/liveware/analytics/Hit:incrementValue	(I)V
    //   43: aload_0
    //   44: aload_2
    //   45: invokespecial 157	com/sonyericsson/extras/liveware/analytics/AnalyticsDao:updateHit	(Lcom/sonyericsson/extras/liveware/analytics/Hit;)V
    //   48: goto -17 -> 31
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	AnalyticsDao
    //   0	56	1	paramHit	Hit
    //   18	27	2	localHit	Hit
    //   51	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	51	finally
    //   35	48	51	finally
  }
  
  /* Error */
  /**
   * @deprecated
   */
  Hit getHit(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: getfield 13	com/sonyericsson/extras/liveware/analytics/AnalyticsDao:mContext	Landroid/content/Context;
    //   8: invokevirtual 23	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   11: astore 4
    //   13: getstatic 29	com/sonyericsson/extras/liveware/analytics/AnalyticsDef$HitTable:URI	Landroid/net/Uri;
    //   16: astore 5
    //   18: iconst_1
    //   19: anewarray 31	java/lang/String
    //   22: astore 6
    //   24: aload 6
    //   26: iconst_0
    //   27: lload_1
    //   28: invokestatic 127	java/lang/Long:toString	(J)Ljava/lang/String;
    //   31: aastore
    //   32: aload 4
    //   34: aload 5
    //   36: aconst_null
    //   37: ldc 129
    //   39: aload 6
    //   41: aconst_null
    //   42: invokevirtual 39	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +78 -> 125
    //   50: aload_3
    //   51: invokeinterface 45 1 0
    //   56: ifeq +69 -> 125
    //   59: aload_3
    //   60: invokestatic 49	com/sonyericsson/extras/liveware/analytics/AnalyticsDao:getHitFromCursor	(Landroid/database/Cursor;)Lcom/sonyericsson/extras/liveware/analytics/Hit;
    //   63: astore 4
    //   65: aload 4
    //   67: astore 4
    //   69: aload_3
    //   70: ifnull +9 -> 79
    //   73: aload_3
    //   74: invokeinterface 52 1 0
    //   79: aload_0
    //   80: monitorexit
    //   81: aload 4
    //   83: areturn
    //   84: astore 4
    //   86: aload 4
    //   88: invokestatic 58	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/Throwable;)Z
    //   91: pop
    //   92: aload_3
    //   93: ifnull +42 -> 135
    //   96: aload_3
    //   97: invokeinterface 52 1 0
    //   102: goto +33 -> 135
    //   105: astore 4
    //   107: aload_3
    //   108: ifnull +9 -> 117
    //   111: aload_3
    //   112: invokeinterface 52 1 0
    //   117: aload 4
    //   119: athrow
    //   120: astore_3
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_3
    //   124: athrow
    //   125: aload_3
    //   126: ifnull +9 -> 135
    //   129: aload_3
    //   130: invokeinterface 52 1 0
    //   135: aconst_null
    //   136: astore 4
    //   138: goto -59 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	AnalyticsDao
    //   0	141	1	paramLong	long
    //   3	109	3	localCursor	Cursor
    //   120	10	3	localObject1	Object
    //   11	71	4	localObject2	Object
    //   84	3	4	localSQLException	SQLException
    //   105	13	4	localObject3	Object
    //   136	1	4	localObject4	Object
    //   16	19	5	localUri	Uri
    //   22	18	6	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   4	65	84	android/database/SQLException
    //   4	65	105	finally
    //   86	92	105	finally
    //   73	79	120	finally
    //   96	120	120	finally
    //   129	135	120	finally
  }
  
  /**
   * @deprecated
   */
  int getNumberOfHits()
  {
    Cursor localCursor = null;
    for (;;)
    {
      try
      {
        ContentResolver localContentResolver = this.mContext.getContentResolver();
        Uri localUri = AnalyticsDef.HitTable.URI;
        String[] arrayOfString = new String[1];
        arrayOfString[0] = "_id";
        localCursor = localContentResolver.query(localUri, arrayOfString, null, null, null);
        int i;
        if (localCursor != null)
        {
          i = localCursor.getCount();
          i = i;
          if (localCursor == null) {}
        }
        if (localObject1 == null) {
          break label112;
        }
      }
      catch (SQLException localSQLException)
      {
        localSQLException = localSQLException;
        Dbg.e(localSQLException);
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
      localObject1.close();
      label112:
      int j = 0;
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  java.util.List<Hit> removeAllHits()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 166	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 167	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: aconst_null
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 13	com/sonyericsson/extras/liveware/analytics/AnalyticsDao:mContext	Landroid/content/Context;
    //   16: invokevirtual 23	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: getstatic 29	com/sonyericsson/extras/liveware/analytics/AnalyticsDef$HitTable:URI	Landroid/net/Uri;
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 39	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +12 -> 43
    //   34: aload_1
    //   35: invokeinterface 170 1 0
    //   40: ifne +33 -> 73
    //   43: aload_0
    //   44: getfield 13	com/sonyericsson/extras/liveware/analytics/AnalyticsDao:mContext	Landroid/content/Context;
    //   47: invokevirtual 23	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   50: getstatic 29	com/sonyericsson/extras/liveware/analytics/AnalyticsDef$HitTable:URI	Landroid/net/Uri;
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 174	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   58: pop
    //   59: aload_1
    //   60: ifnull +9 -> 69
    //   63: aload_1
    //   64: invokeinterface 52 1 0
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_3
    //   72: areturn
    //   73: aload_3
    //   74: aload_1
    //   75: invokestatic 49	com/sonyericsson/extras/liveware/analytics/AnalyticsDao:getHitFromCursor	(Landroid/database/Cursor;)Lcom/sonyericsson/extras/liveware/analytics/Hit;
    //   78: invokeinterface 180 2 0
    //   83: pop
    //   84: goto -54 -> 30
    //   87: astore_2
    //   88: aload_2
    //   89: invokestatic 58	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/Throwable;)Z
    //   92: pop
    //   93: aload_1
    //   94: ifnull -25 -> 69
    //   97: aload_1
    //   98: invokeinterface 52 1 0
    //   103: goto -34 -> 69
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    //   111: astore_2
    //   112: aload_1
    //   113: ifnull +9 -> 122
    //   116: aload_1
    //   117: invokeinterface 52 1 0
    //   122: aload_2
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	AnalyticsDao
    //   11	87	1	localCursor	Cursor
    //   106	11	1	localObject1	Object
    //   87	2	2	localSQLException	SQLException
    //   111	12	2	localObject2	Object
    //   9	65	3	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   12	59	87	android/database/SQLException
    //   73	84	87	android/database/SQLException
    //   2	10	106	finally
    //   63	69	106	finally
    //   97	103	106	finally
    //   116	124	106	finally
    //   12	59	111	finally
    //   73	84	111	finally
    //   88	93	111	finally
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.analytics.AnalyticsDao
 * JD-Core Version:    0.7.0.1
 */