package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class ae
  implements m
{
  private static Object tn = new Object();
  private static ae wW;
  private final Context mContext;
  
  protected ae(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static ae dq()
  {
    synchronized (tn)
    {
      ae localae = wW;
      return localae;
    }
  }
  
  public static void r(Context paramContext)
  {
    synchronized (tn)
    {
      if (wW == null) {
        wW = new ae(paramContext);
      }
      return;
    }
  }
  
  public boolean J(String paramString)
  {
    return "&sr".equals(paramString);
  }
  
  protected String dr()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
  }
  
  public String getValue(String paramString)
  {
    String str = null;
    if ((paramString != null) && (paramString.equals("&sr"))) {
      str = dr();
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ae
 * JD-Core Version:    0.7.0.1
 */