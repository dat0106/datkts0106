package com.google.analytics.tracking.android;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class HitBuilder
{
  static String encode(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError("URL encoding failed for: " + paramString);
    }
  }
  
  static Map<String, String> generateHitParams(MetaModel paramMetaModel, Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localHashMap;
      }
      Object localObject = (Map.Entry)localIterator.next();
      MetaModel.MetaInfo localMetaInfo = paramMetaModel.getMetaInfo((String)((Map.Entry)localObject).getKey());
      if (localMetaInfo != null)
      {
        String str = localMetaInfo.getUrlParam((String)((Map.Entry)localObject).getKey());
        if (str != null)
        {
          localObject = (String)((Map.Entry)localObject).getValue();
          if (localMetaInfo.getFormatter() != null) {
            localObject = localMetaInfo.getFormatter().format((String)localObject);
          }
          if ((localObject != null) && (!((String)localObject).equals(localMetaInfo.getDefaultValue()))) {
            localHashMap.put(str, localObject);
          }
        }
      }
    }
  }
  
  static String postProcessHit(Hit paramHit, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHit.getHitParams());
    if (paramHit.getHitTime() > 0L)
    {
      long l = paramLong - paramHit.getHitTime();
      if (l >= 0L) {
        localStringBuilder.append("&").append("qt").append("=").append(l);
      }
    }
    localStringBuilder.append("&").append("z").append("=").append(paramHit.getHitId());
    return localStringBuilder.toString();
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.HitBuilder
 * JD-Core Version:    0.7.0.1
 */