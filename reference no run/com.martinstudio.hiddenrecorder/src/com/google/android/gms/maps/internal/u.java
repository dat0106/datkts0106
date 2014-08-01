package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class u
{
  private static Context aag;
  private static c aah;
  
  public static c E(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    hn.f(paramContext);
    c localc;
    if (aah != null) {
      localc = aah;
    }
    for (;;)
    {
      return localc;
      F(paramContext);
      aah = G(paramContext);
      try
      {
        aah.a(e.h(getRemoteContext(paramContext).getResources()), 5077000);
        localc = aah;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }
  
  private static void F(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
    switch (i)
    {
    default: 
      throw new GooglePlayServicesNotAvailableException(i);
    }
  }
  
  private static c G(Context paramContext)
  {
    c localc;
    if (!jE())
    {
      Log.i(u.class.getSimpleName(), "Making Creator dynamically");
      localc = c.a.ax((IBinder)a(getRemoteContext(paramContext).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }
    else
    {
      Log.i(u.class.getSimpleName(), "Making Creator statically");
      localc = (c)c(jF());
    }
    return localc;
  }
  
  private static <T> T a(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      Object localObject = c(((ClassLoader)hn.f(paramClassLoader)).loadClass(paramString));
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new IllegalStateException("Unable to find dynamic class " + paramString);
    }
  }
  
  private static <T> T c(Class<?> paramClass)
  {
    try
    {
      Object localObject = paramClass.newInstance();
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new IllegalStateException("Unable to instantiate the dynamic class " + paramClass.getName());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalStateException("Unable to call the default constructor of " + paramClass.getName());
    }
  }
  
  private static Context getRemoteContext(Context paramContext)
  {
    if (aag == null) {
      if (!jE()) {
        aag = GooglePlayServicesUtil.getRemoteContext(paramContext);
      } else {
        aag = paramContext.getApplicationContext();
      }
    }
    return aag;
  }
  
  private static boolean jE()
  {
    return false;
  }
  
  private static Class<?> jF()
  {
    try
    {
      Class localClass;
      if (Build.VERSION.SDK_INT < 15)
      {
        localClass = Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6");
      }
      else
      {
        localClass = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        localClass = localClass;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(localClassNotFoundException);
    }
    return localClassNotFoundException;
  }
}


/* Location:           E:\android\Androidvn\dex2jar\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.u
 * JD-Core Version:    0.7.0.1
 */