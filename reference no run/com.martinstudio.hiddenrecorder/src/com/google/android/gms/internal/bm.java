package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bm
{
  public final String ni;
  public final String nj;
  public final List<String> nk;
  public final String nl;
  public final String nm;
  public final List<String> nn;
  public final String no;
  
  public bm(JSONObject paramJSONObject)
    throws JSONException
  {
    this.nj = paramJSONObject.getString("id");
    Object localObject2 = paramJSONObject.getJSONArray("adapters");
    Object localObject1 = new ArrayList(((JSONArray)localObject2).length());
    for (int i = 0;; i++)
    {
      if (i >= ((JSONArray)localObject2).length())
      {
        this.nk = Collections.unmodifiableList((List)localObject1);
        this.nl = paramJSONObject.optString("allocation_id", null);
        this.nn = bs.a(paramJSONObject, "imp_urls");
        localObject1 = paramJSONObject.optJSONObject("ad");
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((JSONObject)localObject1).toString();
        }
        this.ni = ((String)localObject1);
        localObject1 = paramJSONObject.optJSONObject("data");
        if (localObject1 == null) {
          localObject2 = null;
        } else {
          localObject2 = ((JSONObject)localObject1).toString();
        }
        this.no = ((String)localObject2);
        if (localObject1 != null) {
          str = ((JSONObject)localObject1).optString("class_name");
        }
        this.nm = str;
        return;
      }
      ((List)localObject1).add(((JSONArray)localObject2).getString(i));
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bm
 * JD-Core Version:    0.7.0.1
 */