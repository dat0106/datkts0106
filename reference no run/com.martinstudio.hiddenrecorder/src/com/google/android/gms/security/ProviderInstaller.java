package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.hn;
import java.lang.reflect.Method;

public class ProviderInstaller
{
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  private static Method adX = null;
  private static final Object qm = new Object();
  
  private static void I(Context paramContext)
    throws ClassNotFoundException, NoSuchMethodException
  {
    Class localClass = paramContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl");
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Context.class;
    adX = localClass.getMethod("insertProvider", arrayOfClass);
  }
  
  public static void installIfNeeded(Context paramContext)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    hn.b(paramContext, "Context must not be null");
    GooglePlayServicesUtil.w(paramContext);
    Context localContext = GooglePlayServicesUtil.getRemoteContext(paramContext);
    if (localContext == null)
    {
      Log.e("ProviderInstaller", "Failed to get remote context");
      throw new GooglePlayServicesNotAvailableException(8);
    }
    synchronized (qm)
    {
      try
      {
        if (adX == null) {
          I(localContext);
        }
        Method localMethod = adX;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localContext;
        localMethod.invoke(null, arrayOfObject);
        return;
      }
      catch (Exception localException)
      {
        Log.e("ProviderInstaller", "Failed to install provider: " + localException.getMessage());
        throw new GooglePlayServicesNotAvailableException(8);
      }
    }
  }
  
  public static void installIfNeededAsync(Context paramContext, final ProviderInstallListener paramProviderInstallListener)
  {
    hn.b(paramContext, "Context must not be null");
    hn.b(paramProviderInstallListener, "Listener must not be null");
    hn.ay("Must be called on the UI thread");
    new AsyncTask()
    {
      protected Integer b(Void... paramAnonymousVarArgs)
      {
        try
        {
          ProviderInstaller.installIfNeeded(ProviderInstaller.this);
          localInteger1 = Integer.valueOf(0);
        }
        catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
        {
          for (;;)
          {
            Integer localInteger1;
            Integer localInteger2 = Integer.valueOf(localGooglePlayServicesRepairableException.getConnectionStatusCode());
          }
        }
        catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
        {
          for (;;)
          {
            Integer localInteger3 = Integer.valueOf(localGooglePlayServicesNotAvailableException.errorCode);
          }
        }
        return localInteger1;
      }
      
      protected void d(Integer paramAnonymousInteger)
      {
        if (paramAnonymousInteger.intValue() != 0)
        {
          Intent localIntent = GooglePlayServicesUtil.Z(paramAnonymousInteger.intValue());
          paramProviderInstallListener.onProviderInstallFailed(paramAnonymousInteger.intValue(), localIntent);
        }
        else
        {
          paramProviderInstallListener.onProviderInstalled();
        }
      }
    }.execute(new Void[0]);
  }
  
  public static abstract interface ProviderInstallListener
  {
    public abstract void onProviderInstallFailed(int paramInt, Intent paramIntent);
    
    public abstract void onProviderInstalled();
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.security.ProviderInstaller
 * JD-Core Version:    0.7.0.1
 */