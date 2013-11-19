package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

class MetaModel
{
  private Map<String, MetaInfo> mMetaInfos = new HashMap();
  
  public void addField(String paramString1, String paramString2, String paramString3, Formatter paramFormatter)
  {
    this.mMetaInfos.put(paramString1, new MetaInfo(paramString2, paramString3, paramFormatter));
  }
  
  MetaInfo getMetaInfo(String paramString)
  {
    Object localObject;
    if (!paramString.startsWith("&"))
    {
      localObject = paramString;
      if (paramString.contains("*")) {
        localObject = paramString.substring(0, paramString.indexOf("*"));
      }
      localObject = (MetaInfo)this.mMetaInfos.get(localObject);
    }
    else
    {
      localObject = new MetaInfo(paramString.substring(1), null, null);
    }
    return localObject;
  }
  
  public static class MetaInfo
  {
    private final String mDefaultValue;
    private final MetaModel.Formatter mFormatter;
    private final String mUrlParam;
    
    public MetaInfo(String paramString1, String paramString2, MetaModel.Formatter paramFormatter)
    {
      this.mUrlParam = paramString1;
      this.mDefaultValue = paramString2;
      this.mFormatter = paramFormatter;
    }
    
    public String getDefaultValue()
    {
      return this.mDefaultValue;
    }
    
    public MetaModel.Formatter getFormatter()
    {
      return this.mFormatter;
    }
    
    @VisibleForTesting
    String getUrlParam()
    {
      return this.mUrlParam;
    }
    
    public String getUrlParam(String paramString)
    {
      String str2 = null;
      String str1;
      String[] arrayOfString;
      if (paramString.contains("*"))
      {
        str1 = this.mUrlParam;
        arrayOfString = paramString.split("\\*");
        if (arrayOfString.length <= 1) {}
      }
      for (;;)
      {
        try
        {
          int i = Integer.parseInt(arrayOfString[1]);
          str2 = str1 + i;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Log.w("Unable to parse slot for url parameter " + str1);
          continue;
        }
        return str2;
        str2 = this.mUrlParam;
      }
    }
  }
  
  public static abstract interface Formatter
  {
    public abstract String format(String paramString);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.MetaModel
 * JD-Core Version:    0.7.0.1
 */