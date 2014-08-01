package com.google.android.gms.tagmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class aw
  implements bl
{
  private HttpURLConnection afM;
  
  private InputStream a(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    int i = paramHttpURLConnection.getResponseCode();
    if (i != 200)
    {
      String str = "Bad response: " + i;
      if (i != 404) {
        throw new IOException(str);
      }
      throw new FileNotFoundException(str);
    }
    return paramHttpURLConnection.getInputStream();
  }
  
  private void b(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.disconnect();
    }
  }
  
  public InputStream bV(String paramString)
    throws IOException
  {
    this.afM = bW(paramString);
    return a(this.afM);
  }
  
  HttpURLConnection bW(String paramString)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
    localHttpURLConnection.setReadTimeout(20000);
    localHttpURLConnection.setConnectTimeout(20000);
    return localHttpURLConnection;
  }
  
  public void close()
  {
    b(this.afM);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.aw
 * JD-Core Version:    0.7.0.1
 */