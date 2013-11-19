package com.sonyericsson.extras.liveware.analytics;

import android.net.Uri;
import android.provider.BaseColumns;

class AnalyticsDef
{
  static final String AUTHORITY = "com.sonyericsson.extras.liveware.analytics";
  protected static final Uri BASE_URI = Uri.parse("content://com.sonyericsson.extras.liveware.analytics");
  
  static abstract interface Constants
  {
    public static final String DATABASE_NAME = "batch_analytics.db";
    public static final int DATABASE_VERSION = 1;
    public static final String DIR_TYPE_BASE = "vnd.android.cursor.dir/";
    public static final String ITEM_TYPE_BASE = "vnd.android.cursor.item/";
    public static final int MATCH_HIT = 1;
    public static final int MATCH_HIT_SINGLE = 2;
  }
  
  static abstract interface HitColumns
    extends BaseColumns
  {
    public static final String ACTION = "action";
    public static final String CATEGORY = "category";
    public static final String LABEL = "label";
    public static final String VALUE = "value";
  }
  
  static abstract interface HitTable
  {
    public static final String MIME_TYPE = "asf-hit";
    public static final String PATH = "hit";
    public static final String SINGLE_PATH = "hit/#";
    public static final String TABLE_NAME = "hit";
    public static final Uri URI = Uri.withAppendedPath(AnalyticsDef.BASE_URI, "hit");
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.analytics.AnalyticsDef
 * JD-Core Version:    0.7.0.1
 */