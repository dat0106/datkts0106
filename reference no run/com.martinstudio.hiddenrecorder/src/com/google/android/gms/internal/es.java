package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

public final class es
{
  public static void a(Context paramContext, WebSettings paramWebSettings)
  {
    er.a(paramContext, paramWebSettings);
    paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
  }
  
  public static String getDefaultUserAgent(Context paramContext)
  {
    return WebSettings.getDefaultUserAgent(paramContext);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.es
 * JD-Core Version:    0.7.0.1
 */