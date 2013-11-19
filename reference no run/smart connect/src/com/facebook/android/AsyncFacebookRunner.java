package com.facebook.android;

import android.content.Context;
import android.os.Bundle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class AsyncFacebookRunner
{
  Facebook fb;
  
  public AsyncFacebookRunner(Facebook paramFacebook)
  {
    this.fb = paramFacebook;
  }
  
  public void logout(Context paramContext, RequestListener paramRequestListener)
  {
    logout(paramContext, paramRequestListener, null);
  }
  
  public void logout(final Context paramContext, final RequestListener paramRequestListener, final Object paramObject)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          String str = AsyncFacebookRunner.this.fb.logout(paramContext);
          if ((str.length() == 0) || (str.equals("false"))) {
            paramRequestListener.onFacebookError(new FacebookError("auth.expireSession failed"), paramObject);
          } else {
            paramRequestListener.onComplete(str, paramObject);
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          paramRequestListener.onFileNotFoundException(localFileNotFoundException, paramObject);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          paramRequestListener.onMalformedURLException(localMalformedURLException, paramObject);
        }
        catch (IOException localIOException)
        {
          paramRequestListener.onIOException(localIOException, paramObject);
        }
      }
    }.start();
  }
  
  public void request(Bundle paramBundle, RequestListener paramRequestListener)
  {
    request(null, paramBundle, "GET", paramRequestListener, null);
  }
  
  public void request(Bundle paramBundle, RequestListener paramRequestListener, Object paramObject)
  {
    request(null, paramBundle, "GET", paramRequestListener, paramObject);
  }
  
  public void request(String paramString, Bundle paramBundle, RequestListener paramRequestListener)
  {
    request(paramString, paramBundle, "GET", paramRequestListener, null);
  }
  
  public void request(String paramString, Bundle paramBundle, RequestListener paramRequestListener, Object paramObject)
  {
    request(paramString, paramBundle, "GET", paramRequestListener, paramObject);
  }
  
  public void request(final String paramString1, final Bundle paramBundle, final String paramString2, final RequestListener paramRequestListener, final Object paramObject)
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          String str = AsyncFacebookRunner.this.fb.request(paramString1, paramBundle, paramString2);
          paramRequestListener.onComplete(str, paramObject);
          return;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          for (;;)
          {
            paramRequestListener.onFileNotFoundException(localFileNotFoundException, paramObject);
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            paramRequestListener.onMalformedURLException(localMalformedURLException, paramObject);
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            paramRequestListener.onIOException(localIOException, paramObject);
          }
        }
      }
    }.start();
  }
  
  public void request(String paramString, RequestListener paramRequestListener)
  {
    request(paramString, new Bundle(), "GET", paramRequestListener, null);
  }
  
  public void request(String paramString, RequestListener paramRequestListener, Object paramObject)
  {
    request(paramString, new Bundle(), "GET", paramRequestListener, paramObject);
  }
  
  public static abstract interface RequestListener
  {
    public abstract void onComplete(String paramString, Object paramObject);
    
    public abstract void onFacebookError(FacebookError paramFacebookError, Object paramObject);
    
    public abstract void onFileNotFoundException(FileNotFoundException paramFileNotFoundException, Object paramObject);
    
    public abstract void onIOException(IOException paramIOException, Object paramObject);
    
    public abstract void onMalformedURLException(MalformedURLException paramMalformedURLException, Object paramObject);
  }
}


/* Location:           D:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.facebook.android.AsyncFacebookRunner
 * JD-Core Version:    0.7.0.1
 */