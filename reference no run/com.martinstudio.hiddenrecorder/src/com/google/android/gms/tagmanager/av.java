package com.google.android.gms.tagmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

class av
  implements bl
{
  private HttpClient afL;
  
  private InputStream a(HttpClient paramHttpClient, HttpResponse paramHttpResponse)
    throws IOException
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    if (i != 200)
    {
      String str = "Bad response: " + i;
      if (i != 404) {
        throw new IOException(str);
      }
      throw new FileNotFoundException(str);
    }
    bh.C("Success response");
    return paramHttpResponse.getEntity().getContent();
  }
  
  private void a(HttpClient paramHttpClient)
  {
    if ((paramHttpClient != null) && (paramHttpClient.getConnectionManager() != null)) {
      paramHttpClient.getConnectionManager().shutdown();
    }
  }
  
  public InputStream bV(String paramString)
    throws IOException
  {
    this.afL = lK();
    HttpResponse localHttpResponse = this.afL.execute(new HttpGet(paramString));
    return a(this.afL, localHttpResponse);
  }
  
  public void close()
  {
    a(this.afL);
  }
  
  HttpClient lK()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    return new DefaultHttpClient(localBasicHttpParams);
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.av
 * JD-Core Version:    0.7.0.1
 */