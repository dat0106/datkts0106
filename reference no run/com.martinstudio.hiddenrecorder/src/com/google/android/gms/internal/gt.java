package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gt
{
  private static final go BD = new go("MetadataUtils");
  private static final String[] CL;
  private static final String CM = "yyyyMMdd'T'HHmmss" + CL[0];
  
  static
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "Z";
    arrayOfString[1] = "+hh";
    arrayOfString[2] = "+hhmm";
    arrayOfString[3] = "+hh:mm";
    CL = arrayOfString;
  }
  
  public static String a(Calendar paramCalendar)
  {
    Object localObject;
    if (paramCalendar != null)
    {
      localObject = CM;
      if ((paramCalendar.get(11) == 0) && (paramCalendar.get(12) == 0) && (paramCalendar.get(13) == 0)) {
        localObject = "yyyyMMdd";
      }
      localObject = new SimpleDateFormat((String)localObject);
      ((SimpleDateFormat)localObject).setTimeZone(paramCalendar.getTimeZone());
      localObject = ((SimpleDateFormat)localObject).format(paramCalendar.getTime());
      if (((String)localObject).endsWith("+0000")) {
        localObject = ((String)localObject).replace("+0000", CL[0]);
      }
    }
    else
    {
      BD.b("Calendar object cannot be null", new Object[0]);
      localObject = null;
    }
    return localObject;
  }
  
  /* Error */
  public static void a(List<WebImage> paramList, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 105 1 0
    //   6: aload_1
    //   7: ldc 107
    //   9: invokevirtual 113	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 119	org/json/JSONArray:length	()I
    //   17: istore_2
    //   18: iconst_0
    //   19: istore 5
    //   21: iload 5
    //   23: iload_2
    //   24: if_icmpge +34 -> 58
    //   27: aload_3
    //   28: iload 5
    //   30: invokevirtual 123	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   33: astore 4
    //   35: aload_0
    //   36: new 125	com/google/android/gms/common/images/WebImage
    //   39: dup
    //   40: aload 4
    //   42: invokespecial 128	com/google/android/gms/common/images/WebImage:<init>	(Lorg/json/JSONObject;)V
    //   45: invokeinterface 132 2 0
    //   50: pop
    //   51: iinc 5 1
    //   54: goto -33 -> 21
    //   57: pop
    //   58: return
    //   59: pop
    //   60: goto -9 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramList	List<WebImage>
    //   0	63	1	paramJSONObject	JSONObject
    //   17	8	2	i	int
    //   12	16	3	localJSONArray	JSONArray
    //   33	8	4	localJSONObject	JSONObject
    //   19	33	5	j	int
    //   57	1	6	localJSONException	JSONException
    //   59	1	7	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   0	35	57	org/json/JSONException
    //   35	51	57	org/json/JSONException
    //   35	51	59	java/lang/IllegalArgumentException
  }
  
  public static void a(JSONObject paramJSONObject, List<WebImage> paramList)
  {
    JSONArray localJSONArray;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localJSONArray = new JSONArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((WebImage)localIterator.next()).dU());
      }
    }
    try
    {
      paramJSONObject.put("images", localJSONArray);
      label65:
      return;
    }
    catch (JSONException localJSONException)
    {
      break label65;
    }
  }
  
  public static Calendar aq(String paramString)
  {
    Object localObject1;
    if (TextUtils.isEmpty(paramString))
    {
      BD.b("Input string is empty or null", new Object[0]);
      localObject1 = null;
    }
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      return localObject1;
      localObject1 = ar(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        BD.b("Invalid date format", new Object[0]);
        localObject1 = null;
      }
      else
      {
        localObject3 = as(paramString);
        localObject4 = "yyyyMMdd";
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject1 = (String)localObject1 + "T" + (String)localObject3;
          if (((String)localObject3).length() != "HHmmss".length()) {
            break label133;
          }
        }
        for (localObject4 = "yyyyMMdd'T'HHmmss";; localObject4 = CM) {
          for (;;)
          {
            localObject3 = GregorianCalendar.getInstance();
            try
            {
              localObject1 = new SimpleDateFormat((String)localObject4).parse((String)localObject1);
              ((Calendar)localObject3).setTime((Date)localObject1);
              localObject1 = localObject3;
            }
            catch (ParseException localParseException)
            {
              label133:
              localObject4 = BD;
              localObject3 = new Object[1];
              localObject3[0] = localParseException.getMessage();
              ((go)localObject4).b("Error parsing string: %s", (Object[])localObject3);
              Object localObject2 = null;
            }
          }
        }
      }
    }
  }
  
  private static String ar(String paramString)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString)) {
      BD.b("Input string is empty or null", new Object[0]);
    }
    for (;;)
    {
      return localObject;
      try
      {
        String str = paramString.substring(0, "yyyyMMdd".length());
        localObject = str;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        go localgo = BD;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localIndexOutOfBoundsException.getMessage();
        localgo.c("Error extracting the date: %s", arrayOfObject);
      }
    }
  }
  
  private static String as(String paramString)
  {
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString)) {
      BD.b("string is empty or null", new Object[0]);
    }
    for (;;)
    {
      return localObject1;
      int i = paramString.indexOf('T');
      int j = i + 1;
      if (i != "yyyyMMdd".length())
      {
        BD.b("T delimeter is not found", new Object[0]);
      }
      else
      {
        Object localObject2;
        try
        {
          localObject2 = paramString.substring(j);
          if (((String)localObject2).length() != "HHmmss".length()) {
            break label110;
          }
          localObject1 = localObject2;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          go localgo = BD;
          localObject2 = new Object[1];
          localObject2[0] = localIndexOutOfBoundsException.getMessage();
          localgo.b("Error extracting the time substring: %s", (Object[])localObject2);
        }
        continue;
        label110:
        switch (((String)localObject2).charAt("HHmmss".length()))
        {
        default: 
          break;
        case '+': 
        case '-': 
          if (at((String)localObject2)) {
            localObject1 = ((String)localObject2).replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
          }
          break;
        case 'Z': 
          if (((String)localObject2).length() == "HHmmss".length() + CL[0].length()) {
            localObject1 = ((String)localObject2).substring(0, -1 + ((String)localObject2).length()) + "+0000";
          }
          break;
        }
      }
    }
  }
  
  private static boolean at(String paramString)
  {
    boolean bool = true;
    int i = paramString.length();
    int j = "HHmmss".length();
    if ((i != j + CL[bool].length()) && (i != j + CL[2].length()) && (i != j + CL[3].length())) {
      bool = false;
    }
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gt
 * JD-Core Version:    0.7.0.1
 */