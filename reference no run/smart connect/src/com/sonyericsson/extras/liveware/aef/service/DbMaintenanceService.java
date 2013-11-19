package com.sonyericsson.extras.liveware.aef.service;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import com.sonyericsson.extras.liveware.aef.notification.Notification.Source;
import com.sonyericsson.extras.liveware.aef.permission.AefPermission;
import com.sonyericsson.extras.liveware.aef.registration.Registration.ApiRegistration;
import com.sonyericsson.extras.liveware.aef.registration.Registration.Device;
import com.sonyericsson.extras.liveware.aef.registration.Registration.Display;
import com.sonyericsson.extras.liveware.aef.registration.Registration.Extension;
import com.sonyericsson.extras.liveware.aef.registration.Registration.HostApp;
import com.sonyericsson.extras.liveware.aef.registration.Registration.Input;
import com.sonyericsson.extras.liveware.aef.registration.Registration.Led;
import com.sonyericsson.extras.liveware.aef.registration.Registration.Sensor;
import com.sonyericsson.extras.liveware.asf.InstallReceiver;
import com.sonyericsson.extras.liveware.utils.AsfUtils;
import com.sonyericsson.extras.liveware.utils.Dbg;
import java.util.TreeMap;

public class DbMaintenanceService
  extends IntentService
{
  public DbMaintenanceService()
  {
    super(DbMaintenanceService.class.getName());
  }
  
  private void finishPendingInstall(int paramInt)
  {
    InstallReceiver.onReceive(this, paramInt);
  }
  
  private boolean isAnyHostAppPresent(Context paramContext)
  {
    boolean bool = false;
    localCursor = null;
    try
    {
      ContentResolver localContentResolver = paramContext.getContentResolver();
      Uri localUri = Registration.HostApp.URI;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "_id";
      localCursor = localContentResolver.query(localUri, arrayOfString, null, null, null);
      if (localCursor != null)
      {
        int i = localCursor.getCount();
        if (i > 0) {
          bool = true;
        }
      }
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Dbg.e("query failed in isAnyHostAppPresent", localSQLException);
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
    finally
    {
      if (localCursor == null) {
        break label105;
      }
      localCursor.close();
    }
    return bool;
  }
  
  private boolean isLastHostApp(Context paramContext)
  {
    if (Dbg.d()) {
      Dbg.d("isLastHostApp");
    }
    int i = 0;
    Cursor localCursor = null;
    label143:
    try
    {
      ContentResolver localContentResolver = paramContext.getContentResolver();
      Uri localUri = Registration.HostApp.URI;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "_id";
      localCursor = localContentResolver.query(localUri, arrayOfString, null, null, null);
      if (localCursor != null)
      {
        i = localCursor.getCount();
        i = i;
      }
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Dbg.e("query failed in isLastHostApp", localSQLException);
        if (bool != null) {
          bool.close();
        }
      }
    }
    finally
    {
      if (bool == null) {
        break label143;
      }
      bool.close();
    }
    if (Dbg.d()) {
      Dbg.d("isLastHostApp hostAppCount=" + i);
    }
    if (i == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private Cursor lookUpDeviceId(Context paramContext, int paramInt)
  {
    Cursor localCursor = null;
    try
    {
      ContentResolver localContentResolver = paramContext.getContentResolver();
      Uri localUri = Registration.Device.URI;
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = "_id";
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = Integer.toString(paramInt);
      localCursor = localContentResolver.query(localUri, arrayOfString1, "hostAppId = ?", arrayOfString2, null);
      localCursor = localCursor;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Dbg.e("query failed lookUpDeviceId", localSQLException);
      }
    }
    return localCursor;
  }
  
  private int lookUpHostAppId(Context paramContext, String paramString)
  {
    int i = -1;
    localCursor = null;
    try
    {
      ContentResolver localContentResolver = paramContext.getContentResolver();
      Uri localUri = Registration.HostApp.URI;
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = "_id";
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = paramString;
      localCursor = localContentResolver.query(localUri, arrayOfString1, "packageName = ?", arrayOfString2, null);
      if ((localCursor != null) && (localCursor.getCount() == 1) && (localCursor.moveToFirst()))
      {
        i = localCursor.getInt(localCursor.getColumnIndex("_id"));
        i = i;
      }
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Dbg.e("query failed in lookUpHostAppId", localSQLException);
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
    finally
    {
      if (localCursor == null) {
        break label146;
      }
      localCursor.close();
    }
    return i;
  }
  
  private TreeMap<Integer, String> lookUpPluginId(Context paramContext, String paramString)
  {
    int i = -1;
    String str = "";
    localObject1 = null;
    try
    {
      ContentResolver localContentResolver = paramContext.getContentResolver();
      Uri localUri = Registration.Extension.URI;
      String[] arrayOfString2 = new String[2];
      arrayOfString2[0] = "_id";
      arrayOfString2[1] = "userId";
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = paramString;
      localObject1 = localContentResolver.query(localUri, arrayOfString2, "packageName = ?", arrayOfString1, null);
      if ((localObject1 != null) && (((Cursor)localObject1).getCount() > 0) && (((Cursor)localObject1).moveToFirst()))
      {
        i = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndex("_id"));
        str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("userId"));
        str = str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (Dbg.d()) {
          Dbg.d("lookUpPluginId=" + localException);
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    finally
    {
      if (localObject1 == null) {
        break label209;
      }
      ((Cursor)localObject1).close();
    }
    localObject1 = new TreeMap();
    ((TreeMap)localObject1).put(Integer.valueOf(i), str);
    return localObject1;
  }
  
  private void removeAllExtensions(Context paramContext)
  {
    if (Dbg.d()) {
      Dbg.d("removeAllExtensions");
    }
    try
    {
      paramContext.getContentResolver().delete(Notification.Source.URI, null, null);
      paramContext.getContentResolver().delete(Registration.ApiRegistration.URI, null, null);
      paramContext.getContentResolver().delete(Registration.Extension.URI, null, null);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Dbg.e("delete failed in removeAllExtensions", localSQLException);
      }
    }
  }
  
  /* Error */
  private void removeApiRegistration(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 77	com/sonyericsson/extras/liveware/utils/Dbg:d	()Z
    //   3: ifeq +23 -> 26
    //   6: new 83	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 176
    //   12: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_2
    //   16: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 81	com/sonyericsson/extras/liveware/utils/Dbg:d	(Ljava/lang/String;)Z
    //   25: pop
    //   26: aconst_null
    //   27: astore_3
    //   28: aload_1
    //   29: invokevirtual 39	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   32: astore 4
    //   34: getstatic 170	com/sonyericsson/extras/liveware/aef/registration/Registration$ApiRegistration:URI	Landroid/net/Uri;
    //   37: astore 5
    //   39: iconst_1
    //   40: anewarray 47	java/lang/String
    //   43: astore 7
    //   45: aload 7
    //   47: iconst_0
    //   48: ldc 181
    //   50: aastore
    //   51: iconst_1
    //   52: anewarray 47	java/lang/String
    //   55: astore 6
    //   57: aload 6
    //   59: iconst_0
    //   60: aload_2
    //   61: aastore
    //   62: aload 4
    //   64: aload 5
    //   66: aload 7
    //   68: ldc 183
    //   70: aload 6
    //   72: aconst_null
    //   73: invokevirtual 55	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   76: astore_3
    //   77: aload_3
    //   78: ifnull +16 -> 94
    //   81: aload_3
    //   82: invokeinterface 186 1 0
    //   87: istore 4
    //   89: iload 4
    //   91: ifne +46 -> 137
    //   94: aload_3
    //   95: ifnull +9 -> 104
    //   98: aload_3
    //   99: invokeinterface 64 1 0
    //   104: aload_1
    //   105: invokevirtual 39	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   108: astore 4
    //   110: getstatic 170	com/sonyericsson/extras/liveware/aef/registration/Registration$ApiRegistration:URI	Landroid/net/Uri;
    //   113: astore_3
    //   114: iconst_1
    //   115: anewarray 47	java/lang/String
    //   118: astore 5
    //   120: aload 5
    //   122: iconst_0
    //   123: aload_2
    //   124: aastore
    //   125: aload 4
    //   127: aload_3
    //   128: ldc 188
    //   130: aload 5
    //   132: invokevirtual 167	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   135: pop
    //   136: return
    //   137: aload_0
    //   138: aload_1
    //   139: aload_3
    //   140: aload_3
    //   141: ldc 181
    //   143: invokeinterface 120 2 0
    //   148: invokeinterface 124 2 0
    //   153: invokespecial 192	com/sonyericsson/extras/liveware/aef/service/DbMaintenanceService:removeExtensionIfOnlyOneHostApp	(Landroid/content/Context;I)Z
    //   156: pop
    //   157: goto -80 -> 77
    //   160: astore 4
    //   162: invokestatic 77	com/sonyericsson/extras/liveware/utils/Dbg:d	()Z
    //   165: ifeq +24 -> 189
    //   168: new 83	java/lang/StringBuilder
    //   171: dup
    //   172: ldc 194
    //   174: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   177: aload 4
    //   179: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 81	com/sonyericsson/extras/liveware/utils/Dbg:d	(Ljava/lang/String;)Z
    //   188: pop
    //   189: aload_3
    //   190: ifnull -86 -> 104
    //   193: aload_3
    //   194: invokeinterface 64 1 0
    //   199: goto -95 -> 104
    //   202: astore 4
    //   204: aload_3
    //   205: ifnull +9 -> 214
    //   208: aload_3
    //   209: invokeinterface 64 1 0
    //   214: aload 4
    //   216: athrow
    //   217: astore_3
    //   218: ldc 196
    //   220: aload_3
    //   221: invokestatic 72	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;Ljava/lang/Throwable;)Z
    //   224: pop
    //   225: goto -89 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	DbMaintenanceService
    //   0	228	1	paramContext	Context
    //   0	228	2	paramString	String
    //   27	182	3	localObject1	Object
    //   217	4	3	localSQLException	SQLException
    //   32	31	4	localContentResolver1	ContentResolver
    //   87	3	4	bool	boolean
    //   108	18	4	localContentResolver2	ContentResolver
    //   160	18	4	localException	Exception
    //   202	13	4	localObject2	Object
    //   37	94	5	localObject3	Object
    //   55	16	6	arrayOfString1	String[]
    //   43	24	7	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   28	89	160	java/lang/Exception
    //   137	157	160	java/lang/Exception
    //   28	89	202	finally
    //   137	157	202	finally
    //   162	189	202	finally
    //   104	136	217	android/database/SQLException
  }
  
  private void removeExtension(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    if (Dbg.d()) {
      Dbg.d("removeExtension pluginId=" + paramInt);
    }
    String str = Integer.toString(paramInt);
    try
    {
      Object localObject1 = paramContext.getContentResolver();
      Object localObject2 = Notification.Source.URI;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = paramString1;
      arrayOfString[1] = paramString2;
      ((ContentResolver)localObject1).delete((Uri)localObject2, "userId=? AND packageName=?", arrayOfString);
      localObject1 = paramContext.getContentResolver();
      localObject2 = Registration.ApiRegistration.URI;
      arrayOfString = new String[1];
      arrayOfString[0] = str;
      ((ContentResolver)localObject1).delete((Uri)localObject2, "extensionId=?", arrayOfString);
      localObject2 = paramContext.getContentResolver();
      localObject1 = Registration.Extension.URI;
      arrayOfString = new String[1];
      arrayOfString[0] = str;
      ((ContentResolver)localObject2).delete((Uri)localObject1, "_id = ?", arrayOfString);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        Dbg.e("delete failed in removeExtension", localSQLException);
      }
    }
  }
  
  private boolean removeExtensionIfOnlyOneHostApp(Context paramContext, int paramInt)
  {
    localCursor = null;
    int i = 0;
    boolean bool = false;
    String str1 = "";
    String str2 = "";
    try
    {
      localObject4 = paramContext.getContentResolver();
      Uri localUri = Registration.Extension.URI;
      arrayOfString2 = new String[3];
      arrayOfString2[0] = "notificationApiVersion";
      arrayOfString2[1] = "userId";
      arrayOfString2[2] = "packageName";
      localObject3 = new String[1];
      localObject3[0] = Integer.toString(paramInt);
      localCursor = ((ContentResolver)localObject4).query(localUri, arrayOfString2, "_id = ? ", (String[])localObject3, null);
      if ((localCursor != null) && (localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      {
        i = localCursor.getInt(localCursor.getColumnIndex("notificationApiVersion"));
        str1 = localCursor.getString(localCursor.getColumnIndex("userId"));
        str2 = localCursor.getString(localCursor.getColumnIndex("packageName"));
        str2 = str2;
      }
      if (localCursor != null) {
        localCursor.close();
      }
      if (i == 0) {
        localCursor = null;
      }
    }
    finally
    {
      Object localObject4;
      String[] arrayOfString2;
      Object localObject3;
      String[] arrayOfString1;
      label277:
      if (localCursor != null) {
        localCursor.close();
      }
    }
    try
    {
      localObject3 = paramContext.getContentResolver();
      localObject4 = Registration.ApiRegistration.URI;
      arrayOfString2 = new String[1];
      arrayOfString2[0] = "extensionId";
      arrayOfString1 = new String[1];
      arrayOfString1[0] = Integer.toString(paramInt);
      localCursor = ((ContentResolver)localObject3).query((Uri)localObject4, arrayOfString2, "extensionId = ?", arrayOfString1, null);
      if ((localCursor != null) && (localCursor.getCount() == 1))
      {
        removeExtension(paramContext, paramInt, str1, str2);
        bool = true;
      }
    }
    catch (SQLException localSQLException)
    {
      Dbg.e("query failed in removeExtensionIfOnlyOneHostApp", localSQLException);
      if (localCursor == null) {
        break label277;
      }
      localCursor.close();
      break label277;
    }
    finally
    {
      if (localCursor == null) {
        break label332;
      }
      localCursor.close();
    }
    return bool;
  }
  
  private void removeHostApp(Context paramContext, String paramString)
  {
    if (Dbg.d()) {
      Dbg.d("removeHostApp");
    }
    int i = lookUpHostAppId(paramContext, paramString);
    if (i != -1) {
      localObject2 = null;
    }
    for (;;)
    {
      try
      {
        localObject2 = lookUpDeviceId(paramContext, i);
        if (localObject2 != null)
        {
          boolean bool = ((Cursor)localObject2).moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (SQLException localSQLException)
      {
        Object localObject3;
        Object localObject4;
        int j;
        Object localObject6;
        Object localObject5;
        Dbg.e("delete failed in removeHostApp", localSQLException);
        if (localObject2 == null) {
          continue;
        }
        ((Cursor)localObject2).close();
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          continue;
        }
        ((Cursor)localObject2).close();
      }
      localObject2 = paramContext.getContentResolver();
      localObject3 = Registration.Device.URI;
      localObject4 = new String[1];
      localObject4[0] = Integer.toString(i);
      ((ContentResolver)localObject2).delete((Uri)localObject3, "hostAppId = ?", (String[])localObject4);
      localObject2 = paramContext.getContentResolver();
      localObject4 = Registration.HostApp.URI;
      localObject3 = new String[1];
      localObject3[0] = Integer.toString(i);
      ((ContentResolver)localObject2).delete((Uri)localObject4, "_id = ?", (String[])localObject3);
      return;
      j = ((Cursor)localObject2).getInt(((Cursor)localObject2).getColumnIndex("_id"));
      localObject6 = paramContext.getContentResolver();
      localObject4 = Registration.Led.URI;
      localObject5 = new String[1];
      localObject5[0] = Integer.toString(j);
      ((ContentResolver)localObject6).delete((Uri)localObject4, "deviceId = ?", (String[])localObject5);
      localObject5 = paramContext.getContentResolver();
      localObject4 = Registration.Input.URI;
      localObject6 = new String[1];
      localObject6[0] = Integer.toString(j);
      ((ContentResolver)localObject5).delete((Uri)localObject4, "deviceId = ?", (String[])localObject6);
      localObject5 = paramContext.getContentResolver();
      localObject4 = Registration.Sensor.URI;
      localObject6 = new String[1];
      localObject6[0] = Integer.toString(j);
      ((ContentResolver)localObject5).delete((Uri)localObject4, "deviceId = ?", (String[])localObject6);
      localObject5 = paramContext.getContentResolver();
      localObject6 = Registration.Display.URI;
      localObject4 = new String[1];
      localObject4[0] = Integer.toString(j);
      ((ContentResolver)localObject5).delete((Uri)localObject6, "deviceId = ?", (String[])localObject4);
    }
  }
  
  private void sendRegistrationIntent(Context paramContext)
  {
    Intent localIntent = new Intent("com.sonyericsson.extras.liveware.aef.registration.EXTENSION_REGISTER_REQUEST");
    if (AsfUtils.isHoneycombOrHigher(paramContext)) {
      localIntent.addFlags(32);
    }
    paramContext.sendBroadcast(localIntent);
  }
  
  private void sendRegistrationIntent(Context paramContext, int paramInt)
  {
    if (Dbg.d()) {
      Dbg.d("sendRegistrationIntent uid=" + paramInt);
    }
    String[] arrayOfString = paramContext.getPackageManager().getPackagesForUid(paramInt);
    for (int i = 0; i < arrayOfString.length; i++)
    {
      Intent localIntent = new Intent("com.sonyericsson.extras.liveware.aef.registration.EXTENSION_REGISTER_REQUEST");
      localIntent.setPackage(arrayOfString[i]);
      if (AsfUtils.isHoneycombOrHigher(paramContext)) {
        localIntent.addFlags(32);
      }
      paramContext.sendBroadcast(localIntent);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (Dbg.d()) {
      Dbg.d("onHandleIntent");
    }
    String str = paramIntent.getExtras().getString("SERVICE_COMMAND");
    if (str != null) {
      if (!"PACKAGE_ADDED".equals(str))
      {
        if (!"PACKAGE_REMOVED".equals(str))
        {
          if ((("ASF_STARTED".equals(str)) || ("HOST_APP_ADDED".equals(str))) && (isAnyHostAppPresent(this))) {
            sendRegistrationIntent(this);
          }
        }
        else
        {
          str = paramIntent.getExtras().getString("PACKAGE_NAME");
          Object localObject = lookUpPluginId(this, str);
          Integer localInteger = (Integer)((TreeMap)localObject).firstKey();
          if (localInteger.intValue() <= 0)
          {
            removeHostApp(this, str);
            if (!isLastHostApp(this)) {
              removeApiRegistration(this, str);
            } else {
              removeAllExtensions(this);
            }
          }
          else
          {
            localObject = (String)((TreeMap)localObject).get(localInteger);
            removeExtension(this, localInteger.intValue(), (String)localObject, str);
          }
        }
      }
      else
      {
        int i = paramIntent.getExtras().getInt("PACKAGE_UID");
        finishPendingInstall(i);
        if ((new PermissionHandler(null).checkPluginPermission(this, i)) && (isAnyHostAppPresent(this))) {
          sendRegistrationIntent(this, i);
        }
      }
    }
  }
  
  private static class PermissionHandler
    extends AefPermission
  {}
  
  public static class ServiceIntentCmd
  {
    public static final String EVENT_ASF_STARTED = "ASF_STARTED";
    public static final String EVENT_HOSTAPP_REGISTRATION_ADDED = "HOST_APP_ADDED";
    public static final String EVENT_PACKAGE_ADDED = "PACKAGE_ADDED";
    public static final String EVENT_PACKAGE_REMOVED = "PACKAGE_REMOVED";
    public static final String EXTRA_PACKAGE_NAME = "PACKAGE_NAME";
    public static final String EXTRA_PACKAGE_UID = "PACKAGE_UID";
    public static final String SERVICE_COMMAND_KEY = "SERVICE_COMMAND";
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.aef.service.DbMaintenanceService
 * JD-Core Version:    0.7.0.1
 */