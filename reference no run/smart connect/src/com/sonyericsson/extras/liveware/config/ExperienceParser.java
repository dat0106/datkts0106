package com.sonyericsson.extras.liveware.config;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import com.sonyericsson.extras.liveware.experience.Action;
import com.sonyericsson.extras.liveware.experience.ActionSet;
import com.sonyericsson.extras.liveware.experience.Device;
import com.sonyericsson.extras.liveware.experience.Experience;
import com.sonyericsson.extras.liveware.experience.ExperienceManager;
import com.sonyericsson.extras.liveware.experience.Time;
import com.sonyericsson.extras.liveware.utils.Dbg;
import com.sonyericsson.extras.liveware.utils.ExperienceUtils;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class ExperienceParser
{
  private Context mContext;
  
  public ExperienceParser(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private String getLocalizedName(String paramString)
  {
    Object localObject = null;
    int i = this.mContext.getResources().getIdentifier(paramString, "string", this.mContext.getPackageName());
    String str = this.mContext.getString(i);
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    return localObject;
  }
  
  /* Error */
  private String getUnLocalizedName(String paramString)
  {
    // Byte code:
    //   0: getstatic 52	java/util/Locale:ROOT	Ljava/util/Locale;
    //   3: pop
    //   4: aload_0
    //   5: getfield 13	com/sonyericsson/extras/liveware/config/ExperienceParser:mContext	Landroid/content/Context;
    //   8: invokevirtual 21	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   11: astore 4
    //   13: aload 4
    //   15: invokevirtual 56	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   18: astore_2
    //   19: new 58	android/content/res/Configuration
    //   22: dup
    //   23: aload 4
    //   25: invokevirtual 62	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   28: invokespecial 65	android/content/res/Configuration:<init>	(Landroid/content/res/Configuration;)V
    //   31: astore 5
    //   33: aload 5
    //   35: getfield 68	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   38: astore_3
    //   39: aload 5
    //   41: getstatic 52	java/util/Locale:ROOT	Ljava/util/Locale;
    //   44: putfield 68	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   47: aload 4
    //   49: aload 5
    //   51: aload_2
    //   52: invokevirtual 72	android/content/res/Resources:updateConfiguration	(Landroid/content/res/Configuration;Landroid/util/DisplayMetrics;)V
    //   55: aconst_null
    //   56: astore 6
    //   58: aload_0
    //   59: getfield 13	com/sonyericsson/extras/liveware/config/ExperienceParser:mContext	Landroid/content/Context;
    //   62: invokevirtual 21	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   65: aload_1
    //   66: ldc 23
    //   68: aload_0
    //   69: getfield 13	com/sonyericsson/extras/liveware/config/ExperienceParser:mContext	Landroid/content/Context;
    //   72: invokevirtual 27	android/content/Context:getPackageName	()Ljava/lang/String;
    //   75: invokevirtual 33	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   78: istore 7
    //   80: aload_0
    //   81: getfield 13	com/sonyericsson/extras/liveware/config/ExperienceParser:mContext	Landroid/content/Context;
    //   84: iload 7
    //   86: invokevirtual 37	android/content/Context:getString	(I)Ljava/lang/String;
    //   89: astore 7
    //   91: aload 7
    //   93: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: istore 8
    //   98: iload 8
    //   100: ifne +7 -> 107
    //   103: aload 7
    //   105: astore 6
    //   107: aload 5
    //   109: aload_3
    //   110: putfield 68	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   113: aload 4
    //   115: aload 5
    //   117: aload_2
    //   118: invokevirtual 72	android/content/res/Resources:updateConfiguration	(Landroid/content/res/Configuration;Landroid/util/DisplayMetrics;)V
    //   121: aload 6
    //   123: areturn
    //   124: pop
    //   125: aload_0
    //   126: aload_1
    //   127: invokespecial 74	com/sonyericsson/extras/liveware/config/ExperienceParser:getLocalizedName	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 6
    //   132: goto -11 -> 121
    //   135: astore 6
    //   137: aload 5
    //   139: aload_3
    //   140: putfield 68	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   143: aload 4
    //   145: aload 5
    //   147: aload_2
    //   148: invokevirtual 72	android/content/res/Resources:updateConfiguration	(Landroid/content/res/Configuration;Landroid/util/DisplayMetrics;)V
    //   151: aload 6
    //   153: athrow
    //   154: pop
    //   155: goto -30 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	ExperienceParser
    //   0	158	1	paramString	String
    //   18	130	2	localDisplayMetrics	android.util.DisplayMetrics
    //   38	102	3	localLocale	Locale
    //   11	133	4	localResources	Resources
    //   31	115	5	localConfiguration	android.content.res.Configuration
    //   56	75	6	localObject1	Object
    //   135	17	6	localObject2	Object
    //   78	7	7	i	int
    //   89	15	7	str	String
    //   96	3	8	bool	boolean
    //   124	1	11	localUnsupportedOperationException1	java.lang.UnsupportedOperationException
    //   154	1	12	localUnsupportedOperationException2	java.lang.UnsupportedOperationException
    // Exception table:
    //   from	to	target	type
    //   4	33	124	java/lang/UnsupportedOperationException
    //   80	98	135	finally
    //   33	55	154	java/lang/UnsupportedOperationException
  }
  
  private Experience parse(Experience paramExperience, Resources paramResources, int paramInt, String paramString)
  {
    Experience localExperience = null;
    try
    {
      InputStream localInputStream = paramResources.openRawResource(paramInt);
      Object localObject = XmlPullParserFactory.newInstance();
      ((XmlPullParserFactory)localObject).setNamespaceAware(true);
      localObject = ((XmlPullParserFactory)localObject).newPullParser();
      ((XmlPullParser)localObject).setInput(localInputStream, "utf-8");
      i = ((XmlPullParser)localObject).getEventType();
      break label172;
      if (i == 2)
      {
        if (!((XmlPullParser)localObject).getName().equals("event")) {
          break label93;
        }
        paramExperience = parseExperience((XmlPullParser)localObject, paramString);
      }
      for (;;)
      {
        i = ((XmlPullParser)localObject).next();
        break;
        label93:
        if (((XmlPullParser)localObject).getName().equals("initiators")) {
          parseTriggers((XmlPullParser)localObject, paramExperience);
        } else if (((XmlPullParser)localObject).getName().equals("start_actions")) {
          parseStartActions((XmlPullParser)localObject, paramExperience);
        } else if (((XmlPullParser)localObject).getName().equals("stop_actions")) {
          parseStopActions((XmlPullParser)localObject, paramExperience);
        }
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        int i;
        break;
        if (i == 1) {
          localExperience = paramExperience;
        }
      }
      return localExperience;
    }
    catch (IOException localIOException)
    {
      break label181;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      label172:
      label181:
      break label181;
    }
  }
  
  private ActionSet parseAction(XmlPullParser paramXmlPullParser, Experience paramExperience, int paramInt1, int paramInt2)
    throws XmlPullParserException, IOException
  {
    ActionSet localActionSet = null;
    String str2 = null;
    String str1 = null;
    Object localObject;
    for (int i = 0; i < paramXmlPullParser.getAttributeCount(); i++)
    {
      localObject = paramXmlPullParser.getAttributeName(i);
      if (!((String)localObject).equals("id"))
      {
        if (((String)localObject).equals("setting")) {
          str1 = paramXmlPullParser.getAttributeValue(i);
        }
      }
      else {
        str2 = paramXmlPullParser.getAttributeValue(i);
      }
    }
    if (str2 != null)
    {
      localObject = ExperienceManager.getInstance(this.mContext).getActionByClass(str2);
      if (localObject != null) {
        localActionSet = new ActionSet((Action)localObject, paramExperience.getId(), paramInt1, paramInt2, str1, "", UUID.randomUUID(), 2);
      }
    }
    return localActionSet;
  }
  
  private void parseDevice(XmlPullParser paramXmlPullParser, Experience paramExperience)
    throws XmlPullParserException, IOException
  {
    String str2 = null;
    String str1 = null;
    String str3 = null;
    String str5 = null;
    String str4 = null;
    boolean bool1 = false;
    int i = 0;
    int j = 10;
    boolean bool2 = false;
    int m = 2;
    int k = 0;
    int n = paramXmlPullParser.getAttributeCount();
    if (k >= n)
    {
      if (str2 != null)
      {
        k = ExperienceUtils.getUserDefNameResourceId(this.mContext, this.mContext.getResources(), str2);
        if (k != 0) {
          str1 = this.mContext.getString(k);
        }
      }
      paramExperience.setDevice(new Device(str2, str1, str3, i, j, false, bool1, bool2, str5, 0L, null, 1, str4, m, 0L));
      return;
    }
    String str6 = paramXmlPullParser.getAttributeName(k);
    if (str6.equals("name")) {
      str2 = paramXmlPullParser.getAttributeValue(k);
    }
    for (;;)
    {
      k++;
      break;
      if (str6.equals("icon_resource"))
      {
        str3 = paramXmlPullParser.getAttributeValue(k);
      }
      else if (str6.equals("large_icon_resource"))
      {
        str5 = paramXmlPullParser.getAttributeValue(k);
      }
      else
      {
        if (str6.equals("removable"))
        {
          if (paramXmlPullParser.getAttributeValue(k).equals("1")) {}
          for (bool1 = true;; bool1 = false) {
            break;
          }
        }
        if (str6.equals("bearer"))
        {
          str6 = paramXmlPullParser.getAttributeValue(k);
          if (str6.equals("audio")) {
            i = 7;
          } else if (str6.equals("bluetooth")) {
            i = 4;
          } else if (str6.equals("hdmi")) {
            i = 9;
          } else if (str6.equals("nfc")) {
            i = 10;
          } else if (str6.equals("power")) {
            i = 8;
          } else if (str6.equals("usb")) {
            i = 6;
          } else if (str6.equals("ps3")) {
            i = 1;
          } else if (str6.equals("dmr")) {
            i = 2;
          } else if (str6.equals("dms")) {
            i = 3;
          } else if (str6.equals("wfd")) {
            i = 5;
          }
        }
        else if (str6.equals("device_type"))
        {
          str6 = paramXmlPullParser.getAttributeValue(k);
          if (str6.equals("aas")) {
            j = 15;
          } else if (str6.equals("audio")) {
            j = 11;
          } else if (str6.equals("charger")) {
            j = 12;
          } else if (str6.equals("dock")) {
            j = 14;
          } else if (str6.equals("headset")) {
            j = 5;
          } else if (str6.equals("input")) {
            j = 13;
          } else if (str6.equals("nfc_key_tag")) {
            j = 17;
          } else if (str6.equals("nfc_launch_tag")) {
            j = 16;
          } else if (str6.equals("speaker")) {
            j = 7;
          } else if (str6.equals("headphones")) {
            j = 6;
          } else if (str6.equals("tv")) {
            j = 1;
          } else if (str6.equals("nas")) {
            j = 2;
          } else if (str6.equals("pc")) {
            j = 3;
          } else if (str6.equals("camera")) {
            j = 4;
          } else if (str6.equals("mouse")) {
            j = 8;
          } else if (str6.equals("keyboard")) {
            j = 9;
          } else if (str6.equals("unknown")) {
            j = 10;
          } else if (str6.equals("phone")) {
            j = 18;
          } else if (str6.equals("ps3")) {
            j = 19;
          } else if (str6.equals("bdr")) {
            j = 20;
          }
        }
        else
        {
          if (str6.equals("notify_external"))
          {
            if (paramXmlPullParser.getAttributeValue(k).equals("1")) {}
            for (bool2 = true;; bool2 = false) {
              break;
            }
          }
          if (str6.equals("device_page_activity")) {
            str4 = paramXmlPullParser.getAttributeValue(k);
          } else if (str6.equals("manufacturer")) {
            try
            {
              m = Integer.parseInt(paramXmlPullParser.getAttributeValue(k));
              m = m;
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
      }
    }
  }
  
  private Experience parseExperience(XmlPullParser paramXmlPullParser, String paramString)
    throws XmlPullParserException
  {
    String str1 = paramString;
    String str2 = paramString;
    localObject1 = null;
    Object localObject2 = null;
    String str3;
    if (!TextUtils.isEmpty(str1))
    {
      localObject1 = "event_picture_" + str1;
      str3 = "event_name_" + str1;
      if (str3.contains("nfc_product"))
      {
        int i = -2 + str3.length();
        if (str3.charAt(i) == '_')
        {
          localObject3 = new StringBuilder(str3);
          ((StringBuilder)localObject3).setCharAt(-2 + str3.length(), '.');
          str3 = ((StringBuilder)localObject3).toString();
        }
      }
    }
    for (localObject3 = str3;; localObject3 = null)
    {
      for (;;)
      {
        try
        {
          str2 = getLocalizedName(str3 + "_nc");
          str1 = getUnLocalizedName(str3);
          str1 = str1;
        }
        catch (Resources.NotFoundException localNotFoundException2)
        {
          int k;
          int j;
          int m;
          String str4;
          continue;
        }
        try
        {
          if (!str1.equals(str2)) {
            continue;
          }
          str1 = getLocalizedName(str3);
          str1 = str1;
        }
        catch (Resources.NotFoundException localNotFoundException1)
        {
          localObject3 = null;
          continue;
          str4 = paramXmlPullParser.getAttributeName(j);
          if (!str4.equals("default_enabled")) {
            continue;
          }
          k = Integer.parseInt(paramXmlPullParser.getAttributeValue(j));
          j++;
          continue;
          if (!str4.equals("picture_resource")) {
            continue;
          }
          str4 = paramXmlPullParser.getAttributeValue(j);
          if (TextUtils.isEmpty(str4)) {
            continue;
          }
          localObject1 = str4;
        }
      }
      k = 0;
      j = 0;
      m = paramXmlPullParser.getAttributeCount();
      if (j < m) {
        break;
      }
      return new Experience(str1, (String)localObject1, null, null, null, 0L, k, (String)localObject3);
    }
  }
  
  private void parseStartActions(XmlPullParser paramXmlPullParser, Experience paramExperience)
    throws XmlPullParserException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramXmlPullParser.next();
    while (i != 1) {
      if ((i != 3) || (!paramXmlPullParser.getName().equals("start_actions")))
      {
        if ((i == 2) && (paramXmlPullParser.getName().equals("action")))
        {
          ActionSet localActionSet = parseAction(paramXmlPullParser, paramExperience, 0, localArrayList.size());
          if (localActionSet != null) {
            localArrayList.add(localActionSet);
          }
        }
        int j = paramXmlPullParser.next();
      }
      else
      {
        paramExperience.setStartActions(localArrayList);
      }
    }
  }
  
  private void parseStopActions(XmlPullParser paramXmlPullParser, Experience paramExperience)
    throws XmlPullParserException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramXmlPullParser.next();
    while (i != 1) {
      if ((i != 3) || (!paramXmlPullParser.getName().equals("stop_actions")))
      {
        if ((i == 2) && (paramXmlPullParser.getName().equals("action")))
        {
          ActionSet localActionSet = parseAction(paramXmlPullParser, paramExperience, 1, localArrayList.size());
          if (localActionSet != null) {
            localArrayList.add(localActionSet);
          }
        }
        int j = paramXmlPullParser.next();
      }
      else
      {
        paramExperience.setStopActions(localArrayList);
      }
    }
  }
  
  private void parseTime(XmlPullParser paramXmlPullParser, Experience paramExperience)
    throws XmlPullParserException, IOException
  {
    long l2 = -1L;
    long l1 = -1L;
    int k = 254;
    int i = 0;
    if (i >= paramXmlPullParser.getAttributeCount())
    {
      if ((l2 >= 0L) && (l1 >= 0L)) {
        break label189;
      }
      Dbg.e("Parse error. Do not add Time Trigger");
    }
    for (;;)
    {
      return;
      String str2 = paramXmlPullParser.getAttributeName(i);
      long l3;
      if (str2.equals("start"))
      {
        String str1 = paramXmlPullParser.getAttributeValue(i);
        int j = str1.indexOf(';');
        if (j > 0) {
          k = j + 1;
        }
        try
        {
          k = Integer.parseInt(str1.substring(k));
          k = k;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            Dbg.e("Couldn't parse weekdays bitmask");
            k = 254;
          }
        }
        str1 = str1.substring(0, j - 1);
        l3 = parseTimeString(str1);
      }
      for (;;)
      {
        i++;
        break;
        if (str2.equals("stop")) {
          l1 = parseTimeString(paramXmlPullParser.getAttributeValue(i));
        }
      }
      label189:
      paramExperience.setTime(new Time(l3, l1, false, k));
    }
  }
  
  private long parseTimeString(String paramString)
  {
    DateFormat localDateFormat = DateFormat.getTimeInstance(3, Locale.ENGLISH);
    localDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    try
    {
      l = localDateFormat.parse(paramString).getTime();
      l = l;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        Dbg.e("Failed to parse time value");
        long l = -1L;
      }
    }
    return l;
  }
  
  private void parseTrigger(XmlPullParser paramXmlPullParser, Experience paramExperience)
    throws XmlPullParserException, IOException
  {
    int i = 0;
    while (i < paramXmlPullParser.getAttributeCount()) {
      if (!paramXmlPullParser.getAttributeName(i).equals("initiator_type"))
      {
        i++;
      }
      else
      {
        String str = paramXmlPullParser.getAttributeValue(i);
        if (str.equals("device")) {
          parseDevice(paramXmlPullParser, paramExperience);
        }
        if (str.equals("time")) {
          parseTime(paramXmlPullParser, paramExperience);
        }
      }
    }
  }
  
  private void parseTriggers(XmlPullParser paramXmlPullParser, Experience paramExperience)
    throws XmlPullParserException, IOException
  {
    for (int i = paramXmlPullParser.next();; i = paramXmlPullParser.next())
    {
      if ((i == 1) || ((i == 3) && (paramXmlPullParser.getName().equals("initiators")))) {
        return;
      }
      if ((i == 2) && (paramXmlPullParser.getName().equals("initiator"))) {
        parseTrigger(paramXmlPullParser, paramExperience);
      }
    }
  }
  
  /* Error */
  /**
   * @deprecated
   */
  public Experience parse(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 13	com/sonyericsson/extras/liveware/config/ExperienceParser:mContext	Landroid/content/Context;
    //   6: invokevirtual 21	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   9: astore_2
    //   10: aload_2
    //   11: aload_1
    //   12: ldc_w 450
    //   15: aload_0
    //   16: getfield 13	com/sonyericsson/extras/liveware/config/ExperienceParser:mContext	Landroid/content/Context;
    //   19: invokevirtual 27	android/content/Context:getPackageName	()Ljava/lang/String;
    //   22: invokevirtual 33	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   25: istore_3
    //   26: iload_3
    //   27: ifne +11 -> 38
    //   30: aconst_null
    //   31: astore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: aload 4
    //   37: areturn
    //   38: aload_0
    //   39: aconst_null
    //   40: aload_2
    //   41: iload_3
    //   42: aload_1
    //   43: invokespecial 452	com/sonyericsson/extras/liveware/config/ExperienceParser:parse	(Lcom/sonyericsson/extras/liveware/experience/Experience;Landroid/content/res/Resources;ILjava/lang/String;)Lcom/sonyericsson/extras/liveware/experience/Experience;
    //   46: astore 4
    //   48: aload 4
    //   50: ifnull -17 -> 33
    //   53: aload 4
    //   55: invokevirtual 456	com/sonyericsson/extras/liveware/experience/Experience:getDevice	()Lcom/sonyericsson/extras/liveware/experience/Device;
    //   58: ifnonnull -25 -> 33
    //   61: new 294	java/lang/StringBuilder
    //   64: dup
    //   65: aload_1
    //   66: invokestatic 328	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   69: invokespecial 299	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: ldc_w 458
    //   75: invokevirtual 303	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 5
    //   83: aload_2
    //   84: aload 5
    //   86: ldc_w 450
    //   89: aload_0
    //   90: getfield 13	com/sonyericsson/extras/liveware/config/ExperienceParser:mContext	Landroid/content/Context;
    //   93: invokevirtual 27	android/content/Context:getPackageName	()Ljava/lang/String;
    //   96: invokevirtual 33	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   99: istore_3
    //   100: iload_3
    //   101: ifeq -68 -> 33
    //   104: aload_0
    //   105: aload 4
    //   107: aload_2
    //   108: iload_3
    //   109: aload 5
    //   111: invokespecial 452	com/sonyericsson/extras/liveware/config/ExperienceParser:parse	(Lcom/sonyericsson/extras/liveware/experience/Experience;Landroid/content/res/Resources;ILjava/lang/String;)Lcom/sonyericsson/extras/liveware/experience/Experience;
    //   114: astore_2
    //   115: aload_2
    //   116: astore 4
    //   118: goto -85 -> 33
    //   121: astore_2
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_2
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	ExperienceParser
    //   0	126	1	paramString	String
    //   9	107	2	localObject1	Object
    //   121	4	2	localObject2	Object
    //   25	84	3	i	int
    //   31	86	4	localObject3	Object
    //   81	29	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	26	121	finally
    //   38	115	121	finally
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.sonyericsson.extras.liveware.config.ExperienceParser
 * JD-Core Version:    0.7.0.1
 */