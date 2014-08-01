package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class io
{
  private static final Pattern Ht = Pattern.compile("\\\\.");
  private static final Pattern Hu = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
  
  public static String aK(String paramString)
  {
    Matcher localMatcher;
    StringBuffer localStringBuffer;
    if (!TextUtils.isEmpty(paramString))
    {
      localMatcher = Hu.matcher(paramString);
      localStringBuffer = null;
    }
    for (;;)
    {
      if (!localMatcher.find())
      {
        if (localStringBuffer != null)
        {
          localMatcher.appendTail(localStringBuffer);
          paramString = localStringBuffer.toString();
        }
        return paramString;
      }
      if (localStringBuffer == null) {
        localStringBuffer = new StringBuffer();
      }
      switch (localMatcher.group().charAt(0))
      {
      default: 
        break;
      case '\b': 
        localMatcher.appendReplacement(localStringBuffer, "\\\\b");
        break;
      case '\t': 
        localMatcher.appendReplacement(localStringBuffer, "\\\\t");
        break;
      case '\n': 
        localMatcher.appendReplacement(localStringBuffer, "\\\\n");
        break;
      case '\f': 
        localMatcher.appendReplacement(localStringBuffer, "\\\\f");
        break;
      case '\r': 
        localMatcher.appendReplacement(localStringBuffer, "\\\\r");
        break;
      case '"': 
        localMatcher.appendReplacement(localStringBuffer, "\\\\\\\"");
        break;
      case '/': 
        localMatcher.appendReplacement(localStringBuffer, "\\\\/");
        break;
      case '\\': 
        localMatcher.appendReplacement(localStringBuffer, "\\\\\\\\");
      }
    }
  }
  
  public static boolean d(Object paramObject1, Object paramObject2)
  {
    boolean bool1 = false;
    JSONObject localJSONObject;
    Object localObject1;
    if (((paramObject1 instanceof JSONObject)) && ((paramObject2 instanceof JSONObject)))
    {
      localJSONObject = (JSONObject)paramObject1;
      localObject1 = (JSONObject)paramObject2;
      if (localJSONObject.length() == ((JSONObject)localObject1).length()) {}
    }
    for (;;)
    {
      return bool1;
      Object localObject2 = localJSONObject.keys();
      label47:
      String str;
      if (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if (!((JSONObject)localObject1).has(str)) {}
      }
      else
      {
        boolean bool2;
        int i;
        try
        {
          bool2 = d(localJSONObject.get(str), ((JSONObject)localObject1).get(str));
          if (bool2) {
            break label47;
          }
        }
        catch (JSONException localJSONException2) {}
        bool1 = true;
        continue;
        if (((paramObject1 instanceof JSONArray)) && ((paramObject2 instanceof JSONArray)))
        {
          localObject1 = (JSONArray)paramObject1;
          localObject2 = (JSONArray)paramObject2;
          if (((JSONArray)localObject1).length() != ((JSONArray)localObject2).length()) {
            continue;
          }
          i = 0;
          if (i >= ((JSONArray)localObject1).length()) {}
        }
        try
        {
          bool2 = d(((JSONArray)localObject1).get(i), ((JSONArray)localObject2).get(i));
          if (!bool2) {
            continue;
          }
          i++;
        }
        catch (JSONException localJSONException1) {}
        bool1 = true;
        continue;
        bool1 = paramObject1.equals(paramObject2);
        continue;
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.io
 * JD-Core Version:    0.7.0.1
 */