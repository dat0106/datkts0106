package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class k<T extends j>
{
  Context mContext;
  a<T> tJ;
  
  public k(Context paramContext, a<T> parama)
  {
    this.mContext = paramContext;
    this.tJ = parama;
  }
  
  private T a(XmlResourceParser paramXmlResourceParser)
  {
    try
    {
      paramXmlResourceParser.next();
      int i = paramXmlResourceParser.getEventType();
      if (i != 1)
      {
        if (paramXmlResourceParser.getEventType() == 2)
        {
          String str1 = paramXmlResourceParser.getName().toLowerCase();
          if (!str1.equals("screenname")) {
            break label103;
          }
          str1 = paramXmlResourceParser.getAttributeValue(null, "name");
          str5 = paramXmlResourceParser.nextText().trim();
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str5))) {
            this.tJ.c(str1, str5);
          }
        }
        for (;;)
        {
          int j = paramXmlResourceParser.next();
          break;
          label103:
          if (!j.equals("string")) {
            break label190;
          }
          String str2 = paramXmlResourceParser.getAttributeValue(null, "name");
          str5 = paramXmlResourceParser.nextText().trim();
          if ((!TextUtils.isEmpty(str2)) && (str5 != null)) {
            this.tJ.d(str2, str5);
          }
        }
      }
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      for (;;)
      {
        aa.A("Error parsing tracker configuration file: " + localXmlPullParserException);
        return this.tJ.cw();
        if (!localXmlPullParserException.equals("bool")) {
          break;
        }
        str5 = paramXmlResourceParser.getAttributeValue(null, "name");
        String str3 = paramXmlResourceParser.nextText().trim();
        if (!TextUtils.isEmpty(str5))
        {
          bool = TextUtils.isEmpty(str3);
          if (!bool) {
            try
            {
              bool = Boolean.parseBoolean(str3);
              this.tJ.c(str5, bool);
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              aa.A("Error parsing bool configuration value: " + str3);
            }
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        String str5;
        label190:
        boolean bool;
        aa.A("Error parsing tracker configuration file: " + localIOException);
        continue;
        if (localIOException.equals("integer"))
        {
          String str4 = paramXmlResourceParser.getAttributeValue(null, "name");
          str5 = paramXmlResourceParser.nextText().trim();
          if (!TextUtils.isEmpty(str4))
          {
            bool = TextUtils.isEmpty(str5);
            if (!bool) {
              try
              {
                int k = Integer.parseInt(str5);
                this.tJ.a(str4, k);
              }
              catch (NumberFormatException localNumberFormatException2)
              {
                aa.A("Error parsing int configuration value: " + str5);
              }
            }
          }
        }
      }
    }
  }
  
  public T r(int paramInt)
  {
    try
    {
      localj = a(this.mContext.getResources().getXml(paramInt));
      localj = localj;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        j localj;
        aa.D("inflate() called with unknown resourceId: " + localNotFoundException);
        Object localObject = null;
      }
    }
    return localj;
  }
  
  public static abstract interface a<U extends j>
  {
    public abstract void a(String paramString, int paramInt);
    
    public abstract void c(String paramString1, String paramString2);
    
    public abstract void c(String paramString, boolean paramBoolean);
    
    public abstract U cw();
    
    public abstract void d(String paramString1, String paramString2);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.k
 * JD-Core Version:    0.7.0.1
 */