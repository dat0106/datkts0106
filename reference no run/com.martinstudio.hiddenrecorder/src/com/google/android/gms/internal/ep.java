package com.google.android.gms.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ep
{
  private static final Object qm = new Object();
  private static boolean si = true;
  private static String sj;
  private static boolean sk = false;
  
  public static String a(Readable paramReadable)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = CharBuffer.allocate(2048);
    for (;;)
    {
      int i = paramReadable.read(localCharBuffer);
      if (i == -1) {
        return localStringBuilder.toString();
      }
      localCharBuffer.flip();
      localStringBuilder.append(localCharBuffer, 0, i);
    }
  }
  
  private static JSONArray a(Collection<?> paramCollection)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramCollection.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localJSONArray;
      }
      a(localJSONArray, localIterator.next());
    }
  }
  
  static JSONArray a(Object[] paramArrayOfObject)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    int i = paramArrayOfObject.length;
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return localJSONArray;
      }
      a(localJSONArray, paramArrayOfObject[j]);
    }
  }
  
  public static void a(Context paramContext, String paramString, WebSettings paramWebSettings)
  {
    paramWebSettings.setUserAgentString(c(paramContext, paramString));
  }
  
  public static void a(Context paramContext, String paramString, List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      new et(paramContext, paramString, (String)localIterator.next()).start();
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.setConnectTimeout(60000);
    paramHttpURLConnection.setInstanceFollowRedirects(paramBoolean);
    paramHttpURLConnection.setReadTimeout(60000);
    paramHttpURLConnection.setRequestProperty("User-Agent", c(paramContext, paramString));
    paramHttpURLConnection.setUseCaches(false);
  }
  
  public static void a(WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      er.a(paramWebView);
    }
  }
  
  private static void a(JSONArray paramJSONArray, Object paramObject)
    throws JSONException
  {
    if (!(paramObject instanceof Bundle))
    {
      if (!(paramObject instanceof Map))
      {
        if (!(paramObject instanceof Collection))
        {
          if (!(paramObject instanceof Object[])) {
            paramJSONArray.put(paramObject);
          } else {
            paramJSONArray.put(a((Object[])paramObject));
          }
        }
        else {
          paramJSONArray.put(a((Collection)paramObject));
        }
      }
      else {
        paramJSONArray.put(o((Map)paramObject));
      }
    }
    else {
      paramJSONArray.put(b((Bundle)paramObject));
    }
  }
  
  private static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
    throws JSONException
  {
    if (!(paramObject instanceof Bundle))
    {
      if (!(paramObject instanceof Map))
      {
        if (!(paramObject instanceof Collection))
        {
          if (!(paramObject instanceof Object[])) {
            paramJSONObject.put(paramString, paramObject);
          } else {
            paramJSONObject.put(paramString, a(Arrays.asList((Object[])paramObject)));
          }
        }
        else
        {
          if (paramString == null) {
            paramString = "null";
          }
          paramJSONObject.put(paramString, a((Collection)paramObject));
        }
      }
      else {
        paramJSONObject.put(paramString, o((Map)paramObject));
      }
    }
    else {
      paramJSONObject.put(paramString, b((Bundle)paramObject));
    }
  }
  
  public static boolean a(PackageManager paramPackageManager, String paramString1, String paramString2)
  {
    boolean bool;
    if (paramPackageManager.checkPermission(paramString2, paramString1) != 0) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(ClassLoader paramClassLoader, Class<?> paramClass, String paramString)
  {
    boolean bool = false;
    try
    {
      bool = paramClass.isAssignableFrom(Class.forName(paramString, false, paramClassLoader));
      bool = bool;
    }
    catch (Throwable localThrowable)
    {
      label15:
      break label15;
    }
    return bool;
  }
  
  public static Map<String, String> b(Uri paramUri)
  {
    if (paramUri != null)
    {
      localHashMap = new HashMap();
      Object localObject = new UrlQuerySanitizer();
      ((UrlQuerySanitizer)localObject).setAllowUnregisteredParamaters(true);
      ((UrlQuerySanitizer)localObject).setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
      ((UrlQuerySanitizer)localObject).parseUrl(paramUri.toString());
      localObject = ((UrlQuerySanitizer)localObject).getParameterList().iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext())
        {
          localHashMap = localHashMap;
          break;
        }
        UrlQuerySanitizer.ParameterValuePair localParameterValuePair = (UrlQuerySanitizer.ParameterValuePair)((Iterator)localObject).next();
        localHashMap.put(localParameterValuePair.mParameter, localParameterValuePair.mValue);
      }
    }
    HashMap localHashMap = null;
    return localHashMap;
  }
  
  private static JSONObject b(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localJSONObject;
      }
      String str = (String)localIterator.next();
      a(localJSONObject, str, paramBundle.get(str));
    }
  }
  
  public static void b(WebView paramWebView)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      er.b(paramWebView);
    }
  }
  
  public static boolean bL()
  {
    return si;
  }
  
  public static int bM()
  {
    int i;
    if (Build.VERSION.SDK_INT < 9) {
      i = 0;
    } else {
      i = 6;
    }
    return i;
  }
  
  public static int bN()
  {
    int i;
    if (Build.VERSION.SDK_INT < 9) {
      i = 1;
    } else {
      i = 7;
    }
    return i;
  }
  
  public static String bO()
  {
    UUID localUUID = UUID.randomUUID();
    byte[] arrayOfByte1 = BigInteger.valueOf(localUUID.getLeastSignificantBits()).toByteArray();
    byte[] arrayOfByte2 = BigInteger.valueOf(localUUID.getMostSignificantBits()).toByteArray();
    Object localObject2 = new BigInteger(1, arrayOfByte1).toString();
    int i = 0;
    while (i < 2) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(arrayOfByte1);
        localMessageDigest.update(arrayOfByte2);
        Object localObject1 = new byte[8];
        System.arraycopy(localMessageDigest.digest(), 0, localObject1, 0, 8);
        localObject1 = new BigInteger(1, (byte[])localObject1).toString();
        localObject2 = localObject1;
        label101:
        i++;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        break label101;
      }
    }
    return localObject2;
  }
  
  /* Error */
  private static String c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 23	com/google/android/gms/internal/ep:qm	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: getstatic 314	com/google/android/gms/internal/ep:sj	Ljava/lang/String;
    //   9: ifnull +12 -> 21
    //   12: getstatic 314	com/google/android/gms/internal/ep:sj	Ljava/lang/String;
    //   15: astore_3
    //   16: aload_2
    //   17: monitorexit
    //   18: goto +125 -> 143
    //   21: getstatic 139	android/os/Build$VERSION:SDK_INT	I
    //   24: bipush 17
    //   26: if_icmplt +59 -> 85
    //   29: aload_0
    //   30: invokestatic 320	com/google/android/gms/internal/es:getDefaultUserAgent	(Landroid/content/Context;)Ljava/lang/String;
    //   33: putstatic 314	com/google/android/gms/internal/ep:sj	Ljava/lang/String;
    //   36: new 32	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   43: getstatic 314	com/google/android/gms/internal/ep:sj	Ljava/lang/String;
    //   46: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 325
    //   52: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc_w 327
    //   62: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: putstatic 314	com/google/android/gms/internal/ep:sj	Ljava/lang/String;
    //   71: getstatic 314	com/google/android/gms/internal/ep:sj	Ljava/lang/String;
    //   74: astore_3
    //   75: aload_2
    //   76: monitorexit
    //   77: goto +66 -> 143
    //   80: astore_3
    //   81: aload_2
    //   82: monitorexit
    //   83: aload_3
    //   84: athrow
    //   85: invokestatic 332	com/google/android/gms/internal/eu:bR	()Z
    //   88: ifne +45 -> 133
    //   91: getstatic 336	com/google/android/gms/internal/eu:ss	Landroid/os/Handler;
    //   94: new 6	com/google/android/gms/internal/ep$1
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 339	com/google/android/gms/internal/ep$1:<init>	(Landroid/content/Context;)V
    //   102: invokevirtual 345	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   105: pop
    //   106: getstatic 314	com/google/android/gms/internal/ep:sj	Ljava/lang/String;
    //   109: astore_3
    //   110: aload_3
    //   111: ifnonnull -75 -> 36
    //   114: getstatic 23	com/google/android/gms/internal/ep:qm	Ljava/lang/Object;
    //   117: invokevirtual 348	java/lang/Object:wait	()V
    //   120: goto -14 -> 106
    //   123: pop
    //   124: getstatic 314	com/google/android/gms/internal/ep:sj	Ljava/lang/String;
    //   127: astore_3
    //   128: aload_2
    //   129: monitorexit
    //   130: goto +13 -> 143
    //   133: aload_0
    //   134: invokestatic 351	com/google/android/gms/internal/ep:l	(Landroid/content/Context;)Ljava/lang/String;
    //   137: putstatic 314	com/google/android/gms/internal/ep:sj	Ljava/lang/String;
    //   140: goto -104 -> 36
    //   143: aload_3
    //   144: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramContext	Context
    //   0	145	1	paramString	String
    //   3	126	2	localObject1	Object
    //   15	60	3	str1	String
    //   80	4	3	localObject2	Object
    //   109	35	3	str2	String
    //   123	1	6	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   6	83	80	finally
    //   85	110	80	finally
    //   114	120	80	finally
    //   124	140	80	finally
    //   114	120	123	java/lang/InterruptedException
  }
  
  public static boolean j(Context paramContext)
  {
    boolean bool1 = false;
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    localObject = paramContext.getPackageManager().resolveActivity((Intent)localObject, 65536);
    if ((localObject != null) && (((ResolveInfo)localObject).activityInfo != null))
    {
      if ((0x10 & ((ResolveInfo)localObject).activityInfo.configChanges) != 0)
      {
        int i = 1;
      }
      else
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[bool1] = "keyboard";
        ev.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject1));
        int j = 0;
      }
      if ((0x20 & ((ResolveInfo)localObject).activityInfo.configChanges) == 0)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[bool1] = "keyboardHidden";
        ev.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject2));
        int k = 0;
      }
      if ((0x80 & ((ResolveInfo)localObject).activityInfo.configChanges) == 0)
      {
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[bool1] = "orientation";
        ev.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject3));
        int m = 0;
      }
      if ((0x100 & ((ResolveInfo)localObject).activityInfo.configChanges) == 0)
      {
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[bool1] = "screenLayout";
        ev.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject4));
        int n = 0;
      }
      if ((0x200 & ((ResolveInfo)localObject).activityInfo.configChanges) == 0)
      {
        Object[] arrayOfObject5 = new Object[1];
        arrayOfObject5[bool1] = "uiMode";
        ev.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject5));
        int i1 = 0;
      }
      boolean bool2;
      if ((0x400 & ((ResolveInfo)localObject).activityInfo.configChanges) == 0)
      {
        Object[] arrayOfObject6 = new Object[1];
        arrayOfObject6[bool1] = "screenSize";
        ev.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", arrayOfObject6));
        bool2 = false;
      }
      if ((0x800 & ((ResolveInfo)localObject).activityInfo.configChanges) != 0)
      {
        bool1 = bool2;
      }
      else
      {
        localObject = new Object[1];
        localObject[bool1] = "smallestScreenSize";
        ev.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", (Object[])localObject));
      }
    }
    else
    {
      ev.D("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
    }
    return bool1;
  }
  
  public static void k(Context paramContext)
  {
    if (!sk)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      paramContext.getApplicationContext().registerReceiver(new a(null), localIntentFilter);
      sk = true;
    }
  }
  
  private static String l(Context paramContext)
  {
    return new WebView(paramContext).getSettings().getUserAgentString();
  }
  
  public static int m(Context paramContext)
  {
    int k = 0;
    int j;
    int m;
    if (!(paramContext instanceof Activity))
    {
      int i = 0;
    }
    else
    {
      Window localWindow = ((Activity)paramContext).getWindow();
      Rect localRect = new Rect();
      localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect);
      j = localRect.top;
      m = localWindow.findViewById(16908290).getTop() - j;
    }
    return m + j;
  }
  
  public static JSONObject o(Map<String, ?> paramMap)
    throws JSONException
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        a(localJSONObject, str, paramMap.get(str));
      }
      return localJSONObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new JSONException("Could not convert map to JSON: " + localClassCastException.getMessage());
    }
  }
  
  public static String v(String paramString)
  {
    return Uri.parse(paramString).buildUpon().query(null).build().toString();
  }
  
  private static final class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (!"android.intent.action.USER_PRESENT".equals(paramIntent.getAction()))
      {
        if ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
          ep.p(false);
        }
      }
      else {
        ep.p(true);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ep
 * JD-Core Version:    0.7.0.1
 */