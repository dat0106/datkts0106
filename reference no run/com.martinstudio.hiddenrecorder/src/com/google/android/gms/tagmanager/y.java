package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class y
  implements aq
{
  private static y afr;
  private static final Object tn = new Object();
  private cf aeG;
  private String afs;
  private String aft;
  private ar afu;
  
  private y(Context paramContext)
  {
    this(as.M(paramContext), new cv());
  }
  
  y(ar paramar, cf paramcf)
  {
    this.afu = paramar;
    this.aeG = paramcf;
  }
  
  public static aq K(Context paramContext)
  {
    synchronized (tn)
    {
      if (afr == null) {
        afr = new y(paramContext);
      }
      y localy = afr;
      return localy;
    }
  }
  
  public boolean bR(String paramString)
  {
    boolean bool = false;
    if (!this.aeG.dj()) {
      bh.D("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
    }
    for (;;)
    {
      return bool;
      if ((this.afs != null) && (this.aft != null)) {}
      try
      {
        paramString = this.afs + "?" + this.aft + "=" + URLEncoder.encode(paramString, "UTF-8");
        bh.C("Sending wrapped url hit: " + paramString);
        this.afu.bU(paramString);
        bool = true;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        bh.c("Error wrapping URL for testing.", localUnsupportedEncodingException);
      }
    }
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.y
 * JD-Core Version:    0.7.0.1
 */