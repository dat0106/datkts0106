package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.c.j;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class cn
  implements Runnable
{
  private volatile String aeM;
  private final String aeq;
  private final bm agI;
  private final String agJ;
  private bg<c.j> agK;
  private volatile r agL;
  private volatile String agM;
  private final Context mContext;
  
  cn(Context paramContext, String paramString, bm parambm, r paramr)
  {
    this.mContext = paramContext;
    this.agI = parambm;
    this.aeq = paramString;
    this.agL = paramr;
    this.agJ = ("/r?id=" + paramString);
    this.aeM = this.agJ;
    this.agM = null;
  }
  
  public cn(Context paramContext, String paramString, r paramr)
  {
    this(paramContext, paramString, new bm(), paramr);
  }
  
  private boolean mb()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool;
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
    {
      bool = true;
    }
    else
    {
      bh.C("...no network connectivity");
      bool = false;
    }
    return bool;
  }
  
  private void mc()
  {
    if (!mb()) {
      this.agK.a(bg.a.agd);
    }
    for (;;)
    {
      return;
      bh.C("Start loading resource from network ...");
      String str = md();
      bl localbl = this.agI.lM();
      try
      {
        localObject2 = localbl.bV(str);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Object localObject2;
        ByteArrayOutputStream localByteArrayOutputStream;
        localFileNotFoundException;
        bh.D("No data is retrieved from the given url: " + str + ". Make sure container_id: " + this.aeq + " is correct.");
        this.agK.a(bg.a.agf);
        localbl.close();
      }
      catch (IOException localIOException1)
      {
        bh.c("Error when loading resources from url: " + str + " " + localIOException1.getMessage(), localIOException1);
        this.agK.a(bg.a.age);
        localbl.close();
        continue;
      }
      finally
      {
        localbl.close();
      }
    }
  }
  
  void a(bg<c.j> parambg)
  {
    this.agK = parambg;
  }
  
  void bM(String paramString)
  {
    if (paramString != null)
    {
      bh.z("Setting CTFE URL path: " + paramString);
      this.aeM = paramString;
    }
    else
    {
      this.aeM = this.agJ;
    }
  }
  
  void cb(String paramString)
  {
    bh.z("Setting previous container version: " + paramString);
    this.agM = paramString;
  }
  
  String md()
  {
    String str = this.agL.ls() + this.aeM + "&v=a65833898";
    if ((this.agM != null) && (!this.agM.trim().equals(""))) {
      str = str + "&pv=" + this.agM;
    }
    if (cd.lY().lZ().equals(cd.a.agA)) {
      str = str + "&gtm_debug=x";
    }
    return str;
  }
  
  public void run()
  {
    if (this.agK != null)
    {
      this.agK.lq();
      mc();
      return;
    }
    throw new IllegalStateException("callback must be set before execute");
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cn
 * JD-Core Version:    0.7.0.1
 */