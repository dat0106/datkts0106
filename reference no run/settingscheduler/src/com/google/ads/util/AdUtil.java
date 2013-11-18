package com.google.ads.util;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.ads.AdActivity;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AdUtil
{
  public static final int a = a(Build.VERSION.SDK);
  private static Boolean b = null;
  private static String c = null;
  private static String d;
  private static String e = null;
  private static AudioManager f;
  private static boolean g = true;
  private static boolean h = false;
  private static String i = null;
  
  public static int a()
  {
    int j;
    if (a < 9) {
      j = 0;
    } else {
      j = 6;
    }
    return j;
  }
  
  public static int a(Context paramContext, DisplayMetrics paramDisplayMetrics)
  {
    int j;
    if (a < 4) {
      j = paramDisplayMetrics.heightPixels;
    } else {
      j = e.a(paramContext, paramDisplayMetrics);
    }
    return j;
  }
  
  public static int a(String paramString)
  {
    try
    {
      j = Integer.parseInt(paramString);
      j = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        b.e("The Android SDK version couldn't be parsed to an int: " + Build.VERSION.SDK);
        b.e("Defaulting to Android SDK version 3.");
        int j = 3;
      }
    }
    return j;
  }
  
  public static DisplayMetrics a(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics;
    if (paramActivity.getWindowManager() != null)
    {
      localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    }
    else
    {
      localDisplayMetrics = null;
    }
    return localDisplayMetrics;
  }
  
  public static String a(Context paramContext)
  {
    if (c == null)
    {
      str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if ((str != null) && (!c())) {
        str = b(str);
      } else {
        str = b("emulator");
      }
      if (str != null) {
        c = str.toUpperCase(Locale.US);
      }
    }
    else
    {
      return c;
    }
    String str = null;
    return str;
  }
  
  public static String a(Location paramLocation)
  {
    String str;
    if (paramLocation != null)
    {
      str = c(b(paramLocation));
      str = "e1+" + str;
    }
    else
    {
      str = null;
    }
    return str;
  }
  
  public static String a(Readable paramReadable)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = CharBuffer.allocate(2048);
    for (;;)
    {
      int j = paramReadable.read(localCharBuffer);
      if (j == -1) {
        return localStringBuilder.toString();
      }
      localCharBuffer.flip();
      localStringBuilder.append(localCharBuffer, 0, j);
    }
  }
  
  public static String a(Map<String, Object> paramMap)
  {
    Object localObject = null;
    try
    {
      String str = b(paramMap).toString();
      localObject = str;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        b.d("JsonException in serialization: ", localJSONException);
      }
    }
    return localObject;
  }
  
  public static JSONArray a(Set<Object> paramSet)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramSet == null) || (paramSet.isEmpty())) {}
    for (Object localObject1 = localJSONArray;; localObject1 = localJSONArray)
    {
      return localObject1;
      localObject1 = paramSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((localObject2 instanceof String)) || ((localObject2 instanceof Integer)) || ((localObject2 instanceof Double)) || ((localObject2 instanceof Long)) || ((localObject2 instanceof Float))) {
          localJSONArray.put(localObject2);
        } else if ((localObject2 instanceof Map)) {
          try
          {
            localJSONArray.put(b((Map)localObject2));
          }
          catch (ClassCastException localClassCastException1)
          {
            b.d("Unknown map type in json serialization: ", localClassCastException1);
          }
        } else if ((localClassCastException1 instanceof Set)) {
          try
          {
            localJSONArray.put(a((Set)localClassCastException1));
          }
          catch (ClassCastException localClassCastException2)
          {
            b.d("Unknown map type in json serialization: ", localClassCastException2);
          }
        } else {
          b.e("Unknown value in json serialization: " + localClassCastException2);
        }
      }
    }
  }
  
  public static void a(WebView paramWebView)
  {
    String str = i(paramWebView.getContext().getApplicationContext());
    paramWebView.getSettings().setUserAgentString(str);
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection, Context paramContext)
  {
    paramHttpURLConnection.setRequestProperty("User-Agent", i(paramContext));
  }
  
  public static void a(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public static boolean a(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool;
    if ((paramInt1 & paramInt2) != 0)
    {
      bool = true;
    }
    else
    {
      b.b("The android:configChanges value of the com.google.ads.AdActivity must include " + paramString + ".");
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(Intent paramIntent, Context paramContext)
  {
    boolean bool;
    if (paramContext.getPackageManager().resolveActivity(paramIntent, 65536) == null) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Uri paramUri)
  {
    boolean bool = false;
    if (paramUri != null)
    {
      String str = paramUri.getScheme();
      if (("http".equalsIgnoreCase(str)) || ("https".equalsIgnoreCase(str))) {
        bool = true;
      }
    }
    return bool;
  }
  
  static boolean a(d paramd)
  {
    if (paramd == null) {
      paramd = d.d;
    }
    return paramd.equals(d.e);
  }
  
  public static int b()
  {
    int j;
    if (a < 9) {
      j = 1;
    } else {
      j = 7;
    }
    return j;
  }
  
  public static int b(Context paramContext, DisplayMetrics paramDisplayMetrics)
  {
    int j;
    if (a < 4) {
      j = paramDisplayMetrics.widthPixels;
    } else {
      j = e.b(paramContext, paramDisplayMetrics);
    }
    return j;
  }
  
  private static String b(Location paramLocation)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(1000L * paramLocation.getTime());
    arrayOfObject[1] = Long.valueOf((10000000.0D * paramLocation.getLatitude()));
    arrayOfObject[2] = Long.valueOf((10000000.0D * paramLocation.getLongitude()));
    arrayOfObject[3] = Long.valueOf((1000.0F * paramLocation.getAccuracy()));
    return String.format(localLocale, "role: 6 producer: 24 historical_role: 1 historical_producer: 12 timestamp: %d latlng < latitude_e7: %d longitude_e7: %d> radius: %d", arrayOfObject);
  }
  
  public static String b(String paramString)
  {
    localObject = null;
    if ((paramString != null) && (paramString.length() > 0)) {}
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes(), 0, paramString.length());
      Locale localLocale = Locale.US;
      localObject = new Object[1];
      localObject[0] = new BigInteger(1, localMessageDigest.digest());
      localObject = String.format(localLocale, "%032X", (Object[])localObject);
      localObject = localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        localObject = paramString.substring(0, 32);
      }
    }
    return localObject;
  }
  
  public static HashMap<String, String> b(Uri paramUri)
  {
    HashMap localHashMap = null;
    Object localObject;
    int m;
    if (paramUri != null)
    {
      localHashMap = new HashMap();
      localObject = paramUri.getEncodedQuery();
      if (localObject != null)
      {
        localObject = ((String)localObject).split("&");
        m = localObject.length;
      }
    }
    for (int k = 0;; k++)
    {
      if (k >= m)
      {
        localHashMap = localHashMap;
        return localHashMap;
      }
      String str = localObject[k];
      int j = str.indexOf("=");
      if (j >= 0) {
        localHashMap.put(Uri.decode(str.substring(0, j)), Uri.decode(str.substring(j + 1, str.length())));
      } else {
        localHashMap.put(Uri.decode(str), null);
      }
    }
  }
  
  public static JSONObject b(Map<String, Object> paramMap)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramMap == null) || (paramMap.isEmpty())) {}
    for (Object localObject1 = localJSONObject;; localObject1 = localJSONObject)
    {
      return localObject1;
      localObject1 = paramMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = paramMap.get(str);
        if (((localObject2 instanceof String)) || ((localObject2 instanceof Integer)) || ((localObject2 instanceof Double)) || ((localObject2 instanceof Long)) || ((localObject2 instanceof Float))) {
          localJSONObject.put(str, localObject2);
        } else if ((localObject2 instanceof Map)) {
          try
          {
            localJSONObject.put(str, b((Map)localObject2));
          }
          catch (ClassCastException localClassCastException1)
          {
            b.d("Unknown map type in json serialization: ", localClassCastException1);
          }
        } else if ((localObject2 instanceof Set)) {
          try
          {
            localJSONObject.put(localClassCastException1, a((Set)localObject2));
          }
          catch (ClassCastException localClassCastException2)
          {
            b.d("Unknown map type in json serialization: ", localClassCastException2);
          }
        } else {
          b.e("Unknown value in json serialization: " + localObject2);
        }
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    PackageManager localPackageManager = paramContext.getPackageManager();
    String str = paramContext.getPackageName();
    if (localPackageManager.checkPermission("android.permission.INTERNET", str) != -1)
    {
      if (localPackageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", str) != -1) {
        bool = true;
      } else {
        b.b("ACCESS_NETWORK_STATE permissions must be enabled in AndroidManifest.xml.");
      }
    }
    else {
      b.b("INTERNET permissions must be enabled in AndroidManifest.xml.");
    }
    return bool;
  }
  
  private static String c(String paramString)
  {
    try
    {
      Object localObject2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localObject1 = new byte[16];
      localObject1[0] = 10;
      localObject1[1] = 55;
      localObject1[2] = -112;
      localObject1[3] = -47;
      localObject1[4] = -6;
      localObject1[5] = 7;
      localObject1[6] = 11;
      localObject1[7] = 75;
      localObject1[8] = -7;
      localObject1[9] = -121;
      localObject1[10] = 121;
      localObject1[11] = 69;
      localObject1[12] = 80;
      localObject1[13] = -61;
      localObject1[14] = 15;
      localObject1[15] = 5;
      ((Cipher)localObject2).init(1, new SecretKeySpec((byte[])localObject1, "AES"));
      localObject1 = ((Cipher)localObject2).getIV();
      byte[] arrayOfByte = ((Cipher)localObject2).doFinal(paramString.getBytes());
      localObject2 = new byte[localObject1.length + arrayOfByte.length];
      System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
      System.arraycopy(arrayOfByte, 0, localObject2, localObject1.length, arrayOfByte.length);
      localObject1 = c.b((byte[])localObject2, 11);
      localObject1 = localObject1;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      for (;;)
      {
        Object localObject1 = null;
      }
    }
    return localObject1;
  }
  
  public static boolean c()
  {
    return a(null);
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool;
    if (b == null)
    {
      ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveActivity(new Intent(paramContext, AdActivity.class), 65536);
      b = Boolean.valueOf(true);
      if ((localResolveInfo != null) && (localResolveInfo.activityInfo != null))
      {
        if (!a(localResolveInfo.activityInfo.configChanges, 16, "keyboard")) {
          b = Boolean.valueOf(false);
        }
        if (!a(localResolveInfo.activityInfo.configChanges, 32, "keyboardHidden")) {
          b = Boolean.valueOf(false);
        }
        if (!a(localResolveInfo.activityInfo.configChanges, 128, "orientation")) {
          b = Boolean.valueOf(false);
        }
        if (!a(localResolveInfo.activityInfo.configChanges, 256, "screenLayout")) {
          b = Boolean.valueOf(false);
        }
        if (!a(localResolveInfo.activityInfo.configChanges, 512, "uiMode")) {
          b = Boolean.valueOf(false);
        }
        if (!a(localResolveInfo.activityInfo.configChanges, 1024, "screenSize")) {
          b = Boolean.valueOf(false);
        }
        if (!a(localResolveInfo.activityInfo.configChanges, 2048, "smallestScreenSize")) {
          b = Boolean.valueOf(false);
        }
      }
      else
      {
        b.b("Could not find com.google.ads.AdActivity, please make sure it is registered in AndroidManifest.xml.");
        b = Boolean.valueOf(false);
      }
      bool = b.booleanValue();
    }
    else
    {
      bool = b.booleanValue();
    }
    return bool;
  }
  
  public static String d(Context paramContext)
  {
    Object localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (localObject != null) {
      switch (((NetworkInfo)localObject).getType())
      {
      default: 
        localObject = "unknown";
        break;
      case 0: 
        localObject = "ed";
        break;
      case 1: 
        localObject = "wi";
        break;
      }
    } else {
      localObject = null;
    }
    return localObject;
  }
  
  public static boolean d()
  {
    return g;
  }
  
  public static String e(Context paramContext)
  {
    if (d == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = paramContext.getPackageManager();
      List localList = ((PackageManager)localObject).queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=donuts")), 65536);
      if ((localList == null) || (localList.size() == 0)) {
        localStringBuilder.append("m");
      }
      localList = ((PackageManager)localObject).queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.google")), 65536);
      if ((localList == null) || (localList.size() == 0))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append("a");
      }
      localObject = ((PackageManager)localObject).queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("tel://6509313940")), 65536);
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append("t");
      }
      d = localStringBuilder.toString();
    }
    return d;
  }
  
  public static String f(Context paramContext)
  {
    String str = null;
    if (e != null) {
      str = e;
    }
    for (;;)
    {
      return str;
      try
      {
        Object localObject2 = paramContext.getPackageManager();
        Object localObject1 = ((PackageManager)localObject2).resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.ads")), 65536);
        if (localObject1 != null)
        {
          localObject1 = ((ResolveInfo)localObject1).activityInfo;
          if (localObject1 != null)
          {
            localObject2 = ((PackageManager)localObject2).getPackageInfo(((ActivityInfo)localObject1).packageName, 0);
            if (localObject2 != null)
            {
              e = ((PackageInfo)localObject2).versionCode + "." + ((ActivityInfo)localObject1).packageName;
              str = e;
            }
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
  }
  
  public static a g(Context paramContext)
  {
    if (f == null) {
      f = (AudioManager)paramContext.getSystemService("audio");
    }
    int j = f.getMode();
    a locala;
    if (!c())
    {
      if ((!f.isMusicActive()) && (!f.isSpeakerphoneOn()) && (j != 2) && (j != 1))
      {
        j = f.getRingerMode();
        if ((j != 0) && (j != 1)) {
          locala = a.b;
        } else {
          locala = a.d;
        }
      }
      else
      {
        locala = a.d;
      }
    }
    else {
      locala = a.e;
    }
    return locala;
  }
  
  public static void h(Context paramContext)
  {
    if (!h)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      paramContext.registerReceiver(new UserActivityReceiver(), localIntentFilter);
      h = true;
    }
  }
  
  public static String i(Context paramContext)
  {
    if (i == null)
    {
      String str1 = new WebView(paramContext).getSettings().getUserAgentString();
      if ((str1 == null) || (str1.length() == 0) || (str1.equals("Java0")))
      {
        str1 = System.getProperty("os.name", "Linux");
        String str3 = "Android " + Build.VERSION.RELEASE;
        Object localObject = Locale.getDefault();
        String str2 = ((Locale)localObject).getLanguage().toLowerCase(Locale.US);
        if (str2.length() == 0) {
          str2 = "en";
        }
        localObject = ((Locale)localObject).getCountry().toLowerCase(Locale.US);
        if (((String)localObject).length() > 0) {
          str2 = str2 + "-" + (String)localObject;
        }
        localObject = Build.MODEL + " Build/" + Build.ID;
        str1 = "Mozilla/5.0 (" + str1 + "; U; " + str3 + "; " + str2 + "; " + (String)localObject + ") AppleWebKit/0.0 (KHTML, like " + "Gecko) Version/0.0 Mobile Safari/0.0";
      }
      i = str1 + " (Mobile; " + "afma-sdk-a-v" + "6.2.1" + ")";
    }
    return i;
  }
  
  public static class UserActivityReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (!paramIntent.getAction().equals("android.intent.action.USER_PRESENT"))
      {
        if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF")) {
          AdUtil.a(false);
        }
      }
      else {
        AdUtil.a(true);
      }
    }
  }
  
  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[6];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      g = arrayOfa;
    }
    
    private a() {}
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.util.AdUtil
 * JD-Core Version:    0.7.0.1
 */