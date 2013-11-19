package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.List;

class NoopDispatcher
  implements Dispatcher
{
  public int dispatchHits(List<Hit> paramList)
  {
    if (paramList != null)
    {
      Log.iDebug("Hits not actually being sent as dispatch is false...");
      j = Math.min(paramList.size(), 40);
      for (int i = 0; i < j; i++) {
        if (Log.isDebugEnabled())
        {
          String str2;
          if (!TextUtils.isEmpty(((Hit)paramList.get(i)).getHitParams())) {
            str2 = HitBuilder.postProcessHit((Hit)paramList.get(i), System.currentTimeMillis());
          } else {
            str2 = "";
          }
          String str1;
          if (!TextUtils.isEmpty(str2))
          {
            if (str2.length() > 2036)
            {
              if (str2.length() <= 8192) {
                str1 = "POST would be sent:";
              } else {
                str1 = "Would be too big:";
              }
            }
            else {
              str1 = "GET would be sent:";
            }
          }
          else {
            str1 = "Hit couldn't be read, wouldn't be sent:";
          }
          Log.iDebug(str1 + str2);
        }
      }
    }
    int j = 0;
    return j;
  }
  
  public boolean okToDispatch()
  {
    return true;
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.NoopDispatcher
 * JD-Core Version:    0.7.0.1
 */