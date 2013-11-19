package com.facebook.android;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class Util
{
  private static boolean ENABLE_LOG = false;
  
  public static void clearCookies(Context paramContext)
  {
    CookieSyncManager.createInstance(paramContext);
    CookieManager.getInstance().removeAllCookie();
  }
  
  public static Bundle decodeUrl(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      String[] arrayOfString1 = paramString.split("&");
      int i = arrayOfString1.length;
      for (int j = 0; j < i; j++)
      {
        String[] arrayOfString2 = arrayOfString1[j].split("=");
        if (arrayOfString2.length == 2) {
          localBundle.putString(URLDecoder.decode(arrayOfString2[0]), URLDecoder.decode(arrayOfString2[1]));
        }
      }
    }
    return localBundle;
  }
  
  public static String encodePostBody(Bundle paramBundle, String paramString)
  {
    Object localObject1;
    if (paramBundle != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = paramBundle.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = paramBundle.get(str);
        if ((localObject2 instanceof String))
        {
          localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n" + (String)localObject2);
          localStringBuilder.append("\r\n--" + paramString + "\r\n");
        }
      }
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      localObject1 = "";
    }
    return localObject1;
  }
  
  public static String encodeUrl(Bundle paramBundle)
  {
    Object localObject;
    if (paramBundle != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 1;
      localObject = paramBundle.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ((paramBundle.get(str) instanceof String))
        {
          if (i == 0) {
            localStringBuilder.append("&");
          } else {
            i = 0;
          }
          localStringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(paramBundle.getString(str)));
        }
      }
      localObject = localStringBuilder.toString();
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public static void logd(String paramString1, String paramString2)
  {
    if (ENABLE_LOG) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static String openUrl(String paramString1, String paramString2, Bundle paramBundle)
    throws MalformedURLException, IOException
  {
    if (paramString2.equals("GET")) {
      paramString1 = paramString1 + "?" + encodeUrl(paramBundle);
    }
    logd("Facebook-Util", paramString2 + " URL: " + paramString1);
    localHttpURLConnection = (HttpURLConnection)new URL(paramString1).openConnection();
    localHttpURLConnection.setConnectTimeout(3000);
    localHttpURLConnection.setReadTimeout(20000);
    localHttpURLConnection.setRequestProperty("User-Agent", System.getProperties().getProperty("http.agent") + " FacebookAndroidSDK");
    Object localObject3;
    Object localObject2;
    if (!paramString2.equals("GET"))
    {
      localObject1 = new Bundle();
      localObject3 = paramBundle.keySet().iterator();
      if (((Iterator)localObject3).hasNext()) {
        break label411;
      }
      if (!paramBundle.containsKey("method")) {
        paramBundle.putString("method", paramString2);
      }
      if (paramBundle.containsKey("access_token")) {
        paramBundle.putString("access_token", URLDecoder.decode(paramBundle.getString("access_token")));
      }
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
      localHttpURLConnection.setDoOutput(true);
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
      localHttpURLConnection.connect();
      localObject3 = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
      ((OutputStream)localObject3).write(("--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
      ((OutputStream)localObject3).write(encodePostBody(paramBundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
      ((OutputStream)localObject3).write(("\r\n" + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
      if (!((Bundle)localObject1).isEmpty()) {
        localObject2 = ((Bundle)localObject1).keySet().iterator();
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext())
      {
        ((OutputStream)localObject3).flush();
        ((OutputStream)localObject3).close();
      }
      try
      {
        localObject1 = read(localHttpURLConnection.getInputStream());
        localObject1 = localObject1;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          String str;
          localObject1 = read(localHttpURLConnection.getErrorStream());
        }
      }
      return localObject1;
      label411:
      str = (String)((Iterator)localObject3).next();
      localObject2 = paramBundle.get(str);
      if (!(localObject2 instanceof byte[])) {
        break;
      }
      ((Bundle)localObject1).putByteArray(str, (byte[])localObject2);
      break;
      str = (String)((Iterator)localObject2).next();
      ((OutputStream)localObject3).write(("Content-Disposition: form-data; filename=\"" + str + "\"" + "\r\n").getBytes());
      ((OutputStream)localObject3).write(("Content-Type: content/unknown" + "\r\n" + "\r\n").getBytes());
      ((OutputStream)localObject3).write(((Bundle)localObject1).getByteArray(str));
      ((OutputStream)localObject3).write(("\r\n" + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
    }
  }
  
  public static JSONObject parseJson(String paramString)
    throws JSONException, FacebookError
  {
    if (!paramString.equals("false"))
    {
      if (paramString.equals("true")) {
        paramString = "{value : true}";
      }
      JSONObject localJSONObject = new JSONObject(paramString);
      if (!localJSONObject.has("error"))
      {
        if ((!localJSONObject.has("error_code")) || (!localJSONObject.has("error_msg")))
        {
          if (!localJSONObject.has("error_code"))
          {
            if (!localJSONObject.has("error_msg"))
            {
              if (!localJSONObject.has("error_reason")) {
                return localJSONObject;
              }
              throw new FacebookError(localJSONObject.getString("error_reason"));
            }
            throw new FacebookError(localJSONObject.getString("error_msg"));
          }
          throw new FacebookError("request failed", "", Integer.parseInt(localJSONObject.getString("error_code")));
        }
        throw new FacebookError(localJSONObject.getString("error_msg"), "", Integer.parseInt(localJSONObject.getString("error_code")));
      }
      localJSONObject = localJSONObject.getJSONObject("error");
      throw new FacebookError(localJSONObject.getString("message"), localJSONObject.getString("type"), 0);
    }
    throw new FacebookError("request failed");
  }
  
  public static Bundle parseUrl(String paramString)
  {
    Object localObject = paramString.replace("fbconnect", "http");
    try
    {
      localObject = new URL((String)localObject);
      localBundle = decodeUrl(((URL)localObject).getQuery());
      localBundle.putAll(decodeUrl(((URL)localObject).getRef()));
      return localBundle;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Bundle localBundle = new Bundle();
      }
    }
  }
  
  private static String read(InputStream paramInputStream)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 1000);
    for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine()) {
      localStringBuilder.append(str);
    }
    paramInputStream.close();
    return localStringBuilder.toString();
  }
  
  public static void showAlert(Context paramContext, String paramString1, String paramString2)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setTitle(paramString1);
    localBuilder.setMessage(paramString2);
    localBuilder.create().show();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.facebook.android.Util
 * JD-Core Version:    0.7.0.1
 */