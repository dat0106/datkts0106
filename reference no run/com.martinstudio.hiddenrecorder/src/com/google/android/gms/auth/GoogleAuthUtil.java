package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.IOException;
import java.net.URISyntaxException;

public final class GoogleAuthUtil
{
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  public static final String KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID;
  public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
  @Deprecated
  public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  private static final ComponentName yR = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
  private static final ComponentName yS = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
  private static final Intent yT = new Intent().setPackage("com.google.android.gms").setComponent(yR);
  private static final Intent yU = new Intent().setPackage("com.google.android.gms").setComponent(yS);
  
  static
  {
    String str;
    if (Build.VERSION.SDK_INT < 11) {
      str = "callerUid";
    } else {
      str = "callerUid";
    }
    KEY_CALLER_UID = str;
    if (Build.VERSION.SDK_INT < 14) {
      str = "androidPackageName";
    } else {
      str = "androidPackageName";
    }
    KEY_ANDROID_PACKAGE_NAME = str;
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    try
    {
      String str = getToken(paramContext, paramString1, paramString2, paramBundle);
      return str;
    }
    catch (GooglePlayServicesAvailabilityException localGooglePlayServicesAvailabilityException)
    {
      int i = localGooglePlayServicesAvailabilityException.getConnectionStatusCode();
      a locala;
      if (b(paramContext, i))
      {
        locala = new a(paramContext.getApplicationContext());
        locala.sendMessageDelayed(locala.obtainMessage(1), 30000L);
      }
      for (;;)
      {
        throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        GooglePlayServicesUtil.showErrorNotification(locala, paramContext);
      }
    }
    catch (UserRecoverableAuthException localUserRecoverableAuthException)
    {
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
  }
  
  private static boolean ac(String paramString)
  {
    boolean bool;
    if ((!"NetworkError".equals(paramString)) && (!"ServiceUnavailable".equals(paramString)) && (!"Timeout".equals(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean ad(String paramString)
  {
    boolean bool;
    if ((!"BadAuthentication".equals(paramString)) && (!"CaptchaRequired".equals(paramString)) && (!"DeviceManagementRequiredOrSyncDisabled".equals(paramString)) && (!"NeedPermission".equals(paramString)) && (!"NeedsBrowser".equals(paramString)) && (!"UserCancel".equals(paramString)) && (!"AppDownloadRequired".equals(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean b(Context paramContext, int paramInt)
  {
    int i = 1;
    PackageManager localPackageManager;
    if (paramInt == i) {
      localPackageManager = paramContext.getPackageManager();
    }
    for (;;)
    {
      try
      {
        boolean bool = localPackageManager.getApplicationInfo("com.google.android.gms", 8192).enabled;
        if (bool) {
          return i;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      i = 0;
    }
  }
  
  /* Error */
  public static void clearToken(Context paramContext, String paramString)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 107	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore_2
    //   5: ldc 188
    //   7: invokestatic 193	com/google/android/gms/internal/hn:az	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokestatic 196	com/google/android/gms/auth/GoogleAuthUtil:w	(Landroid/content/Context;)V
    //   14: new 89	android/os/Bundle
    //   17: dup
    //   18: invokespecial 90	android/os/Bundle:<init>	()V
    //   21: astore 4
    //   23: aload_0
    //   24: invokevirtual 199	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   27: getfield 202	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   30: astore_3
    //   31: aload 4
    //   33: ldc 204
    //   35: aload_3
    //   36: invokevirtual 207	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload 4
    //   41: getstatic 43	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   44: invokevirtual 210	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   47: ifne +12 -> 59
    //   50: aload 4
    //   52: getstatic 43	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   55: aload_3
    //   56: invokevirtual 207	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: new 212	com/google/android/gms/common/a
    //   62: dup
    //   63: invokespecial 213	com/google/android/gms/common/a:<init>	()V
    //   66: astore_3
    //   67: aload_2
    //   68: getstatic 73	com/google/android/gms/auth/GoogleAuthUtil:yT	Landroid/content/Intent;
    //   71: aload_3
    //   72: iconst_1
    //   73: invokevirtual 217	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   76: ifeq +101 -> 177
    //   79: aload_3
    //   80: invokevirtual 221	com/google/android/gms/common/a:er	()Landroid/os/IBinder;
    //   83: invokestatic 226	com/google/android/gms/internal/s$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/s;
    //   86: aload_1
    //   87: aload 4
    //   89: invokeinterface 231 3 0
    //   94: astore 5
    //   96: aload 5
    //   98: getstatic 236	com/google/android/gms/internal/ge:zI	Ljava/lang/String;
    //   101: invokevirtual 240	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore 4
    //   106: aload 5
    //   108: ldc 242
    //   110: invokevirtual 245	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   113: ifne +46 -> 159
    //   116: new 83	com/google/android/gms/auth/GoogleAuthException
    //   119: dup
    //   120: aload 4
    //   122: invokespecial 246	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   125: athrow
    //   126: astore 4
    //   128: ldc 248
    //   130: ldc 250
    //   132: aload 4
    //   134: invokestatic 256	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   137: pop
    //   138: new 79	java/io/IOException
    //   141: dup
    //   142: ldc_w 258
    //   145: invokespecial 259	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   148: athrow
    //   149: astore 4
    //   151: aload_2
    //   152: aload_3
    //   153: invokevirtual 263	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   156: aload 4
    //   158: athrow
    //   159: aload_2
    //   160: aload_3
    //   161: invokevirtual 263	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   164: return
    //   165: pop
    //   166: new 83	com/google/android/gms/auth/GoogleAuthException
    //   169: dup
    //   170: ldc_w 265
    //   173: invokespecial 246	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   176: athrow
    //   177: new 79	java/io/IOException
    //   180: dup
    //   181: ldc_w 267
    //   184: invokespecial 259	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramContext	Context
    //   0	188	1	paramString	String
    //   4	156	2	localContext	Context
    //   30	131	3	localObject1	Object
    //   21	100	4	localObject2	Object
    //   126	7	4	localRemoteException	android.os.RemoteException
    //   149	8	4	localObject3	Object
    //   94	13	5	localBundle	Bundle
    //   165	1	8	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   79	126	126	android/os/RemoteException
    //   79	126	149	finally
    //   128	149	149	finally
    //   166	177	149	finally
    //   79	126	165	java/lang/InterruptedException
  }
  
  private static void g(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("Callback cannot be null.");
    }
    String str = paramIntent.toUri(1);
    try
    {
      Intent.parseUri(str, 1);
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
    }
  }
  
  public static String getToken(Context paramContext, String paramString1, String paramString2)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, paramString1, paramString2, new Bundle());
  }
  
  /* Error */
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 107	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore 4
    //   6: ldc 188
    //   8: invokestatic 193	com/google/android/gms/internal/hn:az	(Ljava/lang/String;)V
    //   11: aload 4
    //   13: invokestatic 196	com/google/android/gms/auth/GoogleAuthUtil:w	(Landroid/content/Context;)V
    //   16: aload_3
    //   17: ifnonnull +125 -> 142
    //   20: new 89	android/os/Bundle
    //   23: dup
    //   24: invokespecial 90	android/os/Bundle:<init>	()V
    //   27: astore 6
    //   29: aload_0
    //   30: invokevirtual 199	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   33: getfield 202	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   36: astore 5
    //   38: aload 6
    //   40: ldc 204
    //   42: aload 5
    //   44: invokevirtual 207	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload 6
    //   49: getstatic 43	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   52: invokevirtual 210	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   55: ifne +13 -> 68
    //   58: aload 6
    //   60: getstatic 43	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   63: aload 5
    //   65: invokevirtual 207	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: new 212	com/google/android/gms/common/a
    //   71: dup
    //   72: invokespecial 213	com/google/android/gms/common/a:<init>	()V
    //   75: astore 5
    //   77: aload 4
    //   79: getstatic 73	com/google/android/gms/auth/GoogleAuthUtil:yT	Landroid/content/Intent;
    //   82: aload 5
    //   84: iconst_1
    //   85: invokevirtual 217	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   88: ifeq +185 -> 273
    //   91: aload 5
    //   93: invokevirtual 221	com/google/android/gms/common/a:er	()Landroid/os/IBinder;
    //   96: invokestatic 226	com/google/android/gms/internal/s$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/s;
    //   99: aload_1
    //   100: aload_2
    //   101: aload 6
    //   103: invokeinterface 290 4 0
    //   108: astore 6
    //   110: aload 6
    //   112: ldc_w 292
    //   115: invokevirtual 240	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 8
    //   120: aload 8
    //   122: invokestatic 298	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: istore 7
    //   127: iload 7
    //   129: ifne +26 -> 155
    //   132: aload 4
    //   134: aload 5
    //   136: invokevirtual 263	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   139: aload 8
    //   141: areturn
    //   142: new 89	android/os/Bundle
    //   145: dup
    //   146: aload_3
    //   147: invokespecial 301	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   150: astore 6
    //   152: goto -123 -> 29
    //   155: aload 6
    //   157: ldc_w 303
    //   160: invokevirtual 240	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore 7
    //   165: aload 6
    //   167: ldc_w 305
    //   170: invokevirtual 309	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   173: checkcast 61	android/content/Intent
    //   176: astore 6
    //   178: aload 7
    //   180: invokestatic 311	com/google/android/gms/auth/GoogleAuthUtil:ad	(Ljava/lang/String;)Z
    //   183: ifeq +50 -> 233
    //   186: new 87	com/google/android/gms/auth/UserRecoverableAuthException
    //   189: dup
    //   190: aload 7
    //   192: aload 6
    //   194: invokespecial 314	com/google/android/gms/auth/UserRecoverableAuthException:<init>	(Ljava/lang/String;Landroid/content/Intent;)V
    //   197: athrow
    //   198: astore 6
    //   200: ldc 248
    //   202: ldc 250
    //   204: aload 6
    //   206: invokestatic 256	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   209: pop
    //   210: new 79	java/io/IOException
    //   213: dup
    //   214: ldc_w 258
    //   217: invokespecial 259	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   220: athrow
    //   221: astore 6
    //   223: aload 4
    //   225: aload 5
    //   227: invokevirtual 263	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   230: aload 6
    //   232: athrow
    //   233: aload 7
    //   235: invokestatic 316	com/google/android/gms/auth/GoogleAuthUtil:ac	(Ljava/lang/String;)Z
    //   238: ifeq +25 -> 263
    //   241: new 79	java/io/IOException
    //   244: dup
    //   245: aload 7
    //   247: invokespecial 259	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   250: athrow
    //   251: pop
    //   252: new 83	com/google/android/gms/auth/GoogleAuthException
    //   255: dup
    //   256: ldc_w 265
    //   259: invokespecial 246	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   262: athrow
    //   263: new 83	com/google/android/gms/auth/GoogleAuthException
    //   266: dup
    //   267: aload 7
    //   269: invokespecial 246	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   272: athrow
    //   273: new 79	java/io/IOException
    //   276: dup
    //   277: ldc_w 267
    //   280: invokespecial 259	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   283: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramContext	Context
    //   0	284	1	paramString1	String
    //   0	284	2	paramString2	String
    //   0	284	3	paramBundle	Bundle
    //   4	220	4	localContext	Context
    //   36	190	5	localObject1	Object
    //   27	166	6	localObject2	Object
    //   198	7	6	localRemoteException	android.os.RemoteException
    //   221	10	6	localObject3	Object
    //   125	3	7	bool	boolean
    //   163	105	7	str1	String
    //   118	22	8	str2	String
    //   251	1	12	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   91	127	198	android/os/RemoteException
    //   155	198	198	android/os/RemoteException
    //   233	251	198	android/os/RemoteException
    //   263	273	198	android/os/RemoteException
    //   91	127	221	finally
    //   155	198	221	finally
    //   200	221	221	finally
    //   233	251	221	finally
    //   252	263	221	finally
    //   263	273	221	finally
    //   91	127	251	java/lang/InterruptedException
    //   155	198	251	java/lang/InterruptedException
    //   233	251	251	java/lang/InterruptedException
    //   263	273	251	java/lang/InterruptedException
  }
  
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    paramBundle.putBoolean("handle_notification", true);
    return a(paramContext, paramString1, paramString2, paramBundle);
  }
  
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, Intent paramIntent)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    g(paramIntent);
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    paramBundle.putParcelable("callback_intent", paramIntent);
    paramBundle.putBoolean("handle_notification", true);
    return a(paramContext, paramString1, paramString2, paramBundle);
  }
  
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      if (paramBundle1 == null) {
        paramBundle1 = new Bundle();
      }
      if (paramBundle2 == null) {
        paramBundle2 = new Bundle();
      }
      ContentResolver.validateSyncExtrasBundle(paramBundle2);
      paramBundle1.putString("authority", paramString3);
      paramBundle1.putBundle("sync_extras", paramBundle2);
      paramBundle1.putBoolean("handle_notification", true);
      return a(paramContext, paramString1, paramString2, paramBundle1);
    }
    throw new IllegalArgumentException("Authority cannot be empty or null.");
  }
  
  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
  
  private static void w(Context paramContext)
    throws GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtil.w(paramContext);
      return;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      throw new GooglePlayServicesAvailabilityException(localGooglePlayServicesRepairableException.getConnectionStatusCode(), localGooglePlayServicesRepairableException.getMessage(), localGooglePlayServicesRepairableException.getIntent());
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      throw new GoogleAuthException(localGooglePlayServicesNotAvailableException.getMessage());
    }
  }
  
  private static class a
    extends Handler
  {
    private final Context lx;
    
    a(Context paramContext)
    {
      super();
      this.lx = paramContext;
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 1)
      {
        Log.wtf("GoogleAuthUtil", "Don't know how to handle this message: " + paramMessage.what);
      }
      else
      {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.lx);
        if (GooglePlayServicesUtil.isUserRecoverableError(i)) {
          GooglePlayServicesUtil.showErrorNotification(i, this.lx);
        }
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.GoogleAuthUtil
 * JD-Core Version:    0.7.0.1
 */