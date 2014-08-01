package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class ec
{
  private final List<String> qP;
  private final List<String> qQ;
  private final String qR;
  private final String qS;
  private final String qT;
  private final String qU;
  private final String qV;
  private final boolean qW;
  private final int qX;
  
  public ec(Map<String, String> paramMap)
  {
    this.qV = ((String)paramMap.get("url"));
    this.qS = ((String)paramMap.get("base_uri"));
    this.qT = ((String)paramMap.get("post_parameters"));
    this.qW = parseBoolean((String)paramMap.get("drt_include"));
    this.qR = ((String)paramMap.get("activation_overlay_url"));
    this.qQ = t((String)paramMap.get("check_packages"));
    this.qX = parseInt((String)paramMap.get("request_id"));
    this.qU = ((String)paramMap.get("type"));
    this.qP = t((String)paramMap.get("errors"));
  }
  
  private static boolean parseBoolean(String paramString)
  {
    boolean bool;
    if ((paramString == null) || ((!paramString.equals("1")) && (!paramString.equals("true")))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private int parseInt(String paramString)
  {
    int i;
    if (paramString != null) {
      i = Integer.parseInt(paramString);
    } else {
      i = 0;
    }
    return i;
  }
  
  private List<String> t(String paramString)
  {
    List localList;
    if (paramString != null) {
      localList = Arrays.asList(paramString.split(","));
    } else {
      localList = null;
    }
    return localList;
  }
  
  public List<String> bt()
  {
    return this.qP;
  }
  
  public String bu()
  {
    return this.qT;
  }
  
  public boolean bv()
  {
    return this.qW;
  }
  
  public String getType()
  {
    return this.qU;
  }
  
  public String getUrl()
  {
    return this.qV;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ec
 * JD-Core Version:    0.7.0.1
 */