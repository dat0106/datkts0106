package com.sonyericsson.extras.liveware.aef.permission;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PermissionInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Binder;
import android.text.TextUtils;
import android.util.Pair;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public abstract class AefPermission
{
  public static final int GRANT_EXTENSION_PERMISSION = 2;
  public static final int GRANT_HOSTAPP_PERMISSION = 1;
  public static final int PERMISSION_DENIED = 3;
  
  public void checkForSqlInjectionAttempt(ContentValues paramContentValues)
    throws SQLException
  {
    Iterator localIterator = paramContentValues.valueSet().iterator();
    while (localIterator.hasNext()) {
      checkForSqlInjectionAttempt((String)((Map.Entry)localIterator.next()).getKey());
    }
  }
  
  public void checkForSqlInjectionAttempt(String paramString)
    throws SQLException
  {
    if ((paramString == null) || (!paramString.matches("(\\')|(\\-\\-)"))) {
      return;
    }
    throw new SQLException("Invalid characters in SQL segment: '" + paramString + "'.");
  }
  
  public void checkForSqlInjectionAttempt(String[] paramArrayOfString)
    throws SQLException
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      for (int i = 0; i < j; i++) {
        checkForSqlInjectionAttempt(paramArrayOfString[i]);
      }
    }
  }
  
  public boolean checkHostAppPermission(Context paramContext)
  {
    return checkHostAppPermission(paramContext, Binder.getCallingUid());
  }
  
  public boolean checkHostAppPermission(Context paramContext, int paramInt)
  {
    int i = 1;
    PackageManager localPackageManager = paramContext.getPackageManager();
    String[] arrayOfString = localPackageManager.getPackagesForUid(paramInt);
    String str = paramContext.getPackageName();
    int j;
    if ((arrayOfString != null) && (arrayOfString.length >= i)) {
      j = 0;
    }
    for (;;)
    {
      if (j >= arrayOfString.length) {
        i = 0;
      }
      for (;;)
      {
        return i;
        if (((localPackageManager.checkPermission("com.sonyericsson.extras.liveware.aef.HOSTAPP_PERMISSION", arrayOfString[j]) != 0) || (localPackageManager.checkSignatures(arrayOfString[j], paramContext.getPackageName()) != 0)) && (!TextUtils.equals(str, arrayOfString[j]))) {}
        try
        {
          Signature[] arrayOfSignature = localPackageManager.getPackageInfo(arrayOfString[j], 64).signatures;
          if ((arrayOfSignature != null) && (arrayOfSignature[0] != null))
          {
            boolean bool = WhiteList.exists(arrayOfString[j], arrayOfSignature[0]);
            if (bool) {}
          }
          else
          {
            j++;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            Dbg.e("NameNotFoundException during white list check. ", localNameNotFoundException);
          }
        }
      }
    }
  }
  
  public int checkPermission(Context paramContext, int paramInt)
  {
    int i = 3;
    if (paramInt == -1)
    {
      if (!checkPluginPermission(paramContext))
      {
        if (checkHostAppPermission(paramContext)) {
          i = 1;
        }
      }
      else {
        i = 2;
      }
    }
    else {
      i = 2;
    }
    return i;
  }
  
  public boolean checkPluginPermission(Context paramContext)
  {
    return checkPluginPermission(paramContext, Binder.getCallingUid());
  }
  
  public boolean checkPluginPermission(Context paramContext, int paramInt)
  {
    boolean bool1 = false;
    PackageManager localPackageManager = paramContext.getPackageManager();
    String[] arrayOfString = localPackageManager.getPackagesForUid(paramInt);
    boolean bool3 = false;
    if ((arrayOfString != null) && (arrayOfString.length >= 1)) {}
    label155:
    for (int j = 0;; j++)
    {
      if (j >= arrayOfString.length)
      {
        bool1 = bool3;
        return bool1;
      }
      if (localPackageManager.checkPermission("com.sonyericsson.extras.liveware.aef.EXTENSION_PERMISSION", arrayOfString[j]) == 0) {
        bool3 = true;
      }
      if (!arrayOfString[j].equals(paramContext.getPackageName()))
      {
        int k;
        int i;
        do
        {
          try
          {
            arrayOfPermissionInfo = localPackageManager.getPackageInfo(arrayOfString[j], 4096).permissions;
            if (arrayOfPermissionInfo == null) {
              break label155;
            }
            k = arrayOfPermissionInfo.length;
            i = 0;
          }
          catch (Exception localException)
          {
            PermissionInfo[] arrayOfPermissionInfo;
            boolean bool2;
            break label155;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            break label155;
          }
          bool2 = arrayOfPermissionInfo[i].name.equals("com.sonyericsson.extras.liveware.aef.EXTENSION_PERMISSION");
          if (bool2) {
            break;
          }
          i++;
        } while (i < k);
      }
    }
  }
  
  public int getExtensionIdForExtensionId(TreeMap<String, Integer> paramTreeMap, ContentValues paramContentValues)
  {
    int i;
    if (paramContentValues.containsKey("extensionId"))
    {
      i = paramContentValues.getAsInteger("extensionId").intValue();
      if (paramTreeMap.containsValue(Integer.valueOf(i))) {}
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  public int getExtensionIdForPackage(TreeMap<String, Integer> paramTreeMap, ContentValues paramContentValues)
  {
    if (paramContentValues.containsKey("packageName"))
    {
      String str = paramContentValues.getAsString("packageName");
      if (paramTreeMap.containsKey(str)) {}
    }
    else
    {
      return -1;
    }
    int i = ((Integer)paramTreeMap.get(i)).intValue();
    return i;
  }
  
  protected Pair<String, String[]> injectPluginId(String paramString1, String[] paramArrayOfString, Integer[] paramArrayOfInteger, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i;
    if (paramArrayOfString == null) {
      i = 0;
    } else {
      i = paramArrayOfString.length;
    }
    String[] arrayOfString = new String[i + paramArrayOfInteger.length];
    int j = 0;
    if (i > 0) {
      System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, i);
    }
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      localStringBuffer.append("(" + paramString1 + ")");
    }
    if (paramArrayOfInteger.length > 0)
    {
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        localStringBuffer.append(" AND (");
      }
      while (j < paramArrayOfInteger.length)
      {
        localStringBuffer.append(paramString2 + "=?");
        arrayOfString[(i + j)] = String.valueOf(paramArrayOfInteger[j]);
        j++;
        if (j < paramArrayOfInteger.length) {
          localStringBuffer.append(" OR ");
        }
      }
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        localStringBuffer.append(")");
      }
    }
    return Pair.create(localStringBuffer.toString(), arrayOfString);
  }
  
  public Pair<String, String[]> injectPluginId(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i;
    if (paramArrayOfString1 == null) {
      i = 0;
    } else {
      i = paramArrayOfString1.length;
    }
    String[] arrayOfString = new String[i + paramArrayOfString2.length];
    int j = 0;
    if (i > 0) {
      System.arraycopy(paramArrayOfString1, 0, arrayOfString, 0, i);
    }
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      localStringBuffer.append("(" + paramString1 + ")");
    }
    if (paramArrayOfString2.length > 0)
    {
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        localStringBuffer.append(" AND (");
      }
      while (j < paramArrayOfString2.length)
      {
        localStringBuffer.append(paramString2 + "=?");
        arrayOfString[(i + j)] = paramArrayOfString2[j];
        j++;
        if (j < paramArrayOfString2.length) {
          localStringBuffer.append(" OR ");
        }
      }
      if ((paramString1 != null) && (paramString1.length() > 0)) {
        localStringBuffer.append(")");
      }
    }
    return Pair.create(localStringBuffer.toString(), arrayOfString);
  }
  
  public TreeMap<String, Integer> lookUpExtensionsForUid(int paramInt1, SQLiteDatabase paramSQLiteDatabase, Context paramContext, int paramInt2)
  {
    Object localObject2 = paramContext.getPackageManager();
    String[] arrayOfString1 = ((PackageManager)localObject2).getPackagesForUid(paramInt1);
    String str = ((PackageManager)localObject2).getNameForUid(paramInt1);
    TreeMap localTreeMap = new TreeMap();
    localObject2 = null;
    for (;;)
    {
      try
      {
        Object localObject3 = new String[2];
        localObject3[0] = "_id";
        localObject3[1] = "packageName";
        String[] arrayOfString2 = new String[2];
        arrayOfString2[0] = str;
        arrayOfString2[1] = Integer.toString(paramInt2);
        localObject2 = paramSQLiteDatabase.query("extension", (String[])localObject3, "userId = ? AND notificationApiVersion >= ?", arrayOfString2, null, null, "_id");
        if (localObject2 != null)
        {
          boolean bool = ((Cursor)localObject2).moveToNext();
          if (bool) {}
        }
        else
        {
          return localTreeMap;
        }
        int i = ((Cursor)localObject2).getInt(((Cursor)localObject2).getColumnIndex("_id"));
        localObject3 = ((Cursor)localObject2).getString(((Cursor)localObject2).getColumnIndex("packageName"));
        int j = 0;
        if (j < arrayOfString1.length) {
          if (arrayOfString1[j].equals(localObject3)) {
            localTreeMap.put(localObject3, Integer.valueOf(i));
          } else {
            j++;
          }
        }
      }
      finally
      {
        if (localObject2 != null) {
          ((Cursor)localObject2).close();
        }
      }
    }
  }
  
  public void verifyContentValues(ContentValues paramContentValues, String[] paramArrayOfString)
    throws SQLException
  {
    int i = paramArrayOfString.length;
    int j = 0;
    while (j < i)
    {
      String str = paramArrayOfString[j];
      if ((paramContentValues != null) && (!paramContentValues.containsKey(str))) {
        j++;
      } else {
        throw new SQLException("Invalid column '" + str + "' for ContentValues.");
      }
    }
  }
  
  public void verifyPackage(int paramInt, Context paramContext, ContentValues paramContentValues)
  {
    if (paramContentValues.containsKey("packageName"))
    {
      String str = paramContentValues.getAsString("packageName");
      String[] arrayOfString = paramContext.getPackageManager().getPackagesForUid(paramInt);
      int i = 0;
      while (i < arrayOfString.length) {
        if (!arrayOfString[i].equals(str)) {
          i++;
        } else {
          return;
        }
      }
      throw new SQLException("Invalid value for column 'packageName' for ContentValues.");
    }
    throw new SQLException("Mandatory column is missing 'packageName' for ContentValues.");
  }
  
  public void verifyProjection(String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws SQLException
  {
    int i = paramArrayOfString1.length;
    for (int j = 0; j < i; j++)
    {
      String str2 = paramArrayOfString1[j];
      int m = paramArrayOfString2.length;
      int k = 0;
      while (k < m)
      {
        String str1 = paramArrayOfString2[k];
        if (!str2.equals(str1)) {
          k++;
        } else {
          throw new SQLException("Invalid column '" + str1 + "' in projection");
        }
      }
    }
  }
  
  private static enum WhiteList
  {
    private byte[] mHashedSignature;
    private String mPkgName;
    
    static
    {
      Object localObject = new byte[32];
      localObject[0] = 20;
      localObject[1] = -69;
      localObject[2] = 98;
      localObject[3] = 118;
      localObject[4] = -96;
      localObject[5] = -75;
      localObject[6] = 35;
      localObject[7] = 16;
      localObject[8] = -57;
      localObject[9] = -104;
      localObject[10] = -34;
      localObject[11] = -128;
      localObject[12] = 51;
      localObject[13] = 75;
      localObject[14] = -73;
      localObject[15] = -24;
      localObject[16] = 102;
      localObject[17] = 8;
      localObject[18] = -128;
      localObject[19] = 66;
      localObject[20] = 53;
      localObject[21] = 6;
      localObject[22] = -124;
      localObject[23] = 49;
      localObject[24] = -75;
      localObject[25] = -56;
      localObject[26] = 37;
      localObject[27] = 109;
      localObject[28] = 64;
      localObject[29] = -121;
      localObject[30] = 63;
      localObject[31] = 60;
      SONY_CAR_APP = new WhiteList("SONY_CAR_APP", 0, "com.sony.evc.app.launcher", (byte[])localObject);
      localObject = new WhiteList[1];
      localObject[0] = SONY_CAR_APP;
      ENUM$VALUES = (WhiteList[])localObject;
    }
    
    private WhiteList(String paramString, byte[] paramArrayOfByte)
    {
      this.mPkgName = paramString;
      this.mHashedSignature = paramArrayOfByte;
    }
    
    public static boolean exists(String paramString, Signature paramSignature)
    {
      boolean bool = false;
      WhiteList[] arrayOfWhiteList = values();
      int j = arrayOfWhiteList.length;
      int i = 0;
      while (i < j)
      {
        WhiteList localWhiteList = arrayOfWhiteList[i];
        if (localWhiteList.mPkgName.equals(paramString))
        {
          byte[] arrayOfByte = getHashedSignature(paramSignature.toByteArray());
          if ((arrayOfByte != null) && (Arrays.equals(localWhiteList.mHashedSignature, arrayOfByte))) {}
        }
        else
        {
          i++;
          continue;
        }
        bool = true;
      }
      return bool;
    }
    
    private static byte[] getHashedSignature(byte[] paramArrayOfByte)
    {
      try
      {
        arrayOfByte = MessageDigest.getInstance("SHA-256").digest(paramArrayOfByte);
        arrayOfByte = arrayOfByte;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;)
        {
          Dbg.e("Unable to transform signature.");
          byte[] arrayOfByte = null;
        }
      }
      return arrayOfByte;
    }
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.permission.AefPermission
 * JD-Core Version:    0.7.0.1
 */