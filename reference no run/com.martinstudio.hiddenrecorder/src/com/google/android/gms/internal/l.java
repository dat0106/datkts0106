package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.MotionEvent;

public class l
{
  private String ke = "googleads.g.doubleclick.net";
  private String kf = "/pagead/ads";
  private String[] kg;
  private h kh;
  private final g ki;
  
  public l(h paramh)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = ".doubleclick.net";
    arrayOfString[1] = ".googleadservices.com";
    arrayOfString[2] = ".googlesyndication.com";
    this.kg = arrayOfString;
    this.ki = new g();
    this.kh = paramh;
  }
  
  private Uri a(Uri paramUri, Context paramContext, String paramString, boolean paramBoolean)
    throws m
  {
    try
    {
      if (paramUri.getQueryParameter("ms") != null) {
        throw new m("Query parameter already exists: ms");
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      throw new m("Provided Uri is not in a valid state");
    }
    if (paramBoolean) {}
    for (String str = this.kh.a(paramContext, paramString);; str = str)
    {
      return a(paramUri, "ms", str);
      str = this.kh.a(paramContext);
    }
  }
  
  private Uri a(Uri paramUri, String paramString1, String paramString2)
    throws UnsupportedOperationException
  {
    String str = paramUri.toString();
    int i = str.indexOf("&adurl");
    if (i == -1) {
      i = str.indexOf("?adurl");
    }
    Uri localUri;
    if (i == -1) {
      localUri = paramUri.buildUpon().appendQueryParameter(paramString1, paramString2).build();
    } else {
      localUri = Uri.parse(str.substring(0, localUri + 1) + paramString1 + "=" + paramString2 + "&" + str.substring(localUri + 1));
    }
    return localUri;
  }
  
  public Uri a(Uri paramUri, Context paramContext)
    throws m
  {
    try
    {
      Uri localUri = a(paramUri, paramContext, paramUri.getQueryParameter("ai"), true);
      return localUri;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      throw new m("Provided Uri is not in a valid state");
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.kh.a(paramMotionEvent);
  }
  
  public boolean a(Uri paramUri)
  {
    boolean bool2 = false;
    if (paramUri == null) {
      throw new NullPointerException();
    }
    for (;;)
    {
      try
      {
        String str = paramUri.getHost();
        String[] arrayOfString = this.kg;
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          boolean bool1 = str.endsWith(arrayOfString[i]);
          if (!bool1) {
            continue;
          }
          bool2 = true;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        int i;
        continue;
      }
      return bool2;
      i++;
    }
  }
  
  public h y()
  {
    return this.kh;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.l
 * JD-Core Version:    0.7.0.1
 */