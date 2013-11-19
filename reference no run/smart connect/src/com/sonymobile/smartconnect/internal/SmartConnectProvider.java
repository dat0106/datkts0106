package com.sonymobile.smartconnect.internal;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.sonyericsson.extras.liveware.db.ExperienceDatabaseHelper;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.util.ByteArrayBuffer;

public class SmartConnectProvider
  extends ContentProvider
{
  private static final UriMatcher URL_MATCHER = new UriMatcher(-1);
  
  static
  {
    URL_MATCHER.addURI("com.sonymobile.smartconnect.internal.device", "devices", 10);
    URL_MATCHER.addURI("com.sonymobile.smartconnect.internal.device", "light_theme", 20);
  }
  
  private String addCategorySelection(String paramString)
  {
    if ((paramString == null) || (!paramString.contains("type"))) {
      if (paramString != null) {
        paramString = "(type < 11 OR type > 17) AND (" + paramString + ")";
      } else {
        paramString = "(type < 11 OR type > 17)";
      }
    }
    return paramString;
  }
  
  private String[] addRequiredColumnsToProjection(String[] paramArrayOfString)
  {
    int k = 0;
    int i = 0;
    int j = 0;
    int m = paramArrayOfString.length;
    for (int n = 0; n < m; n++)
    {
      String str = paramArrayOfString[n];
      if ("connection_type".equals(str)) {
        i = 1;
      }
      if ("device_unique_id".equals(str)) {
        j = 1;
      }
    }
    if ((i == 0) || (j == 0))
    {
      int i1 = paramArrayOfString.length;
      ArrayList localArrayList = new ArrayList();
      n = paramArrayOfString.length;
      while (k < n)
      {
        localArrayList.add(paramArrayOfString[k]);
        k++;
      }
      if (i == 0)
      {
        i1++;
        localArrayList.add("connection_type");
      }
      if (j == 0)
      {
        i1++;
        localArrayList.add("device_unique_id");
      }
      paramArrayOfString = (String[])localArrayList.toArray(new String[i1]);
    }
    return paramArrayOfString;
  }
  
  private String addTypeSelection(String paramString)
  {
    if ((paramString == null) || (!paramString.contains("bearer_type"))) {
      if (paramString != null) {
        paramString = "bearer_type < 7 AND (" + paramString + ")";
      } else {
        paramString = "bearer_type < 7";
      }
    }
    return paramString;
  }
  
  private static String[] deviceProjection()
  {
    String[] arrayOfString = new String[10];
    arrayOfString[0] = "device_identify_name";
    arrayOfString[1] = "device_display_name";
    arrayOfString[2] = "device_unique_id";
    arrayOfString[3] = "connection_type";
    arrayOfString[4] = "device_category";
    arrayOfString[5] = "device_icon_data";
    arrayOfString[6] = "device_page_activity";
    arrayOfString[7] = "configured";
    arrayOfString[8] = "manufacturer";
    arrayOfString[9] = "cookie";
    return arrayOfString;
  }
  
  private static String[] deviceProjectionInternal()
  {
    String[] arrayOfString = new String[10];
    arrayOfString[0] = "product_id";
    arrayOfString[1] = "device_name";
    arrayOfString[2] = "device_key";
    arrayOfString[3] = "bearer_type";
    arrayOfString[4] = "type";
    arrayOfString[5] = "iconName";
    arrayOfString[6] = "device_page_activity";
    arrayOfString[7] = "configured";
    arrayOfString[8] = "manufacturer";
    arrayOfString[9] = "cookie";
    return arrayOfString;
  }
  
  private Set<BluetoothDevice> getBluetoothDevices()
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    Object localObject = new HashSet();
    if (localBluetoothAdapter != null) {
      localObject = localBluetoothAdapter.getBondedDevices();
    }
    return localObject;
  }
  
  private String mapColumNames(String paramString)
  {
    String str = paramString;
    String[] arrayOfString2 = deviceProjection();
    String[] arrayOfString1 = deviceProjectionInternal();
    for (int i = 0; i < arrayOfString1.length; i++) {
      str = str.replace(arrayOfString2[i], arrayOfString1[i]);
    }
    return str;
  }
  
  private String[] mapProjection(String[] paramArrayOfString)
  {
    String[] arrayOfString2 = new String[paramArrayOfString.length];
    String[] arrayOfString1 = deviceProjectionInternal();
    for (int i = 0; i < paramArrayOfString.length; i++) {
      arrayOfString2[i] = arrayOfString1[verifyColumn(paramArrayOfString[i])];
    }
    return arrayOfString2;
  }
  
  private int verifyColumn(String paramString)
  {
    String[] arrayOfString = deviceProjection();
    int i = 0;
    while (i < arrayOfString.length) {
      if (!paramString.equals(arrayOfString[i])) {
        i++;
      } else {
        return i;
      }
    }
    throw new SQLException("Invalid column name '" + paramString + "'");
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("Cannot delete URL: " + paramUri);
  }
  
  protected boolean filterUnpaired(Cursor paramCursor, Set<BluetoothDevice> paramSet)
  {
    boolean bool = false;
    if (paramCursor.getInt(paramCursor.getColumnIndex("bearer_type")) == 4)
    {
      String str = paramCursor.getString(paramCursor.getColumnIndex("device_key"));
      if (str != null)
      {
        Iterator localIterator = paramSet.iterator();
        while (localIterator.hasNext()) {
          if (((BluetoothDevice)localIterator.next()).getAddress().equals(str)) {
            return bool;
          }
        }
        bool = true;
      }
      else
      {
        Dbg.e("Empty KeyID field");
      }
    }
    return bool;
  }
  
  public String getType(Uri paramUri)
  {
    String str;
    switch (URL_MATCHER.match(paramUri))
    {
    default: 
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    case 10: 
      str = "vnd.android.cursor.dir/smart_connect_devices";
      break;
    case 20: 
      str = "vnd.android.cursor.dir/smart_connect_devices";
    }
    return str;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("Cannot insert into URL: " + paramUri);
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int i = URL_MATCHER.match(paramUri);
    if ((i != 10) && (i != 20)) {
      throw new IllegalArgumentException("Unknown URL " + paramUri);
    }
    Object localObject2 = paramArrayOfString1;
    Object localObject3;
    String str1;
    SQLiteDatabase localSQLiteDatabase;
    Cursor localCursor;
    Set localSet;
    if (paramArrayOfString1 == null)
    {
      localObject3 = deviceProjectionInternal();
      if (paramString1 != null) {
        paramString1 = mapColumNames(paramString1);
      }
      str1 = addTypeSelection(addCategorySelection(paramString1));
      if (paramString2 != null) {
        paramString2 = mapColumNames(paramString2);
      }
      localSQLiteDatabase = new ExperienceDatabaseHelper(getContext()).getWritableDatabase();
      localCursor = null;
      localSet = getBluetoothDevices();
      if (localObject2 != null) {
        break label200;
      }
      localObject2 = new BlobHandlingMatrixCursor(deviceProjection());
    }
    for (;;)
    {
      label200:
      boolean bool1;
      String str2;
      try
      {
        localCursor = localSQLiteDatabase.query("device", (String[])localObject3, str1, paramArrayOfString2, null, null, paramString2);
        localCursor = localCursor;
        if (localCursor == null)
        {
          if (localCursor != null) {
            localCursor.close();
          }
          localObject2 = null;
          return localObject2;
          localObject2 = addRequiredColumnsToProjection((String[])localObject2);
          localObject3 = mapProjection((String[])localObject2);
          break;
          localObject2 = new BlobHandlingMatrixCursor((String[])localObject2);
          continue;
          localObject3 = new Object[localCursor.getColumnCount()];
          if (!filterUnpaired(localCursor, localSet)) {
            continue;
          }
        }
        bool1 = localCursor.moveToNext();
        if (bool1) {
          continue;
        }
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
        continue;
        int j = 0;
        if (j >= localCursor.getColumnCount())
        {
          int k = localCursor.getColumnIndex("iconName");
          if (k < 0) {
            break label440;
          }
          if (bool1[k] != null)
          {
            Context localContext = getContext();
            str2 = (String)bool1[k];
            if (i != 20) {
              break label450;
            }
            bool3 = true;
            bool1[k] = Device.getPublicIconData(localContext, str2, bool3);
          }
          ((BlobHandlingMatrixCursor)localObject2).addRow(bool1, k);
          continue;
        }
        bool2 = localCursor.isNull(str2);
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
      boolean bool2;
      if (!bool2) {}
      for (;;)
      {
        try
        {
          bool1[str2] = localCursor.getString(str2);
          str2++;
        }
        catch (Throwable localThrowable)
        {
          bool1[str2] = Integer.toString(localCursor.getInt(str2));
          continue;
        }
        bool1[str2] = null;
      }
      label440:
      ((BlobHandlingMatrixCursor)localObject2).addRow(bool1);
      continue;
      label450:
      boolean bool3 = false;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("Cannot update URL: " + paramUri);
  }
  
  private static class BlobHandlingMatrixCursor
    extends MatrixCursor
  {
    int mBlobColumn = -1;
    private ArrayList<ByteArrayBuffer> mBufferList = new ArrayList();
    
    public BlobHandlingMatrixCursor(String[] paramArrayOfString)
    {
      this(paramArrayOfString, 16);
    }
    
    public BlobHandlingMatrixCursor(String[] paramArrayOfString, int paramInt)
    {
      super(paramInt);
    }
    
    public void addRow(Object[] paramArrayOfObject, int paramInt)
    {
      if ((paramInt >= 0) && ((this.mBlobColumn < 0) || (this.mBlobColumn == paramInt)))
      {
        this.mBlobColumn = paramInt;
        if (paramArrayOfObject[paramInt] != null)
        {
          if (!(paramArrayOfObject[paramInt] instanceof ByteArrayBuffer))
          {
            this.mBufferList.add(null);
          }
          else
          {
            this.mBufferList.add((ByteArrayBuffer)paramArrayOfObject[paramInt]);
            paramArrayOfObject[paramInt] = null;
          }
        }
        else {
          this.mBufferList.add((ByteArrayBuffer)paramArrayOfObject[paramInt]);
        }
        super.addRow(paramArrayOfObject);
        return;
      }
      throw new IllegalArgumentException();
    }
    
    public byte[] getBlob(int paramInt)
    {
      if (paramInt == this.mBlobColumn)
      {
        localObject = (ByteArrayBuffer)this.mBufferList.get(this.mPos);
        if (localObject != null) {}
      }
      else
      {
        return null;
      }
      Object localObject = ((ByteArrayBuffer)localObject).toByteArray();
      return localObject;
    }
    
    public int getType(int paramInt)
    {
      int i;
      if (paramInt != this.mBlobColumn) {
        i = super.getType(paramInt);
      } else {
        i = 4;
      }
      return i;
    }
    
    public boolean isNull(int paramInt)
    {
      boolean bool;
      if (paramInt != this.mBlobColumn) {
        bool = super.isNull(paramInt);
      } else if ((ByteArrayBuffer)this.mBufferList.get(this.mPos) != null) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonymobile.smartconnect.internal.SmartConnectProvider
 * JD-Core Version:    0.7.0.1
 */