package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class cd
{
  private static cd agu;
  private volatile String aeq;
  private volatile a agv;
  private volatile String agw;
  private volatile String agx;
  
  cd()
  {
    clear();
  }
  
  private String ca(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  private String i(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  static cd lY()
  {
    try
    {
      if (agu == null) {
        agu = new cd();
      }
      cd localcd = agu;
      return localcd;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void clear()
  {
    this.agv = a.agy;
    this.agw = null;
    this.aeq = null;
    this.agx = null;
  }
  
  String getContainerId()
  {
    return this.aeq;
  }
  
  /**
   * @deprecated
   */
  boolean h(Uri paramUri)
  {
    boolean bool = true;
    String str;
    try
    {
      str = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label153;
      }
      bh.C("Container preview url: " + str);
      if (!str.matches(".*?&gtm_debug=x$")) {
        break label138;
      }
      this.agv = a.agA;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        bool = false;
        continue;
        this.agv = a.agz;
      }
    }
    finally {}
    this.agx = i(paramUri);
    if ((this.agv == a.agz) || (this.agv == a.agA)) {
      this.agw = ("/r?" + this.agx);
    }
    this.aeq = ca(this.agx);
    for (;;)
    {
      return bool;
      label138:
      label153:
      if (str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (ca(paramUri.getQuery()).equals(this.aeq))
        {
          bh.C("Exit preview mode for container: " + this.aeq);
          this.agv = a.agy;
          this.agw = null;
        }
      }
      else
      {
        bh.D("Invalid preview uri: " + str);
        i = 0;
        continue;
      }
      int i = 0;
    }
  }
  
  a lZ()
  {
    return this.agv;
  }
  
  String ma()
  {
    return this.agw;
  }
  
  static enum a
  {
    static
    {
      agA = new a("CONTAINER_DEBUG", 2);
      a[] arrayOfa = new a[3];
      arrayOfa[0] = agy;
      arrayOfa[1] = agz;
      arrayOfa[2] = agA;
      agB = arrayOfa;
    }
    
    private a() {}
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cd
 * JD-Core Version:    0.7.0.1
 */