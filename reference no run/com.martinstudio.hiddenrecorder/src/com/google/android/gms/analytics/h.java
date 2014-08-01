package com.google.android.gms.analytics;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class h
  implements m
{
  private static h tE;
  private static final Object tn = new Object();
  private final Context mContext;
  private String tF;
  private boolean tG = false;
  private final Object tH = new Object();
  
  protected h(Context paramContext)
  {
    this.mContext = paramContext;
    cu();
  }
  
  private boolean K(String paramString)
  {
    boolean bool = false;
    try
    {
      aa.C("Storing clientId.");
      FileOutputStream localFileOutputStream = this.mContext.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      bool = true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        aa.A("Error creating clientId file.");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        aa.A("Error writing to clientId file.");
      }
    }
    return bool;
  }
  
  public static h cq()
  {
    synchronized (tn)
    {
      h localh = tE;
      return localh;
    }
  }
  
  private String cs()
  {
    if (!this.tG) {}
    synchronized (this.tH)
    {
      if (!this.tG) {
        aa.C("Waiting for clientId to load");
      }
      try
      {
        do
        {
          this.tH.wait();
        } while (!this.tG);
        aa.C("Loaded clientId");
        return this.tF;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          aa.A("Exception while waiting for clientId: " + localInterruptedException);
        }
      }
    }
  }
  
  private void cu()
  {
    new Thread("client_id_fetcher")
    {
      public void run()
      {
        synchronized (h.a(h.this))
        {
          h.a(h.this, h.this.cv());
          h.a(h.this, true);
          h.a(h.this).notifyAll();
          return;
        }
      }
    }.start();
  }
  
  public static void r(Context paramContext)
  {
    synchronized (tn)
    {
      if (tE == null) {
        tE = new h(paramContext);
      }
      return;
    }
  }
  
  public boolean J(String paramString)
  {
    return "&cid".equals(paramString);
  }
  
  String cr()
  {
    synchronized (this.tH)
    {
      this.tF = ct();
      String str = this.tF;
      return str;
    }
  }
  
  protected String ct()
  {
    String str = UUID.randomUUID().toString().toLowerCase();
    try
    {
      if (!K(str)) {
        str = "0";
      }
      return str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        str = null;
      }
    }
  }
  
  String cv()
  {
    String str = null;
    try
    {
      localFileInputStream = this.mContext.openFileInput("gaClientId");
      byte[] arrayOfByte = new byte[''];
      int i = localFileInputStream.read(arrayOfByte, 0, 128);
      if (localFileInputStream.available() > 0)
      {
        aa.A("clientId file seems corrupted, deleting it.");
        localFileInputStream.close();
        this.mContext.deleteFile("gaClientId");
      }
      for (;;)
      {
        label56:
        if (str == null) {
          str = ct();
        }
        return str;
        if (i > 0) {
          break;
        }
        aa.A("clientId file seems empty, deleting it.");
        localFileInputStream.close();
        this.mContext.deleteFile("gaClientId");
      }
      str = new String(arrayOfByte, 0, i);
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          FileInputStream localFileInputStream;
          localFileInputStream.close();
          aa.C("Loaded client id from disk.");
          str = str;
        }
        catch (IOException localIOException2)
        {
          str = str;
          continue;
        }
        catch (FileNotFoundException localFileNotFoundException1)
        {
          str = str;
        }
        localIOException1;
        aa.A("Error reading clientId file, deleting it.");
        this.mContext.deleteFile("gaClientId");
      }
    }
    catch (FileNotFoundException localFileNotFoundException2)
    {
      break label56;
    }
  }
  
  public String getValue(String paramString)
  {
    String str;
    if (!"&cid".equals(paramString)) {
      str = null;
    } else {
      str = cs();
    }
    return str;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.h
 * JD-Core Version:    0.7.0.1
 */