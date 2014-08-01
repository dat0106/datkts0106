package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bn
{
  public final List<bm> np;
  public final long nq;
  public final List<String> nr;
  public final List<String> ns;
  public final List<String> nt;
  public final String nu;
  public final long nv;
  public int nw;
  public int nx;
  
  public bn(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject2 = new JSONObject(paramString);
    if (ev.p(2)) {
      ev.C("Mediation Response JSON: " + localJSONObject2.toString(2));
    }
    JSONArray localJSONArray = localJSONObject2.getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    int j = -1;
    for (int i = 0;; i++)
    {
      if (i >= localJSONArray.length())
      {
        this.nw = j;
        this.nx = localJSONArray.length();
        this.np = Collections.unmodifiableList(localArrayList);
        this.nu = localJSONObject2.getString("qdata");
        JSONObject localJSONObject1 = localJSONObject2.optJSONObject("settings");
        if (localJSONObject1 == null)
        {
          this.nq = -1L;
          this.nr = null;
          this.ns = null;
          this.nt = null;
          this.nv = -1L;
        }
        else
        {
          this.nq = localJSONObject1.optLong("ad_network_timeout_millis", -1L);
          this.nr = bs.a(localJSONObject1, "click_urls");
          this.ns = bs.a(localJSONObject1, "imp_urls");
          this.nt = bs.a(localJSONObject1, "nofill_urls");
          long l = localJSONObject1.optLong("refresh", -1L);
          if (l <= 0L) {
            l = -1L;
          } else {
            l *= 1000L;
          }
          this.nv = l;
        }
        return;
      }
      bm localbm = new bm(localJSONArray.getJSONObject(i));
      localArrayList.add(localbm);
      if ((j < 0) && (a(localbm))) {
        j = i;
      }
    }
  }
  
  private boolean a(bm parambm)
  {
    Iterator localIterator = parambm.nk.iterator();
    do
    {
      if (!localIterator.hasNext())
      {
        bool = false;
        break;
      }
    } while (!((String)bool.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"));
    boolean bool = true;
    return bool;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bn
 * JD-Core Version:    0.7.0.1
 */