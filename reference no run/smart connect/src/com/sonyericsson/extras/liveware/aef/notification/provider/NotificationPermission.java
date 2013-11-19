package com.sonyericsson.extras.liveware.aef.notification.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Pair;
import com.sonyericsson.extras.liveware.aef.permission.AefPermission;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.List;

class NotificationPermission
  extends AefPermission
{
  public int lookUpSourceId(int paramInt, SQLiteDatabase paramSQLiteDatabase, Context paramContext)
  {
    int j = -1;
    Cursor localCursor = null;
    try
    {
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = "sourceId";
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = Integer.toString(paramInt);
      localCursor = paramSQLiteDatabase.query("event", arrayOfString2, "_id= ?", arrayOfString1, null, null, null);
      if ((localCursor != null) && (localCursor.getCount() == 1) && (localCursor.moveToFirst()))
      {
        int i = localCursor.getInt(localCursor.getColumnIndex("sourceId"));
        j = i;
      }
      return j;
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
  
  int restrictedDelete(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, SQLiteDatabase paramSQLiteDatabase)
  {
    int i;
    if (paramArrayOfString == null) {
      i = 1;
    } else {
      i = 1 + paramArrayOfString.length;
    }
    String[] arrayOfString = new String[i];
    if (i > 1) {
      System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, i - 1);
    }
    String str;
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      str = paramString3 + " = ?";
    } else {
      str = "(" + paramString1 + ") AND " + paramString3 + " = ?";
    }
    arrayOfString[(i - 1)] = paramString2;
    return paramSQLiteDatabase.delete(paramString4, str, arrayOfString);
  }
  
  int restrictedDelete(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString2, String paramString3, SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    Object localObject = injectPluginId(paramString1, paramArrayOfString1, paramArrayOfString2, paramString2);
    String str = (String)((Pair)localObject).first;
    localObject = (String[])((Pair)localObject).second;
    try
    {
      i = paramSQLiteDatabase.delete(paramString3, str, (String[])localObject);
      i = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (Dbg.d()) {
          Dbg.d("Exception: " + localException.toString());
        }
      }
    }
    return i;
  }
  
  Cursor restrictedQuery(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int i;
    if (paramArrayOfString2 == null) {
      i = 1;
    } else {
      i = 1 + paramArrayOfString2.length;
    }
    String[] arrayOfString = new String[i];
    if (i > 1) {
      System.arraycopy(paramArrayOfString2, 0, arrayOfString, 0, i - 1);
    }
    String str;
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      str = paramString4 + " = ?";
    } else {
      str = "(" + paramString1 + ") AND " + paramString4 + " = ?";
    }
    arrayOfString[(i - 1)] = paramString3;
    return paramSQLiteDatabase.query(paramString5, paramArrayOfString1, str, arrayOfString, null, null, paramString2);
  }
  
  int restrictedUpdate(Uri paramUri, ContentValues paramContentValues, String paramString1, String[] paramArrayOfString, String paramString2, SQLiteDatabase paramSQLiteDatabase, String paramString3, String paramString4, String paramString5)
  {
    int i;
    if (paramUri.getPathSegments().size() != 2) {
      i = 0;
    } else {
      i = 1;
    }
    int k;
    if (paramArrayOfString == null) {
      k = 1;
    } else {
      k = 1 + paramArrayOfString.length;
    }
    if (i == 0) {
      j = 0;
    } else {
      j = 1;
    }
    int j = k + j;
    String[] arrayOfString = new String[j];
    if ((j > 1) && ((i == 0) || (j != 2)))
    {
      int m;
      if (i == 0) {
        m = j - 1;
      } else {
        m = j - 2;
      }
      System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, m);
    }
    String str;
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      str = paramString3 + " = ?";
    } else {
      str = "(" + paramString1 + ") AND " + paramString3 + " = ?";
    }
    if (i == 0)
    {
      arrayOfString[(j - 1)] = paramString4;
    }
    else
    {
      str = str + " AND " + paramString5 + " = ?";
      arrayOfString[(j - 2)] = paramString4;
      arrayOfString[(j - 1)] = paramUri.getLastPathSegment();
    }
    return paramSQLiteDatabase.update(paramString2, paramContentValues, str, arrayOfString);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.notification.provider.NotificationPermission
 * JD-Core Version:    0.7.0.1
 */