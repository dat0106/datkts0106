package com.sonyericsson.extras.liveware.utils;

import android.content.Context;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.experience.Action;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MillerSmartTagsParser
{
  private static final String XML_CUSTOMIZATION_PATH = "/etc/customization/settings/com/sonyericsson/extras/smarttags/custom_settings.xml";
  private static String sEventName = null;
  private static int sKeyId;
  
  public static int getTagIdFromName(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return i;
      if (paramString.startsWith("nfc_product_1"))
      {
        String str = paramString.substring(-1 + paramString.length());
        try
        {
          j = Integer.parseInt(str);
          j = j;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int j = 0;
        }
      }
    }
  }
  
  private static ActionSet parseAction(Context paramContext, XmlPullParser paramXmlPullParser, int paramInt, long paramLong)
  {
    localActionSet = null;
    String str2 = null;
    String str1 = null;
    for (;;)
    {
      try
      {
        j = paramXmlPullParser.getEventType();
        int i = paramXmlPullParser.getDepth();
        if (j != 1) {
          continue;
        }
        if (str2 != null)
        {
          localObject1 = str2.replace("smarttags", "liveware");
          localObject1 = ExperienceManager.getInstance(paramContext).getActionByClass((String)localObject1);
          if (localObject1 != null) {
            localActionSet = new ActionSet((Action)localObject1, paramLong, 0, paramInt, str1, "", UUID.randomUUID(), 2);
          }
        }
        localActionSet = localActionSet;
      }
      catch (IOException localIOException)
      {
        Object localObject1;
        int k;
        String str3;
        Object localObject2;
        localActionSet = null;
        continue;
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        int j;
        localActionSet = null;
        continue;
        j++;
        continue;
      }
      return localActionSet;
      if ((j == 2) && (paramXmlPullParser.getName().equals("setting")) && (paramXmlPullParser.getDepth() == localObject1))
      {
        j = 0;
        k = paramXmlPullParser.getAttributeCount();
        if (j >= k)
        {
          j = paramXmlPullParser.next();
        }
        else
        {
          str3 = paramXmlPullParser.getAttributeName(j);
          if ((str3.equals("key")) && (paramXmlPullParser.getAttributeValue(j).equals("id")))
          {
            paramXmlPullParser.next();
            str2 = paramXmlPullParser.getText();
          }
          else
          {
            if ((!str3.equals("key")) || (!paramXmlPullParser.getAttributeValue(j).equals("setting")) || (paramXmlPullParser.getDepth() != localObject1)) {
              continue;
            }
            paramXmlPullParser.next();
            str1 = paramXmlPullParser.getText();
          }
        }
      }
      else
      {
        localObject2 = paramXmlPullParser.getDepth();
        if (localObject2 < localObject1) {
          if (j != 2) {
            if (j != 3) {}
          }
        }
      }
    }
  }
  
  private static ArrayList<ActionSet> parseActions(Context paramContext, XmlPullParser paramXmlPullParser, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    int k;
    label154:
    label208:
    do
    {
      try
      {
        j = paramXmlPullParser.getEventType();
        i = paramXmlPullParser.getDepth();
      }
      catch (IOException localIOException)
      {
        int j;
        int i;
        int n;
        ActionSet localActionSet;
        localArrayList = null;
        break;
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        localArrayList = null;
        break;
      }
      if ((j == 2) && (paramXmlPullParser.getName().equals("group")) && (paramXmlPullParser.getDepth() == i))
      {
        n = 0;
        j = 0;
        if (j >= paramXmlPullParser.getAttributeCount())
        {
          paramXmlPullParser.nextTag();
          localActionSet = parseAction(paramContext, paramXmlPullParser, n, paramLong);
          if (localActionSet != null) {
            localArrayList.add(localActionSet);
          }
        }
      }
      for (;;)
      {
        k = paramXmlPullParser.next();
        break label208;
        boolean bool = paramXmlPullParser.getAttributeName(k).equals("id");
        if (bool) {}
        try
        {
          m = Integer.parseInt(paramXmlPullParser.getAttributeValue(k));
          n = m;
          k++;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          int m;
          break label154;
        }
        break;
        m = paramXmlPullParser.getDepth();
        if (m < i)
        {
          if (k == 3) {
            break label214;
          }
          if (k == 2) {
            break label214;
          }
        }
      }
    } while (k != 1);
    label214:
    return localArrayList;
  }
  
  private static Experience parseProfile(Context paramContext, XmlPullParser paramXmlPullParser, int paramInt, Experience paramExperience)
  {
    localObject1 = null;
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        k = paramXmlPullParser.getEventType();
        i = paramXmlPullParser.getDepth();
        if (k != 1) {
          continue;
        }
        if ((localObject1 == null) || (sEventName == null) || (sKeyId != paramInt)) {
          continue;
        }
        ((Experience)localObject1).setName(sEventName);
        ((Experience)localObject1).setResourcename(null);
        ((Experience)localObject1).setPictureName(null);
        ((Experience)localObject1).setEnabledState(1);
        localObject1 = localObject1;
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        int k;
        int i;
        String str;
        int m;
        int n;
        localObject1 = null;
        continue;
        localObject1 = null;
        continue;
      }
      catch (IOException localIOException)
      {
        int j;
        localObject1 = null;
        continue;
        j++;
        continue;
      }
      return localObject1;
      if ((k == 2) && (paramXmlPullParser.getName().equals("setting")) && (paramXmlPullParser.getDepth() == i))
      {
        j = 0;
        if (j >= paramXmlPullParser.getAttributeCount())
        {
          if ((sKeyId == paramInt) && (localObject2 != null) && (((ArrayList)localObject2).size() > 0) && (localObject1 == null))
          {
            paramExperience.setStartActions((List)localObject2);
            paramExperience.setStopActions(null);
            localObject1 = paramExperience;
          }
          k = paramXmlPullParser.next();
        }
        else
        {
          str = paramXmlPullParser.getAttributeName(j);
          if ((str.equals("key")) && (paramXmlPullParser.getAttributeValue(j).equals("id")))
          {
            paramXmlPullParser.next();
            try
            {
              sKeyId = Integer.parseInt(paramXmlPullParser.getText());
            }
            catch (NumberFormatException localNumberFormatException) {}
            j++;
          }
          else if ((str.equals("key")) && (paramXmlPullParser.getAttributeValue(j).equals("name")))
          {
            paramXmlPullParser.next();
            sEventName = paramXmlPullParser.getText();
          }
        }
      }
      else if ((str == 2) && (paramXmlPullParser.getName().equals("groups")) && (paramXmlPullParser.getDepth() == i))
      {
        j = 0;
        if (j < paramXmlPullParser.getAttributeCount())
        {
          if ((!paramXmlPullParser.getAttributeName(j).equals("type")) || (!paramXmlPullParser.getAttributeValue(j).equals("actions"))) {
            continue;
          }
          m = paramXmlPullParser.getDepth();
          n = paramXmlPullParser.nextTag();
          if (paramInt != sKeyId)
          {
            if ((n == 1) || ((n == 3) && (m == paramXmlPullParser.getDepth()))) {
              continue;
            }
            n = paramXmlPullParser.next();
            continue;
          }
          localObject2 = parseActions(paramContext, paramXmlPullParser, paramExperience.getId());
        }
      }
      else
      {
        j = paramXmlPullParser.getDepth();
        if (j < i) {
          if (m != 2) {
            if (m != 3) {}
          }
        }
      }
    }
  }
  
  private static void parseProfiles(Context paramContext, XmlPullParser paramXmlPullParser, int paramInt, Experience paramExperience)
  {
    int j;
    do
    {
      try
      {
        paramXmlPullParser.getEventType();
        i = paramXmlPullParser.getDepth();
        j = paramXmlPullParser.nextTag();
      }
      catch (IOException localIOException)
      {
        int i;
        break;
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        break;
      }
      if ((j == 2) && (paramXmlPullParser.getName().equals("group")) && (paramXmlPullParser.getDepth() == i + 1))
      {
        paramXmlPullParser.nextTag();
        if (parseProfile(paramContext, paramXmlPullParser, paramInt, paramExperience) != null) {
          break;
        }
      }
      for (;;)
      {
        j = paramXmlPullParser.next();
        break;
        j = paramXmlPullParser.getDepth();
        if (j < i) {
          return;
        }
      }
    } while (j != 1);
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public static void parseSmartTagVersionOneTag(Context paramContext, int paramInt, Experience paramExperience, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: putstatic 142	com/sonyericsson/extras/liveware/utils/MillerSmartTagsParser:sKeyId	I
    //   7: aconst_null
    //   8: putstatic 15	com/sonyericsson/extras/liveware/utils/MillerSmartTagsParser:sEventName	Ljava/lang/String;
    //   11: aload_3
    //   12: ifnonnull +17 -> 29
    //   15: new 190	java/io/FileInputStream
    //   18: dup
    //   19: ldc 8
    //   21: invokespecial 192	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: astore 4
    //   26: aload 4
    //   28: astore_3
    //   29: invokestatic 198	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   32: astore 4
    //   34: aload 4
    //   36: iconst_1
    //   37: invokevirtual 202	org/xmlpull/v1/XmlPullParserFactory:setNamespaceAware	(Z)V
    //   40: aload 4
    //   42: invokevirtual 206	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   45: astore 4
    //   47: aload 4
    //   49: aload_3
    //   50: ldc 208
    //   52: invokeinterface 212 3 0
    //   57: aload 4
    //   59: invokeinterface 60 1 0
    //   64: istore 5
    //   66: iload 5
    //   68: istore 5
    //   70: iload 5
    //   72: iconst_1
    //   73: if_icmpne +15 -> 88
    //   76: aload_3
    //   77: invokevirtual 217	java/io/InputStream:close	()V
    //   80: ldc 2
    //   82: monitorexit
    //   83: return
    //   84: pop
    //   85: goto -5 -> 80
    //   88: iload 5
    //   90: iconst_2
    //   91: if_icmpne +33 -> 124
    //   94: aload 4
    //   96: invokeinterface 98 1 0
    //   101: ldc 172
    //   103: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifeq +18 -> 124
    //   109: iconst_0
    //   110: istore 5
    //   112: iload 5
    //   114: aload 4
    //   116: invokeinterface 107 1 0
    //   121: if_icmplt +15 -> 136
    //   124: aload 4
    //   126: invokeinterface 110 1 0
    //   131: istore 5
    //   133: goto -63 -> 70
    //   136: aload 4
    //   138: iload 5
    //   140: invokeinterface 113 2 0
    //   145: ldc 174
    //   147: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   150: ifeq +28 -> 178
    //   153: aload 4
    //   155: iload 5
    //   157: invokeinterface 118 2 0
    //   162: ldc 219
    //   164: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   167: ifeq +11 -> 178
    //   170: aload_0
    //   171: aload 4
    //   173: iload_1
    //   174: aload_2
    //   175: invokestatic 221	com/sonyericsson/extras/liveware/utils/MillerSmartTagsParser:parseProfiles	(Landroid/content/Context;Lorg/xmlpull/v1/XmlPullParser;ILcom/sonyericsson/extras/liveware/experience/Experience;)V
    //   178: iinc 5 1
    //   181: goto -69 -> 112
    //   184: pop
    //   185: aload_3
    //   186: invokevirtual 217	java/io/InputStream:close	()V
    //   189: goto -109 -> 80
    //   192: pop
    //   193: ldc 223
    //   195: invokestatic 228	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   198: pop
    //   199: goto -119 -> 80
    //   202: astore 4
    //   204: ldc 2
    //   206: monitorexit
    //   207: aload 4
    //   209: athrow
    //   210: pop
    //   211: aload_3
    //   212: invokevirtual 217	java/io/InputStream:close	()V
    //   215: goto -135 -> 80
    //   218: pop
    //   219: ldc 223
    //   221: invokestatic 228	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   224: pop
    //   225: goto -145 -> 80
    //   228: astore 4
    //   230: aload_3
    //   231: invokevirtual 217	java/io/InputStream:close	()V
    //   234: aload 4
    //   236: athrow
    //   237: pop
    //   238: ldc 223
    //   240: invokestatic 228	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   243: pop
    //   244: goto -10 -> 234
    //   247: pop
    //   248: ldc 223
    //   250: invokestatic 228	com/sonyericsson/extras/liveware/utils/Dbg:e	(Ljava/lang/String;)Z
    //   253: pop
    //   254: goto -174 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramContext	Context
    //   0	257	1	paramInt	int
    //   0	257	2	paramExperience	Experience
    //   0	257	3	paramInputStream	java.io.InputStream
    //   24	148	4	localObject1	Object
    //   202	6	4	localObject2	Object
    //   228	7	4	localObject3	Object
    //   64	115	5	i	int
    //   84	1	8	localIOException1	IOException
    //   184	1	9	localIOException2	IOException
    //   192	1	10	localIOException3	IOException
    //   210	1	11	localXmlPullParserException	XmlPullParserException
    //   218	1	12	localIOException4	IOException
    //   237	1	13	localIOException5	IOException
    //   247	1	14	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   15	26	84	java/io/IOException
    //   29	66	184	java/io/IOException
    //   94	178	184	java/io/IOException
    //   185	189	192	java/io/IOException
    //   3	11	202	finally
    //   15	26	202	finally
    //   76	80	202	finally
    //   185	189	202	finally
    //   193	199	202	finally
    //   211	215	202	finally
    //   219	225	202	finally
    //   230	234	202	finally
    //   234	254	202	finally
    //   29	66	210	org/xmlpull/v1/XmlPullParserException
    //   94	178	210	org/xmlpull/v1/XmlPullParserException
    //   211	215	218	java/io/IOException
    //   29	66	228	finally
    //   94	178	228	finally
    //   230	234	237	java/io/IOException
    //   76	80	247	java/io/IOException
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.utils.MillerSmartTagsParser
 * JD-Core Version:    0.7.0.1
 */