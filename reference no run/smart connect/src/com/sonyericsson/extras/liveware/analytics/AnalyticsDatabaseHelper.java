package com.sonyericsson.extras.liveware.analytics;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sonyericsson.extras.liveware.utils.Dbg;

class AnalyticsDatabaseHelper
  extends SQLiteOpenHelper
{
  private static final String HIT_SQL = "CREATE TABLE IF NOT EXISTS hit (_id INTEGER PRIMARY KEY AUTOINCREMENT, category TEXT NOT NULL, action TEXT NOT NULL, label TEXT NOT NULL, value INT NOT NULL DEFAULT 1,  UNIQUE (category, action, label))";
  
  public AnalyticsDatabaseHelper(Context paramContext)
  {
    super(paramContext, "batch_analytics.db", null, 1);
  }
  
  private void dropAllDatabaseObjects(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS hit");
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS hit (_id INTEGER PRIMARY KEY AUTOINCREMENT, category TEXT NOT NULL, action TEXT NOT NULL, label TEXT NOT NULL, value INT NOT NULL DEFAULT 1,  UNIQUE (category, action, label))");
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
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (Dbg.d()) {
      Dbg.d("Reinstall of first version - drop all tables.");
    }
    dropAllDatabaseObjects(paramSQLiteDatabase);
    onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.analytics.AnalyticsDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */