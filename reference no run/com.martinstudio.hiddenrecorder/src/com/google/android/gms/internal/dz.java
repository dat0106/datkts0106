package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dz
{
  private static final SimpleDateFormat qx = new SimpleDateFormat("yyyyMMdd");
  
  public static dv a(Context paramContext, dt paramdt, String paramString)
  {
    JSONObject localJSONObject;
    String str4;
    Object localObject1;
    String str1;
    String str2;
    String str3;
    long l3;
    Object localObject2;
    int i;
    label217:
    dv localdv3;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        str4 = localJSONObject.optString("ad_base_url", null);
        localObject1 = localJSONObject.optString("ad_url", null);
        str1 = localJSONObject.optString("ad_size", null);
        str2 = localJSONObject.optString("ad_html", null);
        long l1 = -1L;
        str3 = localJSONObject.optString("debug_dialog", null);
        if (!localJSONObject.has("interstitial_timeout")) {
          break label662;
        }
        l3 = (1000.0D * localJSONObject.getDouble("interstitial_timeout"));
        localObject2 = localJSONObject.optString("orientation", null);
        i = -1;
        if ("portrait".equals(localObject2))
        {
          i = ep.bN();
          if (!TextUtils.isEmpty(str2))
          {
            if (!TextUtils.isEmpty(str4)) {
              break label654;
            }
            ev.D("Could not parse the mediation config: Missing required ad_base_url field");
            dv localdv1 = new dv(0);
            break label660;
          }
        }
        else
        {
          if (!"landscape".equals(localObject2)) {
            continue;
          }
          i = ep.bM();
          continue;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = dy.a(paramContext, paramdt.kO.st, (String)localObject1, null, null);
          str4 = ((dv)localObject1).oy;
          str2 = ((dv)localObject1).qb;
          long l2 = ((dv)localObject1).qh;
          localObject2 = localObject1;
          localObject4 = localJSONObject.optJSONArray("click_urls");
          if (localObject2 == null)
          {
            localObject1 = null;
            if (localObject4 == null) {
              break;
            }
            if (localObject1 != null) {
              break label670;
            }
            localObject1 = new LinkedList();
            break label670;
            label256:
            int j;
            if (j >= ((JSONArray)localObject4).length()) {
              break label676;
            }
            ((List)localObject1).add(((JSONArray)localObject4).getString(j));
            j++;
            continue;
          }
        }
        else
        {
          ev.D("Could not parse the mediation config: Missing required ad_html or ad_url field.");
          dv localdv2 = new dv(0);
        }
      }
      catch (JSONException localJSONException)
      {
        ev.D("Could not parse the mediation config: " + localJSONException.getMessage());
        localdv3 = new dv(0);
      }
      localObject1 = ((dv)localObject2).nr;
    }
    label352:
    Object localObject4 = localJSONObject.optJSONArray("impression_urls");
    Object localObject5;
    if (localObject2 == null) {
      localObject5 = null;
    }
    label391:
    label432:
    Object localObject7;
    while (localObject4 != null)
    {
      if (localObject5 != null) {
        break label683;
      }
      localObject5 = new LinkedList();
      break label683;
      int m;
      while (m < ((JSONArray)localObject4).length())
      {
        ((List)localObject5).add(((JSONArray)localObject4).getString(m));
        m++;
      }
      localObject5 = ((dv)localObject2).ns;
      continue;
      localObject5 = localJSONObject.optJSONArray("manual_impression_urls");
      if (localObject2 == null) {}
      for (localObject7 = null; localObject5 != null; localObject7 = ((dv)localObject2).qf)
      {
        if (localObject7 != null) {
          break label696;
        }
        localObject7 = new LinkedList();
        break label696;
        label471:
        int i1;
        while (i1 < ((JSONArray)localObject5).length())
        {
          ((List)localObject7).add(((JSONArray)localObject5).getString(i1));
          i1++;
        }
      }
    }
    for (;;)
    {
      if (localObject2 != null)
      {
        if (((dv)localObject2).orientation != -1) {
          i = ((dv)localObject2).orientation;
        }
        if (((dv)localObject2).qc > 0L) {
          l3 = ((dv)localObject2).qc;
        }
      }
      localObject7 = localJSONObject.optString("active_view");
      String str5 = null;
      boolean bool = localJSONObject.optBoolean("ad_is_javascript", false);
      if (bool) {
        str5 = localJSONObject.optString("ad_passback_url", null);
      }
      localdv3 = new dv(str4, str2, (List)localObject1, (List)localObject4, l3, false, -1L, (List)localObject5, -1L, i, str1, localdv3, str3, bool, str5, (String)localObject7);
      break label660;
      localObject5 = localObject7;
      continue;
      localObject4 = localObject5;
      break label432;
      localObject1 = localObject1;
      break label352;
      label654:
      Object localObject3 = null;
      break label217;
      label660:
      return localdv3;
      label662:
      l3 = -1L;
      break;
      label670:
      int k = 0;
      break label256;
      label676:
      localObject1 = localObject1;
      break label352;
      label683:
      int n = 0;
      break label391;
      localObject4 = k;
      break label432;
      label696:
      int i2 = 0;
      break label471;
      Object localObject6 = n;
    }
  }
  
  public static String a(dt paramdt, ed paramed, Location paramLocation, String paramString)
  {
    try
    {
      localObject1 = new HashMap();
      if ((paramString != null) && (paramString.trim() != "")) {
        ((HashMap)localObject1).put("eid", paramString);
      }
      if (paramdt.pU != null) {
        ((HashMap)localObject1).put("ad_pos", paramdt.pU);
      }
      a((HashMap)localObject1, paramdt.pV);
      ((HashMap)localObject1).put("format", paramdt.kR.mc);
      if (paramdt.kR.width == -1) {
        ((HashMap)localObject1).put("smart_w", "full");
      }
      if (paramdt.kR.height == -2) {
        ((HashMap)localObject1).put("smart_h", "auto");
      }
      Object localObject3;
      if (paramdt.kR.me != null)
      {
        localObject3 = new StringBuilder();
        am[] arrayOfam = paramdt.kR.me;
        int i = arrayOfam.length;
        int j = 0;
        if (j < i)
        {
          am localam = arrayOfam[j];
          if (((StringBuilder)localObject3).length() != 0) {
            ((StringBuilder)localObject3).append("|");
          }
          int m;
          if (localam.width == -1)
          {
            m = (int)(localam.widthPixels / paramed.ro);
            label209:
            ((StringBuilder)localObject3).append(m);
            ((StringBuilder)localObject3).append("x");
            if (localam.height != -2) {
              break label274;
            }
          }
          label274:
          for (int k = (int)(localam.heightPixels / paramed.ro);; k = k.height)
          {
            ((StringBuilder)localObject3).append(k);
            j++;
            break;
            m = k.width;
            break label209;
          }
        }
        ((HashMap)localObject1).put("sz", localObject3);
      }
      ((HashMap)localObject1).put("slotname", paramdt.kL);
      ((HashMap)localObject1).put("pn", paramdt.applicationInfo.packageName);
      if (paramdt.pW != null) {
        ((HashMap)localObject1).put("vc", Integer.valueOf(paramdt.pW.versionCode));
      }
      ((HashMap)localObject1).put("ms", paramdt.pX);
      ((HashMap)localObject1).put("seq_num", paramdt.pY);
      ((HashMap)localObject1).put("session_id", paramdt.pZ);
      ((HashMap)localObject1).put("js", paramdt.kO.st);
      a((HashMap)localObject1, paramed);
      if ((paramdt.pV.versionCode >= 2) && (paramdt.pV.lY != null)) {
        a((HashMap)localObject1, paramdt.pV.lY);
      }
      if (paramdt.versionCode >= 2) {
        ((HashMap)localObject1).put("quality_signals", paramdt.qa);
      }
      if (ev.p(2))
      {
        localObject3 = ep.o((Map)localObject1).toString(2);
        ev.C("Ad Request JSON: " + (String)localObject3);
      }
      localObject1 = ep.o((Map)localObject1).toString();
      localObject1 = localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1;
        ev.D("Problem serializing ad request to JSON: " + localJSONException.getMessage());
        Object localObject2 = null;
      }
    }
    return localObject1;
  }
  
  private static void a(HashMap<String, Object> paramHashMap, Location paramLocation)
  {
    HashMap localHashMap = new HashMap();
    Float localFloat = Float.valueOf(1000.0F * paramLocation.getAccuracy());
    Long localLong2 = Long.valueOf(1000L * paramLocation.getTime());
    Long localLong3 = Long.valueOf((10000000.0D * paramLocation.getLatitude()));
    Long localLong1 = Long.valueOf((10000000.0D * paramLocation.getLongitude()));
    localHashMap.put("radius", localFloat);
    localHashMap.put("lat", localLong3);
    localHashMap.put("long", localLong1);
    localHashMap.put("time", localLong2);
    paramHashMap.put("uule", localHashMap);
  }
  
  private static void a(HashMap<String, Object> paramHashMap, aj paramaj)
  {
    String str = em.bK();
    if (str != null) {
      paramHashMap.put("abf", str);
    }
    if (paramaj.lQ != -1L) {
      paramHashMap.put("cust_age", qx.format(new Date(paramaj.lQ)));
    }
    if (paramaj.extras != null) {
      paramHashMap.put("extras", paramaj.extras);
    }
    if (paramaj.lR != -1) {
      paramHashMap.put("cust_gender", Integer.valueOf(paramaj.lR));
    }
    if (paramaj.lS != null) {
      paramHashMap.put("kw", paramaj.lS);
    }
    if (paramaj.lU != -1) {
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(paramaj.lU));
    }
    if (paramaj.lT) {
      paramHashMap.put("adtest", "on");
    }
    if (paramaj.versionCode >= 2)
    {
      if (paramaj.lV) {
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      }
      if (!TextUtils.isEmpty(paramaj.lW)) {
        paramHashMap.put("ppid", paramaj.lW);
      }
      if (paramaj.lX != null) {
        a(paramHashMap, paramaj.lX);
      }
    }
    if ((paramaj.versionCode >= 3) && (paramaj.lZ != null)) {
      paramHashMap.put("url", paramaj.lZ);
    }
  }
  
  private static void a(HashMap<String, Object> paramHashMap, ax paramax)
  {
    String str2 = null;
    if (Color.alpha(paramax.mB) != 0) {
      paramHashMap.put("acolor", o(paramax.mB));
    }
    if (Color.alpha(paramax.backgroundColor) != 0) {
      paramHashMap.put("bgcolor", o(paramax.backgroundColor));
    }
    if ((Color.alpha(paramax.mC) != 0) && (Color.alpha(paramax.mD) != 0))
    {
      paramHashMap.put("gradientto", o(paramax.mC));
      paramHashMap.put("gradientfrom", o(paramax.mD));
    }
    if (Color.alpha(paramax.mE) != 0) {
      paramHashMap.put("bcolor", o(paramax.mE));
    }
    paramHashMap.put("bthick", Integer.toString(paramax.mF));
    String str1;
    switch (paramax.mG)
    {
    default: 
      str1 = null;
      break;
    case 0: 
      str1 = "none";
      break;
    case 1: 
      str1 = "dashed";
      break;
    case 2: 
      str1 = "dotted";
      break;
    case 3: 
      str1 = "solid";
    }
    if (str1 != null) {
      paramHashMap.put("btype", str1);
    }
    switch (paramax.mH)
    {
    case 0: 
      str2 = "light";
      break;
    case 1: 
      str2 = "medium";
      break;
    case 2: 
      str2 = "dark";
    }
    if (str2 != null) {
      paramHashMap.put("callbuttoncolor", str2);
    }
    if (paramax.mI != null) {
      paramHashMap.put("channel", paramax.mI);
    }
    if (Color.alpha(paramax.mJ) != 0) {
      paramHashMap.put("dcolor", o(paramax.mJ));
    }
    if (paramax.mK != null) {
      paramHashMap.put("font", paramax.mK);
    }
    if (Color.alpha(paramax.mL) != 0) {
      paramHashMap.put("hcolor", o(paramax.mL));
    }
    paramHashMap.put("headersize", Integer.toString(paramax.mM));
    if (paramax.mN != null) {
      paramHashMap.put("q", paramax.mN);
    }
  }
  
  private static void a(HashMap<String, Object> paramHashMap, ed paramed)
  {
    paramHashMap.put("am", Integer.valueOf(paramed.qY));
    paramHashMap.put("cog", m(paramed.qZ));
    paramHashMap.put("coh", m(paramed.ra));
    if (!TextUtils.isEmpty(paramed.rb)) {
      paramHashMap.put("carrier", paramed.rb);
    }
    paramHashMap.put("gl", paramed.rc);
    if (paramed.rd) {
      paramHashMap.put("simulator", Integer.valueOf(1));
    }
    paramHashMap.put("ma", m(paramed.re));
    paramHashMap.put("sp", m(paramed.rf));
    paramHashMap.put("hl", paramed.rg);
    if (!TextUtils.isEmpty(paramed.rh)) {
      paramHashMap.put("mv", paramed.rh);
    }
    paramHashMap.put("muv", Integer.valueOf(paramed.ri));
    if (paramed.rj != -2) {
      paramHashMap.put("cnt", Integer.valueOf(paramed.rj));
    }
    paramHashMap.put("gnt", Integer.valueOf(paramed.rk));
    paramHashMap.put("pt", Integer.valueOf(paramed.rl));
    paramHashMap.put("rm", Integer.valueOf(paramed.rm));
    paramHashMap.put("riv", Integer.valueOf(paramed.rn));
    paramHashMap.put("u_sd", Float.valueOf(paramed.ro));
    paramHashMap.put("sh", Integer.valueOf(paramed.rq));
    paramHashMap.put("sw", Integer.valueOf(paramed.rp));
    Bundle localBundle = new Bundle();
    localBundle.putInt("active_network_state", paramed.ru);
    localBundle.putBoolean("active_network_metered", paramed.rt);
    paramHashMap.put("connectivity", localBundle);
    localBundle = new Bundle();
    localBundle.putBoolean("is_charging", paramed.rs);
    localBundle.putDouble("battery_level", paramed.rr);
    paramHashMap.put("battery", localBundle);
  }
  
  private static Integer m(boolean paramBoolean)
  {
    int i;
    if (!paramBoolean) {
      i = 0;
    } else {
      i = 1;
    }
    return Integer.valueOf(i);
  }
  
  private static String o(int paramInt)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(0xFFFFFF & paramInt);
    return String.format(localLocale, "#%06x", arrayOfObject);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dz
 * JD-Core Version:    0.7.0.1
 */