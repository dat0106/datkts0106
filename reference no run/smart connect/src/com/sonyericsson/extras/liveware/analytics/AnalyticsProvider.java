package com.sonyericsson.extras.liveware.analytics;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.sonyericsson.extras.liveware.utils.Dbg;

public final class AnalyticsProvider
  extends ContentProvider
{
  private static UriMatcher sUriMatcher = new UriMatcher(-1);
  private SQLiteOpenHelper mOpenHelper;
  
  static
  {
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.analytics", "hit", 1);
    sUriMatcher.addURI("com.sonyericsson.extras.liveware.analytics", "hit/#", 2);
  }
  
  private String tableFromMatch(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    case 1: 
      str = "hit";
      break;
    case 2: 
      str = "hit";
    }
    return str;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int k = sUriMatcher.match(paramUri);
    String str = tableFromMatch(k);
    if (str != null)
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      if (k < 2) {}
      for (;;)
      {
        try
        {
          i = localSQLiteDatabase.delete(str, paramString, paramArrayOfString);
          i = i;
        }
        catch (SQLiteConstraintException localSQLiteConstraintException)
        {
          int i;
          String[] arrayOfString;
          if (!Dbg.e()) {
            continue;
          }
          Dbg.e("Error when updating " + paramUri.toString(), localSQLiteConstraintException);
          int j = 0;
          continue;
        }
        catch (SQLException localSQLException)
        {
          if (!Dbg.e()) {
            continue;
          }
          Dbg.e("Error when deleting from " + paramUri.toString(), localSQLException);
          throw localSQLException;
        }
        if (i > 0) {
          getContext().getContentResolver().notifyChange(paramUri, null);
        }
        return i;
        arrayOfString = new String[1];
        arrayOfString[0] = paramUri.getLastPathSegment();
        i = localSQLiteDatabase.delete(i, "_id=?", arrayOfString);
        i = i;
      }
    }
    throw new SQLException("Invalid uri for this content provider. " + paramUri.toString());
  }
  
  public String getType(Uri paramUri)
  {
    String str;
    switch (sUriMatcher.match(paramUri))
    {
    default: 
      str = null;
      break;
    case 1: 
      str = "vnd.android.cursor.dir/asf-hit";
      break;
    case 2: 
      str = "vnd.android.cursor.item/asf-hit";
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
    Object localObject = tableFromMatch(i);
    if ((localObject != null) && (i < 2))
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      try
      {
        long l = localSQLiteDatabase.insert((String)localObject, "", paramContentValues);
        if (Dbg.v()) {
          Dbg.v("Insert in table " + (String)localObject + " with id " + l + ".");
        }
        if (l == -1L) {
          throw new SQLException("Failed to insert");
        }
      }
      catch (SQLException localSQLException)
      {
        if (Dbg.e()) {
          Dbg.e("Error when inserting into " + (String)localObject, localSQLException);
        }
        throw localSQLException;
      }
      localObject = Uri.withAppendedPath(paramUri, String.valueOf(localSQLException));
      if (localObject != null) {
        getContext().getContentResolver().notifyChange((Uri)localObject, null);
      }
      return localObject;
    }
    throw new SQLException("Invalid uri for this content provider. " + paramUri.toString());
  }
  
  public boolean onCreate()
  {
    this.mOpenHelper = new AnalyticsDatabaseHelper(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int i = sUriMatcher.match(paramUri);
    Object localObject = tableFromMatch(i);
    if (localObject == null) {
      throw new SQLException("Invalid uri for this content provider. " + paramUri.toString());
    }
    if (i >= 2)
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
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int k = sUriMatcher.match(paramUri);
    String str = tableFromMatch(k);
    if (str != null)
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      if (k < 2) {}
      for (;;)
      {
        try
        {
          i = localSQLiteDatabase.update(str, paramContentValues, paramString, paramArrayOfString);
          i = i;
        }
        catch (SQLiteConstraintException localSQLiteConstraintException)
        {
          int i;
          String[] arrayOfString;
          if (!Dbg.e()) {
            continue;
          }
          Dbg.e("Error when updating " + paramUri.toString(), localSQLiteConstraintException);
          int j = 0;
          continue;
        }
        catch (SQLException localSQLException)
        {
          if (!Dbg.e()) {
            continue;
          }
          Dbg.e("Error when updating " + paramUri.toString(), localSQLException);
          throw localSQLException;
        }
        if (i > 0) {
          getContext().getContentResolver().notifyChange(paramUri, null);
        }
        return i;
        arrayOfString = new String[1];
        arrayOfString[0] = paramUri.getLastPathSegment();
        i = i.update(str, paramContentValues, "_id=?", arrayOfString);
        i = i;
      }
    }
    throw new SQLException("Invalid uri for this content provider. " + paramUri.toString());
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.analytics.AnalyticsProvider
 * JD-Core Version:    0.7.0.1
 */