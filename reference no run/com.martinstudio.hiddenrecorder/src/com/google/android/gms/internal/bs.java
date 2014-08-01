package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bs
{
  public static List<String> a(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    Object localObject;
    if (localJSONArray == null) {
      localObject = null;
    } else {
      localObject = new ArrayList(localJSONArray.length());
    }
    for (int i = 0;; i++)
    {
      if (i >= localJSONArray.length())
      {
        localObject = Collections.unmodifiableList((List)localObject);
        return localObject;
      }
      ((List)localObject).add(localJSONArray.getString(i));
    }
  }
  
  public static void a(Context paramContext, String paramString1, eg parameg, String paramString2, boolean paramBoolean, List<String> paramList)
  {
    String str1;
    if (!paramBoolean) {
      str1 = "0";
    } else {
      str1 = "1";
    }
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      String str2 = ((String)localIterator.next()).replaceAll("@gw_adlocid@", paramString2).replaceAll("@gw_adnetrefresh@", str1).replaceAll("@gw_qdata@", parameg.rw.nu).replaceAll("@gw_sdkver@", paramString1).replaceAll("@gw_sessid@", ei.rN).replaceAll("@gw_seqnum@", parameg.pY);
      if (parameg.nK != null) {
        str2 = str2.replaceAll("@gw_adnetid@", parameg.nK.nj).replaceAll("@gw_allocid@", parameg.nK.nl);
      }
      new et(paramContext, paramString1, str2).start();
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bs
 * JD-Core Version:    0.7.0.1
 */